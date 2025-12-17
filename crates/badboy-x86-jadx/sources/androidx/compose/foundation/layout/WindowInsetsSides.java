package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u0087@\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\u0000H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u0010\u0010\u0005J\u001b\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000c\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\u0008\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0002¢\u0006\u0004\u0008\u0019\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"Landroidx/compose/foundation/layout/WindowInsetsSides;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hasAny", "sides", "hasAny-bkgdKaI$foundation_layout_release", "(II)Z", "hashCode", "hashCode-impl", "plus", "plus-gK_yJZ4", "(II)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "valueToString", "valueToString-impl", "Companion", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class WindowInsetsSides {

    private static final int AllowLeftInLtr;
    private static final int AllowLeftInRtl;
    private static final int AllowRightInLtr;
    private static final int AllowRightInRtl;
    private static final int Bottom;
    public static final androidx.compose.foundation.layout.WindowInsetsSides.Companion Companion;
    private static final int End;
    private static final int Horizontal;
    private static final int Left;
    private static final int Right;
    private static final int Start;
    private static final int Top;
    private static final int Vertical;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u001a\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u001c\u0010\u0008\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u001c\u0010\u000c\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0013\u0010\u0006R\u0019\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0015\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0017\u0010\u0006R\u0019\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0019\u0010\u0006R\u0019\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u001b\u0010\u0006R\u0019\u0010\u001c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u001d\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001e", d2 = {"Landroidx/compose/foundation/layout/WindowInsetsSides$Companion;", "", "()V", "AllowLeftInLtr", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "getAllowLeftInLtr-JoeWqyM$foundation_layout_release", "()I", "I", "AllowLeftInRtl", "getAllowLeftInRtl-JoeWqyM$foundation_layout_release", "AllowRightInLtr", "getAllowRightInLtr-JoeWqyM$foundation_layout_release", "AllowRightInRtl", "getAllowRightInRtl-JoeWqyM$foundation_layout_release", "Bottom", "getBottom-JoeWqyM", "End", "getEnd-JoeWqyM", "Horizontal", "getHorizontal-JoeWqyM", "Left", "getLeft-JoeWqyM", "Right", "getRight-JoeWqyM", "Start", "getStart-JoeWqyM", "Top", "getTop-JoeWqyM", "Vertical", "getVertical-JoeWqyM", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getAllowLeftInLtr-JoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.access$getAllowLeftInLtr$cp();
        }

        public final int getAllowLeftInRtl-JoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.access$getAllowLeftInRtl$cp();
        }

        public final int getAllowRightInLtr-JoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.access$getAllowRightInLtr$cp();
        }

        public final int getAllowRightInRtl-JoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.access$getAllowRightInRtl$cp();
        }

        public final int getBottom-JoeWqyM() {
            return WindowInsetsSides.access$getBottom$cp();
        }

        public final int getEnd-JoeWqyM() {
            return WindowInsetsSides.access$getEnd$cp();
        }

        public final int getHorizontal-JoeWqyM() {
            return WindowInsetsSides.access$getHorizontal$cp();
        }

        public final int getLeft-JoeWqyM() {
            return WindowInsetsSides.access$getLeft$cp();
        }

        public final int getRight-JoeWqyM() {
            return WindowInsetsSides.access$getRight$cp();
        }

        public final int getStart-JoeWqyM() {
            return WindowInsetsSides.access$getStart$cp();
        }

        public final int getTop-JoeWqyM() {
            return WindowInsetsSides.access$getTop$cp();
        }

        public final int getVertical-JoeWqyM() {
            return WindowInsetsSides.access$getVertical$cp();
        }
    }
    static {
        WindowInsetsSides.Companion companion = new WindowInsetsSides.Companion(0);
        WindowInsetsSides.Companion = companion;
        WindowInsetsSides.AllowLeftInLtr = WindowInsetsSides.constructor-impl(8);
        WindowInsetsSides.AllowRightInLtr = WindowInsetsSides.constructor-impl(4);
        WindowInsetsSides.AllowLeftInRtl = WindowInsetsSides.constructor-impl(2);
        WindowInsetsSides.AllowRightInRtl = WindowInsetsSides.constructor-impl(1);
        WindowInsetsSides.Start = WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.AllowLeftInLtr, WindowInsetsSides.AllowRightInRtl);
        WindowInsetsSides.End = WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.AllowRightInLtr, WindowInsetsSides.AllowLeftInRtl);
        WindowInsetsSides.Top = WindowInsetsSides.constructor-impl(16);
        WindowInsetsSides.Bottom = WindowInsetsSides.constructor-impl(32);
        WindowInsetsSides.Left = WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.AllowLeftInLtr, WindowInsetsSides.AllowLeftInRtl);
        WindowInsetsSides.Right = WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.AllowRightInLtr, WindowInsetsSides.AllowRightInRtl);
        WindowInsetsSides.Horizontal = WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.Left, WindowInsetsSides.Right);
        WindowInsetsSides.Vertical = WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.Top, WindowInsetsSides.Bottom);
    }

    private WindowInsetsSides(int value) {
        super();
        this.value = value;
    }

    public static final int access$getAllowLeftInLtr$cp() {
        return WindowInsetsSides.AllowLeftInLtr;
    }

    public static final int access$getAllowLeftInRtl$cp() {
        return WindowInsetsSides.AllowLeftInRtl;
    }

    public static final int access$getAllowRightInLtr$cp() {
        return WindowInsetsSides.AllowRightInLtr;
    }

    public static final int access$getAllowRightInRtl$cp() {
        return WindowInsetsSides.AllowRightInRtl;
    }

    public static final int access$getBottom$cp() {
        return WindowInsetsSides.Bottom;
    }

    public static final int access$getEnd$cp() {
        return WindowInsetsSides.End;
    }

    public static final int access$getHorizontal$cp() {
        return WindowInsetsSides.Horizontal;
    }

    public static final int access$getLeft$cp() {
        return WindowInsetsSides.Left;
    }

    public static final int access$getRight$cp() {
        return WindowInsetsSides.Right;
    }

    public static final int access$getStart$cp() {
        return WindowInsetsSides.Start;
    }

    public static final int access$getTop$cp() {
        return WindowInsetsSides.Top;
    }

    public static final int access$getVertical$cp() {
        return WindowInsetsSides.Vertical;
    }

    public static final androidx.compose.foundation.layout.WindowInsetsSides box-impl(int i) {
        WindowInsetsSides windowInsetsSides = new WindowInsetsSides(i);
        return windowInsetsSides;
    }

    private static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof WindowInsetsSides) {
            return i3;
        }
        if (i != (WindowInsetsSides)object2.unbox-impl()) {
            return i3;
        }
        return 1;
    }

    public static final boolean equals-impl0(int i, int i2) {
        int i3;
        i3 = i == i2 ? 1 : 0;
        return i3;
    }

    public static final boolean hasAny-bkgdKaI$foundation_layout_release(int arg0, int sides) {
        int i;
        i = arg0 & sides != 0 ? 1 : 0;
        return i;
    }

    public static int hashCode-impl(int i) {
        return Integer.hashCode(i);
    }

    public static final int plus-gK_yJZ4(int arg0, int sides) {
        return WindowInsetsSides.constructor-impl(arg0 | sides);
    }

    public static String toString-impl(int arg0) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("WindowInsetsSides(").append(WindowInsetsSides.valueToString-impl(arg0)).append(')').toString();
    }

    private static final String valueToString-impl(int arg0) {
        int str3;
        int str2;
        int str4;
        int str5;
        int str6;
        int str;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = stringBuilder;
        final int i = 0;
        if (start &= arg0 == WindowInsetsSides.Start) {
            WindowInsetsSides.valueToString_impl$lambda$0$appendPlus(sb, "Start");
        }
        if (left &= arg0 == WindowInsetsSides.Left) {
            WindowInsetsSides.valueToString_impl$lambda$0$appendPlus(sb, "Left");
        }
        if (top &= arg0 == WindowInsetsSides.Top) {
            WindowInsetsSides.valueToString_impl$lambda$0$appendPlus(sb, "Top");
        }
        if (end &= arg0 == WindowInsetsSides.End) {
            WindowInsetsSides.valueToString_impl$lambda$0$appendPlus(sb, "End");
        }
        if (right &= arg0 == WindowInsetsSides.Right) {
            WindowInsetsSides.valueToString_impl$lambda$0$appendPlus(sb, "Right");
        }
        if (bottom &= arg0 == WindowInsetsSides.Bottom) {
            WindowInsetsSides.valueToString_impl$lambda$0$appendPlus(sb, "Bottom");
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private static final void valueToString_impl$lambda$0$appendPlus(StringBuilder $this_buildString, String text) {
        int i;
        i = (CharSequence)$this_buildString.length() > 0 ? 1 : 0;
        if (i != 0) {
            $this_buildString.append('+');
        }
        $this_buildString.append(text);
    }

    public boolean equals(Object object) {
        return WindowInsetsSides.equals-impl(this.value, object);
    }

    public int hashCode() {
        return WindowInsetsSides.hashCode-impl(this.value);
    }

    public String toString() {
        return WindowInsetsSides.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
