package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a.a;

/* loaded from: classes.dex */
public final class i implements a.a {

    public final com.google.android.datatransport.runtime.scheduling.jobscheduling.t a;
    public final Iterable b;
    public i(com.google.android.datatransport.runtime.scheduling.jobscheduling.t t, Iterable iterable2) {
        super();
        this.a = t;
        this.b = iterable2;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a$a
    public final Object execute() {
        return this.a.i(this.b);
    }
}
