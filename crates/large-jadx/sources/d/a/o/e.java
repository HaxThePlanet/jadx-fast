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

/* loaded from: classes.dex */
public class e extends d.a.o.b implements g.a {

    private Context c;
    private ActionBarContextView v;
    private d.a.o.b.a w;
    private WeakReference<View> x;
    private boolean y;
    private g z;
    public e(Context context, ActionBarContextView actionBarContextView2, d.a.o.b.a b$a3, boolean z4) {
        super();
        this.c = context;
        this.v = actionBarContextView2;
        this.w = a3;
        g obj1 = new g(actionBarContextView2.getContext());
        obj1.W(1);
        this.z = obj1;
        obj1.V(this);
    }

    @Override // d.a.o.b
    public boolean a(g g, MenuItem menuItem2) {
        return this.w.d(this, menuItem2);
    }

    @Override // d.a.o.b
    public void b(g g) {
        k();
        this.v.l();
    }

    @Override // d.a.o.b
    public void c() {
        if (this.y) {
        }
        this.y = true;
        this.v.sendAccessibilityEvent(32);
        this.w.a(this);
    }

    @Override // d.a.o.b
    public View d() {
        Object obj;
        WeakReference weakReference = this.x;
        if (weakReference != null) {
            obj = weakReference.get();
        } else {
            obj = 0;
        }
        return obj;
    }

    @Override // d.a.o.b
    public Menu e() {
        return this.z;
    }

    @Override // d.a.o.b
    public MenuInflater f() {
        g gVar = new g(this.v.getContext());
        return gVar;
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
        WeakReference weakReference;
        this.v.setCustomView(view);
        if (view != null) {
            weakReference = new WeakReference(view);
        } else {
            weakReference = 0;
        }
        this.x = weakReference;
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
