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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_keyboardArrowDown", "Landroidx/compose/ui/graphics/vector/ImageVector;", "KeyboardArrowDown", "Landroidx/compose/material/icons/Icons$Rounded;", "getKeyboardArrowDown", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class KeyboardArrowDownKt {

    private static ImageVector _keyboardArrowDown;
    static {
    }

    public static final ImageVector getKeyboardArrowDown(Icons.Rounded $this$KeyboardArrowDown) {
        if (KeyboardArrowDownKt._keyboardArrowDown != null) {
            ImageVector _keyboardArrowDown2 = KeyboardArrowDownKt._keyboardArrowDown;
            Intrinsics.checkNotNull(_keyboardArrowDown2);
            return _keyboardArrowDown2;
        }
        int i10 = 0;
        int i11 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Rounded.KeyboardArrowDown", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i9 = 0;
        int i13 = 0;
        int i19 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i19);
        final int i29 = 1065353216;
        int i15 = 0;
        int i17 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i20 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i63 = 0;
        final int i64 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1090644869, 1091871703);
        builder5.lineTo(1094713344, 1095940178);
        builder5.lineToRelative(1081627116, -1065856532);
        int i32 = 1053273620;
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(i32, -1094210028, 1065520988, -1094210028, 1068792545, 0);
        int i37 = 1053273620;
        builder6.curveToRelative(i32, i37, 1053273620, 1065520988, 0, 1068792545);
        PathBuilder builder = builder6;
        builder.lineToRelative(-1064115896, 1083367752);
        int i33 = -1094210028;
        builder6.curveToRelative(i33, i37, -1081962660, 1053273620, -1078691103, 0);
        builder.lineTo(1087792742, 1093350195);
        builder6.curveToRelative(i33, -1094210028, -1094210028, -1081962660, 0, -1078691103);
        builder6.curveToRelative(1053273620, -1094545572, 1065604874, -1094210028, 1068876431, 0);
        builder6.close();
        KeyboardArrowDownKt._keyboardArrowDown = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i19, 1065353216, i29, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i29, 0, 0, 0, 14336, 0).build();
        ImageVector _keyboardArrowDown3 = KeyboardArrowDownKt._keyboardArrowDown;
        Intrinsics.checkNotNull(_keyboardArrowDown3);
        return _keyboardArrowDown3;
    }
}
