package d.f.a;

import java.util.Arrays;

/* compiled from: SolverVariableValues.java */
/* loaded from: classes.dex */
public class j implements b.a {

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
    private final b k;
    protected final c l;
    j(b bVar, c cVar) {
        super();
        int i = 16;
        this.c = new int[i];
        this.d = new int[i];
        this.e = new int[i];
        this.f = new float[i];
        this.g = new int[i];
        this.h = new int[i];
        this.k = bVar;
        this.l = cVar;
        clear();
    }

    private void l(i iVar, int i) {
        i3 = iVar.c % this.b;
        final int i5 = -1;
        if (iArr[i3] == i5) {
            this.c[i3] = i;
        } else {
            while (iArr3[i] != i5) {
                i = iArr3[i];
            }
            this.d[i] = i;
        }
        this.d[i] = i5;
    }

    private void m(int i, i iVar, float f) {
        this.e[i] = iVar.c;
        this.f[i] = f;
        int i2 = -1;
        this.g[i] = i2;
        this.h[i] = i2;
        iVar.a(this.k);
        iVar.E++;
        this.i++;
    }

    private int n() {
        int i = 0;
        i = 0;
        int i3 = -1;
        while (i < this.a) {
            if (this.e[i] == i3) {
                return i;
            }
        }
        return i3;
    }

    private void o() {
        int i;
        this.e = Arrays.copyOf(this.e, i4);
        this.f = Arrays.copyOf(this.f, i4);
        this.g = Arrays.copyOf(this.g, i4);
        this.h = Arrays.copyOf(this.h, i4);
        this.d = Arrays.copyOf(this.d, i4);
        while (this.d < this.a) {
            int i2 = -1;
            this.e[i] = i2;
            this.d[i] = i2;
            i = i + 1;
        }
        this.a *= 2;
    }

    private void q(int i, i iVar, float f) {
        final int i5 = n();
        m(i5, iVar, f);
        int i4 = -1;
        if (i != i4) {
            this.g[i5] = i;
            this.h[i5] = iArr4[i];
            this.h[i] = i5;
        } else {
            this.g[i5] = i4;
            if (this.i > 0) {
                this.h[i5] = this.j;
                this.j = i5;
            } else {
                this.h[i5] = i4;
            }
        }
        if (iArr2[i5] != i4) {
            this.g[iArr2[i5]] = i5;
        }
        l(iVar, i5);
    }

    private void r(i iVar) {
        int i3;
        int i4;
        i = i8 % this.b;
        i3 = iArr[i];
        final int i7 = -1;
        if (i3 == i7) {
            return;
        }
        if (this.e[i3] == iVar.c) {
            this.c[i] = iArr2[i3];
            this.d[i3] = i7;
        } else {
            while (iArr3[i3] != i7) {
            }
            int i6 = iArr3[i3];
            if (this.e != i7) {
                if (this.e[i6] == iVar.c) {
                    this.d[i3] = iArr3[i6];
                    this.d[i6] = i7;
                }
            }
        }
    }

    public int a() {
        return this.i;
    }

    public boolean b(i iVar) {
        boolean z = true;
        iVar = p(iVar) != -1 ? 1 : 0;
        return (p(iVar) != -1 ? 1 : 0);
    }

    public float c(b bVar, boolean z) {
        int i = 0;
        int[] iArr;
        int i2;
        int i3 = -1;
        float f = j(bVar.a);
        i(bVar.a, z);
        i = 0;
        while (aVar.j < aVar.a()) {
            i3 = -1;
            i = i + 1;
        }
        return f;
    }

    public void clear() {
        int i;
        d.f.a.i iVar;
        d.f.a.b bVar;
        i = 0;
        while (i < this.i) {
            iVar = e(i);
            i = i + 1;
        }
        iVar = -1;
        while (this.i < this.a) {
            this.e[i] = iVar;
            this.d[i] = iVar;
            i = i + 1;
            iVar = -1;
        }
        while (this.i < this.b) {
            this.c[i] = iVar;
            i = i + 1;
        }
        this.i = i;
        this.j = iVar;
    }

