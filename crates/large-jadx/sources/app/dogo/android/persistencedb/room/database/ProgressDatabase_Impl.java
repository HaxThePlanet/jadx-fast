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
import e.a.a.a.b.b.o0;
import e.a.a.a.b.b.p0;
import e.a.a.a.b.b.s0;
import e.a.a.a.b.b.t0;
import e.a.a.a.b.b.y;
import e.a.a.a.b.b.z;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class ProgressDatabase_Impl extends app.dogo.android.persistencedb.room.database.ProgressDatabase {

    private volatile o0 w;
    private volatile y x;
    private volatile s0 y;

    class a extends w0.a {

        final app.dogo.android.persistencedb.room.database.ProgressDatabase_Impl b;
        a(app.dogo.android.persistencedb.room.database.ProgressDatabase_Impl progressDatabase_Impl, int i2) {
            this.b = progressDatabase_Impl;
            super(i2);
        }

        @Override // androidx.room.w0$a
        public void a(g g) {
            g.C("CREATE TABLE IF NOT EXISTS `TrickProgressEntity` (`trickId` TEXT NOT NULL, `dogId` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `lastViewedAt` INTEGER, `lastRatedAt` INTEGER, `knowledge` INTEGER NOT NULL, PRIMARY KEY(`trickId`, `dogId`))");
            g.C("CREATE TABLE IF NOT EXISTS `RecommendedListOrderEntity` (`dogId` TEXT NOT NULL, `recommendedProgramIds` TEXT NOT NULL, PRIMARY KEY(`dogId`))");
            g.C("CREATE TABLE IF NOT EXISTS `WorkoutInfoEntity` (`dogId` TEXT NOT NULL, `cachedWorkoutTrickIdList` TEXT NOT NULL, PRIMARY KEY(`dogId`))");
            g.C("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            g.C("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '0d4418d3580cebc41325bbee4a4f7102')");
        }

        @Override // androidx.room.w0$a
        public void b(g g) {
            int list;
            int size;
            Object obj;
            g.C("DROP TABLE IF EXISTS `TrickProgressEntity`");
            g.C("DROP TABLE IF EXISTS `RecommendedListOrderEntity`");
            g.C("DROP TABLE IF EXISTS `WorkoutInfoEntity`");
            if (ProgressDatabase_Impl.L(this.b) != null) {
                list = 0;
                while (list < ProgressDatabase_Impl.M(this.b).size()) {
                    (u0.b)ProgressDatabase_Impl.O(this.b).get(list).b(g);
                    list++;
                }
            }
        }

        @Override // androidx.room.w0$a
        protected void c(g g) {
            int list;
            int size;
            Object obj;
            if (ProgressDatabase_Impl.P(this.b) != null) {
                list = 0;
                while (list < ProgressDatabase_Impl.Q(this.b).size()) {
                    (u0.b)ProgressDatabase_Impl.R(this.b).get(list).a(g);
                    list++;
                }
            }
        }

        @Override // androidx.room.w0$a
        public void d(g g) {
            int list;
            int size;
            Object obj;
            ProgressDatabase_Impl.S(this.b, g);
            ProgressDatabase_Impl.T(this.b, g);
            if (ProgressDatabase_Impl.U(this.b) != null) {
                list = 0;
                while (list < ProgressDatabase_Impl.V(this.b).size()) {
                    (u0.b)ProgressDatabase_Impl.N(this.b).get(list).c(g);
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
            g gVar = g;
            HashMap hashMap = new HashMap(6);
            int i7 = 1;
            super("trickId", "TEXT", 1, i7, 0, 1);
            hashMap.put("trickId", aVar);
            int i13 = 0;
            int i17 = 1;
            super("dogId", "TEXT", i7, 2, i13, i17);
            String str2 = "dogId";
            hashMap.put(str2, aVar2);
            int i10 = 0;
            super("updatedAt", "INTEGER", i7, i10, i13, i17);
            hashMap.put("updatedAt", aVar3);
            int i14 = 0;
            int i18 = 0;
            int i21 = 1;
            super("lastViewedAt", "INTEGER", i10, i14, i18, i21);
            hashMap.put("lastViewedAt", aVar4);
            super("lastRatedAt", "INTEGER", i10, i14, i18, i21);
            hashMap.put("lastRatedAt", aVar5);
            super("knowledge", "INTEGER", 1, i14, i18, i21);
            hashMap.put("knowledge", aVar6);
            int i5 = 0;
            HashSet hashSet = new HashSet(i5);
            HashSet hashSet4 = new HashSet(i5);
            String str24 = "TrickProgressEntity";
            g gVar5 = new g(str24, hashMap, hashSet, hashSet4);
            g gVar3 = g.a(gVar, str24);
            String str15 = "\n Found:\n";
            if (!gVar5.equals(gVar3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("TrickProgressEntity(app.dogo.android.persistencedb.room.entity.TrickProgressEntity).\n Expected:\n");
                stringBuilder.append(gVar5);
                stringBuilder.append(str15);
                stringBuilder.append(gVar3);
                w0.b bVar = new w0.b(i5, stringBuilder.toString());
                return bVar;
            }
            int i3 = 2;
            HashMap hashMap2 = new HashMap(i3);
            super("dogId", "TEXT", 1, 1, 0, 1);
            hashMap2.put(str2, aVar18);
            super("recommendedProgramIds", "TEXT", 1, 0, 0, 1);
            hashMap2.put("recommendedProgramIds", aVar16);
            HashSet hashSet5 = new HashSet(i5);
            HashSet hashSet6 = new HashSet(i5);
            String str31 = "RecommendedListOrderEntity";
            g gVar7 = new g(str31, hashMap2, hashSet5, hashSet6);
            g gVar4 = g.a(gVar, str31);
            if (!gVar7.equals(gVar4)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("RecommendedListOrderEntity(app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity).\n Expected:\n");
                stringBuilder2.append(gVar7);
                stringBuilder2.append(str15);
                stringBuilder2.append(gVar4);
                w0.b bVar2 = new w0.b(i5, stringBuilder2.toString());
                return bVar2;
            }
            HashMap hashMap3 = new HashMap(i3);
            super("dogId", "TEXT", 1, 1, 0, 1);
            hashMap3.put(str2, aVar7);
            g.a aVar19 = new g.a("cachedWorkoutTrickIdList", "TEXT", 1, 0, 0, 1);
            hashMap3.put("cachedWorkoutTrickIdList", aVar8);
            HashSet hashSet2 = new HashSet(i5);
            HashSet hashSet3 = new HashSet(i5);
            String str28 = "WorkoutInfoEntity";
            g gVar6 = new g(str28, hashMap3, hashSet2, hashSet3);
            g gVar2 = g.a(gVar, str28);
            if (!gVar6.equals(gVar2)) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("WorkoutInfoEntity(app.dogo.android.persistencedb.room.entity.WorkoutInfoEntity).\n Expected:\n");
                stringBuilder3.append(gVar6);
                stringBuilder3.append(str15);
                stringBuilder3.append(gVar2);
                w0.b bVar4 = new w0.b(i5, stringBuilder3.toString());
                return bVar4;
            }
            w0.b bVar3 = new w0.b(1, 0);
            return bVar3;
        }
    }
    static List L(app.dogo.android.persistencedb.room.database.ProgressDatabase_Impl progressDatabase_Impl) {
        return progressDatabase_Impl.g;
    }

    static List M(app.dogo.android.persistencedb.room.database.ProgressDatabase_Impl progressDatabase_Impl) {
        return progressDatabase_Impl.g;
    }

    static List N(app.dogo.android.persistencedb.room.database.ProgressDatabase_Impl progressDatabase_Impl) {
        return progressDatabase_Impl.g;
    }

    static List O(app.dogo.android.persistencedb.room.database.ProgressDatabase_Impl progressDatabase_Impl) {
        return progressDatabase_Impl.g;
    }

    static List P(app.dogo.android.persistencedb.room.database.ProgressDatabase_Impl progressDatabase_Impl) {
        return progressDatabase_Impl.g;
    }

    static List Q(app.dogo.android.persistencedb.room.database.ProgressDatabase_Impl progressDatabase_Impl) {
        return progressDatabase_Impl.g;
    }

    static List R(app.dogo.android.persistencedb.room.database.ProgressDatabase_Impl progressDatabase_Impl) {
        return progressDatabase_Impl.g;
    }

    static g S(app.dogo.android.persistencedb.room.database.ProgressDatabase_Impl progressDatabase_Impl, g g2) {
        progressDatabase_Impl.a = g2;
        return g2;
    }

    static void T(app.dogo.android.persistencedb.room.database.ProgressDatabase_Impl progressDatabase_Impl, g g2) {
        progressDatabase_Impl.t(g2);
    }

    static List U(app.dogo.android.persistencedb.room.database.ProgressDatabase_Impl progressDatabase_Impl) {
        return progressDatabase_Impl.g;
    }

    static List V(app.dogo.android.persistencedb.room.database.ProgressDatabase_Impl progressDatabase_Impl) {
        return progressDatabase_Impl.g;
    }

    @Override // app.dogo.android.persistencedb.room.database.ProgressDatabase
    public y I() {
        y zVar;
        if (this.x != null) {
            return this.x;
        }
        synchronized (this) {
            zVar = new z(this);
            this.x = zVar;
            return this.x;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.ProgressDatabase
    public o0 J() {
        o0 p0Var;
        if (this.w != null) {
            return this.w;
        }
        synchronized (this) {
            p0Var = new p0(this);
            this.w = p0Var;
            return this.w;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.ProgressDatabase
    public s0 K() {
        s0 t0Var;
        if (this.y != null) {
            return this.y;
        }
        synchronized (this) {
            t0Var = new t0(this);
            this.y = t0Var;
            return this.y;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.ProgressDatabase
    protected m0 e() {
        int i = 0;
        HashMap hashMap = new HashMap(i);
        HashMap hashMap2 = new HashMap(i);
        m0 m0Var = new m0(this, hashMap, hashMap2, /* result */);
        return m0Var;
    }

    @Override // app.dogo.android.persistencedb.room.database.ProgressDatabase
    protected h f(e0 e0) {
        ProgressDatabase_Impl.a aVar = new ProgressDatabase_Impl.a(this, 7);
        w0 w0Var = new w0(e0, aVar, "0d4418d3580cebc41325bbee4a4f7102", "5fb6e0db48f49a491681621ddd0cc6ae");
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
        hashMap.put(o0.class, p0.o());
        hashMap.put(y.class, z.f());
        hashMap.put(s0.class, t0.m());
        return hashMap;
    }
}
