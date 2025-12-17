package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0013\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\nJ\u0008\u0010\u000b\u001a\u00020\u000cH\u0016R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Landroidx/core/util/AndroidXContinuationConsumer;", "T", "Landroidx/core/util/Consumer;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "continuation", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/Continuation;)V", "accept", "", "value", "(Ljava/lang/Object;)V", "toString", "", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AndroidXContinuationConsumer<T>  extends AtomicBoolean implements androidx.core.util.Consumer<T> {

    private final Continuation<T> continuation;
    public AndroidXContinuationConsumer(Continuation<? super T> continuation) {
        super(0);
        this.continuation = continuation;
    }

    public void accept(T value) {
        boolean compareAndSet;
        int constructor-impl;
        if (compareAndSet(false, true)) {
            kotlin.Result.Companion companion = Result.Companion;
            this.continuation.resumeWith(Result.constructor-impl(value));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ContinuationConsumer(resultAccepted = ").append(get()).append(')').toString();
    }
}
