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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_shoppingCart", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ShoppingCart", "Landroidx/compose/material/icons/Icons$Rounded;", "getShoppingCart", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ShoppingCartKt {

    private static ImageVector _shoppingCart;
    static {
    }

    public static final ImageVector getShoppingCart(Icons.Rounded $this$ShoppingCart) {
        if (ShoppingCartKt._shoppingCart != null) {
            ImageVector _shoppingCart2 = ShoppingCartKt._shoppingCart;
            Intrinsics.checkNotNull(_shoppingCart2);
            return _shoppingCart2;
        }
        String str = "Rounded.ShoppingCart";
        int i37 = 0;
        int i38 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i36 = 0;
        int i40 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, 0);
        int i42 = 0;
        int i44 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i47 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i116 = 0;
        final int i117 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1088421888, 1099956224);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(-1081291571, 0, -1073825710, 1063675494, -1073825710, 1073741824);
        PathBuilder builder = builder6;
        int i51 = 1102053376;
        final String str3 = str;
        builder.reflectiveCurveTo(1086115021, i51, 1088421888, i51);
        int i3 = -1083808154;
        int i20 = 1073741824;
        builder.reflectiveCurveToRelative(i20, i3, i20, -1073741824);
        int i21 = -1073741824;
        builder.reflectiveCurveToRelative(i3, i21, i21, i21);
        builder.close();
        builder.moveTo(1065353216, 1077936128);
        builder6.curveToRelative(0, 1057803469, 1055286886, 1065353216, 1065353216, 1065353216);
        builder.horizontalLineToRelative(1065353216);
        builder.lineToRelative(1080452710, 1089659208);
        builder.lineToRelative(-1079194419, 1075587318);
        builder6.curveTo(1083220951, 1098247045, 1085234217, 1099431936, 1088421888, 1099431936);
        builder.horizontalLineToRelative(1093664768);
        int i74 = 0;
        builder6.curveToRelative(1057803469, i74, 1065353216, -1092196762, 1065353216, -1082130432);
        int i25 = -1082130432;
        builder.reflectiveCurveToRelative(-1092196762, i25, i25, i25);
        builder.lineTo(1088421888, 1097859072);
        builder.lineToRelative(1066192077, -1073741824);
        builder.horizontalLineToRelative(1089365606);
        builder6.curveToRelative(1061158912, i74, 1068792545, -1093538939, 1071644672, -1081878774);
        builder.lineToRelative(1080368824, -1060131308);
        builder6.curveToRelative(1052602532, -1087834685, -1109309522, -1078103900, -1084311470, -1078103900);
        builder.lineTo(1084667986, 1082130432);
        builder.lineToRelative(-1087666913, -1078523331);
        builder6.curveToRelative(-1104947446, -1095552205, -1090183496, -1089344635, -1083808154, -1089344635);
        int i16 = 1073741824;
        builder.lineTo(i16, i16);
        int i77 = 0;
        builder6.curveToRelative(-1089680179, i77, -1082130432, 1055286886, -1082130432, 1065353216);
        builder.close();
        builder.moveTo(1099431936, 1099956224);
        builder6.curveToRelative(-1081291571, i77, -1073825710, 1063675494, -1073825710, 1073741824);
        int i53 = 1073741824;
        builder.reflectiveCurveToRelative(1063507722, i53, 1073657938, i53);
        int i19 = -1083808154;
        int i33 = 1073741824;
        builder.reflectiveCurveToRelative(i33, i19, i33, -1073741824);
        int i34 = -1073741824;
        builder.reflectiveCurveToRelative(i19, i34, i34, i34);
        builder.close();
        ShoppingCartKt._shoppingCart = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, 0, 1065353216, 1065353216, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), 1065353216, 0, 0, i77, 14336, 0).build();
        ImageVector _shoppingCart3 = ShoppingCartKt._shoppingCart;
        Intrinsics.checkNotNull(_shoppingCart3);
        return _shoppingCart3;
    }
}
