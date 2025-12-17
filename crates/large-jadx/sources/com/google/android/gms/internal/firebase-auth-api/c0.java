package com.google.android.gms.internal.firebase-auth-api;

import android.accounts.Account;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
final class c0<T>  implements com.google.android.gms.internal.firebase-auth-api.l0<T> {

    private static final int[] p;
    private static final Unsafe q;
    private final int[] a;
    private final Object[] b;
    private final int c;
    private final int d;
    private final com.google.android.gms.internal.firebase-auth-api.y e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final int[] i;
    private final int j;
    private final int k;
    private final com.google.android.gms.internal.firebase-auth-api.m l;
    private final com.google.android.gms.internal.firebase-auth-api.y0<?, ?> m;
    private final com.google.android.gms.internal.firebase-auth-api.mr<?> n;
    private final com.google.android.gms.internal.firebase-auth-api.t o;
    static {
        c0.p = new int[0];
        c0.q = j1.l();
    }

    private c0(int[] iArr, Object[] object2Arr2, int i3, int i4, com.google.android.gms.internal.firebase-auth-api.y y5, boolean z6, boolean z7, int[] i8Arr8, int i9, int i10, com.google.android.gms.internal.firebase-auth-api.e0 e011, com.google.android.gms.internal.firebase-auth-api.m m12, com.google.android.gms.internal.firebase-auth-api.y0 y013, com.google.android.gms.internal.firebase-auth-api.mr mr14, com.google.android.gms.internal.firebase-auth-api.t t15, byte[] b16Arr16) {
        int i;
        boolean z;
        final Object obj = this;
        Object obj2 = y5;
        final com.google.android.gms.internal.firebase-auth-api.mr mrVar = mr14;
        super();
        obj.a = iArr;
        obj.b = object2Arr2;
        obj.c = i3;
        obj.d = i4;
        obj.g = obj2 instanceof xr;
        obj.h = z6;
        i = 0;
        if (mrVar != null && mrVar.h(y5)) {
            i = mrVar.h(y5) ? 1 : i;
        }
        obj.f = i;
        obj.i = i8Arr8;
        obj.j = i9;
        obj.k = i10;
        obj.l = m12;
        obj.m = y013;
        obj.n = mrVar;
        obj.e = obj2;
        obj.o = t15;
    }

    private final boolean A(T t, int i2) {
        int i = X(i2);
        final int i5 = 1048575;
        long l2 = (long)i6;
        final int i9 = 0;
        final int i10 = 1;
        if (Long.compare(l2, i8) == 0) {
            int obj9 = m(i2);
            long l = (long)i3;
            int i7 = 0;
            switch (obj9) {
                case 0:
                    return i10;
                    return i9;
                case 1:
                    return i10;
                    return i9;
                case 2:
                    return i10;
                    return i9;
                case 3:
                    return i10;
                    return i9;
                case 4:
                    return i10;
                    return i9;
                case 5:
                    return i10;
                    return i9;
                case 6:
                    return i10;
                    return i9;
                case 7:
                    return j1.B(t, l);
                case 8:
                    Object obj8 = j1.k(t, l);
                    return i10;
                    return i9;
                    return i10;
                    return i9;
                    obj8 = new IllegalArgumentException();
                    throw obj8;
                case 9:
                    return i10;
                    return i9;
                case 10:
                    return i10;
                    return i9;
                case 11:
                    return i10;
                    return i9;
                case 12:
                    return i10;
                    return i9;
                case 13:
                    return i10;
                    return i9;
                case 14:
                    return i10;
                    return i9;
                case 15:
                    return i10;
                    return i9;
                case 16:
                    return i10;
                    return i9;
                case 17:
                    return i10;
                    return i9;
                default:
                    obj8 = new IllegalArgumentException();
                    throw obj8;
            }
        }
        if (obj8 &= obj9 != 0) {
            return i10;
        }
        return i9;
    }

    private final boolean B(T t, int i2, int i3, int i4, int i5) {
        if (i3 == 1048575) {
            return A(t, i2);
        }
        if (i4 & i5 != 0) {
            return 1;
        }
        return 0;
    }

    private static boolean C(Object object, int i2, com.google.android.gms.internal.firebase-auth-api.l0 l03) {
        return l03.g(j1.k(object, (long)obj3));
    }

    private final boolean D(T t, int i2, int i3) {
        if (j1.h(t, (long)obj5) == i2) {
            return 1;
        }
        return 0;
    }

    private static <T> boolean E(T t, long l2) {
        return (Boolean)j1.k(t, l2).booleanValue();
    }

    private final void F(T t, com.google.android.gms.internal.firebase-auth-api.hr hr2) {
        int i13;
        int i4;
        int i9;
        int i10;
        long object;
        long l;
        int i;
        int int;
        int i8;
        int i2;
        int i5;
        int i11;
        int i7;
        int i3;
        int i12;
        final Object obj = this;
        Object obj2 = t;
        com.google.android.gms.internal.firebase-auth-api.hr hrVar = hr2;
        if (obj.f) {
        } else {
            final Unsafe unsafe = c0.q;
            i8 = i10;
            i = 0;
            int = 0;
            while (i < iArr.length) {
                int i16 = obj.m(i);
                i5 = obj.a[i];
                int i17 = c0.l(i16);
                i3 = 1;
                if (i17 <= 17) {
                } else {
                }
                i7 = 0;
                object = (long)i2;
                i11 = 0;
                i += 3;
                i10 = 1048575;
                if (obj.D(obj2, i5, i) != 0) {
                }
                hrVar.B(i5, unsafe.getObject(obj2, object), obj.p(i));
                if (obj.D(obj2, i5, i) != 0) {
                }
                hrVar.c(i5, c0.n(obj2, object));
                if (obj.D(obj2, i5, i) != 0) {
                }
                hrVar.a(i5, c0.Q(obj2, object));
                if (obj.D(obj2, i5, i) != 0) {
                }
                hrVar.J(i5, c0.n(obj2, object));
                if (obj.D(obj2, i5, i) != 0) {
                }
                hrVar.H(i5, c0.Q(obj2, object));
                if (obj.D(obj2, i5, i) != 0) {
                }
                hrVar.t(i5, c0.Q(obj2, object));
                if (obj.D(obj2, i5, i) != 0) {
                }
                hrVar.h(i5, c0.Q(obj2, object));
                if (obj.D(obj2, i5, i) != 0) {
                }
                hrVar.o(i5, (wq)unsafe.getObject(obj2, object));
                if (obj.D(obj2, i5, i) != 0) {
                }
                hrVar.G(i5, unsafe.getObject(obj2, object), obj.p(i));
                if (obj.D(obj2, i5, i) != 0) {
                }
                c0.H(i5, unsafe.getObject(obj2, object), hrVar);
                if (obj.D(obj2, i5, i) != 0) {
                }
                hrVar.m(i5, c0.E(obj2, object));
                if (obj.D(obj2, i5, i) != 0) {
                }
                hrVar.v(i5, c0.Q(obj2, object));
                if (obj.D(obj2, i5, i) != 0) {
                }
                hrVar.x(i5, c0.n(obj2, object));
                if (obj.D(obj2, i5, i) != 0) {
                }
                hrVar.C(i5, c0.Q(obj2, object));
                if (obj.D(obj2, i5, i) != 0) {
                }
                hrVar.j(i5, c0.n(obj2, object));
                if (obj.D(obj2, i5, i) != 0) {
                }
                hrVar.E(i5, c0.n(obj2, object));
                if (obj.D(obj2, i5, i) != 0) {
                }
                hrVar.z(i5, c0.N(obj2, object));
                if (obj.D(obj2, i5, i) != 0) {
                }
                hrVar.q(i5, c0.M(obj2, object));
                obj.G(hrVar, i5, unsafe.getObject(obj2, object), i);
                n0.q(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, obj.p(i));
                n0.x(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, i3);
                n0.w(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, i3);
                n0.v(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, i3);
                n0.u(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, i3);
                n0.m(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, i3);
                n0.z(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, i3);
                n0.j(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, i3);
                n0.n(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, i3);
                n0.o(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, i3);
                n0.r(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, i3);
                n0.B(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, i3);
                n0.s(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, i3);
                n0.p(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, i3);
                n0.l(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, i3);
                n0.x(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, false);
                i11 = i5;
                n0.w(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, false);
                n0.v(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, false);
                n0.u(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, false);
                n0.m(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, false);
                n0.z(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, false);
                n0.k(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar);
                n0.t(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, obj.p(i));
                n0.y(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar);
                n0.j(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, false);
                n0.n(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, false);
                n0.o(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, false);
                n0.r(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, false);
                n0.B(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, false);
                n0.s(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, false);
                n0.p(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, false);
                n0.l(obj.a[i], (List)unsafe.getObject(obj2, object), hrVar, false);
                i11 = 0;
                if (int & i7 != 0) {
                }
                hrVar.B(i5, unsafe.getObject(obj2, object), obj.p(i));
                i11 = 0;
                if (int & i7 != 0) {
                }
                hrVar.c(i5, unsafe.getLong(obj2, object));
                i11 = 0;
                if (int & i7 != 0) {
                }
                hrVar.a(i5, unsafe.getInt(obj2, object));
                i11 = 0;
                if (int & i7 != 0) {
                }
                hrVar.J(i5, unsafe.getLong(obj2, object));
                i11 = 0;
                if (int & i7 != 0) {
                }
                hrVar.H(i5, unsafe.getInt(obj2, object));
                i11 = 0;
                if (int & i7 != 0) {
                }
                hrVar.t(i5, unsafe.getInt(obj2, object));
                i11 = 0;
                if (int & i7 != 0) {
                }
                hrVar.h(i5, unsafe.getInt(obj2, object));
                i11 = 0;
                if (int & i7 != 0) {
                }
                hrVar.o(i5, (wq)unsafe.getObject(obj2, object));
                i11 = 0;
                if (int & i7 != 0) {
                }
                hrVar.G(i5, unsafe.getObject(obj2, object), obj.p(i));
                i11 = 0;
                if (int & i7 != 0) {
                }
                c0.H(i5, unsafe.getObject(obj2, object), hrVar);
                i11 = 0;
                if (int & i7 != 0) {
                }
                hrVar.m(i5, j1.B(obj2, object));
                i11 = 0;
                if (int & i7 != 0) {
                }
                hrVar.v(i5, unsafe.getInt(obj2, object));
                i11 = 0;
                if (int & i7 != 0) {
                }
                hrVar.x(i5, unsafe.getLong(obj2, object));
                i11 = 0;
                if (int & i7 != 0) {
                }
                hrVar.C(i5, unsafe.getInt(obj2, object));
                i11 = 0;
                if (int & i7 != 0) {
                }
                hrVar.j(i5, unsafe.getLong(obj2, object));
                i11 = 0;
                if (int & i7 != 0) {
                }
                hrVar.E(i5, unsafe.getLong(obj2, object));
                i11 = 0;
                if (int & i7 != 0) {
                }
                hrVar.z(i5, j1.g(obj2, object));
                i11 = 0;
                if (int & i7 != 0) {
                }
                hrVar.q(i5, j1.f(obj2, object));
                int i19 = obj.a[i + 2];
                i12 = i19 & i10;
                if (i12 != i8) {
                }
                i7 = i3 << i20;
                int = unsafe.getInt(obj2, (long)i12);
                i8 = i12;
            }
            com.google.android.gms.internal.firebase-auth-api.y0 y0Var = obj.m;
            y0Var.r(y0Var.d(obj2), hrVar);
        }
        obj.n.a(obj2);
        throw 0;
    }

    private final <K, V> void G(com.google.android.gms.internal.firebase-auth-api.hr hr, int i2, Object object3, int i4) {
        if (object3 != null) {
        } else {
        }
        Object obj1 = r(i4);
        throw 0;
    }

    private static final void H(int i, Object object2, com.google.android.gms.internal.firebase-auth-api.hr hr3) {
        if (object2 instanceof String != null) {
            hr3.f(i, (String)object2);
        }
        hr3.o(i, (wq)object2);
    }

    static com.google.android.gms.internal.firebase-auth-api.a1 J(Object object) {
        com.google.android.gms.internal.firebase-auth-api.a1 zzc;
        if (object.zzc == a1.c()) {
            object.zzc = a1.e();
        }
        return zzc;
    }

    static <T> com.google.android.gms.internal.firebase-auth-api.c0<T> K(Class<T> class, com.google.android.gms.internal.firebase-auth-api.v v2, com.google.android.gms.internal.firebase-auth-api.e0 e03, com.google.android.gms.internal.firebase-auth-api.m m4, com.google.android.gms.internal.firebase-auth-api.y0<?, ?> y05, com.google.android.gms.internal.firebase-auth-api.mr<?> mr6, com.google.android.gms.internal.firebase-auth-api.t t7) {
        if (!v2 instanceof j0) {
        } else {
            return c0.L((j0)v2, e03, m4, y05, mr6, t7);
        }
        throw 0;
    }

