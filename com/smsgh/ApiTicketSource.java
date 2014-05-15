/**
 *
 */
package com.smsgh;

/**
 * @author Administrator
 *
 */
public enum ApiTicketSource {

    PHONE("Phone"),
    EMAIL("Email"),
    FORUM("Forum"),
    IN_PERSON("In Person"),
    CHAT("Chat"),
    SOCIAL_NETWORK("Social Network");

    private String source;

    private ApiTicketSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return this.source;
    }
}
