package com.google.android.gms.internal.firebase-auth-api;

import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzai;

/* loaded from: classes2.dex */
final class nh implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.to> {

    final UserProfileChangeRequest a;
    final com.google.android.gms.internal.firebase-auth-api.nl b;
    final com.google.android.gms.internal.firebase-auth-api.sh c;
    nh(com.google.android.gms.internal.firebase-auth-api.sh sh, UserProfileChangeRequest userProfileChangeRequest2, com.google.android.gms.internal.firebase-auth-api.nl nl3) {
        this.c = sh;
        this.a = userProfileChangeRequest2;
        this.b = nl3;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        String displayName;
        boolean photoUri;
        kp kpVar = new kp();
        kpVar.d((to)object.zze());
        if (!this.a.zzb()) {
            if (this.a.getDisplayName() != null) {
                kpVar.b(this.a.getDisplayName());
            }
        } else {
        }
        if (!this.a.zzc()) {
            if (this.a.getPhotoUri() != null) {
                kpVar.g(this.a.zza());
            }
        } else {
        }
        sh.t(this.c, this.b, object, kpVar, this);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        this.b.h(zzai.zza(string));
    }
}
