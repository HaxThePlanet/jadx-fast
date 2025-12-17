package com.google.firebase.installations;

import com.google.firebase.FirebaseException;

/* loaded from: classes2.dex */
public class FirebaseInstallationsException extends FirebaseException {

    private final com.google.firebase.installations.FirebaseInstallationsException.Status status;

    public static enum Status {

        BAD_CONFIG,
        UNAVAILABLE,
        TOO_MANY_REQUESTS;
    }
    public FirebaseInstallationsException(com.google.firebase.installations.FirebaseInstallationsException.Status firebaseInstallationsException$Status) {
        super();
        this.status = status;
    }

    public FirebaseInstallationsException(String string, com.google.firebase.installations.FirebaseInstallationsException.Status firebaseInstallationsException$Status2) {
        super(string);
        this.status = status2;
    }

    public FirebaseInstallationsException(String string, com.google.firebase.installations.FirebaseInstallationsException.Status firebaseInstallationsException$Status2, Throwable throwable3) {
        super(string, throwable3);
        this.status = status2;
    }

    @Override // com.google.firebase.FirebaseException
    public com.google.firebase.installations.FirebaseInstallationsException.Status getStatus() {
        return this.status;
    }
}
