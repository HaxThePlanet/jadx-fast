package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.internal.ThreadLocalElement;
import kotlinx.coroutines.internal.ThreadLocalKey;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u001a+\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0007*\u0006\u0012\u0002\u0008\u00030\u0003H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0008\u001a\u0019\u0010\t\u001a\u00020\n*\u0006\u0012\u0002\u0008\u00030\u0003H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0008\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000b", d2 = {"asContextElement", "Lkotlinx/coroutines/ThreadContextElement;", "T", "Ljava/lang/ThreadLocal;", "value", "(Ljava/lang/ThreadLocal;Ljava/lang/Object;)Lkotlinx/coroutines/ThreadContextElement;", "ensurePresent", "", "(Ljava/lang/ThreadLocal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPresent", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ThreadContextElementKt {
    public static final <T> kotlinx.coroutines.ThreadContextElement<T> asContextElement(java.lang.ThreadLocal<T> $this$asContextElement, T value) {
        ThreadLocalElement threadLocalElement = new ThreadLocalElement(value, $this$asContextElement);
        return (ThreadContextElement)threadLocalElement;
    }

    public static kotlinx.coroutines.ThreadContextElement asContextElement$default(java.lang.ThreadLocal threadLocal, Object object2, int i3, Object object4) {
        Object obj1;
        if (i3 &= 1 != 0) {
            obj1 = threadLocal.get();
        }
        return ThreadContextElementKt.asContextElement(threadLocal, obj1);
    }

    public static final Object ensurePresent(java.lang.ThreadLocal<?> $this$ensurePresent, Continuation<? super Unit> $completion) {
        int i;
        final int i2 = 0;
        int i4 = 0;
        ThreadLocalKey threadLocalKey = new ThreadLocalKey($this$ensurePresent);
        i = $completion.getContext().get((CoroutineContext.Key)threadLocalKey) != null ? 1 : 0;
        if (i == 0) {
        } else {
            return Unit.INSTANCE;
        }
        int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("ThreadLocal ").append($this$ensurePresent).append(" is missing from context ").append($completion.getContext()).toString().toString());
        throw illegalStateException;
    }

    private static final Object ensurePresent$$forInline(java.lang.ThreadLocal<?> $this$ensurePresent, Continuation<? super Unit> $completion) {
        final int obj0 = 0;
        obj0.getContext();
        throw obj0;
    }

    public static final Object isPresent(java.lang.ThreadLocal<?> $this$isPresent, Continuation<? super Boolean> $completion) {
        int i;
        final int i2 = 0;
        ThreadLocalKey threadLocalKey = new ThreadLocalKey($this$isPresent);
        i = $completion.getContext().get((CoroutineContext.Key)threadLocalKey) != null ? 1 : 0;
        return Boxing.boxBoolean(i);
    }

    private static final Object isPresent$$forInline(java.lang.ThreadLocal<?> $this$isPresent, Continuation<? super Boolean> $completion) {
        final int obj0 = 0;
        obj0.getContext();
        throw obj0;
    }
}
