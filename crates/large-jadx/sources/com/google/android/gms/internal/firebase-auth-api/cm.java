package com.google.android.gms.internal.firebase-auth-api;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class cm extends com.google.android.gms.internal.firebase-auth-api.ak implements Serializable {

    private final Pattern zza;
    cm(Pattern pattern) {
        super();
        Objects.requireNonNull(pattern);
        this.zza = pattern;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ak
    public final com.google.android.gms.internal.firebase-auth-api.zi a(java.lang.CharSequence charSequence) {
        bl blVar = new bl(this.zza.matcher(charSequence));
        return blVar;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.ak
    public final String toString() {
        return this.zza.toString();
    }
}
