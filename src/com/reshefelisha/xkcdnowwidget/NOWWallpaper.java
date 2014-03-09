package com.reshefelisha.xkcdnowwidget;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;

public class NOWWallpaper extends WallpaperService{
	
	private final Handler mHandler = new Handler();
	public static final String SHARED_PREFS_NAME="nowsettings";

	@Override
	public Engine onCreateEngine() {
		return new NowEngine();
	}
	
	class NowEngine extends Engine
	{
		
		private boolean mVisible;
		private float mWidth;
		private float mHeight;
        private float mCenterX;
        private float mCenterY;
        SharedPreferences sharedPrefs;
		
		private final Runnable mDrawClock = new Runnable() {
            public void run() {
                drawFrame();
            }
        };
        
        public NowEngine()
        {
        	sharedPrefs = NOWWallpaper.this.getSharedPreferences(SHARED_PREFS_NAME, 0);
        }
        
        @Override
        public void onDestroy() {
            super.onDestroy();
            mHandler.removeCallbacks(mDrawClock);
        }
        
        @Override
        public void onVisibilityChanged(boolean visible) {
            mVisible = visible;
            if (visible) {
                drawFrame();
            } else {
                mHandler.removeCallbacks(mDrawClock);
            }
        }
        
        @Override
        public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            super.onSurfaceChanged(holder, format, width, height);
            // store the center of the surface, so we can draw the clock in the right spot
            mCenterX = width/2.0f;
            mCenterY = height/2.0f;
            mWidth = width;
            mHeight = height;
            drawFrame();
        }
        
        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            super.onSurfaceDestroyed(holder);
            mVisible = false;
            mHandler.removeCallbacks(mDrawClock);
        }
        
        public void drawFrame()
        {
        	
        	final SurfaceHolder holder = getSurfaceHolder();

            Canvas c = null;
            try {
                c = holder.lockCanvas();
                if (c != null) {
                    // draw something
                    drawClock(c);
                }
            } finally {
                if (c != null) holder.unlockCanvasAndPost(c);
            }
        	
        	mHandler.removeCallbacks(mDrawClock);
        	if (mVisible) {
                mHandler.postDelayed(mDrawClock, 1000 * 25);
            }
        }
        
        public void drawClock(Canvas c)
        {
        	c.save();
            c.drawColor(Color.WHITE);
            
            Resources res = getResources();
            
            int t = getTimeDegree();
            int s = 96 - (t/15);
            
            Bitmap bitmap; 
            if(s==1)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd01);
            }
            else if(s==2)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd02);
            }
            else if(s==3)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd03);
            }
            else if(s==4)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd04);
            }
            else if(s==5)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd05);
            }
            else if(s==6)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd06);
            }
            else if(s==7)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd07);
            }
            else if(s==8)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd08);
            }
            else if(s==9)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd09);
            }
            else if(s==10)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd10);
            }
            else if(s==11)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd11);
            }
            else if(s==12)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd12);
            }
            else if(s==13)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd13);
            }
            else if(s==14)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd14);
            }
            else if(s==15)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd15);
            }
            else if(s==16)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd16);
            }
            else if(s==17)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd17);
            }
            else if(s==18)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd18);
            }
            else if(s==19)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd19);
            }
            else if(s==20)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd20);
            }
            else if(s==21)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd21);
            }
            else if(s==22)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd22);
            }
            else if(s==23)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd23);
            }
            else if(s==24)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd24);
            }
            else if(s==25)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd25);
            }
            else if(s==26)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd26);
            }
            else if(s==27)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd27);
            }
            else if(s==28)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd28);
            }
            else if(s==29)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd29);
            }
            else if(s==30)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd30);
            }
            else if(s==31)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd31);
            }
            else if(s==32)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd32);
            }
            else if(s==33)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd33);
            }
            else if(s==34)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd34);
            }
            else if(s==35)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd35);
            }
            else if(s==36)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd36);
            }
            else if(s==37)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd37);
            }
            else if(s==38)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd38);
            }
            else if(s==39)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd39);
            }
            else if(s==40)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd40);
            }
            else if(s==41)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd41);
            }
            else if(s==42)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd42);
            }
            else if(s==43)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd43);
            }
            else if(s==44)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd44);
            }
            else if(s==45)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd45);
            }
            else if(s==46)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd46);
            }
            else if(s==47)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd47);
            }
            else if(s==48)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd48);
            }
            else if(s==49)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd49);
            }
            else if(s==50)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd50);
            }
            else if(s==51)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd51);
            }
            else if(s==52)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd52);
            }
            else if(s==53)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd53);
            }
            else if(s==54)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd54);
            }
            else if(s==55)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd55);
            }
            else if(s==56)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd56);
            }
            else if(s==57)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd57);
            }
            else if(s==58)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd58);
            }
            else if(s==59)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd59);
            }
            else if(s==60)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd60);
            }
            else if(s==61)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd61);
            }
            else if(s==62)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd62);
            }
            else if(s==63)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd63);
            }
            else if(s==64)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd64);
            }
            else if(s==65)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd65);
            }
            else if(s==66)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd66);
            }
            else if(s==67)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd67);
            }
            else if(s==68)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd68);
            }
            else if(s==69)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd69);
            }
            else if(s==70)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd70);
            }
            else if(s==71)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd71);
            }
            else if(s==72)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd72);
            }
            else if(s==73)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd73);
            }
            else if(s==74)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd74);
            }
            else if(s==75)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd75);
            }
            else if(s==76)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd76);
            }
            else if(s==77)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd77);
            }
            else if(s==78)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd78);
            }
            else if(s==79)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd79);
            }
            else if(s==80)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd80);
            }
            else if(s==81)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd81);
            }
            else if(s==82)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd82);
            }
            else if(s==83)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd83);
            }
            else if(s==84)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd84);
            }
            else if(s==85)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd85);
            }
            else if(s==86)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd86);
            }
            else if(s==87)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd87);
            }
            else if(s==88)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd88);
            }
            else if(s==89)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd89);
            }
            else if(s==90)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd90);
            }
            else if(s==91)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd91);
            }
            else if(s==92)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd92);
            }
            else if(s==93)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd93);
            }
            else if(s==94)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd94);
            }
            else if(s==95)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd95);
            }
            else if(s==96)
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd96);
            }
            else
            {
            	bitmap = BitmapFactory.decodeResource(res, R.drawable.xkcd96);
            }
            
            float mValue;
            mWidth = c.getWidth();
            mHeight = c.getHeight();
            mCenterX = mWidth/2;
            mCenterY = mHeight/2;
            mValue = (mWidth > mHeight) ? mHeight : mWidth;
            
            int mSize = (int) (0.85*mValue);
            System.out.println(mValue);
            
            Bitmap sBitmap = Bitmap.createScaledBitmap(bitmap, mSize, mSize, false);
            
            c.drawBitmap(sBitmap, (mCenterX-mSize/2) , (mCenterY-mSize/2), null);
            
            c.restore();
        }
        
        @SuppressLint("SimpleDateFormat")
    	public int getTimeDegree()
    	{
    		DateFormat df = new SimpleDateFormat("HHmm");
    		df.setTimeZone(TimeZone.getTimeZone("gmt"));
    		String gmtTime = df.format(new Date());
    		gmtTime = gmtTime.replaceAll("[^0-9]", "");
    		double minutes = Double.parseDouble(gmtTime.substring(2,4));
    		double hours = Double.parseDouble(gmtTime.substring(0,2));
    		if(hours>=12) hours -=12;
    		else if(hours<12) hours+=12;
    		
    		boolean isAppDST = TimeZone.getTimeZone("gmt").inDaylightTime(new Date());
    		boolean isUserDST = sharedPrefs.getBoolean("pref_dst", false);
    		if(!isAppDST && isUserDST){ hours += 1; }
    		else if(isAppDST && !isUserDST) {hours -= 1;}		
    		
    		System.out.println(hours);
    		double imgNum = ((minutes) + (hours*60));
    		return (int) Math.floor(imgNum);
    	}
	}

}
