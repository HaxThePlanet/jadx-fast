package app.dogo.com.dogo_android.login_v2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.d;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.en;
import app.dogo.com.dogo_android.h.i;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.t;
import app.dogo.com.dogo_android.util.t.a;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthResult;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;

/* compiled from: LoginActivity.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\"\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0008\u0010\u0018\u001a\u00020\u000fH\u0016J\u0012\u0010\u0019\u001a\u00020\u000f2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0008\u0010\u001c\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0007R\u001b\u0010\u0008\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000c\u0010\r\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/login_v2/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/ActivityLoginBinding;", "isBackStackEmptyOr1Item", "", "()Z", "viewModel", "Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setCancelAndFinish", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class LoginActivity extends d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final LoginActivity.a INSTANCE = new LoginActivity$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private i binding;
    private final h b;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/login_v2/LoginActivity$Companion;", "", "()V", "DOG_PARENT_INVITE", "", "IS_NEW_USER_KEY", "PROFILE_PREVIEW", "VIEW_SOURCE", "WAS_USER_LINKED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            oginActivity.this.x();
        }

        b() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements kotlin.d0.c.a<b0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final b0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(LoginViewModel.class), this.$parameters);
        }

        public c(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            String stringExtra;
            Object[] arr = new Object[2];
            if (oginActivity.this.getIntent().getStringExtra("view_source") == null) {
                stringExtra = "";
            }
            return org.koin.core.parameter.b.b(new Object[] { stringExtra, oginActivity.this.getIntent().getParcelableExtra("dog_parent_invite") });
        }

        d() {
            super(0);
        }
    }

    public LoginActivity() {
        super();
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new LoginActivity.c(this, null, new LoginActivity.d(this)));
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ void attachBaseContext(LoginActivity newBase) {
        newBase.x();
    }

    /* renamed from: j, reason: from kotlin metadata */
    private final b0 onBackPressed() {
        return (LoginViewModel)this.b.getValue();
    }

    private final boolean k() {
        boolean z = true;
        if (getSupportFragmentManager().p0() > 1) {
            int i3 = 0;
        }
        return z;
    }

    private static final void r(LoginActivity loginActivity, View view) {
        n.f(loginActivity, "this$0");
        loginActivity.onBackPressed();
    }

    private static final void s(LoginActivity loginActivity, t tVar) {
        n.f(loginActivity, "this$0");
        n.e(tVar, "it");
        app.dogo.com.dogo_android.util.extensionfunction.g1.h0(loginActivity, tVar);
    }

    private static final void t(LoginActivity loginActivity, Boolean boolean) {
        n.f(loginActivity, "this$0");
        n.e(boolean, "it");
        if (boolean.booleanValue()) {
            loginActivity.onBackPressed();
        }
    }

    private static final void u(LoginActivity loginActivity, y yVar) {
        boolean newUser = false;
        n.f(loginActivity, "this$0");
        z = yVar instanceof LoadResult_Success;
        if (yVar instanceof oadResult_Success) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.g0(loginActivity, 2131886831);
            AdditionalUserInfo additionalUserInfo = (LoginViewModel_LoginResults)yVar.component1().component1().getAdditionalUserInfo();
            if (additionalUserInfo == null) {
                int i3 = 0;
            } else {
                newUser = additionalUserInfo.isNewUser();
            }
            str2 = "is_new_user";
            loginActivity.getIntent().putExtra(str2, newUser);
            str = "was_user_linked";
            loginActivity.getIntent().putExtra(str, (LoginViewModel_LoginResults)yVar.component1().b());
            int i = -1;
            loginActivity.setResult(i, loginActivity.getIntent());
            loginActivity.finish();
        }
    }

    private static final void v(LoginActivity loginActivity, Boolean boolean) {
        n.f(loginActivity, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.g1.g0(loginActivity, 2131886836);
    }

    private static final void w(LoginActivity loginActivity, y yVar) {
        n.f(loginActivity, "this$0");
        z = yVar instanceof LoadResult_Error;
        if (yVar instanceof oadResult_Error) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.g0(loginActivity, 2131886123);
        }
    }

    private final void x() {
        setResult(0, new Intent());
        finish();
    }

    @Override // androidx.appcompat.app.d
    protected void attachBaseContext(Context context) {
        n.f(context, "newBase");
        t.a iNSTANCE2 = MyContextWrapper.INSTANCE;
        final Context resources2 = iNSTANCE2.updateResources(context, LocaleService.getLanguageFromLocaleString(App.INSTANCE.l().W()));
        super.attachBaseContext(resources2);
        android.content.res.Resources resources = getResources();
        n.e(resources, "resources");
        iNSTANCE2.updateResourcesUpTo25Api(resources, resources2);
        a.b(this);
    }

    @Override // androidx.appcompat.app.d
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        onBackPressed().I(requestCode, resultCode, data);
    }

    @Override // androidx.appcompat.app.d
    public void onBackPressed() {
        z = onBackPressed().q().getValue() instanceof LoadResult_Loading;
        if (!(this.onBackPressed().q().getValue() instanceof oadResult_Loading) && this.k()) {
            if (onBackPressed().k() != null) {
                app.dogo.com.dogo_android.util.extensionfunction.f1.showChallengeDeleteOrReportDialog(this, new LoginActivity.b(this));
            } else {
                x();
            }
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle savedInstanceState) {
        String stringExtra;
        super.onCreate(savedInstanceState);
        ViewDataBinding viewDataBinding = f.g(this, 2131558432);
        n.e(viewDataBinding, "setContentView(this, R.layout.activity_login)");
        this.binding = viewDataBinding;
        int i3 = 0;
        final String str2 = "binding";
        if (viewDataBinding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i3;
        } else {
            viewDataBinding.T(onBackPressed());
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i3;
            } else {
                this.binding.M(this);
                if (savedInstanceState == null) {
                    if (getIntent().getStringExtra("view_source") == null) {
                        stringExtra = "missing";
                    }
                    LoginScreen loginScreen = new LoginScreen(stringExtra);
                    app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragment(this, loginScreen);
                }
                if (this.binding == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i3;
                } else {
                    binding22.R.O.setOnClickListener(new a(this));
                    onBackPressed().r().observe(this, new b(this));
                    onBackPressed().getShouldGoBack().observe(this, new d(this));
                    onBackPressed().q().observe(this, new f(this));
                    onBackPressed().m().observe(this, new c(this));
                    onBackPressed().p().observe(this, new e(this));
                    getWindow().addFlags(67108864);
                    return;
                }
            }
        }
    }

    public static /* synthetic */ void l(LoginActivity loginActivity, View view) {
        LoginActivity.r(loginActivity, view);
    }

    public static /* synthetic */ void m(LoginActivity loginActivity, t tVar) {
        LoginActivity.s(loginActivity, tVar);
    }

    public static /* synthetic */ void n(LoginActivity loginActivity, Boolean boolean) {
        LoginActivity.v(loginActivity, boolean);
    }

    public static /* synthetic */ void o(LoginActivity loginActivity, Boolean boolean) {
        LoginActivity.t(loginActivity, boolean);
    }

    public static /* synthetic */ void p(LoginActivity loginActivity, y yVar) {
        LoginActivity.w(loginActivity, yVar);
    }

    public static /* synthetic */ void q(LoginActivity loginActivity, y yVar) {
        LoginActivity.u(loginActivity, yVar);
    }
}
