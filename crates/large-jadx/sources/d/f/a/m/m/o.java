package d.f.a.m.m;

import d.f.a.d;
import d.f.a.m.b;
import d.f.a.m.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class o {

    static int f;
    ArrayList<e> a;
    int b;
    int c = 0;
    ArrayList<d.f.a.m.m.o.a> d = null;
    private int e = -1;

    class a {
        public a(d.f.a.m.m.o o, e e2, d d3, int i4) {
            super();
            WeakReference obj1 = new WeakReference(e2);
            d3.x(e2.K);
            d3.x(e2.L);
            d3.x(e2.M);
            d3.x(e2.N);
            d3.x(e2.O);
        }
    }
    static {
    }

    public o(int i) {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.b = -1;
        int i4 = 0;
        int i5 = 0;
        int i3 = o.f;
        o.f = i3 + 1;
        this.b = i3;
        this.c = i;
    }

    private String e() {
        int i = this.c;
        if (i == 0) {
            return "Horizontal";
        }
        if (i == 1) {
            return "Vertical";
        }
        if (i == 2) {
            return "Both";
        }
        return "Unknown";
    }

    private int j(d d, ArrayList<e> arrayList2, int i3) {
        int i4;
        int i;
        int i2;
        ArrayList arrayList;
        Object obj;
        int aVar;
        int obj6;
        int obj7;
        i4 = 0;
        e eVar = (e)arrayList2.get(i4).I();
        d.D();
        (f)eVar.g(d, i4);
        i = i4;
        while (i < arrayList2.size()) {
            (e)arrayList2.get(i).g(d, i4);
            i++;
        }
        if (i3 == 0 && eVar.E0 > 0) {
            if (eVar.E0 > 0) {
                b.b(eVar, d, arrayList2, i4);
            }
        }
        i2 = 1;
        if (i3 == i2 && eVar.F0 > 0) {
            if (eVar.F0 > 0) {
                b.b(eVar, d, arrayList2, i2);
            }
        }
        d.z();
        arrayList = new ArrayList();
        this.d = arrayList;
        while (i4 < arrayList2.size()) {
            aVar = new o.a(this, (e)arrayList2.get(i4), d, i3);
            this.d.add(aVar);
            i4++;
        }
        if (i3 == 0) {
            obj6 = d.x(eVar.K);
            obj7 = d.x(eVar.M);
            d.D();
        } else {
            obj6 = d.x(eVar.L);
            obj7 = d.x(eVar.N);
            d.D();
        }
        return obj7 -= obj6;
    }

    public boolean a(e e) {
        if (this.a.contains(e)) {
            return 0;
        }
        this.a.add(e);
        return 1;
    }

    public void b(ArrayList<d.f.a.m.m.o> arrayList) {
        int i;
        int size;
        int i2;
        int i3;
        int size2 = this.a.size();
        if (this.e != -1 && size2 > 0) {
            if (size2 > 0) {
                i = 0;
                while (i < arrayList.size()) {
                    size = arrayList.get(i);
                    if (this.e == size.b) {
                    }
                    i++;
                    g(this.c, (o)size);
                }
            }
        }
        if (size2 == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public int f(d d, int i2) {
        if (this.a.size() == 0) {
            return 0;
        }
        return j(d, this.a, i2);
    }

    public void g(int i, d.f.a.m.m.o o2) {
        Object next;
        int i2;
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            o2.a((e)next);
            if (i == 0) {
            } else {
            }
            next.s0 = o2.c();
            next.r0 = o2.c();
        }
        this.e = o2.b;
    }

    public void h(boolean z) {
    }

    public void i(int i) {
        this.c = i;
    }

    public String toString() {
        String string;
        Object next;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(e());
        stringBuilder2.append(" [");
        stringBuilder2.append(this.b);
        stringBuilder2.append("] <");
        string = stringBuilder2.toString();
        Iterator iterator = this.a.iterator();
        for (e next : iterator) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(" ");
            stringBuilder.append(next.r());
            string = stringBuilder.toString();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(string);
        stringBuilder3.append(" >");
        return stringBuilder3.toString();
    }
}
