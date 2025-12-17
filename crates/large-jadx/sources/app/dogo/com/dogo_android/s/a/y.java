package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class y implements n {

    public final app.dogo.com.dogo_android.s.a.a3 a;
    public final CouponDiscount b;
    public y(app.dogo.com.dogo_android.s.a.a3 a3, CouponDiscount couponDiscount2) {
        super();
        this.a = a3;
        this.b = couponDiscount2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return a3.g(this.a, this.b, (Boolean)object);
    }
}
