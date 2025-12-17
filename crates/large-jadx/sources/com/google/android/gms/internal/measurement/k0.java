package com.google.android.gms.internal.measurement;

import android.accounts.Account;
import java.util.List;

/* loaded from: classes2.dex */
public final class k0 extends com.google.android.gms.internal.measurement.x {
    protected k0() {
        super();
        this.a.add(n0.zza);
        this.a.add(n0.zzv);
        this.a.add(n0.zzS);
        this.a.add(n0.zzT);
        this.a.add(n0.zzU);
        this.a.add(n0.zzaa);
        this.a.add(n0.zzab);
        this.a.add(n0.zzad);
        this.a.add(n0.zzae);
        this.a.add(n0.zzah);
    }

    public final com.google.android.gms.internal.measurement.q a(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3) {
        int i;
        int i2;
        int length;
        String obj6;
        String obj7;
        boolean obj8;
        int ordinal = b6.e(string).ordinal();
        int i11 = 2;
        final int i12 = 1;
        final int i13 = 0;
        if (ordinal != 0 && ordinal != 21 && ordinal != 59 && ordinal != 52 && ordinal != 53 && ordinal != 55 && ordinal != 56) {
            if (ordinal != 21) {
                if (ordinal != 59) {
                    if (ordinal != 52) {
                        if (ordinal != 53) {
                            if (ordinal != 55) {
                                if (ordinal != 56) {
                                    switch (ordinal) {
                                        case 44:
                                            b6.h(n0.zzS.name(), i11, list3);
                                            obj8 = new i(Double.valueOf(doubleValue2 %= obj6));
                                            return obj8;
                                        case 45:
                                            b6.h(n0.zzT.name(), i11, list3);
                                            obj8 = new i(Double.valueOf(doubleValue4 *= obj6));
                                            return obj8;
                                        case 46:
                                            b6.h(n0.zzU.name(), i12, list3);
                                            obj7 = new i(Double.valueOf(-doubleValue3));
                                            return obj7;
                                        default:
                                            super.b(string);
                                            throw 0;
                                    }
                                }
                            }
                            b6.h(string, i12, list3);
                            return b52.b((q)list3.get(i13));
                        }
                    }
                    b6.h(string, i11, list3);
                    b52.b((q)list3.get(i12));
                    return b52.b((q)list3.get(i13));
                }
                b6.h(n0.zzah.name(), i11, list3);
                obj8 = new i(Double.valueOf(-doubleValue5));
                obj7 = new i(Double.valueOf(doubleValue6 += doubleValue8));
                return obj7;
            }
            b6.h(n0.zzv.name(), i11, list3);
            obj8 = new i(Double.valueOf(doubleValue /= obj6));
            return obj8;
        }
        b6.h(n0.zza.name(), i11, list3);
        obj6 = b52.b((q)list3.get(i13));
        obj7 = b52.b((q)list3.get(i12));
        if (!obj6 instanceof m && !obj6 instanceof u && !obj7 instanceof m) {
            if (!obj6 instanceof u) {
                if (!obj7 instanceof m) {
                    if (obj7 instanceof u) {
                        obj6 = String.valueOf(obj6.zzi());
                        obj7 = String.valueOf(obj7.zzi());
                        if (obj7.length() != 0) {
                            obj6 = obj6.concat(obj7);
                        } else {
                            obj7 = new String(obj6);
                            obj6 = obj7;
                        }
                        obj8 = new u(obj6);
                    } else {
                        obj8 = new i(Double.valueOf(doubleValue7 += obj6));
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj8;
    }
}
