package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window.Callback;
import androidx.appcompat.view.menu.g.a;
import androidx.appcompat.view.menu.m.a;
import d.h.l.z;

/* loaded from: classes.dex */
public interface z {
    public abstract void a(Menu menu, m.a m$a2);

    public abstract boolean b();

    public abstract void c();

    public abstract void collapseActionView();

    public abstract boolean d();

    public abstract boolean e();

    public abstract boolean f();

    public abstract boolean g();

    public abstract Context getContext();

    public abstract java.lang.CharSequence getTitle();

    public abstract void h();

    public abstract void i(androidx.appcompat.widget.m0 m0);

    public abstract boolean j();

    public abstract void k(int i);

    public abstract Menu l();

    public abstract void m(int i);

    public abstract int n();

    public abstract z o(int i, long l2);

    public abstract void p(m.a m$a, g.a g$a2);

    public abstract void q(int i);

    public abstract ViewGroup r();

    public abstract void s(boolean z);

    public abstract void setIcon(int i);

    public abstract void setIcon(Drawable drawable);

    public abstract void setTitle(java.lang.CharSequence charSequence);

    public abstract void setWindowCallback(Window.Callback window$Callback);

    public abstract void setWindowTitle(java.lang.CharSequence charSequence);

    public abstract int t();

    public abstract void u();

    public abstract void v();

    public abstract void w(boolean z);
}
