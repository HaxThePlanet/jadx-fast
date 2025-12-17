package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.l.a;
import com.google.android.gms.tasks.f;

/* loaded from: classes2.dex */
final class mn implements f {
    mn(com.google.android.gms.internal.firebase-auth-api.qn qn) {
        super();
    }

    @Override // com.google.android.gms.tasks.f
    public final void onFailure(Exception exception) {
        String obj4;
        obj4 = String.valueOf(exception.getMessage());
        final String str = "SmsRetrieverClient failed to start: ";
        if (obj4.length() != 0) {
            obj4 = str.concat(obj4);
        } else {
            obj4 = new String(str);
        }
        qn.a().c(obj4, new Object[0]);
    }
}
