package d.f.a;

import java.util.Arrays;

/* loaded from: classes.dex */
public class a implements d.f.a.b.a {

    private static float l = 0.001f;
    int a = 0;
    private final d.f.a.b b;
    protected final d.f.a.c c;
    private int d = 8;
    private d.f.a.i e = null;
    private int[] f;
    private int[] g;
    private float[] h;
    private int i = -1;
    private int j = -1;
    private boolean k = false;
    static {
    }

    a(d.f.a.b b, d.f.a.c c2) {
        super();
        final int i = 0;
        int i2 = 8;
        int i4 = 0;
        this.f = new int[i2];
        this.g = new int[i2];
        this.h = new float[i2];
        int i3 = -1;
        this.b = b;
        this.c = c2;
    }

    @Override // d.f.a.b$a
    public int a() {
        return this.a;
    }

    @Override // d.f.a.b$a
    public boolean b(d.f.a.i i) {
        int i3;
        int i2;
        int[] iArr;
        int i4;
        final int i5 = -1;
        final int i6 = 0;
        if (this.i == i5) {
            return i6;
        }
        i2 = i6;
        while (i3 != i5) {
            i3 = this.g[i3];
            i2++;
        }
        return i6;
    }

    @Override // d.f.a.b$a
    public float c(d.f.a.b b, boolean z2) {
        int i;
        d.f.a.i iVar;
        int i2;
        float f = j(b.a);
        i(b.a, z2);
        final d.f.a.b.a obj6 = b.e;
        i = 0;
        while (i < obj6.a()) {
            iVar = obj6.e(i);
            f(iVar, f2 *= f, z2);
            i++;
        }
        return f;
    }

    @Override // d.f.a.b$a
    public final void clear() {
        int i;
        int i3;
        int[] iArr;
        int i2;
        i = this.i;
        final int i4 = 0;
        i3 = i4;
        int i5 = -1;
        while (i != i5) {
            if (i3 < this.a) {
            }
            d.f.a.i iVar = cVar.d[this.f[i]];
            if (iVar != null) {
            }
            i = this.g[i];
            i3++;
            i5 = -1;
            iVar.f(this.b);
        }
        this.i = i5;
        this.j = i5;
        this.k = i4;
        this.a = i4;
    }

