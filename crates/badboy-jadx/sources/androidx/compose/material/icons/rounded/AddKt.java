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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_add", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Add", "Landroidx/compose/material/icons/Icons$Rounded;", "getAdd", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AddKt {

    private static ImageVector _add;
    static {
    }

    public static final ImageVector getAdd(Icons.Rounded $this$Add) {
        if (AddKt._add != null) {
            ImageVector _add2 = AddKt._add;
            Intrinsics.checkNotNull(_add2);
            return _add2;
        }
        String str = "Rounded.Add";
        int i15 = 0;
        int i16 = 0;
        ImageVector.Builder builder = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i14 = 0;
        int i18 = 0;
        int i28 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i28);
        int i20 = 1065353216;
        int i25 = 0;
        final int i26 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i32 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i63 = 0;
        final int i64 = i;
        final ImageVector.Builder builder5 = builder;
        PathBuilder $this$_get_Add__u24lambda_u241 = builder4;
        $this$_get_Add__u24lambda_u241.moveTo(1099956224, 1095761920);
        $this$_get_Add__u24lambda_u241.horizontalLineToRelative(-1063256064);
        $this$_get_Add__u24lambda_u241.verticalLineToRelative(1084227584);
        int i58 = -1082130432;
        builder4.curveToRelative(0, 1057803469, -1092196762, 1065353216, i58, 1065353216);
        int i23 = -1082130432;
        $this$_get_Add__u24lambda_u241.reflectiveCurveToRelative(i23, -1092196762, i23, i23);
        $this$_get_Add__u24lambda_u241.verticalLineToRelative(-1063256064);
        $this$_get_Add__u24lambda_u241.horizontalLineTo(1086324736);
        int i61 = -1082130432;
        builder4.curveToRelative(-1089680179, 0, -1082130432, -1092196762, i58, i61);
        int i6 = 1055286886;
        final String str3 = str;
        $this$_get_Add__u24lambda_u241.reflectiveCurveToRelative(i6, i23, 1065353216, i23);
        $this$_get_Add__u24lambda_u241.horizontalLineToRelative(1084227584);
        $this$_get_Add__u24lambda_u241.verticalLineTo(1086324736);
        int i59 = 1065353216;
        builder4.curveToRelative(0, -1089680179, 1055286886, -1082130432, i59, i61);
        int i10 = 1065353216;
        $this$_get_Add__u24lambda_u241.reflectiveCurveToRelative(i10, i6, i10, i10);
        int i11 = 1084227584;
        $this$_get_Add__u24lambda_u241.verticalLineToRelative(i11);
        $this$_get_Add__u24lambda_u241.horizontalLineToRelative(i11);
        int i47 = 0;
        builder4.curveToRelative(1057803469, i47, 1065353216, 1055286886, i59, 1065353216);
        int i12 = 1065353216;
        $this$_get_Add__u24lambda_u241.reflectiveCurveToRelative(-1092196762, i12, i23, i12);
        $this$_get_Add__u24lambda_u241.close();
        AddKt._add = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i28, 1065353216, i20, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i20, 0, 0, i47, 14336, 0).build();
        ImageVector _add3 = AddKt._add;
        Intrinsics.checkNotNull(_add3);
        return _add3;
    }
}