    public void d(i iVar, float f) {
        int i2 = 0;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        f = j.m;
        int i8 = -f;
        boolean z = true;
        if (f > i8) {
            if (f < j.m) {
                i(iVar, z);
                return;
            }
        }
        i2 = 0;
        if (this.i != 0) {
            int i = p(iVar);
            i3 = -1;
            if (i == i3) {
                if (this.i + z >= this.a) {
                    o();
                }
                while (i2 < this.i) {
                    if (this.h[i3] == i3) {
                        break;
                    }
                }
                q(i3, iVar, f);
            } else {
                this.f[i] = f;
            }
        } else {
            m(i2, iVar, f);
            l(iVar, i2);
            this.j = i2;
        }
    }

    public i e(int i) {
        int i2;
        int i3 = 0;
        int i4 = -1;
        int[] iArr;
        final int i7 = 0;
        if (this.i == 0) {
            return null;
        }
        i3 = 0;
        while (i3 < this.i) {
            i4 = -1;
            if (this.h[i2] == i4) {
                break;
            }
        }
        return i7;
    }

    public void f(i iVar, float f, boolean z) {
        f = j.m;
        int i3 = -f;
        if (f > i3) {
            if (f < j.m) {
                return;
            }
        }
        int i2 = p(iVar);
        if (i2 == -1) {
            d(iVar, f);
        } else {
            this.f[i2] = fArr[i2] + f;
            float f6 = fArr[i2];
            f3 = j.m;
            i = -f3;
            if (f6 > i) {
                float f7 = fArr[i2];
                if (f7 < j.m) {
                    this.f[i2] = 0.0f;
                    i(iVar, z);
                }
            }
        }
    }

    public void g() {
        int i;
        int i2 = 0;
        int i3 = -1;
        float f;
        float f2 = -1082130432;
        i2 = 0;
        while (i2 < this.i) {
            f2 = -1f;
            f = fArr[i] * f2;
            this.f[i] = f;
            i3 = -1;
            if (this.h[i] == -1) {
                break;
            }
        }
    }

    public float h(int i) {
        int i2;
        int i3 = 0;
        int i4 = -1;
        i3 = 0;
        while (i3 < this.i) {
            i4 = -1;
            if (this.h[i2] == -1) {
                break;
            }
        }
        return 0;
    }

    public float i(i iVar, boolean z) {
        int i = p(iVar);
        int i2 = -1;
        if (i == i2) {
            return 0;
        }
        r(iVar);
        if (this.j == i) {
            this.j = this.h[i];
        }
        this.e[i] = i2;
        if (iArr3[i] != i2) {
            this.h[iArr3[i]] = iArr5[i];
        }
        if (iArr4[i] != i2) {
            this.g[iArr4[i]] = iArr3[i];
        }
        this.i--;
        iVar.E--;
        if (z) {
            iVar.f(this.k);
        }
        return this.f[i];
    }

    public float j(i iVar) {
        int i2 = p(iVar);
        if (i2 != -1) {
            return this.f[i2];
        }
        return 0;
    }

    public void k(float f) {
        int i;
        int i2 = 0;
        int i3 = -1;
        float f2;
        i2 = 0;
        while (i2 < this.i) {
            f2 = fArr[i] / f;
            this.f[i] = f2;
            i3 = -1;
            if (this.h[i] == -1) {
                break;
            }
        }
    }

    public int p(i iVar) {
        int i;
        int i6;
        final int i10 = -1;
        return i10;
    }

    @Override // java.lang.Object
    public String toString() {
        String str;
        String str2;
        String str3;
        int i = 0;
        d.f.a.i iVar;
        int i2;
        String str4;
        int i3;
        int i4;
        int i5;
        StringBuilder stringBuilder3 = new StringBuilder();
        int i6 = hashCode();
        String str15 = " { ";
        str = i6 + str15;
        i = 0;
        while (i < this.i) {
            iVar = e(i);
            i = i + 1;
        }
        StringBuilder stringBuilder4 = new StringBuilder();
        String str13 = " }";
        str14 = str + str13;
        return str14;
    }

}
