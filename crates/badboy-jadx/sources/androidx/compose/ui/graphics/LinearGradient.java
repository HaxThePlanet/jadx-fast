package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001BA\u0008\u0000\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\u0008\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u001e\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\u0008\u0010\u001d\u001a\u00020\u001eH\u0016J\u0008\u0010\u001f\u001a\u00020 H\u0016R\u0014\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\u0008X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u0008X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u000bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006!", d2 = {"Landroidx/compose/ui/graphics/LinearGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "(Ljava/util/List;Ljava/util/List;JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "I", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LinearGradient extends androidx.compose.ui.graphics.ShaderBrush {

    private final List<androidx.compose.ui.graphics.Color> colors;
    private final long end;
    private final long start;
    private final List<Float> stops;
    private final int tileMode;
    private LinearGradient(List<androidx.compose.ui.graphics.Color> colors, List<Float> stops, long start, long end, int tileMode) {
        super();
        this.colors = colors;
        this.stops = stops;
        this.start = start;
        this.end = tileMode;
        this.tileMode = obj7;
    }

    public LinearGradient(List list, List list2, long l3, long l4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        int i2;
        int i;
        int obj11;
        i2 = obj17 & 2 != 0 ? obj11 : list2;
        if (obj17 & 16 != 0) {
            i = obj11;
        } else {
            i = defaultConstructorMarker7;
        }
        super(list, i2, l3, obj4, i5, obj6, i, 0);
    }

    public LinearGradient(List list, List list2, long l3, long l4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(list, list2, l3, l4, i5, defaultConstructorMarker6, obj7);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    public Shader createShader-uvyYCjk(long size) {
        int i;
        float width-impl2;
        float height-impl;
        int i3;
        long start;
        int i2;
        float height-impl2;
        int i4;
        float width-impl;
        int i5 = 2139095040;
        i3 = 1;
        final int i6 = 0;
        i = Float.compare(x-impl, i5) == 0 ? i3 : i6;
        if (i != 0) {
            width-impl2 = Size.getWidth-impl(size);
        } else {
            width-impl2 = Offset.getX-impl(this.start);
        }
        i2 = Float.compare(y-impl, i5) == 0 ? i3 : i6;
        if (i2 != 0) {
            height-impl2 = Size.getHeight-impl(size);
        } else {
            height-impl2 = Offset.getY-impl(this.start);
        }
        i4 = Float.compare(x-impl2, i5) == 0 ? i3 : i6;
        if (i4 != 0) {
            width-impl = Size.getWidth-impl(size);
        } else {
            width-impl = Offset.getX-impl(this.end);
        }
        if (Float.compare(y-impl2, i5) == 0) {
        } else {
            i3 = i6;
        }
        if (i3 != 0) {
            height-impl = Size.getHeight-impl(size);
        } else {
            height-impl = Offset.getY-impl(this.end);
        }
        return ShaderKt.LinearGradientShader-VjE6UOU(OffsetKt.Offset(width-impl2, height-impl2), obj7, OffsetKt.Offset(width-impl, height-impl), obj9, this.colors);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof LinearGradient) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.colors, obj3.colors)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.stops, obj4.stops)) {
            return i2;
        }
        if (!Offset.equals-impl0(this.start, obj4)) {
            return i2;
        }
        if (!Offset.equals-impl0(this.end, obj4)) {
            return i2;
        }
        if (!TileMode.equals-impl0(this.tileMode, obj5.tileMode)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    public long getIntrinsicSize-NH-jbRc() {
        float naN3;
        int i;
        int i2;
        float naN4;
        int i3;
        int y-impl;
        boolean infinite2;
        float naN2;
        int naN;
        boolean infinite;
        naN3 = Offset.getX-impl(this.start);
        y-impl = 1;
        final int i6 = 0;
        if (!Float.isInfinite(naN3) && !Float.isNaN(naN3)) {
            i = !Float.isNaN(naN3) ? y-impl : i6;
        } else {
        }
        if (i != 0) {
            naN4 = Offset.getX-impl(this.end);
            if (!Float.isInfinite(naN4) && !Float.isNaN(naN4)) {
                i = !Float.isNaN(naN4) ? y-impl : i6;
            } else {
            }
            if (i != 0) {
                i2 = Math.abs(x-impl -= infinite2);
            } else {
                i2 = i3;
            }
        } else {
        }
        naN2 = Offset.getY-impl(this.start);
        infinite = Float.isInfinite(naN2);
        if (!infinite && !Float.isNaN(naN2)) {
            naN = !Float.isNaN(naN2) ? y-impl : i6;
        } else {
        }
        if (naN != 0) {
            naN = Offset.getY-impl(this.end);
            if (!Float.isInfinite(naN) && !Float.isNaN(naN)) {
                if (!Float.isNaN(naN)) {
                } else {
                    y-impl = i6;
                }
            } else {
            }
            if (y-impl != 0) {
                i3 = Math.abs(y-impl2 -= y-impl);
            }
        }
        return SizeKt.Size(i2, i3);
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
        boolean finite-k-4lQ0M;
        String str = ", ";
        if (OffsetKt.isFinite-k-4lQ0M(this.start)) {
            StringBuilder stringBuilder = new StringBuilder();
            string = stringBuilder.append("start=").append(Offset.toString-impl(this.start)).append(str).toString();
        } else {
            string = string2;
        }
        if (OffsetKt.isFinite-k-4lQ0M(this.end)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            string2 = stringBuilder2.append("end=").append(Offset.toString-impl(this.end)).append(str).toString();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        return stringBuilder3.append("LinearGradient(colors=").append(this.colors).append(", stops=").append(this.stops).append(str).append(string).append(string2).append("tileMode=").append(TileMode.toString-impl(this.tileMode)).append(')').toString();
    }
}
