package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a.a;

/* loaded from: classes.dex */
public final class l implements a.a {

    public final com.google.android.datatransport.runtime.scheduling.jobscheduling.v a;
    public l(com.google.android.datatransport.runtime.scheduling.jobscheduling.v v) {
        super();
        this.a = v;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a$a
    public final Object execute() {
        return this.a.c();
    }
}
