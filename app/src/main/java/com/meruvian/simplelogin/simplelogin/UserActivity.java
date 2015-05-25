package com.meruvian.simplelogin.simplelogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {
    private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button login_btn;
    int attempts_count=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }

    public void LoginButton() {
        username = (EditText)findViewById(R.id.editText_username);
        password = (EditText)findViewById(R.id.editText_password);
        attempts = (TextView)findViewById(R.id.textView_attempts);
        login_btn = (Button)findViewById(R.id.button_login);

        attempts.setText(Integer.toString(attempts_count));

        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (username.getText().toString().equals("frans") &&
                                (password.getText().toString().equals("thamura"))
                                ) {
                            Toast.makeText(UserActivity.this, "User and Password is correct", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent("com.meruvian.simplelogin.simplelogin.SimpleLoginActivity");
                            startActivity(intent);
                        } else {
                            Toast.makeText(UserActivity.this, "User and Password is not correct", Toast.LENGTH_SHORT).show();
                            attempts_count--;
                            if (attempts_count == 0) {
                                login_btn.setEnabled(false);
                            }
                        }
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
