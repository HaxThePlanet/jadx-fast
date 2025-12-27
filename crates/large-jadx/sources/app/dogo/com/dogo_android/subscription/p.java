package app.dogo.com.dogo_android.subscription;

import i.b.l0.e;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class p implements e {

    public final /* synthetic */ SubscriptionViewModel a;
    public final /* synthetic */ long b;
    public /* synthetic */ p(SubscriptionViewModel subscriptionViewModel, long j) {
        super();
        this.a = subscriptionViewModel;
        this.b = j;
    }

    public final boolean a() {
        return this.a.setupDiscountTimerIfNeeded$lambda_2(this.b, l2);
    }
}
