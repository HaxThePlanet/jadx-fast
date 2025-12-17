package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzjd extends IOException {
    zzjd() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    zzjd(String string, Throwable throwable2) {
        String obj3;
        obj3 = String.valueOf(string);
        final String str = "CodedOutputStream was writing to a flat byte array and ran out of space.: ";
        if (obj3.length() != 0) {
            obj3 = str.concat(obj3);
        } else {
            obj3 = new String(str);
        }
        super(obj3, throwable2);
    }

    zzjd(Throwable throwable) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", throwable);
    }
}
