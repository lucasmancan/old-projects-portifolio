package br.com.lucasmancan.math.models;

import java.util.List;

public class AppResponse {

    public final static AppResponse OOPS = new AppResponse("Oops.. an internal server error occurred");

    private String error;
    private List<String> details;

    public AppResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}
