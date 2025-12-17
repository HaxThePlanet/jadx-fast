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
        int i26 = 0;
        int i27 = 0;
        ImageVector.Builder builder4 = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        ImageVector.Builder builder5 = builder4;
        int i29 = 0;
        SolidColor solidColor3 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, 0);
        final int i80 = 0;
        final int i84 = 1065353216;
        final int i85 = 1065353216;
        int i35 = 0;
        int i37 = 0;
        PathBuilder pathBuilder3 = new PathBuilder();
        int i59 = 0;
        PathBuilder builder11 = pathBuilder3;
        int i165 = 0;
        final int i166 = i;
        final ImageVector.Builder builder16 = builder4;
        builder11.moveTo(1084227584, 1099882824);
        PathBuilder builder12 = builder11;
        builder12.curveTo(1088002458, 1098954834, 1091850732, 1097859072, 1094713344, 1097859072);
        PathBuilder builder = builder12;
        final String str5 = str;
        final int i167 = i21;
        builder.reflectiveCurveToRelative(1084647014, 1066108191, 1088421888, 1077348925);
        int i8 = 1084227584;
        builder.verticalLineTo(i8);
        builder.horizontalLineTo(i8);
        builder.verticalLineTo(1099882824);
        builder.close();
        builder.moveTo(1094713344, 1086324736);
        int i105 = 0;
        builder12.curveToRelative(1073154621, i105, 1080033280, 1070134723, 1080033280, 1080033280);
        int i16 = 1095761920;
        int i23 = 1094713344;
        builder.reflectiveCurveTo(1096737096, i16, i23, i16);
        builder12.curveToRelative(-1074329027, i105, -1067450368, -1077348925, -1067450368, -1067450368);
        int i17 = 1086324736;
        builder.reflectiveCurveTo(1092689592, i17, i23, i17);
        builder.close();
        ImageVector.Builder.addPath-oIyEayM$default(builder5, pathBuilder3.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor3, 1050253722, i80, 1050253722, i84, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i85, 0, 0, i105, 14336, 0);
        ImageVector.Builder builder2 = builder16;
        int i13 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), builder5, 0);
        int i18 = 0;
        int i24 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i31 = 0;
        PathBuilder builder6 = pathBuilder;
        int i38 = 0;
        int i60 = 1100480512;
        builder6.moveTo(i60, 1077936128);
        builder6.horizontalLineTo(1084227584);
        PathBuilder builder13 = builder6;
        builder13.curveTo(1081711002, 1077936128, 1077936128, 1081711002, 1077936128, 1084227584);
        int i42 = 1096810496;
        builder6.verticalLineToRelative(i42);
        int i147 = 1073741824;
        builder13.curveToRelative(0, 1066192077, 1063675494, 1073741824, i147, 1073741824);
        builder6.horizontalLineToRelative(i42);
        builder13.curveToRelative(1066192077, 0, 1073741824, -1083808154, i147, -1073741824);
        builder6.verticalLineTo(1084227584);
        builder13.curveTo(1101529088, 1081711002, 1101057229, 1077936128, 1100480512, 1077936128);
        builder6.close();
        builder6.moveTo(1099431936, i60);
        builder6.horizontalLineTo(1088421888);
        builder6.verticalLineToRelative(-1099578737);
        int i149 = 1094713344;
        builder13.curveTo(1090959442, 1099756995, 1092783964, 1099431936, i149, 1099431936);
        ImageVector.Builder builder15 = builder2;
        builder6.reflectiveCurveToRelative(1080368824, 1058977874, 1084227584, 1071728558);
        int i2 = 1100480512;
        builder6.verticalLineTo(i2);
        builder6.close();
        builder6.moveTo(i2, 1099882824);
        builder13.curveTo(1099536794, 1098954834, 1097575956, 1097859072, i149, 1097859072);
        builder6.reflectiveCurveToRelative(-1062836634, 1066108191, -1059061760, 1077348925);
        builder6.verticalLineTo(1084227584);
        builder6.horizontalLineToRelative(1096810496);
        builder6.verticalLineTo(1099882824);
        builder6.close();
        int i112 = 0;
        ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i80, 1065353216, i84, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i85, 0, 0, i112, 14336, 0);
        int i14 = 0;
        SolidColor solidColor2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), pathBuilder, 0);
        int i19 = 0;
        int i25 = 0;
        PathBuilder pathBuilder2 = new PathBuilder();
        int i33 = 0;
        PathBuilder builder7 = pathBuilder2;
        int i39 = 0;
        builder7.moveTo(1094713344, 1095761920);
        PathBuilder builder14 = builder7;
        builder14.curveToRelative(1073154621, i112, 1080033280, -1077348925, 1080033280, -1067450368);
        int i64 = 1086324736;
        int i76 = 1094713344;
        builder7.reflectiveCurveTo(1096737096, i64, i76, i64);
        builder14.curveToRelative(-1074329027, i112, -1067450368, 1070134723, -1067450368, 1080033280);
        int i65 = 1095761920;
        builder7.reflectiveCurveTo(1092689592, i65, i76, i65);
        builder7.close();
        builder7.moveTo(1094713344, 1090519040);
        builder14.curveToRelative(1062501089, i112, 1069547520, 1059816735, 1069547520, 1069547520);
        int i67 = 1093664768;
        builder7.reflectiveCurveTo(1095583662, i67, i76, i67);
        int i68 = -1077936128;
        builder7.reflectiveCurveToRelative(i68, -1087666913, i68, i68);
        int i69 = 1090519040;
        builder7.reflectiveCurveTo(1093843026, i69, i76, i69);
        builder7.close();
        AccountBoxKt._accountBox = ImageVector.Builder.addPath-oIyEayM$default(builder16, pathBuilder2.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor2, 1065353216, i80, 1065353216, i84, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i85, 0, 0, i112, 14336, 0).build();
        ImageVector _accountBox3 = AccountBoxKt._accountBox;
        Intrinsics.checkNotNull(_accountBox3);
        return _accountBox3;
    }
}
