package org.keywer.jakarta.microservice;


import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.keywer.jakarta.microservice.model.Book;
import org.keywer.jakarta.microservice.rest.BookResource;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;


@RunWith(Arquillian.class)
public class BookApplicationIT {

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addPackages(true,"org.keywer.jakarta.microservice")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }


    @ArquillianResource
    private URI deploymentUrl;

    private Client client;
    private WebTarget bookTarget;

    @Before
    public void init() {
        client = ClientBuilder.newClient();
        bookTarget = client.target(deploymentUrl).path("rest");
    }


    @Test
    @RunAsClient
    public void should_contact_book_endpoint(){
        System.out.println(bookTarget.path("book").getUri());
        Response response =
                bookTarget.path("book")
                        .request(MediaType.APPLICATION_JSON_TYPE)
                        .get();
    }

    @Test
    @RunAsClient
    public void should_get_books(){
        Response response =
                bookTarget.path("book")
                        .request(MediaType.APPLICATION_JSON_TYPE)
                        .get();
        String result = response.readEntity(String.class);
    }

}
