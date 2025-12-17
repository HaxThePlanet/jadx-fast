package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0013\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u000f\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u0087@\u0018\u0000 92\u00020\u0001:\u00019B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\u0008\u0010\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\u0008\u0012\u0010\u000bJ'\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0014\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0018\u0010\u0019J\u001a\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0007¢\u0006\u0004\u0008 \u0010\u000bJ\u000f\u0010!\u001a\u00020\u0007H\u0007¢\u0006\u0004\u0008\"\u0010\u000bJ\u0010\u0010#\u001a\u00020$HÖ\u0001¢\u0006\u0004\u0008%\u0010&J\u000f\u0010'\u001a\u00020\u001bH\u0007¢\u0006\u0004\u0008(\u0010)J\u001b\u0010*\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\u0008+\u0010,J\u001b\u0010-\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\u0008.\u0010,J\u001e\u0010/\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u00080\u0010\u0019J\u001e\u00101\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u00082\u0010\u0019J\u000f\u00103\u001a\u000204H\u0016¢\u0006\u0004\u00085\u00106J\u0016\u00107\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u00088\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000bR\u001a\u0010\u000c\u001a\u00020\u00078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\r\u0010\t\u001a\u0004\u0008\u000e\u0010\u000b\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006:", d2 = {"Landroidx/compose/ui/geometry/Offset;", "", "packedValue", "", "constructor-impl", "(J)J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-dBAh8RU", "(JFF)J", "div", "operand", "div-tuRUvjQ", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "getDistance", "getDistance-impl", "getDistanceSquared", "getDistanceSquared-impl", "hashCode", "", "hashCode-impl", "(J)I", "isValid", "isValid-impl", "(J)Z", "minus", "minus-MK-Hz9U", "(JJ)J", "plus", "plus-MK-Hz9U", "rem", "rem-tuRUvjQ", "times", "times-tuRUvjQ", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-F1C5BW0", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class Offset {

    public static final androidx.compose.ui.geometry.Offset.Companion Companion;
    private static final long Infinite;
    private static final long Unspecified;
    private static final long Zero;
    private final long packedValue;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\n\u0010\u0002\u001a\u0004\u0008\u000b\u0010\u0007R$\u0010\u000c\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\r\u0010\u0002\u001a\u0004\u0008\u000e\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000f", d2 = {"Landroidx/compose/ui/geometry/Offset$Companion;", "", "()V", "Infinite", "Landroidx/compose/ui/geometry/Offset;", "getInfinite-F1C5BW0$annotations", "getInfinite-F1C5BW0", "()J", "J", "Unspecified", "getUnspecified-F1C5BW0$annotations", "getUnspecified-F1C5BW0", "Zero", "getZero-F1C5BW0$annotations", "getZero-F1C5BW0", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getInfinite-F1C5BW0$annotations() {
        }

        public static void getUnspecified-F1C5BW0$annotations() {
        }

        public static void getZero-F1C5BW0$annotations() {
        }

        public final long getInfinite-F1C5BW0() {
            return Offset.access$getInfinite$cp();
        }

        public final long getUnspecified-F1C5BW0() {
            return Offset.access$getUnspecified$cp();
        }

        public final long getZero-F1C5BW0() {
            return Offset.access$getZero$cp();
        }
    }
    static {
        final int i2 = 0;
        Offset.Companion companion = new Offset.Companion(i2);
        Offset.Companion = companion;
        Offset.Zero = Offset.constructor-impl(0);
        Offset.Infinite = Offset.constructor-impl(9187343241974906880L);
        Offset.Unspecified = Offset.constructor-impl(9205357640488583168L);
    }

    private Offset(long packedValue) {
        super();
        this.packedValue = packedValue;
    }

    public static final long access$getInfinite$cp() {
        return Offset.Infinite;
    }

    public static final long access$getUnspecified$cp() {
        return Offset.Unspecified;
    }

    public static final long access$getZero$cp() {
        return Offset.Zero;
    }

    public static final androidx.compose.ui.geometry.Offset box-impl(long l) {
        Offset offset = new Offset(l, obj2);
        return offset;
    }

    public static final float component1-impl(long arg0) {
        final int i = 0;
        return Offset.getX-impl(arg0);
    }

    public static final float component2-impl(long arg0) {
        final int i = 0;
        return Offset.getY-impl(arg0);
    }

    public static long constructor-impl(long l) {
        return l;
    }

    public static final long copy-dBAh8RU(long arg0, float x, float y) {
        int i = 0;
        long l = (long)floatToRawIntBits;
        return Offset.constructor-impl(i3 | i4);
    }

    public static long copy-dBAh8RU$default(long l, float f2, float f3, int i4, Object object5) {
        int bits$iv$iv;
        int i;
        int i2;
        float obj6;
        float obj7;
        int obj9;
        if (object5 & 1 != 0) {
            obj6 = 0;
            i2 = 0;
            obj6 = obj9;
        }
        if (object5 &= 2 != 0) {
            obj9 = 0;
            i = 0;
            obj7 = bits$iv$iv;
        }
        return Offset.copy-dBAh8RU(l, f2, obj6);
    }

    public static final long div-tuRUvjQ(long arg0, float operand) {
        int i = arg0;
        int i3 = 0;
        final int i5 = 32;
        int i9 = 0;
        int i4 = 0;
        long l2 = 4294967295L;
        int i14 = 0;
        int i2 = 0;
        long l = (long)floatToRawIntBits;
        return Offset.constructor-impl(i15 | i10);
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (obj6 instanceof Offset == null) {
            return i2;
        }
        if (Long.compare(l, unbox-impl) != 0) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(long l, long l2) {
        int i;
        i = Long.compare(l, obj3) == 0 ? 1 : 0;
        return i;
    }

    public static final float getDistance-impl(long arg0) {
        int i = arg0;
        int i5 = 0;
        int i10 = 0;
        float bits$iv$iv = Float.intBitsToFloat((int)i8);
        int i6 = 0;
        final int i13 = 0;
        float bits$iv$iv2 = Float.intBitsToFloat((int)i11);
        final int i4 = bits$iv$iv2 * bits$iv$iv2;
        return (float)sqrt;
    }

    public static final float getDistanceSquared-impl(long arg0) {
        int i = arg0;
        int i5 = 0;
        int i10 = 0;
        float bits$iv$iv = Float.intBitsToFloat((int)i8);
        int i6 = 0;
        final int i13 = 0;
        float bits$iv$iv2 = Float.intBitsToFloat((int)i11);
        return i2 += i4;
    }

    public static void getX$annotations() {
    }

    public static final float getX-impl(long arg0) {
        final int i2 = 0;
        final int i6 = 0;
        return Float.intBitsToFloat((int)i4);
    }

    public static void getY$annotations() {
    }

    public static final float getY-impl(long arg0) {
        final int i = 0;
        final int i4 = 0;
        return Float.intBitsToFloat((int)i2);
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    public static final boolean isValid-impl(long arg0) {
        int i;
        l &= arg0;
        long l3 = -9223372034707292160L;
        i = Long.compare(i5, l3) == 0 ? 1 : 0;
        return i;
    }

    public static final long minus-MK-Hz9U(long arg0, long other) {
        int i4 = 0;
        final int i8 = 32;
        int i12 = 0;
        int i5 = 0;
        final int i16 = 0;
        int i6 = 0;
        long l2 = 4294967295L;
        int i20 = 0;
        int i7 = 0;
        final int i23 = 0;
        int i3 = 0;
        long l = (long)floatToRawIntBits;
        return Offset.constructor-impl(i24 | i15);
    }

    public static final long plus-MK-Hz9U(long arg0, long other) {
        int i4 = 0;
        final int i8 = 32;
        int i12 = 0;
        int i5 = 0;
        final int i16 = 0;
        int i6 = 0;
        long l2 = 4294967295L;
        int i20 = 0;
        int i7 = 0;
        final int i23 = 0;
        int i3 = 0;
        long l = (long)floatToRawIntBits;
        return Offset.constructor-impl(i24 | i15);
    }

    public static final long rem-tuRUvjQ(long arg0, float operand) {
        int i = arg0;
        int i3 = 0;
        final int i5 = 32;
        int i9 = 0;
        int i4 = 0;
        long l2 = 4294967295L;
        int i14 = 0;
        int i2 = 0;
        long l = (long)floatToRawIntBits;
        return Offset.constructor-impl(i15 | i10);
    }

    public static final long times-tuRUvjQ(long arg0, float operand) {
        int i = arg0;
        int i3 = 0;
        final int i5 = 32;
        int i9 = 0;
        int i4 = 0;
        long l2 = 4294967295L;
        int i14 = 0;
        int i2 = 0;
        long l = (long)floatToRawIntBits;
        return Offset.constructor-impl(i15 | i10);
    }

    public static String toString-impl(long arg0) {
        String string;
        int i;
        int i2;
        if (OffsetKt.isSpecified-k-4lQ0M(arg0)) {
            StringBuilder stringBuilder = new StringBuilder();
            i2 = 1;
            string = stringBuilder.append("Offset(").append(GeometryUtilsKt.toStringAsFixed(Offset.getX-impl(arg0), i2)).append(", ").append(GeometryUtilsKt.toStringAsFixed(Offset.getY-impl(arg0), i2)).append(')').toString();
        } else {
            string = "Offset.Unspecified";
        }
        return string;
    }

    public static final long unaryMinus-F1C5BW0(long arg0) {
        return Offset.constructor-impl(l ^= arg0);
    }

    public boolean equals(Object object) {
        return Offset.equals-impl(this.packedValue, obj1);
    }

    public int hashCode() {
        return Offset.hashCode-impl(this.packedValue);
    }

    public String toString() {
        return Offset.toString-impl(this.packedValue);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}
