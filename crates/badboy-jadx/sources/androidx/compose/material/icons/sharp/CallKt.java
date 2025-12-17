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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_call", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Call", "Landroidx/compose/material/icons/Icons$Sharp;", "getCall", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CallKt {

    private static ImageVector _call;
    static {
    }

    public static final ImageVector getCall(Icons.Sharp $this$Call) {
        if (CallKt._call != null) {
            ImageVector _call2 = CallKt._call;
            Intrinsics.checkNotNull(_call2);
            return _call2;
        }
        int i12 = 0;
        int i13 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Sharp.Call", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i11 = 0;
        int i15 = 0;
        int i21 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i21);
        final int i31 = 1065353216;
        int i17 = 0;
        int i19 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i22 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i50 = 0;
        final int i51 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1101529088, 1098341417);
        builder5.lineToRelative(-1062689833, -1088673546);
        builder5.lineToRelative(-1071560786, 1075922862);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(-1070260552, -1078439444, -1062941491, -1066401792, -1059921592, -1059921592);
        PathBuilder builder = builder6;
        builder.lineToRelative(1075964805, -1071518843);
        builder.lineTo(1091085271, 1077936128);
        builder.horizontalLineTo(1078061957);
        builder6.curveTo(1075629261, 1095950664, 1093476024, 1101817446, 1101529088, 1101513359);
        builder.verticalLineToRelative(-1062186516);
        builder.close();
        CallKt._call = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i21, 1065353216, i31, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i31, 0, 0, 0, 14336, 0).build();
        ImageVector _call3 = CallKt._call;
        Intrinsics.checkNotNull(_call3);
        return _call3;
    }
}
