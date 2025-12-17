package app.dogo.android.persistencedb.example;

import androidx.room.e0;
import androidx.room.e1.a;
import androidx.room.e1.b;
import androidx.room.f1.c;
import androidx.room.f1.g;
import androidx.room.f1.g.a;
import androidx.room.m0;
import androidx.room.u0;
import androidx.room.u0.b;
import androidx.room.w0;
import androidx.room.w0.a;
import androidx.room.w0.b;
import d.s.a.g;
import d.s.a.h;
import d.s.a.h.b;
import d.s.a.h.b.a;
import d.s.a.h.c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class ExampleDatabase_Impl extends app.dogo.android.persistencedb.example.ExampleDatabase {

    class a extends w0.a {

        final app.dogo.android.persistencedb.example.ExampleDatabase_Impl b;
        a(app.dogo.android.persistencedb.example.ExampleDatabase_Impl exampleDatabase_Impl, int i2) {
            this.b = exampleDatabase_Impl;
            super(i2);
        }

        @Override // androidx.room.w0$a
        public void a(g g) {
            g.C("CREATE TABLE IF NOT EXISTS `ExampleEntity` (`id` TEXT NOT NULL, `goodField` TEXT NOT NULL, PRIMARY KEY(`id`))");
            g.C("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            g.C("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '450612a4f3a2d29e744c6987e2cc2bc9')");
        }

        @Override // androidx.room.w0$a
        public void b(g g) {
            int list;
            int size;
            Object obj;
            g.C("DROP TABLE IF EXISTS `ExampleEntity`");
            if (ExampleDatabase_Impl.E(this.b) != null) {
                list = 0;
                while (list < ExampleDatabase_Impl.F(this.b).size()) {
                    (u0.b)ExampleDatabase_Impl.H(this.b).get(list).b(g);
                    list++;
                }
            }
        }

        @Override // androidx.room.w0$a
        protected void c(g g) {
            int list;
            int size;
            Object obj;
            if (ExampleDatabase_Impl.I(this.b) != null) {
                list = 0;
                while (list < ExampleDatabase_Impl.J(this.b).size()) {
                    (u0.b)ExampleDatabase_Impl.K(this.b).get(list).a(g);
                    list++;
                }
            }
        }

        @Override // androidx.room.w0$a
        public void d(g g) {
            int list;
            int size;
            Object obj;
            ExampleDatabase_Impl.L(this.b, g);
            ExampleDatabase_Impl.M(this.b, g);
            if (ExampleDatabase_Impl.N(this.b) != null) {
                list = 0;
                while (list < ExampleDatabase_Impl.O(this.b).size()) {
                    (u0.b)ExampleDatabase_Impl.G(this.b).get(list).c(g);
                    list++;
                }
            }
        }

        @Override // androidx.room.w0$a
        public void e(g g) {
        }

        @Override // androidx.room.w0$a
        public void f(g g) {
            c.b(g);
        }

        @Override // androidx.room.w0$a
        protected w0.b g(g g) {
            HashMap hashMap = new HashMap(2);
            final int i6 = 1;
            super("id", "TEXT", 1, i6, 0, 1);
            hashMap.put("id", aVar);
            super("goodField", "TEXT", i6, 0, 0, 1);
            hashMap.put("goodField", aVar2);
            int i4 = 0;
            HashSet hashSet = new HashSet(i4);
            HashSet hashSet2 = new HashSet(i4);
            String str9 = "ExampleEntity";
            g gVar = new g(str9, hashMap, hashSet, hashSet2);
            g obj11 = g.a(g, str9);
            if (!gVar.equals(obj11)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ExampleEntity(app.dogo.android.persistencedb.example.ExampleEntity).\n Expected:\n");
                stringBuilder.append(gVar);
                stringBuilder.append("\n Found:\n");
                stringBuilder.append(obj11);
                w0.b bVar = new w0.b(i4, stringBuilder.toString());
                return bVar;
            }
            obj11 = new w0.b(1, 0);
            return obj11;
        }
    }
    static List E(app.dogo.android.persistencedb.example.ExampleDatabase_Impl exampleDatabase_Impl) {
        return exampleDatabase_Impl.g;
    }

    static List F(app.dogo.android.persistencedb.example.ExampleDatabase_Impl exampleDatabase_Impl) {
        return exampleDatabase_Impl.g;
    }

    static List G(app.dogo.android.persistencedb.example.ExampleDatabase_Impl exampleDatabase_Impl) {
        return exampleDatabase_Impl.g;
    }

    static List H(app.dogo.android.persistencedb.example.ExampleDatabase_Impl exampleDatabase_Impl) {
        return exampleDatabase_Impl.g;
    }

    static List I(app.dogo.android.persistencedb.example.ExampleDatabase_Impl exampleDatabase_Impl) {
        return exampleDatabase_Impl.g;
    }

    static List J(app.dogo.android.persistencedb.example.ExampleDatabase_Impl exampleDatabase_Impl) {
        return exampleDatabase_Impl.g;
    }

    static List K(app.dogo.android.persistencedb.example.ExampleDatabase_Impl exampleDatabase_Impl) {
        return exampleDatabase_Impl.g;
    }

    static g L(app.dogo.android.persistencedb.example.ExampleDatabase_Impl exampleDatabase_Impl, g g2) {
        exampleDatabase_Impl.a = g2;
        return g2;
    }

    static void M(app.dogo.android.persistencedb.example.ExampleDatabase_Impl exampleDatabase_Impl, g g2) {
        exampleDatabase_Impl.t(g2);
    }

    static List N(app.dogo.android.persistencedb.example.ExampleDatabase_Impl exampleDatabase_Impl) {
        return exampleDatabase_Impl.g;
    }

    static List O(app.dogo.android.persistencedb.example.ExampleDatabase_Impl exampleDatabase_Impl) {
        return exampleDatabase_Impl.g;
    }

    @Override // app.dogo.android.persistencedb.example.ExampleDatabase
    protected m0 e() {
        int i = 0;
        HashMap hashMap = new HashMap(i);
        HashMap hashMap2 = new HashMap(i);
        m0 m0Var = new m0(this, hashMap, hashMap2, /* result */);
        return m0Var;
    }

    @Override // app.dogo.android.persistencedb.example.ExampleDatabase
    protected h f(e0 e0) {
        ExampleDatabase_Impl.a aVar = new ExampleDatabase_Impl.a(this, 3);
        w0 w0Var = new w0(e0, aVar, "450612a4f3a2d29e744c6987e2cc2bc9", "c85c3581a5f7aefffc997ebb917d0119");
        h.b.a aVar2 = h.b.a(e0.b);
        aVar2.c(e0.c);
        aVar2.b(w0Var);
        return e0.a.a(aVar2.a());
    }

    public List<b> h(Map<Class<? extends a>, a> map) {
        return Arrays.asList(new b[0]);
    }

    public Set<Class<? extends a>> m() {
        HashSet hashSet = new HashSet();
        return hashSet;
    }

    protected Map<Class<?>, List<Class<?>>> n() {
        HashMap hashMap = new HashMap();
        hashMap.put(a.class, b.a());
        return hashMap;
    }
}
