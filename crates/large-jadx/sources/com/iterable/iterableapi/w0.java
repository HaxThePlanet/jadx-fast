package com.iterable.iterableapi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: IterableTaskStorage.java */
/* loaded from: classes2.dex */
class w0 {

    private static w0 e;
    private SQLiteDatabase a;
    private s b = new s();
    private ArrayList<w0.d> c = new ArrayList<>();
    private ArrayList<w0.c> d = new ArrayList<>();

    class a implements Runnable {

        final /* synthetic */ u0 a;
        final /* synthetic */ w0 b;
        a(u0 u0Var) {
            this.b = w0Var;
            this.a = u0Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.b.c.iterator();
            while (it.hasNext()) {
                (w0.d)it.next().b(this.a);
            }
        }
    }

    class b implements Runnable {

        final /* synthetic */ w0 a;
        b() {
            this.a = w0Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.a.d.iterator();
            while (it.hasNext()) {
                (w0.c)it.next().b();
            }
        }
    }

    public interface c {
        void a();

        void b();
    }

    interface d {
        void b(u0 u0Var);
    }
    private w0(Context context) {
        com.iterable.iterableapi.s sVar;
        super();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (context == null) {
            return;
        }
        try {
            if (this.b == null) {
                sVar = new s(context);
            }
            this.a = this.b.getWritableDatabase();
        } catch (android.database.SQLException unused) {
            context = "IterableTaskStorage";
            j0.c(context, "Database cannot be opened for writing");
        }
    }

    static /* synthetic */ ArrayList a(w0 w0Var) {
        return w0Var.c;
    }

    static /* synthetic */ ArrayList b(w0 w0Var) {
        return w0Var.d;
    }

    private u0 f(Cursor cursor) {
        int _int;
        int i = 1;
        int i2 = 1;
        int i4 = 1;
        int i3;
        int i5;
        Object obj = cursor;
        str = "modified";
        i3 = 0;
        if (!obj.isNull(obj.getColumnIndex(str))) {
        } else {
        }
        str2 = "last_attempt";
        if (!obj.isNull(obj.getColumnIndex(str2))) {
        } else {
        }
        str3 = "scheduled";
        if (!obj.isNull(obj.getColumnIndex(str3))) {
        } else {
        }
        str4 = "requested";
        if (!obj.isNull(obj.getColumnIndex(str4))) {
        } else {
        }
        str5 = "processing";
        final long l2 = 0L;
        if (!obj.isNull(obj.getColumnIndex(str5))) {
            int r1 = obj.getInt(obj.getColumnIndex(str5)) > 0 ? 1 : l2;
        }
        str6 = "failed";
        if (!obj.isNull(obj.getColumnIndex(str6))) {
            int r2 = obj.getInt(obj.getColumnIndex(str6)) > 0 ? 1 : l2;
            i2 = (obj.getInt(obj.getColumnIndex(str6)) > 0 ? 1 : l2);
        } else {
            i2 = l2;
        }
        str7 = "blocking";
        if (!obj.isNull(obj.getColumnIndex(str7))) {
            int r8 = obj.getInt(obj.getColumnIndex(str7)) > 0 ? 1 : l2;
            i4 = (obj.getInt(obj.getColumnIndex(str7)) > 0 ? 1 : l2);
        } else {
            i4 = l2;
        }
        string = "data";
        i5 = 0;
        if (!obj.isNull(obj.getColumnIndex(string))) {
        } else {
        }
        string2 = "error";
        if (!obj.isNull(obj.getColumnIndex(string2))) {
        } else {
        }
        str8 = "type";
        if (!obj.isNull(obj.getColumnIndex(str8))) {
        } else {
        }
        str9 = "attempts";
        if (!obj.isNull(obj.getColumnIndex(str9))) {
            _int = obj.getInt(obj.getColumnIndex(str9));
        } else {
            _int = l2;
        }
        u0 u0Var = new u0(obj.getString(obj.getColumnIndex("task_id")), obj.getString(obj.getColumnIndex("name")), obj.getInt(obj.getColumnIndex("version")), obj.getLong(obj.getColumnIndex("created")), l, i3, 0L, i3, z, i3, z3, i3, str16, i, i2, i4, i5, i5, i5, _int);
        return u0Var;
    }

