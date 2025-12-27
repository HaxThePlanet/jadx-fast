package i.b.m0.g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: RxThreadFactory.java */
/* loaded from: classes3.dex */
public final class h extends AtomicLong implements ThreadFactory {

    private static final long serialVersionUID = -7789753024099756196L;
    final boolean nonBlocking;
    final String prefix;
    final int priority;

    static final class a extends Thread implements g {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }
    public h(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public Thread newThread(Runnable runnable) {
        i.b.m0.g.h.a aVar;
        StringBuilder stringBuilder = new StringBuilder(prefix2);
        long incrementAndGet = incrementAndGet();
        r0 = this.prefix + 45 + incrementAndGet;
        h.a r1 = this.nonBlocking ? new h.a(runnable, r0) : new Thread(runnable, r0);
        r1.setPriority(this.priority);
        r1.setDaemon(true);
        return r1;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "RxThreadFactory[";
        String str3 = "]";
        str = str2 + this.prefix + str3;
        return str;
    }

    public h(String str, int i) {
        this(str, i, false);
    }

    public h(String str, int i, boolean z) {
        super();
        this.prefix = str;
        this.priority = i;
        this.nonBlocking = z;
    }
}
