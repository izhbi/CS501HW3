package edu.bu.ivani.w3_p4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText loginEditText;
    private EditText passEditText;
    private Button loginBtn;

    private static final String LOGIN = "user";
    private static final String PASSWORD = "pass123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginEditText = (EditText) findViewById(R.id.loginEditText);
        passEditText = (EditText) findViewById(R.id.passEditText);
        loginBtn = (Button) findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginEditText.getText().toString().equals(LOGIN) && passEditText.getText().toString().equals(PASSWORD)) {
                    Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                    intent.putExtra("login", loginEditText.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}