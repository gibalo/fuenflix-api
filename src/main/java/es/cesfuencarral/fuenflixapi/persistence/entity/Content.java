package es.cesfuencarral.fuenflixapi.persistence.entity;

import javax.persistence.*;

import es.cesfuencarral.fuenflixapi.controller.request.ContentRequest;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "content")
@NamedQueries({
		@NamedQuery(name = "Content.findByFilter", query = "SELECT c FROM Content c WHERE c.contentType = :contentType")
		//,@NamedQuery(name = "Content.findByUserContent", query = "SELECT c FROM Content c JOIN User u ON c.user.id = :user WHERE c.id IN (SELECT u.contents FROM User u WHERE u.user = :user)")
		,@NamedQuery(name = "Content.findByContentType",query = "SELECT c FROM Content c WHERE c.contentType.id = :contentType")
		,@NamedQuery(name = "Content.findByIdList",query = "SELECT c FROM Content c WHERE c.id IN :idList")
})
public class Content implements Serializable {

	/* Fields */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String description;

	private double price;
	private String path;

	@Column(name = "image_path")
	private String imagePath;

	@JoinColumn(name = "content_type", referencedColumnName = "id")
	@ManyToOne
	private ContentType contentType;
	
	@ManyToMany(mappedBy = "contents")
	private Set<User> users;

	/* Constructors */
	public Content() {
	}
	


	/* Getters & setters */

	public Content(ContentType contentType, ContentRequest request) {
		this.contentType = contentType;
		this.name = request.getName();
		this.description = request.getDescription();
		this.price = request.getPrice();
		this.path = request.getPath();
		this.imagePath = request.getImagePath();
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public ContentType getContentType() {
		return contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}
	
	

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	/* others */
	@Override
	public boolean equals(Object object) {
		return (object instanceof Content) && this.id == ((Content) object).getId();
	}

	@Override
	public String toString() {
		return " id=" + id + " ]";
	}

	public void update(ContentType contentType, ContentRequest request) {
		this.contentType = contentType;
		this.name = request.getName();
		this.description = request.getDescription();
		this.price = request.getPrice();
		this.path = request.getPath();
		this.imagePath = request.getImagePath();

	}
}
