package org.keywer.jakarta.simple.microservice.rest.param;


import javax.ws.rs.QueryParam;

public class AuthorParam {
    @QueryParam("name")
    public String name;
    @QueryParam("firstName")
    public String firstName;
}
