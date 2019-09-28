package org.keywer.jakarta.simple.microservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.*;

@Entity
@Table(name = "AUTHOR")
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String firstName;
    @NotNull
    @Past
    private Date birthdate;

    public Author name(String name){
        this.name=name;
        return this;
    }

    public Author firstName(String firstName){
        this.firstName=firstName;
        return this;
    }

    public Author birthdate(Date birthdate){
        this.birthdate=new Date(birthdate.getTime());
        return this;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public Date getBirthdate() {
        return new Date(birthdate.getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) &&
                Objects.equals(firstName, author.firstName) &&
                Objects.equals(birthdate, author.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, firstName, birthdate);
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }

    @Override
    protected Author clone() {
        return new Author()
                .name(this.getName())
                .firstName(this.getFirstName())
                .birthdate(this.getBirthdate());
    }
}
