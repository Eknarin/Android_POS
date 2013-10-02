package com.example.androidpos;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText txt_id;
	private EditText txt_name;
	private Button addButton;
	
	private DatabaseController dbc;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initComponent();
		
		addButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				String _id = txt_id.getText().toString();
				String name = txt_name.getText().toString();
				
				String[] row = dbc.select(_id);
				
				/**kuy*/
				String kuy = "";
				
				for ( String x : row )
					kuy += x;
				
				if ( kuy != "" )
					Toast.makeText(MainActivity.this, "Select " + kuy , Toast.LENGTH_LONG).show();
				else
					Toast.makeText(MainActivity.this, "Select Failed" , Toast.LENGTH_LONG).show();
			}
			
		});
		
	}

	private void initComponent() {
		txt_id = (EditText) findViewById(R.id.text_id);
		txt_name = (EditText) findViewById(R.id.text_name);
		addButton = (Button) findViewById(R.id.addButton);
		dbc = new DatabaseController(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

}
