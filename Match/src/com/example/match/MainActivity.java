package com.example.match;


import com.example.match.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

public class MainActivity extends Activity implements OnTouchListener{

	/** ViewFlipper 컴포넌트 객체 */
	private ViewFlipper m_viewFlipper;
	/** ViewFilpper 안에서 터치된 X축의 좌표 */
	private int m_nPreTouchPosX = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		m_viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper1);
		m_viewFlipper.setOnTouchListener(this);

		// ViewFlipper에 서브 레이아웃 추가
		LinearLayout sub1 = (LinearLayout) View.inflate(this,
				R.layout.main_page1, null);
		LinearLayout sub2 = (LinearLayout) View.inflate(this,
				R.layout.main_page2, null);
		LinearLayout sub3 = (LinearLayout) View.inflate(this,
				R.layout.main_page3, null);
		LinearLayout sub4 = (LinearLayout) View.inflate(this,
				R.layout.main_page4, null);
		m_viewFlipper.addView(sub1);
		m_viewFlipper.addView(sub2);
		m_viewFlipper.addView(sub3);
		m_viewFlipper.addView(sub4);
		
		Button Login = (Button)findViewById(id.login2_facebook);
		Login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, Login_page.class);
				startActivity(intent);
				finish();
			}
		});
	}
	
	private void MoveNextView() {
		m_viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
				R.anim.appear_from_right));
		m_viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
				R.anim.disappear_to_left));
		m_viewFlipper.showNext();
	}

	private void MovewPreviousView() {
		m_viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
				R.anim.appear_from_left));
		m_viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
				R.anim.disappear_to_right));
		m_viewFlipper.showPrevious();
	}


	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			m_nPreTouchPosX = (int) event.getX();
		}

		if (event.getAction() == MotionEvent.ACTION_UP) {
			int nTouchPosX = (int) event.getX();

			if (nTouchPosX < m_nPreTouchPosX) {
				MoveNextView();
			} else if (nTouchPosX > m_nPreTouchPosX) {
				MovewPreviousView();
			}

			m_nPreTouchPosX = nTouchPosX;
		}

		return true;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
