package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.j;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorSession;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzac extends MultiFactor {

    private final com.google.firebase.auth.internal.zzx zza;
    public zzac(com.google.firebase.auth.internal.zzx zzx) {
        super();
        r.j(zzx);
        this.zza = zzx;
    }

    public final j<Void> enroll(MultiFactorAssertion multiFactorAssertion, String string2) {
        r.j(multiFactorAssertion);
        final com.google.firebase.auth.internal.zzx zza = this.zza;
        return FirebaseAuth.getInstance(zza.zza()).zzb(zza, multiFactorAssertion, string2);
    }

    public final List<MultiFactorInfo> getEnrolledFactors() {
        return this.zza.zzn();
    }

    public final j<MultiFactorSession> getSession() {
        zzab zzab = new zzab(this);
        return this.zza.getIdToken(false).continueWithTask(zzab);
    }

    public final j<Void> unenroll(MultiFactorInfo multiFactorInfo) {
        r.j(multiFactorInfo);
        String obj3 = multiFactorInfo.getUid();
        r.f(obj3);
        final com.google.firebase.auth.internal.zzx zza = this.zza;
        return FirebaseAuth.getInstance(zza.zza()).zzl(zza, obj3);
    }

    public final j<Void> unenroll(String string) {
        r.f(string);
        final com.google.firebase.auth.internal.zzx zza = this.zza;
        return FirebaseAuth.getInstance(zza.zza()).zzl(zza, string);
    }
}
