package d.f.a.m.m;

import d.f.a.m.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DependencyNode.java */
/* loaded from: classes.dex */
public class f implements d {

    public d a = null;
    public boolean b = false;
    public boolean c = false;
    p d;
    f.a e;
    int f;
    public int g;
    int h = 1;
    g i = null;
    public boolean j = false;
    List<d> k = new ArrayList<>();
    List<f> l = new ArrayList<>();

    enum a {

        BASELINE,
        BOTTOM,
        HORIZONTAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        UNKNOWN,
        VERTICAL_DIMENSION;
    }
    public f(p pVar) {
        super();
        this.e = f.a.UNKNOWN;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.d = pVar;
    }

    public void a(d dVar) {
        int i = 0;
        int i2 = 0;
        Iterator it2 = this.l.iterator();
        while (it2.hasNext()) {
            if (!(f)it2.next().j) {
                return;
            }
        }
        boolean z3 = true;
        this.c = z3;
        if (this.a != null) {
            this.a.a(this);
        }
        if (this.b) {
            this.d.a(this);
            return;
        }
        i = 0;
        i2 = 0;
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            z2 = item instanceof g;
        }
        if (this.a != 0 && gVar.j == z3 && i.j && this.i != null && gVar.j) {
            i2 = this.h * gVar.g;
            this.f = i2;
            d(i.g + this.f);
        }
        if (this.a != null) {
            this.a.a(this);
        }
    }

    public void b(d dVar) {
        this.k.add(dVar);
        if (this.j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.l.clear();
        this.k.clear();
        boolean z = false;
        this.j = z;
        this.g = z;
        this.c = z;
        this.b = z;
    }

    public void d(int i) {
        if (this.j) {
            return;
        }
        boolean z = true;
        this.j = z;
        this.g = i;
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            item.a(item);
        }
    }

    @Override // java.lang.Object
    public String toString() {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d.b.r());
        stringBuilder.append(":");
        stringBuilder.append(this.e);
        stringBuilder.append("(");
        if (this.j) {
            Integer num = Integer.valueOf(this.g);
        } else {
            String str8 = "unresolved";
        }
        stringBuilder.append(obj);
        stringBuilder.append(") <t=");
        stringBuilder.append(this.l.size());
        stringBuilder.append(":d=");
        stringBuilder.append(this.k.size());
        stringBuilder.append(">");
        return stringBuilder.toString();
    }
}
