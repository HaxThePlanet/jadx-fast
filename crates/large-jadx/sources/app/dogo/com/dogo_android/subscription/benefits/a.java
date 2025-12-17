package app.dogo.com.dogo_android.subscription.benefits;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class a implements y {

    public final app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment a;
    public a(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment) {
        super();
        this.a = subscriptionBenefitsFragment;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        SubscriptionBenefitsFragment.B1(this.a, (Boolean)object);
    }
}
