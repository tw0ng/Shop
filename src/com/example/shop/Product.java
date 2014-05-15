package com.example.shop;

public class Product {
	private String name;
	private String description;
	private String urls;
	private String category;
	
	public Product(String name, String description, String urls, String category) {
		if(name != null)
			this.name = name;
		else {
			this.name = "";
		}
		if(description != null)
			this.description = description;
		else
			this.description = "";

		if(urls != null)
			this.urls = urls;
		else
			this.urls = "";
		if(category != null)
			this.category = category;
		else
			this.category = "";
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getUrls() {
		return urls;
	}
	
	public String getCategory() {
		return category;
	}

}
