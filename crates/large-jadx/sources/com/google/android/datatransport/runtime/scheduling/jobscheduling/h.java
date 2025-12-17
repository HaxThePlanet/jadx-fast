package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a.a;
import f.c.a.b.i.p;

/* loaded from: classes.dex */
public final class h implements a.a {

    public final com.google.android.datatransport.runtime.scheduling.jobscheduling.t a;
    public final Iterable b;
    public final p c;
    public final long d;
    public h(com.google.android.datatransport.runtime.scheduling.jobscheduling.t t, Iterable iterable2, p p3, long l4) {
        super();
        this.a = t;
        this.b = iterable2;
        this.c = p3;
        this.d = l4;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a$a
    public final Object execute() {
        return this.a.g(this.b, this.c, this.d);
    }
}
