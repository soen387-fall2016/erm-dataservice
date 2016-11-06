package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.jaxrs.HalResource;
import com.soen387.erm.dataservice.client.jaxrs.RestClient;
import com.soen387.erm.dataservice.common.model.BaseEntity;
import com.soen387.erm.dataservice.common.model.auth.User;
import org.springframework.hateoas.Resource;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.*;

/**
 * Created by jeremybrown on 2016-10-31.
 */
public class UserApi extends BaseApi<User> {

    protected String usersPathSuffix = "users/";

    public UserApi(RestClient restClient) {
        super(restClient);
    }

    public Collection<Resource<User>> getAllUsers() {
        HalResource<BaseEntity, Resource<User>> userResources = restClient.getRootTarget()
                .path(usersPathSuffix)
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, Resource<User>>>() {});

        return userResources.getContent();
    }

    public Resource<User> getUserByUsername(String username) {
        return restClient
                .getRootTarget()
                .path(usersPathSuffix + username)
                .queryParam("embedded", true)
                .request()
                .accept("application/hal+json")
                .get(new GenericType<Resource<User>>() {});
    }

    public Resource<User> getResourceByLink(String link) {
        return new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<Resource<User>>() {});
    }

    public Collection<Resource<User>> getCollectionByLink(String link) {
        HalResource<BaseEntity, Resource<User>> collectionWrapper = new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, Resource<User>>>() {
                });

        return collectionWrapper.getContent();
    }

    public Resource<User> createResource(User user) {
        return restClient
                .getRootTarget()
                .path(usersPathSuffix)
                .request()
                .post(Entity.json(user), new GenericType<Resource<User>>() {});
    }

//    public Collection<User> getUsersByFirstAndLastName(String firstName, String lastName) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("firstName", firstName);
//        params.put("lastName", lastName);
//
//        Traverson.TraversalBuilder tb = traverson.follow("users", "search", "findByFirstAndLastName")
//                .withTemplateParameters(params);
//        ParameterizedTypeReference<Resources<User>> typeRefDevices = new ParameterizedTypeReference<Resources<User>>() {};
//        Resources<User> resUsers = tb.toObject(typeRefDevices);
//        return resUsers.getContent();
//    }
//
//    public Optional<User> getUserByEmail(String email) {
//        Traverson.TraversalBuilder tb = traverson.follow("userRoles", "search", "findByEmail");
//        ParameterizedTypeReference<Resources<User>> typeRefDevices = new ParameterizedTypeReference<Resources<User>>() {};
//        Resources<User> resUsers = tb.toObject(typeRefDevices);
//        return resUsers.getContent().stream().filter(u -> u.getEmail().equals(email)).findFirst();
//    }
//
//    public Collection<User> getUsersByDepartmentName(String departmentName) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("departmentName", departmentName);
//
//        Traverson.TraversalBuilder tb = traverson.follow("userRoles", "search", "findByDepartmentName")
//                .withTemplateParameters(params);
//        ParameterizedTypeReference<Resources<User>> typeRefDevices = new ParameterizedTypeReference<Resources<User>>() {};
//        Resources<User> resUsers = tb.toObject(typeRefDevices);
//        return resUsers.getContent();
//    }
}
