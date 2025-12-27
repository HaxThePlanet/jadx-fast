package d.f.a;

import java.util.Arrays;
import java.util.Comparator;

/* compiled from: PriorityGoalRow.java */
/* loaded from: classes.dex */
public class h extends b {

    private int g = 128;
    private i[] h;
    private i[] i;
    private int j = 0;
    h.b k = new h$b();

    class a implements Comparator<i> {
        a() {
            super();
        }

        public int a(i iVar, i iVar2) {
            return iVar.c - iVar2.c;
        }
    }

    class b {

        i a;
        final /* synthetic */ h b;
        public b(h hVar) {
            this.b = hVar;
            super();
        }

        public boolean a(i iVar, float f) {
            int i;
            boolean z;
            float[] fArr;
            float[] fArr2;
            final float f6 = 0.0001f;
            final int i2 = 9;
            f = 0.0f;
            i = 1;
            i = 0;
            if (this.a.a) {
                while (this.a < i2) {
                    f4 = iVar.A[i] * f;
                    f3 = fArr5[i] + f4;
                    this.a.A[i] = f3;
                    float abs = Math.abs(fArr5[i]);
                    i = i + 1;
                }
                if (i != 0) {
                    this.b.G(this.a);
                }
                return false;
            }
            while (i < i2) {
                float f5 = iVar.A[i];
                i = i + 1;
            }
            return true;
        }

        public void b(i iVar) {
            this.a = iVar;
        }

        public final boolean c() {
            int i = 8;
            i = 8;
            boolean z = false;
            while (i >= 0) {
                float f = this.a.A[i];
                float f2 = 0.0f;
                if (f < f2) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(i iVar) {
            int i = 8;
            float f;
            float f2;
            int cmp;
            i = 8;
            boolean z = false;
            while (i >= 0) {
                f = iVar.A[i];
                f2 = this.a.A[i];
                if (this.a.A != iVar.A) {
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.a.A, 0.0f);
        }

        public String toString() {
            int i = 0;
            String str;
            str = "[ ";
            if (this.a != null) {
                i = 0;
                int i2 = 9;
                while (this.a < 9) {
                    StringBuilder stringBuilder = new StringBuilder();
                    float f = this.a.A[i];
                    String str3 = " ";
                    str = str + f + str3;
                    i = i + 1;
                    i2 = 9;
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            String str4 = "] ";
            str2 = str + str4 + this.a;
            return str2;
        }
    }
    public h(c cVar) {
        super(cVar);
        int i = 128;
        this.h = new i[i];
        this.i = new i[i];
        d.f.a.h.b bVar = new h.b(this, this);
    }

    static /* synthetic */ void E(h hVar, i iVar) {
        hVar.G(iVar);
    }

    private final void F(i iVar) {
        int i2 = 0;
        int length;
        final int i7 = 1;
        i = this.j + i7;
        length = objArr2.length;
        if (this.j + i7 > objArr2.length) {
            Object[] copy = Arrays.copyOf(this.h, objArr2.length * 2);
            this.h = copy;
            this.i = (i[])Arrays.copyOf(copy, copy.length * 2);
        }
        this.h[this.j] = iVar;
        this.j += i7;
        if (copy.length * 2 > i7) {
            if (objArr[i3 - i7].c > iVar.c) {
                i2 = 0;
                while (copy.length * 2 < this.j) {
                    this.i[i2] = this.h[i2];
                    i2 = i2 + 1;
                }
                Arrays.sort(this.i, i2, this.j, new h.a(this));
                while (this.j < this.j) {
                    this.h[i2] = this.i[i2];
                    i2 = i2 + 1;
                }
            }
        }
        iVar.a = true;
        iVar.a(this);
    }

    private final void G(i iVar) {
        int i;
        final boolean z = false;
        i = z;
        while (i < this.j) {
            if (this.h[i] == iVar) {
            }
        }
    }

    @Override // d.f.a.b
    public void B(d dVar, b bVar, boolean z) {
        int i = 0;
        if (bVar.a == null) {
            return;
        }
        i = 0;
        while (i < bVar.e.a()) {
            d.f.a.i iVar = bVar.e.e(i);
            float f2 = bVar.e.h(i);
            this.k.b(iVar);
            f3 = bVar.b * f2;
            this.b += f3;
            i = i + 1;
        }
        G(bVar.a);
    }

    @Override // d.f.a.b
    public i b(d dVar, boolean[] zArr) {
        int dVar2 = 0;
        d.f.a.i iVar;
        boolean z;
        boolean z2;
        d.f.a.i iVar2;
        dVar2 = -1;
        dVar2 = 0;
        while (dVar2 < this.j) {
            iVar = this.h[dVar2];
            dVar2 = dVar2 + 1;
        }
        if (dVar2 == dVar2) {
            return null;
        }
        return this.h[dVar2];
    }

    @Override // d.f.a.b
    public void c(i iVar) {
        this.k.b(iVar);
        this.k.e();
        iVar.A[iVar.w] = 1065353216;
        F(iVar);
    }

    @Override // d.f.a.b
    public void clear() {
        this.j = 0;
        this.b = 0.0f;
    }

    @Override // d.f.a.b
    public boolean isEmpty() {
        boolean z = true;
        int r0 = this.j == 0 ? 1 : 0;
        return (this.j == 0 ? 1 : 0);
    }

    @Override // d.f.a.b
    public String toString() {
        String str;
        int i = 0;
        StringBuilder stringBuilder2 = new StringBuilder();
        String str3 = "";
        String str4 = " goal -> (";
        String str5 = ") : ";
        str = str3 + str4 + this.b + str5;
        i = 0;
        while (this.b < this.j) {
            this.k.b(this.h[i]);
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = " ";
            str = str + this.k + str2;
            i = i + 1;
        }
        return str;
    }
}
