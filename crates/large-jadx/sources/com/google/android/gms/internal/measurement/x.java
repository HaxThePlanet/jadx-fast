package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class x {

    final List<com.google.android.gms.internal.measurement.n0> a;
    protected x() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
    }

    public abstract com.google.android.gms.internal.measurement.q a(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3);

    final com.google.android.gms.internal.measurement.q b(String string) {
        String obj4;
        if (!this.a.contains(b6.e(string))) {
        } else {
            obj4 = String.valueOf(string);
            String str2 = "Command not implemented: ";
            if (obj4.length() != 0) {
                obj4 = str2.concat(obj4);
            } else {
                obj4 = new String(str2);
            }
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(obj4);
            throw unsupportedOperationException;
        }
        obj4 = new IllegalArgumentException("Command not supported");
        throw obj4;
    }
}
