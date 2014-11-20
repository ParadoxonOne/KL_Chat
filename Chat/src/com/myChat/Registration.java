package com.myChat;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class Registration extends Activity{
	
	Button weiter;
	EditText edname, edpw, edmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration);
		
		weiter  = 		(Button)  	 findViewById(R.id.weiter);
		edname  = 		(EditText)   findViewById(R.id.name02);
		edmail  = 		(EditText)   findViewById(R.id.email02);
		edpw = 			(EditText)   findViewById(R.id.pw02);
		
		Buttons();
	}
	
	private void Buttons(){
        weiter.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				try {
					Check();
				} catch (IOException e) {
				}					//Aufruf der CHECK Methode				
				Intent intent = new Intent(Registration.this, LogInActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
				startActivity(intent);
			}
		});    
	}	
	
	private void Check() throws IOException{
		Registrationspaket Packet = new Registrationspaket();
		Packet.nickname = edname.getText().toString();
		Packet.passwort = edpw.getText().toString();
		
		if(edmail.getText().toString().equals(""))
			Packet.email = "x";
		else
			Packet.email = edmail.getText().toString();

		Network_Client NetClient = new Network_Client(1034,1034);
		
		try{
			int SDK_INT = android.os.Build.VERSION.SDK_INT;
		    if (SDK_INT > 8){
		        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
		                .permitAll().build();
		        StrictMode.setThreadPolicy(policy);
		        //your codes here
		        NetClient.client.connect(5000, "84.118.149.19", 1034, 1034);
		    }
		
		}
		catch(IOException e){
			
		}
		
		NetClient.client.sendTCP(Packet);		
	}
}