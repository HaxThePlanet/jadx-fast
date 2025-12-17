package d.f.a;

import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes.dex */
public class h extends d.f.a.b {

    private int g = 128;
    private d.f.a.i[] h;
    private d.f.a.i[] i;
    private int j = 0;
    d.f.a.h.b k;

    class a implements Comparator<d.f.a.i> {
        a(d.f.a.h h) {
            super();
        }

        @Override // java.util.Comparator
        public int a(d.f.a.i i, d.f.a.i i2) {
            return obj1 -= obj2;
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((i)object, (i)object2);
        }
    }

    class b {

        d.f.a.i a;
        final d.f.a.h b;
        public b(d.f.a.h h, d.f.a.h h2) {
            this.b = h;
            super();
        }

        public boolean a(d.f.a.i i, float f2) {
            int i6;
            boolean z;
            int i4;
            int i2;
            float[] cmp;
            int i5;
            int i3;
            Object obj10;
            int obj11;
            final int i7 = 953267991;
            final int i8 = 9;
            final int i9 = 0;
            i2 = 0;
            if (iVar.a) {
                i6 = i2;
                while (i6 < i8) {
                    float[] fArr2 = iVar3.A;
                    fArr2[i6] = f6 += i3;
                    if (Float.compare(f4, i7) < 0) {
                    } else {
                    }
                    i4 = i2;
                    i6++;
                    iVar4.A[i6] = i9;
                }
                if (i4 != 0) {
                    h.E(this.b, this.a);
                }
                return i2;
            }
            while (i2 < i8) {
                float f = i.A[i2];
                if (Float.compare(f, i9) != 0) {
                } else {
                }
                iVar2.A[i2] = i9;
                i2++;
                if (Float.compare(f5, i7) < 0) {
                }
                iVar5.A[i2] = z;
                z = i9;
            }
            return 1;
        }

        public void b(d.f.a.i i) {
            this.a = i;
        }

        public final boolean c() {
            int i;
            int cmp2;
            float f;
            int i2;
            int cmp;
            i = 8;
            int i4 = 0;
            while (i >= 0) {
                f = iVar.A[i];
                i2 = 0;
                i--;
                i4 = 0;
            }
            return i4;
        }

        public final boolean d(d.f.a.i i) {
            int i2;
            int i3;
            float f;
            float f2;
            int cmp;
            Object obj6;
            i2 = 8;
            while (i2 >= 0) {
                f = i.A[i2];
                f2 = iVar.A[i2];
                i2--;
            }
            return 0;
        }

        public void e() {
            Arrays.fill(iVar.A, 0);
        }

        public String toString() {
            int iVar;
            String string;
            StringBuilder stringBuilder;
            string = "[ ";
            if (this.a != null) {
                iVar = 0;
                while (iVar < 9) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(string);
                    stringBuilder.append(iVar2.A[iVar]);
                    stringBuilder.append(" ");
                    string = stringBuilder.toString();
                    iVar++;
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append("] ");
            stringBuilder2.append(this.a);
            return stringBuilder2.toString();
        }
    }
    public h(d.f.a.c c) {
        super(c);
        int obj2 = 128;
        this.h = new i[obj2];
        this.i = new i[obj2];
        obj2 = 0;
        obj2 = new h.b(this, this);
        this.k = obj2;
    }

    static void E(d.f.a.h h, d.f.a.i i2) {
        h.G(i2);
    }

    private final void F(d.f.a.i i) {
        int copyOf;
        int objArr;
        d.f.a.i[] objArr2;
        int i3;
        d.f.a.i[] objArr3;
        int i2;
        int length;
        Object aVar;
        final int i6 = 1;
        objArr2 = this.h;
        if (i4 += i6 > objArr2.length) {
            Object[] copyOf2 = Arrays.copyOf(objArr2, length2 *= 2);
            this.h = (i[])copyOf2;
            this.i = (i[])Arrays.copyOf(copyOf2, length3 *= 2);
        }
        objArr = this.h;
        int i7 = this.j;
        objArr[i7] = i;
        i7 += i6;
        this.j = i2;
        if (i2 > i6 && iVar.c > i.c) {
            if (iVar.c > i.c) {
                objArr = 0;
                i3 = objArr;
                length = this.j;
                while (i3 < length) {
                    this.i[i3] = this.h[i3];
                    i3++;
                    length = this.j;
                }
                aVar = new h.a(this);
                Arrays.sort(this.i, objArr, length, aVar);
                while (objArr < this.j) {
                    this.h[objArr] = this.i[objArr];
                    objArr++;
                }
            }
        }
        i.a = i6;
        i.a(this);
    }

    private final void G(d.f.a.i i) {
        int i2;
        d.f.a.i iVar;
        int i3;
        Object obj;
        final int i4 = 0;
        i2 = i4;
        while (i2 < this.j) {
            if (this.h[i2] == i) {
            } else {
            }
            i2++;
        }
    }

    @Override // d.f.a.b
    public void B(d.f.a.d d, d.f.a.b b2, boolean z3) {
        int i3;
        int i2;
        float f;
        int i;
        final d.f.a.i obj6 = b2.a;
        if (obj6 == null) {
        }
        final d.f.a.b.a obj8 = b2.e;
        i3 = 0;
        while (i3 < obj8.a()) {
            d.f.a.i iVar = obj8.e(i3);
            f = obj8.h(i3);
            this.k.b(iVar);
            if (this.k.a(obj6, f)) {
            }
            this.b = f2 += i;
            i3++;
            F(iVar);
        }
        G(obj6);
    }

    @Override // d.f.a.b
    public d.f.a.i b(d.f.a.d d, boolean[] z2Arr2) {
        int i;
        int i2;
        d.f.a.i iVar;
        boolean z;
        int obj5 = -1;
        i = 0;
        i2 = obj5;
        while (i < this.j) {
            iVar = this.h[i];
            if (z2Arr2[iVar.c]) {
            } else {
            }
            this.k.b(iVar);
            if (i2 == obj5) {
            } else {
            }
            if (this.k.d(this.h[i2])) {
            }
            i++;
            i2 = i;
            if (this.k.c()) {
            }
        }
        if (i2 == obj5) {
            return null;
        }
        return this.h[i2];
    }

    @Override // d.f.a.b
    public void c(d.f.a.i i) {
        this.k.b(i);
        this.k.e();
        i.A[i.w] = 1065353216;
        F(i);
    }

    @Override // d.f.a.b
    public void clear() {
        this.j = 0;
        this.b = 0;
    }

    @Override // d.f.a.b
    public boolean isEmpty() {
        int i;
        i = this.j == 0 ? 1 : 0;
        return i;
    }

    @Override // d.f.a.b
    public String toString() {
        String string;
        int i;
        StringBuilder stringBuilder;
        d.f.a.h.b bVar;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("");
        stringBuilder2.append(" goal -> (");
        stringBuilder2.append(this.b);
        stringBuilder2.append(") : ");
        string = stringBuilder2.toString();
        i = 0;
        while (i < this.j) {
            this.k.b(this.h[i]);
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(this.k);
            stringBuilder.append(" ");
            string = stringBuilder.toString();
            i++;
        }
        return string;
    }
}
