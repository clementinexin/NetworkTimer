package com.example.daijiajia.networktimer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by daijiajia on 16/7/1.
 */
public class testReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent server=new Intent();
        server.setClass(context,testServer.class);
        context.startService(server);
    }
}
