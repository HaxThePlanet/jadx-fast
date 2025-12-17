package com.google.android.exoplayer2.upstream.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.a;
import com.google.android.exoplayer2.database.c;
import com.google.android.exoplayer2.util.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
final class f {

    private static final String[] c;
    private final a a;
    private String b;
    static {
        f.c = /* result */;
    }

    public f(a a) {
        super();
        this.a = a;
    }

    private static void a(SQLiteDatabase sQLiteDatabase, String string2) {
        String obj3;
        obj3 = String.valueOf(string2);
        final String str = "DROP TABLE IF EXISTS ";
        if (obj3.length() != 0) {
            obj3 = str.concat(obj3);
        } else {
            obj3 = new String(str);
        }
        sQLiteDatabase.execSQL(obj3);
    }

    private Cursor c() {
        g.e(this.b);
        return this.a.getReadableDatabase().query(this.b, f.c, 0, 0, 0, 0, 0);
    }

    private static String d(String string) {
        String obj2;
        obj2 = String.valueOf(string);
        final String str = "ExoPlayerCacheFileMetadata";
        if (obj2.length() != 0) {
            obj2 = str.concat(obj2);
        } else {
            obj2 = new String(str);
        }
        return obj2;
    }

    public Map<String, com.google.android.exoplayer2.upstream.cache.e> b() {
        Throwable databaseIOException;
        int string;
        long long;
        long long2;
        com.google.android.exoplayer2.upstream.cache.e eVar;
        try {
            final Cursor cursor = c();
            HashMap hashMap = new HashMap(cursor.getCount());
            while (cursor.moveToNext()) {
                string = cursor.getString(0);
                g.e(string);
                eVar = new e(cursor.getLong(1), obj4, cursor.getLong(2), obj6);
                hashMap.put((String)string, eVar);
            }
            string = cursor.getString(0);
            g.e(string);
            eVar = new e(cursor.getLong(1), obj4, cursor.getLong(2), obj6);
            hashMap.put((String)string, eVar);
        } catch (Throwable th) {
        }
        try {
            cursor.close();
            return hashMap;
            if (th == null) {
            } else {
            }
            th.close();
            databaseIOException.addSuppressed(th);
            throw databaseIOException;
            databaseIOException = new DatabaseIOException(th);
            throw databaseIOException;
        }
    }

    public void e(long l) {
        int str;
        int stringBuilder;
        String obj3;
        int obj4;
        try {
            obj3 = Long.toHexString(l);
            this.b = f.d(obj3);
            str = 2;
            stringBuilder = 1;
            if (c.b(this.a.getReadableDatabase(), str, obj3) != stringBuilder) {
            }
            obj4 = this.a.getWritableDatabase();
            obj4.beginTransactionNonExclusive();
            c.d(obj4, str, obj3, stringBuilder);
            f.a(obj4, this.b);
            obj3 = this.b;
            stringBuilder = new StringBuilder(length += 108);
            stringBuilder.append("CREATE TABLE ");
            stringBuilder.append(obj3);
            stringBuilder.append(" ");
            stringBuilder.append("(name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
            obj4.execSQL(stringBuilder.toString());
            obj4.setTransactionSuccessful();
            obj4.endTransaction();
            obj4.endTransaction();
            throw l;
            obj4 = new DatabaseIOException(l);
            throw obj4;
        } catch (Throwable th) {
        }
    }

    public void f(String string) {
        g.e(this.b);
        String[] strArr = new String[1];
        this.a.getWritableDatabase().delete(this.b, "name = ?", string);
    }

    public void g(Set<String> set) {
        Object next;
        String str2;
        String str;
        String[] strArr;
        int i;
        g.e(this.b);
        SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
        writableDatabase.beginTransactionNonExclusive();
        final Iterator obj7 = set.iterator();
        for (String next : obj7) {
            strArr = new String[1];
            writableDatabase.delete(this.b, "name = ?", next);
        }
        writableDatabase.setTransactionSuccessful();
        writableDatabase.endTransaction();
    }

    public void h(String string, long l2, long l3) {
        g.e(this.b);
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", string);
        contentValues.put("length", Long.valueOf(l2));
        contentValues.put("last_touch_timestamp", Long.valueOf(obj7));
        this.a.getWritableDatabase().replaceOrThrow(this.b, 0, contentValues);
    }
}
