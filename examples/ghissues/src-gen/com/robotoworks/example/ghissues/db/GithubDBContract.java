/*
 * Generated by Robotoworks Mechanoid
 */
package com.robotoworks.example.ghissues.db;

import android.net.Uri;
import android.provider.BaseColumns;
import com.robotoworks.mechanoid.Mechanoid;
import com.robotoworks.mechanoid.db.AbstractValuesBuilder;
import java.lang.reflect.Field;			
import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class GithubDBContract  {
    public static final String CONTENT_AUTHORITY = initAuthority();

	private static String initAuthority() {
		String authority = "com.robotoworks.example.ghissues.db.githubdb";

		try {
    		
    		ClassLoader loader = GithubDBContract.class.getClassLoader();
    		
			Class<?> clz = loader.loadClass("com.robotoworks.example.ghissues.db.GithubDBContentProviderAuthority");
			Field declaredField = clz.getDeclaredField("CONTENT_AUTHORITY");
			
			authority = declaredField.get(null).toString();
		} catch (ClassNotFoundException e) {} 
    	catch (NoSuchFieldException e) {} 
    	catch (IllegalArgumentException e) {
		} catch (IllegalAccessException e) {
		}
		
		return authority;
	}
	
    private static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

	interface IssuesColumns {
		String OWNER = "owner";
		String REPO = "repo";
		String GHID = "ghid";
		String NUMBER = "number";
		String TITLE = "title";
		String BODY = "body";
	}
	

			
	/**
	 * <p>Column definitions and helper methods to work with the Issues.</p>
	 */
	public static class Issues implements IssuesColumns, BaseColumns {
	    public static final Uri CONTENT_URI = 
				BASE_CONTENT_URI.buildUpon().appendPath("issues").build();
	
		/**
		 * <p>The content type for a cursor that contains many Issues rows.</p>
		 */
	    public static final String CONTENT_TYPE =
	            "vnd.android.cursor.dir/vnd.githubdb.issues";
	
		/**
		 * <p>The content type for a cursor that contains a single Issues row.</p>
		 */
		public static final String ITEM_CONTENT_TYPE =
			"vnd.android.cursor.item/vnd.githubdb.issues";
	
		/**
		 * <p>Builds a Uri with appended id for a row in Issues, 
		 * eg:- content://com.robotoworks.example.ghissues.db.githubdb/issues/123.</p>
		 */
	    public static Uri buildUriWithId(long id) {
	        return CONTENT_URI.buildUpon().appendPath(String.valueOf(id)).build();
	    }
		public static int delete() {
			return Mechanoid.getContentResolver().delete(CONTENT_URI, null, null);
		}
		
		public static int delete(String where, String[] selectionArgs) {
			return Mechanoid.getContentResolver().delete(CONTENT_URI, where, selectionArgs);
		}
		
		/**
		 * <p>Create a new Builder for Issues</p>
		 */
		public static Builder newBuilder() {
			return new Builder();
		}
		
		/**
		 * <p>Build and execute insert or update statements for Issues.</p>
		 *
		 * <p>Use {@link Issues#newBuilder()} to create new builder</p>
		 */
		public static class Builder extends AbstractValuesBuilder {
			private Builder() {
				super(Mechanoid.getApplicationContext(), CONTENT_URI);
			}
			
			public Builder setOwner(String value) {
				mValues.put(Issues.OWNER, value);
				return this;
			}
			public Builder setRepo(String value) {
				mValues.put(Issues.REPO, value);
				return this;
			}
			public Builder setGhid(long value) {
				mValues.put(Issues.GHID, value);
				return this;
			}
			public Builder setNumber(long value) {
				mValues.put(Issues.NUMBER, value);
				return this;
			}
			public Builder setTitle(String value) {
				mValues.put(Issues.TITLE, value);
				return this;
			}
			public Builder setBody(String value) {
				mValues.put(Issues.BODY, value);
				return this;
			}
		}
		
		static final Set<Uri> VIEW_URIS;
		
		static {
			HashSet<Uri> viewUris =  new HashSet<Uri>();
	
			
			VIEW_URIS = Collections.unmodifiableSet(viewUris);
		}
	}

	
	static Map<Uri, Set<Uri>> REFERENCING_VIEWS;
	
	static {
		Map<Uri, Set<Uri>> map = new HashMap<Uri, Set<Uri>>();
		
		map.put(Issues.CONTENT_URI, Issues.VIEW_URIS);
		
		REFERENCING_VIEWS = Collections.unmodifiableMap(map);
		
	}
	
	private GithubDBContract(){}
}
