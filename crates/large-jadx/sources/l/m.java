package l;

import java.util.concurrent.TimeUnit;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public class m extends l.e0 {

    private l.e0 a;
    public m(l.e0 e0) {
        n.f(e0, "delegate");
        super();
        this.a = e0;
    }

    @Override // l.e0
    public final l.e0 a() {
        return this.a;
    }

    @Override // l.e0
    public final l.m b(l.e0 e0) {
        n.f(e0, "delegate");
        this.a = e0;
        return this;
    }

    @Override // l.e0
    public l.e0 clearDeadline() {
        return this.a.clearDeadline();
    }

    @Override // l.e0
    public l.e0 clearTimeout() {
        return this.a.clearTimeout();
    }

    @Override // l.e0
    public long deadlineNanoTime() {
        return this.a.deadlineNanoTime();
    }

    @Override // l.e0
    public l.e0 deadlineNanoTime(long l) {
        return this.a.deadlineNanoTime(l);
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
    public l.e0 timeout(long l, TimeUnit timeUnit2) {
        n.f(obj4, "unit");
        return this.a.timeout(l, timeUnit2);
    }

    @Override // l.e0
    public long timeoutNanos() {
        return this.a.timeoutNanos();
    }
}
