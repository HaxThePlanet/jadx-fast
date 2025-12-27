package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class y implements n {

    public final /* synthetic */ a3 a;
    public final /* synthetic */ CouponDiscount b;
    public /* synthetic */ y(a3 a3Var, CouponDiscount couponDiscount) {
        super();
        this.a = a3Var;
        this.b = couponDiscount;
    }

    public final Object apply(Object object) {
        return GetSubscriptionOffersInteractor.e(this.a, this.b, object);
    }
}