    @Override // d.f.a.b$a
    public final void d(d.f.a.i i, float f2) {
        int length3;
        int i5;
        int length5;
        int copyOf;
        int i6;
        int i3;
        int[] i7;
        int length;
        int[] iArr2;
        int i2;
        int[] iArr;
        int z;
        int length4;
        int length2;
        int i4;
        boolean obj10;
        d.f.a.b obj11;
        final int i9 = 1;
        if (Float.compare(f2, i8) == 0) {
            i(i, i9);
        }
        copyOf = 0;
        final int i11 = -1;
        this.i = copyOf;
        this.h[copyOf] = f2;
        this.f[copyOf] = i.c;
        this.g[copyOf] = i11;
        i.E = obj11 += i9;
        i.a(this.b);
        this.a = obj10 += i9;
        obj10 += i9;
        this.j = obj10;
        obj11 = this.f;
        if (this.i == i11 && !this.k && obj10 >= obj11.length) {
            this.i = copyOf;
            this.h[copyOf] = f2;
            this.f[copyOf] = i.c;
            this.g[copyOf] = i11;
            i.E = obj11 += i9;
            i.a(this.b);
            this.a = obj10 += i9;
            if (!this.k) {
                obj10 += i9;
                this.j = obj10;
                obj11 = this.f;
                if (obj10 >= obj11.length) {
                    this.k = i9;
                    this.j = obj10 -= i9;
                }
            }
        }
        i3 = copyOf;
        i2 = i11;
        while (i5 != i11) {
            int[] iArr6 = this.f;
            i4 = i.c;
            if (iArr6[i5] < i4) {
            }
            i5 = this.g[i5];
            i3++;
            i2 = i5;
        }
        length5 = this.j;
        if (this.k) {
            i7 = this.f;
            if (i7[length5] == i11) {
            } else {
                length5 = i7.length;
            }
        } else {
            length5 = i7;
        }
        length = this.f;
        if (length5 >= length.length && this.a < length.length) {
            if (this.a < length.length) {
                length = copyOf;
                length4 = this.f;
                while (length < length4.length) {
                    if (length4[length] == i11) {
                        break;
                    } else {
                    }
                    length++;
                    length4 = this.f;
                }
            }
        }
        iArr2 = this.f;
        if (length5 >= iArr2.length) {
            i12 *= 2;
            this.d = i13;
            this.k = copyOf;
            this.j = length5 + -1;
            this.h = Arrays.copyOf(this.h, i13);
            this.f = Arrays.copyOf(this.f, this.d);
            this.g = Arrays.copyOf(this.g, this.d);
        }
        this.f[length5] = i.c;
        this.h[length5] = f2;
        if (i2 != i11) {
            obj11 = this.g;
            obj11[length5] = obj11[i2];
            obj11[i2] = length5;
        } else {
            this.g[length5] = this.i;
            this.i = length5;
        }
        i.E = obj11 += i9;
        i.a(this.b);
        obj10 += i9;
        this.a = obj10;
        if (!this.k) {
            this.j = obj11 += i9;
        }
        obj11 = this.f;
        if (obj10 >= obj11.length) {
            this.k = i9;
        }
        if (this.j >= obj11.length) {
            this.k = i9;
            this.j = obj10 -= i9;
        }
    }

    @Override // d.f.a.b$a
    public d.f.a.i e(int i) {
        int i3;
        int i4;
        int[] iArr;
        int i2;
        i3 = this.i;
        i4 = 0;
        while (i3 != -1) {
            i3 = this.g[i3];
            i4++;
        }
        return null;
    }

    @Override // d.f.a.b$a
    public void f(d.f.a.i i, float f2, boolean z3) {
        float cmp;
        int i8;
        int[] i10;
        int length3;
        int[] copyOf;
        int i7;
        int i5;
        float[] fArr;
        int i2;
        int i3;
        int z;
        int length;
        int i9;
        int[] length2;
        int i4;
        int i6;
        boolean obj10;
        int[] obj11;
        int obj12;
        cmp = a.l;
        if (Float.compare(f2, i13) > 0 && Float.compare(f2, cmp) < 0) {
            if (Float.compare(f2, cmp) < 0) {
            }
        }
        i5 = 0;
        int i17 = -1;
        final int i18 = 1;
        this.i = i5;
        this.h[i5] = f2;
        this.f[i5] = i.c;
        this.g[i5] = i17;
        i.E = obj11 += i18;
        i.a(this.b);
        this.a = obj10 += i18;
        obj10 += i18;
        this.j = obj10;
        obj11 = this.f;
        if (this.i == i17 && !this.k && obj10 >= obj11.length) {
            this.i = i5;
            this.h[i5] = f2;
            this.f[i5] = i.c;
            this.g[i5] = i17;
            i.E = obj11 += i18;
            i.a(this.b);
            this.a = obj10 += i18;
            if (!this.k) {
                obj10 += i18;
                this.j = obj10;
                obj11 = this.f;
                if (obj10 >= obj11.length) {
                    this.k = i18;
                    this.j = obj10 -= i18;
                }
            }
        }
        i3 = i5;
        i9 = i17;
        while (i8 != i17) {
            int[] iArr4 = this.f;
            i6 = i.c;
            if (iArr4[i8] < i6) {
            }
            i8 = this.g[i8];
            i3++;
            i9 = i8;
        }
        obj12 = this.j;
        if (this.k) {
            i10 = this.f;
            if (i10[obj12] == i17) {
            } else {
                obj12 = i10.length;
            }
        } else {
            obj12 = i10;
        }
        length3 = this.f;
        if (obj12 >= length3.length && this.a < length3.length) {
            if (this.a < length3.length) {
                length3 = i5;
                length = this.f;
                while (length3 < length.length) {
                    if (length[length3] == i17) {
                        break;
                    } else {
                    }
                    length3++;
                    length = this.f;
                }
            }
        }
        copyOf = this.f;
        if (obj12 >= copyOf.length) {
            i11 *= 2;
            this.d = i12;
            this.k = i5;
            this.j = obj12 + -1;
            this.h = Arrays.copyOf(this.h, i12);
            this.f = Arrays.copyOf(this.f, this.d);
            this.g = Arrays.copyOf(this.g, this.d);
        }
        this.f[obj12] = i.c;
        this.h[obj12] = f2;
        if (i9 != i17) {
            obj11 = this.g;
            obj11[obj12] = obj11[i9];
            obj11[i9] = obj12;
        } else {
            this.g[obj12] = this.i;
            this.i = obj12;
        }
        i.E = obj11 += i18;
        i.a(this.b);
        this.a = obj10 += i18;
        if (!this.k) {
            this.j = obj10 += i18;
        }
        obj11 = this.f;
        if (this.j >= obj11.length) {
            this.k = i18;
            this.j = obj10 -= i18;
        }
    }

