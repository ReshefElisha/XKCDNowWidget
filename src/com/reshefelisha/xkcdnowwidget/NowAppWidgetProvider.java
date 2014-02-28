package com.reshefelisha.xkcdnowwidget;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

public class NowAppWidgetProvider extends AppWidgetProvider{

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		final int N = appWidgetIds.length;		
		for (int i = 0; i < N; i++) {
			int appWidgetId = appWidgetIds[i];
			
			updateAppWidget(context, appWidgetManager, appWidgetId);
		}
	}
	
	@SuppressLint("SimpleDateFormat")
	public int getTimeDegree()
	{
		DateFormat df = new SimpleDateFormat("hhmm");
		df.setTimeZone(TimeZone.getTimeZone("gmt"));
		String gmtTime = df.format(new Date());
		gmtTime = gmtTime.replaceAll("[^0-9]", "");
		//double seconds = Double.parseDouble(gmtTime.substring(4));
		double minutes = Double.parseDouble(gmtTime.substring(2,4));
		double hours = Double.parseDouble(gmtTime.substring(0,2));
		double imgNum = ((minutes) + (hours*60));
		return (int) Math.floor(imgNum);
	}
	
	public static String CLOCK_WIDGET_UPDATE = "com.reshefelisha.xkcdnowwidget.NOW_WIDGET_UPDATE";
	
	private PendingIntent createClockTickIntent(Context context) {
	    Intent intent = new Intent(CLOCK_WIDGET_UPDATE);
	    PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
	    return pendingIntent;
	}
	
	@Override
	public void onEnabled(Context context) {
		super.onEnabled(context);
		Log.d("Now Widget", "Widget Provider enabled.  Starting timer to update widget every second");
		AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
		Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 1);
        alarmManager.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), 120000, createClockTickIntent(context));
	}
	
	@Override
	public void onDisabled(Context context)
	{
		super.onDisabled(context);
		Log.d("Now Widget", "Widget Provider disabled. Turning off timer");
		AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(createClockTickIntent(context));
	}
	
	@Override
	public void onReceive(Context context, Intent intent)
	{
		super.onReceive(context, intent);
		if (CLOCK_WIDGET_UPDATE.equals(intent.getAction())) {
			Log.d("TIME", "TIME");
			ComponentName thisAppWidget = new ComponentName(context.getPackageName(), getClass().getName());
	        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
	        int ids[] = appWidgetManager.getAppWidgetIds(thisAppWidget);
	        for (int appWidgetId: ids) {
				updateAppWidget(context, appWidgetManager, appWidgetId);
	        }
		}
		else if(AppWidgetManager.ACTION_APPWIDGET_ENABLED.equals(intent.getAction()))
		{
			this.onEnabled(context);
		}
		else if(AppWidgetManager.ACTION_APPWIDGET_DISABLED.equals(intent.getAction()))
		{
			this.onDisabled(context);
		}
	}
	
	public void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId)
	{
		RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
		
		int t = getTimeDegree();
		
		/*double s = 1;//1/(((Math.sqrt(2.0)-1)/2)*-1*Math.cos(Math.toRadians(2*t))+((Math.sqrt(2.0)-1)/2) +1); //-((sqrt(2)-1)/2)cos(x)+(sqrt(2)-1)/2+1
		float f = (float) s;
		
		Matrix mat = new Matrix();
		Bitmap bMap = BitmapFactory.decodeResource(context.getResources(), R.drawable.turningpart);
		mat.postRotate(t);
		mat.postScale(f, f);
		Bitmap bMapRotate = Bitmap.createBitmap(bMap, 0, 0,bMap.getWidth(),bMap.getHeight(), mat, true);
		Bitmap proxy = Bitmap.createBitmap(bMapRotate.getWidth(), bMapRotate.getHeight(), Config.ARGB_8888);
		Canvas c = new Canvas(proxy);
		c.drawBitmap(bMapRotate, new Matrix(), null);
		views.setImageViewBitmap(R.id.nowView, bMapRotate);*/
		
		int s = 48 -(t/15);
		if(s<=0) s=96+s;
		
		if(s==1)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd01);
		}
		else if(s==2)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd02);
		}
		else if(s==3)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd03);
		}
		else if(s==4)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd04);
		}
		else if(s==5)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd05);
		}
		else if(s==6)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd06);
		}
		else if(s==7)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd07);
		}
		else if(s==8)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd08);
		}
		else if(s==9)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd09);
		}
		else if(s==10)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd10);
		}
		else if(s==11)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd11);
		}
		else if(s==12)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd12);
		}
		else if(s==13)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd13);
		}
		else if(s==14)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd14);
		}
		else if(s==15)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd15);
		}
		else if(s==16)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd16);
		}
		else if(s==17)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd17);
		}
		else if(s==18)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd18);
		}
		else if(s==19)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd19);
		}
		else if(s==20)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd20);
		}
		else if(s==21)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd21);
		}
		else if(s==22)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd22);
		}
		else if(s==23)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd23);
		}
		else if(s==24)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd24);
		}
		else if(s==25)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd25);
		}
		else if(s==26)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd26);
		}
		else if(s==27)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd27);
		}
		else if(s==28)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd28);
		}
		else if(s==29)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd29);
		}
		else if(s==30)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd30);
		}
		else if(s==31)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd31);
		}
		else if(s==32)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd32);
		}
		else if(s==33)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd33);
		}
		else if(s==34)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd34);
		}
		else if(s==35)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd35);
		}
		else if(s==36)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd36);
		}
		else if(s==37)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd37);
		}
		else if(s==38)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd38);
		}
		else if(s==39)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd39);
		}
		else if(s==40)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd40);
		}
		else if(s==41)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd41);
		}
		else if(s==42)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd42);
		}
		else if(s==43)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd43);
		}
		else if(s==44)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd44);
		}
		else if(s==45)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd45);
		}
		else if(s==46)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd46);
		}
		else if(s==47)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd47);
		}
		else if(s==48)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd48);
		}
		else if(s==49)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd49);
		}
		else if(s==50)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd50);
		}
		else if(s==51)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd51);
		}
		else if(s==52)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd52);
		}
		else if(s==53)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd53);
		}
		else if(s==54)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd54);
		}
		else if(s==55)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd55);
		}
		else if(s==56)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd56);
		}
		else if(s==57)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd57);
		}
		else if(s==58)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd58);
		}
		else if(s==59)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd59);
		}
		else if(s==60)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd60);
		}
		else if(s==61)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd61);
		}
		else if(s==62)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd62);
		}
		else if(s==63)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd63);
		}
		else if(s==64)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd64);
		}
		else if(s==65)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd65);
		}
		else if(s==66)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd66);
		}
		else if(s==67)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd67);
		}
		else if(s==68)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd68);
		}
		else if(s==69)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd69);
		}
		else if(s==70)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd70);
		}
		else if(s==71)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd71);
		}
		else if(s==72)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd72);
		}
		else if(s==73)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd73);
		}
		else if(s==74)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd74);
		}
		else if(s==75)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd75);
		}
		else if(s==76)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd76);
		}
		else if(s==77)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd77);
		}
		else if(s==78)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd78);
		}
		else if(s==79)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd79);
		}
		else if(s==80)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd80);
		}
		else if(s==81)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd81);
		}
		else if(s==82)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd82);
		}
		else if(s==83)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd83);
		}
		else if(s==84)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd84);
		}
		else if(s==85)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd85);
		}
		else if(s==86)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd86);
		}
		else if(s==87)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd87);
		}
		else if(s==88)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd88);
		}
		else if(s==89)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd89);
		}
		else if(s==90)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd90);
		}
		else if(s==91)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd91);
		}
		else if(s==92)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd92);
		}
		else if(s==93)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd93);
		}
		else if(s==94)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd94);
		}
		else if(s==95)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd95);
		}
		else if(s==96)
		{
			views.setImageViewResource(R.id.nowView, R.drawable.xkcd96);
		}
		
		appWidgetManager.updateAppWidget(appWidgetId, views);
	}
}
