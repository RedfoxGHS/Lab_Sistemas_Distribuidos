package br.inatel.labs.labrest.client.exceptions;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
    private String timestamp;
    private String status;
    private String error;
    private String message;
    private String path;

    public StandardError() {
    }

    public StandardError(String jsonString) {
        Gson gson = new Gson();
        JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();
        StandardError temp = gson.fromJson(json, StandardError.class);
        this.timestamp = temp.getTimestamp();
        this.status = temp.getStatus();
        this.error = temp.getError();
        this.message = temp.getMessage();
        this.path = temp.getPath();
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
