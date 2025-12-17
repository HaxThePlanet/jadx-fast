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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_addCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AddCircle", "Landroidx/compose/material/icons/Icons$Outlined;", "getAddCircle", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AddCircleKt {

    private static ImageVector _addCircle;
    static {
    }

    public static final ImageVector getAddCircle(Icons.Outlined $this$AddCircle) {
        if (AddCircleKt._addCircle != null) {
            ImageVector _addCircle2 = AddCircleKt._addCircle;
            Intrinsics.checkNotNull(_addCircle2);
            return _addCircle2;
        }
        String str = "Outlined.AddCircle";
        int i19 = 0;
        int i20 = 0;
        ImageVector.Builder builder = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i18 = 0;
        int i22 = 0;
        int i28 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i28);
        final int i36 = 1065353216;
        int i24 = 0;
        int i26 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i29 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i49 = 0;
        final int i50 = i;
        final ImageVector.Builder builder6 = builder;
        builder4.moveTo(1094713344, 1073741824);
        builder4.curveTo(1087331369, 1073741824, 1073741824, 1087331369, 1073741824, 1094713344);
        int i8 = 1092616192;
        builder4.reflectiveCurveToRelative(1083137065, i8, i8, i8);
        String str3 = str;
        builder4.reflectiveCurveToRelative(i8, -1064346583, i8, -1054867456);
        int i12 = 1073741824;
        builder4.reflectiveCurveTo(1099704566, i12, 1094713344, i12);
        builder4.close();
        int i10 = 1095761920;
        builder4.moveTo(1099431936, i10);
        int i6 = -1065353216;
        builder4.horizontalLineToRelative(i6);
        builder4.verticalLineToRelative(1082130432);
        int i14 = -1073741824;
        builder4.horizontalLineToRelative(i14);
        builder4.verticalLineToRelative(i6);
        int i7 = 1088421888;
        builder4.lineTo(i7, i10);
        builder4.verticalLineToRelative(i14);
        int i11 = 1082130432;
        builder4.horizontalLineToRelative(i11);
        builder4.lineTo(1093664768, i7);
        int i16 = 1073741824;
        builder4.horizontalLineToRelative(i16);
        builder4.verticalLineToRelative(i11);
        builder4.horizontalLineToRelative(i11);
        builder4.verticalLineToRelative(i16);
        builder4.close();
        AddCircleKt._addCircle = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i28, 1065353216, i36, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i36, 0, 0, 0, 14336, 0).build();
        ImageVector _addCircle3 = AddCircleKt._addCircle;
        Intrinsics.checkNotNull(_addCircle3);
        return _addCircle3;
    }
}
