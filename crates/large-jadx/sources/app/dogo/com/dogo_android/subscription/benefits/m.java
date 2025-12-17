package app.dogo.com.dogo_android.subscription.benefits;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class m implements y {

    public final app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment a;
    public m(app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment subscriptionPlanFragment) {
        super();
        this.a = subscriptionPlanFragment;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        SubscriptionPlanFragment.E1(this.a, (Boolean)object);
    }
}
