package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.b1;
import androidx.room.f1.c;
import androidx.room.h0;
import androidx.room.u0;
import androidx.room.x0;
import androidx.room.y0;
import app.dogo.android.persistencedb.room.entity.CouponEntity;
import d.s.a.i;
import d.s.a.k;
import e.a.a.a.b.a.a;
import i.b.a0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: CouponEntityDao_Impl.java */
/* loaded from: classes.dex */
public final class t implements s {

    private final u0 a;
    private final h0<CouponEntity> b = new t$a<>();
    private final a c = new a();
    private final b1 d = new t$b();

    class c implements Callable<Void> {

        final /* synthetic */ CouponEntity[] a;
        final /* synthetic */ t b;
        c(CouponEntity[] couponEntityArr) {
            this.b = tVar;
            this.a = couponEntityArr;
            super();
        }

        public Void a() {
            this.b.a.c();
            try {
                this.b.b.i(this.a);
                this.b.a.C();
            } finally {
                e.a.a.a.b.b.t tVar4 = this.b.a;
                this.b.g();
                throw th;
            }
            this.b.a.g();
            return null;
        }
    }

    class d implements Callable<List<CouponEntity>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ t b;
        d(x0 x0Var) {
            this.b = tVar;
            this.a = x0Var;
            super();
        }

        public List<CouponEntity> a() {
            String string2;
            String string3;
            Object obj3;
            long l;
            boolean z2;
            boolean z;
            final Object obj = this;
            z = false;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(obj.b.a, obj.a, z, cancellationSignal);
            try {
                int i = b.e(cursor, "couponId");
                int i3 = b.e(cursor, "offeringId");
                int i6 = b.e(cursor, "style");
                int i7 = b.e(cursor, "offerText");
                int i8 = b.e(cursor, "discountText");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                cancellationSignal = cursor.isNull(i) ? cancellationSignal : string5;
                cancellationSignal = cursor.isNull(i3) ? cancellationSignal : string4;
                cancellationSignal = cursor.isNull(i6) ? cancellationSignal : string;
                if (cursor.isNull(i7)) {
                } else {
                    string2 = cursor.getString(i7);
                }
                if (cursor.isNull(i8)) {
                } else {
                    string3 = cursor.getString(i8);
                }
                int _int = cursor.getInt(b.e(cursor, "welcomeOffer")) != 0 ? _int : z;
                CouponEntity couponEntity = new CouponEntity(obj3, cursor.getLong(b.e(cursor, "discount")), str11, l, cursor.getLong(b.e(cursor, "offerDurationMs")), str12, cursor.getLong(b.e(cursor, "activationTimeMs")), map, z2, obj.b.c.toStringMap(string2), obj.b.c.toStringMap(string3), z);
                arrayList.add(couponEntity);
            } finally {
                obj2.close();
                throw th;
            }
            cursor.close();
            return arrayList;
        }

