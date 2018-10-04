package id.or.qodr.dragtext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private float dX;
    private float dY;
    private int lastAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView drag = findViewById(R.id.root);
        drag.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
          switch (event.getAction()){
              case MotionEvent.ACTION_DOWN:
                  lastAction = MotionEvent.ACTION_DOWN;
                  dX = v.getX() - event.getRawX();
                  dY = v.getY() - event.getRawY();
                  break;
                  case MotionEvent.ACTION_MOVE:
                  lastAction = MotionEvent.ACTION_MOVE;
                  v.setX(event.getRawX());
                  v.setY(event.getRawY());
                  break;
              case MotionEvent.ACTION_UP:
                  if (lastAction == MotionEvent.ACTION_DOWN){
                      Toast.makeText(this, "Di klik",Toast.LENGTH_LONG).show();
                  }
                  break;
          }
          return true;
    }
}
