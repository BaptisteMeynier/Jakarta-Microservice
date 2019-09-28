package org.keywer.jakarta.microservice.repository;

import org.keywer.jakarta.microservice.constants.ApplicationConstants;
import org.keywer.jakarta.microservice.model.Book;
import org.keywer.jakarta.microservice.rest.param.AuthorParam;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import java.util.List;

@ApplicationScoped
public class Repository {

    @PersistenceContext(unitName = "BOOK_PU")
    private EntityManager em;

    public Book findByTitle(final String title){
        TypedQuery<Book> query = em.createNamedQuery("Book.findByTitle", Book.class);
        query.setParameter("title",title);
        return query.getSingleResult();
    }

    public List<Book> findByAuthor(AuthorParam author) {
        TypedQuery<Book> query = em.createNamedQuery("Book.findByAuthor", Book.class);
        query.setParameter("name",author.name);
        query.setParameter("firstName",author.firstName);
        query.setMaxResults(ApplicationConstants.MAX_QUERY_ENTITY);
        return query.getResultList();
    }
}
