package androidx.compose.material.icons;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeCap.Companion;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.StrokeJoin.Companion;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.ImageVector.Builder;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u001a*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0017\u0010\u0008\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0008\u000bH\u0087\u0008\u001a4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0017\u0010\u0008\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0008\u000bH\u0086\u0008\u001aN\u0010\u000e\u001a\u00020\n*\u00020\n2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\t¢\u0006\u0002\u0008\u000bH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000X\u0081T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0002\u0010\u0003\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0018", d2 = {"MaterialIconDimension", "", "getMaterialIconDimension$annotations", "()V", "materialIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "name", "", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "Lkotlin/ExtensionFunctionType;", "autoMirror", "", "materialPath", "fillAlpha", "strokeAlpha", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "pathBuilder", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "", "materialPath-YwgOQQI", "(Landroidx/compose/ui/graphics/vector/ImageVector$Builder;FFILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IconsKt {

    public static final float MaterialIconDimension = 24f;
    public static void getMaterialIconDimension$annotations() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with autoMirror instead.")
    public static final ImageVector materialIcon(String name, Function1<? super ImageVector.Builder, ImageVector.Builder> block) {
        final int i = 0;
        final int i12 = 0;
        int i3 = 0;
        int i4 = 0;
        ImageVector.Builder builder = new ImageVector.Builder(name, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        return (ImageVector.Builder)block.invoke(builder).build();
    }

    public static final ImageVector materialIcon(String name, boolean autoMirror, Function1<? super ImageVector.Builder, ImageVector.Builder> block) {
        final int i = 0;
        int i3 = 0;
        int i4 = 0;
        ImageVector.Builder builder = new ImageVector.Builder(name, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, autoMirror, 96, 0);
        return (ImageVector.Builder)block.invoke(builder).build();
    }

    public static ImageVector materialIcon$default(String name, boolean autoMirror, Function1 block, int i4, Object object5) {
        int i;
        int obj13;
        i = i4 & 2 != 0 ? obj13 : autoMirror;
        obj13 = 0;
        int i5 = 0;
        int i6 = 0;
        ImageVector.Builder builder = new ImageVector.Builder(name, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj7, 0, i, 96, 0);
        return (ImageVector.Builder)block.invoke(builder).build();
    }

    public static final ImageVector.Builder materialPath-YwgOQQI(ImageVector.Builder $this$materialPath_u2dYwgOQQI, float fillAlpha, float strokeAlpha, int pathFillType, Function1<? super PathBuilder, Unit> pathBuilder) {
        final int i = 0;
        int i4 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj3, i4);
        final int i8 = 1065353216;
        int i2 = 0;
        int i3 = 0;
        PathBuilder pathBuilder2 = new PathBuilder();
        int i5 = 0;
        pathBuilder.invoke(pathBuilder2);
        return ImageVector.Builder.addPath-oIyEayM$default($this$materialPath_u2dYwgOQQI, pathBuilder2.getNodes(), pathFillType, "", (Brush)solidColor, fillAlpha, i4, strokeAlpha, i8, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i8, 0, 0, 0, 14336, 0);
    }

    public static ImageVector.Builder materialPath-YwgOQQI$default(ImageVector.Builder $this$materialPath_u2dYwgOQQI_u24default, float fillAlpha, float strokeAlpha, int pathFillType, Function1 pathBuilder, int i6, Object object7) {
        int i5;
        int i4;
        int defaultFillType;
        int i3;
        int i;
        int i2;
        i = i6 & 1 != 0 ? i5 : fillAlpha;
        i2 = i6 & 2 != 0 ? i4 : strokeAlpha;
        if (i6 & 4 != 0) {
            i3 = defaultFillType;
        } else {
            i3 = pathFillType;
        }
        int i7 = 0;
        final int i9 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj5, i9);
        final int i10 = 1065353216;
        final int i18 = 0;
        int i8 = 0;
        PathBuilder pathBuilder2 = new PathBuilder();
        int i13 = 0;
        pathBuilder.invoke(pathBuilder2);
        return ImageVector.Builder.addPath-oIyEayM$default($this$materialPath_u2dYwgOQQI_u24default, pathBuilder2.getNodes(), i3, "", (Brush)solidColor, i, i9, i2, i10, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i10, 0, 0, 0, 14336, 0);
    }
}
