package com.shop.fragments;


import com.example.shop.R;
import com.shop.MainActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class StringingServicesFragment extends Fragment{
	public StringingServicesFragment() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static StringingServicesFragment newInstance() {
		StringingServicesFragment fragment = new StringingServicesFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_stringingservices, container,
				false);
		TextView textView = (TextView) rootView
				.findViewById(R.id.section_label);
		textView.setText(Html.fromHtml("<h3>Strings are often the most overlooked component of the game. Having the right string &amp; tension for your racket and style of play can significantly change your game. Need advice finding the right setup for you? Contact us or visit our shop for and we’d be happy to give you a free personalized consultation.</h3>"));
		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(2);
	}
}