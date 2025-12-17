package d.f.a;

import java.util.Arrays;

/* loaded from: classes.dex */
public class i implements Comparable<d.f.a.i> {

    private static int I = 1;
    float[] A;
    d.f.a.i.a B;
    d.f.a.b[] C;
    int D = 0;
    public int E = 0;
    boolean F = false;
    int G = -1;
    float H = 0f;
    public boolean a;
    private String b;
    public int c = -1;
    int v = -1;
    public int w = 0;
    public float x;
    public boolean y = false;
    float[] z;

    public static enum a {

        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN;
    }
    static {
    }

    public i(d.f.a.i.a i$a, String string2) {
        super();
        int obj5 = -1;
        final int i = 0;
        int i2 = 9;
        this.z = new float[i2];
        this.A = new float[i2];
        this.C = new b[16];
        obj5 = 0;
        this.B = a;
    }

    static void e() {
        i.I = i++;
    }

    @Override // java.lang.Comparable
    public final void a(d.f.a.b b) {
        int i;
        d.f.a.b[] copyOf;
        d.f.a.b bVar;
        int i2;
        i = 0;
        i2 = this.D;
        while (i < i2) {
            i++;
            i2 = this.D;
        }
        copyOf = this.C;
        if (i2 >= copyOf.length) {
            this.C = (b[])Arrays.copyOf(copyOf, length *= 2);
        }
        int i3 = this.D;
        this.C[i3] = b;
        this.D = i3++;
    }

    @Override // java.lang.Comparable
    public int c(d.f.a.i i) {
        return i2 -= obj2;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return c((i)object);
    }

    @Override // java.lang.Comparable
    public final void f(d.f.a.b b) {
        int i;
        d.f.a.b bVar;
        Object obj;
        d.f.a.b obj5;
        final int i2 = this.D;
        i = 0;
        while (i < i2) {
            if (this.C[i] == b) {
            } else {
            }
            i++;
        }
    }

    @Override // java.lang.Comparable
    public void i() {
        int i;
        d.f.a.b[] objArr;
        int i2 = 0;
        this.b = i2;
        this.B = i.a.UNKNOWN;
        int i3 = 0;
        this.w = i3;
        int i4 = -1;
        this.c = i4;
        this.v = i4;
        final int i6 = 0;
        this.x = i6;
        this.y = i3;
        this.F = i3;
        this.G = i4;
        this.H = i6;
        i = i3;
        while (i < this.D) {
            this.C[i] = i2;
            i++;
        }
        this.D = i3;
        this.E = i3;
        this.a = i3;
        Arrays.fill(this.A, i6);
    }

    @Override // java.lang.Comparable
    public void j(d.f.a.d d, float f2) {
        int i;
        d.f.a.b bVar;
        this.x = f2;
        this.y = true;
        int obj5 = 0;
        this.F = obj5;
        int i2 = -1;
        this.G = i2;
        this.H = 0;
        this.v = i2;
        i = obj5;
        while (i < this.D) {
            this.C[i].A(d, this, obj5);
            i++;
        }
        this.D = obj5;
    }

    @Override // java.lang.Comparable
    public void k(d.f.a.i.a i$a, String string2) {
        this.B = a;
    }

    @Override // java.lang.Comparable
    public final void m(d.f.a.d d, d.f.a.b b2) {
        int i;
        d.f.a.b bVar;
        final int i3 = 0;
        i = i3;
        while (i < this.D) {
            this.C[i].B(d, b2, i3);
            i++;
        }
        this.D = i3;
    }

    @Override // java.lang.Comparable
    public String toString() {
        String string;
        String str;
        String str3 = "";
        if (this.b != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str3);
            stringBuilder.append(this.b);
            string = stringBuilder.toString();
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str3);
            stringBuilder2.append(this.c);
            string = stringBuilder2.toString();
        }
        return string;
    }
}
