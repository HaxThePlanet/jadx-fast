package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0008\u0002\n\u0002\u0010\u000f\n\u0002\u0008\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\u0008\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\u0008\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0000\u001a\u0002H\u0001\"\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0000\u001a\u0002H\u0001\"\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\u0008\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\u0008\u001a!\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\u0008\u001a\u001c\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\u0008\u001a\u00020\u000c\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\u0008\u001a!\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\u0008\u001a\u001c\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\u0008\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\u0008\u001a!\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\u0008\u001a\u001c\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\u0008\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\u0008\u001a!\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\u0008\u001a\u001c\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\u0008\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\u0087\u0008\u001a!\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\u0008\u001a\u001c\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\u0008\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\u0008\u001a!\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\u0008\u001a\u001c\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\u0008\u001a\u00020\u0016\"\u00020\u0015H\u0007\u001a-\u0010\u0017\u001a\u0002H\u0001\"\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0017\u001a\u0002H\u0001\"\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0017\u001a\u0002H\u0001\"\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\u0008\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\u0008\u001a!\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\u0008\u001a\u001c\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\u0008\u001a\u00020\u000c\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\u0008\u001a!\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\u0008\u001a\u001c\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\u0008\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\u0008\u001a!\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\u0008\u001a\u001c\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\u0008\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\u0008\u001a!\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\u0008\u001a\u001c\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\u0008\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\u0087\u0008\u001a!\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\u0008\u001a\u001c\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\u0008\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\u0008\u001a!\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\u0008\u001a\u001c\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\u0008\u001a\u00020\u0016\"\u00020\u0015H\u0007¨\u0006\u0018", d2 = {"maxOf", "T", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "other", "", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "", "", "", "", "", "", "minOf", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
class ComparisonsKt___ComparisonsJvmKt extends kotlin.comparisons.ComparisonsKt__ComparisonsKt {
    private static final byte maxOf(byte a, byte b) {
        return (byte)i;
    }

    private static final byte maxOf(byte a, byte b, byte c) {
        return (byte)i2;
    }

    public static final byte maxOf(byte a, byte... other) {
        int max;
        int i;
        byte b;
        int i2;
        Intrinsics.checkNotNullParameter(other, "other");
        max = a;
        i = 0;
        while (i < other.length) {
            max = (byte)i2;
            i++;
        }
        return max;
    }

    private static final double maxOf(double a, double b) {
        return Math.max(a, b);
    }

    private static final double maxOf(double a, double b, double c) {
        return Math.max(a, b);
    }

    public static final double maxOf(double a, double... other) {
        double max;
        int i;
        long l;
        Intrinsics.checkNotNullParameter(obj8, "other");
        max = a;
        i = 0;
        while (i < obj8.length) {
            max = Math.max(max, obj1);
            i++;
        }
        return max;
    }

    private static final float maxOf(float a, float b) {
        return Math.max(a, b);
    }

    private static final float maxOf(float a, float b, float c) {
        return Math.max(a, Math.max(b, c));
    }

    public static final float maxOf(float a, float... other) {
        float max;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(other, "other");
        max = a;
        i = 0;
        while (i < other.length) {
            max = Math.max(max, other[i]);
            i++;
        }
        return max;
    }

    private static final int maxOf(int a, int b) {
        return Math.max(a, b);
    }

    private static final int maxOf(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static final int maxOf(int a, int... other) {
        int max;
        int i2;
        int i;
        Intrinsics.checkNotNullParameter(other, "other");
        max = a;
        i2 = 0;
        while (i2 < other.length) {
            max = Math.max(max, other[i2]);
            i2++;
        }
        return max;
    }

    private static final long maxOf(long a, long b) {
        return Math.max(a, b);
    }

    private static final long maxOf(long a, long b, long c) {
        return Math.max(a, b);
    }

    public static final long maxOf(long a, long... other) {
        long max;
        int i;
        long l;
        Intrinsics.checkNotNullParameter(obj8, "other");
        max = a;
        i = 0;
        while (i < obj8.length) {
            max = Math.max(max, obj1);
            i++;
        }
        return max;
    }

    public static final <T extends Comparable<? super T>> T maxOf(T a, T b) {
        Object obj;
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        obj = a.compareTo(b) >= 0 ? a : b;
        return obj;
    }

    public static final <T extends Comparable<? super T>> T maxOf(T a, T b, T c) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Intrinsics.checkNotNullParameter(c, "c");
        return ComparisonsKt.maxOf(a, ComparisonsKt.maxOf(b, c));
    }

    public static final <T extends Comparable<? super T>> T maxOf(T a, T... other) {
        Object max;
        int i;
        Object obj;
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(other, "other");
        max = a;
        i = 0;
        while (i < other.length) {
            max = ComparisonsKt.maxOf(max, other[i]);
            i++;
        }
        return max;
    }

    private static final short maxOf(short a, short b) {
        return (short)i;
    }

    private static final short maxOf(short a, short b, short c) {
        return (short)i2;
    }

    public static final short maxOf(short a, short... other) {
        int max;
        int i;
        short s;
        int i2;
        Intrinsics.checkNotNullParameter(other, "other");
        max = a;
        i = 0;
        while (i < other.length) {
            max = (short)i2;
            i++;
        }
        return max;
    }

    private static final byte minOf(byte a, byte b) {
        return (byte)i;
    }

    private static final byte minOf(byte a, byte b, byte c) {
        return (byte)i2;
    }

    public static final byte minOf(byte a, byte... other) {
        int min;
        int i2;
        byte b;
        int i;
        Intrinsics.checkNotNullParameter(other, "other");
        min = a;
        i2 = 0;
        while (i2 < other.length) {
            min = (byte)i;
            i2++;
        }
        return min;
    }

    private static final double minOf(double a, double b) {
        return Math.min(a, b);
    }

    private static final double minOf(double a, double b, double c) {
        return Math.min(a, b);
    }

    public static final double minOf(double a, double... other) {
        double min;
        int i;
        long l;
        Intrinsics.checkNotNullParameter(obj8, "other");
        min = a;
        i = 0;
        while (i < obj8.length) {
            min = Math.min(min, obj1);
            i++;
        }
        return min;
    }

    private static final float minOf(float a, float b) {
        return Math.min(a, b);
    }

    private static final float minOf(float a, float b, float c) {
        return Math.min(a, Math.min(b, c));
    }

    public static final float minOf(float a, float... other) {
        float min;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(other, "other");
        min = a;
        i = 0;
        while (i < other.length) {
            min = Math.min(min, other[i]);
            i++;
        }
        return min;
    }

    private static final int minOf(int a, int b) {
        return Math.min(a, b);
    }

    private static final int minOf(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static final int minOf(int a, int... other) {
        int min;
        int i2;
        int i;
        Intrinsics.checkNotNullParameter(other, "other");
        min = a;
        i2 = 0;
        while (i2 < other.length) {
            min = Math.min(min, other[i2]);
            i2++;
        }
        return min;
    }

    private static final long minOf(long a, long b) {
        return Math.min(a, b);
    }

    private static final long minOf(long a, long b, long c) {
        return Math.min(a, b);
    }

    public static final long minOf(long a, long... other) {
        long min;
        int i;
        long l;
        Intrinsics.checkNotNullParameter(obj8, "other");
        min = a;
        i = 0;
        while (i < obj8.length) {
            min = Math.min(min, obj1);
            i++;
        }
        return min;
    }

    public static final <T extends Comparable<? super T>> T minOf(T a, T b) {
        Object obj;
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        obj = a.compareTo(b) <= 0 ? a : b;
        return obj;
    }

    public static final <T extends Comparable<? super T>> T minOf(T a, T b, T c) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Intrinsics.checkNotNullParameter(c, "c");
        return ComparisonsKt.minOf(a, ComparisonsKt.minOf(b, c));
    }

    public static final <T extends Comparable<? super T>> T minOf(T a, T... other) {
        Object min;
        int i;
        Object obj;
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(other, "other");
        min = a;
        i = 0;
        while (i < other.length) {
            min = ComparisonsKt.minOf(min, other[i]);
            i++;
        }
        return min;
    }

    private static final short minOf(short a, short b) {
        return (short)i;
    }

    private static final short minOf(short a, short b, short c) {
        return (short)i2;
    }

    public static final short minOf(short a, short... other) {
        int min;
        int i2;
        short s;
        int i;
        Intrinsics.checkNotNullParameter(other, "other");
        min = a;
        i2 = 0;
        while (i2 < other.length) {
            min = (short)i;
            i2++;
        }
        return min;
    }
}
