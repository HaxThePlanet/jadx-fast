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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_keyboardArrowUp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "KeyboardArrowUp", "Landroidx/compose/material/icons/Icons$Rounded;", "getKeyboardArrowUp", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class KeyboardArrowUpKt {

    private static ImageVector _keyboardArrowUp;
    static {
    }

    public static final ImageVector getKeyboardArrowUp(Icons.Rounded $this$KeyboardArrowUp) {
        if (KeyboardArrowUpKt._keyboardArrowUp != null) {
            ImageVector _keyboardArrowUp2 = KeyboardArrowUpKt._keyboardArrowUp;
            Intrinsics.checkNotNull(_keyboardArrowUp2);
            return _keyboardArrowUp2;
        }
        int i9 = 0;
        int i10 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Rounded.KeyboardArrowUp", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i8 = 0;
        int i12 = 0;
        int i18 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i18);
        final int i28 = 1065353216;
        int i14 = 0;
        int i16 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i19 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i62 = 0;
        final int i63 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1090644869, 1097554985);
        builder5.lineTo(1094713344, 1093486510);
        int i3 = 1081627116;
        builder5.lineToRelative(i3, i3);
        int i31 = 1053273620;
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(i31, 1053273620, 1065520988, 1053273620, 1068792545, 0);
        int i36 = -1094210028;
        builder6.curveToRelative(i31, i36, 1053273620, -1081962660, 0, -1078691103);
        PathBuilder builder = builder6;
        builder.lineTo(1095447347, 1091263529);
        int i32 = -1094210028;
        builder6.curveToRelative(i32, i36, -1081962660, -1094210028, -1078691103, 0);
        builder.lineTo(1087792742, 1096076493);
        builder6.curveToRelative(i32, 1053273620, -1094210028, 1065520988, 0, 1068792545);
        builder6.curveToRelative(1053273620, 1052938076, 1065604874, 1053273620, 1068876431, 0);
        builder6.close();
        KeyboardArrowUpKt._keyboardArrowUp = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i18, 1065353216, i28, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i28, 0, 0, 0, 14336, 0).build();
        ImageVector _keyboardArrowUp3 = KeyboardArrowUpKt._keyboardArrowUp;
        Intrinsics.checkNotNull(_keyboardArrowUp3);
        return _keyboardArrowUp3;
    }
}
