package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u001a\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0006\u0010\u0008\u001a\u00020\u0007\u001a\u000e\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n\u001a\u0016\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n\u001a\u001e\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\n\u001a\u0012\u0010\u0008\u001a\u00020\u00072\n\u0010\r\u001a\u00020\u0001\"\u00020\n\u001a\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0080\u0008\u001a\u0006\u0010\u0011\u001a\u00020\u0005\u001a\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n\u001a\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n\u001a\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\n\u001a\u0012\u0010\u0011\u001a\u00020\u00052\n\u0010\r\u001a\u00020\u0001\"\u00020\n\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"EmptyFloatArray", "", "getEmptyFloatArray", "()[F", "EmptyFloatSet", "Landroidx/collection/MutableFloatSet;", "emptyFloatSet", "Landroidx/collection/FloatSet;", "floatSetOf", "element1", "", "element2", "element3", "elements", "hash", "", "k", "mutableFloatSetOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FloatSetKt {

    private static final float[] EmptyFloatArray;
    private static final androidx.collection.MutableFloatSet EmptyFloatSet;
    static {
        final int i = 0;
        MutableFloatSet mutableFloatSet = new MutableFloatSet(i);
        FloatSetKt.EmptyFloatSet = mutableFloatSet;
        FloatSetKt.EmptyFloatArray = new float[i];
    }

    public static final androidx.collection.FloatSet emptyFloatSet() {
        return (FloatSet)FloatSetKt.EmptyFloatSet;
    }

    public static final androidx.collection.FloatSet floatSetOf() {
        return (FloatSet)FloatSetKt.EmptyFloatSet;
    }

    public static final androidx.collection.FloatSet floatSetOf(float element1) {
        return (FloatSet)FloatSetKt.mutableFloatSetOf(element1);
    }

    public static final androidx.collection.FloatSet floatSetOf(float element1, float element2) {
        return (FloatSet)FloatSetKt.mutableFloatSetOf(element1, element2);
    }

    public static final androidx.collection.FloatSet floatSetOf(float element1, float element2, float element3) {
        return (FloatSet)FloatSetKt.mutableFloatSetOf(element1, element2, element3);
    }

    public static final androidx.collection.FloatSet floatSetOf(float... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableFloatSet mutableFloatSet = new MutableFloatSet(elements.length);
        final int i = 0;
        mutableFloatSet.plusAssign(elements);
        return (FloatSet)mutableFloatSet;
    }

    public static final float[] getEmptyFloatArray() {
        return FloatSetKt.EmptyFloatArray;
    }

    public static final int hash(float k) {
        final int i = 0;
        i2 *= i4;
        return i5 ^= i3;
    }

    public static final androidx.collection.MutableFloatSet mutableFloatSetOf() {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(0, 1, 0);
        return mutableFloatSet;
    }

    public static final androidx.collection.MutableFloatSet mutableFloatSetOf(float element1) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(1);
        final int i2 = 0;
        mutableFloatSet.plusAssign(element1);
        return mutableFloatSet;
    }

    public static final androidx.collection.MutableFloatSet mutableFloatSetOf(float element1, float element2) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(2);
        androidx.collection.MutableFloatSet num = mutableFloatSet;
        final int i2 = 0;
        num.plusAssign(element1);
        num.plusAssign(element2);
        return mutableFloatSet;
    }

    public static final androidx.collection.MutableFloatSet mutableFloatSetOf(float element1, float element2, float element3) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(3);
        androidx.collection.MutableFloatSet num = mutableFloatSet;
        final int i2 = 0;
        num.plusAssign(element1);
        num.plusAssign(element2);
        num.plusAssign(element3);
        return mutableFloatSet;
    }

    public static final androidx.collection.MutableFloatSet mutableFloatSetOf(float... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableFloatSet mutableFloatSet = new MutableFloatSet(elements.length);
        final int i = 0;
        mutableFloatSet.plusAssign(elements);
        return mutableFloatSet;
    }
}
