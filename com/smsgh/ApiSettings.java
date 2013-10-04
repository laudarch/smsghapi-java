// $Id: ApiSettings.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

public class ApiSettings {
	/**
	 * Data fields.
	 */
	private String  accountId;
	private String  countryCode;
	private String  deliveryReportNotificationUrl;
	private boolean emailDailySummary;
	private boolean emailInvoiceReminders;
	private boolean emailMaintenance;
	private boolean emailNewInvoice;
	private boolean smsFortnightBalance;
	private boolean smsLowBalanceNotification;
	private boolean smsMaintenance;
	private boolean smsPromotionalMessages;
	private boolean smsTopUpNotification;
	private String  timeZone;
	
	/**
	 * Primary constructor.
	 */
	public ApiSettings(JsonObject json) {
		JsonValue val;
		for (String name : json.names()) {
			val = json.get(name);
			switch (name.toLowerCase()) {
				case "accountid":
					this.accountId = val.asString();
					break;
				case "countrycode":
					this.countryCode = val.asString();
					break;
				case "deliveryreportnotificationurl":
					this.deliveryReportNotificationUrl = val.asString();
					break;
				case "emaildailysummary":
					this.emailDailySummary = val.asBoolean();
					break;
				case "emailinvoicereminders":
					this.emailInvoiceReminders = val.asBoolean();
					break;
				case "emailmaintenance":
					this.emailMaintenance = val.asBoolean();
					break;
				case "emailnewinvoice":
					this.emailNewInvoice = val.asBoolean();
					break;
				case "smsfortnightbalance":
					this.smsFortnightBalance = val.asBoolean();
					break;
				case "smslowbalancenotification":
					this.smsLowBalanceNotification = val.asBoolean();
					break;
				case "smsmaintenance":
					this.smsMaintenance = val.asBoolean();
					break;
				case "smspromotionalmessages":
					this.smsPromotionalMessages = val.asBoolean();
					break;
				case "smstopupnotification":
					this.smsTopUpNotification = val.asBoolean();
					break;
				case "timezone":
					this.timeZone = val.asString();
					break;
			}
		}
	}
	
	/**
	 * Gets accountId.
	 */
	public String getAccountId() {
		return this.accountId;
	}
	
	/**
	 * Gets countryCode.
	 */
	public String getCountryCode() {
		return this.countryCode;
	}
	
	/**
	 * Gets deliveryReportNotificationUrl.
	 */
	public String getDeliveryReportNotificationUrl() {
		return this.deliveryReportNotificationUrl;
	}
	
	/**
	 * Gets emailDailySummary.
	 */
	public boolean getEmailDailySummary() {
		return this.emailDailySummary;
	}
	
	/**
	 * Gets emailInvoiceReminders.
	 */
	public boolean getEmailInvoiceReminders() {
		return this.emailInvoiceReminders;
	}
	
	/**
	 * Gets emailMaintenance.
	 */
	public boolean getEmailMaintenance() {
		return this.emailMaintenance;
	}
	
	/**
	 * Gets emailNewInvoice.
	 */
	public boolean getEmailNewInvoice() {
		return this.emailNewInvoice;
	}
	
	/**
	 * Gets smsFortnightBalance.
	 */
	public boolean getSmsFortnightBalance() {
		return this.smsFortnightBalance;
	}
	
	/**
	 * Gets smsLowBalanceNotification.
	 */
	public boolean getSmsLowBalanceNotification() {
		return this.smsLowBalanceNotification;
	}
	
	/**
	 * Gets smsMaintenance.
	 */
	public boolean getSmsMaintenance() {
		return this.smsMaintenance;
	}
	
	/**
	 * Gets smsPromotionalMessages.
	 */
	public boolean getSmsPromotionalMessages() {
		return this.smsPromotionalMessages;
	}
	
	/**
	 * Gets smsTopUpNotification.
	 */
	public boolean getSmsTopUpNotification() {
		return this.smsTopUpNotification;
	}
	
	/**
	 * Gets timeZone.
	 */
	public String getTimeZone() {
		return this.timeZone;
	}
	
	/**
	 * toJson
	 */
	public String toJson() {
		return new JsonObject()
			.add("CountryCode", this.countryCode)
			.add("DeliveryReportNotificationUrl", this.deliveryReportNotificationUrl)
			.add("EmailDailySummary", this.emailDailySummary)
			.add("EmailInvoiceReminders", this.emailInvoiceReminders)
			.add("EmailMaintenance", this.emailMaintenance)
			.add("EmailNewInvoice", this.emailNewInvoice)
			.add("SmsFortnightBalance", this.smsFortnightBalance)
			.add("SmsLowBalanceNotification", this.smsLowBalanceNotification)
			.add("SmsMaintenance", this.smsMaintenance)
			.add("SmsPromotionalMessages", this.smsPromotionalMessages)
			.add("SmsTopUpNotification", this.smsTopUpNotification)
			.add("TimeZone", this.timeZone)
			.toString();
	}
}
