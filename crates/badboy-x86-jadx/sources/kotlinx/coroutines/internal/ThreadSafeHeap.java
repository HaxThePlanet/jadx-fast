package kotlinx.coroutines.internal;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0014\u0008\u0017\u0018\u0000*\u0012\u0008\u0000\u0010\u0001*\u00020\u0002*\u0008\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J,\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u00002\u0014\u0010\u001c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\r0\u001dH\u0086\u0008¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0017J0\u0010 \u001a\u0004\u0018\u00018\u00002!\u0010!\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\r0\u001d¢\u0006\u0002\u0010$J\u000f\u0010%\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0002\u0010&J\r\u0010'\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010&J\u0015\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\nH\u0002¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010+J\u0015\u0010,\u001a\u00028\u00002\u0006\u0010-\u001a\u00020\u0010H\u0001¢\u0006\u0002\u0010.J$\u0010/\u001a\u0004\u0018\u00018\u00002\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u001dH\u0086\u0008¢\u0006\u0002\u0010$J\r\u00100\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010&J\u0011\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0010H\u0082\u0010J\u0011\u00103\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0010H\u0082\u0010J\u0018\u00104\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u0010H\u0002R\t\u0010\u0007\u001a\u00020\u0008X\u0082\u0004R\u001a\u0010\t\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u000eR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@BX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015¨\u00066", d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "T", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "()V", "_size", "Lkotlinx/atomicfu/AtomicInt;", "a", "", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "", "()Z", "value", "", "size", "getSize", "()I", "setSize", "(I)V", "addImpl", "", "node", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "addLastIf", "cond", "Lkotlin/Function1;", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "clear", "find", "predicate", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "removeAtImpl", "index", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstIf", "removeFirstOrNull", "siftDownFrom", "i", "siftUpFrom", "swap", "j", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ThreadSafeHeap<T extends kotlinx.coroutines.internal.ThreadSafeHeapNode & Comparable<? super T>>  {

    private static final AtomicIntegerFieldUpdater _size$FU;
    @Volatile
    private volatile int _size;
    private T[] a;
    static {
        ThreadSafeHeap._size$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size");
    }

    private final T[] realloc() {
        kotlinx.coroutines.internal.ThreadSafeHeapNode[] copyOf;
        kotlinx.coroutines.internal.ThreadSafeHeapNode[] length;
        int i;
        final kotlinx.coroutines.internal.ThreadSafeHeapNode[] objArr = this.a;
        if (objArr == null) {
            i = 0;
            this.a = new ThreadSafeHeapNode[4];
        } else {
            if (getSize() >= objArr.length) {
                copyOf = Arrays.copyOf(objArr, size2 *= 2);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                i = 0;
                this.a = (ThreadSafeHeapNode[])copyOf;
            } else {
                copyOf = objArr;
            }
        }
        return copyOf;
    }

    private final void setSize(int value) {
        ThreadSafeHeap._size$FU.set(this, value);
    }

    private final void siftDownFrom(int i) {
        int j;
        kotlinx.coroutines.internal.ThreadSafeHeapNode[] objArr;
        int compareTo;
        int compareTo2;
        kotlinx.coroutines.internal.ThreadSafeHeapNode threadSafeHeapNode;
        int size;
        int obj5;
        i2++;
        while (j >= getSize()) {
            objArr = this.a;
            Intrinsics.checkNotNull(objArr);
            kotlinx.coroutines.internal.ThreadSafeHeapNode threadSafeHeapNode3 = objArr[j + 1];
            Intrinsics.checkNotNull(threadSafeHeapNode3);
            size = objArr[j];
            Intrinsics.checkNotNull(size);
            if (j + 1 < getSize() && (Comparable)threadSafeHeapNode3.compareTo(size) < 0) {
            }
            kotlinx.coroutines.internal.ThreadSafeHeapNode threadSafeHeapNode2 = objArr[obj5];
            Intrinsics.checkNotNull(threadSafeHeapNode2);
            threadSafeHeapNode = objArr[j];
            Intrinsics.checkNotNull(threadSafeHeapNode);
            swap(obj5, j);
            obj5 = j;
            i2++;
            threadSafeHeapNode3 = objArr[j + 1];
            Intrinsics.checkNotNull(threadSafeHeapNode3);
            size = objArr[j];
            Intrinsics.checkNotNull(size);
            if ((Comparable)threadSafeHeapNode3.compareTo(size) < 0) {
            }
            j++;
        }
    }

    private final void siftUpFrom(int i) {
        kotlinx.coroutines.internal.ThreadSafeHeapNode[] objArr;
        int i2;
        int compareTo;
        kotlinx.coroutines.internal.ThreadSafeHeapNode threadSafeHeapNode;
        int obj5;
        while (obj5 <= 0) {
            objArr = this.a;
            Intrinsics.checkNotNull(objArr);
            i3 /= 2;
            kotlinx.coroutines.internal.ThreadSafeHeapNode threadSafeHeapNode2 = objArr[i2];
            Intrinsics.checkNotNull(threadSafeHeapNode2);
            threadSafeHeapNode = objArr[obj5];
            Intrinsics.checkNotNull(threadSafeHeapNode);
            swap(obj5, i2);
            obj5 = i2;
        }
    }

    private final void swap(int i, int j) {
        final kotlinx.coroutines.internal.ThreadSafeHeapNode[] objArr = this.a;
        Intrinsics.checkNotNull(objArr);
        final kotlinx.coroutines.internal.ThreadSafeHeapNode threadSafeHeapNode = objArr[j];
        Intrinsics.checkNotNull(threadSafeHeapNode);
        final kotlinx.coroutines.internal.ThreadSafeHeapNode threadSafeHeapNode2 = objArr[i];
        Intrinsics.checkNotNull(threadSafeHeapNode2);
        objArr[i] = threadSafeHeapNode;
        objArr[j] = threadSafeHeapNode2;
        threadSafeHeapNode.setIndex(i);
        threadSafeHeapNode2.setIndex(j);
    }

    public final void addImpl(T node) {
        boolean aSSERTIONS_ENABLED;
        int i;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            i = node.getHeap() == null ? 1 : 0;
            if (i == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        node.setHeap(this);
        int size = getSize();
        setSize(size + 1);
        realloc()[size] = node;
        node.setIndex(size);
        siftUpFrom(size);
    }

    public final void addLast(T node) {
        final int i = 0;
        final int i2 = 0;
        int i3 = 0;
        addImpl(node);
        Unit $i$a$SynchronizedThreadSafeHeap$addLast$1 = Unit.INSTANCE;
        return;
        synchronized (this) {
            i = 0;
            i2 = 0;
            i3 = 0;
            addImpl(node);
            $i$a$SynchronizedThreadSafeHeap$addLast$1 = Unit.INSTANCE;
        }
    }

    public final boolean addLastIf(T node, Function1<? super T, Boolean> cond) {
        int i;
        final int i2 = 0;
        final int i3 = 0;
        final int i4 = 0;
        final int i5 = 0;
        synchronized (this) {
            addImpl(node);
            i = 1;
            return i;
        }
    }

    public final void clear() {
        int i;
        int i3;
        int i5;
        int i4;
        int i2;
        final int i7 = 0;
        final int i8 = 0;
        int i6 = 0;
        kotlinx.coroutines.internal.ThreadSafeHeapNode[] objArr = this.a;
        synchronized (this) {
            ArraysKt.fill$default(objArr, 0, 0, 0, 6, 0);
            ThreadSafeHeap._size$FU.set(this, 0);
            Unit $i$a$SynchronizedThreadSafeHeap$clear$1 = Unit.INSTANCE;
        }
    }

    public final T find(Function1<? super T, Boolean> predicate) {
        int i;
        int i2;
        boolean booleanValue;
        final int i3 = 0;
        final int i4 = 0;
        final int i5 = 0;
        i = 0;
        synchronized (this) {
            i2 = 0;
            while (i < getSize()) {
                kotlinx.coroutines.internal.ThreadSafeHeapNode[] objArr = this.a;
                if (objArr != null) {
                }
                Intrinsics.checkNotNull(i2);
                i++;
                i2 = 0;
                i2 = objArr[i];
            }
            return i2;
        }
    }

    public final T firstImpl() {
        kotlinx.coroutines.internal.ThreadSafeHeapNode threadSafeHeapNode;
        int i;
        kotlinx.coroutines.internal.ThreadSafeHeapNode[] objArr = this.a;
        threadSafeHeapNode = objArr != null ? objArr[i] : 0;
        return threadSafeHeapNode;
    }

    public final int getSize() {
        return ThreadSafeHeap._size$FU.get(this);
    }

    public final boolean isEmpty() {
        int i;
        i = getSize() == 0 ? 1 : 0;
        return i;
    }

    public final T peek() {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return firstImpl();
        synchronized (this) {
            i = 0;
            i2 = 0;
            i3 = 0;
            return firstImpl();
        }
    }

    public final boolean remove(T node) {
        int index;
        int i;
        boolean aSSERTIONS_ENABLED;
        int i2;
        final int i3 = 0;
        final int i4 = 0;
        final int i5 = 0;
        i = 0;
        synchronized (this) {
            return i;
        }
    }

    public final T removeAtImpl(int index) {
        int $i$a$AssertThreadSafeHeap$removeAtImpl$1;
        int i;
        int size;
        int size2;
        int compareTo;
        boolean aSSERTIONS_ENABLED;
        kotlinx.coroutines.internal.ThreadSafeHeapNode heap;
        int i4 = 1;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i2 = 0;
            $i$a$AssertThreadSafeHeap$removeAtImpl$1 = getSize() > 0 ? i4 : i;
            if ($i$a$AssertThreadSafeHeap$removeAtImpl$1 == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        kotlinx.coroutines.internal.ThreadSafeHeapNode[] objArr = this.a;
        Intrinsics.checkNotNull(objArr);
        final int i7 = -1;
        setSize(size4 += i7);
        if (index < getSize()) {
            swap(index, getSize());
            i6 /= 2;
            kotlinx.coroutines.internal.ThreadSafeHeapNode threadSafeHeapNode2 = objArr[index];
            Intrinsics.checkNotNull(threadSafeHeapNode2);
            heap = objArr[size2];
            Intrinsics.checkNotNull(heap);
            if (index > 0 && (Comparable)threadSafeHeapNode2.compareTo(heap) < 0) {
                threadSafeHeapNode2 = objArr[index];
                Intrinsics.checkNotNull(threadSafeHeapNode2);
                heap = objArr[size2];
                Intrinsics.checkNotNull(heap);
                if ((Comparable)threadSafeHeapNode2.compareTo(heap) < 0) {
                    swap(index, size2);
                    siftUpFrom(size2);
                } else {
                    siftDownFrom(index);
                }
            } else {
            }
        }
        kotlinx.coroutines.internal.ThreadSafeHeapNode threadSafeHeapNode = objArr[getSize()];
        Intrinsics.checkNotNull(threadSafeHeapNode);
        aSSERTIONS_ENABLED = 0;
        if (DebugKt.getASSERTIONS_ENABLED() && threadSafeHeapNode.getHeap() == this) {
            aSSERTIONS_ENABLED = 0;
            if (threadSafeHeapNode.getHeap() == this) {
                i = i4;
            }
            if (i == 0) {
            } else {
            }
            AssertionError assertionError2 = new AssertionError();
            throw assertionError2;
        }
        int i3 = 0;
        threadSafeHeapNode.setHeap(i3);
        threadSafeHeapNode.setIndex(i7);
        objArr[getSize()] = i3;
        return threadSafeHeapNode;
    }

    public final T removeFirstIf(Function1<? super T, Boolean> predicate) {
        kotlinx.coroutines.internal.ThreadSafeHeapNode atImpl;
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        final int i4 = 0;
        final kotlinx.coroutines.internal.ThreadSafeHeapNode firstImpl = firstImpl();
        synchronized (this) {
            return 0;
        }
    }

    public final T removeFirstOrNull() {
        kotlinx.coroutines.internal.ThreadSafeHeapNode atImpl;
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        synchronized (this) {
            atImpl = removeAtImpl(0);
            return atImpl;
        }
    }
}
