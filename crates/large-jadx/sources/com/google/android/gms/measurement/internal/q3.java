package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes2.dex */
public final class q3 extends com.google.android.gms.measurement.internal.w5 {

    private char c = 0;
    private long d = -1;
    private String e;
    private final com.google.android.gms.measurement.internal.o3 f;
    private final com.google.android.gms.measurement.internal.o3 g;
    private final com.google.android.gms.measurement.internal.o3 h;
    private final com.google.android.gms.measurement.internal.o3 i;
    private final com.google.android.gms.measurement.internal.o3 j;
    private final com.google.android.gms.measurement.internal.o3 k;
    private final com.google.android.gms.measurement.internal.o3 l;
    private final com.google.android.gms.measurement.internal.o3 m;
    private final com.google.android.gms.measurement.internal.o3 n;
    q3(com.google.android.gms.measurement.internal.b5 b5) {
        super(b5);
        final int obj4 = 0;
        int i = -1;
        int i2 = 6;
        o3 o3Var = new o3(this, i2, obj4, obj4);
        this.f = o3Var;
        final int i7 = 1;
        o3 o3Var2 = new o3(this, i2, i7, obj4);
        this.g = o3Var2;
        o3 o3Var3 = new o3(this, i2, obj4, i7);
        this.h = o3Var3;
        int i3 = 5;
        o3 o3Var4 = new o3(this, i3, obj4, obj4);
        this.i = o3Var4;
        o3 o3Var5 = new o3(this, i3, i7, obj4);
        this.j = o3Var5;
        o3 o3Var6 = new o3(this, i3, obj4, i7);
        this.k = o3Var6;
        o3 o3Var7 = new o3(this, 4, obj4, obj4);
        this.l = o3Var7;
        o3 o3Var8 = new o3(this, 3, obj4, obj4);
        this.m = o3Var8;
        o3 o3Var9 = new o3(this, 2, obj4, obj4);
        this.n = o3Var9;
    }

    static String A(boolean z, String string2, Object object3, Object object4, Object object5) {
        String str2;
        String str;
        String obj3;
        if (string2 == null) {
            obj3 = str2;
        }
        final String obj4 = q3.B(z, object3);
        final String obj5 = q3.B(z, object4);
        String obj2 = q3.B(z, object5);
        StringBuilder obj6 = new StringBuilder();
        if (!TextUtils.isEmpty(obj3)) {
            obj6.append(obj3);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(obj4)) {
            obj6.append(str2);
            obj6.append(obj4);
            str2 = str;
        }
        if (!TextUtils.isEmpty(obj5)) {
            obj6.append(str2);
            obj6.append(obj5);
        } else {
            str = str2;
        }
        if (!TextUtils.isEmpty(obj2)) {
            obj6.append(str);
            obj6.append(obj2);
        }
        return obj6.toString();
    }

    static String B(boolean z, Object object2) {
        String str2;
        boolean z2;
        String str;
        int i;
        String nativeMethod;
        String obj8;
        Object obj9;
        if (object2 == null) {
            return "";
        }
        if (object2 instanceof Integer) {
            obj9 = Long.valueOf((long)obj9);
        }
        str = "-";
        if (obj9 instanceof Long && !z) {
            if (!z) {
                return obj9.toString();
            }
            obj8 = obj9;
            long l3 = Math.abs((Long)obj8.longValue());
            if (Long.compare(l3, i5) < 0) {
                return obj9.toString();
            }
            obj9 = obj9.toString().charAt(0);
            if (obj9 == 45) {
                str2 = str;
            }
            obj8 = String.valueOf(Math.abs(obj8.longValue()));
            obj9--;
            long l = 4621819117588971520L;
            StringBuilder stringBuilder2 = new StringBuilder(i3 += length3);
            stringBuilder2.append(str2);
            stringBuilder2.append(Math.round(Math.pow(l, l3)));
            stringBuilder2.append("...");
            stringBuilder2.append(str2);
            stringBuilder2.append(Math.round(obj8 += l2));
            return stringBuilder2.toString();
        }
        if (obj9 instanceof Boolean) {
            return obj9.toString();
        }
        if (obj9 instanceof Throwable) {
            if (z) {
                obj8 = (Throwable)obj9.getClass().getName();
            } else {
                obj8 = obj9.toString();
            }
            StringBuilder stringBuilder = new StringBuilder(obj8);
            obj9 = obj9.getStackTrace();
            while (i < obj9.length) {
                str = obj9[i];
                if (!str.isNativeMethod()) {
                    break;
                } else {
                }
                nativeMethod = str.getClassName();
                if (nativeMethod != null) {
                    break;
                } else {
                }
                i++;
                if (q3.G(nativeMethod).equals(q3.G(b5.class.getCanonicalName()))) {
                    break;
                } else {
                }
            }
            return stringBuilder.toString();
        }
        if (obj9 instanceof p3) {
            return p3.a((p3)obj9);
        }
        if (z) {
            return str;
        }
        return obj9.toString();
    }

