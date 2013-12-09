/**
 * 
 */
package com.smsgh;

/**
 * @author Administrator
 *
 */
public enum ApiTicketPriorities {

	LOW(1), MEDIUM(2), HIGH(3), CRITICAL(4);
	
	private int value;
	
	private ApiTicketPriorities(int value) {
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
