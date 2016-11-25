package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.model.BaseEntity;
import com.soen387.erm.dataservice.client.model.reservation.Reservation;
import com.soen387.erm.dataservice.client.jaxrs.HalResource;
import com.soen387.erm.dataservice.client.jaxrs.RestClient;
import org.springframework.hateoas.Resource;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import java.util.Collection;

/**
 * Created by Nicola on 2016-11-26.
 */
public class ReservationApi extends BaseApi<Reservation> {

    protected String reservationsPathSuffix = "reservations/";

    public ReservationApi(RestClient restClient) {
        super(restClient);
    }

    public Collection<Reservation> getAllReservations() {
        HalResource<BaseEntity, Reservation> reservationResources = restClient.getRootTarget()
                .path(reservationsPathSuffix)
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, Reservation>>() {});

        return reservationResources.getContent();
    }

    public Reservation getReservationById(Long id) {
        return restClient
                .getRootTarget()
                .path(reservationsPathSuffix + id.toString())
                .request()
                .accept("application/hal+json")
                .get(new GenericType<Reservation>() {});
    }

    public Reservation getResourceByLink(String link) {
        return new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<Reservation>() {});
    }

    public Collection<Reservation> getCollectionByLink(String link) {
        HalResource<BaseEntity, Reservation> collectionWrapper = new RestClient(link)
                .getRootTarget()
                .request()
                .accept("application/hal+json")
                .get(new GenericType<HalResource<BaseEntity, Reservation>>() {
                });

        return collectionWrapper.getContent();
    }

    public Reservation createResource(Reservation reservation) {
        return restClient
                .getRootTarget()
                .path(reservationsPathSuffix)
                .request()
                .post(Entity.json(reservation), new GenericType<Reservation>() {});
    }


}
