package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0008\u001a\u00020\u0004J\u0018\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0002\u0010\u000bJ\u001d\u0010\u000c\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00042\u0008\u0010\u000e\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lkotlinx/coroutines/internal/ResizableAtomicArray;", "T", "", "initialLength", "", "(I)V", "array", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "currentLength", "get", "index", "(I)Ljava/lang/Object;", "setSynchronized", "", "value", "(ILjava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResizableAtomicArray<T>  {

    private volatile AtomicReferenceArray<T> array;
    public ResizableAtomicArray(int initialLength) {
        super();
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(initialLength);
        this.array = atomicReferenceArray;
    }

    public final int currentLength() {
        return this.array.length();
    }

    public final T get(int index) {
        Object obj;
        final AtomicReferenceArray array = this.array;
        if (index < array.length()) {
            obj = array.get(index);
        } else {
            obj = 0;
        }
        return obj;
    }

    public final void setSynchronized(int index, T value) {
        int i2;
        int i;
        final AtomicReferenceArray array = this.array;
        final int length = array.length();
        if (index < length) {
            array.set(index, value);
        }
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(RangesKt.coerceAtLeast(index + 1, length * 2));
        i2 = 0;
        while (i2 < length) {
            atomicReferenceArray.set(i2, array.get(i2));
            i2++;
        }
        atomicReferenceArray.set(index, value);
        this.array = atomicReferenceArray;
    }
}
