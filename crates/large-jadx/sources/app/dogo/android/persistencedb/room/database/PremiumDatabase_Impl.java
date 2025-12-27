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
import e.a.a.a.b.b.a0;
import e.a.a.a.b.b.b0;
import e.a.a.a.b.b.s;
import e.a.a.a.b.b.t;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: PremiumDatabase_Impl.java */
/* loaded from: classes.dex */
public final class PremiumDatabase_Impl extends PremiumDatabase {

    private volatile a0 s;
    private volatile s t;

    class a extends w0.a {

        final /* synthetic */ PremiumDatabase_Impl b;
        a(int i) {
            this.b = premiumDatabase_Impl;
            super(i);
        }

        @Override // androidx.room.w0$a
        public void a(d.s.a.g gVar) {
            gVar.C("CREATE TABLE IF NOT EXISTS `DogoPremiumStatusEntity` (`id` TEXT NOT NULL, `ownerType` TEXT NOT NULL, `expirationTimeMs` INTEGER NOT NULL, `expirationDate` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`ownerType`, `id`))");
            gVar.C("CREATE TABLE IF NOT EXISTS `CouponEntity` (`couponId` TEXT NOT NULL, `discount` INTEGER NOT NULL, `offeringId` TEXT NOT NULL, `offerDurationMs` INTEGER NOT NULL, `activationTimeMs` INTEGER NOT NULL, `style` TEXT NOT NULL, `offerText` TEXT, `discountText` TEXT, `welcomeOffer` INTEGER NOT NULL, PRIMARY KEY(`couponId`))");
            gVar.C("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            gVar.C("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ffff96aacb46f446344941442054b220')");
        }

        @Override // androidx.room.w0$a
        public void b(d.s.a.g gVar) {
            int i = 0;
            Object item;
            gVar.C("DROP TABLE IF EXISTS `DogoPremiumStatusEntity`");
            gVar.C("DROP TABLE IF EXISTS `CouponEntity`");
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
            HashMap hashMap = new HashMap(5);
            g.a aVar = new g.a("id", "TEXT", true, 2, null, 1);
            hashMap.put("id", aVar);
            boolean z = true;
            String str48 = null;
            int i15 = 1;
            g.a aVar2 = new g.a("ownerType", "TEXT", z, 1, str48, i15);
            hashMap.put("ownerType", aVar2);
            int i10 = 0;
            g.a aVar3 = new g.a("expirationTimeMs", "INTEGER", z, i10, str48, i15);
            hashMap.put("expirationTimeMs", aVar3);
            g.a aVar4 = new g.a("expirationDate", "TEXT", z, i10, str48, i15);
            hashMap.put("expirationDate", aVar4);
            g.a aVar5 = new g.a("updatedAt", "INTEGER", z, i10, str48, i15);
            hashMap.put("updatedAt", aVar5);
            int i5 = 0;
            String str27 = "DogoPremiumStatusEntity";
            androidx.room.f1.g gVar3 = new g(str27, hashMap, new HashSet(i5), new HashSet(i5));
            androidx.room.f1.g gVar2 = g.a(gVar, str27);
            String str7 = "\n Found:\n";
            if (!gVar3.equals(gVar2)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str28 = "DogoPremiumStatusEntity(app.dogo.android.persistencedb.room.entity.DogoPremiumStatusEntity).\n Expected:\n";
                r0 = str28 + gVar3 + str7 + gVar2;
                return new w0.b(false, r0);
            }
            HashMap hashMap2 = new HashMap(9);
            int i13 = 1;
            g.a aVar6 = new g.a("couponId", "TEXT", true, i13, null, 1);
            hashMap2.put("couponId", aVar6);
            int i17 = 0;
            String str49 = null;
            final int i19 = 1;
            g.a aVar7 = new g.a("discount", "INTEGER", i13, i17, str49, i19);
            hashMap2.put("discount", aVar7);
            g.a aVar8 = new g.a("offeringId", "TEXT", i13, i17, str49, i19);
            hashMap2.put("offeringId", aVar8);
            g.a aVar9 = new g.a("offerDurationMs", "INTEGER", i13, i17, str49, i19);
            hashMap2.put("offerDurationMs", aVar9);
            g.a aVar10 = new g.a("activationTimeMs", "INTEGER", i13, i17, str49, i19);
            hashMap2.put("activationTimeMs", aVar10);
            g.a aVar11 = new g.a("style", "TEXT", i13, i17, str49, i19);
            hashMap2.put("style", aVar11);
            boolean z2 = false;
            g.a aVar12 = new g.a("offerText", "TEXT", z2, i17, str49, i19);
            hashMap2.put("offerText", aVar12);
            g.a aVar13 = new g.a("discountText", "TEXT", z2, i17, str49, i19);
            hashMap2.put("discountText", aVar13);
            g.a aVar14 = new g.a("welcomeOffer", "INTEGER", true, i17, str49, i19);
            hashMap2.put("welcomeOffer", aVar14);
            String str39 = "CouponEntity";
            androidx.room.f1.g gVar4 = new g(str39, hashMap2, new HashSet(i5), new HashSet(i5));
            androidx.room.f1.g gVar5 = g.a(gVar, str39);
            if (!gVar4.equals(gVar5)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str22 = "CouponEntity(app.dogo.android.persistencedb.room.entity.CouponEntity).\n Expected:\n";
                gVar = str22 + gVar4 + str7 + gVar5;
                return new w0.b(false, gVar);
            }
            return new w0.b(true, null);
        }

        @Override // androidx.room.w0$a
        public void e(d.s.a.g gVar) {
        }
    }
    static /* synthetic */ List L(PremiumDatabase_Impl premiumDatabase_Impl) {
        return premiumDatabase_Impl.g;
    }

