package d.u;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionSet.java */
/* loaded from: classes.dex */
public class s extends o {

    private ArrayList<o> b0 = new ArrayList<>();
    private boolean c0 = true;
    int d0;
    boolean e0 = false;
    private int f0 = 0;

    class a extends p {

        final /* synthetic */ o a;
        a(o oVar) {
            this.a = oVar;
            super();
        }

        @Override // d.u.p
        public void onTransitionEnd(o oVar) {
            this.a.W();
            oVar.S(this);
        }
    }

    static class b extends p {

        s a;
        b() {
            super();
            this.a = sVar;
        }

        @Override // d.u.p
        public void onTransitionEnd(o oVar) {
            sVar.d0--;
            if (sVar.d0 == 0) {
                this.a.e0 = false;
                this.a.p();
            }
            oVar.S(this);
        }

        @Override // d.u.p
        public void onTransitionStart(o oVar) {
            if (!sVar.e0) {
                this.a.f0();
                boolean z = true;
                this.a.e0 = z;
            }
        }
    }
    public s() {
        super();
        ArrayList arrayList = new ArrayList();
    }

    private void m0(o oVar) {
        this.b0.add(oVar);
        oVar.J = this;
    }

    private void x0() {
        Iterator it = this.b0.iterator();
        while (it.hasNext()) {
            (o)it.next().a(new s.b(this));
        }
        this.d0 = this.b0.size();
    }

