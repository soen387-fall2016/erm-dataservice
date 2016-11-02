package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.ClientConfig;
import com.soen387.erm.dataservice.common.model.auth.UserRole;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * Created by jeremybrown on 2016-10-31.
 */
public class UserRoleApi {

    private ClientConfig config;

    private Traverson traverson;

    public UserRoleApi(ClientConfig config) {
        this.config = config;
        this.traverson = new Traverson(this.config.getBaseUri(), MediaTypes.HAL_JSON);
    }

    public Collection<UserRole> getUserRoles() {
        Traverson.TraversalBuilder tb = traverson.follow("userRoles");
        ParameterizedTypeReference<Resources<UserRole>> typeRefDevices = new ParameterizedTypeReference<Resources<UserRole>>() {};
        Resources<UserRole> resUserRoles = tb.toObject(typeRefDevices);
        resUserRoles.getId();
        return resUserRoles.getContent();
    }

    public Optional<UserRole> getUserRoleByLink(Link userRoleLink) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Resource<UserRole>> responseEntity =
        restTemplate.exchange(userRoleLink.getHref(), HttpMethod.GET, null, new ParameterizedTypeReference<Resource<UserRole>>() {}, Collections.emptyMap());
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            Resource<UserRole> userRoleResource = responseEntity.getBody();
            return Optional.of(userRoleResource.getContent());
        }
        else {
            return Optional.empty();
        }
    }

}
