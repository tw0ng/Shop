package com.shop;

import java.util.ArrayList;

import com.example.shop.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.shop.fragments.AboutFragment;
import com.shop.fragments.ApparelFragment;
import com.shop.fragments.BagsFragment;
import com.shop.fragments.CompareFragment;
import com.shop.fragments.ContactFragment;
import com.shop.fragments.HomeFragment;
import com.shop.fragments.NavigationDrawerFragment;
import com.shop.fragments.RacketsFragment;
import com.shop.fragments.ShoesFragment;
import com.shop.fragments.ShoppingCartFragment;
import com.shop.fragments.StringingServicesFragment;
import com.shop.objects.Product;
import com.shop.util.Util;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.ClipData.Item;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
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
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		FragmentManager fragmentManager = getSupportFragmentManager();
		if(fragmentManager.getBackStackEntryCount() == 0) {
			DisplayImageOptions displayopts = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).build();
			ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).memoryCacheExtraOptions(Util.getActivityWidth(this) * 5, Util.getActivityHeight(this) * 5).defaultDisplayImageOptions(displayopts).build();
			ImageLoader.getInstance().init(config);
			setupData();
		}
		else {
           fragmentManager.popBackStackImmediate();
		}
	}



	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getSupportFragmentManager();

		switch (position) {
		case 0:
			if(fragmentManager.findFragmentByTag("HOME") == null || !fragmentManager.findFragmentByTag("HOME").isVisible())
				fragmentManager.beginTransaction().replace(R.id.container, HomeFragment.newInstance(position + 1), "HOME").addToBackStack(null).commit();
			break;
		case 2:
			if(fragmentManager.findFragmentByTag("STRINGING") == null || !fragmentManager.findFragmentByTag("STRINGING").isVisible())
				fragmentManager.beginTransaction().replace(R.id.container, StringingServicesFragment.newInstance(),"STRINGING").addToBackStack(null).commit();
			break;
		case 3:
			if(fragmentManager.findFragmentByTag("ABOUT") == null || !fragmentManager.findFragmentByTag("ABOUT").isVisible())
				fragmentManager.beginTransaction().replace(R.id.container, AboutFragment.newInstance(), "ABOUT").addToBackStack(null).commit();
			break;
		case 4:
			if(fragmentManager.findFragmentByTag("CONTACT") == null || !fragmentManager.findFragmentByTag("CONTACT").isVisible())
				fragmentManager.beginTransaction().replace(R.id.container, ContactFragment.newInstance(), "CONTACT").addToBackStack(null).commit();
			break;
		case 5:
			if(fragmentManager.findFragmentByTag("COMPARE") == null || !fragmentManager.findFragmentByTag("COMPARE").isVisible())
				fragmentManager.beginTransaction().replace(R.id.container, CompareFragment.newInstance(), "COMPARE").addToBackStack(null).commit();
			break;
		case 100:
			if(fragmentManager.findFragmentByTag("RACKETS") == null || !fragmentManager.findFragmentByTag("RACKETS").isVisible())
				fragmentManager.beginTransaction().replace(R.id.container, RacketsFragment.newInstance(), "RACKETS").addToBackStack(null).commit();
			break;
		case 101:
			if(fragmentManager.findFragmentByTag("BAGS") == null || !fragmentManager.findFragmentByTag("BAGS").isVisible())
				fragmentManager.beginTransaction().replace(R.id.container, BagsFragment.newInstance(), "BAGS").addToBackStack(null).commit();
			break;
		case 102:
			if(fragmentManager.findFragmentByTag("SHOES") == null || !fragmentManager.findFragmentByTag("SHOES").isVisible())
				fragmentManager.beginTransaction().replace(R.id.container, ShoesFragment.newInstance(),"SHOES").addToBackStack(null).commit();
			break;
		case 103:
			if(fragmentManager.findFragmentByTag("APPAREL") == null || !fragmentManager.findFragmentByTag("APPAREL").isVisible())
				fragmentManager.beginTransaction().replace(R.id.container, ApparelFragment.newInstance(), "APPAREL").addToBackStack(null).commit();
			break;
		}
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 0:
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
		case 5:
			mTitle = getString(R.string.title_section5);
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
		case 200:
			mTitle = getString(R.string.shoppingcart);
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
		switch (id) {
		case R.id.action_settings:
			return true;
		case R.id.action_example:
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction().replace(R.id.container, ShoppingCartFragment.newInstance(), "SHOPPINGCART").addToBackStack(null).commit();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	public void setupData() {
		ArrayList<Product> rackets = Singleton.INSTANCE.getRackets();
		ArrayList<String> urls = new ArrayList<String>();
		urls.add("http://www.akbadminton.com/wp-content/uploads/2014/05/NR700FX_1.jpg");
		urls.add("http://www.akbadminton.com/wp-content/uploads/2014/05/NR700FX_2.jpg");
		urls.add("http://www.akbadminton.com/wp-content/uploads/2014/05/NR700FX_3.jpg");
		rackets.add(new Product("NANORAY 700FX", "NANORAY’s revolutionary frame design with TOUGHLEX for flexible, all-round attack and defence play.",urls,null, 2));
		urls = new ArrayList<String>();
		urls.add("http://www.akbadminton.com/wp-content/uploads/2014/05/NR800_1.jpg");
		urls.add("http://www.akbadminton.com/wp-content/uploads/2014/05/NR800_2.jpg");
		urls.add("http://www.akbadminton.com/wp-content/uploads/2014/05/NR800_3.jpg");
		rackets.add(new Product("NANORAY 800", "X-FULLERINE combined with SONIC METAL produces a fast and controlled swing that generates powerfully accurate, rapid-fire shots.",urls,null, 0));
		urls = new ArrayList<String>();
		urls.add("http://www.akbadminton.com/wp-content/uploads/2014/05/NR-ZSP_1-1.jpg");
		urls.add("http://www.akbadminton.com/wp-content/uploads/2014/05/NR-ZSP_2.jpg");
		urls.add("http://www.akbadminton.com/wp-content/uploads/2014/05/NR-ZSP_3.jpg");
		rackets.add(new Product("NANORAY Z-SPEED", "The world’s fastest racquet.",urls,null, 0));
		Singleton.INSTANCE.addToCart(rackets.get(0));
		Singleton.INSTANCE.addToList(rackets.get(0));
		Singleton.INSTANCE.addToList(rackets.get(1));
		Singleton.INSTANCE.addToList(rackets.get(2));
	}

}
