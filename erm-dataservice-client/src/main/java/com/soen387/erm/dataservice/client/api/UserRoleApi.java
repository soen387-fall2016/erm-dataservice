package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.jaxrs.HalResource;
import com.soen387.erm.dataservice.client.model.BaseEntity;
import com.soen387.erm.dataservice.client.model.auth.UserRole;
import com.soen387.erm.dataservice.client.jaxrs.RestClient;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import java.util.Collection;

/**
 * Created by jeremybrown on 2016-10-31.
 */
public class UserRoleApi extends BaseApi<UserRole> {

    private static final String PATH_SUFFIX = "userRoles/";

    public UserRoleApi(RestClient restClient) {
        super(restClient);
    }

    @Override
    public String getPathSuffix() {
        return PATH_SUFFIX;
    }

    public UserRole getUserRoleById(Long id) {
        return restClient
                .getRootTarget()
                .path(getPathSuffix() + id.toString())
                .request()
                .accept("application/hal+json")
                .get(new GenericType<UserRole>() {});
    }

    @Override
    public UserRole create(UserRole role) {
        return restClient
                .getRootTarget()
                .path(getPathSuffix())
                .request()
                .post(Entity.json(role), new GenericType<UserRole>() {});
    }

    @Override
    public Collection<UserRole> getAll() {
        HalResource<BaseEntity, UserRole> departmentResources = restClient.getRootTarget()
                .path(getPathSuffix())
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, UserRole>>() {});

        return departmentResources.getContent();
    }

    @Override
    public UserRole getByLink(String link) {
        return new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<UserRole>() {});
    }

    @Override
    public Collection<UserRole> getCollectionByLink(String link) {
        HalResource<BaseEntity, UserRole> collectionWrapper = new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, UserRole>>() {
                });

        return collectionWrapper.getContent();
    }
}
