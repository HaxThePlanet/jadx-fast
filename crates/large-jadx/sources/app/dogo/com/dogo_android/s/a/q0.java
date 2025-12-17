package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class q0 implements n {

    public final app.dogo.com.dogo_android.s.a.m3 a;
    public final SpecialOfferCoupon b;
    public final CouponDiscount c;
    public q0(app.dogo.com.dogo_android.s.a.m3 m3, SpecialOfferCoupon specialOfferCoupon2, CouponDiscount couponDiscount3) {
        super();
        this.a = m3;
        this.b = specialOfferCoupon2;
        this.c = couponDiscount3;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return m3.i(this.a, this.b, this.c, (Boolean)object);
    }
}
