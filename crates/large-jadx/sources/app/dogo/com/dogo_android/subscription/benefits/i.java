package app.dogo.com.dogo_android.subscription.benefits;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class i implements View.OnClickListener {

    public final /* synthetic */ SubscriptionBenefitsOfferAdapter a;
    public final /* synthetic */ SubscriptionBenefitsOfferAdapter.ViewHolder b;
    public /* synthetic */ i(SubscriptionBenefitsOfferAdapter subscriptionBenefitsOfferAdapter, SubscriptionBenefitsOfferAdapter.ViewHolder viewHolder) {
        super();
        this.a = subscriptionBenefitsOfferAdapter;
        this.b = viewHolder;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SubscriptionBenefitsOfferAdapter_ViewHolder._init_$lambda_1(this.a, this.b, view);
    }
}
