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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_info", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Info", "Landroidx/compose/material/icons/Icons$Rounded;", "getInfo", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InfoKt {

    private static ImageVector _info;
    static {
    }

    public static final ImageVector getInfo(Icons.Rounded $this$Info) {
        if (InfoKt._info != null) {
            ImageVector _info2 = InfoKt._info;
            Intrinsics.checkNotNull(_info2);
            return _info2;
        }
        String str = "Rounded.Info";
        int i18 = 0;
        int i19 = 0;
        ImageVector.Builder builder = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i17 = 0;
        int i21 = 0;
        int i32 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i32);
        int i23 = 1065353216;
        int i29 = 0;
        final int i30 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i36 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i68 = 0;
        final int i69 = i;
        final ImageVector.Builder builder5 = builder;
        PathBuilder $this$_get_Info__u24lambda_u241 = builder4;
        $this$_get_Info__u24lambda_u241.moveTo(1094713344, 1073741824);
        builder4.curveTo(1087331369, 1073741824, 1073741824, 1087331369, 1073741824, 1094713344);
        int i25 = 1092616192;
        $this$_get_Info__u24lambda_u241.reflectiveCurveToRelative(1083137065, i25, i25, i25);
        final String str3 = str;
        $this$_get_Info__u24lambda_u241.reflectiveCurveToRelative(i25, -1064346583, i25, -1054867456);
        int i12 = 1094713344;
        int i26 = 1073741824;
        $this$_get_Info__u24lambda_u241.reflectiveCurveTo(1099704566, i26, i12, i26);
        $this$_get_Info__u24lambda_u241.close();
        $this$_get_Info__u24lambda_u241.moveTo(i12, 1099431936);
        int i66 = -1082130432;
        builder4.curveToRelative(-1089680179, 0, -1082130432, -1092196762, -1082130432, i66);
        $this$_get_Info__u24lambda_u241.verticalLineToRelative(-1065353216);
        int i45 = 0;
        builder4.curveToRelative(i45, -1089680179, 1055286886, -1082130432, 1065353216, i66);
        int i13 = 1065353216;
        $this$_get_Info__u24lambda_u241.reflectiveCurveToRelative(i13, 1055286886, i13, i13);
        $this$_get_Info__u24lambda_u241.verticalLineToRelative(1082130432);
        builder4.curveToRelative(i45, 1057803469, -1092196762, 1065353216, -1082130432, 1065353216);
        $this$_get_Info__u24lambda_u241.close();
        $this$_get_Info__u24lambda_u241.moveTo(1095761920, 1091567616);
        $this$_get_Info__u24lambda_u241.horizontalLineToRelative(-1073741824);
        $this$_get_Info__u24lambda_u241.lineTo(1093664768, 1088421888);
        int i27 = 1073741824;
        $this$_get_Info__u24lambda_u241.horizontalLineToRelative(i27);
        $this$_get_Info__u24lambda_u241.verticalLineToRelative(i27);
        $this$_get_Info__u24lambda_u241.close();
        InfoKt._info = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i32, 1065353216, i23, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i23, 0, i45, 0, 14336, 0).build();
        ImageVector _info3 = InfoKt._info;
        Intrinsics.checkNotNull(_info3);
        return _info3;
    }
}
