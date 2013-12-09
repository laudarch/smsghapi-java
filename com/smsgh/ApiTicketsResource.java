/**
 * 
 */
package com.smsgh;

/**
 * @author Arsene Tochemey GANDOTE
 * 
 */
public class ApiTicketsResource {

	private final SmsghApi apiHost;

	/**
	 * 
	 */
	public ApiTicketsResource(SmsghApi apiHost) {
		this.apiHost = apiHost;
	}

	/**
	 * Get the paginated list of support tickets
	 * 
	 * @param page The Page Number
	 * @param pageSize The number of data o display on a page
	 * @return API list of ApiTicket
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiTicket> getTickets(int page, int pageSize) throws ApiException {
		String uri = null;
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/tickets/";
		else
			uri = "/" + this.apiHost.getVersion() + "/tickets/";
		return ApiHelper.getApiList(ApiTicket.class, this.apiHost, uri, page, pageSize);
	}

	/**
	 * Get the list of all support tickets
	 * 
	 * @return API list of ApiTicket
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiTicket> getTickets() throws ApiException {
		return getTickets(-1, -1);
	}
	
	/**
	 * Create a new Support Ticket
	 * @param ticket the ticket to create.
	 * @return a new instance of the created Ticket
	 * @throws ApiException if an error occurs.
	 */
	public ApiTicket create(ApiTicket ticket) throws ApiException{
		if(ticket == null)
			throw new NullPointerException("ticket");
		String uri = null;
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/tickets/";
		else
			uri = "/" + this.apiHost.getVersion() + "/tickets/";
		try {
			return new ApiTicket(ApiHelper.getJson(this.apiHost, "POST", uri, ticket.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}		
	}
	
	/**
	 *  Add a reply to a ticket
	 * @param ticketId ticket Id
	 * @param reply the reply to add
	 * @return update ticket object
	 * @throws ApiException
	 */
	public ApiTicket replyTicket(long ticketId, ApiTicketResponse reply) throws ApiException{
		if(reply == null)
			throw new NullPointerException("reply");
		String uri = null;
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/tickets/" + ticketId;
		else
			uri = "/" + this.apiHost.getVersion() + "/tickets/" + ticketId;
		try {
			return new ApiTicket(ApiHelper.getJson(this.apiHost, "PUT", uri, reply.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}				
	}
	
	/**
	 * Get a ticket by id
	 * @param ticketId ticket id 
	 * @return instance of ApiTicket
	 * @throws ApiException
	 */
	public ApiTicket getTicket(long ticketId) throws ApiException{
		String uri = null;
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/tickets/" + ticketId;
		else
			uri = "/" + this.apiHost.getVersion() + "/tickets/" + ticketId;
		try {
			return new ApiTicket(ApiHelper.getJson(this.apiHost, "GET", uri, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}		
	}
}
