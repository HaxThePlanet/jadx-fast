package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons.Filled;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_playArrow", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PlayArrow", "Landroidx/compose/material/icons/Icons$Filled;", "getPlayArrow", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlayArrowKt {

    private static ImageVector _playArrow;
    static {
    }

    public static final ImageVector getPlayArrow(Icons.Filled $this$PlayArrow) {
        if (PlayArrowKt._playArrow != null) {
            ImageVector _playArrow2 = PlayArrowKt._playArrow;
            Intrinsics.checkNotNull(_playArrow2);
            return _playArrow2;
        }
        int i7 = 0;
        int i8 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Filled.PlayArrow", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i6 = 0;
        int i10 = 0;
        int i16 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i16);
        final int i24 = 1065353216;
        int i12 = 0;
        int i14 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i17 = 0;
        PathBuilder builder4 = pathBuilder;
        int i26 = 0;
        final int i32 = i;
        final ImageVector.Builder builder5 = builder;
        builder4.moveTo(1090519040, 1084227584);
        builder4.verticalLineToRelative(1096810496);
        builder4.lineToRelative(1093664768, -1059061760);
        builder4.close();
        PlayArrowKt._playArrow = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i16, 1065353216, i24, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i24, 0, 0, 0, 14336, 0).build();
        ImageVector _playArrow3 = PlayArrowKt._playArrow;
        Intrinsics.checkNotNull(_playArrow3);
        return _playArrow3;
    }
}
