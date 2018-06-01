package co.edu.udea.studyapp.data;

import android.content.ContentValues;

public class Materia {

    private String nombre;
    private String fechaDeCreacion;
    private String nombreCreador;
    private String imagen;
    private String descripcion;

    public Materia(String n, String f, String nC, String i, String d){
        this.nombre=n;
        this.fechaDeCreacion=f;
        this.nombreCreador=nC;
        this.imagen=i;
        this.setDescripcion(d);
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
        values.put(MateriaContract.materiaEntry.NOMBRE, nombre);
        values.put(MateriaContract.materiaEntry.FECHACREACION, fechaDeCreacion);
        values.put(MateriaContract.materiaEntry.NOMBRECREADOR, nombreCreador);
        values.put(MateriaContract.materiaEntry.IMAGEN, imagen);
        values.put(MateriaContract.materiaEntry.DESCRIPCION, getDescripcion());
        return values;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
