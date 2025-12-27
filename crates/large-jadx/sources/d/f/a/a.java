package d.f.a;

import java.util.Arrays;

/* compiled from: ArrayLinkedVariables.java */
/* loaded from: classes.dex */
public class a implements b.a {

    private static float l = 0.001f;
    int a = 0;
    private final b b;
    protected final c c;
    private int d = 8;
    private i e = null;
    private int[] f;
    private int[] g;
    private float[] h;
    private int i = -1;
    private int j = -1;
    private boolean k = false;
    a(b bVar, c cVar) {
        super();
        int i2 = 8;
        this.f = new int[i2];
        this.g = new int[i2];
        this.h = new float[i2];
        this.b = bVar;
        this.c = cVar;
    }

    public int a() {
        return this.a;
    }

    public boolean b(i iVar) {
        int i;
        int i2;
        int[] iArr;
        final int i4 = -1;
        i2 = 0;
        if (this.i == i4) {
            return false;
        }
        while (this.i != i4) {
            if (this.f[i] == iVar.c) {
                return true;
            }
        }
        return false;
    }

    public float c(b bVar, boolean z) {
        int i = 0;
        float f2 = j(bVar.a);
        i(bVar.a, z);
        i = 0;
        while (i < bVar.e.a()) {
            d.f.a.i iVar = bVar.e.e(i);
            f = bVar.e.j(iVar) * f2;
            f(iVar, f, z);
            i = i + 1;
        }
        return f2;
    }

    public final void clear() {
        int i;
        int i2;
        int i3;
        final boolean z = false;
        i2 = z;
        int i4 = -1;
        while (this.i != i4) {
            if (i2 >= this.a) {
                this.i = i4;
                this.j = i4;
                this.k = z;
                this.a = z;
                return;
            }
        }
        this.i = i4;
        this.j = i4;
        this.k = z;
        this.a = z;
    }

    public final void d(i iVar, float f) {
        int i;
        int length2;
        int[] iArr4;
        int length4;
        final boolean z3 = true;
        if (f == 0) {
            i(iVar, z3);
            return;
        }
        length2 = 0;
        i = -1;
        if (this.i == i) {
            this.i = length2;
            this.h[length2] = f;
            this.f[length2] = iVar.c;
            this.g[length2] = i;
            iVar.E += z3;
            iVar.a(this.b);
            this.a += z3;
            if (!this.k) {
                this.j += z3;
                length = iArr13.length;
                if (this.a + z3 >= iArr13.length) {
                    this.k = z3;
                    this.j = iArr13.length - z3;
                }
            }
            return;
        }
        while (this.h != i) {
            if (iArr9[i] == iVar.c) {
                this.h[i] = f;
                return;
            }
        }
        if (!this.k) {
        } else {
            if (iArr[length2] != i) {
                length2 = iArr.length;
            }
        }
        length3 = iArr2.length;
        if (iArr13.length >= iArr2.length && this.a < iArr2.length) {
            length4 = iArr10.length;
            for (int length3 : iArr10) {
                if (length3 == i) {
                    break;
                }
            }
        }
        if (iArr13.length >= iArr3.length) {
            length2 = iArr3.length;
            this.d *= 2;
            this.k = false;
            this.j = length2 - 1;
            this.h = Arrays.copyOf(this.h, i9);
            this.f = Arrays.copyOf(this.f, this.d);
            this.g = Arrays.copyOf(this.g, this.d);
        }
        this.f[length2] = iVar.c;
        this.h[length2] = f;
        if (i != i) {
            this.g[length2] = iArr5[i];
            this.g[i] = length2;
        } else {
            this.g[length2] = this.i;
            this.i = length2;
        }
        iVar.E += z3;
        iVar.a(this.b);
        this.a += z3;
        if (!this.k) {
            this.j += z3;
        }
        if (this.a >= iArr14.length) {
            this.k = z3;
        }
        if (this.j >= iArr14.length) {
            this.k = z3;
            i5 = iArr14.length - z3;
            this.j = i5;
        }
    }

