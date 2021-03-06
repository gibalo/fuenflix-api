package es.cesfuencarral.fuenflixapi.persistence.entity;

import javax.persistence.*;

import es.cesfuencarral.fuenflixapi.controller.request.UserRequest;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user")
@NamedQueries({
	@NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
	@NamedQuery(name = "User.findContentsById", query = "SELECT c FROM User u JOIN u.contents c WHERE u.id = :id")

	})
public class User implements Serializable {

	/* Fields */
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
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "payment", joinColumns = @JoinColumn(name = "user", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "content", referencedColumnName = "id"))
	private Set<Content> contents;

	/* Constructors */
	public User() {
	}

	
	public User(UserRequest entity) {

		this.name = entity.getName();
		this.username = entity.getUsername();
		this.password = entity.getPassword();
		this.email = entity.getEmail();
		this.address = entity.getAddress();
		this.birthDate = new Date();
		this.profile = null;
		this.paymentAccount = null;
		this.contents = null;
	}



	/* Getters & setters */

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

	
	public Set<Content> getContents() {
		return contents;
	}

	public void setContents(Set<Content> contents) {
		this.contents = contents;
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
