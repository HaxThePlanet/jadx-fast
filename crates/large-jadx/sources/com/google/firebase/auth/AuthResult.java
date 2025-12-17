package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.c;

/* loaded from: classes2.dex */
public interface AuthResult extends c {
    @Override // com.google.android.gms.common.internal.safeparcel.c
    public abstract com.google.firebase.auth.AdditionalUserInfo getAdditionalUserInfo();

    @Override // com.google.android.gms.common.internal.safeparcel.c
    public abstract com.google.firebase.auth.AuthCredential getCredential();

    @Override // com.google.android.gms.common.internal.safeparcel.c
    public abstract com.google.firebase.auth.FirebaseUser getUser();
}
