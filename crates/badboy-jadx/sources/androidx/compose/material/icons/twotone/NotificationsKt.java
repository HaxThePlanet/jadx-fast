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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_notifications", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Notifications", "Landroidx/compose/material/icons/Icons$TwoTone;", "getNotifications", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NotificationsKt {

    private static ImageVector _notifications;
    static {
    }

    public static final ImageVector getNotifications(Icons.TwoTone $this$Notifications) {
        if (NotificationsKt._notifications != null) {
            ImageVector _notifications2 = NotificationsKt._notifications;
            Intrinsics.checkNotNull(_notifications2);
            return _notifications2;
        }
        int i19 = 0;
        int i21 = 0;
        ImageVector.Builder builder4 = new ImageVector.Builder("TwoTone.Notifications", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i18 = 0;
        int i23 = 0;
        SolidColor solidColor2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, 0);
        final int i54 = 0;
        final int i57 = 1065353216;
        final int i58 = 1065353216;
        int i28 = 0;
        PathBuilder pathBuilder2 = new PathBuilder();
        int i42 = 0;
        PathBuilder builder9 = pathBuilder2;
        int i110 = 0;
        final int i111 = i;
        builder9.moveTo(1094713344, 1087373312);
        int i96 = -1065353216;
        PathBuilder builder10 = builder9;
        builder10.curveToRelative(-1071686615, 0, -1065353216, 1073825710, i96, 1083179008);
        PathBuilder builder = builder10;
        builder.verticalLineToRelative(1086324736);
        builder.horizontalLineToRelative(1090519040);
        builder.verticalLineToRelative(-1061158912);
        int i62 = 0;
        builder10.curveToRelative(i62, -1071728558, -1077852242, -1064304640, i96, -1064304640);
        builder10.close();
        int i69 = 0;
        ImageVector.Builder.addPath-oIyEayM$default(builder4, pathBuilder2.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor2, 1050253722, i54, 1050253722, i57, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i58, 0, i62, i69, 14336, 0);
        ImageVector.Builder builder2 = builder13;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), 0, 0);
        int i20 = 0;
        int i24 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i30 = 0;
        PathBuilder builder6 = pathBuilder;
        int i43 = 0;
        ImageVector.Builder builder12 = builder2;
        builder6.moveTo(1094713344, 1102053376);
        int i97 = 1073741824;
        PathBuilder builder11 = builder6;
        builder11.curveToRelative(1066192077, i69, 1073741824, -1083808154, i97, -1073741824);
        PathBuilder builder3 = builder11;
        builder3.horizontalLineToRelative(-1065353216);
        int i64 = 0;
        builder11.curveToRelative(i64, 1066192077, 1063675494, 1073741824, i97, 1073741824);
        builder3.close();
        builder3.moveTo(1099956224, 1098907648);
        builder3.verticalLineToRelative(-1063256064);
        builder11.curveToRelative(i64, -1069253919, -1076845609, -1061913887, -1064304640, -1060487823);
        builder3.lineTo(1096286208, 1082130432);
        builder11.curveToRelative(i64, -1084982559, -1087666913, -1077936128, -1077936128, -1077936128);
        final int i112 = i5;
        int $i$f$materialPathYwgOQQI = -1077936128;
        builder3.reflectiveCurveToRelative($i$f$materialPathYwgOQQI, 1059816735, $i$f$materialPathYwgOQQI, 1069547520);
        builder3.verticalLineToRelative(1059984507);
        builder11.curveTo(1089764065, 1084982559, 1086324736, 1090351268, 1086324736, 1093664768);
        builder3.verticalLineToRelative(1084227584);
        builder3.lineToRelative(-1073741824, 1073741824);
        builder3.verticalLineToRelative(1065353216);
        builder3.horizontalLineToRelative(1098907648);
        builder3.verticalLineToRelative(-1082130432);
        int i12 = -1073741824;
        builder3.lineToRelative(i12, i12);
        builder3.close();
        int i13 = 1099431936;
        builder3.moveTo(1098907648, i13);
        builder3.lineTo(1090519040, i13);
        builder3.verticalLineToRelative(-1061158912);
        int i66 = 0;
        builder11.curveToRelative(i66, -1071728558, 1069631406, -1064304640, 1082130432, -1064304640);
        int i51 = 1082130432;
        builder3.reflectiveCurveToRelative(i51, 1073825710, i51, 1083179008);
        builder3.verticalLineToRelative(1086324736);
        builder3.close();
        NotificationsKt._notifications = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i54, 1065353216, i57, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i58, 0, i66, 0, 14336, 0).build();
        ImageVector _notifications3 = NotificationsKt._notifications;
        Intrinsics.checkNotNull(_notifications3);
        return _notifications3;
    }
}
