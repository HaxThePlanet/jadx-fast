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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_done", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Done", "Landroidx/compose/material/icons/Icons$Rounded;", "getDone", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DoneKt {

    private static ImageVector _done;
    static {
    }

    public static final ImageVector getDone(Icons.Rounded $this$Done) {
        if (DoneKt._done != null) {
            ImageVector _done2 = DoneKt._done;
            Intrinsics.checkNotNull(_done2);
            return _done2;
        }
        int i7 = 0;
        int i8 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Rounded.Done", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i6 = 0;
        int i10 = 0;
        int i16 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i16);
        final int i27 = 1065353216;
        int i12 = 0;
        int i14 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i17 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i60 = 0;
        final int i61 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1091567616, 1099012506);
        int i2 = -1067450368;
        builder5.lineToRelative(i2, i2);
        int i30 = -1094210028;
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(i30, -1094210028, -1082046546, -1094210028, -1078774989, 0);
        int i35 = 1053273620;
        builder6.curveToRelative(i30, i35, -1094210028, 1065437102, 0, 1068708659);
        PathBuilder builder = builder6;
        int i21 = 1082528891;
        builder.lineToRelative(i21, i21);
        int i31 = 1053273620;
        builder6.curveToRelative(i31, i35, 1065520988, 1053273620, 1068792545, 0);
        builder.lineTo(1101162086, 1089889894);
        int i36 = -1094210028;
        builder6.curveToRelative(i31, i36, 1053273620, -1082046546, 0, -1078774989);
        builder6.curveToRelative(-1094210028, i36, -1082046546, -1094210028, -1078774989, 0);
        builder.lineTo(1091567616, 1099012506);
        builder.close();
        DoneKt._done = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i16, 1065353216, i27, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i27, 0, 0, 0, 14336, 0).build();
        ImageVector _done3 = DoneKt._done;
        Intrinsics.checkNotNull(_done3);
        return _done3;
    }
}
