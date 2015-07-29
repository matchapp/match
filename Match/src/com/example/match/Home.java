package com.example.match;

import java.util.ArrayList;
import java.util.List;

import com.example.match.R.id;

import java.util.ArrayList;
import java.util.List;

import navigationdrawer.CustomDrawerAdapter;
import navigationdrawer.DrawerItem;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Home extends Activity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	CustomDrawerAdapter adapter;

	List<DrawerItem> dataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		ActionBar actionBar = getActionBar();//���� �׼ǹ� ��������
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#884b96ca")));
		getActionBar().setDisplayShowHomeEnabled(false);// �� ���� �׼ǹ� �����ܾ��ֱ�
		
		dataList = new ArrayList<DrawerItem>();
		mTitle = mDrawerTitle = getTitle();
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		
		dataList.add(new DrawerItem(true)); 
		dataList.add(new DrawerItem("Ŭ��")); 
														
		dataList.add(new DrawerItem("���� Ŭ��", R.drawable.myclub));
		dataList.add(new DrawerItem("Ŭ�� ã��", R.drawable.search));
		dataList.add(new DrawerItem("��� ��Ī", R.drawable.vs));

		dataList.add(new DrawerItem("�Խ���"));
														
		dataList.add(new DrawerItem("���� �Խ���", R.drawable.board1));
		dataList.add(new DrawerItem("Tip �Խ���", R.drawable.tip));
		dataList.add(new DrawerItem("���� �Խ���", R.drawable.want));
		

		dataList.add(new DrawerItem("��Ÿ")); 
														
		dataList.add(new DrawerItem("ü�� �ü�", R.drawable.house));
		dataList.add(new DrawerItem("��ǰ ����", R.drawable.cart));
		dataList.add(new DrawerItem("Help", R.drawable.help));

		adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item,
				dataList);

		mDrawerList.setAdapter(adapter);

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		//getActionBar().setIcon(R.drawable.ic_drawer);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); 
											
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); 
								
				
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {

			if (dataList.get(0).isSpinner()
					& dataList.get(1).getTitle() != null) {
				SelectItem(2);
			} else if (dataList.get(0).getTitle() != null) {
				SelectItem(1);
			} else {
				SelectItem(0);
			}
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void SelectItem(int possition) {

		Fragment fragment = null;
		Bundle args = new Bundle();
		switch (possition) {

		case 2:
			fragment = new FragmentThree();
			args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList
					.get(possition).getImgResID());
			break;
		case 3:
			fragment = new Menu_Club_Search();
			
			break;
		case 4:
			fragment = new FragmentTwo();
			args.putString(FragmentTwo.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(possition)
					.getImgResID());
			break;
		
		case 6:
			fragment = new FragmentTwo();
			args.putString(FragmentTwo.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(possition)
					.getImgResID());
			break;
		case 7:
			fragment = new FragmentThree();
			args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList
					.get(possition).getImgResID());
			break;
		case 8:
			fragment = new Menu_Club_Search();
			
			break;
		case 10:
			fragment = new FragmentTwo();
			args.putString(FragmentTwo.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(possition)
					.getImgResID());
			break;
		case 11:
			fragment = new FragmentThree();
			args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList
					.get(possition).getImgResID());
			break;
		case 12:
			fragment = new Menu_Club_Search();
		
			break;
		
		
		default:
			break;
		}

		fragment.setArguments(args);
		FragmentManager frgManager = getFragmentManager();
		frgManager.beginTransaction().replace(R.id.content_frame, fragment)
				.commit();

		mDrawerList.setItemChecked(possition, true);
		setTitle(dataList.get(possition).getItemName());
		mDrawerLayout.closeDrawer(mDrawerList);

	}

	
	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		return false;
	}

	 @Override
	    public boolean onKeyDown(int keyCode, KeyEvent event) {
	         
	        switch (keyCode) {
	        //�ϵ���� �ڷΰ��� ��ư�� ���� �̺�Ʈ ����
	        case KeyEvent.KEYCODE_BACK:
	             
	        	//mDrawerLayout.closeDrawer(mDrawerList);
	            new AlertDialog.Builder(this)
	            .setTitle("Match ����")
	            .setMessage("Match�� ���� �Ͻðڽ��ϱ�?")
	            .setPositiveButton("��", new DialogInterface.OnClickListener() {
	                 
	                @Override
	                public void onClick(DialogInterface dialog, int which) {
	                    // ���μ��� ����.
	                	 
                         android.os.Process.killProcess(android.os.Process.myPid());
                         System.exit(0);
	                }
	            })
	            .setNegativeButton("�ƴϿ�", null)
	            .show();
	             
	            break;
	 
	        default:
	            break;
	        }
	         
	        return super.onKeyDown(keyCode, event);
	    }
	
	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			if (dataList.get(position).getTitle() == null) {
				SelectItem(position);
			}

		}
	}
	
	
	

}
