package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.j;
import com.google.firebase.annotations.DeferredApi;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.internal.InternalTokenProvider;

/* loaded from: classes2.dex */
public interface InternalAuthProvider extends InternalTokenProvider {
    public abstract void addIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener);

    public abstract j<GetTokenResult> getAccessToken(boolean z);

    @Override // com.google.firebase.internal.InternalTokenProvider
    public abstract String getUid();

    @Override // com.google.firebase.internal.InternalTokenProvider
    public abstract void removeIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener);
}
