package com.shop.fragments;


import java.util.ArrayList;

import com.example.shop.R;
import com.shop.MainActivity;
import com.shop.Singleton;
import com.shop.adapters.CartAdapter;
import com.shop.adapters.ProductAdapter;
import com.shop.objects.Product;
import com.shop.util.Util;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ShoppingCartFragment extends Fragment{
	private ArrayList<Product> shoppingcart;
	View rootView;
	ListView cartContainer;
	CartAdapter cartadapter;
	public ShoppingCartFragment() {
		// TODO Auto-generated constructor stub
		shoppingcart = Singleton.INSTANCE.getShoppingCart();
	}

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static ShoppingCartFragment newInstance() {
		ShoppingCartFragment fragment = new ShoppingCartFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = (View) inflater.inflate(R.layout.fragment_shoppingcart, container,
				false);
		cartContainer = (ListView) rootView.findViewById(R.id.cart_container);
		Button checkout = (Button) rootView.findViewById(R.id.checkout);
		checkout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		cartadapter = new CartAdapter(getActivity().getApplicationContext(),R.layout.fragment_shoppingcart, shoppingcart);

		cartContainer.setAdapter(cartadapter);
		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(200);
	}
		
}