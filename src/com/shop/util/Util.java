package com.shop.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;



public class Util {

	public static final int SCREEN_SIZE_NORMALP = 420;
	public static final int SCREEN_SIZE_LARGEP = 720;
	public static final int SCREEN_SIZE_NORMALL = 560;
	public static final int SCREEN_SIZE_LARGEL = 920;


	public static int getActivityWidth(Activity current) {
		DisplayMetrics displaymetrics = new DisplayMetrics();
		current.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int width = displaymetrics.widthPixels;
		return width;
	}

	public static int getActivityHeight(Activity current) {
		DisplayMetrics displaymetrics = new DisplayMetrics();
		current.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int height = displaymetrics.heightPixels;
		return height;
	}

	public static int getNumCols(Context ctxx) {
		int cols = 1;
		// no activity required
		WindowManager wm = (WindowManager) ctxx.getApplicationContext()
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		Point size = new Point();
		int width = display.getWidth();
		int height = display.getHeight();

		if (ctxx.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
			if (width < SCREEN_SIZE_NORMALP) {
				cols = 1;
			} else if (width < SCREEN_SIZE_LARGEP) {
				cols = 2;
			} else {
				cols = 3;
			} 
		} else {
			if (width < SCREEN_SIZE_NORMALL) {
				cols = 2;
			} else if (width < SCREEN_SIZE_LARGEL) {
				cols = 3;
			} else {
				cols = 4;
			} 
		}
		return cols;
	}

}
