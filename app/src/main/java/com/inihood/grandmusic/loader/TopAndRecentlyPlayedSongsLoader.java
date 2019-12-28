package com.inihood.grandmusic.loader;

import android.content.Context;
import android.database.Cursor;
import android.provider.BaseColumns;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.inihood.grandmusic.model.Song;
import com.inihood.grandmusic.provider.HistoryStore;
import com.inihood.grandmusic.provider.SongPlayCountStore;

import java.util.ArrayList;
import java.util.List;

public class TopAndRecentlyPlayedSongsLoader {
    public static final int NUMBER_OF_TOP_SONGS = 100;

    @NonNull
    public static List<Song> getRecentlyPlayedSongs(@NonNull Context context) {
        return SongLoader.getSongs(makeRecentSongsCursorAndClearUpDatabase(context));
    }

    @NonNull
    public static List<Song> getTopSongs(@NonNull Context context) {
        return SongLoader.getSongs(makeTopSongsCursorAndClearUpDatabase(context));
    }

    @Nullable
    public static Cursor makeRecentSongsCursorAndClearUpDatabase(@NonNull final Context context) {
        SortedLongCursor retCursor = makeRecentSongsCursorImpl(context);

        // clean up the databases with any ids not found
        if (retCursor != null) {
            List<Long> missingIds = retCursor.getMissingIds();
            if (missingIds != null && missingIds.size() > 0) {
                for (long id : missingIds) {
                    HistoryStore.getInstance(context).removeSongId(id);
                }
            }
        }
        return retCursor;
    }

    @Nullable
    public static Cursor makeTopSongsCursorAndClearUpDatabase(@NonNull final Context context) {
        SortedLongCursor retCursor = makeTopSongsCursorImpl(context);

        // clean up the databases with any ids not found
        if (retCursor != null) {
            List<Long> missingIds = retCursor.getMissingIds();
            if (missingIds != null && missingIds.size() > 0) {
                for (long id : missingIds) {
                    SongPlayCountStore.getInstance(context).removeItem(id);
                }
            }
        }
        return retCursor;
    }

    @Nullable
    private static SortedLongCursor makeRecentSongsCursorImpl(@NonNull final Context context) {
        // first get the top results ids from the internal database
        Cursor songs = HistoryStore.getInstance(context).queryRecentIds();

        try {
            return makeSortedCursor(context, songs,
                    songs.getColumnIndex(HistoryStore.RecentStoreColumns.ID));
        } finally {
            if (songs != null) {
                songs.close();
            }
        }
    }

    @Nullable
    private static SortedLongCursor makeTopSongsCursorImpl(@NonNull final Context context) {
        // first get the top results ids from the internal database
        Cursor songs = SongPlayCountStore.getInstance(context).getTopPlayedResults(NUMBER_OF_TOP_SONGS);

        try {
            return makeSortedCursor(context, songs,
                    songs.getColumnIndex(SongPlayCountStore.SongPlayCountColumns.ID));
        } finally {
            if (songs != null) {
                songs.close();
            }
        }
    }

    @Nullable
    private static SortedLongCursor makeSortedCursor(@NonNull final Context context, @Nullable final Cursor cursor, final int idColumn) {
        if (cursor != null && cursor.moveToFirst()) {
            // create the list of ids to select against
            StringBuilder selection = new StringBuilder();
            selection.append(BaseColumns._ID);
            selection.append(" IN (");

            // this songs the order of the ids
            long[] order = new long[cursor.getCount()];

            long id = cursor.getLong(idColumn);
            selection.append(id);
            order[cursor.getPosition()] = id;

            while (cursor.moveToNext()) {
                selection.append(",");

                id = cursor.getLong(idColumn);
                order[cursor.getPosition()] = id;
                selection.append(String.valueOf(id));
            }

            selection.append(")");

            // get a list of songs with the data given the selection statement
            Cursor songCursor = SongLoader.makeSongCursor(context, selection.toString(), null);
            if (songCursor != null) {
                // now return the wrapped TopSongsCursor to handle sorting given order
                return new SortedLongCursor(songCursor, order, BaseColumns._ID);
            }
        }

        return null;
    }
}
