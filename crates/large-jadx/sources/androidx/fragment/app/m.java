package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
class m {

    private final CopyOnWriteArrayList<androidx.fragment.app.m.a> a;
    private final androidx.fragment.app.n b;

    private static final class a {

        final androidx.fragment.app.n.m a;
        final boolean b;
    }
    m(androidx.fragment.app.n n) {
        super();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.a = copyOnWriteArrayList;
        this.b = n;
    }

    void a(androidx.fragment.app.Fragment fragment, Bundle bundle2, boolean z3) {
        Object fragment2;
        int next;
        androidx.fragment.app.n nVar;
        fragment2 = this.b.z0();
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().y0().a(fragment, bundle2, true);
        }
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (z3) {
            } else {
            }
            next.a.a(this.b, fragment, bundle2);
            if (next.b) {
            }
        }
    }

    void b(androidx.fragment.app.Fragment fragment, boolean z2) {
        Object fragment2;
        int next;
        androidx.fragment.app.n nVar;
        fragment2 = this.b.z0();
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().y0().b(fragment, true);
        }
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (z2) {
            } else {
            }
            next.a.b(this.b, fragment, this.b.w0().f());
            if (next.b) {
            }
        }
    }

    void c(androidx.fragment.app.Fragment fragment, Bundle bundle2, boolean z3) {
        Object fragment2;
        int next;
        androidx.fragment.app.n nVar;
        fragment2 = this.b.z0();
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().y0().c(fragment, bundle2, true);
        }
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (z3) {
            } else {
            }
            next.a.c(this.b, fragment, bundle2);
            if (next.b) {
            }
        }
    }

    void d(androidx.fragment.app.Fragment fragment, boolean z2) {
        Object fragment2;
        int next;
        androidx.fragment.app.n nVar;
        fragment2 = this.b.z0();
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().y0().d(fragment, true);
        }
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (z2) {
            } else {
            }
            next.a.d(this.b, fragment);
            if (next.b) {
            }
        }
    }

    void e(androidx.fragment.app.Fragment fragment, boolean z2) {
        Object fragment2;
        int next;
        androidx.fragment.app.n nVar;
        fragment2 = this.b.z0();
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().y0().e(fragment, true);
        }
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (z2) {
            } else {
            }
            next.a.e(this.b, fragment);
            if (next.b) {
            }
        }
    }

    void f(androidx.fragment.app.Fragment fragment, boolean z2) {
        Object fragment2;
        int next;
        androidx.fragment.app.n nVar;
        fragment2 = this.b.z0();
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().y0().f(fragment, true);
        }
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (z2) {
            } else {
            }
            next.a.f(this.b, fragment);
            if (next.b) {
            }
        }
    }

    void g(androidx.fragment.app.Fragment fragment, boolean z2) {
        Object fragment2;
        int next;
        androidx.fragment.app.n nVar;
        fragment2 = this.b.z0();
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().y0().g(fragment, true);
        }
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (z2) {
            } else {
            }
            next.a.g(this.b, fragment, this.b.w0().f());
            if (next.b) {
            }
        }
    }

    void h(androidx.fragment.app.Fragment fragment, Bundle bundle2, boolean z3) {
        Object fragment2;
        int next;
        androidx.fragment.app.n nVar;
        fragment2 = this.b.z0();
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().y0().h(fragment, bundle2, true);
        }
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (z3) {
            } else {
            }
            next.a.h(this.b, fragment, bundle2);
            if (next.b) {
            }
        }
    }

    void i(androidx.fragment.app.Fragment fragment, boolean z2) {
        Object fragment2;
        int next;
        androidx.fragment.app.n nVar;
        fragment2 = this.b.z0();
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().y0().i(fragment, true);
        }
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (z2) {
            } else {
            }
            next.a.i(this.b, fragment);
            if (next.b) {
            }
        }
    }

    void j(androidx.fragment.app.Fragment fragment, Bundle bundle2, boolean z3) {
        Object fragment2;
        int next;
        androidx.fragment.app.n nVar;
        fragment2 = this.b.z0();
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().y0().j(fragment, bundle2, true);
        }
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (z3) {
            } else {
            }
            next.a.j(this.b, fragment, bundle2);
            if (next.b) {
            }
        }
    }

    void k(androidx.fragment.app.Fragment fragment, boolean z2) {
        Object fragment2;
        int next;
        androidx.fragment.app.n nVar;
        fragment2 = this.b.z0();
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().y0().k(fragment, true);
        }
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (z2) {
            } else {
            }
            next.a.k(this.b, fragment);
            if (next.b) {
            }
        }
    }

    void l(androidx.fragment.app.Fragment fragment, boolean z2) {
        Object fragment2;
        int next;
        androidx.fragment.app.n nVar;
        fragment2 = this.b.z0();
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().y0().l(fragment, true);
        }
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (z2) {
            } else {
            }
            next.a.l(this.b, fragment);
            if (next.b) {
            }
        }
    }

    void m(androidx.fragment.app.Fragment fragment, View view2, Bundle bundle3, boolean z4) {
        Object fragment2;
        int next;
        androidx.fragment.app.n nVar;
        fragment2 = this.b.z0();
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().y0().m(fragment, view2, bundle3, true);
        }
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (z4) {
            } else {
            }
            next.a.m(this.b, fragment, view2, bundle3);
            if (next.b) {
            }
        }
    }

    void n(androidx.fragment.app.Fragment fragment, boolean z2) {
        Object fragment2;
        int next;
        androidx.fragment.app.n nVar;
        fragment2 = this.b.z0();
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().y0().n(fragment, true);
        }
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (z2) {
            } else {
            }
            next.a.n(this.b, fragment);
            if (next.b) {
            }
        }
    }
}
