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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_thumbUp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ThumbUp", "Landroidx/compose/material/icons/Icons$Filled;", "getThumbUp", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ThumbUpKt {

    private static ImageVector _thumbUp;
    static {
    }

    public static final ImageVector getThumbUp(Icons.Filled $this$ThumbUp) {
        if (ThumbUpKt._thumbUp != null) {
            ImageVector _thumbUp2 = ThumbUpKt._thumbUp;
            Intrinsics.checkNotNull(_thumbUp2);
            return _thumbUp2;
        }
        int i18 = 0;
        int i19 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Filled.ThumbUp", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i17 = 0;
        int i21 = 0;
        int i34 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i34);
        int i23 = 1065353216;
        int i31 = 0;
        final int i32 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i38 = 0;
        PathBuilder builder4 = pathBuilder;
        final int i84 = 0;
        final int i85 = i;
        final ImageVector.Builder builder5 = builder;
        PathBuilder $this$_get_ThumbUp__u24lambda_u241 = builder4;
        $this$_get_ThumbUp__u24lambda_u241.moveTo(i23, 1101529088);
        $this$_get_ThumbUp__u24lambda_u241.horizontalLineToRelative(1082130432);
        int i24 = 1091567616;
        $this$_get_ThumbUp__u24lambda_u241.lineTo(1084227584, i24);
        $this$_get_ThumbUp__u24lambda_u241.lineTo(1065353216, i24);
        $this$_get_ThumbUp__u24lambda_u241.verticalLineToRelative(1094713344);
        $this$_get_ThumbUp__u24lambda_u241.close();
        $this$_get_ThumbUp__u24lambda_u241.moveTo(1102577664, 1092616192);
        int i45 = 0;
        builder4.curveToRelative(i45, -1081291571, -1083808154, -1073741824, -1073741824, -1073741824);
        $this$_get_ThumbUp__u24lambda_u241.horizontalLineToRelative(-1060508795);
        $this$_get_ThumbUp__u24lambda_u241.lineToRelative(1064514355, -1064157839);
        $this$_get_ThumbUp__u24lambda_u241.lineToRelative(1022739087, -1096558838);
        builder4.curveToRelative(i45, -1093538939, -1104276357, -1085653647, -1092532306, -1081627116);
        $this$_get_ThumbUp__u24lambda_u241.lineTo(1096988754, 1065353216);
        int i11 = 1089659208;
        $this$_get_ThumbUp__u24lambda_u241.lineTo(i11, i11);
        builder4.curveTo(1088883261, 1090414182, 1088421888, 1090990899, 1088421888, 1091567616);
        $this$_get_ThumbUp__u24lambda_u241.verticalLineToRelative(1092616192);
        builder4.curveToRelative(0, 1066192077, 1063675494, 1073741824, 1073741824, 1073741824);
        $this$_get_ThumbUp__u24lambda_u241.horizontalLineToRelative(1091567616);
        builder4.curveToRelative(1062501089, 0, 1069883064, -1090519040, 1072399647, -1080284938);
        $this$_get_ThumbUp__u24lambda_u241.lineToRelative(1078020014, -1058956902);
        builder4.curveToRelative(1035489772, -1100249825, 1041194025, -1091525673, 1041194025, -1086660280);
        $this$_get_ThumbUp__u24lambda_u241.verticalLineToRelative(-1073741824);
        $this$_get_ThumbUp__u24lambda_u241.close();
        ThumbUpKt._thumbUp = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i34, 1065353216, i23, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i23, 0, 0, 0, 14336, 0).build();
        ImageVector _thumbUp3 = ThumbUpKt._thumbUp;
        Intrinsics.checkNotNull(_thumbUp3);
        return _thumbUp3;
    }
}
