package com.accenture.naajiyahsoobratty.moFaim.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


import com.accenture.naajiyahsoobratty.moFaim.Entities.User;
import com.accenture.naajiyahsoobratty.moFaim.Repositories.UserRepository;
import com.accenture.naajiyahsoobratty.mopasfaim.R;

public class Registration extends AppCompatActivity {
    private static final String LOG_TAG = "Registration";

    private EditText username;
    private EditText email;
    private EditText password;
    //private Button register;
    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


    }


    public void onClickInsertUser(View view){
        username=findViewById(R.id.editText_username);
        email=findViewById(R.id.editText_email);
        password=findViewById(R.id.editText_password);

        userRepository = new UserRepository(this);
        Log.d(LOG_TAG,"Registration page:"+username.getText().toString());



        User user=new User();
        user.setUserName(username.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());
        userRepository.insertUser(user);

        Intent toDashboardActivity = new Intent(this, Dashboard.class);
        startActivity(toDashboardActivity);

    }
}
