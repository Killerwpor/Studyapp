package co.edu.udea.studyapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import pl.aprilapps.easyphotopicker.EasyImage;
import pl.tajchert.nammu.Nammu;
import pl.tajchert.nammu.PermissionCallback;

public class MateriaPrincipalActivity extends AppCompatActivity {

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
        String nombreMateria=getIntent().getExtras().getString("nombreMateria");
        this.setTitle(nombreMateria);

        TextView textView7 = findViewById(R.id.textView7);

        FontManager fontManager = new FontManager();
        fontManager.changeFont2(textView7, "RobotoCondensed-Bold", getApplicationContext());
        textView7.setTextSize(30);

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
}






