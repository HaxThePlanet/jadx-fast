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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_clear", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Clear", "Landroidx/compose/material/icons/Icons$Rounded;", "getClear", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ClearKt {

    private static ImageVector _clear;
    static {
    }

    public static final ImageVector getClear(Icons.Rounded $this$Clear) {
        if (ClearKt._clear != null) {
            ImageVector _clear2 = ClearKt._clear;
            Intrinsics.checkNotNull(_clear2);
            return _clear2;
        }
        int i10 = 0;
        int i11 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Rounded.Clear", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i9 = 0;
        int i13 = 0;
        int i19 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i19);
        final int i35 = 1065353216;
        int i15 = 0;
        int i17 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i20 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i67 = 0;
        final int i68 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1100113510, 1085716562);
        int i58 = -1078691103;
        int i62 = 0;
        int i38 = -1094210028;
        int i42 = -1094210028;
        int i47 = -1081962660;
        int i53 = -1094210028;
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(i38, i42, i47, i53, i58, i62);
        PathBuilder builder = builder6;
        builder.lineTo(1094713344, 1093234852);
        builder.lineTo(1088652575, 1085695590);
        builder6.curveToRelative(i38, i42, i47, i53, i58, i62);
        int i59 = 0;
        int i63 = 1068792545;
        int i43 = 1053273620;
        int i48 = -1094210028;
        int i54 = 1065520988;
        builder6.curveToRelative(i38, i43, i48, i54, i59, i63);
        builder.lineTo(1093234852, 1094713344);
        builder.lineTo(1085695590, 1099374264);
        builder6.curveToRelative(i38, i43, i48, i54, i59, i63);
        int i60 = 1068792545;
        int i64 = 0;
        int i39 = 1053273620;
        int i49 = 1065520988;
        int i55 = 1053273620;
        builder6.curveToRelative(i39, i43, i49, i55, i60, i64);
        int i6 = 1096191836;
        builder.lineTo(1094713344, i6);
        int i29 = 1083996897;
        builder.lineToRelative(i29, i29);
        builder6.curveToRelative(i39, i43, i49, i55, i60, i64);
        int i61 = 0;
        int i56 = -1081962660;
        builder6.curveToRelative(i39, -1094210028, 1053273620, i56, i61, -1078691103);
        builder.lineTo(i6, 1094713344);
        builder.lineToRelative(1083996897, -1063486751);
        builder6.curveToRelative(1052938076, -1094545572, 1052938076, i56, i61, -1078774989);
        builder6.close();
        ClearKt._clear = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i19, 1065353216, i35, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i35, 0, 0, 0, 14336, 0).build();
        ImageVector _clear3 = ClearKt._clear;
        Intrinsics.checkNotNull(_clear3);
        return _clear3;
    }
}
