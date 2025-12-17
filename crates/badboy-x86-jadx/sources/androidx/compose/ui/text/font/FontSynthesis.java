package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u000c\u001a\u00020\u00072\u0008\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\u0008\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0014\u0010\n\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0017", d2 = {"Landroidx/compose/ui/text/font/FontSynthesis;", "", "value", "", "constructor-impl", "(I)I", "isStyleOn", "", "isStyleOn-impl$ui_text_release", "(I)Z", "isWeightOn", "isWeightOn-impl$ui_text_release", "equals", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class FontSynthesis {

    private static final int All;
    public static final androidx.compose.ui.text.font.FontSynthesis.Companion Companion;
    private static final int None;
    private static final int Style;
    private static final int Weight;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000e", d2 = {"Landroidx/compose/ui/text/font/FontSynthesis$Companion;", "", "()V", "All", "Landroidx/compose/ui/text/font/FontSynthesis;", "getAll-GVVA2EU", "()I", "I", "None", "getNone-GVVA2EU", "Style", "getStyle-GVVA2EU", "Weight", "getWeight-GVVA2EU", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getAll-GVVA2EU() {
            return FontSynthesis.access$getAll$cp();
        }

        public final int getNone-GVVA2EU() {
            return FontSynthesis.access$getNone$cp();
        }

        public final int getStyle-GVVA2EU() {
            return FontSynthesis.access$getStyle$cp();
        }

        public final int getWeight-GVVA2EU() {
            return FontSynthesis.access$getWeight$cp();
        }
    }
    static {
        FontSynthesis.Companion companion = new FontSynthesis.Companion(0);
        FontSynthesis.Companion = companion;
        FontSynthesis.None = FontSynthesis.constructor-impl(0);
        FontSynthesis.All = FontSynthesis.constructor-impl(1);
        FontSynthesis.Weight = FontSynthesis.constructor-impl(2);
        FontSynthesis.Style = FontSynthesis.constructor-impl(3);
    }

    private FontSynthesis(int value) {
        super();
        this.value = value;
    }

    public static final int access$getAll$cp() {
        return FontSynthesis.All;
    }

    public static final int access$getNone$cp() {
        return FontSynthesis.None;
    }

    public static final int access$getStyle$cp() {
        return FontSynthesis.Style;
    }

    public static final int access$getWeight$cp() {
        return FontSynthesis.Weight;
    }

    public static final androidx.compose.ui.text.font.FontSynthesis box-impl(int i) {
        FontSynthesis fontSynthesis = new FontSynthesis(i);
        return fontSynthesis;
    }

    public static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof FontSynthesis) {
            return i3;
        }
        if (i != (FontSynthesis)object2.unbox-impl()) {
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

    public static final boolean isStyleOn-impl$ui_text_release(int arg0) {
        int i;
        boolean equals-impl0;
        if (!FontSynthesis.equals-impl0(arg0, FontSynthesis.All)) {
            if (FontSynthesis.equals-impl0(arg0, FontSynthesis.Style)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public static final boolean isWeightOn-impl$ui_text_release(int arg0) {
        int i;
        boolean equals-impl0;
        if (!FontSynthesis.equals-impl0(arg0, FontSynthesis.All)) {
            if (FontSynthesis.equals-impl0(arg0, FontSynthesis.Weight)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public static String toString-impl(int arg0) {
        String str;
        str = FontSynthesis.equals-impl0(arg0, FontSynthesis.None) ? "None" : equals-impl02 ? "All" : equals-impl03 ? "Weight" : equals-impl04 ? "Style" : "Invalid";
        return str;
    }

    public boolean equals(Object object) {
        return FontSynthesis.equals-impl(this.value, object);
    }

    public int hashCode() {
        return FontSynthesis.hashCode-impl(this.value);
    }

    public String toString() {
        return FontSynthesis.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
