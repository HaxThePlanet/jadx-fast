package kotlinx.coroutines.internal;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001aI\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\u0008\u0000\u0010\u0004*\u0018\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001j\u0008\u0012\u0004\u0012\u0002H\u0004`\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0006\u0010\u0007\u001a\u00020\u0008H\u0000¢\u0006\u0002\u0010\t\u001a=\u0010\n\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0018\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001j\u0008\u0012\u0004\u0012\u0002H\u0004`\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0006\u0010\u0007\u001a\u00020\u0008H\u0000¢\u0006\u0002\u0010\u000b\u001aC\u0010\u000c\u001a\u0004\u0018\u00010\r\"\u0004\u0008\u0000\u0010\u0004*\u0018\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001j\u0008\u0012\u0004\u0012\u0002H\u0004`\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0002\u0010\u000f**\u0008\u0000\u0010\u0010\u001a\u0004\u0008\u0000\u0010\u0004\"\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u00012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0011", d2 = {"bindCancellationFun", "Lkotlin/Function1;", "", "", "E", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "element", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)Lkotlin/jvm/functions/Function1;", "callUndeliveredElement", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", "callUndeliveredElementCatchingException", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "undeliveredElementException", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlinx/coroutines/internal/UndeliveredElementException;)Lkotlinx/coroutines/internal/UndeliveredElementException;", "OnUndeliveredElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OnUndeliveredElementKt {
    public static final <E> Function1<Throwable, Unit> bindCancellationFun(Function1<? super E, Unit> $this$bindCancellationFun, E element, CoroutineContext context) {
        OnUndeliveredElementKt.bindCancellationFun.1 anon = new OnUndeliveredElementKt.bindCancellationFun.1($this$bindCancellationFun, element, context);
        return (Function1)anon;
    }

    public static final <E> void callUndeliveredElement(Function1<? super E, Unit> $this$callUndeliveredElement, E element, CoroutineContext context) {
        int i;
        kotlinx.coroutines.internal.UndeliveredElementException exc;
        kotlinx.coroutines.internal.UndeliveredElementException callUndeliveredElementCatchingException = OnUndeliveredElementKt.callUndeliveredElementCatchingException($this$callUndeliveredElement, element, 0);
        if (callUndeliveredElementCatchingException != null) {
            i = 0;
            CoroutineExceptionHandlerKt.handleCoroutineException(context, (Throwable)callUndeliveredElementCatchingException);
        }
    }

    public static final <E> kotlinx.coroutines.internal.UndeliveredElementException callUndeliveredElementCatchingException(Function1<? super E, Unit> $this$callUndeliveredElementCatchingException, E element, kotlinx.coroutines.internal.UndeliveredElementException undeliveredElementException) {
        Throwable undeliveredElementException2;
        int string;
        $this$callUndeliveredElementCatchingException.invoke(element);
        return undeliveredElementException;
    }

    public static kotlinx.coroutines.internal.UndeliveredElementException callUndeliveredElementCatchingException$default(Function1 function1, Object object2, kotlinx.coroutines.internal.UndeliveredElementException undeliveredElementException3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, object2, obj2);
    }
}
