package io.grpc.j1;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: AtomicLongCounter.java */
/* loaded from: classes3.dex */
final class i implements e1 {

    private final AtomicLong a = new AtomicLong();
    i() {
        super();
        final AtomicLong atomicLong = new AtomicLong();
    }

    public void add(long j) {
        this.a.getAndAdd(j);
    }
}
