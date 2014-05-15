/**
 *
 */
package com.smsgh;

import java.util.Date;

import com.smsgh.json.JsonObject;
import com.smsgh.json.JsonValue;

/**
 * @author Arsene
 *
 */
public class ApiTicketResponse {

    private long id;
    private Date time;
    private String content;
    private String attachment;

    public ApiTicketResponse() {
    }

    /**
     *
     */
    public ApiTicketResponse(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "id":
                    this.id = val.asLong();
                    break;
                case "time":
                    this.time = val.asDate();
                    break;
                case "content":
                    this.content = val.asString();
                    break;
                case "attachment":
                    this.attachment = val.asString();
                    break;
            }
        }

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public String getAttachment() {
        return attachment;
    }

    public String toJson() {
        JsonObject json = new JsonObject();
        json.add("Content", content);
        return json.toString();
    }

}
