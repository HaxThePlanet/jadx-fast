package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Outline.Generic;
import androidx.compose.ui.graphics.Outline.Rectangle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J(\u0010\u0008\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u0003H\u0016JB\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00112\u0006\u0010\u000c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\u0008\u0010\u001c\u001a\u00020\u001dH\u0016\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001e", d2 = {"Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "topLeft", "Landroidx/compose/foundation/shape/CornerSize;", "topRight", "bottomRight", "bottomLeft", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "copy", "topStart", "topEnd", "bottomEnd", "bottomStart", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AbsoluteCutCornerShape extends androidx.compose.foundation.shape.CornerBasedShape {

    public static final int $stable;
    static {
    }

    public AbsoluteCutCornerShape(androidx.compose.foundation.shape.CornerSize topLeft, androidx.compose.foundation.shape.CornerSize topRight, androidx.compose.foundation.shape.CornerSize bottomRight, androidx.compose.foundation.shape.CornerSize bottomLeft) {
        super(topLeft, topRight, bottomRight, bottomLeft);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public androidx.compose.foundation.shape.AbsoluteCutCornerShape copy(androidx.compose.foundation.shape.CornerSize topStart, androidx.compose.foundation.shape.CornerSize topEnd, androidx.compose.foundation.shape.CornerSize bottomEnd, androidx.compose.foundation.shape.CornerSize bottomStart) {
        AbsoluteCutCornerShape absoluteCutCornerShape = new AbsoluteCutCornerShape(topStart, topEnd, bottomEnd, bottomStart);
        return absoluteCutCornerShape;
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
        Path path;
        int i;
        int cornerSize;
        int i3;
        float height-impl;
        int i7 = 0;
        i2 = Float.compare(i6, i7) == 0 ? 1 : 0;
        if (i2 != 0) {
            rectangle = new Outline.Rectangle(SizeKt.toRect-uvyYCjk(size));
        } else {
            Path path2 = AndroidPath_androidKt.Path();
            path = path2;
            i = 0;
            int i8 = topEnd;
            path.moveTo(i7, i8);
            path.lineTo(i8, i7);
            int cornerSize2 = bottomEnd;
            path.lineTo(width-impl -= cornerSize2, i7);
            path.lineTo(Size.getWidth-impl(size), cornerSize2);
            int cornerSize3 = bottomStart;
            path.lineTo(Size.getWidth-impl(size), height-impl4 -= cornerSize3);
            path.lineTo(width-impl4 -= cornerSize3, Size.getHeight-impl(size));
            cornerSize = layoutDirection;
            path.lineTo(cornerSize, Size.getHeight-impl(size));
            path.lineTo(i7, height-impl3 -= cornerSize);
            path.close();
            rect-uvyYCjk = new Outline.Generic(path2);
            rectangle = rect-uvyYCjk;
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
        if (!other instanceof AbsoluteCutCornerShape) {
            return i2;
        }
        if (!Intrinsics.areEqual(getTopStart(), (AbsoluteCutCornerShape)other.getTopStart())) {
            return i2;
        }
        if (!Intrinsics.areEqual(getTopEnd(), (AbsoluteCutCornerShape)other.getTopEnd())) {
            return i2;
        }
        if (!Intrinsics.areEqual(getBottomEnd(), (AbsoluteCutCornerShape)other.getBottomEnd())) {
            return i2;
        }
        if (!Intrinsics.areEqual(getBottomStart(), (AbsoluteCutCornerShape)other.getBottomStart())) {
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
        return stringBuilder.append("AbsoluteCutCornerShape(topLeft = ").append(getTopStart()).append(", topRight = ").append(getTopEnd()).append(", bottomRight = ").append(getBottomEnd()).append(", bottomLeft = ").append(getBottomStart()).append(')').toString();
    }
}