    @Override // d.f.a.b$a
    public void g() {
        int i3;
        int i2;
        int[] iArr;
        int i;
        int i4;
        int i5;
        i3 = this.i;
        i2 = 0;
        while (i3 != -1) {
            if (i2 < this.a) {
            }
            float[] fArr = this.h;
            fArr[i3] = f *= i5;
            i3 = this.g[i3];
            i2++;
        }
    }

    @Override // d.f.a.b$a
    public float h(int i) {
        int i4;
        int i2;
        int[] iArr;
        int i3;
        i4 = this.i;
        i2 = 0;
        while (i4 != -1) {
            i4 = this.g[i4];
            i2++;
        }
        return 0;
    }

    @Override // d.f.a.b$a
    public final float i(d.f.a.i i, boolean z2) {
        d.f.a.i iVar;
        int i5;
        int i8;
        int i6;
        int i2;
        int i3;
        int i7;
        int i4;
        d.f.a.b obj10;
        if (this.e == i) {
            this.e = 0;
        }
        int i9 = 0;
        final int i11 = -1;
        if (this.i == i11) {
            return i9;
        }
        i6 = 0;
        i2 = i11;
        while (i5 != i11) {
            i6++;
            i2 = i5;
            i5 = i4;
        }
        return i9;
    }

    @Override // d.f.a.b$a
    public final float j(d.f.a.i i) {
        int i5;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        i5 = this.i;
        i2 = 0;
        while (i5 != -1) {
            i5 = this.g[i5];
            i2++;
        }
        return 0;
    }

    @Override // d.f.a.b$a
    public void k(float f) {
        int i3;
        int i;
        int[] iArr;
        int i4;
        int i2;
        i3 = this.i;
        i = 0;
        while (i3 != -1) {
            if (i < this.a) {
            }
            float[] fArr = this.h;
            fArr[i3] = f2 /= f;
            i3 = this.g[i3];
            i++;
        }
    }

    @Override // d.f.a.b$a
    public String toString() {
        int i;
        String string;
        int i4;
        int[] iArr;
        int i2;
        int i3;
        i = this.i;
        string = "";
        i4 = 0;
        while (i != -1) {
            if (i4 < this.a) {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(" -> ");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append(this.h[i]);
            stringBuilder2.append(" : ");
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(stringBuilder2.toString());
            stringBuilder3.append(cVar.d[this.f[i]]);
            string = stringBuilder3.toString();
            i = this.g[i];
            i4++;
        }
        return string;
    }
}
