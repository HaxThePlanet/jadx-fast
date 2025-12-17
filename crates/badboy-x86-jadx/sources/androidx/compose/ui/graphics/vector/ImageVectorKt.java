package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Brush;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u001a\u0086\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00052\u0008\u0008\u0002\u0010\t\u001a\u00020\u00052\u0008\u0008\u0002\u0010\n\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00052\u000e\u0008\u0002\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\r2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0008\u0012H\u0086\u0008\u001a\u0098\u0001\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00052\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0008\u0012H\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$\u001a'\u0010%\u001a\u0002H&\"\u0004\u0008\u0000\u0010&*\u0012\u0012\u0004\u0012\u0002H&0'j\u0008\u0012\u0004\u0012\u0002H&`(H\u0002¢\u0006\u0002\u0010)\u001a'\u0010*\u001a\u0002H&\"\u0004\u0008\u0000\u0010&*\u0012\u0012\u0004\u0012\u0002H&0'j\u0008\u0012\u0004\u0012\u0002H&`(H\u0002¢\u0006\u0002\u0010)\u001a/\u0010+\u001a\u00020,\"\u0004\u0008\u0000\u0010&*\u0012\u0012\u0004\u0012\u0002H&0'j\u0008\u0012\u0004\u0012\u0002H&`(2\u0006\u0010-\u001a\u0002H&H\u0002¢\u0006\u0002\u0010.\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006/", d2 = {"group", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "name", "", "rotate", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "path", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "pathBuilder", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "path-R_LF-3I", "(Landroidx/compose/ui/graphics/vector/ImageVector$Builder;Ljava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "peek", "T", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)Ljava/lang/Object;", "pop", "push", "", "value", "(Ljava/util/ArrayList;Ljava/lang/Object;)Z", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ImageVectorKt {
    public static final Object access$peek(ArrayList $receiver) {
        return ImageVectorKt.peek($receiver);
    }

    public static final Object access$pop(ArrayList $receiver) {
        return ImageVectorKt.pop($receiver);
    }

    public static final boolean access$push(ArrayList $receiver, Object value) {
        return ImageVectorKt.push($receiver, value);
    }

    public static final androidx.compose.ui.graphics.vector.ImageVector.Builder group(androidx.compose.ui.graphics.vector.ImageVector.Builder $this$group, String name, float rotate, float pivotX, float pivotY, float scaleX, float scaleY, float translationX, float translationY, List<? extends androidx.compose.ui.graphics.vector.PathNode> clipPathData, Function1<? super androidx.compose.ui.graphics.vector.ImageVector.Builder, Unit> block) {
        final int i = 0;
        final Object obj = $this$group;
        final int i2 = 0;
        obj.addGroup(name, rotate, pivotX, pivotY, scaleX, scaleY, translationX, translationY, clipPathData);
        block.invoke(obj);
        obj.clearGroup();
        return $this$group;
    }

    public static androidx.compose.ui.graphics.vector.ImageVector.Builder group$default(androidx.compose.ui.graphics.vector.ImageVector.Builder $this$group_u24default, String name, float rotate, float pivotX, float pivotY, float scaleX, float scaleY, float translationX, float translationY, List clipPathData, Function1 block, int i12, Object object13) {
        String str;
        int i4;
        int i;
        int i2;
        int i6;
        int i7;
        int i3;
        int i5;
        List list;
        String obj12;
        int obj13;
        int i8 = i12;
        str = i8 & 1 != 0 ? obj12 : name;
        i4 = i8 & 2 != 0 ? obj13 : rotate;
        i = i8 & 4 != 0 ? obj12 : pivotX;
        i2 = i8 & 8 != 0 ? obj12 : pivotY;
        i6 = i8 & 16 != 0 ? obj12 : scaleX;
        i7 = i8 & 32 != 0 ? obj12 : scaleY;
        i3 = i8 & 64 != 0 ? obj12 : translationX;
        i5 = i8 & 128 != 0 ? obj12 : translationY;
        if (i8 & 256 != 0) {
            list = obj12;
        } else {
            list = clipPathData;
        }
        obj12 = 0;
        Object obj = $this$group_u24default;
        obj13 = 0;
        obj.addGroup(str, i4, i, i2, i6, i7, i3, i5, list);
        block.invoke(obj);
        obj.clearGroup();
        return $this$group_u24default;
    }

    public static final androidx.compose.ui.graphics.vector.ImageVector.Builder path-R_LF-3I(androidx.compose.ui.graphics.vector.ImageVector.Builder $this$path_u2dR_LF_u2d3I, String name, Brush fill, float fillAlpha, Brush stroke, float strokeAlpha, float strokeLineWidth, int strokeLineCap, int strokeLineJoin, float strokeLineMiter, int pathFillType, Function1<? super androidx.compose.ui.graphics.vector.PathBuilder, Unit> pathBuilder) {
        final int i = 0;
        int i2 = 0;
        PathBuilder pathBuilder2 = new PathBuilder();
        final int i3 = 0;
        pathBuilder.invoke(pathBuilder2);
        return ImageVector.Builder.addPath-oIyEayM$default($this$path_u2dR_LF_u2d3I, pathBuilder2.getNodes(), pathFillType, name, fill, fillAlpha, stroke, strokeAlpha, strokeLineWidth, strokeLineCap, strokeLineJoin, strokeLineMiter, 0, 0, 0, 14336, 0);
    }

    public static androidx.compose.ui.graphics.vector.ImageVector.Builder path-R_LF-3I$default(androidx.compose.ui.graphics.vector.ImageVector.Builder $this$path_u2dR_LF_u2d3I_u24default, String name, Brush fill, float fillAlpha, Brush stroke, float strokeAlpha, float strokeLineWidth, int strokeLineCap, int strokeLineJoin, float strokeLineMiter, int pathFillType, Function1 pathBuilder, int i13, Object object14) {
        int defaultFillType;
        int str;
        int i;
        int i16;
        int i12;
        int i11;
        int i9;
        int defaultStrokeLineCap;
        int defaultStrokeLineJoin;
        int i6;
        int i7;
        String str2;
        int i2;
        int i3;
        int i10;
        int i15;
        int i14;
        int i4;
        int i5;
        int i8;
        int i17 = i13;
        str2 = i17 & 1 != 0 ? str : name;
        i2 = i17 & 2 != 0 ? i : fill;
        i3 = i17 & 4 != 0 ? i16 : fillAlpha;
        i10 = i17 & 8 != 0 ? i12 : stroke;
        i15 = i17 & 16 != 0 ? i11 : strokeAlpha;
        i14 = i17 & 32 != 0 ? i9 : strokeLineWidth;
        if (i17 & 64 != 0) {
            i4 = defaultStrokeLineCap;
        } else {
            i4 = strokeLineCap;
        }
        if (i17 & 128 != 0) {
            i5 = defaultStrokeLineJoin;
        } else {
            i5 = strokeLineJoin;
        }
        i8 = i17 & 256 != 0 ? i6 : strokeLineMiter;
        if (i17 &= 512 != 0) {
            i7 = defaultFillType;
        } else {
            i7 = pathFillType;
        }
        int i18 = 0;
        int i19 = 0;
        PathBuilder pathBuilder2 = new PathBuilder();
        int i20 = 0;
        pathBuilder.invoke(pathBuilder2);
        return ImageVector.Builder.addPath-oIyEayM$default($this$path_u2dR_LF_u2d3I_u24default, pathBuilder2.getNodes(), i7, str2, i2, i3, i10, i15, i14, i4, i5, i8, 0, 0, 0, 14336, 0);
    }

    private static final <T> T peek(ArrayList<T> $this$peek) {
        return $this$peek.get(size--);
    }

    private static final <T> T pop(ArrayList<T> $this$pop) {
        return $this$pop.remove(size--);
    }

    private static final <T> boolean push(ArrayList<T> $this$push, T value) {
        return $this$push.add(value);
    }
}
