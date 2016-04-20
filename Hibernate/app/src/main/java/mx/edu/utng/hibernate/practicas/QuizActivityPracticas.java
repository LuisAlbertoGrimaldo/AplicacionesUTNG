package mx.edu.utng.hibernate.practicas;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import mx.edu.utng.hibernate.R;

/**
 * Created by erika on 01/03/2016.
 */
public class QuizActivityPracticas extends Activity {
    List<PreguntaPracticas> quesListPracticas;
    int score=0;
    int qid=0;
    PreguntaPracticas currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    Button butNext;
    TextView times;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        DbHelperQuizPracticas db=new DbHelperQuizPracticas(this);
        quesListPracticas=db.getAllQuestions();
        currentQ=quesListPracticas.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        butNext=(Button)findViewById(R.id.button1);
        setQuestionView();
        times = (TextView) findViewById(R.id.timers);
        // method which will set the things up for our game
        setQuestionView();
        times.setText("00:02:00");
        // A timer of 60 seconds to play for, with an interval of 1 second (1000 milliseconds)
        CounterClass timer = new CounterClass(180000, 1000);
        timer.start();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
                Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());
                if(currentQ.getANSWER().equals(answer.getText()))
                {
                    score++;
                    Log.d(getString(R.string.sc), getString(R.string.score)+score);
                }
                if(qid<5){
                    currentQ=quesListPracticas.get(qid);
                    setQuestionView();
                }else{
                    Intent intent = new Intent(QuizActivityPracticas.this, ResultadoActivityPracticas.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }
        @Override
        public void onFinish() {
            times.setText("El tiempo acabo");
        }
        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub
            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            times.setText(hms);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_quiz_dos, menu);
        return true;
    }
    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        qid++;
    }
}