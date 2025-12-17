package com.iterable.iterableapi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
class w0 {

    private static com.iterable.iterableapi.w0 e;
    private SQLiteDatabase a;
    private com.iterable.iterableapi.s b;
    private ArrayList<com.iterable.iterableapi.w0.d> c;
    private ArrayList<com.iterable.iterableapi.w0.c> d;

    class a implements Runnable {

        final com.iterable.iterableapi.u0 a;
        final com.iterable.iterableapi.w0 b;
        a(com.iterable.iterableapi.w0 w0, com.iterable.iterableapi.u0 u02) {
            this.b = w0;
            this.a = u02;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object next;
            com.iterable.iterableapi.u0 u0Var;
            Iterator iterator = w0.a(this.b).iterator();
            for (w0.d next : iterator) {
                next.b(this.a);
            }
        }
    }

    class b implements Runnable {

        final com.iterable.iterableapi.w0 a;
        b(com.iterable.iterableapi.w0 w0) {
            this.a = w0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object next;
            Iterator iterator = w0.b(this.a).iterator();
            for (w0.c next : iterator) {
                next.b();
            }
        }
    }

    public interface c {
        public abstract void a();

        public abstract void b();
    }

    interface d {
        public abstract void b(com.iterable.iterableapi.u0 u0);
    }
    private w0(Context context) {
        com.iterable.iterableapi.s sVar;
        SQLiteDatabase obj2;
        super();
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.d = arrayList2;
        if (context == null) {
        }
        if (this.b == null) {
            sVar = new s(context);
            this.b = sVar;
        }
        this.a = this.b.getWritableDatabase();
    }

    static ArrayList a(com.iterable.iterableapi.w0 w0) {
        return w0.c;
    }

    static ArrayList b(com.iterable.iterableapi.w0 w0) {
        return w0.d;
    }

    private com.iterable.iterableapi.u0 f(Cursor cursor) {
        int int;
        String long3;
        String long4;
        String long;
        String long2;
        String str;
        int i10;
        String str2;
        String str3;
        String string;
        String string2;
        Object valueOf;
        String columnIndex;
        boolean null;
        int i;
        int i2;
        int i3;
        int i4;
        int i6;
        int i5;
        int i7;
        int i9;
        int i8;
        Object obj = cursor;
        long3 = "modified";
        int i11 = 0;
        if (!obj.isNull(obj.getColumnIndex(long3))) {
            i = long3;
        } else {
            i = i11;
        }
        long4 = "last_attempt";
        if (!obj.isNull(obj.getColumnIndex(long4))) {
            i2 = long4;
        } else {
            i2 = i11;
        }
        long = "scheduled";
        if (!obj.isNull(obj.getColumnIndex(long))) {
            i3 = long;
        } else {
            i3 = i11;
        }
        long2 = "requested";
        if (!obj.isNull(obj.getColumnIndex(long2))) {
            i4 = long2;
        } else {
            i4 = i11;
        }
        str = "processing";
        final int i13 = 0;
        if (!obj.isNull(obj.getColumnIndex(str)) && obj.getInt(obj.getColumnIndex(str)) > 0) {
            i10 = obj.getInt(obj.getColumnIndex(str)) > 0 ? 1 : i13;
        } else {
        }
        str2 = "failed";
        if (!obj.isNull(obj.getColumnIndex(str2))) {
            str2 = obj.getInt(obj.getColumnIndex(str2)) > 0 ? 1 : i13;
            i5 = str2;
        } else {
            i5 = i13;
        }
        str3 = "blocking";
        if (!obj.isNull(obj.getColumnIndex(str3))) {
            null = obj.getInt(obj.getColumnIndex(str3)) > 0 ? 1 : i13;
            i6 = null;
        } else {
            i6 = i13;
        }
        string = "data";
        int i20 = 0;
        if (!obj.isNull(obj.getColumnIndex(string))) {
            i7 = string;
        } else {
            i7 = i20;
        }
        string2 = "error";
        if (!obj.isNull(obj.getColumnIndex(string2))) {
            i9 = string2;
        } else {
            i9 = i20;
        }
        valueOf = "type";
        if (!obj.isNull(obj.getColumnIndex(valueOf))) {
            i8 = valueOf;
        } else {
            i8 = i20;
        }
        columnIndex = "attempts";
        if (!obj.isNull(obj.getColumnIndex(columnIndex))) {
            int = obj.getInt(obj.getColumnIndex(columnIndex));
        } else {
            int = i13;
        }
        super(obj.getString(obj.getColumnIndex("task_id")), obj.getString(obj.getColumnIndex("name")), obj.getInt(obj.getColumnIndex("version")), obj.getLong(obj.getColumnIndex("created")), obj7, i, i13, i2, obj11, i3, obj13, i4, obj15, i10, i5, i6, i7, i9, i8, int);
        return u0Var2;
    }

