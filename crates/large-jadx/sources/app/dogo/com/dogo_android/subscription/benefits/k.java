package app.dogo.com.dogo_android.subscription.benefits;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class k implements View.OnClickListener {

    public final /* synthetic */ SubscriptionPlanFragment a;
    public /* synthetic */ k(SubscriptionPlanFragment subscriptionPlanFragment) {
        super();
        this.a = subscriptionPlanFragment;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SubscriptionPlanFragment.onViewCreated$lambda_3(this.a, view);
    }
}
