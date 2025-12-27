package com.amplitude.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: DatabaseHelper.java */
/* loaded from: classes.dex */
class i extends SQLiteOpenHelper {

    private static final String v;
    static final Map<String, i> w = new HashMap<>();
    private static final g x;
    File a;
    private boolean b = true;
    private j c;
    static {
        i.v = i.class.getName();
        i.x = g.d();
    }

    protected i(Context context, String str) {
        super(context, i.m(str), null, 3);
        this.a = context.getDatabasePath(i.m(str));
        n.e(str);
    }

    private void G0(SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS long_store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS identifys");
        onCreate(sQLiteDatabase);
    }

    private synchronized long H(String str, long j) {
        try {
            final StringBuilder stringBuilder = new StringBuilder();
            String str5 = "SELECT id FROM ";
            String str6 = " LIMIT 1 OFFSET ";
            j--;
            str7 = str5 + str + str6 + l;
            SQLiteStatement compileStatement = getReadableDatabase().compileStatement(str7);
        } catch (android.database.sqlite.SQLiteDoneException sQLiteDone) {
        } catch (Throwable th1) {
        } catch (java.lang.StackOverflowError e2) {
        } catch (android.database.sqlite.SQLiteException sQLite3) {
        }
        try {
        } catch (android.database.sqlite.SQLiteDoneException sQLiteDone) {
        } catch (Throwable th1) {
        } catch (java.lang.StackOverflowError e2) {
        } catch (android.database.sqlite.SQLiteException sQLite3) {
        }
        if (compileStatement != null) {
            compileStatement.close();
            close();
            return str2;
        }
    }

    private void T(java.lang.IllegalStateException exc) {
        String message = exc.getMessage();
        if (n.d(message)) {
            throw exc;
        } else {
            if (message.contains("Couldn't read")) {
                if (message.contains("CursorWindow")) {
                    i();
                    return;
                }
            }
        }
    }

    private synchronized long c(String str, String str2) {
        int arr;
        com.amplitude.api.g gVar;
        long l2;
        String str6;
        String str7;
        long l = -1L;
        try {
            final ContentValues contentValues = new ContentValues();
            str3 = "event";
            contentValues.put(str3, str2);
            l2 = U(getWritableDatabase(), str, contentValues);
        } catch (java.lang.StackOverflowError e) {
        } catch (android.database.sqlite.SQLiteException sQLite1) {
        } catch (Throwable th2) {
        }
        if (l2 == l) {
            try {
                Object[] arr2 = new Object[1];
                i.x.e(i.v, String.format("Insert into %s failed", new Object[] { th2 }));
            } catch (java.lang.StackOverflowError e) {
            } catch (android.database.sqlite.SQLiteException sQLite1) {
            } catch (Throwable th2) {
            }
        }
        close();
        return l2;
    }

    private static void f(RuntimeException exc) throws CursorWindowAllocationException {
        final String message = exc.getMessage();
        if (n.d(message)) {
            throw exc;
        } else {
            if (message.startsWith("Cursor window allocation of")) {
                throw new CursorWindowAllocationException(message);
            }
        }
    }

