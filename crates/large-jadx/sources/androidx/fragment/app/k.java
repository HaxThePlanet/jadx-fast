package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.a;
import androidx.core.content.a;
import d.h.k.i;

/* loaded from: classes.dex */
public abstract class k<E>  extends androidx.fragment.app.g {

    private final Activity a;
    private final Context b;
    private final Handler c;
    final androidx.fragment.app.n v;
    k(Activity activity, Context context2, Handler handler3, int i4) {
        super();
        o obj4 = new o();
        this.v = obj4;
        this.a = activity;
        i.d(context2, "context == null");
        this.b = (Context)context2;
        i.d(handler3, "handler == null");
        this.c = (Handler)handler3;
    }

    k(androidx.fragment.app.e e) {
        Handler handler = new Handler();
        super(e, e, handler, 0);
    }

    @Override // androidx.fragment.app.g
    public View c(int i) {
        return null;
    }

    @Override // androidx.fragment.app.g
    public boolean d() {
        return 1;
    }

    @Override // androidx.fragment.app.g
    Activity e() {
        return this.a;
    }

    @Override // androidx.fragment.app.g
    Context f() {
        return this.b;
    }

    @Override // androidx.fragment.app.g
    Handler g() {
        return this.c;
    }

    public abstract E h();

    @Override // androidx.fragment.app.g
    public LayoutInflater i() {
        return LayoutInflater.from(this.b);
    }

    @Deprecated
    public void j(androidx.fragment.app.Fragment fragment, String[] string2Arr2, int i3) {
    }

    @Override // androidx.fragment.app.g
    public boolean k(androidx.fragment.app.Fragment fragment) {
        return 1;
    }

    @Override // androidx.fragment.app.g
    public boolean l(String string) {
        return 0;
    }

    @Override // androidx.fragment.app.g
    public void m(androidx.fragment.app.Fragment fragment, Intent intent2, int i3, Bundle bundle4) {
        if (i3 != -1) {
        } else {
            a.n(this.b, intent2, bundle4);
        }
        IllegalStateException obj1 = new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        throw obj1;
    }

    @Deprecated
    public void n(androidx.fragment.app.Fragment fragment, IntentSender intentSender2, int i3, Intent intent4, int i5, int i6, int i7, Bundle bundle8) {
        if (i3 != -1) {
        } else {
            a.x(obj.a, intentSender2, i3, intent4, i5, i6, i7, bundle8);
        }
        Object obj2 = this;
        IllegalStateException illegalStateException = new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        throw illegalStateException;
    }

    @Override // androidx.fragment.app.g
    public void o() {
    }
}
