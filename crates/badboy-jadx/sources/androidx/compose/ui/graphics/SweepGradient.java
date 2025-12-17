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
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B/\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0010\u0008\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u001e\u0010\u000b\u001a\u00060\u000cj\u0002`\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001a", d2 = {"Landroidx/compose/ui/graphics/SweepGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "center", "Landroidx/compose/ui/geometry/Offset;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "(JLjava/util/List;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "Landroidx/compose/ui/geometry/Size;", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SweepGradient extends androidx.compose.ui.graphics.ShaderBrush {

    private final long center;
    private final List<androidx.compose.ui.graphics.Color> colors;
    private final List<Float> stops;
    private SweepGradient(long center, List<androidx.compose.ui.graphics.Color> colors, List<Float> stops) {
        super();
        this.center = center;
        this.colors = stops;
        this.stops = obj4;
    }

    public SweepGradient(long l, List list2, List list3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int i;
        int obj10;
        i = defaultConstructorMarker5 &= 4 != 0 ? obj10 : i4;
        super(l, obj2, list3, i, 0);
    }

    public SweepGradient(long l, List list2, List list3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(l, list2, list3, defaultConstructorMarker4);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    public Shader createShader-uvyYCjk(long size) {
        long center-uvyYCjk;
        int i;
        float width-impl;
        long height-impl;
        int i3;
        int i2;
        float center;
        if (OffsetKt.isUnspecified-k-4lQ0M(this.center)) {
            center-uvyYCjk = SizeKt.getCenter-uvyYCjk(size);
        } else {
            int i4 = 2139095040;
            i2 = 0;
            i = Float.compare(x-impl, i4) == 0 ? i3 : i2;
            if (i != 0) {
                width-impl = Size.getWidth-impl(size);
            } else {
                width-impl = Offset.getX-impl(this.center);
            }
            if (Float.compare(center, i4) == 0) {
            } else {
                i3 = i2;
            }
            if (i3 != 0) {
                height-impl = Size.getHeight-impl(size);
            } else {
                height-impl = Offset.getY-impl(this.center);
            }
            center-uvyYCjk = OffsetKt.Offset(width-impl, height-impl);
        }
        return ShaderKt.SweepGradientShader-9KIMszo(center-uvyYCjk, height-impl, this.colors);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof SweepGradient) {
            return i2;
        }
        if (!Offset.equals-impl0(this.center, obj4)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.colors, obj2.colors)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.stops, obj3.stops)) {
            return i2;
        }
        return i;
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
        return result += i;
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    public String toString() {
        String string;
        String str;
        if (OffsetKt.isSpecified-k-4lQ0M(this.center)) {
            StringBuilder stringBuilder = new StringBuilder();
            string = stringBuilder.append("center=").append(Offset.toString-impl(this.center)).append(", ").toString();
        } else {
            string = "";
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        return stringBuilder2.append("SweepGradient(").append(string).append("colors=").append(this.colors).append(", stops=").append(this.stops).append(')').toString();
    }
}
