package d.u;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class s extends d.u.o {

    private ArrayList<d.u.o> b0;
    private boolean c0 = true;
    int d0;
    boolean e0 = false;
    private int f0 = 0;

    class a extends d.u.p {

        final d.u.o a;
        a(d.u.s s, d.u.o o2) {
            this.a = o2;
            super();
        }

        @Override // d.u.p
        public void onTransitionEnd(d.u.o o) {
            this.a.W();
            o.S(this);
        }
    }

    static class b extends d.u.p {

        d.u.s a;
        b(d.u.s s) {
            super();
            this.a = s;
        }

        @Override // d.u.p
        public void onTransitionEnd(d.u.o o) {
            int i;
            final d.u.s sVar = this.a;
            i2--;
            sVar.d0 = i;
            if (i == 0) {
                sVar.e0 = false;
                sVar.p();
            }
            o.S(this);
        }

        @Override // d.u.p
        public void onTransitionStart(d.u.o o) {
            boolean z;
            d.u.s obj2;
            obj2 = this.a;
            if (!obj2.e0) {
                obj2.f0();
                obj2.e0 = true;
            }
        }
    }
    public s() {
        super();
        ArrayList arrayList = new ArrayList();
        this.b0 = arrayList;
        int i = 1;
        int i2 = 0;
    }

    private void m0(d.u.o o) {
        this.b0.add(o);
        o.J = this;
    }

    private void x0() {
        Object next;
        s.b bVar = new s.b(this);
        Iterator iterator = this.b0.iterator();
        for (o next : iterator) {
            next.a(bVar);
        }
        this.d0 = this.b0.size();
    }

    @Override // d.u.o
    public void Q(View view) {
        int i;
        Object obj;
        super.Q(view);
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).Q(view);
            i++;
        }
    }

    @Override // d.u.o
    public d.u.o S(d.u.o.f o$f) {
        return p0(f);
    }

    @Override // d.u.o
    public d.u.o T(View view) {
        return q0(view);
    }

    @Override // d.u.o
    public void U(View view) {
        int i;
        Object obj;
        super.U(view);
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).U(view);
            i++;
        }
    }

    @Override // d.u.o
    protected void W() {
        int i;
        Object iterator;
        Object next2;
        int next;
        Object obj;
        d.u.s.a aVar;
        if (this.b0.isEmpty()) {
            f0();
            p();
        }
        x0();
        if (!this.c0) {
            i = 1;
            while (i < this.b0.size()) {
                aVar = new s.a(this, (o)this.b0.get(i));
                (o)this.b0.get(i + -1).a(aVar);
                i++;
            }
            iterator = this.b0.get(0);
            if ((o)iterator != null) {
                (o)iterator.W();
            }
        } else {
            iterator = this.b0.iterator();
            for (o next2 : iterator) {
                next2.W();
            }
        }
    }

    @Override // d.u.o
    void X(boolean z) {
        int i;
        Object obj;
        super.X(z);
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).X(z);
            i++;
        }
    }

    @Override // d.u.o
    public d.u.o Y(long l) {
        r0(l);
        return this;
    }

    @Override // d.u.o
    public void Z(d.u.o.e o$e) {
        int i;
        Object obj;
        super.Z(e);
        this.f0 = i2 |= 8;
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).Z(e);
            i++;
        }
    }

    @Override // d.u.o
    public d.u.o a(d.u.o.f o$f) {
        return h0(f);
    }

    @Override // d.u.o
    public d.u.o a0(TimeInterpolator timeInterpolator) {
        return s0(timeInterpolator);
    }

    @Override // d.u.o
    public d.u.o b(View view) {
        return i0(view);
    }

    @Override // d.u.o
    public void b0(d.u.g g) {
        int list;
        Object size;
        super.b0(g);
        this.f0 = i |= 4;
        if (this.b0 != null) {
            list = 0;
            while (list < this.b0.size()) {
                (o)this.b0.get(list).b0(g);
                list++;
            }
        }
    }

    @Override // d.u.o
    public void c0(d.u.r r) {
        int i;
        Object obj;
        super.c0(r);
        this.f0 = i2 |= 2;
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).c0(r);
            i++;
        }
    }

    @Override // d.u.o
    public Object clone() {
        return m();
    }

    @Override // d.u.o
    d.u.o d0(ViewGroup viewGroup) {
        v0(viewGroup);
        return this;
    }

    @Override // d.u.o
    public d.u.o e0(long l) {
        return w0(l);
    }

    @Override // d.u.o
    public void f(d.u.u u) {
        boolean iterator;
        boolean next;
        boolean z;
        if (J(u.b)) {
            iterator = this.b0.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((o)next.J(u.b)) {
                }
                next.f(u);
                u.c.add(next);
            }
        }
    }

    @Override // d.u.o
    String g0(String string) {
        String string3;
        int i;
        StringBuilder stringBuilder;
        String string2;
        String str;
        string3 = super.g0(string);
        i = 0;
        while (i < this.b0.size()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append("\n");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append("  ");
            stringBuilder.append((o)this.b0.get(i).g0(stringBuilder2.toString()));
            string3 = stringBuilder.toString();
            i++;
        }
        return string3;
    }

    @Override // d.u.o
    void h(d.u.u u) {
        int i;
        Object obj;
        super.h(u);
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).h(u);
            i++;
        }
    }

    @Override // d.u.o
    public d.u.s h0(d.u.o.f o$f) {
        super.a(f);
        return (s)this;
    }

    @Override // d.u.o
    public d.u.s i0(View view) {
        int i;
        Object obj;
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).b(view);
            i++;
        }
        super.b(view);
        return (s)this;
    }

    @Override // d.u.o
    public void j(d.u.u u) {
        boolean iterator;
        boolean next;
        boolean z;
        if (J(u.b)) {
            iterator = this.b0.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((o)next.J(u.b)) {
                }
                next.j(u);
                u.c.add(next);
            }
        }
    }

    @Override // d.u.o
    public d.u.s k0(d.u.o o) {
        int i2;
        int i3;
        int i;
        int i4;
        m0(o);
        long l = this.c;
        if (Long.compare(l, i9) >= 0) {
            o.Y(l);
        }
        if (i5 &= 1 != 0) {
            o.a0(v());
        }
        if (i6 &= 2 != 0) {
            o.c0(z());
        }
        if (i7 &= 4 != 0) {
            o.b0(y());
        }
        if (i8 &= 8 != 0) {
            o.Z(u());
        }
        return this;
    }

    @Override // d.u.o
    public d.u.o m() {
        int i;
        d.u.o oVar;
        final d.u.o oVar2 = super.m();
        ArrayList arrayList = new ArrayList();
        oVar2.b0 = arrayList;
        i = 0;
        while (i < this.b0.size()) {
            (s)oVar2.m0((o)this.b0.get(i).m());
            i++;
        }
        return oVar2;
    }

    @Override // d.u.o
    public d.u.o n0(int i) {
        int size;
        if (i >= 0 && i >= this.b0.size()) {
            if (i >= this.b0.size()) {
            }
            return (o)this.b0.get(i);
        }
        return null;
    }

    protected void o(ViewGroup viewGroup, d.u.v v2, d.u.v v3, ArrayList<d.u.u> arrayList4, ArrayList<d.u.u> arrayList5) {
        int i;
        int cmp;
        Object obj;
        ViewGroup view;
        d.u.v vVar;
        long l;
        ArrayList list2;
        ArrayList list;
        final Object obj2 = this;
        final long l2 = B();
        i = 0;
        while (i < obj2.b0.size()) {
            obj = obj3;
            int i2 = 0;
            if (Long.compare(l2, i2) > 0) {
            }
            (o)obj.o(viewGroup, v2, v3, arrayList4, arrayList5);
            i++;
            if (!obj2.c0) {
            } else {
            }
            l = obj.B();
            if (Long.compare(l, i2) > 0) {
            } else {
            }
            obj.e0(l2);
            obj.e0(l += l2);
            if (i == 0) {
            }
        }
    }

    @Override // d.u.o
    public int o0() {
        return this.b0.size();
    }

    @Override // d.u.o
    public d.u.s p0(d.u.o.f o$f) {
        super.S(f);
        return (s)this;
    }

    @Override // d.u.o
    public d.u.s q0(View view) {
        int i;
        Object obj;
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).T(view);
            i++;
        }
        super.T(view);
        return (s)this;
    }

    @Override // d.u.o
    void r(ViewGroup viewGroup) {
        int i;
        Object obj;
        super.r(viewGroup);
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).r(viewGroup);
            i++;
        }
    }

    @Override // d.u.o
    public d.u.s r0(long l) {
        int size;
        int i2;
        int i;
        super.Y(l);
        size = this.b0;
        if (Long.compare(l2, i) >= 0 && size != null) {
            size = this.b0;
            if (size != null) {
                i2 = 0;
                while (i2 < size.size()) {
                    (o)this.b0.get(i2).Y(l);
                    i2++;
                }
            }
        }
        return this;
    }

    @Override // d.u.o
    public d.u.s s0(TimeInterpolator timeInterpolator) {
        ArrayList size;
        int i;
        Object obj;
        this.f0 = i2 |= 1;
        size = this.b0;
        if (size != null) {
            i = 0;
            while (i < size.size()) {
                (o)this.b0.get(i).a0(timeInterpolator);
                i++;
            }
        }
        super.a0(timeInterpolator);
        return (s)this;
    }

    @Override // d.u.o
    public d.u.s u0(int i) {
        int obj4;
        int i2 = 1;
        if (i != 0) {
            if (i != i2) {
            } else {
                this.c0 = false;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid parameter for TransitionSet ordering: ");
            stringBuilder.append(i);
            AndroidRuntimeException androidRuntimeException = new AndroidRuntimeException(stringBuilder.toString());
            throw androidRuntimeException;
        }
        this.c0 = i2;
    }

    @Override // d.u.o
    d.u.s v0(ViewGroup viewGroup) {
        int i;
        Object obj;
        super.d0(viewGroup);
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).d0(viewGroup);
            i++;
        }
        return this;
    }

    @Override // d.u.o
    public d.u.s w0(long l) {
        super.e0(l);
        return (s)this;
    }
}
