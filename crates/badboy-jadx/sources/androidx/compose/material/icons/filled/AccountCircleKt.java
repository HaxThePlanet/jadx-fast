package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons.Filled;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_accountCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccountCircle", "Landroidx/compose/material/icons/Icons$Filled;", "getAccountCircle", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AccountCircleKt {

    private static ImageVector _accountCircle;
    static {
    }

    public static final ImageVector getAccountCircle(Icons.Filled $this$AccountCircle) {
        if (AccountCircleKt._accountCircle != null) {
            ImageVector _accountCircle2 = AccountCircleKt._accountCircle;
            Intrinsics.checkNotNull(_accountCircle2);
            return _accountCircle2;
        }
        String str = "Filled.AccountCircle";
        int i22 = 0;
        int i23 = 0;
        ImageVector.Builder builder = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i25 = 0;
        int i31 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i31);
        final int i39 = 1065353216;
        int i27 = 0;
        int i29 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i32 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i74 = 0;
        final int i75 = i;
        final ImageVector.Builder builder6 = builder;
        builder4.moveTo(1094713344, 1073741824);
        PathBuilder builder5 = builder4;
        builder5.curveTo(1087331369, 1073741824, 1073741824, 1087331369, 1073741824, 1094713344);
        int i8 = 1092616192;
        builder4.reflectiveCurveToRelative(1083137065, i8, i8, i8);
        final String str3 = str;
        builder4.reflectiveCurveToRelative(i8, -1064346583, i8, -1054867456);
        int i9 = 1073741824;
        int i15 = 1094713344;
        builder4.reflectiveCurveTo(1099704566, i9, i15, i9);
        builder4.close();
        builder4.moveTo(i15, 1086324736);
        int i49 = 0;
        builder5.curveToRelative(1073154621, i49, 1080033280, 1070134723, 1080033280, 1080033280);
        int i16 = 1095761920;
        int i6 = 1094713344;
        builder4.reflectiveCurveTo(1096737096, i16, i6, i16);
        int i17 = -1067450368;
        builder4.reflectiveCurveToRelative(i17, -1077348925, i17, i17);
        int i18 = 1086324736;
        builder4.reflectiveCurveTo(1092689592, i18, i6, i18);
        builder4.close();
        builder4.moveTo(i6, 1101004800);
        builder5.curveToRelative(-1073615995, i49, -1064451441, -1085150331, -1060865311, -1070050836);
        int i68 = 1094713344;
        builder5.curveTo(1089575322, 1098697933, 1092280648, 1097859072, i68, 1097859072);
        final int i76 = i21;
        builder4.reflectiveCurveToRelative(1083074150, 1061997773, 1086618337, 1074245140);
        builder5.curveTo(1099133092, 1100574884, 1096841953, 1101004800, i68, 1101004800);
        builder5.close();
        AccountCircleKt._accountCircle = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i31, 1065353216, i39, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i39, 0, 0, 0, 14336, 0).build();
        ImageVector _accountCircle3 = AccountCircleKt._accountCircle;
        Intrinsics.checkNotNull(_accountCircle3);
        return _accountCircle3;
    }
}
