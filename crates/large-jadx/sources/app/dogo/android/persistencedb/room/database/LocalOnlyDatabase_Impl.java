package app.dogo.android.persistencedb.room.database;

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
import e.a.a.a.b.b.w;
import e.a.a.a.b.b.x;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class LocalOnlyDatabase_Impl extends app.dogo.android.persistencedb.room.database.LocalOnlyDatabase {

    private volatile w s;

    class a extends w0.a {

        final app.dogo.android.persistencedb.room.database.LocalOnlyDatabase_Impl b;
        a(app.dogo.android.persistencedb.room.database.LocalOnlyDatabase_Impl localOnlyDatabase_Impl, int i2) {
            this.b = localOnlyDatabase_Impl;
            super(i2);
        }

        @Override // androidx.room.w0$a
        public void a(g g) {
            g.C("CREATE TABLE IF NOT EXISTS `DogLocalEntity` (`dogId` TEXT NOT NULL, `workoutUnlocked` INTEGER NOT NULL, `workoutUnlockSource` TEXT NOT NULL, `workoutUnlockScreenShown` INTEGER NOT NULL, `longestStreak` INTEGER NOT NULL, `currentStreak` INTEGER NOT NULL, `lastAchievedStreakTimestampMs` INTEGER NOT NULL, PRIMARY KEY(`dogId`))");
            g.C("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            g.C("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f220914cd72ea108857429d214aa0450')");
        }

        @Override // androidx.room.w0$a
        public void b(g g) {
            int list;
            int size;
            Object obj;
            g.C("DROP TABLE IF EXISTS `DogLocalEntity`");
            if (LocalOnlyDatabase_Impl.J(this.b) != null) {
                list = 0;
                while (list < LocalOnlyDatabase_Impl.K(this.b).size()) {
                    (u0.b)LocalOnlyDatabase_Impl.M(this.b).get(list).b(g);
                    list++;
                }
            }
        }

        @Override // androidx.room.w0$a
        protected void c(g g) {
            int list;
            int size;
            Object obj;
            if (LocalOnlyDatabase_Impl.N(this.b) != null) {
                list = 0;
                while (list < LocalOnlyDatabase_Impl.O(this.b).size()) {
                    (u0.b)LocalOnlyDatabase_Impl.P(this.b).get(list).a(g);
                    list++;
                }
            }
        }

        @Override // androidx.room.w0$a
        public void d(g g) {
            int list;
            int size;
            Object obj;
            LocalOnlyDatabase_Impl.Q(this.b, g);
            LocalOnlyDatabase_Impl.R(this.b, g);
            if (LocalOnlyDatabase_Impl.S(this.b) != null) {
                list = 0;
                while (list < LocalOnlyDatabase_Impl.T(this.b).size()) {
                    (u0.b)LocalOnlyDatabase_Impl.L(this.b).get(list).c(g);
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
            HashMap hashMap = new HashMap(7);
            final int i6 = 1;
            super("dogId", "TEXT", 1, i6, 0, 1);
            hashMap.put("dogId", aVar);
            int i8 = 0;
            int i10 = 0;
            final int i11 = 1;
            super("workoutUnlocked", "INTEGER", i6, i8, i10, i11);
            hashMap.put("workoutUnlocked", aVar2);
            super("workoutUnlockSource", "TEXT", i6, i8, i10, i11);
            hashMap.put("workoutUnlockSource", aVar3);
            super("workoutUnlockScreenShown", "INTEGER", i6, i8, i10, i11);
            hashMap.put("workoutUnlockScreenShown", aVar4);
            super("longestStreak", "INTEGER", i6, i8, i10, i11);
            hashMap.put("longestStreak", aVar5);
            super("currentStreak", "INTEGER", i6, i8, i10, i11);
            hashMap.put("currentStreak", aVar6);
            super("lastAchievedStreakTimestampMs", "INTEGER", i6, i8, i10, i11);
            hashMap.put("lastAchievedStreakTimestampMs", aVar7);
            int i4 = 0;
            HashSet hashSet = new HashSet(i4);
            HashSet hashSet2 = new HashSet(i4);
            String str24 = "DogLocalEntity";
            g gVar = new g(str24, hashMap, hashSet, hashSet2);
            g obj11 = g.a(g, str24);
            if (!gVar.equals(obj11)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("DogLocalEntity(app.dogo.android.persistencedb.room.entity.DogLocalEntity).\n Expected:\n");
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
    static List J(app.dogo.android.persistencedb.room.database.LocalOnlyDatabase_Impl localOnlyDatabase_Impl) {
        return localOnlyDatabase_Impl.g;
    }

    static List K(app.dogo.android.persistencedb.room.database.LocalOnlyDatabase_Impl localOnlyDatabase_Impl) {
        return localOnlyDatabase_Impl.g;
    }

    static List L(app.dogo.android.persistencedb.room.database.LocalOnlyDatabase_Impl localOnlyDatabase_Impl) {
        return localOnlyDatabase_Impl.g;
    }

    static List M(app.dogo.android.persistencedb.room.database.LocalOnlyDatabase_Impl localOnlyDatabase_Impl) {
        return localOnlyDatabase_Impl.g;
    }

    static List N(app.dogo.android.persistencedb.room.database.LocalOnlyDatabase_Impl localOnlyDatabase_Impl) {
        return localOnlyDatabase_Impl.g;
    }

    static List O(app.dogo.android.persistencedb.room.database.LocalOnlyDatabase_Impl localOnlyDatabase_Impl) {
        return localOnlyDatabase_Impl.g;
    }

    static List P(app.dogo.android.persistencedb.room.database.LocalOnlyDatabase_Impl localOnlyDatabase_Impl) {
        return localOnlyDatabase_Impl.g;
    }

    static g Q(app.dogo.android.persistencedb.room.database.LocalOnlyDatabase_Impl localOnlyDatabase_Impl, g g2) {
        localOnlyDatabase_Impl.a = g2;
        return g2;
    }

    static void R(app.dogo.android.persistencedb.room.database.LocalOnlyDatabase_Impl localOnlyDatabase_Impl, g g2) {
        localOnlyDatabase_Impl.t(g2);
    }

    static List S(app.dogo.android.persistencedb.room.database.LocalOnlyDatabase_Impl localOnlyDatabase_Impl) {
        return localOnlyDatabase_Impl.g;
    }

    static List T(app.dogo.android.persistencedb.room.database.LocalOnlyDatabase_Impl localOnlyDatabase_Impl) {
        return localOnlyDatabase_Impl.g;
    }

    @Override // app.dogo.android.persistencedb.room.database.LocalOnlyDatabase
    public w I() {
        w xVar;
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            xVar = new x(this);
            this.s = xVar;
            return this.s;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.LocalOnlyDatabase
    protected m0 e() {
        int i = 0;
        HashMap hashMap = new HashMap(i);
        HashMap hashMap2 = new HashMap(i);
        m0 m0Var = new m0(this, hashMap, hashMap2, /* result */);
        return m0Var;
    }

    @Override // app.dogo.android.persistencedb.room.database.LocalOnlyDatabase
    protected h f(e0 e0) {
        LocalOnlyDatabase_Impl.a aVar = new LocalOnlyDatabase_Impl.a(this, 2);
        w0 w0Var = new w0(e0, aVar, "f220914cd72ea108857429d214aa0450", "92218fa18a570cb67f2c0344564eac52");
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
        hashMap.put(w.class, x.r());
        return hashMap;
    }
}
