package app.dogo.com.dogo_android.service;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import app.dogo.com.dogo_android.j.d;
import app.dogo.com.dogo_android.j.e;
import app.dogo.com.dogo_android.s.a.n3;
import app.dogo.com.dogo_android.s.b.a1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.util.t;
import app.dogo.com.dogo_android.util.t.a;
import app.dogo.com.dogo_android.w.o3;
import com.appsflyer.AppsFlyerLib;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.w;
import m.a.c.b;

/* compiled from: App.kt */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/service/App;", "Landroid/app/Application;", "()V", "onCreate", "", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class App extends Application {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final App.a INSTANCE = new App$a(0);
    public static g2 a;
    public static Context b;
    public static App c;

    @Metadata(d1 = "\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010r\u001a\u00020sH\u0007J\u0010\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020wH\u0007R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR$\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u000c\u0010\u0002\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u0013\u0010\u0002\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u00198FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001a\u0010\u0002\u001a\u0004\u0008\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001e8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001f\u0010\u0002\u001a\u0004\u0008 \u0010!R\u001a\u0010\"\u001a\u00020#8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008$\u0010\u0002\u001a\u0004\u0008%\u0010&R\u001a\u0010'\u001a\u00020(8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008)\u0010\u0002\u001a\u0004\u0008*\u0010+R\u001a\u0010,\u001a\u00020-8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008.\u0010\u0002\u001a\u0004\u0008/\u00100R\u001a\u00101\u001a\u0002028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u00083\u0010\u0002\u001a\u0004\u00084\u00105R\u001a\u00106\u001a\u0002078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u00088\u0010\u0002\u001a\u0004\u00089\u0010:R\u001a\u0010;\u001a\u00020<8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008=\u0010\u0002\u001a\u0004\u0008>\u0010?R\u001a\u0010@\u001a\u00020A8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008B\u0010\u0002\u001a\u0004\u0008C\u0010DR\u001a\u0010E\u001a\u00020F8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008G\u0010\u0002\u001a\u0004\u0008H\u0010IR\u001a\u0010J\u001a\u00020K8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008L\u0010\u0002\u001a\u0004\u0008M\u0010NR\u001a\u0010O\u001a\u00020P8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008Q\u0010\u0002\u001a\u0004\u0008R\u0010SR\u001a\u0010T\u001a\u00020U8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008V\u0010\u0002\u001a\u0004\u0008W\u0010XR\u001a\u0010Y\u001a\u00020Z8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008[\u0010\u0002\u001a\u0004\u0008\\\u0010]R\u001a\u0010^\u001a\u00020_8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008`\u0010\u0002\u001a\u0004\u0008a\u0010bR\u001a\u0010c\u001a\u00020d8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008e\u0010\u0002\u001a\u0004\u0008f\u0010gR\u001a\u0010h\u001a\u00020i8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008j\u0010\u0002\u001a\u0004\u0008k\u0010lR\u001a\u0010m\u001a\u00020n8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008o\u0010\u0002\u001a\u0004\u0008p\u0010q¨\u0006x", d2 = {"Lapp/dogo/com/dogo_android/service/App$Companion;", "", "()V", "app", "Lapp/dogo/com/dogo_android/service/App;", "getApp$annotations", "getApp", "()Lapp/dogo/com/dogo_android/service/App;", "setApp", "(Lapp/dogo/com/dogo_android/service/App;)V", "appContext", "Landroid/content/Context;", "getAppContext$annotations", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "appIntentServiceManager", "Lapp/dogo/com/dogo_android/service/AppIntentServiceManager;", "getAppIntentServiceManager$annotations", "getAppIntentServiceManager", "()Lapp/dogo/com/dogo_android/service/AppIntentServiceManager;", "setAppIntentServiceManager", "(Lapp/dogo/com/dogo_android/service/AppIntentServiceManager;)V", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "getAuthService$annotations", "getAuthService", "()Lapp/dogo/com/dogo_android/service/AuthService;", "cloudFunctions", "Lapp/dogo/com/dogo_android/service/CloudFunctionsService;", "getCloudFunctions$annotations", "getCloudFunctions", "()Lapp/dogo/com/dogo_android/service/CloudFunctionsService;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "getConnectivityService$annotations", "getConnectivityService", "()Lapp/dogo/com/dogo_android/service/ConnectivityService;", "content", "Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;", "getContent$annotations", "getContent", "()Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;", "dynamicLinkService", "Lapp/dogo/com/dogo_android/service/DynamicLinkService;", "getDynamicLinkService$annotations", "getDynamicLinkService", "()Lapp/dogo/com/dogo_android/service/DynamicLinkService;", "fireBaseDBService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "getFireBaseDBService$annotations", "getFireBaseDBService", "()Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "firebaseStorageService", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService;", "getFirebaseStorageService$annotations", "getFirebaseStorageService", "()Lapp/dogo/com/dogo_android/service/FireBaseStorageService;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "getFirestoreService$annotations", "getFirestoreService", "()Lapp/dogo/com/dogo_android/service/FirestoreService;", "notificationService", "Lapp/dogo/com/dogo_android/service/NotificationService;", "getNotificationService$annotations", "getNotificationService", "()Lapp/dogo/com/dogo_android/service/NotificationService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "getPreferenceService$annotations", "getPreferenceService", "()Lapp/dogo/com/dogo_android/service/PreferenceService;", "rateItService", "Lapp/dogo/com/dogo_android/service/RateItService;", "getRateItService$annotations", "getRateItService", "()Lapp/dogo/com/dogo_android/service/RateItService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "getRemoteConfigService$annotations", "getRemoteConfigService", "()Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "stateManager", "Lapp/dogo/com/dogo_android/service/StateManager;", "getStateManager$annotations", "getStateManager", "()Lapp/dogo/com/dogo_android/service/StateManager;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "getStorageService$annotations", "getStorageService", "()Lapp/dogo/com/dogo_android/service/StorageService;", "subscriptionInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "getSubscriptionInteractor$annotations", "getSubscriptionInteractor", "()Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "getTracker$annotations", "getTracker", "()Lapp/dogo/com/dogo_android/tracking/Tracker;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "getUserRepository$annotations", "getUserRepository", "()Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "getUtilities$annotations", "getUtilities", "()Lapp/dogo/com/dogo_android/service/Utilities;", "isTestBuild", "", "updateContextLocale", "", "selectedLocale", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final App isTestBuild() {
            app.dogo.com.dogo_android.service.App app = App.c;
            if (App.c == null) {
                n.w("app");
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            } else {
                return App.c;
            }
        }

        public final Context b() {
            Context context = App.b;
            if (App.b == null) {
                n.w("appContext");
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            } else {
                return App.b;
            }
        }

        public final h2 c() {
            final m.a.c.j.a aVar2 = null;
            return (AuthService)a.a(isTestBuild()).c(c0.b(AuthService.class), aVar2, aVar2);
        }

        public final i2 d() {
            final m.a.c.j.a aVar2 = null;
            return (CloudFunctionsService)a.a(isTestBuild()).c(c0.b(CloudFunctionsService.class), aVar2, aVar2);
        }

        public final j2 e() {
            final m.a.c.j.a aVar2 = null;
            return (ConnectivityService)a.a(isTestBuild()).c(c0.b(ConnectivityService.class), aVar2, aVar2);
        }

        public final a1 f() {
            final m.a.c.j.a aVar2 = null;
            return (ChallengeLocalRepository)a.a(isTestBuild()).c(c0.b(ChallengeLocalRepository.class), aVar2, aVar2);
        }

        public final k2 g() {
            final m.a.c.j.a aVar2 = null;
            return (DynamicLinkService)a.a(isTestBuild()).c(c0.b(DynamicLinkService.class), aVar2, aVar2);
        }

        public final u2 h() {
            final m.a.c.j.a aVar2 = null;
            return (UserLocalCacheService)a.a(isTestBuild()).c(c0.b(UserLocalCacheService.class), aVar2, aVar2);
        }

        public final l2 i() {
            final m.a.c.j.a aVar2 = null;
            return (FireBaseStorageService)a.a(isTestBuild()).c(c0.b(FireBaseStorageService.class), aVar2, aVar2);
        }

        public final m2 j() {
            final m.a.c.j.a aVar2 = null;
            return (FirestoreService)a.a(isTestBuild()).c(c0.b(FirestoreService.class), aVar2, aVar2);
        }

        public final o2 k() {
            final m.a.c.j.a aVar2 = null;
            return (NotificationService)a.a(isTestBuild()).c(c0.b(NotificationService.class), aVar2, aVar2);
        }

        public final p2 l() {
            final m.a.c.j.a aVar2 = null;
            return (PreferenceService)a.a(isTestBuild()).c(c0.b(PreferenceService.class), aVar2, aVar2);
        }

        public final q2 m() {
            final m.a.c.j.a aVar2 = null;
            return (RateItService)a.a(isTestBuild()).c(c0.b(RateItService.class), aVar2, aVar2);
        }

        public final r2 n() {
            final m.a.c.j.a aVar2 = null;
            return (RemoteConfigService)a.a(isTestBuild()).c(c0.b(RemoteConfigService.class), aVar2, aVar2);
        }

        public final s2 o() {
            final m.a.c.j.a aVar2 = null;
            return (StateManager)a.a(isTestBuild()).c(c0.b(StateManager.class), aVar2, aVar2);
        }

        public final t2 p() {
            final m.a.c.j.a aVar2 = null;
            return (StorageService)a.a(isTestBuild()).c(c0.b(StorageService.class), aVar2, aVar2);
        }

        public final n3 q() {
            final m.a.c.j.a aVar2 = null;
            return (SubscribeInteractor)a.a(isTestBuild()).c(c0.b(SubscribeInteractor.class), aVar2, aVar2);
        }

        public final o3 r() {
            final m.a.c.j.a aVar2 = null;
            return (Tracker)a.a(isTestBuild()).c(c0.b(Tracker.class), aVar2, aVar2);
        }

        public final p1 s() {
            final m.a.c.j.a aVar2 = null;
            return (UserRepository)a.a(isTestBuild()).c(c0.b(UserRepository.class), aVar2, aVar2);
        }

        public final v2 t() {
            final m.a.c.j.a aVar2 = null;
            return (Utilities)a.a(isTestBuild()).c(c0.b(Utilities.class), aVar2, aVar2);
        }

        public final boolean u() {
            boolean z;
            boolean z2 = false;
            Object obj = null;
            String str;
            String str2;
            z2 = false;
            if (!c().C()) {
                obj = null;
                str = "7.22.1";
                str2 = "-QA";
                if (l.w(str, str2, false, 2, obj)) {
                    int i2 = 1;
                }
            }
            return z2;
        }

        /* renamed from: v, reason: from kotlin metadata */
        public final void updateContextLocale(App selectedLocale) {
            n.f(selectedLocale, "<set-?>");
            App.c = selectedLocale;
        }

        public final void w(Context context) {
            n.f(context, "<set-?>");
            App.b = context;
        }

        public final void x(g2 g2Var) {
            n.f(g2Var, "<set-?>");
            App.a = g2Var;
        }

        public final void y(String str) {
            n.f(str, "selectedLocale");
            w(MyContextWrapper.Companion.b(b(), LocaleService.b(str)));
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Lorg/koin/core/KoinApplication;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.l<b, w> {
        @Override // kotlin.d0.d.p
        public final void a(b bVar) {
            n.f(bVar, "$this$startKoin");
            a.a(bVar, App.this);
            m.a.c.h.a[] arr = new a[6];
            bVar.d(p.j(new a[] { app.dogo.com.dogo_android.di.d.a(), a.a(), a.a(), app.dogo.com.dogo_android.di.g.a(), app.dogo.com.dogo_android.di.e.a(), app.dogo.com.dogo_android.di.f.a() }));
        }

        b() {
            super(1);
        }
    }
    private static final void s(Throwable th) {
        int i = 0;
        if (th instanceof UndeliverableException) {
            a.k(th.getCause(), "Undeliverable exception received", new Object[i]);
            return;
        }
        a.e(th, "RxJavaPlugin error", new Object[i]);
    }

    @Override // android.app.Application
    public void onCreate() throws android.content.res.Resources.NotFoundException {
        super.onCreate();
        org.koin.core.context.a.a(new App.b(this));
        m.a.c.j.a aVar3 = null;
        Object obj = a.a(this).c(c0.b(f.class), aVar3, aVar3);
        obj.x(this, getResources().getString(2131886132));
        obj.p(this);
        a.b(this, true);
        a.h(new CrashlyticsLogger());
        app.dogo.com.dogo_android.service.App.a iNSTANCE2 = App.INSTANCE;
        iNSTANCE2.updateContextLocale(this);
        Context applicationContext = getApplicationContext();
        n.e(applicationContext, "applicationContext");
        iNSTANCE2.w(MyContextWrapper.Companion.b(applicationContext, LocaleService.b(iNSTANCE2.l().W())));
        iNSTANCE2.x(new AppIntentServiceManager(iNSTANCE2.b(), iNSTANCE2.p()));
        iNSTANCE2.k().d("reminders_id", getString(2131887307));
        iNSTANCE2.k().d("announcement_id", getString(2131886961));
        AppsFlyerLib.getInstance().init(getString(2131886140), iNSTANCE2.r(), this);
        AppsFlyerLib.getInstance().setDebugLog(false);
        AppsFlyerLib.getInstance().start(this);
        a.C(a.a);
    }


    /* renamed from: a, reason: from kotlin metadata */
    public static final Context onCreate() {
        return App.INSTANCE.b();
    }

    public static final h2 b() {
        return App.INSTANCE.c();
    }

    public static final i2 c() {
        return App.INSTANCE.d();
    }

    public static final j2 d() {
        return App.INSTANCE.e();
    }

    public static final a1 e() {
        return App.INSTANCE.f();
    }

    public static final k2 f() {
        return App.INSTANCE.g();
    }

    public static final u2 g() {
        return App.INSTANCE.h();
    }

    public static final m2 h() {
        return App.INSTANCE.j();
    }

    public static final p2 i() {
        return App.INSTANCE.l();
    }

    public static final q2 j() {
        return App.INSTANCE.m();
    }

    public static final r2 k() {
        return App.INSTANCE.n();
    }

    public static final s2 l() {
        return App.INSTANCE.o();
    }

    public static final t2 m() {
        return App.INSTANCE.p();
    }

    public static final n3 n() {
        return App.INSTANCE.q();
    }

    public static final o3 o() {
        return App.INSTANCE.r();
    }

    public static final v2 p() {
        return App.INSTANCE.t();
    }

    public static final boolean q() {
        return App.INSTANCE.u();
    }

    public static /* synthetic */ void r(Throwable th) {
        App.s(th);
    }
}
