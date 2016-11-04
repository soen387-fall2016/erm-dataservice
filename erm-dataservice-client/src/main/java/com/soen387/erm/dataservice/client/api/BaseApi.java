package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.jaxrs.HalResource;
import com.soen387.erm.dataservice.client.jaxrs.RestClient;
import com.soen387.erm.dataservice.common.model.BaseEntity;
import org.springframework.hateoas.Resource;

import javax.ws.rs.core.GenericType;
import java.util.Collection;

/**
 * Created by jeremybrown on 2016-11-03.
 */
public abstract class BaseApi<T> {

    protected RestClient restClient;

    public BaseApi(RestClient restClient) {
        this.restClient = restClient;
    }

    public Resource<T> getResourceByLink(String link) {
        return new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<Resource<T>>() {});
    }

    public Collection<Resource<T>> getCollectionByLink(String link) {
        HalResource<BaseEntity, Resource<T>> collectionWrapper = new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, Resource<T>>>() {
                });

        return collectionWrapper.getContent();
    }
}
