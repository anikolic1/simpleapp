package com.example.helloworld;

import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.helloworld.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add a click through Java instead of XML
        /*
        Button button = findViewById(R.id.button_secret);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecretActivity();
            }
        });
        */
    }

    // Called when user taps the send button
    public void sendMessage(View view){

        // Create intent and find the editText from the type field
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();

        // Create new popup box and set parameters
        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
        builder1.setTitle("Warning");
        builder1.setMessage("You must enter a message before sending.");
        builder1.setCancelable(true);

        // Positive button from popup, just dismiss it
        builder1.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        // Negative button from popup, just dismiss it too
        builder1.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        // If the message is empty, show the alert. Otherwise continue
        AlertDialog alertEmpty = builder1.create();
        if (!message.equals("")) {
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
        else {
            alertEmpty.show();
        }
    }

    // Called when user taps the secret button
    public void goToSecretActivity(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
