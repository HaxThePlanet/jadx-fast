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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_accountBox", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccountBox", "Landroidx/compose/material/icons/Icons$Sharp;", "getAccountBox", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AccountBoxKt {

    private static ImageVector _accountBox;
    static {
    }

    public static final ImageVector getAccountBox(Icons.Sharp $this$AccountBox) {
        if (AccountBoxKt._accountBox != null) {
            ImageVector _accountBox2 = AccountBoxKt._accountBox;
            Intrinsics.checkNotNull(_accountBox2);
            return _accountBox2;
        }
        String str = "Sharp.AccountBox";
        int i11 = 0;
        int i12 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i14 = 0;
        int i20 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i20);
        final int i32 = 1065353216;
        int i16 = 0;
        int i18 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i21 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i74 = 0;
        final int i75 = i;
        final ImageVector.Builder builder7 = builder2;
        int $this$_get_AccountBox__u24lambda_u241 = 1077936128;
        builder5.moveTo(1101529088, $this$_get_AccountBox__u24lambda_u241);
        builder5.horizontalLineTo($this$_get_AccountBox__u24lambda_u241);
        int i2 = 1099956224;
        builder5.verticalLineToRelative(i2);
        builder5.horizontalLineToRelative(i2);
        builder5.verticalLineTo($this$_get_AccountBox__u24lambda_u241);
        builder5.close();
        builder5.moveTo(1094713344, 1086324736);
        int i69 = 1080033280;
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(1073154621, 0, 1080033280, 1070134723, 1080033280, i69);
        builder6.curveToRelative(0, 1073154621, -1077348925, 1080033280, -1067450368, i69);
        PathBuilder builder = builder6;
        int i25 = -1067450368;
        builder.reflectiveCurveToRelative(i25, -1077348925, i25, i25);
        builder6.curveTo(1091043328, 1089617265, 1092689592, 1086324736, 1094713344, 1086324736);
        builder.close();
        int i6 = 1100480512;
        builder.moveTo(i6, i6);
        builder.horizontalLineTo(1084227584);
        builder.verticalLineToRelative(-1100249825);
        builder6.curveToRelative(0, -1088505774, 1049582633, -1080452710, 1061326684, -1077265039);
        builder6.curveTo(1089407549, 1098718904, 1092238705, 1097859072, 1094713344, 1097859072);
        final String str3 = str;
        final int i76 = i10;
        builder.reflectiveCurveToRelative(1083241923, 1062333317, 1086828052, 1074538742);
        builder6.curveToRelative(1056293519, 1052938076, 1061326684, 1064849900, 1061326684, 1070218609);
        builder.verticalLineTo(1100480512);
        builder.close();
        AccountBoxKt._accountBox = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i20, 1065353216, i32, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i32, 0, 0, 0, 14336, 0).build();
        ImageVector _accountBox3 = AccountBoxKt._accountBox;
        Intrinsics.checkNotNull(_accountBox3);
        return _accountBox3;
    }
}
