package androidx.compose.ui.graphics;

import android.graphics.ColorFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0017\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B#\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\u0008¢\u0006\u0002\u0010\tJ\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000bR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\r\u0010\u000b\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0016", d2 = {"Landroidx/compose/ui/graphics/LightingColorFilter;", "Landroidx/compose/ui/graphics/ColorFilter;", "multiply", "Landroidx/compose/ui/graphics/Color;", "add", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "nativeColorFilter", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "(JJLandroid/graphics/ColorFilter;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdd-0d7_KjU", "()J", "J", "getMultiply-0d7_KjU", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LightingColorFilter extends androidx.compose.ui.graphics.ColorFilter {

    private final long add;
    private final long multiply;
    private LightingColorFilter(long multiply, long add) {
        super(multiply, obj2, obj10, obj4, AndroidColorFilter_androidKt.actualLightingColorFilter--OWjLjI(multiply, add), 0);
    }

    private LightingColorFilter(long multiply, long add, ColorFilter nativeColorFilter) {
        super(obj5);
        this.multiply = multiply;
        this.add = nativeColorFilter;
    }

    public LightingColorFilter(long l, long l2, ColorFilter colorFilter3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(l, l2, colorFilter3, defaultConstructorMarker4, obj5);
    }

    public LightingColorFilter(long l, long l2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(l, l2, defaultConstructorMarker3, obj4);
    }

    @Override // androidx.compose.ui.graphics.ColorFilter
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof LightingColorFilter) {
            return i2;
        }
        if (!Color.equals-impl0(this.multiply, obj4)) {
            return i2;
        }
        if (!Color.equals-impl0(this.add, obj4)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.graphics.ColorFilter
    public final long getAdd-0d7_KjU() {
        return this.add;
    }

    @Override // androidx.compose.ui.graphics.ColorFilter
    public final long getMultiply-0d7_KjU() {
        return this.multiply;
    }

    @Override // androidx.compose.ui.graphics.ColorFilter
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.ui.graphics.ColorFilter
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("LightingColorFilter(multiply=").append(Color.toString-impl(this.multiply)).append(", add=").append(Color.toString-impl(this.add)).append(')').toString();
    }
}
