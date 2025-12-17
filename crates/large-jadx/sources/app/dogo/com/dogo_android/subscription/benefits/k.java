package app.dogo.com.dogo_android.subscription.benefits;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class k implements View.OnClickListener {

    public final app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment a;
    public k(app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment subscriptionPlanFragment) {
        super();
        this.a = subscriptionPlanFragment;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SubscriptionPlanFragment.C1(this.a, view);
    }
}
