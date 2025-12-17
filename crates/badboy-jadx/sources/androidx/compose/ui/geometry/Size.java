package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u001a\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 32\u00020\u0001:\u00013B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\u0008\u0017\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\u0008\u0019\u0010\u000bJ'\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u001e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u001f\u0010 J\u001a\u0010!\u001a\u00020\"2\u0008\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008$\u0010%J\u0010\u0010&\u001a\u00020'HÖ\u0001¢\u0006\u0004\u0008(\u0010)J\u000f\u0010*\u001a\u00020\"H\u0007¢\u0006\u0004\u0008+\u0010,J\u001e\u0010-\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008.\u0010 J\u000f\u0010/\u001a\u000200H\u0016¢\u0006\u0004\u00081\u00102R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000bR\u001a\u0010\u000c\u001a\u00020\u00078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\r\u0010\t\u001a\u0004\u0008\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0010\u0010\t\u001a\u0004\u0008\u0011\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u00078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0014\u0010\t\u001a\u0004\u0008\u0015\u0010\u000b\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u00064", d2 = {"Landroidx/compose/ui/geometry/Size;", "", "packedValue", "", "constructor-impl", "(J)J", "height", "", "getHeight$annotations", "()V", "getHeight-impl", "(J)F", "maxDimension", "getMaxDimension$annotations", "getMaxDimension-impl", "minDimension", "getMinDimension$annotations", "getMinDimension-impl", "getPackedValue$annotations", "width", "getWidth$annotations", "getWidth-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-xjbvk4A", "(JFF)J", "div", "operand", "div-7Ah8Wj8", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "isEmpty", "isEmpty-impl", "(J)Z", "times", "times-7Ah8Wj8", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class Size {

    public static final androidx.compose.ui.geometry.Size.Companion Companion;
    private static final long Unspecified;
    private static final long Zero;
    private final long packedValue;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\n\u0010\u0002\u001a\u0004\u0008\u000b\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000c", d2 = {"Landroidx/compose/ui/geometry/Size$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/geometry/Size;", "getUnspecified-NH-jbRc$annotations", "getUnspecified-NH-jbRc", "()J", "J", "Zero", "getZero-NH-jbRc$annotations", "getZero-NH-jbRc", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getUnspecified-NH-jbRc$annotations() {
        }

        public static void getZero-NH-jbRc$annotations() {
        }

        public final long getUnspecified-NH-jbRc() {
            return Size.access$getUnspecified$cp();
        }

        public final long getZero-NH-jbRc() {
            return Size.access$getZero$cp();
        }
    }
    static {
        final int i2 = 0;
        Size.Companion companion = new Size.Companion(i2);
        Size.Companion = companion;
        Size.Zero = Size.constructor-impl(0);
        Size.Unspecified = Size.constructor-impl(9205357640488583168L);
    }

    private Size(long packedValue) {
        super();
        this.packedValue = packedValue;
    }

    public static final long access$getUnspecified$cp() {
        return Size.Unspecified;
    }

    public static final long access$getZero$cp() {
        return Size.Zero;
    }

    public static final androidx.compose.ui.geometry.Size box-impl(long l) {
        Size size = new Size(l, obj2);
        return size;
    }

    public static final float component1-impl(long arg0) {
        final int i = 0;
        return Size.getWidth-impl(arg0);
    }

    public static final float component2-impl(long arg0) {
        final int i = 0;
        return Size.getHeight-impl(arg0);
    }

    public static long constructor-impl(long l) {
        return l;
    }

    public static final long copy-xjbvk4A(long arg0, float width, float height) {
        int i = 0;
        long l = (long)floatToRawIntBits;
        return Size.constructor-impl(i3 | i4);
    }

    public static long copy-xjbvk4A$default(long l, float f2, float f3, int i4, Object object5) {
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
        return Size.copy-xjbvk4A(l, f2, obj6);
    }

    public static final long div-7Ah8Wj8(long arg0, float operand) {
        int cmp;
        if (Long.compare(arg0, l) == 0) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        long l2 = arg0;
        int i2 = 0;
        final int i4 = 32;
        int i8 = 0;
        int i3 = 0;
        long l4 = 4294967295L;
        int i13 = 0;
        int i = 0;
        long l3 = (long)floatToRawIntBits;
        return Size.constructor-impl(i14 | i9);
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof Size) {
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

    public static void getHeight$annotations() {
    }

    public static final float getHeight-impl(long arg0) {
        int cmp;
        if (Long.compare(arg0, l) == 0) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        final int i = 0;
        final int i4 = 0;
        return Float.intBitsToFloat((int)i2);
    }

    public static void getMaxDimension$annotations() {
    }

    public static final float getMaxDimension-impl(long arg0) {
        int cmp;
        if (Long.compare(arg0, l) == 0) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        long l2 = arg0;
        int i = 0;
        int i10 = Integer.MAX_VALUE;
        int i7 = 0;
        int i2 = 0;
        int i11 = 0;
        return Math.max(Float.intBitsToFloat((int)i5), Float.intBitsToFloat((int)i8));
    }

    public static void getMinDimension$annotations() {
    }

    public static final float getMinDimension-impl(long arg0) {
        int cmp;
        if (Long.compare(arg0, l) == 0) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        long l2 = arg0;
        int i = 0;
        int i10 = Integer.MAX_VALUE;
        int i7 = 0;
        int i2 = 0;
        int i11 = 0;
        return Math.min(Float.intBitsToFloat((int)i5), Float.intBitsToFloat((int)i8));
    }

    public static void getPackedValue$annotations() {
    }

    public static void getWidth$annotations() {
    }

    public static final float getWidth-impl(long arg0) {
        int cmp;
        if (Long.compare(arg0, l) == 0) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        final int i = 0;
        final int i5 = 0;
        return Float.intBitsToFloat((int)i3);
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    public static final boolean isEmpty-impl(long arg0) {
        int cmp;
        int i;
        if (Long.compare(arg0, l) == 0) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        i5 &= arg0;
        i = Long.compare(i11, i13) == 0 ? 1 : 0;
        return i;
    }

    public static final long times-7Ah8Wj8(long arg0, float operand) {
        int cmp;
        if (Long.compare(arg0, l) == 0) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        long l2 = arg0;
        int i2 = 0;
        final int i4 = 32;
        int i8 = 0;
        int i3 = 0;
        long l4 = 4294967295L;
        int i13 = 0;
        int i = 0;
        long l3 = (long)floatToRawIntBits;
        return Size.constructor-impl(i14 | i9);
    }

    public static String toString-impl(long arg0) {
        String string;
        int i;
        int i2;
        final int i3 = 0;
        final int i4 = 1;
        i2 = Long.compare(l, l2) != 0 ? i4 : 0;
        if (i2 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            string = stringBuilder.append("Size(").append(GeometryUtilsKt.toStringAsFixed(Size.getWidth-impl(arg0), i4)).append(", ").append(GeometryUtilsKt.toStringAsFixed(Size.getHeight-impl(arg0), i4)).append(')').toString();
        } else {
            string = "Size.Unspecified";
        }
        return string;
    }

    public boolean equals(Object object) {
        return Size.equals-impl(this.packedValue, obj1);
    }

    public int hashCode() {
        return Size.hashCode-impl(this.packedValue);
    }

    public String toString() {
        return Size.toString-impl(this.packedValue);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}
