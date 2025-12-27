package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.SettingsResults;
import i.b.a0;
import i.b.g0;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: SettingsInteractor.kt */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/SettingsInteractor;", "", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "zendeskInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/ZendeskInteractor;", "(Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/repository/interactor/ZendeskInteractor;)V", "getSettingsAsyncData", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/SettingsResults;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k3, reason: from kotlin metadata */
public final class SettingsInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final n3 subscribeInteractor;
    /* renamed from: b, reason: from kotlin metadata */
    private final s3 zendeskInteractor;
    public k3(n3 n3Var, s3 s3Var) {
        n.f(n3Var, "subscribeInteractor");
        n.f(s3Var, "zendeskInteractor");
        super();
        this.subscribeInteractor = n3Var;
        this.zendeskInteractor = s3Var;
    }

    private static final g0 b(k3 k3Var, Boolean boolean) {
        n.f(k3Var, "this$0");
        n.f(boolean, "resubscribe");
        return k3Var.subscribeInteractor.q().flatMap(new kotlinx.coroutines.h0(k3Var, boolean));
    }

    private static final g0 c(k3 k3Var, Boolean boolean, Boolean boolean2) {
        n.f(k3Var, "this$0");
        n.f(boolean, "$resubscribe");
        n.f(boolean2, "subscribed");
        return k3Var.zendeskInteractor.j().map(new kotlinx.coroutines.i0(boolean2, boolean));
    }

    private static final SettingsResults d(Boolean boolean, Boolean boolean2, Boolean boolean3) {
        n.f(boolean, "$subscribed");
        n.f(boolean2, "$resubscribe");
        n.f(boolean3, "hasRequestHistory");
        return new SettingsResults(boolean.booleanValue(), boolean2.booleanValue(), boolean3.booleanValue());
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final a0<SettingsResults> getSettingsAsyncData() {
        a0 flatMapped = this.subscribeInteractor.o().flatMap(new kotlinx.coroutines.j0(this));
        n.e(flatMapped, "subscribeInteractor.revenueCatShowResubscribe().flatMap { resubscribe ->\n            subscribeInteractor.revenueCatSubscribed().flatMap { subscribed ->\n                zendeskInteractor.hasRequestHistory().map { hasRequestHistory ->\n                    SettingsResults(\n                        canResubscribe = resubscribe,\n                        premium = subscribed,\n                        hasZendeskRequestHistory = hasRequestHistory\n                    )\n                }\n            }\n        }");
        return flatMapped;
    }

    public static /* synthetic */ g0 e(k3 k3Var, Boolean boolean, Boolean boolean2) {
        return SettingsInteractor.c(k3Var, boolean, boolean2);
    }

    public static /* synthetic */ SettingsResults f(Boolean boolean, Boolean boolean2, Boolean boolean3) {
        return SettingsInteractor.d(boolean, boolean2, boolean3);
    }

    public static /* synthetic */ g0 g(k3 k3Var, Boolean boolean) {
        return SettingsInteractor.b(k3Var, boolean);
    }
}
