package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.jaxrs.HalResource;
import com.soen387.erm.dataservice.client.jaxrs.RestClient;
import com.soen387.erm.dataservice.client.model.BaseEntity;
import com.soen387.erm.dataservice.client.model.auth.User;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import java.util.Collection;

/**
 * Created by jeremybrown on 2016-10-31.
 */
public class UserApi extends BaseApi<User> {

    private static final String PATH_SUFFIX = "users/";

    public UserApi(RestClient restClient) {
        super(restClient);
    }

    @Override
    public String getPathSuffix() {
        return PATH_SUFFIX;
    }

    public User getUserByUsername(String username) {
        return restClient
                .getRootTarget()
                .path(getPathSuffix() + username)
                .request()
                .accept("application/hal+json")
                .get(new GenericType<User>() {});
    }

    @Override
    public User create(User user) {
        return restClient
                .getRootTarget()
                .path(getPathSuffix())
                .request()
                .post(Entity.json(user), new GenericType<User>() {});
    }

    @Override
    public Collection<User> getAll() {
        HalResource<BaseEntity, User> departmentResources = restClient.getRootTarget()
                .path(getPathSuffix())
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, User>>() {});

        return departmentResources.getContent();
    }

    @Override
    public User getByLink(String link) {
        return new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<User>() {});
    }

    @Override
    public Collection<User> getCollectionByLink(String link) {
        HalResource<BaseEntity, User> collectionWrapper = new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, User>>() {
                });

        return collectionWrapper.getContent();
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
