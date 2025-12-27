package d.f.a;

import java.util.ArrayList;

/* compiled from: ArrayRow.java */
/* loaded from: classes.dex */
public class b implements d.a {

    i a = null;
    float b = 0f;
    boolean c;
    ArrayList<i> d = new ArrayList<>();
    public b.a e;
    boolean f = false;

    public interface a {
        int a();

        boolean b(i iVar);

        float c(b bVar, boolean z);

        void clear();

        void d(i iVar, float f);

        i e(int i);

        void f(i iVar, float f, boolean z);

        void g();

        float h(int i);

        float i(i iVar, boolean z);

        float j(i iVar);

        void k(float f);
    }
    public b() {
        super();
        ArrayList arrayList = new ArrayList();
    }

    private boolean u(i iVar, d dVar) {
        boolean z = true;
        if (iVar.E > 1) {
            int i3 = 0;
        }
        return z;
    }

    private i w(boolean[] zArr, i iVar) {
        int i = 0;
        int i2 = 0;
        int i3;
        int cmp;
        boolean z;
        d.f.a.i.a sLACK2;
        final float f2 = 0.0f;
        i = 0;
        i2 = 0;
        i3 = f2;
        while (i2 < this.e.a()) {
            float f = this.e.h(i2);
            i2 = i2 + 1;
        }
        return i;
    }

    public void A(d dVar, i iVar, boolean z) {
    }

    public void B(d dVar, b bVar, boolean z) {
        this.b += f5;
        if (z) {
            bVar.a.f(this);
        }
        if (d.t && this.a != null) {
            if (this.e.a() == 0) {
                z = true;
                this.f = z;
                dVar.a = z;
            }
        }
    }

    public void C(d dVar, i iVar, boolean z) {
    }

    public void D(d dVar) {
        int i;
        d.f.a.i iVar;
        ArrayList list2;
        boolean z2;
        int i3;
        if (dVar.g.length == 0) {
            return;
        }
        i = 0;
        ArrayList list = 1;
        while (i == 0) {
            while (i < this.e.a()) {
                iVar = this.e.e(i);
                i3 = -1;
                i = i + 1;
            }
            int size = this.d.size();
            iVar = this.e.e(i);
            i3 = -1;
            i = i + 1;
        }
        if (d.t && this.a != null) {
            if (this.e.a() == 0) {
                this.f = true;
                dVar.a = true;
            }
        }
    }

    public void a(d.a aVar) {
        int i = 0;
        float f;
        d.f.a.b.a aVar2;
        boolean z2 = true;
        z = aVar instanceof b;
        if (aVar instanceof b) {
            this.a = null;
            this.e.clear();
            i = 0;
            while (this.e < aVar.e.a()) {
                z2 = true;
                this.e.f(aVar.e.e(i), aVar.e.h(i), z2);
                i = i + 1;
            }
        }
    }

    public i b(d dVar, boolean[] zArr) {
        return w(zArr, null);
    }

    public void c(i iVar) {
        int i = 1148846080;
        i = 1065353216;
        int i2 = 1;
        if (iVar.w != 1) {
            i2 = 2;
            if (iVar.w == 2) {
                i = 1148846080;
            } else {
                i2 = 3;
                if (iVar.w == 3) {
                    i = 1232348160;
                } else {
                    i2 = 4;
                    if (iVar.w == 4) {
                        i = 1315859240;
                    } else {
                        i2 = 5;
                        if (iVar.w == 5) {
                            i = 1399379109;
                        }
                    }
                }
            }
        }
        this.e.d(iVar, i);
    }

    public void clear() {
        this.e.clear();
        this.a = null;
        this.b = 0.0f;
    }

    public b d(d dVar, int i) {
        this.e.d(dVar.o(i, "ep"), 1f);
        this.e.d(dVar.o(i, "em"), -1f);
        return this;
    }

    b e(i iVar, int i) {
        this.e.d(iVar, (float)i);
        return this;
    }

    boolean f(d dVar) {
        boolean z2 = false;
        d.f.a.i iVar = g(dVar);
        final boolean z = true;
        int i2 = iVar == null ? z : 0;
        if (this.e.a() == 0) {
            this.f = z;
        }
        return z2;
    }

