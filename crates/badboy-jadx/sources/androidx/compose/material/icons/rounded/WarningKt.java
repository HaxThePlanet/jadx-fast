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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_warning", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Warning", "Landroidx/compose/material/icons/Icons$Rounded;", "getWarning", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WarningKt {

    private static ImageVector _warning;
    static {
    }

    public static final ImageVector getWarning(Icons.Rounded $this$Warning) {
        if (WarningKt._warning != null) {
            ImageVector _warning2 = WarningKt._warning;
            Intrinsics.checkNotNull(_warning2);
            return _warning2;
        }
        int i14 = 0;
        int i15 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.Warning", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i13 = 0;
        int i17 = 0;
        int i30 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i30);
        int i19 = 1065353216;
        int i27 = 0;
        final int i28 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i34 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i77 = 0;
        final int i78 = i;
        final ImageVector.Builder builder5 = builder;
        PathBuilder $this$_get_Warning__u24lambda_u241 = builder4;
        $this$_get_Warning__u24lambda_u241.moveTo(1083116093, 1101529088);
        $this$_get_Warning__u24lambda_u241.horizontalLineToRelative(1097921987);
        builder4.curveToRelative(1069883064, 0, 1075838976, -1076510065, 1071476900, -1069547520);
        $this$_get_Warning__u24lambda_u241.lineTo(1096527380, 1084206612);
        int i42 = -1085989192;
        builder4.curveToRelative(i42, -1079362191, -1070847754, -1079362191, -1067618140, 0);
        $this$_get_Warning__u24lambda_u241.lineTo(1076845609, 1099956224);
        builder4.curveToRelative(i42, 1068121457, 1044549468, 1077936128, 1071476900, 1077936128);
        $this$_get_Warning__u24lambda_u241.close();
        $this$_get_Warning__u24lambda_u241.moveTo(1094713344, 1096810496);
        int i75 = -1082130432;
        builder4.curveToRelative(-1089680179, 0, -1082130432, -1092196762, -1082130432, i75);
        $this$_get_Warning__u24lambda_u241.verticalLineToRelative(-1073741824);
        int i44 = 0;
        builder4.curveToRelative(i44, -1089680179, 1055286886, -1082130432, 1065353216, i75);
        int i7 = 1065353216;
        $this$_get_Warning__u24lambda_u241.reflectiveCurveToRelative(i7, 1055286886, i7, i7);
        $this$_get_Warning__u24lambda_u241.verticalLineToRelative(1073741824);
        builder4.curveToRelative(i44, 1057803469, -1092196762, 1065353216, -1082130432, 1065353216);
        $this$_get_Warning__u24lambda_u241.close();
        $this$_get_Warning__u24lambda_u241.moveTo(1095761920, 1099956224);
        int i10 = -1073741824;
        $this$_get_Warning__u24lambda_u241.horizontalLineToRelative(i10);
        $this$_get_Warning__u24lambda_u241.verticalLineToRelative(i10);
        int i11 = 1073741824;
        $this$_get_Warning__u24lambda_u241.horizontalLineToRelative(i11);
        $this$_get_Warning__u24lambda_u241.verticalLineToRelative(i11);
        $this$_get_Warning__u24lambda_u241.close();
        WarningKt._warning = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i30, 1065353216, i19, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i19, 0, i44, 0, 14336, 0).build();
        ImageVector _warning3 = WarningKt._warning;
        Intrinsics.checkNotNull(_warning3);
        return _warning3;
    }
}
