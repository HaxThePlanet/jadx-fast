package com.google.android.gms.internal.measurement;

import android.accounts.Account;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
final class ba<T>  implements com.google.android.gms.internal.measurement.ja<T> {

    private static final int[] o;
    private static final Unsafe p;
    private final int[] a;
    private final Object[] b;
    private final int c;
    private final int d;
    private final com.google.android.gms.internal.measurement.y9 e;
    private final boolean f;
    private final boolean g;
    private final int[] h;
    private final int i;
    private final int j;
    private final com.google.android.gms.internal.measurement.l9 k;
    private final com.google.android.gms.internal.measurement.xa<?, ?> l;
    private final com.google.android.gms.internal.measurement.k8<?> m;
    private final com.google.android.gms.internal.measurement.s9 n;
    static {
        ba.o = new int[0];
        ba.p = hb.l();
    }

    private ba(int[] iArr, Object[] object2Arr2, int i3, int i4, com.google.android.gms.internal.measurement.y9 y95, boolean z6, boolean z7, int[] i8Arr8, int i9, int i10, com.google.android.gms.internal.measurement.da da11, com.google.android.gms.internal.measurement.l9 l912, com.google.android.gms.internal.measurement.xa xa13, com.google.android.gms.internal.measurement.k8 k814, com.google.android.gms.internal.measurement.s9 s915, byte[] b16Arr16) {
        int i;
        boolean z;
        final Object obj = this;
        final com.google.android.gms.internal.measurement.k8 k8Var = k814;
        super();
        obj.a = iArr;
        obj.b = object2Arr2;
        obj.c = i3;
        obj.d = i4;
        obj.g = z6;
        i = 0;
        if (k8Var != null && k8Var.c(y95)) {
            i = k8Var.c(y95) ? 1 : i;
        }
        obj.f = i;
        obj.h = i8Arr8;
        obj.i = i9;
        obj.j = i10;
        obj.k = l912;
        obj.l = xa13;
        obj.m = k8Var;
        obj.e = y95;
        obj.n = s915;
    }

    private final void A(T t, com.google.android.gms.internal.measurement.f8 f82) {
        int i2;
        int i5;
        int i6;
        int i11;
        long object;
        long l;
        int i13;
        int int;
        int i12;
        int i7;
        int i8;
        int i9;
        int i10;
        int i;
        int i4;
        final Object obj = this;
        Object obj2 = t;
        com.google.android.gms.internal.measurement.f8 f8Var = f82;
        if (obj.f) {
        } else {
            final Unsafe unsafe = ba.p;
            i12 = i11;
            i13 = 0;
            int = 0;
            while (i13 < iArr.length) {
                int i16 = obj.k(i13);
                i8 = obj.a[i13];
                int i17 = ba.j(i16);
                i = 1;
                if (i17 <= 17) {
                } else {
                }
                i10 = 0;
                object = (long)i7;
                i9 = 0;
                i13 += 3;
                i11 = 1048575;
                if (obj.y(obj2, i8, i13) != 0) {
                }
                f8Var.B(i8, unsafe.getObject(obj2, object), obj.n(i13));
                if (obj.y(obj2, i8, i13) != 0) {
                }
                f8Var.c(i8, ba.l(obj2, object));
                if (obj.y(obj2, i8, i13) != 0) {
                }
                f8Var.a(i8, ba.L(obj2, object));
                if (obj.y(obj2, i8, i13) != 0) {
                }
                f8Var.J(i8, ba.l(obj2, object));
                if (obj.y(obj2, i8, i13) != 0) {
                }
                f8Var.H(i8, ba.L(obj2, object));
                if (obj.y(obj2, i8, i13) != 0) {
                }
                f8Var.t(i8, ba.L(obj2, object));
                if (obj.y(obj2, i8, i13) != 0) {
                }
                f8Var.h(i8, ba.L(obj2, object));
                if (obj.y(obj2, i8, i13) != 0) {
                }
                f8Var.o(i8, (x7)unsafe.getObject(obj2, object));
                if (obj.y(obj2, i8, i13) != 0) {
                }
                f8Var.G(i8, unsafe.getObject(obj2, object), obj.n(i13));
                if (obj.y(obj2, i8, i13) != 0) {
                }
                ba.C(i8, unsafe.getObject(obj2, object), f8Var);
                if (obj.y(obj2, i8, i13) != 0) {
                }
                f8Var.m(i8, ba.z(obj2, object));
                if (obj.y(obj2, i8, i13) != 0) {
                }
                f8Var.v(i8, ba.L(obj2, object));
                if (obj.y(obj2, i8, i13) != 0) {
                }
                f8Var.x(i8, ba.l(obj2, object));
                if (obj.y(obj2, i8, i13) != 0) {
                }
                f8Var.C(i8, ba.L(obj2, object));
                if (obj.y(obj2, i8, i13) != 0) {
                }
                f8Var.j(i8, ba.l(obj2, object));
                if (obj.y(obj2, i8, i13) != 0) {
                }
                f8Var.E(i8, ba.l(obj2, object));
                if (obj.y(obj2, i8, i13) != 0) {
                }
                f8Var.z(i8, ba.I(obj2, object));
                if (obj.y(obj2, i8, i13) != 0) {
                }
                f8Var.q(i8, ba.H(obj2, object));
                obj.B(f8Var, i8, unsafe.getObject(obj2, object), i13);
                la.q(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, obj.n(i13));
                la.x(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, i);
                la.w(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, i);
                la.v(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, i);
                la.u(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, i);
                la.m(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, i);
                la.z(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, i);
                la.j(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, i);
                la.n(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, i);
                la.o(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, i);
                la.r(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, i);
                la.B(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, i);
                la.s(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, i);
                la.p(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, i);
                la.l(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, i);
                la.x(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, false);
                i9 = i8;
                la.w(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, false);
                la.v(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, false);
                la.u(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, false);
                la.m(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, false);
                la.z(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, false);
                la.k(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var);
                la.t(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, obj.n(i13));
                la.y(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var);
                la.j(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, false);
                la.n(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, false);
                la.o(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, false);
                la.r(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, false);
                la.B(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, false);
                la.s(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, false);
                la.p(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, false);
                la.l(obj.a[i13], (List)unsafe.getObject(obj2, object), f8Var, false);
                i9 = 0;
                if (int & i10 != 0) {
                }
                f8Var.B(i8, unsafe.getObject(obj2, object), obj.n(i13));
                i9 = 0;
                if (int & i10 != 0) {
                }
                f8Var.c(i8, unsafe.getLong(obj2, object));
                i9 = 0;
                if (int & i10 != 0) {
                }
                f8Var.a(i8, unsafe.getInt(obj2, object));
                i9 = 0;
                if (int & i10 != 0) {
                }
                f8Var.J(i8, unsafe.getLong(obj2, object));
                i9 = 0;
                if (int & i10 != 0) {
                }
                f8Var.H(i8, unsafe.getInt(obj2, object));
                i9 = 0;
                if (int & i10 != 0) {
                }
                f8Var.t(i8, unsafe.getInt(obj2, object));
                i9 = 0;
                if (int & i10 != 0) {
                }
                f8Var.h(i8, unsafe.getInt(obj2, object));
                i9 = 0;
                if (int & i10 != 0) {
                }
                f8Var.o(i8, (x7)unsafe.getObject(obj2, object));
                i9 = 0;
                if (int & i10 != 0) {
                }
                f8Var.G(i8, unsafe.getObject(obj2, object), obj.n(i13));
                i9 = 0;
                if (int & i10 != 0) {
                }
                ba.C(i8, unsafe.getObject(obj2, object), f8Var);
                i9 = 0;
                if (int & i10 != 0) {
                }
                f8Var.m(i8, hb.B(obj2, object));
                i9 = 0;
                if (int & i10 != 0) {
                }
                f8Var.v(i8, unsafe.getInt(obj2, object));
                i9 = 0;
                if (int & i10 != 0) {
                }
                f8Var.x(i8, unsafe.getLong(obj2, object));
                i9 = 0;
                if (int & i10 != 0) {
                }
                f8Var.C(i8, unsafe.getInt(obj2, object));
                i9 = 0;
                if (int & i10 != 0) {
                }
                f8Var.j(i8, unsafe.getLong(obj2, object));
                i9 = 0;
                if (int & i10 != 0) {
                }
                f8Var.E(i8, unsafe.getLong(obj2, object));
                i9 = 0;
                if (int & i10 != 0) {
                }
                f8Var.z(i8, hb.g(obj2, object));
                i9 = 0;
                if (int & i10 != 0) {
                }
                f8Var.q(i8, hb.f(obj2, object));
                int i19 = obj.a[i13 + 2];
                i4 = i19 & i11;
                if (i4 != i12) {
                }
                i10 = i << i20;
                int = unsafe.getInt(obj2, (long)i4);
                i12 = i4;
            }
            com.google.android.gms.internal.measurement.xa xaVar = obj.l;
            xaVar.i(xaVar.c(obj2), f8Var);
        }
        obj.m.a(obj2);
        throw 0;
    }

    private final <K, V> void B(com.google.android.gms.internal.measurement.f8 f8, int i2, Object object3, int i4) {
        if (object3 != null) {
        } else {
        }
        Object obj1 = o(i4);
        throw 0;
    }

    private static final void C(int i, Object object2, com.google.android.gms.internal.measurement.f8 f83) {
        if (object2 instanceof String != null) {
            f83.f(i, (String)object2);
        }
        f83.o(i, (x7)object2);
    }

    static com.google.android.gms.internal.measurement.ya E(Object object) {
        com.google.android.gms.internal.measurement.ya zzc;
        if (object.zzc == ya.c()) {
            object.zzc = ya.e();
        }
        return zzc;
    }

    static <T> com.google.android.gms.internal.measurement.ba<T> F(Class<T> class, com.google.android.gms.internal.measurement.u9 u92, com.google.android.gms.internal.measurement.da da3, com.google.android.gms.internal.measurement.l9 l94, com.google.android.gms.internal.measurement.xa<?, ?> xa5, com.google.android.gms.internal.measurement.k8<?> k86, com.google.android.gms.internal.measurement.s9 s97) {
        if (!u92 instanceof ia) {
        } else {
            return ba.G((ia)u92, da3, l94, xa5, k86, s97);
        }
        throw 0;
    }

