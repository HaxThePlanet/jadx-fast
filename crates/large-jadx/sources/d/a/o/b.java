package d.a.o;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public abstract class b {

    private Object a;
    private boolean b;

    public interface a {
        public abstract void a(d.a.o.b b);

        public abstract boolean b(d.a.o.b b, Menu menu2);

        public abstract boolean c(d.a.o.b b, Menu menu2);

        public abstract boolean d(d.a.o.b b, MenuItem menuItem2);
    }
    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract java.lang.CharSequence g();

    public Object h() {
        return this.a;
    }

    public abstract java.lang.CharSequence i();

    public boolean j() {
        return this.b;
    }

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View view);

    public abstract void n(int i);

    public abstract void o(java.lang.CharSequence charSequence);

    public void p(Object object) {
        this.a = object;
    }

    public abstract void q(int i);

    public abstract void r(java.lang.CharSequence charSequence);

    public void s(boolean z) {
        this.b = z;
    }
}
