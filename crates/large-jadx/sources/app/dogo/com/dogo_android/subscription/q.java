package app.dogo.com.dogo_android.subscription;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class q implements n {

    public final app.dogo.com.dogo_android.subscription.SubscriptionViewModel a;
    public q(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel) {
        super();
        this.a = subscriptionViewModel;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return SubscriptionViewModel.k(this.a, (Throwable)object);
    }
}
