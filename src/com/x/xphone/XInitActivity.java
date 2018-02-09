package com.x.xphone;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class XInitActivity extends Activity {

	private ListView lvUsers;
	public static List<User> users;
	public Button btnSetDeviceName;
	public EditText etDeviceName;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.initapp);
		lvUsers = (ListView) findViewById(R.id.lvUsers);
		btnSetDeviceName=(Button)findViewById(R.id.btnSetDeviceName);
		btnSetDeviceName.setOnClickListener(setDeviceName);
		etDeviceName=(EditText)findViewById(R.id.etDeviceName);		
		UserListAdapter aa = new UserListAdapter();
		lvUsers.setAdapter(aa);
	}

	
	OnClickListener setDeviceName = new OnClickListener() {
		@Override
		public void onClick(View v) {
			String ss=etDeviceName.getText().toString();
			Toast.makeText(getBaseContext(), ss, 0).show();
		}
	};

	
	private List<User> getData() {
		List<User> data = new ArrayList<User>();
		User U1 = new User();
		U1.UserId = "1";
		U1.UserName = "111";
		U1.UserJC = "wong";
		U1.isChecked = false;
		data.add(U1);
		User U2 = new User();
		U2.UserId = "1";
		U2.UserName = "111";
		U2.UserJC = "wong";
		U2.isChecked = false;
		data.add(U2);
		return data;
	}

	
	private class UserListAdapter extends BaseAdapter {
		private LayoutInflater inflater = null;

		public UserListAdapter() {
			users = getData();
			this.inflater = LayoutInflater.from(MyApplication.getAppContext());
		}

		public int getCount() {
			return users.size();
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
				view = inflater.inflate(R.layout.userlist, null);
				handle.chkUserId = (CheckBox) view.findViewById(R.id.chkUserId);
				handle.tvUserName = (TextView) view.findViewById(R.id.tvUserName);
				view.setTag(handle);
			} else {
				handle = (ViewHandle) view.getTag();
			}
			if (users != null) {
				handle.chkUserId.setText(users.get(position).UserId);
				handle.chkUserId.setChecked(users.get(position).isChecked);
				handle.tvUserName.setText(users.get(position).UserName);
				handle.chkUserId.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						users.get(position).isChecked = isChecked;
						if(isChecked){
							for(int i=0;i<users.size();i++){
								users.get(position).isChecked = false;
							}
						}
						users.get(position).isChecked = isChecked;
						Toast.makeText(getBaseContext(), "选择check" + isChecked, Toast.LENGTH_LONG).show();
					}
				});
			}
			return view;
		}

		class ViewHandle {
			public CheckBox chkUserId;
			public TextView tvUserName;
		}
	}

	
	private class User {
		public String UserId;
		public String UserName;
		public String UserJC;
		public boolean isChecked;
	}
}
