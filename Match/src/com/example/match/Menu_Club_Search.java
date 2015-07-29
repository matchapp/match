package com.example.match;

import java.util.ArrayList;

import recomand_club_Listview.ListviewAdapter;
import recomand_club_Listview.Listviewitem;

import com.example.match.R.id;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class Menu_Club_Search extends Fragment {

	public Menu_Club_Search() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.menu_club_search, container,
				false);
		Spinner spinner = (Spinner) view.findViewById(R.id.sports_name);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this.getActivity(), R.array.sports_name,
				android.R.layout.simple_spinner_item);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinner.setAdapter(adapter);

		// 추천 클럽 리스트뷰
		ListView listView_re = (ListView) view.findViewById(R.id.recomand_club);

		ArrayList<Listviewitem> data = new ArrayList<Listviewitem>();
		Listviewitem sub1 = new Listviewitem(
				R.drawable.ic_launcher, "sub1", R.drawable.icon_next);
		Listviewitem sub2 = new Listviewitem(
				R.drawable.ic_launcher, "sub2", R.drawable.icon_next);
		Listviewitem sub3 = new Listviewitem(
				R.drawable.ic_launcher, "sub3", R.drawable.icon_next);

		data.add(sub1);
		data.add(sub2);
		data.add(sub3);

		ListviewAdapter adapter_re = new ListviewAdapter(this.getActivity(),
				R.layout.club_item, data);
		listView_re.setAdapter(adapter_re);

		// 클럽 항목
		ListView listView_in = (ListView) view.findViewById(R.id.club_index);

		ArrayList<Listviewitem> data1 = new ArrayList<Listviewitem>();
		Listviewitem sub_1 = new Listviewitem(
				R.drawable.ic_launcher, "sub1", R.drawable.icon_next);
		Listviewitem sub_2 = new Listviewitem(
				R.drawable.ic_launcher, "sub2", R.drawable.icon_next);
		Listviewitem sub_3 = new Listviewitem(
				R.drawable.ic_launcher, "sub3", R.drawable.icon_next);
		Listviewitem sub_4 = new Listviewitem(
				R.drawable.ic_launcher, "sub4", R.drawable.icon_next);
		Listviewitem sub_5 = new Listviewitem(
				R.drawable.ic_launcher, "sub5", R.drawable.icon_next);
		Listviewitem sub_6 = new Listviewitem(
				R.drawable.ic_launcher, "sub6", R.drawable.icon_next);
		

		data1.add(sub_1);
		data1.add(sub_2);
		data1.add(sub_3);
		data1.add(sub_4);
		data1.add(sub_5);
		data1.add(sub_6);

		ListviewAdapter adapter_in = new ListviewAdapter(this.getActivity(),
				R.layout.club_item, data1);
		listView_in.setAdapter(adapter_in);
		
		setListViewHeightBasedOnChildren(listView_re);
        setListViewHeightBasedOnChildren(listView_in);
		
		return view;
	}
	
	public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter(); 
        if (listAdapter == null) {
            // pre-condition
            return;
        }
 
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
 
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
}

}