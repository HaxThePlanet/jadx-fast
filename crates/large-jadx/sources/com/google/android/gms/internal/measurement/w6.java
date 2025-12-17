package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.util.Log;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public abstract class w6<T>  {

    private static final Object g;
    private static volatile com.google.android.gms.internal.measurement.u6 h;
    private static final AtomicInteger i;
    public static final int j;
    final com.google.android.gms.internal.measurement.t6 a;
    final String b;
    private final T c;
    private volatile int d = -1;
    private volatile T e;
    private final boolean f = true;
    static {
        Object object = new Object();
        w6.g = object;
        AtomicReference atomicReference = new AtomicReference();
        y6 y6Var = new y6(n6.a, 0);
        AtomicInteger atomicInteger = new AtomicInteger();
        w6.i = atomicInteger;
    }

    w6(com.google.android.gms.internal.measurement.t6 t6, String string2, Object object3, boolean z4, com.google.android.gms.internal.measurement.v6 v65) {
        super();
        int obj4 = -1;
        if (t6.b == null) {
        } else {
            this.a = t6;
            this.b = string2;
            this.c = object3;
            int obj1 = 1;
        }
        obj1 = new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        throw obj1;
    }

    @Deprecated
    public static void d(Context context) {
        Object u6Var;
        Object applicationContext;
        Object obj3;
        final Object obj = w6.g;
        u6Var = w6.h;
        applicationContext = context.getApplicationContext();
        synchronized (obj) {
            obj3 = applicationContext;
            if (u6Var != null) {
                try {
                    if (u6Var.a() != obj3) {
                    }
                    c6.e();
                    x6.c();
                    j6.e();
                    o6 o6Var = new o6(obj3);
                    applicationContext = new y5(obj3, i7.a(o6Var));
                    w6.h = applicationContext;
                    w6.i.incrementAndGet();
                    throw context;
                }
            } else {
            }
        }
    }

    static void e() {
        w6.i.incrementAndGet();
    }

    abstract T a(Object object);

    public final T b() {
        boolean z;
        String str;
        Object i3;
        boolean loggable;
        int i;
        Object t6Var;
        String matches;
        int i2;
        String concat;
        boolean pattern;
        String valueOf;
        int length;
        if (!this.f) {
            Objects.requireNonNull(this.b, "flagName must not be null");
        }
        int i4 = w6.i.get();
        if (this.d < i4 && this.d < i4) {
            synchronized (this) {
                com.google.android.gms.internal.measurement.u6 u6Var = w6.h;
                if (u6Var == null) {
                } else {
                    com.google.android.gms.internal.measurement.t6 t6Var2 = this.a;
                    boolean z5 = t6Var2.f;
                    boolean z2 = t6Var2.g;
                    matches = j6.b(u6Var.a()).c("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
                    i2 = 0;
                    if (matches != null && w5.c.matcher(matches).matches()) {
                        if (w5.c.matcher(matches).matches()) {
                            if (Log.isLoggable("PhenotypeFlag", 3)) {
                                String str6 = "Bypass reading Phenotype values for flag: ";
                                valueOf = String.valueOf(c());
                                if (valueOf.length() != 0) {
                                    concat = str6.concat(valueOf);
                                } else {
                                    valueOf = new String(str6);
                                    concat = valueOf;
                                }
                                Log.d("PhenotypeFlag", concat);
                            }
                            i = i2;
                        } else {
                        }
                    } else {
                    }
                    if (i != 0) {
                        try {
                            t6Var = this.a;
                            if (!t6Var.e) {
                            } else {
                            }
                            com.google.android.gms.internal.measurement.a7 a7Var = t6Var.i;
                            com.google.android.gms.internal.measurement.t6 t6Var6 = this.a;
                            if (t6Var6.e) {
                            } else {
                            }
                            concat = i2;
                            String str7 = t6Var6.c;
                            concat = this.b;
                            t6Var = j6.b(u6Var.a()).c(concat);
                            if (t6Var != null) {
                            } else {
                            }
                            i = a(t6Var);
                            i = i2;
                            if (i == null) {
                            }
                            i = this.c;
                            i3 = u6Var.b().zza();
                            if ((b7)i3.b()) {
                            }
                            com.google.android.gms.internal.measurement.t6 t6Var3 = this.a;
                            String str9 = t6Var3.a;
                            i3 = (k6)i3.a().a(t6Var3.b, i2, t6Var3.d, this.b);
                            if (i3 == null) {
                            } else {
                            }
                            i = this.c;
                            i = a(i3);
                            this.e = i;
                            this.d = i4;
                            IllegalStateException illegalStateException = new IllegalStateException("Must call PhenotypeFlag.init() first");
                            throw illegalStateException;
                            throw th;
                            return this.e;
                        }
                    } else {
                    }
                }
            }
        }
    }

    public final String c() {
        String str = t6Var.d;
        return this.b;
    }
}
