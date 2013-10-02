package com.example.androidpos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseController extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_NAME = "POS_DATABASE";
	
	private static final String TABLE_NAME = "INVENTORY_TABLE";
	
	private static DatabaseController instance = null;
	
	public DatabaseController(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}	
	
	public static void setContext(Context context) {
		instance = new DatabaseController(context);
	}
	
	public static DatabaseController getInstance() {
		return instance;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + TABLE_NAME + 
					"( _id INTEGER PRIMARY KEY," +
					" name TEXT(100) )");
		Log.d("CREATE TABLE","Success" );
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	
	/**
	 * Select data from database
	 * @param _id code identify where data is.
	 * @return database data , otherwise null.
	 */
	public String[] select( String _id ) {
		
		try {
			String [] data = null;
			
			SQLiteDatabase db = this.getReadableDatabase();
			
			Cursor cursor = db.query(TABLE_NAME, new String[] {"*"} , "_id = ?", new String [] { String.valueOf( _id ) }, null , null , null);
			
			if ( cursor != null )
				if ( cursor.moveToFirst() ) {
					data = new String[ cursor.getColumnCount() ];
					for ( int i = 0 ; i < data.length ; i++ )
						data[i] = cursor.getString(i);
				}
			
			/** Close database nad cursor. */
			cursor.close();
			db.close();
			return data;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Insert data to database.
	 * @param _id code identify where data is.
	 * @param name of item.
	 * @return number of row that has been insert, otherwise -1.
	 */
	public long insert( String _id , String name ) {
		try {
			/** Get database. */
			SQLiteDatabase db = this.getWritableDatabase();
			
			/** Prepare values to insert. */
			ContentValues values = new ContentValues();
			values.put( "_id" , _id );
			values.put( "name" , name );
			
			/** Insert values to database. */
			long rows = db.insert( TABLE_NAME , null , values );
			
			/** Close database. */
			db.close();
			return rows;
		} catch ( Exception e ) {
			return -1;
		}
	}
	
	/**
	 * Update database data
	 * @param _id code identify where data is.
	 * @param name to be update
	 * @return number of row that has been update, otherwise -1.
	 */
	public long update( String _id , String name ) {
		
		try {
			/** Get database. */
			SQLiteDatabase db = this.getWritableDatabase();
			
			/** Prepare values to insert. */
			ContentValues values = new ContentValues();
			values.put( "_id" , _id );
			values.put( "name" , name );
			
			long rows = db.update(TABLE_NAME, values, "_id = ?", new String [] { String.valueOf(_id) } );
			
			/** Close database. */
			db.close();
			return rows;
		} catch (Exception e) {
			return -1;
		}
		
	}
	
	/**
	 * Delete data from database.
	 * @param _id code identify where data is.
	 * @return number of row that has been delete, otherwise -1.
	 */
	public long delete( String _id ) {
		
		try {
			/** Get database. */
			SQLiteDatabase db = this.getWritableDatabase();
			
			long rows = db.delete(TABLE_NAME, "_id = ?", new String [] { String.valueOf(_id) } );
			
			/** Close database. */
			db.close();
			return rows;
		} catch (Exception e) {
			return -1;
		}
	}
	
}
