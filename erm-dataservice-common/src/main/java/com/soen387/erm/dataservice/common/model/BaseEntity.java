package com.soen387.erm.dataservice.common.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.soen387.erm.dataservice.common.model.auth.*;
import org.springframework.hateoas.ResourceSupport;

/**
 * @author Vasyl Spachynskyi
 * @version $Id:
 * @since 10.12.2015
 */

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")

@JsonSubTypes({
        @JsonSubTypes.Type(value = User.class, name = "user"),
        @JsonSubTypes.Type(value = UserRole.class, name = "userRole"),
        @JsonSubTypes.Type(value = Department.class, name = "department")
})
public abstract class BaseEntity extends ResourceSupport {

}
