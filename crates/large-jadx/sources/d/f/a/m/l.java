package d.f.a.m;

import d.f.a.c;
import java.util.ArrayList;

/* compiled from: WidgetContainer.java */
/* loaded from: classes.dex */
public class l extends e {

    public ArrayList<e> u0 = new ArrayList<>();
    public l() {
        super();
        final ArrayList arrayList = new ArrayList();
    }

    @Override // d.f.a.m.e
    public void b(e eVar) {
        this.u0.add(eVar);
        if (eVar.I() != null) {
            (l)eVar.I().k1(eVar);
        }
        eVar.T0(this);
    }

    @Override // d.f.a.m.e
    public ArrayList<e> i1() {
        return this.u0;
    }

    @Override // d.f.a.m.e
    public void j1() {
        int i = 0;
        if (this.u0 == null) {
            return;
        }
        i = 0;
        while (i < this.u0.size()) {
            Object item = this.u0.get(i);
            z = item instanceof l;
            i = i + 1;
        }
    }

    @Override // d.f.a.m.e
    public void k1(e eVar) {
        this.u0.remove(eVar);
        eVar.o0();
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
    public void q0(c cVar) {
        int i = 0;
        super.q0(cVar);
        i = 0;
        while (i < this.u0.size()) {
            (e)this.u0.get(i).q0(cVar);
            i = i + 1;
        }
    }
}
