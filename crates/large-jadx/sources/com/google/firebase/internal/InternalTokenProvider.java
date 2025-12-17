package com.google.firebase.internal;

import com.google.android.gms.tasks.j;
import com.google.firebase.auth.GetTokenResult;

/* loaded from: classes2.dex */
public interface InternalTokenProvider {
    public abstract j<GetTokenResult> getAccessToken(boolean z);

    public abstract String getUid();
}
