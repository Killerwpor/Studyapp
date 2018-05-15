package co.edu.udea.studyapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.enums.EPickType;
import com.vansuita.pickimage.listeners.IPickCancel;
import com.vansuita.pickimage.listeners.IPickClick;
import com.vansuita.pickimage.listeners.IPickResult;
import com.vansuita.pickimage.util.Util;

import java.io.File;


public class FragmentPrueba extends Fragment {




    TextView label;
    public final static int RESP_TOMAR_FOTO = 1000;


    public FragmentPrueba() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //PickImageDialog.build(new PickSetup()).show(this.getActivity());
Listener();

        return inflater.inflate(R.layout.fragment_fragment_prueba, container, false);


    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        label=getView().findViewById(R.id.label);
    }

    private void Listener(){
        PickSetup setup = new PickSetup().setTitle("Escoja una opción").setCancelText("Cancelar").setCameraButtonText("Camara").setGalleryButtonText("Galeria");
     PickImageDialog.build(setup)
             .setOnClick(new IPickClick() {
                 @Override
                 public void onGalleryClick() {
                     label.setText("Galeria");

                 }
                 @Override
                 public void onCameraClick() {
                     label.setText("Camara");
                 }
             }).show(this.getActivity());
 }





}
