package com.google.android.gms.cloudmessaging;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes2.dex */
public final class a0 implements e {

    public final com.google.android.gms.cloudmessaging.d a;
    public final String b;
    public final ScheduledFuture c;
    public a0(com.google.android.gms.cloudmessaging.d d, String string2, ScheduledFuture scheduledFuture3) {
        super();
        this.a = d;
        this.b = string2;
        this.c = scheduledFuture3;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        this.a.e(this.b, this.c, j);
    }
}
