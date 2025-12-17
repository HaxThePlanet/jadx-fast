package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;
import java.util.Date;

/* loaded from: classes2.dex */
public final class c implements c {

    public final com.google.firebase.remoteconfig.internal.ConfigFetchHandler a;
    public final j b;
    public final j c;
    public final Date d;
    public c(com.google.firebase.remoteconfig.internal.ConfigFetchHandler configFetchHandler, j j2, j j3, Date date4) {
        super();
        this.a = configFetchHandler;
        this.b = j2;
        this.c = j3;
        this.d = date4;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return this.a.e(this.b, this.c, this.d, j);
    }
}
