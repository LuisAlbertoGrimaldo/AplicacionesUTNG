package mx.edu.utng.structs_final.dbhelper;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.structs_final.model.Question;
import mx.edu.utng.structs_final.model.Result;

/**
 * Created by Saul on 13/04/2016.
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
        Question q = new Question(

                        "¿A qué se refiere con OGNL?","OGNL","Object Graph Navigation Languaje","No es un acrónimo de STRUTS","Object Graph Navigation Languaje");
        this.addQuestion(q);
        Question q1 = new Question("¿Qué permite leer OGNL?","Valores de objectos","Las clases ","Lenguaje de programación", "Valores de objectos");
        this.addQuestion(q1);
        Question q2 = new Question("¿Qué usa OGNL?","Objectos","Usa un contexto estándar de nombres para evaluar las expresiones","Etiquetas", "Usa un contexto estándar de nombres para evaluar las expresiones");
        this.addQuestion(q2);
        //preguntas del quiz II
        Question q3=new Question("¿Qué etiqueta se utiliza en JSP?","<s:form>", "<s:title>", "<s:div", "<s:form>");
        this.addQuestion(q3);
        Question q4=new Question("Model Driven es :","Proporciona para poder establecer todos los parámetros que se reciben de un formulario", "Modelo. ", "Formularios", "Proporciona para poder establecer todos los parámetros que se reciben de un formulario");
        this.addQuestion(q4);
        Question q5=new Question("Para indicarle a Struts 2 que este Action será Model Driven se encarga la clase","ActionMD", "Ninguna", "ActionSupport", "ActionMD" );
        this.addQuestion(q5);
        Question q6=new Question("Procesar los datos del formulario con el método:","Execute", "Query", "Ejecutar", "Execute");
        this.addQuestion(q6);
        Question q7=new Question("¿Cuántas cosas tiene la recepcion de formulario?","8", "7", "9", "7");
        this.addQuestion(q7);
        //preguntas del quiz III
        Question q8 = new Question(
                "Interceptores que se espera que se usen en todos los casos, hasta los más básicos. Se refiere a:","BasicStack", "Accion","Técnica de programación", "BasicStack" );
        this.addQuestion(q8);
        Question q9 = new Question("Después que un Action ha sido procesado se debe enviar la respuesta de regreso al usuario, esto se realiza usando :", "JSP", "Results", "Validación","Results");
        this.addQuestion(q9);
        Question q10 = new Question("¿Qué son los action?", "Validaciones", "Son clases encargadas de realizar la lógica para servir una petición", "Lenguaje de programación", "Son clases encargadas de realizar la lógica para servir una petición");
        this.addQuestion(q10);
        //preguntas del quiz IV
        Question q11 = new Question(
                "¿Qué muestra un action en Tipos Result al terminar su ejecución?","Resultad", "Object Graph Navigation Languaje", "No es un acrónimo de STRUTS", "Resultado");
        this.addQuestion(q11);
        Question q12 = new Question("¿Cuál es un ejemplo de tipo de result?", "Dispatcher", "Las clases ", "Lenguaje de programación", "Dispatcher");
        this.addQuestion(q12);
        Question q13 = new Question("¿Qué usa OGNL?","Objectos", "Usa un contexto estándar de nombres para evaluar las expresiones","Etiquetas", "Usa un contexto estándar de nombres para evaluar las expresiones");
        this.addQuestion(q13);
        //preguntas del quiz V
        Question q14 = new Question(
                "¿Cada uno de los tipos de results pueden recibir varios parámetros?","Si", "No", "Nunca", "Si");
        this.addQuestion(q14);
        Question q15 = new Question("¿OGNL maneja siempre un objeto raíz?", "Objeto default ", "Results", "Validación","Objeto default ");
        this.addQuestion(q15);
        Question q16 = new Question("¿Qué es ValueStack?", "1 objecto", "Muchos objectos", "Lenguaje de programación", "Muchos objectos");
        this.addQuestion(q16);
        //preguntas del quiz VI
        Question q17 = new Question(
                "¿Cada interceptor proporciona una característica distinta?","Location", "Timer", "Validacion", "Location");
        this.addQuestion(q17);
        Question q18 = new Question("¿Cuál es tipo dispatcher pueden recibir dos parámetros?", "Validaciones", "Son clases encargadas de realizar la lógica para servir una petición", "Lenguaje de programación", "Son clases encargadas de realizar la lógica para servir una petición");
        this.addQuestion(q18);
        Question q19 = new Question("Menciona un parámetro que puede recibir un tipo de result","Status", "Accion","Técnica de programación", "Status" );
        this.addQuestion(q19);


    }

    // poner una nueva pregunta
    public void addQuestion(Question quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Insertar
        db.insert(TABLE_NAME_QUEST, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
                    // consulta
                    String selectQuery = "SELECT  * FROM " + TABLE_NAME_QUEST;
                    db = this.getReadableDatabase();
                    Cursor cursor = db.rawQuery(selectQuery, null);
                    // agrega a la lista
                    if (cursor.moveToFirst()) {
                        do {
                            Question quest = new Question();
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
