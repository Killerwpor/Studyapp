package co.edu.udea.studyapp.data;

import android.provider.BaseColumns;

public class ApunteContract {

    public static abstract class ApunteEntry implements BaseColumns {
        public static final String TABLE_NAME = "Apunte";

        public static final String MATERIA = "materia";
        public static final String TITULO   = "titulo";
        public static final String DESCRIPCION= "descripcion";
        public static final String FECHA = "fecha";
        public static final String IMAGEN = "imagen";
    }

}
