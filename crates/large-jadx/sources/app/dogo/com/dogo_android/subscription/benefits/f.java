package app.dogo.com.dogo_android.subscription.benefits;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class f implements View.OnClickListener {

    public final app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment a;
    public f(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsFragment subscriptionBenefitsFragment) {
        super();
        this.a = subscriptionBenefitsFragment;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SubscriptionBenefitsFragment.G1(this.a, view);
    }
}