    i g(d dVar) {
        int i = 0;
        boolean z;
        boolean z2;
        int i2;
        int i3;
        int cmp;
        d.f.a.i.a aVar;
        i = 0;
        final float f2 = 0.0f;
        while (i2 < this.e.a()) {
            float f = this.e.h(i2);
            d.f.a.i iVar = this.e.e(i2);
            i2 = 1;
            i2 = i2 + 1;
        }
        return i != 0 ? i : i;
    }

    public i getKey() {
        return this.a;
    }

    b h(i iVar, i iVar2, int i, float f, i iVar3, i iVar4, int i2) {
        f = 1f;
        if (iVar2 == iVar3) {
            this.e.d(iVar, f);
            this.e.d(iVar4, f);
            this.e.d(iVar2, -2f);
            return this;
        }
        float f2 = -1f;
        if (f == 1056964608) {
            this.e.d(iVar, f);
            this.e.d(iVar2, f2);
            this.e.d(iVar3, f2);
            this.e.d(iVar4, f);
            if (this.e > 0 || i2 > 0) {
                f6 = (float)(-i + i2);
                this.b = f6;
            }
        } else {
            if (this.e <= 0) {
                this.e.d(iVar, f2);
                this.e.d(iVar2, f);
                f6 = (float)i;
                this.b = f6;
            } else {
                if (this.e >= f) {
                    this.e.d(iVar4, f2);
                    this.e.d(iVar3, f);
                    f6 = (float)-i2;
                    this.b = f6;
                } else {
                    f3 = f - f;
                    f5 = f3 * f;
                    this.e.d(iVar, f5);
                    this.e.d(iVar2, f3 * f2);
                    f2 = f2 * f;
                    this.e.d(iVar3, f2);
                    f = f * f;
                    this.e.d(iVar4, f);
                    if (this.e > 0 || i2 > 0) {
                        f7 = (float)i2 * f;
                        f6 = (float)-i * f3 + f7;
                        this.b = f6;
                    }
                }
            }
        }
        return this;
    }

    b i(i iVar, int i) {
        this.a = iVar;
        final float f = (float)i;
        iVar.x = f;
        this.b = f;
        this.f = true;
        return this;
    }

    public boolean isEmpty() {
        boolean z = true;
        float f = 0;
        if (this.a == null) {
            f = 0.0f;
            if (this.b == 0.0f) {
                int r0 = this.e.a() == 0 ? 1 : 0;
            }
        }
        return (this.e.a() == 0 ? 1 : 0);
    }

    b j(i iVar, i iVar2, float f) {
        this.e.d(iVar, -1f);
        this.e.d(iVar2, f);
        return this;
    }

    public b k(i iVar, i iVar2, i iVar3, i iVar4, float f) {
        this.e.d(iVar, -1f);
        this.e.d(iVar2, 1f);
        this.e.d(iVar3, f);
        this.e.d(iVar4, -f);
        return this;
    }

    public b l(float f, float f2, float f3, i iVar, i iVar2, i iVar3, i iVar4) {
        int cmp2;
        float f5 = 0.0f;
        this.b = f5;
        final float f6 = -1f;
        final float f7 = 1f;
        if (f2 != 0.0f) {
            if (f == f3) {
                this.e.d(iVar, f7);
                this.e.d(iVar2, f6);
                this.e.d(iVar4, f7);
                this.e.d(iVar3, f6);
            } else {
                if (this.e == 0.0f) {
                    this.e.d(iVar, f7);
                    this.e.d(iVar2, f6);
                } else {
                    if (f3 == 0.0f) {
                        this.e.d(iVar3, f7);
                        this.e.d(iVar4, f6);
                    } else {
                        f4 = f3 / f2;
                        float f9 = (f / f2) / f4;
                        this.e.d(iVar, f7);
                        this.e.d(iVar2, f6);
                        this.e.d(iVar4, f9);
                        i = -f9;
                        this.e.d(iVar3, i);
                    }
                }
            }
        }
        return this;
    }

    public b m(i iVar, int i) {
        if (i < 0) {
            this.b = (float)-i;
            float f = 1f;
            this.e.d(iVar, f);
        } else {
            this.b = (float)i;
            f = -1f;
            this.e.d(iVar, f);
        }
        return this;
    }

