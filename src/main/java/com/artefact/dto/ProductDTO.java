package com.artefact.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4549558961242196961L;
	private String image;
	private String text;
	private String ebayLink;
	private String amazonLink;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getEbayLink() {
		return ebayLink;
	}
	public void setEbayLink(String ebayLink) {
		this.ebayLink = ebayLink;
	}
	public String getAmazonLink() {
		return amazonLink;
	}
	public void setAmazonLink(String amazonLink) {
		this.amazonLink = amazonLink;
	}
	public ProductDTO(String image, String text, String ebayLink, String amazonLink) {
		super();
		this.image = image;
		this.text = text;
		this.ebayLink = ebayLink;
		this.amazonLink = amazonLink;
	}
	
}
