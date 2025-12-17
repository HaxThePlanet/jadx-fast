package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;
import java.util.Date;

/* loaded from: classes2.dex */
public final class e implements c {

    public final com.google.firebase.remoteconfig.internal.ConfigFetchHandler a;
    public final Date b;
    public e(com.google.firebase.remoteconfig.internal.ConfigFetchHandler configFetchHandler, Date date2) {
        super();
        this.a = configFetchHandler;
        this.b = date2;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        this.a.g(this.b, j);
        return j;
    }
}
