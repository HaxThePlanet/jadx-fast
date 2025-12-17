package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class a8 {

    final Map<String, Callable<? extends com.google.android.gms.internal.measurement.j>> a;
    public a8() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
    }

    public final void a(String string, Callable<? extends com.google.android.gms.internal.measurement.j> callable2) {
        this.a.put(string, callable2);
    }
}
