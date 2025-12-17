package i.b.m0.g;

import i.b.z;
import i.b.z.c;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes3.dex */
public final class e extends z {

    private static final i.b.m0.g.h c;
    final ThreadFactory b;
    static {
        h hVar = new h("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
        e.c = hVar;
    }

    public e() {
        super(e.c);
    }

    public e(ThreadFactory threadFactory) {
        super();
        this.b = threadFactory;
    }

    @Override // i.b.z
    public z.c a() {
        f fVar = new f(this.b);
        return fVar;
    }
}
