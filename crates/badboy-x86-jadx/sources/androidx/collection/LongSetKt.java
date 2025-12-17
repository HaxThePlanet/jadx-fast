package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0010\u0016\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0007\u001a\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0011\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0080\u0008\u001a\u0006\u0010\u000c\u001a\u00020\u0007\u001a\u000e\u0010\u000c\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000b\u001a\u0016\u0010\u000c\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b\u001a\u001e\u0010\u000c\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b\u001a\u0012\u0010\u000c\u001a\u00020\u00072\n\u0010\u0010\u001a\u00020\u0001\"\u00020\u000b\u001a\u0006\u0010\u0011\u001a\u00020\u0005\u001a\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b\u001a\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b\u001a\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b\u001a\u0012\u0010\u0011\u001a\u00020\u00052\n\u0010\u0010\u001a\u00020\u0001\"\u00020\u000b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"EmptyLongArray", "", "getEmptyLongArray", "()[J", "EmptyLongSet", "Landroidx/collection/MutableLongSet;", "emptyLongSet", "Landroidx/collection/LongSet;", "hash", "", "k", "", "longSetOf", "element1", "element2", "element3", "elements", "mutableLongSetOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LongSetKt {

    private static final long[] EmptyLongArray;
    private static final androidx.collection.MutableLongSet EmptyLongSet;
    static {
        final int i = 0;
        MutableLongSet mutableLongSet = new MutableLongSet(i);
        LongSetKt.EmptyLongSet = mutableLongSet;
        LongSetKt.EmptyLongArray = new long[i];
    }

    public static final androidx.collection.LongSet emptyLongSet() {
        return (LongSet)LongSetKt.EmptyLongSet;
    }

    public static final long[] getEmptyLongArray() {
        return LongSetKt.EmptyLongArray;
    }

    public static final int hash(long k) {
        final int i = 0;
        i2 *= i4;
        return i5 ^= i3;
    }

    public static final androidx.collection.LongSet longSetOf() {
        return (LongSet)LongSetKt.EmptyLongSet;
    }

    public static final androidx.collection.LongSet longSetOf(long element1) {
        return (LongSet)LongSetKt.mutableLongSetOf(element1);
    }

    public static final androidx.collection.LongSet longSetOf(long element1, long element2) {
        return (LongSet)LongSetKt.mutableLongSetOf(element1, element2);
    }

    public static final androidx.collection.LongSet longSetOf(long element1, long element2, long element3) {
        return (LongSet)LongSetKt.mutableLongSetOf(element1, element2, element3);
    }

    public static final androidx.collection.LongSet longSetOf(long... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableLongSet mutableLongSet = new MutableLongSet(elements.length);
        final int i = 0;
        mutableLongSet.plusAssign(elements);
        return (LongSet)mutableLongSet;
    }

    public static final androidx.collection.MutableLongSet mutableLongSetOf() {
        MutableLongSet mutableLongSet = new MutableLongSet(0, 1, 0);
        return mutableLongSet;
    }

    public static final androidx.collection.MutableLongSet mutableLongSetOf(long element1) {
        MutableLongSet mutableLongSet = new MutableLongSet(1);
        final int i2 = 0;
        mutableLongSet.plusAssign(element1);
        return mutableLongSet;
    }

    public static final androidx.collection.MutableLongSet mutableLongSetOf(long element1, long element2) {
        MutableLongSet mutableLongSet = new MutableLongSet(2);
        androidx.collection.MutableLongSet num = mutableLongSet;
        final int i2 = 0;
        num.plusAssign(element1);
        num.plusAssign(obj5);
        return mutableLongSet;
    }

    public static final androidx.collection.MutableLongSet mutableLongSetOf(long element1, long element2, long element3) {
        MutableLongSet mutableLongSet = new MutableLongSet(3);
        androidx.collection.MutableLongSet num = mutableLongSet;
        final int i2 = 0;
        num.plusAssign(element1);
        num.plusAssign(element3);
        num.plusAssign(obj7);
        return mutableLongSet;
    }

    public static final androidx.collection.MutableLongSet mutableLongSetOf(long... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableLongSet mutableLongSet = new MutableLongSet(elements.length);
        final int i = 0;
        mutableLongSet.plusAssign(elements);
        return mutableLongSet;
    }
}
