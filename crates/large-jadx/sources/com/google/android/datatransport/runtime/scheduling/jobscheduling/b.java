package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a.a;
import f.c.a.b.i.a0.j.i0;

/* loaded from: classes.dex */
public final class b implements a.a {

    public final i0 a;
    public b(i0 i0) {
        super();
        this.a = i0;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a$a
    public final Object execute() {
        return Integer.valueOf(this.a.s());
    }
}
