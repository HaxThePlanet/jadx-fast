package com.google.firebase.installations;

import com.google.android.gms.tasks.k;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* loaded from: classes2.dex */
class GetIdListener implements com.google.firebase.installations.StateListener {

    final k<String> taskCompletionSource;
    public GetIdListener(k<String> k) {
        super();
        this.taskCompletionSource = k;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean onException(Exception exception) {
        return 0;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean onStateReached(PersistedInstallationEntry persistedInstallationEntry) {
        boolean unregistered;
        if (!persistedInstallationEntry.isUnregistered() && !persistedInstallationEntry.isRegistered() && persistedInstallationEntry.isErrored()) {
            if (!persistedInstallationEntry.isRegistered()) {
                if (persistedInstallationEntry.isErrored()) {
                }
                return 0;
            }
        }
        this.taskCompletionSource.e(persistedInstallationEntry.getFirebaseInstallationId());
        return 1;
    }
}
