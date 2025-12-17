package zendesk.belvedere;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import java.util.List;
import zendesk.belvedere.b0.i;

/* loaded from: classes3.dex */
class l {

    private final zendesk.belvedere.j a;
    private final zendesk.belvedere.k b;
    private final zendesk.belvedere.e c;
    private final zendesk.belvedere.f.b d;

    class a implements View.OnClickListener {

        final zendesk.belvedere.l a;
        a(zendesk.belvedere.l l) {
            this.a = l;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            l.c(this.a).f(l.a(this.a).a(), l.b(this.a));
        }
    }

    class b implements View.OnClickListener {

        final zendesk.belvedere.l a;
        b(zendesk.belvedere.l l) {
            this.a = l;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            l.c(this.a).f(l.a(this.a).k(), l.b(this.a));
        }
    }

    class c implements zendesk.belvedere.f.b {

        final zendesk.belvedere.l a;
        c(zendesk.belvedere.l l) {
            this.a = l;
            super();
        }

        @Override // zendesk.belvedere.f$b
        public boolean a(zendesk.belvedere.h.b h$b) {
            zendesk.belvedere.s sVar;
            ArrayList arrayList;
            zendesk.belvedere.k kVar;
            int i;
            int cmp;
            Object obj7;
            sVar = b.d();
            arrayList = l.a(this.a).c();
            if (sVar != null) {
                if (Long.compare(l, arrayList) > 0) {
                    if (Long.compare(arrayList, cmp) == 0) {
                        b.f(z ^= i);
                        l.c(this.a).g(l.d(this.a, sVar, b.e()).size());
                        arrayList = new ArrayList();
                        arrayList.add(sVar);
                        if (b.e()) {
                            l.b(this.a).J1(arrayList);
                        } else {
                            l.b(this.a).I1(arrayList);
                        }
                    } else {
                        i = 0;
                        l.c(this.a).a(i.e);
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        @Override // zendesk.belvedere.f$b
        public void b() {
            boolean z;
            zendesk.belvedere.r rVar;
            zendesk.belvedere.e eVar;
            if (l.a(this.a).h()) {
                l.c(this.a).f(l.a(this.a).b(), l.b(this.a));
            }
        }
    }
    l(zendesk.belvedere.j j, zendesk.belvedere.k k2, zendesk.belvedere.e e3) {
        super();
        l.c cVar = new l.c(this);
        this.d = cVar;
        this.a = j;
        this.b = k2;
        this.c = e3;
    }

    static zendesk.belvedere.j a(zendesk.belvedere.l l) {
        return l.a;
    }

    static zendesk.belvedere.e b(zendesk.belvedere.l l) {
        return l.c;
    }

    static zendesk.belvedere.k c(zendesk.belvedere.l l) {
        return l.b;
    }

    static List d(zendesk.belvedere.l l, zendesk.belvedere.s s2, boolean z3) {
        return l.j(s2, z3);
    }

    private void g() {
        boolean aVar;
        boolean bVar;
        zendesk.belvedere.k kVar;
        if (this.a.f()) {
            aVar = new l.a(this);
            this.b.h(aVar);
        }
        if (this.a.e()) {
            bVar = new l.b(this);
            this.b.e(bVar);
        }
    }

    private void i() {
        int i;
        boolean z;
        if (!this.a.l()) {
            if (this.b.b()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        final int i2 = i;
        this.b.c(i2);
        this.b.d(this.a.g(), this.a.j(), i2, this.a.h(), this.d);
        this.c.L1();
    }

    private List<zendesk.belvedere.s> j(zendesk.belvedere.s s, boolean z2) {
        List obj1;
        zendesk.belvedere.j obj2;
        if (z2) {
            obj1 = this.a.d(s);
        } else {
            obj1 = this.a.i(s);
        }
        return obj1;
    }

    public void e() {
        int i = 0;
        this.c.M1(i, i);
        int i2 = 0;
        this.c.K1(i2, i2, 0);
        this.c.H1();
    }

    public void f() {
        i();
        g();
        this.b.g(this.a.j().size());
    }

    public void h(int i, int i2, float f3) {
        int cmp;
        if (Float.compare(f3, i3) >= 0) {
            this.c.K1(i, i2, f3);
        }
    }
}
