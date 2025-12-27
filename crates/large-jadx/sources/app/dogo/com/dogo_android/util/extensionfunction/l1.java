package app.dogo.com.dogo_android.util.h0;

import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import app.dogo.com.dogo_android.repository.domain.SubscriptionOffer;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsScreen;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: RemoteConfigExtensions.kt */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a<\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u0006\u000c", d2 = {"getSubscriptionAppScreenV2", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "source", "", "fragmentReturnTag", "initiatedByDogParentFlow", "", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "preloadedOffer", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class l1 {
    public static final j a(r2 r2Var, String str, String str2, boolean z, ProfilePreview profilePreview, SubscriptionOffer subscriptionOffer) {
        n.f(r2Var, "<this>");
        n.f(str, "source");
        n.f(str2, "fragmentReturnTag");
        SubscriptionBenefitsScreen r2Var2 = new SubscriptionBenefitsScreen(str, str2, null, z, profilePreview, subscriptionOffer, 4, null);
        return r2Var2;
    }

    public static /* synthetic */ j b(r2 r2Var, String str, String str2, boolean z, ProfilePreview profilePreview, SubscriptionOffer subscriptionOffer, int i, Object object) {
        ProfilePreview profilePreview52;
        SubscriptionOffer subscriptionOffer62;
        if (i & 4 != 0) {
            i = 0;
        }
        int object82 = 0;
        int r4 = i & 8 != 0 ? object82 : profilePreview;
        int r5 = i & 16 != 0 ? object82 : subscriptionOffer;
        return app.dogo.com.dogo_android.util.extensionfunction.l1.a(r2Var, str, str2, i, profilePreview52, (i & 16 != 0 ? object82 : subscriptionOffer));
    }
}
