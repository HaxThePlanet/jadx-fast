package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0081\u0008\u0018\u00002\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0006\u001a\u0006\u0012\u0002\u0008\u00030\u0004HÂ\u0003J\u0017\u0010\u0007\u001a\u00020\u00002\u000c\u0008\u0002\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004HÆ\u0001J\u0013\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lkotlinx/coroutines/internal/ThreadLocalKey;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/internal/ThreadLocalElement;", "threadLocal", "Ljava/lang/ThreadLocal;", "(Ljava/lang/ThreadLocal;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ThreadLocalKey implements CoroutineContext.Key<kotlinx.coroutines.internal.ThreadLocalElement<?>> {

    private final java.lang.ThreadLocal<?> threadLocal;
    public ThreadLocalKey(java.lang.ThreadLocal<?> threadLocal) {
        super();
        this.threadLocal = threadLocal;
    }

    private final java.lang.ThreadLocal<?> component1() {
        return this.threadLocal;
    }

    public static kotlinx.coroutines.internal.ThreadLocalKey copy$default(kotlinx.coroutines.internal.ThreadLocalKey threadLocalKey, java.lang.ThreadLocal threadLocal2, int i3, Object object4) {
        java.lang.ThreadLocal obj1;
        if (i3 &= 1 != 0) {
            obj1 = threadLocalKey.threadLocal;
        }
        return threadLocalKey.copy(obj1);
    }

    public final kotlinx.coroutines.internal.ThreadLocalKey copy(java.lang.ThreadLocal<?> threadLocal) {
        ThreadLocalKey threadLocalKey = new ThreadLocalKey(threadLocal);
        return threadLocalKey;
    }

    @Override // kotlin.coroutines.CoroutineContext$Key
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ThreadLocalKey) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.threadLocal, obj.threadLocal)) {
            return i2;
        }
        return i;
    }

    @Override // kotlin.coroutines.CoroutineContext$Key
    public int hashCode() {
        return this.threadLocal.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext$Key
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ThreadLocalKey(threadLocal=").append(this.threadLocal).append(')').toString();
    }
}
