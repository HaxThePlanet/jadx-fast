package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
public final class g implements c {

    public final CountDownLatch a;
    public g(CountDownLatch countDownLatch) {
        super();
        this.a = countDownLatch;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return Utils.a(this.a, j);
    }
}
