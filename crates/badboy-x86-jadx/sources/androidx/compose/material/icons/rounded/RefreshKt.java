package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons.Rounded;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_refresh", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Refresh", "Landroidx/compose/material/icons/Icons$Rounded;", "getRefresh", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RefreshKt {

    private static ImageVector _refresh;
    static {
    }

    public static final ImageVector getRefresh(Icons.Rounded $this$Refresh) {
        if (RefreshKt._refresh != null) {
            ImageVector _refresh2 = RefreshKt._refresh;
            Intrinsics.checkNotNull(_refresh2);
            return _refresh2;
        }
        int i8 = 0;
        int i9 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Rounded.Refresh", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i7 = 0;
        int i11 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, 0);
        int i13 = 0;
        int i15 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i18 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i111 = 0;
        final int i112 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1099772723, 1087058739);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(-1076845609, -1076845609, -1065604874, -1071351071, -1060152279, -1072441590);
        builder6.curveToRelative(-1066737336, 1052602532, -1059711877, 1079404134, -1058852045, 1088463831);
        builder6.curveTo(1080117166, 1098813276, 1088988119, 1101004800, 1094713344, 1101004800);
        builder6.curveToRelative(1078733046, 0, 1086177935, -1074832343, 1088862290, -1064178811);
        builder6.curveToRelative(1050924810, -1087666913, -1104947446, -1078439444, -1083808154, -1078439444);
        builder6.curveToRelative(-1094881116, 0, -1086828052, 1045220557, -1084143698, 1057467924);
        builder6.curveToRelative(-1081039913, 1075545375, -1066024305, 1082004603, -1059481190, 1079236362);
        builder6.curveToRelative(-1072819077, -1090854584, -1065332244, -1072483533, -1064346583, -1064262697);
        builder6.curveTo(1084877701, 1092028989, 1090791670, 1086324736, 1094713344, 1086324736);
        builder6.curveToRelative(1070889697, 0, 1078523331, 1060152279, 1082591805, 1071896330);
        PathBuilder builder = builder6;
        builder.lineToRelative(-1077852242, 1069631406);
        builder6.curveToRelative(-1088338002, 1059145646, -1102934180, 1071309128, 1060320051, 1071309128);
        builder.horizontalLineTo(1100480512);
        builder6.curveToRelative(1057803469, 0, 1065353216, -1092196762, 1065353216, -1082130432);
        builder.verticalLineTo(1087184568);
        int i42 = 0;
        builder6.curveToRelative(i42, -1083975926, -1081459343, -1079278305, -1076174520, -1086995825);
        builder.lineToRelative(-1088170230, 1059481190);
        builder.close();
        RefreshKt._refresh = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, 0, 1065353216, 1065353216, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), 1065353216, 0, i42, 0, 14336, 0).build();
        ImageVector _refresh3 = RefreshKt._refresh;
        Intrinsics.checkNotNull(_refresh3);
        return _refresh3;
    }
}
