package app.dogo.com.dogo_android.subscription.benefits;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class d implements y {

    public final app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment a;
    public d(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment) {
        super();
        this.a = subscriptionBenefitsFragment;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        SubscriptionBenefitsFragment.E1(this.a, (y)object);
    }
}
