package app.dogo.com.dogo_android.subscription;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class e implements n {

    public final app.dogo.com.dogo_android.subscription.BillingRepository a;
    public final String b;
    public e(app.dogo.com.dogo_android.subscription.BillingRepository billingRepository, String string2) {
        super();
        this.a = billingRepository;
        this.b = string2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return BillingRepository.e(this.a, this.b, (Boolean)object);
    }
}
