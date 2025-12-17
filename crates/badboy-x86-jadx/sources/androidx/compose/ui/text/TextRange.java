package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u001b\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 *2\u00020\u0001:\u0001*B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001b\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u000bH\u0086\u0002¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020\u00072\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008 \u0010!J\u0010\u0010\"\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\u0008#\u0010\rJ\u0018\u0010$\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\u0008%\u0010\u001bJ\u000f\u0010&\u001a\u00020'H\u0016¢\u0006\u0004\u0008(\u0010)R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\tR\u0011\u0010\u0016\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\r\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006+", d2 = {"Landroidx/compose/ui/text/TextRange;", "", "packedValue", "", "constructor-impl", "(J)J", "collapsed", "", "getCollapsed-impl", "(J)Z", "end", "", "getEnd-impl", "(J)I", "length", "getLength-impl", "max", "getMax-impl", "min", "getMin-impl", "reversed", "getReversed-impl", "start", "getStart-impl", "contains", "other", "contains-5zc-tL8", "(JJ)Z", "offset", "contains-impl", "(JI)Z", "equals", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "intersects", "intersects-5zc-tL8", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class TextRange {

    public static final androidx.compose.ui.text.TextRange.Companion Companion;
    private static final long Zero;
    private final long packedValue;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0008", d2 = {"Landroidx/compose/ui/text/TextRange$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/text/TextRange;", "getZero-d9O1mEE", "()J", "J", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final long getZero-d9O1mEE() {
            return TextRange.access$getZero$cp();
        }
    }
    static {
        TextRange.Companion companion = new TextRange.Companion(0);
        TextRange.Companion = companion;
        TextRange.Zero = TextRangeKt.TextRange(0);
    }

    private TextRange(long packedValue) {
        super();
        this.packedValue = packedValue;
    }

    public static final long access$getZero$cp() {
        return TextRange.Zero;
    }

    public static final androidx.compose.ui.text.TextRange box-impl(long l) {
        TextRange textRange = new TextRange(l, obj2);
        return textRange;
    }

    public static long constructor-impl(long l) {
        return l;
    }

    public static final boolean contains-5zc-tL8(long arg0, long other) {
        int min-impl;
        int i;
        int min-impl2;
        if (TextRange.getMin-impl(arg0) <= TextRange.getMin-impl(obj4) && TextRange.getMax-impl(obj4) <= TextRange.getMax-impl(arg0)) {
            i = TextRange.getMax-impl(obj4) <= TextRange.getMax-impl(arg0) ? 1 : 0;
        } else {
        }
        return i;
    }

    public static final boolean contains-impl(long arg0, int offset) {
        int i;
        i = 0;
        if (obj5 < TextRange.getMax-impl(arg0) && TextRange.getMin-impl(arg0) <= obj5) {
            if (TextRange.getMin-impl(arg0) <= obj5) {
                i = 1;
            }
        }
        return i;
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof TextRange) {
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

    public static final boolean getCollapsed-impl(long arg0) {
        int i;
        i = TextRange.getStart-impl(arg0) == TextRange.getEnd-impl(arg0) ? 1 : 0;
        return i;
    }

    public static final int getEnd-impl(long arg0) {
        final int i = 0;
        return (int)i2;
    }

    public static final int getLength-impl(long arg0) {
        return max-impl -= min-impl;
    }

    public static final int getMax-impl(long arg0) {
        int start-impl;
        if (TextRange.getStart-impl(arg0) > TextRange.getEnd-impl(arg0)) {
            start-impl = TextRange.getStart-impl(arg0);
        } else {
            start-impl = TextRange.getEnd-impl(arg0);
        }
        return start-impl;
    }

    public static final int getMin-impl(long arg0) {
        int start-impl;
        if (TextRange.getStart-impl(arg0) > TextRange.getEnd-impl(arg0)) {
            start-impl = TextRange.getEnd-impl(arg0);
        } else {
            start-impl = TextRange.getStart-impl(arg0);
        }
        return start-impl;
    }

    public static final boolean getReversed-impl(long arg0) {
        int i;
        i = TextRange.getStart-impl(arg0) > TextRange.getEnd-impl(arg0) ? 1 : 0;
        return i;
    }

    public static final int getStart-impl(long arg0) {
        final int i2 = 0;
        return (int)i4;
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    public static final boolean intersects-5zc-tL8(long arg0, long other) {
        int min-impl;
        int i;
        int max-impl;
        if (TextRange.getMin-impl(arg0) < TextRange.getMax-impl(obj4) && TextRange.getMin-impl(obj4) < TextRange.getMax-impl(arg0)) {
            i = TextRange.getMin-impl(obj4) < TextRange.getMax-impl(arg0) ? 1 : 0;
        } else {
        }
        return i;
    }

    public static String toString-impl(long arg0) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TextRange(").append(TextRange.getStart-impl(arg0)).append(", ").append(TextRange.getEnd-impl(arg0)).append(')').toString();
    }

    public boolean equals(Object object) {
        return TextRange.equals-impl(this.packedValue, obj1);
    }

    public int hashCode() {
        return TextRange.hashCode-impl(this.packedValue);
    }

    public String toString() {
        return TextRange.toString-impl(this.packedValue);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}
