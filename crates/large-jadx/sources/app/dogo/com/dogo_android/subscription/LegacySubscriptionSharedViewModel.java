package app.dogo.com.dogo_android.subscription;

import app.dogo.com.dogo_android.repository.domain.SubscriptionOffer;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.h0.l1;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: LegacySubscriptionSharedViewModel.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00082\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/subscription/LegacySubscriptionSharedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "getSubscriptionAppScreen", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "source", "", "fragmentReturnTag", "preloadedOffer", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class LegacySubscriptionSharedViewModel extends s {

    private final r2 remoteConfigService;
    public LegacySubscriptionSharedViewModel(r2 r2Var) {
        n.f(r2Var, "remoteConfigService");
        super();
        this.remoteConfigService = r2Var;
    }

    public static /* synthetic */ j getSubscriptionAppScreen$default(LegacySubscriptionSharedViewModel legacySubscriptionSharedViewModel, String str, String str2, SubscriptionOffer subscriptionOffer, int i, Object object) {
        if (i & 4 != 0) {
            i = 0;
        }
        return legacySubscriptionSharedViewModel.getSubscriptionAppScreen(str, str2, subscriptionOffer);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final j getSubscriptionAppScreen(String source, String fragmentReturnTag, SubscriptionOffer preloadedOffer) {
        n.f(source, "source");
        n.f(fragmentReturnTag, "fragmentReturnTag");
        return app.dogo.com.dogo_android.util.extensionfunction.l1.b(this.remoteConfigService, source, fragmentReturnTag, false, null, preloadedOffer, 8, null);
    }
}
