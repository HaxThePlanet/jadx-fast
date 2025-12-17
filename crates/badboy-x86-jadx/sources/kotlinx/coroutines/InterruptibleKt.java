package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a/\u0010\u0005\u001a\u0002H\u0006\"\u0004\u0008\u0000\u0010\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a)\u0010\u000c\u001a\u0002H\u0006\"\u0004\u0008\u0000\u0010\u00062\u0006\u0010\r\u001a\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\nH\u0002¢\u0006\u0002\u0010\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000f", d2 = {"FINISHED", "", "INTERRUPTED", "INTERRUPTING", "WORKING", "runInterruptible", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runInterruptibleInExpectedContext", "coroutineContext", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InterruptibleKt {

    private static final int FINISHED = 1;
    private static final int INTERRUPTED = 3;
    private static final int INTERRUPTING = 2;
    private static final int WORKING;
    public static final Object access$runInterruptibleInExpectedContext(CoroutineContext coroutineContext, Function0 block) {
        return InterruptibleKt.runInterruptibleInExpectedContext(coroutineContext, block);
    }

    public static final <T> Object runInterruptible(CoroutineContext context, Function0<? extends T> block, Continuation<? super T> $completion) {
        InterruptibleKt.runInterruptible.2 anon = new InterruptibleKt.runInterruptible.2(block, 0);
        return BuildersKt.withContext(context, (Function2)anon, $completion);
    }

    public static Object runInterruptible$default(CoroutineContext coroutineContext, Function0 function02, Continuation continuation3, int i4, Object object5) {
        EmptyCoroutineContext obj0;
        if (i4 &= 1 != 0) {
            obj0 = EmptyCoroutineContext.INSTANCE;
        }
        return InterruptibleKt.runInterruptible(obj0, function02, continuation3);
    }

    private static final <T> T runInterruptibleInExpectedContext(CoroutineContext coroutineContext, Function0<? extends T> block) {
        ThreadState threadState2 = new ThreadState(JobKt.getJob(coroutineContext));
        threadState2.setup();
        threadState2.clearInterrupt();
        return block.invoke();
    }
}
