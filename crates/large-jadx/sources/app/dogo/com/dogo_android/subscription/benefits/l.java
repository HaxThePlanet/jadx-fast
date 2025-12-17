package app.dogo.com.dogo_android.subscription.benefits;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class l implements View.OnClickListener {

    public final app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment a;
    public l(app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment subscriptionPlanFragment) {
        super();
        this.a = subscriptionPlanFragment;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SubscriptionPlanFragment.D1(this.a, view);
    }
}
