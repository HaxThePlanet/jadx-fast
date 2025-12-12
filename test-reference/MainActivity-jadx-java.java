package com.topjohnwu.magisk.ui;

import B1.a;
import G2.r;
import G3.C0027y;
import L1.x;
import M1.AbstractC0043a;
import P0.d;
import Q.c;
import R1.f;
import android.app.Activity;
import android.app.NotificationChannel;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import androidx.navigation.fragment.NavHostFragment;
import b2.EnumC0187a;
import com.topjohnwu.magisk.R;
import com.topjohnwu.magisk.core.JobService;
import com.topjohnwu.magisk.ui.MainActivity;
import com.topjohnwu.magisk.widget.ConcealableBottomNavigationView;
import d2.g;
import e3.e;
import f2.AbstractC0269f;
import f2.InterfaceC0266c;
import g2.AbstractC0307p;
import g2.T;
import java.lang.reflect.Field;
import java.util.Set;
import s2.C0854i;
import t2.AbstractC0931h;
import t2.AbstractC0932i;
import t2.AbstractC0933j;
import w1.AbstractC0984e;
import w1.AbstractC0986g;
import w1.i;
import x1.AbstractC1005c;
import x1.AbstractC1006d;
import x1.C1007e;
import x1.C1014l;
import x1.ComponentCallbacks2C1004b;

/* loaded from: classes.dex */
public final class MainActivity extends i {

    /* renamed from: S, reason: collision with root package name */
    public static final /* synthetic */ int f4972S = 0;

    /* renamed from: T, reason: collision with root package name */
    public static final /* synthetic */ int f4973T = 0;
    public final C0854i M = new C0854i(new a(9, this));
    public final int N = R.layout.activity_main_md2;

    /* renamed from: O, reason: collision with root package name */
    public final Object f4974O = e.s(3, new R1.e(0, this));

    /* renamed from: P, reason: collision with root package name */
    public final int f4975P = R.id.main_nav_host;

    /* renamed from: Q, reason: collision with root package name */
    public final d f4976Q = new d(this);

    /* renamed from: R, reason: collision with root package name */
    public boolean f4977R = true;

    public static void B(MainActivity mainActivity, boolean z5, boolean z6, int i) {
        if ((i & 1) != 0) {
            z5 = true;
        }
        if ((i & 2) != 0) {
            z6 = true;
        }
        androidx.databinding.a aVar = mainActivity.f9956K;
        if (aVar == null) {
            aVar = null;
        }
        ConcealableBottomNavigationView concealableBottomNavigationView = ((AbstractC0043a) aVar).f1604H;
        if (!z6) {
            concealableBottomNavigationView.setVisibility(z5 ? 8 : 0);
        } else {
            concealableBottomNavigationView.setVisibility(0);
            concealableBottomNavigationView.setHidden(z5);
        }
    }

    public final AbstractC0984e A() {
        Object objW = AbstractC0932i.W(((NavHostFragment) this.M.getValue()).m().f5878c.n(), 0);
        if (objW instanceof AbstractC0984e) {
            return (AbstractC0984e) objW;
        }
        return null;
    }

    public final void C(boolean z5) {
        androidx.databinding.a aVar = this.f9956K;
        if (aVar == null) {
            aVar = null;
        }
        e1.a.i0(((AbstractC0043a) aVar).f1605I);
        if (z5) {
            androidx.databinding.a aVar2 = this.f9956K;
            ((AbstractC0043a) (aVar2 != null ? aVar2 : null)).f1605I.setNavigationIcon(R.drawable.ic_back_md2);
        } else {
            androidx.databinding.a aVar3 = this.f9956K;
            if (aVar3 == null) {
                aVar3 = null;
            }
            ((AbstractC0043a) aVar3).f1605I.setNavigationIcon((Drawable) null);
        }
    }

