package co.edu.udea.studyapp.data;

import android.provider.BaseColumns;

public class materiaContract {

    public static abstract class materiaEntry implements BaseColumns {
        public static final String TABLE_NAME = "Materia";

        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String FECHACREACION = "fechaDeCreacion";
        public static final String NOMBRECREADOR= "nombreCreador";
        public static final String IMAGEN = "imagen";
    }
}
