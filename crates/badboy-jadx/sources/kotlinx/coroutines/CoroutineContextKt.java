package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.internal.ThreadContextKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002\u001a8\u0010\u000b\u001a\u0002H\u000c\"\u0004\u0008\u0000\u0010\u000c2\n\u0010\r\u001a\u0006\u0012\u0002\u0008\u00030\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u000c0\u0012H\u0080\u0008¢\u0006\u0002\u0010\u0013\u001a4\u0010\u0014\u001a\u0002H\u000c\"\u0004\u0008\u0000\u0010\u000c2\u0006\u0010\u0015\u001a\u00020\u00032\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u000c0\u0012H\u0080\u0008¢\u0006\u0002\u0010\u0016\u001a\u000c\u0010\u0017\u001a\u00020\n*\u00020\u0003H\u0002\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0003H\u0007\u001a\u0013\u0010\u001b\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u001c*\u00020\u001dH\u0080\u0010\u001a(\u0010\u001e\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u001c*\u0006\u0012\u0002\u0008\u00030\u000e2\u0006\u0010\u0015\u001a\u00020\u00032\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006 ", d2 = {"DEBUG_THREAD_NAME_SEPARATOR", "", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "foldCopies", "originalContext", "appendContext", "isNewCoroutine", "", "withContinuationContext", "T", "continuation", "Lkotlin/coroutines/Continuation;", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withCoroutineContext", "context", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hasCopyableElements", "newCoroutineContext", "addedContext", "Lkotlinx/coroutines/CoroutineScope;", "undispatchedCompletion", "Lkotlinx/coroutines/UndispatchedCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "updateUndispatchedCompletion", "oldValue", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CoroutineContextKt {

    private static final String DEBUG_THREAD_NAME_SEPARATOR = " @";
    private static final CoroutineContext foldCopies(CoroutineContext originalContext, CoroutineContext appendContext, boolean isNewCoroutine) {
        Object anon;
        EmptyCoroutineContext iNSTANCE;
        kotlinx.coroutines.CoroutineContextKt.foldCopies.1 iNSTANCE2;
        final boolean copyableElements2 = CoroutineContextKt.hasCopyableElements(appendContext);
        if (!CoroutineContextKt.hasCopyableElements(originalContext) && !copyableElements2) {
            if (!copyableElements2) {
                return originalContext.plus(appendContext);
            }
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = appendContext;
        anon = new CoroutineContextKt.foldCopies.folded.1(objectRef, isNewCoroutine);
        if (copyableElements2) {
            objectRef.element = (CoroutineContext)objectRef.element.fold(EmptyCoroutineContext.INSTANCE, (Function2)CoroutineContextKt.foldCopies.1.INSTANCE);
        }
        return (CoroutineContext)originalContext.fold(EmptyCoroutineContext.INSTANCE, (Function2)anon).plus((CoroutineContext)objectRef.element);
    }

    public static final String getCoroutineName(CoroutineContext $this$coroutineName) {
        String name;
        int i = 0;
        if (!DebugKt.getDEBUG()) {
            return i;
        }
        kotlin.coroutines.CoroutineContext.Element context = $this$coroutineName.get((CoroutineContext.Key)CoroutineId.Key);
        if ((CoroutineId)context == null) {
            return i;
        }
        name = $this$coroutineName.get((CoroutineContext.Key)CoroutineName.Key);
        if ((CoroutineName)name != null) {
            if ((CoroutineName)name.getName() == null) {
                name = "coroutine";
            }
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(name).append('#').append((CoroutineId)context.getId()).toString();
    }

    private static final boolean hasCopyableElements(CoroutineContext $this$hasCopyableElements) {
        return (Boolean)$this$hasCopyableElements.fold(false, (Function2)CoroutineContextKt.hasCopyableElements.1.INSTANCE).booleanValue();
    }

    public static final CoroutineContext newCoroutineContext(CoroutineContext $this$newCoroutineContext, CoroutineContext addedContext) {
        if (!CoroutineContextKt.hasCopyableElements(addedContext)) {
            return $this$newCoroutineContext.plus(addedContext);
        }
        return CoroutineContextKt.foldCopies($this$newCoroutineContext, addedContext, false);
    }

    public static final CoroutineContext newCoroutineContext(kotlinx.coroutines.CoroutineScope $this$newCoroutineContext, CoroutineContext context) {
        CoroutineContext plus2;
        long incrementAndGet;
        CoroutineContext plus;
        kotlin.coroutines.CoroutineContext.Element default;
        CoroutineContext foldCopies = CoroutineContextKt.foldCopies($this$newCoroutineContext.getCoroutineContext(), context, true);
        if (DebugKt.getDEBUG()) {
            CoroutineId coroutineId = new CoroutineId(DebugKt.getCOROUTINE_ID().incrementAndGet(), obj3);
            plus2 = foldCopies.plus((CoroutineContext)coroutineId);
        } else {
            plus2 = foldCopies;
        }
        if (foldCopies != Dispatchers.getDefault() && foldCopies.get((CoroutineContext.Key)ContinuationInterceptor.Key) == null) {
            if (foldCopies.get((CoroutineContext.Key)ContinuationInterceptor.Key) == null) {
                plus = plus2.plus((CoroutineContext)Dispatchers.getDefault());
            } else {
                plus = plus2;
            }
        } else {
        }
        return plus;
    }

    public static final kotlinx.coroutines.UndispatchedCoroutine<?> undispatchedCompletion(CoroutineStackFrame $this$undispatchedCompletion) {
        CoroutineStackFrame callerFrame;
        boolean z;
        Object obj2;
        int i = 0;
        while (obj2 instanceof DispatchedCoroutine) {
            callerFrame = obj2.getCallerFrame();
            obj2 = callerFrame;
            i = 0;
        }
        return i;
    }

    public static final kotlinx.coroutines.UndispatchedCoroutine<?> updateUndispatchedCompletion(Continuation<?> $this$updateUndispatchedCompletion, CoroutineContext context, Object oldValue) {
        int i;
        int i2 = 0;
        if (!$this$updateUndispatchedCompletion instanceof CoroutineStackFrame) {
            return i2;
        }
        i = context.get((CoroutineContext.Key)UndispatchedMarker.INSTANCE) != null ? 1 : 0;
        if (i == 0) {
            return i2;
        }
        kotlinx.coroutines.UndispatchedCoroutine undispatchedCompletion = CoroutineContextKt.undispatchedCompletion((CoroutineStackFrame)$this$updateUndispatchedCompletion);
        if (undispatchedCompletion != null) {
            undispatchedCompletion.saveThreadContext(context, oldValue);
        }
        return undispatchedCompletion;
    }

    public static final <T> T withContinuationContext(Continuation<?> continuation, Object countOrElement, Function0<? extends T> block) {
        kotlinx.coroutines.UndispatchedCoroutine undispatchedCompletion;
        Throwable th;
        boolean clearThreadContext;
        final int i = 0;
        final CoroutineContext context = continuation.getContext();
        final Object threadContext = ThreadContextKt.updateThreadContext(context, countOrElement);
        if (threadContext != ThreadContextKt.NO_THREAD_ELEMENTS) {
            undispatchedCompletion = CoroutineContextKt.updateUndispatchedCompletion(continuation, context, threadContext);
        } else {
            undispatchedCompletion = 0;
        }
        if (undispatchedCompletion != null) {
            if (undispatchedCompletion.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context, threadContext);
            }
        } else {
        }
        return block.invoke();
    }

    public static final <T> T withCoroutineContext(CoroutineContext context, Object countOrElement, Function0<? extends T> block) {
        final int i = 0;
        ThreadContextKt.restoreThreadContext(context, ThreadContextKt.updateThreadContext(context, countOrElement));
        return block.invoke();
    }
}
