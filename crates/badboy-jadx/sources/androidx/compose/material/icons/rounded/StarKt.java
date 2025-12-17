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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_star", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Star", "Landroidx/compose/material/icons/Icons$Rounded;", "getStar", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StarKt {

    private static ImageVector _star;
    static {
    }

    public static final ImageVector getStar(Icons.Rounded $this$Star) {
        if (StarKt._star != null) {
            ImageVector _star2 = StarKt._star;
            Intrinsics.checkNotNull(_star2);
            return _star2;
        }
        int i15 = 0;
        int i16 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Rounded.Star", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i14 = 0;
        int i18 = 0;
        int i24 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i24);
        final int i41 = 1065353216;
        int i20 = 0;
        int i22 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i25 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i78 = 0;
        final int i79 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1094713344, 1099573494);
        builder5.lineToRelative(1082445005, 1075880919);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(1061326684, 1055622431, 1071141356, -1100920914, 1069463634, -1081459343);
        PathBuilder builder = builder6;
        builder.lineToRelative(-1081291571, -1063843267);
        builder.lineToRelative(1080746312, -1068792545);
        builder6.curveToRelative(1059816735, -1089176863, 1050589266, -1076426179, -1089344635, -1075838976);
        builder.lineToRelative(-1063612580, -1093538939);
        builder.lineToRelative(-1074664571, -1064388526);
        builder6.curveToRelative(-1095887749, -1085318103, -1077936128, -1085318103, -1075084001, 0);
        builder.lineTo(1091766845, 1091179643);
        builder.lineTo(1082885407, 1091609559);
        builder6.curveToRelative(-1084143698, 1032805417, -1080117166, 1066779279, -1089344635, 1071644672);
        builder.lineToRelative(1080746312, 1078691103);
        builder.lineToRelative(-1081291571, 1083640381);
        builder6.curveToRelative(-1102263091, 1063004406, 1060823368, 1069883064, 1069463634, 1066024305);
        builder.lineTo(1094713344, 1099573494);
        builder.close();
        StarKt._star = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i24, 1065353216, i41, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i41, 0, 0, 0, 14336, 0).build();
        ImageVector _star3 = StarKt._star;
        Intrinsics.checkNotNull(_star3);
        return _star3;
    }
}
