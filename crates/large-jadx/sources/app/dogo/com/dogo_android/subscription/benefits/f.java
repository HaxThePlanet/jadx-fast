package app.dogo.com.dogo_android.subscription.benefits;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class f implements View.OnClickListener {

    public final /* synthetic */ SubscriptionBenefitsFragment a;
    public /* synthetic */ f(SubscriptionBenefitsFragment subscriptionBenefitsFragment) {
        super();
        this.a = subscriptionBenefitsFragment;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SubscriptionBenefitsFragment.onViewCreated$lambda_0(this.a, view);
    }
}
