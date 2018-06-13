package es.cesfuencarral.fuenflixapi.controller.request;

public class ContentFilterRequest {

	private long contentType;
	private String user;

	public ContentFilterRequest() {

	}

	public ContentFilterRequest(long contentType, String user) {
		this.contentType = contentType;
		this.user = user;
	}

	public long getContentType() {
		return contentType;
	}

	public void setContentType(long contentType) {
		this.contentType = contentType;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
