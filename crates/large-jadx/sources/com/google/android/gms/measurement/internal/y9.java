package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes2.dex */
final class y9 implements com.google.android.gms.measurement.internal.ha {

    final com.google.android.gms.measurement.internal.ba a;
    y9(com.google.android.gms.measurement.internal.ba ba) {
        this.a = ba;
        super();
    }

    @Override // com.google.android.gms.measurement.internal.ha
    public final void a(String string, String string2, Bundle bundle3) {
        Object obj3;
        boolean obj4;
        final String str = "_err";
        if (TextUtils.isEmpty(string) && ba.Z(this.a) != null) {
            if (ba.Z(this.a) != null) {
                ba.Z(this.a).b().r().b("AppId not known when logging event", str);
            }
        }
        x9 x9Var = new x9(this, string, str, bundle3);
        this.a.a().z(x9Var);
    }
}
