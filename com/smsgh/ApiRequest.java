package com.smsgh;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.AbstractMap;
import java.util.ArrayList;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.bind.DatatypeConverter;

public class ApiRequest {

	/**
	 * Data fields.
	 */
	private String hostname;
	private int port;
	private String protocol;
	private int timeout;
	private String username;
	private String password;

	private String method;
	private String uri;
	private ArrayList<AbstractMap.SimpleEntry> headers;

	private Socket socket;
	private InputStream inputStream;
	private OutputStreamWriter streamWriter;

	/**
	 * Primary constructor.
	 */
	public ApiRequest(String hostname, int port, String protocol, int timeout, String username, String password) {
		this.hostname = hostname;
		this.port = port;
		this.protocol = protocol;
		this.timeout = timeout;
		this.username = username;
		this.password = password;

		this.headers = new ArrayList<AbstractMap.SimpleEntry>();
	}

	/**
	 * Writes upto len bytes into os from the current input stream.
	 */
	private boolean readBytes(ByteArrayOutputStream os, int len) throws IOException {
		int nchs = -1;
		byte buf[] = new byte[8192];

		for (; len > 0 && (nchs = this.inputStream.read(buf, 0, Math.min(len, buf.length))) != -1; len -= nchs)
			os.write(buf, 0, nchs);

		return nchs != -1;
	}

	/**
	 * Opens a connection. This method only instantiate a new object if there's
	 * no connection or invalid. So it's safe to call multiple times.
	 */
	private void open() throws Exception {
		if (this.socket == null) {
			if (this.protocol == "ssl" || this.protocol == "tls") {
				SSLContext sslContext = SSLContext.getInstance(this.protocol);
				sslContext.init(null, new TrustManager[] { new X509TrustManager() {
					public X509Certificate[] getAcceptedIssuers() {
						return null;
					}

					public void checkServerTrusted(X509Certificate[] chain, String authType) {}

					public void checkClientTrusted(X509Certificate[] chain, String authType) {}
				} }, null);
				this.socket = sslContext.getSocketFactory().createSocket(this.hostname, this.port);
			} else
				this.socket = new Socket(this.hostname, this.port);

			this.socket.setSoTimeout(this.timeout * 1000);
			this.inputStream = this.socket.getInputStream();
			this.streamWriter = new OutputStreamWriter(this.socket.getOutputStream());
		}
	}

	/**
	 * Closes this request.
	 */
	private void close() throws IOException {
		if (this.socket != null)
			try {
				this.socket.close();
			} finally {
				this.socket = null;
			}
	}

	/**
	 * Checks if header is present.
	 */
	private boolean hasHeader(String name) {
		name = name.toLowerCase();
		for (AbstractMap.SimpleEntry entry : this.headers) {
			if (entry.getKey().equals(name))
				return true;
		}
		return false;
	}

	/**
	 * Gets method.
	 */
	public String getMethod() {
		return this.method;
	}

	/**
	 * Gets uri.
	 */
	public String getUri() {
		return this.uri;
	}

	/**
	 * Gets a header.
	 */
	public String getHeader(String name) {
		name = name.toLowerCase();
		for (AbstractMap.SimpleEntry entry : this.headers) {
			if (entry.getKey().equals(name))
				return entry.getValue().toString();
		}
		return null;
	}

	/**
	 * Sets method.
	 */
	public ApiRequest setMethod(String value) {
		this.method = value;
		return this;
	}

	/**
	 * Sets uri.
	 */
	public ApiRequest setUri(String value) {
		this.uri = value;
		return this;
	}

	/**
	 * Sets header.
	 */
	@SuppressWarnings("unchecked")
	public ApiRequest setHeader(String name, String value) {
		if (name == null)
			throw new NullPointerException();
		name = name.trim().toLowerCase();
		for (AbstractMap.SimpleEntry entry : this.headers) {
			if (entry.getKey().equals(name)) {
				entry.setValue(value);
				return this;
			}
		}

		this.headers.add(new AbstractMap.SimpleEntry(name, value));
		return this;
	}

	/**
	 * Removes header.
	 */
	public boolean removeHeader(String name) {
		if (name == null)
			throw new NullPointerException();
		name = name.trim().toLowerCase();
		for (AbstractMap.SimpleEntry entry : this.headers) {
			if (entry.getKey().equals(name)) {
				this.headers.remove(entry);
				return true;
			}
		}
		return false;
	}

