package androidx.compose.ui.text.font;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\u0008\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014", d2 = {"Landroidx/compose/ui/text/font/FontStyle;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class FontStyle {

    public static final androidx.compose.ui.text.font.FontStyle.Companion Companion;
    private static final int Italic;
    private static final int Normal;
    private final int value;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010 \n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00040\rR\u001f\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R\u001f\u0010\t\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\n\u0010\u0002\u001a\u0004\u0008\u000b\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000e", d2 = {"Landroidx/compose/ui/text/font/FontStyle$Companion;", "", "()V", "Italic", "Landroidx/compose/ui/text/font/FontStyle;", "getItalic-_-LCdwA$annotations", "getItalic-_-LCdwA", "()I", "I", "Normal", "getNormal-_-LCdwA$annotations", "getNormal-_-LCdwA", "values", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getItalic-_-LCdwA$annotations() {
        }

        public static void getNormal-_-LCdwA$annotations() {
        }

        public final int getItalic-_-LCdwA() {
            return FontStyle.access$getItalic$cp();
        }

        public final int getNormal-_-LCdwA() {
            return FontStyle.access$getNormal$cp();
        }

        public final List<androidx.compose.ui.text.font.FontStyle> values() {
            androidx.compose.ui.text.font.FontStyle[] arr = new FontStyle[2];
            return CollectionsKt.listOf(FontStyle.box-impl(getNormal-_-LCdwA()), FontStyle.box-impl(getItalic-_-LCdwA()));
        }
    }
    static {
        FontStyle.Companion companion = new FontStyle.Companion(0);
        FontStyle.Companion = companion;
        FontStyle.Normal = FontStyle.constructor-impl(0);
        FontStyle.Italic = FontStyle.constructor-impl(1);
    }

    @Deprecated(message = "Please use FontStyle.Normal or FontStyle.Italic", replaceWith = @ReplaceWith(...))
    private FontStyle(int value) {
        super();
        this.value = value;
    }

    public static final int access$getItalic$cp() {
        return FontStyle.Italic;
    }

    public static final int access$getNormal$cp() {
        return FontStyle.Normal;
    }

    public static final androidx.compose.ui.text.font.FontStyle box-impl(int i) {
        FontStyle fontStyle = new FontStyle(i);
        return fontStyle;
    }

    @Deprecated(message = "Please use FontStyle.Normal or FontStyle.Italic", replaceWith = @ReplaceWith(...))
    public static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof FontStyle) {
            return i3;
        }
        if (i != (FontStyle)object2.unbox-impl()) {
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
        str = FontStyle.equals-impl0(arg0, FontStyle.Normal) ? "Normal" : equals-impl02 ? "Italic" : "Invalid";
        return str;
    }

    public boolean equals(Object object) {
        return FontStyle.equals-impl(this.value, object);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return FontStyle.hashCode-impl(this.value);
    }

    public String toString() {
        return FontStyle.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
