package com.soen387.erm.dataservice.server.repository;

import com.soen387.erm.dataservice.server.model.auth.Department;
import com.soen387.erm.dataservice.server.model.auth.User;
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
        config.exposeIdsFor(User.class, Department.class);
        config.setReturnBodyOnCreate(true);
    }
}
