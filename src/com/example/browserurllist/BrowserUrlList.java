package com.example.browserurllist;


import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;


import android.view.View;
import android.app.ListActivity;
import android.widget.ListView;
import android.widget.Toast;
import android.provider.Browser;
import android.widget.TextView;
import android.app.Activity;
import android.database.Cursor;



public class BrowserUrlList extends ListActivity {

    @SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* setContentView(R.layout.activity_browser_url_list);
        
        TextView tv = (TextView) findViewById(R.id.content);
        String[] projection = new String[] { Browser.BookmarkColumns.TITLE,
        Browser.BookmarkColumns.URL };
        Cursor mCur = managedQuery(android.provider.Browser.BOOKMARKS_URI,
        projection, null, null, null);
        mCur.moveToFirst();
        int titleIdx = mCur.getColumnIndex(Browser.BookmarkColumns.TITLE);
        int urlIdx = mCur.getColumnIndex(Browser.BookmarkColumns.URL);
        while (mCur.isAfterLast() == false) {
        tv.append("\n" + mCur.getString(titleIdx));
        tv.append("\n" + mCur.getString(urlIdx));
        mCur.moveToNext();
        	}*/
        
        String[] selection = { Browser.BookmarkColumns._ID,
                Browser.BookmarkColumns.URL, 
                //Browser.BookmarkColumns.TITLE,
                Browser.BookmarkColumns.VISITS,
                //Browser.BookmarkColumns.DATE
                };
        String[] displayFields = { Browser.BookmarkColumns.URL,
                //Browser.BookmarkColumns.TITLE,
                //Browser.BookmarkColumns.DATE,
                Browser.BookmarkColumns.VISITS
                };
       

        int[] viewFields = { android.R.id.text1, android.R.id.text2   };
        Cursor cursor = managedQuery(Browser.BOOKMARKS_URI, selection, null,
                null, null);
        startManagingCursor(cursor);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2, cursor, displayFields,
                viewFields);
        setListAdapter(adapter);
        }
    
 

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        TextView view = (TextView) v.findViewById(android.R.id.text2);
        Toast.makeText(this, view.getText(), Toast.LENGTH_SHORT).show();
    }
}
