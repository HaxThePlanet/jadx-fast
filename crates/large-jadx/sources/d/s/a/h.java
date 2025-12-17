package d.s.a;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public interface h extends Closeable {

    public static abstract class a {

        public final int a;
        public a(int i) {
            super();
            this.a = i;
        }

        private void a(String string) {
            boolean equalsIgnoreCase;
            String str2;
            int str;
            String obj4;
            if (!string.equalsIgnoreCase(":memory:")) {
                if (string.trim().length() == 0) {
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("deleting the database file: ");
                    stringBuilder.append(string);
                    str2 = "SupportSQLite";
                    Log.w(str2, stringBuilder.toString());
                    if (Build.VERSION.SDK_INT >= 16) {
                        equalsIgnoreCase = new File(string);
                        b.c(equalsIgnoreCase);
                    } else {
                        File file = new File(string);
                        if (file.delete() == null) {
                            equalsIgnoreCase = new StringBuilder();
                            equalsIgnoreCase.append("Could not delete the database file ");
                            equalsIgnoreCase.append(string);
                            Log.e(str2, equalsIgnoreCase.toString());
                        }
                    }
                }
            }
        }

        public void b(d.s.a.g g) {
        }

        public void c(d.s.a.g g) {
            boolean second;
            Object obj3;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Corruption reported by sqlite on database: ");
            stringBuilder.append(g.getPath());
            Log.e("SupportSQLite", stringBuilder.toString());
            if (!g.isOpen()) {
                a(g.getPath());
            }
            int i = 0;
            second = g.z();
            g.close();
            if (second != null) {
                obj3 = second.iterator();
                for (Pair next : obj3) {
                    a((String)next.second);
                }
            } else {
                a(g.getPath());
            }
        }

        public abstract void d(d.s.a.g g);

        public void e(d.s.a.g g, int i2, int i3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Can't downgrade database from version ");
            stringBuilder.append(i2);
            stringBuilder.append(" to ");
            stringBuilder.append(i3);
            SQLiteException obj3 = new SQLiteException(stringBuilder.toString());
            throw obj3;
        }

        public void f(d.s.a.g g) {
        }

        public abstract void g(d.s.a.g g, int i2, int i3);
    }

    public static class b {

        public final Context a;
        public final String b;
        public final d.s.a.h.a c;
        public final boolean d;
        b(Context context, String string2, d.s.a.h.a h$a3, boolean z4) {
            super();
            this.a = context;
            this.b = string2;
            this.c = a3;
            this.d = z4;
        }

        public static d.s.a.h.b.a a(Context context) {
            h.b.a aVar = new h.b.a(context);
            return aVar;
        }
    }

    public interface c {
        public abstract d.s.a.h a(d.s.a.h.b h$b);
    }
    @Override // java.io.Closeable
    public abstract void close();

    @Override // java.io.Closeable
    public abstract String getDatabaseName();

    @Override // java.io.Closeable
    public abstract d.s.a.g getReadableDatabase();

    @Override // java.io.Closeable
    public abstract d.s.a.g getWritableDatabase();

    @Override // java.io.Closeable
    public abstract void setWriteAheadLoggingEnabled(boolean z);
}
