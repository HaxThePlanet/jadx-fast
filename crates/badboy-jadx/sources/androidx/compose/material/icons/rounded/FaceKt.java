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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_face", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Face", "Landroidx/compose/material/icons/Icons$Rounded;", "getFace", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FaceKt {

    private static ImageVector _face;
    static {
    }

    public static final ImageVector getFace(Icons.Rounded $this$Face) {
        if (FaceKt._face != null) {
            ImageVector _face2 = FaceKt._face;
            Intrinsics.checkNotNull(_face2);
            return _face2;
        }
        String str = "Rounded.Face";
        int i27 = 0;
        int i28 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i26 = 0;
        int i30 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, 0);
        int i32 = 0;
        int i34 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i37 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i106 = 0;
        final int i107 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1092878336, 1095761920);
        int i91 = -1080033280;
        int i98 = 1067450368;
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(0, 1060152279, -1089512407, 1067450368, i91, i98);
        PathBuilder builder = builder6;
        int i41 = 1089994752;
        final String str3 = str;
        builder.reflectiveCurveTo(i41, 1096485437, i41, 1095761920);
        int i42 = 1094451200;
        builder.reflectiveCurveTo(1090844099, i42, 1091567616, i42);
        int i43 = 1092878336;
        builder.reflectiveCurveTo(i43, 1095038403, i43, 1095761920);
        builder.close();
        builder.moveTo(1097859072, 1094451200);
        builder6.curveToRelative(-1087331369, 0, -1080033280, 1057971241, i91, i98);
        int i17 = 1067450368;
        builder.reflectiveCurveToRelative(1057971241, i17, i17, i17);
        int i44 = 1067450368;
        builder.reflectiveCurveToRelative(i44, -1089512407, i44, -1080033280);
        int i45 = 1094451200;
        builder.reflectiveCurveTo(1098582589, i45, 1097859072, i45);
        builder.close();
        builder.moveTo(1102053376, 1094713344);
        int i55 = 0;
        builder6.curveToRelative(i55, 1085318103, -1064346583, 1092616192, -1054867456, 1092616192);
        int i21 = 1073741824;
        int i46 = 1094713344;
        builder.reflectiveCurveTo(i21, 1099704566, i21, i46);
        int i11 = 1087331369;
        builder.reflectiveCurveTo(i11, i21, i46, i21);
        int i22 = 1102053376;
        builder.reflectiveCurveTo(i22, i11, i22, i46);
        builder.close();
        builder.moveTo(1101004800, 1094713344);
        builder6.curveToRelative(i55, -1085821420, -1107967345, -1077684470, -1096223293, -1072735191);
        builder6.curveTo(1100464783, 1092521820, 1100087296, 1092616192, 1099694080, 1092616192);
        builder6.curveToRelative(-1069002260, 0, -1061326684, -1078439444, -1057467924, -1066653450);
        int i96 = 1082130432;
        builder6.curveTo(1091242557, 1091431301, 1087583027, 1093538939, i96, 1094566543);
        builder6.curveTo(1082151404, 1094608486, 1082130432, 1094660915, i96, 1094713344);
        int i60 = 0;
        builder6.curveToRelative(i60, 1082990264, 1080410767, 1090519040, 1090519040, 1090519040);
        int i24 = 1101004800;
        builder.reflectiveCurveTo(i24, 1099122606, i24, i46);
        builder.close();
        FaceKt._face = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, 0, 1065353216, 1065353216, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), 1065353216, 0, i60, 0, 14336, 0).build();
        ImageVector _face3 = FaceKt._face;
        Intrinsics.checkNotNull(_face3);
        return _face3;
    }
}
