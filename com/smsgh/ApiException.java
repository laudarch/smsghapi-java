package com.smsgh;

/**
 * Represents an API exception.
 *
 * @author Michael Kwayisi, Arsene Tochemey GANDOTE
 */
public class ApiException extends Exception {


    private int httpStatusCode;
    private String reason;
    private String description;
    private String rawBody;
    
    
    public ApiException(){
        super();       
    }
    
    /**
     * Initializes a new instance of this class.
     *
     * @param message the exception message.
     */
    public ApiException(String message) {
        super(message);
    }

      public ApiException(String message, int status, String reason, String description, String body) {
        super(message);
        this.httpStatusCode = status;
        this.reason = reason;
        this.description = description;
        this.rawBody = body;        
    }
    /**
     * @return the httpStatusCode
     */
    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    /**
     * @param httpStatusCode the httpStatusCode to set
     */
    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the body
     */
    public String getRawBody() {
        return rawBody;
    }

    /**
     * @param rawBody the body to set
     */
    public void setRawBody(String rawBody) {
        this.rawBody = rawBody;
    }

}
