package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.b;
import d.h.l.u;
import d.m.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
abstract class c0 {

    private final ViewGroup a;
    final ArrayList<androidx.fragment.app.c0.e> b;
    final ArrayList<androidx.fragment.app.c0.e> c;
    boolean d = false;
    boolean e = false;

    class a implements Runnable {

        final androidx.fragment.app.c0.d a;
        final androidx.fragment.app.c0 b;
        a(androidx.fragment.app.c0 c0, androidx.fragment.app.c0.d c0$d2) {
            this.b = c0;
            this.a = d2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean contains;
            Object mView;
            if (c0Var.b.contains(this.a)) {
                this.a.e().applyState(fragment.mView);
            }
        }
    }

    class b implements Runnable {

        final androidx.fragment.app.c0.d a;
        final androidx.fragment.app.c0 b;
        b(androidx.fragment.app.c0 c0, androidx.fragment.app.c0.d c0$d2) {
            this.b = c0;
            this.a = d2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            c0Var.b.remove(this.a);
            c0Var2.c.remove(this.a);
        }
    }

    static class c {

        static final int[] a;
        static final int[] b;
        static {
            int[] iArr = new int[values.length];
            c0.c.b = iArr;
            int i2 = 1;
            iArr[c0.e.b.ADDING.ordinal()] = i2;
            int i = 2;
            c0.c.b[c0.e.b.REMOVING.ordinal()] = i;
            int i3 = 3;
            c0.c.b[c0.e.b.NONE.ordinal()] = i3;
            int[] iArr7 = new int[values2.length];
            c0.c.a = iArr7;
            iArr7[c0.e.c.REMOVED.ordinal()] = i2;
            c0.c.a[c0.e.c.VISIBLE.ordinal()] = i;
            c0.c.a[c0.e.c.GONE.ordinal()] = i3;
            c0.c.a[c0.e.c.INVISIBLE.ordinal()] = 4;
        }
    }

    static class e {

        private androidx.fragment.app.c0.e.c a;
        private androidx.fragment.app.c0.e.b b;
        private final androidx.fragment.app.Fragment c;
        private final List<Runnable> d;
        private final HashSet<b> e;
        private boolean f = false;
        private boolean g = false;
        e(androidx.fragment.app.c0.e.c c0$e$c, androidx.fragment.app.c0.e.b c0$e$b2, androidx.fragment.app.Fragment fragment3, b b4) {
            super();
            ArrayList arrayList = new ArrayList();
            this.d = arrayList;
            HashSet hashSet = new HashSet();
            this.e = hashSet;
            int i = 0;
            this.a = c;
            this.b = b2;
            this.c = fragment3;
            c0.e.a obj2 = new c0.e.a(this);
            b4.c(obj2);
        }

        final void a(Runnable runnable) {
            this.d.add(runnable);
        }

        final void b() {
            boolean iterator;
            boolean next;
            HashSet next2;
            if (h()) {
            }
            this.f = true;
            if (this.e.isEmpty()) {
                c();
            } else {
                ArrayList arrayList = new ArrayList(this.e);
                iterator = arrayList.iterator();
                for (b next2 : iterator) {
                    next2.a();
                }
            }
        }

