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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_accountBox", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccountBox", "Landroidx/compose/material/icons/Icons$TwoTone;", "getAccountBox", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AccountBoxKt {

    private static ImageVector _accountBox;
    static {
    }

    public static final ImageVector getAccountBox(Icons.TwoTone $this$AccountBox) {
        if (AccountBoxKt._accountBox != null) {
            ImageVector _accountBox2 = AccountBoxKt._accountBox;
            Intrinsics.checkNotNull(_accountBox2);
            return _accountBox2;
        }
        String str = "TwoTone.AccountBox";
        int i25 = 0;
        int i26 = 0;
        ImageVector.Builder builder4 = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        ImageVector.Builder builder5 = builder4;
        int i28 = 0;
        SolidColor solidColor3 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, 0);
        final int i79 = 0;
        final int i83 = 1065353216;
        final int i84 = 1065353216;
        int i34 = 0;
        int i36 = 0;
        PathBuilder pathBuilder3 = new PathBuilder();
        int i58 = 0;
        PathBuilder builder11 = pathBuilder3;
        int i164 = 0;
        final int i165 = i;
        final ImageVector.Builder builder16 = builder4;
        builder11.moveTo(1084227584, 1099882824);
        PathBuilder builder12 = builder11;
        builder12.curveTo(1088002458, 1098954834, 1091850732, 1097859072, 1094713344, 1097859072);
        PathBuilder builder = builder12;
        final String str5 = str;
        final int i166 = i21;
        builder.reflectiveCurveToRelative(1084647014, 1066108191, 1088421888, 1077348925);
        int i8 = 1084227584;
        builder.verticalLineTo(i8);
        builder.horizontalLineTo(i8);
        builder.verticalLineTo(1099882824);
        builder.close();
        builder.moveTo(1094713344, 1086324736);
        int i104 = 0;
        builder12.curveToRelative(1073154621, i104, 1080033280, 1070134723, 1080033280, 1080033280);
        int i16 = 1095761920;
        int i22 = 1094713344;
        builder.reflectiveCurveTo(1096737096, i16, i22, i16);
        builder12.curveToRelative(-1074329027, i104, -1067450368, -1077348925, -1067450368, -1067450368);
        int i17 = 1086324736;
        builder.reflectiveCurveTo(1092689592, i17, i22, i17);
        builder.close();
        ImageVector.Builder.addPath-oIyEayM$default(builder5, pathBuilder3.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor3, 1050253722, i79, 1050253722, i83, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i84, 0, 0, i104, 14336, 0);
        ImageVector.Builder builder2 = builder16;
        int i13 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), builder5, 0);
        int i18 = 0;
        int i23 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i30 = 0;
        PathBuilder builder6 = pathBuilder;
        int i37 = 0;
        int i59 = 1100480512;
        builder6.moveTo(i59, 1077936128);
        builder6.horizontalLineTo(1084227584);
        PathBuilder builder13 = builder6;
        builder13.curveTo(1081711002, 1077936128, 1077936128, 1081711002, 1077936128, 1084227584);
        int i41 = 1096810496;
        builder6.verticalLineToRelative(i41);
        int i146 = 1073741824;
        builder13.curveToRelative(0, 1066192077, 1063675494, 1073741824, i146, 1073741824);
        builder6.horizontalLineToRelative(i41);
        builder13.curveToRelative(1066192077, 0, 1073741824, -1083808154, i146, -1073741824);
        builder6.verticalLineTo(1084227584);
        builder13.curveTo(1101529088, 1081711002, 1101057229, 1077936128, 1100480512, 1077936128);
        builder6.close();
        builder6.moveTo(1099431936, i59);
        builder6.horizontalLineTo(1088421888);
        builder6.verticalLineToRelative(-1099578737);
        int i148 = 1094713344;
        builder13.curveTo(1090959442, 1099756995, 1092783964, 1099431936, i148, 1099431936);
        ImageVector.Builder builder15 = builder2;
        builder6.reflectiveCurveToRelative(1080368824, 1058977874, 1084227584, 1071728558);
        int i2 = 1100480512;
        builder6.verticalLineTo(i2);
        builder6.close();
        builder6.moveTo(i2, 1099882824);
        builder13.curveTo(1099536794, 1098954834, 1097575956, 1097859072, i148, 1097859072);
        builder6.reflectiveCurveToRelative(-1062836634, 1066108191, -1059061760, 1077348925);
        builder6.verticalLineTo(1084227584);
        builder6.horizontalLineToRelative(1096810496);
        builder6.verticalLineTo(1099882824);
        builder6.close();
        int i111 = 0;
        ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i79, 1065353216, i83, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i84, 0, 0, i111, 14336, 0);
        int i14 = 0;
        SolidColor solidColor2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), pathBuilder, 0);
        int i19 = 0;
        int i24 = 0;
        PathBuilder pathBuilder2 = new PathBuilder();
        int i32 = 0;
        PathBuilder builder7 = pathBuilder2;
        int i38 = 0;
        builder7.moveTo(1094713344, 1095761920);
        PathBuilder builder14 = builder7;
        builder14.curveToRelative(1073154621, i111, 1080033280, -1077348925, 1080033280, -1067450368);
        int i63 = 1086324736;
        int i75 = 1094713344;
        builder7.reflectiveCurveTo(1096737096, i63, i75, i63);
        builder14.curveToRelative(-1074329027, i111, -1067450368, 1070134723, -1067450368, 1080033280);
        int i64 = 1095761920;
        builder7.reflectiveCurveTo(1092689592, i64, i75, i64);
        builder7.close();
        builder7.moveTo(1094713344, 1090519040);
        builder14.curveToRelative(1062501089, i111, 1069547520, 1059816735, 1069547520, 1069547520);
        int i66 = 1093664768;
        builder7.reflectiveCurveTo(1095583662, i66, i75, i66);
        int i67 = -1077936128;
        builder7.reflectiveCurveToRelative(i67, -1087666913, i67, i67);
        int i68 = 1090519040;
        builder7.reflectiveCurveTo(1093843026, i68, i75, i68);
        builder7.close();
        AccountBoxKt._accountBox = ImageVector.Builder.addPath-oIyEayM$default(builder16, pathBuilder2.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor2, 1065353216, i79, 1065353216, i83, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i84, 0, 0, i111, 14336, 0).build();
        ImageVector _accountBox3 = AccountBoxKt._accountBox;
        Intrinsics.checkNotNull(_accountBox3);
        return _accountBox3;
    }
}
