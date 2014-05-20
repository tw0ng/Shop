package com.shop;

import java.util.ArrayList;

import android.app.Fragment;
import android.util.Log;

import com.shop.objects.Product;

public enum Singleton {
	INSTANCE;

	private ArrayList<Product> rackets = new ArrayList<Product>();
	private ArrayList<Product> bags = new ArrayList<Product>();
	private ArrayList<Product> shoes = new ArrayList<Product>();
	private ArrayList<Product> apparel = new ArrayList<Product>();
	private ArrayList<Product> shoppingcart = new ArrayList<Product>();
	private ArrayList<Product> compare = new ArrayList<Product>();
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

	public void addToCart(Product product) {
		if(!shoppingcart.contains(product) && product.getQuantity() != 0) {
			shoppingcart.add(product);
		}
		else if(product.getQuantity() != 0){
			shoppingcart.get(shoppingcart.indexOf(product)).updateQuantity(product.getQuantity());
		}
	}

	public void removeFromCart(Product product) {
		Log.d("Product removed was" , product.getName());
		if(shoppingcart.contains(product))
			shoppingcart.remove(shoppingcart.indexOf(product));
	}

	public Product getProductFromCart(Product product) {
		if(shoppingcart.contains(product)) {
			return shoppingcart.get(shoppingcart.indexOf(product));
		}
		else {
			return new Product(null, null, null, null, 0);
		}
	}
	public ArrayList<Product> getShoppingCart() {
		return shoppingcart;
	}

	public ArrayList<Product> getCompareList() {
		return compare;
	}

	public void removeFromList(int position) {
		compare.remove(position);
	}

	public void addToList(Product product) {
		if(!compare.contains(product)) {
			compare.add(product);
		}
	}
}
