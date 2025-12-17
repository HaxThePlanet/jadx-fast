package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0010\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\u0008\u0004\u0010\u0005\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\u0008¢\u0006\u0004\u0008\u0007\u0010\u0008\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007¢\u0006\u0004\u0008\u000b\u0010\u000c\u001a\u001f\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007¢\u0006\u0004\u0008\u000e\u0010\u000f\u001a(\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\u0008¢\u0006\u0004\u0008\u0010\u0010\u0011\u001a#\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007¢\u0006\u0004\u0008\u0013\u0010\u0014\u001a\u001f\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007¢\u0006\u0004\u0008\u0016\u0010\u0017\u001a(\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\u0008¢\u0006\u0004\u0008\u0018\u0010\u0019\u001a#\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007¢\u0006\u0004\u0008\u001b\u0010\u001c\u001a\u001f\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007¢\u0006\u0004\u0008\u001e\u0010\u001f\u001a(\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\u0008¢\u0006\u0004\u0008 \u0010!\u001a#\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007¢\u0006\u0004\u0008#\u0010$\u001a\u001f\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\u0008&\u0010\u0005\u001a(\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\u0008¢\u0006\u0004\u0008'\u0010\u0008\u001a#\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007¢\u0006\u0004\u0008(\u0010\u000c\u001a\u001f\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007¢\u0006\u0004\u0008)\u0010\u000f\u001a(\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\u0008¢\u0006\u0004\u0008*\u0010\u0011\u001a#\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007¢\u0006\u0004\u0008+\u0010\u0014\u001a\u001f\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007¢\u0006\u0004\u0008,\u0010\u0017\u001a(\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\u0008¢\u0006\u0004\u0008-\u0010\u0019\u001a#\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007¢\u0006\u0004\u0008.\u0010\u001c\u001a\u001f\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007¢\u0006\u0004\u0008/\u0010\u001f\u001a(\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\u0008¢\u0006\u0004\u00080\u0010!\u001a#\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007¢\u0006\u0004\u00081\u0010$¨\u00062", d2 = {"maxOf", "Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "c", "maxOf-b33U2AM", "(BBB)B", "other", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-Kr8caGY", "minOf-b33U2AM", "minOf-Wr6uiD8", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-Md2H83M", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-R03FKyM", "minOf-5PvTz6A", "minOf-VKSA0NQ", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/comparisons/UComparisonsKt")
class UComparisonsKt___UComparisonsKt {
    public static final short maxOf-5PvTz6A(short a, short b) {
        int i;
        int i2 = 65535;
        i = Intrinsics.compare(a & i2, i2 &= b) >= 0 ? a : b;
        return i;
    }

    public static final int maxOf-J1ME1BU(int a, int b) {
        int i;
        i = Integer.compareUnsigned(a, b) >= 0 ? a : b;
        return i;
    }

    public static final byte maxOf-Kr8caGY(byte a, byte b) {
        int i;
        i = Intrinsics.compare(a & 255, b & 255) >= 0 ? a : b;
        return i;
    }

    public static final int maxOf-Md2H83M(int a, int... other) {
        int max;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(other, "other");
        max = a;
        i = 0;
        while (i < UIntArray.getSize-impl(other)) {
            max = UComparisonsKt.maxOf-J1ME1BU(max, UIntArray.get-pVg5ArA(other, i));
            i++;
        }
        return max;
    }

    public static final long maxOf-R03FKyM(long a, long... other) {
        long max;
        int i;
        long l;
        Intrinsics.checkNotNullParameter(obj8, "other");
        max = a;
        i = 0;
        while (i < ULongArray.getSize-impl(obj8)) {
            max = UComparisonsKt.maxOf-eb3DHEI(max, obj1);
            i++;
        }
        return max;
    }

    private static final short maxOf-VKSA0NQ(short a, short b, short c) {
        return UComparisonsKt.maxOf-5PvTz6A(a, UComparisonsKt.maxOf-5PvTz6A(b, c));
    }

    private static final int maxOf-WZ9TVnA(int a, int b, int c) {
        return UComparisonsKt.maxOf-J1ME1BU(a, UComparisonsKt.maxOf-J1ME1BU(b, c));
    }

    public static final byte maxOf-Wr6uiD8(byte a, byte... other) {
        byte max;
        int i;
        byte b;
        Intrinsics.checkNotNullParameter(other, "other");
        max = a;
        i = 0;
        while (i < UByteArray.getSize-impl(other)) {
            max = UComparisonsKt.maxOf-Kr8caGY(max, UByteArray.get-w2LRezQ(other, i));
            i++;
        }
        return max;
    }

    private static final byte maxOf-b33U2AM(byte a, byte b, byte c) {
        return UComparisonsKt.maxOf-Kr8caGY(a, UComparisonsKt.maxOf-Kr8caGY(b, c));
    }

    public static final long maxOf-eb3DHEI(long a, long b) {
        long l;
        l = Long.compareUnsigned(a, b) >= 0 ? a : obj4;
        return l;
    }

    private static final long maxOf-sambcqE(long a, long b, long c) {
        return UComparisonsKt.maxOf-eb3DHEI(a, b);
    }

    public static final short maxOf-t1qELG4(short a, short... other) {
        short max;
        int i;
        short s;
        Intrinsics.checkNotNullParameter(other, "other");
        max = a;
        i = 0;
        while (i < UShortArray.getSize-impl(other)) {
            max = UComparisonsKt.maxOf-5PvTz6A(max, UShortArray.get-Mh2AYeg(other, i));
            i++;
        }
        return max;
    }

    public static final short minOf-5PvTz6A(short a, short b) {
        int i;
        int i2 = 65535;
        i = Intrinsics.compare(a & i2, i2 &= b) <= 0 ? a : b;
        return i;
    }

    public static final int minOf-J1ME1BU(int a, int b) {
        int i;
        i = Integer.compareUnsigned(a, b) <= 0 ? a : b;
        return i;
    }

    public static final byte minOf-Kr8caGY(byte a, byte b) {
        int i;
        i = Intrinsics.compare(a & 255, b & 255) <= 0 ? a : b;
        return i;
    }

    public static final int minOf-Md2H83M(int a, int... other) {
        int min;
        int i2;
        int i;
        Intrinsics.checkNotNullParameter(other, "other");
        min = a;
        i2 = 0;
        while (i2 < UIntArray.getSize-impl(other)) {
            min = UComparisonsKt.minOf-J1ME1BU(min, UIntArray.get-pVg5ArA(other, i2));
            i2++;
        }
        return min;
    }

    public static final long minOf-R03FKyM(long a, long... other) {
        long min;
        int i;
        long l;
        Intrinsics.checkNotNullParameter(obj8, "other");
        min = a;
        i = 0;
        while (i < ULongArray.getSize-impl(obj8)) {
            min = UComparisonsKt.minOf-eb3DHEI(min, obj1);
            i++;
        }
        return min;
    }

    private static final short minOf-VKSA0NQ(short a, short b, short c) {
        return UComparisonsKt.minOf-5PvTz6A(a, UComparisonsKt.minOf-5PvTz6A(b, c));
    }

    private static final int minOf-WZ9TVnA(int a, int b, int c) {
        return UComparisonsKt.minOf-J1ME1BU(a, UComparisonsKt.minOf-J1ME1BU(b, c));
    }

    public static final byte minOf-Wr6uiD8(byte a, byte... other) {
        byte min;
        int i;
        byte b;
        Intrinsics.checkNotNullParameter(other, "other");
        min = a;
        i = 0;
        while (i < UByteArray.getSize-impl(other)) {
            min = UComparisonsKt.minOf-Kr8caGY(min, UByteArray.get-w2LRezQ(other, i));
            i++;
        }
        return min;
    }

    private static final byte minOf-b33U2AM(byte a, byte b, byte c) {
        return UComparisonsKt.minOf-Kr8caGY(a, UComparisonsKt.minOf-Kr8caGY(b, c));
    }

    public static final long minOf-eb3DHEI(long a, long b) {
        long l;
        l = Long.compareUnsigned(a, b) <= 0 ? a : obj4;
        return l;
    }

    private static final long minOf-sambcqE(long a, long b, long c) {
        return UComparisonsKt.minOf-eb3DHEI(a, b);
    }

    public static final short minOf-t1qELG4(short a, short... other) {
        short min;
        int i;
        short s;
        Intrinsics.checkNotNullParameter(other, "other");
        min = a;
        i = 0;
        while (i < UShortArray.getSize-impl(other)) {
            min = UComparisonsKt.minOf-5PvTz6A(min, UShortArray.get-Mh2AYeg(other, i));
            i++;
        }
        return min;
    }
}