    public b n(i iVar, i iVar2, int i) {
        int i2;
        i = 0;
        if (i != 0 && i < 0) {
            i2 = -i;
            i = 1;
            f = (float)i2;
            this.b = f;
        }
        float f3 = -1f;
        final float f2 = 1f;
        if (i == 0) {
            this.e.d(iVar, f3);
            this.e.d(iVar2, f2);
        } else {
            this.e.d(iVar, f2);
            this.e.d(iVar2, f3);
        }
        return this;
    }

    public b o(i iVar, i iVar2, i iVar3, int i) {
        int i2;
        i = 0;
        if (i != 0 && i < 0) {
            i2 = -i;
            i = 1;
            f = (float)i2;
            this.b = f;
        }
        float f3 = -1f;
        final float f2 = 1f;
        if (i == 0) {
            this.e.d(iVar, f3);
            this.e.d(iVar2, f2);
            this.e.d(iVar3, f2);
        } else {
            this.e.d(iVar, f2);
            this.e.d(iVar2, f3);
            this.e.d(iVar3, f3);
        }
        return this;
    }

    public b p(i iVar, i iVar2, i iVar3, int i) {
        int i2;
        i = 0;
        if (i != 0 && i < 0) {
            i2 = -i;
            i = 1;
            f = (float)i2;
            this.b = f;
        }
        float f3 = -1f;
        final float f2 = 1f;
        if (i == 0) {
            this.e.d(iVar, f3);
            this.e.d(iVar2, f2);
            this.e.d(iVar3, f3);
        } else {
            this.e.d(iVar, f2);
            this.e.d(iVar2, f3);
            this.e.d(iVar3, f2);
        }
        return this;
    }

    public b q(i iVar, i iVar2, i iVar3, i iVar4, float f) {
        f = 0.5f;
        this.e.d(iVar3, f);
        this.e.d(iVar4, f);
        final float f2 = -0.5f;
        this.e.d(iVar, f2);
        this.e.d(iVar2, f2);
        this.b = -f;
        return this;
    }

    void r() {
        if (this.b < 0) {
            this.b *= f3;
            this.e.g();
        }
    }

    boolean s() {
        boolean z = true;
        d.f.a.i.a uNRESTRICTED2 = null;
        float f = 0;
        if (this.a != null) {
            if (iVar.B != i.a.UNRESTRICTED) {
                f = 0.0f;
                int r0 = this.b >= 0.0f ? 1 : 0;
            }
        }
        return (this.b >= 0.0f ? 1 : 0);
    }

    boolean t(i iVar) {
        return this.e.b(iVar);
    }

    @Override // java.lang.Object
    public String toString() {
        return z();
    }

    public i v(i iVar) {
        return w(null, iVar);
    }

    void x(i iVar) {
        final float f3 = -1f;
        if (this.a != null) {
            this.e.d(this.a, f3);
            int i = -1;
            this.a.v = i;
            d.f.a.i iVar2 = null;
            this.a = iVar2;
        }
        float f2 = (this.e.i(iVar, true)) * f3;
        this.a = iVar;
        if (this.e == 1065353216) {
            return;
        }
        this.b /= f2;
        this.e.k(f2);
    }

    public void y() {
        this.a = null;
        this.e.clear();
        this.b = 0.0f;
        this.f = false;
    }

    String z() {
        String str;
        String str2;
        int i;
        StringBuilder stringBuilder;
        d.f.a.i iVar;
        float f;
        int cmp;
        float f2;
        String str10 = "";
        if (this.a == null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            str3 = "0";
            str = str10 + str3;
        } else {
            StringBuilder stringBuilder4 = new StringBuilder();
            str = str10 + this.a;
        }
        StringBuilder stringBuilder5 = new StringBuilder();
        String str4 = " = ";
        str2 = str + str4;
        final float f5 = 0.0f;
        i = 0;
        i = 1;
        if (this.b != 0.0f) {
            StringBuilder stringBuilder7 = new StringBuilder();
            str2 = str2 + this.b;
        } else {
        }
        while (i < this.e.a()) {
            iVar = this.e.e(i);
            i = i + 1;
        }
        if (this.b == 0) {
            StringBuilder stringBuilder6 = new StringBuilder();
            String str5 = "0.0";
            str2 = str2 + str5;
        }
        return str2;
    }

    public b(c cVar) {
        super();
        ArrayList arrayList = new ArrayList();
        this.e = new a(this, cVar);
    }
}
