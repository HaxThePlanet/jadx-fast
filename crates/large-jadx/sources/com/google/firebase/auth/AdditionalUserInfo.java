package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.c;
import java.util.Map;

/* loaded from: classes2.dex */
public interface AdditionalUserInfo extends c {
    public abstract Map<String, Object> getProfile();

    @Override // com.google.android.gms.common.internal.safeparcel.c
    public abstract String getProviderId();

    @Override // com.google.android.gms.common.internal.safeparcel.c
    public abstract String getUsername();

    @Override // com.google.android.gms.common.internal.safeparcel.c
    public abstract boolean isNewUser();
}
