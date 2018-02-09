
package com.x.app;

import java.util.List;
import com.x.xphone.MyApplication;
import com.x.xphone.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;


public class AppListAdapter extends BaseAdapter
{   

	public List<App> applist; //设置中已经选择的的app列表
    private LayoutInflater inflater = null;
    public AppListAdapter(String Flag)
    {
        this.inflater = LayoutInflater.from(MyApplication.getAppContext());
        applist=App.getAppListByFlag(Flag);
    }

    @Override
    public int getCount() {
        return applist.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	ViewHandle handle = null;
		if (null == convertView)
		{
			handle = new ViewHandle();
			convertView = inflater.inflate(R.layout.applist, null);
			handle.selected= (CheckBox) convertView.findViewById(R.id.list_select);
			handle.app_pkg = (TextView) convertView.findViewById(R.id.list_pkg);
			convertView.setTag(handle);
		} else
		{
			handle = (ViewHandle) convertView.getTag();
		}
		final App a = applist.get(position);
		
		handle.app_pkg.setText(a.pkg);
		handle.selected.setText(a.title);
		handle.selected.setChecked(a.chk);
        final int p = position;
		handle.selected.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				CheckBox cb = (CheckBox)v;
				applist.get(p).chk=cb.isChecked();
			}			
		});
        return convertView;
    }   
	class ViewHandle
	{
		public CheckBox selected;
		public TextView app_name, app_pkg;
	}
}