    static void D(com.google.android.gms.measurement.internal.q3 q3, long l2) {
        q3.d = 46000;
    }

    static void E(com.google.android.gms.measurement.internal.q3 q3, char c2) {
        q3.c = c2;
    }

    private static String G(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        int lastIndexOf = string.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return string;
        }
        return string.substring(0, lastIndexOf);
    }

    static char o(com.google.android.gms.measurement.internal.q3 q3) {
        return q3.c;
    }

    static long p(com.google.android.gms.measurement.internal.q3 q3) {
        return q3.d;
    }

    protected static Object z(String string) {
        if (string == null) {
            return null;
        }
        p3 p3Var = new p3(string);
        return p3Var;
    }

    @EnsuresNonNull("logTagDoNotUseDirectly")
    protected final String C() {
        String str;
        synchronized (this) {
            try {
                if (this.a.Q() != null) {
                } else {
                }
                this.e = this.a.Q();
                this.e = this.a.z().w();
                r.j(this.e);
                return this.e;
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.w5
    protected final void F(int i, boolean z2, boolean z3, String string4, Object object5, Object object6, Object object7) {
        String str;
        Object obj4;
        int i2;
        String str2;
        Object obj;
        Object obj2;
        Object obj3;
        int obj8;
        boolean obj9;
        int obj10;
        if (!z2 && Log.isLoggable(C(), i)) {
            if (Log.isLoggable(C(), i)) {
                Log.println(i, C(), q3.A(false, string4, object5, object6, object7));
            }
        }
        r.j(string4);
        obj9 = this.a.G();
        obj10 = 6;
        if (z3 == 0 && i >= 5 && obj9 == null) {
            if (i >= 5) {
                r.j(string4);
                obj9 = this.a.G();
                obj10 = 6;
                if (obj9 == null) {
                    Log.println(obj10, C(), "Scheduler not set. Not logging error/warn");
                }
                if (!obj9.n()) {
                    Log.println(obj10, C(), "Scheduler not initialized. Not logging error/warn");
                }
                if (i >= 9) {
                    obj8 = 8;
                }
                super(this, obj8, string4, object5, object6, object7);
                obj9.z(obj8);
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.w5
    protected final boolean j() {
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final com.google.android.gms.measurement.internal.o3 q() {
        return this.m;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final com.google.android.gms.measurement.internal.o3 r() {
        return this.f;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final com.google.android.gms.measurement.internal.o3 s() {
        return this.h;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final com.google.android.gms.measurement.internal.o3 t() {
        return this.g;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final com.google.android.gms.measurement.internal.o3 u() {
        return this.l;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final com.google.android.gms.measurement.internal.o3 v() {
        return this.n;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final com.google.android.gms.measurement.internal.o3 w() {
        return this.i;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final com.google.android.gms.measurement.internal.o3 x() {
        return this.k;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final com.google.android.gms.measurement.internal.o3 y() {
        return this.j;
    }
}
