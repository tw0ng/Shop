package com.shop.adapters;

import java.util.ArrayList;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.shop.fragments.HomeFragment;
import com.shop.objects.Product;
import com.shop.util.Util;
import com.example.shop.R;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ProductAdapter extends ArrayAdapter<Product> {
	private Context context;
	public ProductAdapter(Context context, int resource, ArrayList<Product> products) {
		super(context, resource, products);
		this.context = context;
		// TODO Auto-generated constructor stub
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout view = (LinearLayout) convertView;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = (LinearLayout) inflater.inflate(R.layout.product_item, null);
		}
		
		ListView.LayoutParams settings = new ListView.LayoutParams(Util.getActivityWidth(context)/Util.getNumCols(context), ListView.LayoutParams.WRAP_CONTENT);
		view.setLayoutParams(settings);
		Product item = getItem(position);
		if (item!= null) {
			// My layout has only one TextView
			ImageView productImage = (ImageView) view.findViewById(R.id.product_pic);
			TextView productDesc = (TextView) view.findViewById(R.id.item);
			if(item.getUrls() != null && item.getUrls().size() != 0)
		    
			ImageLoader.getInstance().displayImage(item.getUrls().get(0), productImage);
			
			productDesc.setText(item.getName());
			
		}
		return view;
	}

}
