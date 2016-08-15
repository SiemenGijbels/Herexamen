package com.gijbelssiemen.herexamen.Database;

import android.provider.BaseColumns;

/**
 * Created by siemengijbels on 8/12/16.
 */

public final class DatabaseContract {
    public static abstract class ArtistEntry implements BaseColumns {
        public static final String TABLE_NAME = "ARTISTS";
        public static final String COLUMN_ARTIST_NAAM = "naam";
        public static final String COLUMN_BESCHRIJVING = "beschrijving";
        public static final String COLUMN_IMAGE = "image";
    }
}
