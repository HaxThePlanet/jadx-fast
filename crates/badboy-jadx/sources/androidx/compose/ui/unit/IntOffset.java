package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u000f\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0010\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u0087@\u0018\u0000 32\u00020\u0001:\u00013B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\tH\u0087\n¢\u0006\u0004\u0008\u0011\u0010\u000cJ\u0010\u0010\u0012\u001a\u00020\tH\u0087\n¢\u0006\u0004\u0008\u0013\u0010\u000cJ'\u0010\u0014\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\r\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0015\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u001a\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u001f\u0010 J\u0010\u0010!\u001a\u00020\tHÖ\u0001¢\u0006\u0004\u0008\"\u0010\u000cJ\u001b\u0010#\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\u0008$\u0010%J\u001b\u0010&\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\u0008'\u0010%J\u001e\u0010(\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008)\u0010*J\u001e\u0010+\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008,\u0010\u001bJ\u000f\u0010-\u001a\u00020.H\u0017¢\u0006\u0004\u0008/\u00100J\u0016\u00101\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u00082\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0007R\u001a\u0010\u0008\u001a\u00020\t8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\n\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u000cR\u001a\u0010\r\u001a\u00020\t8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u000e\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u000c\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u00064", d2 = {"Landroidx/compose/ui/unit/IntOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "x", "", "getX$annotations", "getX-impl", "(J)I", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-iSbpLlY", "(JII)J", "div", "operand", "", "div-Bjo55l4", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "minus", "minus-qkQi6aY", "(JJ)J", "plus", "plus-qkQi6aY", "rem", "rem-Bjo55l4", "(JI)J", "times", "times-Bjo55l4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-nOcc-ac", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class IntOffset {

    public static final androidx.compose.ui.unit.IntOffset.Companion Companion;
    private static final long Zero;
    private final long packedValue;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0008", d2 = {"Landroidx/compose/ui/unit/IntOffset$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/unit/IntOffset;", "getZero-nOcc-ac", "()J", "J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final long getZero-nOcc-ac() {
            return IntOffset.access$getZero$cp();
        }
    }
    static {
        final int i2 = 0;
        IntOffset.Companion companion = new IntOffset.Companion(i2);
        IntOffset.Companion = companion;
        IntOffset.Zero = IntOffset.constructor-impl(0);
    }

    private IntOffset(long packedValue) {
        super();
        this.packedValue = packedValue;
    }

    public static final long access$getZero$cp() {
        return IntOffset.Zero;
    }

    public static final androidx.compose.ui.unit.IntOffset box-impl(long l) {
        IntOffset intOffset = new IntOffset(l, obj2);
        return intOffset;
    }

    public static final int component1-impl(long arg0) {
        final int i = 0;
        return IntOffset.getX-impl(arg0);
    }

    public static final int component2-impl(long arg0) {
        final int i = 0;
        return IntOffset.getY-impl(arg0);
    }

    public static long constructor-impl(long l) {
        return l;
    }

    public static final long copy-iSbpLlY(long arg0, int x, int y) {
        int i = 0;
        l <<= i3;
        return IntOffset.constructor-impl(i2 | i4);
    }

    public static long copy-iSbpLlY$default(long l, int i2, int i3, int i4, Object object5) {
        int i5;
        int i;
        int obj6;
        int obj7;
        int obj9;
        if (object5 & 1 != 0) {
            obj6 = 0;
            obj6 = (int)i;
        }
        if (object5 &= 2 != 0) {
            obj9 = 0;
            obj7 = (int)i5;
        }
        return IntOffset.copy-iSbpLlY(l, i2, obj6);
    }

    public static final long div-Bjo55l4(long arg0, float operand) {
        int i5 = 0;
        int i8 = 32;
        int i3 = 0;
        int i11 = 0;
        long l = 4294967295L;
        int i6 = 0;
        int $this$fastRoundToInt$iv2 = Math.round(value$iv4 /= obj11);
        int i7 = 0;
        return IntOffset.constructor-impl(i9 | i12);
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (obj6 instanceof IntOffset == null) {
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

    public static final int getX-impl(long arg0) {
        final int i2 = 0;
        return (int)i4;
    }

    public static void getY$annotations() {
    }

    public static final int getY-impl(long arg0) {
        final int i = 0;
        return (int)i2;
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    public static final long minus-qkQi6aY(long arg0, long other) {
        int i6 = 0;
        int i9 = 32;
        int i12 = 0;
        int i13 = 0;
        long l = 4294967295L;
        int i7 = 0;
        value$iv3 -= $i$f$unpackInt2;
        int i8 = 0;
        return IntOffset.constructor-impl(i10 | i15);
    }

    public static final long plus-qkQi6aY(long arg0, long other) {
        int i6 = 0;
        int i9 = 32;
        int i12 = 0;
        int i13 = 0;
        long l = 4294967295L;
        int i7 = 0;
        value$iv3 += $i$f$unpackInt2;
        int i8 = 0;
        return IntOffset.constructor-impl(i10 | i15);
    }

    public static final long rem-Bjo55l4(long arg0, int operand) {
        int i3 = 0;
        int i5 = 32;
        int i8 = 0;
        long l = 4294967295L;
        value$iv3 %= obj11;
        int i4 = 0;
        return IntOffset.constructor-impl(i6 | i9);
    }

    public static final long times-Bjo55l4(long arg0, float operand) {
        int i5 = 0;
        int i8 = 32;
        int i3 = 0;
        int i11 = 0;
        long l = 4294967295L;
        int i6 = 0;
        int $this$fastRoundToInt$iv2 = Math.round(value$iv4 *= obj11);
        int i7 = 0;
        return IntOffset.constructor-impl(i9 | i12);
    }

    public static String toString-impl(long arg0) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append('(').append(IntOffset.getX-impl(arg0)).append(", ").append(IntOffset.getY-impl(arg0)).append(')').toString();
    }

    public static final long unaryMinus-nOcc-ac(long arg0) {
        int i3 = 0;
        int i5 = 32;
        int i8 = 0;
        long l = 4294967295L;
        int value$iv4 = -value$iv3;
        int i4 = 0;
        return IntOffset.constructor-impl(i6 | i9);
    }

    public boolean equals(Object object) {
        return IntOffset.equals-impl(this.packedValue, obj1);
    }

    public int hashCode() {
        return IntOffset.hashCode-impl(this.packedValue);
    }

    public String toString() {
        return IntOffset.toString-impl(this.packedValue);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}
