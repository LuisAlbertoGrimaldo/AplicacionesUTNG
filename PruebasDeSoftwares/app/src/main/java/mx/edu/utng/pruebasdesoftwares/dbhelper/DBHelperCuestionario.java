package mx.edu.utng.pruebasdesoftwares.dbhelper;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import mx.edu.utng.pruebasdesoftwares.model.Result;
import mx.edu.utng.pruebasdesoftwares.model.Question;
import mx.edu.utng.pruebasdesoftwares.R;

/**
 * Created by Luis Alberto on 13/04/2016.
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
                "¿Quien propuso la prueba del camino básico ?", "Tom McCabe", "Tom Robert", "Tom Charlie", "Tom McCabe");
        this.addQuestion(q);


        Question q1 = new Question("¿Qué es una prueba de Caja negra y que errores desean encontrar en las categorías?", "Hace una cobertura de declaraciones del código, ramas, caminos y condiciones", "esta basada en la funcionalidad de los módulos del programa", " determina la funcionalidad del sistema", " determina la funcionalidad del sistema");
        this.addQuestion(q1);
        Question q2 = new Question("¿Qué es la complejidad ciclomática es una métrica de calidad software?", "Hace una cobertura de declaraciones del código, ramas, caminos y condiciones", "esta basada en la funcionalidad de los módulos del programa", "basada en el cálculo del número", "basada en el cálculo del número");
        this.addQuestion(q2);
        //preguntas del quiz II
        Question q3=new Question("Las pruebas de caja blanca buscan revisar los caminos, condiciones, " +
                "particiones de control y datos, de las funciones o módulos del sistema; " +
                "para lo cual el grupo de diseño de pruebas debe:",
                "Conformar un grupo de personas para que use el sistema nuevo",
                "Ejecutar sistema nuevo con los datos usados en el sistema actual",
                "Generar registro de datos que ejecute al menos una vez cada instrucción",
                "Generar registro de datos que ejecute al menos una vez cada instrucción");
        this.addQuestion(q3);
        Question q4=new Question("¿Las pruebas unitarias son llamadas?",
                "Pruebas del camino", "Pruebas modulares",
                "Pruebas de complejidad", "Pruebas modulares");
        this.addQuestion(q4);
        Question q5=new Question("¿Qué es una prueba de camino básico?",
                "Hace una cobertura de declaraciones del código",
                "Permite determinar si un modulo esta listo",
                "Técnica de pueba de caja blanca",
                "Técnica de pueba de caja blanca" );
        this.addQuestion(q5);
        Question q6=new Question("Prueba de camino es propuesta:", "Tom McCabe", "McCall ", "Pressman",
                "Tom McCabe");
        this.addQuestion(q6);
        Question q7=new Question("¿Qué es complejidad ciclomatica?","Grafo de flujo","Programming",
                "Metrica","Metrica");
        this.addQuestion(q7);
        //preguntas del quiz III
        Question q8 = new Question(
                "¿Se le llama prueba de regresión?", "Se tienen que hacer nuevas pruebas donde se han probado antes",
                "Manten informes detallados de las pruebas", "Selección de los usuarios que van a realizar las pruebas",
                "Se tienen que hacer nuevas pruebas donde se han probado antes");
        this.addQuestion(q8);
        Question q9 = new Question("¿Cómo se realizan las pruebas de regresión?",
                "Selección de los usuarios que van a realizar las pruebas",
                "Se tienen que hacer nuevas pruebas donde se han probado antes", "A través de herramientas de automatización de pruebas", "A través de herramientas de automatización de pruebas");
        this.addQuestion(q9);
        Question q10 = new Question("¿Cuándo ya hay falta de tiempo para ejecutar casos de prueba ya ejecutadas se dejan?",
                "En primer plano", "En segundo plano", "En tercer plano", "En segundo plano");
        this.addQuestion(q10);
        //preguntas del quiz IV
        Question q11 = new Question(
                "¿En qué se enfocan las pruebas funcionales?",
                "Enfocarse en los requisitos funcionales", "Enfocarse en los requisitos no funcionales",
                "Verificar la apropiada aceptación de datos", "Enfocarse en los requisitos funcionales");
        this.addQuestion(q11);
        Question q12 = new Question("Las metas de estas pruebas son:", "Verificar la apropiada aceptación de datos",
                "Verificar el procesamiento", "Verificar la apropiada aceptación de datos, procedimiento y recuperación",
                "Verificar la apropiada aceptación de datos, procedimiento y recuperación");
        this.addQuestion(q12);
        Question q13 = new Question("¿En qué estan basadas este tipo de pruebas?",
                "Hace una cobertura de declaraciones del código, ramas, caminos y condiciones",
                "Esta basada en la funcionalidad de los módulos del programa",
                "Técnicas de cajas negra", "Técnicas de cajas negra");
        this.addQuestion(q13);
        //preguntas del quiz V
        Question q14 = new Question(
                "¿Cúal es el objetivo de esta técnica?", "Identificar errores introducidos por la combinación de programas probados unitariamente",
                "Decide qué acciones tomar cuando se descubren problemas",
                "Verificar que las interfaces entre las componentes de software funcionan correctamente",
                "Identificar errores introducidos por la combinación de programas probados unitariamente");
        this.addQuestion(q14);
        Question q15 = new Question("¿Cúal es la descripción de la Prueba?",
                "Hace una cobertura de declaraciones del código, ramas, caminos y condiciones",
                "Esta basada en la funcionalidad de los módulos del programa",
                "Describe cómo verificar que las interfaces entre las componentes de software funcionan correctamente",
                "Describe cómo verificar que las interfaces entre las componentes de software funcionan correctamente");
        this.addQuestion(q15);
        Question q16 = new Question("Por cada caso de prueba ejecutado:",
                "Hace una cobertura de declaraciones del código, ramas, caminos y condiciones",
                "Esta basada en la funcionalidad de los módulos del programa",
                "Comparar el resultado esperado con el resultado obtenido", "Comparar el resultado esperado con el resultado obtenido");
        this.addQuestion(q16);
        //preguntas del quiz VI
        Question q17 = new Question(
                "Este tipo de pruebas sirven para garantizar que la calidad del código es realmente óptima:",
                "Pruebas Unitarias", "Pruebas de Calidad de Código",
                "Pruebas de Regresión", "Pruebas de Calidad de Código");
        this.addQuestion(q17);
        Question q18 = new Question("Pruebas de Calidad de código sirven para: ",
                "Hace una cobertura de declaraciones del código, ramas, caminos y condiciones",
                "Verificar que las especificaciones de diseño sean alcanzadas",
                "Garantizar la probabilidad de tener errores o bugs en la codificación", "Garantizar la probabilidad de tener errores o bugs en la codificación");
        this.addQuestion(q18);
        Question q19 = new Question("Este análisis nos indica el porcentaje que nuestro código desarrollado ha sido probado por las pruebas unitarias",
                "Cobertura", "Focalización", "Regresión", "Cobertura");
        this.addQuestion(q19);

        Question q20 = new Question( "¿Qué significa V(G)?",
                "Número de  Regiones", "Número de Aristas", "Número de Nodos", "Número de  Regiones");
        this.addQuestion(q20);

        Question q21 = new Question( "¿Qué significa A?",
                "Número de  Regiones", "Número de Aristas", "Número de Nodos", "Número de Aristas");
        this.addQuestion(q21);

        Question q22 = new Question( "¿Qué significa N?",
                "Número de  Regiones", "Número de Aristas", "Número de Nodos", "Número de Nodos");
        this.addQuestion(q22);

        Question q23 = new Question( "¿Qué significa P?",
                "Número de  Regiones", "Número de Aristas", "Número de Nodos Predicado", "Número de Nodos Predicado");
        this.addQuestion(q23);
        Question q24 = new Question( "De cuantás formas se puede calcular la complejidad ciclomatica V(G):",
                "3", "1", "2", "3");
        this.addQuestion(q24);

        // END
    }

    // poner una nueva pregunta
    public void addQuestion(Question quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserting Row
        db.insert(TABLE_NAME_QUEST, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
                    String selectQuery = "SELECT  * FROM " + TABLE_NAME_QUEST;
                    db = this.getReadableDatabase();
                    Cursor cursor = db.rawQuery(selectQuery, null);
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
