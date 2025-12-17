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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_delete", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Delete", "Landroidx/compose/material/icons/Icons$Rounded;", "getDelete", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DeleteKt {

    private static ImageVector _delete;
    static {
    }

    public static final ImageVector getDelete(Icons.Rounded $this$Delete) {
        if (DeleteKt._delete != null) {
            ImageVector _delete2 = DeleteKt._delete;
            Intrinsics.checkNotNull(_delete2);
            return _delete2;
        }
        int i15 = 0;
        int i16 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.Delete", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i14 = 0;
        int i18 = 0;
        int i30 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i30);
        int i20 = 1065353216;
        int i27 = 0;
        final int i28 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i34 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i86 = 0;
        final int i87 = i;
        final ImageVector.Builder builder5 = builder;
        PathBuilder $this$_get_Delete__u24lambda_u241 = builder4;
        $this$_get_Delete__u24lambda_u241.moveTo(1086324736, 1100480512);
        int i74 = 1073741824;
        builder4.curveToRelative(0, 1066192077, 1063675494, 1073741824, i74, 1073741824);
        int i22 = 1090519040;
        $this$_get_Delete__u24lambda_u241.horizontalLineToRelative(i22);
        int i80 = -1073741824;
        builder4.curveToRelative(1066192077, 0, 1073741824, -1083808154, i74, i80);
        $this$_get_Delete__u24lambda_u241.verticalLineTo(1091567616);
        int i75 = -1073741824;
        builder4.curveToRelative(0, -1081291571, -1083808154, -1073741824, i75, i80);
        $this$_get_Delete__u24lambda_u241.horizontalLineTo(i22);
        builder4.curveToRelative(-1081291571, 0, -1073741824, 1063675494, i75, 1073741824);
        $this$_get_Delete__u24lambda_u241.verticalLineToRelative(1092616192);
        $this$_get_Delete__u24lambda_u241.close();
        int i23 = 1082130432;
        $this$_get_Delete__u24lambda_u241.moveTo(1099956224, i23);
        $this$_get_Delete__u24lambda_u241.horizontalLineToRelative(-1071644672);
        int i6 = -1086995825;
        $this$_get_Delete__u24lambda_u241.lineToRelative(i6, i6);
        int i76 = -1087163597;
        builder4.curveToRelative(-1103605268, -1103605268, -1092532306, -1097565471, i76, -1097565471);
        $this$_get_Delete__u24lambda_u241.horizontalLineTo(1092521820);
        int i55 = 0;
        builder4.curveToRelative(-1098572104, i55, -1090183496, 1038174126, i76, 1049918177);
        $this$_get_Delete__u24lambda_u241.lineTo(1091043328, i23);
        $this$_get_Delete__u24lambda_u241.horizontalLineTo(1086324736);
        builder4.curveToRelative(-1089680179, i55, -1082130432, 1055286886, -1082130432, 1065353216);
        int i24 = 1065353216;
        $this$_get_Delete__u24lambda_u241.reflectiveCurveToRelative(1055286886, i24, i24, i24);
        $this$_get_Delete__u24lambda_u241.horizontalLineToRelative(1094713344);
        builder4.curveToRelative(1057803469, i55, 1065353216, -1092196762, 1065353216, -1082130432);
        int i25 = -1082130432;
        $this$_get_Delete__u24lambda_u241.reflectiveCurveToRelative(-1092196762, i25, i25, i25);
        $this$_get_Delete__u24lambda_u241.close();
        DeleteKt._delete = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i30, 1065353216, i20, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i20, 0, 0, i55, 14336, 0).build();
        ImageVector _delete3 = DeleteKt._delete;
        Intrinsics.checkNotNull(_delete3);
        return _delete3;
    }
}
