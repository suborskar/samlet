package de.suborskar.samlet.configuration;

import io.micronaut.context.annotation.ConfigurationProperties;

import java.net.URL;

@ConfigurationProperties("samlet")
public class SamletConfiguration {
    private String token;

    private URL webUrl;

    private URL apiUrl;

    private String apiVersion;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public URL getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(URL webUrl) {
        this.webUrl = webUrl;
    }

    public URL getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(URL apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }
}
