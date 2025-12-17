package androidx.room;

import android.database.Cursor;
import androidx.room.e1.b;
import d.s.a.a;
import d.s.a.g;
import d.s.a.h.a;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class w0 extends h.a {

    private androidx.room.e0 b;
    private final androidx.room.w0.a c;
    private final String d;
    private final String e;

    public static abstract class a {

        public final int a;
        public a(int i) {
            super();
            this.a = i;
        }

        protected abstract void a(g g);

        protected abstract void b(g g);

        protected abstract void c(g g);

        protected abstract void d(g g);

        protected abstract void e(g g);

        protected abstract void f(g g);

        protected abstract androidx.room.w0.b g(g g);
    }

    public static class b {

        public final boolean a;
        public final String b;
        public b(boolean z, String string2) {
            super();
            this.a = z;
            this.b = string2;
        }
    }
    public w0(androidx.room.e0 e0, androidx.room.w0.a w0$a2, String string3, String string4) {
        super(a2.a);
        this.b = e0;
        this.c = a2;
        this.d = string3;
        this.e = string4;
    }

    private void h(g g) {
        int string;
        boolean moveToFirst;
        String str;
        boolean obj4;
        if (w0.k(g)) {
            string = 0;
            a aVar2 = new a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1");
            obj4 = g.j1(aVar2);
            if (obj4.moveToFirst()) {
                string = obj4.getString(0);
            }
            obj4.close();
            if (!this.d.equals(string)) {
                if (!this.e.equals(string)) {
                } else {
                }
                obj4 = new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                throw obj4;
            }
        } else {
            androidx.room.w0.b bVar = this.c.g(g);
            if (!bVar.a) {
            } else {
                this.c.e(g);
                l(g);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pre-packaged database has an invalid schema: ");
        stringBuilder.append(bVar.b);
        obj4 = new IllegalStateException(stringBuilder.toString());
        throw obj4;
    }

    private void i(g g) {
        g.C("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean j(g g) {
        boolean moveToFirst;
        int i;
        final Cursor obj2 = g.H0("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        if (obj2.moveToFirst() && obj2.getInt(0) == 0) {
            if (obj2.getInt(i) == 0) {
                i = 1;
            }
        }
        obj2.close();
        return i;
    }

    private static boolean k(g g) {
        boolean moveToFirst;
        int i;
        final Cursor obj2 = g.H0("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        if (obj2.moveToFirst() && obj2.getInt(0) != 0) {
            if (obj2.getInt(i) != 0) {
                i = 1;
            }
        }
        obj2.close();
        return i;
    }

    private void l(g g) {
        i(g);
        g.C(v0.a(this.d));
    }

    @Override // d.s.a.h$a
    public void b(g g) {
        super.b(g);
    }

    @Override // d.s.a.h$a
    public void d(g g) {
        boolean z;
        androidx.room.w0.a aVar;
        this.c.a(g);
        if (!w0.j(g)) {
            z = this.c.g(g);
            if (!z.a) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Pre-packaged database has an invalid schema: ");
            stringBuilder.append(z.b);
            IllegalStateException obj4 = new IllegalStateException(stringBuilder.toString());
            throw obj4;
        }
        l(g);
        this.c.c(g);
    }

    @Override // d.s.a.h$a
    public void e(g g, int i2, int i3) {
        g(g, i2, i3);
    }

    @Override // d.s.a.h$a
    public void f(g g) {
        super.f(g);
        h(g);
        this.c.d(g);
        this.b = 0;
    }

    @Override // d.s.a.h$a
    public void g(g g, int i2, int i3) {
        int i;
        Object e0Var;
        boolean z;
        androidx.room.w0.a next;
        int obj4;
        e0Var = this.b;
        e0Var = e0Var.d.c(i2, i3);
        if (e0Var != null && e0Var != null) {
            e0Var = e0Var.d.c(i2, i3);
            if (e0Var != null) {
                this.c.f(g);
                Iterator iterator = e0Var.iterator();
                for (b next : iterator) {
                    next.a(g);
                }
                androidx.room.w0.b bVar = this.c.g(g);
                if (!bVar.a) {
                } else {
                    this.c.e(g);
                    l(g);
                    i = 1;
                    if (i == 0) {
                        i = this.b;
                        if (i == null) {
                        } else {
                            if (i.a(i2, i3)) {
                            } else {
                                this.c.b(g);
                                this.c.a(g);
                            }
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("A migration from ");
                        stringBuilder.append(i2);
                        stringBuilder.append(" to ");
                        stringBuilder.append(i3);
                        stringBuilder.append(" was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
                        IllegalStateException obj3 = new IllegalStateException(stringBuilder.toString());
                        throw obj3;
                    }
                }
                obj4 = new StringBuilder();
                obj4.append("Migration didn't properly handle: ");
                obj4.append(bVar.b);
                obj3 = new IllegalStateException(obj4.toString());
                throw obj3;
            }
        }
        i = 0;
    }
}
