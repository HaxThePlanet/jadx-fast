package d.f.a;

import java.util.Arrays;

/* loaded from: classes.dex */
public class j implements d.f.a.b.a {

    private static float m = 0.001f;
    private int a = 16;
    private int b = 16;
    int[] c;
    int[] d;
    int[] e;
    float[] f;
    int[] g;
    int[] h;
    int i = 0;
    int j = -1;
    private final d.f.a.b k;
    protected final d.f.a.c l;
    static {
    }

    j(d.f.a.b b, d.f.a.c c2) {
        super();
        int i = 16;
        this.c = new int[i];
        this.d = new int[i];
        this.e = new int[i];
        this.f = new float[i];
        this.g = new int[i];
        this.h = new int[i];
        int i2 = 0;
        int i3 = -1;
        this.k = b;
        this.l = c2;
        clear();
    }

    private void l(d.f.a.i i, int i2) {
        int[] iArr;
        int i3;
        int obj4;
        obj4 %= i4;
        iArr = this.c;
        final int i5 = -1;
        if (iArr[obj4] == i5) {
            iArr[obj4] = i2;
        }
        this.d[i2] = i5;
    }

    private void m(int i, d.f.a.i i2, float f3) {
        this.e[i] = i2.c;
        this.f[i] = f3;
        int i3 = -1;
        this.g[i] = i3;
        this.h[i] = i3;
        i2.a(this.k);
        i2.E = obj3++;
        this.i = obj3++;
    }

    private int n() {
        int i3;
        int i;
        int i2;
        i3 = 0;
        i2 = -1;
        while (i3 < this.a) {
            i3++;
            i2 = -1;
        }
        return i2;
    }

    private void o() {
        int i2;
        int[] iArr;
        int i;
        i3 *= 2;
        this.e = Arrays.copyOf(this.e, i4);
        this.f = Arrays.copyOf(this.f, i4);
        this.g = Arrays.copyOf(this.g, i4);
        this.h = Arrays.copyOf(this.h, i4);
        this.d = Arrays.copyOf(this.d, i4);
        i2 = this.a;
        while (i2 < i4) {
            i = -1;
            this.e[i2] = i;
            this.d[i2] = i;
            i2++;
        }
        this.a = i4;
    }

    private void q(int i, d.f.a.i i2, float f3) {
        int i4;
        int i3;
        int[] obj4;
        int obj6;
        final int i5 = n();
        m(i5, i2, f3);
        obj6 = -1;
        if (i != obj6) {
            this.g[i5] = i;
            i4 = this.h;
            i4[i5] = i4[i];
            i4[i] = i5;
        } else {
            this.g[i5] = obj6;
            if (this.i > 0) {
                this.h[i5] = this.j;
                this.j = i5;
            } else {
                this.h[i5] = obj6;
            }
        }
        obj4 = this.h;
        if (obj4[i5] != obj6) {
            this.g[obj4[i5]] = i5;
        }
        l(i2, i5);
    }

    private void r(d.f.a.i i) {
        int i2;
        int[] iArr;
        int i4;
        int i3;
        int[] obj6;
        obj6 = i.c;
        i2 = obj6 % i5;
        iArr = this.c;
        i4 = iArr[i2];
        final int i6 = -1;
        if (i4 == i6) {
        }
        if (this.e[i4] == obj6) {
            obj6 = this.d;
            iArr[i2] = obj6[i4];
            obj6[i4] = i6;
        }
    }

    @Override // d.f.a.b$a
    public int a() {
        return this.i;
    }

    @Override // d.f.a.b$a
    public boolean b(d.f.a.i i) {
        int obj2;
        obj2 = p(i) != -1 ? 1 : 0;
        return obj2;
    }

    @Override // d.f.a.b$a
    public float c(d.f.a.b b, boolean z2) {
        int i3;
        int i4;
        int[] iArr;
        int i;
        int i2;
        float f = j(b.a);
        i(b.a, z2);
        final d.f.a.b.a obj8 = b.e;
        int i6 = obj8.j;
        i4 = i3;
        while (i3 < (j)obj8.a()) {
            iArr = obj8.e;
            if (iArr[i4] != -1) {
            }
            i4++;
            f(cVar.d[iArr[i4]], f2 *= f, z2);
            i3++;
        }
        return f;
    }

