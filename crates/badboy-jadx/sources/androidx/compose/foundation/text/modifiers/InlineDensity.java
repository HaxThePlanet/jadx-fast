package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0081@\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\u0008\u0005\u0010\u0006B\u0011\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0004\u0008\u0005\u0010\u0008B\u0011\u0008\u0002\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008\u0005\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\u0008\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\rR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\t\u0092\u0001\u00020\n¨\u0006\u001d", d2 = {"Landroidx/compose/foundation/text/modifiers/InlineDensity;", "", "density", "", "fontScale", "constructor-impl", "(FF)J", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)J", "packedValue", "", "(J)J", "getDensity-impl", "(J)F", "getFontScale-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class InlineDensity {

    public static final androidx.compose.foundation.text.modifiers.InlineDensity.Companion Companion;
    private static final long Unspecified;
    private final long packedValue;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0008", d2 = {"Landroidx/compose/foundation/text/modifiers/InlineDensity$Companion;", "", "()V", "Unspecified", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "getUnspecified-L26CHvs", "()J", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final long getUnspecified-L26CHvs() {
            return InlineDensity.access$getUnspecified$cp();
        }
    }
    static {
        InlineDensity.Companion companion = new InlineDensity.Companion(0);
        InlineDensity.Companion = companion;
        int i = 2143289344;
        InlineDensity.Unspecified = InlineDensity.constructor-impl(i, i);
    }

    private InlineDensity(long packedValue) {
        super();
        this.packedValue = packedValue;
    }

    public static final long access$getUnspecified$cp() {
        return InlineDensity.Unspecified;
    }

    public static final androidx.compose.foundation.text.modifiers.InlineDensity box-impl(long l) {
        InlineDensity inlineDensity = new InlineDensity(l, obj2);
        return inlineDensity;
    }

    public static long constructor-impl(float density, float fontScale) {
        int i = 0;
        long l = (long)floatToRawIntBits;
        return InlineDensity.constructor-impl(i3 | i4);
    }

    private static long constructor-impl(long l) {
        return l;
    }

    public static long constructor-impl(Density density) {
        return InlineDensity.constructor-impl(density.getDensity(), density.getFontScale());
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof InlineDensity) {
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

    public static final float getDensity-impl(long arg0) {
        final int i2 = 0;
        final int i6 = 0;
        return Float.intBitsToFloat((int)i4);
    }

    public static final float getFontScale-impl(long arg0) {
        final int i = 0;
        final int i4 = 0;
        return Float.intBitsToFloat((int)i2);
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    public static String toString-impl(long arg0) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("InlineDensity(density=").append(InlineDensity.getDensity-impl(arg0)).append(", fontScale=").append(InlineDensity.getFontScale-impl(arg0)).append(')').toString();
    }

    public boolean equals(Object object) {
        return InlineDensity.equals-impl(this.packedValue, obj1);
    }

    public int hashCode() {
        return InlineDensity.hashCode-impl(this.packedValue);
    }

    public String toString() {
        return InlineDensity.toString-impl(this.packedValue);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}
