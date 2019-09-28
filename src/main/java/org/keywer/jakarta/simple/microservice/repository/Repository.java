package org.keywer.jakarta.simple.microservice.repository;

import org.keywer.jakarta.simple.microservice.model.Book;
import org.keywer.jakarta.simple.microservice.rest.param.AuthorParam;

import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import java.util.List;

import static org.keywer.jakarta.simple.microservice.constants.ApplicationConstants.MAX_QUERY_ENTITY;

@ApplicationScoped
public class Repository {

    @PersistenceContext(unitName = "BOOK_PU")
    private EntityManager em;

    public Book findByTitle(final String title){
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class);
        query.setParameter("title",title);
        return query.getSingleResult();
    }

    public List<Book> findByAuthor(AuthorParam author) {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b JOIN Author a WHERE a.name = :name OR a.firstName=:firstName", Book.class);
        query.setParameter("name",author.name);
        query.setParameter("firstName",author.firstName);
        query.setMaxResults(MAX_QUERY_ENTITY);
        return query.getResultList();
    }
}
