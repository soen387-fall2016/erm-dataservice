package com.soen387.erm.dataservice.client.jaxrs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import com.soen387.erm.dataservice.client.providers.CustomRepresentationTypeProvider;
import com.sun.jersey.multipart.impl.MultiPartWriter;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.springframework.hateoas.core.DefaultRelProvider;
import org.springframework.hateoas.hal.Jackson2HalModule;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * @author Vasyl Spachynskyi
 * @version $Id:
 * @since 09.12.2015
 */
public class RestClient {
    private WebTarget rootTarget;

    public RestClient(String targetUrl) {
        Client client = ClientBuilder.newBuilder().build();
        client.property(ClientProperties.CONNECT_TIMEOUT, 200);
        client.property(ClientProperties.READ_TIMEOUT, 1000);

        JacksonJsonProvider customRepresentationTypeProvider = new CustomRepresentationTypeProvider();
        customRepresentationTypeProvider.setMapper(getHallMapper());

        rootTarget = client.target(targetUrl);

        rootTarget
                .register(customRepresentationTypeProvider)
                .register(JacksonFeature.class)
                .register(MultiPartWriter.class);
    }

    private ObjectMapper getHallMapper() {
        ObjectMapper halObjectMapper = new ObjectMapper();
        halObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        halObjectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        halObjectMapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, true);
        halObjectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        AnnotationIntrospector primary = new JaxbAnnotationIntrospector();
        AnnotationIntrospector secondary = new JacksonAnnotationIntrospector();
        AnnotationIntrospector pair = AnnotationIntrospector.pair(secondary, primary);
        halObjectMapper.setAnnotationIntrospector(pair);

        halObjectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        halObjectMapper
                .setHandlerInstantiator(new Jackson2HalModule.
                        HalHandlerInstantiator(new DefaultRelProvider(), null, null));

        Jackson2HalModule jackson2HalModule = new Jackson2HalModule();

        halObjectMapper.registerModule(jackson2HalModule);
        return halObjectMapper;
    }

    public WebTarget getRootTarget() {
        return rootTarget;
    }
}
