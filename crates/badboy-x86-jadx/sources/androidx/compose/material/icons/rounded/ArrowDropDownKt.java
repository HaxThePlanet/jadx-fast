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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_arrowDropDown", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ArrowDropDown", "Landroidx/compose/material/icons/Icons$Rounded;", "getArrowDropDown", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ArrowDropDownKt {

    private static ImageVector _arrowDropDown;
    static {
    }

    public static final ImageVector getArrowDropDown(Icons.Rounded $this$ArrowDropDown) {
        if (ArrowDropDownKt._arrowDropDown != null) {
            ImageVector _arrowDropDown2 = ArrowDropDownKt._arrowDropDown;
            Intrinsics.checkNotNull(_arrowDropDown2);
            return _arrowDropDown2;
        }
        int i6 = 0;
        int i7 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.ArrowDropDown", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i5 = 0;
        int i9 = 0;
        int i15 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i15);
        final int i24 = 1065353216;
        int i11 = 0;
        int i13 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i16 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i48 = 0;
        final int i49 = i;
        final ImageVector.Builder builder7 = builder;
        builder5.moveTo(1091263529, 1094409257);
        int i2 = 1076216463;
        builder5.lineToRelative(i2, i2);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(1053273620, 1053273620, 1065520988, 1053273620, 1068792545, 0);
        PathBuilder builder2 = builder6;
        builder2.lineToRelative(i2, -1071267185);
        builder6.curveToRelative(1059145646, -1088338002, 1043878380, -1076174520, -1086995825, -1076174520);
        builder2.horizontalLineTo(1091997532);
        int i33 = 0;
        builder6.curveToRelative(-1083975926, i33, -1079362191, 1066024305, -1087163597, 1071309128);
        builder6.close();
        ArrowDropDownKt._arrowDropDown = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i15, 1065353216, i24, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i24, 0, 0, i33, 14336, 0).build();
        ImageVector _arrowDropDown3 = ArrowDropDownKt._arrowDropDown;
        Intrinsics.checkNotNull(_arrowDropDown3);
        return _arrowDropDown3;
    }
}
