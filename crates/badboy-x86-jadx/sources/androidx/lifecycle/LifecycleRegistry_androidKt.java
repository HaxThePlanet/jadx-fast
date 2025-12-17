package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0008\u0010\u0000\u001a\u00020\u0001H\u0001¨\u0006\u0002", d2 = {"isMainThread", "", "lifecycle-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LifecycleRegistry_androidKt {
    public static final boolean isMainThread() {
        return ArchTaskExecutor.getInstance().isMainThread();
    }
}
