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
import androidx.fragment.app.n;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
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
import f.c.a.f.a.d.a;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\"\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0008\u0010\u0018\u001a\u00020\u000fH\u0016J\u0012\u0010\u0019\u001a\u00020\u000f2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0008\u0010\u001c\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0007R\u001b\u0010\u0008\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000c\u0010\r\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/login_v2/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/ActivityLoginBinding;", "isBackStackEmptyOr1Item", "", "()Z", "viewModel", "Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setCancelAndFinish", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LoginActivity extends d {

    public static final app.dogo.com.dogo_android.login_v2.LoginActivity.a Companion;
    private i a;
    private final h b;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/login_v2/LoginActivity$Companion;", "", "()V", "DOG_PARENT_INVITE", "", "IS_NEW_USER_KEY", "PROFILE_PREVIEW", "VIEW_SOURCE", "WAS_USER_LINKED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final app.dogo.com.dogo_android.login_v2.LoginActivity this$0;
        b(app.dogo.com.dogo_android.login_v2.LoginActivity loginActivity) {
            this.this$0 = loginActivity;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            LoginActivity.i(this.this$0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements a<app.dogo.com.dogo_android.login_v2.b0> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public c(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.login_v2.b0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(b0.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<a> {

        final app.dogo.com.dogo_android.login_v2.LoginActivity this$0;
        d(app.dogo.com.dogo_android.login_v2.LoginActivity loginActivity) {
            this.this$0 = loginActivity;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            String stringExtra;
            Object[] arr = new Object[2];
            if (this.this$0.getIntent().getStringExtra("view_source") == null) {
                stringExtra = "";
            }
            return b.b(stringExtra, this.this$0.getIntent().getParcelableExtra("dog_parent_invite"));
        }
    }
    static {
        LoginActivity.a aVar = new LoginActivity.a(0);
        LoginActivity.Companion = aVar;
    }

    public LoginActivity() {
        super();
        LoginActivity.d dVar = new LoginActivity.d(this);
        LoginActivity.c cVar = new LoginActivity.c(this, 0, dVar);
        this.b = j.a(m.SYNCHRONIZED, cVar);
    }

    public static final void i(app.dogo.com.dogo_android.login_v2.LoginActivity loginActivity) {
        loginActivity.x();
    }

    private final app.dogo.com.dogo_android.login_v2.b0 j() {
        return (b0)this.b.getValue();
    }

    private final boolean k() {
        int i;
        if (getSupportFragmentManager().p0() <= 1) {
        } else {
            i = 0;
        }
        return i;
    }

    public static void l(app.dogo.com.dogo_android.login_v2.LoginActivity loginActivity, View view2) {
        LoginActivity.r(loginActivity, view2);
    }

    public static void m(app.dogo.com.dogo_android.login_v2.LoginActivity loginActivity, app.dogo.com.dogo_android.login_v2.t t2) {
        LoginActivity.s(loginActivity, t2);
    }

    public static void n(app.dogo.com.dogo_android.login_v2.LoginActivity loginActivity, Boolean boolean2) {
        LoginActivity.v(loginActivity, boolean2);
    }

    public static void o(app.dogo.com.dogo_android.login_v2.LoginActivity loginActivity, Boolean boolean2) {
        LoginActivity.t(loginActivity, boolean2);
    }

    public static void p(app.dogo.com.dogo_android.login_v2.LoginActivity loginActivity, y y2) {
        LoginActivity.w(loginActivity, y2);
    }

    public static void q(app.dogo.com.dogo_android.login_v2.LoginActivity loginActivity, y y2) {
        LoginActivity.u(loginActivity, y2);
    }

    private static final void r(app.dogo.com.dogo_android.login_v2.LoginActivity loginActivity, View view2) {
        n.f(loginActivity, "this$0");
        loginActivity.onBackPressed();
    }

    private static final void s(app.dogo.com.dogo_android.login_v2.LoginActivity loginActivity, app.dogo.com.dogo_android.login_v2.t t2) {
        n.f(loginActivity, "this$0");
        n.e(t2, "it");
        g1.h0(loginActivity, t2);
    }

    private static final void t(app.dogo.com.dogo_android.login_v2.LoginActivity loginActivity, Boolean boolean2) {
        n.f(loginActivity, "this$0");
        n.e(boolean2, "it");
        if (boolean2.booleanValue()) {
            loginActivity.onBackPressed();
        }
    }

    private static final void u(app.dogo.com.dogo_android.login_v2.LoginActivity loginActivity, y y2) {
        boolean intent;
        boolean newUser;
        String str2;
        String str;
        Object obj4;
        n.f(loginActivity, "this$0");
        if (y2 instanceof y.c) {
            g1.g0(loginActivity, 2131886831);
            AdditionalUserInfo additionalUserInfo = (b0.a)(y.c)y2.a().a().getAdditionalUserInfo();
            if (additionalUserInfo == null) {
                newUser = 0;
            } else {
                newUser = additionalUserInfo.isNewUser();
            }
            loginActivity.getIntent().putExtra("is_new_user", newUser);
            loginActivity.getIntent().putExtra("was_user_linked", (b0.a)y2.a().b());
            loginActivity.setResult(-1, loginActivity.getIntent());
            loginActivity.finish();
        }
    }

    private static final void v(app.dogo.com.dogo_android.login_v2.LoginActivity loginActivity, Boolean boolean2) {
        n.f(loginActivity, "this$0");
        g1.g0(loginActivity, 2131886836);
    }

    private static final void w(app.dogo.com.dogo_android.login_v2.LoginActivity loginActivity, y y2) {
        boolean obj2;
        n.f(loginActivity, "this$0");
        if (y2 instanceof y.a) {
            g1.g0(loginActivity, 2131886123);
        }
    }

    private final void x() {
        Intent intent = new Intent();
        setResult(0, intent);
        finish();
    }

    @Override // androidx.appcompat.app.d
    protected void attachBaseContext(Context context) {
        n.f(context, "newBase");
        t.a companion = t.Companion;
        final Context obj4 = companion.b(context, n2.b(App.Companion.l().W()));
        super.attachBaseContext(obj4);
        android.content.res.Resources resources = getResources();
        n.e(resources, "resources");
        companion.c(resources, obj4);
        a.b(this);
    }

    @Override // androidx.appcompat.app.d
    protected void onActivityResult(int i, int i2, Intent intent3) {
        super.onActivityResult(i, i2, intent3);
        j().I(i, i2, intent3);
    }

    @Override // androidx.appcompat.app.d
    public void onBackPressed() {
        boolean bVar;
        if (!value instanceof y.b) {
            if (k()) {
                if (j().k() != null) {
                    bVar = new LoginActivity.b(this);
                    f1.M(this, bVar);
                } else {
                    x();
                }
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        String stringExtra;
        Object str;
        Object obj5;
        super.onCreate(bundle);
        ViewDataBinding view = f.g(this, 2131558432);
        n.e(view, "setContentView(this, R.layout.activity_login)");
        this.a = (i)view;
        int i3 = 0;
        final String str3 = "binding";
        if (view == null) {
        } else {
            view.T(j());
            stringExtra = this.a;
            if (stringExtra == null) {
            } else {
                stringExtra.M(this);
                if (bundle == null && getIntent().getStringExtra("view_source") == null) {
                    if (getIntent().getStringExtra("view_source") == null) {
                        stringExtra = "missing";
                    }
                    obj5 = new a0(stringExtra);
                    g1.R(this, obj5);
                }
                obj5 = this.a;
                if (obj5 == null) {
                } else {
                    a aVar = new a(this);
                    obj5.O.setOnClickListener(aVar);
                    b bVar = new b(this);
                    j().r().observe(this, bVar);
                    d dVar = new d(this);
                    j().getShouldGoBack().observe(this, dVar);
                    f fVar = new f(this);
                    j().q().observe(this, fVar);
                    c cVar = new c(this);
                    j().m().observe(this, cVar);
                    e eVar = new e(this);
                    j().p().observe(this, eVar);
                    getWindow().addFlags(67108864);
                }
                n.w(str3);
                throw i3;
            }
            n.w(str3);
            throw i3;
        }
        n.w(str3);
        throw i3;
    }
}
