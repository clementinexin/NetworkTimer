package com.example.daijiajia.networktimer;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.content.IntentSender;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * Created by daijiajia on 16/7/1.
 */
public class testServer extends IntentService {

    public testServer(){
        super(testServer.class.getCanonicalName());

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            URL url = new URL("http://www.baidu.com");
            URLConnection connection = url.openConnection();
            int failCount = 0;
            while (connection == null) {
                if (failCount++ >10) {
                    return;
                }
                Thread.sleep(6000);
                connection = url.openConnection();
            }
            connection.connect();
            Runtime.getRuntime().exec("su");
            MainActivity.requestPermission();
            SystemClock.setCurrentTimeMillis(connection.getDate());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
