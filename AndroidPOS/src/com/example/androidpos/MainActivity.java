package com.example.androidpos;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private Button inventoryBtn;
	private Button saleBtn;
	private Button reportBtn;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initComponent();
		
		inventoryBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent inventory = new Intent(MainActivity.this,InventoryActivity.class);
				startActivity(inventory);
								
			}
		});

	}

	private void initComponent() {
		inventoryBtn = (Button)findViewById(R.id.inventoryBtn);
		saleBtn = (Button)findViewById(R.id.saleBtn);
		reportBtn = (Button)findViewById(R.id.reportBtn);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
