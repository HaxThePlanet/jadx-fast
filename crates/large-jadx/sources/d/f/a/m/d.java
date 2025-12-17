package d.f.a.m;

import d.f.a.c;
import d.f.a.i;
import d.f.a.i.a;
import d.f.a.m.m.i;
import d.f.a.m.m.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class d {

    private HashSet<d.f.a.m.d> a = null;
    private int b;
    private boolean c;
    public final d.f.a.m.e d;
    public final d.f.a.m.d.b e;
    public d.f.a.m.d f;
    public int g = 0;
    int h = Integer.MIN_VALUE;
    i i;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            d.a.a = iArr;
            iArr[d.b.CENTER.ordinal()] = 1;
            d.a.a[d.b.LEFT.ordinal()] = 2;
            d.a.a[d.b.RIGHT.ordinal()] = 3;
            d.a.a[d.b.TOP.ordinal()] = 4;
            d.a.a[d.b.BOTTOM.ordinal()] = 5;
            d.a.a[d.b.BASELINE.ordinal()] = 6;
            d.a.a[d.b.CENTER_X.ordinal()] = 7;
            d.a.a[d.b.CENTER_Y.ordinal()] = 8;
            d.a.a[d.b.NONE.ordinal()] = 9;
        }
    }

    public static enum b {

        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y;
    }
    public d(d.f.a.m.e e, d.f.a.m.d.b d$b2) {
        super();
        int i = 0;
        int i2 = 0;
        int i3 = Integer.MIN_VALUE;
        this.d = e;
        this.e = b2;
    }

    public boolean a(d.f.a.m.d d, int i2, int i3, boolean z4) {
        boolean obj5;
        final int i = 1;
        if (d == null) {
            p();
            return i;
        }
        if (!z4 && !o(d)) {
            if (!o(d)) {
                return 0;
            }
        }
        this.f = d;
        if (d.a == null) {
            obj5 = new HashSet();
            d.a = obj5;
        }
        HashSet obj2 = obj2.a;
        if (obj2 != null) {
            obj2.add(this);
        }
        this.g = i2;
        this.h = i3;
        return i;
    }

    public void b(int i, ArrayList<o> arrayList2, o o3) {
        Object iterator;
        d.f.a.m.e next;
        iterator = this.a;
        if (iterator != null) {
            iterator = iterator.iterator();
            for (d next2 : iterator) {
                i.a(next2.d, i, arrayList2, o3);
            }
        }
    }

    public HashSet<d.f.a.m.d> c() {
        return this.a;
    }

    public int d() {
        if (!this.c) {
            return 0;
        }
        return this.b;
    }

    public int e() {
        int i;
        final int i6 = 8;
        if (this.d.Q() == i6) {
            return 0;
        }
        i = this.f;
        if (this.h != Integer.MIN_VALUE && i != null && i.d.Q() == i6) {
            i = this.f;
            if (i != null) {
                if (i.d.Q() == i6) {
                    return this.h;
                }
            }
        }
        return this.g;
    }

    public final d.f.a.m.d f() {
        switch (i) {
            case 1:
                return null;
            case 2:
                return eVar2.M;
            case 3:
                return eVar3.K;
            case 4:
                return eVar.N;
            case 5:
                return eVar4.L;
            default:
                AssertionError assertionError = new AssertionError(this.e.name());
                throw assertionError;
        }
    }

    public d.f.a.m.e g() {
        return this.d;
    }

    public i h() {
        return this.i;
    }

    public d.f.a.m.d i() {
        return this.f;
    }

    public d.f.a.m.d.b j() {
        return this.e;
    }

    public boolean k() {
        boolean z;
        HashSet set = this.a;
        final int i2 = 0;
        if (set == null) {
            return i2;
        }
        Iterator iterator = set.iterator();
        for (d next2 : iterator) {
        }
        return i2;
    }

    public boolean l() {
        int i;
        HashSet set = this.a;
        if (set == null) {
            return 0;
        }
        if (set.size() > 0) {
            i = 1;
        }
        return i;
    }

    public boolean m() {
        return this.c;
    }

    public boolean n() {
        int i;
        i = this.f != null ? 1 : 0;
        return i;
    }

    public boolean o(d.f.a.m.d d) {
        int i3;
        Object obj;
        d.f.a.m.d.b rIGHT;
        int i;
        int i2;
        d.f.a.m.d.b bOTTOM;
        boolean obj6;
        i3 = 0;
        if (!d) {
            return i3;
        }
        d.f.a.m.d.b bVar2 = d.j();
        d.f.a.m.d.b bVar3 = this.e;
        final int i5 = 1;
        if (bVar2 == bVar3 && bVar3 == d.b.BASELINE && d.g().U() && !g().U()) {
            if (bVar3 == d.b.BASELINE) {
                if (d.g().U()) {
                    if (!g().U()) {
                    }
                }
                return i3;
            }
            return i5;
        }
        switch (i4) {
            case 1:
                i3 = i5;
                return i3;
            case 2:
                i = i3;
                i = i5;
                i3 = i5;
                i = i3;
                return i;
            case 3:
                i2 = i3;
                i2 = i5;
                i3 = i5;
                i2 = i3;
                return i2;
            case 4:
                return i5;
                return i3;
            case 5:
                return i3;
            default:
                obj6 = new AssertionError(this.e.name());
                throw obj6;
        }
    }

    public void p() {
        d.f.a.m.d size;
        size = this.f;
        int i2 = 0;
        size = size.a;
        size.remove(this);
        if (size != null && size != null && dVar.a.size() == 0) {
            size = size.a;
            if (size != null) {
                size.remove(this);
                if (dVar.a.size() == 0) {
                    size.a = i2;
                }
            }
        }
        this.a = i2;
        this.f = i2;
        int i = 0;
        this.g = i;
        this.h = Integer.MIN_VALUE;
        this.c = i;
        this.b = i;
    }

    public void q() {
        final int i = 0;
        this.c = i;
        this.b = i;
    }

    public void r(c c) {
        i.a uNRESTRICTED;
        int i;
        i obj3;
        obj3 = this.i;
        if (obj3 == null) {
            obj3 = new i(i.a.UNRESTRICTED, 0);
            this.i = obj3;
        } else {
            obj3.i();
        }
    }

    public void s(int i) {
        this.b = i;
        this.c = true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d.r());
        stringBuilder.append(":");
        stringBuilder.append(this.e.toString());
        return stringBuilder.toString();
    }
}
