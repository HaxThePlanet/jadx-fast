package app.dogo.com.dogo_android.subscription.benefits;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class e implements View.OnClickListener {

    public final /* synthetic */ SubscriptionBenefitsFragment a;
    public /* synthetic */ e(SubscriptionBenefitsFragment subscriptionBenefitsFragment) {
        super();
        this.a = subscriptionBenefitsFragment;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SubscriptionBenefitsFragment.onViewCreated$lambda_1(this.a, view);
    }
}