    @Override // d.f.a.b$a
    public void clear() {
        int i3;
        int i4;
        int i2;
        int i;
        d.f.a.i iVar;
        d.f.a.b bVar;
        final int i6 = 0;
        i2 = i6;
        while (i2 < this.i) {
            iVar = e(i2);
            if (iVar != null) {
            }
            i2++;
            iVar.f(this.k);
        }
        i3 = i6;
        iVar = -1;
        while (i3 < this.a) {
            this.e[i3] = iVar;
            this.d[i3] = iVar;
            i3++;
            iVar = -1;
        }
        i4 = i6;
        while (i4 < this.b) {
            this.c[i4] = iVar;
            i4++;
        }
        this.i = i6;
        this.j = iVar;
    }

    @Override // d.f.a.b$a
    public void d(d.f.a.i i, float f2) {
        float cmp;
        int i3;
        int i6;
        int i2;
        int i4;
        int i5;
        int[] iArr;
        int i8;
        int i7;
        d.f.a.i obj9;
        cmp = j.m;
        i2 = 1;
        if (Float.compare(f2, i11) > 0 && Float.compare(f2, cmp) < 0) {
            if (Float.compare(f2, cmp) < 0) {
                i(i, i2);
            }
        }
        i6 = 0;
        if (this.i == 0) {
            m(i6, i, f2);
            l(i, i6);
            this.j = i6;
        } else {
            i3 = p(i);
            i4 = -1;
            if (i3 != i4) {
                this.f[i3] = f2;
            } else {
                if (i9 += i2 >= this.a) {
                    o();
                }
                i2 = this.j;
                i5 = i4;
                while (i6 < this.i) {
                    int[] iArr2 = this.e;
                    i7 = i.c;
                    if (iArr2[i2] < i7) {
                    }
                    i6++;
                    i5 = i2;
                }
                q(i5, i, f2);
            }
        }
    }

    @Override // d.f.a.b$a
    public d.f.a.i e(int i) {
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5 = this.i;
        final int i7 = 0;
        if (i5 == 0) {
            return i7;
        }
        i2 = this.j;
        i3 = 0;
        while (i3 < i5) {
            i4 = -1;
            i3++;
        }
        return i7;
    }

    @Override // d.f.a.b$a
    public void f(d.f.a.i i, float f2, boolean z3) {
        float cmp;
        float[] i2;
        float f;
        int i3;
        int obj6;
        cmp = j.m;
        if (Float.compare(f2, i5) > 0 && Float.compare(f2, cmp) < 0) {
            if (Float.compare(f2, cmp) < 0) {
            }
        }
        int i4 = p(i);
        if (i4 == -1) {
            d(i, f2);
        } else {
            i2 = this.f;
            i2[i4] = f3 += f2;
            f = j.m;
            if (Float.compare(obj6, i3) > 0 && Float.compare(obj6, f) < 0) {
                if (Float.compare(obj6, f) < 0) {
                    i2[i4] = 0;
                    i(i, z3);
                }
            }
        }
    }

    @Override // d.f.a.b$a
    public void g() {
        int i2;
        int i3;
        int i5;
        int i;
        int i4;
        i2 = this.j;
        i3 = 0;
        while (i3 < this.i) {
            float[] fArr = this.f;
            fArr[i2] = f *= i4;
            if (this.h[i2] == -1) {
                break;
            } else {
            }
            i3++;
        }
    }

    @Override // d.f.a.b$a
    public float h(int i) {
        int i2;
        int i3;
        int i4;
        i2 = this.j;
        i3 = 0;
        while (i3 < this.i) {
            i3++;
        }
        return 0;
    }