    static <T> com.google.android.gms.internal.measurement.ba<T> G(com.google.android.gms.internal.measurement.ia ia, com.google.android.gms.internal.measurement.da da2, com.google.android.gms.internal.measurement.l9 l93, com.google.android.gms.internal.measurement.xa<?, ?> xa4, com.google.android.gms.internal.measurement.k8<?> k85, com.google.android.gms.internal.measurement.s9 s96) {
        String str2;
        int i62;
        Class class;
        int i53;
        int i50;
        int i58;
        char charAt4;
        int i14;
        int i42;
        int length;
        int i5;
        int i20;
        int charAt6;
        int i4;
        char charAt7;
        int i23;
        char charAt13;
        int i59;
        int i54;
        int charAt2;
        char charAt;
        int i24;
        int i15;
        int charAt3;
        int i10;
        int i17;
        int i67;
        char charAt11;
        char c2;
        int i25;
        char charAt9;
        int i43;
        int[] iArr;
        int i16;
        Object i32;
        int i30;
        char charAt12;
        Object obj3;
        Class cls;
        int i41;
        int i45;
        int i33;
        int i11;
        int i18;
        char c8;
        int i21;
        int i66;
        int i63;
        char charAt8;
        int i29;
        int i44;
        char charAt15;
        Object[] arr;
        int i3;
        int i22;
        int i46;
        char c7;
        int i19;
        Object obj;
        boolean z;
        int i61;
        int i7;
        int i65;
        int i64;
        int i57;
        int i26;
        char charAt14;
        int i31;
        int[] iArr2;
        int i;
        int i39;
        char charAt10;
        int i40;
        char charAt5;
        int i2;
        int i34;
        int i6;
        int i35;
        int i60;
        char c4;
        int i27;
        int i49;
        int i47;
        int i28;
        int i36;
        Object obj2;
        int i52;
        int i8;
        int i12;
        char c3;
        int i48;
        char c;
        int i56;
        int i13;
        int i9;
        int i37;
        int type;
        int i51;
        int i55;
        Object[] objArr;
        String str;
        int i38;
        char c5;
        char c6;
        int i70 = 0;
        i44 = ia.zzc() == 2 ? 1 : i70;
        str2 = ia.a();
        length = str2.length();
        charAt3 = 55296;
        if (str2.charAt(i70) >= charAt3) {
            i15 = 1;
            while (str2.charAt(i15) >= charAt3) {
                i15 = i17;
            }
        } else {
            i17 = 1;
        }
        i59 = i17 + 1;
        charAt11 = str2.charAt(i17);
        if (charAt11 >= charAt3) {
            charAt11 &= 8191;
            i30 = 13;
            i18 = i59 + 1;
            char charAt17 = str2.charAt(i59);
            while (charAt17 >= charAt3) {
                i67 |= i89;
                i30 += 13;
                i59 = i18;
                i18 = i59 + 1;
                charAt17 = str2.charAt(i59);
            }
            i67 |= i87;
            i59 = i18;
        }
        if (charAt11 == 0) {
            iArr2 = iArr4;
            c2 = i36;
        } else {
            i25 = i59 + 1;
            charAt = str2.charAt(i59);
            if (charAt >= charAt3) {
                charAt &= 8191;
                i30 = 13;
                i18 = i25 + 1;
                char charAt18 = str2.charAt(i25);
                while (charAt18 >= charAt3) {
                    i24 |= i95;
                    i30 += 13;
                    i25 = i18;
                    i18 = i25 + 1;
                    charAt18 = str2.charAt(i25);
                }
                i24 |= i93;
                i25 = i18;
            }
            i33 = i25 + 1;
            charAt9 = str2.charAt(i25);
            if (charAt9 >= charAt3) {
                charAt9 &= 8191;
                i18 = 13;
                i3 = i33 + 1;
                char charAt20 = str2.charAt(i33);
                while (charAt20 >= charAt3) {
                    i43 |= i105;
                    i18 += 13;
                    i33 = i3;
                    i3 = i33 + 1;
                    charAt20 = str2.charAt(i33);
                }
                i43 |= i103;
                i33 = i3;
            }
            i63 = i33 + 1;
            charAt12 = str2.charAt(i33);
            if (charAt12 >= charAt3) {
                charAt12 &= 8191;
                i3 = 13;
                i57 = i63 + 1;
                char charAt21 = str2.charAt(i63);
                while (charAt21 >= charAt3) {
                    i11 |= i109;
                    i3 += 13;
                    i63 = i57;
                    i57 = i63 + 1;
                    charAt21 = str2.charAt(i63);
                }
                i11 |= i107;
                i63 = i57;
            }
            i22 = i63 + 1;
            charAt8 = str2.charAt(i63);
            if (charAt8 >= charAt3) {
                charAt8 &= 8191;
                i57 = 13;
                i = i22 + 1;
                char charAt22 = str2.charAt(i22);
                while (charAt22 >= charAt3) {
                    i29 |= i115;
                    i57 += 13;
                    i22 = i;
                    i = i22 + 1;
                    charAt22 = str2.charAt(i22);
                }
                i29 |= i113;
                i22 = i;
            }
            i26 = i22 + 1;
            charAt15 = str2.charAt(i22);
            if (charAt15 >= charAt3) {
                charAt15 &= 8191;
                i = 13;
                i27 = i26 + 1;
                char charAt23 = str2.charAt(i26);
                while (charAt23 >= charAt3) {
                    i46 |= i131;
                    i += 13;
                    i26 = i27;
                    i27 = i26 + 1;
                    charAt23 = str2.charAt(i26);
                }
                i46 |= i129;
                i26 = i27;
            }
            i39 = i26 + 1;
            charAt14 = str2.charAt(i26);
            if (charAt14 >= charAt3) {
                charAt14 &= 8191;
                i27 = 13;
                i28 = i39 + 1;
                char charAt24 = str2.charAt(i39);
                while (charAt24 >= charAt3) {
                    i31 |= i135;
                    i27 += 13;
                    i39 = i28;
                    i28 = i39 + 1;
                    charAt24 = str2.charAt(i39);
                }
                i31 |= i133;
                i39 = i28;
            }
            i49 = i39 + 1;
            charAt10 = str2.charAt(i39);
            if (charAt10 >= charAt3) {
                charAt10 &= 8191;
                i28 = 13;
                i52 = i49 + 1;
                char charAt26 = str2.charAt(i49);
                while (charAt26 >= charAt3) {
                    i40 |= i142;
                    i28 += 13;
                    i49 = i52;
                    i52 = i49 + 1;
                    charAt26 = str2.charAt(i49);
                }
                i40 |= i140;
                i49 = i52;
            }
            i28 = i49 + 1;
            charAt5 = str2.charAt(i49);
            if (charAt5 >= charAt3) {
                charAt5 &= 8191;
                i52 = 13;
                i8 = i28 + 1;
                char charAt27 = str2.charAt(i28);
                while (charAt27 >= charAt3) {
                    i47 |= i145;
                    i52 += 13;
                    i28 = i8;
                    i8 = i28 + 1;
                    charAt27 = str2.charAt(i28);
                }
                i47 |= i143;
                i28 = i8;
            }
            iArr2 = new int[charAt10 += i146];
            i147 += charAt9;
            c2 = charAt;
            i59 = i28;
            c7 = charAt8;
            c8 = c6;
        }
        Unsafe unsafe = ba.p;
        Object[] objArr4 = ia.b();
        class = ia.zza().getClass();
        iArr = new int[charAt15 * 3];
        arr = new Object[charAt15 += charAt15];
        final int i149 = charAt5 + c8;
        c3 = charAt5;
        i48 = i149;
        i21 = 0;
        i12 = 0;
        while (i59 < length) {
            i56 = i59 + 1;
            charAt2 = str2.charAt(i59);
            if (charAt2 >= charAt3) {
            } else {
            }
            i58 = i56;
            i13 = i58 + 1;
            charAt4 = str2.charAt(i58);
            if (charAt4 >= charAt3) {
            } else {
            }
            i55 = length;
            i5 = i13;
            int i91 = charAt4 & 255;
            if (charAt4 & 1024 != 0) {
            }
            if (i91 >= 51) {
            } else {
            }
            i38 = iArr;
            c4 = charAt12;
            c5 = c7;
            i32 = i36 + 1;
            Field field = ba.p(class, (String)objArr4[i36]);
            if (i91 != 9) {
            } else {
            }
            i9 = 1;
            int i123 = i21 / 3;
            arr[i124++] = field.getType();
            z = i32;
            objArr = arr;
            if (charAt4 & 4096 == 4096 && i91 <= 17) {
            } else {
            }
            str = str2;
            cls = class;
            i62 = type;
            type = i5;
            i4 = 0;
            if (i91 >= 18 && i91 <= 49) {
            }
            i36 = z;
            int i71 = i21 + 1;
            i38[i21] = charAt2;
            int i90 = i71 + 1;
            if (charAt4 & 512 != 0) {
            } else {
            }
            i66 = 0;
            if (charAt4 &= 256 != 0) {
            } else {
            }
            i14 = 0;
            i38[i71] = i78 |= i16;
            i21 = i90 + 1;
            i38[i90] = i62 |= i72;
            class = cls;
            charAt12 = c4;
            charAt5 = c;
            i59 = type;
            length = i55;
            arr = objArr;
            str2 = str;
            iArr = i38;
            c7 = c5;
            charAt3 = 55296;
            i14 = 268435456;
            i66 = 536870912;
            if (i91 <= 49) {
            }
            iArr2[i48] = (int)objectFieldOffset4;
            i48 = class;
            if (i91 <= 17) {
            } else {
            }
            charAt7 = str2.charAt(i5);
            int i111 = 55296;
            if (charAt7 >= i111) {
            } else {
            }
            type = i41;
            i99 += i37;
            arr = objArr4[i100];
            str = str2;
            if (arr instanceof Field) {
            } else {
            }
            objArr4[i100] = ba.p(class, (String)arr);
            cls = class;
            i62 = (int)objectFieldOffset;
            charAt7 %= 32;
            charAt7 &= 8191;
            i37 = 13;
            char charAt19 = str2.charAt(i41);
            while (charAt19 >= i111) {
                i23 |= i102;
                i37 += 13;
                i41 = type;
                charAt19 = str2.charAt(i41);
            }
            i23 |= i41;
            i23 |= i102;
            i37 += 13;
            i41 = type;
            if (i91 == 17) {
            } else {
            }
            if (i91 != 27) {
            } else {
            }
            i9 = 1;
            int i125 = i21 / 3;
            type = i32 + 1;
            arr[i126++] = objArr4[i32];
            z = type;
            if (i91 == 49) {
            } else {
            }
            if (i91 != 12 && i91 != 30) {
            } else {
            }
            if (i44 == 0) {
            } else {
            }
            i9 = 1;
            int i127 = i21 / 3;
            type = i32 + 1;
            i9 = 1;
            arr[i128++] = objArr4[i32];
            if (i91 != 30) {
            } else {
            }
            if (i91 == 44) {
            } else {
            }
            if (i91 == 50) {
            } else {
            }
            i64 = c3 + 1;
            iArr2[c3] = i21;
            int i150 = i21 / 3;
            i150 += i150;
            type = i32 + 1;
            arr[i151] = objArr4[i32];
            if (charAt4 & 2048 != 0) {
            } else {
            }
            c3 = i64;
            z = type;
            i9 = 1;
            i32 = type + 1;
            arr[i151++] = objArr4[type];
            c3 = i64;
            charAt6 = str2.charAt(i5);
            i51 = i137;
            if (charAt6 >= 55296) {
            } else {
            }
            c5 = c7;
            i6 = i51;
            i19 = i91 + -51;
            type = i6;
            if (i19 != 9) {
            } else {
            }
            int i119 = i21 / 3;
            i35 = i36 + 1;
            i9 = 1;
            arr[i120++] = objArr4[i36];
            i36 = i35;
            charAt6 += charAt6;
            obj = objArr4[i80];
            if (obj instanceof Field) {
            } else {
            }
            objArr4[i80] = ba.p(class, (String)obj);
            i38 = iArr;
            c4 = charAt12;
            i80++;
            obj3 = objArr4[i81];
            if (obj3 instanceof Field) {
            } else {
            }
            objArr4[i81] = ba.p(class, (String)obj3);
            str = str2;
            cls = class;
            i62 = i98;
            objArr = arr;
            i9 = 1;
            i16 = i82;
            i4 = 0;
            if (i19 == 17) {
            } else {
            }
            if (i19 == 12 && i44 == 0) {
            }
            if (i44 == 0) {
            }
            int i121 = i21 / 3;
            i35 = i36 + 1;
            i9 = 1;
            arr[i122++] = objArr4[i36];
            charAt6 &= 8191;
            i34 = i51;
            i51 = 13;
            i38 = i34 + 1;
            char charAt25 = str2.charAt(i34);
            while (charAt25 >= 55296) {
                i20 |= i118;
                i51 += 13;
                i34 = i38;
                c7 = c5;
                i38 = i34 + 1;
                charAt25 = str2.charAt(i34);
            }
            i20 |= c7;
            i6 = i38;
            i20 |= i118;
            i51 += 13;
            i34 = i38;
            c7 = c5;
            iArr2[i12] = i21;
            i12 = i2;
            charAt4 &= 8191;
            i10 = i13;
            i13 = 13;
            type = i10 + 1;
            charAt3 = str2.charAt(i10);
            while (charAt3 >= 55296) {
                i42 |= i86;
                i13 += 13;
                i10 = type;
                length = i55;
                type = i10 + 1;
                charAt3 = str2.charAt(i10);
            }
            i42 |= i84;
            i5 = type;
            i42 |= i86;
            i13 += 13;
            i10 = type;
            length = i55;
            charAt2 &= 8191;
            i50 = i56;
            i56 = 13;
            i37 = i50 + 1;
            char charAt16 = str2.charAt(i50);
            while (charAt16 >= charAt3) {
                i54 |= i75;
                i56 += 13;
                i50 = i37;
                i37 = i50 + 1;
                charAt16 = str2.charAt(i50);
            }
            i54 |= i73;
            i58 = i37;
            i54 |= i75;
            i56 += 13;
            i50 = i37;
        }
        super(iArr, arr, charAt12, c7, ia.zza(), i44, 0, iArr2, charAt5, i149, da2, l93, xa4, k85, s96, 0);
        return baVar;
    }

