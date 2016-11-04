package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.common.model.BaseEntity;
import com.soen387.erm.dataservice.common.model.auth.UserRole;
import com.soen387.erm.dataservice.client.jaxrs.HalResource;
import com.soen387.erm.dataservice.client.jaxrs.RestClient;
import org.springframework.hateoas.Resource;

import javax.ws.rs.core.GenericType;
import java.util.Collection;

/**
 * Created by jeremybrown on 2016-10-31.
 */
public class UserRoleApi extends BaseApi<UserRole> {

    public UserRoleApi(RestClient restClient) {
        super(restClient);
    }

    public Collection<Resource<UserRole>> getAllUserRoles() {
        HalResource<BaseEntity, Resource<UserRole>> userRoleResources = restClient.getRootTarget()
                .path("userRoles")
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, Resource<UserRole>>>() {});

        return userRoleResources.getContent();
    }

    public Resource<UserRole> getUserRoleById(Long id) {
        return restClient
                .getRootTarget()
                .path("userRoles/" + id.toString())
                .request()
                .accept("application/hal+json")
                .get(new GenericType<Resource<UserRole>>() {});
    }
}
