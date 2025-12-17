package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\u0008\u0008\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u000f\u0008\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001d\u0012\u000e\u0010\u0008\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\u000cJ\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0018\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000f\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001fH\u0096\u0002J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0006J\u0015\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0014¢\u0006\u0002\u0010#J'\u0010\"\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\t\"\u0004\u0008\u0001\u0010\u00012\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\tH\u0014¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u0006*\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0082\u0008R\u0018\u0010\u0008\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'", d2 = {"Lkotlin/collections/RingBuffer;", "T", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "capacity", "", "(I)V", "buffer", "", "", "filledSize", "([Ljava/lang/Object;I)V", "[Ljava/lang/Object;", "<set-?>", "size", "getSize", "()I", "startIndex", "add", "", "element", "(Ljava/lang/Object;)V", "expanded", "maxCapacity", "get", "index", "(I)Ljava/lang/Object;", "isFull", "", "iterator", "", "removeFirst", "n", "toArray", "()[Ljava/lang/Object;", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "forward", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class RingBuffer<T>  extends kotlin.collections.AbstractList<T> implements RandomAccess {

    private final Object[] buffer;
    private final int capacity;
    private int size;
    private int startIndex;
    public RingBuffer(int capacity) {
        super(new Object[capacity], 0);
    }

    public RingBuffer(Object[] buffer, int filledSize) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        super();
        this.buffer = buffer;
        int i5 = 0;
        i2 = filledSize >= 0 ? i : i5;
        if (i2 == 0) {
        } else {
            if (filledSize <= buffer3.length) {
            } else {
                i = i5;
            }
            if (i == 0) {
            } else {
                this.capacity = buffer2.length;
                this.size = filledSize;
            }
            int i4 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("ring buffer filled size: ").append(filledSize).append(" cannot be larger than the buffer size: ").append(buffer4.length).toString().toString());
            throw illegalArgumentException2;
        }
        int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("ring buffer filled size should not be negative but it is ").append(filledSize).toString().toString());
        throw illegalArgumentException;
    }

    public static final Object[] access$getBuffer$p(kotlin.collections.RingBuffer $this) {
        return $this.buffer;
    }

    public static final int access$getCapacity$p(kotlin.collections.RingBuffer $this) {
        return $this.capacity;
    }

    public static final int access$getStartIndex$p(kotlin.collections.RingBuffer $this) {
        return $this.startIndex;
    }

    private final int forward(int $this$forward, int n) {
        final int i = 0;
        return i2 %= i4;
    }

    public final void add(T element) {
        if (isFull()) {
        } else {
            final int i2 = 0;
            this.buffer[i3 %= i5] = element;
            this.size = size++;
        }
        IllegalStateException illegalStateException = new IllegalStateException("ring buffer is full");
        throw illegalStateException;
    }

    public final kotlin.collections.RingBuffer<T> expanded(int maxCapacity) {
        Object[] copyOf;
        String str;
        int coerceAtMost = RangesKt.coerceAtMost(i++, maxCapacity);
        if (this.startIndex == 0) {
            Intrinsics.checkNotNullExpressionValue(Arrays.copyOf(this.buffer, coerceAtMost), "copyOf(...)");
        } else {
            copyOf = toArray(new Object[coerceAtMost]);
        }
        RingBuffer ringBuffer = new RingBuffer(copyOf, size());
        return ringBuffer;
    }

    public T get(int index) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, size());
        final int i = 0;
        return this.buffer[i2 %= i4];
    }

    @Override // kotlin.collections.AbstractList
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.collections.AbstractList
    public final boolean isFull() {
        int i;
        i = size() == this.capacity ? 1 : 0;
        return i;
    }

    public Iterator<T> iterator() {
        RingBuffer.iterator.1 anon = new RingBuffer.iterator.1(this);
        return (Iterator)anon;
    }

    @Override // kotlin.collections.AbstractList
    public final void removeFirst(int n) {
        int startIndex;
        Object[] buffer2;
        int i;
        int size;
        Object buffer;
        int capacity;
        int i3;
        int i2;
        buffer2 = 0;
        i = n >= 0 ? startIndex : buffer2;
        if (i == 0) {
        } else {
            if (n <= size()) {
            } else {
                startIndex = buffer2;
            }
            if (startIndex == 0) {
            } else {
                if (n > 0) {
                    startIndex = this.startIndex;
                    capacity = 0;
                    i7 %= i2;
                    size = 0;
                    if (startIndex > i3) {
                        ArraysKt.fill(this.buffer, size, startIndex, this.capacity);
                        ArraysKt.fill(this.buffer, size, buffer2, i3);
                    } else {
                        ArraysKt.fill(this.buffer, size, startIndex, i3);
                    }
                    this.startIndex = i3;
                    this.size = size2 -= n;
                }
            }
            int i4 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("n shouldn't be greater than the buffer size: n = ").append(n).append(", size = ").append(size()).toString().toString());
            throw illegalArgumentException;
        }
        int i5 = 0;
        StringBuilder stringBuilder2 = new StringBuilder();
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("n shouldn't be negative but it is ").append(n).toString().toString());
        throw illegalArgumentException2;
    }

    @Override // kotlin.collections.AbstractList
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public <T> T[] toArray(T[] array) {
        Object copyOf;
        int size;
        int widx;
        int idx;
        int idx2;
        Object capacity;
        Intrinsics.checkNotNullParameter(array, "array");
        if (array.length < size()) {
            Intrinsics.checkNotNullExpressionValue(Arrays.copyOf(array, size()), "copyOf(...)");
        } else {
            copyOf = array;
        }
        int size3 = size();
        widx = 0;
        idx = this.startIndex;
        while (widx < size3) {
            if (idx < this.capacity) {
            }
            copyOf[widx] = this.buffer[idx];
            widx++;
            idx++;
        }
        idx2 = 0;
        while (widx < size3) {
            copyOf[widx] = this.buffer[idx2];
            widx++;
            idx2++;
        }
        return CollectionsKt.terminateCollectionToArray(size3, copyOf);
    }
}
