package es.cesfuencarral.fuenflixapi.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
//@NamedQueries({
//        @NamedQuery(name = "Area.findByValidity", query = "SELECT a FROM Area a WHERE a.validFrom <= :date AND (a.validTill IS NULL OR a.validTill > :date)")
//})
public class User implements Serializable {

    /*Fields*/
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String username;
    private String password;
    private String email;
    private String address;




    @Column(name = "birth_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    @JoinColumn(name = "profile", referencedColumnName = "id")
    @ManyToOne
    private Profile profile;

    @JoinColumn(name = "payment_account", referencedColumnName = "id")
    @ManyToOne
    private PaymentAccount paymentAccount;

    /*Constructors*/
    public User() {}

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    @Override
    public boolean equals(Object object) {
        return (object instanceof User) && this.id == ((User) object).getId();
    }

    @Override
    public String toString() {
        return " id=" + id + " ]";
    }
}
