package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.internal.Symbol;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u001aB\u0010\u000e\u001a\u0002H\u000f\"\u0004\u0008\u0000\u0010\u000f*\u00020\u000b2\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u000f0\u0013H\u0086Hø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0008\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0015", d2 = {"HOLDS_LOCK_ANOTHER_OWNER", "", "HOLDS_LOCK_UNLOCKED", "HOLDS_LOCK_YES", "NO_OWNER", "Lkotlinx/coroutines/internal/Symbol;", "ON_LOCK_ALREADY_LOCKED_BY_OWNER", "TRY_LOCK_ALREADY_LOCKED_BY_OWNER", "TRY_LOCK_FAILED", "TRY_LOCK_SUCCESS", "Mutex", "Lkotlinx/coroutines/sync/Mutex;", "locked", "", "withLock", "T", "owner", "", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MutexKt {

    private static final int HOLDS_LOCK_ANOTHER_OWNER = 2;
    private static final int HOLDS_LOCK_UNLOCKED = 0;
    private static final int HOLDS_LOCK_YES = 1;
    private static final Symbol NO_OWNER = null;
    private static final Symbol ON_LOCK_ALREADY_LOCKED_BY_OWNER = null;
    private static final int TRY_LOCK_ALREADY_LOCKED_BY_OWNER = 2;
    private static final int TRY_LOCK_FAILED = 1;
    private static final int TRY_LOCK_SUCCESS;
    static {
        Symbol symbol = new Symbol("NO_OWNER");
        MutexKt.NO_OWNER = symbol;
        Symbol symbol2 = new Symbol("ALREADY_LOCKED_BY_OWNER");
        MutexKt.ON_LOCK_ALREADY_LOCKED_BY_OWNER = symbol2;
    }

    public static final kotlinx.coroutines.sync.Mutex Mutex(boolean locked) {
        MutexImpl mutexImpl = new MutexImpl(locked);
        return (Mutex)mutexImpl;
    }

    public static kotlinx.coroutines.sync.Mutex Mutex$default(boolean z, int i2, Object object3) {
        int obj0;
        if (i2 &= 1 != 0) {
            obj0 = 0;
        }
        return MutexKt.Mutex(obj0);
    }

    public static final Symbol access$getNO_OWNER$p() {
        return MutexKt.NO_OWNER;
    }

    public static final Symbol access$getON_LOCK_ALREADY_LOCKED_BY_OWNER$p() {
        return MutexKt.ON_LOCK_ALREADY_LOCKED_BY_OWNER;
    }

    public static final <T> Object withLock(kotlinx.coroutines.sync.Mutex mutex, Object object2, Function0<? extends T> function03, Continuation<? super T> continuation4) {
        boolean anon;
        int i2;
        Object l$0;
        int i;
        int label;
        Object lock;
        int obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        anon = continuation4;
        i = Integer.MIN_VALUE;
        if (continuation4 instanceof MutexKt.withLock.1 && label2 &= i != 0) {
            anon = continuation4;
            i = Integer.MIN_VALUE;
            if (label2 &= i != 0) {
                anon.label = obj7 -= i;
            } else {
                anon = new MutexKt.withLock.1(continuation4);
            }
        } else {
        }
        obj7 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj7);
                anon.L$0 = mutex;
                anon.L$1 = object2;
                anon.L$2 = function03;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj6 = object2;
                obj5 = obj;
                l$0 = mutex;
                obj4 = label;
                break;
            case 1:
                obj4 = 0;
                obj5 = anon.L$2;
                obj6 = anon.L$1;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj7);
                break;
            default:
                obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj4;
        }
        l$0.unlock(obj6);
        return obj5.invoke();
    }

    private static final <T> Object withLock$$forInline(kotlinx.coroutines.sync.Mutex $this$withLock, Object owner, Function0<? extends T> action, Continuation<? super T> $completion) {
        final int i = 0;
        $this$withLock.lock(owner, $completion);
        $this$withLock.unlock(owner);
        return action.invoke();
    }

    public static Object withLock$default(kotlinx.coroutines.sync.Mutex $this$withLock_u24default, Object owner, Function0 action, Continuation $completion, int i5, Object object6) {
        int obj1;
        if (i5 &= 1 != 0) {
            obj1 = 0;
        }
        int obj4 = 0;
        $this$withLock_u24default.lock(obj1, $completion);
        $this$withLock_u24default.unlock(obj1);
        return action.invoke();
    }
}
