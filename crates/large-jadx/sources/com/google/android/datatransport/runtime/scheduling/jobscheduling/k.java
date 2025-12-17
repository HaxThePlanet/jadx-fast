package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a.a;
import java.util.Map;

/* loaded from: classes.dex */
public final class k implements a.a {

    public final com.google.android.datatransport.runtime.scheduling.jobscheduling.t a;
    public final Map b;
    public k(com.google.android.datatransport.runtime.scheduling.jobscheduling.t t, Map map2) {
        super();
        this.a = t;
        this.b = map2;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a$a
    public final Object execute() {
        return this.a.k(this.b);
    }
}
