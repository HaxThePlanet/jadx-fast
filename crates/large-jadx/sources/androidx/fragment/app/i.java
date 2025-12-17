package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import d.h.k.i;

/* loaded from: classes.dex */
public class i {

    private final androidx.fragment.app.k<?> a;
    private i(androidx.fragment.app.k<?> k) {
        super();
        this.a = k;
    }

    public static androidx.fragment.app.i b(androidx.fragment.app.k<?> k) {
        i.d(k, "callbacks == null");
        i iVar = new i((k)k);
        return iVar;
    }

    public void a(androidx.fragment.app.Fragment fragment) {
        final androidx.fragment.app.k kVar = this.a;
        kVar.v.l(kVar, kVar, fragment);
    }

    public void c() {
        kVar.v.A();
    }

    public void d(Configuration configuration) {
        kVar.v.C(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return kVar.v.D(menuItem);
    }

    public void f() {
        kVar.v.E();
    }

    public boolean g(Menu menu, MenuInflater menuInflater2) {
        return kVar.v.F(menu, menuInflater2);
    }

    public void h() {
        kVar.v.G();
    }

    public void i() {
        kVar.v.I();
    }

    public void j(boolean z) {
        kVar.v.J(z);
    }

    public boolean k(MenuItem menuItem) {
        return kVar.v.L(menuItem);
    }

    public void l(Menu menu) {
        kVar.v.M(menu);
    }

    public void m() {
        kVar.v.O();
    }

    public void n(boolean z) {
        kVar.v.P(z);
    }

    public boolean o(Menu menu) {
        return kVar.v.Q(menu);
    }

    public void p() {
        kVar.v.S();
    }

    public void q() {
        kVar.v.T();
    }

    public void r() {
        kVar.v.V();
    }

    public boolean s() {
        return kVar.v.c0(true);
    }

    public androidx.fragment.app.n t() {
        return kVar.v;
    }

    public void u() {
        kVar.v.W0();
    }

    public View v(View view, String string2, Context context3, AttributeSet attributeSet4) {
        return kVar.v.x0().onCreateView(view, string2, context3, attributeSet4);
    }

    public void w(Parcelable parcelable) {
        androidx.fragment.app.k kVar = this.a;
        if (!kVar instanceof j0) {
        } else {
            kVar.v.l1(parcelable);
        }
        IllegalStateException obj3 = new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        throw obj3;
    }

    public Parcelable x() {
        return kVar.v.n1();
    }
}
