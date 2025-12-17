package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons.Sharp;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"_keyboardArrowRight", "Landroidx/compose/ui/graphics/vector/ImageVector;", "KeyboardArrowRight", "Landroidx/compose/material/icons/Icons$Sharp;", "getKeyboardArrowRight$annotations", "(Landroidx/compose/material/icons/Icons$Sharp;)V", "getKeyboardArrowRight", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class KeyboardArrowRightKt {

    private static ImageVector _keyboardArrowRight;
    static {
    }

    public static final ImageVector getKeyboardArrowRight(Icons.Sharp $this$KeyboardArrowRight) {
        if (KeyboardArrowRightKt._keyboardArrowRight != null) {
            ImageVector _keyboardArrowRight2 = KeyboardArrowRightKt._keyboardArrowRight;
            Intrinsics.checkNotNull(_keyboardArrowRight2);
            return _keyboardArrowRight2;
        }
        int i12 = 0;
        int i13 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Sharp.KeyboardArrowRight", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
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
        builder4.moveTo(1091137700, 1099216978);
        builder4.lineTo(1095940178, 1094713344);
        builder4.lineTo(1091137700, 1089281720);
        int i9 = 1086324736;
        builder4.lineTo(1092616192, i9);
        builder4.lineToRelative(i9, i9);
        builder4.lineToRelative(-1061158912, i9);
        int i6 = -1078691103;
        builder4.lineToRelative(i6, i6);
        builder4.close();
        KeyboardArrowRightKt._keyboardArrowRight = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i21, 1065353216, i29, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i29, 0, 0, 0, 14336, 0).build();
        ImageVector _keyboardArrowRight3 = KeyboardArrowRightKt._keyboardArrowRight;
        Intrinsics.checkNotNull(_keyboardArrowRight3);
        return _keyboardArrowRight3;
    }

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Sharp.KeyboardArrowRight", replaceWith = @ReplaceWith(...))
    public static void getKeyboardArrowRight$annotations(Icons.Sharp icons$Sharp) {
    }
}
