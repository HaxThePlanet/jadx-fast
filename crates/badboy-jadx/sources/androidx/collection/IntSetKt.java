package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0008\u001a\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0011\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0080\u0008\u001a\u0006\u0010\u000b\u001a\u00020\u0007\u001a\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\t\u001a\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t\u001a\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t\u001a\u0012\u0010\u000b\u001a\u00020\u00072\n\u0010\u000f\u001a\u00020\u0001\"\u00020\t\u001a\u0006\u0010\u0010\u001a\u00020\u0005\u001a\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000c\u001a\u00020\t\u001a\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t\u001a\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t\u001a\u0012\u0010\u0010\u001a\u00020\u00052\n\u0010\u000f\u001a\u00020\u0001\"\u00020\t\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"EmptyIntArray", "", "getEmptyIntArray", "()[I", "EmptyIntSet", "Landroidx/collection/MutableIntSet;", "emptyIntSet", "Landroidx/collection/IntSet;", "hash", "", "k", "intSetOf", "element1", "element2", "element3", "elements", "mutableIntSetOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IntSetKt {

    private static final int[] EmptyIntArray;
    private static final androidx.collection.MutableIntSet EmptyIntSet;
    static {
        final int i = 0;
        MutableIntSet mutableIntSet = new MutableIntSet(i);
        IntSetKt.EmptyIntSet = mutableIntSet;
        IntSetKt.EmptyIntArray = new int[i];
    }

    public static final androidx.collection.IntSet emptyIntSet() {
        return (IntSet)IntSetKt.EmptyIntSet;
    }

    public static final int[] getEmptyIntArray() {
        return IntSetKt.EmptyIntArray;
    }

    public static final int hash(int k) {
        final int i = 0;
        i2 *= i4;
        return i5 ^= i3;
    }

    public static final androidx.collection.IntSet intSetOf() {
        return (IntSet)IntSetKt.EmptyIntSet;
    }

    public static final androidx.collection.IntSet intSetOf(int element1) {
        return (IntSet)IntSetKt.mutableIntSetOf(element1);
    }

    public static final androidx.collection.IntSet intSetOf(int element1, int element2) {
        return (IntSet)IntSetKt.mutableIntSetOf(element1, element2);
    }

    public static final androidx.collection.IntSet intSetOf(int element1, int element2, int element3) {
        return (IntSet)IntSetKt.mutableIntSetOf(element1, element2, element3);
    }

    public static final androidx.collection.IntSet intSetOf(int... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableIntSet mutableIntSet = new MutableIntSet(elements.length);
        final int i = 0;
        mutableIntSet.plusAssign(elements);
        return (IntSet)mutableIntSet;
    }

    public static final androidx.collection.MutableIntSet mutableIntSetOf() {
        MutableIntSet mutableIntSet = new MutableIntSet(0, 1, 0);
        return mutableIntSet;
    }

    public static final androidx.collection.MutableIntSet mutableIntSetOf(int element1) {
        MutableIntSet mutableIntSet = new MutableIntSet(1);
        final int i2 = 0;
        mutableIntSet.plusAssign(element1);
        return mutableIntSet;
    }

    public static final androidx.collection.MutableIntSet mutableIntSetOf(int element1, int element2) {
        MutableIntSet mutableIntSet = new MutableIntSet(2);
        androidx.collection.MutableIntSet set = mutableIntSet;
        final int i2 = 0;
        set.plusAssign(element1);
        set.plusAssign(element2);
        return mutableIntSet;
    }

    public static final androidx.collection.MutableIntSet mutableIntSetOf(int element1, int element2, int element3) {
        MutableIntSet mutableIntSet = new MutableIntSet(3);
        androidx.collection.MutableIntSet set = mutableIntSet;
        final int i2 = 0;
        set.plusAssign(element1);
        set.plusAssign(element2);
        set.plusAssign(element3);
        return mutableIntSet;
    }

    public static final androidx.collection.MutableIntSet mutableIntSetOf(int... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableIntSet mutableIntSet = new MutableIntSet(elements.length);
        final int i = 0;
        mutableIntSet.plusAssign(elements);
        return mutableIntSet;
    }
}
