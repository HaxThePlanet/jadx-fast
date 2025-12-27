package l;

import java.util.concurrent.TimeUnit;
import kotlin.d0.d.n;

/* compiled from: ForwardingTimeout.kt */
/* loaded from: classes3.dex */
public class m extends e0 {

    private e0 a;
    public m(e0 e0Var) {
        n.f(e0Var, "delegate");
        super();
        this.a = e0Var;
    }

    @Override // l.e0
    public final e0 a() {
        return this.a;
    }

    @Override // l.e0
    public final m b(e0 e0Var) {
        n.f(e0Var, "delegate");
        this.a = e0Var;
        return this;
    }

    @Override // l.e0
    public e0 clearDeadline() {
        return this.a.clearDeadline();
    }

    @Override // l.e0
    public e0 clearTimeout() {
        return this.a.clearTimeout();
    }

    @Override // l.e0
    public long deadlineNanoTime() {
        return this.a.deadlineNanoTime();
    }

    @Override // l.e0
    public boolean hasDeadline() {
        return this.a.hasDeadline();
    }

    @Override // l.e0
    public void throwIfReached() {
        this.a.throwIfReached();
    }

    @Override // l.e0
    public e0 timeout(long j, TimeUnit timeUnit) {
        n.f(timeUnit, "unit");
        return this.a.timeout(j, timeUnit);
    }

    @Override // l.e0
    public long timeoutNanos() {
        return this.a.timeoutNanos();
    }

    @Override // l.e0
    public e0 deadlineNanoTime(long j) {
        return this.a.deadlineNanoTime(j);
    }
}
