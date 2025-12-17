package d.h.e;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.animation.AnimationUtils;
import androidx.core.os.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class v extends d.h.e.c implements d.h.e.b.b {

    private static float U = 1f;
    private static final d.h.e.m V;
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
    private d.h.e.m P = 1;
    d.h.e.s[] Q;
    HashMap<String, d.h.e.s> R;
    private float S = -1f;
    String T = null;
    long w = -1;
    float x = -1f;
    private long y;
    private boolean z = false;
    static {
        a aVar = new a();
        v.V = aVar;
    }

    public v() {
        super();
        int i = -1;
        final int i6 = -1082130432;
        final int i7 = 0;
        final int i8 = 0;
        int i2 = 300;
        int i3 = 0;
        int i4 = 1;
        d.h.e.m mVar = v.V;
        int i5 = 0;
    }

    private float A(float f) {
        int i;
        int cmp;
        int obj3;
        i = 0;
        if (Float.compare(f, i) < 0) {
            obj3 = i;
        } else {
            i = this.L;
            if (i != -1) {
                obj3 = Math.min(f, (float)i2);
            }
        }
        return obj3;
    }

    private void C() {
        int clone;
        boolean z;
        int size;
        int i;
        Object obj;
        boolean z2;
        if (this.I) {
        }
        N();
        this.I = true;
        final int i2 = 0;
        this.v = i2;
        if (!this.F) {
            if (this.E && this.a != null) {
                if (this.a != null) {
                } else {
                    clone = i2;
                }
            } else {
            }
        } else {
        }
        if (clone != 0 && !this.E) {
            if (!this.E) {
                L();
            }
        }
        this.E = i2;
        this.F = i2;
        this.G = i2;
        size = -1;
        this.D = size;
        this.w = size;
        clone = this.a;
        if (clone != 0 && clone != null) {
            clone = this.a;
            if (clone != null) {
                clone = clone.clone();
                i = i2;
                while (i < (ArrayList)clone.size()) {
                    (c.a)clone.get(i).b(this, this.A);
                    i++;
                }
            }
        }
        this.A = i2;
        i.b();
    }

    private int D(float f) {
        int cmp;
        double floor;
        float obj5;
        obj5 = A(f);
        double d = (double)obj5;
        floor = Math.floor(d);
        if (Double.compare(d, floor) == 0 && Float.compare(obj5, cmp) > 0) {
            if (Float.compare(obj5, cmp) > 0) {
                floor -= cmp;
            }
        }
        return (int)floor;
    }

    private float E(float f, boolean z2) {
        int obj3;
        boolean obj4;
        obj3 = A(f);
        final int i = D(obj3);
        if (V(i, z2)) {
            obj3 = obj4 - obj3;
        }
        return obj3;
    }

    static float F() {
        return v.U;
    }

    private long H() {
        return (long)i;
    }

    private boolean K() {
        int i;
        i = Long.compare(l, i2) >= 0 ? 1 : 0;
        return i;
    }

    private void L() {
        Object clone;
        boolean size;
        int i;
        Object obj;
        boolean z;
        clone = this.a;
        if (clone != null && !this.G) {
            if (!this.G) {
                clone = clone.clone();
                i = 0;
                while (i < (ArrayList)clone.size()) {
                    (c.a)clone.get(i).f(this, this.A);
                    i++;
                }
            }
        }
        this.G = true;
    }

    public static d.h.e.v M(float... fArr) {
        v vVar = new v();
        vVar.S(fArr);
        return vVar;
    }

    private void N() {
        if (!this.N) {
        }
        c.o(this);
    }

    private float O() {
        float f;
        if (Float.compare(f, i) >= 0) {
        } else {
            f = v.U;
        }
        return f;
    }

    private boolean V(int i, boolean z2) {
        int i4;
        int i5;
        int i3;
        int i2;
        i3 = 2;
        if (i > 0 && this.M == i3) {
            i3 = 2;
            if (this.M == i3) {
                i4 = this.L;
                if (i >= i4 + 1) {
                    i5 = 0;
                    int i6 = 1;
                    if (i4 == -1 && z2 && i %= i3 == 0) {
                        i5 = 0;
                        i6 = 1;
                        if (z2) {
                            if (i %= i3 == 0) {
                                i5 = i6;
                            }
                            return i5;
                        }
                        if (i %= i3 != 0) {
                            i5 = i6;
                        }
                    }
                } else {
                }
                return i5;
            }
        }
        return z2;
    }

    private void W(boolean z) {
        int cmp2;
        int cmp;
        int i;
        double floor;
        boolean obj8;
        if (Looper.myLooper() == null) {
        } else {
            this.A = z;
            final int i3 = 1;
            this.N = z2 ^= i3;
            cmp2 = 0;
            final int i4 = -1082130432;
            obj8 = this.x;
            if (z && Float.compare(obj8, i4) != 0 && Float.compare(obj8, cmp2) != 0) {
                obj8 = this.x;
                if (Float.compare(obj8, i4) != 0) {
                    if (Float.compare(obj8, cmp2) != 0) {
                        int i6 = this.L;
                        if (i6 == -1) {
                            this.x = i9 -= obj8;
                        } else {
                            this.x = f -= obj8;
                        }
                    }
                }
            }
            this.F = i3;
            obj8 = 0;
            this.v = obj8;
            this.E = obj8;
            this.I = obj8;
            int i5 = -1;
            this.D = i5;
            this.w = i5;
            int i10 = 0;
            if (Long.compare(l, i10) != 0 && Float.compare(obj8, cmp2) < 0) {
                if (Float.compare(obj8, cmp2) < 0) {
                    if (this.A) {
                        X();
                        obj8 = this.x;
                        if (Float.compare(obj8, i4) == 0) {
                            Q(i10);
                        } else {
                            P(obj8);
                        }
                    }
                } else {
                }
            } else {
            }
            x();
        }
        obj8 = new AndroidRuntimeException("Animators may only be run on Looper threads");
        throw obj8;
    }

    private void X() {
        i.a(G());
        this.I = false;
        J();
        this.E = true;
        float f = this.x;
        final int i3 = 0;
        if (Float.compare(f, i3) >= 0) {
            this.B = f;
        } else {
            this.B = i3;
        }
        if (this.a != null) {
            L();
        }
    }

    private void x() {
        if (!this.N) {
        }
        c.b(this);
    }

    @Override // d.h.e.c
    public d.h.e.v B() {
        ArrayList arrayList;
        int i;
        ArrayList list;
        int length;
        HashMap hashMap;
        HashMap map;
        String str;
        final d.h.e.c cVar = super.d();
        if (this.c != null) {
            arrayList = new ArrayList(this.c);
            cVar.c = arrayList;
        }
        cVar.x = -1082130432;
        i = 0;
        cVar.A = i;
        cVar.H = i;
        cVar.F = i;
        cVar.E = i;
        cVar.v = i;
        cVar.z = i;
        cVar.G = i;
        int i3 = -1;
        cVar.w = i3;
        cVar.I = i;
        cVar.y = i3;
        cVar.D = i3;
        int i4 = 0;
        cVar.B = i4;
        cVar.C = i4;
        cVar.N = true;
        cVar.O = i;
        d.h.e.s[] objArr = this.Q;
        if (objArr != null) {
            length = objArr.length;
            cVar.Q = new s[length];
            hashMap = new HashMap(length);
            cVar.R = hashMap;
            while (i < length) {
                hashMap = objArr[i].b();
                cVar.Q[i] = hashMap;
                cVar.R.put(hashMap.g(), hashMap);
                i++;
            }
        }
        return (v)cVar;
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
    public d.h.e.s[] I() {
        return this.Q;
    }

    @Override // d.h.e.c
    void J() {
        boolean z;
        int i;
        d.h.e.s sVar;
        if (!this.H) {
            i = 0;
            while (i < objArr.length) {
                this.Q[i].h();
                i++;
            }
            this.H = true;
        }
    }

    @Override // d.h.e.c
    public void P(float f) {
        long z;
        int i;
        J();
        float obj5 = A(f);
        if (K()) {
            this.w = currentAnimationTimeMillis -= z;
        } else {
            this.x = obj5;
        }
        this.B = obj5;
        z(E(obj5, this.A));
    }

    @Override // d.h.e.c
    public void Q(long l) {
        int obj5;
        float obj6;
        final long l2 = this.J;
        if (Long.compare(l2, i) > 0) {
            obj5 /= obj6;
        } else {
            obj5 = 1065353216;
        }
        P(obj5);
    }

    @Override // d.h.e.c
    public d.h.e.v R(long l) {
        if (Long.compare(l, i) < 0) {
        } else {
            this.J = l;
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Animators cannot have negative duration: ");
        stringBuilder.append(l);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    @Override // d.h.e.c
    public void S(float... fArr) {
        d.h.e.s[] length2;
        int i;
        String length;
        float[] obj4;
        if (fArr != null) {
            if (fArr.length == 0) {
            } else {
                d.h.e.s[] objArr = this.Q;
                i = 0;
                if (objArr != null) {
                    if (objArr.length == 0) {
                        length2 = new s[1];
                        length2[i] = s.k("", fArr);
                        U(length2);
                    } else {
                        objArr[i].o(fArr);
                    }
                } else {
                }
                this.H = i;
            }
        }
    }

    @Override // d.h.e.c
    public void T(int... iArr) {
        d.h.e.s[] length2;
        int i;
        String length;
        int[] obj4;
        if (iArr != null) {
            if (iArr.length == 0) {
            } else {
                d.h.e.s[] objArr = this.Q;
                i = 0;
                if (objArr != null) {
                    if (objArr.length == 0) {
                        length2 = new s[1];
                        length2[i] = s.m("", iArr);
                        U(length2);
                    } else {
                        objArr[i].p(iArr);
                    }
                } else {
                }
                this.H = i;
            }
        }
    }

    @Override // d.h.e.c
    public void U(d.h.e.s... sArr) {
        int i;
        d.h.e.s sVar;
        HashMap map;
        String str;
        final int length = sArr.length;
        this.Q = sArr;
        HashMap hashMap = new HashMap(length);
        this.R = hashMap;
        int i2 = 0;
        i = i2;
        while (i < length) {
            sVar = sArr[i];
            this.R.put(sVar.g(), sVar);
            i++;
        }
        this.H = i2;
    }

    @Override // d.h.e.c
    public final boolean a(long l) {
        int cmp2;
        boolean cmp3;
        int cmp;
        boolean z;
        int cmp4;
        float f;
        int i2;
        long l3;
        long l2;
        int i;
        final int i5 = 0;
        if (Long.compare(l4, i5) < 0) {
            if (this.A) {
                cmp2 = l;
            } else {
                l6 += l;
            }
            this.w = cmp2;
        }
        i2 = 0;
        if (this.v) {
            this.y = l;
            N();
            return i2;
        }
        this.z = i2;
        l3 = this.y;
        if (this.z && Long.compare(l3, i5) > 0) {
            this.z = i2;
            l3 = this.y;
            if (Long.compare(l3, i5) > 0) {
                this.w = l11 += l3;
            }
        }
        int i6 = -1082130432;
        if (!this.E && Long.compare(l2, l) > 0 && Float.compare(f3, i6) == 0) {
            if (Long.compare(l2, l) > 0) {
                if (Float.compare(f3, i6) == 0) {
                    return i2;
                }
            }
            this.E = true;
            X();
        }
        if (Long.compare(l7, i5) < 0 && Float.compare(f4, i2) >= 0) {
            if (Float.compare(f4, i2) >= 0) {
                this.w = l - l10;
                this.x = i6;
            }
        }
        this.D = l;
        boolean obj9 = y(Math.max(l, obj10));
        if (obj9 != null) {
            C();
        }
        return obj9;
    }

    @Override // d.h.e.c
    public void cancel() {
        ArrayList iterator;
        boolean next;
        if (Looper.myLooper() == null) {
        } else {
            if (this.I) {
            }
            if (!this.F) {
                if (this.E && this.a != null && !this.E) {
                    if (this.a != null) {
                        if (!this.E) {
                            L();
                        }
                        iterator = (ArrayList)this.a.clone().iterator();
                        for (c.a next : iterator) {
                            next.c(this);
                        }
                    }
                }
            } else {
            }
            C();
        }
        AndroidRuntimeException androidRuntimeException = new AndroidRuntimeException("Animators may only be run on Looper threads");
        throw androidRuntimeException;
    }

    @Override // d.h.e.c
    public Object clone() {
        return B();
    }

    @Override // d.h.e.c
    public d.h.e.c d() {
        return B();
    }

    @Override // d.h.e.c
    public void e() {
        boolean z;
        int i;
        if (Looper.myLooper() == null) {
        } else {
            if (!this.E) {
                X();
                this.F = true;
            } else {
                if (!this.H) {
                    J();
                }
            }
            i = V(this.L, this.A) ? 0 : 1065353216;
            z(i);
            C();
        }
        AndroidRuntimeException androidRuntimeException = new AndroidRuntimeException("Animators may only be run on Looper threads");
        throw androidRuntimeException;
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
        int i = this.L;
        if (i == -1) {
            return -1;
        }
        return l += i6;
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
        boolean z;
        super.m();
        if (!this.v && this.v) {
            if (this.v) {
                this.y = -1;
                this.z = false;
            }
        }
    }

    @Override // d.h.e.c
    boolean n(long l) {
        if (this.N) {
            return 0;
        }
        return a(l);
    }

    @Override // d.h.e.c
    public void r() {
        int i;
        int i4;
        int i2;
        int i3;
        final int i5 = 1;
        if (K()) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.w = currentAnimationTimeMillis -= i3;
            this.A = z2 ^= i5;
        } else {
            if (this.F) {
                this.A = z3 ^= i5;
                e();
            } else {
                W(i5);
            }
        }
    }

    @Override // d.h.e.c
    public d.h.e.c s(long l) {
        return R(l);
    }

    @Override // d.h.e.c
    public void t(d.h.e.m m) {
        d.h.e.m obj1;
        if (m != null) {
            this.P = m;
        } else {
            obj1 = new q();
            this.P = obj1;
        }
    }

    @Override // d.h.e.c
    public String toString() {
        String string;
        int objArr;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("ValueAnimator@");
        stringBuilder2.append(Integer.toHexString(hashCode()));
        string = stringBuilder2.toString();
        if (this.Q != null) {
            objArr = 0;
            while (objArr < objArr3.length) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append("\n    ");
                stringBuilder.append(this.Q[objArr].toString());
                string = stringBuilder.toString();
                objArr++;
            }
        }
        return string;
    }

    @Override // d.h.e.c
    void u(boolean z) {
        int i2;
        int i;
        int obj5;
        J();
        obj5 = z ? i2 : 1065353216;
        final int i4 = 2;
        if (i3 %= i4 == 1 && this.M == i4) {
            if (this.M == i4) {
            } else {
                i2 = obj5;
            }
        } else {
        }
        z(i2);
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
    boolean y(long l) {
        boolean cmp2;
        int i3;
        int i4;
        int i;
        int cmp;
        int i2;
        int obj7;
        boolean obj8;
        i3 = 0;
        if (this.E) {
            long l2 = H();
            cmp2 = Long.compare(l2, i2);
            if (cmp2 > 0) {
                obj7 /= obj8;
            } else {
                obj7 = 1065353216;
            }
            i = 1;
            obj8 = (int)obj7 > (int)obj8 ? i : i3;
            int i6 = this.L;
            if (Float.compare(obj7, f) >= 0 && i6 != -1) {
                i4 = i6 != -1 ? i : i3;
            } else {
            }
            if (cmp2 == 0) {
                i3 = i;
            } else {
            }
            obj7 = A(obj7);
            this.B = obj7;
            z(E(obj7, this.A));
        }
        return i3;
    }

    @Override // d.h.e.c
    void z(float f) {
        int length;
        int i2;
        int i;
        d.h.e.s sVar;
        ArrayList obj5;
        i = i2;
        while (i < objArr.length) {
            this.Q[i].a(this.P.getInterpolation(f));
            i++;
        }
        obj5 = this.c;
        if (obj5 != null) {
            while (i2 < obj5.size()) {
                (c.c)this.c.get(i2).a(this);
                i2++;
            }
        }
    }
}
