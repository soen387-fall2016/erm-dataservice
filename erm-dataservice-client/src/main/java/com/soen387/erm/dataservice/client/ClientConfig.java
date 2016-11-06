package com.soen387.erm.dataservice.client;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by jeremybrown on 2016-10-31.
 */
public class ClientConfig {

    private URI baseUri;

    public ClientConfig() throws URISyntaxException {
        this("http://localhost:8080/api");
    }

    public ClientConfig(String baseUriString) throws URISyntaxException {
        baseUri = new URI(baseUriString);
    }

    public URI getBaseUri() {
        return baseUri;
    }

    public String getBaseUriString() {
        return baseUri.toString();
    }

    public void setBaseUrl(URI baseUri) {
        this.baseUri = baseUri;
    }

    public void setBaseUrl(String baseUriString) throws URISyntaxException {
        this.baseUri = new URI(baseUriString);
    }
}
