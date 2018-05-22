package es.cesfuencarral.fuenflixapi.controller.response;

import es.cesfuencarral.fuenflixapi.persistence.entity.Content;
import es.cesfuencarral.fuenflixapi.persistence.entity.ContentType;

public class ContentResponse {

	private long id;
	private String name;
	private String description;
	private double price;
	private String path;
	private String imagePath;
	private long contentType;
	private String contentTypeName;

	public ContentResponse() {
	}

	public ContentResponse(Content entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
		this.path = entity.getPath();
		this.imagePath = entity.getImagePath();
		this.contentType = entity.getContentType().getId();
		this.contentTypeName = entity.getContentType().getName();
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

	public long getContentType() {
		return contentType;
	}

	public void setContentType(long contentType) {
		this.contentType = contentType;
	}

	public String getContentTypeName() {
		return contentTypeName;
	}

	public void setContentTypeName(String contentTypeName) {
		this.contentTypeName = contentTypeName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
