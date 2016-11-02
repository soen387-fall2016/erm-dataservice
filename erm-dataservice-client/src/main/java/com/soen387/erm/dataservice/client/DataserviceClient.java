package com.soen387.erm.dataservice.client;

import com.soen387.erm.dataservice.client.api.UserApi;
import com.soen387.erm.dataservice.client.api.UserRoleApi;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;

import java.net.URISyntaxException;

/**
 * Created by jeremybrown on 2016-10-31.
 */
public class DataserviceClient {

    private ClientConfig config;
    private Traverson traverson;

    public DataserviceClient() throws URISyntaxException {
        this.config = new ClientConfig();
        this.traverson = new Traverson(this.config.getBaseUri(), MediaTypes.HAL_JSON);
    }

    public UserRoleApi getUserRoleApi() {
        return new UserRoleApi(this.config);
    }

    public UserApi getUserApi() {
        return new UserApi(this.config);
    }
}
