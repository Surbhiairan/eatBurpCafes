package com.example.aniruddh.eatburp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);






        iv=(ImageView) findViewById(R.id.imageView);

        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.mytransition);

        iv.startAnimation(myanim);



        final Intent i= new Intent(this, MainActivity.class);


        Thread timer = new Thread(){

            public void run(){
                try{
                    sleep(4000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally{
                    startActivity(i);
                    finish();;
                }
            }
        };
        timer.start();
    }


    }

