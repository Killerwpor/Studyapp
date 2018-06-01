package co.edu.udea.studyapp.data;

import android.provider.BaseColumns;

public class MateriaContract {

    public static abstract class materiaEntry implements BaseColumns {
        public static final String TABLE_NAME = "Materia";

        public static final String NOMBRE = "nombre";
        public static final String FECHACREACION = "fechaDeCreacion";
        public static final String NOMBRECREADOR= "nombreCreador";
        public static final String IMAGEN = "imagen";
        public static final String DESCRIPCION = "descripcion";
    }
}
