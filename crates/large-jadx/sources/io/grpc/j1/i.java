package io.grpc.j1;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
final class i implements io.grpc.j1.e1 {

    private final AtomicLong a;
    i() {
        super();
        AtomicLong atomicLong = new AtomicLong();
        this.a = atomicLong;
    }

    @Override // io.grpc.j1.e1
    public void add(long l) {
        this.a.getAndAdd(l);
    }
}
