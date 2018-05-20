package es.cesfuencarral.fuenflixapi.controller.request;

import es.cesfuencarral.fuenflixapi.persistence.entity.Content;
import es.cesfuencarral.fuenflixapi.persistence.entity.User;

public class BuyRequest {

	private User user;
	private Content content;
	private double rate;

	public BuyRequest() {

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

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}
