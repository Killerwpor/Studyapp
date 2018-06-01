package co.edu.udea.studyapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import co.edu.udea.studyapp.data.Materia;
import co.edu.udea.studyapp.data.dbHelper;

public class MateriasActivity extends AppCompatActivity {

    private Button botonGuardar;
    private TextView campoNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materias);
        botonGuardar=findViewById(R.id.botonAgregar);
        campoNombre=findViewById(R.id.campoNombre);



        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre=campoNombre.getText().toString();
                String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
                Materia m=new Materia(nombre,date,"UsuaroActual","imagen","Sin descripción"); //tring n, String f, String nC, String i, String d)
               dbHelper db=new dbHelper(getApplicationContext());
               db.guardarMateria(m);
                Intent returnIntent = new Intent();
                returnIntent.putExtra("datos","termine");
                setResult(Activity.RESULT_OK,returnIntent);
                finish();


            }
        });
    }
}
