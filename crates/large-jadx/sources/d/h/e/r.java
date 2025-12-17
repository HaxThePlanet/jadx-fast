package d.h.e;

import android.util.Property;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class r extends d.h.e.v {

    private WeakReference<Object> W;
    private String X;
    private Property Y;
    private boolean Z = false;
    public r() {
        super();
        final int i = 0;
    }

    private r(Object object, String string2) {
        super();
        final int i = 0;
        g0(object);
        f0(string2);
    }

    private boolean b0(d.h.e.c c) {
        boolean z;
        Object length;
        String str2;
        String str;
        Object obj6;
        final int i = 0;
        z = (r)c.I();
        if (c instanceof r && c.a0() == a0() && obj6.length == z.length) {
            z = (r)c.I();
            if (c.a0() == a0()) {
                if (obj6.length == z.length) {
                    obj6 = i;
                    d.h.e.s[] objArr = this.Q;
                    for (Object length : obj2) {
                        objArr = this.Q;
                    }
                    return 1;
                }
            }
        }
        return i;
    }

    public static d.h.e.r c0(Object object, String string2, float... f3Arr3) {
        r rVar = new r(object, string2);
        rVar.S(f3Arr3);
        return rVar;
    }

    public static d.h.e.r d0(Object object, String string2, int... i3Arr3) {
        r rVar = new r(object, string2);
        rVar.T(i3Arr3);
        return rVar;
    }

    @Override // d.h.e.v
    public d.h.e.v B() {
        return Y();
    }

    @Override // d.h.e.v
    public String G() {
        String string;
        String str;
        if (this.T == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("animator:");
            stringBuilder.append(Z());
            string = stringBuilder.toString();
        }
        return string;
    }

    @Override // d.h.e.v
    void J() {
        boolean z;
        int length;
        int i;
        d.h.e.s sVar;
        z = a0();
        if (!this.H && z != null) {
            z = a0();
            if (z != null) {
                i = 0;
                while (i < objArr.length) {
                    this.Q[i].u(z);
                    i++;
                }
            }
            super.J();
        }
    }

    @Override // d.h.e.v
    public d.h.e.v R(long l) {
        e0(l);
        return this;
    }

    @Override // d.h.e.v
    public void S(float... fArr) {
        int length;
        int i;
        String arr;
        float[] obj4;
        length = this.Q;
        if (length != null) {
            if (length.length == 0) {
                length = this.Y;
                i = 0;
                int i2 = 1;
                if (length != null) {
                    arr = new s[i2];
                    arr[i] = s.j(length, fArr);
                    U(arr);
                } else {
                    length = new s[i2];
                    length[i] = s.k(this.X, fArr);
                    U(length);
                }
            } else {
                super.S(fArr);
            }
        } else {
        }
    }

    @Override // d.h.e.v
    public void T(int... iArr) {
        int length;
        int i;
        String arr;
        int[] obj4;
        length = this.Q;
        if (length != null) {
            if (length.length == 0) {
                length = this.Y;
                i = 0;
                int i2 = 1;
                if (length != null) {
                    arr = new s[i2];
                    arr[i] = s.l(length, iArr);
                    U(arr);
                } else {
                    length = new s[i2];
                    length[i] = s.m(this.X, iArr);
                    U(length);
                }
            } else {
                super.T(iArr);
            }
        } else {
        }
    }

    @Override // d.h.e.v
    public d.h.e.r Y() {
        return (r)super.B();
    }

    @Override // d.h.e.v
    public String Z() {
        int length;
        String name;
        int string2;
        String string;
        int stringBuilder;
        string2 = 0;
        if (this.X != null) {
        } else {
            Property property = this.Y;
            if (property != null) {
                name = property.getName();
            } else {
                length = this.Q;
                if (length != null && length.length > 0) {
                    if (length.length > 0) {
                        length = 0;
                        while (length < objArr2.length) {
                            if (length == 0) {
                            } else {
                            }
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(string2);
                            stringBuilder.append(",");
                            string = stringBuilder.toString();
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(string);
                            stringBuilder.append(this.Q[length].g());
                            string2 = stringBuilder.toString();
                            length++;
                            string = "";
                        }
                    }
                }
                name = string2;
            }
        }
        return name;
    }

    @Override // d.h.e.v
    public Object a0() {
        int i;
        WeakReference weakReference = this.W;
        if (weakReference == null) {
            i = 0;
        } else {
            i = weakReference.get();
        }
        return i;
    }

    @Override // d.h.e.v
    public Object clone() {
        return Y();
    }

    @Override // d.h.e.v
    public d.h.e.c d() {
        return Y();
    }

    @Override // d.h.e.v
    public d.h.e.r e0(long l) {
        super.R(l);
        return this;
    }

    @Override // d.h.e.v
    public void f0(String string) {
        d.h.e.s[] objArr;
        HashMap map;
        HashMap map2;
        objArr = this.Q;
        final int i = 0;
        if (objArr != null) {
            objArr = objArr[i];
            objArr.r(string);
            this.R.remove(objArr.g());
            this.R.put(string, objArr);
        }
        this.X = string;
        this.H = i;
    }

    @Override // d.h.e.v
    public void g0(Object object) {
        Object weakReference;
        Object obj2;
        if (a0() != object && l()) {
            if (l()) {
                cancel();
            }
            if (object == null) {
                obj2 = 0;
            } else {
                weakReference = new WeakReference(object);
                obj2 = weakReference;
            }
            this.W = obj2;
            this.H = false;
        }
    }

    @Override // d.h.e.v
    boolean h0(d.h.e.b.b b$b) {
        boolean z;
        Object obj3;
        final int i = 0;
        if (b == null) {
            return i;
        }
        if (b instanceof r && b.Z && b0((r)b)) {
            if (b.Z) {
                if (b0((r)b)) {
                    return 1;
                }
            }
        }
        return i;
    }

    @Override // d.h.e.v
    boolean j() {
        return this.H;
    }

    @Override // d.h.e.v
    public d.h.e.c s(long l) {
        e0(l);
        return this;
    }

    @Override // d.h.e.v
    public String toString() {
        String string;
        int objArr;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("ObjectAnimator@");
        stringBuilder2.append(Integer.toHexString(hashCode()));
        stringBuilder2.append(", target ");
        stringBuilder2.append(a0());
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

    @Override // d.h.e.v
    public void v() {
        b.g().b(this);
        super.v();
    }

    @Override // d.h.e.v
    void z(float f) {
        int i;
        d.h.e.s sVar;
        final Object obj = a0();
        if (this.W != null && obj == null) {
            if (obj == null) {
                cancel();
            }
        }
        super.z(f);
        i = 0;
        while (i < obj4.length) {
            this.Q[i].n(obj);
            i++;
        }
    }
}
