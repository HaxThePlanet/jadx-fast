package androidx.compose.ui.layout;

import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u0008\u0012\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 *2\u00020\u0001:\u0001*B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\tH\u0087\n¢\u0006\u0004\u0008\u0011\u0010\u000cJ\u0010\u0010\u0012\u001a\u00020\tH\u0087\n¢\u0006\u0004\u0008\u0013\u0010\u000cJ'\u0010\u0014\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\r\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0015\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020!HÖ\u0001¢\u0006\u0004\u0008\"\u0010#J\u001e\u0010$\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008%\u0010\u001aJ\u000f\u0010&\u001a\u00020'H\u0016¢\u0006\u0004\u0008(\u0010)R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0007R\u001a\u0010\u0008\u001a\u00020\t8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\n\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u000cR\u001a\u0010\r\u001a\u00020\t8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u000e\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u000c\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006+", d2 = {"Landroidx/compose/ui/layout/ScaleFactor;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "scaleX", "", "getScaleX$annotations", "getScaleX-impl", "(J)F", "scaleY", "getScaleY$annotations", "getScaleY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-8GGzs04", "(JFF)J", "div", "operand", "div-44nBxM0", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "times", "times-44nBxM0", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class ScaleFactor {

    public static final androidx.compose.ui.layout.ScaleFactor.Companion Companion;
    private static final long Unspecified;
    private final long packedValue;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\t", d2 = {"Landroidx/compose/ui/layout/ScaleFactor$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/layout/ScaleFactor;", "getUnspecified-_hLwfpc$annotations", "getUnspecified-_hLwfpc", "()J", "J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getUnspecified-_hLwfpc$annotations() {
        }

        public final long getUnspecified-_hLwfpc() {
            return ScaleFactor.access$getUnspecified$cp();
        }
    }
    static {
        ScaleFactor.Companion companion = new ScaleFactor.Companion(0);
        ScaleFactor.Companion = companion;
        int i = 2143289344;
        ScaleFactor.Unspecified = ScaleFactorKt.ScaleFactor(i, i);
    }

    private ScaleFactor(long packedValue) {
        super();
        this.packedValue = packedValue;
    }

    public static final long access$getUnspecified$cp() {
        return ScaleFactor.Unspecified;
    }

    public static final androidx.compose.ui.layout.ScaleFactor box-impl(long l) {
        ScaleFactor scaleFactor = new ScaleFactor(l, obj2);
        return scaleFactor;
    }

    public static final float component1-impl(long arg0) {
        final int i = 0;
        return ScaleFactor.getScaleX-impl(arg0);
    }

    public static final float component2-impl(long arg0) {
        final int i = 0;
        return ScaleFactor.getScaleY-impl(arg0);
    }

    public static long constructor-impl(long l) {
        return l;
    }

    public static final long copy-8GGzs04(long arg0, float scaleX, float scaleY) {
        return ScaleFactorKt.ScaleFactor(scaleY, obj5);
    }

    public static long copy-8GGzs04$default(long l, float f2, float f3, int i4, Object object5) {
        float obj2;
        float obj3;
        if (object5 & 1 != 0) {
            obj2 = ScaleFactor.getScaleX-impl(l);
        }
        if (object5 &= 2 != 0) {
            obj3 = ScaleFactor.getScaleY-impl(l);
        }
        return ScaleFactor.copy-8GGzs04(l, f2, obj2);
    }

    public static final long div-44nBxM0(long arg0, float operand) {
        return ScaleFactorKt.ScaleFactor(scaleX-impl /= obj4, scaleY-impl /= obj4);
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof ScaleFactor) {
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

    public static void getScaleX$annotations() {
    }

    public static final float getScaleX-impl(long arg0) {
        int i;
        String str;
        i = Long.compare(arg0, unspecified) != 0 ? 1 : 0;
        final int i2 = 0;
        if (i == 0) {
            int i4 = 0;
            InlineClassHelperKt.throwIllegalStateException("ScaleFactor is unspecified");
        }
        int i3 = 0;
        final int i8 = 0;
        return Float.intBitsToFloat((int)i6);
    }

    public static void getScaleY$annotations() {
    }

    public static final float getScaleY-impl(long arg0) {
        int i;
        String str;
        i = Long.compare(arg0, unspecified) != 0 ? 1 : 0;
        final int i2 = 0;
        if (i == 0) {
            int i4 = 0;
            InlineClassHelperKt.throwIllegalStateException("ScaleFactor is unspecified");
        }
        int i3 = 0;
        final int i7 = 0;
        return Float.intBitsToFloat((int)i5);
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    public static final long times-44nBxM0(long arg0, float operand) {
        return ScaleFactorKt.ScaleFactor(scaleX-impl *= obj4, scaleY-impl *= obj4);
    }

    public static String toString-impl(long arg0) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ScaleFactor(").append(ScaleFactorKt.access$roundToTenths(ScaleFactor.getScaleX-impl(arg0))).append(", ").append(ScaleFactorKt.access$roundToTenths(ScaleFactor.getScaleY-impl(arg0))).append(')').toString();
    }

    public boolean equals(Object object) {
        return ScaleFactor.equals-impl(this.packedValue, obj1);
    }

    public int hashCode() {
        return ScaleFactor.hashCode-impl(this.packedValue);
    }

    public String toString() {
        return ScaleFactor.toString-impl(this.packedValue);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}
