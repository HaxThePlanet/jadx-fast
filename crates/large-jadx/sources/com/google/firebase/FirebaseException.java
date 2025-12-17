package com.google.firebase;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public class FirebaseException extends Exception {
    public FirebaseException(String string) {
        r.g(string, "Detail message must not be empty");
        super(string);
    }

    public FirebaseException(String string, Throwable throwable2) {
        r.g(string, "Detail message must not be empty");
        super(string, throwable2);
    }
}
