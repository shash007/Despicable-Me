/*Assignment 3
MainActivity.java
Shashank G Hebbale(800773977)
Sahana K Raj(800774871)
*/


package com.example.despicablemehunt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {

	 final public Integer[] mThumbIds = {
	            R.drawable.icon1, R.drawable.icon2,
	            R.drawable.icon3, R.drawable.icon4,
	            R.drawable.icon1, R.drawable.icon2,
	            R.drawable.icon3, R.drawable.icon4,
	            R.drawable.icon1, R.drawable.icon2,
	            R.drawable.icon3, R.drawable.icon4,
	            R.drawable.icon1, R.drawable.icon2,
	            R.drawable.icon3, R.drawable.icon4
	            
	    };
	 final static String TIME = "TIME";
	 int i=0;
	 int p=0;
	 Integer q=0;
	 public Context mContext;
	 List<Integer> imagesArrayList = new ArrayList<Integer>(Arrays.asList(mThumbIds));
	 Integer [] tempArrayList;
	 public static final Random rgenerator = new Random();
	 public static final Integer[] mImageIds = 
	    { R.drawable.icon1, R.drawable.icon2, R.drawable.icon3,R.drawable.icon4 };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		final long start=  System.currentTimeMillis();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Collections.shuffle(imagesArrayList);
		tempArrayList =   (Integer[])(imagesArrayList.toArray(new Integer[imagesArrayList.size()]));

		 final GridView gridView = (GridView) findViewById(R.id.grid_view);
			        // Instance of ImageAdapter Class
		  
		    final ImageAdapter imagead = new ImageAdapter(this);
	        gridView.setAdapter(imagead);
	        
	        final List<Integer> list = new ArrayList<Integer>();
	        list.add(R.drawable.icon1);
	        list.add(R.drawable.icon2);
	        list.add(R.drawable.icon3);
	        list.add(R.drawable.icon4);
	        
	        q= list.get(rgenerator.nextInt(list.size()));
	        
	        final ImageView iv = (ImageView) findViewById(R.id.imageView1);
	        iv.setImageResource(q);
	        
	        Button btn1 = (Button)findViewById(R.id.button1);
	        Button btn2 = (Button)findViewById(R.id.button2);
	        
	        btn1.setOnClickListener(new View.OnClickListener() {
				
				@SuppressLint("NewApi")
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(MainActivity.this, MainActivity.class);	  
                    startActivity(intent); 
					finish();
					
				}
			});
	        
	        btn2.setOnClickListener(new View.OnClickListener() {
				
	        	
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
					//System.exit(0);
				}
			});
	        gridView.setOnItemClickListener(new OnItemClickListener() {

				@SuppressLint("NewApi")
				
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					//arg1.setClickable(false);
				  
					  if(getResources().getDrawable(q).getConstantState().equals(getResources().getDrawable(tempArrayList[arg2]).getConstantState()))
					  {
						  arg1.setClickable(true);
						  arg1.setAlpha((float) 0.4);
						  
						
						  if((++i)== 4)
						  {
							  	  			      
							  
						      p++;
							  if(p==4)
							  {
								  p=0;
													         
								  final long end=  System.currentTimeMillis();
								  float timeSeconds = (end - start)/1000.0f;
								  Intent intent = new Intent(MainActivity.this, ResultActivity.class);	  
	                              intent.putExtra(TIME, timeSeconds);
	                              startActivity(intent); 
	                              finish();
							  }
							  else{
								  list.remove(q);
								  q= list.get(rgenerator.nextInt(list.size()));
								  iv.setImageResource(q);
								  i=0;
								  
							  }
							  
							
						   			  
						  }
						  
						  

						  
						  
						  
						  
					  }
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public class ImageAdapter extends BaseAdapter {
	    
	 
	    // Keep all Images in array
		 
		 
	    // Constructor
	    public ImageAdapter(Context c){
	        mContext = c;
	    }
	 
	    @Override
	    public int getCount() {
	        return mThumbIds.length;
	    }
	 
	    @Override
	    public Object getItem(int position) {
	        return mThumbIds[position];
	    }
	 
	    @Override
	    public long getItemId(int position) {
	        return 0;
	    }
	 
	   
	    
	    public View getView(int position, View convertView, ViewGroup parent) {
	    	ImageView imageView = new ImageView(mContext);
	        imageView.setImageResource(imagesArrayList.get(position));
	        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
	        imageView.setLayoutParams(new GridView.LayoutParams(60, 60));
	        return imageView;
	    }
	 
	 
	}
}
