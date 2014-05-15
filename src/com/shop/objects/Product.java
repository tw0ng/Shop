package com.shop.objects;

import java.util.ArrayList;

import android.util.Log;

public class Product {
	private String name;
	private String description;
	private ArrayList<String> urls;
	private String category;

	public Product(String name, String description, ArrayList<String> urls, String category) {
		this.urls = new ArrayList<String>();
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
			for(String i:urls) {
				this.urls.add(i);
			}
		
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

	public ArrayList<String> getUrls() {
		return urls;
	}

	public String getCategory() {
		return category;
	}

}
