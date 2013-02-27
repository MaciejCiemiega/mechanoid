/*
 * Generated by Robotoworks Mechanoid
 */
package com.robotoworks.example.movies.ops;

import com.robotoworks.mechanoid.ops.Operation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public abstract class AbstractAddMovieOperation extends Operation {
	public static final String ACTION_ADD_MOVIE = "com.robotoworks.example.movies.ops.actions.ADD_MOVIE";

	public static final String EXTRA_TITLE = "com.robotoworks.example.movies.ops.extras.TITLE";
	public static final String EXTRA_DESCRIPTION = "com.robotoworks.example.movies.ops.extras.DESCRIPTION";
	public static final String EXTRA_YEAR = "com.robotoworks.example.movies.ops.extras.YEAR";

	private String mTitle;
	private String mDescription;
	private int mYear;

	public String getTitle() {
		return mTitle;
	}
	public String getDescription() {
		return mDescription;
	}
	public int getYear() {
		return mYear;
	}

	public static final Intent createAddMovieIntent(String title, String description, int year) {
		Intent intent = new Intent(ACTION_ADD_MOVIE);
		
		Bundle extras = new Bundle();
		extras.putString(EXTRA_TITLE, title);
		extras.putString(EXTRA_DESCRIPTION, description);
		extras.putInt(EXTRA_YEAR, year);
		
		intent.putExtras(extras);
		
		return intent;
		
	}

	@Override
	public Bundle execute() {
		Bundle extras = getIntent().getExtras();
		mTitle = extras.getString(EXTRA_TITLE);
		mDescription = extras.getString(EXTRA_DESCRIPTION);
		mYear = extras.getInt(EXTRA_YEAR);
		
		return onExecute();
	}
			
	protected abstract Bundle onExecute();
}