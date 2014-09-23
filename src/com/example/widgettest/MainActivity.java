package com.example.widgettest;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.RemoteViews;

public class MainActivity extends AppWidgetProvider {


	  private static final String ACTION_CLICK = "ACTION_CLICK";

	  @Override
	  public void onUpdate(Context context, AppWidgetManager appWidgetManager,
	      int[] appWidgetIds) {

		  Log.w("WidgetExample","Bhai");
	    // Get all ids
	/*    ComponentName thisWidget = new ComponentName(context,
	        MyWidgetProvider.class);
	    int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
	    for (int widgetId : allWidgetIds) {*/
		  for(int i=0; i<appWidgetIds.length; i++){
		      int currentWidgetId = appWidgetIds[i];
	      // create some random data
	      int number = (new Random().nextInt(100));

	      RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
	          R.layout.activity_main);
	      Log.w("WidgetExample", String.valueOf(number));
	      // Set the text
	      remoteViews.setTextViewText(R.id.update,String.valueOf(number));

	      // Register an onClickListener
	      Intent intent = new Intent();

	      intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
	      intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

	      PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
	          0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
	      remoteViews.setOnClickPendingIntent(R.id.update, pendingIntent);
	      appWidgetManager.updateAppWidget(currentWidgetId, remoteViews);
	    }
	  }
}
