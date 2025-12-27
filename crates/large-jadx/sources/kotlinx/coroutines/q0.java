package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class q0 implements n {

    public final /* synthetic */ m3 a;
    public final /* synthetic */ SpecialOfferCoupon b;
    public final /* synthetic */ CouponDiscount c;
    public /* synthetic */ q0(m3 m3Var, SpecialOfferCoupon specialOfferCoupon, CouponDiscount couponDiscount) {
        super();
        this.a = m3Var;
        this.b = specialOfferCoupon;
        this.c = couponDiscount;
    }

    public final Object apply(Object object) {
        return SpecialOfferInteractor.d(this.a, this.b, this.c, object);
    }
}
