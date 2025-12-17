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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_call", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Call", "Landroidx/compose/material/icons/Icons$Filled;", "getCall", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CallKt {

    private static ImageVector _call;
    static {
    }

    public static final ImageVector getCall(Icons.Filled $this$Call) {
        if (CallKt._call != null) {
            ImageVector _call2 = CallKt._call;
            Intrinsics.checkNotNull(_call2);
            return _call2;
        }
        int i8 = 0;
        int i9 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Filled.Call", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i7 = 0;
        int i11 = 0;
        int i17 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i17);
        final int i27 = 1065353216;
        int i13 = 0;
        int i15 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i18 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i93 = 0;
        final int i94 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1101010043, 1098257531);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(-1080201052, 0, -1071980216, -1102263091, -1067324539, -1089512407);
        builder6.curveToRelative(-1095552205, -1107967345, -1086492508, -1124744561, -1082046546, 1047904911);
        PathBuilder builder = builder6;
        builder.lineToRelative(-1077348925, 1073490166);
        builder6.curveToRelative(-1070260552, -1079194419, -1062249431, -1065772646, -1059292447, -1059418276);
        builder.lineToRelative(1073322394, -1076593951);
        builder6.curveToRelative(1049247089, -1097901015, 1051931443, -1087666913, 1047904911, -1081962660);
        builder6.curveToRelative(-1094881116, -1081207685, -1089512407, -1072483533, -1089512407, -1067324539);
        builder6.curveToRelative(0, -1089847951, -1092196762, -1082298204, -1082298204, -1082298204);
        builder.horizontalLineTo(1082528891);
        builder6.curveTo(1080662426, 1077936128, 1077936128, 1078942761, 1077936128, 1082088489);
        builder6.curveTo(1077936128, 1096055521, 1093381652, 1101529088, 1101010043, 1101529088);
        builder6.curveToRelative(1060487823, 0, 1065185444, -1088338002, 1065185444, -1080620483);
        builder.verticalLineToRelative(-1067660083);
        int i39 = 0;
        builder6.curveToRelative(i39, -1089847951, -1092196762, -1082298204, -1082298204, -1082298204);
        builder6.close();
        CallKt._call = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i17, 1065353216, i27, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i27, 0, i39, 0, 14336, 0).build();
        ImageVector _call3 = CallKt._call;
        Intrinsics.checkNotNull(_call3);
        return _call3;
    }
}
