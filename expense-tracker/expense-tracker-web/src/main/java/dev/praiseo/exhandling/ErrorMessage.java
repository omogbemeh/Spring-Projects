package dev.praiseo.exhandling;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.Objects;

public class ErrorMessage {
    private Date timeStamp;
    private int statusCode;
    private String message;
    private String description;

    public ErrorMessage(int statusCode, String message, String description) {
        this.timeStamp = new Date();
        this.statusCode = statusCode;
        this.message = message;
        this.description = description;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorMessage that)) return false;
        return statusCode == that.statusCode && timeStamp.equals(that.timeStamp) && message.equals(that.message) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeStamp, statusCode, message, description);
    }
}
