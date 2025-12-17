package app.dogo.com.dogo_android.subscription.benefits;

import android.view.ViewTreeObserver.OnScrollChangedListener;

/* loaded from: classes.dex */
public final class b implements ViewTreeObserver.OnScrollChangedListener {

    public final app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment a;
    public b(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment) {
        super();
        this.a = subscriptionBenefitsFragment;
    }

    @Override // android.view.ViewTreeObserver$OnScrollChangedListener
    public final void onScrollChanged() {
        SubscriptionBenefitsFragment.C1(this.a);
    }
}
