package es.cesfuencarral.fuenflixapi.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "content")
// @NamedQueries({
// @NamedQuery(name = ".", query = "")
// })
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

	/* Constructors */
	public Content() {
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

	/* others */
	@Override
	public boolean equals(Object object) {
		return (object instanceof Content) && this.id == ((Content) object).getId();
	}

	@Override
	public String toString() {
		return " id=" + id + " ]";
	}
}
