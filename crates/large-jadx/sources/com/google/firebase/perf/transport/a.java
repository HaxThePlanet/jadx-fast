package com.google.firebase.perf.transport;

import com.google.protobuf.a;
import f.c.a.b.e;

/* loaded from: classes2.dex */
public final class a implements e {

    public static final com.google.firebase.perf.transport.a a;
    static {
        a aVar = new a();
        a.a = aVar;
    }

    @Override // f.c.a.b.e
    public final Object apply(Object object) {
        return (PerfMetric)object.toByteArray();
    }
}
