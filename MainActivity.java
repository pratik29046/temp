package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.KeyEventDispatcher;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2;
    Thread thread=null;
    boolean isRunning=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.start1);
        btn2=findViewById(R.id.stop);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view == btn1){
//            Intent i=new Intent(getApplicationContext(),background.class);
//            startService(i);
            ComponentName componentName=new ComponentName(this,job.class);
            JobInfo info= new JobInfo.Builder(123,componentName)
                    .setRequiresCharging(true)
//                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                    .setPersisted(true)
                    .setPeriodic(15 * 60 * 1000)
                    .build();

            JobScheduler scheduler=(JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
            int resultCode=scheduler.schedule(info);
            if(resultCode==JobScheduler.RESULT_SUCCESS){
                Log.d("show","job success");
            }else{
                Log.d("show","job not success");
            }

     }
        else if (view == btn2){
//            Intent i=new Intent(getApplicationContext(),background.class);
//            stopService(i);

            JobScheduler scheduler=(JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
            scheduler.cancel(123);
            Log.d("show","stop");

        }

    }
}