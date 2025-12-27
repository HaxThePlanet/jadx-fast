package io.grpc.j1;

import java.util.concurrent.TimeUnit;

/* compiled from: TimeProvider.java */
/* loaded from: classes3.dex */
public interface l2 {

    public static final l2 a = new l2$a();

    class a implements l2 {
        a() {
            super();
        }

        public long a() {
            return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        }
    }

    long a();
}
