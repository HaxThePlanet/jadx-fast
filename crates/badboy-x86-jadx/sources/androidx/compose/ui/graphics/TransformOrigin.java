package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\tH\u0087\n¢\u0006\u0004\u0008\u000f\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\tH\u0087\n¢\u0006\u0004\u0008\u0011\u0010\u000bJ'\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0013\u0010\u0014J\u001a\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\u0008 \u0010!R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0008\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000b\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006#", d2 = {"Landroidx/compose/ui/graphics/TransformOrigin;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "pivotFractionX", "", "getPivotFractionX-impl", "(J)F", "pivotFractionY", "getPivotFractionY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-zey9I6w", "(JFF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class TransformOrigin {

    private static final long Center;
    public static final androidx.compose.ui.graphics.TransformOrigin.Companion Companion;
    private final long packedValue;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0008", d2 = {"Landroidx/compose/ui/graphics/TransformOrigin$Companion;", "", "()V", "Center", "Landroidx/compose/ui/graphics/TransformOrigin;", "getCenter-SzJe1aQ", "()J", "J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final long getCenter-SzJe1aQ() {
            return TransformOrigin.access$getCenter$cp();
        }
    }
    static {
        TransformOrigin.Companion companion = new TransformOrigin.Companion(0);
        TransformOrigin.Companion = companion;
        int i = 1056964608;
        TransformOrigin.Center = TransformOriginKt.TransformOrigin(i, i);
    }

    private TransformOrigin(long packedValue) {
        super();
        this.packedValue = packedValue;
    }

    public static final long access$getCenter$cp() {
        return TransformOrigin.Center;
    }

    public static final androidx.compose.ui.graphics.TransformOrigin box-impl(long l) {
        TransformOrigin transformOrigin = new TransformOrigin(l, obj2);
        return transformOrigin;
    }

    public static final float component1-impl(long arg0) {
        final int i = 0;
        return TransformOrigin.getPivotFractionX-impl(arg0);
    }

    public static final float component2-impl(long arg0) {
        final int i = 0;
        return TransformOrigin.getPivotFractionY-impl(arg0);
    }

    public static long constructor-impl(long l) {
        return l;
    }

    public static final long copy-zey9I6w(long arg0, float pivotFractionX, float pivotFractionY) {
        return TransformOriginKt.TransformOrigin(pivotFractionY, obj5);
    }

    public static long copy-zey9I6w$default(long l, float f2, float f3, int i4, Object object5) {
        float obj2;
        float obj3;
        if (object5 & 1 != 0) {
            obj2 = TransformOrigin.getPivotFractionX-impl(l);
        }
        if (object5 &= 2 != 0) {
            obj3 = TransformOrigin.getPivotFractionY-impl(l);
        }
        return TransformOrigin.copy-zey9I6w(l, f2, obj2);
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof TransformOrigin) {
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

    public static final float getPivotFractionX-impl(long arg0) {
        final int i2 = 0;
        final int i6 = 0;
        return Float.intBitsToFloat((int)i4);
    }

    public static final float getPivotFractionY-impl(long arg0) {
        final int i = 0;
        final int i4 = 0;
        return Float.intBitsToFloat((int)i2);
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    public static String toString-impl(long l) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TransformOrigin(packedValue=").append(l).append(')').toString();
    }

    public boolean equals(Object object) {
        return TransformOrigin.equals-impl(this.packedValue, obj1);
    }

    public int hashCode() {
        return TransformOrigin.hashCode-impl(this.packedValue);
    }

    public String toString() {
        return TransformOrigin.toString-impl(this.packedValue);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}
