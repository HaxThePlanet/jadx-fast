package i.b.m0.g;

import i.b.z;
import i.b.z.c;
import java.util.concurrent.ThreadFactory;

/* compiled from: NewThreadScheduler.java */
/* loaded from: classes3.dex */
public final class e extends z {

    private static final h c = new h();
    final ThreadFactory b;
    static {
    }

    public e() {
        this(e.c);
    }

    @Override // i.b.z
    public z.c a() {
        return new f(this.b);
    }

    public e(ThreadFactory threadFactory) {
        super();
        this.b = threadFactory;
    }
}
