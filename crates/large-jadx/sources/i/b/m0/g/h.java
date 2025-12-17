package i.b.m0.g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class h extends AtomicLong implements ThreadFactory {

    private static final long serialVersionUID = -7789753024099756196L;
    final boolean nonBlocking;
    final String prefix;
    final int priority;

    static final class a extends Thread implements i.b.m0.g.g {
        a(Runnable runnable, String string2) {
            super(runnable, string2);
        }
    }
    public h(String string) {
        super(string, 5, 0);
    }

    public h(String string, int i2) {
        super(string, i2, 0);
    }

    public h(String string, int i2, boolean z3) {
        super();
        this.prefix = string;
        this.priority = i2;
        this.nonBlocking = z3;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public Thread newThread(Runnable runnable) {
        Thread aVar;
        StringBuilder stringBuilder = new StringBuilder(this.prefix);
        stringBuilder.append('-');
        stringBuilder.append(incrementAndGet());
        String string = stringBuilder.toString();
        if (this.nonBlocking) {
            aVar = new h.a(runnable, string);
        } else {
            aVar = new Thread(runnable, string);
        }
        aVar.setPriority(this.priority);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RxThreadFactory[");
        stringBuilder.append(this.prefix);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
