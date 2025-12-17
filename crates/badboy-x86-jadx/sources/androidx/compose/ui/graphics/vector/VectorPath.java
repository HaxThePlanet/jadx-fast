package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0099\u0001\u0008\u0000\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000c\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000c\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u000c\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000c\u0012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u000c\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u000c¢\u0006\u0002\u0010\u0018J\u0013\u0010-\u001a\u00020.2\u0008\u0010/\u001a\u0004\u0018\u000100H\u0096\u0002J\u0008\u00101\u001a\u000202H\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0019\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010#\u001a\u0004\u0008!\u0010\"R\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010\u001cR\u0019\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010#\u001a\u0004\u0008&\u0010\"R\u0019\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010#\u001a\u0004\u0008'\u0010\"R\u0011\u0010\u0014\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010\u001cR\u0011\u0010\u0016\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\u001cR\u0011\u0010\u0017\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u001c\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00063", d2 = {"Landroidx/compose/ui/graphics/vector/VectorPath;", "Landroidx/compose/ui/graphics/vector/VectorNode;", "name", "", "pathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "(Ljava/lang/String;Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFill", "()Landroidx/compose/ui/graphics/Brush;", "getFillAlpha", "()F", "getName", "()Ljava/lang/String;", "getPathData", "()Ljava/util/List;", "getPathFillType-Rg-k1Os", "()I", "I", "getStroke", "getStrokeAlpha", "getStrokeLineCap-KaPHkGw", "getStrokeLineJoin-LxFBmk8", "getStrokeLineMiter", "getStrokeLineWidth", "getTrimPathEnd", "getTrimPathOffset", "getTrimPathStart", "equals", "", "other", "", "hashCode", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VectorPath extends androidx.compose.ui.graphics.vector.VectorNode {

    public static final int $stable;
    private final Brush fill;
    private final float fillAlpha;
    private final String name;
    private final List<androidx.compose.ui.graphics.vector.PathNode> pathData;
    private final int pathFillType;
    private final Brush stroke;
    private final float strokeAlpha;
    private final int strokeLineCap;
    private final int strokeLineJoin;
    private final float strokeLineMiter;
    private final float strokeLineWidth;
    private final float trimPathEnd;
    private final float trimPathOffset;
    private final float trimPathStart;
    static {
    }

    private VectorPath(String name, List<? extends androidx.compose.ui.graphics.vector.PathNode> pathData, int pathFillType, Brush fill, float fillAlpha, Brush stroke, float strokeAlpha, float strokeLineWidth, int strokeLineCap, int strokeLineJoin, float strokeLineMiter, float trimPathStart, float trimPathEnd, float trimPathOffset) {
        super(0);
        this.name = name;
        this.pathData = pathData;
        this.pathFillType = pathFillType;
        this.fill = fill;
        this.fillAlpha = fillAlpha;
        this.stroke = stroke;
        this.strokeAlpha = strokeAlpha;
        this.strokeLineWidth = strokeLineWidth;
        this.strokeLineCap = strokeLineCap;
        this.strokeLineJoin = strokeLineJoin;
        this.strokeLineMiter = strokeLineMiter;
        this.trimPathStart = trimPathStart;
        this.trimPathEnd = trimPathEnd;
        this.trimPathOffset = trimPathOffset;
    }

    public VectorPath(String string, List list2, int i3, Brush brush4, float f5, Brush brush6, float f7, float f8, int i9, int i10, float f11, float f12, float f13, float f14, int i15, DefaultConstructorMarker defaultConstructorMarker16) {
        int str2;
        int defaultStrokeLineCap;
        int defaultStrokeLineJoin;
        int i5;
        String str;
        int i11;
        int i12;
        int i2;
        int i;
        int i13;
        int i8;
        int i4;
        int i6;
        int i16;
        int i7;
        int i14;
        int i17 = i15;
        str = i17 & 1 != 0 ? str2 : string;
        int i26 = 0;
        i11 = i17 & 8 != 0 ? i26 : brush4;
        int i28 = 1065353216;
        i12 = i17 & 16 != 0 ? i28 : f5;
        i2 = i17 & 32 != 0 ? i26 : brush6;
        i = i17 & 64 != 0 ? i28 : f7;
        int i27 = 0;
        i13 = i17 & 128 != 0 ? i27 : f8;
        if (i17 & 256 != 0) {
            i8 = defaultStrokeLineCap;
        } else {
            i8 = i9;
        }
        if (i17 & 512 != 0) {
            i4 = defaultStrokeLineJoin;
        } else {
            i4 = i10;
        }
        i6 = i17 & 1024 != 0 ? i5 : f11;
        i16 = i17 & 2048 != 0 ? i27 : f12;
        i7 = i17 & 4096 != 0 ? i28 : f13;
        i14 = i17 &= 8192 != 0 ? i27 : f14;
        super(str, list2, i3, i11, i12, i2, i, i13, i8, i4, i6, i16, i7, i14, 0);
    }

    public VectorPath(String string, List list2, int i3, Brush brush4, float f5, Brush brush6, float f7, float f8, int i9, int i10, float f11, float f12, float f13, float f14, DefaultConstructorMarker defaultConstructorMarker15) {
        super(string, list2, i3, brush4, f5, brush6, f7, f8, i9, i10, f11, f12, f13, f14);
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public boolean equals(Object other) {
        int i2;
        int i3;
        int i4;
        int i7;
        int i6;
        int i5;
        int i;
        Class class;
        Class class2;
        final int i8 = 1;
        if (this == other) {
            return i8;
        }
        final int i9 = 0;
        if (other != null) {
            if (getClass() != other.getClass()) {
            } else {
                Object obj = other;
                if (!Intrinsics.areEqual(this.name, obj2.name)) {
                    return i9;
                }
                if (!Intrinsics.areEqual(this.fill, obj3.fill)) {
                    return i9;
                }
                i2 = Float.compare(fillAlpha, fillAlpha2) == 0 ? i8 : i9;
                if (i2 == 0) {
                    return i9;
                }
                if (!Intrinsics.areEqual(this.stroke, obj5.stroke)) {
                    return i9;
                }
                i3 = Float.compare(strokeAlpha, strokeAlpha2) == 0 ? i8 : i9;
                if (i3 == 0) {
                    return i9;
                }
                i4 = Float.compare(strokeLineWidth, strokeLineWidth2) == 0 ? i8 : i9;
                if (i4 == 0) {
                    return i9;
                }
                if (!StrokeCap.equals-impl0(this.strokeLineCap, obj8.strokeLineCap)) {
                    return i9;
                }
                if (!StrokeJoin.equals-impl0(this.strokeLineJoin, obj9.strokeLineJoin)) {
                    return i9;
                }
                i7 = Float.compare(strokeLineMiter, strokeLineMiter2) == 0 ? i8 : i9;
                if (i7 == 0) {
                    return i9;
                }
                i6 = Float.compare(trimPathStart, trimPathStart2) == 0 ? i8 : i9;
                if (i6 == 0) {
                    return i9;
                }
                i5 = Float.compare(trimPathEnd, trimPathEnd2) == 0 ? i8 : i9;
                if (i5 == 0) {
                    return i9;
                }
                i = Float.compare(trimPathOffset, trimPathOffset2) == 0 ? i8 : i9;
                if (i == 0) {
                    return i9;
                }
                if (!PathFillType.equals-impl0(this.pathFillType, obj14.pathFillType)) {
                    return i9;
                }
                if (!Intrinsics.areEqual(this.pathData, obj15.pathData)) {
                    return i9;
                }
            }
            return i8;
        }
        return i9;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final Brush getFill() {
        return this.fill;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final float getFillAlpha() {
        return this.fillAlpha;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final String getName() {
        return this.name;
    }

    public final List<androidx.compose.ui.graphics.vector.PathNode> getPathData() {
        return this.pathData;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final int getPathFillType-Rg-k1Os() {
        return this.pathFillType;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final Brush getStroke() {
        return this.stroke;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final float getStrokeAlpha() {
        return this.strokeAlpha;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final int getStrokeLineCap-KaPHkGw() {
        return this.strokeLineCap;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final int getStrokeLineJoin-LxFBmk8() {
        return this.strokeLineJoin;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final float getStrokeLineMiter() {
        return this.strokeLineMiter;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final float getStrokeLineWidth() {
        return this.strokeLineWidth;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final float getTrimPathEnd() {
        return this.trimPathEnd;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final float getTrimPathOffset() {
        return this.trimPathOffset;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final float getTrimPathStart() {
        return this.trimPathStart;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public int hashCode() {
        int i;
        int i2;
        Brush fill = this.fill;
        if (fill != null) {
            i = fill.hashCode();
        } else {
            i = i2;
        }
        Brush stroke = this.stroke;
        if (stroke != null) {
            i2 = stroke.hashCode();
        }
        return result12 += i28;
    }
}