    @Override // h.AbstractActivityC0354i, F.h, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AbstractC0984e abstractC0984eA;
        if (this.f9956K == null || (abstractC0984eA = A()) == null || !abstractC0984eA.W(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, s2.c] */
    @Override // w1.l
    public final AbstractC0986g g() {
        return (f) this.f4974O.getValue();
    }

    @Override // b.AbstractActivityC0172l, android.app.Activity
    public final void onBackPressed() {
        AbstractC0984e abstractC0984eA;
        if (this.f9956K == null || (abstractC0984eA = A()) == null || abstractC0984eA.V()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // w1.i, h.AbstractActivityC0354i, b.AbstractActivityC0172l, F.h, android.app.Activity
    public final void onCreate(final Bundle bundle) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, SecurityException, IllegalArgumentException {
        EnumC0187a enumC0187a = (EnumC0187a) AbstractC0931h.s0(C1007e.f10004a.e(), EnumC0187a.values());
        if (enumC0187a == null) {
            enumC0187a = EnumC0187a.f4364n;
        }
        setTheme(enumC0187a.f4367m);
        final d dVar = this.f4976Q;
        dVar.getClass();
        boolean zA = AbstractC1006d.a();
        MainActivity mainActivity = (MainActivity) dVar.f1978m;
        if (zA && !d.f1976n) {
            mainActivity.getTheme().applyStyle(R.style.StubSplashTheme, true);
        }
        super.onCreate(bundle);
        if (!AbstractC1006d.a()) {
            B.i cVar = Build.VERSION.SDK_INT >= 31 ? new c(mainActivity) : new B.i(mainActivity);
            cVar.E();
            cVar.Q(new B1.f(15));
        }
        if (d.f1976n) {
            dVar.d(bundle);
        } else {
            AbstractC0307p.c(AbstractC0269f.f5264l, new InterfaceC0266c() { // from class: y1.d
                @Override // f2.InterfaceC0266c
                public final void b(T t5) throws Throwable {
                    String launchedFromPackage;
                    int i = 1;
                    int i5 = 0;
                    boolean zA2 = AbstractC1006d.a();
                    P0.d dVar2 = dVar;
                    if (zA2 && !t5.i()) {
                        MainActivity mainActivity2 = (MainActivity) dVar2.f1978m;
                        mainActivity2.runOnUiThread(new R1.b(mainActivity2, i5));
                        return;
                    }
                    MainActivity mainActivity3 = (MainActivity) dVar2.f1978m;
                    if (Build.VERSION.SDK_INT >= 34) {
                        launchedFromPackage = mainActivity3.getLaunchedFromPackage();
                    } else {
                        C0854i c0854i = D1.e.f437a;
                        Field declaredField = Activity.class.getDeclaredField("mReferrer");
                        declaredField.setAccessible(true);
                        launchedFromPackage = (String) declaredField.get(mainActivity3);
                    }
                    Bundle bundleExtra = mainActivity3.getIntent().getBundleExtra("prev_config");
                    boolean z5 = (launchedFromPackage == null || bundleExtra == null) ? false : true;
                    C1007e c1007e = C1007e.f10004a;
                    if (bundleExtra != null && c1007e.c().getAll().isEmpty()) {
                        Set<String> setKeySet = bundleExtra.keySet();
                        setKeySet.removeAll(AbstractC1005c.f9996a);
                        SharedPreferences.Editor editorEdit = c1007e.c().edit();
                        for (String str : setKeySet) {
                            Object obj = bundleExtra.get(str);
                            if (obj instanceof String) {
                                editorEdit.putString(str, (String) obj);
                            } else if (obj instanceof Integer) {
                                editorEdit.putInt(str, ((Number) obj).intValue());
                            } else if (obj instanceof Boolean) {
                                editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
                            }
                        }
                        editorEdit.apply();
                    }
                    SharedPreferences.Editor editorEdit2 = c1007e.c().edit();
                    C1007e c1007e2 = C1007e.f10004a;
                    if (c1007e2.c().getBoolean("su_fingerprint", false)) {
                        L2.c cVar2 = C1007e.f10005b[21];
                        ((C0027y) C1007e.f10001C.f250m).j(c1007e2, 1);
                    }
                    editorEdit2.remove("su_fingerprint");
                    String string = c1007e2.c().getString("update_channel", null);
                    if (string == null || Integer.parseInt(string) > 4 || Integer.parseInt(string) < -1) {
                        editorEdit2.putString("update_channel", String.valueOf(C1007e.f10006c));
                    }
                    editorEdit2.apply();
                    if (r.a(mainActivity3.getPackageName(), "com.topjohnwu.magisk")) {
                        L2.c[] cVarArr = C1007e.f10005b;
                        L2.c cVar3 = cVarArr[13];
                        B.i iVar = C1007e.f10022u;
                        if (iVar.D(c1007e2).length() > 0) {
                            L2.c cVar4 = cVarArr[13];
                            iVar.S(c1007e2, "");
                        }
                        if (z5) {
                            AbstractC0269f.b(B.c.i("(pm uninstall ", launchedFromPackage, ")& >/dev/null 2>&1")).z();
                        }
                    } else {
                        try {
                            mainActivity3.getPackageManager().getApplicationInfo("com.topjohnwu.magisk", 0);
                            AbstractC0269f.b("(pm uninstall com.topjohnwu.magisk)& >/dev/null 2>&1").z();
                        } catch (Throwable unused) {
                        }
                    }
                    if (z5) {
                        mainActivity3.runOnUiThread(new R1.b(mainActivity3, i));
                    } else if (!AbstractC1006d.a() || (((Integer) ((Object[]) C1014l.f10039b.f3064m)[0]).intValue() == 40 && !N2.f.j0(mainActivity3.getIntent().getComponent().getClassName(), "COMPONENT_PLACEHOLDER", false))) {
                        C0854i c0854i2 = g.f5130a;
                        ComponentCallbacks2C1004b componentCallbacks2C1004b = ComponentCallbacks2C1004b.f9992l;
                        if (Build.VERSION.SDK_INT >= 26) {
                            C1.e.k();
                            NotificationChannel notificationChannelC = C1.e.c(componentCallbacks2C1004b.getString(R.string.update_channel));
                            C1.e.k();
                            NotificationChannel notificationChannelA = C1.e.A(componentCallbacks2C1004b.getString(R.string.progress_channel));
                            C1.e.k();
                            g.a().createNotificationChannels(AbstractC0933j.M(notificationChannelC, notificationChannelA, C1.e.D(componentCallbacks2C1004b.getString(R.string.updated_channel))));
                        }
                        int i6 = JobService.f4938m;
                        AbstractC1006d.b(mainActivity3);
                        i3.e.X(mainActivity3);
                        B1.e.b();
                        x.f1480l.a();
                    } else {
                        mainActivity3.z("android.permission.REQUEST_INSTALL_PACKAGES", new C1.f(5, mainActivity3, dVar2));
                    }
                    ((MainActivity) dVar2.f1978m).runOnUiThread(new D1.b(12, dVar2, bundle));
                }
            });
        }
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // w1.i, h.AbstractActivityC0354i, android.app.Activity
    public final void onResume() {
        super.onResume();
        d dVar = this.f4976Q;
        if (dVar.f1977l) {
            dVar.d(null);
        }
    }

    @Override // w1.i
    public final int v() {
        return this.N;
    }

    @Override // w1.i
    public final View w() {
        AbstractC0984e abstractC0984eA = A();
        View viewT = abstractC0984eA != null ? abstractC0984eA.T() : null;
        if (viewT != null && viewT.getVisibility() == 0) {
            return viewT;
        }
        androidx.databinding.a aVar = this.f9956K;
        if (aVar == null) {
            aVar = null;
        }
        if (((AbstractC0043a) aVar).f1604H.getVisibility() != 0) {
            return null;
        }
        androidx.databinding.a aVar2 = this.f9956K;
        return ((AbstractC0043a) (aVar2 != null ? aVar2 : null)).f1604H;
    }

    @Override // w1.i
    public final View x() {
        AbstractC0984e abstractC0984eA = A();
        View viewU = abstractC0984eA != null ? abstractC0984eA.U() : null;
        return viewU == null ? super.x() : viewU;
    }
}
