package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.jaxrs.RestClient;
import org.springframework.hateoas.Resource;

import javax.ws.rs.core.Response;
import java.util.Collection;

/**
 * Created by jeremybrown on 2016-11-03.
 */
public abstract class BaseApi<T> {

    protected RestClient restClient;

    public BaseApi(RestClient restClient) {
        this.restClient = restClient;
    }

    public abstract T createResource(T resource);

    public abstract T getResourceByLink(String link);

    public Response deleteResourceByLink(String link) {
        return new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .delete();
    }

    public abstract Collection<T> getCollectionByLink(String link);

}
