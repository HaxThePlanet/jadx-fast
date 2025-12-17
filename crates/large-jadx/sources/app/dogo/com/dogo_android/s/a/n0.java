package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class n0 implements n {

    public final CouponDiscount a;
    public final app.dogo.com.dogo_android.s.a.m3 b;
    public n0(CouponDiscount couponDiscount, app.dogo.com.dogo_android.s.a.m3 m32) {
        super();
        this.a = couponDiscount;
        this.b = m32;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return m3.f(this.a, this.b, (Boolean)object);
    }
}
