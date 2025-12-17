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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_accountBox", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccountBox", "Landroidx/compose/material/icons/Icons$Filled;", "getAccountBox", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AccountBoxKt {

    private static ImageVector _accountBox;
    static {
    }

    public static final ImageVector getAccountBox(Icons.Filled $this$AccountBox) {
        if (AccountBoxKt._accountBox != null) {
            ImageVector _accountBox2 = AccountBoxKt._accountBox;
            Intrinsics.checkNotNull(_accountBox2);
            return _accountBox2;
        }
        String str = "Filled.AccountBox";
        int i14 = 0;
        int i15 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i17 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, 0);
        int i19 = 0;
        int i21 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i24 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i99 = 0;
        final int i100 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1100480512, 1077936128);
        builder5.horizontalLineTo(1084227584);
        PathBuilder builder6 = builder5;
        builder6.curveTo(1081711002, 1077936128, 1077936128, 1081711002, 1077936128, 1084227584);
        PathBuilder builder = builder6;
        int i3 = 1096810496;
        builder.verticalLineToRelative(i3);
        int i82 = 1073741824;
        builder6.curveToRelative(0, 1066192077, 1063675494, 1073741824, i82, 1073741824);
        builder.horizontalLineToRelative(i3);
        builder6.curveToRelative(1066192077, 0, 1073741824, -1083808154, i82, -1073741824);
        builder.verticalLineTo(1084227584);
        builder6.curveTo(1101529088, 1081711002, 1101057229, 1077936128, 1100480512, 1077936128);
        builder.close();
        builder.moveTo(1094713344, 1086324736);
        int i94 = 1080033280;
        builder6.curveToRelative(1073154621, 0, 1080033280, 1070134723, 1080033280, i94);
        builder6.curveToRelative(0, 1073154621, -1077348925, 1080033280, -1067450368, i94);
        int i29 = -1067450368;
        builder.reflectiveCurveToRelative(i29, -1077348925, i29, i29);
        builder6.curveTo(1091043328, 1089617265, 1092689592, 1086324736, 1094713344, 1086324736);
        builder.close();
        int i7 = 1100480512;
        builder.moveTo(i7, i7);
        builder.horizontalLineTo(1084227584);
        builder.verticalLineToRelative(-1100249825);
        builder6.curveToRelative(0, -1088505774, 1049582633, -1080452710, 1061326684, -1077265039);
        builder6.curveTo(1089407549, 1098718904, 1092238705, 1097859072, 1094713344, 1097859072);
        final String str3 = str;
        final int i101 = i13;
        builder.reflectiveCurveToRelative(1083241923, 1062333317, 1086828052, 1074538742);
        builder6.curveToRelative(1056293519, 1052938076, 1061326684, 1064849900, 1061326684, 1070218609);
        builder.verticalLineTo(1100480512);
        builder.close();
        AccountBoxKt._accountBox = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, 0, 1065353216, 1065353216, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), 1065353216, 0, 0, 0, 14336, 0).build();
        ImageVector _accountBox3 = AccountBoxKt._accountBox;
        Intrinsics.checkNotNull(_accountBox3);
        return _accountBox3;
    }
}
