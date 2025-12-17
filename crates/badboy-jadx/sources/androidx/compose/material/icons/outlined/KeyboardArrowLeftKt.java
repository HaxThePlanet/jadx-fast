package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons.Outlined;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"_keyboardArrowLeft", "Landroidx/compose/ui/graphics/vector/ImageVector;", "KeyboardArrowLeft", "Landroidx/compose/material/icons/Icons$Outlined;", "getKeyboardArrowLeft$annotations", "(Landroidx/compose/material/icons/Icons$Outlined;)V", "getKeyboardArrowLeft", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class KeyboardArrowLeftKt {

    private static ImageVector _keyboardArrowLeft;
    static {
    }

    public static final ImageVector getKeyboardArrowLeft(Icons.Outlined $this$KeyboardArrowLeft) {
        if (KeyboardArrowLeftKt._keyboardArrowLeft != null) {
            ImageVector _keyboardArrowLeft2 = KeyboardArrowLeftKt._keyboardArrowLeft;
            Intrinsics.checkNotNull(_keyboardArrowLeft2);
            return _keyboardArrowLeft2;
        }
        int i13 = 0;
        int i14 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.KeyboardArrowLeft", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i12 = 0;
        int i16 = 0;
        int i22 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i22);
        final int i30 = 1065353216;
        int i18 = 0;
        int i20 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i23 = 0;
        PathBuilder builder4 = pathBuilder;
        int i32 = 0;
        final int i38 = i;
        final ImageVector.Builder builder5 = builder;
        builder4.moveTo(1098288988, 1099216978);
        builder4.lineTo(1093486510, 1094713344);
        builder4.lineToRelative(1083346780, -1064115896);
        int i9 = 1086324736;
        builder4.lineTo(1096810496, i9);
        builder4.lineToRelative(-1061158912, i9);
        builder4.lineToRelative(i9, i9);
        builder4.lineToRelative(1068792545, -1078691103);
        builder4.close();
        KeyboardArrowLeftKt._keyboardArrowLeft = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i22, 1065353216, i30, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i30, 0, 0, 0, 14336, 0).build();
        ImageVector _keyboardArrowLeft3 = KeyboardArrowLeftKt._keyboardArrowLeft;
        Intrinsics.checkNotNull(_keyboardArrowLeft3);
        return _keyboardArrowLeft3;
    }

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Outlined.KeyboardArrowLeft", replaceWith = @ReplaceWith(...))
    public static void getKeyboardArrowLeft$annotations(Icons.Outlined icons$Outlined) {
    }
}
