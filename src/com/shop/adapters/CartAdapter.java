package com.shop.adapters;

import java.util.ArrayList;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.shop.Singleton;
import com.shop.fragments.HomeFragment;
import com.shop.objects.Product;
import com.example.shop.R;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class CartAdapter extends ArrayAdapter<Product> {
	private Context context;
    private Product item;
	public CartAdapter(Context context, int resource, ArrayList<Product> products) {
		super(context, resource, products);
		this.context = context;
		// TODO Auto-generated constructor stub
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.cart_item, null);
		}

		item = getItem(position);
		if (item!= null) {
			// My layout has only one TextView
			ImageView productImage = (ImageView) view.findViewById(R.id.product_pic);
			TextView productDesc = (TextView) view.findViewById(R.id.item);
			TextView quantity = (TextView) view.findViewById(R.id.quantity);
			Button remove = (Button) view.findViewById(R.id.remove_from_cart);
			productImage.setMaxHeight(view.getHeight());
			if(item.getUrls() != null && item.getUrls().size() != 0)
				ImageLoader.getInstance().displayImage(item.getUrls().get(0), productImage);

			productDesc.setText(item.getName());
            quantity.setText(Integer.toString(item.getQuantity()));
            
            remove.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Singleton.INSTANCE.removeFromCart(item);
					notifyDataSetChanged();
				}
			});
            view.invalidate();
		}
		return view;
	}

}
