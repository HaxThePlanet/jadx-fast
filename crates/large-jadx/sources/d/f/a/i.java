package d.f.a;

import java.util.Arrays;

/* compiled from: SolverVariable.java */
/* loaded from: classes.dex */
public class i implements Comparable<i> {

    private static int I = 1;
    float[] A;
    i.a B;
    b[] C;
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

    public enum a {

        CONSTANT,
        ERROR,
        SLACK,
        UNKNOWN,
        UNRESTRICTED;
    }
    public i(i.a aVar, String str) {
        super();
        int i2 = 9;
        this.z = new float[i2];
        this.A = new float[i2];
        this.C = new b[16];
        this.B = aVar;
    }

    static void e() {
        i.I++;
    }

    public final void a(b bVar) {
        int i = 0;
        i = 0;
        while (i < this.D) {
            if (this.C[i] == bVar) {
                return;
            }
        }
        if (this.D >= objArr.length) {
            i2 = objArr.length * 2;
            this.C = (b[])Arrays.copyOf(this.C, i2);
        }
        this.C[this.D] = bVar;
        this.D++;
    }

    public int c(i iVar) {
        return this.c - iVar.c;
    }

    public final void f(b bVar) {
        int i = 0;
        i = 0;
        while (i < this.D) {
            if (this.C[i] == bVar) {
            }
        }
    }

    public void i() {
        int i;
        String str = null;
        this.b = str;
        this.B = i.a.UNKNOWN;
        i = 0;
        this.w = i;
        int i2 = -1;
        this.c = i2;
        this.v = i2;
        final float f = 0.0f;
        this.x = f;
        this.y = false;
        this.F = false;
        this.G = i2;
        this.H = f;
        while (i < this.D) {
            this.C[i] = str;
            i = i + 1;
        }
        this.D = i;
        this.E = i;
        this.a = false;
        Arrays.fill(this.A, f);
    }

    public void j(d dVar, float f) {
        boolean f22;
        this.x = f;
        this.y = true;
        f22 = false;
        this.F = f22;
        int i = -1;
        this.G = i;
        this.H = 0.0f;
        this.v = i;
        while (f22 < this.D) {
            this.C[f22].A(dVar, this, f22);
            f22 = f22 + 1;
        }
        this.D = f22;
    }

    public void k(i.a aVar, String str) {
        this.B = aVar;
    }

    public final void m(d dVar, b bVar) {
        int i;
        final boolean z = false;
        i = z;
        while (i < this.D) {
            this.C[i].B(dVar, bVar, z);
            i = i + 1;
        }
        this.D = z;
    }

    @Override // java.lang.Object
    public String toString() {
        String str;
        String str4 = "";
        if (this.b != null) {
            StringBuilder stringBuilder = new StringBuilder();
            str = str4 + this.b;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            str = str4 + this.c;
        }
        return str;
    }

}
