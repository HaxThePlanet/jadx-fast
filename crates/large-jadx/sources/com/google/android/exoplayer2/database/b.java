package com.google.android.exoplayer2.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.exoplayer2.util.v;

/* loaded from: classes2.dex */
public final class b extends SQLiteOpenHelper implements com.google.android.exoplayer2.database.a {
    public b(Context context) {
        super(context.getApplicationContext(), "exoplayer_internal.db", 0, 1);
    }

    private static void a(SQLiteDatabase sQLiteDatabase) {
        Object string;
        String string2;
        Object string3;
        String equals;
        String[] stringBuilder;
        Cursor query = sQLiteDatabase.query("sqlite_master", /* result */, 0, 0, 0, 0, 0);
        while (query.moveToNext()) {
            string2 = query.getString(0);
            string3 = query.getString(1);
            if ("sqlite_sequence".equals(string3) == null) {
            }
            stringBuilder = new StringBuilder(i3 += length2);
            stringBuilder.append("DROP ");
            stringBuilder.append(string2);
            stringBuilder.append(" IF EXISTS ");
            stringBuilder.append(string3);
            sQLiteDatabase.execSQL(stringBuilder.toString());
        }
        if (query != null) {
            query.close();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        b.a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
