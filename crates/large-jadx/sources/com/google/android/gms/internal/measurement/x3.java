package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
public final class x3 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.x3, com.google.android.gms.internal.measurement.u3> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.x3 zza;
    private int zze;
    private int zzf;
    private String zzg;
    private boolean zzh;
    private com.google.android.gms.internal.measurement.c9<String> zzi;
    static {
        x3 x3Var = new x3();
        x3.zza = x3Var;
        w8.o(x3.class, x3Var);
    }

    private x3() {
        super();
        this.zzg = "";
        this.zzi = w8.k();
    }

    static com.google.android.gms.internal.measurement.x3 x() {
        return x3.zza;
    }

    public static com.google.android.gms.internal.measurement.x3 y() {
        return x3.zza;
    }

    public final List<String> A() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean B() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean C() {
        if (zze &= 4 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean D() {
        if (zze &= 2 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean E() {
        final int i3 = 1;
        if (zze &= i3 != 0) {
            return i3;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int F() {
        int i;
        if (w3.a(this.zzf) == 0) {
            i = 1;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    protected final Object v(int i, Object object2, Object object3) {
        i--;
        int obj7 = 1;
        int obj8 = 5;
        final int i2 = 4;
        final int i3 = 3;
        final int i4 = 2;
        obj7 = 0;
        if (obj6 != null && obj6 != i4 && obj6 != i3 && obj6 != i2 && obj6 != obj8) {
            obj8 = 5;
            i2 = 4;
            i3 = 3;
            i4 = 2;
            if (obj6 != i4) {
                if (obj6 != i3) {
                    obj7 = 0;
                    if (obj6 != i2) {
                        if (obj6 != obj8) {
                            return obj7;
                        }
                        return x3.zza;
                    }
                    u3 obj6 = new u3(obj7);
                    return obj6;
                }
                obj6 = new x3();
                return obj6;
            }
            obj6 = new Object[6];
            obj6[obj7] = "zzf";
            obj6[i4] = v3.a;
            obj6[i3] = "zzg";
            obj6[i2] = "zzh";
            obj6[obj8] = "zzi";
            return w8.n(x3.zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", obj6);
        }
        return Byte.valueOf(obj7);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int w() {
        return this.zzi.size();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String z() {
        return this.zzg;
    }
}
