package mx.edu.utng.hibernate.dbhelper;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.hibernate.model.Pregunta;
import mx.edu.utng.hibernate.Result;

/**
 * Created by Erika Cabrera on 13/04/2016.
 */
public class DBHelperCuestionario extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "custionarios.db";
    private static final String TABLE_NAME_RESULT = "resultado";
    private static final String COLUMN_RESULT = "score";

    //datos para crear la tabla del qiz
    private static final String TABLE_NAME_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "qid";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; // correct option
    private static final String KEY_OPTA = "opta"; // option a
    private static final String KEY_OPTB = "optb"; // option b
    private static final String KEY_OPTC = "optc"; // option c


    SQLiteDatabase db;

    private static final String TABLE_CREATE_RESULT = "create table "+ TABLE_NAME_RESULT+" (id integer primary key not null , " +
            "score integer not null);";

    public DBHelperCuestionario(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sql);
        //db.execSQL(TABLE_CREATE_QUIZ);
        db.execSQL(TABLE_CREATE_RESULT);
        for (int i = 1; i <=6 ; i++) {
            db.execSQL("INSERT INTO "+TABLE_NAME_RESULT +" VALUES("+i+", 0)");
        }

        addQuestion();
    }
//Traer seutado del cuestionario
    public  int  traerResult(int id){
        int score=0;
        String selectQuery = "SELECT  id, score FROM " + TABLE_NAME_RESULT+ " WHERE id= "+id;
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Result re = new Result();
                //int id= re.setIdResult(cursor.getInt(0));
                score = re.setResult(cursor.getInt(1));

                return score;
            } while (cursor.moveToNext());
        }
        return score;


    }

    public void actualizarQuiz(Result re, int numQuiz){

        db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(COLUMN_RESULT, re.getResult());
        //Actualizamos el registro en la base de datos
        db.update(TABLE_NAME_RESULT, valores, "id = " + numQuiz, null);
        db.close();


    }


    private void addQuestion() {


        //preguntas del quiz I
        Pregunta q = new Pregunta(

                "¿Define que es Hibernate?","Un Gestor de base de datos","Herramienta de Mapeo-Objeto-Relacional","Es un acrónimo de STRUTS","Herramienta de Mapeo-Objeto-Relacional");
        this.addQuestion(q);
        Pregunta q1 = new Pregunta("¿Para que otra plataforma esta disponible Hibernate?",".Net","C++","SQL Server", ".Net");
        this.addQuestion(q1);
        Pregunta q2 = new Pregunta("¿Qué archivos declarativos utiliza Hibernate","XML","HTML","CSS", "XML");
        this.addQuestion(q2);
        //preguntas del quiz II
        Pregunta q3=new Pregunta("¿Cómo definen a hibernate sus propios autores?","Como una herramienta de mapeo objeto/relacional", "Como un sitío wen", "Como una sentencia de codigo", "Como una herramienta de mapeo objeto/relacional");
        this.addQuestion(q3);
        Pregunta q4=new Pregunta("Ademáas de encargarse del mapeo de clases Java de que mas se encarga Hibernate?","Maneja los queries y recuperación de datos", "Maneja objetos", "Maneja formularios", "Maneja los queries y recuperación de datos");
        this.addQuestion(q4);
        Pregunta q5=new Pregunta("En que porcentaje se encarga hibernate de las tareas relaciondas con las persistencias","95%", "50%", "100%", "95%" );
        this.addQuestion(q5);
        Pregunta q6=new Pregunta("Procesar los datos del formulario con el metodo:","Execute", "Query", "Ejecutar", "Execute");
        this.addQuestion(q6);
        Pregunta q7=new Pregunta("¿Cuántas cosas tiene la recepcion de formulario?","8", "7", "9", "7");
        this.addQuestion(q7);
        //preguntas del quiz III
        Pregunta q8 = new Pregunta(
                "Interceptores que se espera que se usen en todos los casos, hasta los más básicos. Se refiere a:","BasicStack", "Accion","Tecnica de programacion", "BasicStack" );
        this.addQuestion(q8);
        Pregunta q9 = new Pregunta("Después que un Action ha sido procesado se debe enviar la respuesta de regreso al usuario, esto se realiza usando :", "JSP", "Results", "Validación","Results");
        this.addQuestion(q9);
        Pregunta q10 = new Pregunta("¿Que son los action?", "Validaciones", "Son clases encargadas de realizar la lógica para servir una petición", "Lenguaje de programacion", "Son clases encargadas de realizar la lógica para servir una petición");
        this.addQuestion(q10);
        //preguntas del quiz IV
        Pregunta q11 = new Pregunta(
                "Tipos Result","Resil", "Object Graph Navigation Languaje", "No es un acronimo de STRUTS", "Object Graph Navigation Languaje");
        this.addQuestion(q11);
        Pregunta q12 = new Pregunta("¿Qué permite leer OGNL?", "Valores de objectos", "Las clases ", "Lenguaje de programación", "Valores de objectos");
        this.addQuestion(q12);
        Pregunta q13 = new Pregunta("¿Qué usa OGNL","Objectos?", "Usa un contexto estándar de nombres para evaluar las expresiones","Etiquetas", "Usa un contexto estándar de nombres para evaluar las expresiones");
        this.addQuestion(q13);
        //preguntas del quiz V
        Pregunta q14 = new Pregunta(
                "DBhelper ayuda a struts :","si", "no", "nunca", "si");
        this.addQuestion(q14);
        Pregunta q15 = new Pregunta("OGNL maneja siempre un objeto raízñ ", "Objeto default ", "Results", "Validacion","Objeto default ");
        this.addQuestion(q15);
        Pregunta q16 = new Pregunta("¿QuË permite leer OGNL", "Valores de objectos", "Las clases ", "Lenguaje de programacion", "Valores de objectos");
        this.addQuestion(q16);
        //preguntas del quiz VI
        Pregunta q17 = new Pregunta(
                "¿Cada interceptor proporciona una característica distinta?","Action", "Timer", "Validacion", "Action");
        this.addQuestion(q17);
        Pregunta q18 = new Pregunta("¿Qué son los action?", "Validaciones", "Son clases encargadas de realizar la lógica para servir una petición", "Lenguaje de programación", "Son clases encargadas de realizar la lógica para servir una petición");
        this.addQuestion(q18);
        Pregunta q19 = new Pregunta("Los interceptores que se espera se usen en todos los casos, hasta los más básicos. Se refiere a","BasicStack", "Accion","Técnica de programación", "BasicStack" );
        this.addQuestion(q19);

      /*  Pregunta q20 = new Pregunta( "Cuantos caminos tiene el siguiente codigo",
                "Cobertura", "Focalización", "Regresión", "Cobertura");
        this.addQuestion(q20);*/

        // END
    }

    // poner una nueva pregunta
    public void addQuestion(Pregunta quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserting Row
        db.insert(TABLE_NAME_QUEST, null, values);
    }

    public List<Pregunta> getAllQuestions() {
        List<Pregunta> quesList = new ArrayList<Pregunta>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME_QUEST;
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
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
        // return quest list
        return quesList;

    }


    public int porsentajeCuerso(){
        int q1 =traerResult(1);
        int q2 =traerResult(2);
        int q3 =traerResult(3);
        int q4 =traerResult(4);
        int q5 =traerResult(5);
        int q6 =traerResult(6);
        int suma;
        int porsentaje;
        suma= q1+q2+q3+q4+q5+q6;
        porsentaje= suma/6;
        return porsentaje;
    }







    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+ TABLE_NAME_RESULT+", "+ TABLE_NAME_QUEST;
        db.execSQL(query);
        this.onCreate(db);

    }
}
