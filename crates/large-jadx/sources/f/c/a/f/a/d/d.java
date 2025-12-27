package f.c.a.f.a.d;

import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
final class d implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "SplitCompatBackgroundThread");
    }

    d() {
        super();
    }
}