    private boolean k() {
        l();
        j0.c("IterableTaskStorage", "Database not initialized or is closed");
        return false;
    }

    private void l() {
        new Handler(Looper.getMainLooper()).post(new w0.b(this));
    }

    static w0 m(Context context) {
        if (w0.e == null) {
            w0.e = new w0(context);
        }
        return w0.e;
    }

    void c(w0.c cVar) {
        if (k()) {
            cVar.a();
        } else {
            cVar.b();
        }
        this.d.add(cVar);
    }

    void d(w0.d dVar) {
        this.c.add(dVar);
    }

    String e(String str, x0 x0Var, String str2) throws SQLException {
        String str4;
        final String str5 = null;
        if (!k()) {
            return str5;
        }
        ContentValues contentValues = new ContentValues();
        final com.iterable.iterableapi.u0 u0Var = new u0(str, x0.API, str2);
        contentValues.put("task_id", u0Var.a);
        contentValues.put("name", u0Var.b);
        contentValues.put("version", Integer.valueOf(u0Var.c));
        str2 = "created";
        contentValues.put(str2, Long.valueOf(u0Var.d));
        long l7 = 0L;
        if (u0Var.e != l7) {
            str2 = "modified";
            contentValues.put(str2, Long.valueOf(u0Var.e));
        }
        if (u0Var.f != l7) {
            str2 = "last_attempt";
            contentValues.put(str2, Long.valueOf(u0Var.f));
        }
        if (u0Var.g != l7) {
            str2 = "scheduled";
            contentValues.put(str2, Long.valueOf(u0Var.g));
        }
        if (u0Var.h != l7) {
            str2 = "requested";
            contentValues.put(str2, Long.valueOf(u0Var.h));
        }
        contentValues.put("processing", Boolean.valueOf(u0Var.i));
        contentValues.put("failed", Boolean.valueOf(u0Var.j));
        str4 = "blocking";
        contentValues.put(str4, Boolean.valueOf(u0Var.k));
        if (u0Var.l != null) {
            str4 = "data";
            contentValues.put(str4, u0Var.l);
        }
        if (u0Var.m != null) {
            str4 = "error";
            contentValues.put(str4, u0Var.m);
        }
        contentValues.put("type", u0Var.n.toString());
        contentValues.put("attempts", Integer.valueOf(u0Var.o));
        long insert = this.a.insert("OfflineTask", str5, contentValues);
        if (insert == -1) {
            l();
            return str5;
        }
        contentValues.clear();
        new Handler(Looper.getMainLooper()).post(new w0.a(this, u0Var));
        return u0Var.a;
    }

    void g() throws SQLException {
        if (!k()) {
            return;
        }
        String str5 = null;
        int delete = this.a.delete("OfflineTask", str5, str5);
        StringBuilder stringBuilder = new StringBuilder();
        String str6 = "Deleted ";
        String str = " offline tasks";
        str2 = str6 + delete + str;
        j0.h("IterableTaskStorage", str2);
    }

    boolean h(String str) throws SQLException {
        int i = 0;
        if (!k()) {
            return false;
        }
        final int i2 = 1;
        final String[] strArr = new String[i2];
        strArr[i] = str;
        int delete = this.a.delete("OfflineTask", "task_id =?", strArr);
        StringBuilder stringBuilder = new StringBuilder();
        String str4 = "Deleted entry - ";
        str6 = str4 + delete;
        j0.h("IterableTaskStorage", str6);
        return true;
    }

    u0 i() throws SQLException {
        String[] strArr = null;
        strArr = null;
        if (!k()) {
            return strArr;
        }
        Cursor rawQuery = this.a.rawQuery("select * from OfflineTask order by scheduled limit 1", strArr);
        if (rawQuery.moveToFirst()) {
            com.iterable.iterableapi.u0 u0Var = f(rawQuery);
        }
        rawQuery.close();
        return strArr;
    }

    long j() {
        if (!k()) {
            throw new IllegalStateException("Database is not ready");
        } else {
            return DatabaseUtils.queryNumEntries(this.a, "OfflineTask");
        }
    }
}
