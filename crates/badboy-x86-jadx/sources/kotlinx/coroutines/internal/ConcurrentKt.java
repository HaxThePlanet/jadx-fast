package kotlinx.coroutines.internal;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u001d\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\u0008\u001a\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0000\u001a*\u0010\u000b\u001a\u0002H\u000c\"\u0004\u0008\u0000\u0010\u000c*\u00060\rj\u0002`\u000e2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u000c0\u0010H\u0080\u0008¢\u0006\u0002\u0010\u0011\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000*\u000c\u0008\u0000\u0010\u0012\"\u00020\r2\u00020\r¨\u0006\u0013", d2 = {"REMOVE_FUTURE_ON_CANCEL", "Ljava/lang/reflect/Method;", "identitySet", "", "E", "expectedSize", "", "removeFutureOnCancel", "", "executor", "Ljava/util/concurrent/Executor;", "withLock", "T", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ReentrantLock", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ConcurrentKt {

    private static final Method REMOVE_FUTURE_ON_CANCEL = null;
    static {
        try {
            Class[] arr = new Class[1];
            Method method = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", Boolean.TYPE);
            Throwable e = i;
        }
    }

    public static void ReentrantLock$annotations() {
    }

    public static final <E> Set<E> identitySet(int expectedSize) {
        final int i = 0;
        IdentityHashMap identityHashMap = new IdentityHashMap(expectedSize);
        return Collections.newSetFromMap((Map)identityHashMap);
    }

    public static final boolean removeFutureOnCancel(Executor executor) {
        int i;
        final int i2 = 0;
        if (executor instanceof ScheduledThreadPoolExecutor) {
            i = executor;
        } else {
            try {
                i = 0;
                if (i == 0) {
                }
                return i2;
                final Method rEMOVE_FUTURE_ON_CANCEL = ConcurrentKt.REMOVE_FUTURE_ON_CANCEL;
                if (rEMOVE_FUTURE_ON_CANCEL == null) {
                }
                return i2;
                final int i3 = 1;
                rEMOVE_FUTURE_ON_CANCEL.invoke(i, /* result */);
                return i3;
                return obj0;
            }
        }
    }

    public static final <T> T withLock(ReentrantLock $this$withLock, Function0<? extends T> action) {
        final int i = 0;
        final Lock lock = $this$withLock;
        (Lock)lock.lock();
        lock.unlock();
        return action.invoke();
    }
}
