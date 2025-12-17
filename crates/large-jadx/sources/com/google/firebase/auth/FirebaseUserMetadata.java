package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.c;

/* loaded from: classes2.dex */
public interface FirebaseUserMetadata extends c {
    @Override // com.google.android.gms.common.internal.safeparcel.c
    public abstract long getCreationTimestamp();

    @Override // com.google.android.gms.common.internal.safeparcel.c
    public abstract long getLastSignInTimestamp();
}
