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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_playArrow", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PlayArrow", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPlayArrow", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlayArrowKt {

    private static ImageVector _playArrow;
    static {
    }

    public static final ImageVector getPlayArrow(Icons.TwoTone $this$PlayArrow) {
        if (PlayArrowKt._playArrow != null) {
            ImageVector _playArrow2 = PlayArrowKt._playArrow;
            Intrinsics.checkNotNull(_playArrow2);
            return _playArrow2;
        }
        int i4 = 0;
        int i6 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("TwoTone.PlayArrow", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i3 = 0;
        int i8 = 0;
        int i28 = 0;
        SolidColor solidColor2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i28);
        int i11 = 1065353216;
        int i24 = 0;
        PathBuilder pathBuilder2 = new PathBuilder();
        int i52 = 0;
        int i58 = 0;
        int i62 = i11;
        final int i63 = i;
        PathBuilder $i$f$materialIcon = builder7;
        $i$f$materialIcon.moveTo(1092616192, 1091190129);
        $i$f$materialIcon.verticalLineToRelative(1087834685);
        $i$f$materialIcon.lineTo(1098142188, 1094713344);
        $i$f$materialIcon.close();
        final int i60 = 14336;
        final int i61 = 0;
        int i59 = 0;
        ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder2.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor2, 1050253722, i28, 1050253722, i11, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i11, 0, 0, i59, i60, i61);
        ImageVector.Builder builder = builder2;
        int i5 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), 0, 0);
        int i9 = 0;
        int i25 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i41 = 0;
        int i56 = 0;
        ImageVector.Builder builder8 = builder;
        PathBuilder $this$materialPath_u2dYwgOQQI_u24default$iv = builder6;
        $this$materialPath_u2dYwgOQQI_u24default$iv.moveTo(1090519040, 1100480512);
        $this$materialPath_u2dYwgOQQI_u24default$iv.lineToRelative(1093664768, -1059061760);
        $this$materialPath_u2dYwgOQQI_u24default$iv.lineTo(1090519040, 1084227584);
        $this$materialPath_u2dYwgOQQI_u24default$iv.verticalLineToRelative(1096810496);
        $this$materialPath_u2dYwgOQQI_u24default$iv.close();
        $this$materialPath_u2dYwgOQQI_u24default$iv.moveTo(1092616192, 1091190129);
        $this$materialPath_u2dYwgOQQI_u24default$iv.lineTo(1098142188, 1094713344);
        int i36 = 1092616192;
        $this$materialPath_u2dYwgOQQI_u24default$iv.lineTo(i36, 1098236559);
        $this$materialPath_u2dYwgOQQI_u24default$iv.lineTo(i36, 1091190129);
        $this$materialPath_u2dYwgOQQI_u24default$iv.close();
        PlayArrowKt._playArrow = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, 0, 1065353216, i62, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i62, 0, 0, i59, i60, i61).build();
        ImageVector _playArrow3 = PlayArrowKt._playArrow;
        Intrinsics.checkNotNull(_playArrow3);
        return _playArrow3;
    }
}
