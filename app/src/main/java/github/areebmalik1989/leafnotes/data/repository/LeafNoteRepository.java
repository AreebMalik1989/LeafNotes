package github.areebmalik1989.leafnotes.data.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;
import github.areebmalik1989.core.usecase.leafnote.ILeafNoteRepository;
import github.areebmalik1989.leafnotes.data.entity.LeafNoteData;

import java.util.ArrayList;
import java.util.List;

public class LeafNoteRepository implements ILeafNoteRepository {

    private static final String TAG = LeafNoteRepository.class.getSimpleName();

    // Database fields
    private DbHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public LeafNoteRepository(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void close() {
        dbHelper.close();
    }

    @Override
    public List<LeafNote> getAll() {

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        List<LeafNoteData> noteDataList = new ArrayList<>();
        List<LeafNote> noteList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + DbHelper.TABLE_NAME;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                LeafNoteData leafNoteData = new LeafNoteData();
                leafNoteData.setId(Long.parseLong(cursor.getString(0)));
                leafNoteData.setTitle(cursor.getString(1));
                leafNoteData.setDescription(cursor.getString(2));
                // Adding note to list
                noteDataList.add(leafNoteData);
            } while (cursor.moveToNext());
        }

        for(LeafNoteData leafNoteData : noteDataList) {
            noteList.add(leafNoteData.fromThis());
        }

        db.close();

        return noteList;
    }

    @Override
    public List<LeafNote> searchByTitle(String _title) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        List<LeafNoteData> noteDataList = new ArrayList<>();
        List<LeafNote> noteList = new ArrayList<>();

        Cursor cursor = db.query(DbHelper.TABLE_NAME, DbHelper.columns,
                DbHelper.COL_NOTE_TITLE + " =?", new String[]{String.valueOf(_title)}, null, null, null);

        if(cursor.moveToFirst()) {
            do {
                LeafNoteData leafNoteData = new LeafNoteData();
                leafNoteData.setId(Long.parseLong(cursor.getString(0)));
                leafNoteData.setTitle(cursor.getString(1));
                leafNoteData.setDescription(cursor.getString(2));
                // Adding note to list
                noteDataList.add(leafNoteData);
            } while (cursor.moveToNext());
        }

        for(LeafNoteData leafNoteData : noteDataList) {
            noteList.add(leafNoteData.fromThis());
        }

        db.close();

        return noteList;
    }

    @Override
    public LeafNote getById(Identity identity) {

        long _id = identity.getId();

        database = dbHelper.getReadableDatabase();

        Cursor cursor = database.query(DbHelper.TABLE_NAME, DbHelper.columns,
                DbHelper.COL_NOTE_ID + " =?", new String[]{String.valueOf(_id)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        LeafNoteData leafNoteData = new LeafNoteData(Long.parseLong(cursor.getString(0)), cursor.getString(1),
                cursor.getString(2));

        return leafNoteData.fromThis();
    }

    @Override
    public Identity saveLeafNote(LeafNote leafNote) {

        LeafNoteData leafNoteData = LeafNoteData.from(leafNote);

        database = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DbHelper.COL_NOTE_TITLE, leafNoteData.getTitle());
        values.put(DbHelper.COL_NOTE_DESCRIPTION, leafNoteData.getDescription());

        long id = database.insert(DbHelper.TABLE_NAME, null, values);

        Log.i(TAG, "Note Added");
        database.close();

        return new Identity(id);
    }

    @Override
    public Identity updateLeafNote(LeafNote leafNote) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DbHelper.COL_NOTE_TITLE, leafNote.getTitle());
        values.put(DbHelper.COL_NOTE_DESCRIPTION, leafNote.getDescription());

        // updating row
        db.update(DbHelper.TABLE_NAME, values, DbHelper.COL_NOTE_ID + " = ?",
                new String[]{String.valueOf(leafNote.getId().getId())});

        return leafNote.getId();
    }

    @Override
    public boolean deleteLeafNote(Identity id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.delete(DbHelper.TABLE_NAME, DbHelper.COL_NOTE_ID + " = ?",
                new String[]{String.valueOf(id.getId())});

        Log.i(TAG, "Note Deleted");
        db.close();

        return true;
    }
}
