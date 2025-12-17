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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_lock", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Lock", "Landroidx/compose/material/icons/Icons$Outlined;", "getLock", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LockKt {

    private static ImageVector _lock;
    static {
    }

    public static final ImageVector getLock(Icons.Outlined $this$Lock) {
        if (LockKt._lock != null) {
            ImageVector _lock2 = LockKt._lock;
            Intrinsics.checkNotNull(_lock2);
            return _lock2;
        }
        String str = "Outlined.Lock";
        int i28 = 0;
        int i29 = 0;
        ImageVector.Builder builder = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i27 = 0;
        int i31 = 0;
        int i37 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i37);
        final int i45 = 1065353216;
        int i33 = 0;
        int i35 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i38 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i89 = 0;
        final int i90 = i;
        final ImageVector.Builder builder6 = builder;
        builder4.moveTo(1099956224, 1090519040);
        builder4.horizontalLineToRelative(-1082130432);
        int i15 = 1086324736;
        builder4.lineTo(1099431936, i15);
        PathBuilder builder5 = builder4;
        builder5.curveToRelative(0, -1070554153, -1072735191, -1063256064, -1063256064, -1063256064);
        final String str3 = str;
        int name$iv = 1088421888;
        builder4.reflectiveCurveTo(name$iv, 1078942761, name$iv, i15);
        builder4.verticalLineToRelative(1073741824);
        builder4.lineTo(i15, 1090519040);
        int i85 = 1073741824;
        builder5.curveToRelative(-1081291571, 0, -1073741824, 1063675494, -1073741824, i85);
        int i22 = 1092616192;
        builder4.verticalLineToRelative(i22);
        int i80 = 1073741824;
        builder5.curveToRelative(0, 1066192077, 1063675494, 1073741824, i80, i85);
        builder4.horizontalLineToRelative(1094713344);
        int i86 = -1073741824;
        builder5.curveToRelative(1066192077, 0, 1073741824, -1083808154, i80, i86);
        builder4.lineTo(1101004800, i22);
        int i52 = 0;
        builder5.curveToRelative(i52, -1081291571, -1083808154, -1073741824, -1073741824, i86);
        builder4.close();
        int i23 = 1091567616;
        builder4.moveTo(i23, i15);
        builder5.curveToRelative(i52, -1076593951, 1068205343, -1069547520, 1077936128, -1069547520);
        int i16 = 1077936128;
        builder4.reflectiveCurveToRelative(i16, 1068205343, i16, i16);
        builder4.verticalLineToRelative(1073741824);
        builder4.lineTo(i23, 1090519040);
        int i11 = 1086324736;
        builder4.lineTo(i23, i11);
        builder4.close();
        int i24 = 1101004800;
        builder4.moveTo(1099956224, i24);
        builder4.lineTo(i11, i24);
        int i18 = 1092616192;
        builder4.lineTo(i11, i18);
        int i12 = 1094713344;
        builder4.horizontalLineToRelative(i12);
        builder4.verticalLineToRelative(i18);
        builder4.close();
        builder4.moveTo(i12, 1099431936);
        int i61 = 0;
        builder5.curveToRelative(1066192077, i61, 1073741824, -1083808154, 1073741824, -1073741824);
        int i20 = -1073741824;
        builder4.reflectiveCurveToRelative(-1083808154, i20, i20, i20);
        int i14 = 1063675494;
        int i25 = 1073741824;
        builder4.reflectiveCurveToRelative(i20, i14, i20, i25);
        builder4.reflectiveCurveToRelative(i14, i25, i25, i25);
        builder4.close();
        LockKt._lock = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i37, 1065353216, i45, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i45, 0, 0, i61, 14336, 0).build();
        ImageVector _lock3 = LockKt._lock;
        Intrinsics.checkNotNull(_lock3);
        return _lock3;
    }
}
