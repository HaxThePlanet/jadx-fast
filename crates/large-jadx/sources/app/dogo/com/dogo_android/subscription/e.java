package app.dogo.com.dogo_android.subscription;

import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class e implements n {

    public final /* synthetic */ BillingRepository a;
    public final /* synthetic */ String b;
    public /* synthetic */ e(BillingRepository billingRepository, String str) {
        super();
        this.a = billingRepository;
        this.b = str;
    }

    public final Object apply(Object object) {
        return BillingRepository.validateAndSaveDiscount$lambda_2(this.a, this.b, object);
    }
}
