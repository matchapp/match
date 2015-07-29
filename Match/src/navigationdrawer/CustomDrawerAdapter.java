package navigationdrawer;


import java.util.ArrayList;
import java.util.List;

import com.example.match.R;
import com.example.match.R.drawable;
import com.example.match.R.id;
import com.example.match.R.layout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class CustomDrawerAdapter extends ArrayAdapter<DrawerItem> {
	 
    Context context;
    List<DrawerItem> drawerItemList;
    int layoutResID;

    public CustomDrawerAdapter(Context context, int layoutResourceID,
                List<DrawerItem> listItems) {
          super(context, layoutResourceID, listItems);
          this.context = context;
          this.drawerItemList = listItems;
          this.layoutResID = layoutResourceID;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
          // TODO Auto-generated method stub

          DrawerItemHolder drawerHolder;
          View view = convertView;

          if (view == null) {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                drawerHolder = new DrawerItemHolder();

                view = inflater.inflate(layoutResID, parent, false);
                drawerHolder.ItemName = (TextView) view
                            .findViewById(R.id.drawer_itemName);
                drawerHolder.icon = (ImageView) view.findViewById(R.id.drawer_icon);

                drawerHolder.spinner = (Spinner) view
                            .findViewById(R.id.drawerSpinner);

                drawerHolder.title = (TextView) view.findViewById(R.id.drawerTitle);

                drawerHolder.headerLayout = (LinearLayout) view
                            .findViewById(R.id.headerLayout);
                drawerHolder.itemLayout = (LinearLayout) view
                            .findViewById(R.id.itemLayout);
                drawerHolder.spinnerLayout = (LinearLayout) view
                            .findViewById(R.id.spinnerLayout);

                view.setTag(drawerHolder);

          } else {
                drawerHolder = (DrawerItemHolder) view.getTag();

          }

          DrawerItem dItem = (DrawerItem) this.drawerItemList.get(position);

          if (dItem.isSpinner()) {
                drawerHolder.headerLayout.setVisibility(LinearLayout.INVISIBLE);
                drawerHolder.itemLayout.setVisibility(LinearLayout.INVISIBLE);
                drawerHolder.spinnerLayout.setVisibility(LinearLayout.VISIBLE);

                List<SpinnerItem> userList = new ArrayList<SpinnerItem>();

                  userList.add(new SpinnerItem(R.drawable.person, "�ڼ���",
                            "01077623213"));

                userList.add(new SpinnerItem(R.drawable.person, "������",
                            "01077623213"));

                CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(context,
                            R.layout.custom_spinner_item, userList);

                drawerHolder.spinner.setAdapter(adapter);

                drawerHolder.spinner
                            .setOnItemSelectedListener(new OnItemSelectedListener() {

                                  @Override
                                  public void onItemSelected(AdapterView<?> arg0,
                                              View arg1, int arg2, long arg3) {

                                        Toast.makeText(context, "User Changed",
                                                    Toast.LENGTH_SHORT).show();
                                  }

                                  @Override
                                  public void onNothingSelected(AdapterView<?> arg0) {
                                        // TODO Auto-generated method stub

                                  }
                            });

          } else if (dItem.getTitle() != null) {
                drawerHolder.headerLayout.setVisibility(LinearLayout.VISIBLE);
                drawerHolder.itemLayout.setVisibility(LinearLayout.INVISIBLE);
                drawerHolder.spinnerLayout.setVisibility(LinearLayout.INVISIBLE);
                drawerHolder.title.setText(dItem.getTitle());

          } else {

                drawerHolder.headerLayout.setVisibility(LinearLayout.INVISIBLE);
                drawerHolder.spinnerLayout.setVisibility(LinearLayout.INVISIBLE);
                drawerHolder.itemLayout.setVisibility(LinearLayout.VISIBLE);

                drawerHolder.icon.setImageDrawable(view.getResources().getDrawable(
                            dItem.getImgResID()));
                drawerHolder.ItemName.setText(dItem.getItemName());

          }
          return view;
    }

    private static class DrawerItemHolder {
          TextView ItemName, title;
          ImageView icon;
          LinearLayout headerLayout, itemLayout, spinnerLayout;
          Spinner spinner;
    }
}