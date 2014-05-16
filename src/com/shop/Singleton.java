package com.shop;

import java.util.ArrayList;

import com.shop.objects.Product;

public enum Singleton {
	INSTANCE;

	private ArrayList<Product> rackets = new ArrayList<Product>();
	private ArrayList<Product> bags = new ArrayList<Product>();
	private ArrayList<Product> shoes = new ArrayList<Product>();
	private ArrayList<Product> apparel = new ArrayList<Product>();

	public void setRackets(ArrayList<Product> rackets) {
		this.rackets = rackets;
	}

	public ArrayList<Product> getRackets() {
		return rackets;
	}

	public void setBags(ArrayList<Product> bags) {
		this.bags = bags;
	}

	public ArrayList<Product> getBags() {
		return bags;
	}
	public void setShoes(ArrayList<Product> bags) {
		this.shoes = shoes;
	}

	public ArrayList<Product> getShoes() {
		return shoes;
	}
	public void setApparel(ArrayList<Product> bags) {
		this.apparel = apparel;
	}

	public ArrayList<Product> getApparel() {
		return apparel;
	}

}
