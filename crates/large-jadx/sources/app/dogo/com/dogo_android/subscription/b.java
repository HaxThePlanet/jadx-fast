package app.dogo.com.dogo_android.subscription;

import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements n {

    public final /* synthetic */ BillingRepository a;
    public /* synthetic */ b(BillingRepository billingRepository) {
        super();
        this.a = billingRepository;
    }

    public final Object apply(Object object) {
        return BillingRepository.validateAndSaveDiscountPromoCode$lambda_1(this.a, object);
    }
}
