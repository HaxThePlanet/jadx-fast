package com.google.firebase.installations;

import com.google.android.gms.tasks.j;
import com.google.firebase.annotations.DeferredApi;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.internal.FidListenerHandle;

/* loaded from: classes2.dex */
public interface FirebaseInstallationsApi {
    public abstract j<Void> delete();

    public abstract j<String> getId();

    public abstract j<com.google.firebase.installations.InstallationTokenResult> getToken(boolean z);

    public abstract FidListenerHandle registerFidListener(FidListener fidListener);
}
