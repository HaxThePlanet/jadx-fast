package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B5\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u0012", d2 = {"Landroidx/compose/ui/text/TextLinkStyles;", "", "style", "Landroidx/compose/ui/text/SpanStyle;", "focusedStyle", "hoveredStyle", "pressedStyle", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/SpanStyle;)V", "getFocusedStyle", "()Landroidx/compose/ui/text/SpanStyle;", "getHoveredStyle", "getPressedStyle", "getStyle", "equals", "", "other", "hashCode", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextLinkStyles {

    public static final int $stable;
    private final androidx.compose.ui.text.SpanStyle focusedStyle;
    private final androidx.compose.ui.text.SpanStyle hoveredStyle;
    private final androidx.compose.ui.text.SpanStyle pressedStyle;
    private final androidx.compose.ui.text.SpanStyle style;
    static {
    }

    public TextLinkStyles() {
        super(0, 0, 0, 0, 15, 0);
    }

    public TextLinkStyles(androidx.compose.ui.text.SpanStyle style, androidx.compose.ui.text.SpanStyle focusedStyle, androidx.compose.ui.text.SpanStyle hoveredStyle, androidx.compose.ui.text.SpanStyle pressedStyle) {
        super();
        this.style = style;
        this.focusedStyle = focusedStyle;
        this.hoveredStyle = hoveredStyle;
        this.pressedStyle = pressedStyle;
    }

    public TextLinkStyles(androidx.compose.ui.text.SpanStyle spanStyle, androidx.compose.ui.text.SpanStyle spanStyle2, androidx.compose.ui.text.SpanStyle spanStyle3, androidx.compose.ui.text.SpanStyle spanStyle4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int obj2;
        int obj3;
        int obj4;
        int obj5;
        final int i = 0;
        obj2 = i5 & 1 != 0 ? i : obj2;
        obj3 = i5 & 2 != 0 ? i : obj3;
        obj4 = i5 & 4 != 0 ? i : obj4;
        obj5 = i5 &= 8 != 0 ? i : obj5;
        super(obj2, obj3, obj4, obj5);
    }

    public boolean equals(Object other) {
        boolean z;
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other != null) {
            if (!other instanceof TextLinkStyles) {
            } else {
                if (!Intrinsics.areEqual(this.style, obj.style)) {
                    return i2;
                }
                if (!Intrinsics.areEqual(this.focusedStyle, obj2.focusedStyle)) {
                    return i2;
                }
                if (!Intrinsics.areEqual(this.hoveredStyle, obj3.hoveredStyle)) {
                    return i2;
                }
                if (!Intrinsics.areEqual(this.pressedStyle, obj4.pressedStyle)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public final androidx.compose.ui.text.SpanStyle getFocusedStyle() {
        return this.focusedStyle;
    }

    public final androidx.compose.ui.text.SpanStyle getHoveredStyle() {
        return this.hoveredStyle;
    }

    public final androidx.compose.ui.text.SpanStyle getPressedStyle() {
        return this.pressedStyle;
    }

    public final androidx.compose.ui.text.SpanStyle getStyle() {
        return this.style;
    }

    public int hashCode() {
        int i2;
        int i;
        int i4;
        int i3;
        androidx.compose.ui.text.SpanStyle style = this.style;
        i = 0;
        if (style != null) {
            i2 = style.hashCode();
        } else {
            i2 = i;
        }
        androidx.compose.ui.text.SpanStyle focusedStyle = this.focusedStyle;
        if (focusedStyle != null) {
            i4 = focusedStyle.hashCode();
        } else {
            i4 = i;
        }
        androidx.compose.ui.text.SpanStyle hoveredStyle = this.hoveredStyle;
        if (hoveredStyle != null) {
            i3 = hoveredStyle.hashCode();
        } else {
            i3 = i;
        }
        androidx.compose.ui.text.SpanStyle pressedStyle = this.pressedStyle;
        if (pressedStyle != null) {
            i = pressedStyle.hashCode();
        }
        return result2 += i;
    }
}
