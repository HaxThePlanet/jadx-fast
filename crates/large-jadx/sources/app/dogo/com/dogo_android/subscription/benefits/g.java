package app.dogo.com.dogo_android.subscription.benefits;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class g implements y {

    public final app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment a;
    public g(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment) {
        super();
        this.a = subscriptionBenefitsFragment;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        SubscriptionBenefitsFragment.H1(this.a, (y)object);
    }
}
