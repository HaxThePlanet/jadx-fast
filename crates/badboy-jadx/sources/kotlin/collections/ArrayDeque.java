package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008&\u0008\u0007\u0018\u0000 [*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001[B\u000f\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0006B\u0015\u0008\u0016\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008¢\u0006\u0002\u0010\tJ\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008H\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008H\u0016J\u0013\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0008\u0010\u001e\u001a\u00020\u0017H\u0016J\u0016\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0016J\u001e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00042\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008H\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004H\u0002J\u001d\u0010'\u001a\u00020\u00142\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140)H\u0082\u0008J\u000b\u0010*\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010,\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0016\u0010-\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u00100\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u0016\u00102\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0004H\u0083\u0008¢\u0006\u0002\u0010.J\u0011\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0083\u0008JM\u00103\u001a\u00020\u00172>\u00104\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u00086\u0012\u0008\u00087\u0012\u0004\u0008\u0008(\u000e\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u000b¢\u0006\u000c\u00086\u0012\u0008\u00087\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u001705H\u0000¢\u0006\u0002\u00088J\u0008\u00109\u001a\u00020\u0014H\u0016J\u000b\u0010:\u001a\u00028\u0000¢\u0006\u0002\u0010+J\u0015\u0010;\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\r\u0010<\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0002J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0008\u0010B\u001a\u00020\u0017H\u0002J\u0015\u0010C\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0016\u0010D\u001a\u00020\u00142\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008H\u0016J\u0015\u0010E\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010.J\u000b\u0010F\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010G\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u000b\u0010H\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010I\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0018\u0010J\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0014J\u0018\u0010M\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0002J\u0018\u0010N\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0002J\u0016\u0010O\u001a\u00020\u00142\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008H\u0016J\u001e\u0010P\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010QJ\u001d\u0010R\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0008SJ\u0017\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u000bH\u0000¢\u0006\u0004\u0008U\u0010VJ)\u0010T\u001a\u0008\u0012\u0004\u0012\u0002HW0\u000b\"\u0004\u0008\u0001\u0010W2\u000c\u0010X\u001a\u0008\u0012\u0004\u0012\u0002HW0\u000bH\u0000¢\u0006\u0004\u0008U\u0010YJ\u0015\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u000bH\u0016¢\u0006\u0002\u0010VJ'\u0010Z\u001a\u0008\u0012\u0004\u0012\u0002HW0\u000b\"\u0004\u0008\u0001\u0010W2\u000c\u0010X\u001a\u0008\u0012\u0004\u0012\u0002HW0\u000bH\u0016¢\u0006\u0002\u0010YR\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\\", d2 = {"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", "initialCapacity", "", "(I)V", "()V", "elements", "", "(Ljava/util/Collection;)V", "elementData", "", "", "[Ljava/lang/Object;", "head", "<set-?>", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "addFirst", "(Ljava/lang/Object;)V", "addLast", "clear", "contains", "copyCollectionElements", "internalIndex", "copyElements", "newCapacity", "decremented", "ensureCapacity", "minCapacity", "filterInPlace", "predicate", "Lkotlin/Function1;", "first", "()Ljava/lang/Object;", "firstOrNull", "get", "(I)Ljava/lang/Object;", "incremented", "indexOf", "(Ljava/lang/Object;)I", "internalGet", "internalStructure", "structure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "isEmpty", "last", "lastIndexOf", "lastOrNull", "negativeMod", "nullifyNonEmpty", "internalFromIndex", "internalToIndex", "positiveMod", "registerModification", "remove", "removeAll", "removeAt", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "removeRange", "fromIndex", "toIndex", "removeRangeShiftPreceding", "removeRangeShiftSucceeding", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "testRemoveRange", "testRemoveRange$kotlin_stdlib", "testToArray", "testToArray$kotlin_stdlib", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toArray", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ArrayDeque<E>  extends kotlin.collections.AbstractMutableList<E> {

    public static final kotlin.collections.ArrayDeque.Companion Companion = null;
    private static final int defaultMinCapacity = 10;
    private static final Object[] emptyElementData;
    private Object[] elementData;
    private int head;
    private int size;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0008", d2 = {"Lkotlin/collections/ArrayDeque$Companion;", "", "()V", "defaultMinCapacity", "", "emptyElementData", "", "[Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        ArrayDeque.Companion companion = new ArrayDeque.Companion(0);
        ArrayDeque.Companion = companion;
        ArrayDeque.emptyElementData = new Object[0];
    }

    public ArrayDeque() {
        super();
        this.elementData = ArrayDeque.emptyElementData;
    }

    public ArrayDeque(int initialCapacity) {
        Object[] emptyElementData;
        super();
        if (initialCapacity == 0) {
            emptyElementData = ArrayDeque.emptyElementData;
            this.elementData = emptyElementData;
        } else {
            if (initialCapacity <= 0) {
            } else {
                emptyElementData = new Object[initialCapacity];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Illegal Capacity: ").append(initialCapacity).toString());
        throw illegalArgumentException;
    }

    public ArrayDeque(Collection<? extends E> elements) {
        int emptyElementData;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        super();
        final int i2 = 0;
        this.elementData = elements.toArray(new Object[0]);
        this.size = elementData.length;
        i = elementData2.length == 0 ? 1 : i;
        if (i != 0) {
            this.elementData = ArrayDeque.emptyElementData;
        }
    }

    private final void copyCollectionElements(int internalIndex, Collection<? extends E> elements) {
        int index;
        int index2;
        Object[] elementData;
        Object next;
        final Iterator iterator = elements.iterator();
        index = internalIndex;
        while (index < elementData2.length) {
            if (iterator.hasNext()) {
            }
            this.elementData[index] = iterator.next();
            index++;
        }
        index2 = 0;
        while (index2 < this.head) {
            if (iterator.hasNext()) {
            }
            this.elementData[index2] = iterator.next();
            index2++;
        }
        this.size = size += size2;
    }

    private final void copyElements(int newCapacity) {
        final Object[] arr = new Object[newCapacity];
        final int i2 = 0;
        ArraysKt.copyInto(this.elementData, arr, i2, this.head, elementData4.length);
        ArraysKt.copyInto(this.elementData, arr, length -= head2, i2, this.head);
        this.head = i2;
        this.elementData = arr;
    }

    private final int decremented(int index) {
        int lastIndex;
        if (index == 0) {
            lastIndex = ArraysKt.getLastIndex(this.elementData);
        } else {
            lastIndex = index + -1;
        }
        return lastIndex;
    }

    private final void ensureCapacity(int minCapacity) {
        if (minCapacity < 0) {
        } else {
            if (minCapacity <= elementData.length) {
            }
            if (this.elementData == ArrayDeque.emptyElementData) {
                this.elementData = new Object[RangesKt.coerceAtLeast(minCapacity, 10)];
            }
            copyElements(AbstractList.Companion.newCapacity$kotlin_stdlib(elementData3.length, minCapacity));
        }
        IllegalStateException newCapacity = new IllegalStateException("Deque is too big.");
        throw newCapacity;
    }

    private final boolean filterInPlace(Function1<? super E, Boolean> predicate) {
        int empty;
        int newTail;
        int modified;
        int index2;
        int index;
        int index3;
        int length;
        Object booleanValue;
        boolean booleanValue2;
        int i;
        final int i2 = 0;
        int i4 = 0;
        if (!isEmpty()) {
            empty = elementData.length == 0 ? 1 : i4;
            if (empty != 0) {
            } else {
                int positiveMod = positiveMod(head += size);
                newTail = this.head;
                modified = 0;
                final int i6 = 0;
                if (this.head < positiveMod) {
                    index3 = this.head;
                    while (index3 < positiveMod) {
                        length = this.elementData[index3];
                        if ((Boolean)predicate.invoke(length).booleanValue()) {
                        } else {
                        }
                        modified = 1;
                        index3++;
                        this.elementData[newTail] = length;
                        newTail = booleanValue2;
                    }
                    ArraysKt.fill(this.elementData, i6, newTail, positiveMod);
                } else {
                    index2 = this.head;
                    while (index2 < elementData2.length) {
                        booleanValue = this.elementData[index2];
                        this.elementData[index2] = i6;
                        if ((Boolean)predicate.invoke(booleanValue).booleanValue()) {
                        } else {
                        }
                        modified = 1;
                        index2++;
                        this.elementData[newTail] = booleanValue;
                        newTail = i;
                    }
                    newTail = positiveMod(newTail);
                    index = 0;
                    while (index < positiveMod) {
                        length = this.elementData[index];
                        this.elementData[index] = i6;
                        if ((Boolean)predicate.invoke(length).booleanValue()) {
                        } else {
                        }
                        modified = 1;
                        index++;
                        this.elementData[newTail] = length;
                        newTail = incremented(newTail);
                    }
                }
                if (modified != 0) {
                    registerModification();
                    this.size = negativeMod(newTail - head3);
                }
            }
            return modified;
        }
        return i4;
    }

    private final int incremented(int index) {
        int i;
        i = index == ArraysKt.getLastIndex(this.elementData) ? 0 : index + 1;
        return i;
    }

    private final E internalGet(int internalIndex) {
        return this.elementData[internalIndex];
    }

    private final int internalIndex(int index) {
        return positiveMod(head += index);
    }

    private final int negativeMod(int index) {
        int i;
        if (index < 0) {
            length += index;
        } else {
            i = index;
        }
        return i;
    }

    private final void nullifyNonEmpty(int internalFromIndex, int internalToIndex) {
        Object[] elementData;
        int i;
        final int i2 = 0;
        if (internalFromIndex < internalToIndex) {
            ArraysKt.fill(this.elementData, i2, internalFromIndex, internalToIndex);
        } else {
            ArraysKt.fill(this.elementData, i2, internalFromIndex, elementData3.length);
            ArraysKt.fill(this.elementData, i2, 0, internalToIndex);
        }
    }

    private final int positiveMod(int index) {
        int i;
        if (index >= elementData.length) {
            i = index - length2;
        } else {
            i = index;
        }
        return i;
    }

    private final void registerModification() {
        this.modCount = modCount++;
    }

    private final void removeRangeShiftPreceding(int fromIndex, int toIndex) {
        int copyFromIndex;
        int copyToIndex;
        int copyCount;
        int i2;
        int i3;
        Object[] elementData;
        int i5;
        int i4;
        int i;
        copyFromIndex = positiveMod(head += i7);
        copyToIndex = positiveMod(head2 += i9);
        copyCount = fromIndex;
        while (copyCount > 0) {
            i2 = Math.min(copyCount, Math.min(copyFromIndex + 1, copyToIndex + 1));
            ArraysKt.copyInto(this.elementData, this.elementData, i14++, i15++, copyFromIndex + 1);
            copyFromIndex = negativeMod(copyFromIndex - i2);
            copyToIndex = negativeMod(copyToIndex - i2);
            copyCount -= i2;
        }
    }

    private final void removeRangeShiftSucceeding(int fromIndex, int toIndex) {
        int copyFromIndex;
        int copyToIndex;
        int copyCount;
        int i2;
        int i3;
        Object[] elementData;
        int i;
        copyFromIndex = positiveMod(head += toIndex);
        copyToIndex = positiveMod(head2 += fromIndex);
        size -= toIndex;
        while (copyCount > 0) {
            i2 = Math.min(copyCount, Math.min(length -= copyFromIndex, length2 -= copyToIndex));
            ArraysKt.copyInto(this.elementData, this.elementData, copyToIndex, copyFromIndex, copyFromIndex + i2);
            copyFromIndex = positiveMod(copyFromIndex + i2);
            copyToIndex = positiveMod(copyToIndex + i2);
            copyCount -= i2;
        }
    }

    public void add(int index, E element) {
        int positiveMod;
        Object[] elementData6;
        Object[] elementData4;
        int elementData2;
        Object[] elementData3;
        int elementData;
        int elementData5;
        int i;
        int head;
        int length;
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, size());
        if (index == size()) {
            addLast(element);
        }
        if (index == 0) {
            addFirst(element);
        }
        registerModification();
        int i4 = 1;
        ensureCapacity(size2 += i4);
        int positiveMod2 = positiveMod(head2 += index);
        elementData2 = 0;
        if (index < i5 >>= i4) {
            positiveMod = decremented(positiveMod2);
            elementData3 = decremented(this.head);
            if (positiveMod >= this.head) {
                this.elementData[elementData3] = this.elementData[this.head];
                ArraysKt.copyInto(this.elementData, this.elementData, this.head, head8 += i4, positiveMod + 1);
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, head7 -= i4, this.head, elementData20.length);
                this.elementData[length4 -= i4] = this.elementData[elementData2];
                ArraysKt.copyInto(this.elementData, this.elementData, elementData2, i4, positiveMod + 1);
            }
            this.elementData[positiveMod] = element;
            this.head = elementData3;
        } else {
            positiveMod = positiveMod(head3 += size6);
            if (positiveMod2 < positiveMod) {
                ArraysKt.copyInto(this.elementData, this.elementData, positiveMod2 + 1, positiveMod2, positiveMod);
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, i4, elementData2, positiveMod);
                this.elementData[elementData2] = this.elementData[length2 -= i4];
                ArraysKt.copyInto(this.elementData, this.elementData, positiveMod2 + 1, positiveMod2, length3 -= i4);
            }
            this.elementData[positiveMod2] = element;
        }
        this.size = size5 += i4;
    }

    public boolean add(E element) {
        addLast(element);
        return 1;
    }

    public boolean addAll(int index, Collection<? extends E> elements) {
        Object[] elementData6;
        int elementData2;
        int shiftedHead;
        Object[] elementData3;
        int elementData5;
        int elementData4;
        int elementData;
        int i2;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, size());
        elementData2 = 0;
        if (elements.isEmpty()) {
            return elementData2;
        }
        if (index == size()) {
            return addAll(elements);
        }
        registerModification();
        ensureCapacity(size2 += size4);
        int positiveMod = positiveMod(head += size5);
        int positiveMod2 = positiveMod(head2 += index);
        final int size6 = elements.size();
        final int i9 = 1;
        if (index < i7 >>= i9) {
            head3 -= size6;
            if (positiveMod2 >= this.head) {
                if (shiftedHead >= 0) {
                    ArraysKt.copyInto(this.elementData, this.elementData, shiftedHead, this.head, positiveMod2);
                } else {
                    shiftedHead += length3;
                    length8 -= shiftedHead;
                    if (elementData5 >= positiveMod2 - head5) {
                        ArraysKt.copyInto(this.elementData, this.elementData, shiftedHead, this.head, positiveMod2);
                    } else {
                        ArraysKt.copyInto(this.elementData, this.elementData, shiftedHead, this.head, head9 += elementData5);
                        ArraysKt.copyInto(this.elementData, this.elementData, elementData2, head8 += elementData5, positiveMod2);
                    }
                }
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, shiftedHead, this.head, elementData30.length);
                if (size6 >= positiveMod2) {
                    ArraysKt.copyInto(this.elementData, this.elementData, length10 -= size6, elementData2, positiveMod2);
                } else {
                    ArraysKt.copyInto(this.elementData, this.elementData, length11 -= size6, elementData2, size6);
                    ArraysKt.copyInto(this.elementData, this.elementData, elementData2, size6, positiveMod2);
                }
            }
            this.head = shiftedHead;
            copyCollectionElements(negativeMod(positiveMod2 - size6), elements);
        } else {
            shiftedHead = positiveMod2 + size6;
            if (positiveMod2 < positiveMod) {
                if (positiveMod + size6 <= elementData16.length) {
                    ArraysKt.copyInto(this.elementData, this.elementData, shiftedHead, positiveMod2, positiveMod);
                } else {
                    if (shiftedHead >= elementData9.length) {
                        ArraysKt.copyInto(this.elementData, this.elementData, shiftedHead - length7, positiveMod2, positiveMod);
                    } else {
                        i11 -= length6;
                        ArraysKt.copyInto(this.elementData, this.elementData, elementData2, positiveMod - elementData3, positiveMod);
                        ArraysKt.copyInto(this.elementData, this.elementData, shiftedHead, positiveMod2, positiveMod - elementData3);
                    }
                }
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, size6, elementData2, positiveMod);
                if (shiftedHead >= elementData7.length) {
                    ArraysKt.copyInto(this.elementData, this.elementData, shiftedHead - length4, positiveMod2, elementData23.length);
                } else {
                    ArraysKt.copyInto(this.elementData, this.elementData, elementData2, length9 -= size6, elementData29.length);
                    ArraysKt.copyInto(this.elementData, this.elementData, shiftedHead, positiveMod2, length5 -= size6);
                }
            }
            copyCollectionElements(positiveMod2, elements);
        }
        return i9;
    }

    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return 0;
        }
        registerModification();
        ensureCapacity(size += size2);
        copyCollectionElements(positiveMod(head += size3), elements);
        return 1;
    }

    public final void addFirst(E element) {
        registerModification();
        ensureCapacity(size++);
        this.head = decremented(this.head);
        this.elementData[this.head] = element;
        this.size = size2++;
    }

    public final void addLast(E element) {
        registerModification();
        ensureCapacity(size++);
        this.elementData[positiveMod(head += size3)] = element;
        this.size = size2++;
    }

    @Override // kotlin.collections.AbstractMutableList
    public void clear() {
        boolean positiveMod;
        int head;
        if (!(Collection)this.isEmpty()) {
            registerModification();
            nullifyNonEmpty(this.head, positiveMod(head2 += size));
        }
        int tail = 0;
        this.head = tail;
        this.size = tail;
    }

    @Override // kotlin.collections.AbstractMutableList
    public boolean contains(Object element) {
        int i;
        i = indexOf(element) != -1 ? 1 : 0;
        return i;
    }

    public final E first() {
        if (isEmpty()) {
        } else {
            return this.elementData[this.head];
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("ArrayDeque is empty.");
        throw noSuchElementException;
    }

    public final E firstOrNull() {
        int i;
        int head;
        if (isEmpty()) {
            i = 0;
        } else {
            i = this.elementData[this.head];
        }
        return i;
    }

    public E get(int index) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, size());
        return this.elementData[positiveMod(head += index)];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.collections.AbstractMutableList
    public int indexOf(Object element) {
        int index2;
        int index;
        int length;
        boolean equal;
        int positiveMod = positiveMod(head += size);
        if (this.head < positiveMod) {
            index = this.head;
            while (index < positiveMod) {
                index++;
            }
        } else {
            if (this.head >= positiveMod) {
                index2 = this.head;
                while (index2 < elementData.length) {
                    index2++;
                }
                index = 0;
                while (index < positiveMod) {
                    index++;
                }
            }
        }
        return -1;
    }

    public final void internalStructure$kotlin_stdlib(Function2<? super Integer, ? super Object[], Unit> structure) {
        int head;
        boolean empty;
        int length;
        Intrinsics.checkNotNullParameter(structure, "structure");
        if (!isEmpty()) {
            if (this.head < positiveMod(head2 += size)) {
                head = this.head;
            } else {
                head3 -= length;
            }
        } else {
        }
        structure.invoke(Integer.valueOf(head), toArray());
    }

    @Override // kotlin.collections.AbstractMutableList
    public boolean isEmpty() {
        int i;
        i = size() == 0 ? 1 : 0;
        return i;
    }

    public final E last() {
        if (isEmpty()) {
        } else {
            return this.elementData[positiveMod(head += lastIndex)];
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("ArrayDeque is empty.");
        throw noSuchElementException;
    }

    @Override // kotlin.collections.AbstractMutableList
    public int lastIndexOf(Object element) {
        int index2;
        int index;
        boolean equal;
        boolean equal2;
        int positiveMod = positiveMod(head += size);
        int i2 = -1;
        if (this.head < positiveMod) {
            equal = this.head;
            if (equal <= positiveMod + -1) {
            }
        } else {
            if (this.head > positiveMod) {
                index2 = positiveMod + -1;
                while (i2 < index2) {
                    index2--;
                }
                equal = this.head;
                if (equal <= ArraysKt.getLastIndex(this.elementData)) {
                }
            }
        }
        return i2;
    }

    public final E lastOrNull() {
        int i;
        int positiveMod;
        int lastIndex;
        if (isEmpty()) {
            i = 0;
        } else {
            i = this.elementData[positiveMod(head += lastIndex)];
        }
        return i;
    }

    @Override // kotlin.collections.AbstractMutableList
    public boolean remove(Object element) {
        final int indexOf = indexOf(element);
        if (indexOf == -1) {
            return 0;
        }
        remove(indexOf);
        return 1;
    }

    public boolean removeAll(Collection<? extends Object> elements) {
        boolean positiveMod;
        int newTail$iv2;
        int head;
        int newTail$iv;
        int modified$iv;
        int modified$iv2;
        int index$iv2;
        int index$iv3;
        int index$iv;
        int i2;
        int length;
        Object elementData;
        Object elementData2;
        int contains2;
        boolean contains;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj = this;
        final int i3 = 0;
        if (!obj.isEmpty()) {
            positiveMod = elementData3.length == 0 ? 1 : newTail$iv2;
            if (positiveMod != 0) {
            } else {
                positiveMod = obj.positiveMod(head2 += size);
                head = obj.head;
                modified$iv2 = 0;
                i2 = 0;
                if (obj.head < positiveMod) {
                    index$iv = obj.head;
                    while (index$iv < positiveMod) {
                        length = obj.elementData[index$iv];
                        elementData2 = 0;
                        if (!elements.contains(length)) {
                        } else {
                        }
                        modified$iv2 = 1;
                        index$iv++;
                        obj.elementData[head] = length;
                        head = elementData2;
                    }
                    ArraysKt.fill(obj.elementData, i2, head, positiveMod);
                    modified$iv = head;
                    newTail$iv2 = i;
                } else {
                    index$iv3 = obj.head;
                    while (index$iv3 < elementData4.length) {
                        elementData = obj.elementData[index$iv3];
                        obj.elementData[index$iv3] = i2;
                        contains2 = 0;
                        if (!elements.contains(elementData)) {
                        } else {
                        }
                        modified$iv2 = 1;
                        index$iv3++;
                        obj.elementData[head] = elementData;
                        head = contains2;
                    }
                    newTail$iv = obj.positiveMod(head);
                    index$iv2 = 0;
                    while (index$iv2 < positiveMod) {
                        length = obj.elementData[index$iv2];
                        obj.elementData[index$iv2] = i2;
                        elementData2 = 0;
                        if (!elements.contains(length)) {
                        } else {
                        }
                        modified$iv2 = 1;
                        index$iv2++;
                        obj.elementData[newTail$iv] = length;
                        newTail$iv = obj.incremented(newTail$iv);
                    }
                    modified$iv = newTail$iv;
                    newTail$iv2 = i;
                }
                if (newTail$iv2 != 0) {
                    obj.registerModification();
                    obj.size = obj.negativeMod(modified$iv - head4);
                }
            }
        } else {
        }
        return newTail$iv2;
    }

    public E removeAt(int index) {
        int positiveMod;
        Object[] elementData5;
        int elementData;
        Object[] elementData6;
        Object[] elementData4;
        Object[] elementData3;
        Object[] elementData2;
        int i;
        int length;
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, size());
        if (index == CollectionsKt.getLastIndex((List)this)) {
            return removeLast();
        }
        if (index == 0) {
            return removeFirst();
        }
        registerModification();
        int positiveMod2 = positiveMod(head += index);
        final int i6 = 1;
        final int i7 = 0;
        elementData = 0;
        if (index < size2 >>= i6) {
            if (positiveMod2 >= this.head) {
                ArraysKt.copyInto(this.elementData, this.elementData, head6 += i6, this.head, positiveMod2);
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, i6, elementData, positiveMod2);
                this.elementData[elementData] = this.elementData[length3 -= i6];
                ArraysKt.copyInto(this.elementData, this.elementData, head5 += i6, this.head, length4 -= i6);
            }
            this.elementData[this.head] = i7;
            this.head = incremented(this.head);
        } else {
            positiveMod = positiveMod(head2 += lastIndex2);
            if (positiveMod2 <= positiveMod) {
                ArraysKt.copyInto(this.elementData, this.elementData, positiveMod2, positiveMod2 + 1, positiveMod + 1);
            } else {
                ArraysKt.copyInto(this.elementData, this.elementData, positiveMod2, positiveMod2 + 1, elementData20.length);
                this.elementData[length2 -= i6] = this.elementData[elementData];
                ArraysKt.copyInto(this.elementData, this.elementData, elementData, i6, positiveMod + 1);
            }
            this.elementData[positiveMod] = i7;
        }
        this.size = size3 -= i6;
        return this.elementData[positiveMod2];
    }

    public final E removeFirst() {
        if (isEmpty()) {
        } else {
            registerModification();
            this.elementData[this.head] = 0;
            this.head = incremented(this.head);
            this.size = size--;
            return this.elementData[this.head];
        }
        NoSuchElementException element = new NoSuchElementException("ArrayDeque is empty.");
        throw element;
    }

    public final E removeFirstOrNull() {
        int first;
        if (isEmpty()) {
            first = 0;
        } else {
            first = removeFirst();
        }
        return first;
    }

    public final E removeLast() {
        if (isEmpty()) {
        } else {
            registerModification();
            int positiveMod = positiveMod(head += lastIndex);
            this.elementData[positiveMod] = 0;
            this.size = size--;
            return this.elementData[positiveMod];
        }
        NoSuchElementException internalLastIndex = new NoSuchElementException("ArrayDeque is empty.");
        throw internalLastIndex;
    }

    public final E removeLastOrNull() {
        int last;
        if (isEmpty()) {
            last = 0;
        } else {
            last = removeLast();
        }
        return last;
    }

    @Override // kotlin.collections.AbstractMutableList
    protected void removeRange(int fromIndex, int toIndex) {
        int positiveMod;
        int negativeMod;
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, size());
        int i = toIndex - fromIndex;
        if (i == 0) {
        }
        if (i == size()) {
            clear();
        }
        if (i == 1) {
            remove(fromIndex);
        }
        registerModification();
        if (fromIndex < size3 -= toIndex) {
            removeRangeShiftPreceding(fromIndex, toIndex);
            positiveMod = positiveMod(head += i);
            nullifyNonEmpty(this.head, positiveMod);
            this.head = positiveMod;
        } else {
            removeRangeShiftSucceeding(fromIndex, toIndex);
            positiveMod = positiveMod(head2 += size5);
            nullifyNonEmpty(negativeMod(positiveMod - i), positiveMod);
        }
        this.size = size4 -= i;
    }

    public boolean retainAll(Collection<? extends Object> elements) {
        boolean positiveMod;
        int newTail$iv;
        int head;
        int newTail$iv2;
        int modified$iv;
        int modified$iv2;
        int index$iv3;
        int index$iv;
        int index$iv2;
        int i2;
        int length;
        Object it;
        boolean it2;
        int i;
        int i3;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj = this;
        final int i4 = 0;
        if (!obj.isEmpty()) {
            positiveMod = elementData.length == 0 ? 1 : newTail$iv;
            if (positiveMod != 0) {
            } else {
                positiveMod = obj.positiveMod(head2 += size);
                head = obj.head;
                modified$iv2 = 0;
                i2 = 0;
                if (obj.head < positiveMod) {
                    index$iv2 = obj.head;
                    while (index$iv2 < positiveMod) {
                        length = obj.elementData[index$iv2];
                        it2 = 0;
                        if (elements.contains(length)) {
                        } else {
                        }
                        modified$iv2 = 1;
                        index$iv2++;
                        obj.elementData[head] = length;
                        head = it2;
                    }
                    ArraysKt.fill(obj.elementData, i2, head, positiveMod);
                    modified$iv = head;
                    newTail$iv = i3;
                } else {
                    index$iv = obj.head;
                    while (index$iv < elementData2.length) {
                        it = obj.elementData[index$iv];
                        obj.elementData[index$iv] = i2;
                        i = 0;
                        if (elements.contains(it)) {
                        } else {
                        }
                        modified$iv2 = 1;
                        index$iv++;
                        obj.elementData[head] = it;
                        head = i;
                    }
                    newTail$iv2 = obj.positiveMod(head);
                    index$iv3 = 0;
                    while (index$iv3 < positiveMod) {
                        length = obj.elementData[index$iv3];
                        obj.elementData[index$iv3] = i2;
                        it2 = 0;
                        if (elements.contains(length)) {
                        } else {
                        }
                        modified$iv2 = 1;
                        index$iv3++;
                        obj.elementData[newTail$iv2] = length;
                        newTail$iv2 = obj.incremented(newTail$iv2);
                    }
                    modified$iv = newTail$iv2;
                    newTail$iv = i3;
                }
                if (newTail$iv != 0) {
                    obj.registerModification();
                    obj.size = obj.negativeMod(modified$iv - head4);
                }
            }
        } else {
        }
        return newTail$iv;
    }

    public E set(int index, E element) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, size());
        int positiveMod = positiveMod(head += index);
        this.elementData[positiveMod] = element;
        return this.elementData[positiveMod];
    }

    @Override // kotlin.collections.AbstractMutableList
    public final void testRemoveRange$kotlin_stdlib(int fromIndex, int toIndex) {
        removeRange(fromIndex, toIndex);
    }

    @Override // kotlin.collections.AbstractMutableList
    public final Object[] testToArray$kotlin_stdlib() {
        return toArray();
    }

    public final <T> T[] testToArray$kotlin_stdlib(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return toArray(array);
    }

    @Override // kotlin.collections.AbstractMutableList
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public <T> T[] toArray(T[] array) {
        Object[] arrayOfNulls;
        boolean elementData;
        int elementData2;
        int head2;
        int head;
        int i2;
        int i;
        Intrinsics.checkNotNullParameter(array, "array");
        if (array.length >= size()) {
            arrayOfNulls = array;
        } else {
            arrayOfNulls = ArraysKt.arrayOfNulls(array, size());
        }
        final Object[] objArr = arrayOfNulls;
        final int positiveMod = positiveMod(head3 += elementData2);
        if (this.head < positiveMod) {
            ArraysKt.copyInto$default(this.elementData, objArr, 0, this.head, positiveMod, 2, 0);
        } else {
            if (!(Collection)this.isEmpty()) {
                head = 0;
                ArraysKt.copyInto(this.elementData, objArr, head, this.head, elementData5.length);
                ArraysKt.copyInto(this.elementData, objArr, length2 -= head2, head, positiveMod);
            }
        }
        return CollectionsKt.terminateCollectionToArray(size(), objArr);
    }
}
