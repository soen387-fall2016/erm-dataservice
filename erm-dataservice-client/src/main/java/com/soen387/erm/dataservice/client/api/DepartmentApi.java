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

    public Collection<Resource<Department>> getAllDepartments() {
        HalResource<BaseEntity, Resource<Department>> departmentResources = restClient.getRootTarget()
                .path(departmentsPathSuffix)
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, Resource<Department>>>() {});

        return departmentResources.getContent();
    }

    public Resource<Department> getDepartmentById(Long id) {
        return restClient
                .getRootTarget()
                .path(departmentsPathSuffix + id.toString())
                .request()
                .accept("application/hal+json")
                .get(new GenericType<Resource<Department>>() {});
    }

    public Resource<Department> getResourceByLink(String link) {
        return new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<Resource<Department>>() {});
    }

    public Collection<Resource<Department>> getCollectionByLink(String link) {
        HalResource<BaseEntity, Resource<Department>> collectionWrapper = new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, Resource<Department>>>() {
                });

        return collectionWrapper.getContent();
    }

    public Resource<Department> createResource(Department department) {
        return restClient
                .getRootTarget()
                .path(departmentsPathSuffix)
                .request()
                .post(Entity.json(department), new GenericType<Resource<Department>>() {});
    }
}
