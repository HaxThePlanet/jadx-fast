package com.google.firebase.inappmessaging.internal;

import com.google.firebase.installations.InstallationTokenResult;

/* loaded from: classes2.dex */
public abstract class InstallationIdResult {
    public static com.google.firebase.inappmessaging.internal.InstallationIdResult create(String string, InstallationTokenResult installationTokenResult2) {
        AutoValue_InstallationIdResult autoValue_InstallationIdResult = new AutoValue_InstallationIdResult(string, installationTokenResult2);
        return autoValue_InstallationIdResult;
    }

    abstract String installationId();

    abstract InstallationTokenResult installationTokenResult();
}
