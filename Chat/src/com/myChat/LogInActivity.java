package com.myChat;

import java.io.IOException;
import java.util.Random;

import com.myChat.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
//commit
public class LogInActivity extends Activity{
	
	Button b01, b02, b03;
	TextView tv01, tvid;
	EditText user, password;
	int background;
	Random rnd = new Random();
	Network_Client Netclient;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		RelativeLayout a = (RelativeLayout)findViewById(R.id.login);
		
		backgroundupdater(a);
		
		b01  = 		(Button)   findViewById(R.id.b01);
		b02  = 		(Button)   findViewById(R.id.b02);
		b03  = 		(Button)   findViewById(R.id.b03);
		tv01 =		(TextView) findViewById(R.id.tv01);
		tvid =		(TextView) findViewById(R.id.tvid);
		user=		(EditText) findViewById(R.id.textname);
		password =	(EditText) findViewById(R.id.textpw);
		 
		password.setTransformationMethod(PasswordTransformationMethod.getInstance());
		Buttons();
	}
	
	private void Buttons(){
        b01.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				if(user.getText().toString().equals("") || 
						password.getText().toString().equals("")){
							Toast.makeText(getApplicationContext(), 
							"Bitte geben sie vollständige Daten ein.", Toast.LENGTH_SHORT).show();
						}
				else{ 
					try {
						Netclient = new Network_Client(1034,1034);
					} catch (IOException e1) {
					} 
					
					try{
						int SDK_INT = android.os.Build.VERSION.SDK_INT;
					    if (SDK_INT > 8) 
					    {
					        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					                .permitAll().build();
					        StrictMode.setThreadPolicy(policy);
					        //your codes here
					        Netclient.client.connect(5000, "84.118.149.19", 1034, 1034);
					    }
						
					}
					catch(Exception e){
						Toast.makeText(getApplicationContext(), 
								e.toString(), Toast.LENGTH_LONG).show();
					}	
					
					Netclient.client.addListener(new Listener() {
						public void connected(Connection connection) {
						}

						public void received(Connection connection, Object p){
							if(p instanceof Login){
								Login packet = (Login) p;
								if(packet.acc_avaiable == true){
									Toast.makeText(getApplicationContext(), 
											"Account wird verbunden", Toast.LENGTH_SHORT).show();
									
								}
								if(packet.x == 1)
								{
									OnMenu();
								}
							}
						}

						public void disconnected(Connection connection) {
							};
					});
				}
			}
		});    
        b02.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				finish();
			}
		});  
        b03.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(LogInActivity.this, Registration.class);
				LogInActivity.this.startActivity(myIntent);
			}
		});       
	}	
	
	private void OnMenu(){
		Intent myIntent = new Intent(LogInActivity.this, Menu.class);
		LogInActivity.this.startActivity(myIntent);
	}
	
	private void backgroundupdater(RelativeLayout a){
		background = rnd.nextInt(2);
		 if (background != 1){
			 a.setBackgroundResource(R.drawable.pink);
	        }else
	        	a.setBackgroundResource(R.drawable.welt);
	}
}