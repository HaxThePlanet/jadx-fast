package io.grpc.j1;

import com.google.common.base.n;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* compiled from: ExponentialBackoffPolicy.java */
/* loaded from: classes3.dex */
public final class e0 implements k {

    private Random a = new Random();
    private long b;
    private long c;
    private double d = 1.6d;
    private double e = 0.2d;
    private long f;

    public static final class a implements k.a {
        public k get() {
            return new e0();
        }
    }
    public e0() {
        super();
        Random random = new Random();
        this.b = TimeUnit.SECONDS.toNanos(1L);
        this.c = TimeUnit.MINUTES.toNanos(2L);
        this.f = this.b;
    }

    private long b(double d, double d2) {
        boolean z = true;
        int r0 = d2 >= d ? 1 : 0;
        n.d((d2 >= d ? 1 : 0));
        return (long)(d2 >= d ? 1 : 0);
    }

    public long a() {
        double d = (double)l;
        this.f = Math.min((long)(this.d * d), this.c);
        return l + (b(-d4 * d, d4 * d));
    }
}
