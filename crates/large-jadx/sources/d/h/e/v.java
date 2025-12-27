package d.h.e;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.animation.AnimationUtils;
import androidx.core.os.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: ValueAnimator.java */
/* loaded from: classes.dex */
public class v extends c implements b.b {

    private static float U = 1f;
    private static final m V = new a();
    private boolean A;
    private float B = 0f;
    private float C;
    private long D = -1;
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    boolean H = false;
    private boolean I = false;
    private long J = 300;
    private long K = 0;
    private int L = 0;
    private int M = 1;
    private boolean N = true;
    private boolean O = false;
    private m P;
    s[] Q;
    HashMap<String, s> R;
    private float S = -1f;
    String T = null;
    long w = -1;
    float x = -1f;
    private long y;
    private boolean z = false;

    public v() {
        super();
        this.P = v.V;
    }

    private float A(float f) {
        float min;
        min = 0.0f;
        if (f < 0.0f) {
        } else {
            int cmp = -1;
            if (this.L != -1) {
                min = (float)(i + 1);
                min = Math.min(f, min);
            }
        }
        return min;
    }

    private void C() {
        boolean z = true;
        boolean z2;
        int i;
        Object item;
        boolean z3;
        if (this.I) {
            return;
        }
        N();
        z = true;
        this.I = z;
        z = false;
        this.v = z;
        if (this.F || this.E) {
            if (this.a == null) {
            }
        }
        if (this.I && !this.E) {
            L();
        }
        this.E = z;
        this.F = z;
        this.G = z;
        long l = -1L;
        this.D = l;
        this.w = l;
        if (this.I && this.a != null) {
            Object clone = this.a.clone();
            while (i < clone.size()) {
                (c.a)clone.get(i).b(this, this.A);
                i = i + 1;
            }
        }
        this.A = z;
        i.b();
    }

    private int D(float f) {
        double floored;
        float f2 = A(f);
        double d = (double)f2;
        floored = Math.floor(d);
        if (d == floored) {
            float f3 = 0.0f;
            if (f2 > 0.0f) {
                floored = floored - 1d;
            }
        }
        return (int)floored;
    }

    private float E(float f, boolean z) {
        float f2;
        float f4 = A(f);
        final int i = D(f4);
        f2 = f4 - (float)i;
        if (V(i, z)) {
            f2 = 1f - (f4 - (float)i);
        }
        return f2;
    }

    static float F() {
        return v.U;
    }

    private long H() {
        return (long)(float)this.J * O();
    }

    private boolean K() {
        boolean z = true;
        int r0 = this.D >= 0 ? 1 : 0;
        return (this.D >= 0 ? 1 : 0);
    }

    private void L() {
        int i = 0;
        Object item;
        boolean z2;
        if (this.a != null && !this.G) {
            Object clone = this.a.clone();
            i = 0;
            while (i < clone.size()) {
                (c.a)clone.get(i).f(this, this.A);
                i = i + 1;
            }
        }
        this.G = true;
    }

    public static v M(float... fArr) {
        final d.h.e.v vVar = new v();
        vVar.S(fArr);
        return vVar;
    }

    private void N() {
        if (!this.N) {
            return;
        }
        c.o(this);
    }

    private float O() {
        float f;
        if (this.S < 0) {
            f = v.U;
        }
        return f;
    }

    private boolean V(int i, boolean z) {
        boolean z3 = false;
        if (i > 0) {
            int i4 = 2;
            if (this.M == i4) {
                i5 = i2 + 1;
                if (i < i2 + 1 || this.L == -1) {
                    int i6 = 0;
                    int i3 = 1;
                    if (z) {
                        if (i % i4 == 0) {
                        }
                        return z;
                    }
                    if (i % i4 != 0) {
                    }
                }
                return z3;
            }
        }
        return z;
    }

