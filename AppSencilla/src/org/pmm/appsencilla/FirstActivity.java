package org.pmm.appsencilla;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class FirstActivity extends Activity {
	
	private Calendar tiempoInicial;
	private Calendar tiempoFinal;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_sencilla);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event){
		float x = event.getX();
		float y = event.getY();
		
		switch(event.getAction()){
			case MotionEvent.ACTION_DOWN: 
				tiempoInicial=Calendar.getInstance();
				break;
			case MotionEvent.ACTION_UP:
				tiempoFinal=Calendar.getInstance();
				long duracion=tiempoFinal.getTimeInMillis()-tiempoInicial.getTimeInMillis();
				x = event.getX();
				y = event.getY();
				Intent i = new Intent(this, ResultsActivity.class);
				Bundle b = new Bundle();
				b.putLong("time", duracion);
				b.putFloat("x", x);
				b.putFloat("y", y);
				i.putExtras(b);
				startActivity(i);
				break;
			case MotionEvent.ACTION_MOVE:
				x = event.getX();
				y = event.getY();
				TextView tv = (TextView)findViewById(R.id.tv);
				tv.setText("Coordenadas: "+x+", "+y);
				break;
		}
		
		return super.onTouchEvent(event);
	}
}
