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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_notifications", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Notifications", "Landroidx/compose/material/icons/Icons$Rounded;", "getNotifications", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NotificationsKt {

    private static ImageVector _notifications;
    static {
    }

    public static final ImageVector getNotifications(Icons.Rounded $this$Notifications) {
        if (NotificationsKt._notifications != null) {
            ImageVector _notifications2 = NotificationsKt._notifications;
            Intrinsics.checkNotNull(_notifications2);
            return _notifications2;
        }
        String str = "Rounded.Notifications";
        int i16 = 0;
        int i17 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i15 = 0;
        int i19 = 0;
        int i25 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i25);
        final int i36 = 1065353216;
        int i21 = 0;
        int i23 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i26 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i81 = 0;
        final int i82 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1094713344, 1102053376);
        int i68 = 1073741824;
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(1066192077, 0, 1073741824, -1083808154, i68, -1073741824);
        PathBuilder builder = builder6;
        builder.horizontalLineToRelative(-1065353216);
        int i40 = 0;
        builder6.curveToRelative(i40, 1066192077, 1063507722, 1073741824, i68, 1073741824);
        builder.close();
        builder.moveTo(1099956224, 1098907648);
        builder.verticalLineToRelative(-1063256064);
        builder6.curveToRelative(i40, -1069253919, -1076761723, -1061913887, -1064304640, -1060487823);
        builder.lineTo(1096286208, 1082130432);
        builder6.curveToRelative(i40, -1084982559, -1087666913, -1077936128, -1077936128, -1077936128);
        final String str3 = str;
        int name$iv = -1077936128;
        builder.reflectiveCurveToRelative(name$iv, 1059816735, name$iv, 1069547520);
        builder.verticalLineToRelative(1059984507);
        builder6.curveTo(1089743094, 1084982559, 1086324736, 1090351268, 1086324736, 1093664768);
        builder.verticalLineToRelative(1084227584);
        builder.lineToRelative(-1079697736, 1067785912);
        builder6.curveToRelative(-1088338002, 1059145646, -1102934180, 1071309128, 1060320051, 1071309128);
        builder.horizontalLineToRelative(1095940178);
        int i51 = 0;
        builder6.curveToRelative(1063507722, i51, 1068205343, -1081459343, 1060487823, -1076174520);
        builder.lineTo(1099956224, 1098907648);
        builder.close();
        NotificationsKt._notifications = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i25, 1065353216, i36, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i36, 0, 0, i51, 14336, 0).build();
        ImageVector _notifications3 = NotificationsKt._notifications;
        Intrinsics.checkNotNull(_notifications3);
        return _notifications3;
    }
}
