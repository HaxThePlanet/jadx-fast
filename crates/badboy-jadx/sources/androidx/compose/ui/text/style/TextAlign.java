package androidx.compose.ui.text.style;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/text/style/TextAlign;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class TextAlign {

    private static final int Center;
    public static final androidx.compose.ui.text.style.TextAlign.Companion Companion;
    private static final int End;
    private static final int Justify;
    private static final int Left;
    private static final int Right;
    private static final int Start;
    private static final int Unspecified;
    private final int value;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0010 \n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0015R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0013\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0016", d2 = {"Landroidx/compose/ui/text/style/TextAlign$Companion;", "", "()V", "Center", "Landroidx/compose/ui/text/style/TextAlign;", "getCenter-e0LSkKk", "()I", "I", "End", "getEnd-e0LSkKk", "Justify", "getJustify-e0LSkKk", "Left", "getLeft-e0LSkKk", "Right", "getRight-e0LSkKk", "Start", "getStart-e0LSkKk", "Unspecified", "getUnspecified-e0LSkKk", "values", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getCenter-e0LSkKk() {
            return TextAlign.access$getCenter$cp();
        }

        public final int getEnd-e0LSkKk() {
            return TextAlign.access$getEnd$cp();
        }

        public final int getJustify-e0LSkKk() {
            return TextAlign.access$getJustify$cp();
        }

        public final int getLeft-e0LSkKk() {
            return TextAlign.access$getLeft$cp();
        }

        public final int getRight-e0LSkKk() {
            return TextAlign.access$getRight$cp();
        }

        public final int getStart-e0LSkKk() {
            return TextAlign.access$getStart$cp();
        }

        public final int getUnspecified-e0LSkKk() {
            return TextAlign.access$getUnspecified$cp();
        }

        public final List<androidx.compose.ui.text.style.TextAlign> values() {
            androidx.compose.ui.text.style.TextAlign[] arr = new TextAlign[6];
            return CollectionsKt.listOf(TextAlign.box-impl(getLeft-e0LSkKk()), TextAlign.box-impl(getRight-e0LSkKk()), TextAlign.box-impl(getCenter-e0LSkKk()), TextAlign.box-impl(getJustify-e0LSkKk()), TextAlign.box-impl(getStart-e0LSkKk()), TextAlign.box-impl(getEnd-e0LSkKk()));
        }
    }
    static {
        TextAlign.Companion companion = new TextAlign.Companion(0);
        TextAlign.Companion = companion;
        TextAlign.Left = TextAlign.constructor-impl(1);
        TextAlign.Right = TextAlign.constructor-impl(2);
        TextAlign.Center = TextAlign.constructor-impl(3);
        TextAlign.Justify = TextAlign.constructor-impl(4);
        TextAlign.Start = TextAlign.constructor-impl(5);
        TextAlign.End = TextAlign.constructor-impl(6);
        TextAlign.Unspecified = TextAlign.constructor-impl(Integer.MIN_VALUE);
    }

    private TextAlign(int value) {
        super();
        this.value = value;
    }

    public static final int access$getCenter$cp() {
        return TextAlign.Center;
    }

    public static final int access$getEnd$cp() {
        return TextAlign.End;
    }

    public static final int access$getJustify$cp() {
        return TextAlign.Justify;
    }

    public static final int access$getLeft$cp() {
        return TextAlign.Left;
    }

    public static final int access$getRight$cp() {
        return TextAlign.Right;
    }

    public static final int access$getStart$cp() {
        return TextAlign.Start;
    }

    public static final int access$getUnspecified$cp() {
        return TextAlign.Unspecified;
    }

    public static final androidx.compose.ui.text.style.TextAlign box-impl(int i) {
        TextAlign textAlign = new TextAlign(i);
        return textAlign;
    }

    public static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof TextAlign) {
            return i3;
        }
        if (i != (TextAlign)object2.unbox-impl()) {
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
        str = TextAlign.equals-impl0(arg0, TextAlign.Left) ? "Left" : equals-impl02 ? "Right" : equals-impl03 ? "Center" : equals-impl04 ? "Justify" : equals-impl05 ? "Start" : equals-impl06 ? "End" : equals-impl07 ? "Unspecified" : "Invalid";
        return str;
    }

    public boolean equals(Object object) {
        return TextAlign.equals-impl(this.value, object);
    }

    public int hashCode() {
        return TextAlign.hashCode-impl(this.value);
    }

    public String toString() {
        return TextAlign.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