    private void W(boolean z) throws AndroidRuntimeException {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        } else {
            this.A = z;
            final int i3 = 1;
            this.N = this.O ^ i3;
            float f3 = 0.0f;
            final float f4 = -1f;
            if (z) {
                if (this.x != f4) {
                    if (this.x != 0.0f) {
                        int i = -1;
                        if (this.L == -1) {
                            f = (float)(double)f - Math.floor((double)f);
                            this.x = 1f - f;
                        } else {
                            this.x = (float)(i4 + i3) - f;
                        }
                    }
                }
            }
            this.F = true;
            boolean z3 = false;
            this.v = z3;
            this.E = z3;
            this.I = z3;
            long l = -1L;
            this.D = l;
            this.w = l;
            long l3 = 0L;
            if (this.K != l3) {
                if (this.x >= 0.0f || this.A) {
                    X();
                    if (this.x == f4) {
                        Q(l3);
                    } else {
                        P(this.x);
                    }
                }
            }
            x();
            return;
        }
    }

    private void X() {
        i.a(G());
        this.I = false;
        J();
        this.E = true;
        final float f2 = 0.0f;
        if (this.x >= 0.0f) {
            this.B = this.x;
        } else {
            this.B = 0.0f;
        }
        if (this.a != null) {
            L();
        }
    }

    private void x() {
        if (!this.N) {
            return;
        }
        c.b(this);
    }

    @Override // d.h.e.c
    public v B() {
        boolean z = false;
        HashMap hashMap;
        HashMap map;
        String str;
        final d.h.e.c cVar = super.d();
        if (this.c != null) {
            cVar.c = new ArrayList(this.c);
        }
        cVar.x = -1f;
        z = false;
        cVar.A = z;
        cVar.H = z;
        cVar.F = z;
        cVar.E = z;
        cVar.v = z;
        cVar.z = z;
        cVar.G = z;
        long l = -1L;
        cVar.w = l;
        cVar.I = z;
        cVar.y = l;
        cVar.D = l;
        float f = 0.0f;
        cVar.B = f;
        cVar.C = f;
        cVar.N = true;
        cVar.O = z;
        if (this.Q != null) {
            length = objArr.length;
            cVar.Q = new s[length];
            cVar.R = new HashMap(length);
            while (this.c < length) {
                Object obj = objArr[z].b();
                cVar.Q[z] = obj;
                cVar.R.put(obj.g(), obj);
                z = z + 1;
            }
        }
        return cVar;
    }

    @Override // d.h.e.c
    public String G() {
        String str;
        if (this.T == null) {
            str = "animator";
        }
        return str;
    }

    @Override // d.h.e.c
    public s[] I() {
        return this.Q;
    }

    @Override // d.h.e.c
    void J() {
        int i = 0;
        d.h.e.s sVar;
        if (!this.H) {
            i = 0;
            while (i < this.Q.length) {
                this.Q[i].h();
                i = i + 1;
            }
            boolean z = true;
            this.H = z;
        }
    }

    @Override // d.h.e.c
    public void P(float f) {
        J();
        float f4 = A(f);
        if (K()) {
            l = (long)(float)H() * f4;
            l2 = AnimationUtils.currentAnimationTimeMillis() - l;
            this.w = l2;
        } else {
            this.x = f4;
        }
        this.B = f4;
        z(E(f4, this.A));
    }

    @Override // d.h.e.c
    public void Q(long j) {
        float f = 1065353216;
        if (this.J > 0) {
            f2 = (float)l;
            f = (float)j / f2;
        } else {
            int i2 = 1065353216;
        }
        P(f);
    }

    @Override // d.h.e.c
    public v R(long j) {
        if (j < 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Animators cannot have negative duration: ";
            j = str + j;
            throw new IllegalArgumentException(j);
        } else {
            this.J = j;
            return this;
        }
    }

    @Override // d.h.e.c
    public void S(float... fArr) {
        d.h.e.s[] arr;
        String str;
        d.h.e.s sVar;
        if (fArr != null) {
            if (fArr.length != 0) {
                int i = 0;
                if (this.Q != null) {
                    if (objArr.length == 0) {
                        arr = new s[1];
                        str = "";
                        U(s.k(str, fArr));
                    } else {
                        objArr[i].o(fArr);
                    }
                }
                this.H = false;
            }
        }
    }

    @Override // d.h.e.c
    public void T(int... iArr) {
        d.h.e.s[] arr;
        String str;
        d.h.e.s sVar;
        if (iArr != null) {
            if (iArr.length != 0) {
                int i = 0;
                if (this.Q != null) {
                    if (objArr.length == 0) {
                        arr = new s[1];
                        str = "";
                        U(s.m(str, iArr));
                    } else {
                        objArr[i].p(iArr);
                    }
                }
                this.H = false;
            }
        }
    }

    @Override // d.h.e.c
    public void U(s... sVarArr) {
        int i;
        final int length = sVarArr.length;
        this.Q = sVarArr;
        this.R = new HashMap(length);
        boolean z = false;
        i = z;
        for (d.h.e.s sVar : sVarArr) {
            this.R.put(sVar.g(), sVar);
        }
        this.H = z;
    }

    @Override // d.h.e.c
    public final boolean a(long j) {
        long j2;
        float f;
        boolean z3 = false;
        final long l12 = 0L;
        if (this.w < l12 && this.A) {
            j2 = j;
            this.w = j2;
        }
        z3 = false;
        if (this.v) {
            this.y = j;
            N();
            return false;
        }
        if (this.z) {
            this.z = z3;
            if (this.y > l12) {
                l = j - l;
                this.w += l;
            }
        }
        float f10 = -1f;
        if (!this.E) {
            if (this.w > j) {
                if (this.x == f10) {
                    return false;
                }
            }
            boolean z2 = true;
            this.E = z2;
            X();
        }
        if (this.D < l12 && this.x >= 0.0f) {
            this.w = j - (long)(float)H() * this.x;
            this.x = f10;
        }
        this.D = j;
        boolean z6 = y(Math.max(j, this.w));
        if (z6) {
            C();
        }
        return this.y(Math.max(j, r10, this.w, 0.0f), r10);
    }

    @Override // d.h.e.c
    public void cancel() throws AndroidRuntimeException {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        } else {
            if (this.I) {
                return;
            }
            if (this.F || this.E) {
                if (this.a != null && !this.E) {
                    L();
                    Iterator it = (ArrayList)this.a.clone().iterator();
                    while (it.hasNext()) {
                        (c.a)it.next().c(this);
                    }
                }
            }
            C();
            return;
        }
    }

    @Override // d.h.e.c
    public void e() throws AndroidRuntimeException {
        int i = 1065353216;
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        } else {
            if (!this.E) {
                X();
                boolean z = true;
                this.F = z;
            } else {
                if (!this.H) {
                    J();
                }
            }
            int r0 = V(this.L, this.A) ? 0 : 1065353216;
            z((V(this.L, this.A) ? 0 : 1065353216));
            C();
            return;
        }
    }

    @Override // d.h.e.c
    public long f() {
        return this.J;
    }

    @Override // d.h.e.c
    public long g() {
        return this.K;
    }

    @Override // d.h.e.c
    public long h() {
        if (this.L == -1) {
            return -1;
        }
        return this.K + (this.J * (long)(i + 1));
    }

    @Override // d.h.e.c
    boolean j() {
        return this.H;
    }

    @Override // d.h.e.c
    public boolean k() {
        return this.E;
    }

    @Override // d.h.e.c
    public boolean l() {
        return this.F;
    }

    @Override // d.h.e.c
    public void m() {
        super.m();
        if (!this.v && this.v) {
            this.y = -1L;
            boolean z = false;
            this.z = z;
        }
    }

    @Override // d.h.e.c
    boolean n(long j) {
        if (this.N) {
            return false;
        }
        return a(j);
    }

    @Override // d.h.e.c
    public void r() {
        final boolean z5 = true;
        if (K()) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            l2 = currentAnimationTimeMillis - this.w;
            l3 = H() - l2;
            l = currentAnimationTimeMillis - l3;
            this.w = l;
            this.A ^= z5;
        } else {
            if (this.F) {
                this.A ^= z5;
                e();
            } else {
                W(z5);
            }
        }
    }

    @Override // d.h.e.c
    public void t(m mVar) {
        if (mVar != null) {
            this.P = mVar;
        } else {
            this.P = new q();
        }
    }

    @Override // d.h.e.c
    public String toString() {
        String str;
        int i = 0;
        StringBuilder stringBuilder2 = new StringBuilder();
        String str3 = "ValueAnimator@";
        String str4 = Integer.toHexString(hashCode());
        str = str3 + str4;
        if (this.Q != null) {
            i = 0;
            length = this.Q.length;
            while (this.Q < this.Q.length) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "\n    ";
                String sVar2 = this.Q[i].toString();
                str = str + str2 + sVar2;
                i = i + 1;
                length = this.Q.length;
            }
        }
        return str;
    }

    @Override // d.h.e.c
    void u(boolean z) {
        int z2 = 0;
        int i;
        J();
        z2 = 0;
        z = z ? 0 : 1065353216;
        final int i3 = 2;
        i = this.L % i3;
        if (this.L % i3 != 1 || this.M != i3) {
        }
        z(z2);
    }

    @Override // d.h.e.c
    public void v() {
        W(false);
    }

    @Override // d.h.e.c
    void w(boolean z) {
        this.O = true;
        if (z) {
            r();
        } else {
            v();
        }
        this.O = false;
    }

    @Override // d.h.e.c
    boolean y(long j) {
        int size;
        boolean z3 = false;
        int cmp = -1;
        int i = 1065353216;
        size = 0;
        if (this.E) {
            long l2 = H();
            long l = 0L;
            if (l2 > l) {
                f2 = (float)l2;
                float f6 = (float)(j - this.w) / f2;
            } else {
                i = 1065353216;
            }
            size = 1;
            r8 = size;
            float f3 = (float)(i3 + 1);
            int r2 = size;
            int r1 = size;
            float f4 = A(i);
            this.B = f4;
            z(this.E(f4, this.A));
        }
        return z3;
    }

    @Override // d.h.e.c
    void z(float f) {
        int length;
        int i = 0;
        length = this.Q.length;
        i = 0;
        while (i < this.P) {
            this.Q[i].a(this.P.getInterpolation(f));
            i = i + 1;
        }
        if (this.c != null) {
            while (i < this.c.size()) {
                (c.c)this.c.get(i).a(this);
                i = i + 1;
            }
        }
    }
}
