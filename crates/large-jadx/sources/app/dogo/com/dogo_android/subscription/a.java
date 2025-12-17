package app.dogo.com.dogo_android.subscription;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class a implements n {

    public final app.dogo.com.dogo_android.subscription.BillingRepository a;
    public a(app.dogo.com.dogo_android.subscription.BillingRepository billingRepository) {
        super();
        this.a = billingRepository;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return BillingRepository.a(this.a, (CouponEntity)object);
    }
}
