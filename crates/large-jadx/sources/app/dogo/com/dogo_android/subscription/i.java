package app.dogo.com.dogo_android.subscription;

import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import i.b.c0;
import i.b.e0;

/* loaded from: classes.dex */
public final class i implements e0 {

    public final app.dogo.com.dogo_android.subscription.GetPremiumOfferingsInteractor a;
    public final CouponDiscount b;
    public final boolean c;
    public final boolean d;
    public i(app.dogo.com.dogo_android.subscription.GetPremiumOfferingsInteractor getPremiumOfferingsInteractor, CouponDiscount couponDiscount2, boolean z3, boolean z4) {
        super();
        this.a = getPremiumOfferingsInteractor;
        this.b = couponDiscount2;
        this.c = z3;
        this.d = z4;
    }

    @Override // i.b.e0
    public final void a(c0 c0) {
        GetPremiumOfferingsInteractor.a(this.a, this.b, this.c, this.d, c0);
    }
}
