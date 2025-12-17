package androidx.lifecycle;

import d.b.a.a.a;
import d.b.a.b.a;
import d.b.a.b.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

/* loaded from: classes.dex */
public class s extends androidx.lifecycle.j {

    private a<androidx.lifecycle.p, androidx.lifecycle.s.a> b;
    private androidx.lifecycle.j.c c;
    private final WeakReference<androidx.lifecycle.q> d;
    private int e;
    private boolean f;
    private boolean g;
    private ArrayList<androidx.lifecycle.j.c> h;
    private final boolean i;

    static class a {

        androidx.lifecycle.j.c a;
        androidx.lifecycle.n b;
        a(androidx.lifecycle.p p, androidx.lifecycle.j.c j$c2) {
            super();
            this.b = u.f(p);
            this.a = c2;
        }

        void a(androidx.lifecycle.q q, androidx.lifecycle.j.b j$b2) {
            final androidx.lifecycle.j.c targetState = b2.getTargetState();
            this.a = s.k(this.a, targetState);
            this.b.c(q, b2);
            this.a = targetState;
        }
    }
    public s(androidx.lifecycle.q q) {
        super(q, 1);
    }

    private s(androidx.lifecycle.q q, boolean z2) {
        super();
        a aVar = new a();
        this.b = aVar;
        int i = 0;
        this.e = i;
        this.f = i;
        this.g = i;
        ArrayList arrayList = new ArrayList();
        this.h = arrayList;
        WeakReference weakReference = new WeakReference(q);
        this.d = weakReference;
        this.c = j.c.INITIALIZED;
        this.i = z2;
    }

    private void d(androidx.lifecycle.q q) {
        Object next;
        boolean next2;
        Object value;
        int compareTo;
        Object targetState;
        Iterator descendingIterator = this.b.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (!this.g) {
            }
            next = descendingIterator.next();
            value = (Map.Entry)next.getValue();
            while (value.a.compareTo(this.c) > 0) {
                compareTo = j.b.downFrom(value.a);
                n(compareTo.getTargetState());
                (s.a)value.a(q, compareTo);
                m();
            }
            compareTo = j.b.downFrom(value.a);
            n(compareTo.getTargetState());
            value.a(q, compareTo);
            m();
        }
    }

    private androidx.lifecycle.j.c e(androidx.lifecycle.p p) {
        int i;
        boolean empty;
        androidx.lifecycle.j.c obj3;
        obj3 = this.b.p(p);
        if (obj3 != null) {
            obj3 = obj3.a;
        } else {
            obj3 = i;
        }
        if (!this.h.isEmpty()) {
            ArrayList list = this.h;
            i = list.get(size--);
        }
        return s.k(s.k(this.c, obj3), i);
    }

    private void f(String string) {
        boolean z;
        if (this.i) {
            if (!a.e().b()) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Method ");
            stringBuilder.append(string);
            stringBuilder.append(" must be called on the main thread");
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
    }

    private void g(androidx.lifecycle.q q) {
        Object next;
        boolean next2;
        Object value;
        int compareTo;
        Object key;
        d.b.a.b.b.d dVar = this.b.g();
        while (dVar.hasNext()) {
            if (!this.g) {
            }
            next = dVar.next();
            value = (Map.Entry)next.getValue();
            while (value.a.compareTo(this.c) < 0) {
                n(value.a);
                compareTo = j.b.upFrom(value.a);
                (s.a)value.a(q, compareTo);
                m();
            }
            n(value.a);
            compareTo = j.b.upFrom(value.a);
            value.a(q, compareTo);
            m();
        }
    }

    private boolean i() {
        androidx.lifecycle.j.c cVar;
        int i;
        if (this.b.size() == 0) {
            return 1;
        }
        androidx.lifecycle.j.c cVar2 = value2.a;
        if (value.a == cVar2 && this.c == cVar2) {
            if (this.c == cVar2) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    static androidx.lifecycle.j.c k(androidx.lifecycle.j.c j$c, androidx.lifecycle.j.c j$c2) {
        int compareTo;
        Enum obj1;
        if (c2 != null && c2.compareTo(c) < 0) {
            if (c2.compareTo(c) < 0) {
                obj1 = c2;
            }
        }
        return obj1;
    }

    private void l(androidx.lifecycle.j.c j$c) {
        boolean obj2;
        if (this.c == c) {
        }
        this.c = c;
        int i = 1;
        if (!this.f && this.e != 0) {
            if (this.e != 0) {
            }
            this.f = i;
            p();
            this.f = false;
        }
        this.g = i;
    }

    private void m() {
        final ArrayList list = this.h;
        list.remove(size--);
    }

    private void n(androidx.lifecycle.j.c j$c) {
        this.h.add(c);
    }

    private void p() {
        Map.Entry compareTo;
        boolean z;
        Object obj = this.d.get();
        if ((q)obj == null) {
        }
        IllegalStateException illegalStateException = new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        throw illegalStateException;
    }

    @Override // androidx.lifecycle.j
    public void a(androidx.lifecycle.p p) {
        androidx.lifecycle.j.c iNITIALIZED;
        int i3;
        int i2;
        androidx.lifecycle.j.c cVar;
        int compareTo;
        int i;
        f("addObserver");
        if (this.c == j.c.DESTROYED) {
        } else {
            iNITIALIZED = j.c.INITIALIZED;
        }
        s.a aVar = new s.a(p, iNITIALIZED);
        if ((s.a)this.b.l(p, aVar) != null) {
        }
        Object obj2 = this.d.get();
        if ((q)obj2 == null) {
        }
        final int i4 = 1;
        if (this.e == 0) {
            if (this.f) {
                i2 = i4;
            } else {
                i2 = 0;
            }
        } else {
        }
        cVar = e(p);
        this.e = i5 += i4;
        while (aVar.a.compareTo(cVar) < 0) {
            n(aVar.a);
            androidx.lifecycle.j.b upFrom = j.b.upFrom(aVar.a);
            aVar.a((q)obj2, upFrom);
            m();
            cVar = e(p);
        }
        if (i2 == 0) {
            p();
        }
        this.e = obj7 -= i4;
    }

    @Override // androidx.lifecycle.j
    public androidx.lifecycle.j.c b() {
        return this.c;
    }

    @Override // androidx.lifecycle.j
    public void c(androidx.lifecycle.p p) {
        f("removeObserver");
        this.b.m(p);
    }

    @Override // androidx.lifecycle.j
    public void h(androidx.lifecycle.j.b j$b) {
        f("handleLifecycleEvent");
        l(b.getTargetState());
    }

    @Deprecated
    public void j(androidx.lifecycle.j.c j$c) {
        f("markState");
        o(c);
    }

    @Override // androidx.lifecycle.j
    public void o(androidx.lifecycle.j.c j$c) {
        f("setCurrentState");
        l(c);
    }
}
