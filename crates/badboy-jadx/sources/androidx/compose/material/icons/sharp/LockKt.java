package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons.Sharp;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_lock", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Lock", "Landroidx/compose/material/icons/Icons$Sharp;", "getLock", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LockKt {

    private static ImageVector _lock;
    static {
    }

    public static final ImageVector getLock(Icons.Sharp $this$Lock) {
        if (LockKt._lock != null) {
            ImageVector _lock2 = LockKt._lock;
            Intrinsics.checkNotNull(_lock2);
            return _lock2;
        }
        String str = "Sharp.Lock";
        int i17 = 0;
        int i18 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder(str, Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i16 = 0;
        int i20 = 0;
        int i26 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i26);
        final int i42 = 1065353216;
        int i22 = 0;
        int i24 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i27 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i72 = 0;
        final int i73 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1101004800, 1090519040);
        builder5.horizontalLineToRelative(-1069547520);
        builder5.lineTo(1099431936, 1086765138);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(0, -1071183299, -1074496799, -1063381893, -1064283668, -1062857605);
        builder6.curveTo(1092102390, 1060991140, 1088421888, 1078271672, 1088421888, 1086324736);
        PathBuilder builder = builder6;
        builder.verticalLineToRelative(1073741824);
        int i5 = 1090519040;
        builder.lineTo(1082130432, i5);
        builder.verticalLineToRelative(1096810496);
        builder.horizontalLineToRelative(1098907648);
        builder.lineTo(1101004800, i5);
        builder.close();
        builder.moveTo(1094713344, 1099431936);
        builder6.curveToRelative(-1081291571, 0, -1073741824, -1083808154, -1073741824, -1073741824);
        int i7 = 1063675494;
        int i37 = -1073741824;
        final String str3 = str;
        int name$iv = 1073741824;
        builder.reflectiveCurveToRelative(i7, i37, name$iv, i37);
        builder.reflectiveCurveToRelative(name$iv, i7, name$iv, name$iv);
        builder.reflectiveCurveToRelative(-1083808154, name$iv, i37, name$iv);
        builder.close();
        int i9 = 1091567616;
        builder.moveTo(i9, 1090519040);
        builder.lineTo(i9, 1086324736);
        int i48 = 0;
        builder6.curveToRelative(i48, -1076593951, 1068205343, -1069547520, 1077936128, -1069547520);
        int i38 = 1077936128;
        builder.reflectiveCurveToRelative(i38, 1068205343, i38, i38);
        builder.verticalLineToRelative(1073741824);
        builder.lineTo(i9, 1090519040);
        builder.close();
        LockKt._lock = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i26, 1065353216, i42, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i42, 0, i48, 0, 14336, 0).build();
        ImageVector _lock3 = LockKt._lock;
        Intrinsics.checkNotNull(_lock3);
        return _lock3;
    }
}