    @Override // d.u.o
    public void Q(View view) {
        int i = 0;
        super.Q(view);
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).Q(view);
            i = i + 1;
        }
    }

    @Override // d.u.o
    public void U(View view) {
        int i = 0;
        super.U(view);
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).U(view);
            i = i + 1;
        }
    }

    @Override // d.u.o
    protected void W() {
        int i = 1;
        Object item4;
        d.u.s.a aVar;
        if (this.b0.isEmpty()) {
            f0();
            p();
            return;
        }
        x0();
        if (!this.c0) {
            i = 1;
            while (this.b0 < this.b0.size()) {
                (o)this.b0.get(i - 1).a(new s.a(this, (o)this.b0.get(i)));
                i = i + 1;
            }
            int i2 = 0;
            Object item = this.b0.get(i2);
            if (item != null) {
                item.W();
            }
        } else {
            Iterator it = this.b0.iterator();
            while (it.hasNext()) {
                (o)it.next().W();
            }
        }
    }

    @Override // d.u.o
    void X(boolean z) {
        int i = 0;
        super.X(z);
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).X(z);
            i = i + 1;
        }
    }

    @Override // d.u.o
    public void Z(o.e eVar) {
        int i = 0;
        super.Z(eVar);
        this.f0 |= 8;
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).Z(eVar);
            i = i + 1;
        }
    }

    @Override // d.u.o
    public void b0(g gVar) {
        int i = 0;
        super.b0(gVar);
        this.f0 |= 4;
        if (this.b0 != null) {
            i = 0;
            while ((this.f0 | 4) < this.b0.size()) {
                (o)this.b0.get(i).b0(gVar);
                i = i + 1;
            }
        }
    }

    @Override // d.u.o
    public void c0(r rVar) {
        int i = 0;
        super.c0(rVar);
        this.f0 |= 2;
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).c0(rVar);
            i = i + 1;
        }
    }

    @Override // d.u.o
    public void f(u uVar) {
        boolean z2;
        if (J(uVar.b)) {
            Iterator it = this.b0.iterator();
            while (it.hasNext()) {
                Object item = it.next();
            }
        }
    }

    @Override // d.u.o
    String g0(String str) {
        String str2;
        int i = 0;
        str2 = super.g0(str);
        i = 0;
        while (i < this.b0.size()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str5 = "\n";
            StringBuilder stringBuilder2 = new StringBuilder();
            str4 = "  ";
            str3 = str + str4;
            String str6 = (o)this.b0.get(i).g0(str3);
            str2 = str2 + str5 + str6;
            i = i + 1;
        }
        return str2;
    }

    @Override // d.u.o
    void h(u uVar) {
        int i = 0;
        super.h(uVar);
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).h(uVar);
            i = i + 1;
        }
    }

    @Override // d.u.o
    public s h0(o.f fVar) {
        super.a(fVar);
        return (s)this;
    }

    @Override // d.u.o
    public s i0(View view) {
        int i = 0;
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).b(view);
            i = i + 1;
        }
        super.b(view);
        return (s)this;
    }

    @Override // d.u.o
    public void j(u uVar) {
        boolean z2;
        if (J(uVar.b)) {
            Iterator it = this.b0.iterator();
            while (it.hasNext()) {
                Object item = it.next();
            }
        }
    }

    @Override // d.u.o
    public s k0(o oVar) {
        m0(oVar);
        if (this.c >= 0) {
            oVar.Y(this.c);
        }
        i = this.f0 & 1;
        if (this.f0 & 1 != 0) {
            oVar.a0(v());
        }
        i2 = this.f0 & 2;
        if (this.f0 & 2 != 0) {
            oVar.c0(z());
        }
        i3 = this.f0 & 4;
        if (this.f0 & 4 != 0) {
            oVar.b0(y());
        }
        i4 = this.f0 & 8;
        if (this.f0 & 8 != 0) {
            oVar.Z(u());
        }
        return this;
    }

    @Override // d.u.o
    public o m() {
        int i = 0;
        final d.u.o oVar2 = super.m();
        oVar2.b0 = new ArrayList();
        i = 0;
        while (i < this.b0.size()) {
            oVar2.m0((o)this.b0.get(i).m());
            i = i + 1;
        }
        return oVar2;
    }

    @Override // d.u.o
    public o n0(int i) {
        if (i >= 0) {
            return (o)this.b0.get(i);
        }
        return null;
    }

    @Override // d.u.o
    protected void o(ViewGroup viewGroup, v vVar, v vVar2, ArrayList<u> arrayList, ArrayList<u> arrayList2) {
        int i = 0;
        int cmp;
        d.u.v vVar32;
        ArrayList arrayList42;
        final Object viewGroup3 = this;
        final long l = B();
        i = 0;
        while (i < viewGroup3.b0.size()) {
            long l2 = 0L;
            item.o(viewGroup, vVar, vVar2, arrayList, arrayList2);
            i = i + 1;
        }
    }

    @Override // d.u.o
    public int o0() {
        return this.b0.size();
    }

    @Override // d.u.o
    public s p0(o.f fVar) {
        super.S(fVar);
        return (s)this;
    }

    @Override // d.u.o
    public s q0(View view) {
        int i = 0;
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).T(view);
            i = i + 1;
        }
        super.T(view);
        return (s)this;
    }

    @Override // d.u.o
    void r(ViewGroup viewGroup) {
        int i = 0;
        super.r(viewGroup);
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).r(viewGroup);
            i = i + 1;
        }
    }

    @Override // d.u.o
    public s r0(long j) {
        int i = 0;
        long l = 0;
        super.Y(j);
        l = 0L;
        if (this.c >= l && this.b0 != null) {
            i = 0;
            while (i < this.b0.size()) {
                (o)this.b0.get(i).Y(j);
                i = i + 1;
            }
        }
        return this;
    }

    @Override // d.u.o
    public s s0(TimeInterpolator timeInterpolator) {
        int i = 0;
        Object item;
        this.f0 |= 1;
        if (this.b0 != null) {
            i = 0;
            while (i < this.b0.size()) {
                (o)this.b0.get(i).a0(timeInterpolator);
                i = i + 1;
            }
        }
        super.a0(timeInterpolator);
        return (s)this;
    }

    @Override // d.u.o
    public s u0(int i) throws AndroidRuntimeException {
        int i2 = 1;
        if (i != 0) {
            if (i != i2) {
                final StringBuilder stringBuilder = new StringBuilder();
                final String str = "Invalid parameter for TransitionSet ordering: ";
                i = str + i;
                throw new AndroidRuntimeException(i);
            } else {
                boolean z = false;
                this.c0 = z;
                return this;
            }
        }
        this.c0 = true;
    }

    @Override // d.u.o
    s v0(ViewGroup viewGroup) {
        int i = 0;
        super.d0(viewGroup);
        i = 0;
        while (i < this.b0.size()) {
            (o)this.b0.get(i).d0(viewGroup);
            i = i + 1;
        }
        return this;
    }

    @Override // d.u.o
    public s w0(long j) {
        super.e0(j);
        return (s)this;
    }
}
