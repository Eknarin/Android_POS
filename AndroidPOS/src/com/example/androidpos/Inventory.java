package com.example.androidpos;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	
	private DatabaseController dbc;
	private List<ItemDescription> list;
	
	public Inventory( DatabaseController dbc ) {
		this.dbc = dbc;
		list = new ArrayList<ItemDescription>();
	}
	
	public boolean create( String _id , String name ) {
		if ( dbc.insert( _id, name ) > 0 )
			return true;
		return false;
	}

	public boolean edit( String _id , String name ) {
		if ( dbc.update( _id, name ) > 0 )
			return true;
		return false;
	}

	public boolean remove( String _id ) {
		if ( dbc.delete( _id ) > 0 )
			return true;
		return false;
	}

	public String [] select( String _id ) {
		return dbc.select( _id );
	}
	/**
	public boolean update() {

	}*/

	public String search() {
		return null;
	}
}
