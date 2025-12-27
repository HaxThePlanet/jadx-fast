package app.dogo.com.dogo_android.subscription;

import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements n {

    public final /* synthetic */ BillingRepository a;
    public /* synthetic */ a(BillingRepository billingRepository) {
        super();
        this.a = billingRepository;
    }

    public final Object apply(Object object) {
        return BillingRepository.getDiscount$lambda_0(this.a, object);
    }
}
