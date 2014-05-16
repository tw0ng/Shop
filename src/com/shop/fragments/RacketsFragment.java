package com.shop.fragments;


import java.util.ArrayList;

import com.example.shop.R;
import com.shop.MainActivity;
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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class RacketsFragment extends Fragment{
	ArrayList<Product> rackets;
	public RacketsFragment() {
		// TODO Auto-generated constructor stub
		rackets = new ArrayList<Product>();
		ArrayList<String> urls = new ArrayList<String>();
		urls.add("http://www.akbadminton.com/wp-content/uploads/2014/05/NR700FX_1.jpg");
		urls.add("http://www.akbadminton.com/wp-content/uploads/2014/05/NR700FX_2.jpg");
		urls.add("http://www.akbadminton.com/wp-content/uploads/2014/05/NR700FX_3.jpg");
		rackets.add(new Product("NANORAY 700FX", "NANORAY’s revolutionary frame design with TOUGHLEX for flexible, all-round attack and defence play.",urls,null));
		urls = new ArrayList<String>();
		urls.add("http://www.akbadminton.com/wp-content/uploads/2014/05/NR800_1.jpg");
		urls.add("http://www.akbadminton.com/wp-content/uploads/2014/05/NR800_2.jpg");
		urls.add("http://www.akbadminton.com/wp-content/uploads/2014/05/NR800_3.jpg");
		rackets.add(new Product("NANORAY 800", "X-FULLERINE combined with SONIC METAL produces a fast and controlled swing that generates powerfully accurate, rapid-fire shots.",urls,null));
		urls = new ArrayList<String>();
		urls.add("http://www.akbadminton.com/wp-content/uploads/2014/05/NR-ZSP_1-1.jpg");
		urls.add("http://www.akbadminton.com/wp-content/uploads/2014/05/NR-ZSP_2.jpg");
		urls.add("http://www.akbadminton.com/wp-content/uploads/2014/05/NR-ZSP_3.jpg");
		rackets.add(new Product("NANORAY Z-SPEED", "The world’s fastest racquet.",urls,null));
	}

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static RacketsFragment newInstance() {
		RacketsFragment fragment = new RacketsFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ListView rootView = (ListView) inflater.inflate(R.layout.fragment_rackets, container,
				false);
		ProductAdapter racketadapter = new ProductAdapter(getActivity().getApplicationContext(),R.layout.fragment_rackets, rackets);
        rootView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Log.d("The position for racquets is","The position is "+ position + " There is a racquet? " + rackets.get(position).getName());
				getFragmentManager().beginTransaction().replace(R.id.container, ProductFragment.newInstance(rackets.get(position))).commit();
			}
        	
        });
		rootView.setAdapter(racketadapter);
		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(100);
	}
}