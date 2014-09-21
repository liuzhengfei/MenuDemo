package com.example.menudemo;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

public class MainActivity extends TabActivity implements OnCheckedChangeListener {
	
	private TabHost thHost = null;
	private RadioGroup rgMenu = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//取消标题栏
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
//		//取消状态栏
//				this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//						WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_main);
		thHost = this.getTabHost();
		
		//添加选项卡
		thHost.addTab(thHost.newTabSpec("ONE").setIndicator("ONE").setContent(new Intent(this,OneActivity.class)));
		thHost.addTab(thHost.newTabSpec("TWO").setIndicator("TWO").setContent(new Intent(this,TwoActivity.class)));
		thHost.addTab(thHost.newTabSpec("THREE").setIndicator("THREE").setContent(new Intent(this,ThreeActivity.class)));
		thHost.addTab(thHost.newTabSpec("FOUR").setIndicator("FOUR").setContent(new Intent(this,FourActivity.class)));
		thHost.addTab(thHost.newTabSpec("FIVE").setIndicator("FIVE").setContent(new Intent(this,FiveActivity.class)));
		
		rgMenu = (RadioGroup) super.findViewById(R.id.main_radio);
		rgMenu.setOnCheckedChangeListener(this);
		
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch(checkedId){
		case R.id.main_icon:
			thHost.setCurrentTabByTag("ONE");
			break;
		case R.id.search_icon:
			thHost.setCurrentTabByTag("TWO");
			break;
		case R.id.place_icon:
			thHost.setCurrentTabByTag("THREE");
			break;
		case R.id.baike_icon:
			thHost.setCurrentTabByTag("FOUR");
			break;
		case R.id.more_icon:
			thHost.setCurrentTabByTag("FIVE");
			break;
		}
	}

}
