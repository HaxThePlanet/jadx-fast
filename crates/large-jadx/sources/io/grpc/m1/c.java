package io.grpc.m1;

import com.google.common.base.n;
import io.grpc.c;
import io.grpc.d;
import io.grpc.e;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: AbstractStub.java */
/* loaded from: classes3.dex */
public abstract class c<S extends c<S>> {

    private final e a;
    private final d b;

    public interface a<T extends c<T>> {
        T a(e eVar, d dVar);
    }
    protected c(e eVar, d dVar) {
        super();
        n.p(eVar, "channel");
        this.a = eVar;
        n.p(dVar, "callOptions");
        this.b = dVar;
    }

    public final d b() {
        return this.b;
    }

    public final e c() {
        return this.a;
    }

    public final S d(c cVar) {
        return a(this.a, this.b.k(cVar));
    }

    public final S e(long j, TimeUnit timeUnit) {
        return a(this.a, this.b.m(j, timeUnit));
    }

    public final S f(Executor executor) {
        return a(this.a, this.b.n(executor));
    }

    protected abstract S a(e eVar, d dVar);
}
