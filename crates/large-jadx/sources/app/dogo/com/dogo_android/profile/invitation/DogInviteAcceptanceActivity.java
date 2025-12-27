package app.dogo.com.dogo_android.profile.invitation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.dogcreation.f;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.i1;
import app.dogo.com.dogo_android.util.t;
import app.dogo.com.dogo_android.util.t.a;
import app.dogo.com.dogo_android.view.main_screen.i;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import m.a.b.a.d.a.b;

/* compiled from: DogInviteAcceptanceActivity.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0008\u0010\u0011\u001a\u00020\u000eH\u0002J\"\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0012\u0010\u0018\u001a\u00020\u000e2\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0008\u0010\u001b\u001a\u00020\u000eH\u0002J\u0008\u0010\u001c\u001a\u00020\u000eH\u0002J\u0006\u0010\u001d\u001a\u00020\u000eJ\u0008\u0010\u001e\u001a\u00020\u000eH\u0002J\u0008\u0010\u001f\u001a\u00020\u000eH\u0002J\u0008\u0010 \u001a\u00020\u000eH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\u00088BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000b\u0010\u000c\u001a\u0004\u0008\t\u0010\n¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/profile/invitation/DogInviteAcceptanceActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "screenKey", "Lapp/dogo/com/dogo_android/profile/invitation/DogInviteAcceptanceFlowKey;", "getScreenKey", "()Lapp/dogo/com/dogo_android/profile/invitation/DogInviteAcceptanceFlowKey;", "viewModel", "Lapp/dogo/com/dogo_android/profile/invitation/DogInviteAcceptanceSharedViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/profile/invitation/DogInviteAcceptanceSharedViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "callCancelDialog", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFlowCancel", "onFlowComplete", "onShowNextScreen", "showInvite", "showLogin", "showUserInfo", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class DogInviteAcceptanceActivity extends androidx.appcompat.app.d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final DogInviteAcceptanceActivity.a INSTANCE = new DogInviteAcceptanceActivity$a(0);
    private final h a;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/profile/invitation/DogInviteAcceptanceActivity$Companion;", "", "()V", "DOG_INVITE_LOGIN_REQUEST_CODE", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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
            DogInviteAcceptanceActivity.this.w();
        }

        b() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<androidx.activity.d, w> {
        @Override // kotlin.d0.d.p
        public final void a(androidx.activity.d dVar) {
            n.f(dVar, "$this$addCallback");
            z = DogInviteAcceptanceActivity.this.n().n().getValue() instanceof LoadResult_Loading;
            if (!(DogInviteAcceptanceActivity.onCreate(DogInviteAcceptanceActivity.this).n().getValue() instanceof oadResult_Loading)) {
                DogInviteAcceptanceActivity.this.l();
            }
        }

        c() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            DogInviteAcceptanceActivity.this.n().r();
        }

        d() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class e extends p implements kotlin.d0.c.a<g> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final g invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DogInviteAcceptanceSharedViewModel.class), this.$parameters);
        }

        public e(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    public DogInviteAcceptanceActivity() {
        super();
        final m.a.c.j.a aVar = null;
        this.a = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new DogInviteAcceptanceActivity.e(this, aVar, aVar));
    }

    /* renamed from: A, reason: from kotlin metadata */
    private final void callCancelDialog() {
        startActivityForResult(app.dogo.com.dogo_android.util.extensionfunction.i1.f(this, "dog_owners_list", null, n().l(), 2, null), 157945);
        overridePendingTransition(2130772003, 2130772006);
    }

    private final void B() {
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(this, new InviteUserInformationScreen());
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ void attachBaseContext(DogInviteAcceptanceActivity newBase) {
        newBase.l();
    }

    /* renamed from: j, reason: from kotlin metadata */
    public static final /* synthetic */ g onCreate(DogInviteAcceptanceActivity savedInstanceState) {
        return savedInstanceState.n();
    }

    public static final /* synthetic */ void k(DogInviteAcceptanceActivity dogInviteAcceptanceActivity) {
        dogInviteAcceptanceActivity.w();
    }

    private final void l() {
        app.dogo.com.dogo_android.util.extensionfunction.f1.showChallengeDeleteOrReportDialog(this, new DogInviteAcceptanceActivity.b(this));
    }

    private final f m() {
        return (DogInviteAcceptanceFlowKey)app.dogo.com.dogo_android.util.extensionfunction.g1.l(this);
    }

    private final g n() {
        return (DogInviteAcceptanceSharedViewModel)this.a.getValue();
    }

    private static final void s(DogInviteAcceptanceActivity dogInviteAcceptanceActivity, y yVar) {
        Object yVar22;
        boolean z2;
        n.f(dogInviteAcceptanceActivity, "this$0");
        z = yVar instanceof LoadResult_Error;
        if (z) {
            yVar22 = yVar;
            z2 = yVar22.component1().getCause() instanceof DogParentInvitationException_InvitationHasExpired;
            if (yVar22.component1().getCause() instanceof DogParentInvitationException_InvitationHasExpired) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.i0(dogInviteAcceptanceActivity, BindingAdapters.a.i(yVar22.component1(), dogInviteAcceptanceActivity));
                dogInviteAcceptanceActivity.w();
            } else {
                if (z) {
                    app.dogo.com.dogo_android.util.extensionfunction.f1.h0(dogInviteAcceptanceActivity, new DogInviteAcceptanceActivity.d(dogInviteAcceptanceActivity));
                } else {
                    z3 = yVar instanceof LoadResult_Success;
                    if (yVar instanceof oadResult_Success) {
                        if (dogInviteAcceptanceActivity.getSupportFragmentManager().p0() == 0) {
                            dogInviteAcceptanceActivity.y();
                        }
                    }
                }
            }
        }
    }

    private static final void t(DogInviteAcceptanceActivity dogInviteAcceptanceActivity, y yVar) {
        n.f(dogInviteAcceptanceActivity, "this$0");
        z = yVar instanceof LoadResult_Error;
        if (yVar instanceof oadResult_Error) {
            z = yVar.component1().getCause() instanceof DogParentInvitationException_InvitationHasExpired;
            if (yVar.component1().getCause() instanceof DogParentInvitationException_InvitationHasExpired) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.i0(dogInviteAcceptanceActivity, BindingAdapters.a.i(yVar.component1(), dogInviteAcceptanceActivity));
                dogInviteAcceptanceActivity.w();
            }
        }
    }

    private static final void u(DogInviteAcceptanceActivity dogInviteAcceptanceActivity, Boolean boolean) {
        n.f(dogInviteAcceptanceActivity, "this$0");
        dogInviteAcceptanceActivity.onBackPressed();
    }

    private static final void v(DogInviteAcceptanceActivity dogInviteAcceptanceActivity, Boolean boolean) {
        n.f(dogInviteAcceptanceActivity, "this$0");
        dogInviteAcceptanceActivity.x();
    }

    private final void w() {
        Intent intent;
        if (n().doesUserHaveDogs()) {
            android.net.Uri uri = null;
            boolean z2 = false;
            app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation dogOwnerInvitation = null;
            int i = 13;
            g gVar = null;
            MainScreenKey mainScreenKey = new MainScreenKey(uri, m().b(), z2, dogOwnerInvitation, i, gVar);
            intent = mainScreenKey.buildIntent(this);
        } else {
            n().t();
            z2 = true;
            i = 2;
            gVar = null;
            DogCreationScreenKey dogCreationScreenKey = new DogCreationScreenKey(null, null, z2, true, i, gVar);
            intent = dogCreationScreenKey.buildIntent(this);
        }
        n().v();
        startActivity(intent);
        finish();
        overridePendingTransition(2130772003, 2130772006);
    }

    private final void x() {
        MainScreenKey mainScreenKey = new MainScreenKey(null, true, false, n().l(), 5, null);
        n().v();
        startActivity(mainScreenKey.buildIntent(this));
        finish();
        overridePendingTransition(2130772003, 2130772006);
    }

    private final void z() {
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(this, new DogInviteScreen());
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
        if (requestCode == 157945 && resultCode == -1) {
            y();
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558431);
        try {
            n().u(m().describeContents());
        } catch (Exception e) {
            a.d(e);
            e = 2131886123;
            app.dogo.com.dogo_android.util.extensionfunction.g1.g0(this, e);
            w();
        }
        androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        n.e(onBackPressedDispatcher, "onBackPressedDispatcher");
        e.b(onBackPressedDispatcher, this, false, new DogInviteAcceptanceActivity.c(this), 2, null);
        n().getResult().observe(this, new b(this));
        n().n().observe(this, new d(this));
        n().k().observe(this, new c(this));
        n().m().observe(this, new a(this));
        if (getSupportFragmentManager().p0() == 0) {
            if (!(n().getResult().getValue() instanceof LoadResult_Success)) {
                n().r();
            }
        }
    }

    @Override // androidx.appcompat.app.d
    public final void y() {
        if (!n().q()) {
            callCancelDialog();
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

    public static /* synthetic */ void o(DogInviteAcceptanceActivity dogInviteAcceptanceActivity, Boolean boolean) {
        DogInviteAcceptanceActivity.v(dogInviteAcceptanceActivity, boolean);
    }

    public static /* synthetic */ void p(DogInviteAcceptanceActivity dogInviteAcceptanceActivity, y yVar) {
        DogInviteAcceptanceActivity.s(dogInviteAcceptanceActivity, yVar);
    }

    public static /* synthetic */ void q(DogInviteAcceptanceActivity dogInviteAcceptanceActivity, Boolean boolean) {
        DogInviteAcceptanceActivity.u(dogInviteAcceptanceActivity, boolean);
    }

    public static /* synthetic */ void r(DogInviteAcceptanceActivity dogInviteAcceptanceActivity, y yVar) {
        DogInviteAcceptanceActivity.t(dogInviteAcceptanceActivity, yVar);
    }
}
