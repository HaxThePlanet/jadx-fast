package app.dogo.com.dogo_android.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Display.Mode;
import android.view.WindowManager;
import androidx.appcompat.app.c.a;
import androidx.appcompat.app.d;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.a0.f;
import app.dogo.com.dogo_android.repository.domain.DogoIntent;
import app.dogo.com.dogo_android.repository.domain.SplashDataHolder;
import com.iterable.iterableapi.f0;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.m;

/* compiled from: SplashActivity.kt */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\t\u001a\u00020\nH\u0002J\"\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\u000c2\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0008\u0010\u0015\u001a\u00020\u000cH\u0014J\u0008\u0010\u0016\u001a\u00020\u000cH\u0002J\u0010\u0010\u0017\u001a\u00020\u000c2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0008\u0010\u0019\u001a\u00020\u000cH\u0002J\u0008\u0010\u001a\u001a\u00020\u000cH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/view/SplashActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "viewModel", "Lapp/dogo/com/dogo_android/viewmodel/SplashScreenViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/viewmodel/SplashScreenViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isGoogleServicesAvailable", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "resolveGooglePlay", "restartOrDismissActivityFLow", "isSuccess", "showGooglePlayFailDialog", "trackDeviceDisplayMetrics", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SplashActivity extends d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final SplashActivity.a INSTANCE = new SplashActivity$a(0);
    private final h a;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/view/SplashActivity$Companion;", "", "()V", "REQUEST_CODE_PLAY_SERVICES", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<f> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final f invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(SplashScreenViewModel.class), this.$parameters);
        }

        public b(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    public SplashActivity() {
        super();
        final m.a.c.j.a aVar = null;
        this.a = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new SplashActivity.b(this, aVar, aVar));
    }

    /* renamed from: i, reason: from kotlin metadata */
    private final f isGoogleServicesAvailable() {
        return (SplashScreenViewModel)this.a.getValue();
    }

    private final boolean j() {
        boolean z = true;
        int r0 = e.o().g(this) == 0 ? 1 : 0;
        return (e.o().g(this) == 0 ? 1 : 0);
    }

    private static final void p(SplashActivity splashActivity, Boolean boolean) {
        n.f(splashActivity, "this$0");
        if (boolean != null) {
            boolean.booleanValue();
            splashActivity.isGoogleServicesAvailable().L(splashActivity);
        }
    }

    private static final void q(SplashActivity splashActivity, SplashDataHolder splashDataHolder) {
        n.f(splashActivity, "this$0");
        DogoIntent nextIntent = splashDataHolder.getNextIntent(splashActivity);
        a.f(n.o("Starting activity with ", nextIntent.getConvertToString()), new Object[0]);
        splashActivity.startActivity(nextIntent.getIntent());
        splashActivity.finish();
    }

    private final void r() {
        boolean z = false;
        app.dogo.com.dogo_android.view.i iVar;
        com.google.android.gms.common.e eVar = e.o();
        n.e(eVar, "getInstance()");
        int i = eVar.g(this);
        if (eVar.j(i)) {
            isGoogleServicesAvailable().P(i);
            Dialog dialog = eVar.l(this, i, 2000);
            if (dialog != null) {
                z = false;
                dialog.setCancelable(z);
            }
            if (dialog != null) {
                dialog.setOnCancelListener(new i(this));
            }
            if (dialog != null) {
                dialog.show();
            }
        } else {
            isGoogleServicesAvailable().P(i);
            u();
        }
    }

    private static final void s(SplashActivity splashActivity, DialogInterface dialogInterface) {
        n.f(splashActivity, "this$0");
        splashActivity.u();
    }

    /* renamed from: t, reason: from kotlin metadata */
    private final void onCreate(boolean savedInstanceState) {
        if (savedInstanceState) {
            Intent intent = getIntent();
            str = "intent";
            n.e(intent, str);
            isGoogleServicesAvailable().K(new DogoIntent(intent));
        } else {
            setResult(0);
            finish();
        }
    }

    private final void u() {
        new b(this).w(2131886507).D(2131886691, new h(this)).B(new j(this)).o();
    }

    private static final void v(SplashActivity splashActivity, DialogInterface dialogInterface, int i) {
        n.f(splashActivity, "this$0");
        splashActivity.onCreate(false);
    }

    private static final void w(SplashActivity splashActivity, DialogInterface dialogInterface) {
        n.f(splashActivity, "this$0");
        splashActivity.onCreate(false);
    }

    private final void x() {
        Display defaultDisplay;
        int physicalHeight = 30;
        if (Build.VERSION.SDK_INT >= 30) {
            defaultDisplay = getDisplay();
        } else {
            defaultDisplay = getWindowManager().getDefaultDisplay();
        }
        if (Build.VERSION.SDK_INT != null) {
            Display.Mode mode = defaultDisplay.getMode();
            if (mode != null) {
                isGoogleServicesAvailable().N(mode.getPhysicalHeight(), mode.getPhysicalWidth(), getResources().getDisplayMetrics().density);
            }
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = false;
        boolean z2;
        super.onActivityResult(i, i2, intent);
        StringBuilder stringBuilder = new StringBuilder();
        String str = "Google play service ";
        str2 = str + i + 32 + i2;
        int i3 = 0;
        a.i(str2, new Object[i3]);
        int intent32 = 1;
        int i6 = -1;
        int i4 = 2000;
        if (i == 2000 && i2 == 0) {
            u();
        }
        if (i == 7899 && i2 == i6) {
            onCreate(z);
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        isGoogleServicesAvailable().checkIsAppUpdateAvailable().observe(this, new k(this));
        isGoogleServicesAvailable().D().observe(this, new g(this));
        j.s().q().D(true);
        if (j()) {
            Intent intent = getIntent();
            str = "intent";
            n.e(intent, str);
            isGoogleServicesAvailable().K(new DogoIntent(intent));
        } else {
            r();
        }
        x();
    }

    @Override // androidx.appcompat.app.d
    protected void onResume() {
        super.onResume();
        if (j()) {
            isGoogleServicesAvailable().H();
        }
    }

    public static /* synthetic */ void k(SplashActivity splashActivity, SplashDataHolder splashDataHolder) {
        SplashActivity.q(splashActivity, splashDataHolder);
    }

    /* renamed from: l, reason: from kotlin metadata */
    public static /* synthetic */ void onActivityResult(SplashActivity requestCode, DialogInterface resultCode, int data) {
        SplashActivity.v(requestCode, resultCode, data);
    }

    public static /* synthetic */ void m(SplashActivity splashActivity, DialogInterface dialogInterface) {
        SplashActivity.s(splashActivity, dialogInterface);
    }

    public static /* synthetic */ void n(SplashActivity splashActivity, DialogInterface dialogInterface) {
        SplashActivity.w(splashActivity, dialogInterface);
    }

    public static /* synthetic */ void o(SplashActivity splashActivity, Boolean boolean) {
        SplashActivity.p(splashActivity, boolean);
    }
}
