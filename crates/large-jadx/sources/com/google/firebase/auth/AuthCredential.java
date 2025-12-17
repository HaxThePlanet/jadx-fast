package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.a;

/* loaded from: classes2.dex */
public abstract class AuthCredential extends a {
    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract String getProvider();

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract String getSignInMethod();

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract com.google.firebase.auth.AuthCredential zza();
}
