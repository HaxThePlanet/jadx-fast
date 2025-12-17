package androidx.compose.material.icons.automirrored.twotone;

import androidx.compose.material.icons.Icons.AutoMirrored.TwoTone;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_keyboardArrowLeft", "Landroidx/compose/ui/graphics/vector/ImageVector;", "KeyboardArrowLeft", "Landroidx/compose/material/icons/Icons$AutoMirrored$TwoTone;", "getKeyboardArrowLeft", "(Landroidx/compose/material/icons/Icons$AutoMirrored$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class KeyboardArrowLeftKt {

    private static ImageVector _keyboardArrowLeft;
    static {
    }

    public static final ImageVector getKeyboardArrowLeft(Icons.AutoMirrored.TwoTone $this$KeyboardArrowLeft) {
        if (KeyboardArrowLeftKt._keyboardArrowLeft != null) {
            ImageVector _keyboardArrowLeft2 = KeyboardArrowLeftKt._keyboardArrowLeft;
            Intrinsics.checkNotNull(_keyboardArrowLeft2);
            return _keyboardArrowLeft2;
        }
        int i14 = 0;
        int i15 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("AutoMirrored.TwoTone.KeyboardArrowLeft", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 1, 96, 0);
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
        final int i39 = i2;
        final ImageVector.Builder builder5 = builder;
        builder4.moveTo(1098288988, 1099216978);
        builder4.lineTo(1093486510, 1094713344);
        builder4.lineToRelative(1083346780, -1064115896);
        int i10 = 1086324736;
        builder4.lineTo(1096810496, i10);
        builder4.lineToRelative(-1061158912, i10);
        builder4.lineToRelative(i10, i10);
        builder4.lineToRelative(1068792545, -1078691103);
        builder4.close();
        KeyboardArrowLeftKt._keyboardArrowLeft = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i23, 1065353216, i31, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i31, 0, 0, 0, 14336, 0).build();
        ImageVector _keyboardArrowLeft3 = KeyboardArrowLeftKt._keyboardArrowLeft;
        Intrinsics.checkNotNull(_keyboardArrowLeft3);
        return _keyboardArrowLeft3;
    }
}
