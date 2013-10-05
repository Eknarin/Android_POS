package com.example.androidpos;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	
	private DatabaseController dbc;
	private List<ItemDescription> list;
	
	/** Constructor. */
	public Inventory( DatabaseController dbc ) {
		this.dbc = dbc;
		list = new ArrayList<ItemDescription>();
	}
	
	/**
	 * Create / update item description and create item in database.
	 * @param _id identify item.
	 * @param name of item.
	 * @return true if item is created in database, otherwise false.
	 */
	public boolean create( String _id , String name ) {
		ItemDescription item = new ItemDescription(_id, name, 1);
		
		if ( list.contains( item ) )
			list.get( list.indexOf( item ) ).updateQuantity(1);
		else
			list.add( item );
		
		if ( dbc.insert( _id, name ) > 0 )
			return true;
		return false;
	}

	/**
	 * Edit item description and database item.
	 * @param _id identify item.
	 * @param name of item.
	 * @return true if editing is finish, otherwise false.
	 */
	public boolean edit( String _id , String name ) {
		if ( dbc.update( _id, name ) > 0 )
			return true;
		return false;
	}

	/**
	 * Remove item in database and update item description.
	 * @param _id identify item.
	 * @return true is item is removed, otherwise false.
	 */
	public boolean remove( String _id ) {
		ItemDescription item = getItemById( _id );
		
		if ( list.contains( item ) )
			list.get( list.indexOf( item ) ).updateQuantity(-1);
		else
			return false;
		
		if ( dbc.delete( _id ) > 0 )
			return true;
		return false;
	}

	/**
	 * Select item form database.
	 * @param _id identify item.
	 * @return item information.
	 */
	public String [] select( String _id ) {
		return dbc.select( _id );
	}

	public String search() {
		return null;
	}
	
	public List<ItemDescription> getItemDescriptionList() {
		return this.list;
	}
	
	/**
	 * Get item description from item in database.
	 * @param _id identify item.
	 * @return item description by id.
	 */
	public ItemDescription getItemById( String _id ) {
		String [] data = dbc.select( _id );
		return new ItemDescription( data[0] , data[1] , 0);
	}
}
