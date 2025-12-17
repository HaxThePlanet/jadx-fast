package app.dogo.com.dogo_android.service;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import app.dogo.android.network.f.a;
import app.dogo.com.dogo_android.j.d;
import app.dogo.com.dogo_android.j.e;
import app.dogo.com.dogo_android.j.f;
import app.dogo.com.dogo_android.j.g;
import app.dogo.com.dogo_android.s.a.n3;
import app.dogo.com.dogo_android.s.b.a1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.util.t;
import app.dogo.com.dogo_android.util.t.a;
import app.dogo.com.dogo_android.w.n;
import app.dogo.com.dogo_android.w.o3;
import com.amplitude.api.f;
import com.appsflyer.AppsFlyerLib;
import e.a.a.a.a.a;
import i.b.p0.a;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.k0.l;
import kotlin.w;
import kotlin.y.p;
import m.a.a.b.a.a;
import m.a.a.b.b.a;
import m.a.c.b;
import m.a.c.d.a;
import m.a.c.l.a;
import n.a.a;
import net.time4j.e1.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/service/App;", "Landroid/app/Application;", "()V", "onCreate", "", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class App extends Application {

    public static final app.dogo.com.dogo_android.service.App.a Companion;
    public static app.dogo.com.dogo_android.service.g2 a;
    public static Context b;
    public static app.dogo.com.dogo_android.service.App c;

    @Metadata(d1 = "\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010r\u001a\u00020sH\u0007J\u0010\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020wH\u0007R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR$\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u000c\u0010\u0002\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u0013\u0010\u0002\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u00198FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001a\u0010\u0002\u001a\u0004\u0008\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001e8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001f\u0010\u0002\u001a\u0004\u0008 \u0010!R\u001a\u0010\"\u001a\u00020#8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008$\u0010\u0002\u001a\u0004\u0008%\u0010&R\u001a\u0010'\u001a\u00020(8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008)\u0010\u0002\u001a\u0004\u0008*\u0010+R\u001a\u0010,\u001a\u00020-8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008.\u0010\u0002\u001a\u0004\u0008/\u00100R\u001a\u00101\u001a\u0002028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u00083\u0010\u0002\u001a\u0004\u00084\u00105R\u001a\u00106\u001a\u0002078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u00088\u0010\u0002\u001a\u0004\u00089\u0010:R\u001a\u0010;\u001a\u00020<8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008=\u0010\u0002\u001a\u0004\u0008>\u0010?R\u001a\u0010@\u001a\u00020A8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008B\u0010\u0002\u001a\u0004\u0008C\u0010DR\u001a\u0010E\u001a\u00020F8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008G\u0010\u0002\u001a\u0004\u0008H\u0010IR\u001a\u0010J\u001a\u00020K8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008L\u0010\u0002\u001a\u0004\u0008M\u0010NR\u001a\u0010O\u001a\u00020P8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008Q\u0010\u0002\u001a\u0004\u0008R\u0010SR\u001a\u0010T\u001a\u00020U8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008V\u0010\u0002\u001a\u0004\u0008W\u0010XR\u001a\u0010Y\u001a\u00020Z8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008[\u0010\u0002\u001a\u0004\u0008\\\u0010]R\u001a\u0010^\u001a\u00020_8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008`\u0010\u0002\u001a\u0004\u0008a\u0010bR\u001a\u0010c\u001a\u00020d8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008e\u0010\u0002\u001a\u0004\u0008f\u0010gR\u001a\u0010h\u001a\u00020i8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008j\u0010\u0002\u001a\u0004\u0008k\u0010lR\u001a\u0010m\u001a\u00020n8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008o\u0010\u0002\u001a\u0004\u0008p\u0010q¨\u0006x", d2 = {"Lapp/dogo/com/dogo_android/service/App$Companion;", "", "()V", "app", "Lapp/dogo/com/dogo_android/service/App;", "getApp$annotations", "getApp", "()Lapp/dogo/com/dogo_android/service/App;", "setApp", "(Lapp/dogo/com/dogo_android/service/App;)V", "appContext", "Landroid/content/Context;", "getAppContext$annotations", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "appIntentServiceManager", "Lapp/dogo/com/dogo_android/service/AppIntentServiceManager;", "getAppIntentServiceManager$annotations", "getAppIntentServiceManager", "()Lapp/dogo/com/dogo_android/service/AppIntentServiceManager;", "setAppIntentServiceManager", "(Lapp/dogo/com/dogo_android/service/AppIntentServiceManager;)V", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "getAuthService$annotations", "getAuthService", "()Lapp/dogo/com/dogo_android/service/AuthService;", "cloudFunctions", "Lapp/dogo/com/dogo_android/service/CloudFunctionsService;", "getCloudFunctions$annotations", "getCloudFunctions", "()Lapp/dogo/com/dogo_android/service/CloudFunctionsService;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "getConnectivityService$annotations", "getConnectivityService", "()Lapp/dogo/com/dogo_android/service/ConnectivityService;", "content", "Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;", "getContent$annotations", "getContent", "()Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;", "dynamicLinkService", "Lapp/dogo/com/dogo_android/service/DynamicLinkService;", "getDynamicLinkService$annotations", "getDynamicLinkService", "()Lapp/dogo/com/dogo_android/service/DynamicLinkService;", "fireBaseDBService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "getFireBaseDBService$annotations", "getFireBaseDBService", "()Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "firebaseStorageService", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService;", "getFirebaseStorageService$annotations", "getFirebaseStorageService", "()Lapp/dogo/com/dogo_android/service/FireBaseStorageService;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "getFirestoreService$annotations", "getFirestoreService", "()Lapp/dogo/com/dogo_android/service/FirestoreService;", "notificationService", "Lapp/dogo/com/dogo_android/service/NotificationService;", "getNotificationService$annotations", "getNotificationService", "()Lapp/dogo/com/dogo_android/service/NotificationService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "getPreferenceService$annotations", "getPreferenceService", "()Lapp/dogo/com/dogo_android/service/PreferenceService;", "rateItService", "Lapp/dogo/com/dogo_android/service/RateItService;", "getRateItService$annotations", "getRateItService", "()Lapp/dogo/com/dogo_android/service/RateItService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "getRemoteConfigService$annotations", "getRemoteConfigService", "()Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "stateManager", "Lapp/dogo/com/dogo_android/service/StateManager;", "getStateManager$annotations", "getStateManager", "()Lapp/dogo/com/dogo_android/service/StateManager;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "getStorageService$annotations", "getStorageService", "()Lapp/dogo/com/dogo_android/service/StorageService;", "subscriptionInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "getSubscriptionInteractor$annotations", "getSubscriptionInteractor", "()Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "getTracker$annotations", "getTracker", "()Lapp/dogo/com/dogo_android/tracking/Tracker;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "getUserRepository$annotations", "getUserRepository", "()Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "getUtilities$annotations", "getUtilities", "()Lapp/dogo/com/dogo_android/service/Utilities;", "isTestBuild", "", "updateContextLocale", "", "selectedLocale", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final app.dogo.com.dogo_android.service.App a() {
            app.dogo.com.dogo_android.service.App app = App.c;
            if (app == null) {
            } else {
                return app;
            }
            n.w("app");
            throw 0;
        }

        public final Context b() {
            Context context = App.b;
            if (context == null) {
            } else {
                return context;
            }
            n.w("appContext");
            throw 0;
        }

        public final app.dogo.com.dogo_android.service.h2 c() {
            final int i = 0;
            return (h2)a.a(a()).c(c0.b(h2.class), i, i);
        }

        public final app.dogo.com.dogo_android.service.i2 d() {
            final int i = 0;
            return (i2)a.a(a()).c(c0.b(i2.class), i, i);
        }

        public final app.dogo.com.dogo_android.service.j2 e() {
            final int i = 0;
            return (j2)a.a(a()).c(c0.b(j2.class), i, i);
        }

        public final a1 f() {
            final int i = 0;
            return (a1)a.a(a()).c(c0.b(a1.class), i, i);
        }

        public final app.dogo.com.dogo_android.service.k2 g() {
            final int i = 0;
            return (k2)a.a(a()).c(c0.b(k2.class), i, i);
        }

        public final app.dogo.com.dogo_android.service.u2 h() {
            final int i = 0;
            return (u2)a.a(a()).c(c0.b(u2.class), i, i);
        }

        public final app.dogo.com.dogo_android.service.l2 i() {
            final int i = 0;
            return (l2)a.a(a()).c(c0.b(l2.class), i, i);
        }

        public final app.dogo.com.dogo_android.service.m2 j() {
            final int i = 0;
            return (m2)a.a(a()).c(c0.b(m2.class), i, i);
        }

        public final app.dogo.com.dogo_android.service.o2 k() {
            final int i = 0;
            return (o2)a.a(a()).c(c0.b(o2.class), i, i);
        }

        public final app.dogo.com.dogo_android.service.p2 l() {
            final int i = 0;
            return (p2)a.a(a()).c(c0.b(p2.class), i, i);
        }

        public final app.dogo.com.dogo_android.service.q2 m() {
            final int i = 0;
            return (q2)a.a(a()).c(c0.b(q2.class), i, i);
        }

        public final app.dogo.com.dogo_android.service.r2 n() {
            final int i = 0;
            return (r2)a.a(a()).c(c0.b(r2.class), i, i);
        }

        public final app.dogo.com.dogo_android.service.s2 o() {
            final int i = 0;
            return (s2)a.a(a()).c(c0.b(s2.class), i, i);
        }

        public final app.dogo.com.dogo_android.service.t2 p() {
            final int i = 0;
            return (t2)a.a(a()).c(c0.b(t2.class), i, i);
        }

        public final n3 q() {
            final int i = 0;
            return (n3)a.a(a()).c(c0.b(n3.class), i, i);
        }

        public final o3 r() {
            final int i = 0;
            return (o3)a.a(a()).c(c0.b(o3.class), i, i);
        }

        public final p1 s() {
            final int i = 0;
            return (p1)a.a(a()).c(c0.b(p1.class), i, i);
        }

        public final app.dogo.com.dogo_android.service.v2 t() {
            final int i = 0;
            return (v2)a.a(a()).c(c0.b(v2.class), i, i);
        }

        public final boolean u() {
            boolean z;
            int i2;
            int i;
            String str;
            String str2;
            if (!c().C()) {
                if (l.w("7.22.1", "-QA", false, 2, 0)) {
                    i2 = 1;
                }
            } else {
            }
            return i2;
        }

        public final void v(app.dogo.com.dogo_android.service.App app) {
            n.f(app, "<set-?>");
            App.c = app;
        }

        public final void w(Context context) {
            n.f(context, "<set-?>");
            App.b = context;
        }

        public final void x(app.dogo.com.dogo_android.service.g2 g2) {
            n.f(g2, "<set-?>");
            App.a = g2;
        }

        public final void y(String string) {
            n.f(string, "selectedLocale");
            w(t.Companion.b(b(), n2.b(string)));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Lorg/koin/core/KoinApplication;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<b, w> {

        final app.dogo.com.dogo_android.service.App this$0;
        b(app.dogo.com.dogo_android.service.App app) {
            this.this$0 = app;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(b b) {
            n.f(b, "$this$startKoin");
            a.a(b, this.this$0);
            m.a.c.h.a[] arr = new a[6];
            b.d(p.j(d.a(), a.a(), a.a(), g.a(), e.a(), f.a()));
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((b)object);
            return w.a;
        }
    }
    static {
        App.a aVar = new App.a(0);
        App.Companion = aVar;
    }

    public static final Context a() {
        return App.Companion.b();
    }

    public static final app.dogo.com.dogo_android.service.h2 b() {
        return App.Companion.c();
    }

    public static final app.dogo.com.dogo_android.service.i2 c() {
        return App.Companion.d();
    }

    public static final app.dogo.com.dogo_android.service.j2 d() {
        return App.Companion.e();
    }

    public static final a1 e() {
        return App.Companion.f();
    }

    public static final app.dogo.com.dogo_android.service.k2 f() {
        return App.Companion.g();
    }

    public static final app.dogo.com.dogo_android.service.u2 g() {
        return App.Companion.h();
    }

    public static final app.dogo.com.dogo_android.service.m2 h() {
        return App.Companion.j();
    }

    public static final app.dogo.com.dogo_android.service.p2 i() {
        return App.Companion.l();
    }

    public static final app.dogo.com.dogo_android.service.q2 j() {
        return App.Companion.m();
    }

    public static final app.dogo.com.dogo_android.service.r2 k() {
        return App.Companion.n();
    }

    public static final app.dogo.com.dogo_android.service.s2 l() {
        return App.Companion.o();
    }

    public static final app.dogo.com.dogo_android.service.t2 m() {
        return App.Companion.p();
    }

    public static final n3 n() {
        return App.Companion.q();
    }

    public static final o3 o() {
        return App.Companion.r();
    }

    public static final app.dogo.com.dogo_android.service.v2 p() {
        return App.Companion.t();
    }

    public static final boolean q() {
        return App.Companion.u();
    }

    public static void r(Throwable throwable) {
        App.s(throwable);
    }

    private static final void s(Throwable throwable) {
        int i = 0;
        if (throwable instanceof UndeliverableException != null) {
            a.k((UndeliverableException)throwable.getCause(), "Undeliverable exception received", new Object[i]);
        }
        a.e(throwable, "RxJavaPlugin error", new Object[i]);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        App.b bVar = new App.b(this);
        a.a(bVar);
        int i3 = 0;
        Object obj = a.a(this).c(c0.b(f.class), i3, i3);
        (f)obj.x(this, getResources().getString(2131886132));
        obj.p(this);
        a.b(this, true);
        n nVar = new n();
        a.h(nVar);
        app.dogo.com.dogo_android.service.App.a companion = App.Companion;
        companion.v(this);
        Context applicationContext = getApplicationContext();
        n.e(applicationContext, "applicationContext");
        companion.w(t.Companion.b(applicationContext, n2.b(companion.l().W())));
        g2 g2Var = new g2(companion.b(), companion.p());
        companion.x(g2Var);
        companion.k().d("reminders_id", getString(2131887307));
        companion.k().d("announcement_id", getString(2131886961));
        AppsFlyerLib.getInstance().init(getString(2131886140), companion.r(), this);
        AppsFlyerLib.getInstance().setDebugLog(false);
        AppsFlyerLib.getInstance().start(this);
        a.C(a.a);
    }
}