        public void c() {
            boolean string;
            String next;
            if (this.g) {
            }
            if (n.I0(2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("SpecialEffectsController: ");
                stringBuilder.append(this);
                stringBuilder.append(" has called complete.");
                Log.v("FragmentManager", stringBuilder.toString());
            }
            this.g = true;
            Iterator iterator = this.d.iterator();
            for (Runnable next : iterator) {
                next.run();
            }
        }

        public final void d(b b) {
            boolean obj2;
            if (this.e.remove(b) && this.e.isEmpty()) {
                if (this.e.isEmpty()) {
                    c();
                }
            }
        }

        public androidx.fragment.app.c0.e.c e() {
            return this.a;
        }

        public final androidx.fragment.app.Fragment f() {
            return this.c;
        }

        androidx.fragment.app.c0.e.b g() {
            return this.b;
        }

        final boolean h() {
            return this.f;
        }

        final boolean i() {
            return this.g;
        }

        public final void j(b b) {
            l();
            this.e.add(b);
        }

        final void k(androidx.fragment.app.c0.e.c c0$e$c, androidx.fragment.app.c0.e.b c0$e$b2) {
            String str2;
            Object str;
            int rEMOVED;
            boolean obj6;
            Object obj7;
            obj7 = c0.c.b[b2.ordinal()];
            str = "SpecialEffectsController: For fragment ";
            final String str4 = "FragmentManager";
            final int i = 2;
            if (obj7 != 1) {
                str2 = " mFinalState = ";
                if (obj7 != i) {
                    if (obj7 != 3) {
                    } else {
                        if (this.a != c0.e.c.REMOVED && n.I0(i)) {
                            if (n.I0(i)) {
                                obj7 = new StringBuilder();
                                obj7.append(str);
                                obj7.append(this.c);
                                obj7.append(str2);
                                obj7.append(this.a);
                                obj7.append(" -> ");
                                obj7.append(c);
                                obj7.append(". ");
                                Log.v(str4, obj7.toString());
                            }
                            this.a = c;
                        }
                    }
                } else {
                    if (n.I0(i)) {
                        obj6 = new StringBuilder();
                        obj6.append(str);
                        obj6.append(this.c);
                        obj6.append(str2);
                        obj6.append(this.a);
                        obj6.append(" -> REMOVED. mLifecycleImpact  = ");
                        obj6.append(this.b);
                        obj6.append(" to REMOVING.");
                        Log.v(str4, obj6.toString());
                    }
                    this.a = c0.e.c.REMOVED;
                    this.b = c0.e.b.REMOVING;
                }
            } else {
                if (this.a == c0.e.c.REMOVED && n.I0(i)) {
                    if (n.I0(i)) {
                        obj6 = new StringBuilder();
                        obj6.append(str);
                        obj6.append(this.c);
                        obj6.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                        obj6.append(this.b);
                        obj6.append(" to ADDING.");
                        Log.v(str4, obj6.toString());
                    }
                    this.a = c0.e.c.VISIBLE;
                    this.b = c0.e.b.ADDING;
                }
            }
        }

        void l() {
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Operation ");
            String str2 = "{";
            stringBuilder.append(str2);
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            String str5 = "} ";
            stringBuilder.append(str5);
            stringBuilder.append(str2);
            stringBuilder.append("mFinalState = ");
            stringBuilder.append(this.a);
            stringBuilder.append(str5);
            stringBuilder.append(str2);
            stringBuilder.append("mLifecycleImpact = ");
            stringBuilder.append(this.b);
            stringBuilder.append(str5);
            stringBuilder.append(str2);
            stringBuilder.append("mFragment = ");
            stringBuilder.append(this.c);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    private static class d extends androidx.fragment.app.c0.e {

        private final androidx.fragment.app.u h;
        d(androidx.fragment.app.c0.e.c c0$e$c, androidx.fragment.app.c0.e.b c0$e$b2, androidx.fragment.app.u u3, b b4) {
            super(c, b2, u3.k(), b4);
            this.h = u3;
        }

        @Override // androidx.fragment.app.c0$e
        public void c() {
            super.c();
            this.h.m();
        }

        @Override // androidx.fragment.app.c0$e
        void l() {
            androidx.fragment.app.c0.e.b postOnViewCreatedAlpha;
            Object requireView;
            Object string;
            int visibility;
            Object parent;
            int str;
            androidx.fragment.app.Fragment fragment = this.h.k();
            string = fragment.mView.findFocus();
            fragment.setFocusedView(string);
            if (g() == c0.e.b.ADDING && string != null && n.I0(2)) {
                fragment = this.h.k();
                string = fragment.mView.findFocus();
                if (string != null) {
                    fragment.setFocusedView(string);
                    if (n.I0(2)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("requestFocus: Saved focused view ");
                        stringBuilder.append(string);
                        stringBuilder.append(" for Fragment ");
                        stringBuilder.append(fragment);
                        Log.v("FragmentManager", stringBuilder.toString());
                    }
                }
                requireView = f().requireView();
                str = 0;
                if (requireView.getParent() == null) {
                    this.h.b();
                    requireView.setAlpha(str);
                }
                if (Float.compare(alpha, str) == 0 && requireView.getVisibility() == 0) {
                    if (requireView.getVisibility() == 0) {
                        requireView.setVisibility(4);
                    }
                }
                requireView.setAlpha(fragment.getPostOnViewCreatedAlpha());
            }
        }
    }
    c0(ViewGroup viewGroup) {
        super();
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.c = arrayList2;
        int i = 0;
        this.a = viewGroup;
    }

    private void a(androidx.fragment.app.c0.e.c c0$e$c, androidx.fragment.app.c0.e.b c0$e$b2, androidx.fragment.app.u u3) {
        final ArrayList list = this.b;
        b bVar = new b();
        androidx.fragment.app.c0.e eVar = h(u3.k());
        synchronized (list) {
            eVar.k(c, b2);
        }
    }

    private androidx.fragment.app.c0.e h(androidx.fragment.app.Fragment fragment) {
        Object next;
        boolean equals;
        Iterator iterator = this.b.iterator();
        for (c0.e next : iterator) {
        }
        return null;
    }

    private androidx.fragment.app.c0.e i(androidx.fragment.app.Fragment fragment) {
        Object next;
        boolean equals;
        Iterator iterator = this.c.iterator();
        for (c0.e next : iterator) {
        }
        return null;
    }

    static androidx.fragment.app.c0 n(ViewGroup viewGroup, androidx.fragment.app.n n2) {
        return c0.o(viewGroup, n2.B0());
    }

    static androidx.fragment.app.c0 o(ViewGroup viewGroup, androidx.fragment.app.d0 d02) {
        final int i = b.b;
        final Object tag = viewGroup.getTag(i);
        if (tag instanceof c0) {
            return (c0)tag;
        }
        final androidx.fragment.app.c0 obj4 = d02.a(viewGroup);
        viewGroup.setTag(i, obj4);
        return obj4;
    }

    private void q() {
        Object next;
        Enum from;
        androidx.fragment.app.c0.e.b aDDING;
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((c0.e)next.g() == c0.e.b.ADDING) {
            }
            next.k(c0.e.c.from(next.f().requireView().getVisibility()), c0.e.b.NONE);
        }
    }

    void b(androidx.fragment.app.c0.e.c c0$e$c, androidx.fragment.app.u u2) {
        boolean string;
        String str;
        if (n.I0(2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SpecialEffectsController: Enqueuing add operation for fragment ");
            stringBuilder.append(u2.k());
            Log.v("FragmentManager", stringBuilder.toString());
        }
        a(c, c0.e.b.ADDING, u2);
    }

    void c(androidx.fragment.app.u u) {
        boolean string;
        String str;
        if (n.I0(2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SpecialEffectsController: Enqueuing hide operation for fragment ");
            stringBuilder.append(u.k());
            Log.v("FragmentManager", stringBuilder.toString());
        }
        a(c0.e.c.GONE, c0.e.b.NONE, u);
    }

    void d(androidx.fragment.app.u u) {
        boolean string;
        String str;
        if (n.I0(2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SpecialEffectsController: Enqueuing remove operation for fragment ");
            stringBuilder.append(u.k());
            Log.v("FragmentManager", stringBuilder.toString());
        }
        a(c0.e.c.REMOVED, c0.e.b.REMOVING, u);
    }

    void e(androidx.fragment.app.u u) {
        boolean string;
        String str;
        if (n.I0(2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SpecialEffectsController: Enqueuing show operation for fragment ");
            stringBuilder.append(u.k());
            Log.v("FragmentManager", stringBuilder.toString());
        }
        a(c0.e.c.VISIBLE, c0.e.b.NONE, u);
    }

    abstract void f(List<androidx.fragment.app.c0.e> list, boolean z2);

    void g() {
        boolean arrayList;
        boolean z;
        ArrayList next2;
        boolean next;
        boolean str2;
        String string;
        String str;
        if (this.e) {
        }
        final int i = 0;
        if (!u.Q(this.a)) {
            j();
            this.d = i;
        }
        ArrayList list = this.b;
        synchronized (list) {
            ArrayList arrayList2 = new ArrayList(this.c);
            this.c.clear();
            Iterator iterator = arrayList2.iterator();
            while (iterator.hasNext()) {
                next2 = iterator.next();
                if (n.I0(2)) {
                }
                (c0.e)next2.b();
                if (!next2.i()) {
                }
                this.c.add(next2);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("SpecialEffectsController: Cancelling operation ");
                stringBuilder.append(next2);
                Log.v("FragmentManager", stringBuilder.toString());
            }
            q();
            arrayList = new ArrayList(this.b);
            this.b.clear();
            this.c.addAll(arrayList);
            Iterator iterator2 = arrayList.iterator();
            for (c0.e next : iterator2) {
                next.l();
            }
            f(arrayList, this.d);
            this.d = i;
        }
    }

    void j() {
        Object next;
        ArrayList next3;
        ArrayList next2;
        boolean str2;
        String string4;
        String string;
        String string2;
        String str;
        String string3;
        String str3;
        boolean z = u.Q(this.a);
        final ArrayList list = this.b;
        q();
        Iterator iterator = this.b.iterator();
        synchronized (list) {
            for (c0.e next : iterator) {
                next.l();
            }
            ArrayList arrayList = new ArrayList(this.c);
            Iterator iterator2 = arrayList.iterator();
            int i = 2;
            while (iterator2.hasNext()) {
                next3 = iterator2.next();
                if (n.I0(i)) {
                }
                (c0.e)next3.b();
                i = 2;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("SpecialEffectsController: ");
                if (z) {
                } else {
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Container ");
                stringBuilder3.append(this.a);
                stringBuilder3.append(" is not attached to window. ");
                string2 = stringBuilder3.toString();
                stringBuilder.append(string2);
                stringBuilder.append("Cancelling running operation ");
                stringBuilder.append(next3);
                Log.v("FragmentManager", stringBuilder.toString());
                string2 = "";
            }
            ArrayList arrayList2 = new ArrayList(this.b);
            Iterator iterator3 = arrayList2.iterator();
            while (iterator3.hasNext()) {
                next2 = iterator3.next();
                if (n.I0(i)) {
                }
                (c0.e)next2.b();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("SpecialEffectsController: ");
                if (z) {
                } else {
                }
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("Container ");
                stringBuilder4.append(this.a);
                stringBuilder4.append(" is not attached to window. ");
                string3 = stringBuilder4.toString();
                stringBuilder2.append(string3);
                stringBuilder2.append("Cancelling pending operation ");
                stringBuilder2.append(next2);
                Log.v("FragmentManager", stringBuilder2.toString());
                string3 = "";
            }
        }
    }

    void k() {
        boolean z;
        if (this.e) {
            this.e = false;
            g();
        }
    }

    androidx.fragment.app.c0.e.b l(androidx.fragment.app.u u) {
        int i;
        androidx.fragment.app.c0.e.b nONE;
        androidx.fragment.app.c0.e eVar = h(u.k());
        if (eVar != null) {
            i = eVar.g();
        } else {
            i = 0;
        }
        androidx.fragment.app.c0.e obj3 = i(u.k());
        if (obj3 != null && i != 0 && i == c0.e.b.NONE) {
            if (i != 0) {
                if (i == c0.e.b.NONE) {
                }
            }
            return obj3.g();
        }
        return i;
    }

    public ViewGroup m() {
        return this.a;
    }

    void p() {
        int postponed;
        Object obj;
        androidx.fragment.app.c0.e.c from;
        androidx.fragment.app.c0.e.c cVar;
        androidx.fragment.app.c0.e.c vISIBLE;
        final ArrayList list = this.b;
        q();
        this.e = false;
        size--;
        synchronized (list) {
            while (postponed >= 0) {
                obj = this.b.get(postponed);
                vISIBLE = c0.e.c.VISIBLE;
                if (obj.e() == vISIBLE) {
                    break;
                } else {
                }
                postponed--;
                if (c0.e.c.from(fragment2.mView) != vISIBLE) {
                    break;
                } else {
                }
            }
        }
    }

    void r(boolean z) {
        this.d = z;
    }
}
