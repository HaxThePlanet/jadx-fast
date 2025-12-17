package androidx.collection;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0011\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0016\u001a\u00020\u0012J\u0008\u0010\u0017\u001a\u00020\u0012H\u0002J\u0016\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u000b\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010\u000cJ\u000b\u0010\u001e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000cJ\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\u0004R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0008X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\n\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u000cR\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Landroidx/collection/CircularArray;", "E", "", "minCapacity", "", "(I)V", "capacityBitmask", "elements", "", "[Ljava/lang/Object;", "first", "getFirst", "()Ljava/lang/Object;", "head", "last", "getLast", "tail", "addFirst", "", "element", "(Ljava/lang/Object;)V", "addLast", "clear", "doubleCapacity", "get", "index", "(I)Ljava/lang/Object;", "isEmpty", "", "popFirst", "popLast", "removeFromEnd", "count", "removeFromStart", "size", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CircularArray<E>  {

    private int capacityBitmask;
    private E[] elements;
    private int head;
    private int tail;
    public CircularArray() {
        super(0, 1, 0);
    }

    public CircularArray(int minCapacity) {
        int i;
        int i3;
        int i2;
        super();
        int i7 = 1;
        i2 = minCapacity >= i7 ? i7 : i;
        if (i2 == 0) {
        } else {
            i = minCapacity <= 1073741824 ? i7 : i;
            if (i == 0) {
            } else {
                if (Integer.bitCount(minCapacity) != i7) {
                    highestOneBit <<= i7;
                } else {
                    i3 = minCapacity;
                }
                this.capacityBitmask = i3 + -1;
                this.elements = new Object[i3];
            }
            int i5 = 0;
            IllegalArgumentException $i$a$RequireCircularArray$2 = new IllegalArgumentException("capacity must be <= 2^30".toString());
            throw $i$a$RequireCircularArray$2;
        }
        int i4 = 0;
        IllegalArgumentException $i$a$RequireCircularArray$1 = new IllegalArgumentException("capacity must be >= 1".toString());
        throw $i$a$RequireCircularArray$1;
    }

    public CircularArray(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 8 : obj1;
        super(obj1);
    }

    private final void doubleCapacity() {
        int length = elements.length;
        final int i2 = length << 1;
        if (i2 < 0) {
        } else {
            Object[] arr = new Object[i2];
            final int i4 = 0;
            ArraysKt.copyInto(this.elements, arr, i4, this.head, length);
            ArraysKt.copyInto(this.elements, arr, length - head, i4, this.head);
            this.elements = arr;
            this.head = i4;
            this.tail = length;
            this.capacityBitmask = i2 + -1;
        }
        RuntimeException a = new RuntimeException("Max array capacity exceeded");
        throw a;
    }

    public final void addFirst(E element) {
        this.head = i &= capacityBitmask;
        this.elements[this.head] = element;
        if (this.head == this.tail) {
            doubleCapacity();
        }
    }

    public final void addLast(E element) {
        this.elements[this.tail] = element;
        this.tail = i &= capacityBitmask;
        if (this.tail == this.head) {
            doubleCapacity();
        }
    }

    public final void clear() {
        removeFromStart(size());
    }

    public final E get(int index) {
        int size;
        if (index < 0) {
        } else {
            if (index >= size()) {
            } else {
                Object obj = this.elements[i2 &= capacityBitmask];
                Intrinsics.checkNotNull(obj);
                return obj;
            }
        }
        androidx.collection.CollectionPlatformUtils iNSTANCE = CollectionPlatformUtils.INSTANCE;
        int i = 0;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw (IndexOutOfBoundsException)arrayIndexOutOfBoundsException;
    }

    public final E getFirst() {
        if (this.head == this.tail) {
        } else {
            Object obj = this.elements[this.head];
            Intrinsics.checkNotNull(obj);
            return obj;
        }
        androidx.collection.CollectionPlatformUtils iNSTANCE = CollectionPlatformUtils.INSTANCE;
        int i = 0;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw (IndexOutOfBoundsException)arrayIndexOutOfBoundsException;
    }

    public final E getLast() {
        if (this.head == this.tail) {
        } else {
            Object obj = this.elements[i &= capacityBitmask];
            Intrinsics.checkNotNull(obj);
            return obj;
        }
        androidx.collection.CollectionPlatformUtils iNSTANCE = CollectionPlatformUtils.INSTANCE;
        int i3 = 0;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw (IndexOutOfBoundsException)arrayIndexOutOfBoundsException;
    }

    public final boolean isEmpty() {
        int i;
        i = this.head == this.tail ? 1 : 0;
        return i;
    }

    public final E popFirst() {
        if (this.head == this.tail) {
        } else {
            this.elements[this.head] = 0;
            this.head = i &= capacityBitmask;
            return this.elements[this.head];
        }
        androidx.collection.CollectionPlatformUtils result = CollectionPlatformUtils.INSTANCE;
        int i3 = 0;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw (IndexOutOfBoundsException)arrayIndexOutOfBoundsException;
    }

    public final E popLast() {
        if (this.head == this.tail) {
        } else {
            i &= capacityBitmask;
            this.elements[i2] = 0;
            this.tail = i2;
            return this.elements[i2];
        }
        androidx.collection.CollectionPlatformUtils t = CollectionPlatformUtils.INSTANCE;
        int i3 = 0;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw (IndexOutOfBoundsException)arrayIndexOutOfBoundsException;
    }

    public final void removeFromEnd(int count) {
        int start;
        int tail2;
        int i;
        int i2;
        int i3;
        Object[] i4;
        int tail;
        Object[] elements;
        if (count <= 0) {
        }
        if (count > size()) {
        } else {
            int i5 = count;
            start = 0;
            if (i5 < this.tail) {
                start = tail2 - i5;
            }
            i = start;
            i3 = 0;
            while (i < this.tail) {
                this.elements[i] = i3;
                i++;
                i3 = 0;
            }
            i7 -= start;
            i5 -= i8;
            this.tail = tail4 -= i8;
            if (numOfElements > 0) {
                this.tail = elements2.length;
                tail5 -= numOfElements;
                i4 = i2;
                while (i4 < this.tail) {
                    this.elements[i4] = i3;
                    i4++;
                }
                this.tail = i2;
            }
        }
        androidx.collection.CollectionPlatformUtils numOfElements2 = CollectionPlatformUtils.INSTANCE;
        int i6 = 0;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw (IndexOutOfBoundsException)arrayIndexOutOfBoundsException;
    }

    public final void removeFromStart(int count) {
        int end;
        int head;
        int i;
        int i2;
        Object[] elements;
        int i3;
        int capacityBitmask;
        if (count <= 0) {
        }
        if (count > size()) {
        } else {
            int i4 = count;
            if (i4 < end - head2) {
                end = head + i4;
            }
            i = this.head;
            i2 = 0;
            while (i < end) {
                this.elements[i] = i2;
                i++;
                i2 = 0;
            }
            int i7 = end - i6;
            i4 -= i7;
            this.head = i8 &= capacityBitmask;
            if (numOfElements > 0) {
                i3 = 0;
                while (i3 < numOfElements) {
                    this.elements[i3] = i2;
                    i3++;
                }
                this.head = numOfElements;
            }
        }
        androidx.collection.CollectionPlatformUtils numOfElements2 = CollectionPlatformUtils.INSTANCE;
        int i5 = 0;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw (IndexOutOfBoundsException)arrayIndexOutOfBoundsException;
    }

    public final int size() {
        return i &= capacityBitmask;
    }
}
