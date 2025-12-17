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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_home", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Home", "Landroidx/compose/material/icons/Icons$Rounded;", "getHome", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HomeKt {

    private static ImageVector _home;
    static {
    }

    public static final ImageVector getHome(Icons.Rounded $this$Home) {
        if (HomeKt._home != null) {
            ImageVector _home2 = HomeKt._home;
            Intrinsics.checkNotNull(_home2);
            return _home2;
        }
        int i12 = 0;
        int i13 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.Home", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i11 = 0;
        int i15 = 0;
        int i21 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i21);
        final int i34 = 1065353216;
        int i17 = 0;
        int i19 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i22 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i79 = 0;
        final int i80 = i;
        final ImageVector.Builder builder7 = builder;
        builder5.moveTo(1092616192, 1100480512);
        builder5.verticalLineToRelative(-1063256064);
        builder5.horizontalLineToRelative(1082130432);
        builder5.verticalLineToRelative(1084227584);
        int i67 = 1065353216;
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(0, 1057803469, 1055286886, 1065353216, i67, 1065353216);
        PathBuilder builder2 = builder6;
        builder2.horizontalLineToRelative(1077936128);
        int i46 = 0;
        builder6.curveToRelative(1057803469, i46, 1065353216, -1092196762, i67, -1082130432);
        builder2.verticalLineToRelative(-1059061760);
        builder2.horizontalLineToRelative(1071225242);
        builder6.curveToRelative(1055622431, i46, 1059984507, -1089344635, 1051260355, -1084311470);
        builder2.lineTo(1095415890, 1080452710);
        builder6.curveToRelative(-1094545572, -1095887749, -1082801521, -1095887749, -1079278305, 0);
        builder2.lineToRelative(-1056587121, 1089533379);
        builder6.curveToRelative(-1095887749, 1050253722, -1106960712, 1063172178, 1051260355, 1063172178);
        builder2.horizontalLineTo(1084227584);
        builder2.verticalLineToRelative(1088421888);
        int i71 = 1065353216;
        builder6.curveToRelative(0, 1057803469, 1055286886, 1065353216, i71, 1065353216);
        builder2.horizontalLineToRelative(1077936128);
        int i50 = 0;
        builder6.curveToRelative(1057803469, i50, 1065353216, -1092196762, i71, -1082130432);
        builder6.close();
        HomeKt._home = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i21, 1065353216, i34, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i34, 0, 0, i50, 14336, 0).build();
        ImageVector _home3 = HomeKt._home;
        Intrinsics.checkNotNull(_home3);
        return _home3;
    }
}
