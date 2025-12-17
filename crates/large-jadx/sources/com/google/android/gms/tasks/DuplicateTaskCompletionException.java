package com.google.android.gms.tasks;

import androidx.annotation.RecentlyNonNull;

/* loaded from: classes2.dex */
public final class DuplicateTaskCompletionException extends java.lang.IllegalStateException {
    private DuplicateTaskCompletionException(String string, Throwable throwable2) {
        super(string, throwable2);
    }

    public static java.lang.IllegalStateException a(com.google.android.gms.tasks.j<?> j) {
        boolean successful;
        StringBuilder stringBuilder;
        String obj4;
        if (!j.isComplete()) {
            obj4 = new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            return obj4;
        }
        Exception exception = j.getException();
        if (exception != null) {
            obj4 = "failure";
        } else {
            if (j.isSuccessful()) {
                obj4 = String.valueOf(j.getResult());
                stringBuilder = new StringBuilder(length += 7);
                stringBuilder.append("result ");
                stringBuilder.append(obj4);
                obj4 = stringBuilder.toString();
            } else {
                obj4 = j.isCanceled() ? "cancellation" : "unknown issue";
            }
        }
        obj4 = String.valueOf(obj4);
        String str2 = "Complete with: ";
        if (obj4.length() != 0) {
            obj4 = str2.concat(obj4);
        } else {
            obj4 = new String(str2);
        }
        DuplicateTaskCompletionException duplicateTaskCompletionException = new DuplicateTaskCompletionException(obj4, exception);
        return duplicateTaskCompletionException;
    }
}
