package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.jaxrs.HalResource;
import com.soen387.erm.dataservice.client.jaxrs.RestClient;
import com.soen387.erm.dataservice.client.model.BaseEntity;
import com.soen387.erm.dataservice.client.model.reservation.Reservation;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import java.util.Collection;

/**
 * Created by Nicola on 2016-11-26.
 */
public class ReservationApi extends BaseApi<Reservation> {

    private static final String PATH_SUFFIX = "reservations/";

    public ReservationApi(RestClient restClient) {
        super(restClient);
    }

    @Override
    public String getPathSuffix() {
        return PATH_SUFFIX;
    }

    @Override
    public Reservation create(Reservation resource) {
        return restClient
                .getRootTarget()
                .path(getPathSuffix())
                .request()
                .post(Entity.json(resource), new GenericType<Reservation>() {});
    }

    @Override
    public Collection<Reservation> getAll() {
        HalResource<BaseEntity, Reservation> departmentResources = restClient.getRootTarget()
                .path(getPathSuffix())
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, Reservation>>() {});

        return departmentResources.getContent();
    }

    @Override
    public Reservation getByLink(String link) {
        return new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<Reservation>() {});
    }

    @Override
    public Collection<Reservation> getCollectionByLink(String link) {
        HalResource<BaseEntity, Reservation> collectionWrapper = new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, Reservation>>() {
                });

        return collectionWrapper.getContent();
    }

    public Reservation ReservationById(Long id) {
        return restClient
                .getRootTarget()
                .path(getPathSuffix() + id)
                .request()
                .accept("application/hal+json")
                .get(new GenericType<Reservation>() {});
    }

}
