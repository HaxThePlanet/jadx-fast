package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 02\u00020\u0001:\u00010B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0016\u0010\u0010\u001a\u00020\u0007H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u000bJ\u0016\u0010\u0012\u001a\u00020\u0007H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u000bJ$\u0010\u0014\u001a\u00020\u00002\u0008\u0008\u0002\u0010\r\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u001e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u001cH\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u001f2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008 \u0010!J\u0010\u0010\"\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\u0008#\u0010$J\u001b\u0010%\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\u0008&\u0010'J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\u0008)\u0010'J\u001e\u0010*\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008+\u0010\u001bJ\u001e\u0010*\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u001cH\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008+\u0010\u001dJ\u000f\u0010,\u001a\u00020-H\u0017¢\u0006\u0004\u0008.\u0010/R \u0010\u0006\u001a\u00020\u00078FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000c\u0010\tR \u0010\r\u001a\u00020\u00078FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008\u000e\u0010\t\u001a\u0004\u0008\u000f\u0010\u000b\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00061", d2 = {"Landroidx/compose/ui/unit/DpSize;", "", "packedValue", "", "constructor-impl", "(J)J", "height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM$annotations", "()V", "getHeight-D9Ej5fM", "(J)F", "getPackedValue$annotations", "width", "getWidth-D9Ej5fM$annotations", "getWidth-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "copy", "copy-DwJknco", "(JFF)J", "div", "other", "", "div-Gh9hcWk", "(JF)J", "", "(JI)J", "equals", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(J)I", "minus", "minus-e_xh8Ic", "(JJ)J", "plus", "plus-e_xh8Ic", "times", "times-Gh9hcWk", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class DpSize {

    public static final androidx.compose.ui.unit.DpSize.Companion Companion;
    private static final long Unspecified;
    private static final long Zero;
    private final long packedValue;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\n", d2 = {"Landroidx/compose/ui/unit/DpSize$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/unit/DpSize;", "getUnspecified-MYxV2XQ", "()J", "J", "Zero", "getZero-MYxV2XQ", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final long getUnspecified-MYxV2XQ() {
            return DpSize.access$getUnspecified$cp();
        }

        public final long getZero-MYxV2XQ() {
            return DpSize.access$getZero$cp();
        }
    }
    static {
        final int i2 = 0;
        DpSize.Companion companion = new DpSize.Companion(i2);
        DpSize.Companion = companion;
        DpSize.Zero = DpSize.constructor-impl(0);
        DpSize.Unspecified = DpSize.constructor-impl(9205357640488583168L);
    }

    private DpSize(long packedValue) {
        super();
        this.packedValue = packedValue;
    }

    public static final long access$getUnspecified$cp() {
        return DpSize.Unspecified;
    }

    public static final long access$getZero$cp() {
        return DpSize.Zero;
    }

    public static final androidx.compose.ui.unit.DpSize box-impl(long l) {
        DpSize dpSize = new DpSize(l, obj2);
        return dpSize;
    }

    public static final float component1-D9Ej5fM(long arg0) {
        final int i = 0;
        return DpSize.getWidth-D9Ej5fM(arg0);
    }

    public static final float component2-D9Ej5fM(long arg0) {
        final int i = 0;
        return DpSize.getHeight-D9Ej5fM(arg0);
    }

    public static long constructor-impl(long l) {
        return l;
    }

    public static final long copy-DwJknco(long arg0, float width, float height) {
        final float f2 = height;
        final int i = 0;
        return DpSize.constructor-impl(i3 | i4);
    }

    public static long copy-DwJknco$default(long l, float f2, float f3, int i4, Object object5) {
        float obj2;
        float obj3;
        if (object5 & 1 != 0) {
            obj2 = DpSize.getWidth-D9Ej5fM(l);
        }
        if (object5 &= 2 != 0) {
            obj3 = DpSize.getHeight-D9Ej5fM(l);
        }
        return DpSize.copy-DwJknco(l, f2, obj2);
    }

    public static final long div-Gh9hcWk(long arg0, float other) {
        int i = 0;
        int i3 = 0;
        float arg0$iv2 = Dp.constructor-impl(height-D9Ej5fM / obj13);
        int i4 = 0;
        return DpSize.constructor-impl(i7 | i8);
    }

    public static final long div-Gh9hcWk(long arg0, int other) {
        int i = 0;
        int i3 = 0;
        float arg0$iv2 = Dp.constructor-impl(height-D9Ej5fM / f2);
        int i4 = 0;
        return DpSize.constructor-impl(i7 | i8);
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof DpSize) {
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

    public static final float getHeight-D9Ej5fM(long arg0) {
        final int i2 = 0;
        final int i5 = 0;
        int i = 0;
        return Dp.constructor-impl(Float.intBitsToFloat((int)i3));
    }

    public static void getHeight-D9Ej5fM$annotations() {
    }

    public static void getPackedValue$annotations() {
    }

    public static final float getWidth-D9Ej5fM(long arg0) {
        final int i3 = 0;
        final int i7 = 0;
        int i2 = 0;
        return Dp.constructor-impl(Float.intBitsToFloat((int)i5));
    }

    public static void getWidth-D9Ej5fM$annotations() {
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    public static final long minus-e_xh8Ic(long arg0, long other) {
        int i = 0;
        int i4 = 0;
        float arg0$iv2 = Dp.constructor-impl(height-D9Ej5fM - height-D9Ej5fM2);
        int i2 = 0;
        return DpSize.constructor-impl(i7 | i8);
    }

    public static final long plus-e_xh8Ic(long arg0, long other) {
        int i = 0;
        int i4 = 0;
        float arg0$iv2 = Dp.constructor-impl(height-D9Ej5fM + height-D9Ej5fM2);
        int i2 = 0;
        return DpSize.constructor-impl(i7 | i8);
    }

    public static final long times-Gh9hcWk(long arg0, float other) {
        int i = 0;
        int i3 = 0;
        float arg0$iv2 = Dp.constructor-impl(height-D9Ej5fM * obj13);
        int i4 = 0;
        return DpSize.constructor-impl(i7 | i8);
    }

    public static final long times-Gh9hcWk(long arg0, int other) {
        int i = 0;
        int i3 = 0;
        float arg0$iv2 = Dp.constructor-impl(f2 *= height-D9Ej5fM);
        int i4 = 0;
        return DpSize.constructor-impl(i7 | i8);
    }

    public static String toString-impl(long arg0) {
        String string;
        String string-impl;
        int i;
        final int i2 = 0;
        i = Long.compare(l, l2) != 0 ? 1 : 0;
        if (i != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            string = stringBuilder.append(Dp.toString-impl(DpSize.getWidth-D9Ej5fM(arg0))).append(" x ").append(Dp.toString-impl(DpSize.getHeight-D9Ej5fM(arg0))).toString();
        } else {
            string = "DpSize.Unspecified";
        }
        return string;
    }

    public boolean equals(Object object) {
        return DpSize.equals-impl(this.packedValue, obj1);
    }

    public int hashCode() {
        return DpSize.hashCode-impl(this.packedValue);
    }

    public String toString() {
        return DpSize.toString-impl(this.packedValue);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}
