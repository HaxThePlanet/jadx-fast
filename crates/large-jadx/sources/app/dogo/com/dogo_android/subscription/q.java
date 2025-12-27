package app.dogo.com.dogo_android.subscription;

import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class q implements n {

    public final /* synthetic */ SubscriptionViewModel a;
    public /* synthetic */ q(SubscriptionViewModel subscriptionViewModel) {
        super();
        this.a = subscriptionViewModel;
    }

    public final Object apply(Object object) {
        return SubscriptionViewModel.getSubscriptionOffers$lambda_1(this.a, object);
    }
}
