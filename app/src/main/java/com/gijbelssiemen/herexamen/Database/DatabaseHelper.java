package com.gijbelssiemen.herexamen.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.gijbelssiemen.herexamen.Model.Artist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siemengijbels on 8/12/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private SQLiteDatabase dbase;
    Artist artist;
    Context context;
    private static final int DATABASE_VERSION = 2;
    // Database Name
    private static final String DATABASE_NAME = "ARTISTS";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES_ARTISTS =
            "CREATE TABLE IF NOT EXISTS " + DatabaseContract.ArtistEntry.TABLE_NAME + "("
                    + DatabaseContract.ArtistEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT" + COMMA_SEP
                    + DatabaseContract.ArtistEntry.COLUMN_ARTIST_NAAM + TEXT_TYPE + COMMA_SEP
                    + DatabaseContract.ArtistEntry.COLUMN_BESCHRIJVING + INTEGER_TYPE + COMMA_SEP
                    + DatabaseContract.ArtistEntry.COLUMN_IMAGE + INTEGER_TYPE
                    + ")";

    private static final String SQL_DELETE_ENTRIES_ARTISTS =
            "DROP TABLE IF EXISTS " + DatabaseContract.ArtistEntry.TABLE_NAME;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        db.execSQL(SQL_CREATE_ENTRIES_ARTISTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL(SQL_DELETE_ENTRIES_ARTISTS);
        onCreate(db);
    }

    public void addArtist(Artist artist) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.ArtistEntry.COLUMN_ARTIST_NAAM, artist.getNaam());
        values.put(DatabaseContract.ArtistEntry.COLUMN_BESCHRIJVING, artist.getBeschrijving());
        values.put(DatabaseContract.ArtistEntry.COLUMN_IMAGE, artist.getImage());
        db.close();
    }

    public void deleteArtist(Artist artist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DatabaseContract.ArtistEntry.TABLE_NAME, null, null);
        db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '" + DatabaseContract.ArtistEntry.TABLE_NAME + "'");
        db.close();
    }


    public List<Artist> getAllArtists() {
        List<Artist> artistList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + DatabaseContract.ArtistEntry.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Artist artist = new Artist();
                artist.setArtistId(Integer.parseInt(cursor.getString(0)));
                artist.setNaam(cursor.getString(1));
                artist.setBeschrijving(cursor.getInt(2));
                artistList.add(artist);
            } while (cursor.moveToNext());
        }

        return artistList;
    }

    public Artist getArtist(int artistId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DatabaseContract.ArtistEntry.TABLE_NAME, new String[]{DatabaseContract.ArtistEntry._ID, DatabaseContract.ArtistEntry.COLUMN_ARTIST_NAAM, DatabaseContract.ArtistEntry.COLUMN_BESCHRIJVING, DatabaseContract.ArtistEntry.COLUMN_IMAGE}, DatabaseContract.ArtistEntry._ID + "=?", new String[]{String.valueOf(artistId)}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            artist = new Artist(Integer.parseInt(cursor.getString(0)), cursor.getString(1), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)));
        }

        return artist;
    }

    public int getArtistCount() {
        String artistCount = "SELECT  * FROM " + DatabaseContract.ArtistEntry.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(artistCount, null);

        // return count
        return cursor.getCount();
    }


}
