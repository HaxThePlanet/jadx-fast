package com.google.firebase.installations;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
final class AwaitListener implements e<Void> {

    private final CountDownLatch latch;
    AwaitListener() {
        super();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.latch = countDownLatch;
    }

    @Override // com.google.android.gms.tasks.e
    public boolean await(long l, TimeUnit timeUnit2) {
        return this.latch.await(l, timeUnit2);
    }

    public void onComplete(j<Void> j) {
        this.latch.countDown();
    }

    @Override // com.google.android.gms.tasks.e
    public void onSuccess() {
        this.latch.countDown();
    }
}
