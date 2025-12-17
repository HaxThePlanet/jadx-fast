package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons.Rounded;
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
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"_arrowBack", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ArrowBack", "Landroidx/compose/material/icons/Icons$Rounded;", "getArrowBack$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getArrowBack", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ArrowBackKt {

    private static ImageVector _arrowBack;
    static {
    }

    public static final ImageVector getArrowBack(Icons.Rounded $this$ArrowBack) {
        if (ArrowBackKt._arrowBack != null) {
            ImageVector _arrowBack2 = ArrowBackKt._arrowBack;
            Intrinsics.checkNotNull(_arrowBack2);
            return _arrowBack2;
        }
        int i11 = 0;
        int i12 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Rounded.ArrowBack", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i10 = 0;
        int i14 = 0;
        int i20 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i20);
        final int i31 = 1065353216;
        int i16 = 0;
        int i18 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i21 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i69 = 0;
        final int i70 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1100480512, 1093664768);
        builder5.horizontalLineTo(1090162524);
        builder5.lineToRelative(1083975926, -1063507722);
        int i39 = -1094210028;
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(1053273620, i39, 1053273620, -1081878774, 0, -1078607217);
        int i35 = -1094210028;
        builder6.curveToRelative(i35, i39, -1081962660, -1094210028, -1078691103, 0);
        PathBuilder builder = builder6;
        int i25 = 1087562056;
        builder.lineToRelative(-1059921592, i25);
        int i40 = 1053273620;
        builder6.curveToRelative(i35, i40, -1094210028, 1065520988, 0, 1068792545);
        builder.lineToRelative(i25, i25);
        int i36 = 1053273620;
        builder6.curveToRelative(i36, i40, 1065520988, 1053273620, 1068792545, 0);
        builder6.curveToRelative(i36, -1094210028, 1053273620, -1081962660, 0, -1078691103);
        builder.lineTo(1090162524, 1095761920);
        builder.horizontalLineTo(1100480512);
        int i42 = 0;
        builder6.curveToRelative(1057803469, i42, 1065353216, -1092196762, 1065353216, -1082130432);
        int i27 = -1082130432;
        builder.reflectiveCurveToRelative(-1092196762, i27, i27, i27);
        builder.close();
        ArrowBackKt._arrowBack = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i20, 1065353216, i31, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i31, 0, 0, i42, 14336, 0).build();
        ImageVector _arrowBack3 = ArrowBackKt._arrowBack;
        Intrinsics.checkNotNull(_arrowBack3);
        return _arrowBack3;
    }

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Rounded.ArrowBack", replaceWith = @ReplaceWith(...))
    public static void getArrowBack$annotations(Icons.Rounded icons$Rounded) {
    }
}
