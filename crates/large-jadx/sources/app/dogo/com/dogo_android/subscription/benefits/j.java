package app.dogo.com.dogo_android.subscription.benefits;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class j implements View.OnClickListener {

    public final app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment a;
    public j(app.dogo.com.dogo_android.subscription.benefits.SubscriptionPlanFragment subscriptionPlanFragment) {
        super();
        this.a = subscriptionPlanFragment;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SubscriptionPlanFragment.B1(this.a, view);
    }
}
