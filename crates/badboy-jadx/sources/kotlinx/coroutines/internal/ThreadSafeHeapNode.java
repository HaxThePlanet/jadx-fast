package kotlinx.coroutines.internal;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008g\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u0004\u0010\u0005\"\u0004\u0008\u0006\u0010\u0007R\u0018\u0010\u0008\u001a\u00020\tX¦\u000e¢\u0006\u000c\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\r¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "heap", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ThreadSafeHeapNode {
    public abstract kotlinx.coroutines.internal.ThreadSafeHeap<?> getHeap();

    public abstract int getIndex();

    public abstract void setHeap(kotlinx.coroutines.internal.ThreadSafeHeap<?> threadSafeHeap);

    public abstract void setIndex(int i);
}
