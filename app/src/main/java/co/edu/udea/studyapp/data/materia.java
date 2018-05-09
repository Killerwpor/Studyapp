package co.edu.udea.studyapp.data;

import android.content.ContentValues;

public class materia {

    private String nombre;
    private String fechaDeCreacion;
    private String nombreCreador;
    private String imagen;
    private String descripcion;

    public materia(String n, String f, String nC, String i, String d){
        this.nombre=n;
        this.fechaDeCreacion=f;
        this.nombreCreador=nC;
        this.imagen=i;
        this.descripcion=d;
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
        values.put(materiaContract.materiaEntry.DESCRIPCION, descripcion);
        return values;
    }
}
