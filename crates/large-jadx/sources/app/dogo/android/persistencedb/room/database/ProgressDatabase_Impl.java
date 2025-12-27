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

/* compiled from: ProgressDatabase_Impl.java */
/* loaded from: classes.dex */
public final class ProgressDatabase_Impl extends ProgressDatabase {

    private volatile o0 w;
    private volatile y x;
    private volatile s0 y;

    class a extends w0.a {

        final /* synthetic */ ProgressDatabase_Impl b;
        a(int i) {
            this.b = progressDatabase_Impl;
            super(i);
        }

        @Override // androidx.room.w0$a
        public void a(d.s.a.g gVar) {
            gVar.C("CREATE TABLE IF NOT EXISTS `TrickProgressEntity` (`trickId` TEXT NOT NULL, `dogId` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, `lastViewedAt` INTEGER, `lastRatedAt` INTEGER, `knowledge` INTEGER NOT NULL, PRIMARY KEY(`trickId`, `dogId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `RecommendedListOrderEntity` (`dogId` TEXT NOT NULL, `recommendedProgramIds` TEXT NOT NULL, PRIMARY KEY(`dogId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `WorkoutInfoEntity` (`dogId` TEXT NOT NULL, `cachedWorkoutTrickIdList` TEXT NOT NULL, PRIMARY KEY(`dogId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            gVar.C("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '0d4418d3580cebc41325bbee4a4f7102')");
        }

        @Override // androidx.room.w0$a
        public void b(d.s.a.g gVar) {
            int i = 0;
            Object item;
            gVar.C("DROP TABLE IF EXISTS `TrickProgressEntity`");
            gVar.C("DROP TABLE IF EXISTS `RecommendedListOrderEntity`");
            gVar.C("DROP TABLE IF EXISTS `WorkoutInfoEntity`");
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
            d.s.a.g gVar2 = gVar;
            HashMap hashMap = new HashMap(6);
            int i7 = 1;
            g.a aVar = new g.a("trickId", "TEXT", true, i7, null, 1);
            hashMap.put("trickId", aVar);
            String str31 = null;
            int i16 = 1;
            g.a aVar2 = new g.a("dogId", "TEXT", i7, 2, str31, i16);
            String str2 = "dogId";
            hashMap.put(str2, aVar2);
            int i10 = 0;
            g.a aVar3 = new g.a("updatedAt", "INTEGER", i7, i10, str31, i16);
            hashMap.put("updatedAt", aVar3);
            int i13 = 0;
            String str33 = null;
            int i19 = 1;
            g.a aVar4 = new g.a("lastViewedAt", "INTEGER", i10, i13, str33, i19);
            hashMap.put("lastViewedAt", aVar4);
            g.a aVar5 = new g.a("lastRatedAt", "INTEGER", i10, i13, str33, i19);
            hashMap.put("lastRatedAt", aVar5);
            g.a aVar6 = new g.a("knowledge", "INTEGER", true, i13, str33, i19);
            hashMap.put("knowledge", aVar6);
            int i5 = 0;
            String str24 = "TrickProgressEntity";
            androidx.room.f1.g gVar6 = new g(str24, hashMap, new HashSet(i5), new HashSet(i5));
            androidx.room.f1.g gVar4 = g.a(gVar2, str24);
            String str15 = "\n Found:\n";
            if (!gVar6.equals(gVar4)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = "TrickProgressEntity(app.dogo.android.persistencedb.room.entity.TrickProgressEntity).\n Expected:\n";
                r1 = str3 + gVar6 + str15 + gVar4;
                return new w0.b(false, r1);
            }
            int i3 = 2;
            HashMap hashMap2 = new HashMap(i3);
            g.a aVar9 = new g.a("dogId", "TEXT", true, 1, null, 1);
            hashMap2.put(str2, aVar9);
            g.a aVar10 = new g.a("recommendedProgramIds", "TEXT", true, 0, null, 1);
            hashMap2.put("recommendedProgramIds", aVar10);
            String str32 = "RecommendedListOrderEntity";
            androidx.room.f1.g gVar8 = new g(str32, hashMap2, new HashSet(i5), new HashSet(i5));
            androidx.room.f1.g gVar5 = g.a(gVar2, str32);
            if (!gVar8.equals(gVar5)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str4 = "RecommendedListOrderEntity(app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity).\n Expected:\n";
                r1 = str4 + gVar8 + str15 + gVar5;
                return new w0.b(false, r1);
            }
            HashMap hashMap3 = new HashMap(i3);
            g.a aVar7 = new g.a("dogId", "TEXT", true, 1, null, 1);
            hashMap3.put(str2, aVar7);
            g.a aVar8 = new g.a("cachedWorkoutTrickIdList", "TEXT", true, 0, null, 1);
            hashMap3.put("cachedWorkoutTrickIdList", aVar8);
            String str28 = "WorkoutInfoEntity";
            androidx.room.f1.g gVar7 = new g(str28, hashMap3, new HashSet(i5), new HashSet(i5));
            androidx.room.f1.g gVar3 = g.a(gVar2, str28);
            if (!gVar7.equals(gVar3)) {
                StringBuilder stringBuilder3 = new StringBuilder();
                String str6 = "WorkoutInfoEntity(app.dogo.android.persistencedb.room.entity.WorkoutInfoEntity).\n Expected:\n";
                r0 = str6 + gVar7 + str15 + gVar3;
                return new w0.b(false, r0);
            }
            return new w0.b(true, null);
        }

