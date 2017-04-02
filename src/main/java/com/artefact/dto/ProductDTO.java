package com.artefact.dto;


public class ProductDTO {
	
	/**
	 * 
	 */
	private int id;
	private String image;
	private int category;
	private int priority;
	private String text;
	private String ebayLink;
	private String amazonLink;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
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
	public ProductDTO(int id, String image, int category, int priority, String text, String ebayLink,
			String amazonLink) {
		super();
		this.id = id;
		this.image = image;
		this.category = category;
		this.priority = priority;
		this.text = text;
		this.ebayLink = ebayLink;
		this.amazonLink = amazonLink;
	}
	
	
	
}
