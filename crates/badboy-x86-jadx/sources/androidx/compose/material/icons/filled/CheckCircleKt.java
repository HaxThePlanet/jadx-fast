package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons.Filled;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_checkCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CheckCircle", "Landroidx/compose/material/icons/Icons$Filled;", "getCheckCircle", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CheckCircleKt {

    private static ImageVector _checkCircle;
    static {
    }

    public static final ImageVector getCheckCircle(Icons.Filled $this$CheckCircle) {
        if (CheckCircleKt._checkCircle != null) {
            ImageVector _checkCircle2 = CheckCircleKt._checkCircle;
            Intrinsics.checkNotNull(_checkCircle2);
            return _checkCircle2;
        }
        String str = "Filled.CheckCircle";
        int i22 = 0;
        int i23 = 0;
        ImageVector.Builder builder = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i21 = 0;
        int i25 = 0;
        int i31 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i31);
        final int i39 = 1065353216;
        int i27 = 0;
        int i29 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i32 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i52 = 0;
        final int i53 = i;
        final ImageVector.Builder builder6 = builder;
        builder4.moveTo(1094713344, 1073741824);
        builder4.curveTo(1087331369, 1073741824, 1073741824, 1087331369, 1073741824, 1094713344);
        int i12 = 1092616192;
        builder4.reflectiveCurveToRelative(1083137065, i12, i12, i12);
        String str3 = str;
        builder4.reflectiveCurveToRelative(i12, -1064346583, i12, -1054867456);
        int i13 = 1073741824;
        builder4.reflectiveCurveTo(1099704566, i13, 1094713344, i13);
        builder4.close();
        int i14 = 1092616192;
        builder4.moveTo(i14, 1099431936);
        int i6 = -1063256064;
        builder4.lineToRelative(i6, i6);
        builder4.lineToRelative(1068792545, -1078691103);
        builder4.lineTo(i14, 1096988754);
        builder4.lineToRelative(1089659208, -1057824440);
        builder4.lineTo(1100480512, 1090519040);
        builder4.lineToRelative(-1055916032, 1091567616);
        builder4.close();
        CheckCircleKt._checkCircle = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i31, 1065353216, i39, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i39, 0, 0, 0, 14336, 0).build();
        ImageVector _checkCircle3 = CheckCircleKt._checkCircle;
        Intrinsics.checkNotNull(_checkCircle3);
        return _checkCircle3;
    }
}
