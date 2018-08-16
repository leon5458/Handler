package com.hly.handler;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2018/8/16~~~~~~
 * ~~~~~~更改时间:2018/8/16~~~~~~
 * ~~~~~~版本号:1~~~~~~
 */
public class HandlerPostActivity extends AppCompatActivity {
    public TextView mTextView;
    public Handler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handlerpost_activity_layout);

        mTextView = findViewById(R.id.post_txt);
        // 步骤1：在主线程中创建Handler实例
        mHandler = new Handler();
        // 步骤2：在工作线程中 发送消息到消息队列中 & 指定操作UI内容
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 通过psot（）发送，需传入1个Runnable对象\
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // 指定操作UI内容
                        mTextView.setText("我爱学习");
                    }
                });

            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 通过psot（）发送，需传入1个Runnable对象\
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // 指定操作UI内容
                        mTextView.setText("看完博客写demo");
                    }
                });

            }
        }.start();

    }
}
