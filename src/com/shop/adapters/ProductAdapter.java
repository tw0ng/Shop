package com.shop.adapters;

import java.util.ArrayList;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.shop.objects.Product;
import com.example.shop.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class ProductAdapter extends ArrayAdapter<Product> {
	private Context context;
	
	public ProductAdapter(Context context, int resource, ArrayList<Product> products) {
		super(context, resource, products);
		this.context = context;
		// TODO Auto-generated constructor stub
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.product_item, null);
		}

		Product item = getItem(position);
		if (item!= null) {
			// My layout has only one TextView
			ImageView productImage = (ImageView) view.findViewById(R.id.product_pic);
			TextView productDesc = (TextView) view.findViewById(R.id.item);
			if(item.getUrls() != null && item.getUrls().size() != 0)
		    
			ImageLoader.getInstance().displayImage(item.getUrls().get(0), productImage);
			
			productDesc.setText(item.getDescription());
			
		}
		return view;
	}

}
