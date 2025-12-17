package androidx.compose.material.icons.automirrored.rounded;

import androidx.compose.material.icons.Icons.AutoMirrored.Rounded;
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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_arrowForward", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ArrowForward", "Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;", "getArrowForward", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ArrowForwardKt {

    private static ImageVector _arrowForward;
    static {
    }

    public static final ImageVector getArrowForward(Icons.AutoMirrored.Rounded $this$ArrowForward) {
        if (ArrowForwardKt._arrowForward != null) {
            ImageVector _arrowForward2 = ArrowForwardKt._arrowForward;
            Intrinsics.checkNotNull(_arrowForward2);
            return _arrowForward2;
        }
        int i11 = 0;
        int i12 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("AutoMirrored.Rounded.ArrowForward", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 1, 96, 0);
        int i10 = 0;
        int i14 = 0;
        int i28 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i28);
        int i16 = 1065353216;
        int i25 = 0;
        final int i26 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i32 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i74 = 0;
        final int i75 = i2;
        final ImageVector.Builder builder5 = builder;
        PathBuilder $this$_get_ArrowForward__u24lambda_u241 = builder4;
        $this$_get_ArrowForward__u24lambda_u241.moveTo(1084227584, 1095761920);
        $this$_get_ArrowForward__u24lambda_u241.horizontalLineToRelative(1093843026);
        $this$_get_ArrowForward__u24lambda_u241.lineToRelative(-1063507722, 1083975926);
        int i44 = 1053273620;
        builder4.curveToRelative(-1094210028, i44, -1094210028, 1065604874, 0, 1068876431);
        int i40 = 1053273620;
        builder4.curveToRelative(i40, i44, 1065520988, 1053273620, 1068792545, 0);
        $this$_get_ArrowForward__u24lambda_u241.lineToRelative(1087562056, -1059921592);
        int i45 = -1094210028;
        builder4.curveToRelative(i40, i45, 1053273620, -1081962660, 0, -1078691103);
        $this$_get_ArrowForward__u24lambda_u241.lineToRelative(-1059942564, -1059900621);
        int i41 = -1094210028;
        builder4.curveToRelative(i41, i45, -1081962660, -1094210028, -1078691103, 0);
        builder4.curveToRelative(i41, 1053273620, -1094210028, 1065520988, 0, 1068792545);
        $this$_get_ArrowForward__u24lambda_u241.lineTo(1098996777, 1093664768);
        $this$_get_ArrowForward__u24lambda_u241.horizontalLineTo(1084227584);
        int i47 = 0;
        builder4.curveToRelative(-1089680179, i47, -1082130432, 1055286886, -1082130432, 1065353216);
        int i23 = 1065353216;
        $this$_get_ArrowForward__u24lambda_u241.reflectiveCurveToRelative(1055286886, i23, i23, i23);
        $this$_get_ArrowForward__u24lambda_u241.close();
        ArrowForwardKt._arrowForward = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i28, 1065353216, i16, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i16, 0, 0, i47, 14336, 0).build();
        ImageVector _arrowForward3 = ArrowForwardKt._arrowForward;
        Intrinsics.checkNotNull(_arrowForward3);
        return _arrowForward3;
    }
}
