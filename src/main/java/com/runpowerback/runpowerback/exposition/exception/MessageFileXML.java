package com.runpowerback.runpowerback.exposition.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageFileXML {

    @JsonProperty
    public String message;

    public MessageFileXML() {
    }

    public MessageFileXML(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MessageFileXML{");
        sb.append("MessageFileXML='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
