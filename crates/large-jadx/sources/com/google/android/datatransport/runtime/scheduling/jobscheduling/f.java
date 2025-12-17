package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a.a;
import f.c.a.b.i.p;

/* loaded from: classes.dex */
public final class f implements a.a {

    public final com.google.android.datatransport.runtime.scheduling.jobscheduling.t a;
    public final p b;
    public f(com.google.android.datatransport.runtime.scheduling.jobscheduling.t t, p p2) {
        super();
        this.a = t;
        this.b = p2;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a$a
    public final Object execute() {
        return this.a.c(this.b);
    }
}
