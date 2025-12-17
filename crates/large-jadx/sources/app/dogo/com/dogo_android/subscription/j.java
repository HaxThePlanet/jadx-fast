package app.dogo.com.dogo_android.subscription;

import androidx.fragment.app.n.o;

/* loaded from: classes.dex */
public final class j implements n.o {

    public final app.dogo.com.dogo_android.subscription.SubscriptionActivity a;
    public j(app.dogo.com.dogo_android.subscription.SubscriptionActivity subscriptionActivity) {
        super();
        this.a = subscriptionActivity;
    }

    @Override // androidx.fragment.app.n$o
    public final void onBackStackChanged() {
        SubscriptionActivity.i(this.a);
    }
}
