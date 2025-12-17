package androidx.collection;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0015\n\u0002\u0008\u0011\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003J\u0018\u0010\u0008\u001a\u00020\u000b2\u0008\u0008\u0001\u0010\u000c\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0001J\u0018\u0010\r\u001a\u00020\t2\u0008\u0008\u0001\u0010\u000c\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0001J\u0018\u0010\r\u001a\u00020\t2\u0008\u0008\u0001\u0010\u000c\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0003J\u0011\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0001H\u0086\u0002J\u0011\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003H\u0086\nJ\u0011\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\u0002J\u0011\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0001H\u0086\u0002J\u0011\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003H\u0086\nJ\u0011\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\u0002J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0001J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0016\u001a\u00020\u00032\u0008\u0008\u0001\u0010\u000c\u001a\u00020\u0003J\u001a\u0010\u0017\u001a\u00020\u000b2\u0008\u0008\u0001\u0010\u0018\u001a\u00020\u00032\u0008\u0008\u0001\u0010\u0019\u001a\u00020\u0003J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0001J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001b\u0010\u001b\u001a\u00020\u00032\u0008\u0008\u0001\u0010\u000c\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0086\u0002J\u0006\u0010\u001c\u001a\u00020\u000bJ\u0006\u0010\u001d\u001a\u00020\u000bJ\u0010\u0010\u001e\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0003R\u0012\u0010\u0005\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006 ", d2 = {"Landroidx/collection/MutableIntList;", "Landroidx/collection/IntList;", "initialCapacity", "", "(I)V", "capacity", "getCapacity", "()I", "add", "", "element", "", "index", "addAll", "elements", "", "clear", "ensureCapacity", "minusAssign", "plusAssign", "remove", "removeAll", "removeAt", "removeRange", "start", "end", "retainAll", "set", "sort", "sortDescending", "trim", "minCapacity", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableIntList extends androidx.collection.IntList {
    public MutableIntList() {
        super(0, 1, 0);
    }

    public MutableIntList(int initialCapacity) {
        super(initialCapacity, 0);
    }

    public MutableIntList(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 16 : obj1;
        super(obj1);
    }

    public static void trim$default(androidx.collection.MutableIntList mutableIntList, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = mutableIntList._size;
        }
        mutableIntList.trim(obj1);
    }

    @Override // androidx.collection.IntList
    public final void add(int index, int element) {
        int i;
        int _size;
        int _size3;
        int _size2;
        i = 0;
        int i3 = 1;
        if (index >= 0 && index <= this._size) {
            if (index <= this._size) {
                i = i3;
            }
        }
        if (i == 0) {
        } else {
            ensureCapacity(_size4 += i3);
            int[] content2 = this.content;
            if (index != this._size) {
                ArraysKt.copyInto(content2, content2, index + 1, index, this._size);
            }
            content2[index] = element;
            this._size = _size6 += i3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException content = new IndexOutOfBoundsException(stringBuilder.append("Index ").append(index).append(" must be in 0..").append(this._size).toString());
        throw content;
    }

    @Override // androidx.collection.IntList
    public final boolean add(int element) {
        final int i3 = 1;
        ensureCapacity(_size += i3);
        this.content[this._size] = element;
        this._size = _size2 += i3;
        return i3;
    }

    @Override // androidx.collection.IntList
    public final boolean addAll(int index, androidx.collection.IntList elements) {
        int _size2;
        int i;
        int _size3;
        int _size;
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i2 = 1;
        int i3 = 0;
        if (index >= 0 && index <= this._size) {
            i = index <= this._size ? i2 : i3;
        } else {
        }
        if (i == 0) {
        } else {
            if (elements.isEmpty()) {
                return i3;
            }
            ensureCapacity(_size6 += _size7);
            int[] content = this.content;
            if (index != this._size) {
                ArraysKt.copyInto(content, content, _size9 += index, index, this._size);
            }
            ArraysKt.copyInto(elements.content, content, index, i3, elements._size);
            this._size = _size4 += _size8;
            return i2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("Index ").append(index).append(" must be in 0..").append(this._size).toString());
        throw indexOutOfBoundsException;
    }

    @Override // androidx.collection.IntList
    public final boolean addAll(int index, int[] elements) {
        int _size;
        int _size2;
        int i;
        int i2;
        int length;
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i3 = 1;
        int i4 = 0;
        if (index >= 0 && index <= this._size) {
            i = index <= this._size ? i3 : i4;
        } else {
        }
        if (i == 0) {
        } else {
            i2 = elements.length == 0 ? i3 : i4;
            if (i2 != 0) {
                return i4;
            }
            ensureCapacity(_size4 += length);
            final int[] content = this.content;
            if (index != this._size) {
                ArraysKt.copyInto(content, content, length2 += index, index, this._size);
            }
            Object obj2 = elements;
            ArraysKt.copyInto$default(obj2, content, index, 0, 0, 12, 0);
            this._size = obj10 += obj11;
            return i3;
        }
        Object obj = elements;
        StringBuilder obj11 = new StringBuilder();
        IndexOutOfBoundsException obj10 = new IndexOutOfBoundsException(obj11.append("Index ").append(index).append(" must be in 0..").append(this._size).toString());
        throw obj10;
    }

    @Override // androidx.collection.IntList
    public final boolean addAll(androidx.collection.IntList elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return addAll(this._size, elements);
    }

    @Override // androidx.collection.IntList
    public final boolean addAll(int[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return addAll(this._size, elements);
    }

    @Override // androidx.collection.IntList
    public final void clear() {
        this._size = 0;
    }

    @Override // androidx.collection.IntList
    public final void ensureCapacity(int capacity) {
        int length;
        int[] copyOf;
        String str;
        final int[] content = this.content;
        if (content.length < capacity) {
            copyOf = Arrays.copyOf(content, Math.max(capacity, i /= 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    @Override // androidx.collection.IntList
    public final int getCapacity() {
        final int i = 0;
        return content.length;
    }

    @Override // androidx.collection.IntList
    public final void minusAssign(int element) {
        final int i = 0;
        remove(element);
    }

    @Override // androidx.collection.IntList
    public final void minusAssign(androidx.collection.IntList elements) {
        int i$iv;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj = elements;
        final int i3 = 0;
        i$iv = 0;
        while (i$iv < obj._size) {
            i2 = 0;
            remove(obj.content[i$iv]);
            i$iv++;
        }
    }

    @Override // androidx.collection.IntList
    public final void minusAssign(int[] elements) {
        int i3;
        int i4;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj = elements;
        final int i5 = 0;
        i3 = 0;
        while (i3 < obj.length) {
            i2 = 0;
            remove(obj[i3]);
            i3++;
        }
    }

    @Override // androidx.collection.IntList
    public final void plusAssign(int element) {
        final int i = 0;
        add(element);
    }

    @Override // androidx.collection.IntList
    public final void plusAssign(androidx.collection.IntList elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        addAll(this._size, elements);
    }

    @Override // androidx.collection.IntList
    public final void plusAssign(int[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        addAll(this._size, elements);
    }

    @Override // androidx.collection.IntList
    public final boolean remove(int element) {
        final int indexOf = indexOf(element);
        if (indexOf >= 0) {
            removeAt(indexOf);
            return 1;
        }
        return 0;
    }

    @Override // androidx.collection.IntList
    public final boolean removeAll(androidx.collection.IntList elements) {
        int i;
        Object obj;
        int i2;
        Intrinsics.checkNotNullParameter(elements, "elements");
        final int i4 = 0;
        _size2 -= i2;
        if (0 <= i5) {
        }
        if (this._size != this._size) {
        } else {
            i2 = 0;
        }
        return i2;
    }

    @Override // androidx.collection.IntList
    public final boolean removeAll(int[] elements) {
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(elements, "elements");
        i = 0;
        while (i < elements.length) {
            remove(elements[i]);
            i++;
        }
        i2 = this._size != this._size ? 1 : 0;
        return i2;
    }

    @Override // androidx.collection.IntList
    public final int removeAt(int index) {
        int i2;
        int i;
        int _size;
        Object _size2;
        i2 = 0;
        i = 1;
        if (index >= 0 && index < this._size) {
            if (index < this._size) {
                i2 = i;
            }
        }
        if (i2 == 0) {
        } else {
            int[] content2 = this.content;
            int i6 = 0;
            if (index != _size5 -= i) {
                ArraysKt.copyInto(content2, content2, index, index + 1, this._size);
            }
            this._size = _size3--;
            return content2[index];
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i5 = 0;
        IndexOutOfBoundsException content = new IndexOutOfBoundsException(stringBuilder.append("Index ").append(index).append(" must be in 0..").append(_size4 -= i).toString());
        throw content;
    }

    @Override // androidx.collection.IntList
    public final void removeRange(int start, int end) {
        int i;
        int content2;
        int content;
        int _size2;
        int _size;
        content = 0;
        if (start >= 0 && start <= this._size) {
            _size = start <= this._size ? i : content;
        } else {
        }
        final String str4 = "Start (";
        if (_size == 0) {
        } else {
            if (end >= 0 && end <= this._size) {
                if (end <= this._size) {
                } else {
                    i = content;
                }
            } else {
            }
            if (i == 0) {
            } else {
                if (end < start) {
                } else {
                    if (end != start && end < this._size) {
                        if (end < this._size) {
                            ArraysKt.copyInto(this.content, this.content, start, end, this._size);
                        }
                        this._size = _size3 -= content;
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.append(str4).append(start).append(") is more than end (").append(end).append(')').toString());
                throw illegalArgumentException;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append(str4).append(start).append(") and end (").append(end).append(") must be in 0..").append(this._size).toString());
        throw indexOutOfBoundsException;
    }

    @Override // androidx.collection.IntList
    public final boolean retainAll(androidx.collection.IntList elements) {
        Object obj;
        int contains;
        int i2;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        contains = 0;
        _size3 -= i;
        while (-1 < i2) {
            if (elements.contains(this.content[i2]) == 0) {
            }
            i2--;
            removeAt(i2);
        }
        if (this._size != this._size) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // androidx.collection.IntList
    public final boolean retainAll(int[] elements) {
        Object obj;
        int i3;
        int i4;
        int i2;
        int i5;
        Object obj2;
        int i6;
        int index$iv;
        int length;
        Object it;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        i3 = 0;
        i2 = 1;
        _size3 -= i2;
        obj = null;
        while (-1 < i4) {
            obj2 = elements;
            i6 = 0;
            index$iv = 0;
            while (index$iv < obj2.length) {
                i = 0;
                if (obj2[index$iv] == this.content[i4]) {
                } else {
                }
                it = obj;
                index$iv++;
                it = i2;
            }
            if (i3 < 0) {
            }
            i4--;
            obj = null;
            removeAt(i4);
            i = 0;
            if (obj2[index$iv] == this.content[i4]) {
            } else {
            }
            it = obj;
            if (it != null) {
            } else {
            }
            index$iv++;
            i3 = index$iv;
            it = i2;
        }
        if (this._size != this._size) {
        } else {
            i2 = obj;
        }
        return i2;
    }

    @Override // androidx.collection.IntList
    public final int set(int index, int element) {
        int i;
        int _size;
        int i2 = 1;
        i = 0;
        if (index >= 0 && index < this._size) {
            if (index < this._size) {
                i = i2;
            }
        }
        if (i == 0) {
        } else {
            int[] content = this.content;
            content[index] = element;
            return content[index];
        }
        StringBuilder stringBuilder = new StringBuilder();
        final int i4 = 0;
        IndexOutOfBoundsException old = new IndexOutOfBoundsException(stringBuilder.append("set index ").append(index).append(" must be between 0 .. ").append(_size2 -= i2).toString());
        throw old;
    }

    @Override // androidx.collection.IntList
    public final void sort() {
        ArraysKt.sort(this.content, 0, this._size);
    }

    @Override // androidx.collection.IntList
    public final void sortDescending() {
        ArraysKt.sortDescending(this.content, 0, this._size);
    }

    @Override // androidx.collection.IntList
    public final void trim(int minCapacity) {
        int this_$iv;
        int str;
        int i = Math.max(minCapacity, this._size);
        str = 0;
        if (content2.length > i) {
            this_$iv = Arrays.copyOf(this.content, i);
            Intrinsics.checkNotNullExpressionValue(this_$iv, "copyOf(this, newSize)");
            this.content = this_$iv;
        }
    }
}
