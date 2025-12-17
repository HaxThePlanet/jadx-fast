package app.dogo.com.dogo_android.util.h0;

import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import app.dogo.com.dogo_android.repository.domain.SubscriptionOffer;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsScreen;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a<\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u0006\u000c", d2 = {"getSubscriptionAppScreenV2", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "source", "", "fragmentReturnTag", "initiatedByDogParentFlow", "", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "preloadedOffer", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class l1 {
    public static final j a(r2 r2, String string2, String string3, boolean z4, ProfilePreview profilePreview5, SubscriptionOffer subscriptionOffer6) {
        n.f(r2, "<this>");
        n.f(string2, "source");
        n.f(string3, "fragmentReturnTag");
        super(string2, string3, 0, z4, profilePreview5, subscriptionOffer6, 4, 0);
        return obj9;
    }

    public static j b(r2 r2, String string2, String string3, boolean z4, ProfilePreview profilePreview5, SubscriptionOffer subscriptionOffer6, int i7, Object object8) {
        int i;
        int i2;
        int obj9;
        if (i7 & 4 != 0) {
            obj9 = 0;
        }
        int obj13 = 0;
        i = i7 & 8 != 0 ? obj13 : profilePreview5;
        i2 = i7 & 16 != 0 ? obj13 : subscriptionOffer6;
        return l1.a(r2, string2, string3, obj9, i, i2);
    }
}
