package d.s.a.l;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import d.s.a.b;
import d.s.a.d;
import d.s.a.g;
import d.s.a.h;
import d.s.a.h.a;
import java.io.File;

/* loaded from: classes.dex */
class b implements h {

    private final Context a;
    private final String b;
    private final h.a c;
    private final boolean v;
    private final Object w;
    private d.s.a.l.b.a x;
    private boolean y;

    static class a extends SQLiteOpenHelper {

        final d.s.a.l.a[] a;
        final h.a b;
        private boolean c;
        a(Context context, String string2, d.s.a.l.a[] a3Arr3, h.a h$a4) {
            b.a.a aVar = new b.a.a(a4, a3Arr3);
            super(context, string2, 0, a4.a, aVar);
            this.b = a4;
            this.a = a3Arr3;
        }

        static d.s.a.l.a e(d.s.a.l.a[] aArr, SQLiteDatabase sQLiteDatabase2) {
            boolean aVar;
            final int i = 0;
            aVar = aArr[i];
            if (aVar != null) {
                if (!aVar.a(sQLiteDatabase2)) {
                    aVar = new a(sQLiteDatabase2);
                    aArr[i] = aVar;
                }
            } else {
            }
            return aArr[i];
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        g a() {
            this.c = false;
            synchronized (this) {
                close();
                return a();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        d.s.a.l.a c(SQLiteDatabase sQLiteDatabase) {
            return b.a.e(this.a, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void close() {
            super.close();
            this.a[0] = 0;
            return;
            synchronized (this) {
                super.close();
                this.a[0] = 0;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        g f() {
            this.c = false;
            synchronized (this) {
                close();
                return f();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.b.b(c(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.b.d(c(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.c = true;
            this.b.e(c(sQLiteDatabase), i2, i3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            boolean z;
            Object obj2;
            if (!this.c) {
                this.b.f(c(sQLiteDatabase));
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.c = true;
            this.b.g(c(sQLiteDatabase), i2, i3);
        }
    }
    b(Context context, String string2, h.a h$a3, boolean z4) {
        super();
        this.a = context;
        this.b = string2;
        this.c = a3;
        this.v = z4;
        Object obj1 = new Object();
        this.w = obj1;
    }

    private d.s.a.l.b.a a() {
        d.s.a.l.b.a aVar;
        int sDK_INT;
        Object absolutePath;
        int i;
        Object aVar2;
        Object obj;
        h.a aVar3;
        final Object obj2 = this.w;
        synchronized (obj2) {
            d.s.a.l.a[] arr = new a[1];
            sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 23 && this.b != null && this.v) {
                if (this.b != null) {
                    try {
                        if (this.v) {
                        } else {
                        }
                        File file = new File(d.a(this.a), this.b);
                        aVar2 = new b.a(this.a, file.getAbsolutePath(), arr, this.c);
                        this.x = aVar2;
                        absolutePath = new b.a(this.a, this.b, arr, this.c);
                        this.x = absolutePath;
                        if (sDK_INT >= 16) {
                        }
                        b.f(this.x, this.y);
                        return this.x;
                        throw th;
                    }
                } else {
                }
            } else {
            }
        }
    }

    @Override // d.s.a.h
    public void close() {
        a().close();
    }

    @Override // d.s.a.h
    public String getDatabaseName() {
        return this.b;
    }

    @Override // d.s.a.h
    public g getReadableDatabase() {
        return a().a();
    }

    @Override // d.s.a.h
    public g getWritableDatabase() {
        return a().f();
    }

    @Override // d.s.a.h
    public void setWriteAheadLoggingEnabled(boolean z) {
        final Object obj = this.w;
        final d.s.a.l.b.a aVar = this.x;
        synchronized (obj) {
            b.f(aVar, z);
            this.y = z;
        }
    }
}
