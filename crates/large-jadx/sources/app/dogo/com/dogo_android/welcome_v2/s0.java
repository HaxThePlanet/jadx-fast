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
import f.d.a.a;
import i.b.a0;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0018\u0000 $2\u00020\u0001:\u0001$B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u001d\u001a\u00020\u0012J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u0012J\u0006\u0010#\u001a\u00020\u001fR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingStartViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/Utilities;)V", "anonLoginResults", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "getAnonLoginResults", "()Landroidx/lifecycle/MutableLiveData;", "lasLoginClick", "", "loginScreen", "Lcom/hadilq/liveevent/LiveEvent;", "getLoginScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "nextScreen", "getNextScreen", "isUserLoggedIn", "launchLogin", "", "logInAsAnonymous", "setFirstLaunch", "shouldShowNewsletter", "trackWelcomeSignIn", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class s0 extends s {

    public static final app.dogo.com.dogo_android.welcome_v2.s0.a Companion;
    private final p2 a;
    private final j2 b;
    private final u2 c;
    private final h2 d;
    private final o3 e;
    private final v2 f;
    private long g;
    private final x<y<Boolean>> h;
    private final a<Boolean> i;
    private final a<Boolean> j;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingStartViewModel$Companion;", "", "()V", "CLICK_TIMEOUT", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.welcome_v2.s0 this$0;
        b(app.dogo.com.dogo_android.welcome_v2.s0 s0) {
            this.this$0 = s0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            y.a aVar = new y.a(throwable);
            this.this$0.h().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lcom/google/firebase/auth/AuthResult;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<AuthResult, w> {

        final app.dogo.com.dogo_android.welcome_v2.s0 this$0;
        c(app.dogo.com.dogo_android.welcome_v2.s0 s0) {
            this.this$0 = s0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(AuthResult authResult) {
            final Boolean tRUE = Boolean.TRUE;
            y.c cVar = new y.c(tRUE);
            this.this$0.h().postValue(cVar);
            this.this$0.j().postValue(tRUE);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((AuthResult)object);
            return w.a;
        }
    }
    static {
        s0.a aVar = new s0.a(0);
        s0.Companion = aVar;
    }

    public s0(p2 p2, j2 j22, u2 u23, h2 h24, o3 o35, v2 v26) {
        n.f(p2, "preferenceService");
        n.f(j22, "connectivityService");
        n.f(u23, "userLocalCacheService");
        n.f(h24, "authService");
        n.f(o35, "tracker");
        n.f(v26, "utilities");
        super();
        this.a = p2;
        this.b = j22;
        this.c = u23;
        this.d = h24;
        this.e = o35;
        this.f = v26;
        x obj2 = new x();
        this.h = obj2;
        obj2 = new a();
        this.i = obj2;
        obj2 = new a();
        this.j = obj2;
    }

    public final x<y<Boolean>> h() {
        return this.h;
    }

    public final a<Boolean> i() {
        return this.j;
    }

    public final a<Boolean> j() {
        return this.i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean k() {
        return this.d.D();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void l() {
        int cmp;
        Boolean tRUE;
        if (Long.compare(i, i2) >= 0) {
            this.g = this.f.g();
            this.j.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m() {
        boolean disposable;
        int i;
        Object aVar;
        Object unknownHostException;
        app.dogo.com.dogo_android.welcome_v2.s0.c cVar;
        if (!value instanceof y.b) {
            int i2 = 1;
            i = this.d.v().length() > 0 ? i2 : 0;
            if (i != 0) {
                this.i.postValue(Boolean.TRUE);
            } else {
                if (!this.b.a()) {
                    unknownHostException = new UnknownHostException();
                    aVar = new y.a(unknownHostException);
                    this.h.postValue(aVar);
                } else {
                    this.h.postValue(y.b.a);
                    a0 observeOn = this.d.c(i2).subscribeOn(a.b()).observeOn(a.b());
                    n.e(observeOn, "authService.anonymousSignInSingle(true)\n                        .subscribeOn(Schedulers.io())\n                        .observeOn(Schedulers.io())");
                    unknownHostException = new s0.b(this);
                    cVar = new s0.c(this);
                    getDisposable().b(a.g(observeOn, unknownHostException, cVar));
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
        boolean z;
        int i;
        String str;
        if (this.d.D() && !this.c.C("marketing_emails_v1")) {
            i = !this.c.C("marketing_emails_v1") ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p() {
        this.e.c(f0.a);
    }
}
