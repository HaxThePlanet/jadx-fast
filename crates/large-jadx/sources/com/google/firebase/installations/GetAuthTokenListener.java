package com.google.firebase.installations;

import com.google.android.gms.tasks.k;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* loaded from: classes2.dex */
class GetAuthTokenListener implements com.google.firebase.installations.StateListener {

    private final k<com.google.firebase.installations.InstallationTokenResult> resultTaskCompletionSource;
    private final com.google.firebase.installations.Utils utils;
    public GetAuthTokenListener(com.google.firebase.installations.Utils utils, k<com.google.firebase.installations.InstallationTokenResult> k2) {
        super();
        this.utils = utils;
        this.resultTaskCompletionSource = k2;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean onException(Exception exception) {
        this.resultTaskCompletionSource.d(exception);
        return 1;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean onStateReached(PersistedInstallationEntry persistedInstallationEntry) {
        boolean authTokenExpired;
        if (persistedInstallationEntry.isRegistered() && !this.utils.isAuthTokenExpired(persistedInstallationEntry)) {
            if (!this.utils.isAuthTokenExpired(persistedInstallationEntry)) {
                this.resultTaskCompletionSource.c(InstallationTokenResult.builder().setToken(persistedInstallationEntry.getAuthToken()).setTokenExpirationTimestamp(persistedInstallationEntry.getExpiresInSecs()).setTokenCreationTimestamp(persistedInstallationEntry.getTokenCreationEpochInSecs()).build());
                return 1;
            }
        }
        return 0;
    }
}
