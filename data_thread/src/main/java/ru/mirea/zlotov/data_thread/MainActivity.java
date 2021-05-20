package ru.mirea.zlotov.data_thread;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        final Runnable runn1 = new Runnable() {
            public void run() {
                textView.setText("runn1");
            }
        };
        final Runnable runn2 = new Runnable() {
            public void run() {
                textView.setText("runn2");
            }
        };
        final Runnable runn3 = new Runnable() {
            public void run() {
                textView.setText("runn3");
            }
        };
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    runOnUiThread(runn1);
                    TimeUnit.SECONDS.sleep(1);
                    textView.postDelayed(runn3, 2000);
                    textView.post(runn2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}