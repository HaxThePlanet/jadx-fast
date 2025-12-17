package com.google.android.gms.cloudmessaging;

import android.util.Log;
import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class z implements c {

    public static final com.google.android.gms.cloudmessaging.z a;
    static {
        z zVar = new z();
        z.a = zVar;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        boolean loggable;
        String str;
        StringBuilder stringBuilder;
        if (j.isSuccessful()) {
            return (Bundle)j.getResult();
        }
        String str2 = "Rpc";
        if (!Log.isLoggable(str2, 3)) {
        } else {
            String valueOf = String.valueOf(j.getException());
            stringBuilder = new StringBuilder(length += 22);
            stringBuilder.append("Error making request: ");
            stringBuilder.append(valueOf);
            Log.d(str2, stringBuilder.toString());
        }
        IOException iOException = new IOException("SERVICE_NOT_AVAILABLE", j.getException());
        throw iOException;
    }
}
