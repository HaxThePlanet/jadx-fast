package androidx.compose.ui.graphics;

import android.graphics.ColorFilter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\u0008\u0000\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0002\u0010\u0008J\u001a\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016J\u0015\u0010\u0014\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0019", d2 = {"Landroidx/compose/ui/graphics/ColorMatrixColorFilter;", "Landroidx/compose/ui/graphics/ColorFilter;", "colorMatrix", "Landroidx/compose/ui/graphics/ColorMatrix;", "([FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "nativeColorFilter", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "([FLandroid/graphics/ColorFilter;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "[F", "copyColorMatrix", "targetColorMatrix", "copyColorMatrix-gBh15pI", "([F)[F", "equals", "", "other", "", "hashCode", "", "obtainColorMatrix", "obtainColorMatrix-p10-uLo", "()[F", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ColorMatrixColorFilter extends androidx.compose.ui.graphics.ColorFilter {

    private float[] colorMatrix;
    private ColorMatrixColorFilter(float[] colorMatrix) {
        super(colorMatrix, AndroidColorFilter_androidKt.actualColorMatrixColorFilter-jHG-Opc(colorMatrix), 0);
    }

    private ColorMatrixColorFilter(float[] colorMatrix, ColorFilter nativeColorFilter) {
        super(nativeColorFilter);
        this.colorMatrix = colorMatrix;
    }

    public ColorMatrixColorFilter(float[] fArr, ColorFilter colorFilter2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(fArr, colorFilter2);
    }

    public ColorMatrixColorFilter(float[] fArr, DefaultConstructorMarker defaultConstructorMarker2) {
        super(fArr);
    }

    public static float[] copyColorMatrix-gBh15pI$default(androidx.compose.ui.graphics.ColorMatrixColorFilter colorMatrixColorFilter, float[] f2Arr2, int i3, Object object4) {
        float[] obj1;
        final int obj3 = 1;
        if (i3 &= obj3 != 0) {
            obj1 = 0;
            obj1 = ColorMatrix.constructor-impl$default(obj1, obj3, obj1);
        }
        return colorMatrixColorFilter.copyColorMatrix-gBh15pI(obj1);
    }

    private final float[] obtainColorMatrix-p10-uLo() {
        float[] actualColorMatrixFromFilter;
        float[] fArr;
        int i;
        if (this.colorMatrix == null) {
            i = 0;
            this.colorMatrix = AndroidColorFilter_androidKt.actualColorMatrixFromFilter(getNativeColorFilter$ui_graphics_release());
        }
        return actualColorMatrixFromFilter;
    }

    @Override // androidx.compose.ui.graphics.ColorFilter
    public final float[] copyColorMatrix-gBh15pI(float[] targetColorMatrix) {
        final float[] fArr = targetColorMatrix;
        ArraysKt.copyInto$default(obtainColorMatrix-p10-uLo(), fArr, 0, 0, 0, 14, 0);
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.ColorFilter
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof ColorMatrixColorFilter) {
            return i2;
        }
        if (!Arrays.equals(obtainColorMatrix-p10-uLo(), (ColorMatrixColorFilter)other.obtainColorMatrix-p10-uLo())) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.graphics.ColorFilter
    public int hashCode() {
        int i;
        float[] colorMatrix = this.colorMatrix;
        if (colorMatrix != null) {
            i = ColorMatrix.hashCode-impl(colorMatrix);
        } else {
            i = 0;
        }
        return i;
    }

    @Override // androidx.compose.ui.graphics.ColorFilter
    public String toString() {
        String string-impl;
        StringBuilder stringBuilder = new StringBuilder();
        float[] colorMatrix = this.colorMatrix;
        if (colorMatrix == null) {
            string-impl = "null";
        } else {
            string-impl = ColorMatrix.toString-impl(colorMatrix);
        }
        return stringBuilder.append("ColorMatrixColorFilter(colorMatrix=").append(string-impl).append(')').toString();
    }
}
