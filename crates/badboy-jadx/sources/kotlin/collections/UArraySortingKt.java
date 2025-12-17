package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00082\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\u0008\t\u0010\n\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\u0008\u000c\u0010\r\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\u0008\u000f\u0010\u0010\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\u0008\u0013\u0010\u0014\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00082\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\u0008\u0015\u0010\u0016\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\u0008\u0017\u0010\u0018\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\u0008\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\u0008\u001e\u0010\u0014\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00082\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\u0008\u001f\u0010\u0016\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\u0008 \u0010\u0018\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\u0008!\u0010\u001a¨\u0006\"", d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UArraySortingKt {
    private static final int partition--nroSd4(long[] array, int left, int right) {
        int i;
        int j;
        int compareUnsigned;
        long l;
        i = left;
        j = right;
        long l2 = ULongArray.get-s-VKNKU(array, i2 /= 2);
        while (i <= j) {
            while (Long.compareUnsigned(ULongArray.get-s-VKNKU(array, i), obj5) < 0) {
                i++;
            }
            while (Long.compareUnsigned(ULongArray.get-s-VKNKU(array, j), obj5) > 0) {
                j--;
            }
            if (i <= j) {
            }
            ULongArray.set-k8EXiF4(array, i, ULongArray.get-s-VKNKU(array, j));
            ULongArray.set-k8EXiF4(array, j, ULongArray.get-s-VKNKU(array, i));
            i++;
            j--;
            j--;
            i++;
        }
        return i;
    }

    private static final int partition-4UcCI2c(byte[] array, int left, int right) {
        int i;
        int j;
        int compare;
        int i2;
        i = left;
        j = right;
        byte b = UByteArray.get-w2LRezQ(array, i3 /= 2);
        while (i <= j) {
            while (Intrinsics.compare(b2 &= 255, b & 255) < 0) {
                i++;
            }
            while (Intrinsics.compare(b3 &= 255, b & 255) > 0) {
                j--;
            }
            if (i <= j) {
            }
            UByteArray.set-VurrAj0(array, i, UByteArray.get-w2LRezQ(array, j));
            UByteArray.set-VurrAj0(array, j, UByteArray.get-w2LRezQ(array, i));
            i++;
            j--;
            j--;
            i++;
        }
        return i;
    }

    private static final int partition-Aa5vz7o(short[] array, int left, int right) {
        int i2;
        int j;
        int compare;
        int i;
        int i3;
        i2 = left;
        j = right;
        short s = UShortArray.get-Mh2AYeg(array, i4 /= 2);
        while (i2 <= j) {
            i = 65535;
            while (Intrinsics.compare(s2 &= i, s & i) < 0) {
                i2++;
                i = 65535;
            }
            while (Intrinsics.compare(s3 &= i, s & i) > 0) {
                j--;
            }
            if (i2 <= j) {
            }
            UShortArray.set-01HTLdE(array, i2, UShortArray.get-Mh2AYeg(array, j));
            UShortArray.set-01HTLdE(array, j, UShortArray.get-Mh2AYeg(array, i2));
            i2++;
            j--;
            j--;
            i2++;
        }
        return i2;
    }

    private static final int partition-oBK06Vg(int[] array, int left, int right) {
        int i2;
        int j;
        int compareUnsigned;
        int i;
        i2 = left;
        j = right;
        int i5 = UIntArray.get-pVg5ArA(array, i3 /= 2);
        while (i2 <= j) {
            while (Integer.compareUnsigned(UIntArray.get-pVg5ArA(array, i2), i5) < 0) {
                i2++;
            }
            while (Integer.compareUnsigned(UIntArray.get-pVg5ArA(array, j), i5) > 0) {
                j--;
            }
            if (i2 <= j) {
            }
            UIntArray.set-VXSXFK8(array, i2, UIntArray.get-pVg5ArA(array, j));
            UIntArray.set-VXSXFK8(array, j, UIntArray.get-pVg5ArA(array, i2));
            i2++;
            j--;
            j--;
            i2++;
        }
        return i2;
    }

    private static final void quickSort--nroSd4(long[] array, int left, int right) {
        int i;
        final int partition--nroSd4 = UArraySortingKt.partition--nroSd4(array, left, right);
        if (left < partition--nroSd4 + -1) {
            UArraySortingKt.quickSort--nroSd4(array, left, partition--nroSd4 + -1);
        }
        if (partition--nroSd4 < right) {
            UArraySortingKt.quickSort--nroSd4(array, partition--nroSd4, right);
        }
    }

    private static final void quickSort-4UcCI2c(byte[] array, int left, int right) {
        int i;
        final int partition-4UcCI2c = UArraySortingKt.partition-4UcCI2c(array, left, right);
        if (left < partition-4UcCI2c + -1) {
            UArraySortingKt.quickSort-4UcCI2c(array, left, partition-4UcCI2c + -1);
        }
        if (partition-4UcCI2c < right) {
            UArraySortingKt.quickSort-4UcCI2c(array, partition-4UcCI2c, right);
        }
    }

    private static final void quickSort-Aa5vz7o(short[] array, int left, int right) {
        int i;
        final int partition-Aa5vz7o = UArraySortingKt.partition-Aa5vz7o(array, left, right);
        if (left < partition-Aa5vz7o + -1) {
            UArraySortingKt.quickSort-Aa5vz7o(array, left, partition-Aa5vz7o + -1);
        }
        if (partition-Aa5vz7o < right) {
            UArraySortingKt.quickSort-Aa5vz7o(array, partition-Aa5vz7o, right);
        }
    }

    private static final void quickSort-oBK06Vg(int[] array, int left, int right) {
        int i;
        final int partition-oBK06Vg = UArraySortingKt.partition-oBK06Vg(array, left, right);
        if (left < partition-oBK06Vg + -1) {
            UArraySortingKt.quickSort-oBK06Vg(array, left, partition-oBK06Vg + -1);
        }
        if (partition-oBK06Vg < right) {
            UArraySortingKt.quickSort-oBK06Vg(array, partition-oBK06Vg, right);
        }
    }

    public static final void sortArray--nroSd4(long[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        UArraySortingKt.quickSort--nroSd4(array, fromIndex, toIndex + -1);
    }

    public static final void sortArray-4UcCI2c(byte[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        UArraySortingKt.quickSort-4UcCI2c(array, fromIndex, toIndex + -1);
    }

    public static final void sortArray-Aa5vz7o(short[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        UArraySortingKt.quickSort-Aa5vz7o(array, fromIndex, toIndex + -1);
    }

    public static final void sortArray-oBK06Vg(int[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        UArraySortingKt.quickSort-oBK06Vg(array, fromIndex, toIndex + -1);
    }
}
