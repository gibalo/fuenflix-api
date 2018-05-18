package es.cesfuencarral.fuenflixapi.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "payment_account")
//@NamedQueries({
//        @NamedQuery(name = "Area.findByValidity", query = "SELECT a FROM Area a WHERE a.validFrom <= :date AND (a.validTill IS NULL OR a.validTill > :date)")
//})
public class PaymentAccount implements Serializable {

    /*Fields*/
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String iban;


    /*Constructors*/
    public PaymentAccount() {}

    /*Getters & setters*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public boolean equals(Object object) {
        return (object instanceof PaymentAccount) && this.id == ((PaymentAccount) object).getId();
    }

    @Override
    public String toString() {
        return " id=" + id + " ]";
    }
}
