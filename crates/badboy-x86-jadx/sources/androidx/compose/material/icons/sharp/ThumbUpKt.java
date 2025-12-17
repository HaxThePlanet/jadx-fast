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
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"_thumbUp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ThumbUp", "Landroidx/compose/material/icons/Icons$Sharp;", "getThumbUp", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ThumbUpKt {

    private static ImageVector _thumbUp;
    static {
    }

    public static final ImageVector getThumbUp(Icons.Sharp $this$ThumbUp) {
        if (ThumbUpKt._thumbUp != null) {
            ImageVector _thumbUp2 = ThumbUpKt._thumbUp;
            Intrinsics.checkNotNull(_thumbUp2);
            return _thumbUp2;
        }
        int i14 = 0;
        int i15 = 0;
        ImageVector.Builder builder = new ImageVector.Builder("Sharp.ThumbUp", Dp.constructor-impl(1103101952), Dp.constructor-impl(1103101952), 1103101952, 1103101952, 0, obj8, 0, 0, 96, 0);
        int i13 = 0;
        int i17 = 0;
        int i28 = 0;
        SolidColor solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), obj8, i28);
        int i19 = 1065353216;
        int i25 = 0;
        final int i26 = 0;
        PathBuilder pathBuilder = new PathBuilder();
        int i32 = 0;
        int i39 = 0;
        final int i44 = i;
        final ImageVector.Builder builder5 = builder;
        PathBuilder $this$_get_ThumbUp__u24lambda_u241 = builder4;
        $this$_get_ThumbUp__u24lambda_u241.moveTo(1096988754, i19);
        $this$_get_ThumbUp__u24lambda_u241.lineTo(1088421888, 1090707784);
        $this$_get_ThumbUp__u24lambda_u241.verticalLineTo(1101529088);
        $this$_get_ThumbUp__u24lambda_u241.horizontalLineToRelative(1095038403);
        $this$_get_ThumbUp__u24lambda_u241.lineTo(1102577664, 1095132774);
        $this$_get_ThumbUp__u24lambda_u241.verticalLineTo(1090519040);
        $this$_get_ThumbUp__u24lambda_u241.horizontalLineToRelative(-1056639549);
        $this$_get_ThumbUp__u24lambda_u241.lineToRelative(1066359849, -1062459146);
        $this$_get_ThumbUp__u24lambda_u241.close();
        int i23 = 1065353216;
        $this$_get_ThumbUp__u24lambda_u241.moveTo(i23, 1091567616);
        $this$_get_ThumbUp__u24lambda_u241.horizontalLineToRelative(1082130432);
        $this$_get_ThumbUp__u24lambda_u241.verticalLineToRelative(1094713344);
        $this$_get_ThumbUp__u24lambda_u241.horizontalLineTo(i23);
        $this$_get_ThumbUp__u24lambda_u241.close();
        ThumbUpKt._thumbUp = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), VectorKt.getDefaultFillType(), "", (Brush)solidColor, 1065353216, i28, 1065353216, i19, StrokeCap.Companion.getButt-KaPHkGw(), StrokeJoin.Companion.getBevel-LxFBmk8(), i19, 0, 0, 0, 14336, 0).build();
        ImageVector _thumbUp3 = ThumbUpKt._thumbUp;
        Intrinsics.checkNotNull(_thumbUp3);
        return _thumbUp3;
    }
}
