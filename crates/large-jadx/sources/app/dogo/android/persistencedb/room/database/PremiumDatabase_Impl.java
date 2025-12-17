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

/* loaded from: classes.dex */
public final class PremiumDatabase_Impl extends app.dogo.android.persistencedb.room.database.PremiumDatabase {

    private volatile a0 s;
    private volatile s t;

    class a extends w0.a {

        final app.dogo.android.persistencedb.room.database.PremiumDatabase_Impl b;
        a(app.dogo.android.persistencedb.room.database.PremiumDatabase_Impl premiumDatabase_Impl, int i2) {
            this.b = premiumDatabase_Impl;
            super(i2);
        }

        @Override // androidx.room.w0$a
        public void a(g g) {
            g.C("CREATE TABLE IF NOT EXISTS `DogoPremiumStatusEntity` (`id` TEXT NOT NULL, `ownerType` TEXT NOT NULL, `expirationTimeMs` INTEGER NOT NULL, `expirationDate` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`ownerType`, `id`))");
            g.C("CREATE TABLE IF NOT EXISTS `CouponEntity` (`couponId` TEXT NOT NULL, `discount` INTEGER NOT NULL, `offeringId` TEXT NOT NULL, `offerDurationMs` INTEGER NOT NULL, `activationTimeMs` INTEGER NOT NULL, `style` TEXT NOT NULL, `offerText` TEXT, `discountText` TEXT, `welcomeOffer` INTEGER NOT NULL, PRIMARY KEY(`couponId`))");
            g.C("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            g.C("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ffff96aacb46f446344941442054b220')");
        }

        @Override // androidx.room.w0$a
        public void b(g g) {
            int list;
            int size;
            Object obj;
            g.C("DROP TABLE IF EXISTS `DogoPremiumStatusEntity`");
            g.C("DROP TABLE IF EXISTS `CouponEntity`");
            if (PremiumDatabase_Impl.L(this.b) != null) {
                list = 0;
                while (list < PremiumDatabase_Impl.M(this.b).size()) {
                    (u0.b)PremiumDatabase_Impl.O(this.b).get(list).b(g);
                    list++;
                }
            }
        }

        @Override // androidx.room.w0$a
        protected void c(g g) {
            int list;
            int size;
            Object obj;
            if (PremiumDatabase_Impl.P(this.b) != null) {
                list = 0;
                while (list < PremiumDatabase_Impl.Q(this.b).size()) {
                    (u0.b)PremiumDatabase_Impl.R(this.b).get(list).a(g);
                    list++;
                }
            }
        }

        @Override // androidx.room.w0$a
        public void d(g g) {
            int list;
            int size;
            Object obj;
            PremiumDatabase_Impl.S(this.b, g);
            PremiumDatabase_Impl.T(this.b, g);
            if (PremiumDatabase_Impl.U(this.b) != null) {
                list = 0;
                while (list < PremiumDatabase_Impl.V(this.b).size()) {
                    (u0.b)PremiumDatabase_Impl.N(this.b).get(list).c(g);
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
            HashMap hashMap = new HashMap(5);
            super("id", "TEXT", 1, 2, 0, 1);
            hashMap.put("id", aVar);
            int i8 = 1;
            int i14 = 0;
            int i18 = 1;
            super("ownerType", "TEXT", i8, 1, i14, i18);
            hashMap.put("ownerType", aVar2);
            int i11 = 0;
            super("expirationTimeMs", "INTEGER", i8, i11, i14, i18);
            hashMap.put("expirationTimeMs", aVar3);
            super("expirationDate", "TEXT", i8, i11, i14, i18);
            hashMap.put("expirationDate", aVar4);
            super("updatedAt", "INTEGER", i8, i11, i14, i18);
            hashMap.put("updatedAt", aVar5);
            int i5 = 0;
            HashSet hashSet = new HashSet(i5);
            HashSet hashSet3 = new HashSet(i5);
            String str27 = "DogoPremiumStatusEntity";
            g gVar2 = new g(str27, hashMap, hashSet, hashSet3);
            g gVar = g.a(g, str27);
            String str7 = "\n Found:\n";
            if (!gVar2.equals(gVar)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("DogoPremiumStatusEntity(app.dogo.android.persistencedb.room.entity.DogoPremiumStatusEntity).\n Expected:\n");
                stringBuilder.append(gVar2);
                stringBuilder.append(str7);
                stringBuilder.append(gVar);
                w0.b obj13 = new w0.b(i5, stringBuilder.toString());
                return obj13;
            }
            HashMap hashMap2 = new HashMap(9);
            int i15 = 1;
            super("couponId", "TEXT", 1, i15, 0, 1);
            hashMap2.put("couponId", aVar6);
            int i20 = 0;
            int i22 = 0;
            final int i23 = 1;
            super("discount", "INTEGER", i15, i20, i22, i23);
            hashMap2.put("discount", aVar7);
            super("offeringId", "TEXT", i15, i20, i22, i23);
            hashMap2.put("offeringId", aVar8);
            super("offerDurationMs", "INTEGER", i15, i20, i22, i23);
            hashMap2.put("offerDurationMs", aVar9);
            super("activationTimeMs", "INTEGER", i15, i20, i22, i23);
            hashMap2.put("activationTimeMs", aVar10);
            super("style", "TEXT", i15, i20, i22, i23);
            hashMap2.put("style", aVar11);
            int i16 = 0;
            super("offerText", "TEXT", i16, i20, i22, i23);
            hashMap2.put("offerText", aVar12);
            super("discountText", "TEXT", i16, i20, i22, i23);
            hashMap2.put("discountText", aVar13);
            super("welcomeOffer", "INTEGER", 1, i20, i22, i23);
            hashMap2.put("welcomeOffer", aVar14);
            HashSet hashSet2 = new HashSet(i5);
            HashSet hashSet4 = new HashSet(i5);
            String str39 = "CouponEntity";
            g gVar3 = new g(str39, hashMap2, hashSet2, hashSet4);
            obj13 = g.a(g, str39);
            if (!gVar3.equals(obj13)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("CouponEntity(app.dogo.android.persistencedb.room.entity.CouponEntity).\n Expected:\n");
                stringBuilder2.append(gVar3);
                stringBuilder2.append(str7);
                stringBuilder2.append(obj13);
                w0.b bVar = new w0.b(i5, stringBuilder2.toString());
                return bVar;
            }
            obj13 = new w0.b(1, 0);
            return obj13;
        }
    }
    static List L(app.dogo.android.persistencedb.room.database.PremiumDatabase_Impl premiumDatabase_Impl) {
        return premiumDatabase_Impl.g;
    }

    static List M(app.dogo.android.persistencedb.room.database.PremiumDatabase_Impl premiumDatabase_Impl) {
        return premiumDatabase_Impl.g;
    }

    static List N(app.dogo.android.persistencedb.room.database.PremiumDatabase_Impl premiumDatabase_Impl) {
        return premiumDatabase_Impl.g;
    }

    static List O(app.dogo.android.persistencedb.room.database.PremiumDatabase_Impl premiumDatabase_Impl) {
        return premiumDatabase_Impl.g;
    }

    static List P(app.dogo.android.persistencedb.room.database.PremiumDatabase_Impl premiumDatabase_Impl) {
        return premiumDatabase_Impl.g;
    }

    static List Q(app.dogo.android.persistencedb.room.database.PremiumDatabase_Impl premiumDatabase_Impl) {
        return premiumDatabase_Impl.g;
    }

    static List R(app.dogo.android.persistencedb.room.database.PremiumDatabase_Impl premiumDatabase_Impl) {
        return premiumDatabase_Impl.g;
    }

    static g S(app.dogo.android.persistencedb.room.database.PremiumDatabase_Impl premiumDatabase_Impl, g g2) {
        premiumDatabase_Impl.a = g2;
        return g2;
    }

    static void T(app.dogo.android.persistencedb.room.database.PremiumDatabase_Impl premiumDatabase_Impl, g g2) {
        premiumDatabase_Impl.t(g2);
    }

    static List U(app.dogo.android.persistencedb.room.database.PremiumDatabase_Impl premiumDatabase_Impl) {
        return premiumDatabase_Impl.g;
    }

    static List V(app.dogo.android.persistencedb.room.database.PremiumDatabase_Impl premiumDatabase_Impl) {
        return premiumDatabase_Impl.g;
    }

    @Override // app.dogo.android.persistencedb.room.database.PremiumDatabase
    public s J() {
        s tVar;
        if (this.t != null) {
            return this.t;
        }
        synchronized (this) {
            tVar = new t(this);
            this.t = tVar;
            return this.t;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.PremiumDatabase
    public a0 K() {
        a0 b0Var;
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            b0Var = new b0(this);
            this.s = b0Var;
            return this.s;
        }
    }

    @Override // app.dogo.android.persistencedb.room.database.PremiumDatabase
    protected m0 e() {
        int i = 0;
        HashMap hashMap = new HashMap(i);
        HashMap hashMap2 = new HashMap(i);
        m0 m0Var = new m0(this, hashMap, hashMap2, /* result */);
        return m0Var;
    }

    @Override // app.dogo.android.persistencedb.room.database.PremiumDatabase
    protected h f(e0 e0) {
        PremiumDatabase_Impl.a aVar = new PremiumDatabase_Impl.a(this, 3);
        w0 w0Var = new w0(e0, aVar, "ffff96aacb46f446344941442054b220", "3b81a1e2892bae46f1c2445cae816b01");
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
        hashMap.put(a0.class, b0.g());
        hashMap.put(s.class, t.j());
        return hashMap;
    }
}
