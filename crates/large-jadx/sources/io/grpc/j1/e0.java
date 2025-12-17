package io.grpc.j1;

import com.google.common.base.n;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class e0 implements io.grpc.j1.k {

    private Random a;
    private long b;
    private long c;
    private double d = 1.6d;
    private double e = 0.2d;
    private long f = 4596373779694328218L;

    public static final class a implements io.grpc.j1.k.a {
        @Override // io.grpc.j1.k$a
        public io.grpc.j1.k get() {
            e0 e0Var = new e0();
            return e0Var;
        }
    }
    public e0() {
        super();
        Random random = new Random();
        this.a = random;
        this.b = TimeUnit.SECONDS.toNanos(1);
        this.c = TimeUnit.MINUTES.toNanos(2);
        long l = 4609884578576439706L;
        long l2 = 4596373779694328218L;
        long l3 = this.b;
    }

    private long b(double d, double d2) {
        int i;
        i = Double.compare(obj5, d) >= 0 ? 1 : 0;
        n.d(i);
        return (long)i3;
    }

    @Override // io.grpc.j1.k
    public long a() {
        long l = this.f;
        double d = (double)l;
        this.f = Math.min((long)i2, obj5);
        double d3 = this.e;
        return l += l2;
    }
}
