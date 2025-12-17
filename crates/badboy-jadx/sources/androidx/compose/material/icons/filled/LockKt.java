package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons.Filled;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_lock", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Lock", "Landroidx/compose/material/icons/Icons$Filled;", "getLock", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LockKt {

    private static ImageVector _lock;
    static {
    }

    public static final ImageVector getLock(Icons.Filled $this$Lock) {
        if (LockKt._lock != null) {
            ImageVector _lock2 = LockKt._lock;
            Intrinsics.checkNotNull(_lock2);
            return _lock2;
        }
        String str = "Filled.Lock";
        int i27 = 0;
        int i28 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i26 = 0;
        int i30 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, 0);
        int i32 = 0;
        int i34 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i37 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i94 = 0;
        final int i95 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1099956224, 1090519040);
        builder5.horizontalLineToRelative(-1082130432);
        builder5.lineTo(1099431936, 1086324736);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(0, -1070554153, -1072735191, -1063256064, -1063256064, -1063256064);
        PathBuilder builder = builder6;
        int i41 = 1088421888;
        final String str3 = str;
        builder.reflectiveCurveTo(i41, 1078942761, i41, 1086324736);
        builder.verticalLineToRelative(1073741824);
        builder.lineTo(1086324736, 1090519040);
        int i90 = 1073741824;
        builder6.curveToRelative(-1081291571, 0, -1073741824, 1063675494, -1073741824, i90);
        builder.verticalLineToRelative(1092616192);
        int i86 = 1073741824;
        builder6.curveToRelative(0, 1066192077, 1063675494, 1073741824, i86, i90);
        builder.horizontalLineToRelative(1094713344);
        int i91 = -1073741824;
        builder6.curveToRelative(1066192077, 0, 1073741824, -1083808154, i86, i91);
        builder.lineTo(1101004800, 1092616192);
        int i87 = -1073741824;
        builder6.curveToRelative(0, -1081291571, -1083808154, -1073741824, i87, i91);
        builder.close();
        builder.moveTo(1094713344, 1099431936);
        builder6.curveToRelative(-1081291571, 0, -1073741824, -1083808154, i87, i91);
        int i12 = 1063675494;
        int i20 = -1073741824;
        int i42 = 1073741824;
        builder.reflectiveCurveToRelative(i12, i20, i42, i20);
        int i21 = 1073741824;
        builder.reflectiveCurveToRelative(i21, i12, i21, i21);
        builder.reflectiveCurveToRelative(-1083808154, i42, -1073741824, i42);
        builder.close();
        int i23 = 1090519040;
        builder.moveTo(1097963930, i23);
        int i15 = 1091462758;
        builder.lineTo(i15, i23);
        builder.lineTo(i15, 1086324736);
        int i88 = 1078355558;
        builder6.curveToRelative(0, -1076174520, 1068624773, -1069128090, i88, -1069128090);
        int i65 = 0;
        builder6.curveToRelative(1071309128, i65, 1078355558, 1068624773, i88, 1078355558);
        builder.verticalLineToRelative(1073741824);
        builder.close();
        LockKt._lock = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, 0, 1065353216, 1065353216, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), 1065353216, 0, 0, i65, 14336, 0).build();
        ImageVector _lock3 = LockKt._lock;
        Intrinsics.checkNotNull(_lock3);
        return _lock3;
    }
}
