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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_call", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Call", "Landroidx/compose/material/icons/Icons$Outlined;", "getCall", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CallKt {

    private static ImageVector _call;
    static {
    }

    public static final ImageVector getCall(Icons.Outlined $this$Call) {
        if (CallKt._call != null) {
            ImageVector _call2 = CallKt._call;
            Intrinsics.checkNotNull(_call2);
            return _call2;
        }
        int i13 = 0;
        int i14 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Outlined.Call", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i12 = 0;
        int i16 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, 0);
        int i18 = 0;
        int i20 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i23 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i130 = 0;
        final int i131 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1087457198, 1084227584);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(1031127695, 1063507722, 1045891645, 1071728558, 1055286886, 1076216463);
        PathBuilder builder = builder6;
        builder.lineToRelative(-1080452710, 1067030938);
        builder6.curveToRelative(-1093538939, -1080452710, -1087666913, -1071770501, -1086156964, -1066234020);
        builder.horizontalLineToRelative(1069631406);
        builder.moveToRelative(1092469391, 1094734316);
        builder6.curveToRelative(1062836634, 1047904911, 1071393014, 1053273620, 1076258406, 1055286886);
        builder.verticalLineToRelative(1069463634);
        builder6.curveToRelative(-1079446077, -1111993876, -1071267185, -1095552205, -1066192077, -1086324736);
        builder.lineToRelative(1067030938, -1080536596);
        builder.moveTo(1089470464, 1077936128);
        builder.horizontalLineTo(1082130432);
        builder6.curveToRelative(-1089680179, 0, -1082130432, 1055286886, -1082130432, 1065353216);
        builder6.curveToRelative(0, 1091976561, 1089701151, 1099431936, 1099431936, 1099431936);
        int i122 = -1082130432;
        builder6.curveToRelative(1057803469, 0, 1065353216, -1092196762, 1065353216, i122);
        builder.verticalLineToRelative(-1067492311);
        builder6.curveToRelative(0, -1089680179, -1092196762, -1082130432, -1082130432, i122);
        builder6.curveToRelative(-1080117166, 0, -1071854387, -1102263091, -1067156767, -1089344635);
        builder6.curveToRelative(-1110651699, -1121724662, -1101592003, -1119040307, -1096894382, -1119040307);
        builder6.curveToRelative(-1098572104, 0, -1090351268, 1036831949, -1086995825, 1049918177);
        int i10 = 1074580685;
        int i31 = -1072902963;
        builder.lineToRelative(i31, i10);
        builder6.curveToRelative(-1070260552, -1078355558, -1062941491, -1066359849, -1059921592, -1059921592);
        builder.lineToRelative(i10, i31);
        builder6.curveToRelative(1049582633, -1097901015, 1052266988, -1087666913, 1048576000, -1081962660);
        builder6.curveTo(1091253043, 1087268454, 1091043328, 1084751872, 1091043328, 1082130432);
        int i52 = 0;
        builder6.curveToRelative(i52, -1089680179, -1092196762, -1082130432, -1082130432, -1082130432);
        builder6.close();
        CallKt._call = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, 0, 1065353216, 1065353216, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), 1065353216, 0, i52, 0, 14336, 0).build();
        ImageVector _call3 = CallKt._call;
        Intrinsics.checkNotNull(_call3);
        return _call3;
    }
}
