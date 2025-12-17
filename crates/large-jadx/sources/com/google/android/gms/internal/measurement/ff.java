package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class ff extends com.google.android.gms.internal.measurement.j {

    private final Callable<Object> c;
    public ff(String string, Callable<Object> callable2) {
        super("internal.appMetadata");
        this.c = callable2;
    }

    public final com.google.android.gms.internal.measurement.q a(com.google.android.gms.internal.measurement.b5 b5, List<com.google.android.gms.internal.measurement.q> list2) {
        try {
            return c7.b(this.c.call());
            b5 = q.h;
            return b5;
        }
    }
}
