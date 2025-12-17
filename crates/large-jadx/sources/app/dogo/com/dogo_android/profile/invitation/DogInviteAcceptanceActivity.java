package app.dogo.com.dogo_android.profile.invitation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.d;
import androidx.activity.e;
import androidx.appcompat.app.d;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.dogcreation.f;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.i1;
import app.dogo.com.dogo_android.util.m0.a;
import app.dogo.com.dogo_android.util.t;
import app.dogo.com.dogo_android.util.t.a;
import app.dogo.com.dogo_android.view.main_screen.i;
import f.c.a.f.a.d.a;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import m.a.b.a.d.a.b;
import m.a.c.j.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0008\u0010\u0011\u001a\u00020\u000eH\u0002J\"\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0012\u0010\u0018\u001a\u00020\u000e2\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0008\u0010\u001b\u001a\u00020\u000eH\u0002J\u0008\u0010\u001c\u001a\u00020\u000eH\u0002J\u0006\u0010\u001d\u001a\u00020\u000eJ\u0008\u0010\u001e\u001a\u00020\u000eH\u0002J\u0008\u0010\u001f\u001a\u00020\u000eH\u0002J\u0008\u0010 \u001a\u00020\u000eH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\u00088BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000b\u0010\u000c\u001a\u0004\u0008\t\u0010\n¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/profile/invitation/DogInviteAcceptanceActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "screenKey", "Lapp/dogo/com/dogo_android/profile/invitation/DogInviteAcceptanceFlowKey;", "getScreenKey", "()Lapp/dogo/com/dogo_android/profile/invitation/DogInviteAcceptanceFlowKey;", "viewModel", "Lapp/dogo/com/dogo_android/profile/invitation/DogInviteAcceptanceSharedViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/profile/invitation/DogInviteAcceptanceSharedViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "callCancelDialog", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFlowCancel", "onFlowComplete", "onShowNextScreen", "showInvite", "showLogin", "showUserInfo", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogInviteAcceptanceActivity extends d {

    public static final app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity.a Companion;
    private final h a;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/profile/invitation/DogInviteAcceptanceActivity$Companion;", "", "()V", "DOG_INVITE_LOGIN_REQUEST_CODE", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity this$0;
        b(app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity dogInviteAcceptanceActivity) {
            this.this$0 = dogInviteAcceptanceActivity;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            DogInviteAcceptanceActivity.k(this.this$0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<d, w> {

        final app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity this$0;
        c(app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity dogInviteAcceptanceActivity) {
            this.this$0 = dogInviteAcceptanceActivity;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(d d) {
            boolean obj2;
            n.f(d, "$this$addCallback");
            if (!obj2 instanceof y.b) {
                DogInviteAcceptanceActivity.i(this.this$0);
            }
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((d)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<w> {

        final app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity this$0;
        d(app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity dogInviteAcceptanceActivity) {
            this.this$0 = dogInviteAcceptanceActivity;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            DogInviteAcceptanceActivity.j(this.this$0).r();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class e extends p implements a<app.dogo.com.dogo_android.profile.invitation.g> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public e(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.profile.invitation.g invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(g.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
        DogInviteAcceptanceActivity.a aVar = new DogInviteAcceptanceActivity.a(0);
        DogInviteAcceptanceActivity.Companion = aVar;
    }

    public DogInviteAcceptanceActivity() {
        super();
        final int i = 0;
        DogInviteAcceptanceActivity.e eVar = new DogInviteAcceptanceActivity.e(this, i, i);
        this.a = j.a(m.SYNCHRONIZED, eVar);
    }

    private final void A() {
        startActivityForResult(i1.f(this, "dog_owners_list", 0, n().l(), 2, 0), 157945);
        overridePendingTransition(2130772003, 2130772006);
    }

    private final void B() {
        k kVar = new k();
        g1.n(this, kVar);
    }

    public static final void i(app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity dogInviteAcceptanceActivity) {
        dogInviteAcceptanceActivity.l();
    }

    public static final app.dogo.com.dogo_android.profile.invitation.g j(app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity dogInviteAcceptanceActivity) {
        return dogInviteAcceptanceActivity.n();
    }

    public static final void k(app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity dogInviteAcceptanceActivity) {
        dogInviteAcceptanceActivity.w();
    }

    private final void l() {
        DogInviteAcceptanceActivity.b bVar = new DogInviteAcceptanceActivity.b(this);
        f1.M(this, bVar);
    }

    private final app.dogo.com.dogo_android.profile.invitation.f m() {
        return (f)g1.l(this);
    }

    private final app.dogo.com.dogo_android.profile.invitation.g n() {
        return (g)this.a.getValue();
    }

    public static void o(app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity dogInviteAcceptanceActivity, Boolean boolean2) {
        DogInviteAcceptanceActivity.v(dogInviteAcceptanceActivity, boolean2);
    }

    public static void p(app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity dogInviteAcceptanceActivity, y y2) {
        DogInviteAcceptanceActivity.s(dogInviteAcceptanceActivity, y2);
    }

    public static void q(app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity dogInviteAcceptanceActivity, Boolean boolean2) {
        DogInviteAcceptanceActivity.u(dogInviteAcceptanceActivity, boolean2);
    }

    public static void r(app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity dogInviteAcceptanceActivity, y y2) {
        DogInviteAcceptanceActivity.t(dogInviteAcceptanceActivity, y2);
    }

    private static final void s(app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity dogInviteAcceptanceActivity, y y2) {
        boolean exc;
        Object obj;
        boolean z;
        boolean obj4;
        n.f(dogInviteAcceptanceActivity, "this$0");
        exc = y2 instanceof y.a;
        obj = y2;
        if (exc && cause instanceof DogParentInvitationException.InvitationHasExpired) {
            obj = y2;
            if (cause instanceof DogParentInvitationException.InvitationHasExpired) {
                g1.i0(dogInviteAcceptanceActivity, n.a.i(obj.a(), dogInviteAcceptanceActivity));
                dogInviteAcceptanceActivity.w();
            } else {
                if (exc) {
                    obj4 = new DogInviteAcceptanceActivity.d(dogInviteAcceptanceActivity);
                    f1.h0(dogInviteAcceptanceActivity, obj4);
                } else {
                    if (y2 instanceof y.c && dogInviteAcceptanceActivity.getSupportFragmentManager().p0() == 0) {
                        if (dogInviteAcceptanceActivity.getSupportFragmentManager().p0() == 0) {
                            dogInviteAcceptanceActivity.y();
                        }
                    }
                }
            }
        } else {
        }
    }

    private static final void t(app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity dogInviteAcceptanceActivity, y y2) {
        boolean z;
        Object obj2;
        n.f(dogInviteAcceptanceActivity, "this$0");
        if (y2 instanceof y.a && cause instanceof DogParentInvitationException.InvitationHasExpired) {
            if (cause instanceof DogParentInvitationException.InvitationHasExpired) {
                g1.i0(dogInviteAcceptanceActivity, n.a.i(y2.a(), dogInviteAcceptanceActivity));
                dogInviteAcceptanceActivity.w();
            }
        }
    }

    private static final void u(app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity dogInviteAcceptanceActivity, Boolean boolean2) {
        n.f(dogInviteAcceptanceActivity, "this$0");
        dogInviteAcceptanceActivity.onBackPressed();
    }

    private static final void v(app.dogo.com.dogo_android.profile.invitation.DogInviteAcceptanceActivity dogInviteAcceptanceActivity, Boolean boolean2) {
        n.f(dogInviteAcceptanceActivity, "this$0");
        dogInviteAcceptanceActivity.x();
    }

    private final void w() {
        Intent intent;
        a aVar;
        int i2;
        boolean z;
        int i4;
        int i5;
        int i3;
        int i;
        if (n().j()) {
            super(0, m().b(), 0, 0, 13, 0);
            intent = iVar.buildIntent(this);
        } else {
            n().t();
            super(0, 0, 1, 1, 2, 0);
            intent = fVar.buildIntent(this);
        }
        n().v();
        startActivity(intent);
        finish();
        overridePendingTransition(2130772003, 2130772006);
    }

    private final void x() {
        super(0, 1, 0, n().l(), 5, 0);
        n().v();
        startActivity(iVar2.buildIntent(this));
        finish();
        overridePendingTransition(2130772003, 2130772006);
    }

    private final void z() {
        i iVar = new i();
        g1.n(this, iVar);
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
        int obj1;
        super.onActivityResult(i, i2, intent3);
        if (i == 157945) {
            if (i2 == -1) {
                y();
            } else {
                w();
            }
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        app.dogo.com.dogo_android.profile.invitation.g obj7;
        super.onCreate(bundle);
        setContentView(2131558431);
        n().u(m().a());
        androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        n.e(onBackPressedDispatcher, "onBackPressedDispatcher");
        DogInviteAcceptanceActivity.c cVar2 = new DogInviteAcceptanceActivity.c(this);
        e.b(onBackPressedDispatcher, this, false, cVar2, 2, 0);
        b bVar = new b(this);
        n().getResult().observe(this, bVar);
        d dVar = new d(this);
        n().n().observe(this, dVar);
        c cVar = new c(this);
        n().k().observe(this, cVar);
        a aVar = new a(this);
        n().m().observe(this, aVar);
        if (getSupportFragmentManager().p0() == 0 && !obj7 instanceof y.c) {
            if (!obj7 instanceof y.c) {
                n().r();
            }
        }
    }

    @Override // androidx.appcompat.app.d
    public final void y() {
        boolean z;
        if (!n().q()) {
            A();
        } else {
            if (!n().p()) {
                B();
            } else {
                if (!n().o()) {
                    z();
                } else {
                    x();
                }
            }
        }
    }
}