    public i e(int i) {
        int i2;
        int i3 = 0;
        i3 = 0;
        int i4 = -1;
        while (this.i != -1) {
            if (i3 == i) {
                return this.c.d[this.f[i2]];
            }
        }
        return null;
    }

    public void f(i iVar, float f, boolean z) {
        int i;
        int length;
        int i3;
        float f3;
        int[] length3;
        int[] iArr4;
        f = a.l;
        int i11 = -f;
        if (f > i11) {
            if (f < a.l) {
                return;
            }
        }
        length = 0;
        i = -1;
        final int i16 = 1;
        if (this.i == i) {
            this.i = length;
            this.h[length] = f;
            this.f[length] = iVar.c;
            this.g[length] = i;
            iVar.E += i16;
            iVar.a(this.b);
            this.a += i16;
            if (!this.k) {
                this.j += i16;
                length4 = iArr14.length;
                if (this.a >= iArr14.length) {
                    this.k = true;
                    this.j = iArr14.length - i16;
                }
            }
            return;
        }
        while (a.l != i) {
            if (iArr9[i] == iVar.c) {
                f3 = fArr[i] + f;
                f4 = a.l;
                int i17 = -f4;
                float f6 = 0.0f;
            }
        }
        if (!this.k) {
        } else {
            if (iArr[length] != i) {
                length = iArr.length;
            }
        }
        length2 = iArr2.length;
        if (this.h >= iArr2.length && this.a < iArr2.length) {
            length3 = iArr8.length;
            for (int length2 : iArr8) {
                if (length2 == i) {
                    break;
                }
            }
        }
        if (this.h >= copy.length) {
            length = copy.length;
            this.d *= 2;
            this.k = false;
            this.j = length - 1;
            this.h = Arrays.copyOf(this.h, i10);
            this.f = Arrays.copyOf(this.f, this.d);
            this.g = Arrays.copyOf(this.g, this.d);
        }
        this.f[length] = iVar.c;
        this.h[length] = f;
        if (i != i) {
            this.g[length] = iArr3[i];
            this.g[i] = length;
        } else {
            this.g[length] = this.i;
            this.i = length;
        }
        iVar.E += i16;
        iVar.a(this.b);
        this.a += i16;
        if (!this.k) {
            this.j += i16;
        }
        if (this.j >= iArr10.length) {
            this.k = true;
            i7 = iArr10.length - i16;
            this.j = i7;
        }
    }

    public void g() {
        int i;
        int i2 = 0;
        i2 = 0;
        int i3 = -1;
        while (this.i != -1) {
        }
    }

    public float h(int i) {
        int i2;
        int i3 = 0;
        i3 = 0;
        int i4 = -1;
        while (this.i != -1) {
            if (i3 == i) {
                return this.h[i2];
            }
        }
        return 0;
    }

    public final float i(i iVar, boolean z) {
        int i;
        int i3 = 0;
        int i4;
        if (this.e == iVar) {
            d.f.a.i iVar2 = null;
            this.e = iVar2;
        }
        float f = 0.0f;
        i = -1;
        if (this.i == i) {
            return 0.0f;
        }
        i3 = 0;
        while (this.i != i) {
            if (this.f[i] == iVar.c) {
            }
        }
        return 0.0f;
    }

    public final float j(i iVar) {
        int i;
        int i2 = 0;
        i2 = 0;
        int i3 = -1;
        while (this.i != -1) {
            if (this.f[i] == iVar.c) {
                return this.h[i];
            }
        }
        return 0;
    }

    public void k(float f) {
        int i;
        int i2 = 0;
        i2 = 0;
        int i3 = -1;
        while (this.i != -1) {
        }
    }

    @Override // java.lang.Object
    public String toString() {
        int i;
        String str;
        int i2 = 0;
        str = "";
        i2 = 0;
        int i3 = -1;
        while (this.i != -1) {
        }
        return str;
    }

}
