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
import app.dogo.com.dogo_android.s.a.c2;
import app.dogo.com.dogo_android.s.a.d3;
import app.dogo.com.dogo_android.s.b.l1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.s.c.g;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.w.a0;
import app.dogo.com.dogo_android.w.b2;
import app.dogo.com.dogo_android.w.c2;
import app.dogo.com.dogo_android.w.e0;
import app.dogo.com.dogo_android.w.j1;
import app.dogo.com.dogo_android.w.k1;
import app.dogo.com.dogo_android.w.o2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.o3.b;
import app.dogo.com.dogo_android.w.q3;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.v2;
import com.google.android.gms.common.e;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;
import f.d.a.a;
import i.b.a0;
import i.b.b;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.e0.a;
import kotlin.k0.l;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.r1;
import kotlinx.coroutines.u0;
import kotlinx.coroutines.w2;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000e\n\u0002\u0008\u0008\u0018\u0000 Q2\u00020\u0001:\u0001QBw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010\u001eJ\u0011\u0010'\u001a\u00020!H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0011\u0010)\u001a\u00020*H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J\u001b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010/J\u0011\u00100\u001a\u00020!H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0012\u00101\u001a\u0004\u0018\u00010,2\u0006\u00102\u001a\u00020.H\u0002J\u0018\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u000207H\u0002J\u0006\u00108\u001a\u00020*J\u0011\u00109\u001a\u00020*H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0010\u0010:\u001a\u0002042\u0006\u0010;\u001a\u000204H\u0002J\u000e\u0010<\u001a\u00020*2\u0006\u0010-\u001a\u00020.J\u000e\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020?J0\u0010@\u001a\u00020*2\u0008\u0010A\u001a\u0004\u0018\u00010,2\u0008\u0010B\u001a\u0004\u0018\u00010,2\u0008\u0010C\u001a\u0004\u0018\u00010,2\u0008\u0010D\u001a\u0004\u0018\u00010,H\u0002J\u001e\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u0002042\u0006\u0010G\u001a\u0002042\u0006\u00106\u001a\u000207J\u0012\u0010H\u001a\u00020*2\u0008\u0010I\u001a\u0004\u0018\u00010JH\u0002J\u000e\u0010K\u001a\u00020*2\u0006\u0010L\u001a\u000204J\u001c\u0010M\u001a\u00020*2\u0008\u0010N\u001a\u0004\u0018\u00010J2\u0008\u0010O\u001a\u0004\u0018\u00010JH\u0002J\u0012\u0010P\u001a\u00020*2\u0008\u0010O\u001a\u0004\u0018\u00010JH\u0002R\u0017\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020!0 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\u0008\u0012\u0004\u0012\u00020%0 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006R", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/SplashScreenViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "deferredLinkInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DeferredLinkInteractor;", "appUpdateRepository", "Lapp/dogo/com/dogo_android/repository/remote/AppUpdateRepository;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "cacheUpdaterInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/CacheUpdaterInteractor;", "isDogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "firebasePerformance", "Lcom/google/firebase/perf/FirebasePerformance;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "dispatcher", "Lkotlin/coroutines/CoroutineContext;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/interactor/DeferredLinkInteractor;Lapp/dogo/com/dogo_android/repository/remote/AppUpdateRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/CacheUpdaterInteractor;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lcom/google/firebase/perf/FirebasePerformance;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;Lkotlin/coroutines/CoroutineContext;)V", "appUpdateAvailable", "Lcom/hadilq/liveevent/LiveEvent;", "", "getAppUpdateAvailable", "()Lcom/hadilq/liveevent/LiveEvent;", "nextScreenEvent", "Lapp/dogo/com/dogo_android/repository/domain/SplashDataHolder;", "getNextScreenEvent", "checkIsAppUpdateAvailable", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchUserData", "", "getDeferredUriAndTrackAppOpen", "Landroid/net/Uri;", "dogoIntent", "Lapp/dogo/com/dogo_android/repository/domain/DogoIntent;", "(Lapp/dogo/com/dogo_android/repository/domain/DogoIntent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDogPremium", "parseAndTrackLaunchIntent", "appLaunchIntent", "pxToDp", "", "px", "density", "", "refreshAppUpdateIfNeeded", "refreshRemoteConfig", "roundToNearest10", "number", "startSplashDataUpdate", "startUpdateFlowForResult", "activity", "Landroid/app/Activity;", "trackAppOpen", "referrerUri", "firebaseDeferredLinkUri", "facebookDeferredLinkUri", "uriFromAppLaunchIntent", "trackDeviceDisplayMetrics", "height", "width", "trackFcmNotificationClick", "messageId", "", "trackGoogleApiErrorPopup", "status", "trackNotificationClick", "type", "notificationId", "trackTrainingNotificationClick", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f extends s {

    public static final app.dogo.com.dogo_android.a0.f.a Companion;
    private final p2 a;
    private final h2 b;
    private final o3 c;
    private final c2 d;
    private final g e;
    private final r2 f;
    private final a2 g;
    private final d3 h;
    private final v2 i;
    private final j2 j;
    private final FirebasePerformance k;
    private final p1 l;
    private final l1 m;
    private final g n;
    private final a<Boolean> o;
    private final a<SplashDataHolder> p;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/SplashScreenViewModel$Companion;", "", "()V", "APP_UPDATE_REQUEST_CODE", "", "TRAINING_REMINDER_NOTIFICATION_CLICK_PREFIX", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel", f = "SplashScreenViewModel.kt", l = 228, m = "checkIsAppUpdateAvailable")
    static final class b extends d {

        int label;
        Object result;
        final app.dogo.com.dogo_android.a0.f this$0;
        b(app.dogo.com.dogo_android.a0.f f, d<? super app.dogo.com.dogo_android.a0.f.b> d2) {
            this.this$0 = f;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return f.h(this.this$0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel", f = "SplashScreenViewModel.kt", l = 121, m = "fetchUserData")
    static final class d extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.a0.f this$0;
        d(app.dogo.com.dogo_android.a0.f f, d<? super app.dogo.com.dogo_android.a0.f.d> d2) {
            this.this$0 = f;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return f.i(this.this$0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel", f = "SplashScreenViewModel.kt", l = 259, m = "isDogPremium")
    static final class g extends d {

        int label;
        Object result;
        final app.dogo.com.dogo_android.a0.f this$0;
        g(app.dogo.com.dogo_android.a0.f f, d<? super app.dogo.com.dogo_android.a0.f.g> d2) {
            this.this$0 = f;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return f.u(this.this$0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel", f = "SplashScreenViewModel.kt", l = 181, m = "refreshRemoteConfig")
    static final class j extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.a0.f this$0;
        j(app.dogo.com.dogo_android.a0.f f, d<? super app.dogo.com.dogo_android.a0.f.j> d2) {
            this.this$0 = f;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return f.x(this.this$0, this);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel$checkIsAppUpdateAvailable$2", f = "SplashScreenViewModel.kt", l = {}, m = "invokeSuspend")
    static final class c extends k implements p<m0, d<? super Boolean>, Object> {

        int label;
        final app.dogo.com.dogo_android.a0.f this$0;
        c(app.dogo.com.dogo_android.a0.f f, d<? super app.dogo.com.dogo_android.a0.f.c> d2) {
            this.this$0 = f;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super Boolean> d2) {
            return (f.c)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            f.c obj2 = new f.c(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object blockingGet;
            int i;
            Object[] arr;
            String str;
            b.d();
            if (this.label != 0) {
            } else {
                q.b(object);
                Trace obj5 = f.o(this.this$0).newTrace("splash_checkIsAppUpdateAvailable");
                n.e(obj5, "firebasePerformance.newTrace(\"splash_checkIsAppUpdateAvailable\")");
                obj5.start();
                blockingGet = f.j(this.this$0).a().blockingGet();
                obj5.stop();
                return blockingGet;
            }
            obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel$fetchUserData$2", f = "SplashScreenViewModel.kt", l = {}, m = "invokeSuspend")
    static final class e extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.a0.f this$0;
        e(app.dogo.com.dogo_android.a0.f f, d<? super app.dogo.com.dogo_android.a0.f.e> d2) {
            this.this$0 = f;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (f.e)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            f.e obj2 = new f.e(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label;
            int obj2;
            b.d();
            if (this.label != 0) {
            } else {
                q.b(object);
                if (obj2 ^= 1 != 0) {
                    f.s(this.this$0).o0().e();
                    f.q(this.this$0).K(f.k(this.this$0).v()).e();
                }
                return w.a;
            }
            obj2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj2;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel$getDeferredUriAndTrackAppOpen$2", f = "SplashScreenViewModel.kt", l = {154, 156, 157, 160}, m = "invokeSuspend")
    static final class f extends k implements p<m0, d<? super Uri>, Object> {

        final DogoIntent $dogoIntent;
        private Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final app.dogo.com.dogo_android.a0.f this$0;
        f(app.dogo.com.dogo_android.a0.f f, DogoIntent dogoIntent2, d<? super app.dogo.com.dogo_android.a0.f.f> d3) {
            this.this$0 = f;
            this.$dogoIntent = dogoIntent2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super Uri> d2) {
            return (f.f)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            f.f fVar = new f.f(this.this$0, this.$dogoIntent, d2);
            fVar.L$0 = object;
            return fVar;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object l$4;
            Object l$32;
            Object l$42;
            Object l$33;
            Object obj3;
            Object obj4;
            Object obj5;
            Object obj2;
            Object obj;
            Object l$02;
            Object l$3;
            int l$0;
            Object l$2;
            Object l$1;
            Object arr;
            int i;
            int i2;
            int i3;
            Object trace;
            u0 u0Var;
            int i4;
            Object obj6;
            final Object obj7 = this;
            Object obj8 = b.d();
            int label = obj7.label;
            int i5 = 4;
            int i6 = 3;
            int i7 = 2;
            int i8 = 1;
            l$0 = 0;
            if (label != 0) {
                if (label != i8) {
                    if (label != i7) {
                        if (label != i6) {
                            if (label != i5) {
                            } else {
                                l$4 = obj7.L$4;
                                l$32 = obj7.L$3;
                                q.b(object);
                                l$02 = l$04;
                                obj2 = l$12;
                                obj4 = l$22;
                                obj3 = object;
                                f.y(l$4, (Uri)obj3, obj4, l$32, obj2);
                                l$02.stop();
                                if (obj4 != null) {
                                    l$32 = obj4;
                                } else {
                                    if (l$32 != null) {
                                    } else {
                                        l$32 = obj2;
                                    }
                                }
                                return l$32;
                            }
                            IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            throw illegalStateException;
                        }
                        l$33 = obj7.L$3;
                        l$02 = obj7.L$0;
                        q.b(object);
                        l$1 = l$13;
                        obj2 = l$23;
                        obj5 = object;
                    } else {
                        l$42 = obj7.L$3;
                        l$0 = obj7.L$0;
                        q.b(object);
                        l$1 = l$14;
                        l$3 = l$24;
                        obj = object;
                        obj7.L$0 = l$0;
                        obj7.L$1 = l$1;
                        obj7.L$2 = l$42;
                        obj7.L$3 = (Uri)obj;
                        obj7.label = i6;
                        if (l$3.o(obj7) == obj8) {
                            return obj8;
                        }
                        l$02 = l$0;
                        obj2 = l$42;
                        l$33 = obj6;
                    }
                } else {
                    l$42 = obj7.L$4;
                    l$3 = obj7.L$3;
                    l$2 = obj7.L$2;
                    l$1 = obj7.L$1;
                    q.b(object);
                    trace = arr;
                    obj7.L$0 = trace;
                    obj7.L$1 = l$1;
                    obj7.L$2 = l$3;
                    obj7.L$3 = l$42;
                    obj7.L$4 = l$0;
                    obj7.label = i7;
                    if (l$2.o(obj7) == obj8) {
                        return obj8;
                    }
                    l$0 = trace;
                }
            } else {
                q.b(object);
                Object l$03 = obj7.L$0;
                trace = f.o(obj7.this$0).newTrace("splash_getDeferredUriAndTrackAppOpen");
                n.e(trace, "firebasePerformance.newTrace(\"splash_getDeferredUriAndTrackAppOpen\")");
                trace.start();
                int i9 = 0;
                int i10 = 0;
                f.f.c cVar = new f.f.c(obj7.this$0, l$0);
                int i12 = 0;
                u0Var = k.b((m0)l$03, i9, i10, cVar, 3, i12);
                f.f.b bVar = new f.f.b(obj7.this$0, obj7.$dogoIntent, l$0);
                i2 = 3;
                f.f.a aVar = new f.f.a(obj7.this$0, l$0);
                u0 u0Var2 = u0Var4;
                u0 u0Var3 = k.b(l$03, i9, i10, aVar, i2, 0);
                Uri uri = f.w(obj7.this$0, obj7.$dogoIntent);
                arr = new u0[i6];
                arr[0] = u0Var;
                arr[i8] = u0Var2;
                arr[i7] = u0Var3;
                obj7.L$0 = trace;
                obj7.L$1 = u0Var;
                obj7.L$2 = u0Var2;
                obj7.L$3 = u0Var3;
                obj7.L$4 = uri;
                obj7.label = i8;
                if (h.a(arr, obj7) == obj8) {
                    return obj8;
                }
                l$3 = u0Var3;
                l$2 = u0Var2;
                l$42 = uri;
                l$1 = u0Var;
            }
            l$0 = obj7.this$0;
            obj7.L$0 = l$02;
            obj7.L$1 = obj2;
            obj7.L$2 = l$33;
            obj7.L$3 = (Uri)obj5;
            obj7.L$4 = l$0;
            obj7.label = i5;
            if (l$1.o(obj7) == obj8) {
                return obj8;
            }
            l$4 = l$0;
            obj4 = l$33;
            l$32 = obj6;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel$isDogPremium$2", f = "SplashScreenViewModel.kt", l = {}, m = "invokeSuspend")
    static final class h extends k implements p<m0, d<? super Boolean>, Object> {

        int label;
        final app.dogo.com.dogo_android.a0.f this$0;
        h(app.dogo.com.dogo_android.a0.f f, d<? super app.dogo.com.dogo_android.a0.f.h> d2) {
            this.this$0 = f;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super Boolean> d2) {
            return (f.h)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            f.h obj2 = new f.h(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object blockingGet;
            d3 d3Var;
            int i;
            int obj5;
            b.d();
            if (this.label != 0) {
            } else {
                q.b(object);
                int i2 = 1;
                if (obj5 ^= i2 != 0) {
                    obj5 = f.o(this.this$0).newTrace("splash_isDogPremium");
                    n.e(obj5, "firebasePerformance.newTrace(\"splash_isDogPremium\")");
                    obj5.start();
                    i = 0;
                    blockingGet = d3.b(f.v(this.this$0), i, i2, i).blockingGet();
                    obj5.stop();
                } else {
                    blockingGet = b.a(false);
                }
                return blockingGet;
            }
            obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel$refreshAppUpdateIfNeeded$1", f = "SplashScreenViewModel.kt", l = {}, m = "invokeSuspend")
    static final class i extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.a0.f this$0;
        i(app.dogo.com.dogo_android.a0.f f, d<? super app.dogo.com.dogo_android.a0.f.i> d2) {
            this.this$0 = f;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (f.i)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            f.i obj2 = new f.i(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            boolean booleanValue;
            Object str2;
            String str;
            b.d();
            if (this.label != 0) {
            } else {
                q.b(object);
                Trace obj4 = f.o(this.this$0).newTrace("splash_refreshAppUpdateIfNeeded");
                n.e(obj4, "firebasePerformance.newTrace(\"splash_refreshAppUpdateIfNeeded\")");
                obj4.start();
                Object blockingGet = f.j(this.this$0).e().blockingGet();
                n.e((Boolean)blockingGet, "updateInProgress");
                if (blockingGet.booleanValue()) {
                    this.this$0.B().postValue(b.a(true));
                }
                obj4.stop();
                return w.a;
            }
            obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj4;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel$refreshRemoteConfig$2", f = "SplashScreenViewModel.kt", l = 183, m = "invokeSuspend")
    static final class k extends k implements p<m0, d<? super Object>, Object> {

        int label;
        final app.dogo.com.dogo_android.a0.f this$0;
        k(app.dogo.com.dogo_android.a0.f f, d<? super app.dogo.com.dogo_android.a0.f.k> d2) {
            this.this$0 = f;
            super(2, d2);
        }

        public final Object c(m0 m0, d<Object> d2) {
            return (f.k)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            f.k obj2 = new f.k(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj;
            int label;
            int i;
            int i2;
            app.dogo.com.dogo_android.a0.f fVar;
            long l;
            Object obj7;
            obj = b.d();
            label = this.label;
            i2 = 1;
            if (label != 0) {
                if (label != i2) {
                } else {
                    q.b(object);
                    return obj7;
                }
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
            }
            q.b(object);
            obj7 = new f.k.a(this.this$0, 0);
            this.label = i2;
            if (w2.c(3000, l, obj7) == obj) {
                return obj;
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.SplashScreenViewModel$startSplashDataUpdate$1", f = "SplashScreenViewModel.kt", l = {82, 91, 99, 102, 106}, m = "invokeSuspend")
    static final class l extends k implements p<m0, d<? super w>, Object> {

        final DogoIntent $dogoIntent;
        int I$0;
        int I$1;
        private Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final app.dogo.com.dogo_android.a0.f this$0;
        l(app.dogo.com.dogo_android.a0.f f, DogoIntent dogoIntent2, d<? super app.dogo.com.dogo_android.a0.f.l> d3) {
            this.this$0 = f;
            this.$dogoIntent = dogoIntent2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (f.l)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            f.l lVar = new f.l(this.this$0, this.$dogoIntent, d2);
            lVar.L$0 = object;
            return lVar;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object l$03;
            Object splashDataHolder;
            Object obj4;
            Object l$1;
            Object obj2;
            int i12;
            Object obj3;
            Object obj5;
            int i3;
            Object l$0;
            Object l$12;
            Trace l$04;
            u0 l$13;
            boolean z;
            Trace l$02;
            int i11;
            app.dogo.com.dogo_android.a0.f.l.b bVar;
            int i15;
            int i7;
            int i8;
            int i18;
            SplashDataHolder splashDataHolder2;
            int i4;
            int i6;
            boolean booleanValue;
            int i5;
            int i14;
            int i9;
            SplashDataHolder splashDataHolder3;
            int i13;
            int i16;
            int i;
            int i17;
            int i2;
            int i10;
            Object obj;
            final Object obj6 = this;
            Object obj7 = b.d();
            splashDataHolder = obj6.label;
            l$0 = 3;
            l$04 = 2;
            final int i20 = 0;
            final int i21 = 0;
            final int i22 = 1;
            if (splashDataHolder != 0) {
                if (splashDataHolder != i22) {
                    if (splashDataHolder != l$04) {
                        if (splashDataHolder != l$0) {
                            if (splashDataHolder != 4) {
                                if (splashDataHolder != 5) {
                                } else {
                                    l$03 = obj6.L$0;
                                    q.b(object);
                                    obj2 = object;
                                    if ((Boolean)obj2.booleanValue()) {
                                        obj6.this$0.B().postValue(b.a(i22));
                                    } else {
                                        obj6.this$0.D().postValue(l$03);
                                    }
                                    return w.a;
                                }
                                IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                throw illegalStateException;
                            }
                            l$0 = obj6.L$0;
                            q.b(object);
                            obj5 = object;
                            i3 = l$2;
                            splashDataHolder = obj;
                        } else {
                            splashDataHolder = obj6.L$2;
                            l$12 = obj6.L$1;
                            l$04 = obj6.L$0;
                            q.b(object);
                            obj3 = object;
                            if ((Boolean)obj3.booleanValue()) {
                                splashDataHolder.setDogPremium(i22);
                            }
                            obj6.L$0 = l$04;
                            obj6.L$1 = splashDataHolder;
                            obj6.L$2 = splashDataHolder;
                            obj6.label = 4;
                            if (l$12.o(obj6) == obj7) {
                                return obj7;
                            }
                            i3 = splashDataHolder;
                            l$0 = l$04;
                        }
                    } else {
                        l$04 = obj6.I$0;
                        l$13 = obj6.L$1;
                        l$02 = obj6.L$0;
                        q.b(object);
                        i12 = i$1;
                        obj4 = object;
                        i4 = l$04 != 0 ? i22 : i20;
                        i6 = i12 != 0 ? i22 : i20;
                        super(i4, i6, (Boolean)obj4.booleanValue(), 0, 10, 0);
                        obj6.L$0 = l$02;
                        obj6.L$1 = l$13;
                        obj6.L$2 = splashDataHolder;
                        obj6.label = 3;
                        if (f.u(obj6.this$0, obj6) == obj7) {
                            return obj7;
                        }
                        l$04 = l$02;
                    }
                } else {
                    q.b(object);
                    l$02 = l$06;
                    l$13 = l$1;
                    if (f.p(obj6.this$0).i0()) {
                        f.p(obj6.this$0).u0(f.t(obj6.this$0).g());
                        obj6.L$0 = l$02;
                        obj6.L$1 = l$13;
                        obj6.I$0 = i22;
                        obj6.I$1 = i20;
                        obj6.label = l$04;
                        if (f.u(obj6.this$0, obj6) == obj7) {
                            return obj7;
                        }
                        i12 = i20;
                        l$04 = i22;
                    } else {
                        if (f.p(obj6.this$0).D()) {
                            super(0, 1, 0, 0, 12, 0);
                        } else {
                            super(0, 0, 0, 0, 12, 0);
                        }
                    }
                }
            } else {
                q.b(object);
                Object l$05 = obj6.L$0;
                Trace trace = f.o(obj6.this$0).newTrace("splashscreen_data_loading");
                n.e(trace, "firebasePerformance.newTrace(\"splashscreen_data_loading\")");
                trace.start();
                if (l.z(f.k(obj6.this$0).v())) {
                    f.p(obj6.this$0).T0(i22);
                }
                int i23 = 0;
                i11 = 0;
                f.l.c cVar = new f.l.c(obj6.this$0, obj6.$dogoIntent, i21);
                i12 = trace;
                f.l.a aVar = new f.l.a(obj6.this$0, i21);
                i3 = arr;
                l$0 = u0Var3;
                i3[i20] = k.b(l$05, i23, i11, aVar, 3, 0);
                i3[i22] = l$0;
                bVar = new f.l.b(obj6.this$0, i21);
                i3[l$04] = k.b(l$05, i23, i11, bVar, 3, 0);
                obj6.L$0 = i12;
                obj6.L$1 = l$0;
                obj6.label = i22;
                if (h.a(i3, obj6) == obj7) {
                    return obj7;
                }
                l$02 = i12;
                l$13 = l$0;
            }
            i3.setDeeplink((Uri)obj5);
            l$0.stop();
            if (f.j(obj6.this$0).o()) {
                obj6.L$0 = splashDataHolder;
                obj6.L$1 = i21;
                obj6.L$2 = i21;
                obj6.label = 5;
                if (f.h(obj6.this$0, obj6) == obj7) {
                    return obj7;
                }
                l$03 = splashDataHolder;
            } else {
                obj6.this$0.D().postValue(splashDataHolder);
            }
        }
    }
    static {
        f.a aVar = new f.a(0);
        f.Companion = aVar;
    }

    public f(p2 p2, h2 h22, o3 o33, c2 c24, g g5, r2 r26, a2 a27, d3 d38, v2 v29, j2 j210, FirebasePerformance firebasePerformance11, p1 p112, l1 l113, g g14) {
        n.f(p2, "preferenceService");
        n.f(h22, "authService");
        n.f(o33, "tracker");
        n.f(c24, "deferredLinkInteractor");
        n.f(g5, "appUpdateRepository");
        n.f(r26, "remoteConfigService");
        n.f(a27, "cacheUpdaterInteractor");
        n.f(d38, "isDogPremiumInteractor");
        n.f(v29, "utilities");
        n.f(j210, "connectivityService");
        n.f(firebasePerformance11, "firebasePerformance");
        n.f(p112, "userRepository");
        n.f(l113, "reminderRepository");
        n.f(g14, "dispatcher");
        super();
        this.a = p2;
        this.b = h22;
        this.c = o33;
        this.d = c24;
        this.e = g5;
        this.f = r26;
        this.g = a27;
        this.h = d38;
        this.i = v29;
        this.j = j210;
        this.k = firebasePerformance11;
        this.l = p112;
        this.m = l113;
        this.n = g14;
        a obj3 = new a();
        this.o = obj3;
        obj3 = new a();
        this.p = obj3;
        if (j210.a()) {
            a27.a();
        }
        o33.v(p2.W());
    }

    public f(p2 p2, h2 h22, o3 o33, c2 c24, g g5, r2 r26, a2 a27, d3 d38, v2 v29, j2 j210, FirebasePerformance firebasePerformance11, p1 p112, l1 l113, g g14, int i15, g g16) {
        kotlinx.coroutines.h0 i;
        kotlinx.coroutines.h0 h0Var;
        if (i2 &= 8192 != 0) {
            h0Var = i;
        } else {
            h0Var = g14;
        }
        super(p2, h22, o33, c24, g5, r26, a27, d38, v29, j210, firebasePerformance11, p112, l113, h0Var);
    }

    private final Object A(d<? super w> d) {
        boolean dVar;
        Object l$0;
        int label2;
        int i3;
        int label;
        int i;
        app.dogo.com.dogo_android.a0.f.e eVar;
        int i2;
        Object obj7;
        dVar = d;
        label2 = dVar.label;
        i3 = Integer.MIN_VALUE;
        if (d instanceof f.d && label2 & i3 != 0) {
            dVar = d;
            label2 = dVar.label;
            i3 = Integer.MIN_VALUE;
            if (label2 & i3 != 0) {
                dVar.label = label2 -= i3;
            } else {
                dVar = new f.d(this, d);
            }
        } else {
        }
        obj7 = dVar.result;
        Object obj2 = b.d();
        label = dVar.label;
        int i4 = 1;
        if (label != 0) {
            if (label != i4) {
            } else {
                l$0 = dVar.L$0;
                q.b(obj7);
                l$0.stop();
                return w.a;
            }
            obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj7;
        }
        q.b(obj7);
        obj7 = this.k.newTrace("splash_fetchUserData");
        n.e(obj7, "firebasePerformance.newTrace(\"splash_fetchUserData\")");
        obj7.start();
        eVar = new f.e(this, 0);
        dVar.L$0 = obj7;
        dVar.label = i4;
        if (k.e(this.n, eVar, dVar) == obj2) {
            return obj2;
        }
        l$0 = obj7;
    }

    private final Object C(DogoIntent dogoIntent, d<? super Uri> d2) {
        f.f fVar = new f.f(this, dogoIntent, 0);
        return k.e(this.n, fVar, d2);
    }

    private final Object E(d<? super Boolean> d) {
        boolean gVar;
        int label;
        int i2;
        int hVar;
        int i3;
        int i;
        Object obj6;
        gVar = d;
        label = gVar.label;
        i2 = Integer.MIN_VALUE;
        if (d instanceof f.g && label & i2 != 0) {
            gVar = d;
            label = gVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                gVar.label = label -= i2;
            } else {
                gVar = new f.g(this, d);
            }
        } else {
        }
        obj6 = gVar.result;
        Object obj = b.d();
        hVar = gVar.label;
        int i4 = 1;
        if (hVar != 0) {
            if (hVar != i4) {
            } else {
                q.b(obj6);
                n.e(obj6, "private suspend fun isDogPremium(): Boolean {\n        return withContext(dispatcher) {\n            if (authService.currentUserId.isNotBlank()) {\n                val trace: Trace = firebasePerformance.newTrace(\"splash_isDogPremium\")\n                trace.start()\n                val results = try {\n                    isDogPremiumInteractor.isCurrentDogPremium().blockingGet()\n                } catch (exception: Exception) {\n                    false\n                }\n                trace.stop()\n                results\n            } else {\n                false\n            }\n        }\n    }");
                return obj6;
            }
            obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj6;
        }
        q.b(obj6);
        hVar = new f.h(this, 0);
        gVar.label = i4;
        if (k.e(this.n, hVar, gVar) == obj) {
            return obj;
        }
    }

    private final Uri F(DogoIntent dogoIntent) {
        boolean trainingNotificationIntent;
        Uri build;
        String extras;
        Object obj4;
        build = 0;
        if (dogoIntent.getHasDeeplink()) {
            build = dogoIntent.getIntent().getData();
        } else {
            if (dogoIntent.isTrainingNotificationIntent()) {
                R(dogoIntent.getNotificationStringId());
            } else {
                if (dogoIntent.isPottyNotificationIntent()) {
                    build = Uri.parse(dogoIntent.getUri());
                } else {
                    if (dogoIntent.isSpecialOfferNotificationIntent()) {
                        obj4 = new Uri.Builder();
                        build = obj4.encodedQuery("linkType=special_offer_notification").build();
                    } else {
                        if (dogoIntent.isDogoFcmNotificationIntent()) {
                            Q(dogoIntent.getLinkType(), dogoIntent.getExtras());
                            if (dogoIntent.isChallengeDeeplink()) {
                                trainingNotificationIntent = new Uri.Builder();
                                build = trainingNotificationIntent.encodedQuery(dogoIntent.getChallengeDeeplinkQuery()).build();
                            } else {
                                if (dogoIntent.isUriDeeplink()) {
                                    build = Uri.parse(dogoIntent.getUri());
                                }
                            }
                        } else {
                            O(dogoIntent.getFcmMessageId());
                            obj4 = dogoIntent.getFcmUri();
                            if (dogoIntent.isGenericFcmNotificationIntent() && obj4 != null) {
                                O(dogoIntent.getFcmMessageId());
                                obj4 = dogoIntent.getFcmUri();
                                if (obj4 != null) {
                                    build = Uri.parse(obj4);
                                }
                            }
                        }
                    }
                }
            }
        }
        return build;
    }

    private final int G(int i, float f2) {
        return (int)obj1;
    }

    private final Object I(d<? super w> d) {
        boolean jVar;
        Object l$0;
        int label;
        int i;
        int label2;
        int i3;
        app.dogo.com.dogo_android.a0.f.k kVar;
        int i2;
        Object obj7;
        jVar = d;
        label = jVar.label;
        i = Integer.MIN_VALUE;
        if (d instanceof f.j && label & i != 0) {
            jVar = d;
            label = jVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                jVar.label = label -= i;
            } else {
                jVar = new f.j(this, d);
            }
        } else {
        }
        obj7 = jVar.result;
        Object obj2 = b.d();
        label2 = jVar.label;
        int i4 = 1;
        if (label2 != 0) {
            if (label2 != i4) {
            } else {
                l$0 = jVar.L$0;
                q.b(obj7);
                l$0.stop();
                return w.a;
            }
            obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj7;
        }
        q.b(obj7);
        obj7 = this.k.newTrace("splash_refreshRemoteConfig");
        n.e(obj7, "firebasePerformance.newTrace(\"splash_refreshRemoteConfig\")");
        obj7.start();
        kVar = new f.k(this, 0);
        jVar.L$0 = obj7;
        jVar.label = i4;
        if (k.e(this.n, kVar, jVar) == obj2) {
            return obj2;
        }
        l$0 = obj7;
    }

    private final int J(int i) {
        return obj5 *= 10;
    }

    private final void M(Uri uri, Uri uri2, Uri uri3, Uri uri4) {
        int obj1;
        if (uri2 != null) {
            obj1 = uri2;
        } else {
            if (uri3 != null) {
                obj1 = uri3;
            } else {
                if (uri4 != null) {
                    obj1 = uri4;
                } else {
                    if (uri != null) {
                    } else {
                        obj1 = 0;
                    }
                }
            }
        }
        o3.b obj2 = new o3.b(obj1);
        if (obj1 != null && this.a.i0()) {
            if (this.a.i0()) {
                this.c.f(obj2);
            }
            this.c.b(obj2);
        }
        if (this.a.i0() && !this.a.z()) {
            if (!this.a.z()) {
                this.c.i(obj2);
            }
        }
    }

    private final void O(String string) {
        b2 b2Var = new b2();
        this.c.d(e0.b.d(u.a(b2Var, string)));
    }

    private final void Q(String string, String string2) {
        o2 o2Var = new o2();
        c2 c2Var = new c2();
        this.c.d(e0.a.d(u.a(o2Var, string), u.a(c2Var, string2)));
    }

    private final void R(String string) {
        Q(m.Training.getTag(), n.o("reminder.daily.training.", string));
    }

    public static final Object h(app.dogo.com.dogo_android.a0.f f, d d2) {
        return f.z(d2);
    }

    public static final Object i(app.dogo.com.dogo_android.a0.f f, d d2) {
        return f.A(d2);
    }

    public static final g j(app.dogo.com.dogo_android.a0.f f) {
        return f.e;
    }

    public static final h2 k(app.dogo.com.dogo_android.a0.f f) {
        return f.b;
    }

    public static final c2 l(app.dogo.com.dogo_android.a0.f f) {
        return f.d;
    }

    public static final Object m(app.dogo.com.dogo_android.a0.f f, DogoIntent dogoIntent2, d d3) {
        return f.C(dogoIntent2, d3);
    }

    public static final g n(app.dogo.com.dogo_android.a0.f f) {
        return f.n;
    }

    public static final FirebasePerformance o(app.dogo.com.dogo_android.a0.f f) {
        return f.k;
    }

    public static final p2 p(app.dogo.com.dogo_android.a0.f f) {
        return f.a;
    }

    public static final l1 q(app.dogo.com.dogo_android.a0.f f) {
        return f.m;
    }

    public static final r2 r(app.dogo.com.dogo_android.a0.f f) {
        return f.f;
    }

    public static final p1 s(app.dogo.com.dogo_android.a0.f f) {
        return f.l;
    }

    public static final v2 t(app.dogo.com.dogo_android.a0.f f) {
        return f.i;
    }

    public static final Object u(app.dogo.com.dogo_android.a0.f f, d d2) {
        return f.E(d2);
    }

    public static final d3 v(app.dogo.com.dogo_android.a0.f f) {
        return f.h;
    }

    public static final Uri w(app.dogo.com.dogo_android.a0.f f, DogoIntent dogoIntent2) {
        return f.F(dogoIntent2);
    }

    public static final Object x(app.dogo.com.dogo_android.a0.f f, d d2) {
        return f.I(d2);
    }

    public static final void y(app.dogo.com.dogo_android.a0.f f, Uri uri2, Uri uri3, Uri uri4, Uri uri5) {
        f.M(uri2, uri3, uri4, uri5);
    }

    private final Object z(d<? super Boolean> d) {
        boolean bVar;
        int label;
        int i3;
        int cVar;
        int i;
        int i2;
        Object obj6;
        bVar = d;
        label = bVar.label;
        i3 = Integer.MIN_VALUE;
        if (d instanceof f.b && label & i3 != 0) {
            bVar = d;
            label = bVar.label;
            i3 = Integer.MIN_VALUE;
            if (label & i3 != 0) {
                bVar.label = label -= i3;
            } else {
                bVar = new f.b(this, d);
            }
        } else {
        }
        obj6 = bVar.result;
        Object obj = b.d();
        cVar = bVar.label;
        int i4 = 1;
        if (cVar != 0) {
            if (cVar != i4) {
            } else {
                q.b(obj6);
                n.e(obj6, "private suspend fun checkIsAppUpdateAvailable(): Boolean {\n        return withContext(dispatcher) {\n            val trace: Trace = firebasePerformance.newTrace(\"splash_checkIsAppUpdateAvailable\")\n            trace.start()\n            val results = try {\n                appUpdateRepository.isUpdateAvailable().blockingGet()\n            } catch (exception: Exception) {\n                Timber.w(exception, \"Couldn't check app update availability\")\n                false\n            }\n            trace.stop()\n            results\n        }\n    }");
                return obj6;
            }
            obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj6;
        }
        q.b(obj6);
        cVar = new f.c(this, 0);
        bVar.label = i4;
        if (k.e(this.n, cVar, bVar) == obj) {
            return obj;
        }
    }

    public final a<Boolean> B() {
        return this.o;
    }

    public final a<SplashDataHolder> D() {
        return this.p;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void H() {
        final int i = 0;
        f.i iVar = new f.i(this, i);
        k.d(f0.a(this), this.n, i, iVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void K(DogoIntent dogoIntent) {
        n.f(dogoIntent, "dogoIntent");
        a.f(n.o("App was launched with ", dogoIntent.getConvertToString()), new Object[0]);
        f.l lVar = new f.l(this, dogoIntent, 0);
        k.d(f0.a(this), 0, 0, lVar, 3, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void L(Activity activity) {
        n.f(activity, "activity");
        this.e.p(activity, 7899);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void N(int i, int i2, float f3) {
        this.c.q(q3.ScreenHeight, Integer.valueOf(J(G(i, f3))));
        this.c.q(q3.ScreenWidth, Integer.valueOf(J(G(i2, f3))));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void P(int i) {
        final e eVar = e.o();
        n.e(eVar, "getInstance()");
        j1 j1Var = new j1();
        k1 k1Var = new k1();
        this.c.d(a0.h.d(u.a(j1Var, Integer.valueOf(i)), u.a(k1Var, eVar.e(i))));
    }
}
