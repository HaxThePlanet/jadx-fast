package app.dogo.com.dogo_android.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Display;
import android.view.Display.Mode;
import android.view.WindowManager;
import androidx.appcompat.app.c.a;
import androidx.appcompat.app.d;
import androidx.fragment.app.e;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.a0.f;
import app.dogo.com.dogo_android.repository.domain.DogoIntent;
import app.dogo.com.dogo_android.repository.domain.SplashDataHolder;
import com.google.android.gms.common.e;
import com.iterable.iterableapi.f0;
import com.iterable.iterableapi.j;
import f.c.a.e.s.b;
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
import m.a.b.a.d.a.b;
import m.a.c.j.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\t\u001a\u00020\nH\u0002J\"\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\u000c2\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0008\u0010\u0015\u001a\u00020\u000cH\u0014J\u0008\u0010\u0016\u001a\u00020\u000cH\u0002J\u0010\u0010\u0017\u001a\u00020\u000c2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0008\u0010\u0019\u001a\u00020\u000cH\u0002J\u0008\u0010\u001a\u001a\u00020\u000cH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/view/SplashActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "viewModel", "Lapp/dogo/com/dogo_android/viewmodel/SplashScreenViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/viewmodel/SplashScreenViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isGoogleServicesAvailable", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "resolveGooglePlay", "restartOrDismissActivityFLow", "isSuccess", "showGooglePlayFailDialog", "trackDeviceDisplayMetrics", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SplashActivity extends d {

    public static final app.dogo.com.dogo_android.view.SplashActivity.a Companion;
    private final h a;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/view/SplashActivity$Companion;", "", "()V", "REQUEST_CODE_PLAY_SERVICES", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<f> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final f invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(f.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
        SplashActivity.a aVar = new SplashActivity.a(0);
        SplashActivity.Companion = aVar;
    }

    public SplashActivity() {
        super();
        final int i = 0;
        SplashActivity.b bVar = new SplashActivity.b(this, i, i);
        this.a = j.a(m.SYNCHRONIZED, bVar);
    }

    private final f i() {
        return (f)this.a.getValue();
    }

    private final boolean j() {
        int i;
        i = e.o().g(this) == 0 ? 1 : 0;
        return i;
    }

    public static void k(app.dogo.com.dogo_android.view.SplashActivity splashActivity, SplashDataHolder splashDataHolder2) {
        SplashActivity.q(splashActivity, splashDataHolder2);
    }

    public static void l(app.dogo.com.dogo_android.view.SplashActivity splashActivity, DialogInterface dialogInterface2, int i3) {
        SplashActivity.v(splashActivity, dialogInterface2, i3);
    }

    public static void m(app.dogo.com.dogo_android.view.SplashActivity splashActivity, DialogInterface dialogInterface2) {
        SplashActivity.s(splashActivity, dialogInterface2);
    }

    public static void n(app.dogo.com.dogo_android.view.SplashActivity splashActivity, DialogInterface dialogInterface2) {
        SplashActivity.w(splashActivity, dialogInterface2);
    }

    public static void o(app.dogo.com.dogo_android.view.SplashActivity splashActivity, Boolean boolean2) {
        SplashActivity.p(splashActivity, boolean2);
    }

    private static final void p(app.dogo.com.dogo_android.view.SplashActivity splashActivity, Boolean boolean2) {
        f obj2;
        n.f(splashActivity, "this$0");
        if (boolean2 == null) {
        } else {
            boolean2.booleanValue();
            splashActivity.i().L(splashActivity);
        }
    }

    private static final void q(app.dogo.com.dogo_android.view.SplashActivity splashActivity, SplashDataHolder splashDataHolder2) {
        n.f(splashActivity, "this$0");
        DogoIntent obj3 = splashDataHolder2.getNextIntent(splashActivity);
        a.f(n.o("Starting activity with ", obj3.getConvertToString()), new Object[0]);
        splashActivity.startActivity(obj3.getIntent());
        splashActivity.finish();
    }

    private final void r() {
        Object obj;
        int iVar;
        boolean z;
        e eVar = e.o();
        n.e(eVar, "getInstance()");
        iVar = eVar.g(this);
        if (eVar.j(iVar)) {
            i().P(iVar);
            obj = eVar.l(this, iVar, 2000);
            if (obj == null) {
            } else {
                obj.setCancelable(false);
            }
            if (obj == null) {
            } else {
                iVar = new i(this);
                obj.setOnCancelListener(iVar);
            }
            if (obj == null) {
            } else {
                obj.show();
            }
        } else {
            i().P(iVar);
            u();
        }
    }

    private static final void s(app.dogo.com.dogo_android.view.SplashActivity splashActivity, DialogInterface dialogInterface2) {
        n.f(splashActivity, "this$0");
        splashActivity.u();
    }

    private final void t(boolean z) {
        DogoIntent dogoIntent;
        Intent intent;
        String str;
        f obj4;
        if (z) {
            intent = getIntent();
            n.e(intent, "intent");
            dogoIntent = new DogoIntent(intent);
            i().K(dogoIntent);
        } else {
            setResult(0);
            finish();
        }
    }

    private final void u() {
        b bVar = new b(this);
        h hVar = new h(this);
        j jVar = new j(this);
        bVar.w(2131886507).D(2131886691, hVar).B(jVar).o();
    }

    private static final void v(app.dogo.com.dogo_android.view.SplashActivity splashActivity, DialogInterface dialogInterface2, int i3) {
        n.f(splashActivity, "this$0");
        splashActivity.t(false);
    }

    private static final void w(app.dogo.com.dogo_android.view.SplashActivity splashActivity, DialogInterface dialogInterface2) {
        n.f(splashActivity, "this$0");
        splashActivity.t(false);
    }

    private final void x() {
        Display defaultDisplay;
        int physicalHeight;
        float density;
        f fVar;
        if (Build.VERSION.SDK_INT >= 30) {
            defaultDisplay = getDisplay();
        } else {
            defaultDisplay = getWindowManager().getDefaultDisplay();
        }
        if (defaultDisplay == null) {
        } else {
            defaultDisplay = defaultDisplay.getMode();
            if (defaultDisplay == null) {
            } else {
                i().N(defaultDisplay.getPhysicalHeight(), defaultDisplay.getPhysicalWidth(), displayMetrics.density);
            }
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onActivityResult(int i, int i2, Intent intent3) {
        int i3;
        int i4;
        super.onActivityResult(i, i2, intent3);
        StringBuilder obj6 = new StringBuilder();
        obj6.append("Google play service ");
        obj6.append(i);
        obj6.append(' ');
        obj6.append(i2);
        i3 = 0;
        a.i(obj6.toString(), new Object[i3]);
        obj6 = 1;
        int i6 = -1;
        if (i == 2000) {
            if (i2 == 0) {
                u();
            } else {
                i4 = i2 == i6 ? obj6 : i3;
                t(i4);
            }
        }
        if (i == 7899 && i2 == i6) {
            if (i2 == i6) {
                i3 = obj6;
            }
            t(i3);
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        DogoIntent dogoIntent;
        Intent intent;
        String str;
        f obj4;
        super.onCreate(bundle);
        k kVar = new k(this);
        i().B().observe(this, kVar);
        g gVar = new g(this);
        i().D().observe(this, gVar);
        j.s().q().D(true);
        if (j()) {
            intent = getIntent();
            n.e(intent, "intent");
            dogoIntent = new DogoIntent(intent);
            i().K(dogoIntent);
        } else {
            r();
        }
        x();
    }

    @Override // androidx.appcompat.app.d
    protected void onResume() {
        boolean z;
        super.onResume();
        if (j()) {
            i().H();
        }
    }
}
