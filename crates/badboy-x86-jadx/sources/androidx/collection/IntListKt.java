package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u0012\u0010\u0003\u001a\u00020\u00012\n\u0010\u0008\u001a\u00020\t\"\u00020\u0005\u001a\t\u0010\n\u001a\u00020\u000bH\u0086\u0008\u001a\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u0015\u0010\n\u001a\u00020\u000b2\n\u0010\u0008\u001a\u00020\t\"\u00020\u0005H\u0086\u0008\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"EmptyIntList", "Landroidx/collection/IntList;", "emptyIntList", "intListOf", "element1", "", "element2", "element3", "elements", "", "mutableIntListOf", "Landroidx/collection/MutableIntList;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IntListKt {

    private static final androidx.collection.IntList EmptyIntList;
    static {
        MutableIntList mutableIntList = new MutableIntList(0);
        IntListKt.EmptyIntList = (IntList)mutableIntList;
    }

    public static final androidx.collection.IntList emptyIntList() {
        return IntListKt.EmptyIntList;
    }

    public static final androidx.collection.IntList intListOf() {
        return IntListKt.EmptyIntList;
    }

    public static final androidx.collection.IntList intListOf(int element1) {
        return (IntList)IntListKt.mutableIntListOf(element1);
    }

    public static final androidx.collection.IntList intListOf(int element1, int element2) {
        return (IntList)IntListKt.mutableIntListOf(element1, element2);
    }

    public static final androidx.collection.IntList intListOf(int element1, int element2, int element3) {
        return (IntList)IntListKt.mutableIntListOf(element1, element2, element3);
    }

    public static final androidx.collection.IntList intListOf(int... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableIntList mutableIntList = new MutableIntList(elements.length);
        final int i = 0;
        mutableIntList.plusAssign(elements);
        return (IntList)mutableIntList;
    }

    public static final androidx.collection.MutableIntList mutableIntListOf() {
        final int i = 0;
        MutableIntList mutableIntList = new MutableIntList(0, 1, 0);
        return mutableIntList;
    }

    public static final androidx.collection.MutableIntList mutableIntListOf(int element1) {
        MutableIntList mutableIntList = new MutableIntList(1);
        final int i2 = 0;
        mutableIntList.add(element1);
        return mutableIntList;
    }

    public static final androidx.collection.MutableIntList mutableIntListOf(int element1, int element2) {
        MutableIntList mutableIntList = new MutableIntList(2);
        androidx.collection.MutableIntList list = mutableIntList;
        int i2 = 0;
        list.add(element1);
        int i3 = 0;
        list.add(element2);
        return mutableIntList;
    }

    public static final androidx.collection.MutableIntList mutableIntListOf(int element1, int element2, int element3) {
        MutableIntList mutableIntList = new MutableIntList(3);
        androidx.collection.MutableIntList list = mutableIntList;
        int i2 = 0;
        list.add(element1);
        int i3 = 0;
        list.add(element2);
        int i4 = 0;
        list.add(element3);
        return mutableIntList;
    }

    public static final androidx.collection.MutableIntList mutableIntListOf(int... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = 0;
        MutableIntList mutableIntList = new MutableIntList(elements.length);
        final int i2 = 0;
        mutableIntList.plusAssign(elements);
        return mutableIntList;
    }
}
