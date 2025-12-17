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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_info", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Info", "Landroidx/compose/material/icons/Icons$TwoTone;", "getInfo", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InfoKt {

    private static ImageVector _info;
    static {
    }

    public static final ImageVector getInfo(Icons.TwoTone $this$Info) {
        if (InfoKt._info != null) {
            ImageVector _info2 = InfoKt._info;
            Intrinsics.checkNotNull(_info2);
            return _info2;
        }
        int i13 = 0;
        int i15 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("TwoTone.Info", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i12 = 0;
        int i17 = 0;
        int i34 = 0;
        SolidColor solidColor2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i34);
        int i20 = 1065353216;
        int i30 = 0;
        PathBuilder pathBuilder2 = new PathBuilder();
        int i65 = 0;
        PathBuilder builder8 = pathBuilder2;
        int i79 = 0;
        final int i80 = i20;
        final int i81 = i;
        PathBuilder $i$f$materialIcon = builder8;
        $i$f$materialIcon.moveTo(1094713344, 1082130432);
        builder8.curveToRelative(-1064493384, 0, -1056964608, 1080410767, -1056964608, 1090519040);
        int i36 = 1090519040;
        $i$f$materialIcon.reflectiveCurveToRelative(1080410767, i36, i36, i36);
        int i23 = -1067072881;
        int $this$_get_Info__u24lambda_u242 = -1056964608;
        $i$f$materialIcon.reflectiveCurveToRelative(i36, i23, i36, $this$_get_Info__u24lambda_u242);
        $i$f$materialIcon.reflectiveCurveToRelative(i23, $this$_get_Info__u24lambda_u242, $this$_get_Info__u24lambda_u242, $this$_get_Info__u24lambda_u242);
        $i$f$materialIcon.close();
        int i6 = 1095761920;
        $i$f$materialIcon.moveTo(i6, 1099431936);
        int i25 = -1073741824;
        $i$f$materialIcon.horizontalLineToRelative(i25);
        $i$f$materialIcon.verticalLineToRelative(-1061158912);
        $i$f$materialIcon.horizontalLineToRelative(1073741824);
        $i$f$materialIcon.verticalLineToRelative(1086324736);
        $i$f$materialIcon.close();
        $i$f$materialIcon.moveTo(i6, 1091567616);
        $i$f$materialIcon.horizontalLineToRelative(i25);
        int i7 = 1093664768;
        int i41 = 1088421888;
        $i$f$materialIcon.lineTo(i7, i41);
        int i26 = 1073741824;
        $i$f$materialIcon.horizontalLineToRelative(i26);
        $i$f$materialIcon.verticalLineToRelative(i26);
        $i$f$materialIcon.close();
        int i73 = 14336;
        int i75 = 0;
        int i69 = 0;
        int i71 = 0;
        ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder2.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor2, 1050253722, i34, 1050253722, i20, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i20, 0, i69, i71, i73, i75);
        ImageVector.Builder builder = builder9;
        int i14 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), 0, 0);
        int i18 = 0;
        int i27 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i32 = 0;
        PathBuilder builder7 = pathBuilder;
        int i67 = 0;
        builder7.moveTo(i7, i41);
        int i42 = 1073741824;
        builder7.horizontalLineToRelative(i42);
        builder7.verticalLineToRelative(i42);
        int i43 = -1073741824;
        builder7.horizontalLineToRelative(i43);
        builder7.close();
        builder7.moveTo(i7, i7);
        builder7.horizontalLineToRelative(1073741824);
        builder7.verticalLineToRelative(1086324736);
        builder7.horizontalLineToRelative(i43);
        builder7.close();
        builder7.moveTo(1094713344, 1073741824);
        final PathBuilder builder11 = builder7;
        builder11.curveTo(1087331369, 1073741824, 1073741824, 1087331369, 1073741824, 1094713344);
        PathBuilder builder3 = builder11;
        int i52 = 1092616192;
        builder3.reflectiveCurveToRelative(1083137065, i52, i52, i52);
        ImageVector.Builder builder10 = builder;
        builder3.reflectiveCurveToRelative(i52, -1064346583, i52, -1054867456);
        int i47 = 1094713344;
        int i53 = 1073741824;
        builder3.reflectiveCurveTo(1099704566, i53, i47, i53);
        builder3.close();
        builder3.moveTo(i47, 1101004800);
        builder11.curveToRelative(-1064493384, 0, -1056964608, -1067072881, -1056964608, -1056964608);
        int i4 = 1080410767;
        int i48 = -1056964608;
        int i54 = 1090519040;
        builder3.reflectiveCurveToRelative(i4, i48, i54, i48);
        builder3.reflectiveCurveToRelative(i54, i4, i54, i54);
        builder3.reflectiveCurveToRelative(-1067072881, i54, i48, i54);
        builder3.close();
        InfoKt._info = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, 0, 1065353216, i80, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i80, 0, i69, i71, i73, i75).build();
        ImageVector _info3 = InfoKt._info;
        Intrinsics.checkNotNull(_info3);
        return _info3;
    }
}
