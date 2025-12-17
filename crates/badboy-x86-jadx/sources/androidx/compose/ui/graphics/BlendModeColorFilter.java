package androidx.compose.ui.graphics;

import android.graphics.ColorFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0017\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B#\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0007\u001a\u00060\u0008j\u0002`\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\u0008\u000b\u0010\u000cR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0019", d2 = {"Landroidx/compose/ui/graphics/BlendModeColorFilter;", "Landroidx/compose/ui/graphics/ColorFilter;", "color", "Landroidx/compose/ui/graphics/Color;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "(JILkotlin/jvm/internal/DefaultConstructorMarker;)V", "nativeColorFilter", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "(JILandroid/graphics/ColorFilter;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBlendMode-0nO6VwU", "()I", "I", "getColor-0d7_KjU", "()J", "J", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlendModeColorFilter extends androidx.compose.ui.graphics.ColorFilter {

    private final int blendMode;
    private final long color;
    private BlendModeColorFilter(long color, int blendMode) {
        super(color, obj2, obj9, AndroidColorFilter_androidKt.actualTintColorFilter-xETnrds(color, blendMode), 0);
    }

    private BlendModeColorFilter(long color, int blendMode, ColorFilter nativeColorFilter) {
        super(obj4);
        this.color = color;
        this.blendMode = nativeColorFilter;
    }

    public BlendModeColorFilter(long l, int i2, ColorFilter colorFilter3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(l, i2, colorFilter3, defaultConstructorMarker4);
    }

    public BlendModeColorFilter(long l, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(l, i2, defaultConstructorMarker3);
    }

    @Override // androidx.compose.ui.graphics.ColorFilter
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof BlendModeColorFilter) {
            return i2;
        }
        if (!Color.equals-impl0(this.color, obj4)) {
            return i2;
        }
        if (!BlendMode.equals-impl0(this.blendMode, obj2.blendMode)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.graphics.ColorFilter
    public final int getBlendMode-0nO6VwU() {
        return this.blendMode;
    }

    @Override // androidx.compose.ui.graphics.ColorFilter
    public final long getColor-0d7_KjU() {
        return this.color;
    }

    @Override // androidx.compose.ui.graphics.ColorFilter
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.ui.graphics.ColorFilter
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("BlendModeColorFilter(color=").append(Color.toString-impl(this.color)).append(", blendMode=").append(BlendMode.toString-impl(this.blendMode)).append(')').toString();
    }
}
