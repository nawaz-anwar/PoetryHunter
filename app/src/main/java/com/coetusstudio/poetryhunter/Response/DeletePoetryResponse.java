package com.coetusstudio.poetryhunter.Response;

public class DeletePoetryResponse {

    String status;
    String message;

    public DeletePoetryResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
