package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons.TwoTone;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_star", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Star", "Landroidx/compose/material/icons/Icons$TwoTone;", "getStar", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StarKt {

    private static ImageVector _star;
    static {
    }

    public static final ImageVector getStar(Icons.TwoTone $this$Star) {
        if (StarKt._star != null) {
            ImageVector _star2 = StarKt._star;
            Intrinsics.checkNotNull(_star2);
            return _star2;
        }
        int i25 = 0;
        int i27 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("TwoTone.Star", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i24 = 0;
        int i29 = 0;
        int i70 = 0;
        SolidColor solidColor2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i70);
        int i32 = 1065353216;
        int i66 = 0;
        PathBuilder pathBuilder2 = new PathBuilder();
        int i96 = 0;
        int i101 = 0;
        final int i106 = i;
        PathBuilder $i$f$materialIcon = builder7;
        $i$f$materialIcon.moveTo(1094713344, 1098278502);
        $i$f$materialIcon.lineToRelative(-1066359849, 1074874286);
        $i$f$materialIcon.lineToRelative(1065353216, -1064766013);
        $i$f$materialIcon.lineToRelative(-1068205343, -1070050836);
        $i$f$materialIcon.lineToRelative(1082927350, -1094545572);
        $i$f$materialIcon.lineToRelative(1071225242, -1065290301);
        $i$f$materialIcon.lineToRelative(1071309128, 1082214318);
        $i$f$materialIcon.lineToRelative(1082927350, 1052938076);
        $i$f$materialIcon.lineToRelative(-1068205343, 1077432812);
        $i$f$materialIcon.lineToRelative(1065353216, 1082717635);
        $i$f$materialIcon.close();
        final int i103 = 14336;
        final int i104 = 0;
        int i100 = 0;
        int i102 = 0;
        ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder2.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor2, 1050253722, i70, 1050253722, i32, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i32, 0, i100, i102, i103, i104);
        ImageVector.Builder builder = builder2;
        int i26 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), 0, 0);
        final int i105 = 1065353216;
        int i30 = 0;
        int i67 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i82 = 0;
        PathBuilder builder6 = pathBuilder;
        int i98 = 0;
        final ImageVector.Builder builder8 = builder;
        builder6.moveTo(1102053376, 1091819274);
        builder6.lineToRelative(-1058663301, -1088505774);
        builder6.lineTo(1094713344, 1073741824);
        builder6.lineTo(1091766845, 1091179643);
        builder6.lineTo(1073741824, 1091819274);
        builder6.lineToRelative(1085192274, 1083661353);
        builder6.lineTo(1085947249, 1101529088);
        builder6.lineTo(1094713344, 1099573494);
        builder6.lineTo(1100050596, 1101529088);
        builder6.lineToRelative(-1076845609, -1058998845);
        builder6.lineTo(1102053376, 1091819274);
        builder6.close();
        builder6.moveTo(1094713344, 1098278502);
        builder6.lineToRelative(-1066359849, 1074874286);
        builder6.lineToRelative(1065353216, -1064766013);
        builder6.lineToRelative(-1068205343, -1070050836);
        builder6.lineToRelative(1082927350, -1094545572);
        builder6.lineTo(1094713344, 1086534451);
        builder6.lineToRelative(1071309128, 1082214318);
        builder6.lineToRelative(1082927350, 1052938076);
        builder6.lineToRelative(-1068205343, 1077432812);
        builder6.lineToRelative(1065353216, 1082717635);
        builder6.lineTo(1094713344, 1098278502);
        builder6.close();
        StarKt._star = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, 0, 1065353216, i105, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i105, 0, i100, i102, i103, i104).build();
        ImageVector _star3 = StarKt._star;
        Intrinsics.checkNotNull(_star3);
        return _star3;
    }
}
