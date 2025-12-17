package androidx.compose.material;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Outline.Generic;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.PathOperation.Companion;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0001HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u000c\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J*\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u001c\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J4\u0010\"\u001a\u00020 *\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020$H\u0002R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006)", d2 = {"Landroidx/compose/material/BottomAppBarCutoutShape;", "Landroidx/compose/ui/graphics/Shape;", "cutoutShape", "fabPlacement", "Landroidx/compose/material/FabPlacement;", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/FabPlacement;)V", "getCutoutShape", "()Landroidx/compose/ui/graphics/Shape;", "getFabPlacement", "()Landroidx/compose/material/FabPlacement;", "component1", "component2", "copy", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "equals", "", "other", "", "hashCode", "", "toString", "", "addCutoutShape", "", "Landroidx/compose/ui/graphics/Path;", "addRoundedEdges", "cutoutStartPosition", "", "cutoutEndPosition", "cutoutRadius", "roundedEdgeRadius", "verticalOffset", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BottomAppBarCutoutShape implements Shape {

    private final Shape cutoutShape;
    private final androidx.compose.material.FabPlacement fabPlacement;
    public BottomAppBarCutoutShape(Shape cutoutShape, androidx.compose.material.FabPlacement fabPlacement) {
        super();
        this.cutoutShape = cutoutShape;
        this.fabPlacement = fabPlacement;
    }

    private final void addCutoutShape(Path $this$addCutoutShape, LayoutDirection layoutDirection, Density density) {
        Object equal;
        Path $this$addCutoutShape2;
        float px-0680j_4;
        int i;
        int i2 = 0;
        float $this$addCutoutShape_u24lambda_u242 = density.toPx-0680j_4(AppBarKt.access$getBottomAppBarCutoutOffset$p());
        float f3 = (float)i4;
        f3 *= $this$addCutoutShape_u24lambda_u242;
        long l = SizeKt.Size(f += i6, f4 += i5);
        final int i11 = f5 - $this$addCutoutShape_u24lambda_u242;
        final int i13 = height-impl / i9;
        OutlineKt.addOutline($this$addCutoutShape, this.cutoutShape.createOutline-Pq9zytI(l, i5, layoutDirection));
        $this$addCutoutShape.translate-k-4lQ0M(OffsetKt.Offset(i11, -i13));
        if (Intrinsics.areEqual(this.cutoutShape, RoundedCornerShapeKt.getCircleShape())) {
            int i10 = 0;
            this.addRoundedEdges($this$addCutoutShape, i11, i11 + width-impl, i13, density.toPx-0680j_4(AppBarKt.access$getBottomAppBarRoundedEdgeRadius$p()), 0);
        } else {
            $this$addCutoutShape2 = $this$addCutoutShape;
        }
    }

    private final void addRoundedEdges(Path $this$addRoundedEdges, float cutoutStartPosition, float cutoutEndPosition, float cutoutRadius, float roundedEdgeRadius, float verticalOffset) {
        final Object obj = $this$addRoundedEdges;
        int i = cutoutRadius;
        final int i3 = verticalOffset;
        int i4 = 0;
        int i5 = 0;
        int i9 = 0;
        int $i$f$square2 = i3 * i3;
        int $i$f$calculateCutoutCircleYIntercept = -f;
        i7 += cutoutStartPosition;
        int i11 = cutoutEndPosition - i10;
        final int i12 = 1065353216;
        Pair roundedEdgeIntercept = AppBarKt.calculateRoundedEdgeIntercept($i$f$calculateCutoutCircleYIntercept - i12, i3, i);
        float floatValue2 = (Number)roundedEdgeIntercept.component1().floatValue();
        final int i18 = floatValue - i3;
        obj.moveTo(i8 - roundedEdgeRadius, 0);
        int i2 = 0;
        obj.quadraticTo(i8 - i12, i2, i14 += cutoutStartPosition, i18);
        obj.lineTo(cutoutEndPosition - i16, i18);
        obj.quadraticTo(i11 + i12, i2, i11 + roundedEdgeRadius, i2);
        obj.close();
    }

    public static androidx.compose.material.BottomAppBarCutoutShape copy$default(androidx.compose.material.BottomAppBarCutoutShape bottomAppBarCutoutShape, Shape shape2, androidx.compose.material.FabPlacement fabPlacement3, int i4, Object object5) {
        Shape obj1;
        androidx.compose.material.FabPlacement obj2;
        if (i4 & 1 != 0) {
            obj1 = bottomAppBarCutoutShape.cutoutShape;
        }
        if (i4 &= 2 != 0) {
            obj2 = bottomAppBarCutoutShape.fabPlacement;
        }
        return bottomAppBarCutoutShape.copy(obj1, obj2);
    }

    @Override // androidx.compose.ui.graphics.Shape
    public final Shape component1() {
        return this.cutoutShape;
    }

    @Override // androidx.compose.ui.graphics.Shape
    public final androidx.compose.material.FabPlacement component2() {
        return this.fabPlacement;
    }

    @Override // androidx.compose.ui.graphics.Shape
    public final androidx.compose.material.BottomAppBarCutoutShape copy(Shape shape, androidx.compose.material.FabPlacement fabPlacement2) {
        BottomAppBarCutoutShape bottomAppBarCutoutShape = new BottomAppBarCutoutShape(shape, fabPlacement2);
        return bottomAppBarCutoutShape;
    }

    @Override // androidx.compose.ui.graphics.Shape
    public Outline createOutline-Pq9zytI(long size, LayoutDirection layoutDirection, Density density) {
        final Path path = AndroidPath_androidKt.Path();
        int i = 0;
        final int i5 = 0;
        Rect rect = new Rect(i5, i5, Size.getWidth-impl(size), Size.getHeight-impl(size));
        int i3 = 0;
        Path.addRect$default(path, rect, i3, 2, i3);
        Path path3 = AndroidPath_androidKt.Path();
        Path path4 = path3;
        int i2 = 0;
        addCutoutShape(path4, density, obj11);
        path4.op-N5in7k0(path, path4, PathOperation.Companion.getDifference-b3I0S0c());
        Outline.Generic generic = new Outline.Generic(path3);
        return (Outline)generic;
    }

    @Override // androidx.compose.ui.graphics.Shape
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof BottomAppBarCutoutShape) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.cutoutShape, obj.cutoutShape)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.fabPlacement, obj.fabPlacement)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.graphics.Shape
    public final Shape getCutoutShape() {
        return this.cutoutShape;
    }

    @Override // androidx.compose.ui.graphics.Shape
    public final androidx.compose.material.FabPlacement getFabPlacement() {
        return this.fabPlacement;
    }

    @Override // androidx.compose.ui.graphics.Shape
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.ui.graphics.Shape
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("BottomAppBarCutoutShape(cutoutShape=").append(this.cutoutShape).append(", fabPlacement=").append(this.fabPlacement).append(')').toString();
    }
}
