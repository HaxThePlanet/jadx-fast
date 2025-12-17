package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class PlaceholderVerticalAlign {

    private static final int AboveBaseline;
    private static final int Bottom;
    private static final int Center;
    public static final androidx.compose.ui.text.PlaceholderVerticalAlign.Companion Companion;
    private static final int TextBottom;
    private static final int TextCenter;
    private static final int TextTop;
    private static final int Top;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0013\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0014", d2 = {"Landroidx/compose/ui/text/PlaceholderVerticalAlign$Companion;", "", "()V", "AboveBaseline", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "getAboveBaseline-J6kI3mc", "()I", "I", "Bottom", "getBottom-J6kI3mc", "Center", "getCenter-J6kI3mc", "TextBottom", "getTextBottom-J6kI3mc", "TextCenter", "getTextCenter-J6kI3mc", "TextTop", "getTextTop-J6kI3mc", "Top", "getTop-J6kI3mc", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getAboveBaseline-J6kI3mc() {
            return PlaceholderVerticalAlign.access$getAboveBaseline$cp();
        }

        public final int getBottom-J6kI3mc() {
            return PlaceholderVerticalAlign.access$getBottom$cp();
        }

        public final int getCenter-J6kI3mc() {
            return PlaceholderVerticalAlign.access$getCenter$cp();
        }

        public final int getTextBottom-J6kI3mc() {
            return PlaceholderVerticalAlign.access$getTextBottom$cp();
        }

        public final int getTextCenter-J6kI3mc() {
            return PlaceholderVerticalAlign.access$getTextCenter$cp();
        }

        public final int getTextTop-J6kI3mc() {
            return PlaceholderVerticalAlign.access$getTextTop$cp();
        }

        public final int getTop-J6kI3mc() {
            return PlaceholderVerticalAlign.access$getTop$cp();
        }
    }
    static {
        PlaceholderVerticalAlign.Companion companion = new PlaceholderVerticalAlign.Companion(0);
        PlaceholderVerticalAlign.Companion = companion;
        PlaceholderVerticalAlign.AboveBaseline = PlaceholderVerticalAlign.constructor-impl(1);
        PlaceholderVerticalAlign.Top = PlaceholderVerticalAlign.constructor-impl(2);
        PlaceholderVerticalAlign.Bottom = PlaceholderVerticalAlign.constructor-impl(3);
        PlaceholderVerticalAlign.Center = PlaceholderVerticalAlign.constructor-impl(4);
        PlaceholderVerticalAlign.TextTop = PlaceholderVerticalAlign.constructor-impl(5);
        PlaceholderVerticalAlign.TextBottom = PlaceholderVerticalAlign.constructor-impl(6);
        PlaceholderVerticalAlign.TextCenter = PlaceholderVerticalAlign.constructor-impl(7);
    }

    private PlaceholderVerticalAlign(int value) {
        super();
        this.value = value;
    }

    public static final int access$getAboveBaseline$cp() {
        return PlaceholderVerticalAlign.AboveBaseline;
    }

    public static final int access$getBottom$cp() {
        return PlaceholderVerticalAlign.Bottom;
    }

    public static final int access$getCenter$cp() {
        return PlaceholderVerticalAlign.Center;
    }

    public static final int access$getTextBottom$cp() {
        return PlaceholderVerticalAlign.TextBottom;
    }

    public static final int access$getTextCenter$cp() {
        return PlaceholderVerticalAlign.TextCenter;
    }

    public static final int access$getTextTop$cp() {
        return PlaceholderVerticalAlign.TextTop;
    }

    public static final int access$getTop$cp() {
        return PlaceholderVerticalAlign.Top;
    }

    public static final androidx.compose.ui.text.PlaceholderVerticalAlign box-impl(int i) {
        PlaceholderVerticalAlign placeholderVerticalAlign = new PlaceholderVerticalAlign(i);
        return placeholderVerticalAlign;
    }

    public static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof PlaceholderVerticalAlign) {
            return i3;
        }
        if (i != (PlaceholderVerticalAlign)object2.unbox-impl()) {
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

    public static String toString-impl(int arg0) {
        String str;
        str = PlaceholderVerticalAlign.equals-impl0(arg0, PlaceholderVerticalAlign.AboveBaseline) ? "AboveBaseline" : equals-impl02 ? "Top" : equals-impl03 ? "Bottom" : equals-impl04 ? "Center" : equals-impl05 ? "TextTop" : equals-impl06 ? "TextBottom" : equals-impl07 ? "TextCenter" : "Invalid";
        return str;
    }

    public boolean equals(Object object) {
        return PlaceholderVerticalAlign.equals-impl(this.value, object);
    }

    public int hashCode() {
        return PlaceholderVerticalAlign.hashCode-impl(this.value);
    }

    public String toString() {
        return PlaceholderVerticalAlign.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
