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

/* compiled from: FrameworkSQLiteOpenHelper.java */
/* loaded from: classes.dex */
class b implements h {

    private final Context a;
    private final String b;
    private final h.a c;
    private final boolean v;
    private final Object w = new Object();
    private b.a x;
    private boolean y;

    static class a extends SQLiteOpenHelper {

        final a[] a;
        final h.a b;
        private boolean c;
        a(Context context, String str, a[] aVarArr, h.a aVar) {
            super(context, str, null, aVar.a, new b.a.a(aVar, aVarArr));
            this.b = aVar;
            this.a = aVarArr;
        }

        static a e(a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            final int i = 0;
            Object obj = aVarArr[i];
            if (obj == null || !obj.a(sQLiteDatabase)) {
                aVarArr[i] = new a(sQLiteDatabase);
            }
            return aVarArr[i];
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        synchronized g a() {
            this.c = false;
            close();
            return c(super.getReadableDatabase());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        a c(SQLiteDatabase sQLiteDatabase) {
            return b.a.e(this.a, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public synchronized void close() {
            super.close();
            this.a[0] = 0;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        synchronized g f() {
            this.c = false;
            close();
            return c(super.getWritableDatabase());
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
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.c = true;
            this.b.e(c(sQLiteDatabase), i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.c) {
                this.b.f(c(sQLiteDatabase));
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.c = true;
            this.b.g(c(sQLiteDatabase), i, i2);
        }
    }
    b(Context context, String str, h.a aVar, boolean z) {
        super();
        this.a = context;
        this.b = str;
        this.c = aVar;
        this.v = z;
        final Object object = new Object();
    }

    private b.a a() {
        String absolutePath;
        d.s.a.l.b.a aVar2;
        Context context;
        h.a aVar3;
        synchronized (obj2) {
            try {
                if (this.x == null) {
                    d.s.a.l.a[] arr = new a[1];
                    sDK_INT2 = Build.VERSION.SDK_INT;
                    int i = 23;
                    if (Build.VERSION.SDK_INT < 23 || this.b == null || !this.v) {
                        this.x = new b.a(this.a, this.b, arr, this.c);
                    } else {
                        this.x = new b.a(this.a, new File(d.a(this.a), this.b).getAbsolutePath(), arr, this.c);
                    }
                    if (Build.VERSION.SDK_INT >= 16) {
                        b.f(this.x, this.y);
                    }
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public void close() {
        a().close();
    }

    public String getDatabaseName() {
        return this.b;
    }

    public g getReadableDatabase() {
        return a().a();
    }

    public g getWritableDatabase() {
        return a().f();
    }

    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (obj2) {
            try {
                if (this.x != null) {
                    b.f(this.x, z);
                }
                this.y = z;
                return;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }
}
