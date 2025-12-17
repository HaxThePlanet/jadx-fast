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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_accountBox", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccountBox", "Landroidx/compose/material/icons/Icons$Outlined;", "getAccountBox", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AccountBoxKt {

    private static ImageVector _accountBox;
    static {
    }

    public static final ImageVector getAccountBox(Icons.Outlined $this$AccountBox) {
        if (AccountBoxKt._accountBox != null) {
            ImageVector _accountBox2 = AccountBoxKt._accountBox;
            Intrinsics.checkNotNull(_accountBox2);
            return _accountBox2;
        }
        String str = "Outlined.AccountBox";
        int i36 = 0;
        int i37 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i39 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, 0);
        int i41 = 0;
        int i43 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i46 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i112 = 0;
        final int i113 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1100480512, 1077936128);
        builder5.horizontalLineTo(1084227584);
        PathBuilder builder6 = builder5;
        builder6.curveTo(1081711002, 1077936128, 1077936128, 1081711002, 1077936128, 1084227584);
        PathBuilder builder = builder6;
        int i3 = 1096810496;
        builder.verticalLineToRelative(i3);
        int i97 = 1073741824;
        builder6.curveToRelative(0, 1066192077, 1063675494, 1073741824, i97, 1073741824);
        builder.horizontalLineToRelative(i3);
        builder6.curveToRelative(1066192077, 0, 1073741824, -1083808154, i97, -1073741824);
        builder.verticalLineTo(1084227584);
        builder6.curveTo(1101529088, 1081711002, 1101057229, 1077936128, 1100480512, 1077936128);
        builder.close();
        builder.moveTo(1099431936, 1100480512);
        builder.horizontalLineTo(1088421888);
        builder.verticalLineToRelative(-1099578737);
        int i99 = 1094713344;
        builder6.curveTo(1090959442, 1099756995, 1092783964, 1099431936, i99, 1099431936);
        final String str3 = str;
        final int i114 = i32;
        builder.reflectiveCurveToRelative(1080368824, 1058977874, 1084227584, 1071728558);
        builder.verticalLineTo(1100480512);
        builder.close();
        builder.moveTo(1100480512, 1099882824);
        builder6.curveTo(1099536794, 1098954834, 1097575956, 1097859072, i99, 1097859072);
        builder.reflectiveCurveToRelative(-1062836634, 1066108191, -1059061760, 1077348925);
        builder.verticalLineTo(1084227584);
        builder.horizontalLineToRelative(1096810496);
        builder.verticalLineTo(1099882824);
        builder.close();
        builder.moveTo(1094713344, 1095761920);
        int i75 = 0;
        builder6.curveToRelative(1073154621, i75, 1080033280, -1077348925, 1080033280, -1067450368);
        int i25 = 1086324736;
        int i35 = 1094713344;
        builder.reflectiveCurveTo(1096737096, i25, i35, i25);
        builder6.curveToRelative(-1074329027, i75, -1067450368, 1070134723, -1067450368, 1080033280);
        int i26 = 1095761920;
        builder.reflectiveCurveTo(1092689592, i26, i35, i26);
        builder.close();
        builder.moveTo(1094713344, 1090519040);
        builder6.curveToRelative(1062501089, i75, 1069547520, 1059816735, 1069547520, 1069547520);
        int i28 = 1093664768;
        builder.reflectiveCurveTo(1095583662, i28, i35, i28);
        int i29 = -1077936128;
        builder.reflectiveCurveToRelative(i29, -1087666913, i29, i29);
        int i30 = 1090519040;
        builder.reflectiveCurveTo(1093843026, i30, i35, i30);
        builder.close();
        AccountBoxKt._accountBox = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, 0, 1065353216, 1065353216, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), 1065353216, 0, 0, i75, 14336, 0).build();
        ImageVector _accountBox3 = AccountBoxKt._accountBox;
        Intrinsics.checkNotNull(_accountBox3);
        return _accountBox3;
    }
}