    static /* synthetic */ List M(PremiumDatabase_Impl premiumDatabase_Impl) {
        return premiumDatabase_Impl.g;
    }

    static /* synthetic */ List N(PremiumDatabase_Impl premiumDatabase_Impl) {
        return premiumDatabase_Impl.g;
    }

    static /* synthetic */ List O(PremiumDatabase_Impl premiumDatabase_Impl) {
        return premiumDatabase_Impl.g;
    }

    static /* synthetic */ List P(PremiumDatabase_Impl premiumDatabase_Impl) {
        return premiumDatabase_Impl.g;
    }

    static /* synthetic */ List Q(PremiumDatabase_Impl premiumDatabase_Impl) {
        return premiumDatabase_Impl.g;
    }

    static /* synthetic */ List R(PremiumDatabase_Impl premiumDatabase_Impl) {
        return premiumDatabase_Impl.g;
    }

    static /* synthetic */ d.s.a.g S(PremiumDatabase_Impl premiumDatabase_Impl, d.s.a.g gVar) {
        premiumDatabase_Impl.a = gVar;
        return gVar;
    }

    static /* synthetic */ void T(PremiumDatabase_Impl premiumDatabase_Impl, d.s.a.g gVar) {
        premiumDatabase_Impl.t(gVar);
    }

    static /* synthetic */ List U(PremiumDatabase_Impl premiumDatabase_Impl) {
        return premiumDatabase_Impl.g;
    }

    static /* synthetic */ List V(PremiumDatabase_Impl premiumDatabase_Impl) {
        return premiumDatabase_Impl.g;
    }

    @Override // app.dogo.android.persistencedb.room.database.PremiumDatabase
    public s J() {
        if (this.t != null) {
            return this.t;
        }
        synchronized (this) {
            try {
                if (this.t == null) {
                    this.t = new app.dogo.android.persistencedb.room.dao.t(this);
                }
                return this.t;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.PremiumDatabase
    public a0 K() {
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            try {
                if (this.s == null) {
                    this.s = new app.dogo.android.persistencedb.room.dao.b0(this);
                }
                return this.s;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.PremiumDatabase
    protected m0 e() {
        int i = 0;
        return new m0(this, new HashMap(i), new HashMap(i), new String[] { "DogoPremiumStatusEntity", "CouponEntity" });
    }

    @Override // app.dogo.android.persistencedb.room.database.PremiumDatabase
    protected h f(e0 e0Var) {
        h.b.a aVar2 = h.b.a(e0Var.b);
        aVar2.c(e0Var.c);
        aVar2.b(new w0(e0Var, new PremiumDatabase_Impl.a(this, 3), "ffff96aacb46f446344941442054b220", "3b81a1e2892bae46f1c2445cae816b01"));
        return e0Var.a.a(aVar2.a());
    }

    @Override // app.dogo.android.persistencedb.room.database.PremiumDatabase
    public List<b> h(Map<Class<? extends a>, a> map) {
        return Arrays.asList(new b[0]);
    }

    @Override // app.dogo.android.persistencedb.room.database.PremiumDatabase
    public Set<Class<? extends a>> m() {
        return new HashSet();
    }

    @Override // app.dogo.android.persistencedb.room.database.PremiumDatabase
    protected Map<Class<?>, List<Class<?>>> n() {
        final HashMap hashMap = new HashMap();
        hashMap.put(DogoPremiumStatusDao.class, app.dogo.android.persistencedb.room.dao.b0.g());
        hashMap.put(CouponEntityDao.class, app.dogo.android.persistencedb.room.dao.t.j());
        return hashMap;
    }
}
