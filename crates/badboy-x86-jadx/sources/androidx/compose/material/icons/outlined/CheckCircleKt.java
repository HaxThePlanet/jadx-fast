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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_checkCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CheckCircle", "Landroidx/compose/material/icons/Icons$Outlined;", "getCheckCircle", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CheckCircleKt {

    private static ImageVector _checkCircle;
    static {
    }

    public static final ImageVector getCheckCircle(Icons.Outlined $this$CheckCircle) {
        if (CheckCircleKt._checkCircle != null) {
            ImageVector _checkCircle2 = CheckCircleKt._checkCircle;
            Intrinsics.checkNotNull(_checkCircle2);
            return _checkCircle2;
        }
        String str = "Outlined.CheckCircle";
        int i25 = 0;
        int i26 = 0;
        ImageVector.Builder builder = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i24 = 0;
        int i28 = 0;
        int i34 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i34);
        final int i42 = 1065353216;
        int i30 = 0;
        int i32 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i35 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i60 = 0;
        final int i61 = i;
        final ImageVector.Builder builder6 = builder;
        builder4.moveTo(1094713344, 1073741824);
        PathBuilder builder5 = builder4;
        builder5.curveTo(1087331369, 1073741824, 1073741824, 1087331369, 1073741824, 1094713344);
        int i14 = 1092616192;
        builder4.reflectiveCurveToRelative(1083137065, i14, i14, i14);
        final String str3 = str;
        builder4.reflectiveCurveToRelative(i14, -1064346583, i14, -1054867456);
        int i15 = 1094713344;
        int i21 = 1073741824;
        builder4.reflectiveCurveTo(1099704566, i21, i15, i21);
        builder4.close();
        builder4.moveTo(i15, 1101004800);
        int i49 = 0;
        builder5.curveToRelative(-1064493384, i49, -1056964608, -1067072881, -1056964608, -1056964608);
        int i6 = 1080410767;
        int i16 = -1056964608;
        int i22 = 1090519040;
        builder4.reflectiveCurveToRelative(i6, i16, i22, i16);
        builder4.reflectiveCurveToRelative(i22, i6, i22, i22);
        builder4.reflectiveCurveToRelative(-1067072881, i22, i16, i22);
        builder4.close();
        builder4.moveTo(1099216978, 1089638236);
        builder4.lineTo(1092616192, 1096988754);
        builder4.lineToRelative(-1071267185, -1071309128);
        builder4.lineTo(1086324736, 1095761920);
        int i12 = 1082130432;
        builder4.lineToRelative(i12, i12);
        builder4.lineToRelative(i22, -1056964608);
        builder4.close();
        CheckCircleKt._checkCircle = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i34, 1065353216, i42, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i42, 0, 0, i49, 14336, 0).build();
        ImageVector _checkCircle3 = CheckCircleKt._checkCircle;
        Intrinsics.checkNotNull(_checkCircle3);
        return _checkCircle3;
    }
}
