package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Outline.Rectangle;
import androidx.compose.ui.graphics.Outline.Rounded;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J(\u0010\u0008\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u0003H\u0016JB\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00112\u0006\u0010\u000c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\u0008\u0010\u001c\u001a\u00020\u001dH\u0016J\u0019\u0010\u001e\u001a\u00020\u001f*\u00020\u0011H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\"", d2 = {"Landroidx/compose/foundation/shape/AbsoluteRoundedCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "topLeft", "Landroidx/compose/foundation/shape/CornerSize;", "topRight", "bottomRight", "bottomLeft", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "copy", "topStart", "topEnd", "bottomEnd", "bottomStart", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "equals", "", "other", "", "hashCode", "", "toString", "", "toRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "toRadius-Bz7bX_o", "(F)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AbsoluteRoundedCornerShape extends androidx.compose.foundation.shape.CornerBasedShape {

    public static final int $stable;
    static {
    }

    public AbsoluteRoundedCornerShape(androidx.compose.foundation.shape.CornerSize topLeft, androidx.compose.foundation.shape.CornerSize topRight, androidx.compose.foundation.shape.CornerSize bottomRight, androidx.compose.foundation.shape.CornerSize bottomLeft) {
        super(topLeft, topRight, bottomRight, bottomLeft);
    }

    private final long toRadius-Bz7bX_o(float $this$toRadius_u2dBz7bX_o) {
        return CornerRadiusKt.CornerRadius$default($this$toRadius_u2dBz7bX_o, 0, 2, 0);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public androidx.compose.foundation.shape.AbsoluteRoundedCornerShape copy(androidx.compose.foundation.shape.CornerSize topStart, androidx.compose.foundation.shape.CornerSize topEnd, androidx.compose.foundation.shape.CornerSize bottomEnd, androidx.compose.foundation.shape.CornerSize bottomStart) {
        AbsoluteRoundedCornerShape absoluteRoundedCornerShape = new AbsoluteRoundedCornerShape(topStart, topEnd, bottomEnd, bottomStart);
        return absoluteRoundedCornerShape;
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public androidx.compose.foundation.shape.CornerBasedShape copy(androidx.compose.foundation.shape.CornerSize topStart, androidx.compose.foundation.shape.CornerSize topEnd, androidx.compose.foundation.shape.CornerSize bottomEnd, androidx.compose.foundation.shape.CornerSize bottomStart) {
        return (CornerBasedShape)copy(topStart, topEnd, bottomEnd, bottomStart);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public Outline createOutline-LjSzlW0(long size, float topStart, float topEnd, float bottomEnd, float bottomStart, LayoutDirection layoutDirection) {
        int i2;
        Outline rectangle;
        Object rect-uvyYCjk;
        androidx.compose.ui.geometry.Rect rect-uvyYCjk2;
        long l5;
        int i;
        long l4;
        long l3;
        long l;
        long l2;
        final int i3 = topEnd;
        final int i4 = bottomEnd;
        final int i5 = bottomStart;
        final int i6 = layoutDirection;
        int i10 = 0;
        i2 = Float.compare(i9, i10) == 0 ? 1 : 0;
        if (i2 != 0) {
            rectangle = new Outline.Rectangle(SizeKt.toRect-uvyYCjk(size));
        } else {
            int i11 = 2;
            i = 0;
            rectangle = new Outline.Rounded(RoundRectKt.RoundRect-ZAM2FJo(SizeKt.toRect-uvyYCjk(size), CornerRadiusKt.CornerRadius$default(i3, i10, i11, i), i, CornerRadiusKt.CornerRadius$default(i4, i10, i11, i), obj10));
        }
        return rectangle;
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof AbsoluteRoundedCornerShape) {
            return i2;
        }
        if (!Intrinsics.areEqual(getTopStart(), (AbsoluteRoundedCornerShape)other.getTopStart())) {
            return i2;
        }
        if (!Intrinsics.areEqual(getTopEnd(), (AbsoluteRoundedCornerShape)other.getTopEnd())) {
            return i2;
        }
        if (!Intrinsics.areEqual(getBottomEnd(), (AbsoluteRoundedCornerShape)other.getBottomEnd())) {
            return i2;
        }
        if (!Intrinsics.areEqual(getBottomStart(), (AbsoluteRoundedCornerShape)other.getBottomStart())) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public int hashCode() {
        return result2 += i8;
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("AbsoluteRoundedCornerShape(topLeft = ").append(getTopStart()).append(", topRight = ").append(getTopEnd()).append(", bottomRight = ").append(getBottomEnd()).append(", bottomLeft = ").append(getBottomStart()).append(')').toString();
    }
}
