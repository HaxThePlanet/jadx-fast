package app.dogo.com.dogo_android.s.c;

import android.app.Activity;
import app.dogo.com.dogo_android.service.r2;
import com.google.android.play.core.tasks.f;
import f.c.a.f.a.a.a;
import f.c.a.f.a.a.b;
import i.b.a0;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cJ\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cJ\r\u0010\u000f\u001a\u00020\rH\u0000¢\u0006\u0002\u0008\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/repository/remote/AppUpdateRepository;", "", "updateManager", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "remoteConfig", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "currentVersion", "", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;Lapp/dogo/com/dogo_android/service/RemoteConfigService;I)V", "appUpdateInfo", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "isUpdateAvailable", "Lio/reactivex/Single;", "", "isUpdateInProgress", "shouldForceUpdate", "shouldForceUpdate$app_release", "startUpdateFlowForResult", "", "activity", "Landroid/app/Activity;", "requestCode", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g {

    private final b a;
    private final r2 b;
    private final int c;
    private a d;
    public g(b b, r2 r22, int i3) {
        n.f(b, "updateManager");
        n.f(r22, "remoteConfig");
        super();
        this.a = b;
        this.b = r22;
        this.c = i3;
    }

    private static final a b(app.dogo.com.dogo_android.s.c.g g) {
        n.f(g, "this$0");
        return (a)f.a(g.a.a());
    }

    private static final void c(app.dogo.com.dogo_android.s.c.g g, a a2) {
        n.f(g, "this$0");
        n.e(a2, "it");
        g.d = a2;
    }

    private static final Boolean d(a a) {
        int i;
        Object obj3;
        n.f(a, "updateInfo");
        if (a.c() == 2 && a.a(1)) {
            if (a.a(i)) {
            } else {
                i = 0;
            }
        } else {
        }
        return Boolean.valueOf(i);
    }

    private static final a f(app.dogo.com.dogo_android.s.c.g g) {
        n.f(g, "this$0");
        return (a)f.a(g.a.a());
    }

    private static final void g(app.dogo.com.dogo_android.s.c.g g, a a2) {
        n.f(g, "this$0");
        n.e(a2, "it");
        g.d = a2;
    }

    private static final Boolean h(a a) {
        int obj1;
        n.f(a, "updateInfo");
        obj1 = a.c() == 3 ? 1 : 0;
        return Boolean.valueOf(obj1);
    }

    public static Boolean i(a a) {
        return g.h(a);
    }

    public static a j(app.dogo.com.dogo_android.s.c.g g) {
        return g.f(g);
    }

    public static void k(app.dogo.com.dogo_android.s.c.g g, a a2) {
        g.c(g, a2);
    }

    public static a l(app.dogo.com.dogo_android.s.c.g g) {
        return g.b(g);
    }

    public static Boolean m(a a) {
        return g.d(a);
    }

    public static void n(app.dogo.com.dogo_android.s.c.g g, a a2) {
        g.g(g, a2);
    }

    public final a0<Boolean> a() {
        d dVar = new d(this);
        c cVar = new c(this);
        a0 a0Var = a0.fromCallable(dVar).doOnSuccess(cVar).map(e.a);
        n.e(a0Var, "fromCallable { Tasks.await(updateManager.appUpdateInfo) }\n            .doOnSuccess { appUpdateInfo = it }\n            .map { updateInfo ->\n                updateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE &&\n                    updateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)\n            }");
        return a0Var;
    }

    public final a0<Boolean> e() {
        b bVar = new b(this);
        f fVar = new f(this);
        a0 a0Var = a0.fromCallable(bVar).doOnSuccess(fVar).map(a.a);
        n.e(a0Var, "fromCallable { Tasks.await(updateManager.appUpdateInfo) }\n            .doOnSuccess { appUpdateInfo = it }\n            .map { updateInfo ->\n                updateInfo.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS\n            }");
        return a0Var;
    }

    public final boolean o() {
        int i;
        i = Long.compare(l, l2) > 0 ? 1 : 0;
        return i;
    }

    public final void p(Activity activity, int i2) {
        n.f(activity, "activity");
        a aVar = this.d;
        if (aVar == null) {
        } else {
            if (aVar == null) {
            } else {
                this.a.b(aVar, 1, activity, i2);
            }
            n.w("appUpdateInfo");
            throw 0;
        }
        IllegalStateException obj4 = new IllegalStateException("AppUpdateInfo must be obtained first");
        throw obj4;
    }
}
