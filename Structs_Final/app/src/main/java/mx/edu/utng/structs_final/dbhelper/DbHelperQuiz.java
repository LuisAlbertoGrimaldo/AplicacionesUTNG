package mx.edu.utng.structs_final.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.structs_final.model.Pregunta;

/**
 * Created by Saul on 01/03/2016.
 */
public class DbHelperQuiz extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Nombre de la base de datos
    private static final String DATABASE_NAME = "Quiz2";
    // nombre de kas tablas
    private static final String TABLE_QUEST = "quest";
    // nombre de las columnas
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private SQLiteDatabase dbase;
    public DbHelperQuiz(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }
    private void addQuestions()
    {
        Pregunta q1=new Pregunta(
                "Cada interceptor proporciona una característica distinta","Action", "Timer", "Validacion", "Action");
        this.addQuestion(q1);
        Pregunta q2=new Pregunta("Que son los action ?", "Validaciones", "Son clases encargadas de realizar la lógica para servir una petición", "Lenguaje de programacion", "Son clases encargadas de realizar la lógica para servir una petición");
        this.addQuestion(q2);
        Pregunta q3=new Pregunta("Los interceptores que se espera se usen en todos los casos, hasta los más básicos. Se refiere a","BasicStack", "Accion","Tecnica de progrmacion", "BasicStack" );
        this.addQuestion(q3);
        Pregunta q4=new Pregunta("Después que un Action ha sido procesado se debe enviar la respuesta de regreso al usuario, esto se realiza usando", "JSP", "Results", "Validacion","Results");this.addQuestion(q4);
        Pregunta q5=new Pregunta("Struts 2 procesa las peticiones usando tres elementos principales:","Verdadero","Depende de como se aplique","Falso","Verdadero");
        this.addQuestion(q5);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Eliminar si exite
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        //Crear otra vez
        onCreate(db);
    }
    // Agregar nuevas preguntas
    public void addQuestion(Pregunta quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Pregunta> getAllQuestions() {
        List<Pregunta> quesList = new ArrayList<Pregunta>();
        // Consulta
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        //Mover
        if (cursor.moveToFirst()) {
            do {
                Pregunta quest = new Pregunta();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // regresa la lista
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}
