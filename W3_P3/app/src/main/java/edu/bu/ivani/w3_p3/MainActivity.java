package edu.bu.ivani.w3_p3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    private SeekBar cSeekBar, fSeekBar;
    private TextView cValTextView, fValTextView, msgTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cSeekBar = (SeekBar) findViewById(R.id.cSeekBar);
        fSeekBar = (SeekBar) findViewById(R.id.fSeekBar);
        cValTextView = (TextView) findViewById(R.id.cValTextView);
        fValTextView = (TextView) findViewById(R.id.fValTextView);
        msgTextView = (TextView) findViewById(R.id.msgTextView);

        cSeekBar.setOnSeekBarChangeListener(this);
        fSeekBar.setOnSeekBarChangeListener(this);

        cSeekBar.setProgress(20);
        fSeekBar.setProgress(32);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        cSeekBar.setProgress(savedInstanceState.getInt("cVal"));
        fSeekBar.setProgress(savedInstanceState.getInt("fVal"));
        cValTextView.setText(savedInstanceState.getString("cTextVal"));
        fValTextView.setText(savedInstanceState.getString("fTextVal"));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("cVal", cSeekBar.getProgress());
        outState.putInt("fVal", fSeekBar.getProgress());
        outState.putString("cTextVal", cValTextView.getText().toString());
        outState.putString("fTextVal", fValTextView.getText().toString());
    }

    private double convert(double t, boolean celcius) {
        if (celcius)
            return (t * 9.0 / 5.0) + 32.0;
        return (5.0 * (t - 32.0)) / 9.0;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar.equals(cSeekBar))
            msgTextView.setText((progress <= 20) ? R.string.msg_cold : R.string.msg_hot);

        if (fromUser) {
            double celsius = 0.0;
            double fahrenheit = 32.0;

            if (seekBar.equals(cSeekBar)) {
                celsius = progress;
                fahrenheit = convert(celsius, true);

                fSeekBar.setProgress((int) ((fahrenheit / 212.0) * 100.0));
            } else if (seekBar.equals(fSeekBar)) {
                fahrenheit = ((double) progress / 100.0) * 212.0;
                if (fahrenheit < 32.0) {
                    fahrenheit = 32.0;
                    fSeekBar.setProgress((int) (32.0 * 100.0 / 212.0));
                }
                celsius = convert(fahrenheit, false);

                cSeekBar.setProgress((int) celsius);
            }

            cValTextView.setText((int) celsius + " C");
            fValTextView.setText((int) fahrenheit + " F");
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}