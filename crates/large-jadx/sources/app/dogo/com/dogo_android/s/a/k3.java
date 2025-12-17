package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.SettingsResults;
import i.b.a0;
import i.b.g0;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/SettingsInteractor;", "", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "zendeskInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/ZendeskInteractor;", "(Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/repository/interactor/ZendeskInteractor;)V", "getSettingsAsyncData", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/SettingsResults;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k3 {

    private final app.dogo.com.dogo_android.s.a.n3 a;
    private final app.dogo.com.dogo_android.s.a.s3 b;
    public k3(app.dogo.com.dogo_android.s.a.n3 n3, app.dogo.com.dogo_android.s.a.s3 s32) {
        n.f(n3, "subscribeInteractor");
        n.f(s32, "zendeskInteractor");
        super();
        this.a = n3;
        this.b = s32;
    }

    private static final g0 b(app.dogo.com.dogo_android.s.a.k3 k3, Boolean boolean2) {
        n.f(k3, "this$0");
        n.f(boolean2, "resubscribe");
        h0 h0Var = new h0(k3, boolean2);
        return k3.a.q().flatMap(h0Var);
    }

    private static final g0 c(app.dogo.com.dogo_android.s.a.k3 k3, Boolean boolean2, Boolean boolean3) {
        n.f(k3, "this$0");
        n.f(boolean2, "$resubscribe");
        n.f(boolean3, "subscribed");
        i0 i0Var = new i0(boolean3, boolean2);
        return k3.b.j().map(i0Var);
    }

    private static final SettingsResults d(Boolean boolean, Boolean boolean2, Boolean boolean3) {
        n.f(boolean, "$subscribed");
        n.f(boolean2, "$resubscribe");
        n.f(boolean3, "hasRequestHistory");
        SettingsResults settingsResults = new SettingsResults(boolean.booleanValue(), boolean2.booleanValue(), boolean3.booleanValue());
        return settingsResults;
    }

    public static g0 e(app.dogo.com.dogo_android.s.a.k3 k3, Boolean boolean2, Boolean boolean3) {
        return k3.c(k3, boolean2, boolean3);
    }

    public static SettingsResults f(Boolean boolean, Boolean boolean2, Boolean boolean3) {
        return k3.d(boolean, boolean2, boolean3);
    }

    public static g0 g(app.dogo.com.dogo_android.s.a.k3 k3, Boolean boolean2) {
        return k3.b(k3, boolean2);
    }

    public final a0<SettingsResults> a() {
        j0 j0Var = new j0(this);
        a0 flatMap = this.a.o().flatMap(j0Var);
        n.e(flatMap, "subscribeInteractor.revenueCatShowResubscribe().flatMap { resubscribe ->\n            subscribeInteractor.revenueCatSubscribed().flatMap { subscribed ->\n                zendeskInteractor.hasRequestHistory().map { hasRequestHistory ->\n                    SettingsResults(\n                        canResubscribe = resubscribe,\n                        premium = subscribed,\n                        hasZendeskRequestHistory = hasRequestHistory\n                    )\n                }\n            }\n        }");
        return flatMap;
    }
}
