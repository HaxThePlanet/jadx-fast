package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0011\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 $2\u00020\u0001:\u0001$B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\u0008\u0011\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\u0008\u0013\u0010\u000bJ\u001e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0016\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\u0008\u001d\u0010\u000bJ\u001e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u001f\u0010\u0017J\u000f\u0010 \u001a\u00020!H\u0017¢\u0006\u0004\u0008\"\u0010#R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000c\u0010\tR\u001a\u0010\r\u001a\u00020\u00078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u000e\u0010\t\u001a\u0004\u0008\u000f\u0010\u000b\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006%", d2 = {"Landroidx/compose/ui/unit/IntSize;", "", "packedValue", "", "constructor-impl", "(J)J", "height", "", "getHeight$annotations", "()V", "getHeight-impl", "(J)I", "getPackedValue$annotations", "width", "getWidth$annotations", "getWidth-impl", "component1", "component1-impl", "component2", "component2-impl", "div", "other", "div-YEO4UFw", "(JI)J", "equals", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "times", "times-YEO4UFw", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class IntSize {

    public static final androidx.compose.ui.unit.IntSize.Companion Companion;
    private static final long Zero;
    private final long packedValue;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0008", d2 = {"Landroidx/compose/ui/unit/IntSize$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/unit/IntSize;", "getZero-YbymL2g", "()J", "J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final long getZero-YbymL2g() {
            return IntSize.access$getZero$cp();
        }
    }
    static {
        final int i2 = 0;
        IntSize.Companion companion = new IntSize.Companion(i2);
        IntSize.Companion = companion;
        IntSize.Zero = IntSize.constructor-impl(0);
    }

    private IntSize(long packedValue) {
        super();
        this.packedValue = packedValue;
    }

    public static final long access$getZero$cp() {
        return IntSize.Zero;
    }

    public static final androidx.compose.ui.unit.IntSize box-impl(long l) {
        IntSize intSize = new IntSize(l, obj2);
        return intSize;
    }

    public static final int component1-impl(long arg0) {
        final int i = 0;
        return IntSize.getWidth-impl(arg0);
    }

    public static final int component2-impl(long arg0) {
        final int i = 0;
        return IntSize.getHeight-impl(arg0);
    }

    public static long constructor-impl(long l) {
        return l;
    }

    public static final long div-YEO4UFw(long arg0, int other) {
        int i3 = 0;
        int i5 = 32;
        int i8 = 0;
        long l = 4294967295L;
        value$iv3 /= obj11;
        int i4 = 0;
        return IntSize.constructor-impl(i6 | i9);
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof IntSize) {
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

    public static final int getHeight-impl(long arg0) {
        final int i = 0;
        return (int)i2;
    }

    public static void getPackedValue$annotations() {
    }

    public static void getWidth$annotations() {
    }

    public static final int getWidth-impl(long arg0) {
        final int i2 = 0;
        return (int)i4;
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    public static final long times-YEO4UFw(long arg0, int other) {
        int i3 = 0;
        int i5 = 32;
        int i8 = 0;
        long l = 4294967295L;
        value$iv3 *= obj11;
        int i4 = 0;
        return IntSize.constructor-impl(i6 | i9);
    }

    public static String toString-impl(long arg0) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(IntSize.getWidth-impl(arg0)).append(" x ").append(IntSize.getHeight-impl(arg0)).toString();
    }

    public boolean equals(Object object) {
        return IntSize.equals-impl(this.packedValue, obj1);
    }

    public int hashCode() {
        return IntSize.hashCode-impl(this.packedValue);
    }

    public String toString() {
        return IntSize.toString-impl(this.packedValue);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}
