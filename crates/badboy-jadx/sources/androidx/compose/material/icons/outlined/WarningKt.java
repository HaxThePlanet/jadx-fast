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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_warning", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Warning", "Landroidx/compose/material/icons/Icons$Outlined;", "getWarning", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WarningKt {

    private static ImageVector _warning;
    static {
    }

    public static final ImageVector getWarning(Icons.Outlined $this$Warning) {
        if (WarningKt._warning != null) {
            ImageVector _warning2 = WarningKt._warning;
            Intrinsics.checkNotNull(_warning2);
            return _warning2;
        }
        int i15 = 0;
        int i16 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.Warning", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i14 = 0;
        int i18 = 0;
        int i28 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i28);
        int i20 = 1065353216;
        int i25 = 0;
        final int i26 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i32 = 0;
        int i39 = 0;
        final int i44 = i;
        final ImageVector.Builder builder5 = builder;
        PathBuilder $this$_get_Warning__u24lambda_u241 = builder4;
        $this$_get_Warning__u24lambda_u241.moveTo(i20, 1101529088);
        $this$_get_Warning__u24lambda_u241.horizontalLineToRelative(1102053376);
        $this$_get_Warning__u24lambda_u241.lineTo(1094713344, 1073741824);
        $this$_get_Warning__u24lambda_u241.lineTo(1065353216, 1101529088);
        $this$_get_Warning__u24lambda_u241.close();
        int i23 = 1095761920;
        $this$_get_Warning__u24lambda_u241.moveTo(i23, 1099956224);
        int i6 = -1073741824;
        $this$_get_Warning__u24lambda_u241.horizontalLineToRelative(i6);
        $this$_get_Warning__u24lambda_u241.verticalLineToRelative(i6);
        int i7 = 1073741824;
        $this$_get_Warning__u24lambda_u241.horizontalLineToRelative(i7);
        $this$_get_Warning__u24lambda_u241.verticalLineToRelative(i7);
        $this$_get_Warning__u24lambda_u241.close();
        $this$_get_Warning__u24lambda_u241.moveTo(i23, 1096810496);
        $this$_get_Warning__u24lambda_u241.horizontalLineToRelative(-1073741824);
        $this$_get_Warning__u24lambda_u241.verticalLineToRelative(-1065353216);
        $this$_get_Warning__u24lambda_u241.horizontalLineToRelative(1073741824);
        $this$_get_Warning__u24lambda_u241.verticalLineToRelative(1082130432);
        $this$_get_Warning__u24lambda_u241.close();
        WarningKt._warning = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i28, 1065353216, i20, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i20, 0, 0, 0, 14336, 0).build();
        ImageVector _warning3 = WarningKt._warning;
        Intrinsics.checkNotNull(_warning3);
        return _warning3;
    }
}
