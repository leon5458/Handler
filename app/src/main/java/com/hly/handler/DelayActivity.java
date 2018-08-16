package com.hly.handler;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2018/8/16~~~~~~
 * ~~~~~~更改时间:2018/8/16~~~~~~
 * ~~~~~~版本号:1~~~~~~
 */
public class DelayActivity extends AppCompatActivity {
    private TextView dealy_text;
    private Button delay_post;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delay_activity_layout);

        dealy_text = findViewById(R.id.dealy_text);

        delay_post = findViewById(R.id.delaypost_btn);

        delay_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dealy_text.setText("post_我爱学习");
                    }
                }, 1000);
            }
        });

        findViewById(R.id.thread_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        startActivity(new Intent(DelayActivity.this,HandlerPostActivity.class));
                    }
                }.start();
            }
        });

        findViewById(R.id.TimerTask).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(DelayActivity.this,HandlerPostActivity.class));
                    }
                };
                Timer timer = new Timer();
                timer.schedule(task, 3000);
            }
        });
    }
}
