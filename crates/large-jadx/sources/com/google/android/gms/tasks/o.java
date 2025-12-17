package com.google.android.gms.tasks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
final class o implements com.google.android.gms.tasks.p {

    private final CountDownLatch a;
    o(com.google.android.gms.tasks.n0 n0) {
        super();
        CountDownLatch obj2 = new CountDownLatch(1);
        this.a = obj2;
    }

    @Override // com.google.android.gms.tasks.p
    public final void a() {
        this.a.await();
    }

    @Override // com.google.android.gms.tasks.p
    public final boolean b(long l, TimeUnit timeUnit2) {
        return this.a.await(l, timeUnit2);
    }

    @Override // com.google.android.gms.tasks.p
    public final void onCanceled() {
        this.a.countDown();
    }

    @Override // com.google.android.gms.tasks.p
    public final void onFailure(Exception exception) {
        this.a.countDown();
    }

    @Override // com.google.android.gms.tasks.p
    public final void onSuccess(Object object) {
        this.a.countDown();
    }
}
