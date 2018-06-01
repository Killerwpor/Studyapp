package co.edu.udea.studyapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import co.edu.udea.studyapp.data.Apunte;
import co.edu.udea.studyapp.data.ApunteContract;
import co.edu.udea.studyapp.data.Materia;
import co.edu.udea.studyapp.data.MateriaContract;
import co.edu.udea.studyapp.data.dbHelper;




public class ApuntesActivity extends AppCompatActivity {

    CardView card;
    private FloatingActionButton botonAgregar,botonEliminar;
    private RecyclerView recyclerViewApunte;
    private RecyclerViewAdapterFoto adaptadorApunte;
    private List<Apunte> listaMaterias;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apuntes);


        recyclerViewApunte = findViewById(R.id.content_main_recycler_preview);
        botonAgregar=findViewById(R.id.botonAgregar);
        //botonEliminar=findViewById(R.id.botonEliminar);
        card=findViewById(R.id.card);


        botonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(), MateriaPrincipalActivity.class);
                startActivityForResult(intent,1);
                actualizarApuntes();


            }
        });






/*
        botonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper db=new dbHelper(getApplicationContext());
                String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
                Apunte a=new Apunte("Logica","titulo","ninguna",date,"ninguna");
                db.guardarApunte(a);
            }
        });

*/






        //aquí se actualiza la lista de materias que aparece en el main
       actualizarApuntes();

        //Aquí se piden permisos para usar la camara

        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, 0);
        }





    }











    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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


    private void obtenerApuntesPreview() {

        listaMaterias = new ArrayList<>();
        dbHelper db = new dbHelper(getApplicationContext());
        String nombre, fecha, nombreCreador, imagen, descripcion;
        Uri fotoUri;
        Cursor c = db.obtenerTodosLosApuntes();
        Apunte ap;

        while (c.moveToNext()) { //se obtiene nombre, precio, foto e ingredientes por registro, por eso esta en un while
    //        nombre = c.getString(c.getColumnIndex(ApunteContract.ApunteEntry.MATERIA));
//            fecha = c.getString(c.getColumnIndex(MateriaContract.materiaEntry.FECHACREACION));
          imagen = c.getString(c.getColumnIndex(ApunteContract.ApunteEntry.IMAGEN));
      //      descripcion = c.getString(c.getColumnIndex(MateriaContract.materiaEntry.DESCRIPCION));
            // fotoUri = Uri.parse(foto); //se convierte la foto a Uri
        //    nombreCreador = c.getString(c.getColumnIndex(MateriaContract.materiaEntry.NOMBRECREADOR));
            ap = new Apunte("Materia","Titulo","descripción","fecha",imagen);
            Log.d("ERRORFOTO","imagen: "+imagen);
            listaMaterias.add(ap);


        }

       // ap = new Apunte("Materia","Titulo","descripción","fecha","imagen");

    }

    private void actualizarApuntes() {
        obtenerApuntesPreview();
        new Handler().postDelayed(new Runnable(){
            public void run(){
                recyclerViewApunte.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adaptadorApunte = new RecyclerViewAdapterFoto(listaMaterias);

              /*
                adaptadorApunte.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nombreMateria=listaMaterias.get(recyclerViewApunte.getChildAdapterPosition(view)).getMateria();
                        Intent intent = new Intent (getApplicationContext(), MateriaPrincipalActivity.class);
                        intent.putExtra("nombreMateria",nombreMateria);
                        startActivity(intent);

                    }
                });
                */
                recyclerViewApunte.setAdapter(adaptadorApunte);
            };
        }, 50);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { //se espera a que la activity terminé y mande una señal que diga que terminó
        if (requestCode == 1) { // el "1" es el numero que pasaste como parametro
            if(resultCode == MateriasActivity.RESULT_OK){
                String result=data.getStringExtra("datos");
                // tu codigo para continuar procesando
                if(result.equals("termine")){
                    actualizarApuntes();
                }
            }
            if (resultCode == MateriasActivity.RESULT_CANCELED) {
                // código si no hay resultado
            }
        }
    }

}
