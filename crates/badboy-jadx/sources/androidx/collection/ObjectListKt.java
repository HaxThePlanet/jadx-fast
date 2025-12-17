package androidx.collection;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u001a\u0012\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\u0008\u0000\u0010\u0007\u001a\u0015\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\t\"\u0004\u0008\u0000\u0010\u0007H\u0086\u0008\u001a\u001f\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\t\"\u0004\u0008\u0000\u0010\u00072\u0006\u0010\n\u001a\u0002H\u0007¢\u0006\u0002\u0010\u000b\u001a'\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\t\"\u0004\u0008\u0000\u0010\u00072\u0006\u0010\n\u001a\u0002H\u00072\u0006\u0010\u000c\u001a\u0002H\u0007¢\u0006\u0002\u0010\r\u001a/\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\t\"\u0004\u0008\u0000\u0010\u00072\u0006\u0010\n\u001a\u0002H\u00072\u0006\u0010\u000c\u001a\u0002H\u00072\u0006\u0010\u000e\u001a\u0002H\u0007¢\u0006\u0002\u0010\u000f\u001a.\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\t\"\u0004\u0008\u0000\u0010\u00072\u0012\u0010\u0010\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00070\u0001\"\u0002H\u0007H\u0086\u0008¢\u0006\u0002\u0010\u0011\u001a\u0012\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\u0008\u0000\u0010\u0007\u001a\u001f\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\u0008\u0000\u0010\u00072\u0006\u0010\n\u001a\u0002H\u0007¢\u0006\u0002\u0010\u0013\u001a'\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\u0008\u0000\u0010\u00072\u0006\u0010\n\u001a\u0002H\u00072\u0006\u0010\u000c\u001a\u0002H\u0007¢\u0006\u0002\u0010\u0014\u001a/\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\u0008\u0000\u0010\u00072\u0006\u0010\n\u001a\u0002H\u00072\u0006\u0010\u000c\u001a\u0002H\u00072\u0006\u0010\u000e\u001a\u0002H\u0007¢\u0006\u0002\u0010\u0015\u001a+\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\u0008\u0000\u0010\u00072\u0012\u0010\u0010\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00070\u0001\"\u0002H\u0007¢\u0006\u0002\u0010\u0016\u001a\u0018\u0010\u0017\u001a\u00020\u0018*\u0006\u0012\u0002\u0008\u00030\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002\u001a \u0010\u001c\u001a\u00020\u0018*\u0006\u0012\u0002\u0008\u00030\u00192\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"EmptyArray", "", "", "[Ljava/lang/Object;", "EmptyObjectList", "Landroidx/collection/ObjectList;", "emptyObjectList", "E", "mutableObjectListOf", "Landroidx/collection/MutableObjectList;", "element1", "(Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "element2", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "element3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "elements", "([Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "objectListOf", "(Ljava/lang/Object;)Landroidx/collection/ObjectList;", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/ObjectList;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/ObjectList;", "([Ljava/lang/Object;)Landroidx/collection/ObjectList;", "checkIndex", "", "", "index", "", "checkSubIndex", "fromIndex", "toIndex", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ObjectListKt {

    private static final Object[] EmptyArray;
    private static final androidx.collection.ObjectList<Object> EmptyObjectList;
    static {
        final int i = 0;
        ObjectListKt.EmptyArray = new Object[i];
        MutableObjectList mutableObjectList = new MutableObjectList(i);
        ObjectListKt.EmptyObjectList = (ObjectList)mutableObjectList;
    }

    public static final void access$checkIndex(List $receiver, int index) {
        ObjectListKt.checkIndex($receiver, index);
    }

    public static final void access$checkSubIndex(List $receiver, int fromIndex, int toIndex) {
        ObjectListKt.checkSubIndex($receiver, fromIndex, toIndex);
    }

    public static final Object[] access$getEmptyArray$p() {
        return ObjectListKt.EmptyArray;
    }

    private static final void checkIndex(List<?> $this$checkIndex, int index) {
        final int size = $this$checkIndex.size();
        if (index < 0) {
        } else {
            if (index >= size) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("Index ").append(index).append(" is out of bounds. The list has ").append(size).append(" elements.").toString());
        throw indexOutOfBoundsException;
    }

    private static final void checkSubIndex(List<?> $this$checkSubIndex, int fromIndex, int toIndex) {
        final int size = $this$checkSubIndex.size();
        if (fromIndex > toIndex) {
        } else {
            if (fromIndex < 0) {
            } else {
                if (toIndex > size) {
                } else {
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                IndexOutOfBoundsException indexOutOfBoundsException2 = new IndexOutOfBoundsException(stringBuilder2.append("toIndex (").append(toIndex).append(") is more than than the list size (").append(size).append(')').toString());
                throw indexOutOfBoundsException2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("fromIndex (").append(fromIndex).append(") is less than 0.").toString());
            throw indexOutOfBoundsException;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder3.append("Indices are out of order. fromIndex (").append(fromIndex).append(") is greater than toIndex (").append(toIndex).append(").").toString());
        throw illegalArgumentException;
    }

    public static final <E> androidx.collection.ObjectList<E> emptyObjectList() {
        final androidx.collection.ObjectList emptyObjectList = ObjectListKt.EmptyObjectList;
        Intrinsics.checkNotNull(emptyObjectList, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.emptyObjectList>");
        return emptyObjectList;
    }

    public static final <E> androidx.collection.MutableObjectList<E> mutableObjectListOf() {
        final int i = 0;
        MutableObjectList mutableObjectList = new MutableObjectList(0, 1, 0);
        return mutableObjectList;
    }

    public static final <E> androidx.collection.MutableObjectList<E> mutableObjectListOf(E element1) {
        MutableObjectList mutableObjectList = new MutableObjectList(1);
        final int i2 = 0;
        mutableObjectList.add(element1);
        return mutableObjectList;
    }

    public static final <E> androidx.collection.MutableObjectList<E> mutableObjectListOf(E element1, E element2) {
        MutableObjectList mutableObjectList = new MutableObjectList(2);
        androidx.collection.MutableObjectList list = mutableObjectList;
        int i2 = 0;
        list.add(element1);
        int i3 = 0;
        list.add(element2);
        return mutableObjectList;
    }

    public static final <E> androidx.collection.MutableObjectList<E> mutableObjectListOf(E element1, E element2, E element3) {
        MutableObjectList mutableObjectList = new MutableObjectList(3);
        androidx.collection.MutableObjectList list = mutableObjectList;
        int i2 = 0;
        list.add(element1);
        int i3 = 0;
        list.add(element2);
        int i4 = 0;
        list.add(element3);
        return mutableObjectList;
    }

    public static final <E> androidx.collection.MutableObjectList<E> mutableObjectListOf(E... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = 0;
        MutableObjectList mutableObjectList = new MutableObjectList(elements.length);
        final int i2 = 0;
        mutableObjectList.plusAssign(elements);
        return mutableObjectList;
    }

    public static final <E> androidx.collection.ObjectList<E> objectListOf() {
        final androidx.collection.ObjectList emptyObjectList = ObjectListKt.EmptyObjectList;
        Intrinsics.checkNotNull(emptyObjectList, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.objectListOf>");
        return emptyObjectList;
    }

    public static final <E> androidx.collection.ObjectList<E> objectListOf(E element1) {
        return (ObjectList)ObjectListKt.mutableObjectListOf(element1);
    }

    public static final <E> androidx.collection.ObjectList<E> objectListOf(E element1, E element2) {
        return (ObjectList)ObjectListKt.mutableObjectListOf(element1, element2);
    }

    public static final <E> androidx.collection.ObjectList<E> objectListOf(E element1, E element2, E element3) {
        return (ObjectList)ObjectListKt.mutableObjectListOf(element1, element2, element3);
    }

    public static final <E> androidx.collection.ObjectList<E> objectListOf(E... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableObjectList mutableObjectList = new MutableObjectList(elements.length);
        final int i = 0;
        mutableObjectList.plusAssign(elements);
        return (ObjectList)mutableObjectList;
    }
}
