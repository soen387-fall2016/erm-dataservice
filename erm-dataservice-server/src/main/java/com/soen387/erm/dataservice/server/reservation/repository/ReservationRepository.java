package com.soen387.erm.dataservice.server.reservation.repository;

import com.soen387.erm.dataservice.server.reservation.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by jeremybrown on 2016-10-22.
 */
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findByUserUsername(@Param("username") String username);

    List<Reservation> findByResourcesId(@Param("resourceid") String resourceid);
}
