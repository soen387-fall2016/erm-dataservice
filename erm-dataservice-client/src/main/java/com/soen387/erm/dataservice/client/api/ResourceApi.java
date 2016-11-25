package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.jaxrs.HalResource;
import com.soen387.erm.dataservice.client.jaxrs.RestClient;
import com.soen387.erm.dataservice.client.model.BaseEntity;
import com.soen387.erm.dataservice.client.model.auth.Department;
import com.soen387.erm.dataservice.client.model.resource.AbstractResource;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import java.util.Collection;


public class ResourceApi extends BaseApi<AbstractResource> {

    private static final String PATH_SUFFIX = "resources/";

    public ResourceApi(RestClient restClient) {
        super(restClient);
    }

    @Override
    public String getPathSuffix() {
        return PATH_SUFFIX;
    }

    public AbstractResource getResourceById(Long id) {
        return restClient
                .getRootTarget()
                .path(getPathSuffix() + id)
                .request()
                .accept("application/hal+json")
                .get(new GenericType<AbstractResource>() {});
    }

    @Override
    public AbstractResource create(AbstractResource resource) {
        return restClient
                .getRootTarget()
                .path(getPathSuffix())
                .request()
                .post(Entity.json(resource), new GenericType<AbstractResource>() {});
    }

    @Override
    public Collection<AbstractResource> getAll() {
        HalResource<BaseEntity, AbstractResource> departmentResources = restClient.getRootTarget()
                .path(getPathSuffix())
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, AbstractResource>>() {});

        return departmentResources.getContent();
    }

    @Override
    public AbstractResource getByLink(String link) {
        return new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<AbstractResource>() {});
    }

    @Override
    public Collection<AbstractResource> getCollectionByLink(String link) {
        HalResource<BaseEntity, AbstractResource> collectionWrapper = new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, AbstractResource>>() {
                });

        return collectionWrapper.getContent();
    }
}