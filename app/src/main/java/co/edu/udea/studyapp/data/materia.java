package co.edu.udea.studyapp.data;

import android.content.ContentValues;

public class materia {

    private String nombre;
    private String fechaDeCreacion;
    private String nombreCreador;
    private String imagen;

    public materia(String n, String f, String nC, String i){
        this.nombre=n;
        this.fechaDeCreacion=f;
        this.nombreCreador=nC;
        this.imagen=i;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getNombreCreador() {
        return nombreCreador;
    }

    public void setNombreCreador(String nombreCreador) {
        this.nombreCreador = nombreCreador;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(materiaContract.materiaEntry.NOMBRE, nombre);
        values.put(materiaContract.materiaEntry.FECHACREACION, fechaDeCreacion);
        values.put(materiaContract.materiaEntry.NOMBRECREADOR, nombreCreador);
        values.put(materiaContract.materiaEntry.IMAGEN, imagen);
        return values;
    }
}
