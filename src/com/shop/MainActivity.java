package com.shop;

import com.example.shop.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.shop.fragments.AboutFragment;
import com.shop.fragments.ApparelFragment;
import com.shop.fragments.BagsFragment;
import com.shop.fragments.ContactFragment;
import com.shop.fragments.HomeFragment;
import com.shop.fragments.NavigationDrawerFragment;
import com.shop.fragments.RacketsFragment;
import com.shop.fragments.ShoesFragment;
import com.shop.fragments.StringingServicesFragment;
import com.shop.util.Util;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements
NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		DisplayImageOptions displayopts = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).build();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).memoryCacheExtraOptions(Util.getActivityWidth(this) * 5, Util.getActivityHeight(this) * 5).defaultDisplayImageOptions(displayopts).build();
		ImageLoader.getInstance().init(config);
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getSupportFragmentManager();
		Log.d("Item Clicked", "The position is " + position);
		switch (position) {
		case 0:
			fragmentManager.beginTransaction().replace(R.id.container, HomeFragment.newInstance(position + 1)).commit();
			break;
		case 2:
			fragmentManager.beginTransaction().replace(R.id.container, StringingServicesFragment.newInstance()).commit();
			break;
		case 3:
			fragmentManager.beginTransaction().replace(R.id.container, AboutFragment.newInstance()).commit();
			break;
		case 4:
			fragmentManager.beginTransaction().replace(R.id.container, ContactFragment.newInstance(position + 1)).commit();
			break;
		case 100:
			fragmentManager.beginTransaction().replace(R.id.container, RacketsFragment.newInstance()).commit();
			break;
		case 101:
			fragmentManager.beginTransaction().replace(R.id.container, BagsFragment.newInstance(position + 1)).commit();
			break;
		case 102:
			fragmentManager.beginTransaction().replace(R.id.container, ShoesFragment.newInstance(position + 1)).commit();
			break;
		case 103:
			fragmentManager.beginTransaction().replace(R.id.container, ApparelFragment.newInstance(position + 1)).commit();
			break;

		}

	}

	public void onSectionAttached(int number) {
		Log.d("The Section is", "The section is " + number);
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		case 4:
			mTitle = getString(R.string.title_section4);
			break;
		case 100:
			mTitle = getString(R.string.child_title_section1);
			break;
		case 101:
			mTitle = getString(R.string.child_title_section2);
			break;
		case 102:
			mTitle = getString(R.string.child_title_section3);
			break;
		case 103:
			mTitle = getString(R.string.child_title_section4);
			break;

		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */

}
