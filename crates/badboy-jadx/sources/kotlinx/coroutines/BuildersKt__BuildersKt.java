package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aT\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0005¢\u0006\u0002\u0008\tø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000b", d2 = {"runBlocking", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/BuildersKt")
final class BuildersKt__BuildersKt {
    public static final <T> T runBlocking(CoroutineContext context, Function2<? super kotlinx.coroutines.CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) throws java.lang.InterruptedException {
        int eventLoop;
        CoroutineContext newContext;
        kotlinx.coroutines.GlobalScope iNSTANCE2;
        kotlin.coroutines.CoroutineContext.Element iNSTANCE;
        int currentOrNull$kotlinx_coroutines_core;
        boolean it;
        int i;
        kotlin.coroutines.CoroutineContext.Element context2 = context.get((CoroutineContext.Key)ContinuationInterceptor.Key);
        int i2 = 0;
        int i3 = 0;
        if ((ContinuationInterceptor)context2 == null) {
            newContext = CoroutineContextKt.newCoroutineContext((CoroutineScope)GlobalScope.INSTANCE, context.plus((CoroutineContext)ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core()));
        } else {
            if (context2 instanceof EventLoop) {
                iNSTANCE = context2;
            } else {
                iNSTANCE = currentOrNull$kotlinx_coroutines_core;
            }
            if (iNSTANCE != null) {
                i = 0;
                if (iNSTANCE.shouldBeProcessedFromContext()) {
                    currentOrNull$kotlinx_coroutines_core = iNSTANCE;
                }
                if (currentOrNull$kotlinx_coroutines_core == 0) {
                    currentOrNull$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.currentOrNull$kotlinx_coroutines_core();
                }
            } else {
            }
            eventLoop = currentOrNull$kotlinx_coroutines_core;
            newContext = CoroutineContextKt.newCoroutineContext((CoroutineScope)GlobalScope.INSTANCE, context);
        }
        BlockingCoroutine blockingCoroutine = new BlockingCoroutine(newContext, Thread.currentThread(), eventLoop);
        blockingCoroutine.start(CoroutineStart.DEFAULT, blockingCoroutine, block);
        return blockingCoroutine.joinBlocking();
    }

    public static Object runBlocking$default(CoroutineContext coroutineContext, Function2 function22, int i3, Object object4) throws java.lang.InterruptedException {
        EmptyCoroutineContext obj0;
        if (i3 &= 1 != 0) {
            obj0 = EmptyCoroutineContext.INSTANCE;
        }
        return BuildersKt.runBlocking(obj0, function22);
    }
}
