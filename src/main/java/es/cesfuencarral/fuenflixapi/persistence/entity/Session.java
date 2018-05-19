package es.cesfuencarral.fuenflixapi.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "session")

public class Session implements Serializable {

	/* Fields */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String token;

	@Temporal(TemporalType.TIMESTAMP)
	private Date open;

	@Temporal(TemporalType.TIMESTAMP)
	private Date close;

	private boolean disconnect;

	@JoinColumn(name = "user", referencedColumnName = "id")
	@ManyToOne
	private User user;

	/* Constructors */
	public Session() {
	}

	/* Getters & setters */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getOpen() {
		return open;
	}

	public void setOpen(Date open) {
		this.open = open;
	}

	public Date getClose() {
		return close;
	}

	public void setClose(Date close) {
		this.close = close;
	}

	public boolean isDisconnect() {
		return disconnect;
	}

	public void setDisconnect(boolean disconnect) {
		this.disconnect = disconnect;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public boolean equals(Object object) {
		return (object instanceof Session) && this.id == ((Session) object).getId();
	}

	@Override
	public String toString() {
		return " id=" + id + " ]";
	}
}
