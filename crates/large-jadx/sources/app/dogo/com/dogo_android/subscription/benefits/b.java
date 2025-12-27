package app.dogo.com.dogo_android.subscription.benefits;

import android.view.ViewTreeObserver.OnScrollChangedListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements ViewTreeObserver.OnScrollChangedListener {

    public final /* synthetic */ SubscriptionBenefitsFragment a;
    public /* synthetic */ b(SubscriptionBenefitsFragment subscriptionBenefitsFragment) {
        super();
        this.a = subscriptionBenefitsFragment;
    }

    public final void onScrollChanged() {
        SubscriptionBenefitsFragment.onViewCreated$lambda_8(this.a);
    }
}