    static <T> com.google.android.gms.internal.firebase-auth-api.c0<T> L(com.google.android.gms.internal.firebase-auth-api.j0 j0, com.google.android.gms.internal.firebase-auth-api.e0 e02, com.google.android.gms.internal.firebase-auth-api.m m3, com.google.android.gms.internal.firebase-auth-api.y0<?, ?> y04, com.google.android.gms.internal.firebase-auth-api.mr<?> mr5, com.google.android.gms.internal.firebase-auth-api.t t6) {
        String str;
        int i6;
        Class class;
        int i49;
        int i7;
        int i53;
        char charAt15;
        int i11;
        int i19;
        int length;
        int i20;
        int i44;
        int charAt6;
        int i37;
        char charAt5;
        int i31;
        char charAt3;
        int i62;
        int i16;
        int charAt2;
        char charAt9;
        int i29;
        int i9;
        int charAt10;
        int i;
        int i65;
        int i33;
        char charAt12;
        char c8;
        int i45;
        char charAt7;
        int i48;
        int[] iArr2;
        int i3;
        Object i55;
        int i8;
        char charAt11;
        Object obj;
        Class cls;
        int i17;
        int i10;
        int i35;
        int i30;
        int i46;
        char c;
        int i64;
        int i38;
        int i66;
        char charAt13;
        int i12;
        int i15;
        char charAt;
        Object[] arr;
        int i54;
        int i27;
        int i13;
        char c5;
        int i58;
        Object obj2;
        boolean z;
        int i47;
        int i39;
        int i4;
        int i18;
        int i32;
        int i5;
        char charAt8;
        int i14;
        int[] iArr;
        int i40;
        int i28;
        char charAt4;
        int i43;
        char charAt14;
        int i21;
        int i41;
        int i59;
        int i63;
        int i61;
        char c2;
        int i34;
        int i57;
        int i22;
        int i50;
        int i23;
        Object obj3;
        int i36;
        int i60;
        int i56;
        char c3;
        int i24;
        char c4;
        int i25;
        int i26;
        int i67;
        int i2;
        int type;
        int i42;
        int i52;
        Object[] objArr;
        String str2;
        int i51;
        char c7;
        char c6;
        int i70 = 0;
        i15 = j0.zzc() == 2 ? 1 : i70;
        str = j0.a();
        length = str.length();
        charAt10 = 55296;
        if (str.charAt(i70) >= charAt10) {
            i9 = 1;
            while (str.charAt(i9) >= charAt10) {
                i9 = i65;
            }
        } else {
            i65 = 1;
        }
        i62 = i65 + 1;
        charAt12 = str.charAt(i65);
        if (charAt12 >= charAt10) {
            charAt12 &= 8191;
            i8 = 13;
            i46 = i62 + 1;
            char charAt17 = str.charAt(i62);
            while (charAt17 >= charAt10) {
                i33 |= i89;
                i8 += 13;
                i62 = i46;
                i46 = i62 + 1;
                charAt17 = str.charAt(i62);
            }
            i33 |= i87;
            i62 = i46;
        }
        if (charAt12 == 0) {
            iArr = iArr4;
            c8 = i23;
        } else {
            i45 = i62 + 1;
            charAt9 = str.charAt(i62);
            if (charAt9 >= charAt10) {
                charAt9 &= 8191;
                i8 = 13;
                i46 = i45 + 1;
                char charAt18 = str.charAt(i45);
                while (charAt18 >= charAt10) {
                    i29 |= i95;
                    i8 += 13;
                    i45 = i46;
                    i46 = i45 + 1;
                    charAt18 = str.charAt(i45);
                }
                i29 |= i93;
                i45 = i46;
            }
            i35 = i45 + 1;
            charAt7 = str.charAt(i45);
            if (charAt7 >= charAt10) {
                charAt7 &= 8191;
                i46 = 13;
                i54 = i35 + 1;
                char charAt20 = str.charAt(i35);
                while (charAt20 >= charAt10) {
                    i48 |= i105;
                    i46 += 13;
                    i35 = i54;
                    i54 = i35 + 1;
                    charAt20 = str.charAt(i35);
                }
                i48 |= i103;
                i35 = i54;
            }
            i66 = i35 + 1;
            charAt11 = str.charAt(i35);
            if (charAt11 >= charAt10) {
                charAt11 &= 8191;
                i54 = 13;
                i32 = i66 + 1;
                char charAt21 = str.charAt(i66);
                while (charAt21 >= charAt10) {
                    i30 |= i109;
                    i54 += 13;
                    i66 = i32;
                    i32 = i66 + 1;
                    charAt21 = str.charAt(i66);
                }
                i30 |= i107;
                i66 = i32;
            }
            i27 = i66 + 1;
            charAt13 = str.charAt(i66);
            if (charAt13 >= charAt10) {
                charAt13 &= 8191;
                i32 = 13;
                i40 = i27 + 1;
                char charAt22 = str.charAt(i27);
                while (charAt22 >= charAt10) {
                    i12 |= i115;
                    i32 += 13;
                    i27 = i40;
                    i40 = i27 + 1;
                    charAt22 = str.charAt(i27);
                }
                i12 |= i113;
                i27 = i40;
            }
            i5 = i27 + 1;
            charAt = str.charAt(i27);
            if (charAt >= charAt10) {
                charAt &= 8191;
                i40 = 13;
                i34 = i5 + 1;
                char charAt23 = str.charAt(i5);
                while (charAt23 >= charAt10) {
                    i13 |= i131;
                    i40 += 13;
                    i5 = i34;
                    i34 = i5 + 1;
                    charAt23 = str.charAt(i5);
                }
                i13 |= i129;
                i5 = i34;
            }
            i28 = i5 + 1;
            charAt8 = str.charAt(i5);
            if (charAt8 >= charAt10) {
                charAt8 &= 8191;
                i34 = 13;
                i50 = i28 + 1;
                char charAt24 = str.charAt(i28);
                while (charAt24 >= charAt10) {
                    i14 |= i135;
                    i34 += 13;
                    i28 = i50;
                    i50 = i28 + 1;
                    charAt24 = str.charAt(i28);
                }
                i14 |= i133;
                i28 = i50;
            }
            i57 = i28 + 1;
            charAt4 = str.charAt(i28);
            if (charAt4 >= charAt10) {
                charAt4 &= 8191;
                i50 = 13;
                i36 = i57 + 1;
                char charAt26 = str.charAt(i57);
                while (charAt26 >= charAt10) {
                    i43 |= i142;
                    i50 += 13;
                    i57 = i36;
                    i36 = i57 + 1;
                    charAt26 = str.charAt(i57);
                }
                i43 |= i140;
                i57 = i36;
            }
            i50 = i57 + 1;
            charAt14 = str.charAt(i57);
            if (charAt14 >= charAt10) {
                charAt14 &= 8191;
                i36 = 13;
                i60 = i50 + 1;
                char charAt27 = str.charAt(i50);
                while (charAt27 >= charAt10) {
                    i22 |= i145;
                    i36 += 13;
                    i50 = i60;
                    i60 = i50 + 1;
                    charAt27 = str.charAt(i50);
                }
                i22 |= i143;
                i50 = i60;
            }
            iArr = new int[charAt4 += i146];
            i147 += charAt7;
            c8 = charAt9;
            i62 = i50;
            c5 = charAt13;
            c = c6;
        }
        Unsafe unsafe = c0.q;
        Object[] objArr4 = j0.b();
        class = j0.zza().getClass();
        iArr2 = new int[charAt * 3];
        arr = new Object[charAt += charAt];
        final int i149 = charAt14 + c;
        c3 = charAt14;
        i24 = i149;
        i64 = 0;
        i56 = 0;
        while (i62 < length) {
            i25 = i62 + 1;
            charAt2 = str.charAt(i62);
            if (charAt2 >= charAt10) {
            } else {
            }
            i53 = i25;
            i26 = i53 + 1;
            charAt15 = str.charAt(i53);
            if (charAt15 >= charAt10) {
            } else {
            }
            i52 = length;
            i20 = i26;
            int i91 = charAt15 & 255;
            if (charAt15 & 1024 != 0) {
            }
            if (i91 >= 51) {
            } else {
            }
            i51 = iArr2;
            c2 = charAt11;
            c7 = c5;
            i55 = i23 + 1;
            Field field = c0.s(class, (String)objArr4[i23]);
            if (i91 != 9) {
            } else {
            }
            i67 = 1;
            int i123 = i64 / 3;
            arr[i124++] = field.getType();
            z = i55;
            objArr = arr;
            if (charAt15 & 4096 == 4096 && i91 <= 17) {
            } else {
            }
            str2 = str;
            cls = class;
            i6 = type;
            type = i20;
            i37 = 0;
            if (i91 >= 18 && i91 <= 49) {
            }
            i23 = z;
            int i71 = i64 + 1;
            i51[i64] = charAt2;
            int i90 = i71 + 1;
            if (charAt15 & 512 != 0) {
            } else {
            }
            i38 = 0;
            if (charAt15 &= 256 != 0) {
            } else {
            }
            i11 = 0;
            i51[i71] = i78 |= i3;
            i64 = i90 + 1;
            i51[i90] = i6 |= i72;
            class = cls;
            charAt11 = c2;
            charAt14 = c4;
            i62 = type;
            length = i52;
            arr = objArr;
            str = str2;
            iArr2 = i51;
            c5 = c7;
            charAt10 = 55296;
            i11 = 268435456;
            i38 = 536870912;
            if (i91 <= 49) {
            }
            iArr[i24] = (int)objectFieldOffset4;
            i24 = class;
            if (i91 <= 17) {
            } else {
            }
            charAt5 = str.charAt(i20);
            int i111 = 55296;
            if (charAt5 >= i111) {
            } else {
            }
            type = i17;
            i99 += i2;
            arr = objArr4[i100];
            str2 = str;
            if (arr instanceof Field) {
            } else {
            }
            objArr4[i100] = c0.s(class, (String)arr);
            cls = class;
            i6 = (int)objectFieldOffset;
            charAt5 %= 32;
            charAt5 &= 8191;
            i2 = 13;
            char charAt19 = str.charAt(i17);
            while (charAt19 >= i111) {
                i31 |= i102;
                i2 += 13;
                i17 = type;
                charAt19 = str.charAt(i17);
            }
            i31 |= i17;
            i31 |= i102;
            i2 += 13;
            i17 = type;
            if (i91 == 17) {
            } else {
            }
            if (i91 != 27) {
            } else {
            }
            i67 = 1;
            int i125 = i64 / 3;
            type = i55 + 1;
            arr[i126++] = objArr4[i55];
            z = type;
            if (i91 == 49) {
            } else {
            }
            if (i91 != 12 && i91 != 30) {
            } else {
            }
            if (i15 == 0) {
            } else {
            }
            i67 = 1;
            int i127 = i64 / 3;
            type = i55 + 1;
            i67 = 1;
            arr[i128++] = objArr4[i55];
            if (i91 != 30) {
            } else {
            }
            if (i91 == 44) {
            } else {
            }
            if (i91 == 50) {
            } else {
            }
            i18 = c3 + 1;
            iArr[c3] = i64;
            int i150 = i64 / 3;
            i150 += i150;
            type = i55 + 1;
            arr[i151] = objArr4[i55];
            if (charAt15 & 2048 != 0) {
            } else {
            }
            c3 = i18;
            z = type;
            i67 = 1;
            i55 = type + 1;
            arr[i151++] = objArr4[type];
            c3 = i18;
            charAt6 = str.charAt(i20);
            i42 = i137;
            if (charAt6 >= 55296) {
            } else {
            }
            c7 = c5;
            i59 = i42;
            i58 = i91 + -51;
            type = i59;
            if (i58 != 9) {
            } else {
            }
            int i119 = i64 / 3;
            i63 = i23 + 1;
            i67 = 1;
            arr[i120++] = objArr4[i23];
            i23 = i63;
            charAt6 += charAt6;
            obj2 = objArr4[i80];
            if (obj2 instanceof Field) {
            } else {
            }
            objArr4[i80] = c0.s(class, (String)obj2);
            i51 = iArr2;
            c2 = charAt11;
            i80++;
            obj = objArr4[i81];
            if (obj instanceof Field) {
            } else {
            }
            objArr4[i81] = c0.s(class, (String)obj);
            str2 = str;
            cls = class;
            i6 = i98;
            objArr = arr;
            i67 = 1;
            i3 = i82;
            i37 = 0;
            if (i58 == 17) {
            } else {
            }
            if (i58 == 12 && i15 == 0) {
            }
            if (i15 == 0) {
            }
            int i121 = i64 / 3;
            i63 = i23 + 1;
            i67 = 1;
            arr[i122++] = objArr4[i23];
            charAt6 &= 8191;
            i41 = i42;
            i42 = 13;
            i51 = i41 + 1;
            char charAt25 = str.charAt(i41);
            while (charAt25 >= 55296) {
                i44 |= i118;
                i42 += 13;
                i41 = i51;
                c5 = c7;
                i51 = i41 + 1;
                charAt25 = str.charAt(i41);
            }
            i44 |= c5;
            i59 = i51;
            i44 |= i118;
            i42 += 13;
            i41 = i51;
            c5 = c7;
            iArr[i56] = i64;
            i56 = i21;
            charAt15 &= 8191;
            i = i26;
            i26 = 13;
            type = i + 1;
            charAt10 = str.charAt(i);
            while (charAt10 >= 55296) {
                i19 |= i86;
                i26 += 13;
                i = type;
                length = i52;
                type = i + 1;
                charAt10 = str.charAt(i);
            }
            i19 |= i84;
            i20 = type;
            i19 |= i86;
            i26 += 13;
            i = type;
            length = i52;
            charAt2 &= 8191;
            i7 = i25;
            i25 = 13;
            i2 = i7 + 1;
            char charAt16 = str.charAt(i7);
            while (charAt16 >= charAt10) {
                i16 |= i75;
                i25 += 13;
                i7 = i2;
                i2 = i7 + 1;
                charAt16 = str.charAt(i7);
            }
            i16 |= i73;
            i53 = i2;
            i16 |= i75;
            i25 += 13;
            i7 = i2;
        }
        super(iArr2, arr, charAt11, c5, j0.zza(), i15, 0, iArr, charAt14, i149, e02, m3, y04, mr5, t6, 0);
        return c0Var;
    }

