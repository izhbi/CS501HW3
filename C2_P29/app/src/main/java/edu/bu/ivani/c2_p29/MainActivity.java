package edu.bu.ivani.c2_p29;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    private EditText pastaET, burgerET, friesET, bagelET, soupET;
    private TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pastaET = (EditText) findViewById(R.id.pastaEditText);
        burgerET = (EditText) findViewById(R.id.burgerEditText);
        friesET = (EditText) findViewById(R.id.friesEditText);
        bagelET = (EditText) findViewById(R.id.bagelEditText);
        soupET = (EditText) findViewById(R.id.soupEditText);

        resultTV = (TextView) findViewById(R.id.resultTextView);

        pastaET.addTextChangedListener(this);
        burgerET.addTextChangedListener(this);
        friesET.addTextChangedListener(this);
        bagelET.addTextChangedListener(this);
        soupET.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable editable) {
        try {
            int calories = 0;
            if (!pastaET.getText().toString().isEmpty())
                calories += Integer.parseInt(pastaET.getText().toString()) * 800;
            if (!burgerET.getText().toString().isEmpty())
                calories += Integer.parseInt(burgerET.getText().toString()) * 600;
            if (!friesET.getText().toString().isEmpty())
                calories += Integer.parseInt(friesET.getText().toString()) * 400;
            if (!bagelET.getText().toString().isEmpty())
                calories += Integer.parseInt(bagelET.getText().toString()) * 500;
            if (!soupET.getText().toString().isEmpty())
                calories += Integer.parseInt(soupET.getText().toString()) * 350;

            resultTV.setText("Total Calories: " + calories);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Invalid number", Toast.LENGTH_SHORT);

            resultTV.setText("Total Calories:");
        }
    }
}