package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import com.google.firebase.auth.PhoneAuthCredential;

/* loaded from: classes2.dex */
public final class gn {
    public static com.google.android.gms.internal.firebase-auth-api.cq a(PhoneAuthCredential phoneAuthCredential) {
        if (!TextUtils.isEmpty(phoneAuthCredential.zzh())) {
            return cq.b(phoneAuthCredential.zzf(), phoneAuthCredential.zzh(), phoneAuthCredential.zzi());
        }
        return cq.a(phoneAuthCredential.zzg(), phoneAuthCredential.getSmsCode(), phoneAuthCredential.zzi());
    }
}
