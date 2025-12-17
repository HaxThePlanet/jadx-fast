package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u001f\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0004\u001a\u001e\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a,\u0010\u0007\u001a\u00020\u0008\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\nø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000c", d2 = {"CompletableDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "T", "value", "(Ljava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;", "parent", "Lkotlinx/coroutines/Job;", "completeWith", "", "result", "Lkotlin/Result;", "(Lkotlinx/coroutines/CompletableDeferred;Ljava/lang/Object;)Z", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CompletableDeferredKt {
    public static final <T> kotlinx.coroutines.CompletableDeferred<T> CompletableDeferred(T value) {
        CompletableDeferredImpl completableDeferredImpl = new CompletableDeferredImpl(0);
        final int i2 = 0;
        completableDeferredImpl.complete(value);
        return (CompletableDeferred)completableDeferredImpl;
    }

    public static final <T> kotlinx.coroutines.CompletableDeferred<T> CompletableDeferred(kotlinx.coroutines.Job parent) {
        CompletableDeferredImpl completableDeferredImpl = new CompletableDeferredImpl(parent);
        return (CompletableDeferred)completableDeferredImpl;
    }

    public static kotlinx.coroutines.CompletableDeferred CompletableDeferred$default(kotlinx.coroutines.Job job, int i2, Object object3) {
        int obj0;
        if (i2 &= 1 != 0) {
            obj0 = 0;
        }
        return CompletableDeferredKt.CompletableDeferred(obj0);
    }

    public static final <T> boolean completeWith(kotlinx.coroutines.CompletableDeferred<T> $this$completeWith, Object result) {
        boolean it;
        int i;
        Throwable exceptionOrNull-impl = Result.exceptionOrNull-impl(result);
        if (exceptionOrNull-impl == null) {
            i = 0;
            it = $this$completeWith.complete(result);
        } else {
            i = 0;
            it = $this$completeWith.completeExceptionally(exceptionOrNull-impl);
        }
        return it;
    }
}
