package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons.Sharp;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_share", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Share", "Landroidx/compose/material/icons/Icons$Sharp;", "getShare", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ShareKt {

    private static ImageVector _share;
    static {
    }

    public static final ImageVector getShare(Icons.Sharp $this$Share) {
        if (ShareKt._share != null) {
            ImageVector _share2 = ShareKt._share;
            Intrinsics.checkNotNull(_share2);
            return _share2;
        }
        String str = "Sharp.Share";
        int i23 = 0;
        int i24 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i26 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, 0);
        int i28 = 0;
        int i30 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i33 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i107 = 0;
        final int i108 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1099956224, 1098949591);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(-1086156964, 0, -1078439444, 1050253722, -1074077368, 1061494456);
        PathBuilder builder = builder6;
        builder.lineTo(1091473244, 1095447347);
        builder6.curveToRelative(1028443341, -1100249825, 1035489772, -1091861217, 1035489772, -1087163597);
        final String str3 = str;
        final int i109 = i20;
        builder.reflectiveCurveToRelative(-1121724662, -1091525673, -1111993876, -1087163597);
        builder.lineToRelative(1088526746, -1065122529);
        builder6.curveToRelative(1057635697, 1056964608, 1067450368, 1062165545, 1073909596, 1062165545);
        builder6.curveToRelative(1070889697, 0, 1077936128, -1079278305, 1077936128, -1069547520);
        int i12 = -1069547520;
        builder.reflectiveCurveToRelative(-1079278305, i12, i12, i12);
        int i21 = -1069547520;
        builder.reflectiveCurveToRelative(i21, 1068205343, i21, 1077936128);
        builder6.curveToRelative(0, 1047904911, 1025758986, 1055957975, 1035489772, 1060320051);
        builder.lineTo(1090560983, 1092416963);
        builder6.curveTo(1089470464, 1091892675, 1087981486, 1091567616, 1086324736, 1091567616);
        int i61 = 0;
        builder6.curveToRelative(-1076593951, i61, -1069547520, 1068205343, -1069547520, 1077936128);
        int i15 = 1077936128;
        builder.reflectiveCurveToRelative(1068205343, i15, i15, i15);
        builder6.curveToRelative(1061830001, i61, 1069547520, -1096894382, 1073909596, -1085318103);
        builder.lineToRelative(1088673546, 1082465976);
        builder6.curveToRelative(-1119040307, 1045891645, -1113336054, 1054615798, -1113336054, 1059481190);
        int i54 = 0;
        builder6.curveToRelative(i54, 1070470267, 1067953684, 1077600584, 1077600584, 1077600584);
        int i10 = -1079529964;
        int i17 = 1077600584;
        builder.reflectiveCurveToRelative(i17, i10, i17, -1069883064);
        int i18 = -1069883064;
        builder.reflectiveCurveToRelative(i10, i18, i18, i18);
        builder.close();
        ShareKt._share = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, 0, 1065353216, 1065353216, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), 1065353216, 0, i54, 0, 14336, 0).build();
        ImageVector _share3 = ShareKt._share;
        Intrinsics.checkNotNull(_share3);
        return _share3;
    }
}
