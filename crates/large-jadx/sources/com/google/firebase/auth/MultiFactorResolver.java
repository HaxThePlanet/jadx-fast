package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.tasks.j;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class MultiFactorResolver extends a {
    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract com.google.firebase.auth.FirebaseAuth getFirebaseAuth();

    public abstract List<com.google.firebase.auth.MultiFactorInfo> getHints();

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract com.google.firebase.auth.MultiFactorSession getSession();

    public abstract j<com.google.firebase.auth.AuthResult> resolveSignIn(com.google.firebase.auth.MultiFactorAssertion multiFactorAssertion);
}
