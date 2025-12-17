package com.google.firebase;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.r;

/* loaded from: classes2.dex */
public class FirebaseExceptionMapper implements r {
    public final Exception getException(Status status) {
        if (status.k2() == 8) {
            FirebaseException firebaseException = new FirebaseException(status.zza());
            return firebaseException;
        }
        FirebaseApiNotAvailableException firebaseApiNotAvailableException = new FirebaseApiNotAvailableException(status.zza());
        return firebaseApiNotAvailableException;
    }
}
