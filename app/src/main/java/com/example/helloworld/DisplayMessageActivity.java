package com.example.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get intent that started the activity and extract string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView4);
        textView.setText(message);

        // Display image based on the text that is entered
        ImageView imageView = findViewById(R.id.imageView2);
        String upper = message.toUpperCase();
        if (upper.equals("ELEPHANT")) {
            imageView.setImageResource(R.drawable.elephant);
        }
        else if (upper.equals("DOG")) {
            imageView.setImageResource(R.drawable.doggy);
        }
    }
}
