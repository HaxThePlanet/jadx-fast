package app.dogo.com.dogo_android.subscription;

import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c implements n {

    public final /* synthetic */ BillingRepository a;
    public /* synthetic */ c(BillingRepository billingRepository) {
        super();
        this.a = billingRepository;
    }

    public final Object apply(Object object) {
        return BillingRepository.fetchAndSaveDiscount$lambda_4(this.a, object);
    }
}
