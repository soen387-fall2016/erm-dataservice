package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.model.BaseEntity;
import com.soen387.erm.dataservice.client.model.auth.Department;
import com.soen387.erm.dataservice.client.jaxrs.HalResource;
import com.soen387.erm.dataservice.client.jaxrs.RestClient;
import org.springframework.hateoas.Resource;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import java.util.Collection;

/**
 * Created by jeremybrown on 2016-11-03.
 */
public class DepartmentApi extends BaseApi<Department> {

    protected String departmentsPathSuffix = "departments/";

    public DepartmentApi(RestClient restClient) {
        super(restClient);
    }

    public Collection<Department> getAllDepartments() {
        HalResource<BaseEntity, Department> departmentResources = restClient.getRootTarget()
                .path(departmentsPathSuffix)
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, Department>>() {});

        return departmentResources.getContent();
    }

    public Department getDepartmentById(Long id) {
        return restClient
                .getRootTarget()
                .path(departmentsPathSuffix + id.toString())
                .request()
                .accept("application/hal+json")
                .get(new GenericType<Department>() {});
    }

    public Department getResourceByLink(String link) {
        return new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<Department>() {});
    }

    public Collection<Department> getCollectionByLink(String link) {
        HalResource<BaseEntity, Department> collectionWrapper = new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, Department>>() {
                });

        return collectionWrapper.getContent();
    }

    public Department createResource(Department department) {
        return restClient
                .getRootTarget()
                .path(departmentsPathSuffix)
                .request()
                .post(Entity.json(department), new GenericType<Department>() {});
    }
}
