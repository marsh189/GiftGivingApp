package com.hci.marsh189.giftgiving;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private TextView title;
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button photoBtn;
    private Button newUserBtn;
    private Button signInBtn;

    private String username;
    private String password;
    private String name;
    private String email;

    private SQLiteHelper db;

    private SQLDatabaseConnection query = new SQLDatabaseConnection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        title = (TextView)findViewById(R.id.loginTitle);
        nameEditText = (EditText)findViewById(R.id.nameTextBox);
        emailEditText = (EditText)findViewById(R.id.emailTextBox);
        usernameEditText = (EditText)findViewById(R.id.usernameTextBox);
        passwordEditText = (EditText)findViewById(R.id.passwordTextBox);
        photoBtn = (Button)findViewById(R.id.photoBtn);
        newUserBtn = (Button)findViewById(R.id.newUserBtn);
        signInBtn = (Button)findViewById(R.id.signIn);

        db = new SQLiteHelper(getApplicationContext());

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameEditText.getVisibility() == View.GONE)
                {
                    username = usernameEditText.getText().toString();
                    password = passwordEditText.getText().toString();
                    if(!username.equals("") && !password.equals(""))
                    {
                        boolean login = Login(username, password);
                        if(login)
                        {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("username", LoginActivity.this.username);
                            intent.putExtra("name", LoginActivity.this.name);
                            intent.putExtra("password", LoginActivity.this.email);
                            LoginActivity.this.startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "PLEASE ENTER A USERNAME AND PASSWORD", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(nameEditText.getVisibility() == View.VISIBLE)
                {
                    username = usernameEditText.getText().toString();
                    password = passwordEditText.getText().toString();
                    name = nameEditText.getText().toString();
                    email = emailEditText.getText().toString();

                    if(!username.equals("") && !password.equals("") && !name.equals("") && !email.equals(""))
                    {
                        RegisterUser(username, password, name, email);
                        Toast.makeText(LoginActivity.this, "SUCCESS", Toast.LENGTH_SHORT).show();
                    }
                    else if(username.equals(""))
                    {
                        Toast.makeText(LoginActivity.this, "USERNAME REQUIRED", Toast.LENGTH_SHORT).show();
                    }
                    else if(password.equals(""))
                    {
                        Toast.makeText(LoginActivity.this, "PASSWORD REQUIRED", Toast.LENGTH_SHORT).show();
                    }
                    else if(name.equals(""))
                    {
                        Toast.makeText(LoginActivity.this, "NAME REQUIRED", Toast.LENGTH_SHORT).show();
                    }
                    else if(username.equals(""))
                    {
                        Toast.makeText(LoginActivity.this, "EMAIL REQUIRED", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void RegisterUser(String username, String password, String name, String email)
    {
       boolean success = db.addUser(username, password,name,email);
       
       if(success)
       {
           boolean login = Login(username, password);
           if(login)
           {
               Intent intent = new Intent(LoginActivity.this, MainActivity.class);
               intent.putExtra("username", LoginActivity.this.username);
               intent.putExtra("name", LoginActivity.this.name);
               intent.putExtra("password", LoginActivity.this.email);
               LoginActivity.this.startActivity(intent);
           }
       }
       else
       {
           Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
       }
    }

    public void newUserClicked(View view)
    {
        if(nameEditText.getVisibility() == View.GONE)
        {
            title.setText("New User");
            newUserBtn.setText("Back");
            nameEditText.setVisibility(View.VISIBLE);
            emailEditText.setVisibility(View.VISIBLE);
            photoBtn.setVisibility(View.VISIBLE);

        }
        else if(nameEditText.getVisibility() == View.VISIBLE)
        {
            title.setText("Sign In");
            newUserBtn.setText("New User");
            nameEditText.setVisibility(View.GONE);
            emailEditText.setVisibility(View.GONE);
            photoBtn.setVisibility(View.GONE);
        }
    }

    private boolean Login(String username, String password)
    {
        Cursor results = db.getUser(username);
        if(results.getCount() > 0)
        {
            StringBuffer buffer = new StringBuffer();
            while(results.moveToNext())
            {
                String u = results.getString(0);
                String p = results.getString(1);
                if(username.equals(u) && password.equals(p))
                {
                    this.username = username;
                    this.name = results.getString(2);
                    this.email = results.getString(3);
                    return true;
                }
            }
        }
        else
        {
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
        }

        return false;
    }
}
