package co.edu.udea.studyapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.studyapp.data.Apunte;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerViewApunte;
    private RecyclerViewAdapterApunte adaptadorApunte;
    private List<Apunte> apuntesPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerViewApunte = findViewById(R.id.content_main_recycler_preview);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, apuntesPreview.get(0).getMateria(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        actualizarApuntes();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        
        int id = item.getItemId();

        Intent intent = null;

        if (id == R.id.nav_materias) {

        } else if (id == R.id.nav_grupos) {
            intent = new Intent (getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_perfil) {
            intent = new Intent(getApplicationContext(), PerfilActivity.class);
        } else if (id == R.id.nav_configuracion) {
            intent = new Intent (getApplicationContext(), MateriaEspecificaActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_cerrar_sesion) {

        }

        if(intent != null){
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void obtenerApuntesPreview(){
        Apunte apunte;
        String materia, titulo, descripcion, fecha;
        apuntesPreview = new ArrayList<>();
        materia = "Computación Móvil";
        titulo = "Proyecto";
        descripcion = "Login con Facebook y CardView de los preview realizados.";
        fecha = "08/05/2018";
        apunte = new Apunte(materia, titulo, descripcion, fecha);
        apuntesPreview.add(apunte);
    }

    private void actualizarApuntes() {
        obtenerApuntesPreview();
        new Handler().postDelayed(new Runnable(){
            public void run(){
                recyclerViewApunte.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adaptadorApunte = new RecyclerViewAdapterApunte(apuntesPreview);
                recyclerViewApunte.setAdapter(adaptadorApunte);
            };
        }, 1000);
    }

}
