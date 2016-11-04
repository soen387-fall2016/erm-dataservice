package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.jaxrs.RestClient;
import org.springframework.hateoas.Resource;

import javax.ws.rs.core.GenericType;

/**
 * Created by jeremybrown on 2016-11-03.
 */
public abstract class BaseApi<T> {

    protected RestClient restClient;

    public BaseApi(RestClient restClient) {
        this.restClient = restClient;
    }

    public Resource<T> getByLink(String link) {
        return new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<Resource<T>>() {});
    }
}
