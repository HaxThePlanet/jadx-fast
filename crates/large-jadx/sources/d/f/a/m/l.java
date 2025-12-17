package d.f.a.m;

import d.f.a.c;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class l extends d.f.a.m.e {

    public ArrayList<d.f.a.m.e> u0;
    public l() {
        super();
        ArrayList arrayList = new ArrayList();
        this.u0 = arrayList;
    }

    @Override // d.f.a.m.e
    public void b(d.f.a.m.e e) {
        d.f.a.m.e eVar;
        this.u0.add(e);
        if (e.I() != null) {
            (l)e.I().k1(e);
        }
        e.T0(this);
    }

    public ArrayList<d.f.a.m.e> i1() {
        return this.u0;
    }

    @Override // d.f.a.m.e
    public void j1() {
        int i;
        Object obj;
        boolean z;
        ArrayList list = this.u0;
        if (list == null) {
        }
        i = 0;
        while (i < list.size()) {
            obj = this.u0.get(i);
            if (obj instanceof l) {
            }
            i++;
            (l)(e)obj.j1();
        }
    }

    @Override // d.f.a.m.e
    public void k1(d.f.a.m.e e) {
        this.u0.remove(e);
        e.o0();
    }

    @Override // d.f.a.m.e
    public void l1() {
        this.u0.clear();
    }

    @Override // d.f.a.m.e
    public void o0() {
        this.u0.clear();
        super.o0();
    }

    @Override // d.f.a.m.e
    public void q0(c c) {
        int i;
        Object obj;
        super.q0(c);
        i = 0;
        while (i < this.u0.size()) {
            (e)this.u0.get(i).q0(c);
            i++;
        }
    }
}
