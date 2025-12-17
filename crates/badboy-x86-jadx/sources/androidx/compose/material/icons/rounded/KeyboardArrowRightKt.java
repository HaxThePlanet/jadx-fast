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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"_keyboardArrowRight", "Landroidx/compose/ui/graphics/vector/ImageVector;", "KeyboardArrowRight", "Landroidx/compose/material/icons/Icons$Rounded;", "getKeyboardArrowRight$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getKeyboardArrowRight", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class KeyboardArrowRightKt {

    private static ImageVector _keyboardArrowRight;
    static {
    }

    public static final ImageVector getKeyboardArrowRight(Icons.Rounded $this$KeyboardArrowRight) {
        if (KeyboardArrowRightKt._keyboardArrowRight != null) {
            ImageVector _keyboardArrowRight2 = KeyboardArrowRightKt._keyboardArrowRight;
            Intrinsics.checkNotNull(_keyboardArrowRight2);
            return _keyboardArrowRight2;
        }
        int i10 = 0;
        int i11 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Rounded.KeyboardArrowRight", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i9 = 0;
        int i13 = 0;
        int i19 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i19);
        final int i28 = 1065353216;
        int i15 = 0;
        int i17 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i20 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i62 = 0;
        final int i63 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1091871703, 1098781819);
        builder5.lineTo(1095940178, 1094713344);
        builder5.lineTo(1091871703, 1090644869);
        int i36 = -1094210028;
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(-1094210028, i36, -1094210028, -1081962660, 0, -1078691103);
        int i32 = 1053273620;
        builder6.curveToRelative(i32, i36, 1065520988, -1094210028, 1068792545, 0);
        PathBuilder builder = builder6;
        int i6 = 1083367752;
        builder.lineToRelative(i6, i6);
        int i37 = 1053273620;
        builder6.curveToRelative(i32, i37, 1053273620, 1065520988, 0, 1068792545);
        builder.lineTo(1093350195, 1099589222);
        builder6.curveToRelative(-1094210028, i37, -1081962660, 1053273620, -1078691103, 0);
        builder6.curveToRelative(-1094545572, -1094210028, -1094210028, -1081878774, 0, -1078607217);
        builder6.close();
        KeyboardArrowRightKt._keyboardArrowRight = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i19, 1065353216, i28, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i28, 0, 0, 0, 14336, 0).build();
        ImageVector _keyboardArrowRight3 = KeyboardArrowRightKt._keyboardArrowRight;
        Intrinsics.checkNotNull(_keyboardArrowRight3);
        return _keyboardArrowRight3;
    }

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Rounded.KeyboardArrowRight", replaceWith = @ReplaceWith(...))
    public static void getKeyboardArrowRight$annotations(Icons.Rounded icons$Rounded) {
    }
}
