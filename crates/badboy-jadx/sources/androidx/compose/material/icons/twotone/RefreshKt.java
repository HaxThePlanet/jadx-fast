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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_refresh", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Refresh", "Landroidx/compose/material/icons/Icons$TwoTone;", "getRefresh", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RefreshKt {

    private static ImageVector _refresh;
    static {
    }

    public static final ImageVector getRefresh(Icons.TwoTone $this$Refresh) {
        if (RefreshKt._refresh != null) {
            ImageVector _refresh2 = RefreshKt._refresh;
            Intrinsics.checkNotNull(_refresh2);
            return _refresh2;
        }
        String str = "TwoTone.Refresh";
        int i14 = 0;
        int i15 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i13 = 0;
        int i17 = 0;
        int i23 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i23);
        final int i33 = 1065353216;
        int i19 = 0;
        int i21 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i24 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i73 = 0;
        final int i74 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1099772723, 1087058739);
        PathBuilder builder6 = builder5;
        builder6.curveTo(1099012506, 1084017869, 1097030697, 1082130432, 1094713344, 1082130432);
        int i44 = 0;
        builder6.curveToRelative(-1064472412, i44, -1056985580, 1080368824, -1056985580, 1090519040);
        PathBuilder builder = builder6;
        final String str3 = str;
        int name$iv = 1090519040;
        builder.reflectiveCurveToRelative(1080326881, name$iv, 1090498068, name$iv);
        builder6.curveToRelative(1080997970, i44, 1088086344, -1071434957, 1089952809, -1061158912);
        builder.horizontalLineToRelative(-1073406280);
        builder6.curveToRelative(-1085150331, 1075125944, -1069379748, 1082130432, -1061892915, 1082130432);
        int i46 = 0;
        builder6.curveToRelative(-1068247286, i46, -1061158912, -1070847754, -1061158912, -1061158912);
        int i29 = -1061158912;
        builder.reflectiveCurveToRelative(1076635894, i29, 1086324736, i29);
        builder6.curveToRelative(1070889697, i46, 1078523331, 1060152279, 1082591805, 1071896330);
        builder.lineTo(1095761920, 1093664768);
        builder.horizontalLineToRelative(1088421888);
        builder.verticalLineTo(1082130432);
        builder.lineToRelative(-1072273818, 1075209830);
        builder.close();
        RefreshKt._refresh = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i23, 1065353216, i33, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i33, 0, 0, i46, 14336, 0).build();
        ImageVector _refresh3 = RefreshKt._refresh;
        Intrinsics.checkNotNull(_refresh3);
        return _refresh3;
    }
}
