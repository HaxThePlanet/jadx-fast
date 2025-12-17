package com.google.firebase.auth.internal;

import com.google.firebase.auth.SignInMethodQueryResult;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzaj implements SignInMethodQueryResult {

    private final List<String> zza;
    public zzaj(List<String> list) {
        super();
        this.zza = list;
    }

    public final List<String> getSignInMethods() {
        return this.zza;
    }
}