        @Override // androidx.room.w0$a
        public void e(d.s.a.g gVar) {
        }
    }
    static /* synthetic */ List L(ProgressDatabase_Impl progressDatabase_Impl) {
        return progressDatabase_Impl.g;
    }

    static /* synthetic */ List M(ProgressDatabase_Impl progressDatabase_Impl) {
        return progressDatabase_Impl.g;
    }

    static /* synthetic */ List N(ProgressDatabase_Impl progressDatabase_Impl) {
        return progressDatabase_Impl.g;
    }

    static /* synthetic */ List O(ProgressDatabase_Impl progressDatabase_Impl) {
        return progressDatabase_Impl.g;
    }

    static /* synthetic */ List P(ProgressDatabase_Impl progressDatabase_Impl) {
        return progressDatabase_Impl.g;
    }

    static /* synthetic */ List Q(ProgressDatabase_Impl progressDatabase_Impl) {
        return progressDatabase_Impl.g;
    }

    static /* synthetic */ List R(ProgressDatabase_Impl progressDatabase_Impl) {
        return progressDatabase_Impl.g;
    }

    static /* synthetic */ d.s.a.g S(ProgressDatabase_Impl progressDatabase_Impl, d.s.a.g gVar) {
        progressDatabase_Impl.a = gVar;
        return gVar;
    }

    static /* synthetic */ void T(ProgressDatabase_Impl progressDatabase_Impl, d.s.a.g gVar) {
        progressDatabase_Impl.t(gVar);
    }

    static /* synthetic */ List U(ProgressDatabase_Impl progressDatabase_Impl) {
        return progressDatabase_Impl.g;
    }

    static /* synthetic */ List V(ProgressDatabase_Impl progressDatabase_Impl) {
        return progressDatabase_Impl.g;
    }

    @Override // app.dogo.android.persistencedb.room.database.ProgressDatabase
    public y I() {
        if (this.x != null) {
            return this.x;
        }
        synchronized (this) {
            try {
                if (this.x == null) {
                    this.x = new app.dogo.android.persistencedb.room.dao.z(this);
                }
                return this.x;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.ProgressDatabase
    public o0 J() {
        if (this.w != null) {
            return this.w;
        }
        synchronized (this) {
            try {
                if (this.w == null) {
                    this.w = new app.dogo.android.persistencedb.room.dao.p0(this);
                }
                return this.w;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.ProgressDatabase
    public s0 K() {
        if (this.y != null) {
            return this.y;
        }
        synchronized (this) {
            try {
                if (this.y == null) {
                    this.y = new app.dogo.android.persistencedb.room.dao.t0(this);
                }
                return this.y;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.ProgressDatabase
    protected m0 e() {
        int i = 0;
        return new m0(this, new HashMap(i), new HashMap(i), new String[] { "TrickProgressEntity", "RecommendedListOrderEntity", "WorkoutInfoEntity" });
    }

    @Override // app.dogo.android.persistencedb.room.database.ProgressDatabase
    protected h f(e0 e0Var) {
        h.b.a aVar2 = h.b.a(e0Var.b);
        aVar2.c(e0Var.c);
        aVar2.b(new w0(e0Var, new ProgressDatabase_Impl.a(this, 7), "0d4418d3580cebc41325bbee4a4f7102", "5fb6e0db48f49a491681621ddd0cc6ae"));
        return e0Var.a.a(aVar2.a());
    }

    @Override // app.dogo.android.persistencedb.room.database.ProgressDatabase
    public List<b> h(Map<Class<? extends a>, a> map) {
        return Arrays.asList(new b[0]);
    }

    @Override // app.dogo.android.persistencedb.room.database.ProgressDatabase
    public Set<Class<? extends a>> m() {
        return new HashSet();
    }

    @Override // app.dogo.android.persistencedb.room.database.ProgressDatabase
    protected Map<Class<?>, List<Class<?>>> n() {
        final HashMap hashMap = new HashMap();
        hashMap.put(TrickKnowledgeDao.class, app.dogo.android.persistencedb.room.dao.p0.o());
        hashMap.put(DogRecommendedProgramOrderDao.class, app.dogo.android.persistencedb.room.dao.z.f());
        hashMap.put(WorkoutEntityDao.class, app.dogo.android.persistencedb.room.dao.t0.m());
        return hashMap;
    }
}
