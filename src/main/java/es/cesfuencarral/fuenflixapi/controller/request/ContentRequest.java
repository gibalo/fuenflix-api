package es.cesfuencarral.fuenflixapi.controller.request;

public class ContentRequest {
	/* Fields */
	private String name;
	private String description;
	private long contentType;
	//private double price;
	private String path;
	private String imagePath;

	/* Constructor */
	public ContentRequest() {
	}
	

	/* Getters & Setters */
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

	public long getContentType() {
		return contentType;
	}

	public void setContentType(long contentType) {
		this.contentType = contentType;
	}

	/*public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}*/

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

	/* toString */
	@Override
	public String toString() {
		return "ContentRequest [name=" + name + ", description=" + description + ", contentType=" + contentType
				+ ", price=" + ", path=" + path + ", imagePath=" + imagePath + "]";
	}
}
