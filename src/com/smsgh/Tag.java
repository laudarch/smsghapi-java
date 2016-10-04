package com.smsgh;

/**
 *
 * @author Arsene Tochemey GANDOTE
 */
public class Tag {

    private String key;
    private String value;

    public Tag() {
    }

    public Tag(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "key":
                    this.key = val.asString();
                    break;
                case "value":
                    this.value = val.asString();
                    break;
            }

        }
    }
}
