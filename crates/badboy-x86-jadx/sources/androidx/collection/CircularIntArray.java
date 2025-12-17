package androidx.collection;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0015\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0011\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0010J\u0008\u0010\u0014\u001a\u00020\u0010H\u0002J\u0011\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0086\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0003J\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u0003R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0008\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Landroidx/collection/CircularIntArray;", "", "minCapacity", "", "(I)V", "capacityBitmask", "elements", "", "first", "getFirst", "()I", "head", "last", "getLast", "tail", "addFirst", "", "element", "addLast", "clear", "doubleCapacity", "get", "index", "isEmpty", "", "popFirst", "popLast", "removeFromEnd", "count", "removeFromStart", "size", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CircularIntArray {

    private int capacityBitmask;
    private int[] elements;
    private int head;
    private int tail;
    public CircularIntArray() {
        super(0, 1, 0);
    }

    public CircularIntArray(int minCapacity) {
        int i2;
        int i3;
        int i;
        super();
        int i7 = 1;
        i = minCapacity >= i7 ? i7 : i2;
        if (i == 0) {
        } else {
            i2 = minCapacity <= 1073741824 ? i7 : i2;
            if (i2 == 0) {
            } else {
                if (Integer.bitCount(minCapacity) != i7) {
                    highestOneBit <<= i7;
                } else {
                    i3 = minCapacity;
                }
                this.capacityBitmask = i3 + -1;
                this.elements = new int[i3];
            }
            int i5 = 0;
            IllegalArgumentException $i$a$RequireCircularIntArray$2 = new IllegalArgumentException("capacity must be <= 2^30".toString());
            throw $i$a$RequireCircularIntArray$2;
        }
        int i4 = 0;
        IllegalArgumentException $i$a$RequireCircularIntArray$1 = new IllegalArgumentException("capacity must be >= 1".toString());
        throw $i$a$RequireCircularIntArray$1;
    }

    public CircularIntArray(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 8 : obj1;
        super(obj1);
    }

    private final void doubleCapacity() {
        int length = elements.length;
        final int i2 = length << 1;
        if (i2 < 0) {
        } else {
            int[] iArr = new int[i2];
            final int i4 = 0;
            ArraysKt.copyInto(this.elements, iArr, i4, this.head, length);
            ArraysKt.copyInto(this.elements, iArr, length - head, i4, this.head);
            this.elements = iArr;
            this.head = i4;
            this.tail = length;
            this.capacityBitmask = i2 + -1;
        }
        RuntimeException a = new RuntimeException("Max array capacity exceeded");
        throw a;
    }

    public final void addFirst(int element) {
        this.head = i &= capacityBitmask;
        this.elements[this.head] = element;
        if (this.head == this.tail) {
            doubleCapacity();
        }
    }

    public final void addLast(int element) {
        this.elements[this.tail] = element;
        this.tail = i &= capacityBitmask;
        if (this.tail == this.head) {
            doubleCapacity();
        }
    }

    public final void clear() {
        this.tail = this.head;
    }

    public final int get(int index) {
        int size;
        if (index < 0) {
        } else {
            if (index >= size()) {
            } else {
                return this.elements[i3 &= capacityBitmask];
            }
        }
        androidx.collection.CollectionPlatformUtils iNSTANCE = CollectionPlatformUtils.INSTANCE;
        int i2 = 0;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw (IndexOutOfBoundsException)arrayIndexOutOfBoundsException;
    }

    public final int getFirst() {
        if (this.head == this.tail) {
        } else {
            return this.elements[this.head];
        }
        androidx.collection.CollectionPlatformUtils iNSTANCE = CollectionPlatformUtils.INSTANCE;
        int i2 = 0;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw (IndexOutOfBoundsException)arrayIndexOutOfBoundsException;
    }

    public final int getLast() {
        if (this.head == this.tail) {
        } else {
            return this.elements[i2 &= capacityBitmask];
        }
        androidx.collection.CollectionPlatformUtils iNSTANCE = CollectionPlatformUtils.INSTANCE;
        int i4 = 0;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw (IndexOutOfBoundsException)arrayIndexOutOfBoundsException;
    }

    public final boolean isEmpty() {
        int i;
        i = this.head == this.tail ? 1 : 0;
        return i;
    }

    public final int popFirst() {
        if (this.head == this.tail) {
        } else {
            this.head = i2 &= capacityBitmask;
            return this.elements[this.head];
        }
        androidx.collection.CollectionPlatformUtils result = CollectionPlatformUtils.INSTANCE;
        int i4 = 0;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw (IndexOutOfBoundsException)arrayIndexOutOfBoundsException;
    }

    public final int popLast() {
        if (this.head == this.tail) {
        } else {
            i &= capacityBitmask;
            this.tail = i2;
            return this.elements[i2];
        }
        androidx.collection.CollectionPlatformUtils t = CollectionPlatformUtils.INSTANCE;
        int i4 = 0;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw (IndexOutOfBoundsException)arrayIndexOutOfBoundsException;
    }

    public final void removeFromEnd(int count) {
        if (count <= 0) {
        }
        if (count > size()) {
        } else {
            this.tail = i &= capacityBitmask;
        }
        androidx.collection.CollectionPlatformUtils iNSTANCE = CollectionPlatformUtils.INSTANCE;
        int i3 = 0;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw (IndexOutOfBoundsException)arrayIndexOutOfBoundsException;
    }

    public final void removeFromStart(int count) {
        if (count <= 0) {
        }
        if (count > size()) {
        } else {
            this.head = i &= capacityBitmask;
        }
        androidx.collection.CollectionPlatformUtils iNSTANCE = CollectionPlatformUtils.INSTANCE;
        int i3 = 0;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw (IndexOutOfBoundsException)arrayIndexOutOfBoundsException;
    }

    public final int size() {
        return i &= capacityBitmask;
    }
}
