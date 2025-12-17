package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ShaderBrush;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u001a\u0010\r\u001a\u00020\u000e8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001e", d2 = {"Landroidx/compose/ui/text/style/BrushStyle;", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "value", "Landroidx/compose/ui/graphics/ShaderBrush;", "alpha", "", "(Landroidx/compose/ui/graphics/ShaderBrush;F)V", "getAlpha", "()F", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "getValue", "()Landroidx/compose/ui/graphics/ShaderBrush;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BrushStyle implements androidx.compose.ui.text.style.TextForegroundStyle {

    private final float alpha;
    private final ShaderBrush value;
    public BrushStyle(ShaderBrush value, float alpha) {
        super();
        this.value = value;
        this.alpha = alpha;
    }

    public static androidx.compose.ui.text.style.BrushStyle copy$default(androidx.compose.ui.text.style.BrushStyle brushStyle, ShaderBrush shaderBrush2, float f3, int i4, Object object5) {
        ShaderBrush obj1;
        float obj2;
        if (i4 & 1 != 0) {
            obj1 = brushStyle.value;
        }
        if (i4 &= 2 != 0) {
            obj2 = brushStyle.alpha;
        }
        return brushStyle.copy(obj1, obj2);
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public final ShaderBrush component1() {
        return this.value;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public final float component2() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public final androidx.compose.ui.text.style.BrushStyle copy(ShaderBrush shaderBrush, float f2) {
        BrushStyle brushStyle = new BrushStyle(shaderBrush, f2);
        return brushStyle;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof BrushStyle) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.value, obj.value)) {
            return i2;
        }
        if (Float.compare(this.alpha, obj.alpha) != 0) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public Brush getBrush() {
        return (Brush)this.value;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public long getColor-0d7_KjU() {
        return Color.Companion.getUnspecified-0d7_KjU();
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public final ShaderBrush getValue() {
        return this.value;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("BrushStyle(value=").append(this.value).append(", alpha=").append(this.alpha).append(')').toString();
    }
}
