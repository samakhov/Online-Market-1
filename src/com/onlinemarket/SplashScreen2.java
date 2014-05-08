package com.onlinemarket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
 
public class SplashScreen2 extends Activity {
 
    private static int SPLASH_TIME_OUT = 5000;
    private static int LOADER_CHANGE_TIME = 500;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final ImageView loader = (ImageView)findViewById(R.id.loading);
        final Image image = new Image();
        
        new CountDownTimer(SPLASH_TIME_OUT, LOADER_CHANGE_TIME) {
		public void onTick(long millisUntilFinished) {
		 	loader.setImageResource(image.get_next_image());
		}
		
		public void onFinish() {
			startActivity(new Intent(SplashScreen2.this, MainActivity.class));
			finish();
		}
		}.start();
        
    }
    

    public class Image{
    	private Integer[] image_list;
    	private int index;
    	
        public Image(){
        	index = 0;
        	image_list = new Integer[5];
            image_list[0] = R.drawable.loader_1;
            image_list[1] = R.drawable.loader_2;
            image_list[2] = R.drawable.loader_3;
            image_list[3] = R.drawable.loader_4;
            image_list[4] = R.drawable.loader_5;
        }
        
        public int get_next_image(){
        	
        	if(this.index == 4) {this.index = 0;}
        	else{this.index++;}
        	
        	return this.image_list[this.index];
        }
    }

    
}