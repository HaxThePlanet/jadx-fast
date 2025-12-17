package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001a", d2 = {"Landroidx/compose/ui/graphics/SolidColor;", "Landroidx/compose/ui/graphics/Brush;", "value", "Landroidx/compose/ui/graphics/Color;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-0d7_KjU", "()J", "J", "applyTo", "", "size", "Landroidx/compose/ui/geometry/Size;", "p", "Landroidx/compose/ui/graphics/Paint;", "alpha", "", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SolidColor extends androidx.compose.ui.graphics.Brush {

    private final long value;
    private SolidColor(long value) {
        super(0);
        this.value = value;
    }

    public SolidColor(long l, DefaultConstructorMarker defaultConstructorMarker2) {
        super(l, defaultConstructorMarker2);
    }

    @Override // androidx.compose.ui.graphics.Brush
    public void applyTo-Pq9zytI(long size, androidx.compose.ui.graphics.Paint p, float alpha) {
        int i;
        long copy-wmQWz5c$default;
        android.graphics.Shader shader;
        long value;
        int i5;
        long l;
        int i6;
        int i2;
        int i3;
        int i4;
        int i7 = 1065353216;
        alpha.setAlpha(i7);
        i = Float.compare(obj13, i7) == 0 ? 1 : 0;
        if (i == 0) {
            copy-wmQWz5c$default = Color.copy-wmQWz5c$default(this.value, obj2, alpha-impl * obj13, 0, 0, 0, 14);
        } else {
            copy-wmQWz5c$default = this.value;
        }
        alpha.setColor-8_81llA(copy-wmQWz5c$default);
        if (alpha.getShader() != null) {
            alpha.setShader(0);
        }
    }

    @Override // androidx.compose.ui.graphics.Brush
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof SolidColor) {
            return i2;
        }
        if (!Color.equals-impl0(this.value, obj4)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.graphics.Brush
    public final long getValue-0d7_KjU() {
        return this.value;
    }

    @Override // androidx.compose.ui.graphics.Brush
    public int hashCode() {
        return Color.hashCode-impl(this.value);
    }

    @Override // androidx.compose.ui.graphics.Brush
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SolidColor(value=").append(Color.toString-impl(this.value)).append(')').toString();
    }
}
