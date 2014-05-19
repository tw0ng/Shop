package com.shop.fragments;


import java.util.ArrayList;

import com.example.shop.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.shop.MainActivity;
import com.shop.Singleton;
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
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class RacketsFragment extends Fragment{
	private ArrayList<Product> rackets;
	public RacketsFragment() {
		// TODO Auto-generated constructor stub
		rackets = Singleton.INSTANCE.getRackets();
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
		ScrollView rootView = (ScrollView) inflater.inflate(R.layout.fragment_rackets, container,
				false);
		int cols = Util.getNumCols(getActivity().getApplicationContext());
		LinearLayout col1 = (LinearLayout) rootView.findViewById(R.id.col1);
		LinearLayout col2 = (LinearLayout) rootView.findViewById(R.id.col2);
		LinearLayout col3 = (LinearLayout) rootView.findViewById(R.id.col3);
		LinearLayout col4 = (LinearLayout) rootView.findViewById(R.id.col4);
		int currentCol = 0;
		if(cols == 1) {
			col1.setVisibility(View.VISIBLE);
			LayoutParams lp = (LayoutParams) col1.getLayoutParams();
			lp.width = LayoutParams.FILL_PARENT;
			col1.setLayoutParams(lp);
			col2.setVisibility(View.GONE);
			col3.setVisibility(View.GONE);
			col4.setVisibility(View.GONE);
		}
		else if(cols == 2) {
			col1.setVisibility(View.VISIBLE);
			LayoutParams lp = (LayoutParams) col1.getLayoutParams();
			lp.width = Util.getActivityWidth(getActivity())/cols;
			col1.setLayoutParams(lp);
			col2.setVisibility(View.VISIBLE);
			col2.setLayoutParams(lp);
			col3.setVisibility(View.GONE);
			col4.setVisibility(View.GONE);
		}
		else if(cols == 3) {
			col1.setVisibility(View.VISIBLE);
			LayoutParams lp = (LayoutParams) col1.getLayoutParams();
			lp.width = Util.getActivityWidth(getActivity())/cols;
			col1.setLayoutParams(lp);
			col2.setVisibility(View.VISIBLE);
			col2.setLayoutParams(lp);
			col3.setVisibility(View.VISIBLE);
			col3.setLayoutParams(lp);
			col4.setVisibility(View.GONE);
		}
		else {
			col1.setVisibility(View.VISIBLE);
			LayoutParams lp = (LayoutParams) col1.getLayoutParams();
			lp.width = Util.getActivityWidth(getActivity())/cols;
			col1.setLayoutParams(lp);
			col2.setVisibility(View.VISIBLE);
			col2.setLayoutParams(lp);
			col3.setVisibility(View.VISIBLE);
			col3.setLayoutParams(lp);
			col4.setVisibility(View.VISIBLE);
			col4.setLayoutParams(lp);
		}

		for(int i = 0; i < rackets.size(); i++) {
			final Product currentProduct = rackets.get(i);
			View product = inflater.inflate(R.layout.product_item, null);
			ImageView productImage = (ImageView) product.findViewById(R.id.product_pic);
			TextView productDesc = (TextView) product.findViewById(R.id.item);
			if(rackets.get(i).getUrls() != null && rackets.get(i).getUrls().size() != 0)
				ImageLoader.getInstance().displayImage(rackets.get(i).getUrls().get(0), productImage);

			productDesc.setText(rackets.get(i).getName());
			product.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					getFragmentManager().beginTransaction().replace(R.id.container, ProductFragment.newInstance(currentProduct)).addToBackStack(null).commit();
				}
			});

			if(currentCol == 0) {
				col1.addView(product);
			}
			else if(currentCol == 1) {
				col2.addView(product);
			}
			else if(currentCol == 2) {
				col3.addView(product);
			}
			else if(currentCol == 3) {
				col4.addView(product);
			}

			currentCol++;
			if(currentCol >= cols) {
				currentCol = 0;
			}
		}

		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(100);
	}

}