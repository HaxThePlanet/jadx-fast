package app.dogo.com.dogo_android.subscription.benefits;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class h implements y {

    public final app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment a;
    public h(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment) {
        super();
        this.a = subscriptionBenefitsFragment;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        SubscriptionBenefitsFragment.I1(this.a, (Boolean)object);
    }
}
