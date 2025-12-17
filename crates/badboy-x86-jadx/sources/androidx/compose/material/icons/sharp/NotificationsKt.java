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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_notifications", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Notifications", "Landroidx/compose/material/icons/Icons$Sharp;", "getNotifications", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NotificationsKt {

    private static ImageVector _notifications;
    static {
    }

    public static final ImageVector getNotifications(Icons.Sharp $this$Notifications) {
        if (NotificationsKt._notifications != null) {
            ImageVector _notifications2 = NotificationsKt._notifications;
            Intrinsics.checkNotNull(_notifications2);
            return _notifications2;
        }
        int i15 = 0;
        int i16 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Sharp.Notifications", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i14 = 0;
        int i18 = 0;
        int i29 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i29);
        int i20 = 1065353216;
        int i26 = 0;
        final int i27 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i33 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i66 = 0;
        final int i67 = i;
        final ImageVector.Builder builder5 = builder;
        PathBuilder $this$_get_Notifications__u24lambda_u241 = builder4;
        $this$_get_Notifications__u24lambda_u241.moveTo(1094713344, 1102053376);
        int i59 = 1073741824;
        builder4.curveToRelative(1066192077, 0, 1073741824, -1083808154, i59, -1073741824);
        $this$_get_Notifications__u24lambda_u241.horizontalLineToRelative(-1065353216);
        int i41 = 0;
        builder4.curveToRelative(i41, 1066192077, 1063507722, 1073741824, i59, 1073741824);
        $this$_get_Notifications__u24lambda_u241.close();
        $this$_get_Notifications__u24lambda_u241.moveTo(1099956224, 1098907648);
        $this$_get_Notifications__u24lambda_u241.verticalLineToRelative(-1063256064);
        builder4.curveToRelative(i41, -1069253919, -1076761723, -1061913887, -1064304640, -1060487823);
        $this$_get_Notifications__u24lambda_u241.lineTo(1096286208, 1075838976);
        $this$_get_Notifications__u24lambda_u241.horizontalLineToRelative(-1069547520);
        $this$_get_Notifications__u24lambda_u241.verticalLineToRelative(1074496799);
        builder4.curveTo(1089743094, 1084982559, 1086324736, 1090351268, 1086324736, 1093664768);
        $this$_get_Notifications__u24lambda_u241.verticalLineToRelative(1084227584);
        int i24 = -1073741824;
        $this$_get_Notifications__u24lambda_u241.lineToRelative(i24, 1073741824);
        $this$_get_Notifications__u24lambda_u241.verticalLineToRelative(1065353216);
        $this$_get_Notifications__u24lambda_u241.horizontalLineToRelative(1098907648);
        $this$_get_Notifications__u24lambda_u241.verticalLineToRelative(-1082130432);
        $this$_get_Notifications__u24lambda_u241.lineToRelative(i24, i24);
        $this$_get_Notifications__u24lambda_u241.close();
        NotificationsKt._notifications = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i29, 1065353216, i20, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i20, 0, 0, 0, 14336, 0).build();
        ImageVector _notifications3 = NotificationsKt._notifications;
        Intrinsics.checkNotNull(_notifications3);
        return _notifications3;
    }
}
