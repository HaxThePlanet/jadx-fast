package e.a.a.a.b.b;

import android.database.Cursor;
import androidx.room.b1;
import androidx.room.f1.b;
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
import i.b.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class t implements e.a.a.a.b.b.s {

    private final u0 a;
    private final h0<CouponEntity> b;
    private final a c;
    private final b1 d;

    class c implements Callable<Void> {

        final CouponEntity[] a;
        final e.a.a.a.b.b.t b;
        c(e.a.a.a.b.b.t t, CouponEntity[] couponEntity2Arr2) {
            this.b = t;
            this.a = couponEntity2Arr2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            t.h(this.b).c();
            t.i(this.b).i(this.a);
            t.h(this.b).C();
            t.h(this.b).g();
            return null;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class d implements Callable<List<CouponEntity>> {

        final x0 a;
        final e.a.a.a.b.b.t b;
        d(e.a.a.a.b.b.t t, x0 x02) {
            this.b = t;
            this.a = x02;
            super();
        }

        public List<CouponEntity> a() {
            int couponEntity;
            boolean string2;
            boolean string4;
            boolean string5;
            int string3;
            int string;
            int int;
            int i3;
            int i;
            long long2;
            int i4;
            long long;
            long long3;
            int i5;
            java.util.Map map;
            java.util.Map map2;
            int i2;
            final Object obj = this;
            final int i7 = 0;
            final int i8 = 0;
            Cursor cursor = c.c(t.h(obj.b), obj.a, i7, i8);
            int i6 = b.e(cursor, "couponId");
            int i10 = b.e(cursor, "offeringId");
            int i13 = b.e(cursor, "style");
            int i14 = b.e(cursor, "offerText");
            int i15 = b.e(cursor, "discountText");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i6)) {
                } else {
                }
                i = string2;
                if (cursor.isNull(i10)) {
                } else {
                }
                i4 = string4;
                if (cursor.isNull(i13)) {
                } else {
                }
                i5 = string5;
                if (cursor.isNull(i14)) {
                } else {
                }
                string3 = cursor.getString(i14);
                if (cursor.isNull(i15)) {
                } else {
                }
                string = cursor.getString(i15);
                if (cursor.getInt(b.e(cursor, "welcomeOffer")) != 0) {
                } else {
                }
                i2 = i7;
                super(i, cursor.getLong(b.e(cursor, "discount")), obj18, i4, cursor.getLong(b.e(cursor, "offerDurationMs")), obj21, cursor.getLong(b.e(cursor, "activationTimeMs")), obj23, i5, t.g(obj.b).l(string3), t.g(obj.b).l(string), i2);
                arrayList.add(couponEntity);
                i2 = int;
                string = i8;
                string3 = i8;
                i5 = i8;
                i4 = i8;
                i = i8;
            }
            cursor.close();
            return arrayList;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }

        @Override // java.util.concurrent.Callable
        protected void finalize() {
            this.a.j();
        }
    }

    class e implements Callable<List<CouponEntity>> {

        final x0 a;
        final e.a.a.a.b.b.t b;
        e(e.a.a.a.b.b.t t, x0 x02) {
            this.b = t;
            this.a = x02;
            super();
        }

        public List<CouponEntity> a() {
            int couponEntity;
            boolean string5;
            boolean string;
            boolean string2;
            int string3;
            int string4;
            int int;
            int i;
            int i3;
            long long2;
            int i4;
            long long3;
            long long;
            int i5;
            java.util.Map map;
            java.util.Map map2;
            int i2;
            final Object obj = this;
            final int i7 = 0;
            final int i8 = 0;
            Cursor cursor = c.c(t.h(obj.b), obj.a, i7, i8);
            int i6 = b.e(cursor, "couponId");
            int i10 = b.e(cursor, "offeringId");
            int i13 = b.e(cursor, "style");
            int i14 = b.e(cursor, "offerText");
            int i15 = b.e(cursor, "discountText");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.isNull(i6)) {
                } else {
                }
                i3 = string5;
                if (cursor.isNull(i10)) {
                } else {
                }
                i4 = string;
                if (cursor.isNull(i13)) {
                } else {
                }
                i5 = string2;
                if (cursor.isNull(i14)) {
                } else {
                }
                string3 = cursor.getString(i14);
                if (cursor.isNull(i15)) {
                } else {
                }
                string4 = cursor.getString(i15);
                if (cursor.getInt(b.e(cursor, "welcomeOffer")) != 0) {
                } else {
                }
                i2 = i7;
                super(i3, cursor.getLong(b.e(cursor, "discount")), obj18, i4, cursor.getLong(b.e(cursor, "offerDurationMs")), obj21, cursor.getLong(b.e(cursor, "activationTimeMs")), obj23, i5, t.g(obj.b).l(string3), t.g(obj.b).l(string4), i2);
                arrayList.add(couponEntity);
                i2 = int;
                string4 = i8;
                string3 = i8;
                i5 = i8;
                i4 = i8;
                i3 = i8;
            }
            cursor.close();
            return arrayList;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }

        @Override // java.util.concurrent.Callable
        protected void finalize() {
            this.a.j();
        }
    }

    class b extends b1 {
        b(e.a.a.a.b.b.t t, u0 u02) {
            super(u02);
        }

        @Override // androidx.room.b1
        public String d() {
            return "DELETE FROM CouponEntity";
        }
    }

    class a extends h0<CouponEntity> {

        final e.a.a.a.b.b.t d;
        a(e.a.a.a.b.b.t t, u0 u02) {
            this.d = t;
            super(u02);
        }

        @Override // androidx.room.h0
        public String d() {
            return "INSERT OR REPLACE INTO `CouponEntity` (`couponId`,`discount`,`offeringId`,`offerDurationMs`,`activationTimeMs`,`style`,`offerText`,`discountText`,`welcomeOffer`) VALUES (?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.h0
        public void g(k k, Object object2) {
            k(k, (CouponEntity)object2);
        }

        @Override // androidx.room.h0
        public void k(k k, CouponEntity couponEntity2) {
            String couponId;
            String offeringId;
            String style;
            int i5 = 1;
            if (couponEntity2.getCouponId() == null) {
                k.k1(i5);
            } else {
                k.D(i5, couponEntity2.getCouponId());
            }
            k.u0(2, couponEntity2.getDiscount());
            int i6 = 3;
            if (couponEntity2.getOfferingId() == null) {
                k.k1(i6);
            } else {
                k.D(i6, couponEntity2.getOfferingId());
            }
            k.u0(4, couponEntity2.getOfferDurationMs());
            k.u0(5, couponEntity2.getActivationTimeMs());
            int i7 = 6;
            if (couponEntity2.getStyle() == null) {
                k.k1(i7);
            } else {
                k.D(i7, couponEntity2.getStyle());
            }
            String str = t.g(this.d).f(couponEntity2.getOfferText());
            int i8 = 7;
            if (str == null) {
                k.k1(i8);
            } else {
                k.D(i8, str);
            }
            String str2 = t.g(this.d).f(couponEntity2.getDiscountText());
            int i9 = 8;
            if (str2 == null) {
                k.k1(i9);
            } else {
                k.D(i9, str2);
            }
            k.u0(9, (long)obj5);
        }
    }
    public t(u0 u0) {
        super();
        a aVar = new a();
        this.c = aVar;
        this.a = u0;
        t.a aVar2 = new t.a(this, u0);
        this.b = aVar2;
        t.b bVar = new t.b(this, u0);
        this.d = bVar;
    }

    static a g(e.a.a.a.b.b.t t) {
        return t.c;
    }

    static u0 h(e.a.a.a.b.b.t t) {
        return t.a;
    }

    static h0 i(e.a.a.a.b.b.t t) {
        return t.b;
    }

    public static List<Class<?>> j() {
        return Collections.emptyList();
    }

    public a0<Boolean> a(String string) {
        return s.a.c(this, string);
    }

    public a0<CouponEntity> b() {
        return s.a.a(this);
    }

    public a0<List<CouponEntity>> c() {
        t.d dVar = new t.d(this, x0.e("SELECT * FROM CouponEntity", 0));
        return y0.a(dVar);
    }

    @Override // e.a.a.a.b.b.s
    public void d() {
        this.a.b();
        k kVar = this.d.a();
        this.a.c();
        kVar.N();
        this.a.C();
        this.a.g();
        this.d.f(kVar);
    }

    public a0<List<CouponEntity>> e() {
        t.e eVar = new t.e(this, x0.e("SELECT * FROM CouponEntity ORDER BY activationTimeMs DESC", 0));
        return y0.a(eVar);
    }

    @Override // e.a.a.a.b.b.s
    public b f(CouponEntity... couponEntityArr) {
        t.c cVar = new t.c(this, couponEntityArr);
        return b.o(cVar);
    }
}