    private static <T> double H(T t, long l2) {
        return (Double)hb.k(t, l2).doubleValue();
    }

    private static <T> float I(T t, long l2) {
        return (Float)hb.k(t, l2).floatValue();
    }

    private final int J(T t) {
        int i3;
        int i4;
        int i12;
        int i10;
        int i5;
        int i14;
        int int;
        int i11;
        int object;
        int i17;
        int i16;
        int i9;
        int i13;
        int i6;
        int i;
        int i18;
        int i7;
        int long;
        int i8;
        int i15;
        int i2;
        long l;
        Unsafe unsafe = ba.p;
        int i20 = 1048575;
        final int i21 = 0;
        i11 = i20;
        int = i14;
        while (i10 < iArr.length) {
            int i23 = k(i10);
            i6 = this.a[i10];
            long = ba.j(i23);
            i2 = 1;
            if (long <= 17) {
            } else {
            }
            i15 = i21;
            l = (long)i24;
            object = 63;
            i10 += 3;
            if (y(t, i6, i10)) {
            }
            object = e8.y(i6, (y9)unsafe.getObject(t, l), n(i10));
            i14 += object;
            if (y(t, i6, i10)) {
            }
            long l3 = ba.l(t, l);
            i18 = e8.a(i6 <<= 3);
            object = e8.b(i67 ^= i2);
            i18 += object;
            i14 += i6;
            if (y(t, i6, i10)) {
            }
            int i25 = ba.L(t, l);
            i18 = e8.a(i6 <<= 3);
            object = e8.a(i26 ^= long);
            if (y(t, i6, i10)) {
            }
            i13 = e8.a(i6 << 3);
            i13 += 8;
            if (y(t, i6, i10)) {
            }
            i17 = e8.a(i6 << 3);
            i17 += 4;
            if (y(t, i6, i10)) {
            }
            i18 = e8.a(i6 <<= 3);
            object = e8.z(ba.L(t, l));
            if (y(t, i6, i10)) {
            }
            i18 = e8.a(i6 <<= 3);
            object = e8.a(ba.L(t, l));
            if (y(t, i6, i10)) {
            }
            i = e8.a(i6 <<= 3);
            i8 = e8.a((x7)unsafe.getObject(t, l).g());
            i += long;
            if (y(t, i6, i10)) {
            }
            object = la.Q(i6, unsafe.getObject(t, l), n(i10));
            if (y(t, i6, i10)) {
            }
            Object object40 = unsafe.getObject(t, l);
            if (object40 instanceof x7) {
            } else {
            }
            i18 = e8.a(i6 <<= 3);
            object = e8.C((String)object40);
            i = e8.a(i6 <<= 3);
            i8 = e8.a((x7)object40.g());
            if (y(t, i6, i10)) {
            }
            i9 = e8.a(i6 << 3);
            i9 += i2;
            if (y(t, i6, i10)) {
            }
            i17 = e8.a(i6 << 3);
            if (y(t, i6, i10)) {
            }
            i13 = e8.a(i6 << 3);
            if (y(t, i6, i10)) {
            }
            i18 = e8.a(i6 <<= 3);
            object = e8.z(ba.L(t, l));
            if (y(t, i6, i10)) {
            }
            i16 = e8.a(i6 << 3);
            i6 = e8.b(ba.l(t, l));
            i16 += i6;
            if (y(t, i6, i10)) {
            }
            i16 = e8.a(i6 << 3);
            i6 = e8.b(ba.l(t, l));
            if (y(t, i6, i10)) {
            }
            i17 = e8.a(i6 << 3);
            if (y(t, i6, i10)) {
            }
            i13 = e8.a(i6 << 3);
            s9.a(i6, unsafe.getObject(t, l), o(i10));
            object = la.L(i6, (List)unsafe.getObject(t, l), n(i10));
            object = la.V((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i7 = e8.D(i6);
            long = e8.a(object);
            i7 += long;
            object = la.T((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i7 = e8.D(i6);
            long = e8.a(object);
            object = la.K((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i7 = e8.D(i6);
            long = e8.a(object);
            object = la.I((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i7 = e8.D(i6);
            long = e8.a(object);
            object = la.G((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i7 = e8.D(i6);
            long = e8.a(object);
            object = la.Y((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i7 = e8.D(i6);
            long = e8.a(object);
            object = la.D((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i7 = e8.D(i6);
            long = e8.a(object);
            object = la.I((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i7 = e8.D(i6);
            long = e8.a(object);
            object = la.K((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i7 = e8.D(i6);
            long = e8.a(object);
            object = la.N((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i7 = e8.D(i6);
            long = e8.a(object);
            object = la.a0((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i7 = e8.D(i6);
            long = e8.a(object);
            object = la.P((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i7 = e8.D(i6);
            long = e8.a(object);
            object = la.I((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i7 = e8.D(i6);
            long = e8.a(object);
            object = la.K((List)unsafe.getObject(t, l));
            if (object > 0) {
            }
            i7 = e8.D(i6);
            long = e8.a(object);
            object = la.U(i6, (List)unsafe.getObject(t, l), i21);
            object = la.S(i6, (List)unsafe.getObject(t, l), i21);
            object = la.J(i6, (List)unsafe.getObject(t, l), i21);
            object = la.H(i6, (List)unsafe.getObject(t, l), i21);
            object = la.F(i6, (List)unsafe.getObject(t, l), i21);
            object = la.X(i6, (List)unsafe.getObject(t, l), i21);
            object = la.E(i6, (List)unsafe.getObject(t, l));
            object = la.R(i6, (List)unsafe.getObject(t, l), n(i10));
            object = la.W(i6, (List)unsafe.getObject(t, l));
            object = la.A(i6, (List)unsafe.getObject(t, l), i21);
            object = la.H(i6, (List)unsafe.getObject(t, l), i21);
            object = la.J(i6, (List)unsafe.getObject(t, l), i21);
            object = la.M(i6, (List)unsafe.getObject(t, l), i21);
            object = la.Z(i6, (List)unsafe.getObject(t, l), i21);
            object = la.O(i6, (List)unsafe.getObject(t, l), i21);
            object = la.H(i6, (List)unsafe.getObject(t, l), i21);
            object = la.J(i6, (List)unsafe.getObject(t, l), i21);
            if (int & i15 != 0) {
            }
            object = e8.y(i6, (y9)unsafe.getObject(t, l), n(i10));
            if (int & i15 != 0) {
            }
            long long2 = unsafe.getLong(t, l);
            i18 = e8.a(i6 <<= 3);
            object = e8.b(i68 ^= i2);
            if (int & i15 != 0) {
            }
            int int3 = unsafe.getInt(t, l);
            i18 = e8.a(i6 <<= 3);
            object = e8.a(i29 ^= long);
            if (int & i15 != 0) {
            }
            i13 = e8.a(i6 << 3);
            if (int & i15 != 0) {
            }
            i17 = e8.a(i6 << 3);
            if (int & i15 != 0) {
            }
            i18 = e8.a(i6 <<= 3);
            object = e8.z(unsafe.getInt(t, l));
            if (int & i15 != 0) {
            }
            i18 = e8.a(i6 <<= 3);
            object = e8.a(unsafe.getInt(t, l));
            if (int & i15 != 0) {
            }
            i = e8.a(i6 <<= 3);
            i8 = e8.a((x7)unsafe.getObject(t, l).g());
            if (int & i15 != 0) {
            }
            object = la.Q(i6, unsafe.getObject(t, l), n(i10));
            if (int & i15 != 0) {
            }
            Object object41 = unsafe.getObject(t, l);
            if (object41 instanceof x7) {
            } else {
            }
            i18 = e8.a(i6 <<= 3);
            object = e8.C((String)object41);
            i = e8.a(i6 <<= 3);
            i8 = e8.a((x7)object41.g());
            if (int & i15 != 0) {
            }
            i9 = e8.a(i6 << 3);
            if (int & i15 != 0) {
            }
            i17 = e8.a(i6 << 3);
            if (int & i15 != 0) {
            }
            i13 = e8.a(i6 << 3);
            if (int & i15 != 0) {
            }
            i18 = e8.a(i6 <<= 3);
            object = e8.z(unsafe.getInt(t, l));
            if (int & i15 != 0) {
            }
            i16 = e8.a(i6 << 3);
            i6 = e8.b(unsafe.getLong(t, l));
            if (int & i15 != 0) {
            }
            i16 = e8.a(i6 << 3);
            i6 = e8.b(unsafe.getLong(t, l));
            if (int & i15 != 0) {
            }
            i17 = e8.a(i6 << 3);
            if (int & i15 != 0) {
            }
            i13 = e8.a(i6 << 3);
            int i70 = this.a[i10 + 2];
            l = i70 & i20;
            i15 = i2 << i71;
            if (l != i11) {
            }
            int = unsafe.getInt(t, (long)l);
            i11 = l;
        }
        com.google.android.gms.internal.measurement.xa xaVar = this.l;
        if (this.f) {
        } else {
            return i14 += i19;
        }
        this.m.a(t);
        throw 0;
    }

    private final int K(T t) {
        int i13;
        int z;
        int i10;
        int i;
        int i11;
        int i14;
        int i16;
        int i2;
        int i12;
        int i17;
        int i8;
        int i5;
        int i4;
        int i3;
        int i7;
        int i9;
        int i15;
        long l;
        int i6;
        Unsafe unsafe = ba.p;
        final int i18 = 0;
        i11 = i10;
        while (i10 < iArr.length) {
            int i20 = k(i10);
            i8 = ba.j(i20);
            i7 = this.a[i10];
            l = (long)i21;
            if (i8 >= p8.zzJ.zza() && i8 <= p8.zzW.zza()) {
            }
            i14 = 63;
            i10 += 3;
            if (y(t, i7, i10)) {
            }
            i14 = e8.y(i7, (y9)hb.k(t, l), n(i10));
            i11 += i14;
            if (y(t, i7, i10)) {
            }
            l = ba.l(t, l);
            i3 = e8.a(i7 << 3);
            i14 = e8.b(i65 ^= i6);
            i3 += i14;
            i11 += i8;
            if (y(t, i7, i10)) {
            }
            int i23 = ba.L(t, l);
            i3 = e8.a(i7 << 3);
            i14 = e8.a(i24 ^= i7);
            if (y(t, i7, i10)) {
            }
            i2 = e8.a(i7 << 3);
            i2 += 8;
            if (y(t, i7, i10)) {
            }
            i12 = e8.a(i7 << 3);
            i12 += 4;
            if (y(t, i7, i10)) {
            }
            i3 = e8.a(i7 << 3);
            i14 = e8.z(ba.L(t, l));
            if (y(t, i7, i10)) {
            }
            i3 = e8.a(i7 << 3);
            i14 = e8.a(ba.L(t, l));
            if (y(t, i7, i10)) {
            }
            i4 = e8.a(i7 << 3);
            i9 = e8.a((x7)hb.k(t, l).g());
            i4 += i7;
            if (y(t, i7, i10)) {
            }
            i14 = la.Q(i7, hb.k(t, l), n(i10));
            if (y(t, i7, i10)) {
            }
            Object obj2 = hb.k(t, l);
            if (obj2 instanceof x7) {
            } else {
            }
            i3 = e8.a(i7 << 3);
            i14 = e8.C((String)obj2);
            i4 = e8.a(i7 << 3);
            i9 = e8.a((x7)obj2.g());
            if (y(t, i7, i10)) {
            }
            i17 = e8.a(i7 << 3);
            i17++;
            if (y(t, i7, i10)) {
            }
            i12 = e8.a(i7 << 3);
            if (y(t, i7, i10)) {
            }
            i2 = e8.a(i7 << 3);
            if (y(t, i7, i10)) {
            }
            i3 = e8.a(i7 << 3);
            i14 = e8.z(ba.L(t, l));
            if (y(t, i7, i10)) {
            }
            i15 = e8.a(i7 <<= 3);
            i14 = e8.b(ba.l(t, l));
            i11 += i7;
            if (y(t, i7, i10)) {
            }
            i15 = e8.a(i7 <<= 3);
            i14 = e8.b(ba.l(t, l));
            if (y(t, i7, i10)) {
            }
            i12 = e8.a(i7 << 3);
            if (y(t, i7, i10)) {
            }
            i2 = e8.a(i7 << 3);
            s9.a(i7, hb.k(t, l), o(i10));
            i14 = la.L(i7, (List)hb.k(t, l), n(i10));
            i14 = la.V((List)unsafe.getObject(t, l));
            if (i14 > 0) {
            }
            i5 = e8.D(i7);
            i7 = e8.a(i14);
            i5 += i7;
            i14 = la.T((List)unsafe.getObject(t, l));
            if (i14 > 0) {
            }
            i5 = e8.D(i7);
            i7 = e8.a(i14);
            i14 = la.K((List)unsafe.getObject(t, l));
            if (i14 > 0) {
            }
            i5 = e8.D(i7);
            i7 = e8.a(i14);
            i14 = la.I((List)unsafe.getObject(t, l));
            if (i14 > 0) {
            }
            i5 = e8.D(i7);
            i7 = e8.a(i14);
            i14 = la.G((List)unsafe.getObject(t, l));
            if (i14 > 0) {
            }
            i5 = e8.D(i7);
            i7 = e8.a(i14);
            i14 = la.Y((List)unsafe.getObject(t, l));
            if (i14 > 0) {
            }
            i5 = e8.D(i7);
            i7 = e8.a(i14);
            i14 = la.D((List)unsafe.getObject(t, l));
            if (i14 > 0) {
            }
            i5 = e8.D(i7);
            i7 = e8.a(i14);
            i14 = la.I((List)unsafe.getObject(t, l));
            if (i14 > 0) {
            }
            i5 = e8.D(i7);
            i7 = e8.a(i14);
            i14 = la.K((List)unsafe.getObject(t, l));
            if (i14 > 0) {
            }
            i5 = e8.D(i7);
            i7 = e8.a(i14);
            i14 = la.N((List)unsafe.getObject(t, l));
            if (i14 > 0) {
            }
            i5 = e8.D(i7);
            i7 = e8.a(i14);
            i14 = la.a0((List)unsafe.getObject(t, l));
            if (i14 > 0) {
            }
            i5 = e8.D(i7);
            i7 = e8.a(i14);
            i14 = la.P((List)unsafe.getObject(t, l));
            if (i14 > 0) {
            }
            i5 = e8.D(i7);
            i7 = e8.a(i14);
            i14 = la.I((List)unsafe.getObject(t, l));
            if (i14 > 0) {
            }
            i5 = e8.D(i7);
            i7 = e8.a(i14);
            i14 = la.K((List)unsafe.getObject(t, l));
            if (i14 > 0) {
            }
            i5 = e8.D(i7);
            i7 = e8.a(i14);
            i14 = la.U(i7, (List)hb.k(t, l), i18);
            i14 = la.S(i7, (List)hb.k(t, l), i18);
            i14 = la.J(i7, (List)hb.k(t, l), i18);
            i14 = la.H(i7, (List)hb.k(t, l), i18);
            i14 = la.F(i7, (List)hb.k(t, l), i18);
            i14 = la.X(i7, (List)hb.k(t, l), i18);
            i14 = la.E(i7, (List)hb.k(t, l));
            i14 = la.R(i7, (List)hb.k(t, l), n(i10));
            i14 = la.W(i7, (List)hb.k(t, l));
            i14 = la.A(i7, (List)hb.k(t, l), i18);
            i14 = la.H(i7, (List)hb.k(t, l), i18);
            i14 = la.J(i7, (List)hb.k(t, l), i18);
            i14 = la.M(i7, (List)hb.k(t, l), i18);
            i14 = la.Z(i7, (List)hb.k(t, l), i18);
            i14 = la.O(i7, (List)hb.k(t, l), i18);
            i14 = la.H(i7, (List)hb.k(t, l), i18);
            i14 = la.J(i7, (List)hb.k(t, l), i18);
            if (v(t, i10)) {
            }
            i14 = e8.y(i7, (y9)hb.k(t, l), n(i10));
            if (v(t, i10)) {
            }
            l = hb.i(t, l);
            i3 = e8.a(i7 << 3);
            i14 = e8.b(i66 ^= i6);
            if (v(t, i10)) {
            }
            int i28 = hb.h(t, l);
            i3 = e8.a(i7 << 3);
            i14 = e8.a(i29 ^= i7);
            if (v(t, i10)) {
            }
            i2 = e8.a(i7 << 3);
            if (v(t, i10)) {
            }
            i12 = e8.a(i7 << 3);
            if (v(t, i10)) {
            }
            i3 = e8.a(i7 << 3);
            i14 = e8.z(hb.h(t, l));
            if (v(t, i10)) {
            }
            i3 = e8.a(i7 << 3);
            i14 = e8.a(hb.h(t, l));
            if (v(t, i10)) {
            }
            i4 = e8.a(i7 << 3);
            i9 = e8.a((x7)hb.k(t, l).g());
            if (v(t, i10)) {
            }
            i14 = la.Q(i7, hb.k(t, l), n(i10));
            if (v(t, i10)) {
            }
            Object obj3 = hb.k(t, l);
            if (obj3 instanceof x7) {
            } else {
            }
            i3 = e8.a(i7 << 3);
            i14 = e8.C((String)obj3);
            i4 = e8.a(i7 << 3);
            i9 = e8.a((x7)obj3.g());
            if (v(t, i10)) {
            }
            i17 = e8.a(i7 << 3);
            if (v(t, i10)) {
            }
            i12 = e8.a(i7 << 3);
            if (v(t, i10)) {
            }
            i2 = e8.a(i7 << 3);
            if (v(t, i10)) {
            }
            i3 = e8.a(i7 << 3);
            i14 = e8.z(hb.h(t, l));
            if (v(t, i10)) {
            }
            i15 = e8.a(i7 <<= 3);
            i14 = e8.b(hb.i(t, l));
            if (v(t, i10)) {
            }
            i15 = e8.a(i7 <<= 3);
            i14 = e8.b(hb.i(t, l));
            if (v(t, i10)) {
            }
            i12 = e8.a(i7 << 3);
            if (v(t, i10)) {
            }
            i2 = e8.a(i7 << 3);
            if (i8 <= p8.zzW.zza()) {
            }
            i16 = this.a[i10 + 2];
        }
        com.google.android.gms.internal.measurement.xa xaVar = this.l;
        return i11 += obj12;
    }

    private static <T> int L(T t, long l2) {
        return (Integer)hb.k(t, l2).intValue();
    }

    private final <K, V> int M(T t, byte[] b2Arr2, int i3, int i4, int i5, long l6, com.google.android.gms.internal.measurement.n7 n77) {
        boolean obj5;
        final Unsafe obj2 = ba.p;
        final Object obj3 = o(i5);
        final Object obj4 = obj2.getObject(t, l6);
        if ((r9)obj4.f()) {
        } else {
            obj5 = r9.a().c();
            s9.b(obj5, obj4);
            obj2.putObject(t, l6, n77);
        }
        throw 0;
    }

    private final int N(T t, byte[] b2Arr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long l10, int i11, com.google.android.gms.internal.measurement.n7 n712) {
        com.google.android.gms.internal.measurement.ya obj;
        int i;
        int valueOf;
        int str;
        Long valueOf2;
        boolean string;
        int i2;
        int i13;
        int i12;
        int i10;
        int object;
        final Object obj2 = this;
        obj = t;
        str = b2Arr2;
        valueOf2 = i3;
        valueOf = i5;
        final int i37 = i6;
        string = i7;
        final long l8 = l10;
        i13 = n712;
        final Object obj6 = obj29;
        final Unsafe unsafe = ba.p;
        long l9 = (long)i36;
        i12 = 5;
        object = 2;
        switch (i9) {
            case 51:
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return valueOf2 + 8;
                i = valueOf2;
                break;
            case 52:
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return valueOf2 + 4;
                i = valueOf2;
                break;
            case 53:
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return o7.m(str, valueOf2, obj6);
                i = valueOf2;
                break;
            case 54:
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return o7.j(str, valueOf2, obj6);
                i = valueOf2;
                break;
            case 55:
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return valueOf2 + 8;
                i = valueOf2;
                break;
            case 56:
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return valueOf2 + 4;
                i = valueOf2;
                break;
            case 57:
                i10 = 1;
                i10 = 0;
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return o7.m(str, valueOf2, obj6);
                i = valueOf2;
                break;
            case 58:
                i = o7.j(str, valueOf2, obj6);
                valueOf2 = obj6.a;
                unsafe.putObject(obj, l8, obj10);
                throw zzkh.c();
                string = new String(str, i, valueOf2, d9.a);
                unsafe.putObject(obj, l8, obj10);
                i += valueOf2;
                unsafe.putInt(obj, l9, obj14);
                i = valueOf2;
                break;
            case 59:
                i = o7.d(obj2.n(i13), str, valueOf2, i4, obj6);
                object = unsafe.getObject(obj, l8);
                object = 0;
                unsafe.putObject(obj, l8, obj10);
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                i = valueOf2;
                break;
            case 60:
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return o7.a(str, valueOf2, obj6);
                i = valueOf2;
                break;
            case 61:
                valueOf2 = obj6.a;
                string = obj2.m(i13);
                string = string.e(valueOf2);
                ba.E(t).h(valueOf, Long.valueOf((long)valueOf2));
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                i = str;
                i = valueOf2;
                break;
            case 62:
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return o7.j(str, valueOf2, obj6);
                i = valueOf2;
                break;
            case 63:
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                return o7.m(str, valueOf2, obj6);
                i = valueOf2;
                break;
            case 64:
                i = o7.c(obj2.n(i13), b2Arr2, i3, i4, i26 | 4, obj29);
                object = unsafe.getObject(obj, l8);
                object = 0;
                unsafe.putObject(obj, l8, obj10);
                unsafe.putObject(obj, l8, obj10);
                unsafe.putInt(obj, l9, obj14);
                i = valueOf2;
                break;
            default:
                i = valueOf2;
        }
        return i;
    }

    private final int O(T t, byte[] b2Arr2, int i3, int i4, com.google.android.gms.internal.measurement.n7 n75) {
        int i17;
        byte b;
        Object object;
        int cmp;
        int i;
        int i7;
        int i13;
        int z;
        int i25;
        int i18;
        int i12;
        byte[] bArr2;
        int i9;
        int i5;
        com.google.android.gms.internal.measurement.ya yaVar;
        com.google.android.gms.internal.measurement.n7 n7Var;
        int int;
        int i10;
        Unsafe unsafe2;
        int i14;
        Unsafe unsafe;
        int i19;
        com.google.android.gms.internal.measurement.n7 n7Var2;
        byte[] bArr;
        int i6;
        Object obj2;
        Object obj;
        byte b2;
        int i20;
        int i16;
        int i24;
        int i21;
        int i8;
        int i2;
        int i15;
        int i22;
        int i23;
        long l;
        Unsafe unsafe3;
        int i11;
        int obj33;
        obj = this;
        obj2 = t;
        bArr = b2Arr2;
        i6 = i4;
        n7Var2 = n75;
        unsafe = ba.p;
        final int i48 = 0;
        i17 = i3;
        i10 = i14;
        cmp = i19;
        int = i25;
        while (i17 < i6) {
            i5 = i17 + 1;
            b = bArr[i17];
            if (b < 0) {
            } else {
            }
            b2 = b;
            yaVar = i5;
            n7Var = b2 >>> 3;
            i9 = b2 & 7;
            if (n7Var > cmp) {
            } else {
            }
            i17 = obj.Q(n7Var);
            i12 = i17;
            i7 = obj.a[i12 + 1];
            i17 = ba.j(i7);
            i16 = unsafe;
            i14 = (long)i43;
            obj33 = n7Var;
            i24 = obj33;
            i15 = i7;
            i6 = i12;
            i19 = i16;
            obj33 = i9;
            obj = yaVar;
            i22 = int;
            i23 = i10;
            l = i14;
            unsafe3 = i19;
            i16 = i6;
            i20 = -1;
            unsafe = i15;
            if (this.N(t, b2Arr2, obj, i4, b2, i24, obj33, i15, unsafe, l, n7Var2, i16) != obj) {
            } else {
            }
            i18 = i17;
            int = i22;
            i10 = i23;
            i17 = o7.i(b2, b2Arr2, i18, i4, ba.E(t), n75);
            obj = this;
            obj2 = t;
            bArr = b2Arr2;
            i6 = i4;
            n7Var2 = n75;
            i19 = i20;
            i25 = i16;
            cmp = i24;
            unsafe = unsafe3;
            i14 = 1048575;
            obj = this;
            obj2 = t;
            bArr = b2Arr2;
            i6 = i4;
            n7Var2 = n75;
            i19 = i20;
            i25 = i16;
            cmp = i24;
            int = i22;
            i10 = i23;
            i10 = obj33;
            i18 = obj;
            i22 = int;
            i23 = i10;
            int i42 = i16;
            unsafe3 = i19;
            i20 = -1;
            i16 = i6;
            if (this.P(t, b2Arr2, yaVar, i4, b2, i24, i9, i6, (long)i37, i19, i17, i14) != yaVar) {
            } else {
            }
            if (i9 == 2) {
            } else {
            }
            obj = yaVar;
            i22 = int;
            i23 = i10;
            unsafe3 = i19;
            i16 = i6;
            i20 = -1;
            object = i19.getObject(obj2, i14);
            if (!(c9)object.zzc()) {
            }
            i17 = o7.e(obj.n(i6), b2, b2Arr2, yaVar, i4, object, n75);
            int = i14;
            unsafe = i19;
            i25 = i6;
            i14 = i16;
            cmp = i24;
            i19 = -1;
            i6 = i4;
            int size = object.size();
            if (size == 0) {
            } else {
            }
            size += size;
            i19.putObject(obj2, i14, unsafe);
            z = 10;
            int i45 = obj.a[i12 + 2];
            n7Var = 1;
            i8 = n7Var << i50;
            int i47 = 1048575;
            i45 &= i47;
            if (i46 != i10) {
            } else {
            }
            i15 = i7;
            i21 = i12;
            i19 = i16;
            cmp = 5;
            i16 = i47;
            i6 = i21;
            i24 = obj33;
            i18 = yaVar;
            unsafe3 = i19;
            i16 = i6;
            i20 = -1;
            if (i9 == 0) {
            } else {
            }
            i6 = i21;
            i24 = obj33;
            i16 = 1048575;
            i24 = obj33;
            i19.putLong(t, i14, i9);
            int |= i8;
            unsafe = i19;
            i25 = i6;
            i17 = b2;
            cmp = i24;
            i14 = 1048575;
            i6 = i21;
            i24 = obj33;
            if (i9 == 0) {
            } else {
            }
            i17 = o7.j(bArr, yaVar, n7Var2);
            i19.putInt(obj2, i14, unsafe);
            int |= i8;
            unsafe = i19;
            i25 = i6;
            i6 = i21;
            i24 = obj33;
            if (i9 == 0) {
            } else {
            }
            i17 = o7.j(bArr, yaVar, n7Var2);
            i19.putInt(obj2, i14, unsafe);
            i6 = i21;
            i24 = obj33;
            if (i9 == 2) {
            } else {
            }
            i17 = o7.a(bArr, yaVar, n7Var2);
            i19.putObject(obj2, i14, unsafe);
            i24 = obj33;
            if (i9 == 2) {
            } else {
            }
            i12 = i4;
            i16 = 1048575;
            i17 = o7.d(obj.n(i21), bArr, yaVar, i4, n7Var2);
            Object object2 = i19.getObject(obj2, i14);
            if (object2 == null) {
            } else {
            }
            i19.putObject(obj2, i14, unsafe);
            int |= i8;
            unsafe = i19;
            i14 = i16;
            cmp = i24;
            i19 = -1;
            i6 = i12;
            i25 = i11;
            i19.putObject(obj2, i14, unsafe);
            i12 = i4;
            i16 = i47;
            i6 = i21;
            i24 = obj33;
            if (i9 == 2) {
            } else {
            }
            if (i15 & i28 == 0) {
            } else {
            }
            i17 = o7.h(bArr, yaVar, n7Var2);
            i19.putObject(obj2, i14, unsafe);
            i17 = o7.g(bArr, yaVar, n7Var2);
            i12 = i4;
            i16 = i47;
            i6 = i21;
            i24 = obj33;
            if (i9 == 0) {
            } else {
            }
            i17 = o7.m(bArr, yaVar, n7Var2);
            if (Long.compare(i9, i2) != 0) {
            } else {
            }
            n7Var = i48;
            hb.r(obj2, i14, unsafe);
            i12 = i4;
            i16 = i47;
            i6 = i21;
            i24 = obj33;
            if (i9 == cmp) {
            } else {
            }
            i19.putInt(obj2, i14, unsafe);
            i17 = yaVar + 4;
            i12 = i4;
            i16 = i47;
            i6 = i21;
            i24 = obj33;
            if (i9 == n7Var) {
            } else {
            }
            i19.putLong(t, i14, i9);
            i17 = i14 + 8;
            int |= i8;
            i16 = i47;
            i6 = i21;
            i24 = obj33;
            if (i9 == 0) {
            } else {
            }
            i17 = o7.j(bArr, yaVar, n7Var2);
            i19.putInt(obj2, i14, unsafe);
            i16 = i47;
            i24 = obj33;
            if (i9 == 0) {
            } else {
            }
            i19.putLong(t, i14, i9);
            int |= i8;
            unsafe = i19;
            i25 = i6;
            i17 = b2;
            i16 = i47;
            i6 = i21;
            i24 = obj33;
            if (i9 == cmp) {
            } else {
            }
            hb.u(obj2, i14, unsafe);
            i17 = yaVar + 4;
            i16 = i47;
            i6 = i21;
            i24 = obj33;
            if (i9 == n7Var) {
            } else {
            }
            hb.t(obj2, i14, unsafe);
            i17 = yaVar + 8;
            i15 = i7;
            i21 = i12;
            if (i10 != i47) {
            } else {
            }
            unsafe2 = i16;
            if (i46 != i47) {
            }
            i19 = unsafe2;
            i10 = i11;
            int = unsafe2.getInt(obj2, (long)i46);
            i16.putInt(obj2, (long)i10, i12);
            i18 = yaVar;
            i24 = n7Var;
            unsafe3 = unsafe;
            i20 = i19;
            i16 = i48;
            i17 = obj.R(n7Var, i25 /= 3);
            yaVar = b;
            b2 = i5;
        }
        if (i10 != i14) {
            unsafe.putInt(t, (long)i10, i25);
        }
        if (i17 != i4) {
        } else {
            return i17;
        }
        throw zzkh.e();
    }

    private final int P(T t, byte[] b2Arr2, int i3, int i4, int i5, int i6, int i7, int i8, long l9, int i10, long l11, com.google.android.gms.internal.measurement.n7 n712) {
        int i15;
        Object obj3;
        int i16;
        int i17;
        int i12;
        int i9;
        float intBitsToFloat;
        int i2;
        int i20;
        byte[] bArr;
        com.google.android.gms.internal.measurement.ya zzc;
        int i11;
        int longBitsToDouble;
        int i13;
        com.google.android.gms.internal.measurement.x7 i19;
        int i18;
        long l2;
        int i21;
        int str;
        int i;
        Object obj2;
        long l4;
        long l;
        long l5;
        double longBitsToDouble2;
        Object obj;
        int string;
        long l3;
        int string2;
        java.nio.charset.Charset i14;
        Object object;
        boolean z;
        com.google.android.gms.internal.measurement.ja obj21;
        byte[] obj22;
        int obj23;
        int obj24;
        int obj25;
        com.google.android.gms.internal.measurement.n7 obj26;
        obj3 = t;
        bArr = b2Arr2;
        longBitsToDouble = i3;
        l2 = i4;
        i20 = i5;
        str = i7;
        string = i8;
        long l15 = n712;
        obj2 = obj29;
        final Unsafe unsafe = ba.p;
        object = unsafe.getObject(obj3, l15);
        if (!(c9)object.zzc()) {
            int size = object.size();
            z = size == 0 ? 10 : size + size;
            unsafe.putObject(obj3, l15, obj10);
        }
        string2 = 5;
        i14 = 0;
        int i46 = 1;
        final int i47 = 2;
        switch (l11) {
            case 18:
                i35 += i15;
                (g8)object.d(Double.longBitsToDouble(o7.n(bArr, i15)));
                i15 += 8;
                throw zzkh.f();
                (g8)object.d(Double.longBitsToDouble(o7.n(b2Arr2, i3)));
                obj3 = longBitsToDouble + 8;
                object.d(Double.longBitsToDouble(o7.n(bArr, o7.j(bArr, obj3, obj2))));
                return obj3;
                return i15;
            case 19:
                i36 += i15;
                (q8)object.d(Float.intBitsToFloat(o7.b(bArr, i15)));
                i15 += 4;
                throw zzkh.f();
                (q8)object.d(Float.intBitsToFloat(o7.b(b2Arr2, i3)));
                int i26 = longBitsToDouble + 4;
                object.d(Float.intBitsToFloat(o7.b(bArr, o7.j(bArr, i26, obj2))));
                return i26;
                return i15;
            case 20:
                i37 += i15;
                i15 = o7.m(bArr, i15, obj2);
                (m9)object.g(obj2.b);
                throw zzkh.f();
                i2 = o7.m(bArr, longBitsToDouble, obj2);
                (m9)object.g(obj2.b);
                i2 = o7.m(bArr, o7.j(bArr, i2, obj2), obj2);
                object.g(obj2.b);
                return i2;
                return i15;
            case 21:
                i15 = o7.f(bArr, longBitsToDouble, object, obj2);
                return o7.l(i5, b2Arr2, i3, i4, object, obj29);
                return i15;
            case 22:
                i30 += i15;
                (m9)object.g(o7.n(bArr, i15));
                i15 += 8;
                throw zzkh.f();
                (m9)object.g(o7.n(b2Arr2, i3));
                obj3 = longBitsToDouble + 8;
                object.g(o7.n(bArr, o7.j(bArr, obj3, obj2)));
                return obj3;
                return i15;
            case 23:
                i32 += i15;
                (x8)object.h(o7.b(bArr, i15));
                i15 += 4;
                throw zzkh.f();
                (x8)object.h(o7.b(b2Arr2, i3));
                int i24 = longBitsToDouble + 4;
                object.h(o7.b(bArr, o7.j(bArr, i24, obj2)));
                return i24;
                return i15;
            case 24:
                obj3 = 0;
                i38 += i20;
                i20 = o7.m(bArr, i20, obj2);
                l2 = i46;
                l2 = obj3;
                (p7)object.d(l2);
                i15 = i20;
                throw zzkh.f();
                i11 = o7.m(bArr, longBitsToDouble, obj2);
                i21 = i46;
                i21 = obj3;
                (p7)object.d(i21);
                i11 = o7.m(bArr, o7.j(bArr, i11, obj2), obj2);
                i21 = i46;
                i21 = obj3;
                object.d(i21);
                return i11;
                return i15;
            case 25:
                str = "";
                longBitsToDouble = obj2.a;
                object.add(str);
                string = new String(bArr, o7.j(bArr, longBitsToDouble, obj2), longBitsToDouble, d9.a);
                object.add(string);
                i15 += longBitsToDouble;
                longBitsToDouble = obj2.a;
                object.add(str);
                string = new String(bArr, o7.j(bArr, o7.j(bArr, i15, obj2), obj2), longBitsToDouble, d9.a);
                object.add(string);
                throw zzkh.d();
                throw zzkh.d();
                i15 = o7.j(bArr, longBitsToDouble, obj2);
                longBitsToDouble = obj2.a;
                object.add(str);
                string2 = new String(bArr, i15, longBitsToDouble, d9.a);
                object.add(string2);
                i15 = string;
                i15 = o7.j(bArr, o7.j(bArr, i15, obj2), obj2);
                longBitsToDouble = obj2.a;
                object.add(str);
                string2 = new String(bArr, i15, longBitsToDouble, d9.a);
                object.add(string2);
                throw zzkh.c();
                throw zzkh.d();
                throw zzkh.c();
                throw zzkh.d();
                return i15;
            case 26:
                return o7.e(n(string), i5, b2Arr2, i3, i4, object, obj29);
            case 27:
                i9 = o7.j(bArr, longBitsToDouble, obj2);
                i19 = obj2.a;
                object.add(x7.a);
                object.add(x7.t(bArr, i9, i19));
                i9 += i19;
                i9 = o7.j(bArr, o7.j(bArr, i9, obj2), obj2);
                i19 = obj2.a;
                object.add(x7.a);
                object.add(x7.t(bArr, i9, i19));
                throw zzkh.f();
                throw zzkh.d();
                return i9;
                throw zzkh.f();
                throw zzkh.d();
            case 28:
                i20 = o7.f(bArr, longBitsToDouble, object, obj2);
                i20 = o7.l(i5, b2Arr2, i3, i4, object, obj29);
                zzc = 0;
                bArr = la.c(i6, object, m(string), zzc, obj4.l);
                obj3.zzc = (ya)bArr;
                return i20;
                i15 = i20;
                return i15;
            case 29:
                i33 += i15;
                i15 = o7.j(bArr, i15, obj2);
                (x8)object.h(b8.a(obj2.a));
                throw zzkh.f();
                i17 = o7.j(bArr, longBitsToDouble, obj2);
                (x8)object.h(b8.a(obj2.a));
                i17 = o7.j(bArr, o7.j(bArr, i17, obj2), obj2);
                object.h(b8.a(obj2.a));
                return i17;
                return i15;
            case 30:
                i34 += i15;
                i15 = o7.m(bArr, i15, obj2);
                (m9)object.g(b8.b(obj2.b));
                throw zzkh.f();
                i12 = o7.m(bArr, longBitsToDouble, obj2);
                (m9)object.g(b8.b(obj2.b));
                i12 = o7.m(bArr, o7.j(bArr, i12, obj2), obj2);
                object.g(b8.b(obj2.b));
                return i12;
                return i15;
            default:
                com.google.android.gms.internal.measurement.ja jaVar = n(string);
                i43 |= 4;
                i18 = o7.c(jaVar, b2Arr2, i3, i4, i44, obj29);
                object.add(obj2.c);
                i18 = o7.c(jaVar, b2Arr2, o7.j(bArr, i18, obj2), i4, i44, obj29);
                object.add(obj2.c);
                return i18;
        }
        i15 = longBitsToDouble;
    }

    private final int Q(int i) {
        int i2;
        if (i >= this.c && i <= this.d) {
            if (i <= this.d) {
                return T(i, 0);
            }
        }
        return -1;
    }

    private final int R(int i, int i2) {
        int i3;
        if (i >= this.c && i <= this.d) {
            if (i <= this.d) {
                return T(i, i2);
            }
        }
        return -1;
    }

    private final int S(int i) {
        return this.a[i += 2];
    }

    private final int T(int i, int i2) {
        int i5;
        int i4;
        int i6;
        int i3;
        int obj7;
        final int i8 = -1;
        i7 += i8;
        while (obj7 <= i5) {
            i9 >>>= 1;
            i6 = i10 * 3;
            i3 = this.a[i6];
            if (i < i3) {
            } else {
            }
            obj7 = i4;
            i5 = i4;
        }
        return i8;
    }

    private static int j(int i) {
        return obj0 &= 255;
    }

    private final int k(int i) {
        return this.a[i++];
    }

    private static <T> long l(T t, long l2) {
        return (Long)hb.k(t, l2).longValue();
    }

    private final com.google.android.gms.internal.measurement.z8 m(int i) {
        i /= 3;
        return (z8)this.b[obj2++];
    }

    private final com.google.android.gms.internal.measurement.ja n(int i) {
        i /= 3;
        obj4 += obj4;
        Object obj = this.b[obj4];
        if ((ja)obj != null) {
            return (ja)obj;
        }
        com.google.android.gms.internal.measurement.ja jaVar = ga.a().b((Class)this.b[obj4 + 1]);
        this.b[obj4] = jaVar;
        return jaVar;
    }

    private final Object o(int i) {
        i /= 3;
        return this.b[obj2 += obj2];
    }

    private static Field p(Class<?> class, String string2) {
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

    private final void q(T t, T t2, int i3) {
        final int i4 = 1048575;
        long l = (long)i2;
        if (!v(t2, i3)) {
        }
        Object obj = hb.k(t, l);
        Object obj5 = hb.k(t2, l);
        if (obj != null && obj5 == null) {
            if (obj5 == null) {
            }
            hb.x(t, l, i4);
            s(t, i3);
        }
        if (obj5 != null) {
            hb.x(t, l, i4);
            s(t, i3);
        }
    }

    private final void r(T t, T t2, int i3) {
        Object obj;
        int i4 = this.a[i3];
        long l = (long)i2;
        if (!y(t2, i4, i3)) {
        }
        if (y(t, i4, i3)) {
            obj = hb.k(t, l);
        } else {
            obj = 0;
        }
        Object obj6 = hb.k(t2, l);
        if (obj != null && obj6 == null) {
            if (obj6 == null) {
            }
            hb.x(t, l, obj3);
            t(t, i4, i3);
        }
        if (obj6 != null) {
            hb.x(t, l, obj3);
            t(t, i4, i3);
        }
    }

    private final void s(T t, int i2) {
        int obj6 = S(i2);
        long l = (long)i3;
        if (Long.compare(l, i4) == 0) {
        }
        hb.v(t, l, obj1);
    }

    private final void t(T t, int i2, int i3) {
        hb.v(t, (long)obj5, obj1);
    }

    private final boolean u(T t, T t2, int i3) {
        if (v(t, i3) == v(t2, i3)) {
            return 1;
        }
        return 0;
    }

    private final boolean v(T t, int i2) {
        int i = S(i2);
        final int i4 = 1048575;
        long l2 = (long)i5;
        final int i8 = 0;
        final int i9 = 1;
        if (Long.compare(l2, i7) == 0) {
            int obj9 = k(i2);
            long l = (long)i3;
            obj9 = ba.j(obj9);
            int i6 = 0;
            switch (obj9) {
                case 0:
                    return i9;
                    return i8;
                case 1:
                    return i9;
                    return i8;
                case 2:
                    return i9;
                    return i8;
                case 3:
                    return i9;
                    return i8;
                case 4:
                    return i9;
                    return i8;
                case 5:
                    return i9;
                    return i8;
                case 6:
                    return i9;
                    return i8;
                case 7:
                    return hb.B(t, l);
                case 8:
                    Object obj8 = hb.k(t, l);
                    return i9;
                    return i8;
                    return i9;
                    return i8;
                    obj8 = new IllegalArgumentException();
                    throw obj8;
                case 9:
                    return i9;
                    return i8;
                case 10:
                    return i9;
                    return i8;
                case 11:
                    return i9;
                    return i8;
                case 12:
                    return i9;
                    return i8;
                case 13:
                    return i9;
                    return i8;
                case 14:
                    return i9;
                    return i8;
                case 15:
                    return i9;
                    return i8;
                case 16:
                    return i9;
                    return i8;
                case 17:
                    return i9;
                    return i8;
                default:
                    obj8 = new IllegalArgumentException();
                    throw obj8;
            }
        }
        if (obj8 &= obj9 != 0) {
            return i9;
        }
        return i8;
    }

    private final boolean w(T t, int i2, int i3, int i4, int i5) {
        if (i3 == 1048575) {
            return v(t, i2);
        }
        if (i4 & i5 != 0) {
            return 1;
        }
        return 0;
    }

    private static boolean x(Object object, int i2, com.google.android.gms.internal.measurement.ja ja3) {
        return ja3.f(hb.k(object, (long)obj3));
    }

    private final boolean y(T t, int i2, int i3) {
        if (hb.h(t, (long)obj5) == i2) {
            return 1;
        }
        return 0;
    }

    private static <T> boolean z(T t, long l2) {
        return (Boolean)hb.k(t, l2).booleanValue();
    }

    final int D(T t, byte[] b2Arr2, int i3, int i4, int i5, com.google.android.gms.internal.measurement.n7 n76) {
        int i14;
        byte b2;
        boolean z;
        Unsafe unsafe2;
        Object object;
        int i16;
        int i9;
        int i2;
        byte[] bArr;
        boolean z2;
        int i17;
        Object obj4;
        byte[] bArr2;
        int i10;
        int i11;
        Object obj5;
        com.google.android.gms.internal.measurement.ya yaVar;
        int int;
        com.google.android.gms.internal.measurement.n7 n7Var;
        int i15;
        byte b5;
        byte b3;
        Object n7Var2;
        Object obj8;
        Unsafe unsafe3;
        Object obj2;
        byte b;
        int i20;
        int i22;
        int i8;
        byte[] bArr3;
        Object obj9;
        Object obj;
        Object obj6;
        Object obj7;
        Object obj3;
        int i7;
        int i18;
        int i19;
        int i21;
        byte b4;
        int i6;
        int i12;
        long l;
        int i13;
        Unsafe unsafe;
        int i;
        int obj31;
        obj3 = this;
        obj7 = t;
        bArr3 = b2Arr2;
        obj6 = i4;
        b = i5;
        n7Var2 = n76;
        unsafe3 = ba.p;
        final int i57 = 0;
        i14 = i3;
        int = i10;
        i17 = -1;
        i15 = 1048575;
        i7 = 0;
        while (i14 < obj6) {
            b2 = bArr3[i14];
            if (b2 < 0) {
            } else {
            }
            yaVar = b2;
            i14 = yaVar >>> 3;
            b5 = yaVar & 7;
            if (i14 > i17) {
            } else {
            }
            i17 = obj3.Q(i14);
            i10 = -1;
            int i41 = obj3.a[i17 + 1];
            int i53 = ba.j(i41);
            i21 = i14;
            i6 = i41;
            b4 = yaVar;
            i10 = (long)i23;
            bArr3 = i10;
            i10 = i53;
            yaVar = i21;
            b = b4;
            i19 = -1;
            b3 = i17;
            int i40 = i2;
            int = i40;
            i15 = yaVar;
            obj3 = int;
            i18 = b3;
            unsafe = unsafe3;
            i13 = i19;
            n7Var2 = i19;
            b5 = i5;
            i17 = i14;
            i15 = b4;
            b3 = i6;
            Object obj18 = this;
            obj = t;
            i20 = obj31;
            obj2 = n76;
            i14 = o7.i(b3, b2Arr2, i17, i4, ba.E(t), n76);
            obj6 = i4;
            i9 = b3;
            obj3 = obj18;
            n7Var2 = obj2;
            i17 = i20;
            obj7 = obj;
            i10 = i18;
            int = i21;
            unsafe3 = unsafe;
            bArr3 = b2Arr2;
            b = b5;
            i7 = 0;
            obj2 = n76;
            obj = t;
            i20 = obj31;
            i14 = o7.i(b3, b2Arr2, i17, i4, ba.E(t), n76);
            obj = t;
            obj3 = this;
            obj7 = t;
            bArr3 = b2Arr2;
            i17 = obj31;
            obj6 = i4;
            b = i5;
            n7Var2 = n76;
            i10 = i18;
            int = i21;
            i15 = b4;
            i9 = i6;
            unsafe3 = unsafe;
            b5 = i5;
            i17 = obj3;
            obj31 = i15;
            i18 = b3;
            i13 = i19;
            unsafe = unsafe3;
            i6 = b;
            i21 = int;
            b4 = i15;
            obj3 = i40;
            obj31 = yaVar;
            i18 = b3;
            unsafe = unsafe3;
            i6 = b;
            i13 = i19;
            object = unsafe3.getObject(obj7, bArr3);
            if (!(c9)object.zzc()) {
            }
            i14 = o7.e(obj3.n(b3), b, b2Arr2, i40, i4, object, n76);
            obj6 = i4;
            i10 = b3;
            i17 = i56;
            int = i21;
            i15 = b4;
            bArr3 = b2Arr2;
            b = i5;
            int size = object.size();
            if (size == 0) {
            } else {
            }
            size += size;
            unsafe3.putObject(obj7, bArr3, obj6);
            z2 = 10;
            int i25 = obj3.a[i17 + 2];
            i12 = i55 << i60;
            i22 = 1048575;
            i25 &= i22;
            if (i26 != i15) {
            } else {
            }
            i8 = i15;
            int i51 = int;
            i14 = 5;
            bArr3 = b2Arr2;
            b = b4;
            i19 = -1;
            b5 = i5;
            i18 = b3;
            unsafe = unsafe3;
            b3 = b;
            i13 = i19;
            i15 = obj31;
            obj31 = i21;
            i21 = i;
            long l11 = i10;
            i14 = o7.c(obj3.n(i17), b2Arr2, i2, i4, i36 | 4, n76);
            if (i51 & i12 == 0) {
            } else {
            }
            unsafe3.putObject(obj7, l11, obj6);
            int = i51 | i12;
            bArr3 = b2Arr2;
            i15 = obj31;
            obj6 = i4;
            i10 = b3;
            i9 = b;
            i17 = i21;
            unsafe3.putObject(obj7, l11, obj6);
            bArr3 = b2Arr2;
            b3 = i17;
            obj31 = i8;
            b = b4;
            i19 = -1;
            i17 = i2;
            b5 = o7.m(b2Arr2, i2, n7Var2);
            int i54 = i21;
            int = i17;
            i19 = -1;
            obj31 = i8;
            b = b4;
            b3 = int;
            unsafe3.putLong(t, i10, i10);
            int = i51 | i12;
            i15 = obj31;
            i14 = b5;
            b3 = i17;
            obj31 = i8;
            b = b4;
            i19 = -1;
            i14 = o7.j(b2Arr2, i2, n7Var2);
            unsafe3.putInt(obj7, i10, yaVar);
            int = i51 | i12;
            i15 = obj31;
            b3 = i17;
            b = b4;
            i19 = -1;
            i14 = o7.j(b2Arr2, i2, n7Var2);
            i2 = n7Var2.a;
            i17 = obj3.m(b3);
            if (i17 != null) {
            } else {
            }
            unsafe3.putInt(obj7, i10, yaVar);
            if (i17.e(i2)) {
            } else {
            }
            ba.E(t).h(b, Long.valueOf((long)i2));
            int = i51;
            i10 = b3;
            i9 = b;
            i17 = i21;
            i15 = obj31;
            b3 = i17;
            obj31 = i8;
            b = b4;
            i19 = -1;
            i14 = o7.a(b2Arr2, i2, n7Var2);
            unsafe3.putObject(obj7, i10, yaVar);
            obj31 = i8;
            b = b4;
            i19 = -1;
            i14 = o7.d(obj3.n(i17), b2Arr2, i2, obj6, n7Var2);
            if (i51 & i12 == 0) {
            } else {
            }
            unsafe3.putObject(obj7, i10, yaVar);
            unsafe3.putObject(obj7, i10, yaVar);
            bArr3 = b2Arr2;
            b3 = i17;
            obj31 = i8;
            b = b4;
            i19 = -1;
            if (i6 & i27 == 0) {
            } else {
            }
            i14 = o7.h(bArr3, i2, n7Var2);
            unsafe3.putObject(obj7, i10, yaVar);
            i14 = o7.g(bArr3, i2, n7Var2);
            b3 = i17;
            obj31 = i8;
            b = b4;
            i19 = -1;
            i14 = o7.m(b2Arr2, i2, n7Var2);
            if (Long.compare(l4, b4) != 0) {
            } else {
            }
            i2 = i57;
            hb.r(obj7, i10, yaVar);
            i2 = 1;
            b3 = i17;
            obj31 = i8;
            b = b4;
            i19 = -1;
            unsafe3.putInt(obj7, i10, yaVar);
            i14 = i2 + 4;
            b3 = i17;
            obj31 = i8;
            b = b4;
            i19 = -1;
            unsafe3.putLong(t, i10, i10);
            i14 = b5 + 8;
            b3 = i17;
            obj31 = i8;
            b = b4;
            i19 = -1;
            i14 = o7.j(b2Arr2, i2, n7Var2);
            unsafe3.putInt(obj7, i10, yaVar);
            b3 = i17;
            obj31 = i8;
            b = b4;
            i19 = -1;
            b5 = o7.m(b2Arr2, i2, n7Var2);
            unsafe3.putLong(t, i10, i10);
            b3 = i17;
            obj31 = i8;
            b = b4;
            i19 = -1;
            i17 = i2;
            hb.u(obj7, i10, yaVar);
            i14 = i17 + 4;
            b3 = i17;
            obj31 = i8;
            b = b4;
            i19 = -1;
            i17 = i2;
            hb.t(obj7, i10, yaVar);
            i14 = i17 + 8;
            if (i15 != i22) {
            }
            int = unsafe3.getInt(obj7, (long)i26);
            i8 = i26;
            unsafe3.putInt(obj7, (long)i15, bArr3);
            obj31 = i14;
            i17 = i2;
            i13 = i10;
            b3 = yaVar;
            i21 = int;
            unsafe = unsafe3;
            b5 = b;
            i18 = i57;
            i17 = obj3.R(i14, i10 /= i52);
            yaVar = i38;
            i2 = b2;
        }
        i21 = int;
        b4 = i15;
        unsafe = unsafe3;
        b5 = b;
        obj9 = obj7;
        obj8 = obj3;
        int i39 = 1048575;
        if (i15 != i39) {
            unsafe.putInt(obj9, (long)i15, yaVar);
        }
        i11 = obj8.i;
        while (i11 < obj8.j) {
            yaVar = obj8.h[i11];
            int i46 = obj8.a[yaVar];
            i11++;
        }
        if (b5 == 0) {
            if (i14 != i4) {
            } else {
                return i14;
            }
            throw zzkh.e();
        }
        if (i14 > i4) {
        } else {
            if (i9 != b5) {
            } else {
            }
        }
        throw zzkh.e();
    }

    public final T a() {
        final int i2 = 0;
        return (w8)this.e.v(4, i2, i2);
    }

    public final int b(T t) {
        int length;
        int i;
        int i6;
        int i3;
        boolean floatToIntBits;
        int i5;
        long l;
        int i2;
        i6 = i;
        while (i < iArr.length) {
            int i11 = k(i);
            i5 = this.a[i];
            l = (long)i13;
            i2 = 37;
            i += 3;
            if (y(t, i5, i)) {
            }
            i6 *= 53;
            floatToIntBits = hb.k(t, l).hashCode();
            i3 += floatToIntBits;
            if (y(t, i5, i)) {
            }
            i6 *= 53;
            floatToIntBits = d9.c(ba.l(t, l));
            if (y(t, i5, i)) {
            }
            i6 *= 53;
            floatToIntBits = ba.L(t, l);
            if (y(t, i5, i)) {
            }
            i6 *= 53;
            floatToIntBits = d9.c(ba.l(t, l));
            if (y(t, i5, i)) {
            }
            i6 *= 53;
            floatToIntBits = ba.L(t, l);
            if (y(t, i5, i)) {
            }
            i6 *= 53;
            floatToIntBits = ba.L(t, l);
            if (y(t, i5, i)) {
            }
            i6 *= 53;
            floatToIntBits = ba.L(t, l);
            if (y(t, i5, i)) {
            }
            i6 *= 53;
            floatToIntBits = hb.k(t, l).hashCode();
            if (y(t, i5, i)) {
            }
            i6 *= 53;
            floatToIntBits = hb.k(t, l).hashCode();
            if (y(t, i5, i)) {
            }
            i6 *= 53;
            floatToIntBits = (String)hb.k(t, l).hashCode();
            if (y(t, i5, i)) {
            }
            i6 *= 53;
            floatToIntBits = d9.a(ba.z(t, l));
            if (y(t, i5, i)) {
            }
            i6 *= 53;
            floatToIntBits = ba.L(t, l);
            if (y(t, i5, i)) {
            }
            i6 *= 53;
            floatToIntBits = d9.c(ba.l(t, l));
            if (y(t, i5, i)) {
            }
            i6 *= 53;
            floatToIntBits = ba.L(t, l);
            if (y(t, i5, i)) {
            }
            i6 *= 53;
            floatToIntBits = d9.c(ba.l(t, l));
            if (y(t, i5, i)) {
            }
            i6 *= 53;
            floatToIntBits = d9.c(ba.l(t, l));
            if (y(t, i5, i)) {
            }
            i6 *= 53;
            floatToIntBits = Float.floatToIntBits(ba.I(t, l));
            if (y(t, i5, i)) {
            }
            i6 *= 53;
            floatToIntBits = d9.c(Double.doubleToLongBits(ba.H(t, l)));
            i6 *= 53;
            floatToIntBits = hb.k(t, l).hashCode();
            i6 *= 53;
            floatToIntBits = hb.k(t, l).hashCode();
            floatToIntBits = hb.k(t, l);
            if (floatToIntBits != null) {
            }
            i10 += i2;
            i2 = floatToIntBits.hashCode();
            i6 *= 53;
            floatToIntBits = d9.c(hb.i(t, l));
            i6 *= 53;
            floatToIntBits = hb.h(t, l);
            i6 *= 53;
            floatToIntBits = d9.c(hb.i(t, l));
            i6 *= 53;
            floatToIntBits = hb.h(t, l);
            i6 *= 53;
            floatToIntBits = hb.h(t, l);
            i6 *= 53;
            floatToIntBits = hb.h(t, l);
            i6 *= 53;
            floatToIntBits = hb.k(t, l).hashCode();
            floatToIntBits = hb.k(t, l);
            if (floatToIntBits != null) {
            }
            i2 = floatToIntBits.hashCode();
            i6 *= 53;
            floatToIntBits = (String)hb.k(t, l).hashCode();
            i6 *= 53;
            floatToIntBits = d9.a(hb.B(t, l));
            i6 *= 53;
            floatToIntBits = hb.h(t, l);
            i6 *= 53;
            floatToIntBits = d9.c(hb.i(t, l));
            i6 *= 53;
            floatToIntBits = hb.h(t, l);
            i6 *= 53;
            floatToIntBits = d9.c(hb.i(t, l));
            i6 *= 53;
            floatToIntBits = d9.c(hb.i(t, l));
            i6 *= 53;
            floatToIntBits = Float.floatToIntBits(hb.g(t, l));
            i6 *= 53;
            floatToIntBits = d9.c(Double.doubleToLongBits(hb.f(t, l)));
        }
        if (this.f) {
        } else {
            return i8 += i7;
        }
        this.m.a(t);
        throw 0;
    }

    public final void c(T t) {
        int i;
        boolean z;
        long l;
        int i3;
        int i2;
        Object obj2;
        Object obj;
        i = this.i;
        while (i < this.j) {
            i2 = 1048575;
            l = (long)i6;
            obj2 = hb.k(t, l);
            if (obj2 != null) {
            }
            i++;
            (r9)obj2.d();
            hb.x(t, l, i2);
        }
        while (i3 < iArr.length) {
            this.k.a(t, (long)i7);
            i3++;
        }
        this.l.g(t);
        if (this.f) {
            this.m.b(t);
        }
    }

    public final int d(T t) {
        int obj2;
        if (this.g) {
            obj2 = K(t);
        } else {
            obj2 = J(t);
        }
        return obj2;
    }

    public final void e(T t, T t2) {
        int i3;
        android.os.Parcelable.Creator creator;
        long l;
        int i;
        Objects.requireNonNull(t2);
        i3 = 0;
        while (i3 < iArr.length) {
            int i4 = k(i3);
            l = (long)i6;
            i = this.a[i3];
            i3 += 3;
            r(t, t2, i3);
            if (y(t2, i, i3)) {
            }
            hb.x(t, l, obj3);
            t(t, i, i3);
            r(t, t2, i3);
            if (y(t2, i, i3)) {
            }
            hb.x(t, l, obj3);
            t(t, i, i3);
            la.i(this.n, t, t2, l);
            this.k.b(t, t2, l);
            q(t, t2, i3);
            if (v(t2, i3)) {
            }
            hb.w(t, l, obj3);
            s(t, i3);
            if (v(t2, i3)) {
            }
            hb.v(t, l, obj3);
            s(t, i3);
            if (v(t2, i3)) {
            }
            hb.w(t, l, obj3);
            s(t, i3);
            if (v(t2, i3)) {
            }
            hb.v(t, l, obj3);
            s(t, i3);
            if (v(t2, i3)) {
            }
            hb.v(t, l, obj3);
            s(t, i3);
            if (v(t2, i3)) {
            }
            hb.v(t, l, obj3);
            s(t, i3);
            if (v(t2, i3)) {
            }
            hb.x(t, l, obj3);
            s(t, i3);
            q(t, t2, i3);
            if (v(t2, i3)) {
            }
            hb.x(t, l, obj3);
            s(t, i3);
            if (v(t2, i3)) {
            }
            hb.r(t, l, obj3);
            s(t, i3);
            if (v(t2, i3)) {
            }
            hb.v(t, l, obj3);
            s(t, i3);
            if (v(t2, i3)) {
            }
            hb.w(t, l, obj3);
            s(t, i3);
            if (v(t2, i3)) {
            }
            hb.v(t, l, obj3);
            s(t, i3);
            if (v(t2, i3)) {
            }
            hb.w(t, l, obj3);
            s(t, i3);
            if (v(t2, i3)) {
            }
            hb.w(t, l, obj3);
            s(t, i3);
            if (v(t2, i3)) {
            }
            hb.u(t, l, obj3);
            s(t, i3);
            if (v(t2, i3)) {
            }
            hb.t(t, l, obj3);
            s(t, i3);
        }
        la.f(this.l, t, t2);
        if (this.f) {
        } else {
        }
        la.e(this.m, t, t2);
        throw 0;
    }

    public final boolean f(T t) {
        int i5;
        int i6;
        boolean empty2;
        int int;
        int i3;
        int i8;
        int empty;
        int i4;
        int size;
        int i2;
        int i14;
        int i10;
        int i12;
        int i7;
        int i9;
        int i13;
        int i11;
        int i15;
        int i;
        final Object obj6 = this;
        final Object obj7 = t;
        final int i22 = 1048575;
        final int i23 = 0;
        i5 = i22;
        i10 = int;
        i12 = 0;
        size = 1;
        while (i10 < obj6.i) {
            i7 = obj6.h[i10];
            i13 = obj6.k(i7);
            int i20 = obj6.a[i7 + 2];
            i2 = i20 & i22;
            i20 >>>= 20;
            i11 = size << i4;
            if (i2 != i5) {
            } else {
            }
            i15 = i5;
            i = int;
            empty2 = ba.j(i13);
            i10++;
            i5 = i15;
            int = i;
            i12 = 0;
            size = 1;
            empty2 = hb.k(obj7, (long)i17);
            i4 = i23;
            while (i4 < empty2.size()) {
                i4++;
            }
            i4++;
            empty = 50;
            if (i2 != i22) {
            }
            i = int;
            i15 = i2;
            int = ba.p.getInt(obj7, (long)i2);
        }
        if (obj6.f) {
        } else {
            return size;
        }
        obj6.m.a(obj7);
        throw i12;
    }

    public final void g(T t, byte[] b2Arr2, int i3, int i4, com.google.android.gms.internal.measurement.n7 n75) {
        if (this.g) {
            O(t, b2Arr2, i3, i4, n75);
        }
        this.D(t, b2Arr2, i3, i4, 0, n75);
    }

    public final boolean h(T t, T t2) {
        int i3;
        int i4;
        int floatToIntBits;
        int floatToIntBits2;
        long doubleToLongBits;
        int i;
        final int i5 = 0;
        i4 = i5;
        while (i4 < iArr.length) {
            int i6 = k(i4);
            floatToIntBits2 = 1048575;
            doubleToLongBits = (long)i9;
            i4 += 3;
            long l2 = (long)i8;
            floatToIntBits = la.h(hb.k(t, doubleToLongBits), hb.k(t2, doubleToLongBits));
            floatToIntBits = la.h(hb.k(t, doubleToLongBits), hb.k(t2, doubleToLongBits));
        }
        if (!this.l.c(t).equals(this.l.c(t2))) {
            return i5;
        }
        if (this.f) {
        } else {
            return 1;
        }
        this.m.a(t);
        this.m.a(t2);
        throw 0;
    }

    public final void i(T t, com.google.android.gms.internal.measurement.f8 f82) {
        int i3;
        int cmp;
        int i4;
        int i;
        int i2;
        long l;
        if (this.g) {
            if (this.f) {
            } else {
                final int i6 = 0;
                i3 = i6;
                while (i3 < iArr.length) {
                    cmp = k(i3);
                    i4 = this.a[i3];
                    i2 = 1;
                    l = 1048575;
                    i3 += 3;
                    if (y(t, i4, i3)) {
                    }
                    f82.B(i4, hb.k(t, (long)i39), n(i3));
                    if (y(t, i4, i3)) {
                    }
                    f82.c(i4, ba.l(t, (long)cmp));
                    if (y(t, i4, i3)) {
                    }
                    f82.a(i4, ba.L(t, (long)i18));
                    if (y(t, i4, i3)) {
                    }
                    f82.J(i4, ba.l(t, (long)cmp));
                    if (y(t, i4, i3)) {
                    }
                    f82.H(i4, ba.L(t, (long)i57));
                    if (y(t, i4, i3)) {
                    }
                    f82.t(i4, ba.L(t, (long)i50));
                    if (y(t, i4, i3)) {
                    }
                    f82.h(i4, ba.L(t, (long)i41));
                    if (y(t, i4, i3)) {
                    }
                    f82.o(i4, (x7)hb.k(t, (long)i30));
                    if (y(t, i4, i3)) {
                    }
                    f82.G(i4, hb.k(t, (long)i21), n(i3));
                    if (y(t, i4, i3)) {
                    }
                    ba.C(i4, hb.k(t, (long)i12), f82);
                    if (y(t, i4, i3)) {
                    }
                    f82.m(i4, ba.z(t, (long)i60));
                    if (y(t, i4, i3)) {
                    }
                    f82.v(i4, ba.L(t, (long)i53));
                    if (y(t, i4, i3)) {
                    }
                    f82.x(i4, ba.l(t, (long)cmp));
                    if (y(t, i4, i3)) {
                    }
                    f82.C(i4, ba.L(t, (long)i34));
                    if (y(t, i4, i3)) {
                    }
                    f82.j(i4, ba.l(t, (long)cmp));
                    if (y(t, i4, i3)) {
                    }
                    f82.E(i4, ba.l(t, (long)cmp));
                    if (y(t, i4, i3)) {
                    }
                    f82.z(i4, ba.I(t, (long)i63));
                    if (y(t, i4, i3)) {
                    }
                    f82.q(i4, ba.H(t, (long)cmp));
                    B(f82, i4, hb.k(t, (long)i46), i3);
                    la.q(this.a[i3], (List)hb.k(t, (long)i42), f82, n(i3));
                    la.x(this.a[i3], (List)hb.k(t, (long)i37), f82, i2);
                    la.w(this.a[i3], (List)hb.k(t, (long)i31), f82, i2);
                    la.v(this.a[i3], (List)hb.k(t, (long)i26), f82, i2);
                    la.u(this.a[i3], (List)hb.k(t, (long)i22), f82, i2);
                    la.m(this.a[i3], (List)hb.k(t, (long)i16), f82, i2);
                    la.z(this.a[i3], (List)hb.k(t, (long)i13), f82, i2);
                    la.j(this.a[i3], (List)hb.k(t, (long)i8), f82, i2);
                    la.n(this.a[i3], (List)hb.k(t, (long)i61), f82, i2);
                    la.o(this.a[i3], (List)hb.k(t, (long)i56), f82, i2);
                    la.r(this.a[i3], (List)hb.k(t, (long)i54), f82, i2);
                    la.B(this.a[i3], (List)hb.k(t, (long)i48), f82, i2);
                    la.s(this.a[i3], (List)hb.k(t, (long)i45), f82, i2);
                    la.p(this.a[i3], (List)hb.k(t, (long)i40), f82, i2);
                    la.l(this.a[i3], (List)hb.k(t, (long)i35), f82, i2);
                    la.x(this.a[i3], (List)hb.k(t, (long)i28), f82, i6);
                    la.w(this.a[i3], (List)hb.k(t, (long)i25), f82, i6);
                    la.v(this.a[i3], (List)hb.k(t, (long)i19), f82, i6);
                    la.u(this.a[i3], (List)hb.k(t, (long)i15), f82, i6);
                    la.m(this.a[i3], (List)hb.k(t, (long)i10), f82, i6);
                    la.z(this.a[i3], (List)hb.k(t, (long)i64), f82, i6);
                    la.k(this.a[i3], (List)hb.k(t, (long)i58), f82);
                    la.t(this.a[i3], (List)hb.k(t, (long)i55), f82, n(i3));
                    la.y(this.a[i3], (List)hb.k(t, (long)i51), f82);
                    la.j(this.a[i3], (List)hb.k(t, (long)i47), f82, i6);
                    la.n(this.a[i3], (List)hb.k(t, (long)i43), f82, i6);
                    la.o(this.a[i3], (List)hb.k(t, (long)i38), f82, i6);
                    la.r(this.a[i3], (List)hb.k(t, (long)i32), f82, i6);
                    la.B(this.a[i3], (List)hb.k(t, (long)i27), f82, i6);
                    la.s(this.a[i3], (List)hb.k(t, (long)i23), f82, i6);
                    la.p(this.a[i3], (List)hb.k(t, (long)i17), f82, i6);
                    la.l(this.a[i3], (List)hb.k(t, (long)i14), f82, i6);
                    if (v(t, i3)) {
                    }
                    f82.B(i4, hb.k(t, (long)i9), n(i3));
                    if (v(t, i3)) {
                    }
                    f82.c(i4, hb.i(t, (long)cmp));
                    if (v(t, i3)) {
                    }
                    f82.a(i4, hb.h(t, (long)i49));
                    if (v(t, i3)) {
                    }
                    f82.J(i4, hb.i(t, (long)cmp));
                    if (v(t, i3)) {
                    }
                    f82.H(i4, hb.h(t, (long)i29));
                    if (v(t, i3)) {
                    }
                    f82.t(i4, hb.h(t, (long)i20));
                    if (v(t, i3)) {
                    }
                    f82.h(i4, hb.h(t, (long)i11));
                    if (v(t, i3)) {
                    }
                    f82.o(i4, (x7)hb.k(t, (long)i59));
                    if (v(t, i3)) {
                    }
                    f82.G(i4, hb.k(t, (long)i52), n(i3));
                    if (v(t, i3)) {
                    }
                    ba.C(i4, hb.k(t, (long)i44), f82);
                    if (v(t, i3)) {
                    }
                    f82.m(i4, hb.B(t, (long)i33));
                    if (v(t, i3)) {
                    }
                    f82.v(i4, hb.h(t, (long)i24));
                    if (v(t, i3)) {
                    }
                    f82.x(i4, hb.i(t, (long)cmp));
                    if (v(t, i3)) {
                    }
                    f82.C(i4, hb.h(t, (long)i62));
                    if (v(t, i3)) {
                    }
                    f82.j(i4, hb.i(t, (long)cmp));
                    if (v(t, i3)) {
                    }
                    f82.E(i4, hb.i(t, (long)cmp));
                    if (v(t, i3)) {
                    }
                    f82.z(i4, hb.g(t, (long)i36));
                    if (v(t, i3)) {
                    }
                    f82.q(i4, hb.f(t, (long)cmp));
                }
                com.google.android.gms.internal.measurement.xa xaVar = this.l;
                xaVar.i(xaVar.c(t), f82);
            }
            this.m.a(t);
            throw 0;
        }
        A(t, f82);
    }
}
