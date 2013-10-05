package com.example.androidpos;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InventoryActivity extends Activity {

	private EditText txt_id;
	private EditText txt_name;
	private Button addButton;
	private Button editButton;
	private Button removeButton;
	private Button selectButton;
	
	private InventoryController inc;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inventory);
		
		initComponent();
		
	}

	private void initComponent() {
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

}
