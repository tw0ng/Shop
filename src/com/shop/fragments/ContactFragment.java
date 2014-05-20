package com.shop.fragments;


import com.example.shop.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.shop.MainActivity;
import com.shop.util.Util;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

public class ContactFragment extends Fragment{
	private GoogleMap map;
	private SupportMapFragment mapFrag;
	private FragmentActivity context;
	static final LatLng SHOP = new LatLng(37.5208218,-122.0399597);
	public ContactFragment() {
		// TODO Auto-generated constructor stub

	}

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static ContactFragment newInstance() {
		ContactFragment fragment = new ContactFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_contact, container,
				false);
		mapFrag = (SupportMapFragment) context.getSupportFragmentManager().findFragmentById(R.id.map);

		map = mapFrag.getMap();
		ViewGroup.LayoutParams params = mapFrag.getView().getLayoutParams();
		params.height = Util.getActivityWidth(context);
		Log.d("what is height and width", "The measures are " + params.width + " " + params.height);
		mapFrag.getView().setLayoutParams(params);

		if(map!=null) {

			Marker shop = map.addMarker(new MarkerOptions().position(SHOP));
			shop.setTitle("AKBADMINTON");
			shop.showInfoWindow();
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(SHOP, 15));
			map.setOnMapClickListener(new OnMapClickListener() {

				@Override
				public void onMapClick(LatLng arg0) {
					String url = "http://maps.google.com/maps?daddr=37800 Central Ct Newark, CA 94560";
					Intent intent = new Intent(android.content.Intent.ACTION_VIEW,  Uri.parse(url));
					startActivity(intent);
				}

			});

		}

		return rootView;
	}
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		SupportMapFragment f = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map);
		if(f.isResumed()) {
			getFragmentManager().beginTransaction().remove(f).commit();
		}
	}
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		context = (FragmentActivity) activity;
		((MainActivity) activity).onSectionAttached(4);
	}
}