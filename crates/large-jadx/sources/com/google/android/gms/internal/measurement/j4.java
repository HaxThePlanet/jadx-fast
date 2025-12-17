package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class j4 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.j4, com.google.android.gms.internal.measurement.i4> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.j4 zza;
    private int zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private String zzk;
    private String zzl;
    static {
        j4 j4Var = new j4();
        j4.zza = j4Var;
        w8.o(j4.class, j4Var);
    }

    private j4() {
        super();
        final String str = "";
        this.zzf = str;
        this.zzg = str;
        this.zzh = str;
        this.zzi = str;
        this.zzj = str;
        this.zzk = str;
        this.zzl = str;
    }

    static com.google.android.gms.internal.measurement.j4 w() {
        return j4.zza;
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
                        return j4.zza;
                    }
                    i4 obj6 = new i4(obj7);
                    return obj6;
                }
                obj6 = new j4();
                return obj6;
            }
            obj6 = new Object[8];
            obj6[obj7] = "zzf";
            obj6[i4] = "zzg";
            obj6[i3] = "zzh";
            obj6[i2] = "zzi";
            obj6[obj8] = "zzj";
            obj6[6] = "zzk";
            obj6[7] = "zzl";
            return w8.n(j4.zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", obj6);
        }
        return Byte.valueOf(obj7);
    }
}
