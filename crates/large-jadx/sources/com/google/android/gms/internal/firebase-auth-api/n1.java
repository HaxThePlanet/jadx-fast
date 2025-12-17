package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
final class n1 extends java.lang.IllegalArgumentException {
    n1(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder(54);
        stringBuilder.append("Unpaired surrogate at index ");
        stringBuilder.append(i);
        stringBuilder.append(" of ");
        stringBuilder.append(i2);
        super(stringBuilder.toString());
    }
}
