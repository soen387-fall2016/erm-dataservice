package com.soen387.erm.dataservice.server.repository.reservation;

import com.soen387.erm.dataservice.common.model.reservation.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by jeremybrown on 2016-10-22.
 */
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findByUserUsername(@Param("username") String username);

    List<Reservation> findByResourcesResourceId(@Param("resourceid") String resourceid);
}
