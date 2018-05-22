package es.cesfuencarral.fuenflixapi.controller.request;

public class ContentFilterRequest {

	private long contentType;
	private long user;

	public ContentFilterRequest() {

	}

	public ContentFilterRequest(long contentType, long user) {
		this.contentType = contentType;
		this.user = user;
	}

	public long getContentType() {
		return contentType;
	}

	public void setContentType(long contentType) {
		this.contentType = contentType;
	}

	public long getUser() {
		return user;
	}

	public void setUser(long user) {
		this.user = user;
	}

}
