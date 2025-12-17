package d.f.a;

import d.f.a.m.d;
import d.f.a.m.d.b;
import d.f.a.m.e;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class d {

    public static boolean r = false;
    public static boolean s = true;
    public static boolean t = true;
    public static boolean u = true;
    public static boolean v = false;
    private static int w = 1000;
    public static d.f.a.e x;
    public static long y;
    public static long z;
    public boolean a = false;
    int b = 0;
    private HashMap<String, d.f.a.i> c = null;
    private d.f.a.d.a d;
    private int e = 32;
    private int f = 32;
    d.f.a.b[] g = null;
    public boolean h = false;
    public boolean i = false;
    private boolean[] j;
    int k = 1;
    int l = 0;
    private int m = 32;
    final d.f.a.c n;
    private d.f.a.i[] o;
    private int p = 0;
    private d.f.a.d.a q;

    interface a {
        public abstract void a(d.f.a.d.a d$a);

        public abstract d.f.a.i b(d.f.a.d d, boolean[] z2Arr2);

        public abstract void c(d.f.a.i i);

        public abstract void clear();

        public abstract d.f.a.i getKey();

        public abstract boolean isEmpty();
    }

    class b extends d.f.a.b {
        public b(d.f.a.d d, d.f.a.c c2) {
            super();
            j obj1 = new j(this, c2);
            this.e = obj1;
        }
    }
    static {
    }

    public d() {
        d.f.a.b bVar;
        super();
        int i = 0;
        int i2 = 0;
        final int i5 = 32;
        this.j = new boolean[i5];
        int i3 = 1;
        this.o = new i[d.w];
        this.g = new b[i5];
        C();
        c cVar = new c();
        this.n = cVar;
        h hVar = new h(cVar);
        this.d = hVar;
        if (d.v) {
            bVar = new d.b(this, cVar);
            this.q = bVar;
        } else {
            bVar = new b(cVar);
            this.q = bVar;
        }
    }

    private final int B(d.f.a.d.a d$a, boolean z2) {
        int i3;
        int i;
        int i6;
        boolean[] zArr;
        int i2;
        d.f.a.i iVar;
        d.f.a.i key;
        int i4;
        int i8;
        int i7;
        int i5;
        int i9;
        boolean cmp;
        d.f.a.i.a uNRESTRICTED;
        d.f.a.e obj14 = d.x;
        final int i10 = 1;
        if (obj14 != null) {
            obj14.h = l += i10;
        }
        obj14 = 0;
        i = obj14;
        while (i < this.k) {
            this.j[i] = obj14;
            i++;
        }
        i2 = i6;
        while (i6 == 0) {
            d.f.a.e eVar = d.x;
            if (eVar != null) {
            }
            i2++;
            i4 = 1;
            if (a.getKey() != null) {
            }
            iVar = a.b(this, this.j);
            if (iVar != null) {
            } else {
            }
            i6 = i4;
            i4 = 2139095039;
            i8 = -1;
            i7 = obj14;
            i5 = i8;
            while (i7 < this.l) {
                i9 = this.g[i7];
                if (iVar2.B == i.a.UNRESTRICTED) {
                } else {
                }
                if (i9.f) {
                } else {
                }
                cmp = i9.e.j(iVar);
                i14 /= cmp;
                if (i9.t(iVar) && Float.compare(cmp, i15) < 0 && Float.compare(i9, i4) < 0) {
                }
                i7++;
                cmp = i9.e.j(iVar);
                if (Float.compare(cmp, i15) < 0) {
                }
                i14 /= cmp;
                if (Float.compare(i9, i4) < 0) {
                }
                i5 = i7;
                i4 = i9;
            }
            i4 = this.g[i5];
            i7.v = i8;
            i8 = d.x;
            if (i5 > i8 && i8 != null) {
            }
            i4 = this.g[i5];
            i7.v = i8;
            i8 = d.x;
            if (i8 != null) {
            }
            i4.x(iVar);
            iVar = i4.a;
            iVar.v = i5;
            iVar.m(this, i4);
            i8.j = l3 += i10;
            i9 = this.g[i7];
            if (iVar2.B == i.a.UNRESTRICTED) {
            } else {
            }
            if (i9.f) {
            } else {
            }
            cmp = i9.e.j(iVar);
            i14 /= cmp;
            if (i9.t(iVar) && Float.compare(cmp, i15) < 0 && Float.compare(i9, i4) < 0) {
            }
            i7++;
            cmp = i9.e.j(iVar);
            if (Float.compare(cmp, i15) < 0) {
            }
            i14 /= cmp;
            if (Float.compare(i9, i4) < 0) {
            }
            i5 = i7;
            i4 = i9;
            i8 = this.j;
            i7 = iVar.c;
            i8[i7] = i4;
            this.j[key2.c] = i4;
            eVar.i = l2 += i10;
        }
        return i2;
    }

    private void C() {
        int i2;
        boolean z;
        int i;
        d.f.a.f fVar;
        final int i3 = 0;
        i = 0;
        if (d.v) {
        }
    }

    private d.f.a.i a(d.f.a.i.a i$a, String string2) {
        Object iVar;
        int obj3;
        int obj4;
        iVar = cVar.c.b();
        if ((i)iVar == null) {
            iVar = new i(a, string2);
            iVar.k(a, string2);
        } else {
            (i)iVar.i();
            iVar.k(a, string2);
        }
        obj4 = d.w;
        if (this.p >= obj4) {
            obj4 *= 2;
            d.w = obj4;
            this.o = (i[])Arrays.copyOf(this.o, obj4);
        }
        obj4 = this.p;
        this.p = obj4 + 1;
        this.o[obj4] = iVar;
        return iVar;
    }

    private final void l(d.f.a.b b) {
        boolean z;
        d.f.a.i iVar;
        int i2;
        Object out;
        d.f.a.b str;
        d.f.a.f fVar;
        int i3;
        d.f.a.b[] objArr;
        int i;
        int i5;
        int i4;
        Object obj8;
        if (d.t && b.f) {
            if (b.f) {
                b.a.j(this, b.b);
            } else {
                int i6 = this.l;
                this.g[i6] = b;
                iVar = b.a;
                iVar.v = i6;
                this.l = i6++;
                iVar.m(this, b);
            }
        } else {
        }
        if (d.t && this.a) {
            if (this.a) {
                obj8 = 0;
                iVar = obj8;
                while (iVar < this.l) {
                    if (this.g[iVar] == null) {
                    }
                    i2 = this.g;
                    if (i2[iVar] != null && bVar2.f) {
                    }
                    iVar++;
                    if (bVar2.f) {
                    }
                    d.f.a.b bVar = i2[iVar];
                    bVar.a.j(this, bVar.b);
                    if (d.v) {
                    } else {
                    }
                    cVar.b.a(bVar);
                    str = 0;
                    this.g[iVar] = str;
                    i3 = i2;
                    int i8 = this.l;
                    while (i2 < i8) {
                        objArr = this.g;
                        i = i2 + -1;
                        objArr[i] = objArr[i2];
                        if (iVar3.v == i2) {
                        }
                        i3 = i2;
                        i2 = i4;
                        i8 = this.l;
                        objArr.v = i;
                    }
                    if (i3 < i8) {
                    }
                    this.l = i8--;
                    iVar--;
                    this.g[i3] = str;
                    objArr = this.g;
                    i = i2 + -1;
                    objArr[i] = objArr[i2];
                    if (iVar3.v == i2) {
                    }
                    i3 = i2;
                    i2 = i4;
                    objArr.v = i;
                    cVar2.a.a(bVar);
                    System.out.println("WTF");
                }
                this.a = obj8;
            }
        }
    }

    private void n() {
        int i;
        float f;
        d.f.a.i iVar;
        i = 0;
        while (i < this.l) {
            d.f.a.b bVar = this.g[i];
            iVar.x = bVar.b;
            i++;
        }
    }

    public static d.f.a.b s(d.f.a.d d, d.f.a.i i2, d.f.a.i i3, float f4) {
        final d.f.a.b obj0 = d.r();
        obj0.j(i2, i3, f4);
        return obj0;
    }

    private int u(d.f.a.d.a d$a) {
        int uNRESTRICTED;
        d.f.a.i i7;
        int i2;
        int i9;
        int i10;
        d.f.a.b[] cmp5;
        int i8;
        d.f.a.b bVar;
        d.f.a.i.a aVar2;
        d.f.a.i.a uNRESTRICTED2;
        int cmp;
        int i5;
        int i4;
        int i11;
        int i6;
        int i;
        int i3;
        d.f.a.i.a aVar;
        int cmp3;
        int cmp2;
        int cmp4;
        final Object obj = this;
        i9 = 0;
        i8 = 0;
        while (i9 < obj.l) {
            cmp5 = obj.g;
            i9++;
            i8 = 0;
        }
        i10 = 0;
        if (i10 != 0) {
            i10 = 0;
            cmp5 = 0;
            while (i10 == 0) {
                d.f.a.e eVar2 = d.x;
                if (eVar2 != null) {
                }
                aVar2 = 2139095039;
                i4 = 0;
                i11 = -1;
                i6 = -1;
                i = 0;
                while (i4 < obj.l) {
                    i3 = obj.g[i4];
                    if (iVar4.B == i.a.UNRESTRICTED) {
                    } else {
                    }
                    if (i3.f) {
                    } else {
                    }
                    if (Float.compare(f, i8) < 0) {
                    }
                    i4++;
                    uNRESTRICTED2 = 1;
                    aVar = 9;
                    if (d.u) {
                    } else {
                    }
                    uNRESTRICTED = 1;
                    while (uNRESTRICTED < obj.k) {
                        bVar = cVar2.d[uNRESTRICTED];
                        uNRESTRICTED2 = i3.e.j(bVar);
                        if (Float.compare(uNRESTRICTED2, i8) <= 0) {
                        } else {
                        }
                        cmp = 0;
                        while (cmp < 9) {
                            f4 /= uNRESTRICTED2;
                            if (Float.compare(aVar, aVar2) < 0) {
                            } else {
                            }
                            if (cmp > i) {
                            }
                            cmp++;
                            i6 = uNRESTRICTED;
                            i = cmp;
                            i11 = i4;
                            aVar2 = aVar;
                            if (cmp != i) {
                            } else {
                            }
                        }
                        uNRESTRICTED++;
                        f4 /= uNRESTRICTED2;
                        if (Float.compare(aVar, aVar2) < 0) {
                        } else {
                        }
                        if (cmp > i) {
                        }
                        cmp++;
                        i6 = uNRESTRICTED;
                        i = cmp;
                        i11 = i4;
                        aVar2 = aVar;
                        if (cmp != i) {
                        } else {
                        }
                        i5 = 9;
                    }
                    bVar = cVar2.d[uNRESTRICTED];
                    uNRESTRICTED2 = i3.e.j(bVar);
                    if (Float.compare(uNRESTRICTED2, i8) <= 0) {
                    } else {
                    }
                    cmp = 0;
                    while (cmp < 9) {
                        f4 /= uNRESTRICTED2;
                        if (Float.compare(aVar, aVar2) < 0) {
                        } else {
                        }
                        if (cmp > i) {
                        }
                        cmp++;
                        i6 = uNRESTRICTED;
                        i = cmp;
                        i11 = i4;
                        aVar2 = aVar;
                        if (cmp != i) {
                        } else {
                        }
                    }
                    uNRESTRICTED++;
                    f4 /= uNRESTRICTED2;
                    if (Float.compare(aVar, aVar2) < 0) {
                    } else {
                    }
                    if (cmp > i) {
                    }
                    cmp++;
                    i6 = uNRESTRICTED;
                    i = cmp;
                    i11 = i4;
                    aVar2 = aVar;
                    if (cmp != i) {
                    } else {
                    }
                    i5 = 9;
                    bVar = 0;
                    while (bVar < i3.e.a()) {
                        d.f.a.i iVar3 = i3.e.e(bVar);
                        cmp = i3.e.j(iVar3);
                        if (Float.compare(cmp, i8) <= 0) {
                        } else {
                        }
                        i5 = 0;
                        while (i5 < aVar) {
                            f3 /= cmp;
                            if (Float.compare(i13, aVar2) < 0) {
                            } else {
                            }
                            if (i5 > i) {
                            }
                            i5++;
                            aVar = 9;
                            i6 = iVar3.c;
                            i = i5;
                            i11 = i4;
                            aVar2 = i13;
                            if (i5 != i) {
                            } else {
                            }
                        }
                        bVar++;
                        uNRESTRICTED2 = 1;
                        aVar = 9;
                        f3 /= cmp;
                        if (Float.compare(i13, aVar2) < 0) {
                        } else {
                        }
                        if (i5 > i) {
                        }
                        i5++;
                        aVar = 9;
                        i6 = iVar3.c;
                        i = i5;
                        i11 = i4;
                        aVar2 = i13;
                        if (i5 != i) {
                        } else {
                        }
                    }
                    iVar3 = i3.e.e(bVar);
                    cmp = i3.e.j(iVar3);
                    if (Float.compare(cmp, i8) <= 0) {
                    } else {
                    }
                    i5 = 0;
                    while (i5 < aVar) {
                        f3 /= cmp;
                        if (Float.compare(i13, aVar2) < 0) {
                        } else {
                        }
                        if (i5 > i) {
                        }
                        i5++;
                        aVar = 9;
                        i6 = iVar3.c;
                        i = i5;
                        i11 = i4;
                        aVar2 = i13;
                        if (i5 != i) {
                        } else {
                        }
                    }
                    bVar++;
                    uNRESTRICTED2 = 1;
                    aVar = 9;
                    f3 /= cmp;
                    if (Float.compare(i13, aVar2) < 0) {
                    } else {
                    }
                    if (i5 > i) {
                    }
                    i5++;
                    aVar = 9;
                    i6 = iVar3.c;
                    i = i5;
                    i11 = i4;
                    aVar2 = i13;
                    if (i5 != i) {
                    } else {
                    }
                }
                i7 = -1;
                if (i11 != i7) {
                } else {
                }
                i10 = 1;
                if (cmp5++ > i12 /= 2) {
                }
                i10 = 1;
                bVar = obj.g[i11];
                aVar2.v = i7;
                d.f.a.e eVar = d.x;
                if (eVar != null) {
                }
                bVar.x(cVar.d[i6]);
                i7 = bVar.a;
                i7.v = i11;
                i7.m(obj, bVar);
                eVar.j = l += cmp;
                i3 = obj.g[i4];
                if (iVar4.B == i.a.UNRESTRICTED) {
                } else {
                }
                if (i3.f) {
                } else {
                }
                if (Float.compare(f, i8) < 0) {
                }
                i4++;
                uNRESTRICTED2 = 1;
                aVar = 9;
                if (d.u) {
                } else {
                }
                uNRESTRICTED = 1;
                while (uNRESTRICTED < obj.k) {
                    bVar = cVar2.d[uNRESTRICTED];
                    uNRESTRICTED2 = i3.e.j(bVar);
                    if (Float.compare(uNRESTRICTED2, i8) <= 0) {
                    } else {
                    }
                    cmp = 0;
                    while (cmp < 9) {
                        f4 /= uNRESTRICTED2;
                        if (Float.compare(aVar, aVar2) < 0) {
                        } else {
                        }
                        if (cmp > i) {
                        }
                        cmp++;
                        i6 = uNRESTRICTED;
                        i = cmp;
                        i11 = i4;
                        aVar2 = aVar;
                        if (cmp != i) {
                        } else {
                        }
                    }
                    uNRESTRICTED++;
                    f4 /= uNRESTRICTED2;
                    if (Float.compare(aVar, aVar2) < 0) {
                    } else {
                    }
                    if (cmp > i) {
                    }
                    cmp++;
                    i6 = uNRESTRICTED;
                    i = cmp;
                    i11 = i4;
                    aVar2 = aVar;
                    if (cmp != i) {
                    } else {
                    }
                    i5 = 9;
                }
                bVar = cVar2.d[uNRESTRICTED];
                uNRESTRICTED2 = i3.e.j(bVar);
                if (Float.compare(uNRESTRICTED2, i8) <= 0) {
                } else {
                }
                cmp = 0;
                while (cmp < 9) {
                    f4 /= uNRESTRICTED2;
                    if (Float.compare(aVar, aVar2) < 0) {
                    } else {
                    }
                    if (cmp > i) {
                    }
                    cmp++;
                    i6 = uNRESTRICTED;
                    i = cmp;
                    i11 = i4;
                    aVar2 = aVar;
                    if (cmp != i) {
                    } else {
                    }
                }
                uNRESTRICTED++;
                f4 /= uNRESTRICTED2;
                if (Float.compare(aVar, aVar2) < 0) {
                } else {
                }
                if (cmp > i) {
                }
                cmp++;
                i6 = uNRESTRICTED;
                i = cmp;
                i11 = i4;
                aVar2 = aVar;
                if (cmp != i) {
                } else {
                }
                i5 = 9;
                bVar = 0;
                while (bVar < i3.e.a()) {
                    iVar3 = i3.e.e(bVar);
                    cmp = i3.e.j(iVar3);
                    if (Float.compare(cmp, i8) <= 0) {
                    } else {
                    }
                    i5 = 0;
                    while (i5 < aVar) {
                        f3 /= cmp;
                        if (Float.compare(i13, aVar2) < 0) {
                        } else {
                        }
                        if (i5 > i) {
                        }
                        i5++;
                        aVar = 9;
                        i6 = iVar3.c;
                        i = i5;
                        i11 = i4;
                        aVar2 = i13;
                        if (i5 != i) {
                        } else {
                        }
                    }
                    bVar++;
                    uNRESTRICTED2 = 1;
                    aVar = 9;
                    f3 /= cmp;
                    if (Float.compare(i13, aVar2) < 0) {
                    } else {
                    }
                    if (i5 > i) {
                    }
                    i5++;
                    aVar = 9;
                    i6 = iVar3.c;
                    i = i5;
                    i11 = i4;
                    aVar2 = i13;
                    if (i5 != i) {
                    } else {
                    }
                }
                iVar3 = i3.e.e(bVar);
                cmp = i3.e.j(iVar3);
                if (Float.compare(cmp, i8) <= 0) {
                } else {
                }
                i5 = 0;
                while (i5 < aVar) {
                    f3 /= cmp;
                    if (Float.compare(i13, aVar2) < 0) {
                    } else {
                    }
                    if (i5 > i) {
                    }
                    i5++;
                    aVar = 9;
                    i6 = iVar3.c;
                    i = i5;
                    i11 = i4;
                    aVar2 = i13;
                    if (i5 != i) {
                    } else {
                    }
                }
                bVar++;
                uNRESTRICTED2 = 1;
                aVar = 9;
                f3 /= cmp;
                if (Float.compare(i13, aVar2) < 0) {
                } else {
                }
                if (i5 > i) {
                }
                i5++;
                aVar = 9;
                i6 = iVar3.c;
                i = i5;
                i11 = i4;
                aVar2 = i13;
                if (i5 != i) {
                } else {
                }
                eVar2.k = l2 += uNRESTRICTED2;
            }
            i2 = cmp5;
        } else {
            i2 = 0;
        }
        return i2;
    }

    public static d.f.a.e w() {
        return d.x;
    }

    private void y() {
        int i;
        d.f.a.e eVar;
        int i2;
        long l;
        i3 *= 2;
        this.e = i4;
        this.g = (b[])Arrays.copyOf(this.g, i4);
        d.f.a.c cVar = this.n;
        cVar.d = (i[])Arrays.copyOf(cVar.d, this.e);
        i = this.e;
        this.j = new boolean[i];
        this.f = i;
        this.m = i;
        eVar = d.x;
        if (eVar != null) {
            eVar.d = l2 += i6;
            eVar.o = Math.max(eVar.o, obj3);
            i = d.x;
            i.x = i.o;
        }
    }

    void A(d.f.a.d.a d$a) {
        d.f.a.e eVar;
        long l;
        long l2;
        eVar = d.x;
        if (eVar != null) {
            eVar.t = l3 += i3;
            eVar.u = Math.max(eVar.u, obj2);
            eVar = d.x;
            eVar.v = Math.max(eVar.v, obj2);
        }
        u(a);
        B(a, false);
        n();
    }

    public void D() {
        d.f.a.b bVar;
        int i2;
        int i;
        d.f.a.c cVar;
        d.f.a.i iVar;
        int i3;
        d.f.a.i[] objArr;
        int i4;
        int length;
        int i5 = 0;
        i2 = i5;
        d.f.a.c cVar3 = this.n;
        objArr = cVar3.d;
        while (i2 < objArr.length) {
            iVar = objArr[i2];
            if (iVar != null) {
            }
            i2++;
            cVar3 = this.n;
            objArr = cVar3.d;
            iVar.i();
        }
        cVar3.c.c(this.o, this.p);
        this.p = i5;
        Arrays.fill(cVar2.d, 0);
        HashMap map = this.c;
        if (map != null) {
            map.clear();
        }
        this.b = i5;
        this.d.clear();
        this.k = 1;
        i = i5;
        while (i < this.l) {
            i3 = this.g;
            if (i3[i] != 0) {
            }
            i++;
            i3.c = i5;
        }
        C();
        this.l = i5;
        if (d.v) {
            bVar = new d.b(this, this.n);
            this.q = bVar;
        } else {
            bVar = new b(this.n);
            this.q = bVar;
        }
    }

    public void b(e e, e e2, float f3, int i4) {
        final Object obj = this;
        Object obj2 = e;
        Object obj3 = e2;
        d.b lEFT = d.b.LEFT;
        d.b tOP = d.b.TOP;
        d.b rIGHT = d.b.RIGHT;
        d.b bOTTOM = d.b.BOTTOM;
        d.f.a.b bVar = r();
        double d3 = (double)d2;
        double d = (double)obj4;
        bVar.q(obj.q(obj2.m(tOP)), obj.q(obj2.m(bOTTOM)), obj.q(obj3.m(tOP)), obj.q(obj3.m(bOTTOM)), (float)i2);
        obj.d(bVar);
        d.f.a.b bVar2 = r();
        bVar2.q(obj.q(obj2.m(lEFT)), obj.q(obj2.m(rIGHT)), obj.q(obj3.m(lEFT)), obj.q(obj3.m(rIGHT)), (float)i);
        obj.d(bVar2);
    }

    public void c(d.f.a.i i, d.f.a.i i2, int i3, float f4, d.f.a.i i5, d.f.a.i i6, int i7, int i8) {
        final d.f.a.d dVar = this;
        final int i4 = i8;
        final d.f.a.b bVar2 = r();
        bVar2.h(i, i2, i3, f4, i5, i6, i7);
        if (i4 != 8) {
            bVar2.d(this, i4);
        }
        d(bVar2);
    }

    public void d(d.f.a.b b) {
        int i2;
        d.f.a.i iVar;
        boolean z;
        d.f.a.f fVar;
        int i4;
        boolean z3;
        int i;
        int i3;
        boolean z2;
        int i5;
        int i6;
        if (b == null) {
        }
        d.f.a.e eVar = d.x;
        final int i10 = 1;
        eVar.f = l += i10;
        if (eVar != null && b.f) {
            eVar.f = l += i10;
            if (b.f) {
                eVar.g = l2 += i10;
            }
        }
        i = 1;
        if (i7 += i < this.m) {
            if (i8 += i >= this.f) {
                y();
            }
        } else {
        }
        b.D(this);
        if (!b.f && b.isEmpty()) {
            b.D(this);
            if (b.isEmpty()) {
            }
            b.r();
            z2 = p();
            b.a = z2;
            l(b);
            if (b.f(this) && this.l == i12 += i) {
                z2 = p();
                b.a = z2;
                l(b);
                if (this.l == i12 += i) {
                    this.q.a(b);
                    B(this.q, i);
                    iVar = b.v(z2);
                    z2 = d.x;
                    if (z2.v == -1 && b.a == z2 && iVar != null && z2 != null) {
                        if (b.a == z2) {
                            iVar = b.v(z2);
                            if (iVar != null) {
                                z2 = d.x;
                                if (z2 != null) {
                                    z2.j = l3 += i10;
                                }
                                b.x(iVar);
                            }
                        }
                        if (!b.f) {
                            b.a.m(this, b);
                        }
                        if (d.v) {
                            cVar.a.a(b);
                        } else {
                            cVar2.b.a(b);
                        }
                        this.l = i9 -= i;
                    }
                } else {
                    i = i4;
                }
            } else {
            }
            if (!b.s()) {
            }
            i4 = i;
        }
        if (i4 == 0) {
            l(b);
        }
    }

    public d.f.a.b e(d.f.a.i i, d.f.a.i i2, int i3, int i4) {
        boolean z;
        int i5;
        final int i6 = 8;
        if (d.s && i4 == i6 && i2.y && i.v == -1) {
            if (i4 == i6) {
                if (i2.y) {
                    if (i.v == -1) {
                        i.j(this, obj5 += obj6);
                        return null;
                    }
                }
            }
        }
        d.f.a.b bVar = r();
        bVar.n(i, i2, i3);
        if (i4 != i6) {
            bVar.d(this, i4);
        }
        d(bVar);
        return bVar;
    }

    public void f(d.f.a.i i, int i2) {
        int i4;
        boolean z;
        d.f.a.b bVar;
        int i3;
        boolean z2;
        int i5;
        float obj6;
        i3 = -1;
        final int i9 = 1;
        if (d.s && i.v == i3) {
            if (i.v == i3) {
                final float obj7 = (float)i2;
                i.j(this, obj7);
                i4 = 0;
                while (i4 < i7 += i9) {
                    i3 = cVar.d[i4];
                    if (i3 != 0 && i3.F && i3.G == i.c) {
                    }
                    i4++;
                    if (i3.F) {
                    }
                    if (i3.G == i.c) {
                    }
                    i3.j(this, f += obj7);
                }
            }
        }
        int i6 = i.v;
        if (i6 != i3) {
            bVar = this.g[i6];
            if (bVar.f) {
                bVar.b = (float)i2;
            } else {
                if (bVar.e.a() == 0) {
                    bVar.f = i9;
                    bVar.b = (float)i2;
                } else {
                    bVar = r();
                    bVar.m(i, i2);
                    d(bVar);
                }
            }
        } else {
            bVar = r();
            bVar.i(i, i2);
            d(bVar);
        }
    }

    public void g(d.f.a.i i, d.f.a.i i2, int i3, boolean z4) {
        final d.f.a.b obj6 = r();
        final d.f.a.i iVar = t();
        iVar.w = 0;
        obj6.o(i, i2, iVar, i3);
        d(obj6);
    }

    public void h(d.f.a.i i, d.f.a.i i2, int i3, int i4) {
        int obj4;
        d.f.a.i obj5;
        final d.f.a.b bVar = r();
        final d.f.a.i iVar = t();
        iVar.w = 0;
        bVar.o(i, i2, iVar, i3);
        if (i4 != 8) {
            m(bVar, (int)obj4, i4);
        }
        d(bVar);
    }

    public void i(d.f.a.i i, d.f.a.i i2, int i3, boolean z4) {
        final d.f.a.b obj6 = r();
        final d.f.a.i iVar = t();
        iVar.w = 0;
        obj6.p(i, i2, iVar, i3);
        d(obj6);
    }

    public void j(d.f.a.i i, d.f.a.i i2, int i3, int i4) {
        int obj4;
        d.f.a.i obj5;
        final d.f.a.b bVar = r();
        final d.f.a.i iVar = t();
        iVar.w = 0;
        bVar.p(i, i2, iVar, i3);
        if (i4 != 8) {
            m(bVar, (int)obj4, i4);
        }
        d(bVar);
    }

    public void k(d.f.a.i i, d.f.a.i i2, d.f.a.i i3, d.f.a.i i4, float f5, int i6) {
        final d.f.a.b bVar2 = r();
        bVar2.k(i, i2, i3, i4, f5);
        if (i6 != 8) {
            bVar2.d(this, i6);
        }
        d(bVar2);
    }

    void m(d.f.a.b b, int i2, int i3) {
        b.e(o(i3, 0), i2);
    }

    public d.f.a.i o(int i, String string2) {
        int i2;
        int i3;
        d.f.a.e eVar = d.x;
        if (eVar != null) {
            eVar.l = l += i3;
        }
        if (i4++ >= this.f) {
            y();
        }
        final d.f.a.i obj7 = a(i.a.ERROR, string2);
        i6++;
        this.b = i7;
        this.k = i9++;
        obj7.c = i7;
        obj7.w = i;
        obj6.d[i7] = obj7;
        this.d.c(obj7);
        return obj7;
    }

    public d.f.a.i p() {
        int i2;
        int i;
        d.f.a.e eVar = d.x;
        if (eVar != null) {
            eVar.n = l += i;
        }
        if (i3++ >= this.f) {
            y();
        }
        d.f.a.i iVar = a(i.a.SLACK, 0);
        i7++;
        this.b = i8;
        this.k = i9++;
        iVar.c = i8;
        cVar.d[i8] = iVar;
        return iVar;
    }

    public d.f.a.i q(Object object) {
        int i2;
        boolean z;
        int i;
        Object obj4;
        if (object == null) {
            return null;
        }
        if (i3++ >= this.f) {
            y();
        }
        if (object instanceof d && (d)object.h() == null) {
            if ((d)object.h() == null) {
                object.r(this.n);
                i2 = obj4;
            }
            obj4 = i2.c;
            z = -1;
            if (obj4 != z && obj4 <= this.b) {
                if (obj4 <= this.b) {
                    if (cVar3.d[obj4] == null && obj4 != z) {
                        if (obj4 != z) {
                            i2.i();
                        }
                        obj4++;
                        this.b = obj4;
                        this.k = i5++;
                        i2.c = obj4;
                        i2.B = i.a.UNRESTRICTED;
                        cVar2.d[obj4] = i2;
                    }
                } else {
                }
            } else {
            }
        }
        return i2;
    }

    public d.f.a.b r() {
        Object bVar;
        int i;
        final int i2 = 1;
        if (d.v) {
            bVar = cVar.a.b();
            if ((b)bVar == null) {
                bVar = new d.b(this, this.n);
                d.z = l += i2;
            } else {
                (b)bVar.y();
            }
        } else {
            bVar = cVar2.b.b();
            if ((b)bVar == null) {
                bVar = new b(this.n);
                d.y = l2 += i2;
            } else {
                (b)bVar.y();
            }
        }
        i.e();
        return bVar;
    }

    public d.f.a.i t() {
        int i2;
        int i;
        d.f.a.e eVar = d.x;
        if (eVar != null) {
            eVar.m = l += i;
        }
        if (i3++ >= this.f) {
            y();
        }
        d.f.a.i iVar = a(i.a.SLACK, 0);
        i7++;
        this.b = i8;
        this.k = i9++;
        iVar.c = i8;
        cVar.d[i8] = iVar;
        return iVar;
    }

    public d.f.a.c v() {
        return this.n;
    }

    public int x(Object object) {
        d.f.a.i obj2 = (d)object.h();
        if (obj2 != null) {
            return (int)obj2;
        }
        return 0;
    }

    public void z() {
        Object obj;
        boolean z2;
        int i;
        int i2;
        boolean z;
        d.f.a.e eVar = d.x;
        final int i3 = 1;
        if (eVar != null) {
            eVar.e = l += i3;
        }
        if (this.d.isEmpty()) {
            n();
        }
        if (!this.h) {
            if (this.i) {
                d.f.a.e eVar2 = d.x;
                if (eVar2 != null) {
                    eVar2.q = l2 += i3;
                }
                i2 = i;
                while (i2 < this.l) {
                    i2++;
                }
                i = 1;
                if (i == 0) {
                    A(this.d);
                } else {
                    obj = d.x;
                    if (obj != null) {
                        obj.p = l3 += i3;
                    }
                    n();
                }
            } else {
                A(this.d);
            }
        } else {
        }
    }
}
