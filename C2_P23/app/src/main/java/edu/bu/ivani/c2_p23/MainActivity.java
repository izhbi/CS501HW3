package edu.bu.ivani.c2_p23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int curColorIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView lightTextView = (TextView) findViewById(R.id.lightTextView);
        Button button = (Button) findViewById(R.id.button);

        final int[] colors = {R.color.red, R.color.yellow, R.color.green};
        final String[] colorNames = {"RED", "YELLOW", "GREEN"};

        lightTextView.setTextColor(getResources().getColor(colors[curColorIndex]));
        lightTextView.setText("Color is " + colorNames[curColorIndex]);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curColorIndex = (curColorIndex + 1) % colors.length;
                lightTextView.setTextColor(getResources().getColor(colors[curColorIndex]));
                lightTextView.setText("Color is " + colorNames[curColorIndex]);
            }
        });
    }
}