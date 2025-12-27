package app.dogo.com.dogo_android.welcome_v2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.u2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.f0;
import app.dogo.com.dogo_android.w.o3;
import com.google.firebase.auth.AuthResult;
import i.b.a0;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* compiled from: OnboardingStartViewModel.kt */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0018\u0000 $2\u00020\u0001:\u0001$B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u001d\u001a\u00020\u0012J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u0012J\u0006\u0010#\u001a\u00020\u001fR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingStartViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/Utilities;)V", "anonLoginResults", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "getAnonLoginResults", "()Landroidx/lifecycle/MutableLiveData;", "lasLoginClick", "", "loginScreen", "Lcom/hadilq/liveevent/LiveEvent;", "getLoginScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "nextScreen", "getNextScreen", "isUserLoggedIn", "launchLogin", "", "logInAsAnonymous", "setFirstLaunch", "shouldShowNewsletter", "trackWelcomeSignIn", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: s0, reason: from kotlin metadata */
public final class OnboardingStartViewModel extends s {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final s0.a INSTANCE = new s0$a(0);
    private final p2 a;
    /* renamed from: b, reason: from kotlin metadata */
    private final j2 authService;
    /* renamed from: c, reason: from kotlin metadata */
    private final u2 connectivityService;
    /* renamed from: d, reason: from kotlin metadata */
    private final h2 lasLoginClick;
    private final o3 e;
    private final v2 f;
    /* renamed from: g, reason: from kotlin metadata */
    private long preferenceService;
    /* renamed from: h, reason: from kotlin metadata */
    private final x<y<Boolean>> tracker = new x<>();
    /* renamed from: i, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> userLocalCacheService = new a<>();
    /* renamed from: j, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> utilities = new a<>();

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingStartViewModel$Companion;", "", "()V", "CLICK_TIMEOUT", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            s0.this.isUserLoggedIn().postValue(new LoadResult_Error(th));
        }

        b() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lcom/google/firebase/auth/AuthResult;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<AuthResult, w> {
        @Override // kotlin.d0.d.p
        public final void a(AuthResult authResult) {
            final Boolean tRUE2 = Boolean.TRUE;
            s0.this.isUserLoggedIn().postValue(new LoadResult_Success(tRUE2));
            s0.this.j().postValue(tRUE2);
        }

        c() {
            super(1);
        }
    }
    public s0(p2 p2Var, j2 j2Var, u2 u2Var, h2 h2Var, o3 o3Var, v2 v2Var) {
        n.f(p2Var, "preferenceService");
        n.f(j2Var, "connectivityService");
        n.f(u2Var, "userLocalCacheService");
        n.f(h2Var, "authService");
        n.f(o3Var, "tracker");
        n.f(v2Var, "utilities");
        super();
        this.a = p2Var;
        this.authService = j2Var;
        this.connectivityService = u2Var;
        this.lasLoginClick = h2Var;
        this.e = o3Var;
        this.f = v2Var;
        x xVar = new x();
        f.d.a.a aVar = new a();
        f.d.a.a aVar2 = new a();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: h, reason: from kotlin metadata */
    public final x<y<Boolean>> isUserLoggedIn() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> i() {
        return this.utilities;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> j() {
        return this.userLocalCacheService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean k() {
        return this.lasLoginClick.D();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void l() {
        long l2 = this.f.g() - this.preferenceService;
        if (this.f >= 1500) {
            this.preferenceService = this.f.g();
            this.utilities.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m() {
        int i = 0;
        z = this.tracker.getValue() instanceof LoadResult_Loading;
        if (!(this.tracker.getValue() instanceof oadResult_Loading)) {
            boolean z3 = true;
            boolean r0 = this.lasLoginClick.v().length() > 0 ? z3 : 0;
            if (this.tracker != 0) {
                this.userLocalCacheService.postValue(Boolean.TRUE);
            } else {
                if (!this.authService.a()) {
                    this.tracker.postValue(new LoadResult_Error(new UnknownHostException()));
                } else {
                    this.tracker.postValue(LoadResult_Loading.a);
                    a0 observable2 = this.lasLoginClick.c(z3).subscribeOn(a.b()).observeOn(a.b());
                    n.e(observable2, "authService.anonymousSignInSingle(true)\n                        .subscribeOn(Schedulers.io())\n                        .observeOn(Schedulers.io())");
                    getDisposable().b(a.g(observable2, new kotlinx.coroutines.s0.b(this), new kotlinx.coroutines.s0.c(this)));
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n() {
        this.a.T0(false);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean o() {
        boolean z2 = false;
        String str;
        if (this.lasLoginClick.D()) {
            str = "marketing_emails_v1";
            int r0 = !this.connectivityService.C(str) ? 1 : 0;
        }
        return (!this.connectivityService.C(str) ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p() {
        this.e.logEvent(E_Onboarding.a);
    }

}
