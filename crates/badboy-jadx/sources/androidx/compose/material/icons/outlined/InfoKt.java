package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons.Outlined;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_info", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Info", "Landroidx/compose/material/icons/Icons$Outlined;", "getInfo", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InfoKt {

    private static ImageVector _info;
    static {
    }

    public static final ImageVector getInfo(Icons.Outlined $this$Info) {
        if (InfoKt._info != null) {
            ImageVector _info2 = InfoKt._info;
            Intrinsics.checkNotNull(_info2);
            return _info2;
        }
        String str = "Outlined.Info";
        int i17 = 0;
        int i18 = 0;
        ImageVector.Builder builder = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i16 = 0;
        int i20 = 0;
        int i26 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i26);
        final int i38 = 1065353216;
        int i22 = 0;
        int i24 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i27 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i56 = 0;
        final int i57 = i;
        final ImageVector.Builder builder7 = builder;
        int $this$_get_Info__u24lambda_u241 = 1093664768;
        builder5.moveTo($this$_get_Info__u24lambda_u241, 1088421888);
        int i2 = 1073741824;
        builder5.horizontalLineToRelative(i2);
        builder5.verticalLineToRelative(i2);
        int i3 = -1073741824;
        builder5.horizontalLineToRelative(i3);
        builder5.close();
        builder5.moveTo($this$_get_Info__u24lambda_u241, $this$_get_Info__u24lambda_u241);
        builder5.horizontalLineToRelative(1073741824);
        builder5.verticalLineToRelative(1086324736);
        builder5.horizontalLineToRelative(i3);
        builder5.close();
        builder5.moveTo(1094713344, 1073741824);
        PathBuilder builder6 = builder5;
        builder6.curveTo(1087331369, 1073741824, 1073741824, 1087331369, 1073741824, 1094713344);
        PathBuilder builder2 = builder6;
        int i5 = 1092616192;
        builder2.reflectiveCurveToRelative(1083137065, i5, i5, i5);
        final String str3 = str;
        builder2.reflectiveCurveToRelative(i5, -1064346583, i5, -1054867456);
        int i13 = 1094713344;
        int i33 = 1073741824;
        builder2.reflectiveCurveTo(1099704566, i33, i13, i33);
        builder2.close();
        builder2.moveTo(i13, 1101004800);
        int i45 = 0;
        builder6.curveToRelative(-1064493384, i45, -1056964608, -1067072881, -1056964608, -1056964608);
        int i8 = 1080410767;
        int i14 = -1056964608;
        int i34 = 1090519040;
        builder2.reflectiveCurveToRelative(i8, i14, i34, i14);
        builder2.reflectiveCurveToRelative(i34, i8, i34, i34);
        builder2.reflectiveCurveToRelative(-1067072881, i34, i14, i34);
        builder2.close();
        InfoKt._info = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i26, 1065353216, i38, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i38, 0, 0, i45, 14336, 0).build();
        ImageVector _info3 = InfoKt._info;
        Intrinsics.checkNotNull(_info3);
        return _info3;
    }
}
