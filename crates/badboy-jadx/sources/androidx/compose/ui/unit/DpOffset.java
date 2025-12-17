package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J$\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\r\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u001b\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\u0008 \u0010\u001eJ\u000f\u0010!\u001a\u00020\"H\u0017¢\u0006\u0004\u0008#\u0010$R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0007R \u0010\u0008\u001a\u00020\t8FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008\n\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u000cR \u0010\r\u001a\u00020\t8FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008\u000e\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u000c\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006&", d2 = {"Landroidx/compose/ui/unit/DpOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "x", "Landroidx/compose/ui/unit/Dp;", "getX-D9Ej5fM$annotations", "getX-D9Ej5fM", "(J)F", "y", "getY-D9Ej5fM$annotations", "getY-D9Ej5fM", "copy", "copy-tPigGR8", "(JFF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "minus", "minus-CB-Mgk4", "(JJ)J", "plus", "plus-CB-Mgk4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class DpOffset {

    public static final androidx.compose.ui.unit.DpOffset.Companion Companion;
    private static final long Unspecified;
    private static final long Zero;
    private final long packedValue;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\n", d2 = {"Landroidx/compose/ui/unit/DpOffset$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/unit/DpOffset;", "getUnspecified-RKDOV3M", "()J", "J", "Zero", "getZero-RKDOV3M", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final long getUnspecified-RKDOV3M() {
            return DpOffset.access$getUnspecified$cp();
        }

        public final long getZero-RKDOV3M() {
            return DpOffset.access$getZero$cp();
        }
    }
    static {
        final int i2 = 0;
        DpOffset.Companion companion = new DpOffset.Companion(i2);
        DpOffset.Companion = companion;
        DpOffset.Zero = DpOffset.constructor-impl(0);
        DpOffset.Unspecified = DpOffset.constructor-impl(9205357640488583168L);
    }

    private DpOffset(long packedValue) {
        super();
        this.packedValue = packedValue;
    }

    public static final long access$getUnspecified$cp() {
        return DpOffset.Unspecified;
    }

    public static final long access$getZero$cp() {
        return DpOffset.Zero;
    }

    public static final androidx.compose.ui.unit.DpOffset box-impl(long l) {
        DpOffset dpOffset = new DpOffset(l, obj2);
        return dpOffset;
    }

    public static long constructor-impl(long l) {
        return l;
    }

    public static final long copy-tPigGR8(long arg0, float x, float y) {
        final float f2 = y;
        final int i = 0;
        return DpOffset.constructor-impl(i3 | i4);
    }

    public static long copy-tPigGR8$default(long l, float f2, float f3, int i4, Object object5) {
        float obj2;
        float obj3;
        if (object5 & 1 != 0) {
            obj2 = DpOffset.getX-D9Ej5fM(l);
        }
        if (object5 &= 2 != 0) {
            obj3 = DpOffset.getY-D9Ej5fM(l);
        }
        return DpOffset.copy-tPigGR8(l, f2, obj2);
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (obj6 instanceof DpOffset == null) {
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

    public static final float getX-D9Ej5fM(long arg0) {
        final int i3 = 0;
        final int i7 = 0;
        int i2 = 0;
        return Dp.constructor-impl(Float.intBitsToFloat((int)i5));
    }

    public static void getX-D9Ej5fM$annotations() {
    }

    public static final float getY-D9Ej5fM(long arg0) {
        final int i2 = 0;
        final int i5 = 0;
        int i = 0;
        return Dp.constructor-impl(Float.intBitsToFloat((int)i3));
    }

    public static void getY-D9Ej5fM$annotations() {
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    public static final long minus-CB-Mgk4(long arg0, long other) {
        int i = 0;
        int i4 = 0;
        float arg0$iv2 = Dp.constructor-impl(y-D9Ej5fM - y-D9Ej5fM2);
        int i2 = 0;
        return DpOffset.constructor-impl(i7 | i8);
    }

    public static final long plus-CB-Mgk4(long arg0, long other) {
        int i = 0;
        int i4 = 0;
        float arg0$iv2 = Dp.constructor-impl(y-D9Ej5fM + y-D9Ej5fM2);
        int i2 = 0;
        return DpOffset.constructor-impl(i7 | i8);
    }

    public static String toString-impl(long arg0) {
        String string;
        int i2;
        int i;
        final int i4 = 0;
        i = Long.compare(l, l2) != 0 ? 1 : 0;
        if (i != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            string = stringBuilder.append('(').append(Dp.toString-impl(DpOffset.getX-D9Ej5fM(arg0))).append(", ").append(Dp.toString-impl(DpOffset.getY-D9Ej5fM(arg0))).append(')').toString();
        } else {
            string = "DpOffset.Unspecified";
        }
        return string;
    }

    public boolean equals(Object object) {
        return DpOffset.equals-impl(this.packedValue, obj1);
    }

    public int hashCode() {
        return DpOffset.hashCode-impl(this.packedValue);
    }

    public String toString() {
        return DpOffset.toString-impl(this.packedValue);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}
