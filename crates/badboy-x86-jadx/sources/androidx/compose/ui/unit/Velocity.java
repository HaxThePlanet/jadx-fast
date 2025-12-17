package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0013\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u000c\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u0087@\u0018\u0000 22\u00020\u0001:\u00012B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\u0008\u0010\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\u0008\u0012\u0010\u000bJ'\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0014\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0018\u0010\u0019J\u001a\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020 HÖ\u0001¢\u0006\u0004\u0008!\u0010\"J\u001b\u0010#\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\u0008$\u0010%J\u001b\u0010&\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\u0008'\u0010%J\u001e\u0010(\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008)\u0010\u0019J\u001e\u0010*\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008+\u0010\u0019J\u000f\u0010,\u001a\u00020-H\u0016¢\u0006\u0004\u0008.\u0010/J\u0016\u00100\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u00081\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000bR\u001a\u0010\u000c\u001a\u00020\u00078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\r\u0010\t\u001a\u0004\u0008\u000e\u0010\u000b\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u00063", d2 = {"Landroidx/compose/ui/unit/Velocity;", "", "packedValue", "", "constructor-impl", "(J)J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-OhffZ5M", "(JFF)J", "div", "operand", "div-adjELrA", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "minus", "minus-AH228Gc", "(JJ)J", "plus", "plus-AH228Gc", "rem", "rem-adjELrA", "times", "times-adjELrA", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-9UxMQ8M", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class Velocity {

    public static final androidx.compose.ui.unit.Velocity.Companion Companion;
    private static final long Zero;
    private final long packedValue;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\t", d2 = {"Landroidx/compose/ui/unit/Velocity$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/unit/Velocity;", "getZero-9UxMQ8M$annotations", "getZero-9UxMQ8M", "()J", "J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getZero-9UxMQ8M$annotations() {
        }

        public final long getZero-9UxMQ8M() {
            return Velocity.access$getZero$cp();
        }
    }
    static {
        final int i2 = 0;
        Velocity.Companion companion = new Velocity.Companion(i2);
        Velocity.Companion = companion;
        Velocity.Zero = Velocity.constructor-impl(0);
    }

    private Velocity(long packedValue) {
        super();
        this.packedValue = packedValue;
    }

    public static final long access$getZero$cp() {
        return Velocity.Zero;
    }

    public static final androidx.compose.ui.unit.Velocity box-impl(long l) {
        Velocity velocity = new Velocity(l, obj2);
        return velocity;
    }

    public static final float component1-impl(long arg0) {
        final int i = 0;
        return Velocity.getX-impl(arg0);
    }

    public static final float component2-impl(long arg0) {
        final int i = 0;
        return Velocity.getY-impl(arg0);
    }

    public static long constructor-impl(long l) {
        return l;
    }

    public static final long copy-OhffZ5M(long arg0, float x, float y) {
        int i = 0;
        long l = (long)floatToRawIntBits;
        return Velocity.constructor-impl(i3 | i4);
    }

    public static long copy-OhffZ5M$default(long l, float f2, float f3, int i4, Object object5) {
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
        return Velocity.copy-OhffZ5M(l, f2, obj6);
    }

    public static final long div-adjELrA(long arg0, float operand) {
        int i = arg0;
        int i3 = 0;
        final int i5 = 32;
        int i9 = 0;
        int i4 = 0;
        long l2 = 4294967295L;
        int i14 = 0;
        int i2 = 0;
        long l = (long)floatToRawIntBits;
        return Velocity.constructor-impl(i15 | i10);
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof Velocity) {
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

    public static final long minus-AH228Gc(long arg0, long other) {
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
        return Velocity.constructor-impl(i24 | i15);
    }

    public static final long plus-AH228Gc(long arg0, long other) {
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
        return Velocity.constructor-impl(i24 | i15);
    }

    public static final long rem-adjELrA(long arg0, float operand) {
        int i = arg0;
        int i3 = 0;
        final int i5 = 32;
        int i9 = 0;
        int i4 = 0;
        long l2 = 4294967295L;
        int i14 = 0;
        int i2 = 0;
        long l = (long)floatToRawIntBits;
        return Velocity.constructor-impl(i15 | i10);
    }

    public static final long times-adjELrA(long arg0, float operand) {
        int i = arg0;
        int i3 = 0;
        final int i5 = 32;
        int i9 = 0;
        int i4 = 0;
        long l2 = 4294967295L;
        int i14 = 0;
        int i2 = 0;
        long l = (long)floatToRawIntBits;
        return Velocity.constructor-impl(i15 | i10);
    }

    public static String toString-impl(long arg0) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append('(').append(Velocity.getX-impl(arg0)).append(", ").append(Velocity.getY-impl(arg0)).append(") px/sec").toString();
    }

    public static final long unaryMinus-9UxMQ8M(long arg0) {
        return Velocity.constructor-impl(l ^= arg0);
    }

    public boolean equals(Object object) {
        return Velocity.equals-impl(this.packedValue, obj1);
    }

    public int hashCode() {
        return Velocity.hashCode-impl(this.packedValue);
    }

    public String toString() {
        return Velocity.toString-impl(this.packedValue);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}
