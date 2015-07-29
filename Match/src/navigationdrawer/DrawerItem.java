package navigationdrawer;

import com.example.match.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class DrawerItem {

	String ItemName;
	int imgResID;
	String title;
	boolean isSpinner;

	public DrawerItem(String itemName, int imgResID) {
		super();
		ItemName = itemName;
		this.imgResID = imgResID;
	}

	public DrawerItem(boolean isSpinner) {
		this(null, 0);
		this.isSpinner = isSpinner;
	}

	public DrawerItem(String title) {
		this(null, 0);
		this.title = title;
	}

	public DrawerItem(int imgResID) {
		super();
		this.imgResID = imgResID;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public int getImgResID() {
		return imgResID;
	}

	public void setImgResID(int imgResID) {
		this.imgResID = imgResID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isSpinner() {
		return isSpinner;
	}
}