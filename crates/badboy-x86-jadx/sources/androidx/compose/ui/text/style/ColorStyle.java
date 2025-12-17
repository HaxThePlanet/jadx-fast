package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0012\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u001a\u0010\r\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\u0008\u0010\u0010\u000f\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001f", d2 = {"Landroidx/compose/ui/text/style/ColorStyle;", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "value", "Landroidx/compose/ui/graphics/Color;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "alpha", "", "getAlpha", "()F", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "color", "getColor-0d7_KjU", "()J", "getValue-0d7_KjU", "J", "component1", "component1-0d7_KjU", "copy", "copy-8_81llA", "(J)Landroidx/compose/ui/text/style/ColorStyle;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ColorStyle implements androidx.compose.ui.text.style.TextForegroundStyle {

    private final long value;
    private ColorStyle(long value) {
        int i;
        super();
        this.value = value;
        final int i3 = 0;
        i = Long.compare(value2, i4) != 0 ? 1 : 0;
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ColorStyle value must be specified, use TextForegroundStyle.Unspecified instead.".toString());
        throw illegalArgumentException;
    }

    public ColorStyle(long l, DefaultConstructorMarker defaultConstructorMarker2) {
        super(l, defaultConstructorMarker2);
    }

    public static androidx.compose.ui.text.style.ColorStyle copy-8_81llA$default(androidx.compose.ui.text.style.ColorStyle colorStyle, long l2, int i3, Object object4) {
        long obj1;
        if (object4 &= 1 != 0) {
            obj1 = colorStyle.value;
        }
        return colorStyle.copy-8_81llA(obj1);
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public final long component1-0d7_KjU() {
        return this.value;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public final androidx.compose.ui.text.style.ColorStyle copy-8_81llA(long l) {
        ColorStyle colorStyle = new ColorStyle(l, obj4, 0);
        return colorStyle;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ColorStyle) {
            return i2;
        }
        if (!Color.equals-impl0(this.value, obj4)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public float getAlpha() {
        return Color.getAlpha-impl(getColor-0d7_KjU());
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public Brush getBrush() {
        return null;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public long getColor-0d7_KjU() {
        return this.value;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public final long getValue-0d7_KjU() {
        return this.value;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public int hashCode() {
        return Color.hashCode-impl(this.value);
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ColorStyle(value=").append(Color.toString-impl(this.value)).append(')').toString();
    }
}
