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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"_arrowForward", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ArrowForward", "Landroidx/compose/material/icons/Icons$Rounded;", "getArrowForward$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getArrowForward", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ArrowForwardKt {

    private static ImageVector _arrowForward;
    static {
    }

    public static final ImageVector getArrowForward(Icons.Rounded $this$ArrowForward) {
        if (ArrowForwardKt._arrowForward != null) {
            ImageVector _arrowForward2 = ArrowForwardKt._arrowForward;
            Intrinsics.checkNotNull(_arrowForward2);
            return _arrowForward2;
        }
        int i10 = 0;
        int i11 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.ArrowForward", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i9 = 0;
        int i13 = 0;
        int i27 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i27);
        int i15 = 1065353216;
        int i24 = 0;
        final int i25 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i31 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i73 = 0;
        final int i74 = i;
        final ImageVector.Builder builder5 = builder;
        PathBuilder $this$_get_ArrowForward__u24lambda_u241 = builder4;
        $this$_get_ArrowForward__u24lambda_u241.moveTo(1084227584, 1095761920);
        $this$_get_ArrowForward__u24lambda_u241.horizontalLineToRelative(1093843026);
        $this$_get_ArrowForward__u24lambda_u241.lineToRelative(-1063507722, 1083975926);
        int i43 = 1053273620;
        builder4.curveToRelative(-1094210028, i43, -1094210028, 1065604874, 0, 1068876431);
        int i39 = 1053273620;
        builder4.curveToRelative(i39, i43, 1065520988, 1053273620, 1068792545, 0);
        $this$_get_ArrowForward__u24lambda_u241.lineToRelative(1087562056, -1059921592);
        int i44 = -1094210028;
        builder4.curveToRelative(i39, i44, 1053273620, -1081962660, 0, -1078691103);
        $this$_get_ArrowForward__u24lambda_u241.lineToRelative(-1059942564, -1059900621);
        int i40 = -1094210028;
        builder4.curveToRelative(i40, i44, -1081962660, -1094210028, -1078691103, 0);
        builder4.curveToRelative(i40, 1053273620, -1094210028, 1065520988, 0, 1068792545);
        $this$_get_ArrowForward__u24lambda_u241.lineTo(1098996777, 1093664768);
        $this$_get_ArrowForward__u24lambda_u241.horizontalLineTo(1084227584);
        int i46 = 0;
        builder4.curveToRelative(-1089680179, i46, -1082130432, 1055286886, -1082130432, 1065353216);
        int i22 = 1065353216;
        $this$_get_ArrowForward__u24lambda_u241.reflectiveCurveToRelative(1055286886, i22, i22, i22);
        $this$_get_ArrowForward__u24lambda_u241.close();
        ArrowForwardKt._arrowForward = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i27, 1065353216, i15, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i15, 0, 0, i46, 14336, 0).build();
        ImageVector _arrowForward3 = ArrowForwardKt._arrowForward;
        Intrinsics.checkNotNull(_arrowForward3);
        return _arrowForward3;
    }

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Rounded.ArrowForward", replaceWith = @ReplaceWith(...))
    public static void getArrowForward$annotations(Icons.Rounded icons$Rounded) {
    }
}
