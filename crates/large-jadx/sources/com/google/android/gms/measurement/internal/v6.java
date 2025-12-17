package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes2.dex */
final class v6 implements com.google.android.gms.measurement.internal.ha {

    final com.google.android.gms.measurement.internal.i7 a;
    v6(com.google.android.gms.measurement.internal.i7 i7) {
        this.a = i7;
        super();
    }

    @Override // com.google.android.gms.measurement.internal.ha
    public final void a(String string, String string2, Bundle bundle3) {
        final String str = "auto";
        final String str2 = "_err";
        if (!TextUtils.isEmpty(string)) {
        } else {
            this.a.r(str, str2, bundle3);
        }
        this.a.t(str, str2, bundle3, string);
        throw 0;
    }
}
