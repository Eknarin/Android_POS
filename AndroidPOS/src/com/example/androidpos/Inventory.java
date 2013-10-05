package com.example.androidpos;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Inventory {
	
	private DatabaseHandler dbc;
	private List<ItemDescription> list;
	
	/** Constructor. */
	public Inventory( DatabaseHandler dbc ) {
		this.dbc = dbc;
		list = new ArrayList<ItemDescription>();
	}
	
	/**
	 * Create / update item description and create item in database.
	 * @param _id identify item.
	 * @param name of item.
	 * @return true if item is created in database, otherwise false.
	 */
	public boolean create( String _id , String name , int quantity , String description , String unit , double price , double cost) {
		ItemDescription item = new ItemDescription( name, quantity, description, unit, price, cost);
		
		if ( list.contains( item ) ) return false;
		
		list.add( item );
		
		if ( dbc.insert( _id, name, quantity, description, unit, price, cost ) > 0 )
			return true;
		return false;
	}
	
	/**
	 * Add existing item description item to database.
	 * @param _id identify item.
	 * @param name of item.
	 * @return true if item is created in database, otherwise false.
	 */
	public boolean add( String _id , String name ) {
		ItemDescription item = getItemByName( _id , name );
		
		if ( list.contains( item ) ) 
			list.get( list.indexOf(item) ).updateQuantity(1);
		else
			return false;
		
		String [] data = item.getDescription();
		
		if ( dbc.insert( _id, name, Integer.parseInt(data[2]) , data[3], data[4], Double.parseDouble(data[5]) , Double.parseDouble(data[6]) ) > 0 )
			return true;
		return false;
	}

	/**
	 * Edit item description.
	 * @param name to get item from database
	 * @param cost change cost of inventory item.
	 * @param price change price of inventory item.
	 * @param unit change unit of inventory item.
	 * @return true if editing is finish, otherwise false.
	 */
	public boolean edit( String name, String unit, double price, double cost ) {
		ItemDescription item = getItemByName( "" , name);
		
		if ( list.get( list.indexOf( item ) ).update( item ) )
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

	/**
	 * Select all data from database.
	 * @return all data from database, otherwise return null.
	 */
	public String[][] selectAll() {
		return dbc.selectAll();	
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
		return new ItemDescription( data[1] , Integer.parseInt(data[2]) , data[3], data[4], Double.parseDouble(data[5]), Double.parseDouble(data[6]));
	}
	
	/**
	 * Get item description from item in database.
	 * @param _id identify item.
	 * @return item description by id.
	 */
	public ItemDescription getItemByName( String _id , String name ) {
		String [] data = dbc.select( name );
		return new ItemDescription( data[1] , Integer.parseInt(data[2]) , data[3], data[4], Double.parseDouble(data[5]), Double.parseDouble(data[6]));
	}
	
}
