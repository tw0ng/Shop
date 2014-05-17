package com.shop.fragments;


import com.example.shop.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.shop.MainActivity;
import com.shop.Singleton;
import com.shop.objects.Product;
import com.shop.util.Util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.widget.TextView;

public class ProductFragment extends Fragment{
	private Product product;
	private PopupWindow addtocartwindow;
	private Button addToCart;
	private View rootView;
	NumberPicker quantity;
	public ProductFragment() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static ProductFragment newInstance(Product product) {
		ProductFragment fragment = new ProductFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		fragment.product = product;
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_product, container,
				false);

		TextView header = (TextView) rootView.findViewById(R.id.product_header);
		header.setText(product.getName());

		ImageView productImage = (ImageView) rootView.findViewById(R.id.product_pic);
		ImageLoader.getInstance().displayImage(product.getUrls().get(0), productImage);
		TextView description = (TextView) rootView.findViewById(R.id.product_description);
		description.setText(product.getDescription());
		View layoutAddToCart = inflater.inflate(R.layout.fragment_addtocart, null);

		layoutAddToCart.setBackgroundColor(Color.WHITE);
		addToCart = (Button) rootView.findViewById(R.id.add_to_cart);
		addToCart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rootView.setAlpha((float) .1);
				addtocartwindow.showAtLocation(rootView, android.view.Gravity.CENTER, 0, 0);
			}
		});



		TextView productname = (TextView) layoutAddToCart.findViewById(R.id.product_header);
		productname.setText(product.getName());

		quantity = (NumberPicker) layoutAddToCart.findViewById(R.id.quantity);
		quantity.setMaxValue(20);
		quantity.setMinValue(0);
		String[] nums = new String[21];
		for(int i = 0; i < nums.length; i++)
			nums[i] = Integer.toString(i);
		quantity.setDisplayedValues(nums);
		quantity.setWrapSelectorWheel(false);
		Button insideAddToCart = (Button) layoutAddToCart.findViewById(R.id.add_to_cart);

		insideAddToCart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rootView.setAlpha((float) 1);
					Singleton.INSTANCE.addToCart(new Product(product.getName(),product.getDescription(),product.getUrls(),product.getCategory(),quantity.getValue()));
				addtocartwindow.dismiss();
			}
		});

		Button cancel = (Button) layoutAddToCart.findViewById(R.id.close);
		cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rootView.setAlpha((float) 1);
				addtocartwindow.dismiss();
			}
		});
		addtocartwindow = new PopupWindow(layoutAddToCart, LayoutParams.FILL_PARENT,Util.getActivityWidth(getActivity()));
		addtocartwindow.setContentView(layoutAddToCart);
		addtocartwindow.setFocusable(true);
		addtocartwindow.setOutsideTouchable(false);

		return rootView;
	}


	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(100);
	}
}