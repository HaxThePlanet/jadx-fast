package f.c.a.f.a.d;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
final class d implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "SplitCompatBackgroundThread");
        return thread;
    }
}
