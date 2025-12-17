package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class y implements c {

    public final com.google.android.gms.cloudmessaging.d a;
    public final Bundle b;
    public y(com.google.android.gms.cloudmessaging.d d, Bundle bundle2) {
        super();
        this.a = d;
        this.b = bundle2;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return this.a.c(this.b, j);
    }
}
