package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class n0 implements n {

    public final /* synthetic */ CouponDiscount a;
    public final /* synthetic */ m3 b;
    public /* synthetic */ n0(CouponDiscount couponDiscount, m3 m3Var) {
        super();
        this.a = couponDiscount;
        this.b = m3Var;
    }

    public final Object apply(Object object) {
        return SpecialOfferInteractor.c(this.a, this.b, object);
    }
}
