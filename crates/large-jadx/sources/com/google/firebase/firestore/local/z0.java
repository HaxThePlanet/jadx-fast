package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;

/* loaded from: classes2.dex */
public final class z0 implements SQLiteDatabase.CursorFactory {

    public final Object[] a;
    public z0(Object[] objectArr) {
        super();
        this.a = objectArr;
    }

    @Override // android.database.sqlite.SQLiteDatabase$CursorFactory
    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver2, String string3, SQLiteQuery sQLiteQuery4) {
        return SQLitePersistence.Query.a(this.a, sQLiteDatabase, sQLiteCursorDriver2, string3, sQLiteQuery4);
    }
}
