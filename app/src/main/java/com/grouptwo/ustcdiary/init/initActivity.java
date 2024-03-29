package com.grouptwo.ustcdiary.init;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.grouptwo.ustcdiary.R;
import com.grouptwo.ustcdiary.main.mainActivity;

public class initActivity extends AppCompatActivity {

    private Handler initHandler;
    private int initTime = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
        initHandler = new Handler();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initHandler.postDelayed(new goToMain(),initTime);

    }

    @Override
    protected void onPause() {
        super.onPause();
        initHandler.removeCallbacksAndMessages(null);

    }

    public class goToMain implements Runnable{
        @Override
        public void run() {
            Intent goToMain = new Intent(initActivity.this, mainActivity.class);
            startActivity(goToMain);
            finish();
        }
    }
}
