package app.dogo.com.dogo_android.subscription;

import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import i.b.c0;
import i.b.e0;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class i implements e0 {

    public final /* synthetic */ GetPremiumOfferingsInteractor a;
    public final /* synthetic */ CouponDiscount b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;
    public /* synthetic */ i(GetPremiumOfferingsInteractor getPremiumOfferingsInteractor, CouponDiscount couponDiscount, boolean z, boolean z2) {
        super();
        this.a = getPremiumOfferingsInteractor;
        this.b = couponDiscount;
        this.c = z;
        this.d = z2;
    }

    public final void a(c0 c0Var) {
        GetPremiumOfferingsInteractor.getOffers$lambda_0(this.a, this.b, this.c, this.d, c0Var);
    }
}
