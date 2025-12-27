package d.s.a;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* compiled from: SupportSQLiteOpenHelper.java */
/* loaded from: classes.dex */
public interface h extends Closeable {

    public static abstract class a {

        public final int a;
        public a(int i) {
            super();
            this.a = i;
        }

        private void a(String str) {
            if (!str.equalsIgnoreCase(":memory:")) {
                if (str.trim().length() != 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str8 = "deleting the database file: ";
                    str6 = str8 + str;
                    str2 = "SupportSQLite";
                    Log.w(str2, str6);
                    try {
                        int i = 16;
                        b.c(new File(str));
                    } catch (Exception e) {
                    }
                    try {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        String str9 = "Could not delete the database file ";
                        str3 = str9 + e;
                        Log.e(str2, str3);
                    } catch (Exception e) {
                    }
                }
            }
        }

        public void c(g gVar) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Corruption reported by sqlite on database: ";
            String path2 = gVar.getPath();
            str = str2 + path2;
            Log.e("SupportSQLite", str);
            if (!gVar.isOpen()) {
                a(gVar.getPath());
                return;
            }
            try {
                List second2 = gVar.z();
            } catch (Throwable th) {
            } catch (java.io.IOException unused) {
                Iterator it = second2.iterator();
                a((String)(Pair)it.next().second);
                a(gVar.getPath());
                return;
            }
            try {
                gVar.close();
            } catch (Throwable th) {
            } catch (java.io.IOException unused) {
                it = second2.iterator();
                a((String)(Pair)it.next().second);
                a(gVar.getPath());
                return;
            }
            if (second22) {
                gVar = second22.iterator();
                boolean second22 = gVar.hasNext();
                if (second22) {
                    second22 = gVar.next();
                    a(second22);
                }
            } else {
                gVar = gVar.getPath();
                a(gVar);
            }
            throw th;
        }

        public void e(g gVar, int i, int i2) throws SQLiteException {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Can't downgrade database from version ";
            String str2 = " to ";
            i = str + i + str2 + i2;
            throw new SQLiteException(i);
        }

        public void b(g gVar) {
        }

        public abstract void d(g gVar);

        public void f(g gVar) {
        }

        public abstract void g(g gVar, int i, int i2);
    }

    public static class b {

        public final Context a;
        public final String b;
        public final h.a c;
        public final boolean d;
        b(Context context, String str, h.a aVar, boolean z) {
            super();
            this.a = context;
            this.b = str;
            this.c = aVar;
            this.d = z;
        }

        public static h.b.a a(Context context) {
            return new h.b.a(context);
        }
    }

    public interface c {
        h a(h.b bVar);
    }
    @Override // java.io.Closeable
    void close();

    String getDatabaseName();

    g getReadableDatabase();

    g getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z);
}
