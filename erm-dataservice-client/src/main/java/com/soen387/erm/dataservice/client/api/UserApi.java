package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.ClientConfig;
import com.soen387.erm.dataservice.common.model.auth.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.client.Traverson;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by jeremybrown on 2016-10-31.
 */
public class UserApi {

    private ClientConfig config;

    private Traverson traverson;

    public UserApi(ClientConfig config) {
        this.config = config;
        this.traverson = new Traverson(this.config.getBaseUri(), MediaTypes.HAL_JSON);
    }

    public Collection<User> getUsers() {
        Traverson.TraversalBuilder tb = traverson.follow("users");
        ParameterizedTypeReference<Resources<User>> typeRefDevices = new ParameterizedTypeReference<Resources<User>>() {};
        Resources<User> resUsers = tb.toObject(typeRefDevices);
        return resUsers.getContent();
    }

    public Collection<User> getUsersByFirstAndLastName(String firstName, String lastName) {
        Map<String, Object> params = new HashMap<>();
        params.put("firstName", firstName);
        params.put("lastName", lastName);

        Traverson.TraversalBuilder tb = traverson.follow("users", "search", "findByFirstAndLastName")
                .withTemplateParameters(params);
        ParameterizedTypeReference<Resources<User>> typeRefDevices = new ParameterizedTypeReference<Resources<User>>() {};
        Resources<User> resUsers = tb.toObject(typeRefDevices);
        return resUsers.getContent();
    }

    public Optional<User> getUserByEmail(String email) {
        Traverson.TraversalBuilder tb = traverson.follow("userRoles", "search", "findByEmail");
        ParameterizedTypeReference<Resources<User>> typeRefDevices = new ParameterizedTypeReference<Resources<User>>() {};
        Resources<User> resUsers = tb.toObject(typeRefDevices);
        return resUsers.getContent().stream().filter(u -> u.getEmail().equals(email)).findFirst();
    }

    public Collection<User> getUsersByDepartmentName(String departmentName) {
        Map<String, Object> params = new HashMap<>();
        params.put("departmentName", departmentName);

        Traverson.TraversalBuilder tb = traverson.follow("userRoles", "search", "findByDepartmentName")
                .withTemplateParameters(params);
        ParameterizedTypeReference<Resources<User>> typeRefDevices = new ParameterizedTypeReference<Resources<User>>() {};
        Resources<User> resUsers = tb.toObject(typeRefDevices);
        return resUsers.getContent();
    }

    public Optional<User> getUserByUsername(String username) {
        // TODO use actual endpoint for username instead of filtering on "all" list
        Traverson.TraversalBuilder tb = traverson.follow("userRoles");
        ParameterizedTypeReference<Resources<User>> typeRefDevices = new ParameterizedTypeReference<Resources<User>>() {};
        Resources<User> resUsers = tb.toObject(typeRefDevices);
        return resUsers.getContent().stream().filter(u -> u.getUsername().equals(username)).findFirst();
    }
}
