package com.google.firebase.installations;

import com.google.firebase.installations.local.PersistedInstallationEntry;

/* loaded from: classes2.dex */
interface StateListener {
    public abstract boolean onException(Exception exception);

    public abstract boolean onStateReached(PersistedInstallationEntry persistedInstallationEntry);
}