    private boolean k() {
        SQLiteDatabase open;
        open = this.a;
        if (open != null && !open.isOpen()) {
            if (!open.isOpen()) {
            }
            return 1;
        }
        l();
        j0.c("IterableTaskStorage", "Database not initialized or is closed");
        return 0;
    }

    private void l() {
        Handler handler = new Handler(Looper.getMainLooper());
        w0.b bVar = new w0.b(this);
        handler.post(bVar);
    }

    static com.iterable.iterableapi.w0 m(Context context) {
        com.iterable.iterableapi.w0 w0Var;
        if (w0.e == null) {
            w0Var = new w0(context);
            w0.e = w0Var;
        }
        return w0.e;
    }

    void c(com.iterable.iterableapi.w0.c w0$c) {
        if (k()) {
            c.a();
        } else {
            c.b();
        }
        this.d.add(c);
    }

    void d(com.iterable.iterableapi.w0.d w0$d) {
        this.c.add(d);
    }

    String e(String string, com.iterable.iterableapi.x0 x02, String string3) {
        int obj7;
        String obj9;
        final int i = 0;
        if (!k()) {
            return i;
        }
        ContentValues obj8 = new ContentValues();
        u0 u0Var = new u0(string, x0.API, string3);
        obj8.put("task_id", u0Var.a);
        obj8.put("name", u0Var.b);
        obj8.put("version", Integer.valueOf(u0Var.c));
        obj8.put("created", Long.valueOf(u0Var.d));
        long l2 = u0Var.e;
        int i2 = 0;
        if (Long.compare(l2, i2) != 0) {
            obj8.put("modified", Long.valueOf(l2));
        }
        long l3 = u0Var.f;
        if (Long.compare(l3, i2) != 0) {
            obj8.put("last_attempt", Long.valueOf(l3));
        }
        long l4 = u0Var.g;
        if (Long.compare(l4, i2) != 0) {
            obj8.put("scheduled", Long.valueOf(l4));
        }
        long l5 = u0Var.h;
        if (Long.compare(l5, i2) != 0) {
            obj8.put("requested", Long.valueOf(l5));
        }
        obj8.put("processing", Boolean.valueOf(u0Var.i));
        obj8.put("failed", Boolean.valueOf(u0Var.j));
        obj8.put("blocking", Boolean.valueOf(u0Var.k));
        obj7 = u0Var.l;
        if (obj7 != null) {
            obj8.put("data", obj7);
        }
        obj7 = u0Var.m;
        if (obj7 != null) {
            obj8.put("error", obj7);
        }
        obj8.put("type", u0Var.n.toString());
        obj8.put("attempts", Integer.valueOf(u0Var.o));
        if (Long.compare(insert, i3) == 0) {
            l();
            return i;
        }
        obj8.clear();
        obj7 = new Handler(Looper.getMainLooper());
        obj8 = new w0.a(this, u0Var);
        obj7.post(obj8);
        return u0Var.a;
    }

    void g() {
        if (!k()) {
        }
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Deleted ");
        stringBuilder.append(this.a.delete("OfflineTask", i, i));
        stringBuilder.append(" offline tasks");
        j0.h("IterableTaskStorage", stringBuilder.toString());
    }

    boolean h(String string) {
        int i = 0;
        if (!k()) {
            return i;
        }
        final int i2 = 1;
        final String[] strArr = new String[i2];
        strArr[i] = string;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Deleted entry - ");
        stringBuilder.append(this.a.delete("OfflineTask", "task_id =?", strArr));
        j0.h("IterableTaskStorage", stringBuilder.toString());
        return i2;
    }

    com.iterable.iterableapi.u0 i() {
        int i;
        i = 0;
        if (!k()) {
            return i;
        }
        Cursor rawQuery = this.a.rawQuery("select * from OfflineTask order by scheduled limit 1", i);
        if (rawQuery.moveToFirst()) {
            i = f(rawQuery);
        }
        rawQuery.close();
        return i;
    }

    long j() {
        if (!k()) {
        } else {
            return DatabaseUtils.queryNumEntries(this.a, "OfflineTask");
        }
        IllegalStateException illegalStateException = new IllegalStateException("Database is not ready");
        throw illegalStateException;
    }
}
