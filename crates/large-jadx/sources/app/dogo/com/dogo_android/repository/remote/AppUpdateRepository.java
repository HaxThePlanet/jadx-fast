package app.dogo.com.dogo_android.s.c;

import android.app.Activity;
import app.dogo.com.dogo_android.service.r2;
import com.google.android.play.core.tasks.f;
import f.c.a.f.a.a.a;
import f.c.a.f.a.a.b;
import i.b.a0;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: AppUpdateRepository.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cJ\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cJ\r\u0010\u000f\u001a\u00020\rH\u0000¢\u0006\u0002\u0008\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/repository/remote/AppUpdateRepository;", "", "updateManager", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "remoteConfig", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "currentVersion", "", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;Lapp/dogo/com/dogo_android/service/RemoteConfigService;I)V", "appUpdateInfo", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "isUpdateAvailable", "Lio/reactivex/Single;", "", "isUpdateInProgress", "shouldForceUpdate", "shouldForceUpdate$app_release", "startUpdateFlowForResult", "", "activity", "Landroid/app/Activity;", "requestCode", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public final class AppUpdateRepository {

    /* renamed from: a, reason: from kotlin metadata */
    private final b appUpdateInfo;
    /* renamed from: b, reason: from kotlin metadata */
    private final r2 currentVersion;
    /* renamed from: c, reason: from kotlin metadata */
    private final int remoteConfig;
    /* renamed from: d, reason: from kotlin metadata */
    private a updateManager;
    public g(b bVar, r2 r2Var, int i) {
        n.f(bVar, "updateManager");
        n.f(r2Var, "remoteConfig");
        super();
        this.appUpdateInfo = bVar;
        this.currentVersion = r2Var;
        this.remoteConfig = i;
    }

    private static final a b(g gVar) {
        n.f(gVar, "this$0");
        return (a)f.a(gVar.appUpdateInfo.a());
    }

    /* renamed from: c, reason: from kotlin metadata */
    private static final void startUpdateFlowForResult(g activity, a requestCode) {
        n.f(activity, "this$0");
        n.e(requestCode, "it");
        activity.updateManager = requestCode;
    }

    private static final Boolean d(a aVar) {
        boolean z2 = false;
        boolean z;
        n.f(aVar, "updateInfo");
        if (aVar.c() != 2 || !aVar.a(1)) {
            int i3 = 0;
        }
        return Boolean.valueOf(z2);
    }

    private static final a f(g gVar) {
        n.f(gVar, "this$0");
        return (a)f.a(gVar.appUpdateInfo.a());
    }

    private static final void g(g gVar, a aVar) {
        n.f(gVar, "this$0");
        n.e(aVar, "it");
        gVar.updateManager = aVar;
    }

    private static final Boolean h(a aVar) {
        boolean z = true;
        n.f(aVar, "updateInfo");
        aVar = aVar.c() == 3 ? 1 : 0;
        return (aVar.c() == 3 ? 1 : 0);
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final a0<Boolean> isUpdateAvailable() {
        a0 map = a0.fromCallable(new app.dogo.com.dogo_android.repository.remote.d(this)).doOnSuccess(new app.dogo.com.dogo_android.repository.remote.c(this)).map(app.dogo.com.dogo_android.repository.remote.e.a);
        n.e(map, "fromCallable { Tasks.await(updateManager.appUpdateInfo) }\n            .doOnSuccess { appUpdateInfo = it }\n            .map { updateInfo ->\n                updateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE &&\n                    updateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)\n            }");
        return map;
    }

    public final a0<Boolean> e() {
        a0 map = a0.fromCallable(new app.dogo.com.dogo_android.repository.remote.b(this)).doOnSuccess(new app.dogo.com.dogo_android.repository.remote.f(this)).map(app.dogo.com.dogo_android.repository.remote.a.a);
        n.e(map, "fromCallable { Tasks.await(updateManager.appUpdateInfo) }\n            .doOnSuccess { appUpdateInfo = it }\n            .map { updateInfo ->\n                updateInfo.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS\n            }");
        return map;
    }

    public final boolean o() {
        boolean z = true;
        long l = this.currentVersion.x();
        long l2 = (long)this.remoteConfig;
        int r0 = l > this.remoteConfig ? 1 : 0;
        return (l > this.remoteConfig ? 1 : 0);
    }

    public final void p(Activity activity, int i) {
        n.f(activity, "activity");
        if (this.updateManager == null) {
            throw new IllegalStateException("AppUpdateInfo must be obtained first");
        } else {
            if (this.updateManager == null) {
                n.w("appUpdateInfo");
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            } else {
                this.appUpdateInfo.b(this.updateManager, 1, activity, i);
                return;
            }
        }
    }

    public static /* synthetic */ Boolean i(a aVar) {
        return AppUpdateRepository.h(aVar);
    }

    public static /* synthetic */ a j(g gVar) {
        return AppUpdateRepository.f(gVar);
    }

    public static /* synthetic */ void k(g gVar, a aVar) {
        AppUpdateRepository.startUpdateFlowForResult(gVar, aVar);
    }

    public static /* synthetic */ a l(g gVar) {
        return AppUpdateRepository.b(gVar);
    }

    public static /* synthetic */ Boolean m(a aVar) {
        return AppUpdateRepository.d(aVar);
    }

    public static /* synthetic */ void n(g gVar, a aVar) {
        AppUpdateRepository.g(gVar, aVar);
    }
}
