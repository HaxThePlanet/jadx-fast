package app.dogo.com.dogo_android.subscription;

import i.b.l0.c;
import java.util.List;

/* loaded from: classes.dex */
public final class n implements c {

    public final app.dogo.com.dogo_android.subscription.SubscriptionViewModel a;
    public final List b;
    public final boolean c;
    public final boolean d;
    public n(app.dogo.com.dogo_android.subscription.SubscriptionViewModel subscriptionViewModel, List list2, boolean z3, boolean z4) {
        super();
        this.a = subscriptionViewModel;
        this.b = list2;
        this.c = z3;
        this.d = z4;
    }

    @Override // i.b.l0.c
    public final Object apply(Object object, Object object2) {
        return SubscriptionViewModel.h(this.a, this.b, this.c, this.d, (DogProfile)object, (Boolean)object2);
    }
}
