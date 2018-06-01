package co.edu.udea.studyapp.data;

import android.content.ContentValues;

public class Apunte {

    private String materia;
    private String titulo;
    private String descripcion;
    private String fecha;
    private String imagen;

    public Apunte(String materia, String titulo, String descripcion, String fecha, String img) {
        this.setMateria(materia);
        this.setTitulo(titulo);
        this.setDescripcion(descripcion);
        this.setFecha(fecha);
        this.setImagen(img);
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMateria() {
        return materia;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(ApunteContract.ApunteEntry.MATERIA, materia);
        values.put(ApunteContract.ApunteEntry.DESCRIPCION, descripcion);
        values.put(ApunteContract.ApunteEntry.FECHA, fecha);
        values.put(ApunteContract.ApunteEntry.TITULO, titulo);
        values.put(ApunteContract.ApunteEntry.IMAGEN, imagen);
        return values;
    }
}
