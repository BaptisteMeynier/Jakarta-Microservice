package org.keywer.jakarta.microservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Objects;


@Entity
@Table(name = "BOOK")
@NamedQueries({
        @NamedQuery(name="Book.findByTitle",query="SELECT b FROM Book b WHERE b.title = :title"),
        @NamedQuery(name="Book.findByAuthor",query="SELECT b FROM Book b JOIN Author a WHERE a.name = :name OR a.firstName=:firstName")
}
)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String title;
    @Positive
    private float price;
    @NotNull
    @ManyToOne
    @JoinColumn(name="FK_AUTHOR_ID")
    private Author author;

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    public Author getAuthor() {
        return author.clone();
    }

    public Book title(String title){
        this.title=title;
        return this;
    }

    public Book price(float price){
        this.price=price;
        return this;
    }

    public Book author(Author author){
        this.author=author;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Float.compare(book.price, price) == 0 &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, author);
    }

    @Override
    protected Book clone(){
        return new Book().title(this.title).price(this.price).author(this.author);
    }
}
