package com.soen387.erm.dataservice.server.repository;

import com.soen387.erm.dataservice.server.model.auth.Department;
import com.soen387.erm.dataservice.server.model.auth.User;
import com.soen387.erm.dataservice.server.model.auth.UserRole;
import com.soen387.erm.dataservice.server.model.reservation.Reservation;
import com.soen387.erm.dataservice.server.model.resource.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * Created by jeremybrown on 2016-11-07.
 */
@Configuration
public class ErmRepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(User.class, Department.class, UserRole.class);
        config.exposeIdsFor(Reservation.class);
        config.exposeIdsFor(AbstractResource.class, Building.class, Computer.class, Projector.class, Room.class,
                Whiteboard.class, ComputerOS.class);
        config.setReturnBodyOnCreate(true);
    }
}
