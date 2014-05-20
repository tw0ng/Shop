package com.shop.fragments;


import java.util.ArrayList;

import com.example.shop.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.shop.MainActivity;
import com.shop.Singleton;
import com.shop.adapters.CartAdapter;
import com.shop.adapters.ProductAdapter;
import com.shop.objects.Product;
import com.shop.util.Util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CompareFragment extends Fragment{
	private ArrayList<Product> compareList;

	public CompareFragment() {
		// TODO Auto-generated constructor stub
		compareList = Singleton.INSTANCE.getCompareList();
	}

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static CompareFragment newInstance() {
		CompareFragment fragment = new CompareFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_compare, container,
				false);
		LinearLayout containerView = (LinearLayout) rootView.findViewById(R.id.container);
		for(int i = 0; i < compareList.size(); i++) {
			LinearLayout view = (LinearLayout) inflater.inflate(R.layout.product_item, null);

			LinearLayout.LayoutParams settings = new LinearLayout.LayoutParams(Util.getActivityWidth(getActivity())/Util.getNumCols(getActivity()), ListView.LayoutParams.WRAP_CONTENT);
			view.setLayoutParams(settings);
			Product item = compareList.get(i);
			// My layout has only one TextView
			ImageView productImage = (ImageView) view.findViewById(R.id.product_pic);
			TextView productDesc = (TextView) view.findViewById(R.id.item);
			if(item.getUrls() != null && item.getUrls().size() != 0)
				ImageLoader.getInstance().displayImage(item.getUrls().get(0), productImage);

			productDesc.setText(item.getName());
			view.setOnTouchListener(new OnTouchListener() {

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					drag(event, v);
					return false;
				}
			});
			containerView.addView(view);
		}

		return rootView;
	}
	public void drag(MotionEvent event, View v)
	{

		LinearLayout.LayoutParams params = (android.widget.LinearLayout.LayoutParams) v.getLayoutParams();

		switch(event.getAction())
		{
		case MotionEvent.ACTION_MOVE:
		{
			params.topMargin = (int)event.getRawY() - (v.getHeight());
			params.leftMargin = (int)event.getRawX() - (v.getWidth()/2);
			v.setLayoutParams(params);
			break;
		}
		case MotionEvent.ACTION_UP:
		{
			params.topMargin = (int)event.getRawY() - (v.getHeight());
			params.leftMargin = (int)event.getRawX() - (v.getWidth()/2);
			v.setLayoutParams(params);
			break;
		}
		case MotionEvent.ACTION_DOWN:
		{
			v.setLayoutParams(params);
			break;
		}
		}
	}
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(105);
	}

}