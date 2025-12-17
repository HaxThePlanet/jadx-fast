package com.google.android.gms.internal.firebase-auth-api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.l.a;
import java.util.HashMap;

/* loaded from: classes2.dex */
final class on extends BroadcastReceiver {

    private final String a;
    final com.google.android.gms.internal.firebase-auth-api.qn b;
    public on(com.google.android.gms.internal.firebase-auth-api.qn qn, String string2) {
        this.b = qn;
        super();
        this.a = string2;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent2) {
        boolean equals;
        String str;
        Context obj3;
        boolean obj4;
        if ("com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(intent2.getAction())) {
            obj4 = intent2.getExtras();
            if ((Status)obj4.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS").k2() != 0) {
            } else {
                equals = qn.d(this.b).get(this.a);
                str = 0;
                if ((pn)equals == null) {
                    qn.a().c("Verification code received with no active retrieval session.", new Object[str]);
                } else {
                    obj4 = qn.b((String)obj4.get("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE"));
                    equals.e = obj4;
                    if (obj4 == null) {
                        qn.a().c("Unable to extract verification code.", new Object[str]);
                    } else {
                        if (!t1.d(equals.d)) {
                            qn.e(this.b, this.a);
                        }
                    }
                }
            }
            context.getApplicationContext().unregisterReceiver(this);
        }
    }
}
