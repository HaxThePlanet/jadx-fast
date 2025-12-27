package app.dogo.android.persistencedb.room.database;

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
import e.a.a.a.b.b.w;
import e.a.a.a.b.b.x;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: LocalOnlyDatabase_Impl.java */
/* loaded from: classes.dex */
public final class LocalOnlyDatabase_Impl extends LocalOnlyDatabase {

    private volatile w s;

    class a extends w0.a {

        final /* synthetic */ LocalOnlyDatabase_Impl b;
        a(int i) {
            this.b = localOnlyDatabase_Impl;
            super(i);
        }

        @Override // androidx.room.w0$a
        public void a(d.s.a.g gVar) {
            gVar.C("CREATE TABLE IF NOT EXISTS `DogLocalEntity` (`dogId` TEXT NOT NULL, `workoutUnlocked` INTEGER NOT NULL, `workoutUnlockSource` TEXT NOT NULL, `workoutUnlockScreenShown` INTEGER NOT NULL, `longestStreak` INTEGER NOT NULL, `currentStreak` INTEGER NOT NULL, `lastAchievedStreakTimestampMs` INTEGER NOT NULL, PRIMARY KEY(`dogId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            gVar.C("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f220914cd72ea108857429d214aa0450')");
        }

        @Override // androidx.room.w0$a
        public void b(d.s.a.g gVar) {
            int i = 0;
            Object item;
            gVar.C("DROP TABLE IF EXISTS `DogLocalEntity`");
            if (this.b.g != null) {
                i = 0;
                while (this.b < this.b.g.size()) {
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
                while (this.b < this.b.g.size()) {
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
                while (this.b.g < this.b.g.size()) {
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
            HashMap hashMap = new HashMap(7);
            final int i6 = 1;
            g.a aVar = new g.a("dogId", "TEXT", true, i6, null, 1);
            hashMap.put("dogId", aVar);
            int i8 = 0;
            String str25 = null;
            final int i10 = 1;
            g.a aVar2 = new g.a("workoutUnlocked", "INTEGER", i6, i8, str25, i10);
            hashMap.put("workoutUnlocked", aVar2);
            g.a aVar3 = new g.a("workoutUnlockSource", "TEXT", i6, i8, str25, i10);
            hashMap.put("workoutUnlockSource", aVar3);
            g.a aVar4 = new g.a("workoutUnlockScreenShown", "INTEGER", i6, i8, str25, i10);
            hashMap.put("workoutUnlockScreenShown", aVar4);
            g.a aVar5 = new g.a("longestStreak", "INTEGER", i6, i8, str25, i10);
            hashMap.put("longestStreak", aVar5);
            g.a aVar6 = new g.a("currentStreak", "INTEGER", i6, i8, str25, i10);
            hashMap.put("currentStreak", aVar6);
            g.a aVar7 = new g.a("lastAchievedStreakTimestampMs", "INTEGER", i6, i8, str25, i10);
            hashMap.put("lastAchievedStreakTimestampMs", aVar7);
            int i4 = 0;
            String str24 = "DogLocalEntity";
            androidx.room.f1.g gVar2 = new g(str24, hashMap, new HashSet(i4), new HashSet(i4));
            androidx.room.f1.g gVar3 = g.a(gVar, str24);
            if (!gVar2.equals(gVar3)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str9 = "DogLocalEntity(app.dogo.android.persistencedb.room.entity.DogLocalEntity).\n Expected:\n";
                String str10 = "\n Found:\n";
                gVar = str9 + gVar2 + str10 + gVar3;
                return new w0.b(false, gVar);
            }
            return new w0.b(true, null);
        }

        @Override // androidx.room.w0$a
        public void e(d.s.a.g gVar) {
        }
    }
    static /* synthetic */ List J(LocalOnlyDatabase_Impl localOnlyDatabase_Impl) {
        return localOnlyDatabase_Impl.g;
    }

    static /* synthetic */ List K(LocalOnlyDatabase_Impl localOnlyDatabase_Impl) {
        return localOnlyDatabase_Impl.g;
    }

    static /* synthetic */ List L(LocalOnlyDatabase_Impl localOnlyDatabase_Impl) {
        return localOnlyDatabase_Impl.g;
    }

    static /* synthetic */ List M(LocalOnlyDatabase_Impl localOnlyDatabase_Impl) {
        return localOnlyDatabase_Impl.g;
    }

    static /* synthetic */ List N(LocalOnlyDatabase_Impl localOnlyDatabase_Impl) {
        return localOnlyDatabase_Impl.g;
    }

    static /* synthetic */ List O(LocalOnlyDatabase_Impl localOnlyDatabase_Impl) {
        return localOnlyDatabase_Impl.g;
    }

    static /* synthetic */ List P(LocalOnlyDatabase_Impl localOnlyDatabase_Impl) {
        return localOnlyDatabase_Impl.g;
    }

    static /* synthetic */ d.s.a.g Q(LocalOnlyDatabase_Impl localOnlyDatabase_Impl, d.s.a.g gVar) {
        localOnlyDatabase_Impl.a = gVar;
        return gVar;
    }

    static /* synthetic */ void R(LocalOnlyDatabase_Impl localOnlyDatabase_Impl, d.s.a.g gVar) {
        localOnlyDatabase_Impl.t(gVar);
    }

    static /* synthetic */ List S(LocalOnlyDatabase_Impl localOnlyDatabase_Impl) {
        return localOnlyDatabase_Impl.g;
    }

    static /* synthetic */ List T(LocalOnlyDatabase_Impl localOnlyDatabase_Impl) {
        return localOnlyDatabase_Impl.g;
    }

    @Override // app.dogo.android.persistencedb.room.database.LocalOnlyDatabase
    public w I() {
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            try {
                if (this.s == null) {
                    this.s = new app.dogo.android.persistencedb.room.dao.x(this);
                }
                return this.s;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.LocalOnlyDatabase
    protected m0 e() {
        int i = 0;
        return new m0(this, new HashMap(i), new HashMap(i), new String[] { "DogLocalEntity" });
    }

    @Override // app.dogo.android.persistencedb.room.database.LocalOnlyDatabase
    protected h f(e0 e0Var) {
        h.b.a aVar2 = h.b.a(e0Var.b);
        aVar2.c(e0Var.c);
        aVar2.b(new w0(e0Var, new LocalOnlyDatabase_Impl.a(this, 2), "f220914cd72ea108857429d214aa0450", "92218fa18a570cb67f2c0344564eac52"));
        return e0Var.a.a(aVar2.a());
    }

    @Override // app.dogo.android.persistencedb.room.database.LocalOnlyDatabase
    public List<b> h(Map<Class<? extends a>, a> map) {
        return Arrays.asList(new b[0]);
    }

    @Override // app.dogo.android.persistencedb.room.database.LocalOnlyDatabase
    public Set<Class<? extends a>> m() {
        return new HashSet();
    }

    @Override // app.dogo.android.persistencedb.room.database.LocalOnlyDatabase
    protected Map<Class<?>, List<Class<?>>> n() {
        final HashMap hashMap = new HashMap();
        hashMap.put(DogLocalEntityDao.class, app.dogo.android.persistencedb.room.dao.x.r());
        return hashMap;
    }
}
