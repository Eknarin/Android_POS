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
		
		addButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				String _id = txt_id.getText().toString();
				String name = txt_name.getText().toString();
				
				if ( inc.addItem(_id, name, 0, name, name, 0, 0) )
					Toast.makeText(InventoryActivity.this, "Add Success" , Toast.LENGTH_LONG).show();
				else
					Toast.makeText(InventoryActivity.this, "Add Failed" , Toast.LENGTH_LONG).show();
			}
			
		});
		
		editButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				String _id = txt_id.getText().toString();
				String name = txt_name.getText().toString();
				
				if ( inc.editItem(_id, name) )
					Toast.makeText(InventoryActivity.this, "Edit Success" , Toast.LENGTH_LONG).show();
				else
					Toast.makeText(InventoryActivity.this, "Edit Failed" , Toast.LENGTH_LONG).show();
			}
			
		});
		
		removeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				String _id = txt_id.getText().toString();
				
				if ( inc.removeItem(_id) )
					Toast.makeText(InventoryActivity.this, "Remove Success" , Toast.LENGTH_LONG).show();
				else
					Toast.makeText(InventoryActivity.this, "Remove Failed" , Toast.LENGTH_LONG).show();
			}
			
		});
		
		selectButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				String _id = txt_id.getText().toString();
				
				String item = "";
				for ( String x : inc.getItem(_id ) )
					item += x + "";
				
				if ( item != "" )
					Toast.makeText(InventoryActivity.this, "Select " + item , Toast.LENGTH_LONG).show();
			}
			
		});
		
	}

	private void initComponent() {
		txt_id = (EditText) findViewById(R.id.text_id);
		txt_name = (EditText) findViewById(R.id.text_name);
		addButton = (Button) findViewById(R.id.addButton);
		editButton = (Button) findViewById(R.id.editButton);
		removeButton = (Button) findViewById(R.id.removeButton);
		selectButton = (Button) findViewById(R.id.selectButton);
		inc = new InventoryController( new Inventory( new DatabaseController(this) ) );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

}
