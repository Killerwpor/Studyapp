package co.edu.udea.studyapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;
import pl.tajchert.nammu.Nammu;
import pl.tajchert.nammu.PermissionCallback;

public class ConfiguracionActivity extends AppCompatActivity {

    private static final String PHOTOS_KEY = "Studyapp";

    // protected RecyclerView recyclerView;

    //  protected View galleryButton;

    //  private ImagesAdapter imagesAdapter;

    // private ArrayList<File> photos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        Nammu.init(this);

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
                EasyImage.openCamera(ConfiguracionActivity.this, 0);
            }
        });

        findViewById(R.id.floatingActionButton3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EasyImage.openGallery(ConfiguracionActivity.this,0);
            }
        });



    }
}






