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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_keyboardArrowUp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "KeyboardArrowUp", "Landroidx/compose/material/icons/Icons$Filled;", "getKeyboardArrowUp", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class KeyboardArrowUpKt {

    private static ImageVector _keyboardArrowUp;
    static {
    }

    public static final ImageVector getKeyboardArrowUp(Icons.Filled $this$KeyboardArrowUp) {
        if (KeyboardArrowUpKt._keyboardArrowUp != null) {
            ImageVector _keyboardArrowUp2 = KeyboardArrowUpKt._keyboardArrowUp;
            Intrinsics.checkNotNull(_keyboardArrowUp2);
            return _keyboardArrowUp2;
        }
        int i12 = 0;
        int i13 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Filled.KeyboardArrowUp", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i11 = 0;
        int i15 = 0;
        int i21 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i21);
        final int i29 = 1065353216;
        int i17 = 0;
        int i19 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i22 = 0;
        PathBuilder builder4 = pathBuilder;
        int i31 = 0;
        final int i37 = i;
        final ImageVector.Builder builder5 = builder;
        builder4.moveTo(1089281720, 1098288988);
        builder4.lineTo(1094713344, 1093486510);
        builder4.lineToRelative(1083367752, 1083346780);
        builder4.lineTo(1099956224, 1096810496);
        int i5 = -1061158912;
        builder4.lineToRelative(i5, i5);
        builder4.lineToRelative(i5, 1086324736);
        builder4.close();
        KeyboardArrowUpKt._keyboardArrowUp = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i21, 1065353216, i29, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i29, 0, 0, 0, 14336, 0).build();
        ImageVector _keyboardArrowUp3 = KeyboardArrowUpKt._keyboardArrowUp;
        Intrinsics.checkNotNull(_keyboardArrowUp3);
        return _keyboardArrowUp3;
    }
}
