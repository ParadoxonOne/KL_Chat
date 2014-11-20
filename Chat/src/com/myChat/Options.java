package com.myChat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Options extends Activity{
	
	boolean blu, yello, rd, violt, gren;		//Überprüfen der "Checkboxen"
	boolean min_Interest, min_Color;			//CHECK ob mind. 1 von beiden an is
	ImageView blue, red, yellow, violet, green; //Durch diese Farben

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.options);
		RelativeLayout a = (RelativeLayout)findViewById(R.id.options);
		
		blue = 		(ImageView) findViewById(R.id.imageView1);
		red = 		(ImageView) findViewById(R.id.ImageView01);
		yellow = 	(ImageView) findViewById(R.id.ImageView03);
		violet = 	(ImageView) findViewById(R.id.ImageView04);
		green = 	(ImageView) findViewById(R.id.ImageView02);
		
		//FARBE AUSWÄHLEN IST EIN MUSS
		//GENAU WIE MIND. 1 INTERESSE
		//BILD OPTIONAL WÄHLBAR; ANSONSTEN GIBTS VON UNS EINS
		
		onColorClick();
		
	}
	
	public void onColorClick(){ 
		blue.setOnClickListener(new View.OnClickListener() {		//BLAUER KNOPF
			@Override
			public void onClick(View v) {
				blu = true;
				yello = false; 
				rd = false;
				violt = false;
				gren = false;	
				
				blue.setImageResource(R.drawable.blueok);
				yellow.setImageResource(R.drawable.yellow);
				red.setImageResource(R.drawable.red);
				green.setImageResource(R.drawable.green);
				violet.setImageResource(R.drawable.violet);
			  }
			});
		red.setOnClickListener(new View.OnClickListener() {		//ROTER KNOPF
			@Override
			public void onClick(View v) {
				blu = false;
				yello = false; 
				rd = true;
				violt = false;
				gren = false;	
				
				blue.setImageResource(R.drawable.blue);
				yellow.setImageResource(R.drawable.yellow);
				red.setImageResource(R.drawable.redok);
				green.setImageResource(R.drawable.green);
				violet.setImageResource(R.drawable.violet);
			  }
			});
		yellow.setOnClickListener(new View.OnClickListener() {		 //GELBER KNOP
			@Override
			public void onClick(View v) {
				blu = false;
				yello = true; 
				rd = false;
				violt = false;
				gren = false;	
				
				blue.setImageResource(R.drawable.blue);
				yellow.setImageResource(R.drawable.yellowok);
				red.setImageResource(R.drawable.red);
				green.setImageResource(R.drawable.green);
				violet.setImageResource(R.drawable.violet);
			  }
			});
		green.setOnClickListener(new View.OnClickListener() {	//GRÜNER KNOPF GEWÄHLT	
			@Override
			public void onClick(View v) {
				blu = false;
				yello = false; 
				rd = false;
				violt = false;
				gren = true;			
				
				blue.setImageResource(R.drawable.blue);
				yellow.setImageResource(R.drawable.yellow);
				red.setImageResource(R.drawable.red);
				green.setImageResource(R.drawable.greenok);
				violet.setImageResource(R.drawable.violet);
			  }
			});
		violet.setOnClickListener(new View.OnClickListener() {		//VIOLETTER KNOPF
			@Override
			public void onClick(View v) {
				blu = false;
				yello = false; 
				rd = false;
				violt = true;
				gren = false;	
				
				blue.setImageResource(R.drawable.blue);
				yellow.setImageResource(R.drawable.yellow);
				red.setImageResource(R.drawable.red);
				green.setImageResource(R.drawable.green);
				violet.setImageResource(R.drawable.violetok);
			  }
			});
	}
	
}


/*chkIos.setOnClickListener(new OnClickListener() {   KLICKER FÜR INTERESSEN
 
	  @Override
	  public void onClick(View v) {
                //is chkIos checked?
		if (((CheckBox) v).isChecked()) {
			Toast.makeText(MyAndroidAppActivity.this,
		 	   "Bro, try Android :)", Toast.LENGTH_LONG).show();
		}
 
	  }
	});*/
