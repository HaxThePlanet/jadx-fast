package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u0012\u0010\u0003\u001a\u00020\u00012\n\u0010\u0008\u001a\u00020\t\"\u00020\u0005\u001a\t\u0010\n\u001a\u00020\u000bH\u0086\u0008\u001a\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u0015\u0010\n\u001a\u00020\u000b2\n\u0010\u0008\u001a\u00020\t\"\u00020\u0005H\u0086\u0008\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"EmptyFloatList", "Landroidx/collection/FloatList;", "emptyFloatList", "floatListOf", "element1", "", "element2", "element3", "elements", "", "mutableFloatListOf", "Landroidx/collection/MutableFloatList;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FloatListKt {

    private static final androidx.collection.FloatList EmptyFloatList;
    static {
        MutableFloatList mutableFloatList = new MutableFloatList(0);
        FloatListKt.EmptyFloatList = (FloatList)mutableFloatList;
    }

    public static final androidx.collection.FloatList emptyFloatList() {
        return FloatListKt.EmptyFloatList;
    }

    public static final androidx.collection.FloatList floatListOf() {
        return FloatListKt.EmptyFloatList;
    }

    public static final androidx.collection.FloatList floatListOf(float element1) {
        return (FloatList)FloatListKt.mutableFloatListOf(element1);
    }

    public static final androidx.collection.FloatList floatListOf(float element1, float element2) {
        return (FloatList)FloatListKt.mutableFloatListOf(element1, element2);
    }

    public static final androidx.collection.FloatList floatListOf(float element1, float element2, float element3) {
        return (FloatList)FloatListKt.mutableFloatListOf(element1, element2, element3);
    }

    public static final androidx.collection.FloatList floatListOf(float... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableFloatList mutableFloatList = new MutableFloatList(elements.length);
        final int i = 0;
        mutableFloatList.plusAssign(elements);
        return (FloatList)mutableFloatList;
    }

    public static final androidx.collection.MutableFloatList mutableFloatListOf() {
        final int i = 0;
        MutableFloatList mutableFloatList = new MutableFloatList(0, 1, 0);
        return mutableFloatList;
    }

    public static final androidx.collection.MutableFloatList mutableFloatListOf(float element1) {
        MutableFloatList mutableFloatList = new MutableFloatList(1);
        final int i2 = 0;
        mutableFloatList.add(element1);
        return mutableFloatList;
    }

    public static final androidx.collection.MutableFloatList mutableFloatListOf(float element1, float element2) {
        MutableFloatList mutableFloatList = new MutableFloatList(2);
        androidx.collection.MutableFloatList num = mutableFloatList;
        int i2 = 0;
        num.add(element1);
        int i3 = 0;
        num.add(element2);
        return mutableFloatList;
    }

    public static final androidx.collection.MutableFloatList mutableFloatListOf(float element1, float element2, float element3) {
        MutableFloatList mutableFloatList = new MutableFloatList(3);
        androidx.collection.MutableFloatList num = mutableFloatList;
        int i2 = 0;
        num.add(element1);
        int i3 = 0;
        num.add(element2);
        int i4 = 0;
        num.add(element3);
        return mutableFloatList;
    }

    public static final androidx.collection.MutableFloatList mutableFloatListOf(float... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = 0;
        MutableFloatList mutableFloatList = new MutableFloatList(elements.length);
        final int i2 = 0;
        mutableFloatList.plusAssign(elements);
        return mutableFloatList;
    }
}
