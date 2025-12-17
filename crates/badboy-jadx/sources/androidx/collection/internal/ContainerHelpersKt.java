package androidx.collection.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u001a \u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\tH\u0000\u001a \u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\rH\u0000\u001a\u001c\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0000\u001a\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0000\u001a\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0000\u001a\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0000X\u0081\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0016", d2 = {"EMPTY_INTS", "", "EMPTY_LONGS", "", "EMPTY_OBJECTS", "", "", "[Ljava/lang/Object;", "binarySearch", "", "array", "size", "value", "", "equal", "", "a", "b", "idealByteArraySize", "need", "idealIntArraySize", "idealLongArraySize", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContainerHelpersKt {

    public static final int[] EMPTY_INTS;
    public static final long[] EMPTY_LONGS;
    public static final Object[] EMPTY_OBJECTS;
    static {
        int i = 0;
        ContainerHelpersKt.EMPTY_INTS = new int[i];
        ContainerHelpersKt.EMPTY_LONGS = new long[i];
        ContainerHelpersKt.EMPTY_OBJECTS = new Object[i];
    }

    public static final int binarySearch(int[] array, int size, int value) {
        int lo;
        int hi;
        int i2;
        int i;
        Intrinsics.checkNotNullParameter(array, "array");
        lo = 0;
        hi = size + -1;
        while (lo <= hi) {
            i3 >>>= 1;
            i = array[i2];
            hi = i2 + -1;
            lo = i2 + 1;
        }
        return ~lo;
    }

    public static final int binarySearch(long[] array, int size, long value) {
        int lo;
        int hi;
        int i;
        long l;
        int cmp;
        Intrinsics.checkNotNullParameter(array, "array");
        lo = 0;
        hi = size + -1;
        while (lo <= hi) {
            i2 >>>= 1;
            l = array[i];
            hi = i + -1;
            lo = i + 1;
        }
        return ~lo;
    }

    public static final boolean equal(Object a, Object b) {
        return Intrinsics.areEqual(a, b);
    }

    public static final int idealByteArraySize(int need) {
        int i;
        int i2;
        int i3;
        i = 4;
        while (i < 32) {
            i2 = 1;
            i++;
        }
        return need;
    }

    public static final int idealIntArraySize(int need) {
        return idealByteArraySize /= 4;
    }

    public static final int idealLongArraySize(int need) {
        return idealByteArraySize /= 8;
    }
}
