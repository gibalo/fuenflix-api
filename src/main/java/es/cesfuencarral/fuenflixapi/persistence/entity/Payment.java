package es.cesfuencarral.fuenflixapi.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "payment")
//@NamedQueries({
//        @NamedQuery(name = "Area.findByValidity", query = "SELECT a FROM Area a WHERE a.validFrom <= :date AND (a.validTill IS NULL OR a.validTill > :date)")
//})
public class Payment implements Serializable {

    /*Fields*/
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double rate;




    @Column(name = "buying_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date buyingDate;

    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private User user;

    @JoinColumn(name = "content", referencedColumnName = "id")
    @ManyToOne
    private Content content;

    /*Constructors*/
    public Payment() {}

    /*Getters & setters*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Date getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(Date buyingDate) {
        this.buyingDate = buyingDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object object) {
        return (object instanceof Payment) && this.id == ((Payment) object).getId();
    }

    @Override
    public String toString() {
        return " id=" + id + " ]";
    }
}
