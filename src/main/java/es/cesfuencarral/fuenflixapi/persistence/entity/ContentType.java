package es.cesfuencarral.fuenflixapi.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "content_type")
//@NamedQueries({
//        @NamedQuery(name = "Area.findByValidity", query = "SELECT a FROM Area a WHERE a.validFrom <= :date AND (a.validTill IS NULL OR a.validTill > :date)")
//})
public class ContentType implements Serializable {

    /*Fields*/
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;


    /*Constructors*/
    public ContentType() {}

    /*Getters & setters*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        return (object instanceof ContentType) && this.id == ((ContentType) object).getId();
    }

    @Override
    public String toString() {
        return " id=" + id + " ]";
    }
}
