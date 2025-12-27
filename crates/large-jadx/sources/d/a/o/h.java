package d.a.o;

import android.view.View;
import android.view.animation.Interpolator;
import d.h.l.a0;
import d.h.l.b0;
import d.h.l.z;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* loaded from: classes.dex */
public class h {

    final ArrayList<z> a = new ArrayList<>();
    private long b = -1;
    private Interpolator c;
    a0 d;
    private boolean e;
    private final b0 f = new h$a();

    class a extends b0 {

        private boolean a = false;
        private int b = 0;
        final /* synthetic */ h c;
        a() {
            this.c = hVar;
            super();
        }

        @Override // d.h.l.b0
        public void b(View view) {
            int size = 0;
            this.b++;
            if (this.b == this.c.a.size()) {
                if (this.c.d != null) {
                    this.c.d.b(null);
                }
                d();
            }
        }

        @Override // d.h.l.b0
        public void c(View view) {
            if (this.a) {
                return;
            }
            this.a = true;
            if (this.c.d != null) {
                View view2 = null;
                this.c.d.c(view2);
            }
        }

        @Override // d.h.l.b0
        void d() {
            int i = 0;
            this.b = i;
            this.a = false;
            this.c.b();
        }
    }
    public h() {
        super();
        d.a.o.h.a aVar = new h.a(this);
        ArrayList arrayList = new ArrayList();
    }

    public void a() {
        if (!this.e) {
            return;
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            (z)it.next().b();
        }
        this.e = false;
    }

    void b() {
        this.e = false;
    }

    public h c(z zVar) {
        if (!this.e) {
            this.a.add(zVar);
        }
        return this;
    }

    public h d(z zVar, z zVar2) {
        this.a.add(zVar);
        zVar2.i(zVar.c());
        this.a.add(zVar2);
        return this;
    }

    public h e(long j) {
        if (!this.e) {
            this.b = j;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.e) {
            this.c = interpolator;
        }
        return this;
    }

    public h g(a0 a0Var) {
        if (!this.e) {
            this.d = a0Var;
        }
        return this;
    }

    public void h() {
        a0 a0Var;
        if (this.e) {
            return;
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            item.k();
        }
        this.e = true;
    }
}
