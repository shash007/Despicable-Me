/*Assignment 3
ResultActivity.java
Shashank G Hebbale(800773977)
Sahana K Raj(800774871)
*/

package com.example.despicablemehunt;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		TextView textview = (TextView) findViewById(R.id.textView2);
		TextView textview1 = (TextView) findViewById(R.id.textView1);
		ImageView imageview = (ImageView)findViewById(R.id.imageView1);
		float timeshow = getIntent().getExtras().getFloat(MainActivity.TIME);
		String s = new DecimalFormat("##.##").format(timeshow);
		textview.setText("It took you " + s + "s to finish the game.");
	    		
		if(timeshow < 20.0f)
		{
			
			textview1.setText("Congratulations !!!");
			imageview.setImageResource(R.drawable.win);
		}
		
		else
		{
			textview1.setText("What took you so long ?!");
			imageview.setImageResource(R.drawable.loose);
		}
		
		
		
		
		Button button = (Button)findViewById(R.id.button1);
		
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Intent intent = new Intent(ResultActivity.this, MainActivity.class);	  
                 startActivity(intent);
                 finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

}
