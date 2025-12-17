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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_keyboardArrowDown", "Landroidx/compose/ui/graphics/vector/ImageVector;", "KeyboardArrowDown", "Landroidx/compose/material/icons/Icons$Filled;", "getKeyboardArrowDown", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class KeyboardArrowDownKt {

    private static ImageVector _keyboardArrowDown;
    static {
    }

    public static final ImageVector getKeyboardArrowDown(Icons.Filled $this$KeyboardArrowDown) {
        if (KeyboardArrowDownKt._keyboardArrowDown != null) {
            ImageVector _keyboardArrowDown2 = KeyboardArrowDownKt._keyboardArrowDown;
            Intrinsics.checkNotNull(_keyboardArrowDown2);
            return _keyboardArrowDown2;
        }
        int i14 = 0;
        int i15 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Filled.KeyboardArrowDown", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
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
        builder4.moveTo(1089281720, 1091137700);
        builder4.lineTo(1094713344, 1095940178);
        builder4.lineToRelative(1083367752, -1064136868);
        builder4.lineTo(1099956224, 1092616192);
        int i10 = -1061158912;
        builder4.lineToRelative(i10, 1086324736);
        builder4.lineToRelative(i10, i10);
        builder4.lineToRelative(1068792545, -1078691103);
        builder4.close();
        KeyboardArrowDownKt._keyboardArrowDown = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i23, 1065353216, i31, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i31, 0, 0, 0, 14336, 0).build();
        ImageVector _keyboardArrowDown3 = KeyboardArrowDownKt._keyboardArrowDown;
        Intrinsics.checkNotNull(_keyboardArrowDown3);
        return _keyboardArrowDown3;
    }
}
