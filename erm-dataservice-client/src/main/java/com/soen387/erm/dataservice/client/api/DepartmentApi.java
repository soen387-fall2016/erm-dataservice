package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.jaxrs.HalResource;
import com.soen387.erm.dataservice.client.model.BaseEntity;
import com.soen387.erm.dataservice.client.model.auth.Department;
import com.soen387.erm.dataservice.client.jaxrs.RestClient;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import java.util.Collection;

/**
 * Created by jeremybrown on 2016-11-03.
 */
public class DepartmentApi extends BaseApi<Department> {

    private static final String PATH_SUFFIX = "departments/";

    public DepartmentApi(RestClient restClient) {
        super(restClient);
    }

    @Override
    public String getPathSuffix() {
        return PATH_SUFFIX;
    }

    @Override
    public Collection<Department> getAll() {
        HalResource<BaseEntity, Department> departmentResources = restClient.getRootTarget()
                .path(getPathSuffix())
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, Department>>() {});

        return departmentResources.getContent();
    }

    public Department getDepartmentById(Long id) {
        return restClient
                .getRootTarget()
                .path(getPathSuffix() + id.toString())
                .request()
                .accept("application/hal+json")
                .get(new GenericType<Department>() {});
    }

    public Department getByLink(String link) {
        return new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<Department>() {});
    }

    @Override
    public Collection<Department> getCollectionByLink(String link) {
        HalResource<BaseEntity, Department> collectionWrapper = new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, Department>>() {
                });

        return collectionWrapper.getContent();
    }

    @Override
    public Department create(Department department) {
        return restClient
                .getRootTarget()
                .path(getPathSuffix())
                .request()
                .post(Entity.json(department), new GenericType<Department>() {});
    }
}
