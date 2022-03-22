package com.example.myapplication;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.media.MediaPlayer;

public class job extends JobService{
     MediaPlayer player;
     Thread thread;
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
//        player.setLooping(true);
//        player.start();
//        return false;
        thread= new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    player.setLooping(true);
//                     player.start();
//                    thread.sleep(20);

                }catch (Exception e){
                    System.out.println(e);
                }

            }

        });
        thread.start();
        player.start();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        player.stop();
        return true;
    }
}
