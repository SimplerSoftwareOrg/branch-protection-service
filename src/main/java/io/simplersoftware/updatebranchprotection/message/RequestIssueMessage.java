package io.simplersoftware.updatebranchprotection.message;

import javax.swing.*;

public class RequestIssueMessage {

    private String title;
    private String body;

    public RequestIssueMessage(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public RequestIssueMessage() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "RequestIssueMessage{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
