package recomand_club_Listview;


import com.example.match.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Listviewitem {

	private int icon;
	private int icon_next;
	private String name;
	
	public int getIcon(){
		return icon;
		
	}
	public String getName(){
		return name;
	}
	
	public int getIcon_next(){
		return icon_next;
	}
	
	public Listviewitem(int icon, String name, int icon_next){
		this.icon = icon;
		this.name = name;
		this.icon_next = icon_next;
	}

}
