package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\rH\u0000\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0002\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\",\u0010\u0006\u001a \u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\u0008\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"NO_THREAD_ELEMENTS", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "updateState", "Lkotlinx/coroutines/internal/ThreadState;", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ThreadContextKt {

    public static final kotlinx.coroutines.internal.Symbol NO_THREAD_ELEMENTS;
    private static final Function2<Object, CoroutineContext.Element, Object> countAll;
    private static final Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> findOne;
    private static final Function2<kotlinx.coroutines.internal.ThreadState, CoroutineContext.Element, kotlinx.coroutines.internal.ThreadState> updateState;
    static {
        Symbol symbol = new Symbol("NO_THREAD_ELEMENTS");
        ThreadContextKt.NO_THREAD_ELEMENTS = symbol;
        ThreadContextKt.countAll = (Function2)ThreadContextKt.countAll.1.INSTANCE;
        ThreadContextKt.findOne = (Function2)ThreadContextKt.findOne.1.INSTANCE;
        ThreadContextKt.updateState = (Function2)ThreadContextKt.updateState.1.INSTANCE;
    }

    public static final void restoreThreadContext(CoroutineContext context, Object oldState) {
        Object fold;
        String str;
        if (oldState == ThreadContextKt.NO_THREAD_ELEMENTS) {
        }
        if (oldState instanceof ThreadState) {
            (ThreadState)oldState.restore(context);
        } else {
            fold = context.fold(0, ThreadContextKt.findOne);
            Intrinsics.checkNotNull(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            (ThreadContextElement)fold.restoreThreadContext(context, oldState);
        }
    }

    public static final Object threadContextElements(CoroutineContext context) {
        Object fold = context.fold(0, ThreadContextKt.countAll);
        Intrinsics.checkNotNull(fold);
        return fold;
    }

    public static final Object updateThreadContext(CoroutineContext context, Object countOrElement) {
        Object threadContextElements;
        Object element;
        Object threadContext;
        if (countOrElement == null) {
            threadContextElements = ThreadContextKt.threadContextElements(context);
        } else {
            threadContextElements = countOrElement;
        }
        if (threadContextElements == 0) {
            element = ThreadContextKt.NO_THREAD_ELEMENTS;
        } else {
            if (threadContextElements instanceof Integer) {
                ThreadState threadState = new ThreadState(context, (Number)threadContextElements.intValue());
                element = context.fold(threadState, ThreadContextKt.updateState);
            } else {
                Intrinsics.checkNotNull(threadContextElements, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
                element = threadContext;
            }
        }
        return element;
    }
}