	/**
	 * Sends this request.
	 */
	@SuppressWarnings("unchecked")
	public ApiResponse send(String body) throws ApiException {
		ApiResponse apiResponse = null;
		StringBuilder buffer = new StringBuilder();

		// Add the HTTP Host header if not present
		// since this request will be in HTTP/1.1 format.
		if (!this.hasHeader("Host")) {
			this.headers.add(new AbstractMap.SimpleEntry("host", this.hostname));
		}

		// Add the Authorizaton header if not present.
		if (!this.hasHeader("Authorization") && this.username != null && this.password != null) {
			buffer.append(this.username).append(":").append(this.password);
			this.headers.add(new AbstractMap.SimpleEntry("authorization", "Basic " + DatatypeConverter.printBase64Binary(buffer.toString().getBytes())));
			buffer.setLength(0);
		}

		// Set the Content-Length header if data is being sent.
		if (body == null) {
			// let us check whether is a PUT request
			if(this.method.equals("PUT")){
				this.setHeader("content-length", 0 + "");
			}
			else{
				this.removeHeader("content-length");
				this.removeHeader("content-type");				
			}
		} else
			this.setHeader("content-length", body.length() + "");

		// Start buffering the request data.
		buffer.append(this.method).append(" ").append(this.uri).append(" HTTP/1.0\r\n");

		// Append all headers to the buffer.
		for (AbstractMap.SimpleEntry header : this.headers)
			buffer.append(header.getKey()).append(": ").append(header.getValue()).append("\r\n");

		// Terminate the header.
		buffer.append("\r\n");
		if (body != null)
			buffer.append(body);

		try {
			// Send request.
			this.open();
			this.streamWriter.write(buffer.toString(), 0, buffer.length());
			this.streamWriter.flush();
			buffer.setLength(0);

			String buff; // Generic buffer.
			ByteArrayOutputStream baos = new ByteArrayOutputStream(8192);
			apiResponse = new ApiResponse();

			// Attempt to read the response headers.
			for (int ch, pc = 0; (ch = this.inputStream.read()) >= 0;) {
				baos.write(ch);
				if (ch == 13 && pc == 10) {
					if ((ch = this.inputStream.read()) != -1)
						baos.write(ch);
					break;
				} else
					pc = ch == 10 ? ch : 0;
			}

			// Process HTTP response header.
			if ((buff = baos.toString()).startsWith("HTTP/")) {
				String tokens[];
				boolean isFirst = true;
				baos.reset();

				for (String line : buff.split("\r\n")) {

					// Process response line.
					if (isFirst) {
						isFirst = false;
						tokens = line.split(" ", 3);
						if (tokens.length > 1) {
							apiResponse.setStatus(Integer.parseInt(tokens[1]));
							if (tokens.length > 2)
								apiResponse.setReason(tokens[2]);
						}
					}

					// Process actual headers.
					else {
						tokens = line.split(":", 2);
						if (tokens.length == 2)
							apiResponse.setHeader(tokens[0], tokens[1].trim());
					}
				}
			}

			// Perhaps the server closed its connection.
			else if (buff.length() == 0) {
				this.close();
				throw new ApiException("Remote server failed to respond");
			}

			// If the response received doesn't start with
			// the character sequence "HTTP/", I say it's not HTTP.
			else
				throw new ApiException("Bad response from remote host");

			// Check for presence of Content-length.
			if ((buff = apiResponse.getHeader("content-length")) != null) {
				readBytes(baos, Integer.parseInt(buff));
			}

			// Check if the response body is encoded.
			else if ((buff = apiResponse.getHeader("transfer-encoding")) != null) {
				switch (buff) {
				case "chunked":
					chunked: for (int ch;;) {
						buff = "";

						// Get length of chunked data.
						for (;;) {
							ch = this.inputStream.read();
							if (ch == -1)
								break chunked;
							else if (ch == 10)
								break;
							else if (ch != 13)
								buff += (char) ch;
						}

						// Read chunked bytes.
						if (!readBytes(baos, Integer.parseInt(buff, 16)))
							break;

						// Throw away trailing CRLF.
						for (ch = 0; ch < 2; ch++)
							if (this.inputStream.read() == -1)
								break chunked;
					}
					break;

				default:
					throw new ApiException("Unsupported transfer-encoding: " + buff);
				}
			}

			// We had response headers but we were not informed how
			// to handle the body. The HTTP spec doesn't allow this.
			// else throw new ApiException("Bad response from remote host");

			// Determine charset of the response body.
			int offset;
			if ((buff = apiResponse.getHeader("Content-type")) != null && (offset = buff.indexOf('=')) != -1) {
				buff = baos.toString(buff.substring(offset + 1));
			} else
				buff = baos.toString();

			// Set the response body.
			apiResponse.setBody(buff);

			// Close the connection if the server says so.
			if ((buff = apiResponse.getHeader("Connection")) != null && buff.toLowerCase().trim().equals("close")) {
				this.close();
			}

			this.close(); // Unfortunately :)
			return apiResponse;
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
}
