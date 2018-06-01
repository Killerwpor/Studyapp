package co.edu.udea.studyapp.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {


    public dbHelper(Context context) {
        super(context, "StudyappDB",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

            sqLiteDatabase.execSQL("CREATE TABLE " + MateriaContract.materiaEntry.TABLE_NAME + " ("
                    + MateriaContract.materiaEntry.NOMBRE + " TEXT PRIMARY KEY, "
                    + MateriaContract.materiaEntry.NOMBRECREADOR + " TEXT NOT NULL,"
                    + MateriaContract.materiaEntry.DESCRIPCION + " TEXT NOT NULL,"
                    + MateriaContract.materiaEntry.FECHACREACION + " TEXT NOT NULL,"
                    + MateriaContract.materiaEntry.IMAGEN + " TEXT NOT NULL,"
                    + "UNIQUE (" + MateriaContract.materiaEntry.NOMBRE + "))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public long guardarMateria(Materia m) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                MateriaContract.materiaEntry.TABLE_NAME,
                null,
                m.toContentValues());

    }

    public Cursor obtenerTodasLasMaterias() {
        return getReadableDatabase()
                .query(
                        MateriaContract.materiaEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

}
