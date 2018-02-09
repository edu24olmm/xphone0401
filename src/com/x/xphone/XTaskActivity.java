package com.x.xphone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.R.bool;
import android.R.string;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class XTaskActivity extends Activity {

	private ListView lvTaskList;
	public static List<Task> tasks;
	public Button btnSelectTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selecttask);
		lvTaskList = (ListView) findViewById(R.id.lvTasks);
		btnSelectTask=(Button)findViewById(R.id.btnSelectTask);
		btnSelectTask.setOnClickListener(selectTask);
		
		TaskListAdapter aa = new TaskListAdapter();
		lvTaskList.setAdapter(aa);
	}

	
	OnClickListener selectTask = new OnClickListener() {
		@Override
		public void onClick(View v) {
			
			
		}
	};

	
	private List<Task> getData() {

		List<Task> data = new ArrayList<Task>();
		Task t1 = new Task();
		t1.TaskId = "1";
		t1.pkgName = "pkgname1";
		t1.pkgInfo = "pkginfo1";
		t1.isChecked = false;
		data.add(t1);
		Task t2 = new Task();
		t2.TaskId = "2";
		t2.pkgName = "pkgname2";
		t2.pkgInfo = "pkginfo2";
		t2.isChecked = false;
		data.add(t2);
		return data;
	}

	private class TaskListAdapter extends BaseAdapter {
		private LayoutInflater inflater = null;

		public TaskListAdapter() {
			tasks = getData();
			this.inflater = LayoutInflater.from(MyApplication.getAppContext());
		}

		public int getCount() {
			return tasks.size();
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		@SuppressLint("InflateParams")
		public View getView(final int position, View view, ViewGroup parent) {
			ViewHandle handle = null;
			if (null == view) {
				handle = new ViewHandle();
				view = inflater.inflate(R.layout.tasklist, null);
				handle.chkTaskId = (CheckBox) view.findViewById(R.id.chkTaskId);
				handle.tvPkgName = (TextView) view.findViewById(R.id.tvPkgName);
				handle.tvPkgInfo = (TextView) view.findViewById(R.id.tvPkgInfo);
				view.setTag(handle);
			} else {
				handle = (ViewHandle) view.getTag();
			}

			if (tasks != null) {
				handle.chkTaskId.setText(tasks.get(position).TaskId);
				handle.tvPkgName.setText(tasks.get(position).pkgName);
				handle.tvPkgInfo.setText(tasks.get(position).pkgInfo);
				handle.chkTaskId.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						tasks.get(position).isChecked = isChecked;
						Toast.makeText(getBaseContext(), "选择check" + isChecked, Toast.LENGTH_LONG).show();
					}
				});
			}
			return view;
		}

		class ViewHandle {
			public CheckBox chkTaskId;
			public TextView tvPkgName, tvPkgInfo;
		}
	}

	
	private class Task {

		public String TaskId;
		public String pkgName;
		public String pkgInfo;
		public String url;
		public boolean isChecked;
	}
}
