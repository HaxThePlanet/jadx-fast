package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class o0 implements Callable {

    public final app.dogo.com.dogo_android.s.a.m3 a;
    public final SpecialOfferCoupon b;
    public o0(app.dogo.com.dogo_android.s.a.m3 m3, SpecialOfferCoupon specialOfferCoupon2) {
        super();
        this.a = m3;
        this.b = specialOfferCoupon2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return m3.g(this.a, this.b);
    }
}
