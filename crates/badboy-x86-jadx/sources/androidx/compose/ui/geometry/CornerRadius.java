package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u0008\u0012\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u0087@\u0018\u0000 12\u00020\u0001:\u00011B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\tH\u0087\n¢\u0006\u0004\u0008\u0011\u0010\u000cJ\u0010\u0010\u0012\u001a\u00020\tH\u0087\n¢\u0006\u0004\u0008\u0013\u0010\u000cJ'\u0010\u0014\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\r\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0015\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020!HÖ\u0001¢\u0006\u0004\u0008\"\u0010#J\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\u0008%\u0010&J\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\u0008(\u0010&J\u001e\u0010)\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008*\u0010\u001aJ\u000f\u0010+\u001a\u00020,H\u0016¢\u0006\u0004\u0008-\u0010.J\u0016\u0010/\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u00080\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0007R\u001a\u0010\u0008\u001a\u00020\t8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\n\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u000cR\u001a\u0010\r\u001a\u00020\t8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u000e\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u000c\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u00062", d2 = {"Landroidx/compose/ui/geometry/CornerRadius;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "x", "", "getX$annotations", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-OHQCggk", "(JFF)J", "div", "operand", "div-Bz7bX_o", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "minus", "minus-vF7b-mM", "(JJ)J", "plus", "plus-vF7b-mM", "times", "times-Bz7bX_o", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-kKHJgLs", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class CornerRadius {

    public static final androidx.compose.ui.geometry.CornerRadius.Companion Companion;
    private static final long Zero;
    private final long packedValue;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\t", d2 = {"Landroidx/compose/ui/geometry/CornerRadius$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/geometry/CornerRadius;", "getZero-kKHJgLs$annotations", "getZero-kKHJgLs", "()J", "J", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getZero-kKHJgLs$annotations() {
        }

        public final long getZero-kKHJgLs() {
            return CornerRadius.access$getZero$cp();
        }
    }
    static {
        final int i2 = 0;
        CornerRadius.Companion companion = new CornerRadius.Companion(i2);
        CornerRadius.Companion = companion;
        int i = 0;
        CornerRadius.Zero = CornerRadiusKt.CornerRadius$default(i, i, 2, i2);
    }

    private CornerRadius(long packedValue) {
        super();
        this.packedValue = packedValue;
    }

    public static final long access$getZero$cp() {
        return CornerRadius.Zero;
    }

    public static final androidx.compose.ui.geometry.CornerRadius box-impl(long l) {
        CornerRadius cornerRadius = new CornerRadius(l, obj2);
        return cornerRadius;
    }

    public static final float component1-impl(long arg0) {
        final int i = 0;
        return CornerRadius.getX-impl(arg0);
    }

    public static final float component2-impl(long arg0) {
        final int i = 0;
        return CornerRadius.getY-impl(arg0);
    }

    public static long constructor-impl(long l) {
        return l;
    }

    public static final long copy-OHQCggk(long arg0, float x, float y) {
        return CornerRadiusKt.CornerRadius(y, obj5);
    }

    public static long copy-OHQCggk$default(long l, float f2, float f3, int i4, Object object5) {
        float obj2;
        float obj3;
        if (object5 & 1 != 0) {
            obj2 = CornerRadius.getX-impl(l);
        }
        if (object5 &= 2 != 0) {
            obj3 = CornerRadius.getY-impl(l);
        }
        return CornerRadius.copy-OHQCggk(l, f2, obj2);
    }

    public static final long div-Bz7bX_o(long arg0, float operand) {
        return CornerRadiusKt.CornerRadius(x-impl /= obj4, y-impl /= obj4);
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof CornerRadius) {
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

    public static void getPackedValue$annotations() {
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

    public static final long minus-vF7b-mM(long arg0, long other) {
        return CornerRadiusKt.CornerRadius(x-impl -= x-impl2, y-impl -= y-impl2);
    }

    public static final long plus-vF7b-mM(long arg0, long other) {
        return CornerRadiusKt.CornerRadius(x-impl += x-impl2, y-impl += y-impl2);
    }

    public static final long times-Bz7bX_o(long arg0, float operand) {
        return CornerRadiusKt.CornerRadius(x-impl *= obj4, y-impl *= obj4);
    }

    public static String toString-impl(long arg0) {
        int i;
        String string;
        String stringAsFixed;
        float y-impl;
        int i2 = 1;
        i = Float.compare(x-impl, y-impl2) == 0 ? i2 : 0;
        final int i3 = 41;
        if (i != 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            string = stringBuilder2.append("CornerRadius.circular(").append(GeometryUtilsKt.toStringAsFixed(CornerRadius.getX-impl(arg0), i2)).append(i3).toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            string = stringBuilder.append("CornerRadius.elliptical(").append(GeometryUtilsKt.toStringAsFixed(CornerRadius.getX-impl(arg0), i2)).append(", ").append(GeometryUtilsKt.toStringAsFixed(CornerRadius.getY-impl(arg0), i2)).append(i3).toString();
        }
        return string;
    }

    public static final long unaryMinus-kKHJgLs(long arg0) {
        return CornerRadiusKt.CornerRadius(-x-impl, -y-impl);
    }

    public boolean equals(Object object) {
        return CornerRadius.equals-impl(this.packedValue, obj1);
    }

    public int hashCode() {
        return CornerRadius.hashCode-impl(this.packedValue);
    }

    public String toString() {
        return CornerRadius.toString-impl(this.packedValue);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}
