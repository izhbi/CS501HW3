package edu.bu.ivani.w3_p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOGTAG = "MYTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOGTAG, "onCreate() called");

        EditText editText = (EditText) findViewById(R.id.editText);
        TextView textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("Hello");
                textView.setText("Hello");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(LOGTAG, "onStart() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(LOGTAG, "onRestart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(LOGTAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(LOGTAG, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(LOGTAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(LOGTAG, "onDestroy() called");
    }
}