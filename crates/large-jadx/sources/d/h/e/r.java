package d.h.e;

import android.util.Property;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: ObjectAnimator.java */
/* loaded from: classes.dex */
public final class r extends v {

    private WeakReference<Object> W;
    private String X;
    private Property Y;
    private boolean Z = false;
    public r() {
        super();
    }

    private boolean b0(c cVar) {
        int i;
        z = cVar instanceof r;
        i = 0;
        if (cVar instanceof r) {
            d.h.e.s[] objArr = cVar.I();
            if (cVar.a0() == a0()) {
                if (this.Q.length == objArr.length) {
                    while (this.Q.length < objArr2.length) {
                        d.h.e.s sVar = objArr2[i];
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static r c0(Object object, String str, float... fArr) {
        final d.h.e.r rVar = new r(object, str);
        rVar.S(fArr);
        return rVar;
    }

    public static r d0(Object object, String str, int... iArr) {
        final d.h.e.r rVar = new r(object, str);
        rVar.T(iArr);
        return rVar;
    }

    @Override // d.h.e.v
    public String G() {
        String str;
        if (this.T == null) {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "animator:";
            String str2 = Z();
            str = str3 + str2;
        }
        return str;
    }

    @Override // d.h.e.v
    void J() {
        int length;
        int i;
        d.h.e.s sVar;
        if (!this.H && obj != null) {
            length = this.Q.length;
            i = 0;
            while (i < length) {
                this.Q[i].u(obj);
                i = i + 1;
            }
            super.J();
        }
    }

    @Override // d.h.e.v
    public void S(float... fArr) {
        if (this.Q != null) {
            length = objArr.length;
            if (objArr.length == 0) {
                int i = 0;
                int i2 = 1;
                if (this.Y != null) {
                    d.h.e.s[] arr2 = new s[i2];
                    U(s.j(this.Y, fArr));
                } else {
                    d.h.e.s[] arr = new s[i2];
                    U(s.k(this.X, fArr));
                }
            } else {
                super.S(fArr);
            }
        }
    }

    @Override // d.h.e.v
    public void T(int... iArr) {
        if (this.Q != null) {
            length = objArr.length;
            if (objArr.length == 0) {
                int i = 0;
                int i2 = 1;
                if (this.Y != null) {
                    d.h.e.s[] arr2 = new s[i2];
                    U(s.l(this.Y, iArr));
                } else {
                    d.h.e.s[] arr = new s[i2];
                    U(s.m(this.X, iArr));
                }
            } else {
                super.T(iArr);
            }
        }
    }

    @Override // d.h.e.v
    public r Y() {
        return (r)super.B();
    }

    @Override // d.h.e.v
    public String Z() {
        int i = 0;
        String name;
        String str = null;
        String str2;
        int i2 = 0;
        int length;
        i2 = 0;
        if (this.X == null) {
            if (this.Y != null) {
                name = this.Y.getName();
            } else {
                if (this.Q != null && objArr.length > 0) {
                    i = 0;
                    length = this.Q.length;
                    while (this.Q < this.Q.length) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String str3 = this.Q[i].g();
                        str = str2 + str3;
                        i = i + 1;
                    }
                }
            }
        }
        return name;
    }

    @Override // d.h.e.v
    public Object a0() {
        int i = 0;
        if (this.W == null) {
            i = 0;
        } else {
            Object obj = this.W.get();
        }
        return i;
    }

    @Override // d.h.e.v
    public r e0(long j) {
        super.R(j);
        return this;
    }

    @Override // d.h.e.v
    public void f0(String str) {
        final int i = 0;
        if (this.Q != null) {
            d.h.e.s sVar = objArr[i];
            sVar.r(str);
            this.R.remove(sVar.g());
            this.R.put(str, sVar);
        }
        this.X = str;
        this.H = false;
    }

    @Override // d.h.e.v
    public void g0(Object object) {
        WeakReference weakReference;
        if (a0() != object && this.l()) {
            cancel();
            object = object == null ? 0 : new WeakReference(object);
            this.W = (object == null ? 0 : new WeakReference(object));
            boolean z = false;
            this.H = (object == null ? 0 : new WeakReference(object));
        }
    }

    @Override // d.h.e.v
    boolean h0(b.b bVar) {
        final boolean z3 = false;
        if (bVar == null) {
            return false;
        }
        z = bVar instanceof r;
        if (bVar instanceof r) {
            if (bVar.Z && this.b0(bVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // d.h.e.v
    boolean j() {
        return this.H;
    }

    @Override // d.h.e.v
    public String toString() {
        String str;
        int i = 0;
        StringBuilder stringBuilder2 = new StringBuilder();
        String str3 = "ObjectAnimator@";
        String str4 = Integer.toHexString(hashCode());
        String str5 = ", target ";
        Object obj = a0();
        str = str3 + str4 + str5 + obj;
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

    @Override // d.h.e.v
    public void v() {
        b.g().b(this);
        super.v();
    }

    @Override // d.h.e.v
    void z(float f) {
        int i = 0;
        final Object obj = a0();
        if (this.W != null && obj == null) {
            cancel();
            return;
        }
        super.z(f);
        i = 0;
        while (this.W < this.Q.length) {
            this.Q[i].n(obj);
            i = i + 1;
        }
    }

    private r(Object object, String str) {
        super();
        g0(object);
        f0(str);
    }
}
