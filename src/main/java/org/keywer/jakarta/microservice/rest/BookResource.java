package org.keywer.jakarta.microservice.rest;

import org.keywer.jakarta.microservice.model.Book;
import org.keywer.jakarta.microservice.repository.Repository;
import org.keywer.jakarta.microservice.rest.param.AuthorParam;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("book")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    private Repository repository;

    @GET
    public Response getBookByTitle(@QueryParam("title") String title){
        final Book book = repository.findByTitle(title);
        return Response.ok().entity(book).build();
    }

    @GET
    @Path("author")
    public Response getBooksByAuthor(@BeanParam AuthorParam author){
        final List<Book> books = repository.findByAuthor(author);
        return Response.ok().entity(books).build();
    }
}
