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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_menu", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Menu", "Landroidx/compose/material/icons/Icons$Rounded;", "getMenu", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MenuKt {

    private static ImageVector _menu;
    static {
    }

    public static final ImageVector getMenu(Icons.Rounded $this$Menu) {
        if (MenuKt._menu != null) {
            ImageVector _menu2 = MenuKt._menu;
            Intrinsics.checkNotNull(_menu2);
            return _menu2;
        }
        int i16 = 0;
        int i17 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.Menu", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i15 = 0;
        int i19 = 0;
        int i38 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i38);
        int i21 = 1065353216;
        int i35 = 0;
        final int i36 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i42 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i88 = 0;
        final int i89 = i;
        final ImageVector.Builder builder5 = builder;
        PathBuilder $this$_get_Menu__u24lambda_u241 = builder4;
        $this$_get_Menu__u24lambda_u241.moveTo(1082130432, 1099956224);
        $this$_get_Menu__u24lambda_u241.horizontalLineToRelative(1098907648);
        int i57 = 0;
        builder4.curveToRelative(1057803469, i57, 1065353216, -1092196762, 1065353216, -1082130432);
        int i24 = -1082130432;
        $this$_get_Menu__u24lambda_u241.reflectiveCurveToRelative(-1092196762, i24, i24, i24);
        $this$_get_Menu__u24lambda_u241.lineTo(1082130432, 1098907648);
        builder4.curveToRelative(-1089680179, i57, -1082130432, 1055286886, -1082130432, 1065353216);
        int i26 = 1065353216;
        $this$_get_Menu__u24lambda_u241.reflectiveCurveToRelative(1055286886, i26, i26, i26);
        $this$_get_Menu__u24lambda_u241.close();
        $this$_get_Menu__u24lambda_u241.moveTo(1082130432, 1095761920);
        $this$_get_Menu__u24lambda_u241.horizontalLineToRelative(1098907648);
        builder4.curveToRelative(1057803469, i57, 1065353216, -1092196762, 1065353216, -1082130432);
        int i28 = -1082130432;
        $this$_get_Menu__u24lambda_u241.reflectiveCurveToRelative(-1092196762, i28, i28, i28);
        $this$_get_Menu__u24lambda_u241.lineTo(1082130432, 1093664768);
        int i85 = 1065353216;
        builder4.curveToRelative(-1089680179, i57, -1082130432, 1055286886, -1082130432, i85);
        int i30 = 1065353216;
        $this$_get_Menu__u24lambda_u241.reflectiveCurveToRelative(1055286886, i30, i30, i30);
        $this$_get_Menu__u24lambda_u241.close();
        $this$_get_Menu__u24lambda_u241.moveTo(1077936128, 1088421888);
        int i80 = 1065353216;
        builder4.curveToRelative(0, 1057803469, 1055286886, 1065353216, i80, i85);
        $this$_get_Menu__u24lambda_u241.horizontalLineToRelative(1098907648);
        int i59 = 0;
        builder4.curveToRelative(1057803469, i59, 1065353216, -1092196762, i80, -1082130432);
        int i32 = -1082130432;
        $this$_get_Menu__u24lambda_u241.reflectiveCurveToRelative(-1092196762, i32, i32, i32);
        $this$_get_Menu__u24lambda_u241.lineTo(1082130432, 1086324736);
        builder4.curveToRelative(-1089680179, i59, -1082130432, 1055286886, -1082130432, 1065353216);
        $this$_get_Menu__u24lambda_u241.close();
        MenuKt._menu = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i38, 1065353216, i21, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i21, 0, 0, i59, 14336, 0).build();
        ImageVector _menu3 = MenuKt._menu;
        Intrinsics.checkNotNull(_menu3);
        return _menu3;
    }
}
