package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons.TwoTone;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_lock", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Lock", "Landroidx/compose/material/icons/Icons$TwoTone;", "getLock", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LockKt {

    private static ImageVector _lock;
    static {
    }

    public static final ImageVector getLock(Icons.TwoTone $this$Lock) {
        if (LockKt._lock != null) {
            ImageVector _lock2 = LockKt._lock;
            Intrinsics.checkNotNull(_lock2);
            return _lock2;
        }
        String str = "TwoTone.Lock";
        int i33 = 0;
        int i35 = 0;
        ImageVector.Builder builder3 = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i32 = 0;
        SolidColor solidColor2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, 0);
        final int i74 = 0;
        final int i77 = 1065353216;
        final int i78 = 1065353216;
        int i39 = 0;
        int i43 = 0;
        PathBuilder pathBuilder2 = new PathBuilder();
        int i47 = 0;
        PathBuilder builder8 = pathBuilder2;
        final int i89 = 0;
        final int i90 = i;
        builder8.moveTo(1086324736, 1101004800);
        builder8.horizontalLineToRelative(1094713344);
        builder8.lineTo(1099956224, 1092616192);
        int i4 = 1092616192;
        builder8.lineTo(1086324736, i4);
        builder8.verticalLineToRelative(i4);
        builder8.close();
        builder8.moveTo(1094713344, 1095761920);
        final int i82 = 0;
        PathBuilder builder9 = builder8;
        builder9.curveToRelative(1066192077, i82, 1073741824, 1063675494, 1073741824, 1073741824);
        PathBuilder builder = builder9;
        int i26 = -1083808154;
        int i66 = 1073741824;
        String str4 = str;
        int name$iv = -1073741824;
        builder.reflectiveCurveToRelative(i26, i66, name$iv, i66);
        builder.reflectiveCurveToRelative(name$iv, i26, name$iv, name$iv);
        int i67 = -1073741824;
        builder.reflectiveCurveToRelative(1063675494, i67, 1073741824, i67);
        builder.close();
        int i84 = 14336;
        int i86 = 0;
        int i79 = 0;
        int i81 = 0;
        ImageVector.Builder.addPath-oIyEayM$default(builder3, pathBuilder2.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor2, 1050253722, i74, 1050253722, i77, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i78, i79, i81, i82, i84, i86);
        ImageVector.Builder builder2 = builder11;
        int i28 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), 0, 0);
        int i30 = 0;
        int i34 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i41 = 0;
        PathBuilder builder5 = pathBuilder;
        int i44 = 0;
        builder5.moveTo(1099956224, 1090519040);
        builder5.horizontalLineToRelative(-1082130432);
        builder5.lineTo(1099431936, 1086324736);
        final PathBuilder builder12 = builder5;
        builder12.curveToRelative(0, -1070554153, -1072735191, -1063256064, -1063256064, -1063256064);
        int i70 = 1088421888;
        ImageVector.Builder builder10 = builder2;
        builder5.reflectiveCurveTo(i70, 1078942761, i70, 1086324736);
        builder5.verticalLineToRelative(1073741824);
        builder5.lineTo(1086324736, 1090519040);
        int i125 = 1073741824;
        builder12.curveToRelative(-1081291571, 0, -1073741824, 1063675494, -1073741824, i125);
        builder5.verticalLineToRelative(1092616192);
        int i120 = 1073741824;
        builder12.curveToRelative(0, 1066192077, 1063675494, 1073741824, i120, i125);
        builder5.horizontalLineToRelative(1094713344);
        int i126 = -1073741824;
        builder12.curveToRelative(1066192077, 0, 1073741824, -1083808154, i120, i126);
        builder5.lineTo(1101004800, 1092616192);
        int i95 = 0;
        builder12.curveToRelative(i95, -1081291571, -1083808154, -1073741824, -1073741824, i126);
        builder5.close();
        builder5.moveTo(1091567616, 1086324736);
        builder12.curveToRelative(i95, -1076593951, 1068205343, -1069547520, 1077936128, -1069547520);
        int i55 = 1077936128;
        builder5.reflectiveCurveToRelative(i55, 1068205343, i55, i55);
        builder5.verticalLineToRelative(1073741824);
        int i14 = 1091567616;
        builder5.lineTo(i14, 1090519040);
        builder5.lineTo(i14, 1086324736);
        builder5.close();
        builder5.moveTo(1099956224, 1101004800);
        int i59 = 1086324736;
        builder5.lineTo(i59, 1101004800);
        builder5.lineTo(i59, 1092616192);
        builder5.horizontalLineToRelative(1094713344);
        builder5.verticalLineToRelative(1092616192);
        builder5.close();
        builder5.moveTo(1094713344, 1099431936);
        builder12.curveToRelative(1066192077, 0, 1073741824, -1083808154, 1073741824, -1073741824);
        int i61 = -1073741824;
        builder5.reflectiveCurveToRelative(-1083808154, i61, i61, i61);
        int i22 = 1063675494;
        int i62 = 1073741824;
        int i71 = -1073741824;
        builder5.reflectiveCurveToRelative(i71, i22, i71, i62);
        builder5.reflectiveCurveToRelative(i22, i62, i62, i62);
        builder5.close();
        LockKt._lock = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i74, 1065353216, i77, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i78, i79, i81, i82, i84, i86).build();
        ImageVector _lock3 = LockKt._lock;
        Intrinsics.checkNotNull(_lock3);
        return _lock3;
    }
}
