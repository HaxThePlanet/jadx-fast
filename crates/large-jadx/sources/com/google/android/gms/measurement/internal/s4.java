package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.xc;
import java.util.Map;

/* loaded from: classes2.dex */
final class s4 implements xc {

    final String a;
    final com.google.android.gms.measurement.internal.t4 b;
    s4(com.google.android.gms.measurement.internal.t4 t4, String string2) {
        this.b = t4;
        this.a = string2;
        super();
    }

    @Override // com.google.android.gms.internal.measurement.xc
    public final String zza(String string) {
        String key;
        Object obj = t4.q(this.b).get(this.a);
        if (obj != null && !(Map)obj.containsKey(string)) {
            if (!obj.containsKey(string)) {
            }
            return (String)obj.get(string);
        }
        return null;
    }
}