    private static <T> double M(T t, long l2) {
        return (Double)j1.k(t, l2).doubleValue();
    }

    private static <T> float N(T t, long l2) {
        return (Float)j1.k(t, l2).floatValue();
    }

    private final int O(T t) {
        int i8;
        int i14;
        int i11;
        int i7;
        int i15;
        int i17;
        int int;
        int i5;
        int object;
        int i16;
        int i10;
        int i2;
        int i3;
        int i18;
        int i13;
        int i6;
        int i4;
        int long;
        int i12;
        int i;
        int i9;
        long l;
        Unsafe unsafe = c0.q;
        int i20 = 1048575;
        final int i21 = 0;
        i5 = i20;
        int = i17;
        while (i7 < iArr.length) {
            int i23 = m(i7);
            i18 = this.a[i7];
            long = c0.l(i23);
            i9 = 1;
            if (long <= 17) {
            } else {
            }
            i = i21;
            l = (long)i24;
            object = 63;
            i7 += 3;
            if (D(t, i18, i7)) {
            }
            object = gr.F(i18, (y)unsafe.getObject(t, l), p(i7));
            i17 += object;
            if (D(t, i18, i7)) {
            }
            long l3 = c0.n(t, l);
            i6 = gr.f(i18 <<= 3);
            object = gr.g(i67 ^= i9);
            i6 += object;
            i17 += i18;
            if (D(t, i18, i7)) {
            }
            int i25 = c0.Q(t, l);
            i6 = gr.f(i18 <<= 3);
            object = gr.f(i26 ^= long);
            if (D(t, i18, i7)) {
            }
            i3 = gr.f(i18 << 3);
            i3 += 8;
            if (D(t, i18, i7)) {
            }
            i16 = gr.f(i18 << 3);
            i16 += 4;
            if (D(t, i18, i7)) {
            }
            i6 = gr.f(i18 <<= 3);
            object = gr.G(c0.Q(t, l));
            if (D(t, i18, i7)) {
            }
            i6 = gr.f(i18 <<= 3);
            object = gr.f(c0.Q(t, l));
            if (D(t, i18, i7)) {
            }
            i13 = gr.f(i18 <<= 3);
            i12 = gr.f((wq)unsafe.getObject(t, l).g());
            i13 += long;
            if (D(t, i18, i7)) {
            }
            object = n0.Q(i18, unsafe.getObject(t, l), p(i7));
            if (D(t, i18, i7)) {
            }
            Object object40 = unsafe.getObject(t, l);
            if (object40 instanceof wq) {
            } else {
            }
            i6 = gr.f(i18 <<= 3);
            object = gr.d((String)object40);
            i13 = gr.f(i18 <<= 3);
            i12 = gr.f((wq)object40.g());
            if (D(t, i18, i7)) {
            }
            i2 = gr.f(i18 << 3);
            i2 += i9;
            if (D(t, i18, i7)) {
            }
            i16 = gr.f(i18 << 3);
            if (D(t, i18, i7)) {
            }
            i3 = gr.f(i18 << 3);
            if (D(t, i18, i7)) {
            }
            i6 = gr.f(i18 <<= 3);
            object = gr.G(c0.Q(t, l));
            if (D(t, i18, i7)) {
            }
            i10 = gr.f(i18 << 3);
            i18 = gr.g(c0.n(t, l));
            i10 += i18;
            if (D(t, i18, i7)) {
            }
            i10 = gr.f(i18 << 3);
            i18 = gr.g(c0.n(t, l));
            if (D(t, i18, i7)) {
            }
            i16 = gr.f(i18 << 3);
            if (D(t, i18, i7)) {
            }
            i3 = gr.f(i18 << 3);
            t.a(i18, unsafe.getObject(t, l), r(i7));
            object = n0.L(i18, (List)unsafe.getObject(t, l), p(i7));
            object = n0.V((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i4 = gr.e(i18);
            long = gr.f(object);
            i4 += long;
            object = n0.T((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i4 = gr.e(i18);
            long = gr.f(object);
            object = n0.K((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i4 = gr.e(i18);
            long = gr.f(object);
            object = n0.I((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i4 = gr.e(i18);
            long = gr.f(object);
            object = n0.G((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i4 = gr.e(i18);
            long = gr.f(object);
            object = n0.Y((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i4 = gr.e(i18);
            long = gr.f(object);
            object = n0.D((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i4 = gr.e(i18);
            long = gr.f(object);
            object = n0.I((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i4 = gr.e(i18);
            long = gr.f(object);
            object = n0.K((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i4 = gr.e(i18);
            long = gr.f(object);
            object = n0.N((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i4 = gr.e(i18);
            long = gr.f(object);
            object = n0.a0((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i4 = gr.e(i18);
            long = gr.f(object);
            object = n0.P((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i4 = gr.e(i18);
            long = gr.f(object);
            object = n0.I((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i4 = gr.e(i18);
            long = gr.f(object);
            object = n0.K((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i4 = gr.e(i18);
            long = gr.f(object);
            object = n0.U(i18, (List)unsafe.getObject(t, l), i21);
            object = n0.S(i18, (List)unsafe.getObject(t, l), i21);
            object = n0.J(i18, (List)unsafe.getObject(t, l), i21);
            object = n0.H(i18, (List)unsafe.getObject(t, l), i21);
            object = n0.F(i18, (List)unsafe.getObject(t, l), i21);
            object = n0.X(i18, (List)unsafe.getObject(t, l), i21);
            object = n0.E(i18, (List)unsafe.getObject(t, l));
            object = n0.R(i18, (List)unsafe.getObject(t, l), p(i7));
            object = n0.W(i18, (List)unsafe.getObject(t, l));
            object = n0.A(i18, (List)unsafe.getObject(t, l), i21);
            object = n0.H(i18, (List)unsafe.getObject(t, l), i21);
            object = n0.J(i18, (List)unsafe.getObject(t, l), i21);
            object = n0.M(i18, (List)unsafe.getObject(t, l), i21);
            object = n0.Z(i18, (List)unsafe.getObject(t, l), i21);
            object = n0.O(i18, (List)unsafe.getObject(t, l), i21);
            object = n0.H(i18, (List)unsafe.getObject(t, l), i21);
            object = n0.J(i18, (List)unsafe.getObject(t, l), i21);
            if (int & i != 0) {
            }
            object = gr.F(i18, (y)unsafe.getObject(t, l), p(i7));
            if (int & i != 0) {
            }
            long long2 = unsafe.getLong(t, l);
            i6 = gr.f(i18 <<= 3);
            object = gr.g(i68 ^= i9);
            if (int & i != 0) {
            }
            int int3 = unsafe.getInt(t, l);
            i6 = gr.f(i18 <<= 3);
            object = gr.f(i29 ^= long);
            if (int & i != 0) {
            }
            i3 = gr.f(i18 << 3);
            if (int & i != 0) {
            }
            i16 = gr.f(i18 << 3);
            if (int & i != 0) {
            }
            i6 = gr.f(i18 <<= 3);
            object = gr.G(unsafe.getInt(t, l));
            if (int & i != 0) {
            }
            i6 = gr.f(i18 <<= 3);
            object = gr.f(unsafe.getInt(t, l));
            if (int & i != 0) {
            }
            i13 = gr.f(i18 <<= 3);
            i12 = gr.f((wq)unsafe.getObject(t, l).g());
            if (int & i != 0) {
            }
            object = n0.Q(i18, unsafe.getObject(t, l), p(i7));
            if (int & i != 0) {
            }
            Object object41 = unsafe.getObject(t, l);
            if (object41 instanceof wq) {
            } else {
            }
            i6 = gr.f(i18 <<= 3);
            object = gr.d((String)object41);
            i13 = gr.f(i18 <<= 3);
            i12 = gr.f((wq)object41.g());
            if (int & i != 0) {
            }
            i2 = gr.f(i18 << 3);
            if (int & i != 0) {
            }
            i16 = gr.f(i18 << 3);
            if (int & i != 0) {
            }
            i3 = gr.f(i18 << 3);
            if (int & i != 0) {
            }
            i6 = gr.f(i18 <<= 3);
            object = gr.G(unsafe.getInt(t, l));
            if (int & i != 0) {
            }
            i10 = gr.f(i18 << 3);
            i18 = gr.g(unsafe.getLong(t, l));
            if (int & i != 0) {
            }
            i10 = gr.f(i18 << 3);
            i18 = gr.g(unsafe.getLong(t, l));
            if (int & i != 0) {
            }
            i16 = gr.f(i18 << 3);
            if (int & i != 0) {
            }
            i3 = gr.f(i18 << 3);
            int i70 = this.a[i7 + 2];
            l = i70 & i20;
            i = i9 << i71;
            if (l != i5) {
            }
            int = unsafe.getInt(t, (long)l);
            i5 = l;
        }
        com.google.android.gms.internal.firebase-auth-api.y0 y0Var = this.m;
        if (this.f) {
        } else {
            return i17 += i19;
        }
        this.n.a(t);
        throw 0;
    }

    private final int P(T t) {
        int i13;
        int z;
        int i11;
        int i3;
        int i10;
        int i8;
        int i14;
        int i2;
        int i15;
        int i6;
        int i16;
        int i17;
        int i5;
        int i9;
        int i7;
        int i12;
        int i4;
        long l;
        int i;
        Unsafe unsafe = c0.q;
        final int i18 = 0;
        i10 = i11;
        while (i11 < iArr.length) {
            int i20 = m(i11);
            i16 = c0.l(i20);
            i7 = this.a[i11];
            l = (long)i21;
            if (i16 >= rr.zzJ.zza() && i16 <= rr.zzW.zza()) {
            }
            i8 = 63;
            i11 += 3;
            if (D(t, i7, i11)) {
            }
            i8 = gr.F(i7, (y)j1.k(t, l), p(i11));
            i10 += i8;
            if (D(t, i7, i11)) {
            }
            l = c0.n(t, l);
            i9 = gr.f(i7 << 3);
            i8 = gr.g(i65 ^= i);
            i9 += i8;
            i10 += i16;
            if (D(t, i7, i11)) {
            }
            int i23 = c0.Q(t, l);
            i9 = gr.f(i7 << 3);
            i8 = gr.f(i24 ^= i7);
            if (D(t, i7, i11)) {
            }
            i2 = gr.f(i7 << 3);
            i2 += 8;
            if (D(t, i7, i11)) {
            }
            i15 = gr.f(i7 << 3);
            i15 += 4;
            if (D(t, i7, i11)) {
            }
            i9 = gr.f(i7 << 3);
            i8 = gr.G(c0.Q(t, l));
            if (D(t, i7, i11)) {
            }
            i9 = gr.f(i7 << 3);
            i8 = gr.f(c0.Q(t, l));
            if (D(t, i7, i11)) {
            }
            i5 = gr.f(i7 << 3);
            i12 = gr.f((wq)j1.k(t, l).g());
            i5 += i7;
            if (D(t, i7, i11)) {
            }
            i8 = n0.Q(i7, j1.k(t, l), p(i11));
            if (D(t, i7, i11)) {
            }
            Object obj2 = j1.k(t, l);
            if (obj2 instanceof wq) {
            } else {
            }
            i9 = gr.f(i7 << 3);
            i8 = gr.d((String)obj2);
            i5 = gr.f(i7 << 3);
            i12 = gr.f((wq)obj2.g());
            if (D(t, i7, i11)) {
            }
            i6 = gr.f(i7 << 3);
            i6++;
            if (D(t, i7, i11)) {
            }
            i15 = gr.f(i7 << 3);
            if (D(t, i7, i11)) {
            }
            i2 = gr.f(i7 << 3);
            if (D(t, i7, i11)) {
            }
            i9 = gr.f(i7 << 3);
            i8 = gr.G(c0.Q(t, l));
            if (D(t, i7, i11)) {
            }
            i4 = gr.f(i7 <<= 3);
            i8 = gr.g(c0.n(t, l));
            i10 += i7;
            if (D(t, i7, i11)) {
            }
            i4 = gr.f(i7 <<= 3);
            i8 = gr.g(c0.n(t, l));
            if (D(t, i7, i11)) {
            }
            i15 = gr.f(i7 << 3);
            if (D(t, i7, i11)) {
            }
            i2 = gr.f(i7 << 3);
            t.a(i7, j1.k(t, l), r(i11));
            i8 = n0.L(i7, (List)j1.k(t, l), p(i11));
            i8 = n0.V((List)unsafe.getObject(t, l));
            if (i8 > 0) {
            }
            i17 = gr.e(i7);
            i7 = gr.f(i8);
            i17 += i7;
            i8 = n0.T((List)unsafe.getObject(t, l));
            if (i8 > 0) {
            }
            i17 = gr.e(i7);
            i7 = gr.f(i8);
            i8 = n0.K((List)unsafe.getObject(t, l));
            if (i8 > 0) {
            }
            i17 = gr.e(i7);
            i7 = gr.f(i8);
            i8 = n0.I((List)unsafe.getObject(t, l));
            if (i8 > 0) {
            }
            i17 = gr.e(i7);
            i7 = gr.f(i8);
            i8 = n0.G((List)unsafe.getObject(t, l));
            if (i8 > 0) {
            }
            i17 = gr.e(i7);
            i7 = gr.f(i8);
            i8 = n0.Y((List)unsafe.getObject(t, l));
            if (i8 > 0) {
            }
            i17 = gr.e(i7);
            i7 = gr.f(i8);
            i8 = n0.D((List)unsafe.getObject(t, l));
            if (i8 > 0) {
            }
            i17 = gr.e(i7);
            i7 = gr.f(i8);
            i8 = n0.I((List)unsafe.getObject(t, l));
            if (i8 > 0) {
            }
            i17 = gr.e(i7);
            i7 = gr.f(i8);
            i8 = n0.K((List)unsafe.getObject(t, l));
            if (i8 > 0) {
            }
            i17 = gr.e(i7);
            i7 = gr.f(i8);
            i8 = n0.N((List)unsafe.getObject(t, l));
            if (i8 > 0) {
            }
            i17 = gr.e(i7);
            i7 = gr.f(i8);
            i8 = n0.a0((List)unsafe.getObject(t, l));
            if (i8 > 0) {
            }
            i17 = gr.e(i7);
            i7 = gr.f(i8);
            i8 = n0.P((List)unsafe.getObject(t, l));
            if (i8 > 0) {
            }
            i17 = gr.e(i7);
            i7 = gr.f(i8);
            i8 = n0.I((List)unsafe.getObject(t, l));
            if (i8 > 0) {
            }
            i17 = gr.e(i7);
            i7 = gr.f(i8);
            i8 = n0.K((List)unsafe.getObject(t, l));
            if (i8 > 0) {
            }
            i17 = gr.e(i7);
            i7 = gr.f(i8);
            i8 = n0.U(i7, (List)j1.k(t, l), i18);
            i8 = n0.S(i7, (List)j1.k(t, l), i18);
            i8 = n0.J(i7, (List)j1.k(t, l), i18);
            i8 = n0.H(i7, (List)j1.k(t, l), i18);
            i8 = n0.F(i7, (List)j1.k(t, l), i18);
            i8 = n0.X(i7, (List)j1.k(t, l), i18);
            i8 = n0.E(i7, (List)j1.k(t, l));
            i8 = n0.R(i7, (List)j1.k(t, l), p(i11));
            i8 = n0.W(i7, (List)j1.k(t, l));
            i8 = n0.A(i7, (List)j1.k(t, l), i18);
            i8 = n0.H(i7, (List)j1.k(t, l), i18);
            i8 = n0.J(i7, (List)j1.k(t, l), i18);
            i8 = n0.M(i7, (List)j1.k(t, l), i18);
            i8 = n0.Z(i7, (List)j1.k(t, l), i18);
            i8 = n0.O(i7, (List)j1.k(t, l), i18);
            i8 = n0.H(i7, (List)j1.k(t, l), i18);
            i8 = n0.J(i7, (List)j1.k(t, l), i18);
            if (A(t, i11)) {
            }
            i8 = gr.F(i7, (y)j1.k(t, l), p(i11));
            if (A(t, i11)) {
            }
            l = j1.i(t, l);
            i9 = gr.f(i7 << 3);
            i8 = gr.g(i66 ^= i);
            if (A(t, i11)) {
            }
            int i28 = j1.h(t, l);
            i9 = gr.f(i7 << 3);
            i8 = gr.f(i29 ^= i7);
            if (A(t, i11)) {
            }
            i2 = gr.f(i7 << 3);
            if (A(t, i11)) {
            }
            i15 = gr.f(i7 << 3);
            if (A(t, i11)) {
            }
            i9 = gr.f(i7 << 3);
            i8 = gr.G(j1.h(t, l));
            if (A(t, i11)) {
            }
            i9 = gr.f(i7 << 3);
            i8 = gr.f(j1.h(t, l));
            if (A(t, i11)) {
            }
            i5 = gr.f(i7 << 3);
            i12 = gr.f((wq)j1.k(t, l).g());
            if (A(t, i11)) {
            }
            i8 = n0.Q(i7, j1.k(t, l), p(i11));
            if (A(t, i11)) {
            }
            Object obj3 = j1.k(t, l);
            if (obj3 instanceof wq) {
            } else {
            }
            i9 = gr.f(i7 << 3);
            i8 = gr.d((String)obj3);
            i5 = gr.f(i7 << 3);
            i12 = gr.f((wq)obj3.g());
            if (A(t, i11)) {
            }
            i6 = gr.f(i7 << 3);
            if (A(t, i11)) {
            }
            i15 = gr.f(i7 << 3);
            if (A(t, i11)) {
            }
            i2 = gr.f(i7 << 3);
            if (A(t, i11)) {
            }
            i9 = gr.f(i7 << 3);
            i8 = gr.G(j1.h(t, l));
            if (A(t, i11)) {
            }
            i4 = gr.f(i7 <<= 3);
            i8 = gr.g(j1.i(t, l));
            if (A(t, i11)) {
            }
            i4 = gr.f(i7 <<= 3);
            i8 = gr.g(j1.i(t, l));
            if (A(t, i11)) {
            }
            i15 = gr.f(i7 << 3);
            if (A(t, i11)) {
            }
            i2 = gr.f(i7 << 3);
            if (i16 <= rr.zzW.zza()) {
            }
            i14 = this.a[i11 + 2];
        }
        com.google.android.gms.internal.firebase-auth-api.y0 y0Var = this.m;
        return i10 += obj12;
    }

    private static <T> int Q(T t, long l2) {
        return (Integer)j1.k(t, l2).intValue();
    }

    private final <K, V> int R(T t, byte[] b2Arr2, int i3, int i4, int i5, long l6, com.google.android.gms.internal.firebase-auth-api.mq mq7) {
        boolean obj5;
        final Unsafe obj2 = c0.q;
        final Object obj3 = r(i5);
        final Object obj4 = obj2.getObject(t, l6);
        if (!t.b(obj4)) {
        } else {
            obj5 = s.a().c();
            t.c(obj5, obj4);
            obj2.putObject(t, l6, mq7);
        }
        throw 0;
    }

    private final int S(T t, byte[] b2Arr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long l10, int i11, com.google.android.gms.internal.firebase-auth-api.mq mq12) {
        com.google.android.gms.internal.firebase-auth-api.a1 obj;
        int i2;
        int valueOf;
        int str;
        Long valueOf2;
        boolean string;
        int i10;
        int i12;
        int i14;
        int i13;
        int object;
        final Object obj2 = this;
        obj = t;
        str = b2Arr2;
        valueOf2 = i3;
        valueOf = i5;
        final int i37 = i6;
        string = i7;
        final long l8 = l10;
        i12 = mq12;
        final Object obj6 = obj29;
        final Unsafe unsafe = c0.q;
        long l9 = (long)i36;
        i14 = 5;
        object = 2;
        switch (i9) {
            case 51:
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return valueOf2 + 8;
                i2 = valueOf2;
                break;
            case 52:
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return valueOf2 + 4;
                i2 = valueOf2;
                break;
            case 53:
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return nq.m(str, valueOf2, obj6);
                i2 = valueOf2;
                break;
            case 54:
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return nq.j(str, valueOf2, obj6);
                i2 = valueOf2;
                break;
            case 55:
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return valueOf2 + 8;
                i2 = valueOf2;
                break;
            case 56:
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return valueOf2 + 4;
                i2 = valueOf2;
                break;
            case 57:
                i13 = 1;
                i13 = 0;
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return nq.m(str, valueOf2, obj6);
                i2 = valueOf2;
                break;
            case 58:
                i2 = nq.j(str, valueOf2, obj6);
                valueOf2 = obj6.a;
                unsafe.putObject(obj, l8, obj10);
                throw zzaae.d();
                string = new String(str, i2, valueOf2, e.a);
                unsafe.putObject(obj, l8, obj10);
                i2 += valueOf2;
                unsafe.putInt(obj, l9, obj14);
                i2 = valueOf2;
                break;
            case 59:
                i2 = nq.d(obj2.p(i12), str, valueOf2, i4, obj6);
                object = unsafe.getObject(obj, l8);
                object = 0;
                unsafe.putObject(obj, l8, obj10);
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                i2 = valueOf2;
                break;
            case 60:
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return nq.a(str, valueOf2, obj6);
                i2 = valueOf2;
                break;
            case 61:
                valueOf2 = obj6.a;
                string = obj2.o(i12);
                string = string.zza();
                c0.J(t).h(valueOf, Long.valueOf((long)valueOf2));
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                i2 = str;
                i2 = valueOf2;
                break;
            case 62:
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return nq.j(str, valueOf2, obj6);
                i2 = valueOf2;
                break;
            case 63:
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return nq.m(str, valueOf2, obj6);
                i2 = valueOf2;
                break;
            case 64:
                i2 = nq.c(obj2.p(i12), b2Arr2, i3, i4, i26 | 4, obj29);
                object = unsafe.getObject(obj, l8);
                object = 0;
                unsafe.putObject(obj, l8, obj10);
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                i2 = valueOf2;
                break;
            default:
                i2 = valueOf2;
        }
        return i2;
    }

    private final int T(T t, byte[] b2Arr2, int i3, int i4, com.google.android.gms.internal.firebase-auth-api.mq mq5) {
        int i15;
        byte b;
        Object object;
        int cmp;
        int i9;
        int i21;
        int i22;
        int z;
        int i6;
        int i12;
        int i2;
        byte[] bArr2;
        int i14;
        int i13;
        com.google.android.gms.internal.firebase-auth-api.a1 a1Var;
        com.google.android.gms.internal.firebase-auth-api.mq mqVar2;
        int int;
        int i20;
        Unsafe unsafe;
        int i24;
        Unsafe unsafe2;
        int i25;
        com.google.android.gms.internal.firebase-auth-api.mq mqVar;
        byte[] bArr;
        int i;
        Object obj2;
        Object obj;
        byte b2;
        int i16;
        int i19;
        int i11;
        int i7;
        int i23;
        int i5;
        int i17;
        int i18;
        int i8;
        long l;
        Unsafe unsafe3;
        int i10;
        int obj33;
        obj = this;
        obj2 = t;
        bArr = b2Arr2;
        i = i4;
        mqVar = mq5;
        unsafe2 = c0.q;
        final int i48 = 0;
        i15 = i3;
        i20 = i24;
        cmp = i25;
        int = i6;
        while (i15 < i) {
            i13 = i15 + 1;
            b = bArr[i15];
            if (b < 0) {
            } else {
            }
            b2 = b;
            a1Var = i13;
            mqVar2 = b2 >>> 3;
            i14 = b2 & 7;
            if (mqVar2 > cmp) {
            } else {
            }
            i15 = obj.V(mqVar2);
            i2 = i15;
            i21 = obj.a[i2 + 1];
            i15 = c0.l(i21);
            i19 = unsafe2;
            i24 = (long)i43;
            obj33 = mqVar2;
            i11 = obj33;
            i17 = i21;
            i = i2;
            i25 = i19;
            obj33 = i14;
            obj = a1Var;
            i18 = int;
            i8 = i20;
            l = i24;
            unsafe3 = i25;
            i19 = i;
            i16 = -1;
            unsafe2 = i17;
            if (this.S(t, b2Arr2, obj, i4, b2, i11, obj33, i17, unsafe2, l, mqVar, i19) != obj) {
            } else {
            }
            i12 = i15;
            int = i18;
            i20 = i8;
            i15 = nq.i(b2, b2Arr2, i12, i4, c0.J(t), mq5);
            obj = this;
            obj2 = t;
            bArr = b2Arr2;
            i = i4;
            mqVar = mq5;
            i25 = i16;
            i6 = i19;
            cmp = i11;
            unsafe2 = unsafe3;
            i24 = 1048575;
            obj = this;
            obj2 = t;
            bArr = b2Arr2;
            i = i4;
            mqVar = mq5;
            i25 = i16;
            i6 = i19;
            cmp = i11;
            int = i18;
            i20 = i8;
            i20 = obj33;
            i12 = obj;
            i18 = int;
            i8 = i20;
            int i42 = i19;
            unsafe3 = i25;
            i16 = -1;
            i19 = i;
            if (this.U(t, b2Arr2, a1Var, i4, b2, i11, i14, i, (long)i37, i25, i15, i24) != a1Var) {
            } else {
            }
            if (i14 == 2) {
            } else {
            }
            obj = a1Var;
            i18 = int;
            i8 = i20;
            unsafe3 = i25;
            i19 = i;
            i16 = -1;
            object = i25.getObject(obj2, i24);
            if (!(d)object.zzc()) {
            }
            i15 = nq.e(obj.p(i), b2, b2Arr2, a1Var, i4, object, mq5);
            int = i24;
            unsafe2 = i25;
            i6 = i;
            i24 = i19;
            cmp = i11;
            i25 = -1;
            i = i4;
            int size = object.size();
            if (size == 0) {
            } else {
            }
            size += size;
            i25.putObject(obj2, i24, unsafe2);
            z = 10;
            int i45 = obj.a[i2 + 2];
            mqVar2 = 1;
            i23 = mqVar2 << i50;
            int i47 = 1048575;
            i45 &= i47;
            if (i46 != i20) {
            } else {
            }
            i17 = i21;
            i7 = i2;
            i25 = i19;
            cmp = 5;
            i19 = i47;
            i = i7;
            i11 = obj33;
            i12 = a1Var;
            unsafe3 = i25;
            i19 = i;
            i16 = -1;
            if (i14 == 0) {
            } else {
            }
            i = i7;
            i11 = obj33;
            i19 = 1048575;
            i11 = obj33;
            i25.putLong(t, i24, i14);
            int |= i23;
            unsafe2 = i25;
            i6 = i;
            i15 = b2;
            cmp = i11;
            i24 = 1048575;
            i = i7;
            i11 = obj33;
            if (i14 == 0) {
            } else {
            }
            i15 = nq.j(bArr, a1Var, mqVar);
            i25.putInt(obj2, i24, unsafe2);
            int |= i23;
            unsafe2 = i25;
            i6 = i;
            i = i7;
            i11 = obj33;
            if (i14 == 0) {
            } else {
            }
            i15 = nq.j(bArr, a1Var, mqVar);
            i25.putInt(obj2, i24, unsafe2);
            i = i7;
            i11 = obj33;
            if (i14 == 2) {
            } else {
            }
            i15 = nq.a(bArr, a1Var, mqVar);
            i25.putObject(obj2, i24, unsafe2);
            i11 = obj33;
            if (i14 == 2) {
            } else {
            }
            i2 = i4;
            i19 = 1048575;
            i15 = nq.d(obj.p(i7), bArr, a1Var, i4, mqVar);
            Object object2 = i25.getObject(obj2, i24);
            if (object2 == null) {
            } else {
            }
            i25.putObject(obj2, i24, unsafe2);
            int |= i23;
            unsafe2 = i25;
            i24 = i19;
            cmp = i11;
            i25 = -1;
            i = i2;
            i6 = i10;
            i25.putObject(obj2, i24, unsafe2);
            i2 = i4;
            i19 = i47;
            i = i7;
            i11 = obj33;
            if (i14 == 2) {
            } else {
            }
            if (i17 & i28 == 0) {
            } else {
            }
            i15 = nq.h(bArr, a1Var, mqVar);
            i25.putObject(obj2, i24, unsafe2);
            i15 = nq.g(bArr, a1Var, mqVar);
            i2 = i4;
            i19 = i47;
            i = i7;
            i11 = obj33;
            if (i14 == 0) {
            } else {
            }
            i15 = nq.m(bArr, a1Var, mqVar);
            if (Long.compare(i14, i5) != 0) {
            } else {
            }
            mqVar2 = i48;
            j1.r(obj2, i24, unsafe2);
            i2 = i4;
            i19 = i47;
            i = i7;
            i11 = obj33;
            if (i14 == cmp) {
            } else {
            }
            i25.putInt(obj2, i24, unsafe2);
            i15 = a1Var + 4;
            i2 = i4;
            i19 = i47;
            i = i7;
            i11 = obj33;
            if (i14 == mqVar2) {
            } else {
            }
            i25.putLong(t, i24, i14);
            i15 = i24 + 8;
            int |= i23;
            i19 = i47;
            i = i7;
            i11 = obj33;
            if (i14 == 0) {
            } else {
            }
            i15 = nq.j(bArr, a1Var, mqVar);
            i25.putInt(obj2, i24, unsafe2);
            i19 = i47;
            i11 = obj33;
            if (i14 == 0) {
            } else {
            }
            i25.putLong(t, i24, i14);
            int |= i23;
            unsafe2 = i25;
            i6 = i;
            i15 = b2;
            i19 = i47;
            i = i7;
            i11 = obj33;
            if (i14 == cmp) {
            } else {
            }
            j1.u(obj2, i24, unsafe2);
            i15 = a1Var + 4;
            i19 = i47;
            i = i7;
            i11 = obj33;
            if (i14 == mqVar2) {
            } else {
            }
            j1.t(obj2, i24, unsafe2);
            i15 = a1Var + 8;
            i17 = i21;
            i7 = i2;
            if (i20 != i47) {
            } else {
            }
            unsafe = i19;
            if (i46 != i47) {
            }
            i25 = unsafe;
            i20 = i10;
            int = unsafe.getInt(obj2, (long)i46);
            i19.putInt(obj2, (long)i20, i2);
            i12 = a1Var;
            i11 = mqVar2;
            unsafe3 = unsafe2;
            i16 = i25;
            i19 = i48;
            i15 = obj.W(mqVar2, i6 /= 3);
            a1Var = b;
            b2 = i13;
        }
        if (i20 != i24) {
            unsafe2.putInt(t, (long)i20, i6);
        }
        if (i15 != i4) {
        } else {
            return i15;
        }
        throw zzaae.g();
    }

    private final int U(T t, byte[] b2Arr2, int i3, int i4, int i5, int i6, int i7, int i8, long l9, int i10, long l11, com.google.android.gms.internal.firebase-auth-api.mq mq12) {
        int i15;
        Object obj3;
        int i2;
        int i9;
        int i12;
        int i21;
        float intBitsToFloat;
        int i20;
        int i17;
        byte[] bArr;
        com.google.android.gms.internal.firebase-auth-api.a1 zzc;
        int i13;
        int longBitsToDouble2;
        int i16;
        com.google.android.gms.internal.firebase-auth-api.wq i14;
        int i19;
        long l;
        int i;
        int str;
        int i11;
        Object obj;
        long l3;
        long l4;
        long l2;
        double longBitsToDouble;
        Object obj2;
        int string;
        long l5;
        int string2;
        java.nio.charset.Charset i18;
        Object object;
        boolean z;
        com.google.android.gms.internal.firebase-auth-api.l0 obj21;
        byte[] obj22;
        int obj23;
        int obj24;
        int obj25;
        com.google.android.gms.internal.firebase-auth-api.mq obj26;
        obj3 = t;
        bArr = b2Arr2;
        longBitsToDouble2 = i3;
        l = i4;
        i17 = i5;
        str = i7;
        string = i8;
        long l15 = mq12;
        obj = obj29;
        final Unsafe unsafe = c0.q;
        object = unsafe.getObject(obj3, l15);
        if (!(d)object.zzc()) {
            int size = object.size();
            z = size == 0 ? 10 : size + size;
            unsafe.putObject(obj3, l15, obj10);
        }
        string2 = 5;
        i18 = 0;
        int i46 = 1;
        final int i47 = 2;
        switch (l11) {
            case 18:
                i35 += i15;
                (ir)object.d(Double.longBitsToDouble(nq.n(bArr, i15)));
                i15 += 8;
                throw zzaae.i();
                (ir)object.d(Double.longBitsToDouble(nq.n(b2Arr2, i3)));
                obj3 = longBitsToDouble2 + 8;
                object.d(Double.longBitsToDouble(nq.n(bArr, nq.j(bArr, obj3, obj))));
                return obj3;
                return i15;
            case 19:
                i36 += i15;
                (sr)object.d(Float.intBitsToFloat(nq.b(bArr, i15)));
                i15 += 4;
                throw zzaae.i();
                (sr)object.d(Float.intBitsToFloat(nq.b(b2Arr2, i3)));
                int i26 = longBitsToDouble2 + 4;
                object.d(Float.intBitsToFloat(nq.b(bArr, nq.j(bArr, i26, obj))));
                return i26;
                return i15;
            case 20:
                i37 += i15;
                i15 = nq.m(bArr, i15, obj);
                (n)object.g(obj.b);
                throw zzaae.i();
                i20 = nq.m(bArr, longBitsToDouble2, obj);
                (n)object.g(obj.b);
                i20 = nq.m(bArr, nq.j(bArr, i20, obj), obj);
                object.g(obj.b);
                return i20;
                return i15;
            case 21:
                i15 = nq.f(bArr, longBitsToDouble2, object, obj);
                return nq.l(i5, b2Arr2, i3, i4, object, obj29);
                return i15;
            case 22:
                i30 += i15;
                (n)object.g(nq.n(bArr, i15));
                i15 += 8;
                throw zzaae.i();
                (n)object.g(nq.n(b2Arr2, i3));
                obj3 = longBitsToDouble2 + 8;
                object.g(nq.n(bArr, nq.j(bArr, obj3, obj)));
                return obj3;
                return i15;
            case 23:
                i32 += i15;
                (yr)object.g(nq.b(bArr, i15));
                i15 += 4;
                throw zzaae.i();
                (yr)object.g(nq.b(b2Arr2, i3));
                int i24 = longBitsToDouble2 + 4;
                object.g(nq.b(bArr, nq.j(bArr, i24, obj)));
                return i24;
                return i15;
            case 24:
                obj3 = 0;
                i38 += i17;
                i17 = nq.m(bArr, i17, obj);
                l = i46;
                l = obj3;
                (oq)object.d(l);
                i15 = i17;
                throw zzaae.i();
                i13 = nq.m(bArr, longBitsToDouble2, obj);
                i = i46;
                i = obj3;
                (oq)object.d(i);
                i13 = nq.m(bArr, nq.j(bArr, i13, obj), obj);
                i = i46;
                i = obj3;
                object.d(i);
                return i13;
                return i15;
            case 25:
                str = "";
                longBitsToDouble2 = obj.a;
                object.add(str);
                string = new String(bArr, nq.j(bArr, longBitsToDouble2, obj), longBitsToDouble2, e.a);
                object.add(string);
                i15 += longBitsToDouble2;
                longBitsToDouble2 = obj.a;
                object.add(str);
                string = new String(bArr, nq.j(bArr, nq.j(bArr, i15, obj), obj), longBitsToDouble2, e.a);
                object.add(string);
                throw zzaae.f();
                throw zzaae.f();
                i15 = nq.j(bArr, longBitsToDouble2, obj);
                longBitsToDouble2 = obj.a;
                object.add(str);
                string2 = new String(bArr, i15, longBitsToDouble2, e.a);
                object.add(string2);
                i15 = string;
                i15 = nq.j(bArr, nq.j(bArr, i15, obj), obj);
                longBitsToDouble2 = obj.a;
                object.add(str);
                string2 = new String(bArr, i15, longBitsToDouble2, e.a);
                object.add(string2);
                throw zzaae.d();
                throw zzaae.f();
                throw zzaae.d();
                throw zzaae.f();
                return i15;
            case 26:
                return nq.e(p(string), i5, b2Arr2, i3, i4, object, obj29);
            case 27:
                i21 = nq.j(bArr, longBitsToDouble2, obj);
                i14 = obj.a;
                object.add(wq.a);
                object.add(wq.w(bArr, i21, i14));
                i21 += i14;
                i21 = nq.j(bArr, nq.j(bArr, i21, obj), obj);
                i14 = obj.a;
                object.add(wq.a);
                object.add(wq.w(bArr, i21, i14));
                throw zzaae.i();
                throw zzaae.f();
                return i21;
                throw zzaae.i();
                throw zzaae.f();
            case 28:
                i17 = nq.f(bArr, longBitsToDouble2, object, obj);
                i17 = nq.l(i5, b2Arr2, i3, i4, object, obj29);
                zzc = 0;
                bArr = n0.c(i6, object, o(string), zzc, obj4.m);
                obj3.zzc = (a1)bArr;
                return i17;
                i15 = i17;
                return i15;
            case 29:
                i33 += i15;
                i15 = nq.j(bArr, i15, obj);
                (yr)object.g(zq.l(obj.a));
                throw zzaae.i();
                i9 = nq.j(bArr, longBitsToDouble2, obj);
                (yr)object.g(zq.l(obj.a));
                i9 = nq.j(bArr, nq.j(bArr, i9, obj), obj);
                object.g(zq.l(obj.a));
                return i9;
                return i15;
            case 30:
                i34 += i15;
                i15 = nq.m(bArr, i15, obj);
                (n)object.g(zq.m(obj.b));
                throw zzaae.i();
                i12 = nq.m(bArr, longBitsToDouble2, obj);
                (n)object.g(zq.m(obj.b));
                i12 = nq.m(bArr, nq.j(bArr, i12, obj), obj);
                object.g(zq.m(obj.b));
                return i12;
                return i15;
            default:
                com.google.android.gms.internal.firebase-auth-api.l0 l0Var = p(string);
                i43 |= 4;
                i19 = nq.c(l0Var, b2Arr2, i3, i4, i44, obj29);
                object.add(obj.c);
                i19 = nq.c(l0Var, b2Arr2, nq.j(bArr, i19, obj), i4, i44, obj29);
                object.add(obj.c);
                return i19;
        }
        i15 = longBitsToDouble2;
    }

    private final int V(int i) {
        int i2;
        if (i >= this.c && i <= this.d) {
            if (i <= this.d) {
                return k(i, 0);
            }
        }
        return -1;
    }

    private final int W(int i, int i2) {
        int i3;
        if (i >= this.c && i <= this.d) {
            if (i <= this.d) {
                return k(i, i2);
            }
        }
        return -1;
    }

    private final int X(int i) {
        return this.a[i += 2];
    }

    private final int k(int i, int i2) {
        int i5;
        int i6;
        int i4;
        int i3;
        int obj7;
        final int i8 = -1;
        i7 += i8;
        while (obj7 <= i5) {
            i9 >>>= 1;
            i4 = i10 * 3;
            i3 = this.a[i4];
            if (i < i3) {
            } else {
            }
            obj7 = i6;
            i5 = i6;
        }
        return i8;
    }

    private static int l(int i) {
        return obj0 &= 255;
    }

    private final int m(int i) {
        return this.a[i++];
    }

    private static <T> long n(T t, long l2) {
        return (Long)j1.k(t, l2).longValue();
    }

    private final com.google.android.gms.internal.firebase-auth-api.c o(int i) {
        i /= 3;
        return (c)this.b[obj2++];
    }

    private final com.google.android.gms.internal.firebase-auth-api.l0 p(int i) {
        i /= 3;
        obj4 += obj4;
        Object obj = this.b[obj4];
        if ((l0)obj != null) {
            return (l0)obj;
        }
        com.google.android.gms.internal.firebase-auth-api.l0 l0Var = h0.a().b((Class)this.b[obj4 + 1]);
        this.b[obj4] = l0Var;
        return l0Var;
    }

    private final <UT, UB> UB q(Object object, int i2, UB ub3, com.google.android.gms.internal.firebase-auth-api.y0<UT, UB> y04) {
        int obj6 = this.a[i2];
        if (j1.k(object, (long)obj6) == null) {
            return ub3;
        }
        if (o(i2) != null) {
        } else {
            return ub3;
        }
        Object obj3 = r(i2);
        throw 0;
    }

    private final Object r(int i) {
        i /= 3;
        return this.b[obj2 += obj2];
    }

    private static Field s(Class<?> class, String string2) {
        int runtimeException;
        int str;
        try {
            return class.getDeclaredField(string2);
            Field[] string = class.getDeclaredFields();
            runtimeException = string.length;
            str = 0;
            Field length = string[str];
            String length2 = length.getName();
            length2 = string2.equals(length2);
        }
        class = class.getName();
        string = Arrays.toString(string);
        str = String.valueOf(string2);
        str = str.length();
        length = String.valueOf(class);
        length = length.length();
        length2 = String.valueOf(string);
        length2 = length2.length();
        str += 40;
        str += length;
        str += length2;
        StringBuilder stringBuilder = new StringBuilder(str);
        str = "Field ";
        stringBuilder.append(str);
        stringBuilder.append(string2);
        string2 = " for ";
        stringBuilder.append(string2);
        stringBuilder.append(class);
        class = " not found. Known fields are ";
        stringBuilder.append(class);
        stringBuilder.append(string);
        class = stringBuilder.toString();
        runtimeException = new RuntimeException(class);
        throw runtimeException;
    }

    private final void t(T t, T t2, int i3) {
        final int i4 = 1048575;
        long l = (long)i2;
        if (!A(t2, i3)) {
        }
        Object obj = j1.k(t, l);
        Object obj5 = j1.k(t2, l);
        if (obj != null && obj5 == null) {
            if (obj5 == null) {
            }
            j1.x(t, l, i4);
            w(t, i3);
        }
        if (obj5 != null) {
            j1.x(t, l, i4);
            w(t, i3);
        }
    }

    private final void u(T t, T t2, int i3) {
        Object obj;
        int i4 = this.a[i3];
        long l = (long)i2;
        if (!D(t2, i4, i3)) {
        }
        if (D(t, i4, i3)) {
            obj = j1.k(t, l);
        } else {
            obj = 0;
        }
        Object obj6 = j1.k(t2, l);
        if (obj != null && obj6 == null) {
            if (obj6 == null) {
            }
            j1.x(t, l, obj3);
            x(t, i4, i3);
        }
        if (obj6 != null) {
            j1.x(t, l, obj3);
            x(t, i4, i3);
        }
    }

    private final void v(Object object, int i2, com.google.android.gms.internal.firebase-auth-api.k0 k03) {
        final int i = 1048575;
        if (c0.z(i2)) {
            j1.x(object, (long)obj4, i);
        }
        if (this.g) {
            j1.x(object, (long)obj4, i);
        }
        j1.x(object, (long)obj4, i);
    }

    private final void w(T t, int i2) {
        int obj6 = X(i2);
        long l = (long)i3;
        if (Long.compare(l, i4) == 0) {
        }
        j1.v(t, l, obj1);
    }

    private final void x(T t, int i2, int i3) {
        j1.v(t, (long)obj5, obj1);
    }

    private final boolean y(T t, T t2, int i3) {
        if (A(t, i3) == A(t2, i3)) {
            return 1;
        }
        return 0;
    }

    private static boolean z(int i) {
        if (i &= i2 != 0) {
            return 1;
        }
        return 0;
    }

    final int I(T t, byte[] b2Arr2, int i3, int i4, int i5, com.google.android.gms.internal.firebase-auth-api.mq mq6) {
        int i24;
        Unsafe unsafe3;
        Object object;
        boolean z2;
        int i9;
        byte valueOf;
        boolean z;
        byte[] bArr2;
        int i21;
        int i;
        int i17;
        Object obj5;
        byte[] bArr3;
        int i10;
        int i2;
        int i16;
        Object obj2;
        long l2;
        int int;
        com.google.android.gms.internal.firebase-auth-api.mq mqVar2;
        int i6;
        int i13;
        int i23;
        byte b2;
        Object mqVar;
        Object obj6;
        Unsafe unsafe;
        Object obj3;
        byte b;
        int i15;
        byte[] bArr;
        Object obj7;
        Object obj9;
        Object obj4;
        Object obj8;
        Object obj;
        int i18;
        int i11;
        int i7;
        int i14;
        int i19;
        int i20;
        long l;
        int i12;
        int i22;
        Unsafe unsafe2;
        int i8;
        int obj31;
        obj = this;
        obj8 = t;
        bArr = b2Arr2;
        obj4 = i4;
        b = i5;
        mqVar = mq6;
        unsafe = c0.q;
        final int i54 = 0;
        i24 = i3;
        int = i10;
        i21 = -1;
        i6 = 1048575;
        while (i24 < obj4) {
            int i36 = i24 + 1;
            byte b3 = bArr[i24];
            if (b3 < 0) {
            } else {
            }
            valueOf = b3;
            i24 = i8;
            int i49 = valueOf >>> 3;
            b2 = valueOf & 7;
            if (i49 > i21) {
            } else {
            }
            i21 = obj.V(i49);
            i16 = -1;
            i16 = obj.a[i21 + 1];
            l2 = c0.l(i16);
            byte b6 = valueOf;
            i20 = i24;
            l = l3;
            b = b6;
            bArr = l;
            i18 = -1;
            i19 = i49;
            i23 = i21;
            int i42 = i20;
            i22 = i6;
            i6 = i42;
            obj = i6;
            i14 = i23;
            unsafe2 = unsafe;
            i19 = b;
            mqVar = obj31;
            obj8 = 0;
            i24 = this.S(t, b2Arr2, obj, i4, i19, i19, b2, i16, mqVar, bArr, b, i14);
            i23 = i5;
            i21 = i24;
            b2 = i19;
            i6 = i22;
            Object obj17 = this;
            obj9 = t;
            obj3 = mq6;
            i15 = i12;
            i24 = nq.i(b2, b2Arr2, i21, i4, c0.J(t), mq6);
            obj4 = i4;
            i9 = b2;
            obj = obj17;
            mqVar = obj3;
            i21 = i15;
            obj8 = obj9;
            int = i7;
            i10 = i14;
            unsafe = unsafe2;
            bArr = b2Arr2;
            b = i23;
            obj3 = mq6;
            obj9 = t;
            i24 = nq.i(b2, b2Arr2, i21, i4, c0.J(t), mq6);
            obj9 = t;
            obj = this;
            obj8 = t;
            bArr = b2Arr2;
            obj4 = i4;
            b = i5;
            mqVar = mq6;
            int = i7;
            i10 = i14;
            i9 = i19;
            i21 = i12;
            i6 = i22;
            unsafe = unsafe2;
            i23 = i5;
            i21 = obj;
            b2 = i19;
            i6 = i22;
            obj8 = 0;
            int i53 = 0;
            i12 = i19;
            unsafe2 = unsafe;
            i19 = b;
            i24 = this.U(t, b2Arr2, i6, i4, b, i19, b2, i23, (long)i16, unsafe, l2, bArr);
            i23 = i5;
            i21 = i24;
            i7 = int;
            i22 = i6;
            obj = i42;
            i14 = i23;
            unsafe2 = unsafe;
            i12 = i19;
            i19 = b;
            object = unsafe.getObject(obj8, bArr);
            if (!(d)object.zzc()) {
            }
            i22 = i6;
            i24 = nq.e(obj.p(i23), b, b2Arr2, i42, i4, object, mq6);
            bArr = b2Arr2;
            obj4 = i4;
            i10 = i23;
            int = i7;
            i21 = i19;
            i6 = i22;
            b = i5;
            int size = object.size();
            if (size == 0) {
            } else {
            }
            size += size;
            unsafe.putObject(obj8, bArr, obj4);
            z = 10;
            int i26 = obj.a[i21 + 2];
            i12 = valueOf << i57;
            int i51 = 1048575;
            i26 &= i51;
            if (i27 != i6) {
            } else {
            }
            i11 = i21;
            i22 = i6;
            i13 = int;
            i24 = 5;
            b = b6;
            i18 = -1;
            i7 = i13;
            i14 = i23;
            unsafe2 = unsafe;
            b2 = b;
            i12 = i19;
            i6 = i22;
            obj8 = 0;
            i23 = i5;
            long l10 = l2;
            i24 = nq.c(obj.p(i11), b2Arr2, i20, i4, i40 | 4, mq6);
            if (i13 & i12 == 0) {
            } else {
            }
            unsafe.putObject(obj8, l10, obj4);
            int = i13 | i12;
            bArr = b2Arr2;
            obj4 = i4;
            i10 = i23;
            i9 = b;
            unsafe.putObject(obj8, l10, obj4);
            b = b6;
            i19 = i49;
            i23 = i11;
            i18 = -1;
            i21 = i20;
            int i39 = i20;
            b2 = nq.m(bArr, i39, mqVar);
            b = b6;
            i19 = i49;
            i23 = i11;
            i18 = -1;
            unsafe.putLong(t, l, i16);
            int = i13 | i12;
            i10 = i23;
            i24 = b2;
            b = b6;
            i19 = i49;
            i23 = i11;
            i18 = -1;
            i21 = valueOf;
            i24 = nq.j(bArr, i20, mqVar);
            unsafe.putInt(obj8, l, i16);
            int = i13 | i12;
            i19 = i49;
            i18 = -1;
            i24 = nq.j(bArr, i20, mqVar);
            valueOf = mqVar.a;
            l2 = obj.o(i11);
            if (l2 != null) {
            } else {
            }
            unsafe.putInt(obj8, l, i16);
            l2 = l2.zza();
            if (l2) {
            } else {
            }
            c0.J(t).h(b6, Long.valueOf((long)valueOf));
            int = i13;
            b = b6;
            i19 = i49;
            i23 = i11;
            i18 = -1;
            i24 = nq.a(bArr, i20, mqVar);
            unsafe.putObject(obj8, l, i16);
            b = b6;
            i21 = l;
            i19 = i49;
            i18 = -1;
            i24 = nq.d(obj.p(i11), bArr, i20, obj4, mqVar);
            if (i13 & i12 == 0) {
            } else {
            }
            unsafe.putObject(obj8, i21, i16);
            unsafe.putObject(obj8, i21, i16);
            b = b6;
            valueOf = i20;
            i19 = i49;
            i23 = i11;
            i18 = -1;
            if (i30 &= i16 == 0) {
            } else {
            }
            i24 = nq.h(bArr, valueOf, mqVar);
            unsafe.putObject(obj8, l, int);
            i24 = nq.g(bArr, valueOf, mqVar);
            b = b6;
            i19 = i49;
            i23 = i11;
            i18 = -1;
            i24 = nq.m(bArr, i20, mqVar);
            if (Long.compare(l6, i20) != 0) {
            } else {
            }
            valueOf = i54;
            j1.r(obj8, l, int);
            valueOf = 1;
            b = b6;
            valueOf = i20;
            i19 = i49;
            i23 = i11;
            i18 = -1;
            unsafe.putInt(obj8, l, int);
            i24 = valueOf + 4;
            b = b6;
            valueOf = i20;
            i19 = i49;
            i23 = i11;
            i18 = -1;
            unsafe.putLong(t, l, i16);
            i24 = b2 + 8;
            b = b6;
            i19 = i49;
            i23 = i11;
            i18 = -1;
            i24 = nq.j(bArr, i20, mqVar);
            unsafe.putInt(obj8, l, int);
            b = b6;
            i19 = i49;
            i23 = i11;
            i18 = -1;
            b2 = nq.m(bArr, i20, mqVar);
            unsafe.putLong(t, l, i16);
            b = b6;
            i21 = i20;
            i19 = i49;
            i23 = i11;
            i18 = -1;
            j1.u(obj8, l, int);
            i24 = i21 + 4;
            b = b6;
            i21 = i20;
            i19 = i49;
            i23 = i11;
            i18 = -1;
            j1.t(obj8, l, int);
            i24 = i21 + 8;
            i11 = i21;
            if (i6 != i51) {
            }
            int = unsafe.getInt(obj8, (long)i27);
            i22 = i27;
            unsafe.putInt(obj8, (long)i6, i21);
            i21 = i24;
            b2 = valueOf;
            i18 = i16;
            i7 = int;
            i12 = i49;
            unsafe2 = unsafe;
            i23 = b;
            i14 = i54;
            i21 = obj.W(i49, i10 /= l2);
            i24 = nq.k(b3, bArr, i36, mqVar);
            valueOf = mqVar.a;
        }
        i7 = int;
        i22 = i6;
        unsafe2 = unsafe;
        i23 = b;
        obj7 = obj8;
        obj6 = obj;
        i2 = 0;
        if (i6 != 1048575) {
            unsafe2.putInt(obj7, (long)i6, b);
        }
        i17 = obj6.j;
        while (i17 < obj6.k) {
            obj6.q(obj7, obj6.i[i17], i2, obj6.m);
            i17++;
        }
        if (i23 == 0) {
            if (i24 != i4) {
            } else {
                return i24;
            }
            throw zzaae.g();
        }
        if (i24 > i4) {
        } else {
            if (i9 != i23) {
            } else {
            }
        }
        throw zzaae.g();
    }

    public final T a() {
        final int i2 = 0;
        return (xr)this.e.q(4, i2, i2);
    }

    public final int b(T t) {
        int length;
        int i5;
        int i3;
        int i4;
        boolean floatToIntBits;
        int i2;
        long l;
        int i;
        i3 = i5;
        while (i5 < iArr.length) {
            int i11 = m(i5);
            i2 = this.a[i5];
            l = (long)i13;
            i = 37;
            i5 += 3;
            if (D(t, i2, i5)) {
            }
            i3 *= 53;
            floatToIntBits = j1.k(t, l).hashCode();
            i4 += floatToIntBits;
            if (D(t, i2, i5)) {
            }
            i3 *= 53;
            floatToIntBits = e.c(c0.n(t, l));
            if (D(t, i2, i5)) {
            }
            i3 *= 53;
            floatToIntBits = c0.Q(t, l);
            if (D(t, i2, i5)) {
            }
            i3 *= 53;
            floatToIntBits = e.c(c0.n(t, l));
            if (D(t, i2, i5)) {
            }
            i3 *= 53;
            floatToIntBits = c0.Q(t, l);
            if (D(t, i2, i5)) {
            }
            i3 *= 53;
            floatToIntBits = c0.Q(t, l);
            if (D(t, i2, i5)) {
            }
            i3 *= 53;
            floatToIntBits = c0.Q(t, l);
            if (D(t, i2, i5)) {
            }
            i3 *= 53;
            floatToIntBits = j1.k(t, l).hashCode();
            if (D(t, i2, i5)) {
            }
            i3 *= 53;
            floatToIntBits = j1.k(t, l).hashCode();
            if (D(t, i2, i5)) {
            }
            i3 *= 53;
            floatToIntBits = (String)j1.k(t, l).hashCode();
            if (D(t, i2, i5)) {
            }
            i3 *= 53;
            floatToIntBits = e.a(c0.E(t, l));
            if (D(t, i2, i5)) {
            }
            i3 *= 53;
            floatToIntBits = c0.Q(t, l);
            if (D(t, i2, i5)) {
            }
            i3 *= 53;
            floatToIntBits = e.c(c0.n(t, l));
            if (D(t, i2, i5)) {
            }
            i3 *= 53;
            floatToIntBits = c0.Q(t, l);
            if (D(t, i2, i5)) {
            }
            i3 *= 53;
            floatToIntBits = e.c(c0.n(t, l));
            if (D(t, i2, i5)) {
            }
            i3 *= 53;
            floatToIntBits = e.c(c0.n(t, l));
            if (D(t, i2, i5)) {
            }
            i3 *= 53;
            floatToIntBits = Float.floatToIntBits(c0.N(t, l));
            if (D(t, i2, i5)) {
            }
            i3 *= 53;
            floatToIntBits = e.c(Double.doubleToLongBits(c0.M(t, l)));
            i3 *= 53;
            floatToIntBits = j1.k(t, l).hashCode();
            i3 *= 53;
            floatToIntBits = j1.k(t, l).hashCode();
            floatToIntBits = j1.k(t, l);
            if (floatToIntBits != null) {
            }
            i10 += i;
            i = floatToIntBits.hashCode();
            i3 *= 53;
            floatToIntBits = e.c(j1.i(t, l));
            i3 *= 53;
            floatToIntBits = j1.h(t, l);
            i3 *= 53;
            floatToIntBits = e.c(j1.i(t, l));
            i3 *= 53;
            floatToIntBits = j1.h(t, l);
            i3 *= 53;
            floatToIntBits = j1.h(t, l);
            i3 *= 53;
            floatToIntBits = j1.h(t, l);
            i3 *= 53;
            floatToIntBits = j1.k(t, l).hashCode();
            floatToIntBits = j1.k(t, l);
            if (floatToIntBits != null) {
            }
            i = floatToIntBits.hashCode();
            i3 *= 53;
            floatToIntBits = (String)j1.k(t, l).hashCode();
            i3 *= 53;
            floatToIntBits = e.a(j1.B(t, l));
            i3 *= 53;
            floatToIntBits = j1.h(t, l);
            i3 *= 53;
            floatToIntBits = e.c(j1.i(t, l));
            i3 *= 53;
            floatToIntBits = j1.h(t, l);
            i3 *= 53;
            floatToIntBits = e.c(j1.i(t, l));
            i3 *= 53;
            floatToIntBits = e.c(j1.i(t, l));
            i3 *= 53;
            floatToIntBits = Float.floatToIntBits(j1.g(t, l));
            i3 *= 53;
            floatToIntBits = e.c(Double.doubleToLongBits(j1.f(t, l)));
        }
        if (this.f) {
        } else {
            return i8 += i7;
        }
        this.n.a(t);
        throw 0;
    }

    public final void c(T t) {
        int i3;
        boolean z;
        long l;
        int i2;
        int i;
        Object obj;
        Object obj2;
        i3 = this.j;
        while (i3 < this.k) {
            i = 1048575;
            l = (long)i6;
            obj = j1.k(t, l);
            if (obj != null) {
            }
            i3++;
            (s)obj.d();
            j1.x(t, l, i);
        }
        while (i2 < iArr.length) {
            this.l.b(t, (long)i7);
            i2++;
        }
        this.m.m(t);
        if (this.f) {
            this.n.e(t);
        }
    }

    public final int d(T t) {
        int obj2;
        if (this.h) {
            obj2 = P(t);
        } else {
            obj2 = O(t);
        }
        return obj2;
    }

    public final void e(T t, T t2) {
        int i2;
        android.os.Parcelable.Creator creator;
        long l;
        int i3;
        Objects.requireNonNull(t2);
        i2 = 0;
        while (i2 < iArr.length) {
            int i4 = m(i2);
            l = (long)i6;
            i3 = this.a[i2];
            i2 += 3;
            u(t, t2, i2);
            if (D(t2, i3, i2)) {
            }
            j1.x(t, l, obj3);
            x(t, i3, i2);
            u(t, t2, i2);
            if (D(t2, i3, i2)) {
            }
            j1.x(t, l, obj3);
            x(t, i3, i2);
            n0.i(this.o, t, t2, l);
            this.l.c(t, t2, l);
            t(t, t2, i2);
            if (A(t2, i2)) {
            }
            j1.w(t, l, obj3);
            w(t, i2);
            if (A(t2, i2)) {
            }
            j1.v(t, l, obj3);
            w(t, i2);
            if (A(t2, i2)) {
            }
            j1.w(t, l, obj3);
            w(t, i2);
            if (A(t2, i2)) {
            }
            j1.v(t, l, obj3);
            w(t, i2);
            if (A(t2, i2)) {
            }
            j1.v(t, l, obj3);
            w(t, i2);
            if (A(t2, i2)) {
            }
            j1.v(t, l, obj3);
            w(t, i2);
            if (A(t2, i2)) {
            }
            j1.x(t, l, obj3);
            w(t, i2);
            t(t, t2, i2);
            if (A(t2, i2)) {
            }
            j1.x(t, l, obj3);
            w(t, i2);
            if (A(t2, i2)) {
            }
            j1.r(t, l, obj3);
            w(t, i2);
            if (A(t2, i2)) {
            }
            j1.v(t, l, obj3);
            w(t, i2);
            if (A(t2, i2)) {
            }
            j1.w(t, l, obj3);
            w(t, i2);
            if (A(t2, i2)) {
            }
            j1.v(t, l, obj3);
            w(t, i2);
            if (A(t2, i2)) {
            }
            j1.w(t, l, obj3);
            w(t, i2);
            if (A(t2, i2)) {
            }
            j1.w(t, l, obj3);
            w(t, i2);
            if (A(t2, i2)) {
            }
            j1.u(t, l, obj3);
            w(t, i2);
            if (A(t2, i2)) {
            }
            j1.t(t, l, obj3);
            w(t, i2);
        }
        n0.f(this.m, t, t2);
        if (this.f) {
        } else {
        }
        n0.e(this.n, t, t2);
        throw 0;
    }

    public final void f(T t, com.google.android.gms.internal.firebase-auth-api.hr hr2) {
        int i2;
        int cmp;
        int i3;
        int i5;
        int i;
        long l;
        if (this.h) {
            if (this.f) {
            } else {
                final int i6 = 0;
                i2 = i6;
                while (i2 < iArr.length) {
                    cmp = m(i2);
                    i3 = this.a[i2];
                    i = 1;
                    l = 1048575;
                    i2 += 3;
                    if (D(t, i3, i2)) {
                    }
                    hr2.B(i3, j1.k(t, (long)i39), p(i2));
                    if (D(t, i3, i2)) {
                    }
                    hr2.c(i3, c0.n(t, (long)cmp));
                    if (D(t, i3, i2)) {
                    }
                    hr2.a(i3, c0.Q(t, (long)i18));
                    if (D(t, i3, i2)) {
                    }
                    hr2.J(i3, c0.n(t, (long)cmp));
                    if (D(t, i3, i2)) {
                    }
                    hr2.H(i3, c0.Q(t, (long)i57));
                    if (D(t, i3, i2)) {
                    }
                    hr2.t(i3, c0.Q(t, (long)i50));
                    if (D(t, i3, i2)) {
                    }
                    hr2.h(i3, c0.Q(t, (long)i41));
                    if (D(t, i3, i2)) {
                    }
                    hr2.o(i3, (wq)j1.k(t, (long)i30));
                    if (D(t, i3, i2)) {
                    }
                    hr2.G(i3, j1.k(t, (long)i21), p(i2));
                    if (D(t, i3, i2)) {
                    }
                    c0.H(i3, j1.k(t, (long)i12), hr2);
                    if (D(t, i3, i2)) {
                    }
                    hr2.m(i3, c0.E(t, (long)i60));
                    if (D(t, i3, i2)) {
                    }
                    hr2.v(i3, c0.Q(t, (long)i53));
                    if (D(t, i3, i2)) {
                    }
                    hr2.x(i3, c0.n(t, (long)cmp));
                    if (D(t, i3, i2)) {
                    }
                    hr2.C(i3, c0.Q(t, (long)i34));
                    if (D(t, i3, i2)) {
                    }
                    hr2.j(i3, c0.n(t, (long)cmp));
                    if (D(t, i3, i2)) {
                    }
                    hr2.E(i3, c0.n(t, (long)cmp));
                    if (D(t, i3, i2)) {
                    }
                    hr2.z(i3, c0.N(t, (long)i63));
                    if (D(t, i3, i2)) {
                    }
                    hr2.q(i3, c0.M(t, (long)cmp));
                    G(hr2, i3, j1.k(t, (long)i46), i2);
                    n0.q(this.a[i2], (List)j1.k(t, (long)i42), hr2, p(i2));
                    n0.x(this.a[i2], (List)j1.k(t, (long)i37), hr2, i);
                    n0.w(this.a[i2], (List)j1.k(t, (long)i31), hr2, i);
                    n0.v(this.a[i2], (List)j1.k(t, (long)i26), hr2, i);
                    n0.u(this.a[i2], (List)j1.k(t, (long)i22), hr2, i);
                    n0.m(this.a[i2], (List)j1.k(t, (long)i16), hr2, i);
                    n0.z(this.a[i2], (List)j1.k(t, (long)i13), hr2, i);
                    n0.j(this.a[i2], (List)j1.k(t, (long)i8), hr2, i);
                    n0.n(this.a[i2], (List)j1.k(t, (long)i61), hr2, i);
                    n0.o(this.a[i2], (List)j1.k(t, (long)i56), hr2, i);
                    n0.r(this.a[i2], (List)j1.k(t, (long)i54), hr2, i);
                    n0.B(this.a[i2], (List)j1.k(t, (long)i48), hr2, i);
                    n0.s(this.a[i2], (List)j1.k(t, (long)i45), hr2, i);
                    n0.p(this.a[i2], (List)j1.k(t, (long)i40), hr2, i);
                    n0.l(this.a[i2], (List)j1.k(t, (long)i35), hr2, i);
                    n0.x(this.a[i2], (List)j1.k(t, (long)i28), hr2, i6);
                    n0.w(this.a[i2], (List)j1.k(t, (long)i25), hr2, i6);
                    n0.v(this.a[i2], (List)j1.k(t, (long)i19), hr2, i6);
                    n0.u(this.a[i2], (List)j1.k(t, (long)i15), hr2, i6);
                    n0.m(this.a[i2], (List)j1.k(t, (long)i10), hr2, i6);
                    n0.z(this.a[i2], (List)j1.k(t, (long)i64), hr2, i6);
                    n0.k(this.a[i2], (List)j1.k(t, (long)i58), hr2);
                    n0.t(this.a[i2], (List)j1.k(t, (long)i55), hr2, p(i2));
                    n0.y(this.a[i2], (List)j1.k(t, (long)i51), hr2);
                    n0.j(this.a[i2], (List)j1.k(t, (long)i47), hr2, i6);
                    n0.n(this.a[i2], (List)j1.k(t, (long)i43), hr2, i6);
                    n0.o(this.a[i2], (List)j1.k(t, (long)i38), hr2, i6);
                    n0.r(this.a[i2], (List)j1.k(t, (long)i32), hr2, i6);
                    n0.B(this.a[i2], (List)j1.k(t, (long)i27), hr2, i6);
                    n0.s(this.a[i2], (List)j1.k(t, (long)i23), hr2, i6);
                    n0.p(this.a[i2], (List)j1.k(t, (long)i17), hr2, i6);
                    n0.l(this.a[i2], (List)j1.k(t, (long)i14), hr2, i6);
                    if (A(t, i2)) {
                    }
                    hr2.B(i3, j1.k(t, (long)i9), p(i2));
                    if (A(t, i2)) {
                    }
                    hr2.c(i3, j1.i(t, (long)cmp));
                    if (A(t, i2)) {
                    }
                    hr2.a(i3, j1.h(t, (long)i49));
                    if (A(t, i2)) {
                    }
                    hr2.J(i3, j1.i(t, (long)cmp));
                    if (A(t, i2)) {
                    }
                    hr2.H(i3, j1.h(t, (long)i29));
                    if (A(t, i2)) {
                    }
                    hr2.t(i3, j1.h(t, (long)i20));
                    if (A(t, i2)) {
                    }
                    hr2.h(i3, j1.h(t, (long)i11));
                    if (A(t, i2)) {
                    }
                    hr2.o(i3, (wq)j1.k(t, (long)i59));
                    if (A(t, i2)) {
                    }
                    hr2.G(i3, j1.k(t, (long)i52), p(i2));
                    if (A(t, i2)) {
                    }
                    c0.H(i3, j1.k(t, (long)i44), hr2);
                    if (A(t, i2)) {
                    }
                    hr2.m(i3, j1.B(t, (long)i33));
                    if (A(t, i2)) {
                    }
                    hr2.v(i3, j1.h(t, (long)i24));
                    if (A(t, i2)) {
                    }
                    hr2.x(i3, j1.i(t, (long)cmp));
                    if (A(t, i2)) {
                    }
                    hr2.C(i3, j1.h(t, (long)i62));
                    if (A(t, i2)) {
                    }
                    hr2.j(i3, j1.i(t, (long)cmp));
                    if (A(t, i2)) {
                    }
                    hr2.E(i3, j1.i(t, (long)cmp));
                    if (A(t, i2)) {
                    }
                    hr2.z(i3, j1.g(t, (long)i36));
                    if (A(t, i2)) {
                    }
                    hr2.q(i3, j1.f(t, (long)cmp));
                }
                com.google.android.gms.internal.firebase-auth-api.y0 y0Var = this.m;
                y0Var.r(y0Var.d(t), hr2);
            }
            this.n.a(t);
            throw 0;
        }
        F(t, hr2);
    }

    public final boolean g(T t) {
        int i13;
        int i14;
        boolean empty2;
        int int;
        int i2;
        int i15;
        int empty;
        int i3;
        int size;
        int i8;
        int i4;
        int i9;
        int i12;
        int i7;
        int i10;
        int i;
        int i11;
        int i5;
        int i6;
        final Object obj6 = this;
        final Object obj7 = t;
        final int i22 = 1048575;
        final int i23 = 0;
        i13 = i22;
        i9 = int;
        i12 = 0;
        size = 1;
        while (i9 < obj6.j) {
            i7 = obj6.i[i9];
            i = obj6.m(i7);
            int i20 = obj6.a[i7 + 2];
            i8 = i20 & i22;
            i20 >>>= 20;
            i11 = size << i3;
            if (i8 != i13) {
            } else {
            }
            i5 = i13;
            i6 = int;
            empty2 = c0.l(i);
            i9++;
            i13 = i5;
            int = i6;
            i12 = 0;
            size = 1;
            empty2 = j1.k(obj7, (long)i17);
            i3 = i23;
            while (i3 < empty2.size()) {
                i3++;
            }
            i3++;
            empty = 50;
            if (i8 != i22) {
            }
            i6 = int;
            i5 = i8;
            int = c0.q.getInt(obj7, (long)i8);
        }
        if (obj6.f) {
        } else {
            return size;
        }
        obj6.n.a(obj7);
        throw i12;
    }

    public final void h(T t, com.google.android.gms.internal.firebase-auth-api.k0 k02, com.google.android.gms.internal.firebase-auth-api.lr lr3) {
        int i6;
        Object obj2;
        int i;
        int valueOf2;
        int i5;
        Object obj3;
        int valueOf;
        long l;
        Object obj;
        int i2;
        int i3;
        int obj14;
        Object obj15;
        Objects.requireNonNull(lr3);
        final com.google.android.gms.internal.firebase-auth-api.y0 y0Var = this.m;
        final com.google.android.gms.internal.firebase-auth-api.mr mrVar2 = this.n;
        final int i77 = 0;
        i2 = i6;
        obj2 = k02.zzc();
        i = V(obj2);
        while (i < 0) {
            if (!this.f) {
            } else {
            }
            i = obj2;
            y0Var.q(k02);
            if (i2 == 0) {
            }
            obj2 = k02.zzc();
            i = V(obj2);
            valueOf2 = m(i);
            i5 = c0.l(valueOf2);
            valueOf = 1048575;
            if (i2 == 0) {
            }
            i2 = y0Var.f();
            j1.x(t, (long)i66, i5);
            x(t, obj2, i);
            j1.x(t, (long)i65, i5);
            x(t, obj2, i);
            j1.x(t, (long)i64, i5);
            x(t, obj2, i);
            j1.x(t, (long)i63, i5);
            x(t, obj2, i);
            j1.x(t, (long)i62, i5);
            x(t, obj2, i);
            i5 = k02.a();
            l = o(i);
            if (l != null) {
            } else {
            }
            j1.x(t, (long)i60, l);
            x(t, obj2, i);
            if (l.zza()) {
            } else {
            }
            i2 = n0.d(obj2, i5, i2, y0Var);
            j1.x(t, (long)i53, i5);
            x(t, obj2, i);
            j1.x(t, (long)i71, i5);
            x(t, obj2, i);
            i5 = D(t, obj2, i);
            if (i5) {
            } else {
            }
            j1.x(t, (long)i67, i5);
            w(t, i);
            x(t, obj2, i);
            valueOf2 = (long)i68;
            j1.x(t, valueOf2, i5);
            v(t, valueOf2, k02);
            x(t, obj2, i);
            j1.x(t, (long)i61, i5);
            x(t, obj2, i);
            j1.x(t, (long)i59, i5);
            x(t, obj2, i);
            j1.x(t, (long)i58, i5);
            x(t, obj2, i);
            j1.x(t, (long)i57, i5);
            x(t, obj2, i);
            j1.x(t, (long)i56, i5);
            x(t, obj2, i);
            j1.x(t, (long)i55, i5);
            x(t, obj2, i);
            j1.x(t, (long)i52, i5);
            x(t, obj2, i);
            j1.x(t, (long)i69, i5);
            x(t, obj2, i);
            k02.D(this.l.a(t, (long)i12), p(i), lr3);
            k02.F(this.l.a(t, (long)i33));
            k02.H(this.l.a(t, (long)i30));
            k02.B(this.l.a(t, (long)i27));
            k02.C(this.l.a(t, (long)i24));
            valueOf2 = this.l.a(t, (long)i54);
            k02.s(valueOf2);
            i2 = n0.c(obj2, valueOf2, o(i), i2, y0Var);
            k02.I(this.l.a(t, (long)i51));
            k02.J(this.l.a(t, (long)i49));
            k02.E(this.l.a(t, (long)i44));
            k02.G(this.l.a(t, (long)i42));
            k02.z(this.l.a(t, (long)i40));
            k02.w(this.l.a(t, (long)i37));
            k02.t(this.l.a(t, (long)i36));
            k02.L(this.l.a(t, (long)i35));
            k02.x(this.l.a(t, (long)i32));
            k02.F(this.l.a(t, (long)i29));
            k02.H(this.l.a(t, (long)i26));
            k02.B(this.l.a(t, (long)i23));
            k02.C(this.l.a(t, (long)i21));
            valueOf2 = this.l.a(t, (long)i70);
            k02.s(valueOf2);
            i2 = n0.c(obj2, valueOf2, o(i), i2, y0Var);
            k02.I(this.l.a(t, (long)i48));
            k02.y(this.l.a(t, (long)i43));
            k02.K(this.l.a(t, (long)i41), p(i), lr3);
            if (c0.z(valueOf2)) {
            } else {
            }
            (ar)k02.j(this.l.a(t, (long)i38), false);
            (ar)k02.j(this.l.a(t, (long)i39), true);
            k02.J(this.l.a(t, (long)i34));
            k02.E(this.l.a(t, (long)i31));
            k02.G(this.l.a(t, (long)i28));
            k02.z(this.l.a(t, (long)i25));
            k02.w(this.l.a(t, (long)i22));
            k02.t(this.l.a(t, (long)i20));
            k02.L(this.l.a(t, (long)i50));
            k02.x(this.l.a(t, (long)i45));
            if (A(t, i)) {
            } else {
            }
            j1.x(t, (long)i16, i5);
            w(t, i);
            valueOf2 = (long)i17;
            j1.x(t, valueOf2, i5);
            j1.w(t, (long)obj2, i5);
            w(t, i);
            j1.v(t, (long)i11, i5);
            w(t, i);
            j1.w(t, (long)obj2, i5);
            w(t, i);
            j1.v(t, (long)i9, i5);
            w(t, i);
            i5 = k02.a();
            l = o(i);
            if (l != null) {
            } else {
            }
            j1.v(t, (long)obj2, l);
            w(t, i);
            if (l.zza()) {
            } else {
            }
            i2 = n0.d(obj2, i5, i2, y0Var);
            j1.v(t, (long)i18, i5);
            w(t, i);
            j1.x(t, (long)i15, i5);
            w(t, i);
            if (A(t, i)) {
            } else {
            }
            j1.x(t, (long)i13, i5);
            w(t, i);
            valueOf2 = (long)i14;
            j1.x(t, valueOf2, i5);
            v(t, valueOf2, k02);
            w(t, i);
            j1.r(t, (long)i10, i5);
            w(t, i);
            j1.v(t, (long)i8, i5);
            w(t, i);
            j1.w(t, (long)obj2, i5);
            w(t, i);
            j1.v(t, (long)i7, i5);
            w(t, i);
            j1.w(t, (long)obj2, i5);
            w(t, i);
            j1.w(t, (long)obj2, i5);
            w(t, i);
            j1.u(t, (long)i19, i5);
            w(t, i);
            j1.t(t, (long)obj2, i5);
            w(t, i);
            i2 = y0Var.c(t);
            if (i6 == 0) {
            }
            i3 = i6;
            i2 = mrVar2.d(k02, i, lr3, i3, i2, y0Var);
            i6 = i3;
            i6 = mrVar2.b(t);
            i = i77;
        }
        obj14 = this.j;
        while (obj14 < this.k) {
            q(t, this.i[obj14], i2, y0Var);
            obj14++;
        }
        if (i2 != 0) {
            y0Var.n(t, i2);
        }
    }

    public final void i(T t, byte[] b2Arr2, int i3, int i4, com.google.android.gms.internal.firebase-auth-api.mq mq5) {
        if (this.h) {
            T(t, b2Arr2, i3, i4, mq5);
        }
        this.I(t, b2Arr2, i3, i4, 0, mq5);
    }

    public final boolean j(T t, T t2) {
        int i2;
        int i;
        int floatToIntBits2;
        int floatToIntBits;
        long doubleToLongBits;
        int i3;
        final int i5 = 0;
        i = i5;
        while (i < iArr.length) {
            int i6 = m(i);
            floatToIntBits = 1048575;
            doubleToLongBits = (long)i9;
            i += 3;
            long l2 = (long)i8;
            floatToIntBits2 = n0.h(j1.k(t, doubleToLongBits), j1.k(t2, doubleToLongBits));
            floatToIntBits2 = n0.h(j1.k(t, doubleToLongBits), j1.k(t2, doubleToLongBits));
        }
        if (!this.m.d(t).equals(this.m.d(t2))) {
            return i5;
        }
        if (this.f) {
        } else {
            return 1;
        }
        this.n.a(t);
        this.n.a(t2);
        throw 0;
    }
}
