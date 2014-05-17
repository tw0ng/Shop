package com.shop.objects;

import java.util.ArrayList;

import android.util.Log;

public class Product {
	private String name;
	private String description;
	private ArrayList<String> urls;
	private String category;
	private int quantity;
	public Product(String name, String description, ArrayList<String> urls, String category, int quantity) {
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

		this.quantity = quantity;
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

	public int getQuantity() {
		return quantity;
	}

	public void updateQuantity(int quantity) {
		this.quantity += quantity;
	}

	@Override
	public boolean equals(Object o) {

		if(!(o instanceof Product))
			return false;
		if(!this.name.equals(((Product) o).getName()))
			return false;

		return true;

	}
}
