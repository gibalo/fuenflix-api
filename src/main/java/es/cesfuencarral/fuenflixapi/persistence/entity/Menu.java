package es.cesfuencarral.fuenflixapi.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "menu")

public class Menu implements Serializable {

	/* Fields */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private int code;

	@JoinColumn(name = "profile", referencedColumnName = "id")
	@ManyToOne
	private Profile profile;

	/* Constructors */
	public Menu() {
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

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public boolean equals(Object object) {
		return (object instanceof Menu) && this.id == ((Menu) object).getId();
	}

	@Override
	public String toString() {
		return " id=" + id + " ]";
	}
}
