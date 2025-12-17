package io.grpc.m1;

import com.google.common.base.n;
import io.grpc.c;
import io.grpc.d;
import io.grpc.e;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class c<S extends io.grpc.m1.c<S>>  {

    private final e a;
    private final d b;

    public interface a {
        public abstract T a(e e, d d2);
    }
    protected c(e e, d d2) {
        super();
        n.p(e, "channel");
        this.a = (e)e;
        n.p(d2, "callOptions");
        this.b = (d)d2;
    }

    protected abstract S a(e e, d d2);

    public final d b() {
        return this.b;
    }

    public final e c() {
        return this.a;
    }

    public final S d(c c) {
        return a(this.a, this.b.k(c));
    }

    public final S e(long l, TimeUnit timeUnit2) {
        return a(this.a, this.b.m(l, timeUnit2));
    }

    public final S f(Executor executor) {
        return a(this.a, this.b.n(executor));
    }
}
