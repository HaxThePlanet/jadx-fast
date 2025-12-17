package d.a.o;

import android.view.View;
import android.view.animation.Interpolator;
import d.h.l.a0;
import d.h.l.b0;
import d.h.l.z;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class h {

    final ArrayList<z> a;
    private long b = -1;
    private Interpolator c;
    a0 d;
    private boolean e;
    private final b0 f;

    class a extends b0 {

        private boolean a = false;
        private int b = 0;
        final d.a.o.h c;
        a(d.a.o.h h) {
            this.c = h;
            super();
            final int obj1 = 0;
        }

        @Override // d.h.l.b0
        public void b(View view) {
            int size;
            int obj2;
            obj2++;
            this.b = obj2;
            obj2 = obj2.d;
            if (obj2 == hVar.a.size() && obj2 != null) {
                obj2 = obj2.d;
                if (obj2 != null) {
                    obj2.b(0);
                }
                d();
            }
        }

        @Override // d.h.l.b0
        public void c(View view) {
            int i;
            if (this.a) {
            }
            this.a = true;
            a0 obj2 = obj2.d;
            if (obj2 != null) {
                obj2.c(0);
            }
        }

        @Override // d.h.l.b0
        void d() {
            int i = 0;
            this.b = i;
            this.a = i;
            this.c.b();
        }
    }
    public h() {
        super();
        int i = -1;
        h.a aVar = new h.a(this);
        this.f = aVar;
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
    }

    public void a() {
        Object next;
        if (!this.e) {
        }
        Iterator iterator = this.a.iterator();
        for (z next : iterator) {
            next.b();
        }
        this.e = false;
    }

    void b() {
        this.e = false;
    }

    public d.a.o.h c(z z) {
        boolean z2;
        if (!this.e) {
            this.a.add(z);
        }
        return this;
    }

    public d.a.o.h d(z z, z z2) {
        this.a.add(z);
        z2.i(z.c());
        this.a.add(z2);
        return this;
    }

    public d.a.o.h e(long l) {
        if (!this.e) {
            this.b = l;
        }
        return this;
    }

    public d.a.o.h f(Interpolator interpolator) {
        if (!this.e) {
            this.c = interpolator;
        }
        return this;
    }

    public d.a.o.h g(a0 a0) {
        if (!this.e) {
            this.d = a0;
        }
        return this;
    }

    public void h() {
        Object next;
        a0 a0Var;
        int cmp;
        if (this.e) {
        }
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            long l = this.b;
            if (Long.compare(l, i2) >= 0) {
            }
            Interpolator interpolator = this.c;
            if (interpolator != null) {
            }
            if (this.d != null) {
            }
            (z)next.k();
            next.g(this.f);
            next.f(interpolator);
            next.e(l);
        }
        this.e = true;
    }
}
