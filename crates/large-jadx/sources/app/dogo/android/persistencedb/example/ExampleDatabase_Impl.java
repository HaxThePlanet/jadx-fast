package app.dogo.android.persistencedb.example;

import androidx.room.e0;
import androidx.room.e1.a;
import androidx.room.e1.b;
import androidx.room.f1.c;
import androidx.room.f1.g.a;
import androidx.room.m0;
import androidx.room.u0;
import androidx.room.u0.b;
import androidx.room.w0;
import androidx.room.w0.a;
import androidx.room.w0.b;
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

/* compiled from: ExampleDatabase_Impl.java */
/* loaded from: classes.dex */
public final class ExampleDatabase_Impl extends ExampleDatabase {

    class a extends w0.a {

        final /* synthetic */ ExampleDatabase_Impl b;
        a(int i) {
            this.b = exampleDatabase_Impl;
            super(i);
        }

        @Override // androidx.room.w0$a
        public void a(d.s.a.g gVar) {
            gVar.C("CREATE TABLE IF NOT EXISTS `ExampleEntity` (`id` TEXT NOT NULL, `goodField` TEXT NOT NULL, PRIMARY KEY(`id`))");
            gVar.C("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            gVar.C("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '450612a4f3a2d29e744c6987e2cc2bc9')");
        }

        @Override // androidx.room.w0$a
        public void b(d.s.a.g gVar) {
            int i = 0;
            Object item;
            gVar.C("DROP TABLE IF EXISTS `ExampleEntity`");
            if (this.b.g != null) {
                i = 0;
                while (this.b.g < this.b.g.size()) {
                    (u0.b)this.b.g.get(i).b(gVar);
                    i = i + 1;
                }
            }
        }

        @Override // androidx.room.w0$a
        protected void c(d.s.a.g gVar) {
            int i = 0;
            Object item;
            if (this.b.g != null) {
                i = 0;
                while (this.b.g < this.b.g.size()) {
                    (u0.b)this.b.g.get(i).a(gVar);
                    i = i + 1;
                }
            }
        }

        @Override // androidx.room.w0$a
        public void d(d.s.a.g gVar) {
            int i = 0;
            Object item;
            this.b.a = gVar;
            this.b.t(gVar);
            if (this.b.g != null) {
                i = 0;
                while (this.b < this.b.g.size()) {
                    (u0.b)this.b.g.get(i).c(gVar);
                    i = i + 1;
                }
            }
        }

        @Override // androidx.room.w0$a
        public void f(d.s.a.g gVar) {
            c.b(gVar);
        }

        @Override // androidx.room.w0$a
        protected w0.b g(d.s.a.g gVar) {
            HashMap hashMap = new HashMap(2);
            final int i6 = 1;
            g.a aVar = new g.a("id", "TEXT", true, i6, null, 1);
            hashMap.put("id", aVar);
            g.a aVar2 = new g.a("goodField", "TEXT", i6, 0, null, 1);
            hashMap.put("goodField", aVar2);
            int i4 = 0;
            String str9 = "ExampleEntity";
            androidx.room.f1.g gVar2 = new g(str9, hashMap, new HashSet(i4), new HashSet(i4));
            androidx.room.f1.g gVar3 = g.a(gVar, str9);
            if (!gVar2.equals(gVar3)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str4 = "ExampleEntity(app.dogo.android.persistencedb.example.ExampleEntity).\n Expected:\n";
                String str5 = "\n Found:\n";
                gVar = str4 + gVar2 + str5 + gVar3;
                return new w0.b(false, gVar);
            }
            return new w0.b(true, null);
        }

        @Override // androidx.room.w0$a
        public void e(d.s.a.g gVar) {
        }
    }
    static /* synthetic */ List E(ExampleDatabase_Impl exampleDatabase_Impl) {
        return exampleDatabase_Impl.g;
    }

    static /* synthetic */ List F(ExampleDatabase_Impl exampleDatabase_Impl) {
        return exampleDatabase_Impl.g;
    }

    static /* synthetic */ List G(ExampleDatabase_Impl exampleDatabase_Impl) {
        return exampleDatabase_Impl.g;
    }

    static /* synthetic */ List H(ExampleDatabase_Impl exampleDatabase_Impl) {
        return exampleDatabase_Impl.g;
    }

    static /* synthetic */ List I(ExampleDatabase_Impl exampleDatabase_Impl) {
        return exampleDatabase_Impl.g;
    }

    static /* synthetic */ List J(ExampleDatabase_Impl exampleDatabase_Impl) {
        return exampleDatabase_Impl.g;
    }

    static /* synthetic */ List K(ExampleDatabase_Impl exampleDatabase_Impl) {
        return exampleDatabase_Impl.g;
    }

    static /* synthetic */ d.s.a.g L(ExampleDatabase_Impl exampleDatabase_Impl, d.s.a.g gVar) {
        exampleDatabase_Impl.a = gVar;
        return gVar;
    }

    static /* synthetic */ void M(ExampleDatabase_Impl exampleDatabase_Impl, d.s.a.g gVar) {
        exampleDatabase_Impl.t(gVar);
    }

    static /* synthetic */ List N(ExampleDatabase_Impl exampleDatabase_Impl) {
        return exampleDatabase_Impl.g;
    }

    static /* synthetic */ List O(ExampleDatabase_Impl exampleDatabase_Impl) {
        return exampleDatabase_Impl.g;
    }

    @Override // app.dogo.android.persistencedb.example.ExampleDatabase
    protected m0 e() {
        int i = 0;
        return new m0(this, new HashMap(i), new HashMap(i), new String[] { "ExampleEntity" });
    }

    @Override // app.dogo.android.persistencedb.example.ExampleDatabase
    protected h f(e0 e0Var) {
        h.b.a aVar2 = h.b.a(e0Var.b);
        aVar2.c(e0Var.c);
        aVar2.b(new w0(e0Var, new ExampleDatabase_Impl.a(this, 3), "450612a4f3a2d29e744c6987e2cc2bc9", "c85c3581a5f7aefffc997ebb917d0119"));
        return e0Var.a.a(aVar2.a());
    }

    @Override // app.dogo.android.persistencedb.example.ExampleDatabase
    public List<b> h(Map<Class<? extends a>, a> map) {
        return Arrays.asList(new b[0]);
    }

    @Override // app.dogo.android.persistencedb.example.ExampleDatabase
    public Set<Class<? extends a>> m() {
        return new HashSet();
    }

    @Override // app.dogo.android.persistencedb.example.ExampleDatabase
    protected Map<Class<?>, List<Class<?>>> n() {
        final HashMap hashMap = new HashMap();
        hashMap.put(ExampleDao.class, b.a());
        return hashMap;
    }
}
