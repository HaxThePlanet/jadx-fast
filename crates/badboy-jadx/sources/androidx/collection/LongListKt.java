package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u0012\u0010\u0003\u001a\u00020\u00012\n\u0010\u0008\u001a\u00020\t\"\u00020\u0005\u001a\t\u0010\n\u001a\u00020\u000bH\u0086\u0008\u001a\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u0015\u0010\n\u001a\u00020\u000b2\n\u0010\u0008\u001a\u00020\t\"\u00020\u0005H\u0086\u0008\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"EmptyLongList", "Landroidx/collection/LongList;", "emptyLongList", "longListOf", "element1", "", "element2", "element3", "elements", "", "mutableLongListOf", "Landroidx/collection/MutableLongList;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LongListKt {

    private static final androidx.collection.LongList EmptyLongList;
    static {
        MutableLongList mutableLongList = new MutableLongList(0);
        LongListKt.EmptyLongList = (LongList)mutableLongList;
    }

    public static final androidx.collection.LongList emptyLongList() {
        return LongListKt.EmptyLongList;
    }

    public static final androidx.collection.LongList longListOf() {
        return LongListKt.EmptyLongList;
    }

    public static final androidx.collection.LongList longListOf(long element1) {
        return (LongList)LongListKt.mutableLongListOf(element1);
    }

    public static final androidx.collection.LongList longListOf(long element1, long element2) {
        return (LongList)LongListKt.mutableLongListOf(element1, element2);
    }

    public static final androidx.collection.LongList longListOf(long element1, long element2, long element3) {
        return (LongList)LongListKt.mutableLongListOf(element1, element2, element3);
    }

    public static final androidx.collection.LongList longListOf(long... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableLongList mutableLongList = new MutableLongList(elements.length);
        final int i = 0;
        mutableLongList.plusAssign(elements);
        return (LongList)mutableLongList;
    }

    public static final androidx.collection.MutableLongList mutableLongListOf() {
        final int i = 0;
        MutableLongList mutableLongList = new MutableLongList(0, 1, 0);
        return mutableLongList;
    }

    public static final androidx.collection.MutableLongList mutableLongListOf(long element1) {
        MutableLongList mutableLongList = new MutableLongList(1);
        final int i2 = 0;
        mutableLongList.add(element1);
        return mutableLongList;
    }

    public static final androidx.collection.MutableLongList mutableLongListOf(long element1, long element2) {
        MutableLongList mutableLongList = new MutableLongList(2);
        androidx.collection.MutableLongList num = mutableLongList;
        int i2 = 0;
        num.add(element1);
        int i3 = 0;
        num.add(obj5);
        return mutableLongList;
    }

    public static final androidx.collection.MutableLongList mutableLongListOf(long element1, long element2, long element3) {
        MutableLongList mutableLongList = new MutableLongList(3);
        androidx.collection.MutableLongList num = mutableLongList;
        int i2 = 0;
        num.add(element1);
        int i3 = 0;
        num.add(element3);
        int i4 = 0;
        num.add(obj7);
        return mutableLongList;
    }

    public static final androidx.collection.MutableLongList mutableLongListOf(long... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = 0;
        MutableLongList mutableLongList = new MutableLongList(elements.length);
        final int i2 = 0;
        mutableLongList.plusAssign(elements);
        return mutableLongList;
    }
}
