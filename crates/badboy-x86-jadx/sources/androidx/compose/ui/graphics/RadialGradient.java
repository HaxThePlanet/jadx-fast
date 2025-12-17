package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.geometry.SizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001BA\u0008\u0000\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\u0008\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u001e\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\u0008\u0010\u001d\u001a\u00020\u001eH\u0016J\u0008\u0010\u001f\u001a\u00020 H\u0016R\u0016\u0010\u0007\u001a\u00020\u0008X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u000bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006!", d2 = {"Landroidx/compose/ui/graphics/RadialGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "(Ljava/util/List;Ljava/util/List;JFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "I", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RadialGradient extends androidx.compose.ui.graphics.ShaderBrush {

    private final long center;
    private final List<androidx.compose.ui.graphics.Color> colors;
    private final float radius;
    private final List<Float> stops;
    private final int tileMode;
    private RadialGradient(List<androidx.compose.ui.graphics.Color> colors, List<Float> stops, long center, float radius, int tileMode) {
        super();
        this.colors = colors;
        this.stops = stops;
        this.center = center;
        this.radius = tileMode;
        this.tileMode = obj6;
    }

    public RadialGradient(List list, List list2, long l3, float f4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        int i2;
        int i;
        int obj10;
        int obj14;
        i2 = defaultConstructorMarker7 & 2 != 0 ? obj10 : list2;
        if (defaultConstructorMarker7 & 16 != 0) {
            i = obj14;
        } else {
            i = i6;
        }
        super(list, i2, l3, obj4, i5, i, 0);
    }

    public RadialGradient(List list, List list2, long l3, float f4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(list, list2, l3, f4, i5, defaultConstructorMarker6);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    public Shader createShader-uvyYCjk(long size) {
        float centerX;
        float centerY;
        boolean unspecified-k-4lQ0M;
        float radius;
        int i2;
        float width-impl;
        int i;
        int i3;
        long center-uvyYCjk;
        long center;
        int i4 = 0;
        int i5 = 0;
        i3 = 1;
        final int i7 = 0;
        final int i8 = 2139095040;
        if (OffsetKt.isUnspecified-k-4lQ0M(this.center)) {
            center-uvyYCjk = SizeKt.getCenter-uvyYCjk(size);
            centerX = Offset.getX-impl(center-uvyYCjk);
            centerY = Offset.getY-impl(center-uvyYCjk);
        } else {
            i2 = Float.compare(x-impl, i8) == 0 ? i3 : i7;
            if (i2 != 0) {
                width-impl = Size.getWidth-impl(size);
            } else {
                width-impl = Offset.getX-impl(this.center);
            }
            centerX = width-impl;
            i = Float.compare(y-impl, i8) == 0 ? i3 : i7;
            if (i != 0) {
                unspecified-k-4lQ0M = Size.getHeight-impl(size);
            } else {
                unspecified-k-4lQ0M = Offset.getY-impl(this.center);
            }
            centerY = unspecified-k-4lQ0M;
        }
        if (Float.compare(radius2, i8) == 0) {
        } else {
            i3 = i7;
        }
        if (i3 != 0) {
            minDimension-impl /= i3;
        } else {
            radius = this.radius;
        }
        return ShaderKt.RadialGradientShader-8uybcMk(OffsetKt.Offset(centerX, centerY), obj7, radius, this.colors, this.stops);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    public boolean equals(Object other) {
        int i;
        final int i2 = 1;
        if (this == other) {
            return i2;
        }
        final int i3 = 0;
        if (!other instanceof RadialGradient) {
            return i3;
        }
        if (!Intrinsics.areEqual(this.colors, obj2.colors)) {
            return i3;
        }
        if (!Intrinsics.areEqual(this.stops, obj3.stops)) {
            return i3;
        }
        if (!Offset.equals-impl0(this.center, obj4)) {
            return i3;
        }
        i = Float.compare(radius, radius2) == 0 ? i2 : i3;
        if (i == 0) {
            return i3;
        }
        if (!TileMode.equals-impl0(this.tileMode, obj5.tileMode)) {
            return i3;
        }
        return i2;
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    public long getIntrinsicSize-NH-jbRc() {
        float naN;
        int i2;
        long unspecified-NH-jbRc;
        boolean infinite;
        int i;
        naN = this.radius;
        if (!Float.isInfinite(naN) && !Float.isNaN(naN)) {
            i2 = !Float.isNaN(naN) ? 1 : 0;
        } else {
        }
        if (i2 != 0) {
            infinite = (float)i4;
            unspecified-NH-jbRc = SizeKt.Size(radius *= infinite, radius2 *= infinite);
        } else {
            unspecified-NH-jbRc = Size.Companion.getUnspecified-NH-jbRc();
        }
        return unspecified-NH-jbRc;
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    public int hashCode() {
        int i;
        List stops = this.stops;
        if (stops != null) {
            i = stops.hashCode();
        } else {
            i = 0;
        }
        return result2 += i10;
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    public String toString() {
        String string;
        String string2;
        String string-impl;
        int radius;
        float naN;
        String str = ", ";
        if (OffsetKt.isSpecified-k-4lQ0M(this.center)) {
            StringBuilder stringBuilder = new StringBuilder();
            string = stringBuilder.append("center=").append(Offset.toString-impl(this.center)).append(str).toString();
        } else {
            string = string2;
        }
        naN = this.radius;
        if (!Float.isInfinite(naN) && !Float.isNaN(naN)) {
            radius = !Float.isNaN(naN) ? 1 : 0;
        } else {
        }
        if (radius != 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            string2 = stringBuilder2.append("radius=").append(this.radius).append(str).toString();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        return stringBuilder3.append("RadialGradient(colors=").append(this.colors).append(", stops=").append(this.stops).append(str).append(string).append(string2).append("tileMode=").append(TileMode.toString-impl(this.tileMode)).append(')').toString();
    }
}
