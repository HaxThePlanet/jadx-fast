package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class lb extends java.lang.IllegalArgumentException {
    lb(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder(54);
        stringBuilder.append("Unpaired surrogate at index ");
        stringBuilder.append(i);
        stringBuilder.append(" of ");
        stringBuilder.append(i2);
        super(stringBuilder.toString());
    }
}
