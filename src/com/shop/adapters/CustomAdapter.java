package com.shop.adapters;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.shop.R;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseExpandableListAdapter {
	private Context _context;
	private ArrayList<String> header;
	private HashMap<String, ArrayList<String>> children;

	public CustomAdapter(Context context, ArrayList<String> listDataHeader,
			HashMap<String, ArrayList<String>> listChildData) {
		this._context = context;
		this.header = listDataHeader;
		this.children = listChildData;
	}

	@Override
	public Object getChild(int groupPosition, int childPosititon) {
		return this.children.get(this.header.get(groupPosition))
				.get(childPosititon);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, final int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
        Log.d("Are there children?", "The child is " + this.children.get(this.header.get(groupPosition)).size() + " The header name " + this.header.get(groupPosition) + " The child is " + childPosition);
		final String childText = (String) getChild(groupPosition, childPosition);

		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this._context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.nav_item, null);
		}

		TextView txtListChild = (TextView) convertView
				.findViewById(R.id.item);
        Log.d("The child exists? ", "Child is " + childText);
		txtListChild.setText(childText);
		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		if(this.children.containsKey(this.header.get(groupPosition)))
			return this.children.get(this.header.get(groupPosition))
					.size();
		else
			return 0;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return this.header.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return this.header.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		String headerTitle = (String) getGroup(groupPosition);
		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this._context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.header, null);
		}

		TextView lblListHeader = (TextView) convertView
				.findViewById(R.id.header);
		lblListHeader.setTypeface(null, Typeface.BOLD);
		lblListHeader.setText(headerTitle);

		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
}