        @Override // java.lang.Object
        protected void finalize() {
            this.a.j();
        }
    }

    class e implements Callable<List<CouponEntity>> {

        final /* synthetic */ x0 a;
        final /* synthetic */ t b;
        e(x0 x0Var) {
            this.b = tVar;
            this.a = x0Var;
            super();
        }

        public List<CouponEntity> a() {
            String string2;
            String string3;
            Object obj3;
            long l;
            boolean z2;
            boolean z;
            final Object obj = this;
            z = false;
            final android.os.CancellationSignal cancellationSignal = null;
            Cursor cursor = c.c(obj.b.a, obj.a, z, cancellationSignal);
            try {
                int i = b.e(cursor, "couponId");
                int i3 = b.e(cursor, "offeringId");
                int i6 = b.e(cursor, "style");
                int i7 = b.e(cursor, "offerText");
                int i8 = b.e(cursor, "discountText");
                final ArrayList arrayList = new ArrayList(cursor.getCount());
                cancellationSignal = cursor.isNull(i) ? cancellationSignal : string5;
                cancellationSignal = cursor.isNull(i3) ? cancellationSignal : string4;
                cancellationSignal = cursor.isNull(i6) ? cancellationSignal : string;
                if (cursor.isNull(i7)) {
                } else {
                    string2 = cursor.getString(i7);
                }
                if (cursor.isNull(i8)) {
                } else {
                    string3 = cursor.getString(i8);
                }
                int _int = cursor.getInt(b.e(cursor, "welcomeOffer")) != 0 ? _int : z;
                CouponEntity couponEntity = new CouponEntity(obj3, cursor.getLong(b.e(cursor, "discount")), str11, l, cursor.getLong(b.e(cursor, "offerDurationMs")), str12, cursor.getLong(b.e(cursor, "activationTimeMs")), map, z2, obj.b.c.toStringMap(string2), obj.b.c.toStringMap(string3), z);
                arrayList.add(couponEntity);
            } finally {
                obj2.close();
                throw th;
            }
            cursor.close();
            return arrayList;
        }

        @Override // java.lang.Object
        protected void finalize() {
            this.a.j();
        }
    }

    class b extends b1 {
        b(u0 u0Var) {
            super(u0Var);
        }

        @Override // androidx.room.b1
        public String d() {
            return "DELETE FROM CouponEntity";
        }
    }

    class a extends h0<CouponEntity> {

        final /* synthetic */ t d;
        a(u0 u0Var) {
            this.d = tVar;
            super(u0Var);
        }

        @Override // androidx.room.h0
        public void k(k kVar, CouponEntity couponEntity) {
            int i5 = 1;
            if (couponEntity.getCouponId() == null) {
                kVar.k1(i5);
            } else {
                kVar.D(i5, couponEntity.getCouponId());
            }
            kVar.u0(2, couponEntity.getDiscount());
            int i6 = 3;
            if (couponEntity.getOfferingId() == null) {
                kVar.k1(i6);
            } else {
                kVar.D(i6, couponEntity.getOfferingId());
            }
            kVar.u0(4, couponEntity.getOfferDurationMs());
            kVar.u0(5, couponEntity.getActivationTimeMs());
            int i7 = 6;
            if (couponEntity.getStyle() == null) {
                kVar.k1(i7);
            } else {
                kVar.D(i7, couponEntity.getStyle());
            }
            String stringMap = this.d.c.fromStringMap(couponEntity.getOfferText());
            int i8 = 7;
            if (stringMap == null) {
                kVar.k1(i8);
            } else {
                kVar.D(i8, stringMap);
            }
            String stringMap2 = this.d.c.fromStringMap(couponEntity.getDiscountText());
            int i9 = 8;
            if (stringMap2 == null) {
                kVar.k1(i9);
            } else {
                kVar.D(i9, stringMap2);
            }
            kVar.u0(9, couponEntity.getWelcomeOffer() != 0 ? 1 : 0);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `CouponEntity` (`couponId`,`discount`,`offeringId`,`offerDurationMs`,`activationTimeMs`,`style`,`offerText`,`discountText`,`welcomeOffer`) VALUES (?,?,?,?,?,?,?,?,?)";
        }
    }
    public t(u0 u0Var) {
        super();
        a dataConverter = new DataConverter();
        this.a = u0Var;
        e.a.a.a.b.b.t.a aVar = new app.dogo.android.persistencedb.room.dao.t.a(this, u0Var);
        e.a.a.a.b.b.t.b bVar = new app.dogo.android.persistencedb.room.dao.t.b(this, u0Var);
    }

    static /* synthetic */ a g(t tVar) {
        return tVar.c;
    }

    static /* synthetic */ u0 h(t tVar) {
        return tVar.a;
    }

    static /* synthetic */ h0 i(t tVar) {
        return tVar.b;
    }

    public static List<Class<?>> j() {
        return Collections.emptyList();
    }

    public a0<Boolean> a(String str) {
        return app.dogo.android.persistencedb.room.dao.s.a.c(this, str);
    }

    public a0<CouponEntity> b() {
        return app.dogo.android.persistencedb.room.dao.s.a.a(this);
    }

    public a0<List<CouponEntity>> c() {
        return y0.a(new app.dogo.android.persistencedb.room.dao.t.d(this, x0.e("SELECT * FROM CouponEntity", 0)));
    }

    public void d() {
        this.a.b();
        k kVar2 = this.d.a();
        this.a.c();
        try {
            kVar2.N();
            this.a.C();
        } finally {
            this.a.g();
            this.a.f(kVar);
            throw th;
        }
        this.a.g();
        this.d.f(kVar2);
    }

    public a0<List<CouponEntity>> e() {
        return y0.a(new app.dogo.android.persistencedb.room.dao.t.e(this, x0.e("SELECT * FROM CouponEntity ORDER BY activationTimeMs DESC", 0)));
    }

    public i.b.b f(CouponEntity... couponEntityArr) {
        return b.o(new app.dogo.android.persistencedb.room.dao.t.c(this, couponEntityArr));
    }
}
