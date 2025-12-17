package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
public final class f implements c {

    public final k a;
    public f(k k) {
        super();
        this.a = k;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return Utils.b(this.a, j);
    }
}
