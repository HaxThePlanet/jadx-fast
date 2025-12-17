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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_star", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Star", "Landroidx/compose/material/icons/Icons$Sharp;", "getStar", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StarKt {

    private static ImageVector _star;
    static {
    }

    public static final ImageVector getStar(Icons.Sharp $this$Star) {
        if (StarKt._star != null) {
            ImageVector _star2 = StarKt._star;
            Intrinsics.checkNotNull(_star2);
            return _star2;
        }
        int i24 = 0;
        int i25 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Sharp.Star", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i23 = 0;
        int i27 = 0;
        int i33 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i33);
        final int i41 = 1065353216;
        int i29 = 0;
        int i31 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i34 = 0;
        PathBuilder builder4 = pathBuilder;
        int i43 = 0;
        final int i49 = i;
        final ImageVector.Builder builder5 = builder;
        builder4.moveTo(1094713344, 1099573494);
        builder4.lineTo(1100050596, 1101529088);
        builder4.lineToRelative(-1076761723, -1058998845);
        builder4.lineTo(1102053376, 1091819274);
        builder4.lineToRelative(-1058663301, -1088673546);
        builder4.lineTo(1094713344, 1073741824);
        builder4.lineTo(1091766845, 1091179643);
        builder4.lineTo(1073741824, 1091819274);
        builder4.lineToRelative(1085192274, 1083661353);
        builder4.lineTo(1085947249, 1101529088);
        builder4.lineTo(1094713344, 1099573494);
        builder4.close();
        StarKt._star = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i33, 1065353216, i41, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i41, 0, 0, 0, 14336, 0).build();
        ImageVector _star3 = StarKt._star;
        Intrinsics.checkNotNull(_star3);
        return _star3;
    }
}
