package com.shop.util;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ImageViewResize extends ImageView {
	public ImageViewResize(Context context) {
	   super(context);
   }
	public ImageViewResize(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public ImageViewResize(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int width = MeasureSpec.getSize(widthMeasureSpec);
		int height = width * getDrawable().getIntrinsicHeight() / getDrawable().getIntrinsicWidth();
		setMeasuredDimension(width, height);
	}
}
