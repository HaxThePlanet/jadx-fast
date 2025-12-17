package kotlinx.coroutines;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0008\u0002\u001a=\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u001e\u0010\u0003\u001a\u0010\u0012\u000c\u0008\u0001\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u00050\u0004\"\u0008\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\u00082\u0012\u0010\t\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\n0\u0004\"\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a-\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u00050\u000cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u001b\u0010\u0007\u001a\u00020\u0008*\u0008\u0012\u0004\u0012\u00020\n0\u000cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000e", d2 = {"awaitAll", "", "T", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AwaitKt {
    public static final <T> Object awaitAll(Collection<? extends kotlinx.coroutines.Deferred<? extends T>> $this$awaitAll, Continuation<? super List<? extends T>> $completion) {
        if ($this$awaitAll.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        final int i = 0;
        AwaitAll awaitAll = new AwaitAll((Deferred[])$this$awaitAll.toArray(new Deferred[0]));
        return awaitAll.await($completion);
    }

    public static final <T> Object awaitAll(kotlinx.coroutines.Deferred<? extends T>[] deferreds, Continuation<? super List<? extends T>> $completion) {
        int i;
        i = deferreds.length == 0 ? 1 : 0;
        if (i != 0) {
            return CollectionsKt.emptyList();
        }
        AwaitAll awaitAll = new AwaitAll(deferreds);
        return awaitAll.await($completion);
    }

    public static final Object joinAll(Collection<? extends kotlinx.coroutines.Job> collection, Continuation<? super Unit> continuation2) {
        boolean anon;
        int i3;
        int i5;
        int i4;
        Object iterator;
        int i;
        int i2;
        int obj6;
        Object obj7;
        anon = continuation2;
        i5 = Integer.MIN_VALUE;
        if (continuation2 instanceof AwaitKt.joinAll.3 && label &= i5 != 0) {
            anon = continuation2;
            i5 = Integer.MIN_VALUE;
            if (label &= i5 != 0) {
                anon.label = obj7 -= i5;
            } else {
                anon = new AwaitKt.joinAll.3(continuation2);
            }
        } else {
        }
        obj7 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj7);
                iterator = (Iterable)collection.iterator();
                obj6 = i4;
                break;
            case 1:
                obj6 = 0;
                i4 = 0;
                iterator = anon.L$0;
                ResultKt.throwOnFailure(obj7);
                break;
            default:
                obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj6;
        }
        if (iterator.hasNext()) {
            anon.L$0 = iterator;
            anon.label = 1;
            if ((Job)iterator.next().join(anon) == cOROUTINE_SUSPENDED) {
                return cOROUTINE_SUSPENDED;
            } else {
            }
        }
        return Unit.INSTANCE;
    }

    public static final Object joinAll(kotlinx.coroutines.Job[] jobArr, Continuation<? super Unit> continuation2) {
        boolean anon;
        int i;
        int i3;
        int i2;
        int length;
        int i$0;
        Object l$0;
        int i4;
        int obj8;
        Object obj9;
        anon = continuation2;
        i3 = Integer.MIN_VALUE;
        if (continuation2 instanceof AwaitKt.joinAll.1 && label &= i3 != 0) {
            anon = continuation2;
            i3 = Integer.MIN_VALUE;
            if (label &= i3 != 0) {
                anon.label = obj9 -= i3;
            } else {
                anon = new AwaitKt.joinAll.1(continuation2);
            }
        } else {
        }
        obj9 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        final int i5 = 1;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj9);
                length = jobArr.length;
                i$0 = 0;
                l$0 = jobArr;
                obj8 = i2;
                break;
            case 1:
                obj8 = 0;
                i2 = 0;
                length = anon.I$1;
                i$0 = anon.I$0;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj9);
                i$0 += i5;
                break;
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        if (i$0 < length) {
            anon.L$0 = l$0;
            anon.I$0 = i$0;
            anon.I$1 = length;
            anon.label = i5;
            if (l$0[i$0].join(anon) == cOROUTINE_SUSPENDED) {
                return cOROUTINE_SUSPENDED;
            } else {
            }
        }
        return Unit.INSTANCE;
    }
}
