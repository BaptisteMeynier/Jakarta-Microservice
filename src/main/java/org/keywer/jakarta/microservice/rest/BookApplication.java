package org.keywer.jakarta.microservice.rest;

import org.keywer.jakarta.microservice.rest.exception.NoResultExceptionMapper;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("api/v1")
public class BookApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(BookResource.class);
        resources.add(NoResultExceptionMapper.class);
        return resources;
    }
}
