package org.pmm.appsencilla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		Intent i = this.getIntent();
		if(i!=null){
			Bundle b = i.getExtras();
			long duracion = b.getLong("time",-1);
			float x = b.getFloat("x");
			float y = b.getFloat("y");
			TextView tv1 = (TextView)findViewById(R.id.textView1);
			tv1.setText("Tiempo pulsado: "+duracion+" ms");
			TextView tv2 = (TextView)findViewById(R.id.textView2);
			tv2.setText("Coordenadas finales: "+x+", "+y);
		}
	}
	
	
}
