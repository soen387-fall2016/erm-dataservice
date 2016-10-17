package com.soen387.erm.dataservice.reservation.repository;

import com.soen387.erm.dataservice.auth.model.User;
import com.soen387.erm.dataservice.reservation.model.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ebrjere on 9/28/16.
 */
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findByUser(User user);

    // TODO
}
