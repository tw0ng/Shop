package com.shop.fragments;


import com.example.shop.R;
import com.nostra13.universalimageloader.core.ImageLoader;
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
import android.widget.ImageView;
import android.widget.TextView;

public class AboutFragment extends Fragment{
	String imageUrl = "http://www.akbadminton.com/wp-content/uploads/2014/03/ak-270x270.jpg";
	public AboutFragment() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static AboutFragment newInstance() {
		AboutFragment fragment = new AboutFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_about, container,
				false);
		ImageView aboutpic = (ImageView) rootView.findViewById(R.id.about_pic);
		ImageLoader.getInstance().displayImage(imageUrl, aboutpic);
		TextView textView = (TextView) rootView
				.findViewById(R.id.section_label);
		textView.setText(Html.fromHtml("<h4>Alan Kakinami</h4><h5>janitor, painter and WORLD CLASS Stringer at AKBadminton & Tennis</h5><p>Alan Kakinami started stringing in 1995, and by 2000 he started to refine his skills as a stringer. By 2001 he was stringing at the US Nationals and US Opens for badminton. By 2003 He became official stringer at Siebel Open, now SAP Open, and Bank of the West Classic, the professional tennis tournaments in the Bay Area. In 2005 he was asked to string at the 2005 Badminton World Championships and 2009 became Official stringer for Pan American Games for badminton. Over the years AK has become synonymous with QUALITY stringing.</p><p><strong>Tournaments:</strong><br />Badminton:<br />2012 London Olympic Games<br />2012 All England Badminton Championships<br />2005,2011 World Badminton Championships<br />2011 Pan American Games<br />2009-2010 Pan American Badminton Championships<br />2010 Jr World Badminton Championships<br />2000-2012 US Open Badminton Championships<br />1999-2012 US National Badminton Championships</p><p>Tennis:<br />2003 Siebel Open<br />2004-2007 SAP Open<br />2009-2010<br />2003-2009 Bank of the West Classic</p><p><strong>Players Strung:</strong><br />Badminton:<br />Taufik Hidayat 2004 Olympic Gold Medalist, 2005 World Champion<br />Lin Dan 2008 Olympic Gold Medalist, 2006 World Champion<br />Tony Gunawan 2000 Olympic gold Medalist, 2001/2005 World Champion<br />Halim Haryanto 2001 World Doubles Champion<br />Jonas Rasmussen 2003 World Doubles Champion</p><p>Tennis:<br />Marty Fish 2004 Olympic Silver Medalist<br />Venus Williams 2000, 2008, 2012 Olympic Gold Medalist<br />Serena Williams 2000, 2008, 2012 Olympic Gold Medalist<br />Andy Murray 2006-2007 SAP Open Champion<br />Frenando Verdasco 2010 SAP Open Champion</p>"));
				return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(3);
	}
}