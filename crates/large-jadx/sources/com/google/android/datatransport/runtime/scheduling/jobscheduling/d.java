package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a.a;
import f.c.a.b.i.p;

/* loaded from: classes.dex */
public final class d implements a.a {

    public final com.google.android.datatransport.runtime.scheduling.jobscheduling.t a;
    public final p b;
    public final long c;
    public d(com.google.android.datatransport.runtime.scheduling.jobscheduling.t t, p p2, long l3) {
        super();
        this.a = t;
        this.b = p2;
        this.c = l3;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a$a
    public final Object execute() {
        return this.a.m(this.b, this.c);
    }
}
