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
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J(\u0010\u0008\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016JB\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001a", d2 = {"Landroidx/compose/foundation/shape/CutCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "copy", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CutCornerShape extends androidx.compose.foundation.shape.CornerBasedShape {

    public static final int $stable;
    static {
    }

    public CutCornerShape(androidx.compose.foundation.shape.CornerSize topStart, androidx.compose.foundation.shape.CornerSize topEnd, androidx.compose.foundation.shape.CornerSize bottomEnd, androidx.compose.foundation.shape.CornerSize bottomStart) {
        super(topStart, topEnd, bottomEnd, bottomStart);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public androidx.compose.foundation.shape.CornerBasedShape copy(androidx.compose.foundation.shape.CornerSize topStart, androidx.compose.foundation.shape.CornerSize topEnd, androidx.compose.foundation.shape.CornerSize bottomEnd, androidx.compose.foundation.shape.CornerSize bottomStart) {
        return (CornerBasedShape)copy(topStart, topEnd, bottomEnd, bottomStart);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public androidx.compose.foundation.shape.CutCornerShape copy(androidx.compose.foundation.shape.CornerSize topStart, androidx.compose.foundation.shape.CornerSize topEnd, androidx.compose.foundation.shape.CornerSize bottomEnd, androidx.compose.foundation.shape.CornerSize bottomStart) {
        CutCornerShape cutCornerShape = new CutCornerShape(topStart, topEnd, bottomEnd, bottomStart);
        return cutCornerShape;
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public Outline createOutline-LjSzlW0(long size, float topStart, float topEnd, float bottomEnd, float bottomStart, LayoutDirection layoutDirection) {
        int i2;
        Outline rectangle;
        Object rect-uvyYCjk;
        Path path;
        int i5;
        int i6;
        int i7;
        int i4;
        int i3;
        int i;
        float height-impl;
        int i11 = 0;
        i2 = Float.compare(i10, i11) == 0 ? 1 : 0;
        if (i2 != 0) {
            rectangle = new Outline.Rectangle(SizeKt.toRect-uvyYCjk(size));
        } else {
            Path path2 = AndroidPath_androidKt.Path();
            path = path2;
            i5 = 0;
            i7 = obj14 == LayoutDirection.Ltr ? topEnd : bottomEnd;
            path.moveTo(i11, i7);
            path.lineTo(i7, i11);
            i = obj14 == LayoutDirection.Ltr ? bottomEnd : topEnd;
            path.lineTo(width-impl -= i, i11);
            path.lineTo(Size.getWidth-impl(size), i);
            i4 = obj14 == LayoutDirection.Ltr ? bottomStart : layoutDirection;
            path.lineTo(Size.getWidth-impl(size), height-impl4 -= i4);
            path.lineTo(width-impl4 -= i4, Size.getHeight-impl(size));
            i3 = obj14 == LayoutDirection.Ltr ? layoutDirection : bottomStart;
            path.lineTo(i3, Size.getHeight-impl(size));
            path.lineTo(i11, height-impl3 -= i3);
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
        if (!other instanceof CutCornerShape) {
            return i2;
        }
        if (!Intrinsics.areEqual(getTopStart(), (CutCornerShape)other.getTopStart())) {
            return i2;
        }
        if (!Intrinsics.areEqual(getTopEnd(), (CutCornerShape)other.getTopEnd())) {
            return i2;
        }
        if (!Intrinsics.areEqual(getBottomEnd(), (CutCornerShape)other.getBottomEnd())) {
            return i2;
        }
        if (!Intrinsics.areEqual(getBottomStart(), (CutCornerShape)other.getBottomStart())) {
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
        return stringBuilder.append("CutCornerShape(topStart = ").append(getTopStart()).append(", topEnd = ").append(getTopEnd()).append(", bottomEnd = ").append(getBottomEnd()).append(", bottomStart = ").append(getBottomStart()).append(')').toString();
    }
}
