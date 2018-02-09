package com.x.phone;

import java.io.File;
import java.io.IOException;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class InputDbContext extends ContextWrapper {
	
	
	public String InputDbFile;

	public InputDbContext(Context base) {
		super(base);
	}


	@Override
	public File getDatabasePath(String name) {
		File dbFile = new File(InputDbFile);
		return dbFile;
	}


	@Override
	public SQLiteDatabase openOrCreateDatabase(String name, int mode,
			SQLiteDatabase.CursorFactory factory) {
		SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(
				getDatabasePath(name), null);
		return result;
	}

	@Override
	public SQLiteDatabase openOrCreateDatabase(String name, int mode,
			CursorFactory factory, DatabaseErrorHandler errorHandler) {
		SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(
				getDatabasePath(name), null);
		return result;
	}
}