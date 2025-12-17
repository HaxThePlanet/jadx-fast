package kotlin.i0.z.e.m0.e.z;

import java.util.ArrayList;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.y.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public abstract class a {

    private final int[] a;
    private final int b;
    private final int c;
    private final int d;
    private final List<Integer> e;
    static {
    }

    public a(int... iArr) {
        int intValue3;
        int intValue;
        int length;
        int intValue2;
        List obj3;
        n.f(iArr, "numbers");
        super();
        this.a = iArr;
        Integer num = i.C(iArr, 0);
        intValue2 = -1;
        if (num == null) {
            intValue3 = intValue2;
        } else {
            intValue3 = num.intValue();
        }
        this.b = intValue3;
        Integer num2 = i.C(iArr, 1);
        if (num2 == null) {
            intValue = intValue2;
        } else {
            intValue = num2.intValue();
        }
        this.c = intValue;
        Integer num3 = i.C(iArr, 2);
        if (num3 == null) {
        } else {
            intValue2 = num3.intValue();
        }
        this.d = intValue2;
        int i4 = 3;
        if (iArr.length > i4) {
            obj3 = p.L0(i.c(iArr).subList(i4, iArr.length));
        } else {
            obj3 = p.g();
        }
        this.e = obj3;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final boolean c(int i, int i2, int i3) {
        int i4;
        final int i5 = this.b;
        i4 = 1;
        if (i5 > i) {
            return i4;
        }
        final int i6 = 0;
        if (i5 < i) {
            return i6;
        }
        int obj4 = this.c;
        if (obj4 > i2) {
            return i4;
        }
        if (obj4 < i2) {
            return i6;
        }
        if (this.d >= i3) {
        } else {
            i4 = i6;
        }
        return i4;
    }

    public final boolean d(kotlin.i0.z.e.m0.e.z.a a) {
        n.f(a, "version");
        return c(a.b, a.c, a.d);
    }

    public final boolean e(int i, int i2, int i3) {
        int i4;
        final int i5 = this.b;
        i4 = 1;
        if (i5 < i) {
            return i4;
        }
        final int i6 = 0;
        if (i5 > i) {
            return i6;
        }
        int obj4 = this.c;
        if (obj4 < i2) {
            return i4;
        }
        if (obj4 > i2) {
            return i6;
        }
        if (this.d <= i3) {
        } else {
            i4 = i6;
        }
        return i4;
    }

    public boolean equals(Object object) {
        boolean z;
        Class class;
        Object obj3;
        if ((a)object != null && n.b(getClass(), object.getClass()) && this.b == object.b && this.c == object.c && this.d == object.d && n.b(this.e, object.e)) {
            if (n.b(getClass(), (a)object.getClass())) {
                if (this.b == object.b) {
                    if (this.c == object.c) {
                        if (this.d == object.d) {
                            obj3 = n.b(this.e, object.e) ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    protected final boolean f(kotlin.i0.z.e.m0.e.z.a a) {
        int i3;
        int i2;
        int i;
        Object obj5;
        n.f(a, "ourVersion");
        i3 = this.b;
        i2 = 1;
        if (i3 == 0) {
            if (a.b == 0 && this.c == a.c) {
                if (this.c == a.c) {
                } else {
                    i2 = i4;
                }
            } else {
            }
        } else {
            if (i3 == a.b && this.c <= a.c) {
                if (this.c <= a.c) {
                } else {
                }
            } else {
            }
        }
        return i2;
    }

    public final int[] g() {
        return this.a;
    }

    public int hashCode() {
        int i = this.b;
        i += i6;
        i2 += i8;
        return i3 += i10;
    }

    public String toString() {
        String str;
        String length;
        int i;
        int i2;
        Integer valueOf;
        int i5;
        int i4;
        int i3;
        int i6;
        int[] iArr = g();
        ArrayList arrayList = new ArrayList();
        i = 0;
        i2 = i;
        while (i2 < iArr.length) {
            valueOf = iArr[i2];
            if (valueOf != -1) {
            } else {
            }
            i5 = i;
            if (i5 == 0) {
                break;
            } else {
            }
            arrayList.add(Integer.valueOf(valueOf));
            i2++;
            i5 = 1;
        }
        if (arrayList.isEmpty()) {
            str = "unknown";
        } else {
            str = p.h0(arrayList, ".", 0, 0, 0, 0, 0, 62, 0);
        }
        return str;
    }
}
