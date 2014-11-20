package com.myChat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Menu extends Activity{
	
	Button bSearch, bLogout, bContacts;
	TextView tOptions;
	ImageView iPic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		RelativeLayout a = (RelativeLayout)findViewById(R.id.menu);
		
		bSearch  = 		(Button)   findViewById(R.id.bSearch);
		bLogout  = 		(Button)   findViewById(R.id.bLogout);
		bContacts= 		(Button)   findViewById(R.id.bContacts);
		tOptions =		(TextView) findViewById(R.id.tOptions);
		iPic	 =		(ImageView)findViewById(R.id.iPic);
		

	        tOptions.setOnClickListener(new View.OnClickListener() {		
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(Menu.this, Options.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
					startActivity(intent);
				}
			});   
	}

	
	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}
	
	@Override
	public void onBackPressed() {
		return;
	}
}