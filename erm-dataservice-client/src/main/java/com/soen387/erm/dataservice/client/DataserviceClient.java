package com.soen387.erm.dataservice.client;

import com.soen387.erm.dataservice.client.api.DepartmentApi;
import com.soen387.erm.dataservice.client.api.UserApi;
import com.soen387.erm.dataservice.client.api.UserRoleApi;
import com.soen387.erm.dataservice.client.jaxrs.RestClient;

import java.net.URISyntaxException;

/**
 * Created by jeremybrown on 2016-10-31.
 */
public class DataserviceClient {

    private RestClient restClient;

    public DataserviceClient() throws URISyntaxException {
        ClientConfig config = new ClientConfig();
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
}
