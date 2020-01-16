package io.simplersoftware.updatebranchprotection.message;

import org.kohsuke.github.GHAppInstallationToken;

public class AppInstallationTokenMessage{

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
