// $Id: ApiException.java 222 2013-08-27 10:07:18Z mkwayisi $
package com.smsgh;

/**
 * Represents an API exception.
 * 
 * @author Michael Kwayisi
 */
public class ApiException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Initializes a new instance of this class.
	 * 
	 * @param message the exception message.
	 */
	public ApiException(String message) {
		super(message);
	}
}
