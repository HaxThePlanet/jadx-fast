package androidx.compose.material.icons.automirrored.sharp;

import androidx.compose.material.icons.Icons.AutoMirrored.Sharp;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_send", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Send", "Landroidx/compose/material/icons/Icons$AutoMirrored$Sharp;", "getSend", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SendKt {

    private static ImageVector _send;
    static {
    }

    public static final ImageVector getSend(Icons.AutoMirrored.Sharp $this$Send) {
        if (SendKt._send != null) {
            ImageVector _send2 = SendKt._send;
            Intrinsics.checkNotNull(_send2);
            return _send2;
        }
        int i14 = 0;
        int i15 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("AutoMirrored.Sharp.Send", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 1, 96, 0);
        int i13 = 0;
        int i17 = 0;
        int i23 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i23);
        final int i31 = 1065353216;
        int i19 = 0;
        int i21 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i24 = 0;
        PathBuilder builder4 = pathBuilder;
        int i33 = 0;
        final int i39 = i;
        final ImageVector.Builder builder5 = builder;
        builder4.moveTo(1073783767, 1101529088);
        builder4.lineTo(1102577664, 1094713344);
        builder4.lineTo(1073783767, 1077936128);
        int i10 = 1073741824;
        builder4.lineTo(i10, 1092616192);
        builder4.lineToRelative(1097859072, i10);
        builder4.lineToRelative(-1049624576, i10);
        builder4.lineToRelative(1008981770, 1088421888);
        builder4.close();
        SendKt._send = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i23, 1065353216, i31, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i31, 0, 0, 0, 14336, 0).build();
        ImageVector _send3 = SendKt._send;
        Intrinsics.checkNotNull(_send3);
        return _send3;
    }
}
