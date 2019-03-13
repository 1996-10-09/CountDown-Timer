package lk.ac.kln.countdowntimer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
private int counter = 99;
private boolean running =false;
private boolean wasrunning = false;
private static final String CURRENT_COUNTER = "counter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null) {
            counter = savedInstanceState.getInt(CURRENT_COUNTER);
        }
        running = true;
        countdown();
    }

      @Override

      public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(CURRENT_COUNTER,counter);
      }


    private void countdown() {
        final TextView textView = findViewById(R.id.textView);
         final Handler handler = new Handler();
         handler.post(new Runnable(){


        @Override
              public void run(){
                    final TextView textView  = findViewById(R.id.textView);
                  textView.setText(Integer.toString(counter));
                  if(counter==0){
                      counter =99;
                  }
                  if(running) {
                      counter--;
                  }
                  handler.postDelayed(this,1000 );

            }
        });

    }

        protected void startCounter(View view){
        running = true;
        }
    protected void stopCounter(View view){
        running = false;
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onRestart(){
        super.onRestart();
        running = true;
    }
    @Override
    public void onStart(){
        super.onStart();
        running = true;
    }

    @Override
    public void onStop() {
        super.onStop();
        running = false;


    }
}
