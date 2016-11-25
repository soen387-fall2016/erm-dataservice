package com.soen387.erm.dataservice.client;

import com.soen387.erm.dataservice.client.api.*;
import com.soen387.erm.dataservice.client.jaxrs.RestClient;

import java.net.URISyntaxException;

/**
 * Created by jeremybrown on 2016-10-31.
 */
public class DataserviceClient {

    private RestClient restClient;

    public DataserviceClient() throws URISyntaxException {
        this(new ClientConfig());
    }

    public DataserviceClient(ClientConfig config) {
        this.restClient = new RestClient(config.getBaseUriString());
    }

    public UserRoleApi getUserRoleApi() {
        return new UserRoleApi(this.restClient);
    }

    public DepartmentApi getDepartmentApi() {
        return new DepartmentApi(this.restClient);
    }

    public UserApi getUserApi() {
        return new UserApi(this.restClient);
    }

    public ReservationApi getReservationApi() {
        return new ReservationApi(this.restClient);
    }

    public ResourceApi getResourceApi() {
        return new ResourceApi(this.restClient);
    }
}