    @Override // d.f.a.b$a
    public float i(d.f.a.i i, boolean z2) {
        int i4;
        int i6;
        int i2;
        int i5;
        int i7;
        int i3;
        d.f.a.b obj9;
        i4 = p(i);
        i6 = -1;
        if (i4 == i6) {
            return 0;
        }
        r(i);
        if (this.j == i4) {
            this.j = this.h[i4];
        }
        this.e[i4] = i6;
        int[] iArr3 = this.g;
        if (iArr3[i4] != i6) {
            i5 = this.h;
            i5[iArr3[i4]] = i5[i4];
        }
        int[] iArr4 = this.h;
        if (iArr4[i4] != i6) {
            iArr3[iArr4[i4]] = iArr3[i4];
        }
        this.i = i8--;
        i.E = i10--;
        if (z2 != null) {
            i.f(this.k);
        }
        return this.f[i4];
    }

    @Override // d.f.a.b$a
    public float j(d.f.a.i i) {
        int obj2 = p(i);
        if (obj2 != -1) {
            return this.f[obj2];
        }
        return 0;
    }

    @Override // d.f.a.b$a
    public void k(float f) {
        int i;
        int i2;
        int i3;
        int i4;
        i = this.j;
        i2 = 0;
        while (i2 < this.i) {
            float[] fArr = this.f;
            fArr[i] = f2 /= f;
            if (this.h[i] == -1) {
                break;
            } else {
            }
            i2++;
        }
    }

    @Override // d.f.a.b$a
    public int p(d.f.a.i i) {
        int i5;
        int i2;
        int i3;
        int i4;
        Object obj6;
        final int i8 = -1;
        if (this.i != 0) {
            if (i == null) {
            } else {
                obj6 = i.c;
                i5 = this.c[obj6 % i6];
                if (i5 == i8) {
                    return i8;
                }
                if (this.e[i5] == obj6) {
                    return i5;
                }
                i2 = this.d;
                while (i2[i5] != i8) {
                    if (this.e[i2[i5]] != obj6) {
                    }
                    i5 = i2[i5];
                    i2 = this.d;
                }
                if (i2[i5] == i8) {
                    return i8;
                }
                if (this.e[i2[i5]] == obj6) {
                    return i2[i5];
                }
            }
        }
        return i8;
    }

    @Override // d.f.a.b$a
    public String toString() {
        String string;
        String string3;
        String string2;
        int i;
        d.f.a.i stringBuilder2;
        StringBuilder stringBuilder3;
        int stringBuilder;
        StringBuilder stringBuilder4;
        String str;
        int i2;
        int i3;
        int i4;
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(hashCode());
        stringBuilder5.append(" { ");
        string = stringBuilder5.toString();
        i = 0;
        while (i < this.i) {
            stringBuilder2 = e(i);
            if (stringBuilder2 == null) {
            } else {
            }
            StringBuilder stringBuilder7 = new StringBuilder();
            stringBuilder7.append(string);
            stringBuilder7.append(stringBuilder2);
            stringBuilder7.append(" = ");
            stringBuilder7.append(h(i));
            stringBuilder7.append(" ");
            int i7 = p(stringBuilder2);
            StringBuilder stringBuilder8 = new StringBuilder();
            stringBuilder8.append(stringBuilder7.toString());
            stringBuilder8.append("[p: ");
            String string5 = stringBuilder8.toString();
            str = "none";
            i2 = -1;
            if (this.g[i7] != i2) {
            } else {
            }
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append(string5);
            stringBuilder4.append(str);
            string3 = stringBuilder4.toString();
            StringBuilder stringBuilder9 = new StringBuilder();
            stringBuilder9.append(string3);
            stringBuilder9.append(", n: ");
            String string6 = stringBuilder9.toString();
            if (this.h[i7] != i2) {
            } else {
            }
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string6);
            stringBuilder3.append(str);
            string2 = stringBuilder3.toString();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append("]");
            string = stringBuilder2.toString();
            i++;
            stringBuilder = new StringBuilder();
            stringBuilder.append(string6);
            stringBuilder.append(cVar.d[this.e[this.h[i7]]]);
            string2 = stringBuilder.toString();
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append(string5);
            stringBuilder4.append(cVar2.d[this.e[this.g[i7]]]);
            string3 = stringBuilder4.toString();
        }
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append(string);
        stringBuilder6.append(" }");
        return stringBuilder6.toString();
    }
}
