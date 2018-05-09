package co.edu.udea.studyapp.data;

public class Apunte {

    private String materia;
    private String titulo;
    private String descripcion;
    private String fecha;

    public Apunte(String materia, String titulo, String descripcion, String fecha) {
        this.setMateria(materia);
        this.setTitulo(titulo);
        this.setDescripcion(descripcion);
        this.setFecha(fecha);
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
}
