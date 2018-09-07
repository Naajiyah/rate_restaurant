package com.accenture.naajiyahsoobratty.moFaim.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.accenture.naajiyahsoobratty.moFaim.Entities.User;
import com.accenture.naajiyahsoobratty.mopasfaim.R;
import com.accenture.naajiyahsoobratty.moFaim.Repositories.UserRepository;

public class Login extends AppCompatActivity {

    private static final String LOG_TAG = "Login";

    private EditText username;
    private EditText password;
    private UserRepository userRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void onClickLogin(View view){
        username=findViewById(R.id.editText_username);
        password=findViewById(R.id.editText_password);
        userRepository = new UserRepository(this);

        User user=userRepository.loginAuthentication(username.getText().toString(),password.getText().toString());
        if(user!=null){
            Intent toDashboardActivity = new Intent(this, Dashboard.class);

            SharedPreferences sharedPref= this.getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("user_id",user.getUserId());
            editor.commit();



            startActivity(toDashboardActivity);

        }
        else{
            Toast.makeText(this, "Username or password incorrect. Please try again", Toast.LENGTH_SHORT).show();

        }

    }
    public void onClickRegister( View view){
        Intent toDashboardActivity = new Intent(this, Registration.class);
        startActivity(toDashboardActivity);
    }
}
