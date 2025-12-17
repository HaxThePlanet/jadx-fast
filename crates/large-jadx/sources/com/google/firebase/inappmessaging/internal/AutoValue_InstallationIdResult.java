package com.google.firebase.inappmessaging.internal;

import com.google.firebase.installations.InstallationTokenResult;
import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_InstallationIdResult extends com.google.firebase.inappmessaging.internal.InstallationIdResult {

    private final String installationId;
    private final InstallationTokenResult installationTokenResult;
    AutoValue_InstallationIdResult(String string, InstallationTokenResult installationTokenResult2) {
        super();
        Objects.requireNonNull(string, "Null installationId");
        this.installationId = string;
        Objects.requireNonNull(installationTokenResult2, "Null installationTokenResult");
        this.installationTokenResult = installationTokenResult2;
    }

    @Override // com.google.firebase.inappmessaging.internal.InstallationIdResult
    public boolean equals(Object object) {
        int i;
        boolean installationTokenResult;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof InstallationIdResult != null) {
            if (this.installationId.equals((InstallationIdResult)object.installationId()) && this.installationTokenResult.equals(object.installationTokenResult())) {
                if (this.installationTokenResult.equals(object.installationTokenResult())) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.inappmessaging.internal.InstallationIdResult
    public int hashCode() {
        int i5 = 1000003;
        return i3 ^= i6;
    }

    @Override // com.google.firebase.inappmessaging.internal.InstallationIdResult
    String installationId() {
        return this.installationId;
    }

    @Override // com.google.firebase.inappmessaging.internal.InstallationIdResult
    InstallationTokenResult installationTokenResult() {
        return this.installationTokenResult;
    }

    @Override // com.google.firebase.inappmessaging.internal.InstallationIdResult
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InstallationIdResult{installationId=");
        stringBuilder.append(this.installationId);
        stringBuilder.append(", installationTokenResult=");
        stringBuilder.append(this.installationTokenResult);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
