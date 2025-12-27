package d.a.o;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.g.a;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* compiled from: StandaloneActionMode.java */
/* loaded from: classes.dex */
public class e extends b implements g.a {

    private Context c;
    private ActionBarContextView v;
    private b.a w;
    private WeakReference<View> x;
    private boolean y;
    private g z = new g();
    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        super();
        this.c = context;
        this.v = actionBarContextView;
        this.w = aVar;
        final g gVar = new g(actionBarContextView.getContext());
        gVar.W(1);
        gVar.V(this);
    }

    @Override // d.a.o.b
    public boolean a(g gVar, MenuItem menuItem) {
        return this.w.d(this, menuItem);
    }

    @Override // d.a.o.b
    public void b(g gVar) {
        k();
        this.v.l();
    }

    @Override // d.a.o.b
    public void c() {
        if (this.y) {
            return;
        }
        this.y = true;
        this.v.sendAccessibilityEvent(32);
        this.w.a(this);
    }

    @Override // d.a.o.b
    public View d() {
        Object obj = null;
        obj = this.x != null ? (View)obj : 0;
        return obj;
    }

    @Override // d.a.o.b
    public Menu e() {
        return this.z;
    }

    @Override // d.a.o.b
    public MenuInflater f() {
        return new g(this.v.getContext());
    }

    @Override // d.a.o.b
    public java.lang.CharSequence g() {
        return this.v.getSubtitle();
    }

    @Override // d.a.o.b
    public java.lang.CharSequence i() {
        return this.v.getTitle();
    }

    @Override // d.a.o.b
    public void k() {
        this.w.c(this, this.z);
    }

    @Override // d.a.o.b
    public boolean l() {
        return this.v.j();
    }

    @Override // d.a.o.b
    public void m(View view) {
        WeakReference weakReference = null;
        this.v.setCustomView(view);
        WeakReference r0 = view != null ? new WeakReference(view) : 0;
        this.x = (view != null ? new WeakReference(view) : 0);
    }

    @Override // d.a.o.b
    public void n(int i) {
        o(this.c.getString(i));
    }

    @Override // d.a.o.b
    public void o(java.lang.CharSequence charSequence) {
        this.v.setSubtitle(charSequence);
    }

    @Override // d.a.o.b
    public void q(int i) {
        r(this.c.getString(i));
    }

    @Override // d.a.o.b
    public void r(java.lang.CharSequence charSequence) {
        this.v.setTitle(charSequence);
    }

    @Override // d.a.o.b
    public void s(boolean z) {
        super.s(z);
        this.v.setTitleOptional(z);
    }
}
