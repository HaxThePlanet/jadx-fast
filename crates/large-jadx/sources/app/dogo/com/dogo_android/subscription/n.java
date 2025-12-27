package app.dogo.com.dogo_android.subscription;

import i.b.l0.c;
import java.util.List;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class n implements c {

    public final /* synthetic */ SubscriptionViewModel a;
    public final /* synthetic */ List b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;
    public /* synthetic */ n(SubscriptionViewModel subscriptionViewModel, List list, boolean z, boolean z2) {
        super();
        this.a = subscriptionViewModel;
        this.b = list;
        this.c = z;
        this.d = z2;
    }

    public final Object apply(Object object, Object object2) {
        return SubscriptionViewModel.fetchDataAndOpenZendeskScreen$lambda_7(this.a, this.b, this.c, this.d, (DogProfile)object, (Boolean)object2);
    }
}
