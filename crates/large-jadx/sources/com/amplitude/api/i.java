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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
class i extends SQLiteOpenHelper {

    private static final String v;
    static final Map<String, com.amplitude.api.i> w;
    private static final com.amplitude.api.g x;
    File a;
    private boolean b = true;
    private com.amplitude.api.j c;
    static {
        i.v = i.class.getName();
        HashMap hashMap = new HashMap();
        i.w = hashMap;
        i.x = g.d();
    }

    protected i(Context context, String string2) {
        super(context, i.m(string2), 0, 3);
        int i = 1;
        this.a = context.getDatabasePath(i.m(string2));
        n.e(string2);
    }

    private void G0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS long_store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS identifys");
        onCreate(sQLiteDatabase);
    }

    private long H(String string, long l2) {
        int i;
        SQLiteDatabase readableDatabase;
        StringBuilder stringBuilder;
        long obj10;
        String obj11;
        com.amplitude.api.g obj12;
        final int i2 = 0;
        i = 1;
        int i3 = -1;
        int i4 = 0;
        stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT id FROM ");
        stringBuilder.append(string);
        stringBuilder.append(" LIMIT 1 OFFSET ");
        stringBuilder.append(l2 -= i5);
        SQLiteStatement compileStatement = getReadableDatabase().compileStatement(stringBuilder.toString());
        synchronized (this) {
            if (compileStatement != null) {
                compileStatement.close();
            }
            close();
            return compileStatement.simpleQueryForLong();
        }
    }

    private void T(java.lang.IllegalStateException illegalStateException) {
        String contains;
        boolean contains2;
        contains = illegalStateException.getMessage();
        if (n.d(contains)) {
        } else {
            if (!contains.contains("Couldn't read")) {
            } else {
                if (!contains.contains("CursorWindow")) {
                } else {
                    i();
                }
            }
        }
        throw illegalStateException;
    }

    private long c(String string, String string2) {
        int i;
        String format;
        int arr;
        int i2;
        com.amplitude.api.g gVar2;
        long l;
        String str3;
        ContentValues contentValues;
        String str;
        String str2;
        String obj8;
        int obj9;
        contentValues = new ContentValues();
        contentValues.put("event", string2);
        synchronized (this) {
            str2 = new Object[1];
            i.x.e(i.v, String.format("Insert into %s failed", string));
            close();
            return l;
        }
    }

    private static void f(RuntimeException runtimeException) {
        boolean startsWith;
        final String message = runtimeException.getMessage();
        if (n.d(message)) {
        } else {
            if (message.startsWith("Cursor window allocation of")) {
            } else {
                if (message.startsWith("Could not allocate CursorWindow")) {
                }
            }
            CursorWindowAllocationException obj2 = new CursorWindowAllocationException(message);
            throw obj2;
        }
        throw runtimeException;
    }

    private void i() {
        String open3;
        boolean open2;
        int writableDatabase;
        int arr;
        int i;
        com.amplitude.api.j jVar;
        com.amplitude.api.g gVar;
        String str2;
        String str;
        open3 = "databaseReset callback failed during delete";
        writableDatabase = 0;
        close();
        this.a.delete();
        this.b = false;
        writableDatabase = getWritableDatabase();
        this.c.a(writableDatabase);
        this.b = true;
        if (this.c != null && this.b && writableDatabase != null && writableDatabase.isOpen()) {
            if (this.b) {
                this.b = i;
                writableDatabase = getWritableDatabase();
                this.c.a(writableDatabase);
                this.b = i2;
                if (writableDatabase != null) {
                    if (writableDatabase.isOpen()) {
                        close();
                    }
                }
            }
        }
    }

    static com.amplitude.api.i k(Context context, String string2) {
        Object iVar;
        Object obj3;
        final Class<com.amplitude.api.i> obj = i.class;
        final String obj4 = n.e(string2);
        final Map map = i.w;
        synchronized (obj) {
            iVar = new i(context.getApplicationContext(), obj4);
            map.put(obj4, iVar);
            return iVar;
        }
    }

    private static String m(String string) {
        StringBuilder stringBuilder;
        String str;
        String obj2;
        if (!n.d(string)) {
            if (string.equals("$default_instance")) {
                obj2 = "com.amplitude.api";
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("com.amplitude.api_");
                stringBuilder.append(string);
                obj2 = stringBuilder.toString();
            }
        } else {
        }
        return obj2;
    }

    private long o(String string) {
        long simpleQueryForLong;
        int arr;
        Throwable th;
        com.amplitude.api.g gVar;
        String str2;
        String str;
        int i2 = 0;
        final int i3 = 1;
        int i4 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT COUNT(*) FROM ");
        stringBuilder.append(string);
        SQLiteStatement compileStatement = getReadableDatabase().compileStatement(stringBuilder.toString());
        simpleQueryForLong = compileStatement.simpleQueryForLong();
        synchronized (this) {
            compileStatement.close();
            close();
            return simpleQueryForLong;
        }
    }

    private void t0(String string, long l2) {
        int i;
        SQLiteDatabase writableDatabase;
        StringBuilder stringBuilder;
        String obj6;
        String obj7;
        int obj8;
        final int i2 = 0;
        i = 1;
        stringBuilder = new StringBuilder();
        stringBuilder.append("id = ");
        stringBuilder.append(l2);
        getWritableDatabase().delete(string, stringBuilder.toString(), 0);
        synchronized (this) {
            close();
        }
    }

    private void z0(String string, long l2) {
        int i;
        SQLiteDatabase writableDatabase;
        StringBuilder stringBuilder;
        String obj6;
        String obj7;
        int obj8;
        final int i2 = 0;
        i = 1;
        stringBuilder = new StringBuilder();
        stringBuilder.append("id <= ");
        stringBuilder.append(l2);
        getWritableDatabase().delete(string, stringBuilder.toString(), 0);
        synchronized (this) {
            close();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    void A0(long l) {
        t0("identifys", l);
        return;
        synchronized (this) {
            t0("identifys", l);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    void C0(long l) {
        z0("identifys", l);
        return;
        synchronized (this) {
            z0("identifys", l);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    Long E(String string) {
        return (Long)M("long_store", string);
        synchronized (this) {
            return (Long)M("long_store", string);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    long F(long l) {
        return H("events", l);
        synchronized (this) {
            return H("events", l);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    void I0(com.amplitude.api.j j) {
        this.c = j;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    long J(long l) {
        return H("identifys", l);
        synchronized (this) {
            return H("identifys", l);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    long K() {
        return l += l2;
        synchronized (this) {
            return l += l2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    String L(String string) {
        return (String)M("store", string);
        synchronized (this) {
            return (String)M("store", string);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    protected Object M(String string, String string2) {
        String str;
        int i;
        int i2;
        Throwable th;
        boolean moveToFirst;
        SQLiteDatabase readableDatabase;
        String str2;
        String[] strArr;
        Object obj14;
        Cursor obj15;
        i = 0;
        i2 = 1;
        readableDatabase = getReadableDatabase();
        final String[] strArr2 = new String[i2];
        strArr2[0] = string2;
        obj15 = this.l0(readableDatabase, string, /* result */, "key = ?", strArr2, 0, 0, 0, 0);
        synchronized (this) {
            if (string.equals("store")) {
                obj14 = obj15.getString(i2);
            } else {
                obj14 = Long.valueOf(obj15.getLong(i2));
            }
            try {
                i = obj14;
                if (obj15 != null) {
                }
                obj15.close();
                string2 = str;
                i.f(string);
                throw str;
                string2 = str;
                T(string);
                if (string2 != null) {
                }
                string2.close();
                close();
                string2 = str;
                com.amplitude.api.g gVar = i.x;
                String str5 = i.v;
                String str7 = "getValue from %s failed";
                int arr = new Object[arr];
                arr[obj0] = string;
                string = String.format(str7, arr);
                gVar.c(str5, string, th);
                i();
                if (string2 != null) {
                }
                string2.close();
                string2 = str;
                gVar = i.x;
                str5 = i.v;
                str7 = "getValue from %s failed";
                arr = new Object[arr];
                arr[obj0] = string;
                string = String.format(str7, arr);
                gVar.c(str5, string, th);
                i();
                if (string2 != null) {
                }
                string2.close();
                return i;
                str = string2;
                if (str == null) {
                } else {
                }
                str.close();
                close();
                throw string;
                throw string;
            } catch (android.database.sqlite.SQLiteException sQLite) {
            } catch (java.lang.StackOverflowError e1) {
            } catch (java.lang.IllegalStateException ise2) {
            } catch (RuntimeException e3) {
            } catch (Throwable th4) {
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    long U(SQLiteDatabase sQLiteDatabase, String string2, ContentValues contentValues3) {
        return sQLiteDatabase.insert(string2, 0, contentValues3);
        synchronized (this) {
            return sQLiteDatabase.insert(string2, 0, contentValues3);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    long V(SQLiteDatabase sQLiteDatabase, String string2, ContentValues contentValues3) {
        return sQLiteDatabase.insertWithOnConflict(string2, 0, contentValues3, 5);
        synchronized (this) {
            return sQLiteDatabase.insertWithOnConflict(string2, 0, contentValues3, 5);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    long Y(String string, Long long2) {
        String str;
        long obj2;
        Object obj3;
        synchronized (this) {
            obj2 = j("long_store", string);
            try {
                return obj2;
                throw string;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    long a(String string) {
        return c("events", string);
        synchronized (this) {
            return c("events", string);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    long e(String string) {
        return c("identifys", string);
        synchronized (this) {
            return c("identifys", string);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    long e0(String string, String string2) {
        String str;
        long obj2;
        Object obj3;
        synchronized (this) {
            obj2 = j("store", string);
            try {
                return obj2;
                throw string;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    long g0(SQLiteDatabase sQLiteDatabase, String string2, String string3, Object object4) {
        Object contentValues;
        String obj5;
        Object obj6;
        contentValues = new ContentValues();
        contentValues.put("key", string3);
        synchronized (this) {
            try {
                contentValues.put("value", (Long)object4);
                contentValues.put("value", (String)object4);
                final long obj3 = V(sQLiteDatabase, string2, contentValues);
                if (Long.compare(obj3, obj5) == 0) {
                }
                i.x.e(i.v, "Insert failed");
                return obj3;
                throw sQLiteDatabase;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    long j(String string, String string2) {
        int arr;
        com.amplitude.api.g gVar;
        String str2;
        String str;
        long obj6;
        final String[] strArr = new String[1];
        obj6 = (long)obj6;
        close();
        synchronized (this) {
            return obj6;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    long j0(String string, String string2, Object object3) {
        int arr;
        int i;
        String str2;
        String str;
        long obj6;
        String obj7;
        Object obj8;
        final int i2 = 0;
        i = 1;
        int i3 = 0;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        obj6 = g0(writableDatabase, string, string2, object3);
        synchronized (this) {
            if (writableDatabase.isOpen()) {
                close();
            }
            return obj6;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    Cursor l0(SQLiteDatabase sQLiteDatabase, String string2, String[] string3Arr3, String string4, String[] string5Arr5, String string6, String string7, String string8, String string9) {
        return sQLiteDatabase.query(string2, string3Arr3, string4, string5Arr5, string6, string7, string8, string9);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    void m0(long l) {
        t0("events", l);
        return;
        synchronized (this) {
            t0("events", l);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    long n() {
        return o("events");
        synchronized (this) {
            return o("events");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        com.amplitude.api.j jVar;
        int format;
        boolean z;
        String str2;
        String str;
        SQLiteDatabase obj6;
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS store (key TEXT PRIMARY KEY NOT NULL, value TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS long_store (key TEXT PRIMARY KEY NOT NULL, value INTEGER);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS identifys (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);");
        jVar = this.c;
        if (jVar != null && this.b) {
            if (this.b) {
                this.b = false;
                jVar.a(sQLiteDatabase);
                this.b = true;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        int i;
        int stringBuilder;
        int str;
        String obj5;
        int obj6;
        if (i2 > i3) {
            i.x.b(i.v, "onUpgrade() with invalid oldVersion and newVersion");
            G0(sQLiteDatabase);
        }
        i = 1;
        if (i3 <= i) {
        }
        str = 2;
        if (i2 != i) {
            if (i2 != str) {
                if (i2 != 3) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("onUpgrade() with unknown oldVersion ");
                    stringBuilder.append(i2);
                    i.x.b(i.v, stringBuilder.toString());
                    G0(sQLiteDatabase);
                }
            } else {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS identifys (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS long_store (key TEXT PRIMARY KEY NOT NULL, value INTEGER);");
            }
        } else {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS store (key TEXT PRIMARY KEY NOT NULL, value TEXT);");
            if (i3 <= str) {
            } else {
            }
        }
    }

    List<JSONObject> q(long l, long l2) {
        return this.r("events", l, obj3);
        synchronized (this) {
            return this.r("events", l, obj3);
        }
    }

    protected List<JSONObject> r(String string, long l2, long l3) {
        String string3;
        boolean moveToNext;
        com.amplitude.api.g gVar2;
        String string2;
        Cursor cursor;
        SQLiteDatabase long;
        String str3;
        String[] jSONObject;
        String str;
        StringBuilder stringBuilder;
        String str2;
        com.amplitude.api.g gVar;
        int i;
        String str4;
        final Object obj2 = this;
        int i2 = l2;
        int i3 = obj22;
        LinkedList linkedList = new LinkedList();
        i = 0;
        str = 0;
        synchronized (this) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("id <= ");
            stringBuilder.append(i2);
            string3 = stringBuilder.toString();
            if (Long.compare(i3, str) >= 0) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("");
                stringBuilder2.append(i3);
                str4 = string2;
            } else {
                str4 = i;
            }
            str3 = string;
            cursor = this.l0(getReadableDatabase(), str3, /* result */, string3, 0, 0, 0, "id ASC", str4);
            try {
                while (cursor.moveToNext()) {
                    string3 = cursor.getString(1);
                    if (n.d(string3) != null) {
                    } else {
                    }
                    jSONObject = new JSONObject(string3);
                    jSONObject.put("event_id", cursor.getLong(0));
                    linkedList.add(jSONObject);
                }
                string3 = cursor.getString(i11);
                if (n.d(string3) != null) {
                } else {
                }
                jSONObject = new JSONObject(string3);
                jSONObject.put("event_id", cursor.getLong(i10));
                linkedList.add(jSONObject);
            } catch (android.database.sqlite.SQLiteException sQLite) {
            } catch (java.lang.StackOverflowError e1) {
            } catch (java.lang.IllegalStateException ise2) {
            } catch (RuntimeException e3) {
            } catch (Throwable th4) {
            }
            cursor.close();
            close();
            return linkedList;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    void v0(long l) {
        z0("events", l);
        return;
        synchronized (this) {
            z0("events", l);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    long w() {
        return o("identifys");
        synchronized (this) {
            return o("identifys");
        }
    }

    List<JSONObject> x(long l, long l2) {
        return this.r("identifys", l, obj3);
        synchronized (this) {
            return this.r("identifys", l, obj3);
        }
    }
}
