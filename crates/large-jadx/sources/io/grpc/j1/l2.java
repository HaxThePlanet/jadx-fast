package io.grpc.j1;

import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public interface l2 {

    public static final io.grpc.j1.l2 a;

    class a implements io.grpc.j1.l2 {
        @Override // io.grpc.j1.l2
        public long a() {
            return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        }
    }
    static {
        l2.a aVar = new l2.a();
        l2.a = aVar;
    }

    public abstract long a();
}
