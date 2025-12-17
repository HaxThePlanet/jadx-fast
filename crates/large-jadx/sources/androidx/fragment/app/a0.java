package androidx.fragment.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.d0;
import androidx.lifecycle.g0.b;
import androidx.lifecycle.i;
import androidx.lifecycle.i0;
import androidx.lifecycle.j;
import androidx.lifecycle.j.b;
import androidx.lifecycle.j.c;
import androidx.lifecycle.j0;
import androidx.lifecycle.s;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.b;
import androidx.savedstate.c;

/* loaded from: classes.dex */
class a0 implements i, c, j0 {

    private final androidx.fragment.app.Fragment a;
    private final i0 b;
    private g0.b c;
    private s v = null;
    private b w = null;
    a0(androidx.fragment.app.Fragment fragment, i0 i02) {
        super();
        final int i = 0;
        this.a = fragment;
        this.b = i02;
    }

    @Override // androidx.lifecycle.i
    void a(j.b j$b) {
        this.v.h(b);
    }

    @Override // androidx.lifecycle.i
    void b() {
        Object sVar;
        if (this.v == null) {
            s sVar2 = new s(this);
            this.v = sVar2;
            this.w = b.a(this);
        }
    }

    @Override // androidx.lifecycle.i
    boolean c() {
        int i;
        i = this.v != null ? 1 : 0;
        return i;
    }

    @Override // androidx.lifecycle.i
    void d(Bundle bundle) {
        this.w.c(bundle);
    }

    @Override // androidx.lifecycle.i
    void e(Bundle bundle) {
        this.w.d(bundle);
    }

    @Override // androidx.lifecycle.i
    void f(j.c j$c) {
        this.v.o(c);
    }

    @Override // androidx.lifecycle.i
    public g0.b getDefaultViewModelProviderFactory() {
        int bVar;
        Context applicationContext;
        boolean d0Var;
        boolean arguments;
        g0.b defaultViewModelProviderFactory = this.a.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(fragment2.mDefaultFactory)) {
            this.c = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.c == null) {
            bVar = 0;
            applicationContext = this.a.requireContext().getApplicationContext();
            while (applicationContext instanceof ContextWrapper) {
                if (applicationContext instanceof Application) {
                    break;
                } else {
                }
                applicationContext = (ContextWrapper)applicationContext.getBaseContext();
            }
            d0Var = new d0(bVar, this, this.a.getArguments());
            this.c = d0Var;
        }
        return this.c;
    }

    @Override // androidx.lifecycle.i
    public j getLifecycle() {
        b();
        return this.v;
    }

    @Override // androidx.lifecycle.i
    public SavedStateRegistry getSavedStateRegistry() {
        b();
        return this.w.b();
    }

    @Override // androidx.lifecycle.i
    public i0 getViewModelStore() {
        b();
        return this.b;
    }
}
