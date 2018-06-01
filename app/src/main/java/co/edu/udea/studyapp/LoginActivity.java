package co.edu.udea.studyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

public class LoginActivity extends AppCompatActivity {

    Button botonLogin;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        botonLogin=findViewById(R.id.login_button);
        callbackManager = CallbackManager.Factory.create();

        TextView textView5 = findViewById(R.id.textView5);
        TextView textView6 = findViewById(R.id.textView6);
        EditText editText = findViewById(R.id.editText);
        EditText editText2 = findViewById(R.id.editText2);

        FontManager fontManager = new FontManager();
        fontManager.changeFont2(textView5, "RobotoCondensed-Bold", getApplicationContext());
        fontManager.changeFont2(textView6, "RobotoCondensed-Light", getApplicationContext());
        fontManager.changeFont2(editText, "RobotoCondensed-Light", getApplicationContext());
        fontManager.changeFont2(editText2, "RobotoCondensed-Light", getApplicationContext());

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callbackManager = CallbackManager.Factory.create();

                LoginManager.getInstance().registerCallback(callbackManager,
                        new FacebookCallback<LoginResult>() {
                            @Override
                            public void onSuccess(LoginResult loginResult) {
                                Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }

                            @Override
                            public void onCancel() {
                                // App code
                            }

                            @Override
                            public void onError(FacebookException exception) {
                                // App code
                            }
                        });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

}
