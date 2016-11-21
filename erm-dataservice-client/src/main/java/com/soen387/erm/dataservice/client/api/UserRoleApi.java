package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.model.BaseEntity;
import com.soen387.erm.dataservice.client.model.auth.UserRole;
import com.soen387.erm.dataservice.client.jaxrs.HalResource;
import com.soen387.erm.dataservice.client.jaxrs.RestClient;
import org.springframework.hateoas.Resource;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import java.util.Collection;

/**
 * Created by jeremybrown on 2016-10-31.
 */
public class UserRoleApi extends BaseApi<UserRole> {

    protected String userRolesPathSuffix = "userRoles/";

    public UserRoleApi(RestClient restClient) {
        super(restClient);
    }

    public Collection<UserRole> getAllUserRoles() {
        HalResource<BaseEntity, UserRole> userRoleResources = restClient.getRootTarget()
                .path(userRolesPathSuffix)
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, UserRole>>() {});

        return userRoleResources.getContent();
    }

    public UserRole getUserRoleById(Long id) {
        return restClient
                .getRootTarget()
                .path(userRolesPathSuffix + id.toString())
                .request()
                .accept("application/hal+json")
                .get(new GenericType<UserRole>() {});
    }

    public UserRole getResourceByLink(String link) {
        return new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<UserRole>() {});
    }

    public Collection<UserRole> getCollectionByLink(String link) {
        HalResource<BaseEntity, UserRole> collectionWrapper = new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, UserRole>>() {
                });

        return collectionWrapper.getContent();
    }

    public UserRole createResource(UserRole role) {
        return restClient
                .getRootTarget()
                .path(userRolesPathSuffix)
                .request()
                .post(Entity.json(role), new GenericType<UserRole>() {});
    }

}
