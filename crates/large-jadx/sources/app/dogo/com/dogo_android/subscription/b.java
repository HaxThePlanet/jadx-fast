package app.dogo.com.dogo_android.subscription;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class b implements n {

    public final app.dogo.com.dogo_android.subscription.BillingRepository a;
    public b(app.dogo.com.dogo_android.subscription.BillingRepository billingRepository) {
        super();
        this.a = billingRepository;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return BillingRepository.b(this.a, (String)object);
    }
}
