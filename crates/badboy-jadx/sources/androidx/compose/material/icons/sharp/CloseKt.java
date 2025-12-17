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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_close", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Close", "Landroidx/compose/material/icons/Icons$Sharp;", "getClose", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CloseKt {

    private static ImageVector _close;
    static {
    }

    public static final ImageVector getClose(Icons.Sharp $this$Close) {
        if (CloseKt._close != null) {
            ImageVector _close2 = CloseKt._close;
            Intrinsics.checkNotNull(_close2);
            return _close2;
        }
        int i24 = 0;
        int i25 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Sharp.Close", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
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
        builder4.moveTo(1100480512, 1087184568);
        builder4.lineTo(1099741266, 1084227584);
        builder4.lineTo(1094713344, 1093234852);
        int i4 = 1084227584;
        int i14 = 1087184568;
        builder4.lineTo(i14, i4);
        builder4.lineTo(i4, i14);
        builder4.lineTo(1093234852, 1094713344);
        builder4.lineTo(1084227584, 1099741266);
        builder4.lineTo(1087184568, 1100480512);
        builder4.lineTo(1094713344, 1096191836);
        int i9 = 1099741266;
        int i19 = 1100480512;
        builder4.lineTo(i9, i19);
        builder4.lineTo(i19, i9);
        builder4.lineTo(1096191836, 1094713344);
        builder4.lineTo(1100480512, 1087184568);
        builder4.close();
        CloseKt._close = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i33, 1065353216, i41, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i41, 0, 0, 0, 14336, 0).build();
        ImageVector _close3 = CloseKt._close;
        Intrinsics.checkNotNull(_close3);
        return _close3;
    }
}
