package app.dogo.com.dogo_android.a0;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.m;
import app.dogo.com.dogo_android.repository.domain.DogoIntent;
import app.dogo.com.dogo_android.repository.domain.SplashDataHolder;
import app.dogo.com.dogo_android.s.a.a2;
import app.dogo.com.dogo_android.s.a.d3;
import app.dogo.com.dogo_android.s.b.l1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.w.b2;
import app.dogo.com.dogo_android.w.e0;
import app.dogo.com.dogo_android.w.j1;
import app.dogo.com.dogo_android.w.k1;
import app.dogo.com.dogo_android.w.o2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.o3.b;
import app.dogo.com.dogo_android.w.q3;
import app.dogo.com.dogo_android.w.u2;
import com.google.android.gms.common.e;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;
import kotlin.Metadata;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.r1;
import kotlinx.coroutines.u0;
import kotlinx.coroutines.w2;

/* compiled from: SplashScreenViewModel.kt */
@Metadata(d1 = "\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000e\n\u0002\u0008\u0008\u0018\u0000 Q2\u00020\u0001:\u0001QBw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010\u001eJ\u0011\u0010'\u001a\u00020!H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0011\u0010)\u001a\u00020*H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J\u001b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010/J\u0011\u00100\u001a\u00020!H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0012\u00101\u001a\u0004\u0018\u00010,2\u0006\u00102\u001a\u00020.H\u0002J\u0018\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u000207H\u0002J\u0006\u00108\u001a\u00020*J\u0011\u00109\u001a\u00020*H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0010\u0010:\u001a\u0002042\u0006\u0010;\u001a\u000204H\u0002J\u000e\u0010<\u001a\u00020*2\u0006\u0010-\u001a\u00020.J\u000e\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020?J0\u0010@\u001a\u00020*2\u0008\u0010A\u001a\u0004\u0018\u00010,2\u0008\u0010B\u001a\u0004\u0018\u00010,2\u0008\u0010C\u001a\u0004\u0018\u00010,2\u0008\u0010D\u001a\u0004\u0018\u00010,H\u0002J\u001e\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u0002042\u0006\u0010G\u001a\u0002042\u0006\u00106\u001a\u000207J\u0012\u0010H\u001a\u00020*2\u0008\u0010I\u001a\u0004\u0018\u00010JH\u0002J\u000e\u0010K\u001a\u00020*2\u0006\u0010L\u001a\u000204J\u001c\u0010M\u001a\u00020*2\u0008\u0010N\u001a\u0004\u0018\u00010J2\u0008\u0010O\u001a\u0004\u0018\u00010JH\u0002J\u0012\u0010P\u001a\u00020*2\u0008\u0010O\u001a\u0004\u0018\u00010JH\u0002R\u0017\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020!0 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\u0008\u0012\u0004\u0012\u00020%0 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006R", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/SplashScreenViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "deferredLinkInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DeferredLinkInteractor;", "appUpdateRepository", "Lapp/dogo/com/dogo_android/repository/remote/AppUpdateRepository;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "cacheUpdaterInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/CacheUpdaterInteractor;", "isDogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "firebasePerformance", "Lcom/google/firebase/perf/FirebasePerformance;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "dispatcher", "Lkotlin/coroutines/CoroutineContext;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/interactor/DeferredLinkInteractor;Lapp/dogo/com/dogo_android/repository/remote/AppUpdateRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/CacheUpdaterInteractor;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lcom/google/firebase/perf/FirebasePerformance;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;Lkotlin/coroutines/CoroutineContext;)V", "appUpdateAvailable", "Lcom/hadilq/liveevent/LiveEvent;", "", "getAppUpdateAvailable", "()Lcom/hadilq/liveevent/LiveEvent;", "nextScreenEvent", "Lapp/dogo/com/dogo_android/repository/domain/SplashDataHolder;", "getNextScreenEvent", "checkIsAppUpdateAvailable", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchUserData", "", "getDeferredUriAndTrackAppOpen", "Landroid/net/Uri;", "dogoIntent", "Lapp/dogo/com/dogo_android/repository/domain/DogoIntent;", "(Lapp/dogo/com/dogo_android/repository/domain/DogoIntent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDogPremium", "parseAndTrackLaunchIntent", "appLaunchIntent", "pxToDp", "", "px", "density", "", "refreshAppUpdateIfNeeded", "refreshRemoteConfig", "roundToNearest10", "number", "startSplashDataUpdate", "startUpdateFlowForResult", "activity", "Landroid/app/Activity;", "trackAppOpen", "referrerUri", "firebaseDeferredLinkUri", "facebookDeferredLinkUri", "uriFromAppLaunchIntent", "trackDeviceDisplayMetrics", "height", "width", "trackFcmNotificationClick", "messageId", "", "trackGoogleApiErrorPopup", "status", "trackNotificationClick", "type", "notificationId", "trackTrainingNotificationClick", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final class SplashScreenViewModel extends s {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final f.a INSTANCE = new f$a(0);
    private final p2 a;
    /* renamed from: b, reason: from kotlin metadata */
    private final h2 appUpdateRepository;
    /* renamed from: c, reason: from kotlin metadata */
    private final o3 authService;
    /* renamed from: d, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.s.a.c2 cacheUpdaterInteractor;
    /* renamed from: e, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.s.c.g connectivityService;
    /* renamed from: f, reason: from kotlin metadata */
    private final r2 deferredLinkInteractor;
    /* renamed from: g, reason: from kotlin metadata */
    private final a2 dispatcher;
    /* renamed from: h, reason: from kotlin metadata */
    private final d3 firebasePerformance;
    /* renamed from: i, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.service.v2 isDogPremiumInteractor;
    private final j2 j;
    /* renamed from: k, reason: from kotlin metadata */
    private final FirebasePerformance preferenceService;
    /* renamed from: l, reason: from kotlin metadata */
    private final p1 reminderRepository;
    /* renamed from: m, reason: from kotlin metadata */
    private final l1 remoteConfigService;
    /* renamed from: n, reason: from kotlin metadata */
    private final kotlin.b0.g tracker;
    /* renamed from: o, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> userRepository;
    /* renamed from: p, reason: from kotlin metadata */
    private final f.d.a.a<SplashDataHolder> utilities;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/SplashScreenViewModel$Companion;", "", "()V", "APP_UPDATE_REQUEST_CODE", "", "TRAINING_REMINDER_NOTIFICATION_CLICK_PREFIX", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel", f = "SplashScreenViewModel.kt", l = 228, m = "checkIsAppUpdateAvailable")
    static final class b extends kotlin.b0.k.a.d {

        int label;
        /* synthetic */ Object result;
        b(kotlin.b0.d<? super f.b> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return f.this.z(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel", f = "SplashScreenViewModel.kt", l = 121, m = "fetchUserData")
    static final class d extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        d(kotlin.b0.d<? super f.d> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return f.this.getDeferredUriAndTrackAppOpen(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel", f = "SplashScreenViewModel.kt", l = 259, m = "isDogPremium")
    static final class g extends kotlin.b0.k.a.d {

        int label;
        /* synthetic */ Object result;
        g(kotlin.b0.d<? super f.g> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return f.this.parseAndTrackLaunchIntent(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel", f = "SplashScreenViewModel.kt", l = 181, m = "refreshRemoteConfig")
    static final class j extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        j(kotlin.b0.d<? super f.j> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return f.this.startSplashDataUpdate(this);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel$checkIsAppUpdateAvailable$2", f = "SplashScreenViewModel.kt", l = {}, m = "invokeSuspend")
    static final class c extends kotlin.b0.k.a.k implements p<m0, kotlin.b0.d<? super Boolean>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object blockingGet;
            b.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(object);
                Trace trace = f.this.preferenceService.newTrace("splash_checkIsAppUpdateAvailable");
                n.e(trace, "firebasePerformance.newTrace(\"splash_checkIsAppUpdateAvailable\")");
                trace.start();
                try {
                    blockingGet = f.this.connectivityService.isUpdateAvailable().blockingGet();
                } catch (Exception e) {
                    int i = 0;
                    a.k(e, "Couldn't check app update availability", new Object[i]);
                }
                trace.stop();
                return blockingGet;
            }
        }

        c(kotlin.b0.d<? super f.c> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super Boolean> dVar) {
            return (kotlinx.coroutines.f.c)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new kotlinx.coroutines.f.c(f.this, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel$fetchUserData$2", f = "SplashScreenViewModel.kt", l = {}, m = "invokeSuspend")
    static final class e extends kotlin.b0.k.a.k implements p<m0, kotlin.b0.d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(object);
                i = !l.z(f.this.appUpdateRepository.v());
                if (!l.z(f.this.appUpdateRepository.v()) != 0) {
                    try {
                        f.this.reminderRepository.o0().e();
                        f.this.remoteConfigService.K(f.this.appUpdateRepository.v()).e();
                    } catch (Exception e) {
                        a.g(e);
                    }
                }
                return w.a;
            }
        }

        e(kotlin.b0.d<? super f.e> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super w> dVar) {
            return (kotlinx.coroutines.f.e)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new kotlinx.coroutines.f.e(f.this, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel$getDeferredUriAndTrackAppOpen$2", f = "SplashScreenViewModel.kt", l = {154, 156, 157, 160}, m = "invokeSuspend")
    static final class f extends kotlin.b0.k.a.k implements p<m0, kotlin.b0.d<? super Uri>, Object> {

        final /* synthetic */ DogoIntent $dogoIntent;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            app.dogo.com.dogo_android.a0.f fVar;
            Uri uri;
            Object obj;
            Object object2;
            Uri uri3;
            Object obj4;
            Object obj6;
            Object obj7;
            Object obj5;
            int i = 0;
            int i2 = 3;
            Object obj8;
            u0 u0Var3;
            int i3 = 0;
            final Object object3 = this;
            Object obj9 = b.d();
            int i4 = 4;
            int i5 = 3;
            int i6 = 2;
            int i7 = 1;
            kotlin.b0.d dVar = null;
            if (object3.label != 0) {
                if (object3.label != i7) {
                    if (object3.label != i6) {
                        if (object3.label != i5) {
                            if (object3.label != i4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                q.b(object);
                                object2 = object;
                                fVar.trackAppOpen((Uri)uri3, uri, uri, uri);
                                obj4.stop();
                                if (uri != null) {
                                } else {
                                    if (object3.label == null) {
                                    }
                                }
                                return uri;
                            }
                        }
                        q.b(object);
                        object2 = object;
                    } else {
                        q.b(object);
                        object2 = object;
                        object3.L$0 = obj4;
                        object3.L$1 = obj5;
                        object3.L$2 = obj;
                        object3.L$3 = object2;
                        object3.label = i5;
                        if (obj6.o(object3) == obj9) {
                            return obj9;
                        }
                    }
                } else {
                    q.b(object);
                    object3.L$0 = obj4;
                    object3.L$1 = obj5;
                    object3.L$2 = obj6;
                    object3.L$3 = obj;
                    object3.L$4 = dVar;
                    object3.label = i6;
                    if (obj7.o(object3) == obj9) {
                        return obj9;
                    }
                }
            } else {
                q.b(object);
                Trace trace = object3.this$0.preferenceService.newTrace("splash_getDeferredUriAndTrackAppOpen");
                n.e(trace, "firebasePerformance.newTrace(\"splash_getDeferredUriAndTrackAppOpen\")");
                trace.start();
                kotlin.b0.g gVar = null;
                kotlinx.coroutines.o0 o0Var = null;
                Object obj12 = null;
                u0Var3 = kotlinx.coroutines.internal.k.b(l$02, gVar, o0Var, new kotlinx.coroutines.f.f.c(object3.this$0, dVar), 3, obj12);
                i2 = 3;
                i3 = 0;
                u0 u0Var2 = kotlinx.coroutines.internal.k.b(l$02, gVar, o0Var, new kotlinx.coroutines.f.f.a(object3.this$0, dVar), i2, i3);
                Uri uri2 = object3.this$0.roundToNearest10(object3.$dogoIntent);
                u0[] arr = new u0[i5];
                i = 0;
                arr[i] = u0Var3;
                arr[i7] = u0Var;
                arr[i6] = u0Var2;
                object3.L$0 = trace;
                object3.L$1 = u0Var3;
                object3.L$2 = u0Var;
                object3.L$3 = u0Var2;
                object3.L$4 = uri2;
                object3.label = i7;
                if (kotlinx.coroutines.internal.h.a(arr, object3) == obj9) {
                    return obj9;
                }
            }
            object3.L$0 = obj4;
            object3.L$1 = obj;
            object3.L$2 = object2;
            object3.L$3 = object2;
            object3.L$4 = object3.this$0;
            object3.label = i4;
            if (obj5.o(object3) == obj9) {
                return obj9;
            }
        }

        f(DogoIntent dogoIntent, kotlin.b0.d<? super f.f> dVar) {
            this.$dogoIntent = dogoIntent;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super Uri> dVar) {
            return (kotlinx.coroutines.f.f)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            final app.dogo.com.dogo_android.a0.f.f fVar = new kotlinx.coroutines.f.f(f.this, this.$dogoIntent, dVar);
            fVar.L$0 = object;
            return fVar;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel$isDogPremium$2", f = "SplashScreenViewModel.kt", l = {}, m = "invokeSuspend")
    static final class h extends kotlin.b0.k.a.k implements p<m0, kotlin.b0.d<? super Boolean>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object blockingGet;
            Boolean bool;
            b.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(object);
                int i2 = 1;
                i = l.z(f.this.appUpdateRepository.v()) ^ i2;
                if (l.z(f.this.appUpdateRepository.v()) ^ i2 != 0) {
                    Trace trace = f.this.preferenceService.newTrace("splash_isDogPremium");
                    n.e(trace, "firebasePerformance.newTrace(\"splash_isDogPremium\")");
                    trace.start();
                    try {
                        String str = null;
                        blockingGet = IsDogPremiumInteractor.b(f.this.firebasePerformance, str, i2, str).blockingGet();
                    } catch (Exception unused) {
                    }
                    trace.stop();
                } else {
                    bool = b.a(false);
                }
                return bool;
            }
        }

        h(kotlin.b0.d<? super f.h> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super Boolean> dVar) {
            return (kotlinx.coroutines.f.h)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new kotlinx.coroutines.f.h(f.this, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel$refreshAppUpdateIfNeeded$1", f = "SplashScreenViewModel.kt", l = {}, m = "invokeSuspend")
    static final class i extends kotlin.b0.k.a.k implements p<m0, kotlin.b0.d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(object);
                Trace trace = f.this.preferenceService.newTrace("splash_refreshAppUpdateIfNeeded");
                n.e(trace, "firebasePerformance.newTrace(\"splash_refreshAppUpdateIfNeeded\")");
                trace.start();
                try {
                    Object blockingGet = f.this.connectivityService.e().blockingGet();
                    str = "updateInProgress";
                    n.e(blockingGet, str);
                    f.this.checkIsAppUpdateAvailable().postValue(b.a(true));
                } catch (Exception e) {
                    int arr = 0;
                    arr = new Object[arr];
                    a.k(e, "Couldn't check if update is in progress", arr);
                }
                trace.stop();
                return w.a;
            }
        }

        i(kotlin.b0.d<? super f.i> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super w> dVar) {
            return (kotlinx.coroutines.f.i)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new kotlinx.coroutines.f.i(f.this, dVar);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel$refreshRemoteConfig$2", f = "SplashScreenViewModel.kt", l = 183, m = "invokeSuspend")
    static final class k extends kotlin.b0.k.a.k implements p<m0, kotlin.b0.d<? super Object>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj2;
            Object obj = b.d();
            kotlin.b0.d dVar = null;
            int i = 1;
            if (this.label != 0 && this.label == i) {
                try {
                    q.b(object);
                } catch (Exception unused) {
                    object = null;
                    app.dogo.com.dogo_android.a0.f fVar2 = 2;
                    long l = 0L;
                    kotlin.b0.d dVar2 = object;
                    object = kotlinx.coroutines.internal.k.d(GlobalScope.a, f.this.tracker, dVar2, new kotlinx.coroutines.f.k.b(fVar2, dVar2), f.this, l);
                }
                return obj2;
            }
            q.b(f.this);
            int i2 = 3000;
            try {
                this.label = i;
            } catch (Exception unused) {
                object = null;
                fVar2 = 2;
                l = 0L;
                dVar2 = object;
                object = kotlinx.coroutines.internal.k.d(GlobalScope.a, f.this.tracker, dVar2, new kotlinx.coroutines.f.k.b(fVar2, dVar2), f.this, l);
            }
            return kotlinx.coroutines.internal.w2.c(i2, new kotlinx.coroutines.f.k.a(f.this, null), this) == obj ? obj : obj2;
        }

        k(kotlin.b0.d<? super f.k> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<Object> dVar) {
            return (kotlinx.coroutines.f.k)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new kotlinx.coroutines.f.k(f.this, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel$startSplashDataUpdate$1", f = "SplashScreenViewModel.kt", l = {82, 91, 99, 102, 106}, m = "invokeSuspend")
    static final class l extends kotlin.b0.k.a.k implements p<m0, kotlin.b0.d<? super w>, Object> {

        final /* synthetic */ DogoIntent $dogoIntent;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            SplashDataHolder splashDataHolder;
            Object object2;
            int i;
            Trace trace;
            Uri uri3;
            u0[] arr;
            int i2 = 5;
            u0 u0Var;
            int i3;
            kotlinx.coroutines.o0 o0Var;
            app.dogo.com.dogo_android.a0.f.l.b bVar;
            int i4;
            Object obj5;
            int i5;
            int i6;
            boolean z2 = false;
            boolean z3 = true;
            boolean booleanValue = false;
            Uri uri = null;
            int i7 = 10;
            kotlin.d0.d.g gVar = null;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            Uri uri2 = null;
            int i8 = 12;
            kotlin.d0.d.g gVar2 = null;
            Object obj3;
            final Object object3 = this;
            Object obj6 = b.d();
            i2 = 4;
            int i11 = 3;
            i3 = 2;
            i = 0;
            final kotlin.b0.d dVar = null;
            i3 = 1;
            if (object3.label != 0) {
                if (object3.label != i3) {
                    if (object3.label != i3) {
                        if (object3.label != i11) {
                            if (object3.label != 4) {
                                if (object3.label != 5) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                } else {
                                    q.b(object);
                                    object2 = object;
                                    if ((Boolean)object2.booleanValue()) {
                                        object3.this$0.checkIsAppUpdateAvailable().postValue(b.a(true));
                                    } else {
                                        object3.this$0.D().postValue(splashDataHolder);
                                    }
                                    return w.a;
                                }
                            }
                            q.b(object);
                            object2 = object;
                        } else {
                            q.b(object);
                            object2 = object;
                            if ((Boolean)object2.booleanValue()) {
                                splashDataHolder.setDogPremium(true);
                            }
                            object3.L$0 = trace;
                            object3.L$1 = splashDataHolder;
                            object3.L$2 = splashDataHolder;
                            object3.label = 4;
                            if (u0Var.o(object3) == obj6) {
                                return obj6;
                            }
                        }
                    } else {
                        q.b(object);
                        object2 = object;
                        uri = null;
                        i7 = 10;
                        gVar = null;
                        int r19 = object3.I$0 != 0 ? i3 : i;
                        int r20 = i != 0 ? i3 : i;
                        splashDataHolder = new SplashDataHolder(z2, (i != 0 ? i3 : i), (Boolean)object2.booleanValue(), null, 10, null);
                        object3.L$0 = trace;
                        object3.L$1 = u0Var;
                        object3.L$2 = splashDataHolder;
                        i2 = 3;
                        object3.label = i2;
                        if (object3.this$0.parseAndTrackLaunchIntent(object3) == obj6) {
                            return obj6;
                        }
                    }
                } else {
                    q.b(object);
                    if (object3.this$0.a.i0()) {
                        object3.this$0.a.u0(object3.this$0.isDogPremiumInteractor.g());
                        object3.L$0 = trace;
                        object3.L$1 = u0Var;
                        object3.I$0 = i3;
                        object3.I$1 = i;
                        object3.label = i3;
                        if (object3.this$0.parseAndTrackLaunchIntent(object3) == obj6) {
                            return obj6;
                        }
                    } else {
                        if (object3.this$0.a.D()) {
                            z2 = false;
                            z3 = true;
                            booleanValue = false;
                            uri = null;
                            i7 = 12;
                            gVar = null;
                            splashDataHolder = new SplashDataHolder(z2, z3, booleanValue, uri, i7, gVar);
                        } else {
                            z4 = false;
                            z5 = false;
                            z6 = false;
                            uri2 = null;
                            i8 = 12;
                            gVar2 = null;
                            splashDataHolder = new SplashDataHolder(z4, z5, z6, uri2, i8, gVar2);
                        }
                    }
                }
            } else {
                q.b(object);
                trace = object3.this$0.preferenceService.newTrace("splashscreen_data_loading");
                n.e(trace, "firebasePerformance.newTrace(\"splashscreen_data_loading\")");
                trace.start();
                if (l.z(object3.this$0.appUpdateRepository.v())) {
                    object3.this$0.a.T0(true);
                }
                kotlin.b0.g gVar3 = null;
                o0Var = null;
                i5 = 3;
                i6 = 0;
                arr[i] = kotlinx.coroutines.internal.k.b(l$022, gVar3, o0Var, new kotlinx.coroutines.f.l.a(object3.this$0, dVar), i5, i6);
                arr[i3] = u0Var;
                i4 = 3;
                obj5 = null;
                arr[i3] = kotlinx.coroutines.internal.k.b(l$022, gVar3, o0Var, new kotlinx.coroutines.f.l.b(object3.this$0, dVar), i4, obj5);
                object3.L$0 = trace;
                object3.L$1 = u0Var;
                object3.label = i3;
                if (kotlinx.coroutines.internal.h.a(arr, object3) == obj6) {
                    return obj6;
                }
            }
            splashDataHolder.setDeeplink((Uri)uri3);
            trace.stop();
            if (object3.this$0.connectivityService.o()) {
                object3.L$0 = splashDataHolder;
                object3.L$1 = dVar;
                object3.L$2 = dVar;
                i2 = 5;
                object3.label = i2;
                if (object3.this$0.z(object3) == obj6) {
                    return obj6;
                }
            } else {
                object3.this$0.D().postValue(splashDataHolder);
            }
        }

        l(DogoIntent dogoIntent, kotlin.b0.d<? super f.l> dVar) {
            this.$dogoIntent = dogoIntent;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super w> dVar) {
            return (kotlinx.coroutines.f.l)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            final app.dogo.com.dogo_android.a0.f.l lVar = new kotlinx.coroutines.f.l(f.this, this.$dogoIntent, dVar);
            lVar.L$0 = object;
            return lVar;
        }
    }
    public /* synthetic */ f(p2 p2Var, h2 h2Var, o3 o3Var, app.dogo.com.dogo_android.s.a.c2 c2Var, app.dogo.com.dogo_android.s.c.g gVar, r2 r2Var, a2 a2Var, d3 d3Var, app.dogo.com.dogo_android.service.v2 v2Var, j2 j2Var, FirebasePerformance firebasePerformance, p1 p1Var, l1 l1Var, kotlin.b0.g gVar2, int i, kotlin.d0.d.g gVar3) {
        Object gVar142;
        kotlinx.coroutines.h0 h0Var = i & 8192 != 0 ? h0Var : gVar2;
        this(p2Var, h2Var, o3Var, c2Var, gVar, r2Var, a2Var, d3Var, v2Var, j2Var, firebasePerformance, p1Var, l1Var, gVar142);
    }

    /* renamed from: A, reason: from kotlin metadata */
    /* suspend */ private final Object getDeferredUriAndTrackAppOpen(kotlin.b0.d<? super w> dogoIntent) {
        Object dogoIntent2;
        Object obj;
        int label2;
        int i = -2147483648;
        int i2;
        z = dogoIntent instanceof kotlinx.coroutines.f.d;
        if (dogoIntent instanceof kotlinx.coroutines.f.d) {
            dogoIntent2 = dogoIntent;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dogoIntent2.label -= i;
            } else {
                app.dogo.com.dogo_android.a0.f.d dVar2 = new kotlinx.coroutines.f.d(this, dogoIntent);
            }
        }
        Object obj3 = b.d();
        int i3 = 1;
        if (dogoIntent2.label != 0 && dogoIntent2.label == i3) {
            q.b(dogoIntent2.result);
            obj.stop();
            return w.a;
        }
        q.b(dogoIntent2.result);
        Trace dogoIntent3 = this.preferenceService.newTrace("splash_fetchUserData");
        n.e(dogoIntent3, "firebasePerformance.newTrace(\"splash_fetchUserData\")");
        dogoIntent3.start();
        kotlin.b0.d dVar = null;
        dogoIntent2.L$0 = dogoIntent3;
        dogoIntent2.label = i3;
        if (kotlinx.coroutines.internal.k.e(this.tracker, new kotlinx.coroutines.f.e(this, dVar), dogoIntent2) == obj3) {
            return obj3;
        }
    }

    /* renamed from: C, reason: from kotlin metadata */
    private final Object pxToDp(DogoIntent px, kotlin.b0.d<? super Uri> density) {
        return kotlinx.coroutines.internal.k.e(this.tracker, new kotlinx.coroutines.f.f(this, px, null), density);
    }

    /* renamed from: E, reason: from kotlin metadata */
    private final Object parseAndTrackLaunchIntent(kotlin.b0.d<? super Boolean> appLaunchIntent) {
        Object appLaunchIntent2;
        int label2;
        int i = -2147483648;
        int i2;
        Object result2;
        z = appLaunchIntent instanceof kotlinx.coroutines.f.g;
        if (appLaunchIntent instanceof kotlinx.coroutines.f.g) {
            appLaunchIntent2 = appLaunchIntent;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                appLaunchIntent2.label -= i;
            } else {
                app.dogo.com.dogo_android.a0.f.g gVar = new kotlinx.coroutines.f.g(this, appLaunchIntent);
            }
        }
        Object obj = b.d();
        int i3 = 1;
        if (appLaunchIntent2.label != 0 && appLaunchIntent2.label == i3) {
            q.b(appLaunchIntent2.result);
            n.e(result2, "private suspend fun isDogPremium(): Boolean {\n        return withContext(dispatcher) {\n            if (authService.currentUserId.isNotBlank()) {\n                val trace: Trace = firebasePerformance.newTrace(\"splash_isDogPremium\")\n                trace.start()\n                val results = try {\n                    isDogPremiumInteractor.isCurrentDogPremium().blockingGet()\n                } catch (exception: Exception) {\n                    false\n                }\n                trace.stop()\n                results\n            } else {\n                false\n            }\n        }\n    }");
            return result2;
        }
        q.b(appLaunchIntent2.result);
        kotlin.b0.d dVar = null;
        appLaunchIntent2.label = i3;
        if (kotlinx.coroutines.internal.k.e(this.tracker, new kotlinx.coroutines.f.h(this, dVar), appLaunchIntent2) == obj) {
            return obj;
        }
    }

    /* renamed from: F, reason: from kotlin metadata */
    private final Uri roundToNearest10(DogoIntent number) {
        Uri builder = null;
        int i = 0;
        if (number.getHasDeeplink()) {
            builder = number.getIntent().getData();
        } else {
            if (number.isTrainingNotificationIntent()) {
                trackGoogleApiErrorPopup(number.getNotificationStringId());
            } else {
                if (number.isPottyNotificationIntent()) {
                    builder = Uri.parse(number.getUri());
                } else {
                    if (number.isSpecialOfferNotificationIntent()) {
                        builder = new Uri.Builder().encodedQuery("linkType=special_offer_notification").build();
                    } else {
                        if (number.isDogoFcmNotificationIntent()) {
                            Q(number.getLinkType(), number.getExtras());
                            if (number.isChallengeDeeplink()) {
                                builder = new Uri.Builder().encodedQuery(number.getChallengeDeeplinkQuery()).build();
                            } else {
                                if (number.isUriDeeplink()) {
                                    builder = Uri.parse(number.getUri());
                                }
                            }
                        } else {
                            if (number.isGenericFcmNotificationIntent()) {
                                trackFcmNotificationClick(number.getFcmMessageId());
                                String fcmUri = number.getFcmUri();
                                if (fcmUri != null) {
                                    builder = Uri.parse(fcmUri);
                                }
                            }
                        }
                    }
                }
            }
        }
        return builder;
    }

    /* renamed from: I, reason: from kotlin metadata */
    private final Object startSplashDataUpdate(kotlin.b0.d<? super w> dogoIntent) {
        Object dogoIntent2;
        Object obj;
        int label2;
        int i = -2147483648;
        int i2;
        z = dogoIntent instanceof kotlinx.coroutines.f.j;
        if (dogoIntent instanceof kotlinx.coroutines.f.j) {
            dogoIntent2 = dogoIntent;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dogoIntent2.label -= i;
            } else {
                app.dogo.com.dogo_android.a0.f.j jVar = new kotlinx.coroutines.f.j(this, dogoIntent);
            }
        }
        Object obj3 = b.d();
        int i3 = 1;
        if (dogoIntent2.label != 0 && dogoIntent2.label == i3) {
            q.b(dogoIntent2.result);
            obj.stop();
            return w.a;
        }
        q.b(dogoIntent2.result);
        Trace dogoIntent3 = this.preferenceService.newTrace("splash_refreshRemoteConfig");
        n.e(dogoIntent3, "firebasePerformance.newTrace(\"splash_refreshRemoteConfig\")");
        dogoIntent3.start();
        kotlin.b0.d dVar = null;
        dogoIntent2.L$0 = dogoIntent3;
        dogoIntent2.label = i3;
        if (kotlinx.coroutines.internal.k.e(this.tracker, new kotlinx.coroutines.f.k(this, dVar), dogoIntent2) == obj3) {
            return obj3;
        }
    }

    /* renamed from: J, reason: from kotlin metadata */
    private final int startUpdateFlowForResult(int activity) {
        return (a.a((double)activity / 10d)) * 10;
    }

    /* renamed from: M, reason: from kotlin metadata */
    private final void trackAppOpen(Uri referrerUri, Uri firebaseDeferredLinkUri, Uri facebookDeferredLinkUri, Uri uriFromAppLaunchIntent) {
        Uri firebaseDeferredLinkUri2 = null;
        if (firebaseDeferredLinkUri != null) {
            firebaseDeferredLinkUri2 = firebaseDeferredLinkUri;
        } else {
            if (facebookDeferredLinkUri != null) {
                firebaseDeferredLinkUri2 = facebookDeferredLinkUri;
            } else {
                if (uriFromAppLaunchIntent != null) {
                    firebaseDeferredLinkUri2 = uriFromAppLaunchIntent;
                } else {
                    if (referrerUri == null) {
                        int i = 0;
                    }
                }
            }
        }
        final o3.b tracker_MarketingDeeplink = new Tracker_MarketingDeeplink(firebaseDeferredLinkUri2);
        if (firebaseDeferredLinkUri2 != null) {
            if (this.a.i0()) {
                this.authService.logFirstAppOpen(tracker_MarketingDeeplink);
            }
            this.authService.logAppOpen(tracker_MarketingDeeplink);
        }
        if (this.a.i0()) {
            if (!this.a.z()) {
                this.authService.onAppOpenAttribution(tracker_MarketingDeeplink);
            }
        }
    }

    /* renamed from: O, reason: from kotlin metadata */
    private final void trackFcmNotificationClick(String messageId) {
        this.authService.logEvent(E_Notifications.b.withParameters(u.a(new EP_MessageId(), messageId)));
    }

    private final void Q(String str, String str2) {
        this.authService.logEvent(E_Notifications.a.withParameters(u.a(new EP_Type(), str), u.a(new EP_NotificationId(), str2)));
    }

    /* renamed from: R, reason: from kotlin metadata */
    private final void trackGoogleApiErrorPopup(String status) {
        Q(NotificationType.Training.getTag(), n.o("reminder.daily.training.", status));
    }

    public static final /* synthetic */ Object h(f fVar, kotlin.b0.d dVar) {
        return fVar.z(dVar);
    }

    public static final /* synthetic */ Object i(f fVar, kotlin.b0.d dVar) {
        return fVar.getDeferredUriAndTrackAppOpen(dVar);
    }

    /* renamed from: j, reason: from kotlin metadata */
    public static final /* synthetic */ app.dogo.com.dogo_android.s.c.g trackTrainingNotificationClick(f notificationId) {
        return notificationId.connectivityService;
    }

    public static final /* synthetic */ h2 k(f fVar) {
        return fVar.appUpdateRepository;
    }

    public static final /* synthetic */ app.dogo.com.dogo_android.s.a.c2 l(f fVar) {
        return fVar.cacheUpdaterInteractor;
    }

    /* renamed from: m, reason: from kotlin metadata */
    public static final /* synthetic */ Object trackDeviceDisplayMetrics(f height, DogoIntent width, kotlin.b0.d density) {
        return height.pxToDp(width, density);
    }

    public static final /* synthetic */ kotlin.b0.g n(f fVar) {
        return fVar.tracker;
    }

    public static final /* synthetic */ FirebasePerformance o(f fVar) {
        return fVar.preferenceService;
    }

    public static final /* synthetic */ p2 p(f fVar) {
        return fVar.a;
    }

    public static final /* synthetic */ l1 q(f fVar) {
        return fVar.remoteConfigService;
    }

    public static final /* synthetic */ r2 r(f fVar) {
        return fVar.deferredLinkInteractor;
    }

    public static final /* synthetic */ p1 s(f fVar) {
        return fVar.reminderRepository;
    }

    public static final /* synthetic */ app.dogo.com.dogo_android.service.v2 t(f fVar) {
        return fVar.isDogPremiumInteractor;
    }

    public static final /* synthetic */ Object u(f fVar, kotlin.b0.d dVar) {
        return fVar.parseAndTrackLaunchIntent(dVar);
    }

    public static final /* synthetic */ d3 v(f fVar) {
        return fVar.firebasePerformance;
    }

    public static final /* synthetic */ Uri w(f fVar, DogoIntent dogoIntent) {
        return fVar.roundToNearest10(dogoIntent);
    }

    public static final /* synthetic */ Object x(f fVar, kotlin.b0.d dVar) {
        return fVar.startSplashDataUpdate(dVar);
    }

    public static final /* synthetic */ void y(f fVar, Uri uri, Uri uri2, Uri uri3, Uri uri4) {
        fVar.trackAppOpen(uri, uri2, uri3, uri4);
    }

    private final Object z(kotlin.b0.d<? super Boolean> dVar) {
        Object dVar2;
        int label2;
        int i = -2147483648;
        int i2;
        Object result2;
        z = dVar instanceof kotlinx.coroutines.f.b;
        if (dVar instanceof kotlinx.coroutines.f.b) {
            dVar2 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar2.label -= i;
            } else {
                app.dogo.com.dogo_android.a0.f.b bVar = new kotlinx.coroutines.f.b(this, dVar);
            }
        }
        Object obj = b.d();
        int i3 = 1;
        if (dVar2.label != 0 && dVar2.label == i3) {
            q.b(dVar2.result);
            n.e(result2, "private suspend fun checkIsAppUpdateAvailable(): Boolean {\n        return withContext(dispatcher) {\n            val trace: Trace = firebasePerformance.newTrace(\"splash_checkIsAppUpdateAvailable\")\n            trace.start()\n            val results = try {\n                appUpdateRepository.isUpdateAvailable().blockingGet()\n            } catch (exception: Exception) {\n                Timber.w(exception, \"Couldn't check app update availability\")\n                false\n            }\n            trace.stop()\n            results\n        }\n    }");
            return result2;
        }
        q.b(dVar2.result);
        kotlin.b0.d dVar3 = null;
        dVar2.label = i3;
        if (kotlinx.coroutines.internal.k.e(this.tracker, new kotlinx.coroutines.f.c(this, dVar3), dVar2) == obj) {
            return obj;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: B, reason: from kotlin metadata */
    /* suspend */ public final f.d.a.a<Boolean> checkIsAppUpdateAvailable() {
        return this.userRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<SplashDataHolder> D() {
        return this.utilities;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void H() {
        final kotlin.b0.d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.tracker, dVar, new kotlinx.coroutines.f.i(this, dVar), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void K(DogoIntent dogoIntent) {
        n.f(dogoIntent, "dogoIntent");
        a.f(n.o("App was launched with ", dogoIntent.getConvertToString()), new Object[0]);
        kotlinx.coroutines.internal.k.d(f0.a(this), null, null, new kotlinx.coroutines.f.l(this, dogoIntent, null), 3, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void L(Activity activity) {
        n.f(activity, "activity");
        this.connectivityService.p(activity, 7899);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void N(int i, int i2, float f) {
        this.authService.setUserProperty(UserProperty.ScreenHeight, Integer.valueOf(startUpdateFlowForResult(trackNotificationClick(i, f))));
        this.authService.setUserProperty(UserProperty.ScreenWidth, Integer.valueOf(startUpdateFlowForResult(trackNotificationClick(i2, f))));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void P(int i) {
        final e eVar = e.o();
        n.e(eVar, "getInstance()");
        this.authService.logEvent(E_General.h.withParameters(u.a(new EP_ErrorCode(), Integer.valueOf(i)), u.a(new EP_ErrorMessage(), eVar.e(i))));
    }

    public f(p2 p2Var, h2 h2Var, o3 o3Var, app.dogo.com.dogo_android.s.a.c2 c2Var, app.dogo.com.dogo_android.s.c.g gVar, r2 r2Var, a2 a2Var, d3 d3Var, app.dogo.com.dogo_android.service.v2 v2Var, j2 j2Var, FirebasePerformance firebasePerformance, p1 p1Var, l1 l1Var, kotlin.b0.g gVar2) {
        n.f(p2Var, "preferenceService");
        n.f(h2Var, "authService");
        n.f(o3Var, "tracker");
        n.f(c2Var, "deferredLinkInteractor");
        n.f(gVar, "appUpdateRepository");
        n.f(r2Var, "remoteConfigService");
        n.f(a2Var, "cacheUpdaterInteractor");
        n.f(d3Var, "isDogPremiumInteractor");
        n.f(v2Var, "utilities");
        n.f(j2Var, "connectivityService");
        n.f(firebasePerformance, "firebasePerformance");
        n.f(p1Var, "userRepository");
        n.f(l1Var, "reminderRepository");
        n.f(gVar2, "dispatcher");
        super();
        this.a = p2Var;
        this.appUpdateRepository = h2Var;
        this.authService = o3Var;
        this.cacheUpdaterInteractor = c2Var;
        this.connectivityService = gVar;
        this.deferredLinkInteractor = r2Var;
        this.dispatcher = a2Var;
        this.firebasePerformance = d3Var;
        this.isDogPremiumInteractor = v2Var;
        this.j = j2Var;
        this.preferenceService = firebasePerformance;
        this.reminderRepository = p1Var;
        this.remoteConfigService = l1Var;
        this.tracker = gVar2;
        this.userRepository = new a();
        this.utilities = new a();
        if (j2Var.getActiveNetworkType()) {
            a2Var.updateCache();
        }
        o3Var.trackDeviceData(p2Var.W());
    }


    /* renamed from: G, reason: from kotlin metadata */
    private final int trackNotificationClick(int type, float notificationId) {
        return (int)(float)type / notificationId;
    }
}
