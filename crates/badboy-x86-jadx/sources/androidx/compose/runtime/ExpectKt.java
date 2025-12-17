package androidx.compose.runtime;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002H\u0000\u001a\u000c\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000¨\u0006\u0006", d2 = {"ThreadLocal", "Landroidx/compose/runtime/ThreadLocal;", "T", "postIncrement", "", "Landroidx/compose/runtime/AtomicInt;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ExpectKt {
    public static final <T> androidx.compose.runtime.ThreadLocal<T> ThreadLocal() {
        ThreadLocal threadLocal = new ThreadLocal((Function0)ExpectKt.ThreadLocal.1.INSTANCE);
        return threadLocal;
    }

    public static final int postIncrement(androidx.compose.runtime.AtomicInt $this$postIncrement) {
        final int i = 1;
        return i2 -= i;
    }
}
