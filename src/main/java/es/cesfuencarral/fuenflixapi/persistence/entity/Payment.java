package es.cesfuencarral.fuenflixapi.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "payment")

public class Payment implements Serializable {

	/* Fields */
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

	/* Constructors */
	public Payment() {
	}

	
	public Payment(double rate, Date buyingDate, User user, Content content) {
		this.rate = rate;
		this.buyingDate = buyingDate;
		this.user = user;
		this.content = content;
	}


	/* Getters & setters */

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
