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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_playArrow", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PlayArrow", "Landroidx/compose/material/icons/Icons$Rounded;", "getPlayArrow", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlayArrowKt {

    private static ImageVector _playArrow;
    static {
    }

    public static final ImageVector getPlayArrow(Icons.Rounded $this$PlayArrow) {
        if (PlayArrowKt._playArrow != null) {
            ImageVector _playArrow2 = PlayArrowKt._playArrow;
            Intrinsics.checkNotNull(_playArrow2);
            return _playArrow2;
        }
        int i7 = 0;
        int i8 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Rounded.PlayArrow", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i6 = 0;
        int i10 = 0;
        int i16 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i16);
        final int i26 = 1065353216;
        int i12 = 0;
        int i14 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i17 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i51 = 0;
        final int i52 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1090519040, 1088044401);
        builder5.verticalLineToRelative(1092993679);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(0, 1061830001, 1063172178, 1067618140, 1069883064, 1062668861);
        PathBuilder builder = builder6;
        builder.lineToRelative(1090665841, -1062878577);
        builder6.curveToRelative(1058977874, -1094210028, 1058977874, -1079697736, 0, -1076342292);
        builder.lineTo(1092133847, 1086282793);
        builder6.curveTo(1091431301, 1085381018, 1090519040, 1086387651, 1090519040, 1088044401);
        builder6.close();
        PlayArrowKt._playArrow = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i16, 1065353216, i26, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i26, 0, 0, 0, 14336, 0).build();
        ImageVector _playArrow3 = PlayArrowKt._playArrow;
        Intrinsics.checkNotNull(_playArrow3);
        return _playArrow3;
    }
}
