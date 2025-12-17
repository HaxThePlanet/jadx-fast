package com.google.android.play.core.tasks;

import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
final class t implements com.google.android.play.core.tasks.u {

    private final CountDownLatch a;
    t(com.google.android.play.core.tasks.s s) {
        super();
        CountDownLatch obj2 = new CountDownLatch(1);
        this.a = obj2;
    }

    @Override // com.google.android.play.core.tasks.u
    public final void a() {
        this.a.await();
    }

    @Override // com.google.android.play.core.tasks.u
    public final void onFailure(Exception exception) {
        this.a.countDown();
    }

    @Override // com.google.android.play.core.tasks.u
    public final void onSuccess(Object object) {
        this.a.countDown();
    }
}
