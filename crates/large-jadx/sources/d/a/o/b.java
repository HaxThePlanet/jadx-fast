package d.a.o;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* compiled from: ActionMode.java */
/* loaded from: classes.dex */
public abstract class b {

    private Object a;
    private boolean b;

    public interface a {
        void a(b bVar);

        boolean b(b bVar, Menu menu);

        boolean c(b bVar, Menu menu);

        boolean d(b bVar, MenuItem menuItem);
    }
    public Object h() {
        return this.a;
    }

    public boolean j() {
        return this.b;
    }

    public void p(Object object) {
        this.a = object;
    }

    public void s(boolean z) {
        this.b = z;
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract java.lang.CharSequence g();

    public abstract java.lang.CharSequence i();

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View view);

    public abstract void n(int i);

    public abstract void o(java.lang.CharSequence charSequence);

    public abstract void q(int i);

    public abstract void r(java.lang.CharSequence charSequence);
}
