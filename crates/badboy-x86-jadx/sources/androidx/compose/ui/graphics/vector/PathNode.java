package androidx.compose.ui.graphics.vector;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u00002\u00020\u0001:\u0013\u0007\u0008\t\n\u000b\u000c\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\u001b\u0008\u0004\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\u0006\u0082\u0001\u0013\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,¨\u0006-", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode;", "", "isCurve", "", "isQuad", "(ZZ)V", "()Z", "ArcTo", "Close", "CurveTo", "HorizontalTo", "LineTo", "MoveTo", "QuadTo", "ReflectiveCurveTo", "ReflectiveQuadTo", "RelativeArcTo", "RelativeCurveTo", "RelativeHorizontalTo", "RelativeLineTo", "RelativeMoveTo", "RelativeQuadTo", "RelativeReflectiveCurveTo", "RelativeReflectiveQuadTo", "RelativeVerticalTo", "VerticalTo", "Landroidx/compose/ui/graphics/vector/PathNode$ArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode$Close;", "Landroidx/compose/ui/graphics/vector/PathNode$CurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$HorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode$LineTo;", "Landroidx/compose/ui/graphics/vector/PathNode$MoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$QuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeHorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeLineTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeMoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeVerticalTo;", "Landroidx/compose/ui/graphics/vector/PathNode$VerticalTo;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PathNode {

    private final boolean isCurve;
    private final boolean isQuad;

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0010R\u0011\u0010\u0008\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\r¨\u0006\"", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$ArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "horizontalEllipseRadius", "", "verticalEllipseRadius", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcStartX", "arcStartY", "(FFFZZFF)V", "getArcStartX", "()F", "getArcStartY", "getHorizontalEllipseRadius", "()Z", "getTheta", "getVerticalEllipseRadius", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ArcTo extends androidx.compose.ui.graphics.vector.PathNode {

        private final float arcStartX;
        private final float arcStartY;
        private final float horizontalEllipseRadius;
        private final boolean isMoreThanHalf;
        private final boolean isPositiveArc;
        private final float theta;
        private final float verticalEllipseRadius;
        public ArcTo(float horizontalEllipseRadius, float verticalEllipseRadius, float theta, boolean isMoreThanHalf, boolean isPositiveArc, float arcStartX, float arcStartY) {
            final int i3 = 0;
            super(i3, i3, 3, 0);
            this.horizontalEllipseRadius = horizontalEllipseRadius;
            this.verticalEllipseRadius = verticalEllipseRadius;
            this.theta = theta;
            this.isMoreThanHalf = isMoreThanHalf;
            this.isPositiveArc = isPositiveArc;
            this.arcStartX = arcStartX;
            this.arcStartY = arcStartY;
        }

        public static androidx.compose.ui.graphics.vector.PathNode.ArcTo copy$default(androidx.compose.ui.graphics.vector.PathNode.ArcTo pathNode$ArcTo, float f2, float f3, float f4, boolean z5, boolean z6, float f7, float f8, int i9, Object object10) {
            float obj1;
            float obj2;
            float obj3;
            boolean obj4;
            boolean obj5;
            float obj6;
            float obj7;
            if (i9 & 1 != 0) {
                obj1 = arcTo.horizontalEllipseRadius;
            }
            if (i9 & 2 != 0) {
                obj2 = arcTo.verticalEllipseRadius;
            }
            if (i9 & 4 != 0) {
                obj3 = arcTo.theta;
            }
            if (i9 & 8 != 0) {
                obj4 = arcTo.isMoreThanHalf;
            }
            if (i9 & 16 != 0) {
                obj5 = arcTo.isPositiveArc;
            }
            if (i9 & 32 != 0) {
                obj6 = arcTo.arcStartX;
            }
            if (i9 &= 64 != 0) {
                obj7 = arcTo.arcStartY;
            }
            return arcTo.copy(obj1, obj2, obj3, obj4, obj5, obj6, obj7);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component1() {
            return this.horizontalEllipseRadius;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component2() {
            return this.verticalEllipseRadius;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component3() {
            return this.theta;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final boolean component4() {
            return this.isMoreThanHalf;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final boolean component5() {
            return this.isPositiveArc;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component6() {
            return this.arcStartX;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component7() {
            return this.arcStartY;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final androidx.compose.ui.graphics.vector.PathNode.ArcTo copy(float f, float f2, float f3, boolean z4, boolean z5, float f6, float f7) {
            PathNode.ArcTo arcTo = new PathNode.ArcTo(f, f2, f3, z4, z5, f6, f7);
            return arcTo;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof PathNode.ArcTo) {
                return i2;
            }
            Object obj = object;
            if (Float.compare(this.horizontalEllipseRadius, obj.horizontalEllipseRadius) != 0) {
                return i2;
            }
            if (Float.compare(this.verticalEllipseRadius, obj.verticalEllipseRadius) != 0) {
                return i2;
            }
            if (Float.compare(this.theta, obj.theta) != 0) {
                return i2;
            }
            if (this.isMoreThanHalf != obj.isMoreThanHalf) {
                return i2;
            }
            if (this.isPositiveArc != obj.isPositiveArc) {
                return i2;
            }
            if (Float.compare(this.arcStartX, obj.arcStartX) != 0) {
                return i2;
            }
            if (Float.compare(this.arcStartY, obj.arcStartY) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getArcStartX() {
            return this.arcStartX;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getArcStartY() {
            return this.arcStartY;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getHorizontalEllipseRadius() {
            return this.horizontalEllipseRadius;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getTheta() {
            return this.theta;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getVerticalEllipseRadius() {
            return this.verticalEllipseRadius;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public int hashCode() {
            return i6 += i19;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final boolean isMoreThanHalf() {
            return this.isMoreThanHalf;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final boolean isPositiveArc() {
            return this.isPositiveArc;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("ArcTo(horizontalEllipseRadius=").append(this.horizontalEllipseRadius).append(", verticalEllipseRadius=").append(this.verticalEllipseRadius).append(", theta=").append(this.theta).append(", isMoreThanHalf=").append(this.isMoreThanHalf).append(", isPositiveArc=").append(this.isPositiveArc).append(", arcStartX=").append(this.arcStartX).append(", arcStartY=").append(this.arcStartY).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$Close;", "Landroidx/compose/ui/graphics/vector/PathNode;", "()V", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Close extends androidx.compose.ui.graphics.vector.PathNode {

        public static final androidx.compose.ui.graphics.vector.PathNode.Close INSTANCE;
        static {
            PathNode.Close close = new PathNode.Close();
            PathNode.Close.INSTANCE = close;
        }

        private Close() {
            final int i3 = 0;
            super(i3, i3, 3, 0);
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000b¨\u0006 ", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$CurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x1", "", "y1", "x2", "y2", "x3", "y3", "(FFFFFF)V", "getX1", "()F", "getX2", "getX3", "getY1", "getY2", "getY3", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CurveTo extends androidx.compose.ui.graphics.vector.PathNode {

        private final float x1;
        private final float x2;
        private final float x3;
        private final float y1;
        private final float y2;
        private final float y3;
        public CurveTo(float x1, float y1, float x2, float y2, float x3, float y3) {
            super(1, 0, 2, 0);
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
        }

        public static androidx.compose.ui.graphics.vector.PathNode.CurveTo copy$default(androidx.compose.ui.graphics.vector.PathNode.CurveTo pathNode$CurveTo, float f2, float f3, float f4, float f5, float f6, float f7, int i8, Object object9) {
            float obj1;
            float obj2;
            float obj3;
            float obj4;
            float obj5;
            float obj6;
            if (i8 & 1 != 0) {
                obj1 = curveTo.x1;
            }
            if (i8 & 2 != 0) {
                obj2 = curveTo.y1;
            }
            if (i8 & 4 != 0) {
                obj3 = curveTo.x2;
            }
            if (i8 & 8 != 0) {
                obj4 = curveTo.y2;
            }
            if (i8 & 16 != 0) {
                obj5 = curveTo.x3;
            }
            if (i8 &= 32 != 0) {
                obj6 = curveTo.y3;
            }
            return curveTo.copy(obj1, obj2, obj3, obj4, obj5, obj6);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component1() {
            return this.x1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component2() {
            return this.y1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component3() {
            return this.x2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component4() {
            return this.y2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component5() {
            return this.x3;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component6() {
            return this.y3;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final androidx.compose.ui.graphics.vector.PathNode.CurveTo copy(float f, float f2, float f3, float f4, float f5, float f6) {
            PathNode.CurveTo curveTo = new PathNode.CurveTo(f, f2, f3, f4, f5, f6);
            return curveTo;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof PathNode.CurveTo) {
                return i2;
            }
            Object obj = object;
            if (Float.compare(this.x1, obj.x1) != 0) {
                return i2;
            }
            if (Float.compare(this.y1, obj.y1) != 0) {
                return i2;
            }
            if (Float.compare(this.x2, obj.x2) != 0) {
                return i2;
            }
            if (Float.compare(this.y2, obj.y2) != 0) {
                return i2;
            }
            if (Float.compare(this.x3, obj.x3) != 0) {
                return i2;
            }
            if (Float.compare(this.y3, obj.y3) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getX1() {
            return this.x1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getX2() {
            return this.x2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getX3() {
            return this.x3;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getY1() {
            return this.y1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getY2() {
            return this.y2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getY3() {
            return this.y3;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public int hashCode() {
            return i10 += i16;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("CurveTo(x1=").append(this.x1).append(", y1=").append(this.y1).append(", x2=").append(this.x2).append(", y2=").append(this.y2).append(", x3=").append(this.x3).append(", y3=").append(this.y3).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0011", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$HorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "(F)V", "getX", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class HorizontalTo extends androidx.compose.ui.graphics.vector.PathNode {

        private final float x;
        public HorizontalTo(float x) {
            final int i3 = 0;
            super(i3, i3, 3, 0);
            this.x = x;
        }

        public static androidx.compose.ui.graphics.vector.PathNode.HorizontalTo copy$default(androidx.compose.ui.graphics.vector.PathNode.HorizontalTo pathNode$HorizontalTo, float f2, int i3, Object object4) {
            float obj1;
            if (i3 &= 1 != 0) {
                obj1 = horizontalTo.x;
            }
            return horizontalTo.copy(obj1);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component1() {
            return this.x;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final androidx.compose.ui.graphics.vector.PathNode.HorizontalTo copy(float f) {
            PathNode.HorizontalTo horizontalTo = new PathNode.HorizontalTo(f);
            return horizontalTo;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof PathNode.HorizontalTo) {
                return i2;
            }
            if (Float.compare(this.x, obj.x) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getX() {
            return this.x;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public int hashCode() {
            return Float.hashCode(this.x);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("HorizontalTo(x=").append(this.x).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0014", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$LineTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "y", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class LineTo extends androidx.compose.ui.graphics.vector.PathNode {

        private final float x;
        private final float y;
        public LineTo(float x, float y) {
            final int i3 = 0;
            super(i3, i3, 3, 0);
            this.x = x;
            this.y = y;
        }

        public static androidx.compose.ui.graphics.vector.PathNode.LineTo copy$default(androidx.compose.ui.graphics.vector.PathNode.LineTo pathNode$LineTo, float f2, float f3, int i4, Object object5) {
            float obj1;
            float obj2;
            if (i4 & 1 != 0) {
                obj1 = lineTo.x;
            }
            if (i4 &= 2 != 0) {
                obj2 = lineTo.y;
            }
            return lineTo.copy(obj1, obj2);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component1() {
            return this.x;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component2() {
            return this.y;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final androidx.compose.ui.graphics.vector.PathNode.LineTo copy(float f, float f2) {
            PathNode.LineTo lineTo = new PathNode.LineTo(f, f2);
            return lineTo;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof PathNode.LineTo) {
                return i2;
            }
            Object obj = object;
            if (Float.compare(this.x, obj.x) != 0) {
                return i2;
            }
            if (Float.compare(this.y, obj.y) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getX() {
            return this.x;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getY() {
            return this.y;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public int hashCode() {
            return i2 += i4;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("LineTo(x=").append(this.x).append(", y=").append(this.y).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0014", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$MoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "y", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class MoveTo extends androidx.compose.ui.graphics.vector.PathNode {

        private final float x;
        private final float y;
        public MoveTo(float x, float y) {
            final int i3 = 0;
            super(i3, i3, 3, 0);
            this.x = x;
            this.y = y;
        }

        public static androidx.compose.ui.graphics.vector.PathNode.MoveTo copy$default(androidx.compose.ui.graphics.vector.PathNode.MoveTo pathNode$MoveTo, float f2, float f3, int i4, Object object5) {
            float obj1;
            float obj2;
            if (i4 & 1 != 0) {
                obj1 = moveTo.x;
            }
            if (i4 &= 2 != 0) {
                obj2 = moveTo.y;
            }
            return moveTo.copy(obj1, obj2);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component1() {
            return this.x;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component2() {
            return this.y;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final androidx.compose.ui.graphics.vector.PathNode.MoveTo copy(float f, float f2) {
            PathNode.MoveTo moveTo = new PathNode.MoveTo(f, f2);
            return moveTo;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof PathNode.MoveTo) {
                return i2;
            }
            Object obj = object;
            if (Float.compare(this.x, obj.x) != 0) {
                return i2;
            }
            if (Float.compare(this.y, obj.y) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getX() {
            return this.x;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getY() {
            return this.y;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public int hashCode() {
            return i2 += i4;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("MoveTo(x=").append(this.x).append(", y=").append(this.y).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u001a", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$QuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x1", "", "y1", "x2", "y2", "(FFFF)V", "getX1", "()F", "getX2", "getY1", "getY2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class QuadTo extends androidx.compose.ui.graphics.vector.PathNode {

        private final float x1;
        private final float x2;
        private final float y1;
        private final float y2;
        public QuadTo(float x1, float y1, float x2, float y2) {
            final int i = 1;
            super(0, i, i, 0);
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public static androidx.compose.ui.graphics.vector.PathNode.QuadTo copy$default(androidx.compose.ui.graphics.vector.PathNode.QuadTo pathNode$QuadTo, float f2, float f3, float f4, float f5, int i6, Object object7) {
            float obj1;
            float obj2;
            float obj3;
            float obj4;
            if (i6 & 1 != 0) {
                obj1 = quadTo.x1;
            }
            if (i6 & 2 != 0) {
                obj2 = quadTo.y1;
            }
            if (i6 & 4 != 0) {
                obj3 = quadTo.x2;
            }
            if (i6 &= 8 != 0) {
                obj4 = quadTo.y2;
            }
            return quadTo.copy(obj1, obj2, obj3, obj4);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component1() {
            return this.x1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component2() {
            return this.y1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component3() {
            return this.x2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component4() {
            return this.y2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final androidx.compose.ui.graphics.vector.PathNode.QuadTo copy(float f, float f2, float f3, float f4) {
            PathNode.QuadTo quadTo = new PathNode.QuadTo(f, f2, f3, f4);
            return quadTo;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof PathNode.QuadTo) {
                return i2;
            }
            Object obj = object;
            if (Float.compare(this.x1, obj.x1) != 0) {
                return i2;
            }
            if (Float.compare(this.y1, obj.y1) != 0) {
                return i2;
            }
            if (Float.compare(this.x2, obj.x2) != 0) {
                return i2;
            }
            if (Float.compare(this.y2, obj.y2) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getX1() {
            return this.x1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getX2() {
            return this.x2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getY1() {
            return this.y1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getY2() {
            return this.y2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public int hashCode() {
            return i6 += i10;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("QuadTo(x1=").append(this.x1).append(", y1=").append(this.y1).append(", x2=").append(this.x2).append(", y2=").append(this.y2).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u001a", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x1", "", "y1", "x2", "y2", "(FFFF)V", "getX1", "()F", "getX2", "getY1", "getY2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ReflectiveCurveTo extends androidx.compose.ui.graphics.vector.PathNode {

        private final float x1;
        private final float x2;
        private final float y1;
        private final float y2;
        public ReflectiveCurveTo(float x1, float y1, float x2, float y2) {
            super(1, 0, 2, 0);
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public static androidx.compose.ui.graphics.vector.PathNode.ReflectiveCurveTo copy$default(androidx.compose.ui.graphics.vector.PathNode.ReflectiveCurveTo pathNode$ReflectiveCurveTo, float f2, float f3, float f4, float f5, int i6, Object object7) {
            float obj1;
            float obj2;
            float obj3;
            float obj4;
            if (i6 & 1 != 0) {
                obj1 = reflectiveCurveTo.x1;
            }
            if (i6 & 2 != 0) {
                obj2 = reflectiveCurveTo.y1;
            }
            if (i6 & 4 != 0) {
                obj3 = reflectiveCurveTo.x2;
            }
            if (i6 &= 8 != 0) {
                obj4 = reflectiveCurveTo.y2;
            }
            return reflectiveCurveTo.copy(obj1, obj2, obj3, obj4);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component1() {
            return this.x1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component2() {
            return this.y1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component3() {
            return this.x2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component4() {
            return this.y2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final androidx.compose.ui.graphics.vector.PathNode.ReflectiveCurveTo copy(float f, float f2, float f3, float f4) {
            PathNode.ReflectiveCurveTo reflectiveCurveTo = new PathNode.ReflectiveCurveTo(f, f2, f3, f4);
            return reflectiveCurveTo;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof PathNode.ReflectiveCurveTo) {
                return i2;
            }
            Object obj = object;
            if (Float.compare(this.x1, obj.x1) != 0) {
                return i2;
            }
            if (Float.compare(this.y1, obj.y1) != 0) {
                return i2;
            }
            if (Float.compare(this.x2, obj.x2) != 0) {
                return i2;
            }
            if (Float.compare(this.y2, obj.y2) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getX1() {
            return this.x1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getX2() {
            return this.x2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getY1() {
            return this.y1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getY2() {
            return this.y2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public int hashCode() {
            return i6 += i10;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("ReflectiveCurveTo(x1=").append(this.x1).append(", y1=").append(this.y1).append(", x2=").append(this.x2).append(", y2=").append(this.y2).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0014", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "y", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ReflectiveQuadTo extends androidx.compose.ui.graphics.vector.PathNode {

        private final float x;
        private final float y;
        public ReflectiveQuadTo(float x, float y) {
            final int i = 1;
            super(0, i, i, 0);
            this.x = x;
            this.y = y;
        }

        public static androidx.compose.ui.graphics.vector.PathNode.ReflectiveQuadTo copy$default(androidx.compose.ui.graphics.vector.PathNode.ReflectiveQuadTo pathNode$ReflectiveQuadTo, float f2, float f3, int i4, Object object5) {
            float obj1;
            float obj2;
            if (i4 & 1 != 0) {
                obj1 = reflectiveQuadTo.x;
            }
            if (i4 &= 2 != 0) {
                obj2 = reflectiveQuadTo.y;
            }
            return reflectiveQuadTo.copy(obj1, obj2);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component1() {
            return this.x;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component2() {
            return this.y;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final androidx.compose.ui.graphics.vector.PathNode.ReflectiveQuadTo copy(float f, float f2) {
            PathNode.ReflectiveQuadTo reflectiveQuadTo = new PathNode.ReflectiveQuadTo(f, f2);
            return reflectiveQuadTo;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof PathNode.ReflectiveQuadTo) {
                return i2;
            }
            Object obj = object;
            if (Float.compare(this.x, obj.x) != 0) {
                return i2;
            }
            if (Float.compare(this.y, obj.y) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getX() {
            return this.x;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getY() {
            return this.y;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public int hashCode() {
            return i2 += i4;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("ReflectiveQuadTo(x=").append(this.x).append(", y=").append(this.y).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0010R\u0011\u0010\u0008\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\r¨\u0006\"", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "horizontalEllipseRadius", "", "verticalEllipseRadius", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcStartDx", "arcStartDy", "(FFFZZFF)V", "getArcStartDx", "()F", "getArcStartDy", "getHorizontalEllipseRadius", "()Z", "getTheta", "getVerticalEllipseRadius", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RelativeArcTo extends androidx.compose.ui.graphics.vector.PathNode {

        private final float arcStartDx;
        private final float arcStartDy;
        private final float horizontalEllipseRadius;
        private final boolean isMoreThanHalf;
        private final boolean isPositiveArc;
        private final float theta;
        private final float verticalEllipseRadius;
        public RelativeArcTo(float horizontalEllipseRadius, float verticalEllipseRadius, float theta, boolean isMoreThanHalf, boolean isPositiveArc, float arcStartDx, float arcStartDy) {
            final int i3 = 0;
            super(i3, i3, 3, 0);
            this.horizontalEllipseRadius = horizontalEllipseRadius;
            this.verticalEllipseRadius = verticalEllipseRadius;
            this.theta = theta;
            this.isMoreThanHalf = isMoreThanHalf;
            this.isPositiveArc = isPositiveArc;
            this.arcStartDx = arcStartDx;
            this.arcStartDy = arcStartDy;
        }

        public static androidx.compose.ui.graphics.vector.PathNode.RelativeArcTo copy$default(androidx.compose.ui.graphics.vector.PathNode.RelativeArcTo pathNode$RelativeArcTo, float f2, float f3, float f4, boolean z5, boolean z6, float f7, float f8, int i9, Object object10) {
            float obj1;
            float obj2;
            float obj3;
            boolean obj4;
            boolean obj5;
            float obj6;
            float obj7;
            if (i9 & 1 != 0) {
                obj1 = relativeArcTo.horizontalEllipseRadius;
            }
            if (i9 & 2 != 0) {
                obj2 = relativeArcTo.verticalEllipseRadius;
            }
            if (i9 & 4 != 0) {
                obj3 = relativeArcTo.theta;
            }
            if (i9 & 8 != 0) {
                obj4 = relativeArcTo.isMoreThanHalf;
            }
            if (i9 & 16 != 0) {
                obj5 = relativeArcTo.isPositiveArc;
            }
            if (i9 & 32 != 0) {
                obj6 = relativeArcTo.arcStartDx;
            }
            if (i9 &= 64 != 0) {
                obj7 = relativeArcTo.arcStartDy;
            }
            return relativeArcTo.copy(obj1, obj2, obj3, obj4, obj5, obj6, obj7);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component1() {
            return this.horizontalEllipseRadius;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component2() {
            return this.verticalEllipseRadius;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component3() {
            return this.theta;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final boolean component4() {
            return this.isMoreThanHalf;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final boolean component5() {
            return this.isPositiveArc;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component6() {
            return this.arcStartDx;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component7() {
            return this.arcStartDy;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final androidx.compose.ui.graphics.vector.PathNode.RelativeArcTo copy(float f, float f2, float f3, boolean z4, boolean z5, float f6, float f7) {
            PathNode.RelativeArcTo relativeArcTo = new PathNode.RelativeArcTo(f, f2, f3, z4, z5, f6, f7);
            return relativeArcTo;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof PathNode.RelativeArcTo) {
                return i2;
            }
            Object obj = object;
            if (Float.compare(this.horizontalEllipseRadius, obj.horizontalEllipseRadius) != 0) {
                return i2;
            }
            if (Float.compare(this.verticalEllipseRadius, obj.verticalEllipseRadius) != 0) {
                return i2;
            }
            if (Float.compare(this.theta, obj.theta) != 0) {
                return i2;
            }
            if (this.isMoreThanHalf != obj.isMoreThanHalf) {
                return i2;
            }
            if (this.isPositiveArc != obj.isPositiveArc) {
                return i2;
            }
            if (Float.compare(this.arcStartDx, obj.arcStartDx) != 0) {
                return i2;
            }
            if (Float.compare(this.arcStartDy, obj.arcStartDy) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getArcStartDx() {
            return this.arcStartDx;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getArcStartDy() {
            return this.arcStartDy;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getHorizontalEllipseRadius() {
            return this.horizontalEllipseRadius;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getTheta() {
            return this.theta;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getVerticalEllipseRadius() {
            return this.verticalEllipseRadius;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public int hashCode() {
            return i6 += i19;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final boolean isMoreThanHalf() {
            return this.isMoreThanHalf;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final boolean isPositiveArc() {
            return this.isPositiveArc;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("RelativeArcTo(horizontalEllipseRadius=").append(this.horizontalEllipseRadius).append(", verticalEllipseRadius=").append(this.verticalEllipseRadius).append(", theta=").append(this.theta).append(", isMoreThanHalf=").append(this.isMoreThanHalf).append(", isPositiveArc=").append(this.isPositiveArc).append(", arcStartDx=").append(this.arcStartDx).append(", arcStartDy=").append(this.arcStartDy).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000b¨\u0006 ", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx1", "", "dy1", "dx2", "dy2", "dx3", "dy3", "(FFFFFF)V", "getDx1", "()F", "getDx2", "getDx3", "getDy1", "getDy2", "getDy3", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RelativeCurveTo extends androidx.compose.ui.graphics.vector.PathNode {

        private final float dx1;
        private final float dx2;
        private final float dx3;
        private final float dy1;
        private final float dy2;
        private final float dy3;
        public RelativeCurveTo(float dx1, float dy1, float dx2, float dy2, float dx3, float dy3) {
            super(1, 0, 2, 0);
            this.dx1 = dx1;
            this.dy1 = dy1;
            this.dx2 = dx2;
            this.dy2 = dy2;
            this.dx3 = dx3;
            this.dy3 = dy3;
        }

        public static androidx.compose.ui.graphics.vector.PathNode.RelativeCurveTo copy$default(androidx.compose.ui.graphics.vector.PathNode.RelativeCurveTo pathNode$RelativeCurveTo, float f2, float f3, float f4, float f5, float f6, float f7, int i8, Object object9) {
            float obj1;
            float obj2;
            float obj3;
            float obj4;
            float obj5;
            float obj6;
            if (i8 & 1 != 0) {
                obj1 = relativeCurveTo.dx1;
            }
            if (i8 & 2 != 0) {
                obj2 = relativeCurveTo.dy1;
            }
            if (i8 & 4 != 0) {
                obj3 = relativeCurveTo.dx2;
            }
            if (i8 & 8 != 0) {
                obj4 = relativeCurveTo.dy2;
            }
            if (i8 & 16 != 0) {
                obj5 = relativeCurveTo.dx3;
            }
            if (i8 &= 32 != 0) {
                obj6 = relativeCurveTo.dy3;
            }
            return relativeCurveTo.copy(obj1, obj2, obj3, obj4, obj5, obj6);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component1() {
            return this.dx1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component2() {
            return this.dy1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component3() {
            return this.dx2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component4() {
            return this.dy2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component5() {
            return this.dx3;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component6() {
            return this.dy3;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final androidx.compose.ui.graphics.vector.PathNode.RelativeCurveTo copy(float f, float f2, float f3, float f4, float f5, float f6) {
            PathNode.RelativeCurveTo relativeCurveTo = new PathNode.RelativeCurveTo(f, f2, f3, f4, f5, f6);
            return relativeCurveTo;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof PathNode.RelativeCurveTo) {
                return i2;
            }
            Object obj = object;
            if (Float.compare(this.dx1, obj.dx1) != 0) {
                return i2;
            }
            if (Float.compare(this.dy1, obj.dy1) != 0) {
                return i2;
            }
            if (Float.compare(this.dx2, obj.dx2) != 0) {
                return i2;
            }
            if (Float.compare(this.dy2, obj.dy2) != 0) {
                return i2;
            }
            if (Float.compare(this.dx3, obj.dx3) != 0) {
                return i2;
            }
            if (Float.compare(this.dy3, obj.dy3) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDx1() {
            return this.dx1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDx2() {
            return this.dx2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDx3() {
            return this.dx3;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDy1() {
            return this.dy1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDy2() {
            return this.dy2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDy3() {
            return this.dy3;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public int hashCode() {
            return i10 += i16;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("RelativeCurveTo(dx1=").append(this.dx1).append(", dy1=").append(this.dy1).append(", dx2=").append(this.dx2).append(", dy2=").append(this.dy2).append(", dx3=").append(this.dx3).append(", dy3=").append(this.dy3).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0011", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeHorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "(F)V", "getDx", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RelativeHorizontalTo extends androidx.compose.ui.graphics.vector.PathNode {

        private final float dx;
        public RelativeHorizontalTo(float dx) {
            final int i3 = 0;
            super(i3, i3, 3, 0);
            this.dx = dx;
        }

        public static androidx.compose.ui.graphics.vector.PathNode.RelativeHorizontalTo copy$default(androidx.compose.ui.graphics.vector.PathNode.RelativeHorizontalTo pathNode$RelativeHorizontalTo, float f2, int i3, Object object4) {
            float obj1;
            if (i3 &= 1 != 0) {
                obj1 = relativeHorizontalTo.dx;
            }
            return relativeHorizontalTo.copy(obj1);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component1() {
            return this.dx;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final androidx.compose.ui.graphics.vector.PathNode.RelativeHorizontalTo copy(float f) {
            PathNode.RelativeHorizontalTo relativeHorizontalTo = new PathNode.RelativeHorizontalTo(f);
            return relativeHorizontalTo;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof PathNode.RelativeHorizontalTo) {
                return i2;
            }
            if (Float.compare(this.dx, obj.dx) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDx() {
            return this.dx;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public int hashCode() {
            return Float.hashCode(this.dx);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("RelativeHorizontalTo(dx=").append(this.dx).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0014", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeLineTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "dy", "(FF)V", "getDx", "()F", "getDy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RelativeLineTo extends androidx.compose.ui.graphics.vector.PathNode {

        private final float dx;
        private final float dy;
        public RelativeLineTo(float dx, float dy) {
            final int i3 = 0;
            super(i3, i3, 3, 0);
            this.dx = dx;
            this.dy = dy;
        }

        public static androidx.compose.ui.graphics.vector.PathNode.RelativeLineTo copy$default(androidx.compose.ui.graphics.vector.PathNode.RelativeLineTo pathNode$RelativeLineTo, float f2, float f3, int i4, Object object5) {
            float obj1;
            float obj2;
            if (i4 & 1 != 0) {
                obj1 = relativeLineTo.dx;
            }
            if (i4 &= 2 != 0) {
                obj2 = relativeLineTo.dy;
            }
            return relativeLineTo.copy(obj1, obj2);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component1() {
            return this.dx;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component2() {
            return this.dy;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final androidx.compose.ui.graphics.vector.PathNode.RelativeLineTo copy(float f, float f2) {
            PathNode.RelativeLineTo relativeLineTo = new PathNode.RelativeLineTo(f, f2);
            return relativeLineTo;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof PathNode.RelativeLineTo) {
                return i2;
            }
            Object obj = object;
            if (Float.compare(this.dx, obj.dx) != 0) {
                return i2;
            }
            if (Float.compare(this.dy, obj.dy) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDx() {
            return this.dx;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDy() {
            return this.dy;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public int hashCode() {
            return i2 += i4;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("RelativeLineTo(dx=").append(this.dx).append(", dy=").append(this.dy).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0014", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeMoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "dy", "(FF)V", "getDx", "()F", "getDy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RelativeMoveTo extends androidx.compose.ui.graphics.vector.PathNode {

        private final float dx;
        private final float dy;
        public RelativeMoveTo(float dx, float dy) {
            final int i3 = 0;
            super(i3, i3, 3, 0);
            this.dx = dx;
            this.dy = dy;
        }

        public static androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo copy$default(androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo pathNode$RelativeMoveTo, float f2, float f3, int i4, Object object5) {
            float obj1;
            float obj2;
            if (i4 & 1 != 0) {
                obj1 = relativeMoveTo.dx;
            }
            if (i4 &= 2 != 0) {
                obj2 = relativeMoveTo.dy;
            }
            return relativeMoveTo.copy(obj1, obj2);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component1() {
            return this.dx;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component2() {
            return this.dy;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo copy(float f, float f2) {
            PathNode.RelativeMoveTo relativeMoveTo = new PathNode.RelativeMoveTo(f, f2);
            return relativeMoveTo;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof PathNode.RelativeMoveTo) {
                return i2;
            }
            Object obj = object;
            if (Float.compare(this.dx, obj.dx) != 0) {
                return i2;
            }
            if (Float.compare(this.dy, obj.dy) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDx() {
            return this.dx;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDy() {
            return this.dy;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public int hashCode() {
            return i2 += i4;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("RelativeMoveTo(dx=").append(this.dx).append(", dy=").append(this.dy).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u001a", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx1", "", "dy1", "dx2", "dy2", "(FFFF)V", "getDx1", "()F", "getDx2", "getDy1", "getDy2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RelativeQuadTo extends androidx.compose.ui.graphics.vector.PathNode {

        private final float dx1;
        private final float dx2;
        private final float dy1;
        private final float dy2;
        public RelativeQuadTo(float dx1, float dy1, float dx2, float dy2) {
            final int i = 1;
            super(0, i, i, 0);
            this.dx1 = dx1;
            this.dy1 = dy1;
            this.dx2 = dx2;
            this.dy2 = dy2;
        }

        public static androidx.compose.ui.graphics.vector.PathNode.RelativeQuadTo copy$default(androidx.compose.ui.graphics.vector.PathNode.RelativeQuadTo pathNode$RelativeQuadTo, float f2, float f3, float f4, float f5, int i6, Object object7) {
            float obj1;
            float obj2;
            float obj3;
            float obj4;
            if (i6 & 1 != 0) {
                obj1 = relativeQuadTo.dx1;
            }
            if (i6 & 2 != 0) {
                obj2 = relativeQuadTo.dy1;
            }
            if (i6 & 4 != 0) {
                obj3 = relativeQuadTo.dx2;
            }
            if (i6 &= 8 != 0) {
                obj4 = relativeQuadTo.dy2;
            }
            return relativeQuadTo.copy(obj1, obj2, obj3, obj4);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component1() {
            return this.dx1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component2() {
            return this.dy1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component3() {
            return this.dx2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component4() {
            return this.dy2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final androidx.compose.ui.graphics.vector.PathNode.RelativeQuadTo copy(float f, float f2, float f3, float f4) {
            PathNode.RelativeQuadTo relativeQuadTo = new PathNode.RelativeQuadTo(f, f2, f3, f4);
            return relativeQuadTo;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof PathNode.RelativeQuadTo) {
                return i2;
            }
            Object obj = object;
            if (Float.compare(this.dx1, obj.dx1) != 0) {
                return i2;
            }
            if (Float.compare(this.dy1, obj.dy1) != 0) {
                return i2;
            }
            if (Float.compare(this.dx2, obj.dx2) != 0) {
                return i2;
            }
            if (Float.compare(this.dy2, obj.dy2) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDx1() {
            return this.dx1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDx2() {
            return this.dx2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDy1() {
            return this.dy1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDy2() {
            return this.dy2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public int hashCode() {
            return i6 += i10;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("RelativeQuadTo(dx1=").append(this.dx1).append(", dy1=").append(this.dy1).append(", dx2=").append(this.dx2).append(", dy2=").append(this.dy2).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u001a", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx1", "", "dy1", "dx2", "dy2", "(FFFF)V", "getDx1", "()F", "getDx2", "getDy1", "getDy2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RelativeReflectiveCurveTo extends androidx.compose.ui.graphics.vector.PathNode {

        private final float dx1;
        private final float dx2;
        private final float dy1;
        private final float dy2;
        public RelativeReflectiveCurveTo(float dx1, float dy1, float dx2, float dy2) {
            super(1, 0, 2, 0);
            this.dx1 = dx1;
            this.dy1 = dy1;
            this.dx2 = dx2;
            this.dy2 = dy2;
        }

        public static androidx.compose.ui.graphics.vector.PathNode.RelativeReflectiveCurveTo copy$default(androidx.compose.ui.graphics.vector.PathNode.RelativeReflectiveCurveTo pathNode$RelativeReflectiveCurveTo, float f2, float f3, float f4, float f5, int i6, Object object7) {
            float obj1;
            float obj2;
            float obj3;
            float obj4;
            if (i6 & 1 != 0) {
                obj1 = relativeReflectiveCurveTo.dx1;
            }
            if (i6 & 2 != 0) {
                obj2 = relativeReflectiveCurveTo.dy1;
            }
            if (i6 & 4 != 0) {
                obj3 = relativeReflectiveCurveTo.dx2;
            }
            if (i6 &= 8 != 0) {
                obj4 = relativeReflectiveCurveTo.dy2;
            }
            return relativeReflectiveCurveTo.copy(obj1, obj2, obj3, obj4);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component1() {
            return this.dx1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component2() {
            return this.dy1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component3() {
            return this.dx2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component4() {
            return this.dy2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final androidx.compose.ui.graphics.vector.PathNode.RelativeReflectiveCurveTo copy(float f, float f2, float f3, float f4) {
            PathNode.RelativeReflectiveCurveTo relativeReflectiveCurveTo = new PathNode.RelativeReflectiveCurveTo(f, f2, f3, f4);
            return relativeReflectiveCurveTo;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof PathNode.RelativeReflectiveCurveTo) {
                return i2;
            }
            Object obj = object;
            if (Float.compare(this.dx1, obj.dx1) != 0) {
                return i2;
            }
            if (Float.compare(this.dy1, obj.dy1) != 0) {
                return i2;
            }
            if (Float.compare(this.dx2, obj.dx2) != 0) {
                return i2;
            }
            if (Float.compare(this.dy2, obj.dy2) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDx1() {
            return this.dx1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDx2() {
            return this.dx2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDy1() {
            return this.dy1;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDy2() {
            return this.dy2;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public int hashCode() {
            return i6 += i10;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("RelativeReflectiveCurveTo(dx1=").append(this.dx1).append(", dy1=").append(this.dy1).append(", dx2=").append(this.dx2).append(", dy2=").append(this.dy2).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0014", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "dy", "(FF)V", "getDx", "()F", "getDy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RelativeReflectiveQuadTo extends androidx.compose.ui.graphics.vector.PathNode {

        private final float dx;
        private final float dy;
        public RelativeReflectiveQuadTo(float dx, float dy) {
            final int i = 1;
            super(0, i, i, 0);
            this.dx = dx;
            this.dy = dy;
        }

        public static androidx.compose.ui.graphics.vector.PathNode.RelativeReflectiveQuadTo copy$default(androidx.compose.ui.graphics.vector.PathNode.RelativeReflectiveQuadTo pathNode$RelativeReflectiveQuadTo, float f2, float f3, int i4, Object object5) {
            float obj1;
            float obj2;
            if (i4 & 1 != 0) {
                obj1 = relativeReflectiveQuadTo.dx;
            }
            if (i4 &= 2 != 0) {
                obj2 = relativeReflectiveQuadTo.dy;
            }
            return relativeReflectiveQuadTo.copy(obj1, obj2);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component1() {
            return this.dx;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component2() {
            return this.dy;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final androidx.compose.ui.graphics.vector.PathNode.RelativeReflectiveQuadTo copy(float f, float f2) {
            PathNode.RelativeReflectiveQuadTo relativeReflectiveQuadTo = new PathNode.RelativeReflectiveQuadTo(f, f2);
            return relativeReflectiveQuadTo;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof PathNode.RelativeReflectiveQuadTo) {
                return i2;
            }
            Object obj = object;
            if (Float.compare(this.dx, obj.dx) != 0) {
                return i2;
            }
            if (Float.compare(this.dy, obj.dy) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDx() {
            return this.dx;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDy() {
            return this.dy;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public int hashCode() {
            return i2 += i4;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("RelativeReflectiveQuadTo(dx=").append(this.dx).append(", dy=").append(this.dy).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0011", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeVerticalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dy", "", "(F)V", "getDy", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RelativeVerticalTo extends androidx.compose.ui.graphics.vector.PathNode {

        private final float dy;
        public RelativeVerticalTo(float dy) {
            final int i3 = 0;
            super(i3, i3, 3, 0);
            this.dy = dy;
        }

        public static androidx.compose.ui.graphics.vector.PathNode.RelativeVerticalTo copy$default(androidx.compose.ui.graphics.vector.PathNode.RelativeVerticalTo pathNode$RelativeVerticalTo, float f2, int i3, Object object4) {
            float obj1;
            if (i3 &= 1 != 0) {
                obj1 = relativeVerticalTo.dy;
            }
            return relativeVerticalTo.copy(obj1);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component1() {
            return this.dy;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final androidx.compose.ui.graphics.vector.PathNode.RelativeVerticalTo copy(float f) {
            PathNode.RelativeVerticalTo relativeVerticalTo = new PathNode.RelativeVerticalTo(f);
            return relativeVerticalTo;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof PathNode.RelativeVerticalTo) {
                return i2;
            }
            if (Float.compare(this.dy, obj.dy) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getDy() {
            return this.dy;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public int hashCode() {
            return Float.hashCode(this.dy);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("RelativeVerticalTo(dy=").append(this.dy).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0011", d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$VerticalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "y", "", "(F)V", "getY", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class VerticalTo extends androidx.compose.ui.graphics.vector.PathNode {

        private final float y;
        public VerticalTo(float y) {
            final int i3 = 0;
            super(i3, i3, 3, 0);
            this.y = y;
        }

        public static androidx.compose.ui.graphics.vector.PathNode.VerticalTo copy$default(androidx.compose.ui.graphics.vector.PathNode.VerticalTo pathNode$VerticalTo, float f2, int i3, Object object4) {
            float obj1;
            if (i3 &= 1 != 0) {
                obj1 = verticalTo.y;
            }
            return verticalTo.copy(obj1);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float component1() {
            return this.y;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final androidx.compose.ui.graphics.vector.PathNode.VerticalTo copy(float f) {
            PathNode.VerticalTo verticalTo = new PathNode.VerticalTo(f);
            return verticalTo;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof PathNode.VerticalTo) {
                return i2;
            }
            if (Float.compare(this.y, obj.y) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public final float getY() {
            return this.y;
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public int hashCode() {
            return Float.hashCode(this.y);
        }

        @Override // androidx.compose.ui.graphics.vector.PathNode
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("VerticalTo(y=").append(this.y).append(')').toString();
        }
    }
    private PathNode(boolean isCurve, boolean isQuad) {
        super();
        this.isCurve = isCurve;
        this.isQuad = isQuad;
    }

    public PathNode(boolean z, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        int obj3;
        final int i = 0;
        obj2 = i3 & 1 != 0 ? i : obj2;
        obj3 = i3 &= 2 != 0 ? i : obj3;
        super(obj2, obj3, 0);
    }

    public PathNode(boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(z, z2);
    }

    public final boolean isCurve() {
        return this.isCurve;
    }

    public final boolean isQuad() {
        return this.isQuad;
    }
}
