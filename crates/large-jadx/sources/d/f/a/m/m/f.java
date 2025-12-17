package d.f.a.m.m;

import d.f.a.m.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class f implements d.f.a.m.m.d {

    public d.f.a.m.m.d a = null;
    public boolean b = false;
    public boolean c = false;
    d.f.a.m.m.p d;
    d.f.a.m.m.f.a e;
    int f;
    public int g;
    int h = 1;
    d.f.a.m.m.g i = null;
    public boolean j = false;
    List<d.f.a.m.m.d> k;
    List<d.f.a.m.m.f> l;

    static enum a {

        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE;
    }
    public f(d.f.a.m.m.p p) {
        super();
        int i = 0;
        final int i2 = 0;
        this.e = f.a.UNKNOWN;
        int i3 = 1;
        ArrayList arrayList = new ArrayList();
        this.k = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.l = arrayList2;
        this.d = p;
    }

    @Override // d.f.a.m.m.d
    public void a(d.f.a.m.m.d d) {
        boolean z2;
        int i2;
        int i;
        Object next;
        boolean z;
        d.f.a.m.m.g obj6;
        obj6 = this.l.iterator();
        for (f next3 : obj6) {
        }
        obj6 = 1;
        this.c = obj6;
        d.f.a.m.m.d dVar = this.a;
        if (dVar != null) {
            dVar.a(this);
        }
        if (this.b) {
            this.d.a(this);
        }
        i2 = 0;
        i = 0;
        Iterator iterator = this.l.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next instanceof g) {
            } else {
            }
            i++;
            i2 = next;
        }
        obj6 = this.i;
        if (i2 != 0 && i == obj6 && i2.j && obj6 != null && obj6.j) {
            if (i == obj6) {
                if (i2.j) {
                    obj6 = this.i;
                    if (obj6 != null) {
                        if (obj6.j) {
                            this.f = i3 *= obj6;
                        }
                    }
                    d(obj6 += i2);
                }
            }
        }
        obj6 = this.a;
        if (obj6 != null) {
            obj6.a(this);
        }
    }

    @Override // d.f.a.m.m.d
    public void b(d.f.a.m.m.d d) {
        this.k.add(d);
        if (this.j) {
            d.a(d);
        }
    }

    @Override // d.f.a.m.m.d
    public void c() {
        this.l.clear();
        this.k.clear();
        int i = 0;
        this.j = i;
        this.g = i;
        this.c = i;
        this.b = i;
    }

    @Override // d.f.a.m.m.d
    public void d(int i) {
        int next;
        if (this.j) {
        }
        this.j = true;
        this.g = i;
        Iterator obj2 = this.k.iterator();
        for (d next : obj2) {
            next.a(next);
        }
    }

    @Override // d.f.a.m.m.d
    public String toString() {
        Object valueOf;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(pVar.b.r());
        stringBuilder.append(":");
        stringBuilder.append(this.e);
        stringBuilder.append("(");
        if (this.j) {
            valueOf = Integer.valueOf(this.g);
        } else {
            valueOf = "unresolved";
        }
        stringBuilder.append(valueOf);
        stringBuilder.append(") <t=");
        stringBuilder.append(this.l.size());
        stringBuilder.append(":d=");
        stringBuilder.append(this.k.size());
        stringBuilder.append(">");
        return stringBuilder.toString();
    }
}
