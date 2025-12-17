package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u0017\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u000c\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00052\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016R\u001c\u0010\u0002\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0017", d2 = {"Landroidx/compose/ui/text/style/TextMotion;", "", "linearity", "Landroidx/compose/ui/text/style/TextMotion$Linearity;", "subpixelTextPositioning", "", "(IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLinearity-4e0Vf04$ui_text_release", "()I", "I", "getSubpixelTextPositioning$ui_text_release", "()Z", "copy", "copy-JdDtMQo$ui_text_release", "(IZ)Landroidx/compose/ui/text/style/TextMotion;", "equals", "other", "hashCode", "", "toString", "", "Companion", "Linearity", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextMotion {

    public static final int $stable;
    private static final androidx.compose.ui.text.style.TextMotion Animated;
    public static final androidx.compose.ui.text.style.TextMotion.Companion Companion;
    private static final androidx.compose.ui.text.style.TextMotion Static;
    private final int linearity;
    private final boolean subpixelTextPositioning;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006¨\u0006\t", d2 = {"Landroidx/compose/ui/text/style/TextMotion$Companion;", "", "()V", "Animated", "Landroidx/compose/ui/text/style/TextMotion;", "getAnimated", "()Landroidx/compose/ui/text/style/TextMotion;", "Static", "getStatic", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.ui.text.style.TextMotion getAnimated() {
            return TextMotion.access$getAnimated$cp();
        }

        public final androidx.compose.ui.text.style.TextMotion getStatic() {
            return TextMotion.access$getStatic$cp();
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0081@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/text/style/TextMotion$Linearity;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class Linearity {

        public static final androidx.compose.ui.text.style.TextMotion.Linearity.Companion Companion;
        private static final int FontHinting;
        private static final int Linear;
        private static final int None;
        private final int value;
        static {
            TextMotion.Linearity.Companion companion = new TextMotion.Linearity.Companion(0);
            TextMotion.Linearity.Companion = companion;
            TextMotion.Linearity.Linear = TextMotion.Linearity.constructor-impl(1);
            TextMotion.Linearity.FontHinting = TextMotion.Linearity.constructor-impl(2);
            TextMotion.Linearity.None = TextMotion.Linearity.constructor-impl(3);
        }

        private Linearity(int value) {
            super();
            this.value = value;
        }

        public static final int access$getFontHinting$cp() {
            return TextMotion.Linearity.FontHinting;
        }

        public static final int access$getLinear$cp() {
            return TextMotion.Linearity.Linear;
        }

        public static final int access$getNone$cp() {
            return TextMotion.Linearity.None;
        }

        public static final androidx.compose.ui.text.style.TextMotion.Linearity box-impl(int i) {
            TextMotion.Linearity linearity = new TextMotion.Linearity(i);
            return linearity;
        }

        private static int constructor-impl(int i) {
            return i;
        }

        public static boolean equals-impl(int i, Object object2) {
            final int i3 = 0;
            if (!object2 instanceof TextMotion.Linearity) {
                return i3;
            }
            if (i != (TextMotion.Linearity)object2.unbox-impl()) {
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
            str = TextMotion.Linearity.equals-impl0(arg0, TextMotion.Linearity.Linear) ? "Linearity.Linear" : equals-impl02 ? "Linearity.FontHinting" : equals-impl03 ? "Linearity.None" : "Invalid";
            return str;
        }

        public boolean equals(Object object) {
            return TextMotion.Linearity.equals-impl(this.value, object);
        }

        public int hashCode() {
            return TextMotion.Linearity.hashCode-impl(this.value);
        }

        public String toString() {
            return TextMotion.Linearity.toString-impl(this.value);
        }

        public final int unbox-impl() {
            return this.value;
        }
    }
    static {
        final int i = 0;
        TextMotion.Companion companion = new TextMotion.Companion(i);
        TextMotion.Companion = companion;
        TextMotion textMotion = new TextMotion(TextMotion.Linearity.Companion.getFontHinting-4e0Vf04(), 0, i);
        TextMotion.Static = textMotion;
        TextMotion textMotion2 = new TextMotion(TextMotion.Linearity.Companion.getLinear-4e0Vf04(), 1, i);
        TextMotion.Animated = textMotion2;
    }

    private TextMotion(int linearity, boolean subpixelTextPositioning) {
        super();
        this.linearity = linearity;
        this.subpixelTextPositioning = subpixelTextPositioning;
    }

    public TextMotion(int i, boolean z2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(i, z2);
    }

    public static final androidx.compose.ui.text.style.TextMotion access$getAnimated$cp() {
        return TextMotion.Animated;
    }

    public static final androidx.compose.ui.text.style.TextMotion access$getStatic$cp() {
        return TextMotion.Static;
    }

    public static androidx.compose.ui.text.style.TextMotion copy-JdDtMQo$ui_text_release$default(androidx.compose.ui.text.style.TextMotion textMotion, int i2, boolean z3, int i4, Object object5) {
        int obj1;
        boolean obj2;
        if (i4 & 1 != 0) {
            obj1 = textMotion.linearity;
        }
        if (i4 &= 2 != 0) {
            obj2 = textMotion.subpixelTextPositioning;
        }
        return textMotion.copy-JdDtMQo$ui_text_release(obj1, obj2);
    }

    public final androidx.compose.ui.text.style.TextMotion copy-JdDtMQo$ui_text_release(int linearity, boolean subpixelTextPositioning) {
        TextMotion textMotion = new TextMotion(linearity, subpixelTextPositioning, 0);
        return textMotion;
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof TextMotion) {
            return i2;
        }
        if (!TextMotion.Linearity.equals-impl0(this.linearity, obj.linearity)) {
            return i2;
        }
        if (this.subpixelTextPositioning != obj2.subpixelTextPositioning) {
            return i2;
        }
        return i;
    }

    public final int getLinearity-4e0Vf04$ui_text_release() {
        return this.linearity;
    }

    public final boolean getSubpixelTextPositioning$ui_text_release() {
        return this.subpixelTextPositioning;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        String str;
        str = Intrinsics.areEqual(this, TextMotion.Static) ? "TextMotion.Static" : equal2 ? "TextMotion.Animated" : "Invalid";
        return str;
    }
}
