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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_checkCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CheckCircle", "Landroidx/compose/material/icons/Icons$Rounded;", "getCheckCircle", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CheckCircleKt {

    private static ImageVector _checkCircle;
    static {
    }

    public static final ImageVector getCheckCircle(Icons.Rounded $this$CheckCircle) {
        if (CheckCircleKt._checkCircle != null) {
            ImageVector _checkCircle2 = CheckCircleKt._checkCircle;
            Intrinsics.checkNotNull(_checkCircle2);
            return _checkCircle2;
        }
        String str = "Rounded.CheckCircle";
        int i20 = 0;
        int i21 = 0;
        ImageVector.Builder builder = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i19 = 0;
        int i23 = 0;
        int i29 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i29);
        final int i37 = 1065353216;
        int i25 = 0;
        int i27 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i30 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i71 = 0;
        final int i72 = i;
        final ImageVector.Builder builder6 = builder;
        builder4.moveTo(1094713344, 1073741824);
        PathBuilder builder5 = builder4;
        builder5.curveTo(1087331369, 1073741824, 1073741824, 1087331369, 1073741824, 1094713344);
        int i10 = 1092616192;
        builder4.reflectiveCurveToRelative(1083137065, i10, i10, i10);
        final String str3 = str;
        builder4.reflectiveCurveToRelative(i10, -1064346583, i10, -1054867456);
        int i11 = 1073741824;
        builder4.reflectiveCurveTo(1099704566, i11, 1094713344, i11);
        builder4.close();
        builder4.moveTo(1091871703, 1099059692);
        builder4.lineTo(1085695590, 1095447347);
        int i46 = -1094210028;
        builder5.curveToRelative(-1094210028, i46, -1094210028, -1081962660, 0, -1078691103);
        int i63 = 1068792545;
        int i68 = 0;
        int i42 = 1053273620;
        int i51 = 1065520988;
        int i57 = -1094210028;
        builder5.curveToRelative(i42, i46, i51, i57, i63, i68);
        builder4.lineTo(1092616192, 1096988754);
        builder4.lineToRelative(1088170230, -1059313418);
        builder5.curveToRelative(i42, i46, i51, i57, i63, i68);
        int i47 = 1053273620;
        builder5.curveToRelative(i42, i47, 1053273620, 1065520988, 0, 1068792545);
        builder4.lineToRelative(-1057824440, 1089659208);
        builder5.curveToRelative(-1094545572, i47, -1081962660, 1053273620, -1078691103, 0);
        builder5.close();
        CheckCircleKt._checkCircle = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i29, 1065353216, i37, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i37, 0, 0, 0, 14336, 0).build();
        ImageVector _checkCircle3 = CheckCircleKt._checkCircle;
        Intrinsics.checkNotNull(_checkCircle3);
        return _checkCircle3;
    }
}
