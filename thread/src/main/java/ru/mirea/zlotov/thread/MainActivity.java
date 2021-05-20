package ru.mirea.zlotov.thread;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    final Integer multix = 28;
    Double result = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_lessons_ave);
    }


    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            result = (multix * 2.0 + 2.0) / 30.0;
            textView.setText(result.toString());
            result = 0.0;
        }
    };

    public void onClick(View view) {
        runOnUiThread(runnable);
    }

}