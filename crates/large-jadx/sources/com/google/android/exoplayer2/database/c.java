package com.google.android.exoplayer2.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes2.dex */
public final class c {
    private static String[] a(int i, String string2) {
        String[] strArr = new String[2];
        return strArr;
    }

    public static int b(SQLiteDatabase sQLiteDatabase, int i2, String string3) {
        try {
            final int i = -1;
            if (!p0.F0(sQLiteDatabase, "ExoPlayerVersions")) {
            }
            return i;
            final Cursor obj10 = sQLiteDatabase.query("ExoPlayerVersions", /* result */, "feature = ? AND instance_uid = ?", c.a(i2, string3), 0, 0, 0);
            if (obj10.getCount() == 0 && obj10 != null) {
            }
            if (obj10 != null) {
            }
            obj10.close();
            return i;
            obj10.moveToNext();
            if (obj10 != null) {
            }
            obj10.close();
            return obj10.getInt(0);
            if (sQLiteDatabase == null) {
            } else {
            }
            sQLiteDatabase.close();
            i2.addSuppressed(sQLiteDatabase);
            throw i2;
            i2 = new DatabaseIOException(sQLiteDatabase);
            throw i2;
        } catch (Throwable th) {
        }
    }

    public static void c(SQLiteDatabase sQLiteDatabase, int i2, String string3) {
        final String str = "ExoPlayerVersions";
        if (!p0.F0(sQLiteDatabase, str)) {
        }
        try {
            sQLiteDatabase.delete(str, "feature = ? AND instance_uid = ?", c.a(i2, string3));
            i2 = new DatabaseIOException(sQLiteDatabase);
            throw i2;
        }
    }

    public static void d(SQLiteDatabase sQLiteDatabase, int i2, String string3, int i4) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))");
            ContentValues contentValues = new ContentValues();
            contentValues.put("feature", Integer.valueOf(i2));
            contentValues.put("instance_uid", string3);
            contentValues.put("version", Integer.valueOf(i4));
            sQLiteDatabase.replaceOrThrow("ExoPlayerVersions", 0, contentValues);
            i2 = new DatabaseIOException(sQLiteDatabase);
            throw i2;
        }
    }
}
