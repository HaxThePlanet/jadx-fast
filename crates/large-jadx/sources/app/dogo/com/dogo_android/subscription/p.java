package app.dogo.com.dogo_android.subscription;

import i.b.l0.e;

/* loaded from: classes.dex */
public final class p implements e {

    public final app.dogo.com.dogo_android.subscription.SubscriptionViewModel a;
    public final long b;
    public p(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel, long l2) {
        super();
        this.a = subscriptionViewModel;
        this.b = l2;
    }

    @Override // i.b.l0.e
    public final boolean a() {
        return SubscriptionViewModel.j(this.a, this.b);
    }
}
