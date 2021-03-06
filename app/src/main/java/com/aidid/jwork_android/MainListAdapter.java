package com.aidid.jwork_android;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
/**
 * Class adapter MainListAdapter
 *
 * @author Bryan Oliver
 * @version 9.6.2021
 */

public class MainListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private ArrayList<Recruiter> _listDataHeader;
    private HashMap<Recruiter, ArrayList<Job>> _listDataChild;

    /**
     * Constructor MainListAdapter
     * @param context
     * @param listDataHeader
     * @param listChildData
     */
    public MainListAdapter(Context context, ArrayList<Recruiter> listDataHeader,
                           HashMap<Recruiter, ArrayList<Job>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    /**
     * Getter child
     * @param groupPosition
     * @param childPosititon
     * @return
     */
    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    /**
     * getter child for position
     * @param groupPosition
     * @param childPosition
     * @return childPosition
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    /**
     * getter child view
     * @param groupPosition
     * @param childPosition
     * @param isLastChild
     * @param convertView
     * @param parent
     * @return convertView
     */
    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final Job childText = (Job) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.layout_job, null);
        }
        TextView txtListChild = (TextView) convertView.findViewById(R.id.lblListItem);
        String s = childText.getName() + ", Fee : " + childText.getFee();
        txtListChild.setText(s);
        return convertView;
    }

    /**
     * Getter for counting children
     * @param groupPosition
     * @return
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    /**
     * getter group
     * @param groupPosition
     * @return
     */
    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    /**
     * getter count group
     * @return
     */
    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    /**
     * getter group id
     * @param groupPosition
     * @return
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * getter group view
     * @param groupPosition
     * @param isExpanded
     * @param convertView
     * @param parent
     * @return convertView
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        final Recruiter headerTitle = (Recruiter) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.layout_recruiter, null);
        }

        TextView ListHeader = (TextView) convertView.findViewById(R.id.lblListHeader);
        ListHeader.setTypeface(null, Typeface.BOLD);
        ListHeader.setText("Recruiter " + headerTitle.getName());

        return convertView;
    }

    /**
     * hasStableIds
     * @return false
     */
    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     * isChildSelectable
     * @param groupPosition
     * @param childPosition
     * @return true
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}