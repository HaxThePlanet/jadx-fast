package d.f.a;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class b implements d.f.a.d.a {

    d.f.a.i a = null;
    float b = 0f;
    boolean c;
    ArrayList<d.f.a.i> d;
    public d.f.a.b.a e;
    boolean f = false;

    public interface a {
        public abstract int a();

        public abstract boolean b(d.f.a.i i);

        public abstract float c(d.f.a.b b, boolean z2);

        public abstract void clear();

        public abstract void d(d.f.a.i i, float f2);

        public abstract d.f.a.i e(int i);

        public abstract void f(d.f.a.i i, float f2, boolean z3);

        public abstract void g();

        public abstract float h(int i);

        public abstract float i(d.f.a.i i, boolean z2);

        public abstract float j(d.f.a.i i);

        public abstract void k(float f);
    }
    public b() {
        super();
        int i = 0;
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        int i3 = 0;
    }

    public b(d.f.a.c c) {
        super();
        int i = 0;
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        int i3 = 0;
        a aVar = new a(this, c);
        this.e = aVar;
    }

    private boolean u(d.f.a.i i, d.f.a.d d2) {
        int obj2;
        if (i.E <= 1) {
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    private d.f.a.i w(boolean[] zArr, d.f.a.i i2) {
        int i4;
        int i3;
        int i;
        float f;
        int cmp2;
        boolean cmp;
        d.f.a.i.a sLACK;
        final int i6 = 0;
        i4 = 0;
        i3 = 0;
        i = i6;
        while (i3 < this.e.a()) {
            f = this.e.h(i3);
            if (Float.compare(f, i6) < 0) {
            }
            i3++;
            cmp2 = this.e.e(i3);
            if (zArr != null) {
            } else {
            }
            if (cmp2 != i2) {
            }
            cmp = cmp2.B;
            if (cmp != i.a.SLACK) {
            } else {
            }
            if (Float.compare(f, i) < 0) {
            }
            i = f;
            i4 = cmp2;
            if (cmp == i.a.ERROR && Float.compare(f, i) < 0) {
            }
            if (!zArr[cmp2.c] && cmp2 != i2) {
            }
        }
        return i4;
    }

    @Override // d.f.a.d$a
    public void A(d.f.a.d d, d.f.a.i i2, boolean z3) {
        d.f.a.b.a z;
        int i3;
        int i;
        Object obj5;
        if (i2 != null) {
            if (!i2.y) {
            } else {
                this.b = f2 += i;
                this.e.i(i2, z3);
                if (z3) {
                    i2.f(this);
                }
                if (d.t && this.e.a() == 0) {
                    if (this.e.a() == 0) {
                        obj5 = 1;
                        this.f = obj5;
                        d.a = obj5;
                    }
                }
            }
        }
    }

    @Override // d.f.a.d$a
    public void B(d.f.a.d d, d.f.a.b b2, boolean z3) {
        Object obj5;
        this.b = f2 += i2;
        if (z3) {
            b2.a.f(this);
        }
        if (d.t && this.a != null && this.e.a() == 0) {
            if (this.a != null) {
                if (this.e.a() == 0) {
                    obj5 = 1;
                    this.f = obj5;
                    d.a = obj5;
                }
            }
        }
    }

    @Override // d.f.a.d$a
    public void C(d.f.a.d d, d.f.a.i i2, boolean z3) {
        float z;
        d.f.a.b.a aVar;
        d.f.a.i[] objArr;
        Object obj5;
        if (i2 != null) {
            if (!i2.F) {
            } else {
                z = this.e.j(i2);
                this.b = f += i3;
                this.e.i(i2, z3);
                if (z3) {
                    i2.f(this);
                }
                this.e.f(cVar.d[i2.G], z, z3);
                if (d.t && this.e.a() == 0) {
                    if (this.e.a() == 0) {
                        obj5 = 1;
                        this.f = obj5;
                        d.a = obj5;
                    }
                }
            }
        }
    }

    @Override // d.f.a.d$a
    public void D(d.f.a.d d) {
        boolean z;
        int i;
        ArrayList list;
        int size;
        int i3;
        d.f.a.i iVar;
        ArrayList list2;
        int i2;
        if (objArr.length == 0) {
        }
        int i4 = 0;
        i = i4;
        list = 1;
        while (i == 0) {
            i3 = i4;
            while (i3 < this.e.a()) {
                iVar = this.e.e(i3);
                if (iVar.v == -1 && !iVar.y) {
                } else {
                }
                this.d.add(iVar);
                i3++;
                if (!iVar.y) {
                } else {
                }
                if (iVar.F) {
                }
            }
            size = this.d.size();
            if (size > 0) {
            } else {
            }
            i = list;
            list = 1;
            i3 = i4;
            while (i3 < size) {
                iVar = this.d.get(i3);
                if (iVar.y) {
                } else {
                }
                if (iVar.F) {
                } else {
                }
                B(d, d.g[iVar.v], list);
                i3++;
                C(d, (i)iVar, list);
                A(d, iVar, list);
            }
            this.d.clear();
            iVar = this.d.get(i3);
            if (iVar.y) {
            } else {
            }
            if (iVar.F) {
            } else {
            }
            B(d, d.g[iVar.v], list);
            i3++;
            C(d, (i)iVar, list);
            A(d, iVar, list);
            iVar = this.e.e(i3);
            if (iVar.v == -1 && !iVar.y) {
            } else {
            }
            this.d.add(iVar);
            i3++;
            if (!iVar.y) {
            } else {
            }
            if (iVar.F) {
            }
        }
        if (d.t && this.a != null && this.e.a() == 0) {
            if (this.a != null) {
                if (this.e.a() == 0) {
                    this.f = list;
                    d.a = list;
                }
            }
        }
    }

    @Override // d.f.a.d$a
    public void a(d.f.a.d.a d$a) {
        int i2;
        d.f.a.i iVar;
        float f;
        d.f.a.b.a aVar;
        int i;
        if (a instanceof b) {
            this.a = 0;
            this.e.clear();
            i2 = 0;
            while (i2 < a.e.a()) {
                this.e.f(a.e.e(i2), a.e.h(i2), true);
                i2++;
            }
        }
    }

    @Override // d.f.a.d$a
    public d.f.a.i b(d.f.a.d d, boolean[] z2Arr2) {
        return w(z2Arr2, 0);
    }

    @Override // d.f.a.d$a
    public void c(d.f.a.i i) {
        int i2;
        int i3;
        int i4 = i.w;
        i2 = 1065353216;
        if (i4 == 1) {
        } else {
            if (i4 == 2) {
                i2 = 1148846080;
            } else {
                if (i4 == 3) {
                    i2 = 1232348160;
                } else {
                    if (i4 == 4) {
                        i2 = 1315859240;
                    } else {
                        if (i4 == 5) {
                            i2 = 1399379109;
                        }
                    }
                }
            }
        }
        this.e.d(i, i2);
    }

    @Override // d.f.a.d$a
    public void clear() {
        this.e.clear();
        this.a = 0;
        this.b = 0;
    }

    @Override // d.f.a.d$a
    public d.f.a.b d(d.f.a.d d, int i2) {
        this.e.d(d.o(i2, "ep"), 1065353216);
        this.e.d(d.o(i2, "em"), -1082130432);
        return this;
    }

    @Override // d.f.a.d$a
    d.f.a.b e(d.f.a.i i, int i2) {
        this.e.d(i, (float)i2);
        return this;
    }

    @Override // d.f.a.d$a
    boolean f(d.f.a.d d) {
        int obj3;
        obj3 = g(d);
        final int i = 1;
        obj3 = obj3 == null ? i : 0;
        if (this.e.a() == 0) {
            this.f = i;
        }
        return obj3;
    }

    @Override // d.f.a.d$a
    d.f.a.i g(d.f.a.d d) {
        int i3;
        boolean z;
        int i2;
        boolean z2;
        int i7;
        int i4;
        int i8;
        int i6;
        int i;
        float f;
        d.f.a.i iVar;
        d.f.a.i.a cmp;
        d.f.a.i.a uNRESTRICTED;
        int i5;
        final int i11 = 0;
        i8 = i4;
        i = i6;
        i2 = i3;
        while (i7 < this.e.a()) {
            f = this.e.h(i7);
            iVar = this.e.e(i7);
            i5 = 1;
            if (iVar.B == i.a.UNRESTRICTED) {
            } else {
            }
            if (i3 == 0 && Float.compare(f, i11) < 0) {
            }
            i7++;
            if (Float.compare(f, i11) < 0) {
            }
            if (i2 == 0) {
            } else {
            }
            if (Float.compare(i, f) > 0) {
            } else {
            }
            if (i8 == 0 && u(iVar, d)) {
            }
            if (u(iVar, d)) {
            }
            i = f;
            i2 = iVar;
            i8 = i5;
            z2 = u(iVar, d);
            i8 = z2;
            i = f;
            i2 = iVar;
            z2 = u(iVar, d);
            if (i3 == 0) {
            } else {
            }
            if (Float.compare(i6, f) > 0) {
            } else {
            }
            if (i4 == 0 && u(iVar, d)) {
            }
            if (u(iVar, d)) {
            }
            i6 = f;
            i3 = iVar;
            i4 = i5;
            z = u(iVar, d);
            i4 = z;
            i6 = f;
            i3 = iVar;
            z = u(iVar, d);
        }
        if (i3 != 0) {
            return i3;
        }
        return i2;
    }

    @Override // d.f.a.d$a
    public d.f.a.i getKey() {
        return this.a;
    }

    @Override // d.f.a.d$a
    d.f.a.b h(d.f.a.i i, d.f.a.i i2, int i3, float f4, d.f.a.i i5, d.f.a.i i6, int i7) {
        int i9;
        int cmp;
        int i8;
        int i4;
        int i10;
        float obj6;
        d.f.a.i obj7;
        d.f.a.b.a obj9;
        i9 = 1065353216;
        if (i2 == i5) {
            this.e.d(i, i9);
            this.e.d(i6, i9);
            this.e.d(i2, -1073741824);
            return this;
        }
        i8 = -1082130432;
        if (Float.compare(f4, i11) == 0) {
            this.e.d(i, i9);
            this.e.d(i2, i8);
            this.e.d(i5, i8);
            this.e.d(i6, i9);
            if (i3 <= 0) {
                if (i7 > 0) {
                    this.b = (float)obj6;
                }
            } else {
            }
        } else {
            if (Float.compare(f4, i12) <= 0) {
                this.e.d(i, i8);
                this.e.d(i2, i9);
                this.b = (float)i3;
            } else {
                if (Float.compare(f4, i9) >= 0) {
                    this.e.d(i6, i8);
                    this.e.d(i5, i9);
                    this.b = (float)obj6;
                } else {
                    i4 = i9 - f4;
                    this.e.d(i, i4 * i9);
                    this.e.d(i2, i4 * i8);
                    this.e.d(i5, i8 *= f4);
                    this.e.d(i6, i9 *= f4);
                    if (i3 <= 0) {
                        if (i7 > 0) {
                            this.b = obj6 += obj7;
                        }
                    } else {
                    }
                }
            }
        }
        return this;
    }

    @Override // d.f.a.d$a
    d.f.a.b i(d.f.a.i i, int i2) {
        this.a = i;
        final float obj2 = (float)i2;
        i.x = obj2;
        this.b = obj2;
        this.f = true;
        return this;
    }

    @Override // d.f.a.d$a
    public boolean isEmpty() {
        int i;
        d.f.a.i cmp;
        int i2;
        if (this.a == null && Float.compare(f, i2) == 0 && this.e.a() == 0) {
            if (Float.compare(f, i2) == 0) {
                i = this.e.a() == 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // d.f.a.d$a
    d.f.a.b j(d.f.a.i i, d.f.a.i i2, float f3) {
        this.e.d(i, -1082130432);
        this.e.d(i2, f3);
        return this;
    }

    @Override // d.f.a.d$a
    public d.f.a.b k(d.f.a.i i, d.f.a.i i2, d.f.a.i i3, d.f.a.i i4, float f5) {
        this.e.d(i, -1082130432);
        this.e.d(i2, 1065353216);
        this.e.d(i3, f5);
        this.e.d(i4, -f5);
        return this;
    }

    @Override // d.f.a.d$a
    public d.f.a.b l(float f, float f2, float f3, d.f.a.i i4, d.f.a.i i5, d.f.a.i i6, d.f.a.i i7) {
        int cmp2;
        int cmp;
        int obj5;
        d.f.a.b.a obj6;
        int obj7;
        cmp2 = 0;
        this.b = cmp2;
        final int i = -1082130432;
        final int i2 = 1065353216;
        if (Float.compare(f2, cmp2) != 0) {
            if (Float.compare(f, f3) == 0) {
                this.e.d(i4, i2);
                this.e.d(i5, i);
                this.e.d(i7, i2);
                this.e.d(i6, i);
            } else {
                if (Float.compare(f, cmp2) == 0) {
                    this.e.d(i4, i2);
                    this.e.d(i5, i);
                } else {
                    if (Float.compare(f3, cmp2) == 0) {
                        this.e.d(i6, i2);
                        this.e.d(i7, i);
                    } else {
                        obj5 /= obj7;
                        this.e.d(i4, i2);
                        this.e.d(i5, i);
                        this.e.d(i7, obj5);
                        this.e.d(i6, -obj5);
                    }
                }
            }
        } else {
        }
        return this;
    }

    @Override // d.f.a.d$a
    public d.f.a.b m(d.f.a.i i, int i2) {
        int i3;
        d.f.a.b.a obj3;
        if (i2 < 0) {
            this.b = (float)obj3;
            this.e.d(i, 1065353216);
        } else {
            this.b = (float)i2;
            this.e.d(i, -1082130432);
        }
        return this;
    }

    @Override // d.f.a.d$a
    public d.f.a.b n(d.f.a.i i, d.f.a.i i2, int i3) {
        int i4;
        d.f.a.b.a aVar;
        d.f.a.b.a obj3;
        int obj5;
        i4 = 0;
        if (i3 != 0 && i3 < 0) {
            if (i3 < 0) {
                i3 *= -1;
                i4 = 1;
            }
            this.b = (float)obj5;
        }
        obj5 = -1082130432;
        final int i5 = 1065353216;
        if (i4 == 0) {
            this.e.d(i, obj5);
            this.e.d(i2, i5);
        } else {
            this.e.d(i, i5);
            this.e.d(i2, obj5);
        }
        return this;
    }

    @Override // d.f.a.d$a
    public d.f.a.b o(d.f.a.i i, d.f.a.i i2, d.f.a.i i3, int i4) {
        int i5;
        d.f.a.b.a aVar;
        d.f.a.b.a obj3;
        int obj6;
        i5 = 0;
        if (i4 != 0 && i4 < 0) {
            if (i4 < 0) {
                i4 *= -1;
                i5 = 1;
            }
            this.b = (float)obj6;
        }
        obj6 = -1082130432;
        final int i6 = 1065353216;
        if (i5 == 0) {
            this.e.d(i, obj6);
            this.e.d(i2, i6);
            this.e.d(i3, i6);
        } else {
            this.e.d(i, i6);
            this.e.d(i2, obj6);
            this.e.d(i3, obj6);
        }
        return this;
    }

    @Override // d.f.a.d$a
    public d.f.a.b p(d.f.a.i i, d.f.a.i i2, d.f.a.i i3, int i4) {
        int i5;
        d.f.a.b.a aVar;
        d.f.a.b.a obj3;
        int obj6;
        i5 = 0;
        if (i4 != 0 && i4 < 0) {
            if (i4 < 0) {
                i4 *= -1;
                i5 = 1;
            }
            this.b = (float)obj6;
        }
        obj6 = -1082130432;
        final int i6 = 1065353216;
        if (i5 == 0) {
            this.e.d(i, obj6);
            this.e.d(i2, i6);
            this.e.d(i3, obj6);
        } else {
            this.e.d(i, i6);
            this.e.d(i2, obj6);
            this.e.d(i3, i6);
        }
        return this;
    }

    @Override // d.f.a.d$a
    public d.f.a.b q(d.f.a.i i, d.f.a.i i2, d.f.a.i i3, d.f.a.i i4, float f5) {
        final int i5 = 1056964608;
        this.e.d(i3, i5);
        this.e.d(i4, i5);
        final int obj6 = -1090519040;
        this.e.d(i, obj6);
        this.e.d(i2, obj6);
        this.b = -f5;
        return this;
    }

    @Override // d.f.a.d$a
    void r() {
        float f;
        int cmp;
        f = this.b;
        if (Float.compare(f, i2) < 0) {
            this.b = f *= cmp;
            this.e.g();
        }
    }

    @Override // d.f.a.d$a
    boolean s() {
        d.f.a.i.a cmp;
        int i;
        d.f.a.i.a uNRESTRICTED;
        cmp = this.a;
        if (cmp != null) {
            if (cmp.B != i.a.UNRESTRICTED) {
                i = Float.compare(f, uNRESTRICTED) >= 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // d.f.a.d$a
    boolean t(d.f.a.i i) {
        return this.e.b(i);
    }

    @Override // d.f.a.d$a
    public String toString() {
        return z();
    }

    @Override // d.f.a.d$a
    public d.f.a.i v(d.f.a.i i) {
        return w(0, i);
    }

    @Override // d.f.a.d$a
    void x(d.f.a.i i) {
        d.f.a.i iVar;
        int i2;
        iVar = this.a;
        final int i4 = -1082130432;
        if (iVar != null) {
            this.e.d(iVar, i4);
            iVar2.v = -1;
            this.a = 0;
        }
        f *= i4;
        this.a = i;
        if (Float.compare(i3, obj4) == 0) {
        }
        this.b = obj4 /= i3;
        this.e.k(i3);
    }

    @Override // d.f.a.d$a
    public void y() {
        this.a = 0;
        this.e.clear();
        this.b = 0;
        this.f = false;
    }

    @Override // d.f.a.d$a
    String z() {
        String string;
        String string3;
        Object str;
        int stringBuilder3;
        StringBuilder stringBuilder2;
        StringBuilder stringBuilder;
        int i;
        d.f.a.i string2;
        float f;
        int cmp;
        int i2;
        String str8 = "";
        if (this.a == null) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(str8);
            stringBuilder4.append("0");
            string = stringBuilder4.toString();
        } else {
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append(str8);
            stringBuilder5.append(this.a);
            string = stringBuilder5.toString();
        }
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append(string);
        stringBuilder6.append(" = ");
        final int i4 = 0;
        final int i5 = 1;
        if (Float.compare(f3, i4) != 0) {
            StringBuilder stringBuilder7 = new StringBuilder();
            stringBuilder7.append(stringBuilder6.toString());
            stringBuilder7.append(this.b);
            string3 = stringBuilder7.toString();
            stringBuilder3 = i5;
        } else {
            stringBuilder3 = i;
        }
        while (i < this.e.a()) {
            string2 = this.e.e(i);
            if (string2 == null) {
            } else {
            }
            f = this.e.h(i);
            cmp = Float.compare(f, i4);
            if (cmp == 0) {
            } else {
            }
            string2 = string2.toString();
            if (stringBuilder3 == 0) {
            } else {
            }
            if (cmp > 0) {
            } else {
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string3);
            stringBuilder2.append(" - ");
            string3 = stringBuilder2.toString();
            f *= i2;
            if (Float.compare(f, i3) == 0) {
            } else {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(f);
            stringBuilder.append(" ");
            stringBuilder.append(string2);
            string3 = stringBuilder.toString();
            stringBuilder3 = i5;
            i++;
            stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string3 = stringBuilder.toString();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string3);
            stringBuilder2.append(" + ");
            string3 = stringBuilder2.toString();
            if (Float.compare(f, i4) < 0) {
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string3);
            stringBuilder2.append("- ");
            string3 = stringBuilder2.toString();
        }
        if (stringBuilder3 == 0) {
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string3);
            stringBuilder3.append("0.0");
            string3 = stringBuilder3.toString();
        }
        return string3;
    }
}
