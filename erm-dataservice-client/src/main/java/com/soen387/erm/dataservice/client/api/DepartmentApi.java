package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.common.model.BaseEntity;
import com.soen387.erm.dataservice.common.model.auth.Department;
import com.soen387.erm.dataservice.client.jaxrs.HalResource;
import com.soen387.erm.dataservice.client.jaxrs.RestClient;
import org.springframework.hateoas.Resource;

import javax.ws.rs.core.GenericType;
import java.util.Collection;

/**
 * Created by jeremybrown on 2016-11-03.
 */
public class DepartmentApi extends BaseApi<Department> {

    public DepartmentApi(RestClient restClient) {
        super(restClient);
    }

    public Collection<Resource<Department>> getAllDepartments() {
        HalResource<BaseEntity, Resource<Department>> departmentResources = restClient.getRootTarget()
                .path("departments")
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, Resource<Department>>>() {});

        return departmentResources.getContent();
    }

    public Resource<Department> getDepartmentById(Long id) {
        return restClient
                .getRootTarget()
                .path("departments/" + id.toString())
                .request()
                .accept("application/hal+json")
                .get(new GenericType<Resource<Department>>() {});
    }
}
