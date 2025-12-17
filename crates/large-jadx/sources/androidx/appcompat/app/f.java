package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.y0;
import d.a.o.b;
import d.a.o.b.a;
import d.e.b;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class f {

    private static int a = -100;
    private static final b<WeakReference<androidx.appcompat.app.f>> b;
    private static final Object c;
    static {
        b bVar = new b();
        f.b = bVar;
        Object object = new Object();
        f.c = object;
    }

    private static void A(androidx.appcompat.app.f f) {
        Object obj;
        final Object obj2 = f.c;
        Iterator iterator = f.b.iterator();
        synchronized (obj2) {
            while (iterator.hasNext()) {
                obj = (WeakReference)iterator.next().get();
                if ((f)obj != f) {
                } else {
                }
                iterator.remove();
                if ((f)obj == null) {
                }
            }
        }
    }

    public static void C(boolean z) {
        y0.b(z);
    }

    static void c(androidx.appcompat.app.f f) {
        final Object obj = f.c;
        f.A(f);
        WeakReference weakReference = new WeakReference(f);
        f.b.add(weakReference);
        return;
        synchronized (obj) {
            obj = f.c;
            f.A(f);
            weakReference = new WeakReference(f);
            f.b.add(weakReference);
        }
    }

    public static androidx.appcompat.app.f g(Activity activity, androidx.appcompat.app.e e2) {
        g gVar = new g(activity, e2);
        return gVar;
    }

    public static androidx.appcompat.app.f h(Dialog dialog, androidx.appcompat.app.e e2) {
        g gVar = new g(dialog, e2);
        return gVar;
    }

    public static int j() {
        return f.a;
    }

    public static boolean q() {
        return y0.a();
    }

    static void z(androidx.appcompat.app.f f) {
        final Object obj = f.c;
        f.A(f);
        return;
        synchronized (obj) {
            obj = f.c;
            f.A(f);
        }
    }

    public abstract boolean B(int i);

    public abstract void D(int i);

    public abstract void E(View view);

    public abstract void F(View view, ViewGroup.LayoutParams viewGroup$LayoutParams2);

    public abstract void G(Toolbar toolbar);

    public void H(int i) {
    }

    public abstract void I(java.lang.CharSequence charSequence);

    public abstract b J(b.a b$a);

    public abstract void d(View view, ViewGroup.LayoutParams viewGroup$LayoutParams2);

    @Deprecated
    public void e(Context context) {
    }

    public Context f(Context context) {
        e(context);
        return context;
    }

    public abstract <T extends View> T i(int i);

    public abstract androidx.appcompat.app.b k();

    public int l() {
        return -100;
    }

    public abstract MenuInflater m();

    public abstract androidx.appcompat.app.a n();

    public abstract void o();

    public abstract void p();

    public abstract void r(Configuration configuration);

    public abstract void s(Bundle bundle);

    public abstract void t();

    public abstract void u(Bundle bundle);

    public abstract void v();

    public abstract void w(Bundle bundle);

    public abstract void x();

    public abstract void y();
}
