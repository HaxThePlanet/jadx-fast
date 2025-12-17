package app.dogo.com.dogo_android.login_v2;

import android.app.Activity;
import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation;
import app.dogo.com.dogo_android.s.a.n3;
import app.dogo.com.dogo_android.s.b.l1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.h2.a;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.f1;
import app.dogo.com.dogo_android.w.o2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p;
import app.dogo.com.dogo_android.w.v2;
import com.facebook.login.p;
import com.facebook.o;
import com.google.android.gms.auth.api.signin.b;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import f.d.a.a;
import i.b.a0;
import i.b.b;
import i.b.g0;
import i.b.i0.b.a;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.k0.l;
import kotlin.o;
import kotlin.u;
import kotlin.w;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001:\u0001OBG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u000e\u00106\u001a\u0002072\u0006\u00108\u001a\u000209J\u000e\u0010:\u001a\u0002072\u0006\u00108\u001a\u000209J\u0010\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020=H\u0002J\u0008\u0010>\u001a\u00020\u0015H\u0002J\u0010\u0010?\u001a\u0002072\u0006\u0010@\u001a\u00020\u0015H\u0002J \u0010A\u001a\u0002072\u0006\u0010<\u001a\u00020=2\u0006\u0010B\u001a\u00020=2\u0008\u0010C\u001a\u0004\u0018\u00010DJ\u001e\u0010E\u001a\u0008\u0012\u0004\u0012\u00020-0F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0015H\u0002J\u0006\u0010J\u001a\u000207J\u0006\u0010K\u001a\u000207J\u0006\u0010L\u001a\u000207J\u0006\u0010M\u001a\u000207J\u0008\u0010N\u001a\u000207H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u0010\u0012\u000c\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR(\u0010\u001b\u001a\u0010\u0012\u000c\u0012\n \u0016*\u0004\u0018\u00010\u00030\u00030\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001c\u0010\u0018\"\u0004\u0008\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00150 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0017\u0010#\u001a\u0008\u0012\u0004\u0012\u00020\u00150 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\"R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010&\u001a\u0010\u0012\u000c\u0012\n \u0016*\u0004\u0018\u00010\u00030\u00030\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008'\u0010\u0018\"\u0004\u0008(\u0010\u001eR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010)\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150*0\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010\u0018R\u001d\u0010,\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020-0*0\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010\u0018R\u0017\u0010/\u001a\u0008\u0012\u0004\u0012\u00020\u00150 ¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010\"R\u0017\u00101\u001a\u0008\u0012\u0004\u0012\u0002020 ¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010\"R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00104\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u0010\u0018R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P", d2 = {"Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "callerScreenTag", "", "dogInvite", "Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "loginOnResultInteractor", "Lapp/dogo/com/dogo_android/login_v2/LoginOnResultInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/login_v2/LoginOnResultInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;)V", "buttonState", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getButtonState", "()Landroidx/lifecycle/MutableLiveData;", "getDogInvite", "()Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "emailField", "getEmailField", "setEmailField", "(Landroidx/lifecycle/MutableLiveData;)V", "emailFormatError", "Lcom/hadilq/liveevent/LiveEvent;", "getEmailFormatError", "()Lcom/hadilq/liveevent/LiveEvent;", "loginComplete", "getLoginComplete", "originalUserId", "passwordField", "getPasswordField", "setPasswordField", "restorePurchaseLiveData", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getRestorePurchaseLiveData", "result", "Lapp/dogo/com/dogo_android/login_v2/LoginViewModel$LoginResults;", "getResult", "shouldGoBack", "getShouldGoBack", "showToast", "Lapp/dogo/com/dogo_android/login_v2/DogoLoginMessage;", "getShowToast", "title", "getTitle", "facebookButton", "", "activity", "Landroid/app/Activity;", "googleButton", "isLoginRequest", "requestCode", "", "isSignInValid", "launchEmailAuthentication", "createNewUser", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "onLogin", "Lio/reactivex/Single;", "authResult", "Lcom/google/firebase/auth/AuthResult;", "wasUserPreviouslySubscribed", "passwordReset", "resetForm", "signIn", "signUp", "trackLoginEvent", "LoginResults", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b0 extends s {

    private final String a;
    private final DogOwnerInvitation b;
    private h2 c;
    private final j2 d;
    private final app.dogo.com.dogo_android.login_v2.y e;
    private final o3 f;
    private final l1 g;
    private final n3 h;
    private final String i;
    private final x<String> j;
    private final x<Boolean> k;
    private final a<app.dogo.com.dogo_android.login_v2.t> l;
    private final a<Boolean> m;
    private final x<y<app.dogo.com.dogo_android.login_v2.b0.a>> n;
    private final x<y<Boolean>> o;
    private final a<Boolean> p;
    private x<String> q;
    private x<String> r;
    private final a<Boolean> s;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/login_v2/LoginViewModel$LoginResults;", "", "authResult", "Lcom/google/firebase/auth/AuthResult;", "wasUserLinked", "", "(Lcom/google/firebase/auth/AuthResult;Z)V", "getAuthResult", "()Lcom/google/firebase/auth/AuthResult;", "getWasUserLinked", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {

        private final AuthResult a;
        private final boolean b;
        public a(AuthResult authResult, boolean z2) {
            n.f(authResult, "authResult");
            super();
            this.a = authResult;
            this.b = z2;
        }

        public final AuthResult a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof b0.a) {
                return i2;
            }
            if (!n.b(this.a, object.a)) {
                return i2;
            }
            if (this.b != object.b) {
                return i2;
            }
            return i;
        }

        public int hashCode() {
            boolean z;
            if (this.b) {
                z = 1;
            }
            return i2 += z;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LoginResults(authResult=");
            stringBuilder.append(this.a);
            stringBuilder.append(", wasUserLinked=");
            stringBuilder.append(this.b);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.login_v2.b0 this$0;
        b(app.dogo.com.dogo_android.login_v2.b0 b0) {
            this.this$0 = b0;
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
            this.this$0.q().postValue(aVar);
            b0.h(this.this$0).c(p.h);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/login_v2/LoginViewModel$LoginResults;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<app.dogo.com.dogo_android.login_v2.b0.a, w> {

        final app.dogo.com.dogo_android.login_v2.b0 this$0;
        c(app.dogo.com.dogo_android.login_v2.b0 b0) {
            this.this$0 = b0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(app.dogo.com.dogo_android.login_v2.b0.a b0$a) {
            y.c cVar = new y.c(a);
            this.this$0.q().postValue(cVar);
            this.this$0.n().postValue(Boolean.TRUE);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((b0.a)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.login_v2.b0 this$0;
        d(app.dogo.com.dogo_android.login_v2.b0 b0) {
            this.this$0 = b0;
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
            this.this$0.q().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/login_v2/LoginViewModel$LoginResults;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements l<app.dogo.com.dogo_android.login_v2.b0.a, w> {

        final app.dogo.com.dogo_android.login_v2.b0 this$0;
        e(app.dogo.com.dogo_android.login_v2.b0 b0) {
            this.this$0 = b0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(app.dogo.com.dogo_android.login_v2.b0.a b0$a) {
            y.c cVar = new y.c(a);
            this.this$0.q().postValue(cVar);
            this.this$0.n().postValue(Boolean.TRUE);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((b0.a)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.login_v2.b0 this$0;
        f(app.dogo.com.dogo_android.login_v2.b0 b0) {
            this.this$0 = b0;
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
            a.e(throwable, "failed to send password reset link", new Object[0]);
            final int i3 = 0;
            t tVar = new t(2131886498, i3, 2, i3);
            this.this$0.r().postValue(tVar);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements a<w> {

        final String $email;
        final app.dogo.com.dogo_android.login_v2.b0 this$0;
        g(app.dogo.com.dogo_android.login_v2.b0 b0, String string2) {
            this.this$0 = b0;
            this.$email = string2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            t tVar = new t(2131886181, n.o(": ", this.$email));
            this.this$0.r().postValue(tVar);
        }
    }
    public b0(String string, DogOwnerInvitation dogOwnerInvitation2, h2 h23, j2 j24, app.dogo.com.dogo_android.login_v2.y y5, o3 o36, l1 l17, n3 n38) {
        n.f(string, "callerScreenTag");
        n.f(h23, "authService");
        n.f(j24, "connectivityService");
        n.f(y5, "loginOnResultInteractor");
        n.f(o36, "tracker");
        n.f(l17, "reminderRepository");
        n.f(n38, "subscribeInteractor");
        super();
        this.a = string;
        this.b = dogOwnerInvitation2;
        this.c = h23;
        this.d = j24;
        this.e = y5;
        this.f = o36;
        this.g = l17;
        this.h = n38;
        this.i = h23.v();
        x obj2 = new x();
        this.j = obj2;
        obj2 = new x(Boolean.TRUE);
        this.k = obj2;
        obj2 = new a();
        this.l = obj2;
        obj2 = new a();
        this.m = obj2;
        obj2 = new x();
        this.n = obj2;
        obj2 = new x();
        this.o = obj2;
        obj2 = new a();
        this.p = obj2;
        String obj3 = "";
        obj2 = new x(obj3);
        this.q = obj2;
        obj2 = new x(obj3);
        this.r = obj2;
        obj2 = new a();
        this.s = obj2;
    }

    public static g0 A(app.dogo.com.dogo_android.login_v2.b0 b0, o o2) {
        return b0.H(b0, o2);
    }

    public static o B(app.dogo.com.dogo_android.login_v2.b0 b0, AuthResult authResult2, Boolean boolean3) {
        return b0.J(b0, authResult2, boolean3);
    }

    public static app.dogo.com.dogo_android.login_v2.b0.a C(AuthResult authResult, app.dogo.com.dogo_android.login_v2.b0 b02, AuthResult authResult3) {
        return b0.O(authResult, b02, authResult3);
    }

    public static g0 D(app.dogo.com.dogo_android.login_v2.b0 b0, o o2) {
        return b0.K(b0, o2);
    }

    public static o E(app.dogo.com.dogo_android.login_v2.b0 b0, Boolean boolean2, AuthResult authResult3) {
        return b0.G(b0, boolean2, authResult3);
    }

    private final void F(boolean z) {
        boolean bVar;
        String string;
        Object companion;
        a disposable;
        a0 a0Var;
        app.dogo.com.dogo_android.login_v2.y yVar;
        Object value;
        boolean obj7;
        if (v()) {
            Object value2 = this.q.getValue();
            if ((String)value2 == null) {
                string = 0;
            } else {
                string = l.a1((String)value2).toString();
            }
            if (string != null) {
                companion = h2.Companion;
                if (!companion.b(string)) {
                    this.s.postValue(Boolean.TRUE);
                } else {
                    this.n.postValue(y.b.a);
                    s sVar = new s(this);
                    o oVar = new o(this);
                    obj7 = a0.zip(this.h.q(), this.e.b(string, companion.a((String)this.r.getValue()), z), sVar).flatMap(oVar).subscribeOn(a.b()).observeOn(a.a());
                    n.e(obj7, "zip(\n                        subscribeInteractor.revenueCatSubscribed(),\n                        loginOnResultInteractor.launchEmailAuthentication(\n                            email,\n                            AuthService.createBlankStringIfNullOrEmpty(passwordField.value),\n                            createNewUser\n                        )\n                    ) { isSubscribed, authResults ->\n                        trackLoginEvent()\n                        Pair(authResults, isSubscribed)\n                    }\n                        .flatMap { pair -> onLogin(pair.first, pair.second) }\n                        .subscribeOn(Schedulers.io())\n                        .observeOn(AndroidSchedulers.mainThread())");
                    bVar = new b0.b(this);
                    companion = new b0.c(this);
                    getDisposable().b(a.g(obj7, bVar, companion));
                }
            } else {
            }
        }
    }

    private static final o G(app.dogo.com.dogo_android.login_v2.b0 b0, Boolean boolean2, AuthResult authResult3) {
        n.f(b0, "this$0");
        n.f(boolean2, "isSubscribed");
        n.f(authResult3, "authResults");
        b0.V();
        o obj1 = new o(authResult3, boolean2);
        return obj1;
    }

    private static final g0 H(app.dogo.com.dogo_android.login_v2.b0 b0, o o2) {
        n.f(b0, "this$0");
        n.f(o2, "pair");
        Object obj = o2.c();
        n.e(obj, "pair.first");
        Object obj3 = o2.d();
        n.e(obj3, "pair.second");
        return b0.L((AuthResult)obj, (Boolean)obj3.booleanValue());
    }

    private static final o J(app.dogo.com.dogo_android.login_v2.b0 b0, AuthResult authResult2, Boolean boolean3) {
        n.f(b0, "this$0");
        n.f(authResult2, "authResult");
        n.f(boolean3, "isSubscribed");
        b0.V();
        o obj1 = new o(authResult2, boolean3);
        return obj1;
    }

    private static final g0 K(app.dogo.com.dogo_android.login_v2.b0 b0, o o2) {
        n.f(b0, "this$0");
        n.f(o2, "pair");
        Object obj = o2.c();
        n.e(obj, "pair.first");
        Object obj3 = o2.d();
        n.e(obj3, "pair.second");
        return b0.L((AuthResult)obj, (Boolean)obj3.booleanValue());
    }

    private final a0<app.dogo.com.dogo_android.login_v2.b0.a> L(AuthResult authResult, boolean z2) {
        app.dogo.com.dogo_android.login_v2.l lVar;
        a0 obj3;
        if (z2) {
            this.o.postValue(y.b.a);
            m mVar = new m(this);
            lVar = new l(this, authResult);
            obj3 = this.h.j().onErrorReturn(mVar).map(lVar);
        } else {
            obj3 = a0.just(authResult);
        }
        n.e(obj3, "if (wasUserPreviouslySubscribed) {\n            restorePurchaseLiveData.postValue(LoadResult.Loading)\n            subscribeInteractor.restorePurchase()\n                .onErrorReturn {\n                    Timber.e(Exception(\"Failed to restore purchase on Login. \", it))\n                    restorePurchaseLiveData.postValue(LoadResult.Error(it))\n                    false\n                }.map {\n                    restorePurchaseLiveData.postValue(LoadResult.Success(it))\n                    authResult\n                }\n        } else {\n            Single.just(authResult)\n        }");
        q qVar = new q(authResult, this);
        k kVar = new k(authResult, this);
        final a0 obj2 = obj3.map(qVar).flatMap(kVar);
        n.e(obj2, "restorePurchaseSingle.map {\n            LoginResults(\n                authResult = authResult,\n                wasUserLinked = authResult.user?.uid == originalUserId\n            )\n        }.flatMap {\n            val userId = authResult.user?.uid\n            if (userId != null) {\n                reminderRepository.setupAllUsersActivePottyReminders(userId).toSingle { it }\n            } else {\n                Single.just(it)\n            }\n        }");
        return obj2;
    }

    private static final Boolean M(app.dogo.com.dogo_android.login_v2.b0 b0, Throwable throwable2) {
        n.f(b0, "this$0");
        n.f(throwable2, "it");
        Exception exception = new Exception("Failed to restore purchase on Login. ", throwable2);
        a.d(exception);
        y.a aVar = new y.a(throwable2);
        b0.p().postValue(aVar);
        return Boolean.FALSE;
    }

    private static final AuthResult N(app.dogo.com.dogo_android.login_v2.b0 b0, AuthResult authResult2, Boolean boolean3) {
        n.f(b0, "this$0");
        n.f(authResult2, "$authResult");
        n.f(boolean3, "it");
        y.c cVar = new y.c(boolean3);
        b0.p().postValue(cVar);
        return authResult2;
    }

    private static final app.dogo.com.dogo_android.login_v2.b0.a O(AuthResult authResult, app.dogo.com.dogo_android.login_v2.b0 b02, AuthResult authResult3) {
        int uid;
        n.f(authResult, "$authResult");
        n.f(b02, "this$0");
        n.f(authResult3, "it");
        FirebaseUser user = authResult.getUser();
        if (user == null) {
            uid = 0;
        } else {
            uid = user.getUid();
        }
        b0.a obj3 = new b0.a(authResult, n.b(uid, b02.i));
        return obj3;
    }

    private static final g0 P(AuthResult authResult, app.dogo.com.dogo_android.login_v2.b0 b02, app.dogo.com.dogo_android.login_v2.b0.a b0$a3) {
        int obj1;
        Object obj2;
        n.f(authResult, "$authResult");
        n.f(b02, "this$0");
        n.f(a3, "it");
        obj1 = authResult.getUser();
        if (obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = obj1.getUid();
        }
        if (obj1 != null) {
            obj2 = new n(a3);
            obj1 = b02.g.K(obj1).B(obj2);
        } else {
            obj1 = a0.just(a3);
        }
        return obj1;
    }

    private static final app.dogo.com.dogo_android.login_v2.b0.a Q(app.dogo.com.dogo_android.login_v2.b0.a b0$a) {
        n.f(a, "$it");
        return a;
    }

    private final void V() {
        f1 f1Var = new f1();
        o2 o2Var = new o2();
        this.f.e(p.a.d(u.a(f1Var, this.a), u.a(o2Var, this.c.u())), true);
    }

    public static final o3 h(app.dogo.com.dogo_android.login_v2.b0 b0) {
        return b0.f;
    }

    private final boolean u(int i) {
        int z;
        int obj2;
        if (!o.w(i)) {
            if (i == 10001) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    private final boolean v() {
        a z;
        int i4;
        Object tVar;
        int i;
        int i2;
        int i3;
        i4 = 0;
        if (!this.c.D()) {
            if (this.d.a()) {
                i4 = 1;
            } else {
                i3 = 0;
                tVar = new t(2131886953, i3, 2, i3);
                this.l.postValue(tVar);
            }
        } else {
            this.m.postValue(Boolean.TRUE);
        }
        return i4;
    }

    public static g0 w(AuthResult authResult, app.dogo.com.dogo_android.login_v2.b0 b02, app.dogo.com.dogo_android.login_v2.b0.a b0$a3) {
        return b0.P(authResult, b02, a3);
    }

    public static AuthResult x(app.dogo.com.dogo_android.login_v2.b0 b0, AuthResult authResult2, Boolean boolean3) {
        b0.N(b0, authResult2, boolean3);
        return authResult2;
    }

    public static Boolean y(app.dogo.com.dogo_android.login_v2.b0 b0, Throwable throwable2) {
        return b0.M(b0, throwable2);
    }

    public static app.dogo.com.dogo_android.login_v2.b0.a z(app.dogo.com.dogo_android.login_v2.b0.a b0$a) {
        b0.Q(a);
        return a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void I(int i, int i2, Intent intent3) {
        Object eVar;
        boolean obj2;
        int obj3;
        Object obj4;
        this.e.c(i, i2, intent3);
        if (u(i) && i2 == -1) {
            if (i2 == -1) {
                this.n.postValue(y.b.a);
                p pVar = new p(this);
                obj4 = new r(this);
                obj3 = a0.zip(this.e.a(), this.h.q(), pVar).flatMap(obj4).subscribeOn(a.b()).observeOn(a.a());
                n.e(obj3, "zip(\n                    loginOnResultInteractor.getAuthResult(),\n                    subscribeInteractor.revenueCatSubscribed()\n                ) { authResult, isSubscribed ->\n                    trackLoginEvent()\n                    Pair(authResult, isSubscribed)\n                }\n                    .flatMap { pair -> onLogin(pair.first, pair.second) }\n                    .subscribeOn(Schedulers.io())\n                    .observeOn(AndroidSchedulers.mainThread())");
                obj4 = new b0.d(this);
                eVar = new b0.e(this);
                getDisposable().b(a.g(obj3, obj4, eVar));
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void R() {
        boolean z;
        app.dogo.com.dogo_android.login_v2.t disposable;
        int i2;
        int i;
        int fVar;
        int gVar;
        if (v()) {
            Object value = this.q.getValue();
            if ((String)value != null) {
                if (l.z((String)value)) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
            } else {
            }
            if (i2 != 0) {
                gVar = 0;
                disposable = new t(2131886182, gVar, 2, gVar);
                this.l.postValue(disposable);
            } else {
                i = this.e.d(value).y(a.b()).q(a.b());
                n.e(i, "loginOnResultInteractor.sendPasswordResetEmail(email)\n                        .subscribeOn(Schedulers.io())\n                        .observeOn(Schedulers.io())");
                fVar = new b0.f(this);
                gVar = new b0.g(this, value);
                getDisposable().b(a.d(i, fVar, gVar));
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void S() {
        final String str = "";
        this.q.postValue(str);
        this.r.postValue(str);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void T() {
        F(false);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void U() {
        F(true);
    }

    public final a<Boolean> getShouldGoBack() {
        return this.m;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i(Activity activity) {
        boolean z;
        java.util.List list;
        n.f(activity, "activity");
        if (v()) {
            this.c.w().j(activity, this.c.x());
        }
    }

    public final x<Boolean> j() {
        return this.k;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final DogOwnerInvitation k() {
        return this.b;
    }

    public final x<String> l() {
        return this.q;
    }

    public final a<Boolean> m() {
        return this.s;
    }

    public final a<Boolean> n() {
        return this.p;
    }

    public final x<String> o() {
        return this.r;
    }

    public final x<y<Boolean>> p() {
        return this.o;
    }

    public final x<y<app.dogo.com.dogo_android.login_v2.b0.a>> q() {
        return this.n;
    }

    public final a<app.dogo.com.dogo_android.login_v2.t> r() {
        return this.l;
    }

    public final x<String> s() {
        return this.j;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void t(Activity activity) {
        boolean z;
        int i;
        n.f(activity, "activity");
        if (v()) {
            z = this.c.y().b();
            n.e(z, "authService.googleSignInClient.signInIntent");
            activity.startActivityForResult(z, 10001);
        }
    }
}
