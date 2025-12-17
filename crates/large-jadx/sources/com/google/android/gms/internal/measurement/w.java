package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
public final class w extends com.google.android.gms.internal.measurement.x {
    public w() {
        super();
        this.a.add(n0.zze);
        this.a.add(n0.zzf);
        this.a.add(n0.zzg);
        this.a.add(n0.zzh);
        this.a.add(n0.zzi);
        this.a.add(n0.zzj);
        this.a.add(n0.zzk);
    }

    public final com.google.android.gms.internal.measurement.q a(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3) {
        int i;
        com.google.android.gms.internal.measurement.n0 zza = n0.zza;
        final int i3 = 31;
        final int i4 = 2;
        final int i5 = 1;
        int i6 = 0;
        switch (ordinal) {
            case 4:
                b6.h(n0.zze.name(), i4, list3);
                Object obj10 = list3.get(i5);
                int obj9 = b6.b(b52.b((q)obj10).zzh().doubleValue());
                obj10 = new i(Double.valueOf((double)obj8));
                return obj10;
            case 5:
                b6.h(n0.zzf.name(), i4, list3);
                obj10 = list3.get(i5);
                obj9 = (int)obj9;
                i iVar = new i(Double.valueOf((double)obj8));
                return iVar;
            case 6:
                b6.h(n0.zzg.name(), i5, list3);
                obj9 = new i(Double.valueOf((double)obj8));
                return obj9;
            case 7:
                b6.h(n0.zzh.name(), i4, list3);
                obj10 = list3.get(i5);
                obj9 = b6.b(b52.b((q)obj10).zzh().doubleValue());
                obj10 = new i(Double.valueOf((double)obj8));
                return obj10;
            case 8:
                b6.h(n0.zzi.name(), i4, list3);
                obj10 = list3.get(i5);
                obj9 = (int)obj9;
                i iVar2 = new i(Double.valueOf((double)obj8));
                return iVar2;
            case 9:
                b6.h(n0.zzj.name(), i4, list3);
                obj10 = new i(Double.valueOf((double)obj8));
                return obj10;
            case 10:
                b6.h(n0.zzk.name(), i4, list3);
                obj10 = list3.get(i5);
                obj9 = b6.b(b52.b((q)obj10).zzh().doubleValue());
                obj10 = new i(Double.valueOf((double)obj8));
                return obj10;
            default:
                super.b(string);
                throw 0;
        }
    }
}
