package com.shop.fragments;


import java.util.ArrayList;

import com.example.shop.R;
import com.shop.MainActivity;
import com.shop.Singleton;
import com.shop.adapters.ProductAdapter;
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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class BagsFragment extends Fragment{
	private ArrayList<Product> bags;
	public BagsFragment() {
		// TODO Auto-generated constructor stub
		bags = Singleton.INSTANCE.getBags();
	}

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static BagsFragment newInstance() {
		BagsFragment fragment = new BagsFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ListView rootView = (ListView) inflater.inflate(R.layout.fragment_bags, container,
				false);
		ProductAdapter bagsadapter = new ProductAdapter(getActivity().getApplicationContext(),R.layout.fragment_bags, bags);
        rootView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Log.d("The position for racquets is","The position is "+ position + " There is a racquet? " + bags.get(position).getName());
				getFragmentManager().beginTransaction().replace(R.id.container, ProductFragment.newInstance(bags.get(position))).addToBackStack(null).commit();
			}
        	
        });
		rootView.setAdapter(bagsadapter);
		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(
				101);
	}
}