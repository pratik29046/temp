package com.example.myapplication;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import java.lang.Thread;
import androidx.annotation.Nullable;

public class background extends Service {
    Thread thread;
    private MediaPlayer player;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player = MediaPlayer.create(this, R.raw.music);
//        player.setLooping(true);
//        player.start();
         thread= new Thread(new Runnable() {
             @Override
             public void run() {
                 try{
                     player.setLooping(true);
//                     player.start();
                     thread.sleep(20);

                 }catch (Exception e){
                      System.out.println(e);
                 }

             }

         });
         player.start();
         thread.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}






//import android.app.Service;
//import android.content.Intent;
//import android.media.MediaPlayer;
//import android.os.IBinder;
//import android.util.Log;
//import android.widget.Toast;
//
//
//
//public class background extends Service {
//
//    private static final String TAG = "background";
//    MediaPlayer player;
//
//    public IBinder onBind(Intent arg0) {
//        return null;
//    }
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        player = MediaPlayer.create(this, R.raw.music);
//        player.setLooping(true); // Set looping
//        Toast.makeText(this, "Service started...", Toast.LENGTH_SHORT).show();
//
//    }
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        player.start();
//        return Service.START_STICKY;
//    }
//
//    public IBinder onUnBind(Intent arg0) {
//        Log.i(TAG, "onUnBind()");
//        return null;
//    }
//
//
//    @Override
//    public void onDestroy() {
//        player.stop();
//    }
//
//    @Override
//    public void onLowMemory() {
//        Log.i(TAG, "onLowMemory()");
//    }
//}

