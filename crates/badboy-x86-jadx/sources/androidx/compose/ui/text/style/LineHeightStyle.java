package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0007\u0018\u0000 \u00152\u00020\u0001:\u0003\u0014\u0015\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000b\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0017", d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle;", "", "alignment", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "trim", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "(FILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment-PIaL0Z0", "()F", "F", "getTrim-EVpEnUU", "()I", "I", "equals", "", "other", "hashCode", "", "toString", "", "Alignment", "Companion", "Trim", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LineHeightStyle {

    public static final int $stable;
    public static final androidx.compose.ui.text.style.LineHeightStyle.Companion Companion;
    private static final androidx.compose.ui.text.style.LineHeightStyle Default;
    private final float alignment;
    private final int trim;

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u000cHÖ\u0001¢\u0006\u0004\u0008\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0014", d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "", "topRatio", "", "constructor-impl", "(F)F", "equals", "", "other", "equals-impl", "(FLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(F)I", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class Alignment {

        private static final float Bottom;
        private static final float Center;
        public static final androidx.compose.ui.text.style.LineHeightStyle.Alignment.Companion Companion;
        private static final float Proportional;
        private static final float Top;
        private final float topRatio;
        static {
            LineHeightStyle.Alignment.Companion companion = new LineHeightStyle.Alignment.Companion(0);
            LineHeightStyle.Alignment.Companion = companion;
            LineHeightStyle.Alignment.Top = LineHeightStyle.Alignment.constructor-impl(0);
            LineHeightStyle.Alignment.Center = LineHeightStyle.Alignment.constructor-impl(1056964608);
            LineHeightStyle.Alignment.Proportional = LineHeightStyle.Alignment.constructor-impl(-1082130432);
            LineHeightStyle.Alignment.Bottom = LineHeightStyle.Alignment.constructor-impl(1065353216);
        }

        private Alignment(float topRatio) {
            super();
            this.topRatio = topRatio;
        }

        public static final float access$getBottom$cp() {
            return LineHeightStyle.Alignment.Bottom;
        }

        public static final float access$getCenter$cp() {
            return LineHeightStyle.Alignment.Center;
        }

        public static final float access$getProportional$cp() {
            return LineHeightStyle.Alignment.Proportional;
        }

        public static final float access$getTop$cp() {
            return LineHeightStyle.Alignment.Top;
        }

        public static final androidx.compose.ui.text.style.LineHeightStyle.Alignment box-impl(float f) {
            LineHeightStyle.Alignment alignment = new LineHeightStyle.Alignment(f);
            return alignment;
        }

        public static float constructor-impl(float topRatio) {
            int cmp;
            int i2;
            int i;
            i = 1;
            final int i7 = 0;
            if (Float.compare(i3, topRatio) <= 0 && Float.compare(topRatio, i4) <= 0) {
                i2 = Float.compare(topRatio, i4) <= 0 ? i : i7;
            } else {
            }
            if (i2 == 0) {
                i2 = Float.compare(topRatio, i6) == 0 ? i : i7;
                if (i2 != 0) {
                } else {
                    i = i7;
                }
            }
            if (i == 0) {
            } else {
                return topRatio;
            }
            int i5 = 0;
            IllegalStateException illegalStateException = new IllegalStateException("topRatio should be in [0..1] range or -1".toString());
            throw illegalStateException;
        }

        public static boolean equals-impl(float f, Object object2) {
            final int i2 = 0;
            if (!object2 instanceof LineHeightStyle.Alignment) {
                return i2;
            }
            if (Float.compare(f, (LineHeightStyle.Alignment)object2.unbox-impl()) != 0) {
                return i2;
            }
            return 1;
        }

        public static final boolean equals-impl0(float f, float f2) {
            int i;
            i = Float.compare(f, f2) == 0 ? 1 : 0;
            return i;
        }

        public static int hashCode-impl(float f) {
            return Float.hashCode(f);
        }

        public static String toString-impl(float arg0) {
            int i4;
            String string;
            int i2;
            int i3;
            int i;
            i = 1;
            final int i5 = 0;
            i4 = Float.compare(arg0, top) == 0 ? i : i5;
            if (i4 != 0) {
                string = "LineHeightStyle.Alignment.Top";
            } else {
                i2 = Float.compare(arg0, center) == 0 ? i : i5;
                if (i2 != 0) {
                    string = "LineHeightStyle.Alignment.Center";
                } else {
                    i3 = Float.compare(arg0, proportional) == 0 ? i : i5;
                    if (i3 != 0) {
                        string = "LineHeightStyle.Alignment.Proportional";
                    } else {
                        if (Float.compare(arg0, bottom) == 0) {
                        } else {
                            i = i5;
                        }
                        if (i != 0) {
                            string = "LineHeightStyle.Alignment.Bottom";
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            string = stringBuilder.append("LineHeightStyle.Alignment(topPercentage = ").append(arg0).append(')').toString();
                        }
                    }
                }
            }
            return string;
        }

        public boolean equals(Object object) {
            return LineHeightStyle.Alignment.equals-impl(this.topRatio, object);
        }

        public int hashCode() {
            return LineHeightStyle.Alignment.hashCode-impl(this.topRatio);
        }

        public String toString() {
            return LineHeightStyle.Alignment.toString-impl(this.topRatio);
        }

        public final float unbox-impl() {
            return this.topRatio;
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/style/LineHeightStyle;", "getDefault", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.ui.text.style.LineHeightStyle getDefault() {
            return LineHeightStyle.access$getDefault$cp();
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0000¢\u0006\u0004\u0008\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\u0008\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0017", d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isTrimFirstLineTop", "isTrimFirstLineTop-impl$ui_text_release", "(I)Z", "isTrimLastLineBottom", "isTrimLastLineBottom-impl$ui_text_release", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class Trim {

        private static final int Both = 0;
        public static final androidx.compose.ui.text.style.LineHeightStyle.Trim.Companion Companion = null;
        private static final int FirstLineTop = 0;
        private static final int FlagTrimBottom = 16;
        private static final int FlagTrimTop = 1;
        private static final int LastLineBottom;
        private static final int None;
        private final int value;
        static {
            LineHeightStyle.Trim.Companion companion = new LineHeightStyle.Trim.Companion(0);
            LineHeightStyle.Trim.Companion = companion;
            LineHeightStyle.Trim.FirstLineTop = LineHeightStyle.Trim.constructor-impl(1);
            LineHeightStyle.Trim.LastLineBottom = LineHeightStyle.Trim.constructor-impl(16);
            LineHeightStyle.Trim.Both = LineHeightStyle.Trim.constructor-impl(17);
            LineHeightStyle.Trim.None = LineHeightStyle.Trim.constructor-impl(0);
        }

        private Trim(int value) {
            super();
            this.value = value;
        }

        public static final int access$getBoth$cp() {
            return LineHeightStyle.Trim.Both;
        }

        public static final int access$getFirstLineTop$cp() {
            return LineHeightStyle.Trim.FirstLineTop;
        }

        public static final int access$getLastLineBottom$cp() {
            return LineHeightStyle.Trim.LastLineBottom;
        }

        public static final int access$getNone$cp() {
            return LineHeightStyle.Trim.None;
        }

        public static final androidx.compose.ui.text.style.LineHeightStyle.Trim box-impl(int i) {
            LineHeightStyle.Trim trim = new LineHeightStyle.Trim(i);
            return trim;
        }

        private static int constructor-impl(int i) {
            return i;
        }

        public static boolean equals-impl(int i, Object object2) {
            final int i3 = 0;
            if (!object2 instanceof LineHeightStyle.Trim) {
                return i3;
            }
            if (i != (LineHeightStyle.Trim)object2.unbox-impl()) {
                return i3;
            }
            return 1;
        }

        public static final boolean equals-impl0(int i, int i2) {
            int i3;
            i3 = i == i2 ? 1 : 0;
            return i3;
        }

        public static int hashCode-impl(int i) {
            return Integer.hashCode(i);
        }

        public static final boolean isTrimFirstLineTop-impl$ui_text_release(int arg0) {
            int i;
            i = arg0 & 1 > 0 ? 1 : 0;
            return i;
        }

        public static final boolean isTrimLastLineBottom-impl$ui_text_release(int arg0) {
            int i;
            i = arg0 & 16 > 0 ? 1 : 0;
            return i;
        }

        public static String toString-impl(int arg0) {
            String str;
            str = arg0 == LineHeightStyle.Trim.FirstLineTop ? "LineHeightStyle.Trim.FirstLineTop" : arg0 == lastLineBottom ? "LineHeightStyle.Trim.LastLineBottom" : arg0 == both ? "LineHeightStyle.Trim.Both" : arg0 == none ? "LineHeightStyle.Trim.None" : "Invalid";
            return str;
        }

        public boolean equals(Object object) {
            return LineHeightStyle.Trim.equals-impl(this.value, object);
        }

        public int hashCode() {
            return LineHeightStyle.Trim.hashCode-impl(this.value);
        }

        public String toString() {
            return LineHeightStyle.Trim.toString-impl(this.value);
        }

        public final int unbox-impl() {
            return this.value;
        }
    }
    static {
        final int i = 0;
        LineHeightStyle.Companion companion = new LineHeightStyle.Companion(i);
        LineHeightStyle.Companion = companion;
        LineHeightStyle lineHeightStyle = new LineHeightStyle(LineHeightStyle.Alignment.Companion.getProportional-PIaL0Z0(), LineHeightStyle.Trim.Companion.getBoth-EVpEnUU(), i);
        LineHeightStyle.Default = lineHeightStyle;
    }

    private LineHeightStyle(float alignment, int trim) {
        super();
        this.alignment = alignment;
        this.trim = trim;
    }

    public LineHeightStyle(float f, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(f, i2);
    }

    public static final androidx.compose.ui.text.style.LineHeightStyle access$getDefault$cp() {
        return LineHeightStyle.Default;
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof LineHeightStyle) {
            return i2;
        }
        if (!LineHeightStyle.Alignment.equals-impl0(this.alignment, obj.alignment)) {
            return i2;
        }
        if (!LineHeightStyle.Trim.equals-impl0(this.trim, obj2.trim)) {
            return i2;
        }
        return i;
    }

    public final float getAlignment-PIaL0Z0() {
        return this.alignment;
    }

    public final int getTrim-EVpEnUU() {
        return this.trim;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("LineHeightStyle(alignment=").append(LineHeightStyle.Alignment.toString-impl(this.alignment)).append(", trim=").append(LineHeightStyle.Trim.toString-impl(this.trim)).append(')').toString();
    }
}
