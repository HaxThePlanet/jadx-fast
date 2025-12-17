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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"_send", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Send", "Landroidx/compose/material/icons/Icons$Rounded;", "getSend$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getSend", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SendKt {

    private static ImageVector _send;
    static {
    }

    public static final ImageVector getSend(Icons.Rounded $this$Send) {
        if (SendKt._send != null) {
            ImageVector _send2 = SendKt._send;
            Intrinsics.checkNotNull(_send2);
            return _send2;
        }
        int i11 = 0;
        int i12 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Rounded.Send", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i10 = 0;
        int i14 = 0;
        int i20 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i20);
        final int i33 = 1065353216;
        int i16 = 0;
        int i18 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i21 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i69 = 0;
        final int i70 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1079613850, 1101214515);
        builder5.lineToRelative(1099667866, -1058055127);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(1062165545, -1095552205, 1062165545, -1078020014, 0, -1075084001);
        PathBuilder builder = builder6;
        builder.lineTo(1079613850, 1080452710);
        builder6.curveToRelative(-1087834685, -1097565471, -1078858875, 1045220557, -1078858875, 1063843267);
        builder.lineTo(1073741824, 1091693445);
        builder6.curveToRelative(0, 1056964608, 1052602532, 1064178811, 1063172178, 1065185444);
        builder.lineTo(1099431936, 1094713344);
        builder.lineTo(1077390868, 1096684667);
        builder6.curveToRelative(-1090519040, 1032805417, -1084311470, 1056964608, -1084311470, 1065353216);
        builder.lineToRelative(1008981770, 1083409695);
        int i40 = 0;
        builder6.curveToRelative(i40, 1060487823, 1060823368, 1067030938, 1068624773, 1063843267);
        builder6.close();
        SendKt._send = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i20, 1065353216, i33, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i33, 0, i40, 0, 14336, 0).build();
        ImageVector _send3 = SendKt._send;
        Intrinsics.checkNotNull(_send3);
        return _send3;
    }

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Rounded.Send", replaceWith = @ReplaceWith(...))
    public static void getSend$annotations(Icons.Rounded icons$Rounded) {
    }
}
