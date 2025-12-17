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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"_send", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Send", "Landroidx/compose/material/icons/Icons$Outlined;", "getSend$annotations", "(Landroidx/compose/material/icons/Icons$Outlined;)V", "getSend", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SendKt {

    private static ImageVector _send;
    static {
    }

    public static final ImageVector getSend(Icons.Outlined $this$Send) {
        if (SendKt._send != null) {
            ImageVector _send2 = SendKt._send;
            Intrinsics.checkNotNull(_send2);
            return _send2;
        }
        int i29 = 0;
        int i30 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.Send", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i28 = 0;
        int i32 = 0;
        int i38 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i38);
        final int i46 = 1065353216;
        int i34 = 0;
        int i36 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i39 = 0;
        PathBuilder builder4 = pathBuilder;
        int i48 = 0;
        final int i54 = i;
        final ImageVector.Builder builder5 = builder;
        builder4.moveTo(1082151404, 1086387651);
        builder4.lineToRelative(1089491436, 1078858875);
        builder4.lineToRelative(-1057971241, -1082130432);
        builder4.lineToRelative(1008981770, -1072819077);
        builder4.moveToRelative(1089470464, 1091274015);
        builder4.lineTo(1082130432, 1099940495);
        builder4.verticalLineToRelative(-1072819077);
        builder4.lineToRelative(1089491436, -1082130432);
        builder4.moveTo(1073783767, 1077936128);
        int i23 = 1073741824;
        builder4.lineTo(i23, 1092616192);
        builder4.lineToRelative(1097859072, i23);
        builder4.lineToRelative(-1049624576, i23);
        builder4.lineToRelative(1008981770, 1088421888);
        builder4.lineTo(1102577664, 1094713344);
        builder4.lineTo(1073783767, 1077936128);
        builder4.close();
        SendKt._send = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i38, 1065353216, i46, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i46, 0, 0, 0, 14336, 0).build();
        ImageVector _send3 = SendKt._send;
        Intrinsics.checkNotNull(_send3);
        return _send3;
    }

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Outlined.Send", replaceWith = @ReplaceWith(...))
    public static void getSend$annotations(Icons.Outlined icons$Outlined) {
    }
}
