package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
public final class l0 extends com.google.android.gms.internal.measurement.x {
    public final com.google.android.gms.internal.measurement.q a(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3) {
        boolean empty;
        final int i = 0;
        final int i2 = 1;
        if (string == null) {
        } else {
            if (string.isEmpty()) {
            } else {
                if (!b52.h(string)) {
                } else {
                    com.google.android.gms.internal.measurement.q qVar = b52.d(string);
                    if (!qVar instanceof j) {
                    } else {
                        return (j)qVar.a(b52, list3);
                    }
                    Object[] obj7 = new Object[i2];
                    obj7[i] = string;
                    IllegalArgumentException obj6 = new IllegalArgumentException(String.format("Function %s is not defined", obj7));
                    throw obj6;
                }
            }
        }
        obj7 = new Object[i2];
        obj7[i] = string;
        obj6 = new IllegalArgumentException(String.format("Command not found: %s", obj7));
        throw obj6;
    }
}
