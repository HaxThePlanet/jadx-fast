package app.dogo.com.dogo_android.subscription.benefits;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class i implements View.OnClickListener {

    public final app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter a;
    public final app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter.ViewHolder b;
    public i(app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter subscriptionBenefitsOfferAdapter, app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter.ViewHolder subscriptionBenefitsOfferAdapter$ViewHolder2) {
        super();
        this.a = subscriptionBenefitsOfferAdapter;
        this.b = viewHolder2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SubscriptionBenefitsOfferAdapter.ViewHolder.a(this.a, this.b, view);
    }
}
