package com.shop.fragments;


import com.example.shop.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.shop.MainActivity;
import com.shop.objects.Product;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductFragment extends Fragment{
	private Product product;
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
		View rootView = inflater.inflate(R.layout.fragment_product, container,
				false);

		Log.d("The product exists?" , "There is a product" + product.getName());
		TextView header = (TextView) rootView.findViewById(R.id.product_header);
				header.setText(product.getName());

		ImageView productImage = (ImageView) rootView.findViewById(R.id.product_pic);
			    ImageLoader.getInstance().displayImage(product.getUrls().get(0), productImage);
		TextView description = (TextView) rootView.findViewById(R.id.product_description);
				description.setText(product.getDescription());
		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(100);
	}
}