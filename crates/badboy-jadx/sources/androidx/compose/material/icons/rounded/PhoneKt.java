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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_phone", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Phone", "Landroidx/compose/material/icons/Icons$Rounded;", "getPhone", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PhoneKt {

    private static ImageVector _phone;
    static {
    }

    public static final ImageVector getPhone(Icons.Rounded $this$Phone) {
        if (PhoneKt._phone != null) {
            ImageVector _phone2 = PhoneKt._phone;
            Intrinsics.checkNotNull(_phone2);
            return _phone2;
        }
        int i11 = 0;
        int i12 = 0;
        ImageVector.Builder builder2 = new ImageVector.Builder("Rounded.Phone", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i10 = 0;
        int i14 = 0;
        int i20 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i20);
        final int i31 = 1065353216;
        int i16 = 0;
        int i18 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i21 = 0;
        PathBuilder builder5 = pathBuilder;
        final int i86 = 0;
        final int i87 = i;
        final ImageVector.Builder builder7 = builder2;
        builder5.moveTo(1100601098, 1098131702);
        builder5.lineToRelative(-1071476900, -1097565471);
        PathBuilder builder6 = builder5;
        builder6.curveToRelative(-1088673546, -1114678231, -1080368824, 1041194025, -1076761723, 1058139013);
        PathBuilder builder = builder6;
        builder.lineToRelative(-1075084001, 1072399647);
        builder6.curveToRelative(-1070260552, -1078439444, -1062941491, -1066401792, -1059921592, -1059921592);
        builder.lineToRelative(1072483533, -1075000115);
        builder6.curveToRelative(1054615798, -1092867850, 1059313418, -1081878774, 1058139013, -1076761723);
        builder.lineToRelative(-1097565471, -1071560786);
        builder6.curveToRelative(-1107967345, -1082046546, -1082633748, -1075671204, -1073825710, -1075671204);
        builder.horizontalLineTo(1084290499);
        builder6.curveToRelative(-1081039913, 0, -1073448223, 1064346583, -1073741824, 1074035425);
        builder6.curveToRelative(1057467924, 1091085271, 1089176863, 1098236559, 1098792305, 1098792305);
        builder6.curveToRelative(1066443735, 1032805417, 1074035425, -1084311470, 1074035425, -1073741824);
        builder.verticalLineToRelative(-1076006748);
        builder6.curveToRelative(1008981770, -1082046546, -1086324736, -1074916229, -1075755090, -1073909596);
        builder6.close();
        PhoneKt._phone = ImageVector.Builder.addPath-oIyEayM$default(builder2, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i20, 1065353216, i31, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i31, 0, 0, 0, 14336, 0).build();
        ImageVector _phone3 = PhoneKt._phone;
        Intrinsics.checkNotNull(_phone3);
        return _phone3;
    }
}
