package github.areebmalik1989.leafnotes.data.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

    private static final String TAG = DbHelper.class.getSimpleName();

    //Table Name
    public static final String TABLE_NAME = "notes";
    //Column Names
    public static final String COL_NOTE_ID = "_id";
    public static final String COL_NOTE_TITLE = "_title";
    public static final String COL_NOTE_DESCRIPTION = "_desc";

    static final String[] columns = new String[]{DbHelper.COL_NOTE_ID,
            DbHelper.COL_NOTE_TITLE, DbHelper.COL_NOTE_DESCRIPTION};

    //Database Information
    private static final String DATABASE_NAME = "leafnotes.db";
    private static final int DATABASE_VERSION = 1;

    // creation SQLite statement
    private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME
            + "(" + COL_NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NOTE_TITLE + " TEXT NOT NULL, " + COL_NOTE_DESCRIPTION + " TEXT);";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.i(TAG, "DB Created");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE);
        Log.i(TAG, "Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
        Log.i(TAG, "DB Upgraded");
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
