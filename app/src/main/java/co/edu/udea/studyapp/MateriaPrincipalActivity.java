package co.edu.udea.studyapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.studyapp.data.Apunte;
import co.edu.udea.studyapp.data.dbHelper;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;
import pl.tajchert.nammu.Nammu;
import pl.tajchert.nammu.PermissionCallback;

public class MateriaPrincipalActivity extends AppCompatActivity {

    private static final String PHOTOS_KEY = "Studyapp";
    private ArrayList<File> photos = new ArrayList<>();
    String nombreMateria;
    FloatingActionButton botonCalendario;

    // protected RecyclerView recyclerView;

    //  protected View galleryButton;

    //  private ImagesAdapter imagesAdapter;

    // private ArrayList<File> photos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        Nammu.init(this);
        nombreMateria=getIntent().getExtras().getString("nombreMateria");
        if(nombreMateria!=null){
            this.setTitle(nombreMateria);
       }

botonCalendario=findViewById(R.id.botonCalendario);

        botonCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), calendarioActivity.class);
                startActivity(intent);


            }
        });

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Nammu.askForPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE, new PermissionCallback() {
                @Override
                public void permissionGranted() {
                    //Nothing, this sample saves to Public gallery so it needs permission
                }

                @Override
                public void permissionRefused() {
                    finish();
                }
            });
        }

        EasyImage.configuration(this)
                .setImagesFolderName("EasyImage sample")
                .setCopyTakenPhotosToPublicGalleryAppFolder(true)
                .setCopyPickedImagesToPublicGalleryAppFolder(true)
                .setAllowMultiplePickInGallery(true);

        // checkGalleryAppAvailability();


        findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EasyImage.openCamera(MateriaPrincipalActivity.this, 0);
            }
        });

        findViewById(R.id.floatingActionButton3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EasyImage.openGallery(MateriaPrincipalActivity.this,0);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {
                //Some error handling
            }

            @Override
            public void onImagesPicked(List<File> imagesFiles, EasyImage.ImageSource source, int type) {
                //Handle the images
                onPhotosReturned(imagesFiles);

            }
        });
    }

    private void onPhotosReturned(List<File> returnedPhotos) {
        photos.addAll(returnedPhotos);
        Log.d("ERROR","ENTRO AL METODO0");
        Apunte a=new Apunte("Apunte","titulo","descripcion","fecha",returnedPhotos.get(0).toString());
        dbHelper db=new dbHelper(getApplicationContext());
        db.guardarApunte(a);


        Intent intent = new Intent(getApplicationContext(), ApuntesActivity.class);
         //intent.putExtra("fotos", (Serializable) returnedPhotos);
        startActivity(intent);


    }

}






