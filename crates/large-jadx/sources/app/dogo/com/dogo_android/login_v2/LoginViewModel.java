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
import app.dogo.com.dogo_android.w.v2;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import i.b.a0;
import i.b.g0;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.u;
import kotlin.w;

/* compiled from: LoginViewModel.kt */
@Metadata(d1 = "\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001:\u0001OBG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u000e\u00106\u001a\u0002072\u0006\u00108\u001a\u000209J\u000e\u0010:\u001a\u0002072\u0006\u00108\u001a\u000209J\u0010\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020=H\u0002J\u0008\u0010>\u001a\u00020\u0015H\u0002J\u0010\u0010?\u001a\u0002072\u0006\u0010@\u001a\u00020\u0015H\u0002J \u0010A\u001a\u0002072\u0006\u0010<\u001a\u00020=2\u0006\u0010B\u001a\u00020=2\u0008\u0010C\u001a\u0004\u0018\u00010DJ\u001e\u0010E\u001a\u0008\u0012\u0004\u0012\u00020-0F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0015H\u0002J\u0006\u0010J\u001a\u000207J\u0006\u0010K\u001a\u000207J\u0006\u0010L\u001a\u000207J\u0006\u0010M\u001a\u000207J\u0008\u0010N\u001a\u000207H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u0010\u0012\u000c\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR(\u0010\u001b\u001a\u0010\u0012\u000c\u0012\n \u0016*\u0004\u0018\u00010\u00030\u00030\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001c\u0010\u0018\"\u0004\u0008\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00150 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0017\u0010#\u001a\u0008\u0012\u0004\u0012\u00020\u00150 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\"R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010&\u001a\u0010\u0012\u000c\u0012\n \u0016*\u0004\u0018\u00010\u00030\u00030\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008'\u0010\u0018\"\u0004\u0008(\u0010\u001eR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010)\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150*0\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010\u0018R\u001d\u0010,\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020-0*0\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010\u0018R\u0017\u0010/\u001a\u0008\u0012\u0004\u0012\u00020\u00150 ¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010\"R\u0017\u00101\u001a\u0008\u0012\u0004\u0012\u0002020 ¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010\"R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00104\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u0010\u0018R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P", d2 = {"Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "callerScreenTag", "", "dogInvite", "Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "loginOnResultInteractor", "Lapp/dogo/com/dogo_android/login_v2/LoginOnResultInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/login_v2/LoginOnResultInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;)V", "buttonState", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getButtonState", "()Landroidx/lifecycle/MutableLiveData;", "getDogInvite", "()Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "emailField", "getEmailField", "setEmailField", "(Landroidx/lifecycle/MutableLiveData;)V", "emailFormatError", "Lcom/hadilq/liveevent/LiveEvent;", "getEmailFormatError", "()Lcom/hadilq/liveevent/LiveEvent;", "loginComplete", "getLoginComplete", "originalUserId", "passwordField", "getPasswordField", "setPasswordField", "restorePurchaseLiveData", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getRestorePurchaseLiveData", "result", "Lapp/dogo/com/dogo_android/login_v2/LoginViewModel$LoginResults;", "getResult", "shouldGoBack", "getShouldGoBack", "showToast", "Lapp/dogo/com/dogo_android/login_v2/DogoLoginMessage;", "getShowToast", "title", "getTitle", "facebookButton", "", "activity", "Landroid/app/Activity;", "googleButton", "isLoginRequest", "requestCode", "", "isSignInValid", "launchEmailAuthentication", "createNewUser", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "onLogin", "Lio/reactivex/Single;", "authResult", "Lcom/google/firebase/auth/AuthResult;", "wasUserPreviouslySubscribed", "passwordReset", "resetForm", "signIn", "signUp", "trackLoginEvent", "LoginResults", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b0, reason: from kotlin metadata */
public final class LoginViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final String authService;
    private final DogOwnerInvitation b;
    /* renamed from: c, reason: from kotlin metadata */
    private h2 callerScreenTag;
    /* renamed from: d, reason: from kotlin metadata */
    private final j2 connectivityService;
    private final y e;
    private final o3 f;
    private final l1 g;
    private final n3 h;
    /* renamed from: i, reason: from kotlin metadata */
    private final String loginOnResultInteractor;
    /* renamed from: j, reason: from kotlin metadata */
    private final x<String> originalUserId = new x<>();
    private final x<Boolean> k = new x<>();
    /* renamed from: l, reason: from kotlin metadata */
    private final f.d.a.a<t> reminderRepository = new a<>();
    private final f.d.a.a<Boolean> m = new a<>();
    private final x<y<b0.a>> n = new x<>();
    private final x<y<Boolean>> o = new x<>();
    private final f.d.a.a<Boolean> p = new a<>();
    /* renamed from: q, reason: from kotlin metadata */
    private x<String> subscribeInteractor = new x<>("");
    private x<String> r = new x<>("");
    /* renamed from: s, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> tracker = new a<>();

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/login_v2/LoginViewModel$LoginResults;", "", "authResult", "Lcom/google/firebase/auth/AuthResult;", "wasUserLinked", "", "(Lcom/google/firebase/auth/AuthResult;Z)V", "getAuthResult", "()Lcom/google/firebase/auth/AuthResult;", "getWasUserLinked", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: from kotlin metadata */
        private final AuthResult authResult;
        /* renamed from: b, reason: from kotlin metadata */
        private final boolean wasUserLinked;
        public a(AuthResult authResult, boolean z) {
            n.f(authResult, "authResult");
            super();
            this.authResult = authResult;
            this.wasUserLinked = z;
        }

        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public final AuthResult component1() {
            return this.authResult;
        }

        public final boolean b() {
            return this.wasUserLinked;
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z4 = false;
            if (!(other instanceof LoginViewModel_LoginResults)) {
                return false;
            }
            if (!n.b(this.authResult, other.authResult)) {
                return false;
            }
            return this.wasUserLinked != other.wasUserLinked ? z4 : z;
        }

        public int hashCode() {
            boolean wasUserLinked2 = true;
            if (this.wasUserLinked) {
                int i4 = 1;
            }
            return (this.authResult.hashCode() * 31) + wasUserLinked2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "LoginResults(authResult=";
            String str3 = ", wasUserLinked=";
            str = str2 + this.authResult + str3 + this.wasUserLinked + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            b0.this.q().postValue(new LoadResult_Error(th));
            b0.this.f.logEvent(E_Auth.h);
        }

        b() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/login_v2/LoginViewModel$LoginResults;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends kotlin.d0.d.p implements kotlin.d0.c.l<b0.a, w> {
        @Override // kotlin.d0.d.p
        public final void a(b0.a aVar) {
            b0.this.q().postValue(new LoadResult_Success(aVar));
            b0.this.n().postValue(Boolean.TRUE);
        }

        c() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            b0.this.q().postValue(new LoadResult_Error(th));
        }

        d() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/login_v2/LoginViewModel$LoginResults;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends kotlin.d0.d.p implements kotlin.d0.c.l<b0.a, w> {
        @Override // kotlin.d0.d.p
        public final void a(b0.a aVar) {
            b0.this.q().postValue(new LoadResult_Success(aVar));
            b0.this.n().postValue(Boolean.TRUE);
        }

        e() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            a.e(th, "failed to send password reset link", new Object[0]);
            final String str3 = null;
            b0.this.r().postValue(new DogoLoginMessage(2131886498, str3, 2, str3));
        }

        f() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends kotlin.d0.d.p implements kotlin.d0.c.a<w> {

        final /* synthetic */ String $email;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            b0.this.r().postValue(new DogoLoginMessage(2131886181, n.o(": ", this.$email)));
        }

        g(String str) {
            this.$email = str;
            super(0);
        }
    }
    public b0(String str, DogOwnerInvitation dogOwnerInvitation, h2 h2Var, j2 j2Var, y yVar, o3 o3Var, l1 l1Var, n3 n3Var) {
        n.f(str, "callerScreenTag");
        n.f(h2Var, "authService");
        n.f(j2Var, "connectivityService");
        n.f(yVar, "loginOnResultInteractor");
        n.f(o3Var, "tracker");
        n.f(l1Var, "reminderRepository");
        n.f(n3Var, "subscribeInteractor");
        super();
        this.authService = str;
        this.b = dogOwnerInvitation;
        this.callerScreenTag = h2Var;
        this.connectivityService = j2Var;
        this.e = yVar;
        this.f = o3Var;
        this.g = l1Var;
        this.h = n3Var;
        this.loginOnResultInteractor = h2Var.v();
        x xVar = new x();
        x xVar2 = new x(Boolean.TRUE);
        f.d.a.a aVar = new a();
        f.d.a.a aVar2 = new a();
        x xVar3 = new x();
        x xVar4 = new x();
        f.d.a.a aVar3 = new a();
        String str10 = "";
        x xVar5 = new x(str10);
        x xVar6 = new x(str10);
        f.d.a.a aVar4 = new a();
    }

    /* renamed from: F, reason: from kotlin metadata */
    private final void facebookButton(boolean activity) {
        String object = null;
        h2.a iNSTANCE2;
        boolean email;
        if (v()) {
            Object value2 = this.subscribeInteractor.getValue();
            if (value2 == null) {
                int i = 0;
            } else {
                object = l.a1(value2).toString();
            }
            if (this.subscribeInteractor != null) {
                iNSTANCE2 = AuthService.INSTANCE;
                if (!iNSTANCE2.isEmail(object)) {
                    this.tracker.postValue(Boolean.TRUE);
                } else {
                    this.n.postValue(LoadResult_Loading.a);
                    a0 observable2 = a0.zip(this.h.q(), this.e.launchEmailAuthentication(object, AuthService.INSTANCE.createBlankStringIfNullOrEmpty((String)this.r.getValue()), activity), new s(this)).flatMap(new o(this)).subscribeOn(a.b()).observeOn(a.a());
                    n.e(observable2, "zip(\n                        subscribeInteractor.revenueCatSubscribed(),\n                        loginOnResultInteractor.launchEmailAuthentication(\n                            email,\n                            AuthService.createBlankStringIfNullOrEmpty(passwordField.value),\n                            createNewUser\n                        )\n                    ) { isSubscribed, authResults ->\n                        trackLoginEvent()\n                        Pair(authResults, isSubscribed)\n                    }\n                        .flatMap { pair -> onLogin(pair.first, pair.second) }\n                        .subscribeOn(Schedulers.io())\n                        .observeOn(AndroidSchedulers.mainThread())");
                    getDisposable().b(a.g(observable2, new b0.b(this), new b0.c(this)));
                }
            }
        }
    }

    private static final kotlin.o G(b0 b0Var, Boolean boolean, AuthResult authResult) {
        n.f(b0Var, "this$0");
        n.f(boolean, "isSubscribed");
        n.f(authResult, "authResults");
        b0Var.isSignInValid();
        return new Pair(authResult, boolean);
    }

    private static final g0 H(b0 b0Var, kotlin.o oVar) {
        n.f(b0Var, "this$0");
        n.f(oVar, "pair");
        Object obj = oVar.c();
        n.e(obj, "pair.first");
        Object obj2 = oVar.d();
        n.e(obj2, "pair.second");
        return b0Var.L(obj, obj2.booleanValue());
    }

    private static final kotlin.o J(b0 b0Var, AuthResult authResult, Boolean boolean) {
        n.f(b0Var, "this$0");
        n.f(authResult, "authResult");
        n.f(boolean, "isSubscribed");
        b0Var.isSignInValid();
        return new Pair(authResult, boolean);
    }

    private static final g0 K(b0 b0Var, kotlin.o oVar) {
        n.f(b0Var, "this$0");
        n.f(oVar, "pair");
        Object obj = oVar.c();
        n.e(obj, "pair.first");
        Object obj2 = oVar.d();
        n.e(obj2, "pair.second");
        return b0Var.L(obj, obj2.booleanValue());
    }

    private final a0<b0.a> L(AuthResult authResult, boolean z) {
        a0 just;
        if (z) {
            this.o.postValue(LoadResult_Loading.a);
            just = this.h.j().onErrorReturn(new m(this)).map(new l(this, authResult));
        } else {
            just = a0.just(authResult);
        }
        n.e(just, "if (wasUserPreviouslySubscribed) {\n            restorePurchaseLiveData.postValue(LoadResult.Loading)\n            subscribeInteractor.restorePurchase()\n                .onErrorReturn {\n                    Timber.e(Exception(\"Failed to restore purchase on Login. \", it))\n                    restorePurchaseLiveData.postValue(LoadResult.Error(it))\n                    false\n                }.map {\n                    restorePurchaseLiveData.postValue(LoadResult.Success(it))\n                    authResult\n                }\n        } else {\n            Single.just(authResult)\n        }");
        final a0 flatMapped = just.map(new q(authResult, this)).flatMap(new k(authResult, this));
        n.e(flatMapped, "restorePurchaseSingle.map {\n            LoginResults(\n                authResult = authResult,\n                wasUserLinked = authResult.user?.uid == originalUserId\n            )\n        }.flatMap {\n            val userId = authResult.user?.uid\n            if (userId != null) {\n                reminderRepository.setupAllUsersActivePottyReminders(userId).toSingle { it }\n            } else {\n                Single.just(it)\n            }\n        }");
        return flatMapped;
    }

    private static final Boolean M(b0 b0Var, Throwable th) {
        n.f(b0Var, "this$0");
        n.f(th, "it");
        a.d(new Exception("Failed to restore purchase on Login. ", th));
        b0Var.p().postValue(new LoadResult_Error(th));
        return Boolean.FALSE;
    }

    private static final AuthResult N(b0 b0Var, AuthResult authResult, Boolean boolean) {
        n.f(b0Var, "this$0");
        n.f(authResult, "$authResult");
        n.f(boolean, "it");
        b0Var.p().postValue(new LoadResult_Success(boolean));
        return authResult;
    }

    private static final b0.a O(AuthResult authResult, b0 b0Var, AuthResult authResult2) {
        String uid = null;
        n.f(authResult, "$authResult");
        n.f(b0Var, "this$0");
        n.f(authResult2, "it");
        FirebaseUser user = authResult.getUser();
        if (user == null) {
            int i = 0;
        } else {
            uid = user.getUid();
        }
        LoginViewModel_LoginResults loginViewModel_LoginResults = new LoginViewModel_LoginResults(authResult, n.b(uid, b0Var.loginOnResultInteractor));
        return loginViewModel_LoginResults;
    }

    private static final g0 P(AuthResult authResult, b0 b0Var, b0.a aVar) {
        String uid = null;
        a0 just;
        n.f(authResult, "$authResult");
        n.f(b0Var, "this$0");
        n.f(aVar, "it");
        FirebaseUser user = authResult.getUser();
        if (user == null) {
            int i = 0;
        } else {
            uid = user.getUid();
        }
        if (uid != null) {
            just = b0Var.g.K(uid).B(new n(aVar));
        } else {
            just = a0.just(aVar);
        }
        return just;
    }

    /* renamed from: V, reason: from kotlin metadata */
    private final void isSignInValid() {
        this.f.logEvent(E_Auth.a.withParameters(u.a(new EP_CurrentScreen(), this.authService), u.a(new EP_Type(), this.callerScreenTag.u())), true);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ o3 isLoginRequest(b0 requestCode) {
        return requestCode.f;
    }

    /* renamed from: u, reason: from kotlin metadata */
    private final boolean launchEmailAuthentication(int createNewUser) {
        boolean z;
        boolean z2 = false;
        if (FacebookSdk.w(createNewUser) || createNewUser == 10001) {
            int i3 = 1;
        }
        return z2;
    }

    private final boolean v() {
        boolean z3 = false;
        int i3 = 0;
        if (this.callerScreenTag.D()) {
            this.m.postValue(Boolean.TRUE);
        } else {
            if (this.connectivityService.a()) {
                int i4 = 1;
            } else {
                int i = 2131886953;
                int i2 = 2;
                String str = null;
                this.reminderRepository.postValue(new DogoLoginMessage(i, str, i2, str));
            }
        }
        return z3;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void I(int i, int i2, Intent intent) {
        this.e.notifyInfo(i, i2, intent);
        if (launchEmailAuthentication(i) && i2 == -1) {
            this.n.postValue(LoadResult_Loading.a);
            a0 observable2 = a0.zip(this.e.getAuthResult(), this.h.q(), new p(this)).flatMap(new r(this)).subscribeOn(a.b()).observeOn(a.a());
            n.e(observable2, "zip(\n                    loginOnResultInteractor.getAuthResult(),\n                    subscribeInteractor.revenueCatSubscribed()\n                ) { authResult, isSubscribed ->\n                    trackLoginEvent()\n                    Pair(authResult, isSubscribed)\n                }\n                    .flatMap { pair -> onLogin(pair.first, pair.second) }\n                    .subscribeOn(Schedulers.io())\n                    .observeOn(AndroidSchedulers.mainThread())");
            getDisposable().b(a.g(observable2, new b0.d(this), new b0.e(this)));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void R() {
        int i = 0;
        if (v()) {
            Object value = this.subscribeInteractor.getValue();
            if (value == null || l.z(value)) {
                i = 1;
            }
            if (i != 0) {
                int i2 = 2131886182;
                int i3 = 2;
                String str = null;
                this.reminderRepository.postValue(new DogoLoginMessage(i2, str, i3, str));
            } else {
                i.b.b bVar3 = this.e.sendPasswordResetEmail(value).y(a.b()).q(a.b());
                n.e(bVar3, "loginOnResultInteractor.sendPasswordResetEmail(email)\n                        .subscribeOn(Schedulers.io())\n                        .observeOn(Schedulers.io())");
                getDisposable().b(a.d(bVar3, new b0.f(this), new b0.g(this, value)));
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void S() {
        final String str = "";
        this.subscribeInteractor.postValue(str);
        this.r.postValue(str);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void T() {
        facebookButton(false);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void U() {
        facebookButton(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> getShouldGoBack() {
        return this.m;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i(Activity activity) {
        n.f(activity, "activity");
        if (v()) {
            this.callerScreenTag.w().j(activity, this.callerScreenTag.x());
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Boolean> j() {
        return this.k;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final DogOwnerInvitation k() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<String> l() {
        return this.subscribeInteractor;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> m() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> n() {
        return this.p;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<String> o() {
        return this.r;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<Boolean>> p() {
        return this.o;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<b0.a>> q() {
        return this.n;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<t> r() {
        return this.reminderRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<String> s() {
        return this.originalUserId;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void t(Activity activity) throws android.content.ActivityNotFoundException {
        n.f(activity, "activity");
        if (v()) {
            Intent intent = this.callerScreenTag.y().b();
            n.e(intent, "authService.googleSignInClient.signInIntent");
            int i = 10001;
            activity.startActivityForResult(intent, i);
        }
    }

    /* renamed from: A, reason: from kotlin metadata */
    public static /* synthetic */ g0 onLogin(b0 authResult, kotlin.o wasUserPreviouslySubscribed) {
        return LoginViewModel.H(authResult, wasUserPreviouslySubscribed);
    }

    /* renamed from: B, reason: from kotlin metadata */
    public static /* synthetic */ kotlin.o onActivityResult(b0 requestCode, AuthResult resultCode, Boolean data) {
        return LoginViewModel.J(requestCode, resultCode, data);
    }

    public static /* synthetic */ b0.a C(AuthResult authResult, b0 b0Var, AuthResult authResult2) {
        return LoginViewModel.O(authResult, b0Var, authResult2);
    }

    public static /* synthetic */ g0 D(b0 b0Var, kotlin.o oVar) {
        return LoginViewModel.K(b0Var, oVar);
    }

    public static /* synthetic */ kotlin.o E(b0 b0Var, Boolean boolean, AuthResult authResult) {
        return LoginViewModel.G(b0Var, boolean, authResult);
    }

    /* renamed from: Q, reason: from kotlin metadata */
    private static final b0.a googleButton(b0.a activity) {
        n.f(activity, "$it");
        return activity;
    }

    public static /* synthetic */ g0 w(AuthResult authResult, b0 b0Var, b0.a aVar) {
        return LoginViewModel.P(authResult, b0Var, aVar);
    }

    public static /* synthetic */ AuthResult x(b0 b0Var, AuthResult authResult, Boolean boolean) {
        LoginViewModel.N(b0Var, authResult, boolean);
        return authResult;
    }

    public static /* synthetic */ Boolean y(b0 b0Var, Throwable th) {
        return LoginViewModel.M(b0Var, th);
    }

    public static /* synthetic */ b0.a z(b0.a aVar) {
        LoginViewModel.googleButton(aVar);
        return aVar;
    }
}
