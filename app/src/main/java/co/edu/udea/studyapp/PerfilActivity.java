package co.edu.udea.studyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    private TextView textView2, textView3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        FontManager fontManager = new FontManager();

        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        fontManager.changeFont2(textView2, "RobotoCondensed-Light", getApplicationContext());
        fontManager.changeFont2(textView3, "RobotoCondensed-Light", getApplicationContext());
        fontManager.changeFont2(textView4, "RobotoCondensed-Light", getApplicationContext());
    }
}