    private void i() {
        boolean open3;
        com.amplitude.api.g gVar;
        str = "databaseReset callback failed during delete";
        int i = 0;
        try {
            close();
            this.a.delete();
        } catch (Throwable th) {
        } catch (android.database.sqlite.SQLiteException sQLite1) {
        }
        if (this.c != null && this.b) {
            this.b = false;
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                this.c.a(writableDatabase);
            } catch (Throwable th) {
            } catch (android.database.sqlite.SQLiteException sQLite1) {
            }
            this.b = true;
            if (writableDatabase != null && writableDatabase.isOpen()) {
                close();
            }
        }
    }

    static synchronized i k(Context context, String str) {
        Object value;
        final Class<com.amplitude.api.i> obj2 = i.class;
        str = n.e(str);
        final Map map = i.w;
        if ((i)map.get(str) == null) {
            i.w.put(str, new i(context.getApplicationContext(), str));
        }
        return value;
    }

    private static String m(String str) {
        boolean equals;
        String str3;
        if (!n.d(str)) {
            if (str.equals("$default_instance")) {
                str3 = "com.amplitude.api";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                str2 = "com.amplitude.api_";
                str3 = str2 + str;
            }
        }
        return str3;
    }

    private synchronized long o(String str) {
        long simpleQueryForLong;
        StringBuilder stringBuilder = new StringBuilder();
        final String str4 = "SELECT COUNT(*) FROM ";
        str2 = str4 + str;
        SQLiteStatement compileStatement = getReadableDatabase().compileStatement(str2);
        simpleQueryForLong = compileStatement.simpleQueryForLong();
        if (compileStatement != null) {
            compileStatement.close();
            close();
            return simpleQueryForLong;
        }
    }

    private synchronized void t0(String str, long j) {
        int i = 1;
        StringBuilder stringBuilder = new StringBuilder();
        final String str4 = "id = ";
        str5 = str4 + j;
        String[] strArr = null;
        getWritableDatabase().delete(str, str5, strArr);
        close();
    }

    private synchronized void z0(String str, long j) {
        int i = 1;
        StringBuilder stringBuilder = new StringBuilder();
        final String str4 = "id <= ";
        str5 = str4 + j;
        String[] strArr = null;
        getWritableDatabase().delete(str, str5, strArr);
        close();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized void A0(long j) {
        t0("identifys", j);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized void C0(long j) {
        z0("identifys", j);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized Long E(String str) {
        return (Long)M("long_store", str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized long F(long j) {
        return H("events", j);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    void I0(j jVar) {
        this.c = jVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized long J(long j) {
        return H("identifys", j);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized long K() {
        return n() + w();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized String L(String str) {
        return (String)M("store", str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    protected synchronized Object M(String str, String str2) {
        String str22;
        int i = 0;
        Throwable th;
        long _long;
        Long str3;
        i = 0;
        final int i4 = 1;
        try {
            final SQLiteDatabase readableDatabase = getReadableDatabase();
            final String[] strArr2 = new String[i4];
            strArr2[0] = str2;
            final Cursor cursor = this.l0(readableDatabase, str, new String[] { "key", "value" }, "key = ?", strArr2, null, null, null, null);
        } catch (RuntimeException e) {
        } catch (java.lang.IllegalStateException ise1) {
        } catch (java.lang.StackOverflowError e2) {
        } catch (android.database.sqlite.SQLiteException sQLite3) {
        } catch (Throwable th4) {
            str22 = str2;
        }
        try {
            if (th4.equals("store")) {
                String string = cursor.getString(i4);
            } else {
                str3 = Long.valueOf(cursor.getLong(i4));
            }
        } catch (RuntimeException e) {
        } catch (java.lang.IllegalStateException ise1) {
        } catch (java.lang.StackOverflowError e2) {
        } catch (android.database.sqlite.SQLiteException sQLite3) {
        } catch (Throwable th4) {
            str22 = str2;
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
            }
        }
        close();
        return i;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized long U(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) {
        return sQLiteDatabase.insert(str, null, contentValues);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized long V(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) {
        return sQLiteDatabase.insertWithOnConflict(str, null, contentValues, 5);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized long Y(String str, Long long) {
        long l;
        if (long == null) {
            str3 = "long_store";
            l = j(str3, str);
            str2 = "long_store";
            l = j0(str2, str, long);
        }
        return l;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized long a(String str) {
        return c("events", str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized long e(String str) {
        return c("identifys", str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized long e0(String str, String str2) {
        long l;
        if (str2 == null) {
            str4 = "store";
            l = j(str4, str);
            str3 = "store";
            l = j0(str3, str, str2);
        }
        return l;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized long g0(SQLiteDatabase sQLiteDatabase, String str, String str2, Object object) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", str2);
        if (object instanceof Long) {
            str = "value";
            contentValues.put(str, object);
        } else {
            str = "value";
            contentValues.put(str, object);
        }
        final long l = V(sQLiteDatabase, str, contentValues);
        if (l == -1) {
            i.x.e(i.v, "Insert failed");
        }
        return l;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized long j(String str, String str2) {
        int arr;
        com.amplitude.api.g gVar;
        String str3;
        String str5;
        long l;
        final String[] strArr = new String[1];
        l = (long)(getWritableDatabase().delete(str, "key=?", new String[] { str2 }));
        close();
        return l;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized long j0(String str, String str2, Object object) {
        long l;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        l = g0(writableDatabase, str, str2, object);
        if (writableDatabase != null && writableDatabase.isOpen()) {
            close();
        }
        return l;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    Cursor l0(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) throws android.database.SQLException {
        return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized void m0(long j) {
        t0("events", j);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized long n() {
        return o("events");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS store (key TEXT PRIMARY KEY NOT NULL, value TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS long_store (key TEXT PRIMARY KEY NOT NULL, value INTEGER);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS identifys (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);");
        if (this.c != null && this.b) {
            boolean z = false;
            boolean z2 = true;
            try {
                this.b = z;
                this.c.a(sQLiteDatabase);
            } catch (Throwable th) {
            }
            this.b = z2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws android.database.SQLException {
        if (i > i2) {
            i.x.b(i.v, "onUpgrade() with invalid oldVersion and newVersion");
            G0(sQLiteDatabase);
            return;
        }
        i = 1;
        if (i.v <= i) {
            return;
        }
        int i4 = 3;
        int i5 = 2;
        if (i.x != i) {
            if (i.x == i5) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS identifys (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);");
                str = "CREATE TABLE IF NOT EXISTS long_store (key TEXT PRIMARY KEY NOT NULL, value INTEGER);";
                sQLiteDatabase.execSQL(str);
            } else {
                if (i.x != 3) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str4 = "onUpgrade() with unknown oldVersion ";
                    str = str4 + i;
                    i.x.b(i.v, str);
                    G0(sQLiteDatabase);
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized List<JSONObject> q(long j, long j2) {
        return this.r("events", j, j2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    protected synchronized List<JSONObject> r(String str, long j, long j2) {
        String string;
        com.amplitude.api.g gVar;
        String str2;
        long j22 = j;
        long l = j2;
        try {
            final LinkedList linkedList = new LinkedList();
        } catch (Throwable th) {
        } catch (RuntimeException e1) {
        } catch (java.lang.IllegalStateException ise2) {
        } catch (java.lang.StackOverflowError e3) {
        } catch (android.database.sqlite.SQLiteException sQLite4) {
        }
        final int i = 0;
        try {
            long l2 = 0L;
            if (j22 >= l2) {
                StringBuilder stringBuilder = new StringBuilder();
                str5 = "id <= ";
                string = str5 + j22;
            } else {
            }
            if (l >= l2) {
                StringBuilder stringBuilder2 = new StringBuilder();
                str4 = "";
                str2 = str4 + l;
            } else {
            }
            final String str3 = str;
            Cursor cursor = this.l0(readableDatabase, str3, strArr, string, null, null, null, str6, str2);
        } catch (Throwable th) {
        }
        while (cursor.moveToNext()) {
            string = cursor.getString(1);
        }
        if (cursor != null) {
            try {
                cursor.close();
                close();
            } catch (Throwable th) {
            } catch (RuntimeException e1) {
            } catch (java.lang.IllegalStateException ise2) {
            } catch (java.lang.StackOverflowError e3) {
            } catch (android.database.sqlite.SQLiteException sQLite4) {
            }
            return linkedList;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized void v0(long j) {
        z0("events", j);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized long w() {
        return o("identifys");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    synchronized List<JSONObject> x(long j, long j2) {
        return this.r("identifys", j, j2);
    }
}
