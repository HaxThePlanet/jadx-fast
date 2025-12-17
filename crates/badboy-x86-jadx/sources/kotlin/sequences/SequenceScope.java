package kotlin.sequences;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u001c\n\u0002\u0008\u0002\n\u0002\u0010(\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008'\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\u00020\u0002B\u0007\u0008\u0000¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H¦@¢\u0006\u0002\u0010\u0007J\u001c\u0010\u0008\u001a\u00020\u00052\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00028\u00000\nH\u0086@¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0008\u001a\u00020\u00052\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\rH¦@¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u0008\u001a\u00020\u00052\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0010H\u0086@¢\u0006\u0002\u0010\u0011¨\u0006\u0012", d2 = {"Lkotlin/sequences/SequenceScope;", "T", "", "()V", "yield", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yieldAll", "elements", "", "(Ljava/lang/Iterable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "iterator", "", "(Ljava/util/Iterator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class SequenceScope<T>  {
    public abstract Object yield(T t, Continuation<? super Unit> continuation2);

    public final Object yieldAll(Iterable<? extends T> elements, Continuation<? super Unit> $completion) {
        boolean empty;
        if (elements instanceof Collection != null && (Collection)elements.isEmpty()) {
            if ((Collection)elements.isEmpty()) {
                return Unit.INSTANCE;
            }
        }
        Object yieldAll = yieldAll(elements.iterator(), $completion);
        if (yieldAll == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return yieldAll;
        }
        return Unit.INSTANCE;
    }

    public abstract Object yieldAll(Iterator<? extends T> iterator, Continuation<? super Unit> continuation2);

    public final Object yieldAll(kotlin.sequences.Sequence<? extends T> sequence, Continuation<? super Unit> $completion) {
        Object yieldAll = yieldAll(sequence.iterator(), $completion);
        if (yieldAll == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return yieldAll;
        }
        return Unit.INSTANCE;
    }
}
