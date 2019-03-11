package lk.ac.kln.countdowntimer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
private int counter = 99;
private boolean running;
private boolean wasrunning;
private static final String CURRENT_COUNTER = "counter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = savedInstanceState.getInt(CURRENT_COUNTER);
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

                  textView.setText(Integer.toString(counter));
                    counter--;
                  handler.postDelayed(this,1000 );

            }
        });

    }
}
